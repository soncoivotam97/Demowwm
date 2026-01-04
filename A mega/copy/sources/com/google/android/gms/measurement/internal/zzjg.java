package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzjg implements Runnable {
    final /* synthetic */ zzdx zza;
    final /* synthetic */ zzjl zzb;

    zzjg(zzjl zzjl, zzdx zzdx) {
        this.zzb = zzjl;
        this.zza = zzdx;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzt.zzay().zzj().zza("Connected to service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
