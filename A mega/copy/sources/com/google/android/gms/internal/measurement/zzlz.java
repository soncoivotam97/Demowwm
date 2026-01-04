package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzlz {
    private static final Class zza;
    private static final zzmo zzb = zzab(false);
    private static final zzmo zzc = zzab(true);
    private static final zzmo zzd = new zzmq();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzmo zzA() {
        return zzc;
    }

    public static zzmo zzB() {
        return zzd;
    }

    static Object zzC(Object obj, int i, List list, zzkj zzkj, Object obj2, zzmo zzmo) {
        Object obj3 = null;
        if (zzkj == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzkj.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj3 = zzD(obj, i, intValue, obj3, zzmo);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj3;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzkj.zza(intValue2)) {
                    obj3 = zzD(obj, i, intValue2, obj3, zzmo);
                    it.remove();
                }
            }
        }
        return obj3;
    }

    static Object zzD(Object obj, int i, int i2, Object obj2, zzmo zzmo) {
        if (obj2 == null) {
            obj2 = zzmo.zzc(obj);
        }
        zzmo.zzf(obj2, i, (long) i2);
        return obj2;
    }

    static void zzE(zzjs zzjs, Object obj, Object obj2) {
        zzjs.zza(obj2);
        throw null;
    }

    static void zzF(zzmo zzmo, Object obj, Object obj2) {
        zzmo.zzh(obj, zzmo.zze(zzmo.zzd(obj), zzmo.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzkf.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzc(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzng zzng) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zze(i, list);
        }
    }

    public static void zzJ(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzg(i, list, z);
        }
    }

    public static void zzK(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzj(i, list, z);
        }
    }

    public static void zzL(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzl(i, list, z);
        }
    }

    public static void zzM(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzn(i, list, z);
        }
    }

    public static void zzN(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzp(i, list, z);
        }
    }

    public static void zzO(int i, List list, zzng zzng, zzlx zzlx) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzjn) zzng).zzq(i, list.get(i2), zzlx);
            }
        }
    }

    public static void zzP(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzs(i, list, z);
        }
    }

    public static void zzQ(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzu(i, list, z);
        }
    }

    public static void zzR(int i, List list, zzng zzng, zzlx zzlx) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzjn) zzng).zzv(i, list.get(i2), zzlx);
            }
        }
    }

    public static void zzS(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzx(i, list, z);
        }
    }

    public static void zzT(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzz(i, list, z);
        }
    }

    public static void zzU(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzB(i, list, z);
        }
    }

    public static void zzV(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzD(i, list, z);
        }
    }

    public static void zzW(int i, List list, zzng zzng) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzG(i, list);
        }
    }

    public static void zzX(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzI(i, list, z);
        }
    }

    public static void zzY(int i, List list, zzng zzng, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzng.zzK(i, list, z);
        }
    }

    static boolean zzZ(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i << 3) + 1);
    }

    static void zzaa(zzlh zzlh, Object obj, Object obj2, long j) {
        zzmy.zzs(obj, j, zzlh.zzb(zzmy.zzf(obj, j), zzmy.zzf(obj2, j)));
    }

    private static zzmo zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzmo) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List list) {
        return list.size();
    }

    static int zzc(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjm.zzz(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzz += zzjm.zzt((zzje) list.get(i2));
        }
        return zzz;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjm.zzz(i));
    }

    static int zze(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i = 0;
            while (i2 < size) {
                i += zzjm.zzv(zzkg.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjm.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i << 3) + 4);
    }

    static int zzg(List list) {
        return list.size() * 4;
    }

    static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i << 3) + 8);
    }

    static int zzi(List list) {
        return list.size() * 8;
    }

    static int zzj(int i, List list, zzlx zzlx) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzjm.zzu(i, (zzlm) list.get(i3), zzlx);
        }
        return i2;
    }

    static int zzk(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjm.zzz(i));
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i = 0;
            while (i2 < size) {
                i += zzjm.zzv(zzkg.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjm.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjm.zzz(i));
    }

    static int zzn(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlb = (zzlb) list;
            i = 0;
            while (i2 < size) {
                i += zzjm.zzB(zzlb.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjm.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, Object obj, zzlx zzlx) {
        if (!(obj instanceof zzks)) {
            return zzjm.zzA(i << 3) + zzjm.zzx((zzlm) obj, zzlx);
        }
        int zzA = zzjm.zzA(i << 3);
        int zza2 = ((zzks) obj).zza();
        return zzA + zzjm.zzA(zza2) + zza2;
    }

    static int zzp(int i, List list, zzlx zzlx) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzks) {
                i2 = zzjm.zzw((zzks) obj);
            } else {
                i2 = zzjm.zzx((zzlm) obj, zzlx);
            }
            zzz += i2;
        }
        return zzz;
    }

    static int zzq(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjm.zzz(i));
    }

    static int zzr(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i = 0;
            while (i2 < size) {
                int zze = zzkg.zze(i2);
                i += zzjm.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjm.zzz(i));
    }

    static int zzt(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlb = (zzlb) list;
            i = 0;
            while (i2 < size) {
                long zza2 = zzlb.zza(i2);
                i += zzjm.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i) * size;
        if (list instanceof zzku) {
            zzku zzku = (zzku) list;
            while (i4 < size) {
                Object zzf = zzku.zzf(i4);
                if (zzf instanceof zzje) {
                    i3 = zzjm.zzt((zzje) zzf);
                } else {
                    i3 = zzjm.zzy((String) zzf);
                }
                zzz += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzje) {
                    i2 = zzjm.zzt((zzje) obj);
                } else {
                    i2 = zzjm.zzy((String) obj);
                }
                zzz += i2;
                i4++;
            }
        }
        return zzz;
    }

    static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjm.zzz(i));
    }

    static int zzw(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i = 0;
            while (i2 < size) {
                i += zzjm.zzA(zzkg.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjm.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzx(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjm.zzz(i));
    }

    static int zzy(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlb = (zzlb) list;
            i = 0;
            while (i2 < size) {
                i += zzjm.zzB(zzlb.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjm.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzmo zzz() {
        return zzb;
    }
}
