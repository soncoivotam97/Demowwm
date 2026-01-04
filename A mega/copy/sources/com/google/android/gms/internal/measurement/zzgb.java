package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzgb extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgb zza;
    private zzkm zzd = zzbE();

    static {
        zzgb zzgb = new zzgb();
        zza = zzgb;
        zzkf.zzbL(zzgb.class, zzgb);
    }

    private zzgb() {
    }

    public static zzga zza() {
        return (zzga) zza.zzbx();
    }

    static /* synthetic */ void zze(zzgb zzgb, zzgd zzgd) {
        zzgd.getClass();
        zzkm zzkm = zzgb.zzd;
        if (!zzkm.zzc()) {
            zzgb.zzd = zzkf.zzbF(zzkm);
        }
        zzgb.zzd.add(zzgd);
    }

    public final zzgd zzc(int i) {
        return (zzgd) this.zzd.get(0);
    }

    public final List zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgd.class});
        } else if (i2 == 3) {
            return new zzgb();
        } else {
            if (i2 == 4) {
                return new zzga((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
