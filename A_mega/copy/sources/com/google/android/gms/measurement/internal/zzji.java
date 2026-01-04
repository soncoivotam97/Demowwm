package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzji implements Runnable {
    final /* synthetic */ zzdx zza;
    final /* synthetic */ zzjl zzb;

    zzji(zzjl zzjl, zzdx zzdx) {
        this.zzb = zzjl;
        this.zza = zzdx;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzt.zzay().zzc().zza("Connected to remote service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
