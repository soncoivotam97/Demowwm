package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzeo implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzep zzb;

    zzeo(zzep zzep, boolean z) {
        this.zzb = zzep;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zzJ(this.zza);
    }
}
