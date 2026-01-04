package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final /* synthetic */ class zzgv implements Runnable {
    public final /* synthetic */ zzhx zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzgv(zzhx zzhx, Bundle bundle, long j) {
        this.zza = zzhx;
        this.zzb = bundle;
        this.zzc = j;
    }

    public final void run() {
        zzhx zzhx = this.zza;
        Bundle bundle = this.zzb;
        long j = this.zzc;
        if (TextUtils.isEmpty(zzhx.zzt.zzh().zzm())) {
            zzhx.zzR(bundle, 0, j);
        } else {
            zzhx.zzt.zzay().zzl().zza("Using developer consent only; google app id found");
        }
    }
}
