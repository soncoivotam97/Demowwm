package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzgi extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgi zza;
    /* access modifiers changed from: private */
    public zzkl zzd = zzbC();
    /* access modifiers changed from: private */
    public zzkl zze = zzbC();
    /* access modifiers changed from: private */
    public zzkm zzf = zzbE();
    /* access modifiers changed from: private */
    public zzkm zzg = zzbE();

    static {
        zzgi zzgi = new zzgi();
        zza = zzgi;
        zzkf.zzbL(zzgi.class, zzgi);
    }

    private zzgi() {
    }

    public static zzgh zzf() {
        return (zzgh) zza.zzbx();
    }

    public static zzgi zzh() {
        return zza;
    }

    static /* synthetic */ void zzo(zzgi zzgi, Iterable iterable) {
        zzkl zzkl = zzgi.zzd;
        if (!zzkl.zzc()) {
            zzgi.zzd = zzkf.zzbD(zzkl);
        }
        zzio.zzbt(iterable, zzgi.zzd);
    }

    static /* synthetic */ void zzq(zzgi zzgi, Iterable iterable) {
        zzkl zzkl = zzgi.zze;
        if (!zzkl.zzc()) {
            zzgi.zze = zzkf.zzbD(zzkl);
        }
        zzio.zzbt(iterable, zzgi.zze);
    }

    static /* synthetic */ void zzs(zzgi zzgi, Iterable iterable) {
        zzgi.zzy();
        zzio.zzbt(iterable, zzgi.zzf);
    }

    static /* synthetic */ void zzu(zzgi zzgi, int i) {
        zzgi.zzy();
        zzgi.zzf.remove(i);
    }

    static /* synthetic */ void zzv(zzgi zzgi, Iterable iterable) {
        zzgi.zzz();
        zzio.zzbt(iterable, zzgi.zzg);
    }

    static /* synthetic */ void zzx(zzgi zzgi, int i) {
        zzgi.zzz();
        zzgi.zzg.remove(i);
    }

    private final void zzy() {
        zzkm zzkm = this.zzf;
        if (!zzkm.zzc()) {
            this.zzf = zzkf.zzbF(zzkm);
        }
    }

    private final void zzz() {
        zzkm zzkm = this.zzg;
        if (!zzkm.zzc()) {
            this.zzg = zzkf.zzbF(zzkm);
        }
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final zzfr zze(int i) {
        return (zzfr) this.zzf.get(i);
    }

    public final zzgk zzi(int i) {
        return (zzgk) this.zzg.get(i);
    }

    public final List zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", zzfr.class, "zzg", zzgk.class});
        } else if (i2 == 3) {
            return new zzgi();
        } else {
            if (i2 == 4) {
                return new zzgh((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final List zzm() {
        return this.zzg;
    }

    public final List zzn() {
        return this.zzd;
    }
}
