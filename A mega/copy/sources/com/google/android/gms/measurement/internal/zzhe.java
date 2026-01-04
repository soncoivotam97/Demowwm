package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhe implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhx zzb;

    zzhe(zzhx zzhx, long j) {
        this.zzb = zzhx;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzt.zzt().zzu(new AtomicReference());
    }
}
