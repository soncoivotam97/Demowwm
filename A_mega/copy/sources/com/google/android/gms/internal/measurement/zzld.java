package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzld implements zzlk {
    private final zzlk[] zza;

    zzld(zzlk... zzlkArr) {
        this.zza = zzlkArr;
    }

    public final zzlj zzb(Class cls) {
        zzlk[] zzlkArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzlk zzlk = zzlkArr[i];
            if (zzlk.zzc(cls)) {
                return zzlk.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zzlk[] zzlkArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzlkArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
