package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzft implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgj zzc;

    zzft(zzgj zzgj, zzac zzac, zzq zzq) {
        this.zzc = zzgj;
        this.zza = zzac;
        this.zzb = zzq;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzO(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzU(this.zza, this.zzb);
        }
    }
}
