package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
final class zzdw extends zzch {
    private final zzgs zza;

    zzdw(zzgs zzgs) {
        this.zza = zzgs;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }
}
