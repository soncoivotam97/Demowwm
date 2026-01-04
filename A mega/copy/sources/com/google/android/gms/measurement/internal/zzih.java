package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzih implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ zzie zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzim zze;

    zzih(zzim zzim, zzie zzie, zzie zzie2, long j, boolean z) {
        this.zze = zzim;
        this.zza = zzie;
        this.zzb = zzie2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
