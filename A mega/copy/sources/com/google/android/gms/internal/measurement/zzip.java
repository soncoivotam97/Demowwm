package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
abstract class zzip extends AbstractList implements zzkm {
    private boolean zza = true;

    zzip() {
    }

    public void add(int i, Object obj) {
        zzbT();
        super.add(i, obj);
    }

    public boolean addAll(int i, Collection collection) {
        zzbT();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzbT();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public Object remove(int i) {
        zzbT();
        return super.remove(i);
    }

    public final boolean removeAll(Collection collection) {
        zzbT();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        zzbT();
        return super.retainAll(collection);
    }

    public Object set(int i, Object obj) {
        zzbT();
        return super.set(i, obj);
    }

    public final void zzb() {
        this.zza = false;
    }

    /* access modifiers changed from: protected */
    public final void zzbT() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    public boolean add(Object obj) {
        zzbT();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        zzbT();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzbT();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
