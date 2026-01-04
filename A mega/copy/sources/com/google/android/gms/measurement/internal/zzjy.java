package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzjy {
    final /* synthetic */ zzkc zza;
    private zzjx zzb;

    zzjy(zzkc zzkc) {
        this.zza = zzkc;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzjx(this, this.zza.zzt.zzav().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzg();
        zzjx zzjx = this.zzb;
        if (zzjx != null) {
            this.zza.zzd.removeCallbacks(zzjx);
        }
        this.zza.zzt.zzm().zzm.zza(false);
    }
}
