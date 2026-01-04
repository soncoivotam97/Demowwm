package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zznb extends zzna {
    zznb() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        while (r9 < i3 && bArr[r9] >= 0) {
            i2 = r9 + 1;
        }
        if (r9 >= i3) {
            return 0;
        }
        while (r9 < i3) {
            int i4 = r9 + 1;
            byte b = bArr[r9];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b >= -62) {
                        r9 += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                } else if (b < -16) {
                    if (i4 >= i3 - 1) {
                        return zznd.zza(bArr, i4, i3);
                    }
                    int i5 = r9 + 2;
                    byte b2 = bArr[i4];
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        r9 += 3;
                        if (bArr[i5] > -65) {
                        }
                    }
                } else if (i4 >= i3 - 2) {
                    return zznd.zza(bArr, i4, i3);
                } else {
                    int i6 = r9 + 2;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                        int i7 = r9 + 3;
                        if (bArr[i6] <= -65) {
                            r9 += 4;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            r9 = i4;
        }
        return 0;
    }
}
