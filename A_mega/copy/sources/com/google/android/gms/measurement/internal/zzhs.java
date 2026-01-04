package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhs implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzai zze;
    final /* synthetic */ zzhx zzf;

    zzhs(zzhx zzhx, zzai zzai, int i, long j, boolean z, zzai zzai2) {
        this.zzf = zzhx;
        this.zza = zzai;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzai2;
    }

    public final void run() {
        this.zzf.zzV(this.zza);
        zzhx.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzpd.zzc();
        if (this.zzf.zzt.zzf().zzs((String) null, zzdu.zzam)) {
            zzhx.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
