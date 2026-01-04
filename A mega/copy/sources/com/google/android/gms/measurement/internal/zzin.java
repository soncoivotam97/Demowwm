package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzin implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzcf zze;
    final /* synthetic */ zzjm zzf;

    zzin(zzjm zzjm, String str, String str2, zzq zzq, boolean z, zzcf zzcf) {
        this.zzf = zzjm;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = z;
        this.zze = zzcf;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e;
        Bundle bundle2 = new Bundle();
        try {
            zzjm zzjm = this.zzf;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzkw> zzh2 = zzh.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh2 != null) {
                for (zzkw zzkw : zzh2) {
                    String str = zzkw.zze;
                    if (str != null) {
                        bundle.putString(zzkw.zzb, str);
                    } else {
                        Long l = zzkw.zzd;
                        if (l != null) {
                            bundle.putLong(zzkw.zzb, l.longValue());
                        } else {
                            Double d = zzkw.zzg;
                            if (d != null) {
                                bundle.putDouble(zzkw.zzb, d.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.zzf.zzQ();
                this.zzf.zzt.zzv().zzR(this.zze, bundle);
            } catch (RemoteException e2) {
                e = e2;
                try {
                    this.zzf.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
                    this.zzf.zzt.zzv().zzR(this.zze, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e3) {
            bundle = bundle2;
            e = e3;
            this.zzf.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
            this.zzf.zzt.zzv().zzR(this.zze, bundle);
        } catch (Throwable th3) {
            th = th3;
            this.zzf.zzt.zzv().zzR(this.zze, bundle2);
            throw th;
        }
    }
}
