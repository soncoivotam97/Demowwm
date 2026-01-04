package com.google.android.gms.internal.measurement;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzik implements zzii {
    @CheckForNull
    volatile zzii zza;
    volatile boolean zzb;
    @CheckForNull
    Object zzc;

    zzik(zzii zzii) {
        zzii.getClass();
        this.zza = zzii;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzii zzii = this.zza;
                    zzii.getClass();
                    Object zza2 = zzii.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
