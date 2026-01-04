package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzjw {
    private static final zzjw zzb = new zzjw(true);
    final zzmk zza = new zzma(16);
    private boolean zzc;
    private boolean zzd;

    private zzjw() {
    }

    public static zzjw zza() {
        throw null;
    }

    private static final void zzd(zzjv zzjv, Object obj) {
        boolean z;
        zzne zzb2 = zzjv.zzb();
        zzkn.zze(obj);
        zzne zzne = zzne.DOUBLE;
        zznf zznf = zznf.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzje) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzkh)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzlm) || (obj instanceof zzkr)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzjv.zza()), zzjv.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjw zzjw = new zzjw();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzjw.zzc((zzjv) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjw.zzc((zzjv) entry.getKey(), entry.getValue());
        }
        zzjw.zzd = this.zzd;
        return zzjw;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjw)) {
            return false;
        }
        return this.zza.equals(((zzjw) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzkf) {
                    ((zzkf) zzg.getValue()).zzbJ();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzjv zzjv, Object obj) {
        if (!zzjv.zzc()) {
            zzd(zzjv, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzjv, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzkr) {
            this.zzd = true;
        }
        this.zza.put(zzjv, obj);
    }

    private zzjw(boolean z) {
        zzb();
        zzb();
    }
}
