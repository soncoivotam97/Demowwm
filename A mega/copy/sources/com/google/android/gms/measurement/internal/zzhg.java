package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhg implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhx zzb;

    zzhg(zzhx zzhx, Bundle bundle) {
        this.zzb = zzhx;
        this.zza = bundle;
    }

    public final void run() {
        zzhx zzhx = this.zzb;
        Bundle bundle = this.zza;
        zzhx.zzg();
        zzhx.zza();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!zzhx.zzt.zzJ()) {
            zzhx.zzt.zzay().zzj().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(checkNotEmpty, 0, (Object) null, "");
        try {
            zzaw zzz = zzhx.zzt.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true);
            String string = bundle.getString("app_id");
            long j = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP);
            boolean z = bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            String string2 = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME);
            zzac zzac = r4;
            zzac zzac2 = new zzac(string, "", zzkw, j, z, string2, (zzaw) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzaw) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzz);
            zzhx.zzt.zzt().zzE(zzac);
        } catch (IllegalArgumentException unused) {
        }
    }
}
