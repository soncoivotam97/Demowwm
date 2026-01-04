package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final class zzar {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzau zzf;

    zzar(zzfr zzfr, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzau zzau;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzfr.zzay().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzeh.zzn(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzau = new zzau(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzfr.zzay().zzd().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzA = zzfr.zzv().zzA(str4, bundle2.get(str4));
                    if (zzA == null) {
                        zzfr.zzay().zzk().zzb("Param value can't be null", zzfr.zzj().zze(str4));
                        it.remove();
                    } else {
                        zzfr.zzv().zzO(bundle2, str4, zzA);
                    }
                }
            }
            zzau = new zzau(bundle2);
        }
        this.zzf = zzau;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String obj = this.zzf.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    /* access modifiers changed from: package-private */
    public final zzar zza(zzfr zzfr, long j) {
        return new zzar(zzfr, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    private zzar(zzfr zzfr, String str, String str2, String str3, long j, long j2, zzau zzau) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzau);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzfr.zzay().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzeh.zzn(str2), zzeh.zzn(str3));
        }
        this.zzf = zzau;
    }
}
