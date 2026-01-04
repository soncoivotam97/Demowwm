package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzlp<T> implements zzlx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmy.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzla zzm;
    private final zzmo zzn;
    private final zzjs zzo;
    private final zzlr zzp;
    private final zzlh zzq;

    private zzlp(int[] iArr, Object[] objArr, int i, int i2, zzlm zzlm, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlr zzlr, zzla zzla, zzmo zzmo, zzjs zzjs, zzlh zzlh, byte[] bArr) {
        zzlm zzlm2 = zzlm;
        zzjs zzjs2 = zzjs;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzjs2 != null && zzjs2.zzc(zzlm)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlr;
        this.zzm = zzla;
        this.zzn = zzmo;
        this.zzo = zzjs2;
        this.zzg = zzlm2;
        this.zzq = zzlh;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzmy.zzf(obj, j)).longValue();
    }

    private final zzkj zzD(int i) {
        int i2 = i / 3;
        return (zzkj) this.zzd[i2 + i2 + 1];
    }

    private final zzlx zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlx zzlx = (zzlx) this.zzd[i3];
        if (zzlx != null) {
            return zzlx;
        }
        zzlx zzb2 = zzlu.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzG(Object obj, int i) {
        zzlx zzE = zzE(i);
        long zzB = (long) (zzB(i) & 1048575);
        if (!zzT(obj, i)) {
            return zzE.zze();
        }
        Object object = zzb.getObject(obj, zzB);
        if (zzW(object)) {
            return object;
        }
        Object zze2 = zzE.zze();
        if (object != null) {
            zzE.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzH(Object obj, int i, int i2) {
        zzlx zzE = zzE(i2);
        if (!zzX(obj, i, i2)) {
            return zzE.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzB(i2) & 1048575));
        if (zzW(object)) {
            return object;
        }
        Object zze2 = zzE.zze();
        if (object != null) {
            zzE.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzI(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzJ(Object obj) {
        if (!zzW(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzK(Object obj, Object obj2, int i) {
        if (zzT(obj2, i)) {
            long zzB = (long) (zzB(i) & 1048575);
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, zzB);
            if (object != null) {
                zzlx zzE = zzE(i);
                if (!zzT(obj, i)) {
                    if (!zzW(object)) {
                        unsafe.putObject(obj, zzB, object);
                    } else {
                        Object zze2 = zzE.zze();
                        zzE.zzg(zze2, object);
                        unsafe.putObject(obj, zzB, zze2);
                    }
                    zzM(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzB);
                if (!zzW(object2)) {
                    Object zze3 = zzE.zze();
                    zzE.zzg(zze3, object2);
                    unsafe.putObject(obj, zzB, zze3);
                    object2 = zze3;
                }
                zzE.zzg(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzL(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzX(obj2, i2, i)) {
            long zzB = (long) (zzB(i) & 1048575);
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, zzB);
            if (object != null) {
                zzlx zzE = zzE(i);
                if (!zzX(obj, i2, i)) {
                    if (!zzW(object)) {
                        unsafe.putObject(obj, zzB, object);
                    } else {
                        Object zze2 = zzE.zze();
                        zzE.zzg(zze2, object);
                        unsafe.putObject(obj, zzB, zze2);
                    }
                    zzN(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzB);
                if (!zzW(object2)) {
                    Object zze3 = zzE.zze();
                    zzE.zzg(zze3, object2);
                    unsafe.putObject(obj, zzB, zze3);
                    object2 = zze3;
                }
                zzE.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzM(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (1048575 & zzy);
        if (j != 1048575) {
            zzmy.zzq(obj, j, (1 << (zzy >>> 20)) | zzmy.zzc(obj, j));
        }
    }

    private final void zzN(Object obj, int i, int i2) {
        zzmy.zzq(obj, (long) (zzy(i2) & 1048575), i);
    }

    private final void zzO(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzB(i) & 1048575), obj2);
        zzM(obj, i);
    }

    private final void zzP(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzB(i2) & 1048575), obj2);
        zzN(obj, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044c, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029b, code lost:
        r13 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzQ(java.lang.Object r17, com.google.android.gms.internal.measurement.zzng r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045d
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0453
            int r10 = r0.zzB(r7)
            int[] r11 = r0.zzc
            r12 = r11[r7]
            int r13 = zzA(r10)
            r14 = 17
            r15 = 1
            if (r13 > r14) goto L_0x003b
            int r14 = r7 + 2
            r11 = r11[r14]
            r14 = r11 & r5
            if (r14 == r9) goto L_0x0036
            long r8 = (long) r14
            int r8 = r4.getInt(r1, r8)
            r9 = r14
        L_0x0036:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x003c
        L_0x003b:
            r11 = 0
        L_0x003c:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r13) {
                case 0: goto L_0x0440;
                case 1: goto L_0x0433;
                case 2: goto L_0x0426;
                case 3: goto L_0x0419;
                case 4: goto L_0x040c;
                case 5: goto L_0x03ff;
                case 6: goto L_0x03f2;
                case 7: goto L_0x03e5;
                case 8: goto L_0x03d7;
                case 9: goto L_0x03c5;
                case 10: goto L_0x03b5;
                case 11: goto L_0x03a7;
                case 12: goto L_0x0399;
                case 13: goto L_0x038b;
                case 14: goto L_0x037d;
                case 15: goto L_0x036f;
                case 16: goto L_0x0361;
                case 17: goto L_0x034f;
                case 18: goto L_0x033f;
                case 19: goto L_0x032f;
                case 20: goto L_0x031f;
                case 21: goto L_0x030f;
                case 22: goto L_0x02ff;
                case 23: goto L_0x02ef;
                case 24: goto L_0x02df;
                case 25: goto L_0x02cf;
                case 26: goto L_0x02c0;
                case 27: goto L_0x02ad;
                case 28: goto L_0x029e;
                case 29: goto L_0x028d;
                case 30: goto L_0x027e;
                case 31: goto L_0x026f;
                case 32: goto L_0x0260;
                case 33: goto L_0x0251;
                case 34: goto L_0x0242;
                case 35: goto L_0x0233;
                case 36: goto L_0x0224;
                case 37: goto L_0x0215;
                case 38: goto L_0x0206;
                case 39: goto L_0x01f7;
                case 40: goto L_0x01e8;
                case 41: goto L_0x01d9;
                case 42: goto L_0x01ca;
                case 43: goto L_0x01bb;
                case 44: goto L_0x01ac;
                case 45: goto L_0x019d;
                case 46: goto L_0x018e;
                case 47: goto L_0x017f;
                case 48: goto L_0x0170;
                case 49: goto L_0x015d;
                case 50: goto L_0x0154;
                case 51: goto L_0x0145;
                case 52: goto L_0x0136;
                case 53: goto L_0x0127;
                case 54: goto L_0x0118;
                case 55: goto L_0x0109;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00eb;
                case 58: goto L_0x00dc;
                case 59: goto L_0x00cd;
                case 60: goto L_0x00ba;
                case 61: goto L_0x00aa;
                case 62: goto L_0x009c;
                case 63: goto L_0x008e;
                case 64: goto L_0x0080;
                case 65: goto L_0x0072;
                case 66: goto L_0x0064;
                case 67: goto L_0x0056;
                case 68: goto L_0x0044;
                default: goto L_0x0041;
            }
        L_0x0041:
            r13 = 0
            goto L_0x044c
        L_0x0044:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlx r6 = r0.zzE(r7)
            r2.zzq(r12, r5, r6)
            goto L_0x0041
        L_0x0056:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzC(r12, r5)
            goto L_0x0041
        L_0x0064:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzA(r12, r5)
            goto L_0x0041
        L_0x0072:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzy(r12, r5)
            goto L_0x0041
        L_0x0080:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzw(r12, r5)
            goto L_0x0041
        L_0x008e:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzi(r12, r5)
            goto L_0x0041
        L_0x009c:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzH(r12, r5)
            goto L_0x0041
        L_0x00aa:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzje r5 = (com.google.android.gms.internal.measurement.zzje) r5
            r2.zzd(r12, r5)
            goto L_0x0041
        L_0x00ba:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlx r6 = r0.zzE(r7)
            r2.zzv(r12, r5, r6)
            goto L_0x0041
        L_0x00cd:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzZ(r12, r5, r2)
            goto L_0x0041
        L_0x00dc:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            boolean r5 = zzY(r1, r5)
            r2.zzb(r12, r5)
            goto L_0x0041
        L_0x00eb:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzk(r12, r5)
            goto L_0x0041
        L_0x00fa:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzm(r12, r5)
            goto L_0x0041
        L_0x0109:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzr(r12, r5)
            goto L_0x0041
        L_0x0118:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzJ(r12, r5)
            goto L_0x0041
        L_0x0127:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzt(r12, r5)
            goto L_0x0041
        L_0x0136:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            float r5 = zzo(r1, r5)
            r2.zzo(r12, r5)
            goto L_0x0041
        L_0x0145:
            boolean r10 = r0.zzX(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            double r5 = zzn(r1, r5)
            r2.zzf(r12, r5)
            goto L_0x0041
        L_0x0154:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzR(r2, r12, r5, r7)
            goto L_0x0041
        L_0x015d:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlx r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlz.zzO(r10, r5, r2, r6)
            goto L_0x0041
        L_0x0170:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzV(r10, r5, r2, r15)
            goto L_0x0041
        L_0x017f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzU(r10, r5, r2, r15)
            goto L_0x0041
        L_0x018e:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzT(r10, r5, r2, r15)
            goto L_0x0041
        L_0x019d:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzS(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ac:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzK(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01bb:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzX(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ca:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzH(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01d9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzL(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01e8:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzM(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01f7:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzP(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0206:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzY(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0215:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzQ(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0224:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzN(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0233:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzJ(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0242:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.measurement.zzlz.zzV(r10, r5, r2, r11)
            goto L_0x029b
        L_0x0251:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzU(r10, r5, r2, r11)
            goto L_0x029b
        L_0x0260:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzT(r10, r5, r2, r11)
            goto L_0x029b
        L_0x026f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzS(r10, r5, r2, r11)
            goto L_0x029b
        L_0x027e:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzK(r10, r5, r2, r11)
            goto L_0x029b
        L_0x028d:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzX(r10, r5, r2, r11)
        L_0x029b:
            r13 = r11
            goto L_0x044c
        L_0x029e:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzI(r10, r5, r2)
            goto L_0x0041
        L_0x02ad:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlx r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlz.zzR(r10, r5, r2, r6)
            goto L_0x0041
        L_0x02c0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzW(r10, r5, r2)
            goto L_0x0041
        L_0x02cf:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r13 = 0
            com.google.android.gms.internal.measurement.zzlz.zzH(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02df:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzL(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ef:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzM(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ff:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzP(r10, r5, r2, r13)
            goto L_0x044c
        L_0x030f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzY(r10, r5, r2, r13)
            goto L_0x044c
        L_0x031f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzQ(r10, r5, r2, r13)
            goto L_0x044c
        L_0x032f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzN(r10, r5, r2, r13)
            goto L_0x044c
        L_0x033f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlz.zzJ(r10, r5, r2, r13)
            goto L_0x044c
        L_0x034f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlx r6 = r0.zzE(r7)
            r2.zzq(r12, r5, r6)
            goto L_0x044c
        L_0x0361:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzC(r12, r5)
            goto L_0x044c
        L_0x036f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzA(r12, r5)
            goto L_0x044c
        L_0x037d:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzy(r12, r5)
            goto L_0x044c
        L_0x038b:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzw(r12, r5)
            goto L_0x044c
        L_0x0399:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r12, r5)
            goto L_0x044c
        L_0x03a7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzH(r12, r5)
            goto L_0x044c
        L_0x03b5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzje r5 = (com.google.android.gms.internal.measurement.zzje) r5
            r2.zzd(r12, r5)
            goto L_0x044c
        L_0x03c5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzlx r6 = r0.zzE(r7)
            r2.zzv(r12, r5, r6)
            goto L_0x044c
        L_0x03d7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzZ(r12, r5, r2)
            goto L_0x044c
        L_0x03e5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            boolean r5 = com.google.android.gms.internal.measurement.zzmy.zzw(r1, r5)
            r2.zzb(r12, r5)
            goto L_0x044c
        L_0x03f2:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r12, r5)
            goto L_0x044c
        L_0x03ff:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzm(r12, r5)
            goto L_0x044c
        L_0x040c:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzr(r12, r5)
            goto L_0x044c
        L_0x0419:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzJ(r12, r5)
            goto L_0x044c
        L_0x0426:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzt(r12, r5)
            goto L_0x044c
        L_0x0433:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            float r5 = com.google.android.gms.internal.measurement.zzmy.zzb(r1, r5)
            r2.zzo(r12, r5)
            goto L_0x044c
        L_0x0440:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            double r5 = com.google.android.gms.internal.measurement.zzmy.zza(r1, r5)
            r2.zzf(r12, r5)
        L_0x044c:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0453:
            com.google.android.gms.internal.measurement.zzmo r0 = r0.zzn
            java.lang.Object r1 = r0.zzd(r1)
            r0.zzi(r1, r2)
            return
        L_0x045d:
            com.google.android.gms.internal.measurement.zzjs r0 = r0.zzo
            r0.zza(r1)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzQ(java.lang.Object, com.google.android.gms.internal.measurement.zzng):void");
    }

    private final void zzR(zzng zzng, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlf zzlf = (zzlf) zzF(i2);
            throw null;
        }
    }

    private final boolean zzS(Object obj, Object obj2, int i) {
        return zzT(obj, i) == zzT(obj2, i);
    }

    private final boolean zzT(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (zzy & 1048575);
        if (j != 1048575) {
            return (zzmy.zzc(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = (long) (zzB & 1048575);
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmy.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmy.zzb(obj, j2)) != 0;
            case 2:
                return zzmy.zzd(obj, j2) != 0;
            case 3:
                return zzmy.zzd(obj, j2) != 0;
            case 4:
                return zzmy.zzc(obj, j2) != 0;
            case 5:
                return zzmy.zzd(obj, j2) != 0;
            case 6:
                return zzmy.zzc(obj, j2) != 0;
            case 7:
                return zzmy.zzw(obj, j2);
            case 8:
                Object zzf2 = zzmy.zzf(obj, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzje) {
                    return !zzje.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmy.zzf(obj, j2) != null;
            case 10:
                return !zzje.zzb.equals(zzmy.zzf(obj, j2));
            case 11:
                return zzmy.zzc(obj, j2) != 0;
            case 12:
                return zzmy.zzc(obj, j2) != 0;
            case 13:
                return zzmy.zzc(obj, j2) != 0;
            case 14:
                return zzmy.zzd(obj, j2) != 0;
            case 15:
                return zzmy.zzc(obj, j2) != 0;
            case 16:
                return zzmy.zzd(obj, j2) != 0;
            case 17:
                return zzmy.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzU(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzT(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzV(Object obj, int i, zzlx zzlx) {
        return zzlx.zzk(zzmy.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkf) {
            return ((zzkf) obj).zzbO();
        }
        return true;
    }

    private final boolean zzX(Object obj, int i, int i2) {
        return zzmy.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzY(Object obj, long j) {
        return ((Boolean) zzmy.zzf(obj, j)).booleanValue();
    }

    private static final void zzZ(int i, Object obj, zzng zzng) throws IOException {
        if (obj instanceof String) {
            zzng.zzF(i, (String) obj);
        } else {
            zzng.zzd(i, (zzje) obj);
        }
    }

    static zzmp zzd(Object obj) {
        zzkf zzkf = (zzkf) obj;
        zzmp zzmp = zzkf.zzc;
        if (zzmp != zzmp.zzc()) {
            return zzmp;
        }
        zzmp zzf2 = zzmp.zzf();
        zzkf.zzc = zzf2;
        return zzf2;
    }

    static zzlp zzl(Class cls, zzlj zzlj, zzlr zzlr, zzla zzla, zzmo zzmo, zzjs zzjs, zzlh zzlh) {
        if (zzlj instanceof zzlw) {
            return zzm((zzlw) zzlj, zzlr, zzla, zzmo, zzjs, zzlh);
        }
        zzml zzml = (zzml) zzlj;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x037f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzlp zzm(com.google.android.gms.internal.measurement.zzlw r34, com.google.android.gms.internal.measurement.zzlr r35, com.google.android.gms.internal.measurement.zzla r36, com.google.android.gms.internal.measurement.zzmo r37, com.google.android.gms.internal.measurement.zzjs r38, com.google.android.gms.internal.measurement.zzlh r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r2
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.measurement.zzlm r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r1) goto L_0x03ce
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0194:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0194
        L_0x01a6:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ae
        L_0x01ac:
            r3 = r24
        L_0x01ae:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01db
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d5
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bc
        L_0x01d5:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r1
            r1 = r24
        L_0x01df:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x029a
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0223
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzI(r2, r12)
            r17[r1] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r1 = r1 + 1
            r8 = r17[r1]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r2, r8)
            r17[r1] = r8
        L_0x0284:
            r1 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r29 = r11
            r0 = r16
            r26 = r27
            r25 = 1
            r16 = r7
            r7 = r1
            r1 = 0
            goto L_0x0393
        L_0x029a:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x0312
            r12 = 17
            if (r5 != r12) goto L_0x02b2
            goto L_0x0312
        L_0x02b2:
            r12 = 27
            if (r5 == r12) goto L_0x0302
            r12 = 49
            if (r5 != r12) goto L_0x02bb
            goto L_0x0302
        L_0x02bb:
            r12 = 12
            if (r5 == r12) goto L_0x02f2
            r12 = 30
            if (r5 == r12) goto L_0x02f2
            r12 = 44
            if (r5 != r12) goto L_0x02c8
            goto L_0x02f2
        L_0x02c8:
            r12 = 50
            if (r5 != r12) goto L_0x02e8
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r29 = r16 + 2
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02eb
            int r7 = r16 + 3
            int r22 = r22 + 1
            r16 = r17[r29]
            r11[r22] = r16
            r22 = r12
        L_0x02e8:
            r25 = 1
            goto L_0x031f
        L_0x02eb:
            r22 = r12
            r12 = r29
            r25 = 1
            goto L_0x0320
        L_0x02f2:
            if (r10 != 0) goto L_0x02e8
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030f
        L_0x0302:
            r25 = 1
            int r12 = r9 / 3
            int r16 = r16 + 2
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030f:
            r12 = r16
            goto L_0x0320
        L_0x0312:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r16 = r8.getType()
            r11[r12] = r16
        L_0x031f:
            r12 = r7
        L_0x0320:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x037f
            r8 = 17
            if (r5 > r8) goto L_0x037f
            int r8 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0359
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0343:
            int r26 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0355
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r16
            r1 = r1 | r8
            int r16 = r16 + 13
            r8 = r26
            goto L_0x0343
        L_0x0355:
            int r8 = r8 << r16
            r1 = r1 | r8
            goto L_0x035b
        L_0x0359:
            r26 = r8
        L_0x035b:
            int r8 = r6 + r6
            int r16 = r1 / 32
            int r8 = r8 + r16
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x036c
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0374
        L_0x036c:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzI(r2, r11)
            r17[r8] = r11
        L_0x0374:
            r0 = r12
            long r11 = r15.objectFieldOffset(r11)
            int r8 = (int) r11
            int r1 = r1 % 32
            r16 = r8
            goto L_0x0385
        L_0x037f:
            r30 = r0
            r0 = r12
            r26 = r1
            r1 = 0
        L_0x0385:
            r8 = 18
            if (r5 < r8) goto L_0x0393
            r8 = 49
            if (r5 > r8) goto L_0x0393
            int r8 = r23 + 1
            r13[r23] = r7
            r23 = r8
        L_0x0393:
            int r8 = r9 + 1
            r31[r9] = r4
            int r4 = r9 + 2
            r11 = r3 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x03a0
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a1
        L_0x03a0:
            r11 = 0
        L_0x03a1:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a8
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a9
        L_0x03a8:
            r3 = 0
        L_0x03a9:
            r3 = r3 | r11
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r7
            r31[r8] = r3
            int r9 = r9 + 3
            int r1 = r1 << 20
            r1 = r1 | r16
            r31[r4] = r1
            r16 = r0
            r8 = r14
            r14 = r24
            r4 = r26
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ce:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.zzlp r0 = new com.google.android.gms.internal.measurement.zzlp
            r4 = r0
            com.google.android.gms.internal.measurement.zzlm r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzm(com.google.android.gms.internal.measurement.zzlw, com.google.android.gms.internal.measurement.zzlr, com.google.android.gms.internal.measurement.zzla, com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzjs, com.google.android.gms.internal.measurement.zzlh):com.google.android.gms.internal.measurement.zzlp");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzmy.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzmy.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0309, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030a, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030b, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0349, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037d, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0488, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0503, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0504, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x052d, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x053b, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x054a, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x054e, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ee, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019b, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ab, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bb, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = zzb
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r4
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000c:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0555
            int r9 = r15.zzB(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzA(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0035
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0036
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0036
        L_0x0035:
            r10 = 0
        L_0x0036:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x053f;
                case 1: goto L_0x0530;
                case 2: goto L_0x051a;
                case 3: goto L_0x0506;
                case 4: goto L_0x04f0;
                case 5: goto L_0x04e4;
                case 6: goto L_0x04d8;
                case 7: goto L_0x04ca;
                case 8: goto L_0x049f;
                case 9: goto L_0x048c;
                case 10: goto L_0x046f;
                case 11: goto L_0x045a;
                case 12: goto L_0x0445;
                case 13: goto L_0x0438;
                case 14: goto L_0x042b;
                case 15: goto L_0x0411;
                case 16: goto L_0x03f7;
                case 17: goto L_0x03e3;
                case 18: goto L_0x03d5;
                case 19: goto L_0x03c9;
                case 20: goto L_0x03bd;
                case 21: goto L_0x03b1;
                case 22: goto L_0x03a5;
                case 23: goto L_0x0399;
                case 24: goto L_0x038d;
                case 25: goto L_0x0381;
                case 26: goto L_0x0373;
                case 27: goto L_0x0364;
                case 28: goto L_0x0359;
                case 29: goto L_0x034d;
                case 30: goto L_0x033e;
                case 31: goto L_0x0332;
                case 32: goto L_0x0326;
                case 33: goto L_0x031a;
                case 34: goto L_0x030e;
                case 35: goto L_0x02f5;
                case 36: goto L_0x02e0;
                case 37: goto L_0x02cb;
                case 38: goto L_0x02b6;
                case 39: goto L_0x02a1;
                case 40: goto L_0x028c;
                case 41: goto L_0x0276;
                case 42: goto L_0x0260;
                case 43: goto L_0x024a;
                case 44: goto L_0x0234;
                case 45: goto L_0x021e;
                case 46: goto L_0x0208;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01dc;
                case 49: goto L_0x01cc;
                case 50: goto L_0x01bf;
                case 51: goto L_0x01af;
                case 52: goto L_0x019f;
                case 53: goto L_0x0187;
                case 54: goto L_0x0172;
                case 55: goto L_0x015c;
                case 56: goto L_0x014f;
                case 57: goto L_0x0142;
                case 58: goto L_0x0133;
                case 59: goto L_0x0106;
                case 60: goto L_0x00f2;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00be;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x0071;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x037e
        L_0x003f:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlm r3 = (com.google.android.gms.internal.measurement.zzlm) r3
            com.google.android.gms.internal.measurement.zzlx r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzu(r11, r3, r4)
            goto L_0x037d
        L_0x0055:
            boolean r10 = r15.zzX(r1, r11, r5)
            if (r10 == 0) goto L_0x037e
            long r3 = zzC(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjm.zzA(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x037e
        L_0x0071:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x030a
        L_0x008c:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01bb
        L_0x009a:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ab
        L_0x00a8:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x030a
        L_0x00be:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x030a
        L_0x00d4:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x00ee:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x030b
        L_0x00f2:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlx r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzo(r11, r3, r4)
            goto L_0x037d
        L_0x0106:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzje
            if (r4 == 0) goto L_0x0125
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x00ee
        L_0x0125:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzy(r3)
            goto L_0x030a
        L_0x0133:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            int r3 = r3 + r14
            goto L_0x037d
        L_0x0142:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01ab
        L_0x014f:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x01bb
        L_0x015c:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x030a
        L_0x0172:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            goto L_0x019b
        L_0x0187:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
        L_0x019b:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x037e
        L_0x019f:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x01ab:
            int r3 = r3 + 4
            goto L_0x037d
        L_0x01af:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x01bb:
            int r3 = r3 + 8
            goto L_0x037d
        L_0x01bf:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.zzF(r5)
            com.google.android.gms.internal.measurement.zzlh.zza(r11, r3, r4)
            goto L_0x037e
        L_0x01cc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlx r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzj(r11, r3, r4)
            goto L_0x037d
        L_0x01dc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzt(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x01f2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzr(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x0208:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x021e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x0234:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zze(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x024a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzw(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x0260:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzb(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x0276:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x028c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x02a1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzl(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzy(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x02cb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzn(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x02e0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0309
        L_0x02f5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0309:
            int r4 = r4 + r9
        L_0x030a:
            int r4 = r4 + r3
        L_0x030b:
            int r6 = r6 + r4
            goto L_0x037e
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzs(r11, r3, r9)
            goto L_0x0349
        L_0x031a:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzq(r11, r3, r9)
            goto L_0x0349
        L_0x0326:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzh(r11, r3, r9)
            goto L_0x0349
        L_0x0332:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzf(r11, r3, r9)
            goto L_0x0349
        L_0x033e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzd(r11, r3, r9)
        L_0x0349:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x054e
        L_0x034d:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzv(r11, r3, r9)
            goto L_0x037d
        L_0x0359:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzc(r11, r3)
            goto L_0x037d
        L_0x0364:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlx r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzp(r11, r3, r4)
            goto L_0x037d
        L_0x0373:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzu(r11, r3)
        L_0x037d:
            int r6 = r6 + r3
        L_0x037e:
            r12 = 0
            goto L_0x054e
        L_0x0381:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlz.zza(r11, r3, r12)
            goto L_0x03e0
        L_0x038d:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzf(r11, r3, r12)
            goto L_0x03e0
        L_0x0399:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzh(r11, r3, r12)
            goto L_0x03e0
        L_0x03a5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzk(r11, r3, r12)
            goto L_0x03e0
        L_0x03b1:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzx(r11, r3, r12)
            goto L_0x03e0
        L_0x03bd:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzm(r11, r3, r12)
            goto L_0x03e0
        L_0x03c9:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzf(r11, r3, r12)
            goto L_0x03e0
        L_0x03d5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzh(r11, r3, r12)
        L_0x03e0:
            int r6 = r6 + r3
            goto L_0x054e
        L_0x03e3:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlm r3 = (com.google.android.gms.internal.measurement.zzlm) r3
            com.google.android.gms.internal.measurement.zzlx r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzu(r11, r3, r4)
            goto L_0x03e0
        L_0x03f7:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjm.zzA(r10)
            long r13 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r13
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054e
        L_0x0411:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0503
        L_0x042b:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x054a
        L_0x0438:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x053b
        L_0x0445:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
            goto L_0x0503
        L_0x045a:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0503
        L_0x046f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x0488:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0504
        L_0x048c:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlx r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlz.zzo(r11, r3, r4)
            goto L_0x03e0
        L_0x049f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzje
            if (r4 == 0) goto L_0x04bd
            com.google.android.gms.internal.measurement.zzje r3 = (com.google.android.gms.internal.measurement.zzje) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x0488
        L_0x04bd:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzy(r3)
            goto L_0x0503
        L_0x04ca:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            int r3 = r3 + r14
            goto L_0x03e0
        L_0x04d8:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x053b
        L_0x04e4:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
            goto L_0x054a
        L_0x04f0:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzv(r3)
        L_0x0503:
            int r4 = r4 + r3
        L_0x0504:
            int r6 = r6 + r4
            goto L_0x054e
        L_0x0506:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
            goto L_0x052d
        L_0x051a:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjm.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzB(r3)
        L_0x052d:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054e
        L_0x0530:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x053b:
            int r3 = r3 + 4
            goto L_0x03e0
        L_0x053f:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjm.zzA(r3)
        L_0x054a:
            int r3 = r3 + 8
            goto L_0x03e0
        L_0x054e:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000c
        L_0x0555:
            com.google.android.gms.internal.measurement.zzmo r2 = r0.zzn
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x0565
            return r6
        L_0x0565:
            com.google.android.gms.internal.measurement.zzjs r0 = r0.zzo
            r0.zza(r1)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzp(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzB(r2)
            int r5 = zzA(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzjx r4 = com.google.android.gms.internal.measurement.zzjx.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzjx r4 = com.google.android.gms.internal.measurement.zzjx.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlm r4 = (com.google.android.gms.internal.measurement.zzlm) r4
            com.google.android.gms.internal.measurement.zzlx r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzX(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzC(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlx r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzje
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.lang.Object r5 = r11.zzF(r2)
            com.google.android.gms.internal.measurement.zzlh.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlx r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlx r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlm r4 = (com.google.android.gms.internal.measurement.zzlm) r4
            com.google.android.gms.internal.measurement.zzlx r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzT(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzmy.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlx r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlz.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzje
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzje r4 = (com.google.android.gms.internal.measurement.zzje) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjm.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmy.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmy.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjm.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjm.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzmo r11 = r11.zzn
            java.lang.Object r12 = r11.zzd(r12)
            int r11 = r11.zza(r12)
            int r3 = r3 + r11
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzq(java.lang.Object):int");
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzmy.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzir zzir) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzlg) object).zze()) {
            zzlg zzb2 = zzlg.zza().zzb();
            zzlh.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzlf zzlf = (zzlf) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzir zzir) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzir zzir2 = zzir;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzis.zzp(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzis.zzb(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                if (i12 == 0) {
                    int zzm2 = zzis.zzm(bArr2, i9, zzir2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzir2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzis.zzj(bArr2, i9, zzir2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzir2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzis.zzp(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzis.zzb(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzis.zzm(bArr2, i9, zzir2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzir2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzis.zzj(bArr2, i9, zzir2);
                    int i14 = zzir2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zznd.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i14, zzkn.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzkp.zzc();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                if (i12 == 2) {
                    Object zzH = zzH(obj2, i11, i13);
                    int zzo2 = zzis.zzo(zzH, zzE(i13), bArr, i, i2, zzir);
                    zzP(obj2, i11, i13, zzH);
                    return zzo2;
                }
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                if (i12 == 2) {
                    int zza2 = zzis.zza(bArr2, i9, zzir2);
                    unsafe.putObject(obj2, j2, zzir2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case HtmlCompat.FROM_HTML_MODE_COMPACT:
                if (i12 == 0) {
                    int zzj4 = zzis.zzj(bArr2, i9, zzir2);
                    int i15 = zzir2.zza;
                    zzkj zzD = zzD(i13);
                    if (zzD == null || zzD.zza(i15)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i15));
                        unsafe.putInt(obj2, j3, i11);
                        return zzj4;
                    }
                    zzd(obj).zzj(i10, Long.valueOf((long) i15));
                    return zzj4;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                if (i12 == 0) {
                    int zzj5 = zzis.zzj(bArr2, i9, zzir2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzji.zzb(zzir2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                if (i12 == 0) {
                    int zzm4 = zzis.zzm(bArr2, i9, zzir2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzji.zzc(zzir2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    Object zzH2 = zzH(obj2, i11, i13);
                    int zzn2 = zzis.zzn(zzH2, zzE(i13), bArr, i, i2, (i10 & -8) | 4, zzir);
                    zzP(obj2, i11, i13, zzH2);
                    return zzn2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02e0, code lost:
        if (r0 != r15) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0304, code lost:
        if (r0 != r15) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        r23 = r32;
        r11 = r34;
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r13 = r4;
        r32 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ee, code lost:
        r6 = r6 | r8;
        r13 = r33;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0113, code lost:
        r6 = r6 | r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x018e, code lost:
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c7, code lost:
        r2 = r10;
        r0 = r13;
        r1 = r23;
        r8 = -1;
        r10 = 1048575;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0205, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0207, code lost:
        r6 = r32 | r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0209, code lost:
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x020c, code lost:
        r6 = r32;
        r28 = r9;
        r19 = r10;
        r2 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x029b, code lost:
        if (r0 != r15) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b3, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.measurement.zzir r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            zzJ(r30)
            sun.misc.Unsafe r9 = zzb
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r7 = r10
            r2 = r16
            r6 = r2
        L_0x001c:
            if (r0 >= r13) goto L_0x032e
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.android.gms.internal.measurement.zzis.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0031
        L_0x002e:
            r17 = r0
            r4 = r3
        L_0x0031:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003e
            int r2 = r2 / 3
            int r0 = r15.zzx(r5, r2)
            goto L_0x0042
        L_0x003e:
            int r0 = r15.zzw(r5)
        L_0x0042:
            r2 = r0
            if (r2 != r8) goto L_0x0050
            r2 = r4
            r23 = r5
            r18 = r8
            r28 = r9
            r19 = r16
            goto L_0x0307
        L_0x0050:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = zzA(r1)
            r8 = r1 & r10
            long r10 = (long) r8
            r8 = 17
            r32 = r5
            if (r13 > r8) goto L_0x0217
            int r8 = r2 + 2
            r0 = r0[r8]
            int r8 = r0 >>> 20
            r5 = 1
            int r8 = r5 << r8
            r21 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r10
            if (r0 == r7) goto L_0x0085
            if (r7 == r10) goto L_0x007d
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x007d:
            if (r0 == r10) goto L_0x0084
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x0084:
            r7 = r0
        L_0x0085:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x01ed;
                case 1: goto L_0x01d3;
                case 2: goto L_0x01a8;
                case 3: goto L_0x01a8;
                case 4: goto L_0x0191;
                case 5: goto L_0x0172;
                case 6: goto L_0x015c;
                case 7: goto L_0x0137;
                case 8: goto L_0x0116;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00db;
                case 11: goto L_0x0191;
                case 12: goto L_0x00c8;
                case 13: goto L_0x015c;
                case 14: goto L_0x0172;
                case 15: goto L_0x00b1;
                case 16: goto L_0x0093;
                default: goto L_0x0089;
            }
        L_0x0089:
            r23 = r32
            r11 = r34
            r10 = r2
        L_0x008e:
            r13 = r4
            r32 = r6
            goto L_0x020c
        L_0x0093:
            if (r3 != 0) goto L_0x0089
            r11 = r34
            r0 = r21
            int r13 = com.google.android.gms.internal.measurement.zzis.zzm(r12, r4, r11)
            long r3 = r11.zzb
            long r4 = com.google.android.gms.internal.measurement.zzji.zzc(r3)
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r21
            r23 = r32
            r0.putLong(r1, r2, r4)
            r6 = r6 | r8
            goto L_0x01c7
        L_0x00b1:
            r23 = r32
            r11 = r34
            r10 = r2
            if (r3 != 0) goto L_0x008e
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzji.zzb(r1)
            r2 = r21
            r9.putInt(r14, r2, r1)
            goto L_0x0113
        L_0x00c8:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r21
            if (r3 != 0) goto L_0x008e
            int r2 = com.google.android.gms.internal.measurement.zzis.zzj(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x00ee
        L_0x00db:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r21
            r2 = 2
            if (r3 != r2) goto L_0x008e
            int r2 = com.google.android.gms.internal.measurement.zzis.zza(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x00ee:
            r6 = r6 | r8
            r13 = r33
            r0 = r2
            goto L_0x0257
        L_0x00f4:
            r23 = r32
            r11 = r34
            r10 = r2
            r2 = 2
            if (r3 != r2) goto L_0x008e
            java.lang.Object r13 = r15.zzG(r14, r10)
            com.google.android.gms.internal.measurement.zzlx r1 = r15.zzE(r10)
            r0 = r13
            r2 = r31
            r3 = r4
            r4 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r10, r13)
        L_0x0113:
            r6 = r6 | r8
            goto L_0x0209
        L_0x0116:
            r23 = r32
            r11 = r34
            r10 = r2
            r32 = r6
            r5 = r21
            r0 = 2
            if (r3 != r0) goto L_0x018e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x012c
            int r0 = com.google.android.gms.internal.measurement.zzis.zzg(r12, r4, r11)
            goto L_0x0130
        L_0x012c:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzh(r12, r4, r11)
        L_0x0130:
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r5, r1)
            goto L_0x0207
        L_0x0137:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r5
            r32 = r6
            r5 = r21
            if (r3 != 0) goto L_0x018e
            int r1 = com.google.android.gms.internal.measurement.zzis.zzm(r12, r4, r11)
            long r2 = r11.zzb
            r20 = 0
            int r2 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r2 == 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r0 = r16
        L_0x0152:
            com.google.android.gms.internal.measurement.zzmy.zzm(r14, r5, r0)
            r6 = r32 | r8
            r13 = r33
            r0 = r1
            goto L_0x0257
        L_0x015c:
            r23 = r32
            r11 = r34
            r10 = r2
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x018e
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r12, r4)
            r9.putInt(r14, r5, r0)
            int r0 = r4 + 4
            goto L_0x0207
        L_0x0172:
            r23 = r32
            r11 = r34
            r10 = r2
            r0 = r5
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x018e
            long r20 = com.google.android.gms.internal.measurement.zzis.zzp(r12, r4)
            r0 = r9
            r1 = r30
            r2 = r5
            r13 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            goto L_0x0205
        L_0x018e:
            r13 = r4
            goto L_0x020c
        L_0x0191:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r32 = r6
            r5 = r21
            if (r3 != 0) goto L_0x020c
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r12, r13, r11)
            int r1 = r11.zza
            r9.putInt(r14, r5, r1)
            goto L_0x0207
        L_0x01a8:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r32 = r6
            r5 = r21
            if (r3 != 0) goto L_0x020c
            int r13 = com.google.android.gms.internal.measurement.zzis.zzm(r12, r13, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r20 = r2
            r2 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            r6 = r32 | r8
        L_0x01c7:
            r2 = r10
            r0 = r13
            r1 = r23
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r33
            goto L_0x001c
        L_0x01d3:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x020c
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmy.zzp(r14, r5, r0)
            int r0 = r13 + 4
            goto L_0x0207
        L_0x01ed:
            r23 = r32
            r11 = r34
            r10 = r2
            r13 = r4
            r0 = r5
            r32 = r6
            r5 = r21
            if (r3 != r0) goto L_0x020c
            long r0 = com.google.android.gms.internal.measurement.zzis.zzp(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmy.zzo(r14, r5, r0)
        L_0x0205:
            int r0 = r13 + 8
        L_0x0207:
            r6 = r32 | r8
        L_0x0209:
            r13 = r33
            goto L_0x0257
        L_0x020c:
            r6 = r32
            r28 = r9
            r19 = r10
            r2 = r13
            r18 = -1
            goto L_0x0307
        L_0x0217:
            r23 = r32
            r8 = r6
            r5 = r10
            r11 = r34
            r10 = r2
            r0 = 27
            if (r13 != r0) goto L_0x026a
            r0 = 2
            if (r3 != r0) goto L_0x025d
            java.lang.Object r0 = r9.getObject(r14, r5)
            com.google.android.gms.internal.measurement.zzkm r0 = (com.google.android.gms.internal.measurement.zzkm) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0242
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023a
            r1 = 10
            goto L_0x023b
        L_0x023a:
            int r1 = r1 + r1
        L_0x023b:
            com.google.android.gms.internal.measurement.zzkm r0 = r0.zzd(r1)
            r9.putObject(r14, r5, r0)
        L_0x0242:
            r5 = r0
            com.google.android.gms.internal.measurement.zzlx r0 = r15.zzE(r10)
            r1 = r17
            r2 = r31
            r3 = r4
            r4 = r33
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r33
            r6 = r8
        L_0x0257:
            r2 = r10
            r1 = r23
            r8 = -1
            goto L_0x0329
        L_0x025d:
            r15 = r4
            r26 = r7
            r27 = r8
            r28 = r9
            r19 = r10
            r18 = -1
            goto L_0x02e3
        L_0x026a:
            r0 = 49
            if (r13 > r0) goto L_0x02b5
            long r1 = (long) r1
            r0 = r29
            r20 = r1
            r1 = r30
            r2 = r31
            r32 = r3
            r3 = r4
            r15 = r4
            r4 = r33
            r24 = r5
            r5 = r17
            r6 = r23
            r26 = r7
            r7 = r32
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r19 = r10
            r9 = r20
            r11 = r13
            r12 = r24
            r14 = r34
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02b3
        L_0x029d:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r2 = r19
            r1 = r23
            r7 = r26
            r6 = r27
            goto L_0x0327
        L_0x02b3:
            r2 = r0
            goto L_0x02e4
        L_0x02b5:
            r32 = r3
            r15 = r4
            r24 = r5
            r26 = r7
            r27 = r8
            r28 = r9
            r19 = r10
            r18 = -1
            r0 = 50
            if (r13 != r0) goto L_0x02e9
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x02e3
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r24
            r8 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02b3
            goto L_0x029d
        L_0x02e3:
            r2 = r15
        L_0x02e4:
            r7 = r26
            r6 = r27
            goto L_0x0307
        L_0x02e9:
            r7 = r32
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r23
            r9 = r13
            r10 = r24
            r12 = r19
            r13 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02b3
            goto L_0x029d
        L_0x0307:
            com.google.android.gms.internal.measurement.zzmp r4 = zzd(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzis.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r2 = r19
            r1 = r23
        L_0x0327:
            r9 = r28
        L_0x0329:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x001c
        L_0x032e:
            r27 = r6
            r28 = r9
            r1 = r10
            if (r7 == r1) goto L_0x033f
            long r1 = (long) r7
            r3 = r30
            r6 = r27
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x033f:
            r1 = r33
            if (r0 != r1) goto L_0x0344
            return r0
        L_0x0344:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0455 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c8  */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzir r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkm r12 = (com.google.android.gms.internal.measurement.zzkm) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.measurement.zzkm r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x0395;
                case 20: goto L_0x0352;
                case 21: goto L_0x0352;
                case 22: goto L_0x0337;
                case 23: goto L_0x02f4;
                case 24: goto L_0x02b1;
                case 25: goto L_0x0257;
                case 26: goto L_0x01a0;
                case 27: goto L_0x0185;
                case 28: goto L_0x012b;
                case 29: goto L_0x0337;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b1;
                case 32: goto L_0x02f4;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e4;
                case 36: goto L_0x0395;
                case 37: goto L_0x0352;
                case 38: goto L_0x0352;
                case 39: goto L_0x0337;
                case 40: goto L_0x02f4;
                case 41: goto L_0x02b1;
                case 42: goto L_0x0257;
                case 43: goto L_0x0337;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b1;
                case 46: goto L_0x02f4;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x0454
            com.google.android.gms.internal.measurement.zzlx r0 = r15.zzE(r8)
            r1 = r2 & -8
            r1 = r1 | 4
            r21 = r0
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r1
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzis.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r6 = r7.zzc
            r12.add(r6)
            goto L_0x0432
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.measurement.zzlb r12 = (com.google.android.gms.internal.measurement.zzlb) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x0067:
            if (r0 >= r1) goto L_0x0077
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r0, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzji.zzc(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r0 != r1) goto L_0x007b
            goto L_0x0455
        L_0x007b:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0080:
            if (r6 != 0) goto L_0x0454
            com.google.android.gms.internal.measurement.zzlb r12 = (com.google.android.gms.internal.measurement.zzlb) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzji.zzc(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r0 >= r5) goto L_0x00aa
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r1, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzji.zzc(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r0
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzkg r12 = (com.google.android.gms.internal.measurement.zzkg) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x00b6:
            if (r0 >= r1) goto L_0x00c6
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r2 = r7.zza
            int r2 = com.google.android.gms.internal.measurement.zzji.zzb(r2)
            r12.zzh(r2)
            goto L_0x00b6
        L_0x00c6:
            if (r0 != r1) goto L_0x00ca
            goto L_0x0455
        L_0x00ca:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x00cf:
            if (r6 != 0) goto L_0x0454
            com.google.android.gms.internal.measurement.zzkg r12 = (com.google.android.gms.internal.measurement.zzkg) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = com.google.android.gms.internal.measurement.zzji.zzb(r1)
            r12.zzh(r1)
        L_0x00e0:
            if (r0 >= r5) goto L_0x00f9
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r1, r7)
            int r1 = r7.zza
            int r1 = com.google.android.gms.internal.measurement.zzji.zzb(r1)
            r12.zzh(r1)
            goto L_0x00e0
        L_0x00f9:
            return r0
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzis.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x0454
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzis.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzkj r3 = r15.zzD(r8)
            r4 = 0
            com.google.android.gms.internal.measurement.zzmo r0 = r0.zzn
            r15 = r16
            r16 = r21
            r17 = r12
            r18 = r3
            r19 = r4
            r20 = r0
            com.google.android.gms.internal.measurement.zzlz.zzC(r15, r16, r17, r18, r19, r20)
            r0 = r2
            goto L_0x0455
        L_0x012b:
            if (r6 != r14) goto L_0x0454
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            if (r1 < 0) goto L_0x0180
            int r4 = r3.length
            int r4 = r4 - r0
            if (r1 > r4) goto L_0x017b
            if (r1 != 0) goto L_0x0141
            com.google.android.gms.internal.measurement.zzje r1 = com.google.android.gms.internal.measurement.zzje.zzb
            r12.add(r1)
            goto L_0x0149
        L_0x0141:
            com.google.android.gms.internal.measurement.zzje r4 = com.google.android.gms.internal.measurement.zzje.zzl(r3, r0, r1)
            r12.add(r4)
        L_0x0148:
            int r0 = r0 + r1
        L_0x0149:
            if (r0 >= r5) goto L_0x017a
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x0154
            goto L_0x017a
        L_0x0154:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r1, r7)
            int r1 = r7.zza
            if (r1 < 0) goto L_0x0175
            int r4 = r3.length
            int r4 = r4 - r0
            if (r1 > r4) goto L_0x0170
            if (r1 != 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzje r1 = com.google.android.gms.internal.measurement.zzje.zzb
            r12.add(r1)
            goto L_0x0149
        L_0x0168:
            com.google.android.gms.internal.measurement.zzje r4 = com.google.android.gms.internal.measurement.zzje.zzl(r3, r0, r1)
            r12.add(r4)
            goto L_0x0148
        L_0x0170:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0175:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r0
        L_0x017a:
            return r0
        L_0x017b:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0180:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r0
        L_0x0185:
            if (r6 == r14) goto L_0x0189
            goto L_0x0454
        L_0x0189:
            com.google.android.gms.internal.measurement.zzlx r0 = r15.zzE(r8)
            r21 = r0
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r0 = com.google.android.gms.internal.measurement.zzis.zze(r21, r22, r23, r24, r25, r26, r27)
            return r0
        L_0x01a0:
            if (r6 != r14) goto L_0x0454
            r0 = 536870912(0x20000000, double:2.652494739E-315)
            long r0 = r24 & r0
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x01f3
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01ee
            if (r4 != 0) goto L_0x01bb
            r12.add(r1)
            goto L_0x01c6
        L_0x01bb:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.measurement.zzkn.zzb
            r6.<init>(r3, r0, r4, r8)
            r12.add(r6)
        L_0x01c5:
            int r0 = r0 + r4
        L_0x01c6:
            if (r0 >= r5) goto L_0x0455
            int r4 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0455
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01e9
            if (r4 != 0) goto L_0x01de
            r12.add(r1)
            goto L_0x01c6
        L_0x01de:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.measurement.zzkn.zzb
            r6.<init>(r3, r0, r4, r8)
            r12.add(r6)
            goto L_0x01c5
        L_0x01e9:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r0
        L_0x01ee:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r0
        L_0x01f3:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0252
            if (r4 != 0) goto L_0x0202
            r12.add(r1)
            r6 = r0
            goto L_0x0214
        L_0x0202:
            int r6 = r0 + r4
            boolean r8 = com.google.android.gms.internal.measurement.zznd.zzf(r3, r0, r6)
            if (r8 == 0) goto L_0x024d
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkn.zzb
            r8.<init>(r3, r0, r4, r9)
            r12.add(r8)
        L_0x0214:
            if (r6 >= r5) goto L_0x024a
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r6, r7)
            int r4 = r7.zza
            if (r2 != r4) goto L_0x024a
            int r6 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r0 = r7.zza
            if (r0 < 0) goto L_0x0245
            if (r0 != 0) goto L_0x022c
            r12.add(r1)
            goto L_0x0214
        L_0x022c:
            int r4 = r6 + r0
            boolean r8 = com.google.android.gms.internal.measurement.zznd.zzf(r3, r6, r4)
            if (r8 == 0) goto L_0x0240
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkn.zzb
            r8.<init>(r3, r6, r0, r9)
            r12.add(r8)
            r6 = r4
            goto L_0x0214
        L_0x0240:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzc()
            throw r0
        L_0x0245:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r0
        L_0x024a:
            r0 = r6
            goto L_0x0455
        L_0x024d:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzc()
            throw r0
        L_0x0252:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzd()
            throw r0
        L_0x0257:
            r0 = 0
            if (r6 != r14) goto L_0x0280
            com.google.android.gms.internal.measurement.zzit r12 = (com.google.android.gms.internal.measurement.zzit) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0263:
            if (r1 >= r2) goto L_0x0276
            int r1 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r1, r7)
            long r4 = r7.zzb
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0271
            r4 = r13
            goto L_0x0272
        L_0x0271:
            r4 = r0
        L_0x0272:
            r12.zze(r4)
            goto L_0x0263
        L_0x0276:
            if (r1 != r2) goto L_0x027b
            r0 = r1
            goto L_0x0455
        L_0x027b:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0280:
            if (r6 != 0) goto L_0x0454
            com.google.android.gms.internal.measurement.zzit r12 = (com.google.android.gms.internal.measurement.zzit) r12
            int r1 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0290
            r4 = r13
            goto L_0x0291
        L_0x0290:
            r4 = r0
        L_0x0291:
            r12.zze(r4)
        L_0x0294:
            if (r1 >= r5) goto L_0x02b0
            int r4 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x029f
            goto L_0x02b0
        L_0x029f:
            int r1 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x02ab
            r4 = r13
            goto L_0x02ac
        L_0x02ab:
            r4 = r0
        L_0x02ac:
            r12.zze(r4)
            goto L_0x0294
        L_0x02b0:
            return r1
        L_0x02b1:
            if (r6 != r14) goto L_0x02d1
            com.google.android.gms.internal.measurement.zzkg r12 = (com.google.android.gms.internal.measurement.zzkg) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x02bc:
            if (r0 >= r1) goto L_0x02c8
            int r2 = com.google.android.gms.internal.measurement.zzis.zzb(r3, r0)
            r12.zzh(r2)
            int r0 = r0 + 4
            goto L_0x02bc
        L_0x02c8:
            if (r0 != r1) goto L_0x02cc
            goto L_0x0455
        L_0x02cc:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x02d1:
            if (r6 != r9) goto L_0x0454
            com.google.android.gms.internal.measurement.zzkg r12 = (com.google.android.gms.internal.measurement.zzkg) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r17, r18)
            r12.zzh(r0)
            int r0 = r4 + 4
        L_0x02de:
            if (r0 >= r5) goto L_0x02f3
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x02e9
            goto L_0x02f3
        L_0x02e9:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r3, r1)
            r12.zzh(r0)
            int r0 = r1 + 4
            goto L_0x02de
        L_0x02f3:
            return r0
        L_0x02f4:
            if (r6 != r14) goto L_0x0314
            com.google.android.gms.internal.measurement.zzlb r12 = (com.google.android.gms.internal.measurement.zzlb) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x02ff:
            if (r0 >= r1) goto L_0x030b
            long r4 = com.google.android.gms.internal.measurement.zzis.zzp(r3, r0)
            r12.zzg(r4)
            int r0 = r0 + 8
            goto L_0x02ff
        L_0x030b:
            if (r0 != r1) goto L_0x030f
            goto L_0x0455
        L_0x030f:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0314:
            if (r6 != r13) goto L_0x0454
            com.google.android.gms.internal.measurement.zzlb r12 = (com.google.android.gms.internal.measurement.zzlb) r12
            long r0 = com.google.android.gms.internal.measurement.zzis.zzp(r17, r18)
            r12.zzg(r0)
            int r0 = r4 + 8
        L_0x0321:
            if (r0 >= r5) goto L_0x0336
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x032c
            goto L_0x0336
        L_0x032c:
            long r8 = com.google.android.gms.internal.measurement.zzis.zzp(r3, r1)
            r12.zzg(r8)
            int r0 = r1 + 8
            goto L_0x0321
        L_0x0336:
            return r0
        L_0x0337:
            if (r6 != r14) goto L_0x033f
            int r0 = com.google.android.gms.internal.measurement.zzis.zzf(r3, r4, r12, r7)
            goto L_0x0455
        L_0x033f:
            if (r6 == 0) goto L_0x0343
            goto L_0x0454
        L_0x0343:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r0 = com.google.android.gms.internal.measurement.zzis.zzl(r20, r21, r22, r23, r24, r25)
            return r0
        L_0x0352:
            if (r6 != r14) goto L_0x0372
            com.google.android.gms.internal.measurement.zzlb r12 = (com.google.android.gms.internal.measurement.zzlb) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x035d:
            if (r0 >= r1) goto L_0x0369
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r0, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035d
        L_0x0369:
            if (r0 != r1) goto L_0x036d
            goto L_0x0455
        L_0x036d:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0372:
            if (r6 != 0) goto L_0x0454
            com.google.android.gms.internal.measurement.zzlb r12 = (com.google.android.gms.internal.measurement.zzlb) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037f:
            if (r0 >= r5) goto L_0x0394
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x038a
            goto L_0x0394
        L_0x038a:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r3, r1, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037f
        L_0x0394:
            return r0
        L_0x0395:
            if (r6 != r14) goto L_0x03b9
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x03a0:
            if (r0 >= r1) goto L_0x03b0
            int r2 = com.google.android.gms.internal.measurement.zzis.zzb(r3, r0)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r12.zze(r2)
            int r0 = r0 + 4
            goto L_0x03a0
        L_0x03b0:
            if (r0 != r1) goto L_0x03b4
            goto L_0x0455
        L_0x03b4:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x03b9:
            if (r6 != r9) goto L_0x0454
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r17, r18)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r12.zze(r0)
            int r0 = r4 + 4
        L_0x03ca:
            if (r0 >= r5) goto L_0x03e3
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x03d5
            goto L_0x03e3
        L_0x03d5:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r3, r1)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r12.zze(r0)
            int r0 = r1 + 4
            goto L_0x03ca
        L_0x03e3:
            return r0
        L_0x03e4:
            if (r6 != r14) goto L_0x0407
            com.google.android.gms.internal.measurement.zzjo r12 = (com.google.android.gms.internal.measurement.zzjo) r12
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r1 = r7.zza
            int r1 = r1 + r0
        L_0x03ef:
            if (r0 >= r1) goto L_0x03ff
            long r4 = com.google.android.gms.internal.measurement.zzis.zzp(r3, r0)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r0 = r0 + 8
            goto L_0x03ef
        L_0x03ff:
            if (r0 != r1) goto L_0x0402
            goto L_0x0455
        L_0x0402:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L_0x0407:
            if (r6 != r13) goto L_0x0454
            com.google.android.gms.internal.measurement.zzjo r12 = (com.google.android.gms.internal.measurement.zzjo) r12
            long r0 = com.google.android.gms.internal.measurement.zzis.zzp(r17, r18)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            r12.zze(r0)
            int r0 = r4 + 8
        L_0x0418:
            if (r0 >= r5) goto L_0x0431
            int r1 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r0, r7)
            int r4 = r7.zza
            if (r2 == r4) goto L_0x0423
            goto L_0x0431
        L_0x0423:
            long r8 = com.google.android.gms.internal.measurement.zzis.zzp(r3, r1)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            int r0 = r1 + 8
            goto L_0x0418
        L_0x0431:
            return r0
        L_0x0432:
            if (r4 >= r5) goto L_0x0453
            int r6 = com.google.android.gms.internal.measurement.zzis.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x043d
            goto L_0x0453
        L_0x043d:
            r21 = r0
            r22 = r17
            r23 = r6
            r24 = r19
            r25 = r1
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzis.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r6 = r7.zzc
            r12.add(r6)
            goto L_0x0432
        L_0x0453:
            return r4
        L_0x0454:
            r0 = r4
        L_0x0455:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzir):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzB(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzA(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzY(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzo(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzX(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmy.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmy.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmy.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmy.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmy.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzmy.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmy.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmy.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzmy.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzmy.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkn.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzmo r0 = r8.zzn
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjs r8 = r8.zzo
            r8.zza(r9)
            r8 = 0
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0345, code lost:
        if (r0 != r15) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0361, code lost:
        r7 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x038a, code lost:
        if (r0 != r15) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b0, code lost:
        if (r0 != r15) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0195, code lost:
        r5 = r26 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0197, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x019a, code lost:
        r6 = r1;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ff, code lost:
        r5 = r26 | r24;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0202, code lost:
        r2 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0206, code lost:
        r8 = r6;
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x029d, code lost:
        r0 = r6 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x029f, code lost:
        r5 = r26 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02a1, code lost:
        r2 = r11;
        r3 = r13;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02a7, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02a9, code lost:
        r7 = r34;
        r2 = r6;
        r28 = r10;
        r32 = r11;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzir r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            zzJ(r30)
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            r17 = 0
            if (r0 >= r13) goto L_0x041d
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.zzis.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x0031
        L_0x0030:
            r4 = r0
        L_0x0031:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x003e
            int r3 = r3 / r7
            int r2 = r15.zzx(r0, r3)
            goto L_0x0042
        L_0x003e:
            int r2 = r15.zzw(r0)
        L_0x0042:
            r3 = -1
            if (r2 != r3) goto L_0x0054
            r32 = r0
            r2 = r1
            r20 = r3
            r8 = r4
            r26 = r5
            r28 = r10
            r7 = r11
            r19 = r16
            goto L_0x03b3
        L_0x0054:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r7 = r3[r20]
            int r11 = zzA(r7)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r18
            r21 = r1
            long r0 = (long) r0
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02b4
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x008f
            r18 = r4
            if (r6 == r3) goto L_0x0085
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0085:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r27 = r0
            r26 = r5
            goto L_0x0095
        L_0x008f:
            r18 = r4
            r26 = r5
            r27 = r6
        L_0x0095:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0284;
                case 1: goto L_0x0268;
                case 2: goto L_0x0248;
                case 3: goto L_0x0248;
                case 4: goto L_0x0230;
                case 5: goto L_0x020a;
                case 6: goto L_0x01e6;
                case 7: goto L_0x01c3;
                case 8: goto L_0x019e;
                case 9: goto L_0x016d;
                case 10: goto L_0x0152;
                case 11: goto L_0x0230;
                case 12: goto L_0x011b;
                case 13: goto L_0x01e6;
                case 14: goto L_0x020a;
                case 15: goto L_0x00fc;
                case 16: goto L_0x00c8;
                default: goto L_0x0099;
            }
        L_0x0099:
            r13 = r2
            r11 = r20
            r6 = r21
            r0 = 3
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02a7
            java.lang.Object r7 = r15.zzG(r14, r13)
            com.google.android.gms.internal.measurement.zzlx r1 = r15.zzE(r13)
            int r0 = r11 << 3
            r5 = r0 | 4
            r0 = r7
            r2 = r31
            r3 = r6
            r4 = r33
            r8 = r18
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzis.zzn(r0, r1, r2, r3, r4, r5, r6)
            r15.zzO(r14, r13, r7)
            r5 = r26 | r24
            r1 = r8
            goto L_0x0202
        L_0x00c8:
            if (r8 != 0) goto L_0x00ee
            r1 = r21
            int r6 = com.google.android.gms.internal.measurement.zzis.zzm(r12, r1, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.measurement.zzji.zzc(r0)
            r11 = r20
            r7 = r22
            r0 = r10
            r1 = r30
            r13 = r2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r2 = r7
            r7 = r18
            r0.putLong(r1, r2, r4)
            r5 = r26 | r24
            r0 = r6
            goto L_0x0197
        L_0x00ee:
            r13 = r2
            r11 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r8 = r18
            r6 = r21
            goto L_0x02a9
        L_0x00fc:
            r13 = r2
            r7 = r18
            r11 = r20
            r1 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x019a
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzji.zzb(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0195
        L_0x011b:
            r13 = r2
            r7 = r18
            r11 = r20
            r1 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x019a
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzkj r2 = r15.zzD(r13)
            if (r2 == 0) goto L_0x014e
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x013e
            goto L_0x014e
        L_0x013e:
            com.google.android.gms.internal.measurement.zzmp r2 = zzd(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzj(r7, r1)
            r1 = r7
            r2 = r11
            goto L_0x02ff
        L_0x014e:
            r10.putInt(r14, r3, r1)
            goto L_0x0195
        L_0x0152:
            r13 = r2
            r7 = r18
            r11 = r20
            r1 = r21
            r3 = r22
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x019a
            int r0 = com.google.android.gms.internal.measurement.zzis.zza(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0195
        L_0x016d:
            r13 = r2
            r7 = r18
            r11 = r20
            r1 = r21
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x019a
            java.lang.Object r6 = r15.zzG(r14, r13)
            com.google.android.gms.internal.measurement.zzlx r2 = r15.zzE(r13)
            r0 = r6
            r5 = r1
            r1 = r2
            r2 = r31
            r3 = r5
            r4 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzis.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r13, r6)
        L_0x0195:
            r5 = r26 | r24
        L_0x0197:
            r1 = r7
            goto L_0x0202
        L_0x019a:
            r6 = r1
            r8 = r7
            goto L_0x02a9
        L_0x019e:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0206
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r7
            if (r0 != 0) goto L_0x01b9
            int r0 = com.google.android.gms.internal.measurement.zzis.zzg(r12, r5, r9)
            goto L_0x01bd
        L_0x01b9:
            int r0 = com.google.android.gms.internal.measurement.zzis.zzh(r12, r5, r9)
        L_0x01bd:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01ff
        L_0x01c3:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0206
            int r0 = com.google.android.gms.internal.measurement.zzis.zzm(r12, r5, r9)
            long r7 = r9.zzb
            r17 = 0
            int r2 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x01e0
            goto L_0x01e2
        L_0x01e0:
            r1 = r16
        L_0x01e2:
            com.google.android.gms.internal.measurement.zzmy.zzm(r14, r3, r1)
            goto L_0x01ff
        L_0x01e6:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0206
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r12, r5)
            r10.putInt(r14, r3, r0)
            int r0 = r5 + 4
        L_0x01ff:
            r5 = r26 | r24
            r1 = r6
        L_0x0202:
            r2 = r11
            r3 = r13
            goto L_0x0302
        L_0x0206:
            r8 = r6
            r6 = r5
            goto L_0x02a9
        L_0x020a:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r1) goto L_0x022b
            long r7 = com.google.android.gms.internal.measurement.zzis.zzp(r12, r5)
            r0 = r10
            r1 = r30
            r2 = r3
            r18 = r6
            r6 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x029d
        L_0x022b:
            r18 = r6
            r6 = r5
            goto L_0x02a7
        L_0x0230:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x02a7
            int r0 = com.google.android.gms.internal.measurement.zzis.zzj(r12, r6, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x029f
        L_0x0248:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x02a7
            int r6 = com.google.android.gms.internal.measurement.zzis.zzm(r12, r6, r9)
            long r7 = r9.zzb
            r0 = r10
            r1 = r30
            r2 = r3
            r4 = r7
            r0.putLong(r1, r2, r4)
            r5 = r26 | r24
            r0 = r6
            goto L_0x02a1
        L_0x0268:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02a7
            int r0 = com.google.android.gms.internal.measurement.zzis.zzb(r12, r6)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmy.zzp(r14, r3, r0)
            int r0 = r6 + 4
            goto L_0x029f
        L_0x0284:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r1) goto L_0x02a7
            long r0 = com.google.android.gms.internal.measurement.zzis.zzp(r12, r6)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmy.zzo(r14, r3, r0)
        L_0x029d:
            int r0 = r6 + 8
        L_0x029f:
            r5 = r26 | r24
        L_0x02a1:
            r2 = r11
            r3 = r13
            r1 = r18
            goto L_0x0302
        L_0x02a7:
            r8 = r18
        L_0x02a9:
            r7 = r34
            r2 = r6
            r28 = r10
            r32 = r11
            r19 = r13
            goto L_0x0392
        L_0x02b4:
            r13 = r2
            r2 = r4
            r27 = r6
            r1 = r20
            r6 = r21
            r3 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r0 = 27
            if (r11 != r0) goto L_0x0317
            r0 = 2
            if (r8 != r0) goto L_0x030a
            java.lang.Object r0 = r10.getObject(r14, r3)
            com.google.android.gms.internal.measurement.zzkm r0 = (com.google.android.gms.internal.measurement.zzkm) r0
            boolean r7 = r0.zzc()
            if (r7 != 0) goto L_0x02e7
            int r7 = r0.size()
            if (r7 != 0) goto L_0x02df
            r7 = 10
            goto L_0x02e0
        L_0x02df:
            int r7 = r7 + r7
        L_0x02e0:
            com.google.android.gms.internal.measurement.zzkm r0 = r0.zzd(r7)
            r10.putObject(r14, r3, r0)
        L_0x02e7:
            r7 = r0
            com.google.android.gms.internal.measurement.zzlx r0 = r15.zzE(r13)
            r8 = r1
            r1 = r2
            r11 = r2
            r2 = r31
            r3 = r6
            r4 = r33
            r26 = r5
            r5 = r7
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzis.zze(r0, r1, r2, r3, r4, r5, r6)
            r2 = r8
            r1 = r11
        L_0x02ff:
            r3 = r13
            r5 = r26
        L_0x0302:
            r6 = r27
            r13 = r33
            r11 = r34
            goto L_0x001d
        L_0x030a:
            r26 = r5
            r32 = r1
            r18 = r2
            r15 = r6
            r28 = r10
            r19 = r13
            goto L_0x038d
        L_0x0317:
            r26 = r5
            r5 = r1
            r0 = 49
            if (r11 > r0) goto L_0x0365
            long r0 = (long) r7
            r21 = r0
            r0 = r29
            r1 = r30
            r7 = r2
            r2 = r31
            r24 = r3
            r3 = r6
            r4 = r33
            r32 = r5
            r5 = r7
            r15 = r6
            r6 = r32
            r18 = r7
            r7 = r8
            r8 = r13
            r28 = r10
            r9 = r21
            r19 = r13
            r12 = r24
            r14 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0361
        L_0x0347:
            r15 = r29
            r14 = r30
            r12 = r31
            r2 = r32
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r18
            r3 = r19
            r5 = r26
            r6 = r27
            r10 = r28
            goto L_0x001d
        L_0x0361:
            r7 = r34
            r2 = r0
            goto L_0x0390
        L_0x0365:
            r18 = r2
            r24 = r3
            r32 = r5
            r15 = r6
            r28 = r10
            r19 = r13
            r0 = 50
            if (r11 != r0) goto L_0x0395
            r0 = 2
            if (r8 != r0) goto L_0x038d
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r24
            r8 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0361
            goto L_0x0347
        L_0x038d:
            r7 = r34
            r2 = r15
        L_0x0390:
            r8 = r18
        L_0x0392:
            r6 = r27
            goto L_0x03b3
        L_0x0395:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r32
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r24
            r12 = r19
            r13 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0361
            goto L_0x0347
        L_0x03b3:
            if (r8 != r7) goto L_0x03c1
            if (r7 == 0) goto L_0x03c1
            r9 = r29
            r12 = r30
            r0 = r2
            r1 = r8
            r5 = r26
            goto L_0x0426
        L_0x03c1:
            r9 = r29
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x03f6
            r10 = r35
            com.google.android.gms.internal.measurement.zzjr r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzjr r1 = com.google.android.gms.internal.measurement.zzjr.zza
            if (r0 == r1) goto L_0x03f1
            com.google.android.gms.internal.measurement.zzlm r1 = r9.zzg
            r11 = r32
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x03eb
            com.google.android.gms.internal.measurement.zzmp r4 = zzd(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzis.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r30
            goto L_0x040b
        L_0x03eb:
            r12 = r30
            r0 = r12
            com.google.android.gms.internal.measurement.zzkc r0 = (com.google.android.gms.internal.measurement.zzkc) r0
            throw r17
        L_0x03f1:
            r12 = r30
            r11 = r32
            goto L_0x03fc
        L_0x03f6:
            r12 = r30
            r11 = r32
            r10 = r35
        L_0x03fc:
            com.google.android.gms.internal.measurement.zzmp r4 = zzd(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzis.zzi(r0, r1, r2, r3, r4, r5)
        L_0x040b:
            r13 = r33
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r3 = r19
            r5 = r26
            r10 = r28
            r12 = r31
            r11 = r7
            goto L_0x001d
        L_0x041d:
            r26 = r5
            r27 = r6
            r28 = r10
            r7 = r11
            r12 = r14
            r9 = r15
        L_0x0426:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x0431
            long r3 = (long) r6
            r6 = r28
            r6.putInt(r12, r3, r5)
        L_0x0431:
            int r3 = r9.zzk
        L_0x0433:
            int r4 = r9.zzl
            if (r3 >= r4) goto L_0x045e
            int[] r4 = r9.zzj
            r4 = r4[r3]
            int[] r5 = r9.zzc
            r5 = r5[r4]
            int r5 = r9.zzB(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzmy.zzf(r12, r5)
            if (r5 != 0) goto L_0x044c
            goto L_0x0452
        L_0x044c:
            com.google.android.gms.internal.measurement.zzkj r6 = r9.zzD(r4)
            if (r6 != 0) goto L_0x0455
        L_0x0452:
            int r3 = r3 + 1
            goto L_0x0433
        L_0x0455:
            com.google.android.gms.internal.measurement.zzlg r5 = (com.google.android.gms.internal.measurement.zzlg) r5
            java.lang.Object r0 = r9.zzF(r4)
            com.google.android.gms.internal.measurement.zzlf r0 = (com.google.android.gms.internal.measurement.zzlf) r0
            throw r17
        L_0x045e:
            if (r7 != 0) goto L_0x046a
            r2 = r33
            if (r0 != r2) goto L_0x0465
            goto L_0x0470
        L_0x0465:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zze()
            throw r0
        L_0x046a:
            r2 = r33
            if (r0 > r2) goto L_0x0471
            if (r1 != r7) goto L_0x0471
        L_0x0470:
            return r0
        L_0x0471:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    public final Object zze() {
        return ((zzkf) this.zzg).zzbA();
    }

    public final void zzf(Object obj) {
        if (zzW(obj)) {
            if (obj instanceof zzkf) {
                zzkf zzkf = (zzkf) obj;
                zzkf.zzbM(Integer.MAX_VALUE);
                zzkf.zzb = 0;
                zzkf.zzbK();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                long j = (long) (1048575 & zzB);
                int zzA = zzA(zzB);
                if (zzA != 9) {
                    switch (zzA) {
                        case 17:
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                        case 30:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_WIDTH_DEFAULT:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                            this.zzm.zza(obj, j);
                            continue;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j);
                            if (object != null) {
                                ((zzlg) object).zzc();
                                unsafe.putObject(obj, j, object);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                if (zzT(obj, i)) {
                    zzE(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzg(obj);
            if (this.zzh) {
                this.zzo.zzb(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzJ(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (1048575 & zzB);
            int i2 = this.zzc[i];
            switch (zzA(zzB)) {
                case 0:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzo(obj, j, zzmy.zza(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 1:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzp(obj, j, zzmy.zzb(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 2:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzr(obj, j, zzmy.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 3:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzr(obj, j, zzmy.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 4:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzq(obj, j, zzmy.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 5:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzr(obj, j, zzmy.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 6:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzq(obj, j, zzmy.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 7:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzm(obj, j, zzmy.zzw(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 8:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzs(obj, j, zzmy.zzf(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 9:
                    zzK(obj, obj2, i);
                    break;
                case 10:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzs(obj, j, zzmy.zzf(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 11:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzq(obj, j, zzmy.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 12:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzq(obj, j, zzmy.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 13:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzq(obj, j, zzmy.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 14:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzr(obj, j, zzmy.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 15:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzq(obj, j, zzmy.zzc(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 16:
                    if (!zzT(obj2, i)) {
                        break;
                    } else {
                        zzmy.zzr(obj, j, zzmy.zzd(obj2, j));
                        zzM(obj, i);
                        break;
                    }
                case 17:
                    zzK(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                case 30:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_WIDTH_DEFAULT:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzlz.zzaa(this.zzq, obj, obj2, j);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzX(obj2, i2, i)) {
                        break;
                    } else {
                        zzmy.zzs(obj, j, zzmy.zzf(obj2, j));
                        zzN(obj, i2, i);
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                    zzL(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                    if (!zzX(obj2, i2, i)) {
                        break;
                    } else {
                        zzmy.zzs(obj, j, zzmy.zzf(obj2, j));
                        zzN(obj, i2, i);
                        break;
                    }
                case 68:
                    zzL(obj, obj2, i);
                    break;
            }
        }
        zzlz.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzlz.zzE(this.zzo, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzir zzir) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zzir);
        } else {
            zzc(obj, bArr, i, i2, 0, zzir);
        }
    }

    public final void zzi(Object obj, zzng zzng) throws IOException {
        if (!this.zzi) {
            zzQ(obj, zzng);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzf(i2, zzmy.zza(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzo(i2, zzmy.zzb(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzt(i2, zzmy.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzJ(i2, zzmy.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzr(i2, zzmy.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzm(i2, zzmy.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzk(i2, zzmy.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzb(i2, zzmy.zzw(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzZ(i2, zzmy.zzf(obj, (long) (zzB & 1048575)), zzng);
                            break;
                        }
                    case 9:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzv(i2, zzmy.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 10:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzd(i2, (zzje) zzmy.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzH(i2, zzmy.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzi(i2, zzmy.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzw(i2, zzmy.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzy(i2, zzmy.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzA(i2, zzmy.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzC(i2, zzmy.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzT(obj, i)) {
                            break;
                        } else {
                            zzng.zzq(i2, zzmy.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 18:
                        zzlz.zzJ(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 19:
                        zzlz.zzN(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 20:
                        zzlz.zzQ(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 21:
                        zzlz.zzY(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 22:
                        zzlz.zzP(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 23:
                        zzlz.zzM(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 24:
                        zzlz.zzL(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 25:
                        zzlz.zzH(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 26:
                        zzlz.zzW(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng);
                        break;
                    case 27:
                        zzlz.zzR(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, zzE(i));
                        break;
                    case 28:
                        zzlz.zzI(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                        zzlz.zzX(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 30:
                        zzlz.zzK(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_WIDTH_DEFAULT:
                        zzlz.zzS(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 32:
                        zzlz.zzT(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 33:
                        zzlz.zzU(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 34:
                        zzlz.zzV(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, false);
                        break;
                    case 35:
                        zzlz.zzJ(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 36:
                        zzlz.zzN(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 37:
                        zzlz.zzQ(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 38:
                        zzlz.zzY(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 39:
                        zzlz.zzP(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 40:
                        zzlz.zzM(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 41:
                        zzlz.zzL(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 42:
                        zzlz.zzH(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 43:
                        zzlz.zzX(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 44:
                        zzlz.zzK(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 45:
                        zzlz.zzS(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 46:
                        zzlz.zzT(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case 47:
                        zzlz.zzU(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        zzlz.zzV(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                        zzlz.zzO(i2, (List) zzmy.zzf(obj, (long) (zzB & 1048575)), zzng, zzE(i));
                        break;
                    case 50:
                        zzR(zzng, i2, zzmy.zzf(obj, (long) (zzB & 1048575)), i);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzf(i2, zzn(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzo(i2, zzo(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzt(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzJ(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzr(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzm(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzk(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzb(i2, zzY(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzZ(i2, zzmy.zzf(obj, (long) (zzB & 1048575)), zzng);
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzv(i2, zzmy.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzd(i2, (zzje) zzmy.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzH(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case HtmlCompat.FROM_HTML_MODE_COMPACT:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzi(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzw(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzy(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzA(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzC(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzX(obj, i2, i)) {
                            break;
                        } else {
                            zzng.zzq(i2, zzmy.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                }
            }
            zzmo zzmo = this.zzn;
            zzmo.zzi(zzmo.zzd(obj), zzng);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (zzB & 1048575);
            switch (zzA(zzB)) {
                case 0:
                    if (zzS(obj, obj2, i) && Double.doubleToLongBits(zzmy.zza(obj, j)) == Double.doubleToLongBits(zzmy.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzS(obj, obj2, i) && Float.floatToIntBits(zzmy.zzb(obj, j)) == Float.floatToIntBits(zzmy.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzS(obj, obj2, i) && zzmy.zzd(obj, j) == zzmy.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzS(obj, obj2, i) && zzmy.zzd(obj, j) == zzmy.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzS(obj, obj2, i) && zzmy.zzc(obj, j) == zzmy.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzS(obj, obj2, i) && zzmy.zzd(obj, j) == zzmy.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzS(obj, obj2, i) && zzmy.zzc(obj, j) == zzmy.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzS(obj, obj2, i) && zzmy.zzw(obj, j) == zzmy.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzS(obj, obj2, i) && zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzS(obj, obj2, i) && zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzS(obj, obj2, i) && zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzS(obj, obj2, i) && zzmy.zzc(obj, j) == zzmy.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzS(obj, obj2, i) && zzmy.zzc(obj, j) == zzmy.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzS(obj, obj2, i) && zzmy.zzc(obj, j) == zzmy.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzS(obj, obj2, i) && zzmy.zzd(obj, j) == zzmy.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzS(obj, obj2, i) && zzmy.zzc(obj, j) == zzmy.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzS(obj, obj2, i) && zzmy.zzd(obj, j) == zzmy.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzS(obj, obj2, i) && zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                case 30:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_WIDTH_DEFAULT:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    z = zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j));
                    break;
                case 50:
                    z = zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
                case 56:
                case 57:
                case 58:
                case 59:
                case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                case 68:
                    long zzy = (long) (zzy(i) & 1048575);
                    if (zzmy.zzc(obj, zzy) == zzmy.zzc(obj2, zzy) && zzlz.zzZ(zzmy.zzf(obj, j), zzmy.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzB) != 0 && !zzU(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzX(obj2, i7, i6) && !zzV(obj2, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzlg) zzmy.zzf(obj2, (long) (zzB & 1048575))).isEmpty()) {
                            zzlf zzlf = (zzlf) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzmy.zzf(obj2, (long) (zzB & 1048575));
                if (!list.isEmpty()) {
                    zzlx zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzU(obj, i6, i2, i, i10) && !zzV(obj2, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }
}
