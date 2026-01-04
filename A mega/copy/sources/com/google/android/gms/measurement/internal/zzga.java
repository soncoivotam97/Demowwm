package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzga implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgj zzb;

    zzga(zzgj zzgj, zzq zzq) {
        this.zzb = zzgj;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        zzkt zzc = this.zzb.zza;
        zzq zzq = this.zza;
        zzc.zzaz().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzq.zza);
        zzc.zzd(zzq);
    }
}
