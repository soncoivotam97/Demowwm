package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzjz extends zzap {
    final /* synthetic */ zzka zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjz(zzka zzka, zzgm zzgm) {
        super(zzgm);
        this.zza = zzka;
    }

    public final void zzc() {
        zzka zzka = this.zza;
        zzka.zzc.zzg();
        zzka.zzd(false, false, zzka.zzc.zzt.zzav().elapsedRealtime());
        zzka.zzc.zzt.zzd().zzf(zzka.zzc.zzt.zzav().elapsedRealtime());
    }
}
