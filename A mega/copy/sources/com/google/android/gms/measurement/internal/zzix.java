package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzix implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcf zzc;
    final /* synthetic */ zzjm zzd;

    zzix(zzjm zzjm, zzaw zzaw, String str, zzcf zzcf) {
        this.zzd = zzjm;
        this.zza = zzaw;
        this.zzb = str;
        this.zzc = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        byte[] bArr = null;
        try {
            zzjm zzjm = this.zzd;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                zzfr = this.zzd.zzt;
            } else {
                bArr = zzh.zzu(this.zza, this.zzb);
                this.zzd.zzQ();
                zzfr = this.zzd.zzt;
            }
        } catch (RemoteException e) {
            this.zzd.zzt.zzay().zzd().zzb("Failed to send event to the service to bundle", e);
            zzfr = this.zzd.zzt;
        } catch (Throwable th) {
            this.zzd.zzt.zzv().zzS(this.zzc, bArr);
            throw th;
        }
        zzfr.zzv().zzS(this.zzc, bArr);
    }
}
