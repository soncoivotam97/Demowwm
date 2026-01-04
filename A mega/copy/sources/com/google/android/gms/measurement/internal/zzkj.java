package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzkj implements Runnable {
    final /* synthetic */ zzku zza;
    final /* synthetic */ zzkt zzb;

    zzkj(zzkt zzkt, zzku zzku) {
        this.zzb = zzkt;
        this.zza = zzku;
    }

    public final void run() {
        zzkt.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
