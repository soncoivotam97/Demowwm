package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzgd implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgj zzc;

    zzgd(zzgj zzgj, zzaw zzaw, String str) {
        this.zzc = zzgj;
        this.zza = zzaw;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzF(this.zza, this.zzb);
    }
}
