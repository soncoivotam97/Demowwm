package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzjh implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjl zzb;

    zzjh(zzjl zzjl, ComponentName componentName) {
        this.zzb = zzjl;
        this.zza = componentName;
    }

    public final void run() {
        zzjm.zzo(this.zzb.zza, this.zza);
    }
}
