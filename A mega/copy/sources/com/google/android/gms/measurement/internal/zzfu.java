package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzfu implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzgj zzb;

    zzfu(zzgj zzgj, zzac zzac) {
        this.zzb = zzgj;
        this.zza = zzac;
    }

    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzN(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
