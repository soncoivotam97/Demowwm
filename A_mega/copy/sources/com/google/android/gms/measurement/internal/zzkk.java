package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzkk implements zzej {
    final /* synthetic */ String zza;
    final /* synthetic */ zzkt zzb;

    zzkk(zzkt zzkt, String str) {
        this.zzb = zzkt;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzK(i, th, bArr, this.zza);
    }
}
