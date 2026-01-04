package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
public class zzkb<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    protected zzkf zza;
    private final zzkf zzb;

    protected zzkb(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzbO()) {
            this.zza = messagetype.zzbA();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzlu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final zzkb zzaA(zzkf zzkf) {
        if (!this.zzb.equals(zzkf)) {
            if (!this.zza.zzbO()) {
                zzaH();
            }
            zza(this.zza, zzkf);
        }
        return this;
    }

    public final zzkb zzaB(byte[] bArr, int i, int i2, zzjr zzjr) throws zzkp {
        if (!this.zza.zzbO()) {
            zzaH();
        }
        try {
            zzlu.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zzir(zzjr));
            return this;
        } catch (zzkp e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzkp.zzf();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r3 != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType zzaC() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaE()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r5.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0019
            goto L_0x0038
        L_0x0019:
            if (r3 == 0) goto L_0x0039
            com.google.android.gms.internal.measurement.zzlu r3 = com.google.android.gms.internal.measurement.zzlu.zza()
            java.lang.Class r4 = r5.getClass()
            com.google.android.gms.internal.measurement.zzlx r3 = r3.zzb(r4)
            boolean r3 = r3.zzk(r5)
            if (r0 == 0) goto L_0x0036
            if (r1 == r3) goto L_0x0031
            r0 = r2
            goto L_0x0032
        L_0x0031:
            r0 = r5
        L_0x0032:
            r1 = 2
            r5.zzl(r1, r0, r2)
        L_0x0036:
            if (r3 == 0) goto L_0x0039
        L_0x0038:
            return r5
        L_0x0039:
            com.google.android.gms.internal.measurement.zzmn r0 = new com.google.android.gms.internal.measurement.zzmn
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkb.zzaC():com.google.android.gms.internal.measurement.zzkf");
    }

    /* renamed from: zzaD */
    public MessageType zzaE() {
        if (!this.zza.zzbO()) {
            return this.zza;
        }
        this.zza.zzbJ();
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaG() {
        if (!this.zza.zzbO()) {
            zzaH();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaH() {
        zzkf zzbA = this.zzb.zzbA();
        zza(zzbA, this.zza);
        this.zza = zzbA;
    }

    public final /* bridge */ /* synthetic */ zzin zzav(byte[] bArr, int i, int i2) throws zzkp {
        zzaB(bArr, 0, i2, zzjr.zza);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzin zzaw(byte[] bArr, int i, int i2, zzjr zzjr) throws zzkp {
        zzaB(bArr, 0, i2, zzjr);
        return this;
    }

    /* renamed from: zzaz */
    public final zzkb zzau() {
        zzkb zzkb = (zzkb) this.zzb.zzl(5, (Object) null, (Object) null);
        zzkb.zza = zzaE();
        return zzkb;
    }

    public final /* bridge */ /* synthetic */ zzlm zzbS() {
        throw null;
    }
}
