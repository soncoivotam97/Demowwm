package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzex implements Runnable {
    final /* synthetic */ zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzey zzc;

    zzex(zzey zzey, zzbr zzbr, ServiceConnection serviceConnection) {
        this.zzc = zzey;
        this.zza = zzbr;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzey zzey = this.zzc;
        zzez zzez = zzey.zza;
        String zza2 = zzey.zzb;
        zzbr zzbr = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzez.zza.zzaz().zzg();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", zza2);
        Bundle bundle2 = null;
        try {
            Bundle zzd = zzbr.zzd(bundle);
            if (zzd == null) {
                zzez.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
            } else {
                bundle2 = zzd;
            }
        } catch (Exception e) {
            zzez.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        zzez.zza.zzaz().zzg();
        zzfr.zzO();
        if (bundle2 != null) {
            long j = bundle2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzez.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzez.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzez.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    Bundle zzs = zzez.zza.zzv().zzs(Uri.parse("?".concat(string)));
                    if (zzs == null) {
                        zzez.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = bundle2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzez.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzez.zza.zzm().zzd.zza()) {
                            zzez.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzez.zza.zzJ()) {
                            zzez.zza.zzm().zzd.zzb(j);
                            zzez.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs.putString("_cis", "referrer API v2");
                            zzez.zza.zzq().zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", zzs, zza2);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzez.zza.zzau(), serviceConnection);
    }
}
