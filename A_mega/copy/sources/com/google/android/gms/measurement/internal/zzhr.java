package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhr implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzhx zzg;

    zzhr(zzhx zzhx, zzai zzai, long j, int i, long j2, boolean z, zzai zzai2) {
        this.zzg = zzhx;
        this.zza = zzai;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzai2;
    }

    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzhx.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpd.zzc();
        if (this.zzg.zzt.zzf().zzs((String) null, zzdu.zzam)) {
            zzhx.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
