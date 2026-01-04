package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
public final class zzkt extends zzip implements RandomAccess, zzku {
    public static final zzku zza;
    private static final zzkt zzb;
    private final List zzc;

    static {
        zzkt zzkt = new zzkt(10);
        zzb = zzkt;
        zzkt.zzb();
        zza = zzkt;
    }

    public zzkt() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzje) {
            return ((zzje) obj).zzn(zzkn.zzb);
        }
        return zzkn.zzg((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzbT();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zzbT();
        if (collection instanceof zzku) {
            collection = ((zzku) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbT();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzbT();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzbT();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzkm zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzkt(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzku zze() {
        return zzc() ? new zzmt(this) : this;
    }

    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    /* renamed from: zzg */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzje) {
            zzje zzje = (zzje) obj;
            String zzn = zzje.zzn(zzkn.zzb);
            if (zzje.zzi()) {
                this.zzc.set(i, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzg = zzkn.zzg(bArr);
        if (zzkn.zzh(bArr)) {
            this.zzc.set(i, zzg);
        }
        return zzg;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzje zzje) {
        zzbT();
        this.zzc.add(zzje);
        this.modCount++;
    }

    public zzkt(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzkt(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
