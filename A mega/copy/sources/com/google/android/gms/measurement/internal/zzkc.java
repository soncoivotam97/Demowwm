package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final class zzkc extends zzf {
    protected final zzkb zza = new zzkb(this);
    protected final zzka zzb = new zzka(this);
    protected final zzjy zzc = new zzjy(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzkc(zzfr zzfr) {
        super(zzfr);
    }

    static /* bridge */ /* synthetic */ void zzj(zzkc zzkc, long j) {
        zzkc.zzg();
        zzkc.zzm();
        zzkc.zzt.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j));
        zzkc.zzc.zza(j);
        if (zzkc.zzt.zzf().zzu()) {
            zzkc.zzb.zzb(j);
        }
    }

    static /* bridge */ /* synthetic */ void zzl(zzkc zzkc, long j) {
        zzkc.zzg();
        zzkc.zzm();
        zzkc.zzt.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzkc.zzt.zzf().zzu() || zzkc.zzt.zzm().zzm.zzb()) {
            zzkc.zzb.zzc(j);
        }
        zzkc.zzc.zzb();
        zzkb zzkb = zzkc.zza;
        zzkb.zza.zzg();
        if (zzkb.zza.zzt.zzJ()) {
            zzkb.zzb(zzkb.zza.zzt.zzav().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }
}
