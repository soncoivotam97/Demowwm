package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzjx implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjy zzc;

    zzjx(zzjy zzjy, long j, long j2) {
        this.zzc = zzjy;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzt.zzaz().zzp(new zzjw(this));
    }
}
