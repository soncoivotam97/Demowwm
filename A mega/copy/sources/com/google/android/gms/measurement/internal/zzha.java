package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzha implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhx zzb;

    zzha(zzhx zzhx, long j) {
        this.zzb = zzhx;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzt.zzm().zzf.zzb(this.zza);
        this.zzb.zzt.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
