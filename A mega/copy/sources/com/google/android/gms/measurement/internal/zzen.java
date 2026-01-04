package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzen extends zzkh {
    public zzen(zzkt zzkt) {
        super(zzkt);
    }

    public final boolean zza() {
        zzW();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzt.zzau().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
