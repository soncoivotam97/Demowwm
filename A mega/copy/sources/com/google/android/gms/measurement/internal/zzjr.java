package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzjr implements Runnable {
    final /* synthetic */ zzkt zza;
    final /* synthetic */ Runnable zzb;

    zzjr(zzjt zzjt, zzkt zzkt, Runnable runnable) {
        this.zza = zzkt;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
