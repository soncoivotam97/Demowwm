package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final /* synthetic */ class zzjw implements Runnable {
    public final /* synthetic */ zzjx zza;

    public /* synthetic */ zzjw(zzjx zzjx) {
        this.zza = zzjx;
    }

    public final void run() {
        zzjx zzjx = this.zza;
        zzjy zzjy = zzjx.zzc;
        long j = zzjx.zza;
        long j2 = zzjx.zzb;
        zzjy.zza.zzg();
        zzjy.zza.zzt.zzay().zzc().zza("Application going to the background");
        zzjy.zza.zzt.zzm().zzm.zza(true);
        Bundle bundle = new Bundle();
        if (!zzjy.zza.zzt.zzf().zzu()) {
            zzjy.zza.zzb.zzb(j2);
            zzjy.zza.zzb.zzd(false, false, j2);
        }
        zzjy.zza.zzt.zzq().zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
    }
}
