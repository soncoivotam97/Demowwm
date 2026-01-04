package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zzle implements zzly {
    private static final zzlk zza = new zzlc();
    private final zzlk zzb;

    public zzle() {
        zzlk zzlk;
        zzlk[] zzlkArr = new zzlk[2];
        zzlkArr[0] = zzka.zza();
        try {
            zzlk = (zzlk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzlk = zza;
        }
        zzlkArr[1] = zzlk;
        zzld zzld = new zzld(zzlkArr);
        zzkn.zzf(zzld, "messageInfoFactory");
        this.zzb = zzld;
    }

    private static boolean zzb(zzlj zzlj) {
        return zzlj.zzc() == 1;
    }

    public final zzlx zza(Class cls) {
        zzlz.zzG(cls);
        zzlj zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzkf.class.isAssignableFrom(cls)) {
                return zzlq.zzc(zzlz.zzB(), zzju.zzb(), zzb2.zza());
            }
            return zzlq.zzc(zzlz.zzz(), zzju.zza(), zzb2.zza());
        } else if (zzkf.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzlp.zzl(cls, zzb2, zzls.zzb(), zzla.zzd(), zzlz.zzB(), zzju.zzb(), zzli.zzb());
            }
            return zzlp.zzl(cls, zzb2, zzls.zzb(), zzla.zzd(), zzlz.zzB(), (zzjs) null, zzli.zzb());
        } else if (zzb(zzb2)) {
            return zzlp.zzl(cls, zzb2, zzls.zza(), zzla.zzc(), zzlz.zzz(), zzju.zza(), zzli.zza());
        } else {
            return zzlp.zzl(cls, zzb2, zzls.zza(), zzla.zzc(), zzlz.zzA(), (zzjs) null, zzli.zza());
        }
    }
}
