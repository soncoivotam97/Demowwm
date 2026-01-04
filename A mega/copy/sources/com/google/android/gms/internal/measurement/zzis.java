package com.google.android.gms.internal.measurement;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzis {
    static int zza(byte[] bArr, int i, zzir zzir) throws zzkp {
        int zzj = zzj(bArr, i, zzir);
        int i2 = zzir.zza;
        if (i2 < 0) {
            throw zzkp.zzd();
        } else if (i2 > bArr.length - zzj) {
            throw zzkp.zzf();
        } else if (i2 == 0) {
            zzir.zzc = zzje.zzb;
            return zzj;
        } else {
            zzir.zzc = zzje.zzl(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static int zzc(zzlx zzlx, byte[] bArr, int i, int i2, int i3, zzir zzir) throws IOException {
        Object zze = zzlx.zze();
        int zzn = zzn(zze, zzlx, bArr, i, i2, i3, zzir);
        zzlx.zzf(zze);
        zzir.zzc = zze;
        return zzn;
    }

    static int zzd(zzlx zzlx, byte[] bArr, int i, int i2, zzir zzir) throws IOException {
        Object zze = zzlx.zze();
        int zzo = zzo(zze, zzlx, bArr, i, i2, zzir);
        zzlx.zzf(zze);
        zzir.zzc = zze;
        return zzo;
    }

    static int zze(zzlx zzlx, int i, byte[] bArr, int i2, int i3, zzkm zzkm, zzir zzir) throws IOException {
        int zzd = zzd(zzlx, bArr, i2, i3, zzir);
        zzkm.add(zzir.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzir);
            if (i != zzir.zza) {
                break;
            }
            zzd = zzd(zzlx, bArr, zzj, i3, zzir);
            zzkm.add(zzir.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzkm zzkm, zzir zzir) throws IOException {
        zzkg zzkg = (zzkg) zzkm;
        int zzj = zzj(bArr, i, zzir);
        int i2 = zzir.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzir);
            zzkg.zzh(zzir.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzkp.zzf();
    }

    static int zzg(byte[] bArr, int i, zzir zzir) throws zzkp {
        int zzj = zzj(bArr, i, zzir);
        int i2 = zzir.zza;
        if (i2 < 0) {
            throw zzkp.zzd();
        } else if (i2 == 0) {
            zzir.zzc = "";
            return zzj;
        } else {
            zzir.zzc = new String(bArr, zzj, i2, zzkn.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzir zzir) throws zzkp {
        int zzj = zzj(bArr, i, zzir);
        int i2 = zzir.zza;
        if (i2 < 0) {
            throw zzkp.zzd();
        } else if (i2 == 0) {
            zzir.zzc = "";
            return zzj;
        } else {
            zzir.zzc = zznd.zzd(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzmp zzmp, zzir zzir) throws zzkp {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzir);
                zzmp.zzj(i, Long.valueOf(zzir.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzmp.zzj(i, Long.valueOf(zzp(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzir);
                int i5 = zzir.zza;
                if (i5 < 0) {
                    throw zzkp.zzd();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzmp.zzj(i, zzje.zzb);
                    } else {
                        zzmp.zzj(i, zzje.zzl(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzkp.zzf();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzmp zzf = zzmp.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzir);
                    int i8 = zzir.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zzf, zzir);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzkp.zze();
                }
                zzmp.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzmp.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzkp.zzb();
            }
        } else {
            throw zzkp.zzb();
        }
    }

    static int zzj(byte[] bArr, int i, zzir zzir) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzir);
        }
        zzir.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzir zzir) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzir.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzir.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzir.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzir.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzir.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzkm zzkm, zzir zzir) {
        zzkg zzkg = (zzkg) zzkm;
        int zzj = zzj(bArr, i2, zzir);
        zzkg.zzh(zzir.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzir);
            if (i != zzir.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzir);
            zzkg.zzh(zzir.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzir zzir) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzir.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzir.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzlx zzlx, byte[] bArr, int i, int i2, int i3, zzir zzir) throws IOException {
        int zzc = ((zzlp) zzlx).zzc(obj, bArr, i, i2, i3, zzir);
        zzir.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzo(java.lang.Object r6, com.google.android.gms.internal.measurement.zzlx r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzir r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzh(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.measurement.zzkp r6 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzis.zzo(java.lang.Object, com.google.android.gms.internal.measurement.zzlx, byte[], int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    static long zzp(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
