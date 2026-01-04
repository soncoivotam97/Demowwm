package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzgh implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgj zzb;

    zzgh(zzgj zzgj, zzq zzq) {
        this.zzb = zzgj;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzL(this.zza);
    }
}
