package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zziy extends zzjb {
    private final int zzc;

    zziy(byte[] bArr, int i, int i2) {
        super(bArr);
        zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final byte zza(int i) {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            String str = "Index < 0: " + i;
            throw arrayIndexOutOfBoundsException;
        }
        arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        throw arrayIndexOutOfBoundsException;
    }
}
