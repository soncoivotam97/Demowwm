package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
public abstract class zzkf<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmp zzc = zzmp.zzc();
    private int zzd = -1;

    private final int zza(zzlx zzlx) {
        if (zzlx == null) {
            return zzlu.zza().zzb(getClass()).zza(this);
        }
        return zzlx.zza(this);
    }

    protected static zzkk zzbB() {
        return zzkg.zzf();
    }

    protected static zzkl zzbC() {
        return zzlb.zzf();
    }

    protected static zzkl zzbD(zzkl zzkl) {
        int size = zzkl.size();
        return zzkl.zze(size == 0 ? 10 : size + size);
    }

    protected static zzkm zzbE() {
        return zzlv.zze();
    }

    protected static zzkm zzbF(zzkm zzkm) {
        int size = zzkm.size();
        return zzkm.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzbH(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzbI(zzlm zzlm, String str, Object[] objArr) {
        return new zzlw(zzlm, str, objArr);
    }

    protected static void zzbL(Class cls, zzkf zzkf) {
        zza.put(cls, zzkf);
        zzkf.zzbJ();
    }

    static zzkf zzbz(Class cls) {
        Map map = zza;
        zzkf zzkf = (zzkf) map.get(cls);
        if (zzkf == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkf = (zzkf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzkf == null) {
            zzkf = (zzkf) ((zzkf) zzmy.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzkf != null) {
                map.put(cls, zzkf);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlu.zza().zzb(getClass()).zzj(this, (zzkf) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzbO()) {
            return zzbv();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzbv = zzbv();
        this.zzb = zzbv;
        return zzbv;
    }

    public final String toString() {
        return zzlo.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final zzkf zzbA() {
        return (zzkf) zzl(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzll zzbG() {
        return (zzkb) zzl(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzbJ() {
        zzlu.zza().zzb(getClass()).zzf(this);
        zzbK();
    }

    /* access modifiers changed from: package-private */
    public final void zzbK() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzbM(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzbN(zzjm zzjm) throws IOException {
        zzlu.zza().zzb(getClass()).zzi(this, zzjn.zza(zzjm));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbO() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzlm zzbS() {
        return (zzkf) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbv() {
        return zzlu.zza().zzb(getClass()).zzb(this);
    }

    /* access modifiers changed from: protected */
    public final zzkb zzbx() {
        return (zzkb) zzl(5, (Object) null, (Object) null);
    }

    public final zzkb zzby() {
        zzkb zzkb = (zzkb) zzl(5, (Object) null, (Object) null);
        zzkb.zzaA(this);
        return zzkb;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzbr(zzlx zzlx) {
        if (zzbO()) {
            int zza2 = zza(zzlx);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza3 = zza(zzlx);
        if (zza3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza3;
            return zza3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza3);
    }

    public final int zzbw() {
        if (zzbO()) {
            int zza2 = zza((zzlx) null);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i == Integer.MAX_VALUE) {
            i = zza((zzlx) null);
            if (i >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
            } else {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        }
        return i;
    }
}
