package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzmq extends zzmo {
    zzmq() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zza(Object obj) {
        return ((zzmp) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzmp) obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzkf zzkf = (zzkf) obj;
        zzmp zzmp = zzkf.zzc;
        if (zzmp != zzmp.zzc()) {
            return zzmp;
        }
        zzmp zzf = zzmp.zzf();
        zzkf.zzc = zzf;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzkf) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzmp.zzc().equals(obj2)) {
            return obj;
        }
        if (zzmp.zzc().equals(obj)) {
            return zzmp.zze((zzmp) obj, (zzmp) obj2);
        }
        ((zzmp) obj).zzd((zzmp) obj2);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzmp) obj).zzj(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        ((zzkf) obj).zzc.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzkf) obj).zzc = (zzmp) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, zzng zzng) throws IOException {
        ((zzmp) obj).zzk(zzng);
    }
}
