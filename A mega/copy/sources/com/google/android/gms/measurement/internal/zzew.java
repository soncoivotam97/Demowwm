package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzew extends zzgl {
    static final Pair zza = new Pair("", 0L);
    public zzeu zzb;
    public final zzes zzc = new zzes(this, "first_open_time", 0);
    public final zzes zzd = new zzes(this, "app_install_time", 0);
    public final zzev zze = new zzev(this, "app_instance_id", (String) null);
    public final zzes zzf = new zzes(this, "session_timeout", 1800000);
    public final zzeq zzg = new zzeq(this, "start_new_session", true);
    public final zzev zzh = new zzev(this, "non_personalized_ads", (String) null);
    public final zzeq zzi = new zzeq(this, "allow_remote_dynamite", false);
    public final zzes zzj = new zzes(this, "last_pause_time", 0);
    public final zzes zzk = new zzes(this, "session_id", 0);
    public boolean zzl;
    public final zzeq zzm = new zzeq(this, "app_backgrounded", false);
    public final zzeq zzn = new zzeq(this, "deep_link_retrieval_complete", false);
    public final zzes zzo = new zzes(this, "deep_link_retrieval_attempts", 0);
    public final zzev zzp = new zzev(this, "firebase_feature_rollouts", (String) null);
    public final zzev zzq = new zzev(this, "deferred_attribution_cache", (String) null);
    public final zzes zzr = new zzes(this, "deferred_attribution_cache_timestamp", 0);
    public final zzer zzs = new zzer(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzu;
    private String zzv;
    private boolean zzw;
    private long zzx;

    zzew(zzfr zzfr) {
        super(zzfr);
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences zza() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.zzu);
        return this.zzu;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzaA() {
        SharedPreferences sharedPreferences = this.zzt.zzau().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzu = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzl = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzu.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzt.zzf();
        this.zzb = new zzeu(this, "health_monitor", Math.max(0, ((Long) zzdu.zzb.zza((Object) null)).longValue()), (zzet) null);
    }

    /* access modifiers changed from: package-private */
    public final Pair zzb(String str) {
        zzg();
        long elapsedRealtime = this.zzt.zzav().elapsedRealtime();
        String str2 = this.zzv;
        if (str2 != null && elapsedRealtime < this.zzx) {
            return new Pair(str2, Boolean.valueOf(this.zzw));
        }
        this.zzx = elapsedRealtime + this.zzt.zzf().zzi(str, zzdu.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzt.zzau());
            this.zzv = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzv = id;
            }
            this.zzw = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            this.zzt.zzay().zzc().zzb("Unable to get advertising id", e);
            this.zzv = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzv, Boolean.valueOf(this.zzw));
    }

    /* access modifiers changed from: package-private */
    public final zzai zzc() {
        zzg();
        return zzai.zzb(zza().getString("consent_settings", "G1"));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzi(boolean z) {
        zzg();
        this.zzt.zzay().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj() {
        SharedPreferences sharedPreferences = this.zzu;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(long j) {
        return j - this.zzf.zza() > this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl(int i) {
        return zzai.zzj(i, zza().getInt("consent_source", 100));
    }
}
