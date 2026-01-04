package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhq implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzhx zzb;

    zzhq(zzhx zzhx, Boolean bool) {
        this.zzb = zzhx;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzaa(this.zza, true);
    }
}
