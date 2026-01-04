package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzao implements Runnable {
    final /* synthetic */ zzgm zza;
    final /* synthetic */ zzap zzb;

    zzao(zzap zzap, zzgm zzgm) {
        this.zzb = zzap;
        this.zza = zzgm;
    }

    public final void run() {
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
