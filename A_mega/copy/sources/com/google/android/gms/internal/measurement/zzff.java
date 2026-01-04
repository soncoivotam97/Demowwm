package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzff extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzff zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private int zzg;
    private zzkm zzh = zzbE();
    private zzkm zzi = zzbE();
    /* access modifiers changed from: private */
    public zzkm zzj = zzbE();
    private String zzk = "";
    private boolean zzl;
    private zzkm zzm = zzbE();
    private zzkm zzn = zzbE();
    private String zzo = "";

    static {
        zzff zzff = new zzff();
        zza = zzff;
        zzkf.zzbL(zzff.class, zzff);
    }

    private zzff() {
    }

    public static zzfe zze() {
        return (zzfe) zza.zzbx();
    }

    public static zzff zzg() {
        return zza;
    }

    static /* synthetic */ void zzo(zzff zzff, int i, zzfd zzfd) {
        zzfd.getClass();
        zzkm zzkm = zzff.zzi;
        if (!zzkm.zzc()) {
            zzff.zzi = zzkf.zzbF(zzkm);
        }
        zzff.zzi.set(i, zzfd);
    }

    public final int zza() {
        return this.zzm.size();
    }

    public final int zzb() {
        return this.zzi.size();
    }

    public final long zzc() {
        return this.zze;
    }

    public final zzfd zzd(int i) {
        return (zzfd) this.zzi.get(i);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzo;
    }

    public final List zzj() {
        return this.zzj;
    }

    public final List zzk() {
        return this.zzn;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzfj.class, "zzi", zzfd.class, "zzj", zzei.class, "zzk", "zzl", "zzm", zzgt.class, "zzn", zzfb.class, "zzo"});
        } else if (i2 == 3) {
            return new zzff();
        } else {
            if (i2 == 4) {
                return new zzfe((zzez) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final List zzm() {
        return this.zzm;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final boolean zzq() {
        return this.zzl;
    }

    public final boolean zzr() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzs() {
        return (this.zzd & 1) != 0;
    }
}
