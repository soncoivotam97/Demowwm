package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzgr extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgr zza;
    private int zzd;
    private String zze = "";
    private zzkm zzf = zzbE();

    static {
        zzgr zzgr = new zzgr();
        zza = zzgr;
        zzkf.zzbL(zzgr.class, zzgr);
    }

    private zzgr() {
    }

    public final String zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", zzgy.class});
        } else if (i2 == 3) {
            return new zzgr();
        } else {
            if (i2 == 4) {
                return new zzgq((zzgn) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
