package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzjv implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkc zzb;

    zzjv(zzkc zzkc, long j) {
        this.zzb = zzkc;
        this.zza = j;
    }

    public final void run() {
        zzkc.zzj(this.zzb, this.zza);
    }
}
