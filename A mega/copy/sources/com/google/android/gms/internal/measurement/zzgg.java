package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzgg extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgg zza;
    private int zzd;
    private int zze = 1;
    private zzkm zzf = zzbE();

    static {
        zzgg zzgg = new zzgg();
        zza = zzgg;
        zzkf.zzbL(zzgg.class, zzgg);
    }

    private zzgg() {
    }

    public static zzge zza() {
        return (zzge) zza.zzbx();
    }

    static /* synthetic */ void zzc(zzgg zzgg, zzfv zzfv) {
        zzfv.getClass();
        zzkm zzkm = zzgg.zzf;
        if (!zzkm.zzc()) {
            zzgg.zzf = zzkf.zzbF(zzkm);
        }
        zzgg.zzf.add(zzfv);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", zzgf.zza, "zzf", zzfv.class});
        } else if (i2 == 3) {
            return new zzgg();
        } else {
            if (i2 == 4) {
                return new zzge((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
