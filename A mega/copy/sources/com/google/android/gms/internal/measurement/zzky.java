package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzky extends zzla {
    private zzky() {
        super((zzkz) null);
    }

    /* synthetic */ zzky(zzkx zzkx) {
        super((zzkz) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        ((zzkm) zzmy.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j) {
        zzkm zzkm = (zzkm) zzmy.zzf(obj, j);
        zzkm zzkm2 = (zzkm) zzmy.zzf(obj2, j);
        int size = zzkm.size();
        int size2 = zzkm2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkm.zzc()) {
                zzkm = zzkm.zzd(size2 + size);
            }
            zzkm.addAll(zzkm2);
        }
        if (size > 0) {
            zzkm2 = zzkm;
        }
        zzmy.zzs(obj, j, zzkm2);
    }
}
