package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzik implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzim zzc;

    zzik(zzim zzim, zzie zzie, long j) {
        this.zzc = zzim;
        this.zza = zzie;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzim zzim = this.zzc;
        zzim.zza = null;
        zzim.zzt.zzt().zzG((zzie) null);
    }
}
