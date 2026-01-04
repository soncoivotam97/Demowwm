package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhl implements zzla {
    final /* synthetic */ zzhx zza;

    zzhl(zzhx zzhx) {
        this.zza = zzhx;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle, str);
        } else {
            this.zza.zzD(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
        }
    }
}
