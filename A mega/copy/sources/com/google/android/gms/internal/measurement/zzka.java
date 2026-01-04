package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzka implements zzlk {
    private static final zzka zza = new zzka();

    private zzka() {
    }

    public static zzka zza() {
        return zza;
    }

    public final zzlj zzb(Class cls) {
        if (zzkf.class.isAssignableFrom(cls)) {
            try {
                return (zzlj) zzkf.zzbz(cls.asSubclass(zzkf.class)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzkf.class.isAssignableFrom(cls);
    }
}
