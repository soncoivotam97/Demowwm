package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzls {
    private static final zzlr zza;
    private static final zzlr zzb = new zzlr();

    static {
        zzlr zzlr;
        try {
            zzlr = (zzlr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlr = null;
        }
        zza = zzlr;
    }

    static zzlr zza() {
        return zza;
    }

    static zzlr zzb() {
        return zzb;
    }
}
