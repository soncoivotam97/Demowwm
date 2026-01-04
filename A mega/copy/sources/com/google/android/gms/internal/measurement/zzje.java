package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
public abstract class zzje implements Iterable, Serializable {
    private static final Comparator zza = new zziw();
    public static final zzje zzb = new zzjb(zzkn.zzd);
    private static final zzjd zzd = new zzjd((zzjc) null);
    private int zzc = 0;

    static {
        int i = zziq.zza;
    }

    zzje() {
    }

    public static zzje zzl(byte[] bArr, int i, int i2) {
        zzj(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzjb(bArr2);
    }

    public static zzje zzm(String str) {
        return new zzjb(str.getBytes(zzkn.zzb));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zze(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zziv(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzmm.zza(this) : zzmm.zza(zzf(0, 47)).concat("...")});
    }

    public abstract byte zza(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract int zze(int i, int i2, int i3);

    public abstract zzje zzf(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zzg(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzh(zziu zziu) throws IOException;

    public abstract boolean zzi();

    /* access modifiers changed from: protected */
    public final int zzk() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }

    static int zzj(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }
}
