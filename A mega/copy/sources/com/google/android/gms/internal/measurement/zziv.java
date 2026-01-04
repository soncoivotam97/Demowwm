package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zziv extends zzix {
    final /* synthetic */ zzje zza;
    private int zzb = 0;
    private final int zzc;

    zziv(zzje zzje) {
        this.zza = zzje;
        this.zzc = zzje.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
