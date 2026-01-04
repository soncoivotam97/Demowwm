package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzkt implements zzgm {
    private static volatile zzkt zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzie zzD;
    private String zzE;
    private final zzla zzF = new zzko(this);
    long zza;
    private final zzfi zzc;
    private final zzen zzd;
    private zzam zze;
    private zzep zzf;
    private zzkf zzg;
    private zzaa zzh;
    private final zzkv zzi;
    private zzic zzj;
    private zzjo zzk;
    private final zzki zzl;
    private zzez zzm;
    /* access modifiers changed from: private */
    public final zzfr zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    zzkt(zzku zzku, zzfr zzfr) {
        Preconditions.checkNotNull(zzku);
        this.zzn = zzfr.zzp(zzku.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzki(this);
        zzkv zzkv = new zzkv(this);
        zzkv.zzX();
        this.zzi = zzkv;
        zzen zzen = new zzen(this);
        zzen.zzX();
        this.zzd = zzen;
        zzfi zzfi = new zzfi(this);
        zzfi.zzX();
        this.zzc = zzfi;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new zzkj(this, zzku));
    }

    static final void zzaa(zzfs zzfs, int i, String str) {
        List zzp2 = zzfs.zzp();
        int i2 = 0;
        while (i2 < zzp2.size()) {
            if (!"_err".equals(((zzfx) zzp2.get(i2)).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zzfw zze2 = zzfx.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i).longValue());
        zzfw zze3 = zzfx.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfs.zzf((zzfx) zze2.zzaC());
        zzfs.zzf((zzfx) zze3.zzaC());
    }

    static final void zzab(zzfs zzfs, String str) {
        List zzp2 = zzfs.zzp();
        for (int i = 0; i < zzp2.size(); i++) {
            if (str.equals(((zzfx) zzp2.get(i)).zzg())) {
                zzfs.zzh(i);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null || zzad.booleanValue()) {
            String zzy2 = zzj2.zzy();
            String zzw2 = zzj2.zzw();
            long zzb2 = zzj2.zzb();
            String zzv2 = zzj2.zzv();
            long zzm2 = zzj2.zzm();
            long zzj3 = zzj2.zzj();
            boolean zzai = zzj2.zzai();
            String zzx2 = zzj2.zzx();
            zzj2.zza();
            return new zzq(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzai, false, zzx2, 0, 0, 0, zzj2.zzah(), false, zzj2.zzr(), zzj2.zzq(), zzj2.zzk(), zzj2.zzC(), (String) null, zzh(str).zzh(), "", (String) null);
        }
        zzay().zzd().zzb("App version does not match; dropping. appId", zzeh.zzn(str));
        return null;
    }

    private final Boolean zzad(zzh zzh2) {
        try {
            if (zzh2.zzb() != -2147483648L) {
                if (zzh2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzh2.zzt(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzh2.zzt(), 0).versionName;
                String zzw2 = zzh2.zzw();
                if (zzw2 != null && zzw2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    private final void zzaf(zzgc zzgc, long j, boolean z) {
        String str;
        zzky zzky;
        String str2;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        zzam zzam = this.zze;
        zzal(zzam);
        zzky zzp2 = zzam.zzp(zzgc.zzap(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzky = new zzky(zzgc.zzap(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzky = new zzky(zzgc.zzap(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j));
        }
        zzgl zzd2 = zzgm.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzav().currentTimeMillis());
        zzd2.zze(((Long) zzky.zze).longValue());
        zzgm zzgm = (zzgm) zzd2.zzaC();
        int zza2 = zzkv.zza(zzgc, str);
        if (zza2 >= 0) {
            zzgc.zzam(zza2, zzgm);
        } else {
            zzgc.zzm(zzgm);
        }
        if (j > 0) {
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzL(zzky);
            if (true != z) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzay().zzj().zzc("Updated engagement user property. scope, value", str2, zzky.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0237  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfo r1 = r20.zzaz()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.elapsedRealtime()
            long r5 = r0.zza
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkf r0 = r0.zzg
            zzal(r0)
            r0.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0254
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0254
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzag r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzs
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzjo r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzjo r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018e
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzkv r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzw(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018e
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018e
            r1 = 0
        L_0x0152:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzB
            r5 = 0
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r6 = 0
            int r2 = java.lang.Math.max(r6, r2)
            r11 = 20
            int r2 = java.lang.Math.min(r11, r2)
            if (r1 >= r2) goto L_0x0114
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzA
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Long r2 = (java.lang.Long) r2
            long r11 = r2.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            r13 = 1
            long r13 = r13 << r1
            long r11 = r11 * r13
            long r7 = r7 + r11
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018e
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018e:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0237
            com.google.android.gms.measurement.internal.zzen r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021a
            com.google.android.gms.measurement.internal.zzjo r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkv r9 = r0.zzi
            zzal(r9)
            boolean r9 = r9.zzw(r1, r5)
            if (r9 != 0) goto L_0x01c9
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01c9:
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0200
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r1 = com.google.android.gms.measurement.internal.zzdu.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzjo r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzav()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0200:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzkf r0 = r0.zzg
            zzal(r0)
            r0.zzd(r7)
            return
        L_0x021a:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkf r0 = r0.zzg
            zzal(r0)
            r0.zza()
            return
        L_0x0237:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkf r0 = r0.zzg
            zzal(r0)
            r0.zza()
            return
        L_0x0254:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkf r0 = r0.zzg
            zzal(r0)
            r0.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzag():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0b81, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzag.zzA() + r8)) goto L_0x0b83;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03a7 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x046b A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04c5 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x081f A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0868 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x088b A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0902 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0904 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x090c A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0938 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0b71 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0bf8 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0c14 A[Catch:{ SQLiteException -> 0x0c2c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01e4=Splitter:B:69:0x01e4, B:420:0x0d08=Splitter:B:420:0x0d08} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r42, long r43) {
        /*
            r41 = this;
            r1 = r41
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze
            zzal(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzkq r4 = new com.google.android.gms.measurement.internal.zzkq     // Catch:{ all -> 0x0d1a }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            long r9 = r1.zzA     // Catch:{ all -> 0x0d1a }
            r6 = 0
            r7 = r43
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0d08
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x002e
            goto L_0x0d08
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgd r5 = r4.zza     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x0d1a }
            r5.zzr()     // Catch:{ all -> 0x0d1a }
            r10 = r12
            r13 = r10
            r8 = 0
            r9 = 0
            r11 = -1
            r14 = -1
            r15 = 0
        L_0x0040:
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0d1a }
            int r12 = r12.size()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r15
            java.lang.String r15 = "_e"
            r17 = r2
            r18 = r3
            if (r8 >= r12) goto L_0x0543
            java.util.List r3 = r4.zzc     // Catch:{ all -> 0x0d1a }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkb r3 = r3.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r12 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r2 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            r20 = r9
            java.lang.String r9 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.zzr(r2, r9)     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "_err"
            if (r2 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r15 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzd(r15)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r6, r7, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzlb r21 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzla r2 = r1.zzF     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r23 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r25 = "_ev"
            java.lang.String r26 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            r27 = 0
            r24 = 11
            r22 = r2
            r21.zzN(r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0d1a }
        L_0x00e8:
            r7 = r8
            r23 = r10
            r15 = r16
            r9 = r20
            r10 = r5
            r5 = -1
            goto L_0x0538
        L_0x00f3:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgo.zza(r18)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x016d
            r2 = r18
            r3.zzi(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r12 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            r18 = r2
            java.lang.String r2 = "Renaming ad_impression to _ai"
            r12.zza(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzq()     // Catch:{ all -> 0x0d1a }
            r12 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r12)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r12 = r3.zza()     // Catch:{ all -> 0x0d1a }
            if (r2 >= r12) goto L_0x016d
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfx r21 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r22 = r8
            java.lang.String r8 = r21.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzfx r8 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r8 != 0) goto L_0x0168
            java.lang.String r8 = "admob"
            com.google.android.gms.internal.measurement.zzfx r12 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r8.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.zzeh r8 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "AdMob ad impression logged from app. Potentially duplicative."
            r8.zza(r12)     // Catch:{ all -> 0x0d1a }
        L_0x0168:
            int r2 = r2 + 1
            r8 = r22
            goto L_0x0125
        L_0x016d:
            r22 = r8
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzq(r8, r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "_c"
            if (r2 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x0d1a }
            r21 = r11
            int r11 = r12.hashCode()     // Catch:{ all -> 0x0d1a }
            r23 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r11 == r10) goto L_0x01be
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r11 == r10) goto L_0x01b4
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r11 == r10) goto L_0x01aa
            goto L_0x01c8
        L_0x01aa:
            java.lang.String r10 = "_ui"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 1
            goto L_0x01c9
        L_0x01b4:
            java.lang.String r10 = "_ug"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 2
            goto L_0x01c9
        L_0x01be:
            java.lang.String r10 = "_in"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 0
            goto L_0x01c9
        L_0x01c8:
            r10 = -1
        L_0x01c9:
            if (r10 == 0) goto L_0x01df
            r11 = 1
            if (r10 == r11) goto L_0x01df
            r11 = 2
            if (r10 == r11) goto L_0x01df
            r25 = r5
            r24 = r7
            r7 = r13
            r19 = r14
            r2 = 0
            goto L_0x03a5
        L_0x01db:
            r23 = r10
            r21 = r11
        L_0x01df:
            r24 = r7
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x01e4:
            int r7 = r3.zza()     // Catch:{ all -> 0x0d1a }
            r25 = r5
            java.lang.String r5 = "_r"
            if (r10 >= r7) goto L_0x024b
            com.google.android.gms.internal.measurement.zzfx r7 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x0219
            com.google.android.gms.internal.measurement.zzfx r5 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r7 = r13
            r19 = r14
            r13 = 1
            r5.zzi(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r10, r5)     // Catch:{ all -> 0x0d1a }
            r11 = 1
            goto L_0x0243
        L_0x0219:
            r7 = r13
            r19 = r14
            com.google.android.gms.internal.measurement.zzfx r13 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0243
            com.google.android.gms.internal.measurement.zzfx r5 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r12 = 1
            r5.zzi(r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r10, r5)     // Catch:{ all -> 0x0d1a }
            r12 = 1
        L_0x0243:
            int r10 = r10 + 1
            r13 = r7
            r14 = r19
            r5 = r25
            goto L_0x01e4
        L_0x024b:
            r7 = r13
            r19 = r14
            if (r11 != 0) goto L_0x027c
            if (r2 == 0) goto L_0x027c
            com.google.android.gms.measurement.internal.zzeh r10 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzec r13 = r13.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzd(r14)     // Catch:{ all -> 0x0d1a }
            r10.zzb(r11, r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r10 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0d1a }
            r10.zzj(r8)     // Catch:{ all -> 0x0d1a }
            r13 = 1
            r10.zzi(r13)     // Catch:{ all -> 0x0d1a }
            r3.zze(r10)     // Catch:{ all -> 0x0d1a }
        L_0x027c:
            if (r12 != 0) goto L_0x02a8
            com.google.android.gms.measurement.internal.zzeh r10 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzd(r13)     // Catch:{ all -> 0x0d1a }
            r10.zzb(r11, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r10 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0d1a }
            r10.zzj(r5)     // Catch:{ all -> 0x0d1a }
            r11 = 1
            r10.zzi(r11)     // Catch:{ all -> 0x0d1a }
            r3.zze(r10)     // Catch:{ all -> 0x0d1a }
        L_0x02a8:
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r10)     // Catch:{ all -> 0x0d1a }
            long r27 = r41.zza()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r29 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            r33 = 0
            r34 = 1
            r30 = 0
            r31 = 0
            r32 = 0
            r26 = r10
            com.google.android.gms.measurement.internal.zzak r10 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0d1a }
            long r10 = r10.zze     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzag r12 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r13 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x0d1a }
            int r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0d1a }
            long r12 = (long) r12     // Catch:{ all -> 0x0d1a }
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x02e2
            zzab(r3, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x02e4
        L_0x02e2:
            r16 = 1
        L_0x02e4:
            java.lang.String r5 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r5 = com.google.android.gms.measurement.internal.zzlb.zzai(r5)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x03a5
            if (r2 == 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            long r27 = r41.zza()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r29 = r10.zzx()     // Catch:{ all -> 0x0d1a }
            r33 = 0
            r34 = 0
            r30 = 0
            r31 = 0
            r32 = 1
            r26 = r5
            com.google.android.gms.measurement.internal.zzak r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0d1a }
            long r10 = r5.zzc     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzag r5 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r12 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzm     // Catch:{ all -> 0x0d1a }
            int r5 = r5.zze(r12, r13)     // Catch:{ all -> 0x0d1a }
            long r12 = (long) r5     // Catch:{ all -> 0x0d1a }
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgd r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r11)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r10, r11)     // Catch:{ all -> 0x0d1a }
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = -1
        L_0x0341:
            int r13 = r3.zza()     // Catch:{ all -> 0x0d1a }
            if (r10 >= r13) goto L_0x036b
            com.google.android.gms.internal.measurement.zzfx r13 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r14 = r8.equals(r14)     // Catch:{ all -> 0x0d1a }
            if (r14 == 0) goto L_0x035d
            com.google.android.gms.internal.measurement.zzkb r5 = r13.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r12 = r10
            goto L_0x0368
        L_0x035d:
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r13 = r9.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0368
            r11 = 1
        L_0x0368:
            int r10 = r10 + 1
            goto L_0x0341
        L_0x036b:
            if (r11 == 0) goto L_0x0374
            if (r5 == 0) goto L_0x0373
            r3.zzh(r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x03a5
        L_0x0373:
            r5 = 0
        L_0x0374:
            if (r5 == 0) goto L_0x038e
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzau()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d1a }
            r5.zzj(r9)     // Catch:{ all -> 0x0d1a }
            r9 = 10
            r5.zzi(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r12, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x03a5
        L_0x038e:
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgd r10 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r9, r10)     // Catch:{ all -> 0x0d1a }
        L_0x03a5:
            if (r2 == 0) goto L_0x045e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r3.zzp()     // Catch:{ all -> 0x0d1a }
            r2.<init>(r5)     // Catch:{ all -> 0x0d1a }
            r5 = 0
            r9 = -1
            r10 = -1
        L_0x03b3:
            int r11 = r2.size()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r11) goto L_0x03e3
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x03cf
            r9 = r5
            goto L_0x03e0
        L_0x03cf:
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x03e0
            r10 = r5
        L_0x03e0:
            int r5 = r5 + 1
            goto L_0x03b3
        L_0x03e3:
            r5 = -1
            if (r9 != r5) goto L_0x03e8
            goto L_0x045f
        L_0x03e8:
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0419
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0419
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0d1a }
            r3.zzh(r9)     // Catch:{ all -> 0x0d1a }
            zzab(r3, r8)     // Catch:{ all -> 0x0d1a }
            r2 = 18
            zzaa(r3, r2, r13)     // Catch:{ all -> 0x0d1a }
            goto L_0x045e
        L_0x0419:
            r5 = -1
            if (r10 != r5) goto L_0x041d
            goto L_0x0445
        L_0x041d:
            java.lang.Object r2 = r2.get(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            int r10 = r2.length()     // Catch:{ all -> 0x0d1a }
            r11 = 3
            if (r10 != r11) goto L_0x0445
            r10 = 0
        L_0x042f:
            int r11 = r2.length()     // Catch:{ all -> 0x0d1a }
            if (r10 >= r11) goto L_0x045f
            int r11 = r2.codePointAt(r10)     // Catch:{ all -> 0x0d1a }
            boolean r13 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0445
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x0d1a }
            int r10 = r10 + r11
            goto L_0x042f
        L_0x0445:
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r10)     // Catch:{ all -> 0x0d1a }
            r3.zzh(r9)     // Catch:{ all -> 0x0d1a }
            zzab(r3, r8)     // Catch:{ all -> 0x0d1a }
            r2 = 19
            zzaa(r3, r2, r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x045f
        L_0x045e:
            r5 = -1
        L_0x045f:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r15.equals(r2)     // Catch:{ all -> 0x0d1a }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04c5
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r2 = r3.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzkv.zzB(r2, r6)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x04c0
            if (r7 == 0) goto L_0x04b4
            long r10 = r7.zzc()     // Catch:{ all -> 0x0d1a }
            long r12 = r3.zzc()     // Catch:{ all -> 0x0d1a }
            long r10 = r10 - r12
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0d1a }
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x04b4
            com.google.android.gms.internal.measurement.zzkb r2 = r7.zzau()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            boolean r6 = r1.zzaj(r3, r2)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x04a7
            r6 = r19
            r10 = r25
            r10.zzS(r6, r2)     // Catch:{ all -> 0x0d1a }
            r11 = r21
            r2 = 0
            r13 = 0
            goto L_0x04af
        L_0x04a7:
            r6 = r19
            r10 = r25
            r2 = r3
            r13 = r7
            r11 = r20
        L_0x04af:
            r23 = r2
            r14 = r6
            goto L_0x0524
        L_0x04b4:
            r6 = r19
            r10 = r25
            r23 = r3
            r14 = r6
            r13 = r7
            r11 = r20
            goto L_0x0524
        L_0x04c0:
            r6 = r19
            r10 = r25
            goto L_0x051f
        L_0x04c5:
            r6 = r19
            r10 = r25
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x051f
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r2 = r3.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0d1a }
            r11 = r24
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzkv.zzB(r2, r11)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x051f
            if (r23 == 0) goto L_0x0518
            long r11 = r23.zzc()     // Catch:{ all -> 0x0d1a }
            long r13 = r3.zzc()     // Catch:{ all -> 0x0d1a }
            long r11 = r11 - r13
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0d1a }
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0518
            com.google.android.gms.internal.measurement.zzkb r2 = r23.zzau()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            boolean r7 = r1.zzaj(r2, r3)     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x0511
            r8 = r21
            r10.zzS(r8, r2)     // Catch:{ all -> 0x0d1a }
            r14 = r6
            r2 = 0
            r23 = 0
            goto L_0x0516
        L_0x0511:
            r8 = r21
            r2 = r3
            r14 = r20
        L_0x0516:
            r13 = r2
            goto L_0x0523
        L_0x0518:
            r8 = r21
            r13 = r3
            r11 = r8
            r14 = r20
            goto L_0x0524
        L_0x051f:
            r8 = r21
            r14 = r6
            r13 = r7
        L_0x0523:
            r11 = r8
        L_0x0524:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r6 = r3.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r6 = (com.google.android.gms.internal.measurement.zzft) r6     // Catch:{ all -> 0x0d1a }
            r7 = r22
            r2.set(r7, r6)     // Catch:{ all -> 0x0d1a }
            int r9 = r20 + 1
            r10.zzk(r3)     // Catch:{ all -> 0x0d1a }
            r15 = r16
        L_0x0538:
            int r8 = r7 + 1
            r5 = r10
            r2 = r17
            r3 = r18
            r10 = r23
            goto L_0x0040
        L_0x0543:
            r10 = r5
            r11 = r7
            r20 = r9
            r2 = 0
            r7 = r2
            r5 = 0
        L_0x054b:
            if (r5 >= r9) goto L_0x059b
            com.google.android.gms.internal.measurement.zzft r12 = r10.zze(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r12.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x056e
            com.google.android.gms.measurement.internal.zzkv r13 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r13 = com.google.android.gms.measurement.internal.zzkv.zzB(r12, r6)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x056e
            r10.zzA(r5)     // Catch:{ all -> 0x0d1a }
            int r9 = r9 + -1
            int r5 = r5 + -1
            goto L_0x0598
        L_0x056e:
            com.google.android.gms.measurement.internal.zzkv r13 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r12 = com.google.android.gms.measurement.internal.zzkv.zzB(r12, r11)     // Catch:{ all -> 0x0d1a }
            if (r12 == 0) goto L_0x0598
            boolean r13 = r12.zzw()     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0588
            long r12 = r12.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x0589
        L_0x0588:
            r12 = 0
        L_0x0589:
            if (r12 == 0) goto L_0x0598
            long r13 = r12.longValue()     // Catch:{ all -> 0x0d1a }
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0598
            long r12 = r12.longValue()     // Catch:{ all -> 0x0d1a }
            long r7 = r7 + r12
        L_0x0598:
            r12 = 1
            int r5 = r5 + r12
            goto L_0x054b
        L_0x059b:
            r5 = 0
            r1.zzaf(r10, r7, r5)     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r10.zzas()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x05a7:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "_se"
            if (r6 == 0) goto L_0x05cd
            java.lang.String r6 = "_s"
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x05a7
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            r5.zzA(r6, r9)     // Catch:{ all -> 0x0d1a }
        L_0x05cd:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzkv.zza(r10, r5)     // Catch:{ all -> 0x0d1a }
            if (r5 < 0) goto L_0x05da
            r5 = 1
            r1.zzaf(r10, r7, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x05fa
        L_0x05da:
            int r5 = com.google.android.gms.measurement.internal.zzkv.zza(r10, r9)     // Catch:{ all -> 0x0d1a }
            if (r5 < 0) goto L_0x05fa
            r10.zzB(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d1a }
        L_0x05fa:
            com.google.android.gms.measurement.internal.zzkv r5 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r6.zza(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkt r6 = r5.zzf     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r6 = r6.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.zzn(r7)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzkt r6 = r5.zzf     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r6 = r6.zze     // Catch:{ all -> 0x0d1a }
            zzal(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzh r6 = r6.zzj(r7)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            boolean r6 = r6.zzah()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.zze()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzc()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r6.zza(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgl r6 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0d1a }
            r7 = r17
            r6.zzf(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r5 = r5.zzg()     // Catch:{ all -> 0x0d1a }
            long r8 = r5.zza()     // Catch:{ all -> 0x0d1a }
            r6.zzg(r8)     // Catch:{ all -> 0x0d1a }
            r8 = 1
            r6.zze(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r5 = r6.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgm r5 = (com.google.android.gms.internal.measurement.zzgm) r5     // Catch:{ all -> 0x0d1a }
            r6 = 0
        L_0x0673:
            int r8 = r10.zzb()     // Catch:{ all -> 0x0d1a }
            if (r6 >= r8) goto L_0x068e
            com.google.android.gms.internal.measurement.zzgm r8 = r10.zzao(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x068b
            r10.zzam(r6, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x0691
        L_0x068b:
            int r6 = r6 + 1
            goto L_0x0673
        L_0x068e:
            r10.zzm(r5)     // Catch:{ all -> 0x0d1a }
        L_0x0691:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10.zzai(r5)     // Catch:{ all -> 0x0d1a }
            r5 = -9223372036854775808
            r10.zzQ(r5)     // Catch:{ all -> 0x0d1a }
            r5 = 0
        L_0x069f:
            int r6 = r10.zza()     // Catch:{ all -> 0x0d1a }
            if (r5 >= r6) goto L_0x06d2
            com.google.android.gms.internal.measurement.zzft r6 = r10.zze(r5)     // Catch:{ all -> 0x0d1a }
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            long r11 = r10.zzd()     // Catch:{ all -> 0x0d1a }
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x06bc
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            r10.zzai(r7)     // Catch:{ all -> 0x0d1a }
        L_0x06bc:
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            long r11 = r10.zzc()     // Catch:{ all -> 0x0d1a }
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x06cf
            long r6 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            r10.zzQ(r6)     // Catch:{ all -> 0x0d1a }
        L_0x06cf:
            int r5 = r5 + 1
            goto L_0x069f
        L_0x06d2:
            r10.zzz()     // Catch:{ all -> 0x0d1a }
            r10.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaa r5 = r1.zzh     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r21 = r10.zzap()     // Catch:{ all -> 0x0d1a }
            java.util.List r22 = r10.zzas()     // Catch:{ all -> 0x0d1a }
            java.util.List r23 = r10.zzat()     // Catch:{ all -> 0x0d1a }
            long r6 = r10.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r24 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r10.zzc()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r25 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d1a }
            r20 = r5
            java.util.List r5 = r20.zza(r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0d1a }
            r10.zzf(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzag r5 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0a54
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0d1a }
            r5.<init>()     // Catch:{ all -> 0x0d1a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0d1a }
            r6.<init>()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzlb r7 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            java.security.SecureRandom r7 = r7.zzG()     // Catch:{ all -> 0x0d1a }
            r8 = 0
        L_0x0725:
            int r9 = r10.zza()     // Catch:{ all -> 0x0d1a }
            if (r8 >= r9) goto L_0x0a1a
            com.google.android.gms.internal.measurement.zzft r9 = r10.zze(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkb r9 = r9.zzby()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r9 = (com.google.android.gms.internal.measurement.zzfs) r9     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07c8
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r11 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzkv.zzC(r11, r14)     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0d1a }
            java.lang.Object r14 = r5.get(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r14 = (com.google.android.gms.measurement.internal.zzas) r14     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x077c
            com.google.android.gms.measurement.internal.zzam r14 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r15 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0d1a }
            r2 = r17
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r14 = r14.zzn(r15, r2)     // Catch:{ all -> 0x0d1a }
            if (r14 == 0) goto L_0x077c
            r5.put(r11, r14)     // Catch:{ all -> 0x0d1a }
        L_0x077c:
            if (r14 == 0) goto L_0x07bb
            java.lang.Long r2 = r14.zzi     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x07bb
            java.lang.Long r2 = r14.zzj     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x079a
            long r2 = r2.longValue()     // Catch:{ all -> 0x0d1a }
            r17 = 1
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x079a
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = r14.zzj     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkv.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
        L_0x079a:
            java.lang.Boolean r2 = r14.zzk     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x07b2
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x07b2
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            r2 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkv.zzz(r9, r12, r11)     // Catch:{ all -> 0x0d1a }
        L_0x07b2:
            com.google.android.gms.internal.measurement.zzkf r2 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
        L_0x07bb:
            r10.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x07be:
            r24 = r4
            r22 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a0e
        L_0x07c8:
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r11 = r2.zza(r3, r11)     // Catch:{ all -> 0x0d1a }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x07f9
            long r2 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x07e4 }
            goto L_0x07fb
        L_0x07e4:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r14, r3, r11)     // Catch:{ all -> 0x0d1a }
        L_0x07f9:
            r2 = 0
        L_0x07fb:
            com.google.android.gms.measurement.internal.zzlb r11 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            long r14 = r11.zzr(r14, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r11 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0d1a }
            r44 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0d1a }
            r17 = r2
            java.lang.String r2 = "_dbg"
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x0853
            java.util.List r3 = r11.zzi()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x0827:
            boolean r11 = r3.hasNext()     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x0853
            java.lang.Object r11 = r3.next()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x0d1a }
            r22 = r3
            java.lang.String r3 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x0d1a }
            if (r3 == 0) goto L_0x0850
            long r2 = r11.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.equals(r2)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x084e
            goto L_0x0853
        L_0x084e:
            r2 = 1
            goto L_0x0866
        L_0x0850:
            r3 = r22
            goto L_0x0827
        L_0x0853:
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            int r2 = r2.zzc(r3, r11)     // Catch:{ all -> 0x0d1a }
        L_0x0866:
            if (r2 > 0) goto L_0x088b
            com.google.android.gms.measurement.internal.zzeh r3 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            r3.zzc(r11, r12, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r2 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
            r10.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
            goto L_0x07be
        L_0x088b:
            java.lang.String r3 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = (com.google.android.gms.measurement.internal.zzas) r3     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r3)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzn(r11, r12)     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzeh r3 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgd r12 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0d1a }
            r22 = r14
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r3.zzc(r11, r12, r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r25 = r11.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.String r26 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r33 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            r39 = 0
            r40 = 0
            r27 = 1
            r29 = 1
            r31 = 1
            r35 = 0
            r37 = 0
            r38 = 0
            r24 = r3
            r24.<init>(r25, r26, r27, r29, r31, r33, r35, r37, r38, r39, r40)     // Catch:{ all -> 0x0d1a }
            goto L_0x08ed
        L_0x08eb:
            r22 = r14
        L_0x08ed:
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r11 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzkv.zzC(r11, r12)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x0904
            r12 = 1
            goto L_0x0905
        L_0x0904:
            r12 = 0
        L_0x0905:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d1a }
            r14 = 1
            if (r2 != r14) goto L_0x0938
            com.google.android.gms.internal.measurement.zzkf r2 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0933
            java.lang.Long r2 = r3.zzi     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x0927
            java.lang.Long r2 = r3.zzj     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x0927
            java.lang.Boolean r2 = r3.zzk     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0933
        L_0x0927:
            r2 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r2, r2, r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0933:
            r10.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
            goto L_0x07be
        L_0x0938:
            int r14 = r7.nextInt(r2)     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x097a
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r11)     // Catch:{ all -> 0x0d1a }
            long r14 = (long) r2     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkv.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r11 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0d1a }
            r6.add(r11)     // Catch:{ all -> 0x0d1a }
            boolean r11 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x095f
            r11 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r11, r2, r11)     // Catch:{ all -> 0x0d1a }
        L_0x095f:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            r14 = r22
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzb(r11, r14)     // Catch:{ all -> 0x0d1a }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r22 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a0b
        L_0x097a:
            r14 = r22
            r22 = r7
            java.lang.Long r7 = r3.zzh     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x098f
            long r17 = r7.longValue()     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r26 = r5
            r25 = r10
            r23 = r11
            goto L_0x09a5
        L_0x098f:
            com.google.android.gms.measurement.internal.zzlb r7 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            r25 = r10
            r23 = r11
            long r10 = r9.zzb()     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r26 = r5
            r4 = r17
            long r17 = r7.zzr(r10, r4)     // Catch:{ all -> 0x0d1a }
        L_0x09a5:
            int r4 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x09f1
            com.google.android.gms.measurement.internal.zzkv r4 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r4)     // Catch:{ all -> 0x0d1a }
            r4 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d1a }
            r10 = r44
            com.google.android.gms.measurement.internal.zzkv.zzz(r9, r10, r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkv r7 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzal(r7)     // Catch:{ all -> 0x0d1a }
            long r10 = (long) r2     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkv.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r7 = r9.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x0d1a }
            r6.add(r7)     // Catch:{ all -> 0x0d1a }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x09df
            r7 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0d1a }
            r7 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r7, r2, r10)     // Catch:{ all -> 0x0d1a }
        L_0x09df:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r10 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzb(r10, r14)     // Catch:{ all -> 0x0d1a }
            r7 = r26
            r7.put(r2, r3)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a09
        L_0x09f1:
            r7 = r26
            r4 = 1
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0a09
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r11 = r23
            r10 = 0
            com.google.android.gms.measurement.internal.zzas r3 = r3.zza(r11, r10, r10)     // Catch:{ all -> 0x0d1a }
            r7.put(r2, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0a09:
            r2 = r25
        L_0x0a0b:
            r2.zzS(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0a0e:
            int r8 = r8 + 1
            r10 = r2
            r5 = r7
            r7 = r22
            r4 = r24
            r2 = 0
            goto L_0x0725
        L_0x0a1a:
            r24 = r4
            r7 = r5
            r2 = r10
            int r3 = r6.size()     // Catch:{ all -> 0x0d1a }
            int r4 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r3 >= r4) goto L_0x0a2e
            r2.zzr()     // Catch:{ all -> 0x0d1a }
            r2.zzg(r6)     // Catch:{ all -> 0x0d1a }
        L_0x0a2e:
            java.util.Set r3 = r7.entrySet()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x0a36:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0d1a }
            if (r4 == 0) goto L_0x0a51
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0d1a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzas r4 = (com.google.android.gms.measurement.internal.zzas) r4     // Catch:{ all -> 0x0d1a }
            r5.zzE(r4)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a36
        L_0x0a51:
            r3 = r24
            goto L_0x0a56
        L_0x0a54:
            r2 = r10
            r3 = r4
        L_0x0a56:
            com.google.android.gms.internal.measurement.zzgd r4 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzh r5 = r5.zzj(r4)     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0a7f
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d1a }
            goto L_0x0adb
        L_0x0a7f:
            int r6 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r6 <= 0) goto L_0x0adb
            long r6 = r5.zzn()     // Catch:{ all -> 0x0d1a }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a93
            r2.zzab(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a96
        L_0x0a93:
            r2.zzv()     // Catch:{ all -> 0x0d1a }
        L_0x0a96:
            long r8 = r5.zzp()     // Catch:{ all -> 0x0d1a }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0aa1
            goto L_0x0aa2
        L_0x0aa1:
            r6 = r8
        L_0x0aa2:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0aaa
            r2.zzac(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0aad
        L_0x0aaa:
            r2.zzw()     // Catch:{ all -> 0x0d1a }
        L_0x0aad:
            r5.zzE()     // Catch:{ all -> 0x0d1a }
            long r6 = r5.zzo()     // Catch:{ all -> 0x0d1a }
            int r6 = (int) r6     // Catch:{ all -> 0x0d1a }
            r2.zzI(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            r5.zzab(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r2.zzc()     // Catch:{ all -> 0x0d1a }
            r5.zzZ(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r5.zzs()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0ad0
            r2.zzW(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0ad3
        L_0x0ad0:
            r2.zzs()     // Catch:{ all -> 0x0d1a }
        L_0x0ad3:
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r6)     // Catch:{ all -> 0x0d1a }
            r6.zzD(r5)     // Catch:{ all -> 0x0d1a }
        L_0x0adb:
            int r5 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r5 <= 0) goto L_0x0c5f
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn     // Catch:{ all -> 0x0d1a }
            r5.zzaw()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r5 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r6 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzff r5 = r5.zze(r6)     // Catch:{ all -> 0x0d1a }
            r6 = -1
            if (r5 == 0) goto L_0x0b08
            boolean r8 = r5.zzs()     // Catch:{ all -> 0x0d1a }
            if (r8 != 0) goto L_0x0b00
            goto L_0x0b08
        L_0x0b00:
            long r8 = r5.zzc()     // Catch:{ all -> 0x0d1a }
            r2.zzK(r8)     // Catch:{ all -> 0x0d1a }
            goto L_0x0b2f
        L_0x0b08:
            com.google.android.gms.internal.measurement.zzgd r5 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = r5.zzF()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0b18
            r2.zzK(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0b2f
        L_0x0b18:
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0b2f:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzkf r2 = r2.zzaC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgd r2 = (com.google.android.gms.internal.measurement.zzgd) r2     // Catch:{ all -> 0x0d1a }
            r5.zzg()     // Catch:{ all -> 0x0d1a }
            r5.zzW()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0d1a }
            boolean r8 = r2.zzbe()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0d1a }
            r5.zzz()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r8 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.util.Clock r8 = r8.zzav()     // Catch:{ all -> 0x0d1a }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0d1a }
            long r10 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r12 = r5.zzt     // Catch:{ all -> 0x0d1a }
            r12.zzf()     // Catch:{ all -> 0x0d1a }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0d1a }
            long r12 = r8 - r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0b83
            long r10 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r12 = r5.zzt     // Catch:{ all -> 0x0d1a }
            r12.zzf()     // Catch:{ all -> 0x0d1a }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0d1a }
            long r12 = r12 + r8
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0ba6
        L_0x0b83:
            com.google.android.gms.measurement.internal.zzfr r10 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0d1a }
            long r13 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d1a }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0ba6:
            byte[] r8 = r2.zzbu()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkt r9 = r5.zzf     // Catch:{ IOException -> 0x0c46 }
            com.google.android.gms.measurement.internal.zzkv r9 = r9.zzi     // Catch:{ IOException -> 0x0c46 }
            zzal(r9)     // Catch:{ IOException -> 0x0c46 }
            byte[] r8 = r9.zzy(r8)     // Catch:{ IOException -> 0x0c46 }
            com.google.android.gms.measurement.internal.zzfr r9 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0d1a }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0d1a }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0d1a }
            r9.<init>()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0d1a }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0d1a }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d1a }
            boolean r8 = r2.zzbk()     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0c05
            java.lang.String r8 = "retry_count"
            int r10 = r2.zze()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0d1a }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d1a }
        L_0x0c05:
            android.database.sqlite.SQLiteDatabase r8 = r5.zzh()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c2c }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0c5f
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzt     // Catch:{ SQLiteException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ SQLiteException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r2.zzx()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ SQLiteException -> 0x0c2c }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0c2c }
            goto L_0x0c5f
        L_0x0c2c:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r5.zzc(r7, r2, r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0c5f
        L_0x0c46:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r5.zzc(r7, r2, r6)     // Catch:{ all -> 0x0d1a }
        L_0x0c5f:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            java.util.List r3 = r3.zzb     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzg()     // Catch:{ all -> 0x0d1a }
            r2.zzW()     // Catch:{ all -> 0x0d1a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d1a }
            r6 = 0
        L_0x0c77:
            int r7 = r3.size()     // Catch:{ all -> 0x0d1a }
            if (r6 >= r7) goto L_0x0c94
            if (r6 == 0) goto L_0x0c84
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d1a }
        L_0x0c84:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d1a }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d1a }
            r5.append(r7)     // Catch:{ all -> 0x0d1a }
            int r6 = r6 + 1
            goto L_0x0c77
        L_0x0c94:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d1a }
            android.database.sqlite.SQLiteDatabase r6 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d1a }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d1a }
            int r6 = r3.size()     // Catch:{ all -> 0x0d1a }
            if (r5 == r6) goto L_0x0cc9
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d1a }
            int r3 = r3.size()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r6, r5, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0cc9:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0ce1 }
            r6 = 0
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0ce1 }
            r6 = 1
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0ce1 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r3.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0ce1 }
            goto L_0x0cf6
        L_0x0ce1:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r5, r4, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0cf6:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            r2.zzC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            r1 = 1
            return r1
        L_0x0d08:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzal(r2)     // Catch:{ all -> 0x0d1a }
            r2.zzC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            r1 = 0
            return r1
        L_0x0d1a:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzam zzam = this.zze;
        zzal(zzam);
        if (zzam.zzF()) {
            return true;
        }
        zzam zzam2 = this.zze;
        zzal(zzam2);
        return !TextUtils.isEmpty(zzam2.zzr());
    }

    private final boolean zzaj(zzfs zzfs, zzfs zzfs2) {
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB2 = zzkv.zzB((zzft) zzfs.zzaC(), "_sc");
        String str = null;
        String zzh2 = zzB2 == null ? null : zzB2.zzh();
        zzal(this.zzi);
        zzfx zzB3 = zzkv.zzB((zzft) zzfs2.zzaC(), "_pc");
        if (zzB3 != null) {
            str = zzB3.zzh();
        }
        if (str == null || !str.equals(zzh2)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB4 = zzkv.zzB((zzft) zzfs.zzaC(), "_et");
        if (zzB4 == null || !zzB4.zzw() || zzB4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzB4.zzd();
        zzal(this.zzi);
        zzfx zzB5 = zzkv.zzB((zzft) zzfs2.zzaC(), "_et");
        if (zzB5 != null && zzB5.zzd() > 0) {
            zzd2 += zzB5.zzd();
        }
        zzal(this.zzi);
        zzkv.zzz(zzfs2, "_et", Long.valueOf(zzd2));
        zzal(this.zzi);
        zzkv.zzz(zzfs, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzq2) {
        return !TextUtils.isEmpty(zzq2.zzb) || !TextUtils.isEmpty(zzq2.zzq);
    }

    private static final zzkh zzal(zzkh zzkh) {
        if (zzkh == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzkh.zzY()) {
            return zzkh;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzkh.getClass()))));
        }
    }

    public static zzkt zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkt.class) {
                if (zzb == null) {
                    zzb = new zzkt((zzku) Preconditions.checkNotNull(new zzku(context)), (zzfr) null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzkt zzkt, zzku zzku) {
        zzkt.zzaz().zzg();
        zzkt.zzm = new zzez(zzkt);
        zzam zzam = new zzam(zzkt);
        zzam.zzX();
        zzkt.zze = zzam;
        zzkt.zzg().zzq((zzaf) Preconditions.checkNotNull(zzkt.zzc));
        zzjo zzjo = new zzjo(zzkt);
        zzjo.zzX();
        zzkt.zzk = zzjo;
        zzaa zzaa = new zzaa(zzkt);
        zzaa.zzX();
        zzkt.zzh = zzaa;
        zzic zzic = new zzic(zzkt);
        zzic.zzX();
        zzkt.zzj = zzic;
        zzkf zzkf = new zzkf(zzkt);
        zzkf.zzX();
        zzkt.zzg = zzkf;
        zzkt.zzf = new zzep(zzkt);
        if (zzkt.zzr != zzkt.zzs) {
            zzkt.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzkt.zzr), Integer.valueOf(zzkt.zzs));
        }
        zzkt.zzo = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzx;
                zzaz().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzay().zzd().zzb("Failed to read from channel", e);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaz().zzg();
                if (i > zzi2) {
                    zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                } else if (i < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaz().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzay().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e2) {
                            zzay().zzd().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzC(String str, zzgc zzgc) {
        int zza2;
        int indexOf;
        zzfi zzfi = this.zzc;
        zzal(zzfi);
        Set zzk2 = zzfi.zzk(str);
        if (zzk2 != null) {
            zzgc.zzi(zzk2);
        }
        zzfi zzfi2 = this.zzc;
        zzal(zzfi2);
        if (zzfi2.zzv(str)) {
            zzgc.zzp();
        }
        zzfi zzfi3 = this.zzc;
        zzal(zzfi3);
        if (zzfi3.zzy(str)) {
            if (zzg().zzs(str, zzdu.zzaq)) {
                String zzar = zzgc.zzar();
                if (!TextUtils.isEmpty(zzar) && (indexOf = zzar.indexOf(".")) != -1) {
                    zzgc.zzY(zzar.substring(0, indexOf));
                }
            } else {
                zzgc.zzu();
            }
        }
        zzfi zzfi4 = this.zzc;
        zzal(zzfi4);
        if (zzfi4.zzz(str) && (zza2 = zzkv.zza(zzgc, "_id")) != -1) {
            zzgc.zzB(zza2);
        }
        zzfi zzfi5 = this.zzc;
        zzal(zzfi5);
        if (zzfi5.zzx(str)) {
            zzgc.zzq();
        }
        zzfi zzfi6 = this.zzc;
        zzal(zzfi6);
        if (zzfi6.zzu(str)) {
            zzgc.zzn();
            zzks zzks = (zzks) this.zzC.get(str);
            if (zzks == null || zzks.zzb + zzg().zzi(str, zzdu.zzR) < zzav().elapsedRealtime()) {
                zzks = new zzks(this);
                this.zzC.put(str, zzks);
            }
            zzgc.zzR(zzks.zza);
        }
        zzfi zzfi7 = this.zzc;
        zzal(zzfi7);
        if (zzfi7.zzw(str)) {
            zzgc.zzy();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(zzh zzh2) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzaz().zzg();
        if (!TextUtils.isEmpty(zzh2.zzy()) || !TextUtils.isEmpty(zzh2.zzr())) {
            zzki zzki = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String zzy2 = zzh2.zzy();
            if (TextUtils.isEmpty(zzy2)) {
                zzy2 = zzh2.zzr();
            }
            ArrayMap arrayMap3 = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) zzdu.zzd.zza((Object) null)).encodedAuthority((String) zzdu.zze.zza((Object) null)).path("config/app/".concat(String.valueOf(zzy2))).appendQueryParameter("platform", "android");
            zzki.zzt.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(zzh2.zzt());
                URL url = new URL(uri);
                zzay().zzj().zzb("Fetching remote configuration", str);
                zzfi zzfi = this.zzc;
                zzal(zzfi);
                zzff zze2 = zzfi.zze(str);
                zzfi zzfi2 = this.zzc;
                zzal(zzfi2);
                String zzh3 = zzfi2.zzh(str);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(zzh3)) {
                        arrayMap2 = new ArrayMap();
                        arrayMap2.put("If-Modified-Since", zzh3);
                    } else {
                        arrayMap2 = null;
                    }
                    zzox.zzc();
                    if (zzg().zzs((String) null, zzdu.zzao)) {
                        zzfi zzfi3 = this.zzc;
                        zzal(zzfi3);
                        String zzf2 = zzfi3.zzf(str);
                        if (!TextUtils.isEmpty(zzf2)) {
                            if (arrayMap2 == null) {
                                arrayMap2 = new ArrayMap();
                            }
                            arrayMap3 = arrayMap2;
                            arrayMap3.put("If-None-Match", zzf2);
                        }
                    }
                    arrayMap = arrayMap2;
                    this.zzt = true;
                    zzen zzen = this.zzd;
                    zzal(zzen);
                    zzkl zzkl = new zzkl(this);
                    zzen.zzg();
                    zzen.zzW();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(zzkl);
                    zzen.zzt.zzaz().zzo(new zzem(zzen, str, url, (byte[]) null, arrayMap, zzkl));
                }
                arrayMap = arrayMap3;
                this.zzt = true;
                zzen zzen2 = this.zzd;
                zzal(zzen2);
                zzkl zzkl2 = new zzkl(this);
                zzen2.zzg();
                zzen2.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzkl2);
                zzen2.zzt.zzaz().zzo(new zzem(zzen2, str, url, (byte[]) null, arrayMap, zzkl2));
            } catch (MalformedURLException unused) {
                zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeh.zzn(zzh2.zzt()), uri);
            }
        } else {
            zzI((String) Preconditions.checkNotNull(zzh2.zzt()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(zzaw zzaw, zzq zzq2) {
        zzaw zzaw2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq3 = zzq2;
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq3.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzq3.zza;
        long j = zzaw.zzd;
        zzei zzb2 = zzei.zzb(zzaw);
        zzaz().zzg();
        zzie zzie = null;
        if (!(this.zzD == null || (str = this.zzE) == null || !str.equals(str2))) {
            zzie = this.zzD;
        }
        zzlb.zzK(zzie, zzb2.zzd, false);
        zzaw zza2 = zzb2.zza();
        zzal(this.zzi);
        if (zzkv.zzA(zza2, zzq3)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            List list4 = zzq3.zzt;
            if (list4 == null) {
                zzaw2 = zza2;
            } else if (list4.contains(zza2.zza)) {
                Bundle zzc2 = zza2.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzaw2 = new zzaw(zza2.zza, new zzau(zzc2), zza2.zzc, zza2.zzd);
            } else {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza2.zza, zza2.zzc);
                return;
            }
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                Preconditions.checkNotEmpty(str2);
                zzam2.zzg();
                zzam2.zzW();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzam2.zzt.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeh.zzn(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzam2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        zzay().zzj().zzd("User property timed out", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb), zzac.zzc.zza());
                        zzaw zzaw3 = zzac.zzg;
                        if (zzaw3 != null) {
                            zzY(new zzaw(zzaw3, j), zzq3);
                        }
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str2, zzac.zzc.zzb);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                Preconditions.checkNotEmpty(str2);
                zzam4.zzg();
                zzam4.zzW();
                if (i < 0) {
                    zzam4.zzt.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeh.zzn(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzam4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList<zzaw> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        zzay().zzj().zzd("User property expired", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                        zzam zzam5 = this.zze;
                        zzal(zzam5);
                        zzam5.zzA(str2, zzac2.zzc.zzb);
                        zzaw zzaw4 = zzac2.zzk;
                        if (zzaw4 != null) {
                            arrayList.add(zzaw4);
                        }
                        zzam zzam6 = this.zze;
                        zzal(zzam6);
                        zzam6.zza(str2, zzac2.zzc.zzb);
                    }
                }
                for (zzaw zzaw5 : arrayList) {
                    zzY(new zzaw(zzaw5, j), zzq3);
                }
                zzam zzam7 = this.zze;
                zzal(zzam7);
                String str3 = zzaw2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzam7.zzg();
                zzam7.zzW();
                if (i < 0) {
                    zzam7.zzt.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), zzam7.zzt.zzj().zzd(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzam7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList<zzaw> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzkw zzkw = zzac3.zzc;
                        zzky zzky = new zzky((String) Preconditions.checkNotNull(zzac3.zza), zzac3.zzb, zzkw.zzb, j, Preconditions.checkNotNull(zzkw.zza()));
                        zzam zzam8 = this.zze;
                        zzal(zzam8);
                        if (zzam8.zzL(zzky)) {
                            zzay().zzj().zzd("User property triggered", zzac3.zza, this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeh.zzn(zzac3.zza), this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                        }
                        zzaw zzaw6 = zzac3.zzi;
                        if (zzaw6 != null) {
                            arrayList2.add(zzaw6);
                        }
                        zzac3.zzc = new zzkw(zzky);
                        zzac3.zze = true;
                        zzam zzam9 = this.zze;
                        zzal(zzam9);
                        zzam9.zzK(zzac3);
                    }
                }
                zzY(zzaw2, zzq3);
                for (zzaw zzaw7 : arrayList2) {
                    zzY(new zzaw(zzaw7, j), zzq3);
                }
                zzam zzam10 = this.zze;
                zzal(zzam10);
                zzam10.zzC();
            } finally {
                zzam zzam11 = this.zze;
                zzal(zzam11);
                zzam11.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzF(zzaw zzaw, String str) {
        zzaw zzaw2 = zzaw;
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null) {
            if (!"_ui".equals(zzaw2.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeh.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeh.zzn(str));
            return;
        }
        String zzy2 = zzj2.zzy();
        String zzw2 = zzj2.zzw();
        long zzb2 = zzj2.zzb();
        String zzv2 = zzj2.zzv();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        boolean zzai = zzj2.zzai();
        String zzx2 = zzj2.zzx();
        zzj2.zza();
        zzq zzq2 = r2;
        zzq zzq3 = new zzq(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzai, false, zzx2, 0, 0, 0, zzj2.zzah(), false, zzj2.zzr(), zzj2.zzq(), zzj2.zzk(), zzj2.zzC(), (String) null, zzh(str2).zzh(), "", (String) null);
        zzG(zzaw2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzG(zzaw zzaw, zzq zzq2) {
        Preconditions.checkNotEmpty(zzq2.zza);
        zzei zzb2 = zzei.zzb(zzaw);
        zzlb zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzam zzam = this.zze;
        zzal(zzam);
        zzv2.zzL(bundle, zzam.zzi(zzq2.zza));
        zzv().zzM(zzb2, zzg().zzd(zzq2.zza));
        zzaw zza2 = zzb2.zza();
        if ("_cmp".equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzW(new zzkw("_lgclid", zza2.zzd, zzg2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzq2);
            }
        }
        zzE(zza2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzH() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0104 A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011b A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0138 A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0146 A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0168 A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016c A[Catch:{ all -> 0x0185, all -> 0x018f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzfo r0 = r8.zzaz()
            r0.zzg()
            r8.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0012
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x018f }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzeh r1 = r8.zzay()     // Catch:{ all -> 0x018f }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()     // Catch:{ all -> 0x018f }
            int r2 = r12.length     // Catch:{ all -> 0x018f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x018f }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x018f }
            com.google.android.gms.measurement.internal.zzam r1 = r8.zze     // Catch:{ all -> 0x018f }
            zzal(r1)     // Catch:{ all -> 0x018f }
            r1.zzw()     // Catch:{ all -> 0x018f }
            com.google.android.gms.measurement.internal.zzam r1 = r8.zze     // Catch:{ all -> 0x0185 }
            zzal(r1)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzj(r9)     // Catch:{ all -> 0x0185 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r10 == r3) goto L_0x0042
            r3 = 204(0xcc, float:2.86E-43)
            if (r10 == r3) goto L_0x0042
            if (r10 != r4) goto L_0x0046
            r10 = r4
        L_0x0042:
            if (r11 != 0) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = r0
        L_0x0047:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzeh r10 = r8.zzay()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzk()     // Catch:{ all -> 0x0185 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0185 }
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0185 }
            goto L_0x016f
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00ba
            if (r10 != r5) goto L_0x0063
            goto L_0x00ba
        L_0x0063:
            com.google.android.gms.common.util.Clock r12 = r8.zzav()     // Catch:{ all -> 0x0185 }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x0185 }
            r1.zzU(r12)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzam r12 = r8.zze     // Catch:{ all -> 0x0185 }
            zzal(r12)     // Catch:{ all -> 0x0185 }
            r12.zzD(r1)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzeh r12 = r8.zzay()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzj()     // Catch:{ all -> 0x0185 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0185 }
            r12.zzc(r13, r1, r11)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzfi r11 = r8.zzc     // Catch:{ all -> 0x0185 }
            zzal(r11)     // Catch:{ all -> 0x0185 }
            r11.zzl(r9)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzjo r9 = r8.zzk     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzd     // Catch:{ all -> 0x0185 }
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0185 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0185 }
            r9.zzb(r11)     // Catch:{ all -> 0x0185 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00a6
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b5
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzjo r9 = r8.zzk     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzb     // Catch:{ all -> 0x0185 }
            com.google.android.gms.common.util.Clock r10 = r8.zzav()     // Catch:{ all -> 0x0185 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0185 }
            r9.zzb(r10)     // Catch:{ all -> 0x0185 }
        L_0x00b5:
            r8.zzag()     // Catch:{ all -> 0x0185 }
            goto L_0x016f
        L_0x00ba:
            r11 = 0
            if (r13 == 0) goto L_0x00c6
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r3 = r13.get(r3)     // Catch:{ all -> 0x0185 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0185 }
            goto L_0x00c7
        L_0x00c6:
            r3 = r11
        L_0x00c7:
            if (r3 == 0) goto L_0x00d6
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0185 }
            if (r6 != 0) goto L_0x00d6
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0185 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0185 }
            goto L_0x00d7
        L_0x00d6:
            r3 = r11
        L_0x00d7:
            com.google.android.gms.internal.measurement.zzox.zzc()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzag r6 = r8.zzg()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzao     // Catch:{ all -> 0x0185 }
            boolean r6 = r6.zzs(r11, r7)     // Catch:{ all -> 0x0185 }
            if (r6 == 0) goto L_0x0101
            if (r13 == 0) goto L_0x00f1
            java.lang.String r6 = "ETag"
            java.lang.Object r13 = r13.get(r6)     // Catch:{ all -> 0x0185 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0185 }
            goto L_0x00f2
        L_0x00f1:
            r13 = r11
        L_0x00f2:
            if (r13 == 0) goto L_0x0101
            boolean r6 = r13.isEmpty()     // Catch:{ all -> 0x0185 }
            if (r6 != 0) goto L_0x0101
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0185 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0185 }
            goto L_0x0102
        L_0x0101:
            r13 = r11
        L_0x0102:
            if (r10 == r5) goto L_0x0110
            if (r10 != r4) goto L_0x0107
            goto L_0x0110
        L_0x0107:
            com.google.android.gms.measurement.internal.zzfi r11 = r8.zzc     // Catch:{ all -> 0x0185 }
            zzal(r11)     // Catch:{ all -> 0x0185 }
            r11.zzt(r9, r12, r3, r13)     // Catch:{ all -> 0x0185 }
            goto L_0x0123
        L_0x0110:
            com.google.android.gms.measurement.internal.zzfi r12 = r8.zzc     // Catch:{ all -> 0x0185 }
            zzal(r12)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.internal.measurement.zzff r12 = r12.zze(r9)     // Catch:{ all -> 0x0185 }
            if (r12 != 0) goto L_0x0123
            com.google.android.gms.measurement.internal.zzfi r12 = r8.zzc     // Catch:{ all -> 0x0185 }
            zzal(r12)     // Catch:{ all -> 0x0185 }
            r12.zzt(r9, r11, r11, r11)     // Catch:{ all -> 0x0185 }
        L_0x0123:
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0185 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0185 }
            r1.zzL(r11)     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzam r11 = r8.zze     // Catch:{ all -> 0x0185 }
            zzal(r11)     // Catch:{ all -> 0x0185 }
            r11.zzD(r1)     // Catch:{ all -> 0x0185 }
            if (r10 != r5) goto L_0x0146
            com.google.android.gms.measurement.internal.zzeh r10 = r8.zzay()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzl()     // Catch:{ all -> 0x0185 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0185 }
            goto L_0x0157
        L_0x0146:
            com.google.android.gms.measurement.internal.zzeh r9 = r8.zzay()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x0185 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0185 }
            r9.zzc(r11, r10, r2)     // Catch:{ all -> 0x0185 }
        L_0x0157:
            com.google.android.gms.measurement.internal.zzen r9 = r8.zzd     // Catch:{ all -> 0x0185 }
            zzal(r9)     // Catch:{ all -> 0x0185 }
            boolean r9 = r9.zza()     // Catch:{ all -> 0x0185 }
            if (r9 == 0) goto L_0x016c
            boolean r9 = r8.zzai()     // Catch:{ all -> 0x0185 }
            if (r9 == 0) goto L_0x016c
            r8.zzX()     // Catch:{ all -> 0x0185 }
            goto L_0x016f
        L_0x016c:
            r8.zzag()     // Catch:{ all -> 0x0185 }
        L_0x016f:
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x0185 }
            zzal(r9)     // Catch:{ all -> 0x0185 }
            r9.zzC()     // Catch:{ all -> 0x0185 }
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x018f }
            zzal(r9)     // Catch:{ all -> 0x018f }
            r9.zzx()     // Catch:{ all -> 0x018f }
            r8.zzt = r0
            r8.zzae()
            return
        L_0x0185:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzam r10 = r8.zze     // Catch:{ all -> 0x018f }
            zzal(r10)     // Catch:{ all -> 0x018f }
            r10.zzx()     // Catch:{ all -> 0x018f }
            throw r9     // Catch:{ all -> 0x018f }
        L_0x018f:
            r9 = move-exception
            r8.zzt = r0
            r8.zzae()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(boolean z) {
        zzag();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzK(int i, Throwable th, byte[] bArr, String str) {
        zzam zzam;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzae();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzy(list);
            zzag();
            this.zzu = false;
            zzae();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzam = this.zze;
                            zzal(zzam);
                            long longValue = l.longValue();
                            zzam.zzg();
                            zzam.zzW();
                            if (zzam.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzam.zzt.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List list2 = this.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                    this.zzz = null;
                    zzen zzen = this.zzd;
                    zzal(zzen);
                    if (!zzen.zza() || !zzai()) {
                        this.zzA = -1;
                        zzag();
                    } else {
                        zzX();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzae();
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        zzam zzam22 = this.zze;
        zzal(zzam22);
        zzam22.zzy(list);
        zzag();
        this.zzu = false;
        zzae();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03eb A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0417 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x042c A[SYNTHETIC, Splitter:B:133:0x042c] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04d7 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x04f4 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0554 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0142 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0202 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0206 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0260 A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x026f A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027f A[Catch:{ RuntimeException -> 0x0375, all -> 0x0582 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(com.google.android.gms.measurement.internal.zzq r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfo r8 = r24.zzaz()
            r8.zzg()
            r24.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = zzak(r25)
            if (r8 == 0) goto L_0x058c
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze
            zzal(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzh r8 = r8.zzj(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.zzy()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.zzL(r9)
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze
            zzal(r11)
            r11.zzD(r8)
            com.google.android.gms.measurement.internal.zzfi r8 = r1.zzc
            zzal(r8)
            java.lang.String r11 = r2.zza
            r8.zzm(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r24.zzd(r25)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r24.zzav()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfr r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()
            r8.zzd()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzeh r13 = r24.zzay()
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzk()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze
            zzal(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r9)     // Catch:{ all -> 0x0582 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0582 }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzky r9 = r9.zzp(r10, r13)     // Catch:{ all -> 0x0582 }
            if (r9 == 0) goto L_0x00c5
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.zzb     // Catch:{ all -> 0x0582 }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x0582 }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            r21 = r3
            r22 = r4
            r4 = r15
            r3 = 0
            goto L_0x0119
        L_0x00c5:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x0582 }
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzkw r10 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_npa"
            java.lang.Boolean r13 = r2.zzr     // Catch:{ all -> 0x0582 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0582 }
            if (r15 == r13) goto L_0x00d8
            r19 = 0
            goto L_0x00da
        L_0x00d8:
            r19 = 1
        L_0x00da:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0582 }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r10
            r3 = 0
            r4 = r15
            r15 = r11
            r17 = r19
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0582 }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0582 }
            java.lang.Long r13 = r10.zzd     // Catch:{ all -> 0x0582 }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x0582 }
            if (r9 != 0) goto L_0x0119
        L_0x00fd:
            r1.zzW(r10, r2)     // Catch:{ all -> 0x0582 }
            goto L_0x0119
        L_0x0101:
            r21 = r3
            r22 = r4
            r4 = r15
            r3 = 0
            if (r9 == 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzkw r9 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_npa"
            java.lang.String r18 = "auto"
            r17 = 0
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0582 }
            r1.zzP(r9, r2)     // Catch:{ all -> 0x0582 }
        L_0x0119:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r9)     // Catch:{ all -> 0x0582 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0582 }
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x0582 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x0582 }
            if (r9 == 0) goto L_0x0202
            com.google.android.gms.measurement.internal.zzlb r13 = r24.zzv()     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x0582 }
            java.lang.String r15 = r9.zzy()     // Catch:{ all -> 0x0582 }
            java.lang.String r10 = r2.zzq     // Catch:{ all -> 0x0582 }
            java.lang.String r3 = r9.zzr()     // Catch:{ all -> 0x0582 }
            boolean r3 = r13.zzam(r14, r15, r10, r3)     // Catch:{ all -> 0x0582 }
            if (r3 == 0) goto L_0x0202
            com.google.android.gms.measurement.internal.zzeh r3 = r24.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x0582 }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r9.zzt()     // Catch:{ all -> 0x0582 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ all -> 0x0582 }
            r3.zzb(r10, r13)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r3)     // Catch:{ all -> 0x0582 }
            java.lang.String r9 = r9.zzt()     // Catch:{ all -> 0x0582 }
            r3.zzW()     // Catch:{ all -> 0x0582 }
            r3.zzg()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ all -> 0x0582 }
            android.database.sqlite.SQLiteDatabase r10 = r3.zzh()     // Catch:{ SQLiteException -> 0x01ea }
            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x01ea }
            r14 = 0
            r13[r14] = r9     // Catch:{ SQLiteException -> 0x01ea }
            java.lang.String r14 = "events"
            int r14 = r10.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            java.lang.String r15 = "user_attributes"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ea }
            int r14 = r14 + r15
            com.google.android.gms.internal.measurement.zzoi.zzc()     // Catch:{ SQLiteException -> 0x01ea }
            com.google.android.gms.measurement.internal.zzfr r15 = r3.zzt     // Catch:{ SQLiteException -> 0x01ea }
            com.google.android.gms.measurement.internal.zzag r15 = r15.zzf()     // Catch:{ SQLiteException -> 0x01ea }
            com.google.android.gms.measurement.internal.zzdt r4 = com.google.android.gms.measurement.internal.zzdu.zzat     // Catch:{ SQLiteException -> 0x01ea }
            r23 = r6
            r6 = 0
            boolean r4 = r15.zzs(r6, r4)     // Catch:{ SQLiteException -> 0x01e8 }
            if (r4 == 0) goto L_0x01d2
            java.lang.String r4 = "default_event_params"
            int r0 = r10.delete(r4, r0, r13)     // Catch:{ SQLiteException -> 0x01e8 }
            int r14 = r14 + r0
        L_0x01d2:
            if (r14 <= 0) goto L_0x0200
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt     // Catch:{ SQLiteException -> 0x01e8 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x01e8 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01e8 }
            java.lang.String r4 = "Deleted application data. app, records"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01e8 }
            r0.zzc(r4, r9, r6)     // Catch:{ SQLiteException -> 0x01e8 }
            goto L_0x0200
        L_0x01e8:
            r0 = move-exception
            goto L_0x01ed
        L_0x01ea:
            r0 = move-exception
            r23 = r6
        L_0x01ed:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0582 }
            java.lang.String r4 = "Error deleting application data. appId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0582 }
            r3.zzc(r4, r6, r0)     // Catch:{ all -> 0x0582 }
        L_0x0200:
            r9 = 0
            goto L_0x0204
        L_0x0202:
            r23 = r6
        L_0x0204:
            if (r9 == 0) goto L_0x025b
            long r3 = r9.zzb()     // Catch:{ all -> 0x0582 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021d
            long r3 = r9.zzb()     // Catch:{ all -> 0x0582 }
            long r13 = r2.zzj     // Catch:{ all -> 0x0582 }
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021d
            r0 = 1
            goto L_0x021e
        L_0x021d:
            r0 = 0
        L_0x021e:
            java.lang.String r3 = r9.zzw()     // Catch:{ all -> 0x0582 }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0582 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r4 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0239
            if (r3 == 0) goto L_0x0239
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x0582 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0582 }
            if (r4 != 0) goto L_0x0239
            r15 = 1
            goto L_0x023a
        L_0x0239:
            r15 = 0
        L_0x023a:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x025b
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0582 }
            r0.<init>()     // Catch:{ all -> 0x0582 }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0582 }
            r15.<init>(r0)     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0582 }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x0582 }
        L_0x025b:
            r24.zzd(r25)     // Catch:{ all -> 0x0582 }
            if (r8 != 0) goto L_0x026f
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r0)     // Catch:{ all -> 0x0582 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0582 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0582 }
            r15 = 0
            goto L_0x027d
        L_0x026f:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r0)     // Catch:{ all -> 0x0582 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0582 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0582 }
            r15 = 1
        L_0x027d:
            if (r0 != 0) goto L_0x0554
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r3
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x050c
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0582 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0582 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfo r0 = r24.zzaz()     // Catch:{ all -> 0x0582 }
            r0.zzg()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzez r0 = r1.zzm     // Catch:{ all -> 0x0582 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0582 }
            r8 = r0
            com.google.android.gms.measurement.internal.zzez r8 = (com.google.android.gms.measurement.internal.zzez) r8     // Catch:{ all -> 0x0582 }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0582 }
            if (r0 == 0) goto L_0x03aa
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x0582 }
            if (r9 == 0) goto L_0x02c0
            goto L_0x03aa
        L_0x02c0:
            com.google.android.gms.measurement.internal.zzfr r9 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfo r9 = r9.zzaz()     // Catch:{ all -> 0x0582 }
            r9.zzg()     // Catch:{ all -> 0x0582 }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x0582 }
            if (r9 != 0) goto L_0x02e0
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x0582 }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.zza(r5)     // Catch:{ all -> 0x0582 }
            goto L_0x03b9
        L_0x02e0:
            com.google.android.gms.measurement.internal.zzey r9 = new com.google.android.gms.measurement.internal.zzey     // Catch:{ all -> 0x0582 }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()     // Catch:{ all -> 0x0582 }
            r0.zzg()     // Catch:{ all -> 0x0582 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0582 }
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r13)     // Catch:{ all -> 0x0582 }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r13.<init>(r5, r14)     // Catch:{ all -> 0x0582 }
            r0.setComponent(r13)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfr r13 = r8.zza     // Catch:{ all -> 0x0582 }
            android.content.Context r13 = r13.zzau()     // Catch:{ all -> 0x0582 }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x0582 }
            if (r13 != 0) goto L_0x031c
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x0582 }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0582 }
            goto L_0x03b9
        L_0x031c:
            r14 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r14)     // Catch:{ all -> 0x0582 }
            if (r13 == 0) goto L_0x039a
            boolean r15 = r13.isEmpty()     // Catch:{ all -> 0x0582 }
            if (r15 != 0) goto L_0x039a
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x0582 }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x0582 }
            android.content.pm.ServiceInfo r14 = r13.serviceInfo     // Catch:{ all -> 0x0582 }
            if (r14 == 0) goto L_0x03b9
            android.content.pm.ServiceInfo r14 = r13.serviceInfo     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = r14.packageName     // Catch:{ all -> 0x0582 }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x0582 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x0582 }
            if (r13 == 0) goto L_0x038a
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x0582 }
            if (r5 == 0) goto L_0x038a
            boolean r5 = r8.zza()     // Catch:{ all -> 0x0582 }
            if (r5 == 0) goto L_0x038a
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x0582 }
            r5.<init>(r0)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0375 }
            com.google.android.gms.measurement.internal.zzfr r13 = r8.zza     // Catch:{ RuntimeException -> 0x0375 }
            android.content.Context r13 = r13.zzau()     // Catch:{ RuntimeException -> 0x0375 }
            r14 = 1
            boolean r0 = r0.bindService(r13, r5, r9, r14)     // Catch:{ RuntimeException -> 0x0375 }
            com.google.android.gms.measurement.internal.zzfr r5 = r8.zza     // Catch:{ RuntimeException -> 0x0375 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ RuntimeException -> 0x0375 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzj()     // Catch:{ RuntimeException -> 0x0375 }
            java.lang.String r9 = "Install Referrer Service is"
            java.lang.String r13 = "available"
            java.lang.String r14 = "not available"
            r15 = 1
            if (r15 == r0) goto L_0x0371
            r13 = r14
        L_0x0371:
            r5.zzb(r9, r13)     // Catch:{ RuntimeException -> 0x0375 }
            goto L_0x03b9
        L_0x0375:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r5 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0582 }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0582 }
            r5.zzb(r8, r0)     // Catch:{ all -> 0x0582 }
            goto L_0x03b9
        L_0x038a:
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0582 }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0582 }
            goto L_0x03b9
        L_0x039a:
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x0582 }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r5)     // Catch:{ all -> 0x0582 }
            goto L_0x03b9
        L_0x03aa:
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x0582 }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r5)     // Catch:{ all -> 0x0582 }
        L_0x03b9:
            com.google.android.gms.measurement.internal.zzfo r0 = r24.zzaz()     // Catch:{ all -> 0x0582 }
            r0.zzg()     // Catch:{ all -> 0x0582 }
            r24.zzB()     // Catch:{ all -> 0x0582 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x0582 }
            r5.<init>()     // Catch:{ all -> 0x0582 }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0582 }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0582 }
            r13 = 0
            r5.putLong(r7, r13)     // Catch:{ all -> 0x0582 }
            r6 = r23
            r5.putLong(r6, r13)     // Catch:{ all -> 0x0582 }
            r10 = r22
            r5.putLong(r10, r13)     // Catch:{ all -> 0x0582 }
            r15 = r21
            r5.putLong(r15, r13)     // Catch:{ all -> 0x0582 }
            r5.putLong(r4, r8)     // Catch:{ all -> 0x0582 }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x0582 }
            if (r0 == 0) goto L_0x03ee
            r5.putLong(r3, r8)     // Catch:{ all -> 0x0582 }
        L_0x03ee:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0582 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0582 }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r0)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0582 }
            r0.zzg()     // Catch:{ all -> 0x0582 }
            r0.zzW()     // Catch:{ all -> 0x0582 }
            java.lang.String r4 = "first_open_count"
            long r13 = r0.zzc(r3, r4)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0582 }
            android.content.Context r0 = r0.zzau()     // Catch:{ all -> 0x0582 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0582 }
            if (r0 != 0) goto L_0x042c
            com.google.android.gms.measurement.internal.zzeh r0 = r24.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0582 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0582 }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x0582 }
        L_0x0428:
            r3 = 0
            goto L_0x04f0
        L_0x042c:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x043c }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x043c }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x043c }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x043c }
            goto L_0x044f
        L_0x043c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r4 = r24.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0582 }
            java.lang.String r8 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0582 }
            r4.zzc(r8, r9, r0)     // Catch:{ all -> 0x0582 }
            r0 = 0
        L_0x044f:
            if (r0 == 0) goto L_0x04a8
            long r8 = r0.firstInstallTime     // Catch:{ all -> 0x0582 }
            r16 = 0
            int r4 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x04a8
            long r8 = r0.firstInstallTime     // Catch:{ all -> 0x0582 }
            r21 = r3
            long r3 = r0.lastUpdateTime     // Catch:{ all -> 0x0582 }
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0488
            com.google.android.gms.measurement.internal.zzag r0 = r24.zzg()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzab     // Catch:{ all -> 0x0582 }
            r4 = 0
            boolean r0 = r0.zzs(r4, r3)     // Catch:{ all -> 0x0582 }
            if (r0 == 0) goto L_0x0482
            r8 = 0
            int r0 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x047f
            r8 = 1
            r5.putLong(r7, r8)     // Catch:{ all -> 0x0582 }
            r0 = 0
            r7 = 0
            goto L_0x048b
        L_0x047f:
            r7 = r13
            r0 = 0
            goto L_0x048b
        L_0x0482:
            r8 = 1
            r5.putLong(r7, r8)     // Catch:{ all -> 0x0582 }
            goto L_0x047f
        L_0x0488:
            r4 = 0
            r7 = r13
            r0 = 1
        L_0x048b:
            com.google.android.gms.measurement.internal.zzkw r3 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_fi"
            r9 = 1
            if (r9 == r0) goto L_0x0495
            r16 = 0
            goto L_0x0497
        L_0x0495:
            r16 = 1
        L_0x0497:
            java.lang.Long r17 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0582 }
            java.lang.String r18 = "auto"
            r13 = r3
            r9 = r15
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0582 }
            r1.zzW(r3, r2)     // Catch:{ all -> 0x0582 }
            r13 = r7
            goto L_0x04ac
        L_0x04a8:
            r21 = r3
            r9 = r15
            r4 = 0
        L_0x04ac:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04c0 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x04c0 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04c0 }
            r3 = r21
            r7 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r3, r7)     // Catch:{ NameNotFoundException -> 0x04be }
            goto L_0x04d5
        L_0x04be:
            r0 = move-exception
            goto L_0x04c3
        L_0x04c0:
            r0 = move-exception
            r3 = r21
        L_0x04c3:
            com.google.android.gms.measurement.internal.zzeh r7 = r24.zzay()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()     // Catch:{ all -> 0x0582 }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0582 }
            r7.zzc(r8, r3, r0)     // Catch:{ all -> 0x0582 }
            r0 = r4
        L_0x04d5:
            if (r0 == 0) goto L_0x0428
            int r3 = r0.flags     // Catch:{ all -> 0x0582 }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04e3
            r3 = 1
            r5.putLong(r10, r3)     // Catch:{ all -> 0x0582 }
            goto L_0x04e5
        L_0x04e3:
            r3 = 1
        L_0x04e5:
            int r0 = r0.flags     // Catch:{ all -> 0x0582 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0428
            r5.putLong(r9, r3)     // Catch:{ all -> 0x0582 }
            goto L_0x0428
        L_0x04f0:
            int r0 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04f7
            r5.putLong(r6, r13)     // Catch:{ all -> 0x0582 }
        L_0x04f7:
            com.google.android.gms.measurement.internal.zzaw r0 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0582 }
            r15.<init>(r5)     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0582 }
            r1.zzG(r0, r2)     // Catch:{ all -> 0x0582 }
            goto L_0x0571
        L_0x050c:
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0582 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x0582 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzfo r0 = r24.zzaz()     // Catch:{ all -> 0x0582 }
            r0.zzg()     // Catch:{ all -> 0x0582 }
            r24.zzB()     // Catch:{ all -> 0x0582 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0582 }
            r0.<init>()     // Catch:{ all -> 0x0582 }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x0582 }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x0582 }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x0582 }
            boolean r4 = r2.zzp     // Catch:{ all -> 0x0582 }
            if (r4 == 0) goto L_0x053f
            r0.putLong(r3, r7)     // Catch:{ all -> 0x0582 }
        L_0x053f:
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0582 }
            r15.<init>(r0)     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0582 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0582 }
            goto L_0x0571
        L_0x0554:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x0582 }
            if (r0 == 0) goto L_0x0571
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0582 }
            r0.<init>()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0582 }
            r15.<init>(r0)     // Catch:{ all -> 0x0582 }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x0582 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0582 }
        L_0x0571:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0582 }
            zzal(r0)     // Catch:{ all -> 0x0582 }
            r0.zzC()     // Catch:{ all -> 0x0582 }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze
            zzal(r0)
            r0.zzx()
            return
        L_0x0582:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            throw r0
        L_0x058c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzL(com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzM() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzO(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (zzq2.zzh) {
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    String str = (String) Preconditions.checkNotNull(zzac.zza);
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzac zzk2 = zzam2.zzk(str, zzac.zzc.zzb);
                    if (zzk2 != null) {
                        zzay().zzc().zzc("Removing conditional user property", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb));
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str, zzac.zzc.zzb);
                        if (zzk2.zze) {
                            zzam zzam4 = this.zze;
                            zzal(zzam4);
                            zzam4.zzA(str, zzac.zzc.zzb);
                        }
                        zzaw zzaw = zzac.zzk;
                        if (zzaw != null) {
                            zzau zzau = zzaw.zzb;
                            zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzac.zzk)).zza, zzau != null ? zzau.zzc() : null, zzk2.zzb, zzac.zzk.zzd, true, true)), zzq2);
                        }
                    } else {
                        zzay().zzk().zzc("Conditional user property doesn't exist", zzeh.zzn(zzac.zza), this.zzn.zzj().zzf(zzac.zzc.zzb));
                    }
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzC();
                } finally {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                }
            } else {
                zzd(zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzP(zzkw zzkw, zzq zzq2) {
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
            } else if (!"_npa".equals(zzkw.zzb) || zzq2.zzr == null) {
                zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkw.zzb));
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    if ("_id".equals(zzkw.zzb)) {
                        zzam zzam2 = this.zze;
                        zzal(zzam2);
                        zzam2.zzA((String) Preconditions.checkNotNull(zzq2.zza), "_lair");
                    }
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    zzam3.zzA((String) Preconditions.checkNotNull(zzq2.zza), zzkw.zzb);
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkw.zzb));
                } finally {
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                }
            } else {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzkw("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzq2.zzr.booleanValue() ? 0 : 1), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzQ(zzq zzq2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzam = this.zze;
        zzal(zzam);
        String str = (String) Preconditions.checkNotNull(zzq2.zza);
        Preconditions.checkNotEmpty(str);
        zzam.zzg();
        zzam.zzW();
        try {
            SQLiteDatabase zzh2 = zzam.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete("events", "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzam.zzt.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzam.zzt.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeh.zzn(str), e);
        }
        if (zzq2.zzh) {
            zzL(zzq2);
        }
    }

    public final void zzR(String str, zzie zzie) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzie != null) {
            this.zzE = str;
            this.zzD = zzie;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzS() {
        zzaz().zzg();
        zzam zzam = this.zze;
        zzal(zzam);
        zzam.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    /* access modifiers changed from: package-private */
    public final void zzT(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzU(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzU(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzb);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z = false;
            zzac2.zze = false;
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                zzac zzk2 = zzam2.zzk((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzac2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzac2.zzb = zzk2.zzb;
                    zzac2.zzd = zzk2.zzd;
                    zzac2.zzh = zzk2.zzh;
                    zzac2.zzf = zzk2.zzf;
                    zzac2.zzi = zzk2.zzi;
                    zzac2.zze = true;
                    zzkw zzkw = zzac2.zzc;
                    zzac2.zzc = new zzkw(zzkw.zzb, zzk2.zzc.zzc, zzkw.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzac2.zzf)) {
                    zzkw zzkw2 = zzac2.zzc;
                    zzac2.zzc = new zzkw(zzkw2.zzb, zzac2.zzd, zzkw2.zza(), zzac2.zzc.zzf);
                    zzac2.zze = true;
                    z = true;
                }
                if (zzac2.zze) {
                    zzkw zzkw3 = zzac2.zzc;
                    zzky zzky = new zzky((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzb, zzkw3.zzb, zzkw3.zzc, Preconditions.checkNotNull(zzkw3.zza()));
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzL(zzky)) {
                        zzay().zzc().zzd("User property updated immediately", zzac2.zza, this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzac2.zza), this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                    }
                    if (z && zzac2.zzi != null) {
                        zzY(new zzaw(zzac2.zzi, zzac2.zzd), zzq2);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                if (zzam4.zzK(zzac2)) {
                    zzay().zzc().zzd("Conditional property added", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeh.zzn(zzac2.zza), this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                }
                zzam zzam5 = this.zze;
                zzal(zzam5);
                zzam5.zzC();
            } finally {
                zzam zzam6 = this.zze;
                zzal(zzam6);
                zzam6.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzV(String str, zzai zzai) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzai);
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzai);
        zzam.zzg();
        zzam.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzai.zzh());
        try {
            if (zzam.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzam.zzt.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e) {
            zzam.zzt.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeh.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzW(zzkw zzkw, zzq zzq2) {
        long j;
        zzkw zzkw2 = zzkw;
        zzq zzq3 = zzq2;
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            int zzl2 = zzv().zzl(zzkw2.zzb);
            int i = 0;
            if (zzl2 != 0) {
                zzlb zzv2 = zzv();
                String str = zzkw2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzkw2.zzb;
                zzv().zzN(this.zzF, zzq3.zza, zzl2, "_ev", zzD2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzkw2.zzb, zzkw.zza());
            if (zzd2 != 0) {
                zzlb zzv3 = zzv();
                String str3 = zzkw2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzkw.zza();
                if (zza2 != null && ((zza2 instanceof String) || (zza2 instanceof CharSequence))) {
                    i = zza2.toString().length();
                }
                zzv().zzN(this.zzF, zzq3.zza, zzd2, "_ev", zzD3, i);
                return;
            }
            Object zzB2 = zzv().zzB(zzkw2.zzb, zzkw.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzkw2.zzb)) {
                    long j2 = zzkw2.zzc;
                    String str4 = zzkw2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzq3.zza);
                    zzam zzam = this.zze;
                    zzal(zzam);
                    zzky zzp2 = zzam.zzp(str5, "_sno");
                    if (zzp2 != null) {
                        Object obj = zzp2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzW(new zzkw("_sno", j2, Long.valueOf(j + 1), str4), zzq3);
                        }
                    }
                    if (zzp2 != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp2.zze);
                    }
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzas zzn2 = zzam2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j = zzn2.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzW(new zzkw("_sno", j2, Long.valueOf(j + 1), str4), zzq3);
                }
                zzky zzky = new zzky((String) Preconditions.checkNotNull(zzq3.zza), (String) Preconditions.checkNotNull(zzkw2.zzf), zzkw2.zzb, zzkw2.zzc, zzB2);
                zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzky.zzc), zzB2);
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    if ("_id".equals(zzky.zzc)) {
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzky zzp3 = zzam4.zzp(zzq3.zza, "_id");
                        if (zzp3 != null && !zzky.zze.equals(zzp3.zze)) {
                            zzam zzam5 = this.zze;
                            zzal(zzam5);
                            zzam5.zzA(zzq3.zza, "_lair");
                        }
                    }
                    zzd(zzq3);
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    boolean zzL = zzam6.zzL(zzky);
                    zzam zzam7 = this.zze;
                    zzal(zzam7);
                    zzam7.zzC();
                    if (!zzL) {
                        zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                        zzv().zzN(this.zzF, zzq3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzam zzam8 = this.zze;
                    zzal(zzam8);
                    zzam8.zzx();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0280, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x054b, code lost:
        if (r11 != null) goto L_0x054d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0572, code lost:
        if (r11 != null) goto L_0x054d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0575, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010c, code lost:
        if (r11 != null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0116, code lost:
        if (r11 != null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012e, code lost:
        if (r11 != null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r1.zzA = r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:233:0x04ef */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02a7 A[SYNTHETIC, Splitter:B:164:0x02a7] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02b0 A[Catch:{ all -> 0x0502, all -> 0x0597 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0506 A[Catch:{ all -> 0x0502, all -> 0x0597 }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0593 A[SYNTHETIC, Splitter:B:275:0x0593] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0138 A[Catch:{ all -> 0x0134, all -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0597 }
            r0.zzaw()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzjm r0 = r0.zzt()     // Catch:{ all -> 0x0597 }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x0597 }
            if (r0 != 0) goto L_0x0038
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
        L_0x0030:
            r22.zzae()
            return
        L_0x0034:
            r0 = move-exception
            r2 = r3
            goto L_0x0599
        L_0x0038:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0597 }
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004e:
            long r4 = r1.zza     // Catch:{ all -> 0x0597 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x005c
            r22.zzag()     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x005c:
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()     // Catch:{ all -> 0x0597 }
            r0.zzg()     // Catch:{ all -> 0x0597 }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x0597 }
            if (r0 == 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0077:
            com.google.android.gms.measurement.internal.zzen r0 = r1.zzd     // Catch:{ all -> 0x0597 }
            zzal(r0)     // Catch:{ all -> 0x0597 }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0597 }
            if (r0 != 0) goto L_0x0095
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r22.zzag()     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0095:
            com.google.android.gms.common.util.Clock r0 = r22.zzav()     // Catch:{ all -> 0x0597 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzP     // Catch:{ all -> 0x0597 }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x0597 }
            r22.zzg()     // Catch:{ all -> 0x0597 }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0597 }
            long r10 = r4 - r10
            r8 = r3
        L_0x00b2:
            if (r8 >= r0) goto L_0x00bd
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x0034 }
            if (r12 == 0) goto L_0x00bd
            int r8 = r8 + 1
            goto L_0x00b2
        L_0x00bd:
            com.google.android.gms.measurement.internal.zzjo r0 = r1.zzk     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc     // Catch:{ all -> 0x0597 }
            long r10 = r0.zza()     // Catch:{ all -> 0x0597 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0034 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0034 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0034 }
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0597 }
            zzal(r0)     // Catch:{ all -> 0x0597 }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x0597 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0597 }
            r7 = -1
            if (r0 != 0) goto L_0x050a
            long r10 = r1.zzA     // Catch:{ all -> 0x0597 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x013c
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0034 }
            zzal(r10)     // Catch:{ all -> 0x0034 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x011d, all -> 0x011b }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x011d, all -> 0x011b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0119 }
            if (r0 != 0) goto L_0x0112
            if (r11 == 0) goto L_0x0131
        L_0x010e:
            r11.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0131
        L_0x0112:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0119 }
            if (r11 == 0) goto L_0x0131
            goto L_0x010e
        L_0x0119:
            r0 = move-exception
            goto L_0x011f
        L_0x011b:
            r0 = move-exception
            goto L_0x0136
        L_0x011d:
            r0 = move-exception
            r11 = r9
        L_0x011f:
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzt     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()     // Catch:{ all -> 0x0134 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0134 }
            if (r11 == 0) goto L_0x0131
            goto L_0x010e
        L_0x0131:
            r1.zzA = r7     // Catch:{ all -> 0x0034 }
            goto L_0x013c
        L_0x0134:
            r0 = move-exception
            r9 = r11
        L_0x0136:
            if (r9 == 0) goto L_0x013b
            r9.close()     // Catch:{ all -> 0x0034 }
        L_0x013b:
            throw r0     // Catch:{ all -> 0x0034 }
        L_0x013c:
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzf     // Catch:{ all -> 0x0597 }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzag r7 = r22.zzg()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzg     // Catch:{ all -> 0x0597 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x0597 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0597 }
            zzal(r8)     // Catch:{ all -> 0x0597 }
            r8.zzg()     // Catch:{ all -> 0x0597 }
            r8.zzW()     // Catch:{ all -> 0x0597 }
            if (r0 <= 0) goto L_0x0163
            r10 = r2
            goto L_0x0164
        L_0x0163:
            r10 = r3
        L_0x0164:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0597 }
            if (r7 <= 0) goto L_0x016b
            r10 = r2
            goto L_0x016c
        L_0x016b:
            r10 = r3
        L_0x016c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0597 }
            r10 = 2
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            java.lang.String r12 = "rowid"
            r13[r3] = r12     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            java.lang.String r12 = "data"
            r13[r2] = r12     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            java.lang.String r12 = "retry_count"
            r13[r10] = r12     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            r16 = 0
            r17 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x028a, all -> 0x0286 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0282 }
            if (r0 != 0) goto L_0x01af
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0282 }
            if (r11 == 0) goto L_0x01ab
            r11.close()     // Catch:{ all -> 0x0034 }
        L_0x01ab:
            r20 = r4
            goto L_0x02aa
        L_0x01af:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0282 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0282 }
            r13 = r3
        L_0x01b5:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0282 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0252 }
            com.google.android.gms.measurement.internal.zzkt r2 = r8.zzf     // Catch:{ IOException -> 0x0252 }
            com.google.android.gms.measurement.internal.zzkv r2 = r2.zzi     // Catch:{ IOException -> 0x0252 }
            zzal(r2)     // Catch:{ IOException -> 0x0252 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x023d }
            r9.<init>(r0)     // Catch:{ IOException -> 0x023d }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x023d }
            r0.<init>(r9)     // Catch:{ IOException -> 0x023d }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x023d }
            r3.<init>()     // Catch:{ IOException -> 0x023d }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x023d }
            r20 = r4
        L_0x01d9:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x023b }
            if (r4 > 0) goto L_0x0236
            r0.close()     // Catch:{ IOException -> 0x023b }
            r9.close()     // Catch:{ IOException -> 0x023b }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x023b }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0280 }
            if (r2 != 0) goto L_0x01f5
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0280 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01f5
            goto L_0x0279
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ IOException -> 0x0221 }
            com.google.android.gms.internal.measurement.zzll r2 = com.google.android.gms.measurement.internal.zzkv.zzl(r2, r0)     // Catch:{ IOException -> 0x0221 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ IOException -> 0x0221 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0280 }
            if (r4 != 0) goto L_0x020d
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0280 }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x0280 }
        L_0x020d:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0280 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzkf r0 = r2.zzaC()     // Catch:{ SQLiteException -> 0x0280 }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ SQLiteException -> 0x0280 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0280 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0280 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0280 }
            goto L_0x0268
        L_0x0221:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ SQLiteException -> 0x0280 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0280 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0280 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0280 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0280 }
            goto L_0x0268
        L_0x0236:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x023b }
            goto L_0x01d9
        L_0x023b:
            r0 = move-exception
            goto L_0x0240
        L_0x023d:
            r0 = move-exception
            r20 = r4
        L_0x0240:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ IOException -> 0x0250 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ IOException -> 0x0250 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ IOException -> 0x0250 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0250 }
            throw r0     // Catch:{ IOException -> 0x0250 }
        L_0x0250:
            r0 = move-exception
            goto L_0x0255
        L_0x0252:
            r0 = move-exception
            r20 = r4
        L_0x0255:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ SQLiteException -> 0x0280 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0280 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0280 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0280 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0280 }
        L_0x0268:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0280 }
            if (r0 == 0) goto L_0x0279
            if (r13 <= r7) goto L_0x0271
            goto L_0x0279
        L_0x0271:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            r10 = 2
            goto L_0x01b5
        L_0x0279:
            if (r11 == 0) goto L_0x027e
            r11.close()     // Catch:{ all -> 0x0597 }
        L_0x027e:
            r0 = r12
            goto L_0x02aa
        L_0x0280:
            r0 = move-exception
            goto L_0x028e
        L_0x0282:
            r0 = move-exception
            r20 = r4
            goto L_0x028e
        L_0x0286:
            r0 = move-exception
            r9 = 0
            goto L_0x0504
        L_0x028a:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x028e:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ all -> 0x0502 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0502 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0502 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x0502 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0502 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0502 }
            if (r11 == 0) goto L_0x02aa
            r11.close()     // Catch:{ all -> 0x0597 }
        L_0x02aa:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0597 }
            if (r2 != 0) goto L_0x058a
            com.google.android.gms.measurement.internal.zzai r2 = r1.zzh(r6)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzah r3 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0597 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x0597 }
            if (r2 == 0) goto L_0x0311
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0597 }
        L_0x02c0:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0597 }
            if (r3 == 0) goto L_0x02df
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0597 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0597 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgd r3 = (com.google.android.gms.internal.measurement.zzgd) r3     // Catch:{ all -> 0x0597 }
            java.lang.String r4 = r3.zzJ()     // Catch:{ all -> 0x0597 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0597 }
            if (r4 != 0) goto L_0x02c0
            java.lang.String r2 = r3.zzJ()     // Catch:{ all -> 0x0597 }
            goto L_0x02e0
        L_0x02df:
            r2 = 0
        L_0x02e0:
            if (r2 == 0) goto L_0x0311
            r3 = 0
        L_0x02e3:
            int r4 = r0.size()     // Catch:{ all -> 0x0597 }
            if (r3 >= r4) goto L_0x0311
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0597 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0597 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ all -> 0x0597 }
            java.lang.String r5 = r4.zzJ()     // Catch:{ all -> 0x0597 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0597 }
            if (r5 == 0) goto L_0x02fe
            goto L_0x030e
        L_0x02fe:
            java.lang.String r4 = r4.zzJ()     // Catch:{ all -> 0x0597 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0597 }
            if (r4 != 0) goto L_0x030e
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0597 }
            goto L_0x0311
        L_0x030e:
            int r3 = r3 + 1
            goto L_0x02e3
        L_0x0311:
            com.google.android.gms.internal.measurement.zzga r2 = com.google.android.gms.internal.measurement.zzgb.zza()     // Catch:{ all -> 0x0597 }
            int r3 = r0.size()     // Catch:{ all -> 0x0597 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0597 }
            int r5 = r0.size()     // Catch:{ all -> 0x0597 }
            r4.<init>(r5)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzag r5 = r22.zzg()     // Catch:{ all -> 0x0597 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0597 }
            if (r5 == 0) goto L_0x033a
            com.google.android.gms.measurement.internal.zzai r5 = r1.zzh(r6)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzah r7 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0597 }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x0597 }
            if (r5 == 0) goto L_0x033a
            r5 = 1
            goto L_0x033b
        L_0x033a:
            r5 = 0
        L_0x033b:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r6)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0597 }
            boolean r7 = r7.zzi(r8)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r6)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0597 }
            boolean r8 = r8.zzi(r9)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ all -> 0x0597 }
            r11 = 0
            boolean r9 = r9.zzs(r11, r10)     // Catch:{ all -> 0x0597 }
            if (r9 == 0) goto L_0x036d
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x0597 }
            boolean r9 = r9.zzs(r6, r10)     // Catch:{ all -> 0x0597 }
            if (r9 == 0) goto L_0x036d
            r9 = 1
            goto L_0x036e
        L_0x036d:
            r9 = 0
        L_0x036e:
            r10 = 0
        L_0x036f:
            if (r10 >= r3) goto L_0x03ed
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0597 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0597 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgd r11 = (com.google.android.gms.internal.measurement.zzgd) r11     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzkb r11 = r11.zzby()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x0597 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0597 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0597 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0597 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0597 }
            r4.add(r12)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzag r12 = r22.zzg()     // Catch:{ all -> 0x0597 }
            r12.zzh()     // Catch:{ all -> 0x0597 }
            r12 = 74029(0x1212d, double:3.6575E-319)
            r11.zzal(r12)     // Catch:{ all -> 0x0597 }
            r12 = r20
            r11.zzak(r12)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x0597 }
            r14.zzaw()     // Catch:{ all -> 0x0597 }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x0597 }
            if (r5 != 0) goto L_0x03ae
            r11.zzq()     // Catch:{ all -> 0x0597 }
        L_0x03ae:
            if (r7 != 0) goto L_0x03b6
            r11.zzx()     // Catch:{ all -> 0x0597 }
            r11.zzt()     // Catch:{ all -> 0x0597 }
        L_0x03b6:
            if (r8 != 0) goto L_0x03bb
            r11.zzn()     // Catch:{ all -> 0x0597 }
        L_0x03bb:
            r1.zzC(r6, r11)     // Catch:{ all -> 0x0597 }
            if (r9 != 0) goto L_0x03c3
            r11.zzy()     // Catch:{ all -> 0x0597 }
        L_0x03c3:
            com.google.android.gms.measurement.internal.zzag r14 = r22.zzg()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzdt r15 = com.google.android.gms.measurement.internal.zzdu.zzT     // Catch:{ all -> 0x0597 }
            boolean r14 = r14.zzs(r6, r15)     // Catch:{ all -> 0x0597 }
            if (r14 == 0) goto L_0x03e5
            com.google.android.gms.internal.measurement.zzkf r14 = r11.zzaC()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgd r14 = (com.google.android.gms.internal.measurement.zzgd) r14     // Catch:{ all -> 0x0597 }
            byte[] r14 = r14.zzbu()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzkv r15 = r1.zzi     // Catch:{ all -> 0x0597 }
            zzal(r15)     // Catch:{ all -> 0x0597 }
            long r14 = r15.zzd(r14)     // Catch:{ all -> 0x0597 }
            r11.zzJ(r14)     // Catch:{ all -> 0x0597 }
        L_0x03e5:
            r2.zza(r11)     // Catch:{ all -> 0x0597 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x036f
        L_0x03ed:
            r12 = r20
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = r0.zzq()     // Catch:{ all -> 0x0597 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0597 }
            if (r0 == 0) goto L_0x040f
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzi     // Catch:{ all -> 0x0597 }
            zzal(r0)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzkf r5 = r2.zzaC()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = r0.zzm(r5)     // Catch:{ all -> 0x0597 }
            r11 = r0
            goto L_0x0410
        L_0x040f:
            r11 = 0
        L_0x0410:
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzi     // Catch:{ all -> 0x0597 }
            zzal(r0)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzkf r0 = r2.zzaC()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.internal.measurement.zzgb r0 = (com.google.android.gms.internal.measurement.zzgb) r0     // Catch:{ all -> 0x0597 }
            byte[] r14 = r0.zzbu()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzki r0 = r1.zzl     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzkt r0 = r0.zzf     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzc     // Catch:{ all -> 0x0597 }
            zzal(r0)     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = r0.zzi(r6)     // Catch:{ all -> 0x0597 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0597 }
            if (r5 != 0) goto L_0x0467
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x0597 }
            r7 = 0
            java.lang.Object r5 = r5.zza(r7)     // Catch:{ all -> 0x0597 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0597 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0597 }
            android.net.Uri$Builder r7 = r5.buildUpon()     // Catch:{ all -> 0x0597 }
            java.lang.String r5 = r5.getAuthority()     // Catch:{ all -> 0x0597 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0597 }
            r8.<init>()     // Catch:{ all -> 0x0597 }
            r8.append(r0)     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = "."
            r8.append(r0)     // Catch:{ all -> 0x0597 }
            r8.append(r5)     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0597 }
            r7.authority(r0)     // Catch:{ all -> 0x0597 }
            android.net.Uri r0 = r7.build()     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0597 }
            goto L_0x0470
        L_0x0467:
            com.google.android.gms.measurement.internal.zzdt r0 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x0597 }
            r5 = 0
            java.lang.Object r0 = r0.zza(r5)     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0597 }
        L_0x0470:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04ef }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x04ef }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04ef }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x04ef }
            java.util.List r7 = r1.zzy     // Catch:{ MalformedURLException -> 0x04ef }
            if (r7 == 0) goto L_0x0490
            com.google.android.gms.measurement.internal.zzeh r4 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x04ef }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x04ef }
            goto L_0x0497
        L_0x0490:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04ef }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04ef }
            r1.zzy = r7     // Catch:{ MalformedURLException -> 0x04ef }
        L_0x0497:
            com.google.android.gms.measurement.internal.zzjo r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x04ef }
            r4.zzb(r12)     // Catch:{ MalformedURLException -> 0x04ef }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x04ab
            r3 = 0
            com.google.android.gms.internal.measurement.zzgd r2 = r2.zzb(r3)     // Catch:{ MalformedURLException -> 0x04ef }
            java.lang.String r4 = r2.zzx()     // Catch:{ MalformedURLException -> 0x04ef }
        L_0x04ab:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x04ef }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04ef }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04ef }
            r2.zzd(r3, r4, r7, r11)     // Catch:{ MalformedURLException -> 0x04ef }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzen r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x04ef }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzkk r2 = new com.google.android.gms.measurement.internal.zzkk     // Catch:{ MalformedURLException -> 0x04ef }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04ef }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x04ef }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzt     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzfo r3 = r3.zzaz()     // Catch:{ MalformedURLException -> 0x04ef }
            com.google.android.gms.measurement.internal.zzem r4 = new com.google.android.gms.measurement.internal.zzem     // Catch:{ MalformedURLException -> 0x04ef }
            r15 = 0
            r10 = r4
            r12 = r6
            r13 = r5
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04ef }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x04ef }
            goto L_0x058a
        L_0x04ef:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0597 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x0597 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0597 }
            goto L_0x058a
        L_0x0502:
            r0 = move-exception
            r9 = r11
        L_0x0504:
            if (r9 == 0) goto L_0x0509
            r9.close()     // Catch:{ all -> 0x0597 }
        L_0x0509:
            throw r0     // Catch:{ all -> 0x0597 }
        L_0x050a:
            r12 = r4
            r5 = r9
            r1.zzA = r7     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0597 }
            zzal(r2)     // Catch:{ all -> 0x0597 }
            r22.zzg()     // Catch:{ all -> 0x0597 }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0597 }
            long r3 = r12 - r3
            r2.zzg()     // Catch:{ all -> 0x0597 }
            r2.zzW()     // Catch:{ all -> 0x0597 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x0561, all -> 0x055e }
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0561, all -> 0x055e }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0561, all -> 0x055e }
            r4 = 0
            r6[r4] = r3     // Catch:{ SQLiteException -> 0x0561, all -> 0x055e }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x0561, all -> 0x055e }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x055c }
            if (r0 != 0) goto L_0x0551
            com.google.android.gms.measurement.internal.zzfr r0 = r2.zzt     // Catch:{ SQLiteException -> 0x055c }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x055c }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x055c }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.zza(r3)     // Catch:{ SQLiteException -> 0x055c }
            if (r11 == 0) goto L_0x0575
        L_0x054d:
            r11.close()     // Catch:{ all -> 0x0597 }
            goto L_0x0575
        L_0x0551:
            r3 = 0
            java.lang.String r9 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x055c }
            if (r11 == 0) goto L_0x0576
            r11.close()     // Catch:{ all -> 0x0597 }
            goto L_0x0576
        L_0x055c:
            r0 = move-exception
            goto L_0x0563
        L_0x055e:
            r0 = move-exception
            r9 = r5
            goto L_0x0591
        L_0x0561:
            r0 = move-exception
            r11 = r5
        L_0x0563:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x058f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x058f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x058f }
            java.lang.String r3 = "Error selecting expired configs"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x058f }
            if (r11 == 0) goto L_0x0575
            goto L_0x054d
        L_0x0575:
            r9 = r5
        L_0x0576:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0597 }
            if (r0 != 0) goto L_0x058a
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0597 }
            zzal(r0)     // Catch:{ all -> 0x0597 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r9)     // Catch:{ all -> 0x0597 }
            if (r0 == 0) goto L_0x058a
            r1.zzD(r0)     // Catch:{ all -> 0x0597 }
        L_0x058a:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x058f:
            r0 = move-exception
            r9 = r11
        L_0x0591:
            if (r9 == 0) goto L_0x0596
            r9.close()     // Catch:{ all -> 0x0597 }
        L_0x0596:
            throw r0     // Catch:{ all -> 0x0597 }
        L_0x0597:
            r0 = move-exception
            r2 = 0
        L_0x0599:
            r1.zzv = r2
            r22.zzae()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzX():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0749, code lost:
        if (r14.isEmpty() != false) goto L_0x074b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x030f A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x036f A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0503 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0542 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x05bb A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0608 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0615 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0622 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x065a A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x066b A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06ac A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x06c7 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x074e A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0794 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x07de A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x07f7 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0885 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x08a5 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0937 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x09e3 A[Catch:{ SQLiteException -> 0x09fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x09f9  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0943 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016b A[SYNTHETIC, Splitter:B:46:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e6 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02c2 A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x030c A[Catch:{ NumberFormatException -> 0x0733, all -> 0x0a7a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(com.google.android.gms.measurement.internal.zzaw r35, com.google.android.gms.measurement.internal.zzq r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfo r10 = r34.zzaz()
            r10.zzg()
            r34.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzkv.zzA(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0a85
            com.google.android.gms.measurement.internal.zzfi r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzeh r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlb r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF
            java.lang.String r1 = r2.zza
            r17 = 0
            r14 = 11
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r1
            r11.zzN(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.zzh r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r34.zzav()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r34.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzeh r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzD(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzei r2 = com.google.android.gms.measurement.internal.zzei.zzb(r35)
            com.google.android.gms.measurement.internal.zzlb r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzag r12 = r34.zzg()
            int r12 = r12.zzd(r10)
            r11.zzM(r2, r12)
            com.google.android.gms.measurement.internal.zzaw r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeh r11 = r34.zzay()
            java.lang.String r11 = r11.zzq()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzeh r11 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()
            java.lang.String r12 = r12.zzc(r2)
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze
            zzal(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0a7a }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x014a
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a7a }
            if (r9 != 0) goto L_0x014a
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a7a }
            if (r9 == 0) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r9 = 0
            goto L_0x014b
        L_0x014a:
            r9 = 1
        L_0x014b:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0a7a }
            if (r11 != 0) goto L_0x015f
            if (r9 == 0) goto L_0x0159
            r9 = 1
            goto L_0x015f
        L_0x0159:
            r33 = r4
            r8 = r15
        L_0x015c:
            r4 = 2
            goto L_0x02f9
        L_0x015f:
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x0a7a }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.zzg(r13)     // Catch:{ all -> 0x0a7a }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x01d4
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a7a }
            java.lang.Double r9 = r9.zzd(r13)     // Catch:{ all -> 0x0a7a }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0a7a }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x0192
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a7a }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0a7a }
            r21 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x0a7a }
            double r13 = (double) r14     // Catch:{ all -> 0x0a7a }
            double r17 = r13 * r19
            goto L_0x0194
        L_0x0192:
            r21 = r15
        L_0x0194:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01ae
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01ae
            long r13 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a7a }
            if (r9 == 0) goto L_0x01e0
            long r13 = -r13
            goto L_0x01e0
        L_0x01ae:
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a7a }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            r2.zzC()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            return
        L_0x01d4:
            r21 = r15
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a7a }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0a7a }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a7a }
        L_0x01e0:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a7a }
            if (r9 != 0) goto L_0x02f3
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0a7a }
            if (r11 == 0) goto L_0x02f3
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r11)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzky r11 = r11.zzp(r10, r9)     // Catch:{ all -> 0x0a7a }
            if (r11 == 0) goto L_0x023e
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a7a }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a7a }
            if (r12 != 0) goto L_0x0210
            goto L_0x023e
        L_0x0210:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0a7a }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzky r18 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0a7a }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.util.Clock r17 = r34.zzav()     // Catch:{ all -> 0x0a7a }
            long r19 = r17.currentTimeMillis()     // Catch:{ all -> 0x0a7a }
            long r11 = r11 + r13
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a7a }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = r14
            r15 = 0
            r14 = r9
            r9 = r21
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a7a }
            r33 = r4
            r8 = r9
            r9 = r18
            r4 = 2
            goto L_0x02b7
        L_0x023e:
            r15 = r21
            r8 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r11)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzag r12 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzD     // Catch:{ all -> 0x0a7a }
            int r8 = r12.zze(r10, r8)     // Catch:{ all -> 0x0a7a }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a7a }
            r11.zzg()     // Catch:{ all -> 0x0a7a }
            r11.zzW()     // Catch:{ all -> 0x0a7a }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x0281 }
            r21 = r15
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x027d }
            r16 = 0
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x027d }
            r16 = 1
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x027d }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x027d }
            r33 = r4
            r4 = 2
            r15[r4] = r8     // Catch:{ SQLiteException -> 0x027b }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r8, r15)     // Catch:{ SQLiteException -> 0x027b }
            goto L_0x029b
        L_0x027b:
            r0 = move-exception
            goto L_0x0287
        L_0x027d:
            r0 = move-exception
            r33 = r4
            goto L_0x0286
        L_0x0281:
            r0 = move-exception
            r33 = r4
            r21 = r15
        L_0x0286:
            r4 = 2
        L_0x0287:
            r8 = r0
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzt     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            r11.zzc(r12, r15, r8)     // Catch:{ all -> 0x0a7a }
        L_0x029b:
            com.google.android.gms.measurement.internal.zzky r18 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.util.Clock r11 = r34.zzav()     // Catch:{ all -> 0x0a7a }
            long r15 = r11.currentTimeMillis()     // Catch:{ all -> 0x0a7a }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a7a }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a7a }
            r9 = r18
        L_0x02b7:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r11)     // Catch:{ all -> 0x0a7a }
            boolean r11 = r11.zzL(r9)     // Catch:{ all -> 0x0a7a }
            if (r11 != 0) goto L_0x02f9
            com.google.android.gms.measurement.internal.zzeh r11 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzec r14 = r14.zzj()     // Catch:{ all -> 0x0a7a }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0a7a }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x0a7a }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a7a }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzlb r11 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF     // Catch:{ all -> 0x0a7a }
            r16 = 0
            r17 = 0
            r14 = 9
            r15 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a7a }
            goto L_0x02f9
        L_0x02f3:
            r33 = r4
            r8 = r21
            goto L_0x015c
        L_0x02f9:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r9 = com.google.android.gms.measurement.internal.zzlb.zzai(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a7a }
            r34.zzv()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x0a7a }
            if (r11 != 0) goto L_0x030f
            r16 = 0
            goto L_0x032f
        L_0x030f:
            com.google.android.gms.measurement.internal.zzat r12 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0a7a }
            r12.<init>(r11)     // Catch:{ all -> 0x0a7a }
            r16 = 0
        L_0x0316:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0a7a }
            if (r13 == 0) goto L_0x032f
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0a7a }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x0a7a }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0a7a }
            if (r14 == 0) goto L_0x0316
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0a7a }
            int r13 = r13.length     // Catch:{ all -> 0x0a7a }
            long r13 = (long) r13     // Catch:{ all -> 0x0a7a }
            long r16 = r16 + r13
            goto L_0x0316
        L_0x032f:
            r22 = 1
            long r15 = r16 + r22
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r11)     // Catch:{ all -> 0x0a7a }
            long r12 = r34.zza()     // Catch:{ all -> 0x0a7a }
            r20 = 0
            r21 = 0
            r17 = 1
            r30 = r5
            r4 = 0
            r14 = r10
            r18 = r9
            r19 = r20
            r20 = r8
            com.google.android.gms.measurement.internal.zzak r11 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0a7a }
            long r12 = r11.zzb     // Catch:{ all -> 0x0a7a }
            r34.zzg()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzj     // Catch:{ all -> 0x0a7a }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0a7a }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a7a }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a7a }
            r31 = r6
            r16 = r7
            long r6 = (long) r14     // Catch:{ all -> 0x0a7a }
            long r12 = r12 - r6
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            r17 = 1000(0x3e8, double:4.94E-321)
            if (r6 <= 0) goto L_0x039d
            long r12 = r12 % r17
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x038c
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            long r5 = r11.zzb     // Catch:{ all -> 0x0a7a }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a7a }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a7a }
        L_0x038c:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            r2.zzC()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            return
        L_0x039d:
            if (r9 == 0) goto L_0x03f8
            long r6 = r11.zza     // Catch:{ all -> 0x0a7a }
            r34.zzg()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzl     // Catch:{ all -> 0x0a7a }
            java.lang.Object r12 = r12.zza(r15)     // Catch:{ all -> 0x0a7a }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x0a7a }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0a7a }
            long r12 = (long) r12     // Catch:{ all -> 0x0a7a }
            long r6 = r6 - r12
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x03f8
            long r6 = r6 % r17
            int r3 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x03d3
            com.google.android.gms.measurement.internal.zzeh r3 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            long r6 = r11.zza     // Catch:{ all -> 0x0a7a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a7a }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0a7a }
        L_0x03d3:
            com.google.android.gms.measurement.internal.zzlb r11 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF     // Catch:{ all -> 0x0a7a }
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0a7a }
            r17 = 0
            r14 = 16
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            r2.zzC()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            return
        L_0x03f8:
            r6 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x0446
            long r7 = r11.zzd     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzag r12 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            java.lang.String r13 = r3.zza     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzk     // Catch:{ all -> 0x0a7a }
            int r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0a7a }
            int r12 = java.lang.Math.min(r6, r12)     // Catch:{ all -> 0x0a7a }
            r13 = 0
            int r12 = java.lang.Math.max(r13, r12)     // Catch:{ all -> 0x0a7a }
            long r12 = (long) r12     // Catch:{ all -> 0x0a7a }
            long r7 = r7 - r12
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0446
            int r2 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0435
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            long r5 = r11.zzd     // Catch:{ all -> 0x0a7a }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a7a }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a7a }
        L_0x0435:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            r2.zzC()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            return
        L_0x0446:
            com.google.android.gms.measurement.internal.zzau r7 = r2.zzb     // Catch:{ all -> 0x0a7a }
            android.os.Bundle r7 = r7.zzc()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzlb r8 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r2.zzc     // Catch:{ all -> 0x0a7a }
            r8.zzO(r7, r11, r12)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzlb r8 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.zzae(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.String r14 = "_r"
            if (r8 == 0) goto L_0x0477
            com.google.android.gms.measurement.internal.zzlb r8 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0a7a }
            java.lang.String r12 = "_dbg"
            r8.zzO(r7, r12, r11)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzlb r8 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            r8.zzO(r7, r14, r11)     // Catch:{ all -> 0x0a7a }
        L_0x0477:
            java.lang.String r8 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x049f
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a7a }
            r12 = r16
            com.google.android.gms.measurement.internal.zzky r8 = r8.zzp(r11, r12)     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x049f
            java.lang.Object r11 = r8.zze     // Catch:{ all -> 0x0a7a }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a7a }
            if (r11 == 0) goto L_0x049f
            com.google.android.gms.measurement.internal.zzlb r11 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0a7a }
            r11.zzO(r7, r12, r8)     // Catch:{ all -> 0x0a7a }
        L_0x049f:
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r8)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a7a }
            r8.zzg()     // Catch:{ all -> 0x0a7a }
            r8.zzW()     // Catch:{ all -> 0x0a7a }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzfr r12 = r8.zzt     // Catch:{ SQLiteException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzag r12 = r12.zzf()     // Catch:{ SQLiteException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzo     // Catch:{ SQLiteException -> 0x04e3 }
            int r12 = r12.zze(r10, r13)     // Catch:{ SQLiteException -> 0x04e3 }
            int r6 = java.lang.Math.min(r6, r12)     // Catch:{ SQLiteException -> 0x04e3 }
            r13 = 0
            int r6 = java.lang.Math.max(r13, r6)     // Catch:{ SQLiteException -> 0x04df }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x04df }
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x04df }
            r12[r13] = r10     // Catch:{ SQLiteException -> 0x04df }
            r16 = 1
            r12[r16] = r6     // Catch:{ SQLiteException -> 0x04df }
            java.lang.String r6 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r4 = r31
            int r5 = r11.delete(r4, r6, r12)     // Catch:{ SQLiteException -> 0x04dd }
            long r5 = (long) r5
            goto L_0x04fd
        L_0x04dd:
            r0 = move-exception
            goto L_0x04e7
        L_0x04df:
            r0 = move-exception
            r4 = r31
            goto L_0x04e7
        L_0x04e3:
            r0 = move-exception
            r4 = r31
            r13 = 0
        L_0x04e7:
            r5 = r0
            com.google.android.gms.measurement.internal.zzfr r6 = r8.zzt     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            r6.zzc(r8, r11, r5)     // Catch:{ all -> 0x0a7a }
            r5 = 0
        L_0x04fd:
            r11 = 0
            int r8 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r8 <= 0) goto L_0x0518
            com.google.android.gms.measurement.internal.zzeh r8 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzk()     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a7a }
            r8.zzc(r11, r12, r5)     // Catch:{ all -> 0x0a7a }
        L_0x0518:
            com.google.android.gms.measurement.internal.zzar r5 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0a7a }
            java.lang.String r6 = r2.zzc     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a7a }
            long r2 = r2.zzd     // Catch:{ all -> 0x0a7a }
            r18 = 0
            r11 = r5
            r31 = r13
            r13 = r6
            r6 = r14
            r14 = r10
            r32 = r4
            r4 = r15
            r15 = r8
            r16 = r2
            r20 = r7
            r11.<init>((com.google.android.gms.measurement.internal.zzfr) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = r5.zzb     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzn(r10, r3)     // Catch:{ all -> 0x0a7a }
            if (r2 != 0) goto L_0x05bb
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            long r2 = r2.zzf(r10)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzag r7 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            int r7 = r7.zzb(r10)     // Catch:{ all -> 0x0a7a }
            long r7 = (long) r7     // Catch:{ all -> 0x0a7a }
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x059d
            if (r9 == 0) goto L_0x059d
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzn     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzec r6 = r6.zzj()     // Catch:{ all -> 0x0a7a }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0a7a }
            java.lang.String r5 = r6.zzd(r5)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzag r6 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a7a }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzlb r11 = r34.zzv()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF     // Catch:{ all -> 0x0a7a }
            r16 = 0
            r17 = 0
            r14 = 8
            r15 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            return
        L_0x059d:
            com.google.android.gms.measurement.internal.zzas r2 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0a7a }
            java.lang.String r13 = r5.zzb     // Catch:{ all -> 0x0a7a }
            long r7 = r5.zzd     // Catch:{ all -> 0x0a7a }
            r26 = 0
            r27 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r11 = r2
            r12 = r10
            r20 = r7
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0a7a }
            goto L_0x05c9
        L_0x05bb:
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzn     // Catch:{ all -> 0x0a7a }
            long r7 = r2.zzf     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zza(r3, r7)     // Catch:{ all -> 0x0a7a }
            long r7 = r5.zzd     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzc(r7)     // Catch:{ all -> 0x0a7a }
        L_0x05c9:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r3)     // Catch:{ all -> 0x0a7a }
            r3.zzE(r2)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfo r2 = r34.zzaz()     // Catch:{ all -> 0x0a7a }
            r2.zzg()     // Catch:{ all -> 0x0a7a }
            r34.zzB()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)     // Catch:{ all -> 0x0a7a }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a7a }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a7a }
            r3 = r36
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a7a }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ all -> 0x0a7a }
            r7 = 1
            r2.zzad(r7)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = "android"
            r2.zzZ(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x060d
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a7a }
            r2.zzD(r8)     // Catch:{ all -> 0x0a7a }
        L_0x060d:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x061a
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a7a }
            r2.zzF(r8)     // Catch:{ all -> 0x0a7a }
        L_0x061a:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x0627
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a7a }
            r2.zzG(r8)     // Catch:{ all -> 0x0a7a }
        L_0x0627:
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzag r8 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.zzs(r4, r9)     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x0651
            com.google.android.gms.measurement.internal.zzag r8 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.zzs(r9, r10)     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x0651
            java.lang.String r8 = r3.zzx     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x0651
            java.lang.String r8 = r3.zzx     // Catch:{ all -> 0x0a7a }
            r2.zzah(r8)     // Catch:{ all -> 0x0a7a }
        L_0x0651:
            long r8 = r3.zzj     // Catch:{ all -> 0x0a7a }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x065e
            int r8 = (int) r8     // Catch:{ all -> 0x0a7a }
            r2.zzH(r8)     // Catch:{ all -> 0x0a7a }
        L_0x065e:
            long r8 = r3.zze     // Catch:{ all -> 0x0a7a }
            r2.zzV(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x0670
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a7a }
            r2.zzU(r8)     // Catch:{ all -> 0x0a7a }
        L_0x0670:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a7a }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzai r9 = com.google.android.gms.measurement.internal.zzai.zzb(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0a7a }
            r2.zzL(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r2.zzaq()     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x06a4
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x06a4
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a7a }
            r2.zzC(r8)     // Catch:{ all -> 0x0a7a }
        L_0x06a4:
            long r8 = r3.zzf     // Catch:{ all -> 0x0a7a }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06af
            r2.zzM(r8)     // Catch:{ all -> 0x0a7a }
        L_0x06af:
            long r8 = r3.zzs     // Catch:{ all -> 0x0a7a }
            r2.zzP(r8)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzkv r8 = r1.zzi     // Catch:{ all -> 0x0a7a }
            zzal(r8)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzkt r9 = r8.zzf     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzn     // Catch:{ all -> 0x0a7a }
            android.content.Context r9 = r9.zzau()     // Catch:{ all -> 0x0a7a }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzdu.zzc(r9)     // Catch:{ all -> 0x0a7a }
            if (r9 == 0) goto L_0x074b
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x0a7a }
            if (r10 == 0) goto L_0x06cf
            goto L_0x074b
        L_0x06cf:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0a7a }
            r14.<init>()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzO     // Catch:{ all -> 0x0a7a }
            java.lang.Object r10 = r10.zza(r4)     // Catch:{ all -> 0x0a7a }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a7a }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a7a }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0a7a }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0a7a }
        L_0x06e8:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0a7a }
            if (r11 == 0) goto L_0x0745
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0a7a }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0a7a }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0a7a }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0a7a }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0a7a }
            if (r12 == 0) goto L_0x06e8
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x0733 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x0733 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0733 }
            if (r11 == 0) goto L_0x06e8
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x0733 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x0733 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x0733 }
            if (r11 < r10) goto L_0x06e8
            com.google.android.gms.measurement.internal.zzfr r11 = r8.zzt     // Catch:{ NumberFormatException -> 0x0733 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ NumberFormatException -> 0x0733 }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x0733 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x0733 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x0733 }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x0733 }
            goto L_0x0745
        L_0x0733:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r12 = r8.zzt     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzk()     // Catch:{ all -> 0x0a7a }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0a7a }
            goto L_0x06e8
        L_0x0745:
            boolean r8 = r14.isEmpty()     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x074c
        L_0x074b:
            r14 = r4
        L_0x074c:
            if (r14 == 0) goto L_0x0751
            r2.zzh(r14)     // Catch:{ all -> 0x0a7a }
        L_0x0751:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a7a }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzai r9 = com.google.android.gms.measurement.internal.zzai.zzb(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0a7a }
            boolean r9 = r8.zzi(r9)     // Catch:{ all -> 0x0a7a }
            if (r9 == 0) goto L_0x079f
            boolean r9 = r3.zzo     // Catch:{ all -> 0x0a7a }
            if (r9 == 0) goto L_0x079f
            com.google.android.gms.measurement.internal.zzjo r9 = r1.zzk     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a7a }
            android.util.Pair r9 = r9.zzd(r10, r8)     // Catch:{ all -> 0x0a7a }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a7a }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0a7a }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a7a }
            if (r10 != 0) goto L_0x079f
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0a7a }
            if (r10 == 0) goto L_0x079f
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a7a }
            r2.zzae(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.Object r10 = r9.second     // Catch:{ all -> 0x0a7a }
            if (r10 == 0) goto L_0x079f
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0a7a }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0a7a }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0a7a }
            r2.zzX(r9)     // Catch:{ all -> 0x0a7a }
        L_0x079f:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a7a }
            r9.zzu()     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0a7a }
            r2.zzN(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a7a }
            r9.zzu()     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a7a }
            r2.zzY(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a7a }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0a7a }
            int r9 = (int) r9     // Catch:{ all -> 0x0a7a }
            r2.zzaj(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0a7a }
            r2.zzan(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a7a }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0a7a }
            if (r9 == 0) goto L_0x07ea
            r2.zzap()     // Catch:{ all -> 0x0a7a }
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0a7a }
            if (r9 != 0) goto L_0x07ea
            r2.zzO(r4)     // Catch:{ all -> 0x0a7a }
        L_0x07ea:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x0a7a }
            if (r9 != 0) goto L_0x085c
            com.google.android.gms.measurement.internal.zzh r9 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a7a }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r1.zzw(r8)     // Catch:{ all -> 0x0a7a }
            r9.zzH(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0a7a }
            r9.zzV(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0a7a }
            r9.zzW(r10)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzah r10 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0a7a }
            boolean r10 = r8.zzi(r10)     // Catch:{ all -> 0x0a7a }
            if (r10 == 0) goto L_0x0826
            com.google.android.gms.measurement.internal.zzjo r10 = r1.zzk     // Catch:{ all -> 0x0a7a }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a7a }
            boolean r12 = r3.zzo     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r10.zzf(r11, r12)     // Catch:{ all -> 0x0a7a }
            r9.zzae(r10)     // Catch:{ all -> 0x0a7a }
        L_0x0826:
            r10 = 0
            r9.zzaa(r10)     // Catch:{ all -> 0x0a7a }
            r9.zzab(r10)     // Catch:{ all -> 0x0a7a }
            r9.zzZ(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0a7a }
            r9.zzJ(r10)     // Catch:{ all -> 0x0a7a }
            long r10 = r3.zzj     // Catch:{ all -> 0x0a7a }
            r9.zzK(r10)     // Catch:{ all -> 0x0a7a }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0a7a }
            r9.zzI(r10)     // Catch:{ all -> 0x0a7a }
            long r10 = r3.zze     // Catch:{ all -> 0x0a7a }
            r9.zzX(r10)     // Catch:{ all -> 0x0a7a }
            long r10 = r3.zzf     // Catch:{ all -> 0x0a7a }
            r9.zzS(r10)     // Catch:{ all -> 0x0a7a }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0a7a }
            r9.zzac(r10)     // Catch:{ all -> 0x0a7a }
            long r10 = r3.zzs     // Catch:{ all -> 0x0a7a }
            r9.zzT(r10)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r10)     // Catch:{ all -> 0x0a7a }
            r10.zzD(r9)     // Catch:{ all -> 0x0a7a }
        L_0x085c:
            com.google.android.gms.measurement.internal.zzah r10 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0a7a }
            boolean r8 = r8.zzi(r10)     // Catch:{ all -> 0x0a7a }
            if (r8 == 0) goto L_0x087b
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x087b
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a7a }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a7a }
            r2.zzE(r8)     // Catch:{ all -> 0x0a7a }
        L_0x087b:
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a7a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a7a }
            if (r8 != 0) goto L_0x0892
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a7a }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a7a }
            r2.zzT(r8)     // Catch:{ all -> 0x0a7a }
        L_0x0892:
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a7a }
            java.util.List r3 = r8.zzu(r3)     // Catch:{ all -> 0x0a7a }
            r13 = r31
        L_0x089f:
            int r8 = r3.size()     // Catch:{ all -> 0x0a7a }
            if (r13 >= r8) goto L_0x08d5
            com.google.android.gms.internal.measurement.zzgl r8 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzky r9 = (com.google.android.gms.measurement.internal.zzky) r9     // Catch:{ all -> 0x0a7a }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0a7a }
            r8.zzf(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzky r9 = (com.google.android.gms.measurement.internal.zzky) r9     // Catch:{ all -> 0x0a7a }
            long r9 = r9.zzd     // Catch:{ all -> 0x0a7a }
            r8.zzg(r9)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzkv r9 = r1.zzi     // Catch:{ all -> 0x0a7a }
            zzal(r9)     // Catch:{ all -> 0x0a7a }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzky r10 = (com.google.android.gms.measurement.internal.zzky) r10     // Catch:{ all -> 0x0a7a }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0a7a }
            r9.zzu(r8, r10)     // Catch:{ all -> 0x0a7a }
            r2.zzl(r8)     // Catch:{ all -> 0x0a7a }
            int r13 = r13 + 1
            goto L_0x089f
        L_0x08d5:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ IOException -> 0x0a30 }
            zzal(r3)     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.internal.measurement.zzkf r8 = r2.zzaC()     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.internal.measurement.zzgd r8 = (com.google.android.gms.internal.measurement.zzgd) r8     // Catch:{ IOException -> 0x0a30 }
            r3.zzg()     // Catch:{ IOException -> 0x0a30 }
            r3.zzW()     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0a30 }
            java.lang.String r9 = r8.zzx()     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0a30 }
            byte[] r9 = r8.zzbu()     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.measurement.internal.zzkt r10 = r3.zzf     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.measurement.internal.zzkv r10 = r10.zzi     // Catch:{ IOException -> 0x0a30 }
            zzal(r10)     // Catch:{ IOException -> 0x0a30 }
            long r10 = r10.zzd(r9)     // Catch:{ IOException -> 0x0a30 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a30 }
            r12.<init>()     // Catch:{ IOException -> 0x0a30 }
            java.lang.String r13 = r8.zzx()     // Catch:{ IOException -> 0x0a30 }
            r14 = r30
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0a30 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0a30 }
            r15 = r33
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0a30 }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0a30 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x0a16 }
            java.lang.String r13 = "raw_events_metadata"
            r7 = 4
            r9.insertWithOnConflict(r13, r4, r12, r7)     // Catch:{ SQLiteException -> 0x0a16 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzau r3 = r5.zzf     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzat r7 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0a7a }
            r7.<init>(r3)     // Catch:{ all -> 0x0a7a }
        L_0x0931:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x0a7a }
            if (r3 == 0) goto L_0x0943
            java.lang.String r3 = r7.next()     // Catch:{ all -> 0x0a7a }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0a7a }
            if (r3 == 0) goto L_0x0931
        L_0x0941:
            r13 = 1
            goto L_0x0985
        L_0x0943:
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc     // Catch:{ all -> 0x0a7a }
            zzal(r3)     // Catch:{ all -> 0x0a7a }
            java.lang.String r6 = r5.zza     // Catch:{ all -> 0x0a7a }
            java.lang.String r7 = r5.zzb     // Catch:{ all -> 0x0a7a }
            boolean r3 = r3.zzq(r6, r7)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r6)     // Catch:{ all -> 0x0a7a }
            long r17 = r34.zza()     // Catch:{ all -> 0x0a7a }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a7a }
            r23 = 0
            r24 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r16 = r6
            r19 = r7
            com.google.android.gms.measurement.internal.zzak r6 = r16.zzl(r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0a7a }
            if (r3 == 0) goto L_0x0983
            long r6 = r6.zze     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzag r3 = r34.zzg()     // Catch:{ all -> 0x0a7a }
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x0a7a }
            int r3 = r3.zze(r8, r9)     // Catch:{ all -> 0x0a7a }
            long r8 = (long) r3     // Catch:{ all -> 0x0a7a }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0983
            goto L_0x0941
        L_0x0983:
            r13 = r31
        L_0x0985:
            r2.zzg()     // Catch:{ all -> 0x0a7a }
            r2.zzW()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = r5.zza     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzkt r3 = r2.zzf     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzkv r3 = r3.zzi     // Catch:{ all -> 0x0a7a }
            zzal(r3)     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.internal.measurement.zzft r3 = r3.zzj(r5)     // Catch:{ all -> 0x0a7a }
            byte[] r3 = r3.zzbu()     // Catch:{ all -> 0x0a7a }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x0a7a }
            r6.<init>()     // Catch:{ all -> 0x0a7a }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a7a }
            r6.put(r14, r7)     // Catch:{ all -> 0x0a7a }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0a7a }
            r6.put(r7, r8)     // Catch:{ all -> 0x0a7a }
            java.lang.String r7 = "timestamp"
            long r8 = r5.zzd     // Catch:{ all -> 0x0a7a }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a7a }
            r6.put(r7, r8)     // Catch:{ all -> 0x0a7a }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a7a }
            r6.put(r15, r7)     // Catch:{ all -> 0x0a7a }
            java.lang.String r7 = "data"
            r6.put(r7, r3)     // Catch:{ all -> 0x0a7a }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0a7a }
            r6.put(r3, r7)     // Catch:{ all -> 0x0a7a }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x09fe }
            r7 = r32
            long r3 = r3.insert(r7, r4, r6)     // Catch:{ SQLiteException -> 0x09fe }
            r6 = -1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x09f9
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzt     // Catch:{ SQLiteException -> 0x09fe }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x09fe }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x09fe }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.zza     // Catch:{ SQLiteException -> 0x09fe }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x09fe }
            r3.zzb(r4, r6)     // Catch:{ SQLiteException -> 0x09fe }
            goto L_0x0a47
        L_0x09f9:
            r3 = 0
            r1.zza = r3     // Catch:{ all -> 0x0a7a }
            goto L_0x0a47
        L_0x09fe:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0a7a }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x0a7a }
            r2.zzc(r4, r5, r3)     // Catch:{ all -> 0x0a7a }
            goto L_0x0a47
        L_0x0a16:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ IOException -> 0x0a30 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ IOException -> 0x0a30 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.zzx()     // Catch:{ IOException -> 0x0a30 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ IOException -> 0x0a30 }
            r3.zzc(r5, r6, r4)     // Catch:{ IOException -> 0x0a30 }
            throw r4     // Catch:{ IOException -> 0x0a30 }
        L_0x0a30:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzeh r4 = r34.zzay()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0a7a }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzap()     // Catch:{ all -> 0x0a7a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)     // Catch:{ all -> 0x0a7a }
            r4.zzc(r5, r2, r3)     // Catch:{ all -> 0x0a7a }
        L_0x0a47:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a7a }
            zzal(r2)     // Catch:{ all -> 0x0a7a }
            r2.zzC()     // Catch:{ all -> 0x0a7a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r34.zzag()
            com.google.android.gms.measurement.internal.zzeh r1 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r28
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r2 = r2 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "Background event processing time, ms"
            r1.zzb(r3, r2)
            return
        L_0x0a7a:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r1 = r1.zze
            zzal(r1)
            r1.zzx()
            throw r2
        L_0x0a85:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzY(com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzt.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzay().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzay().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzay().zzd().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzay().zzd().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzay().zzk().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzjo zzjo = this.zzk;
        zzjo.zzW();
        zzjo.zzg();
        long zza2 = zzjo.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzjo.zzt.zzv().zzG().nextInt(86400000)) + 1;
            zzjo.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zzau() {
        return this.zzn.zzau();
    }

    public final Clock zzav() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    public final zzab zzaw() {
        throw null;
    }

    public final zzeh zzay() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    public final zzfo zzaz() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    /* access modifiers changed from: package-private */
    public final zzh zzd(zzq zzq2) {
        String str;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        if (!zzq2.zzw.isEmpty()) {
            this.zzC.put(zzq2.zza, new zzks(this, zzq2.zzw));
        }
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(zzq2.zza);
        zzai zzc2 = zzh(zzq2.zza).zzc(zzai.zzb(zzq2.zzv));
        if (zzc2.zzi(zzah.AD_STORAGE)) {
            str = this.zzk.zzf(zzq2.zza, zzq2.zzo);
        } else {
            str = "";
        }
        if (zzj2 == null) {
            zzj2 = new zzh(this.zzn, zzq2.zza);
            if (zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
                zzj2.zzH(zzw(zzc2));
            }
            if (zzc2.zzi(zzah.AD_STORAGE)) {
                zzj2.zzae(str);
            }
        } else if (zzc2.zzi(zzah.AD_STORAGE) && str != null && !str.equals(zzj2.zzA())) {
            zzj2.zzae(str);
            if (zzq2.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzq2.zza, zzc2).first)) {
                zzj2.zzH(zzw(zzc2));
                zzam zzam2 = this.zze;
                zzal(zzam2);
                if (zzam2.zzp(zzq2.zza, "_id") != null) {
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzp(zzq2.zza, "_lair") == null) {
                        zzky zzky = new zzky(zzq2.zza, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzav().currentTimeMillis(), 1L);
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzam4.zzL(zzky);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzu()) && zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
            zzj2.zzH(zzw(zzc2));
        }
        zzj2.zzW(zzq2.zzb);
        zzj2.zzF(zzq2.zzq);
        if (!TextUtils.isEmpty(zzq2.zzk)) {
            zzj2.zzV(zzq2.zzk);
        }
        long j = zzq2.zze;
        if (j != 0) {
            zzj2.zzX(j);
        }
        if (!TextUtils.isEmpty(zzq2.zzc)) {
            zzj2.zzJ(zzq2.zzc);
        }
        zzj2.zzK(zzq2.zzj);
        String str2 = zzq2.zzd;
        if (str2 != null) {
            zzj2.zzI(str2);
        }
        zzj2.zzS(zzq2.zzf);
        zzj2.zzac(zzq2.zzh);
        if (!TextUtils.isEmpty(zzq2.zzg)) {
            zzj2.zzY(zzq2.zzg);
        }
        zzj2.zzG(zzq2.zzo);
        zzj2.zzad(zzq2.zzr);
        zzj2.zzT(zzq2.zzs);
        zzpd.zzc();
        if (zzg().zzs((String) null, zzdu.zzal) && zzg().zzs(zzq2.zza, zzdu.zzan)) {
            zzj2.zzag(zzq2.zzx);
        }
        zznt.zzc();
        if (zzg().zzs((String) null, zzdu.zzaj)) {
            zzj2.zzaf(zzq2.zzt);
        } else {
            zznt.zzc();
            if (zzg().zzs((String) null, zzdu.zzai)) {
                zzj2.zzaf((List) null);
            }
        }
        if (zzj2.zzaj()) {
            zzam zzam5 = this.zze;
            zzal(zzam5);
            zzam5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzaa zzf() {
        zzaa zzaa = this.zzh;
        zzal(zzaa);
        return zzaa;
    }

    public final zzag zzg() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzai zzh(String str) {
        String str2;
        zzai zzai = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzai2 = (zzai) this.zzB.get(str);
        if (zzai2 != null) {
            return zzai2;
        }
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        zzam.zzg();
        zzam.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzam.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = "G1";
            }
            zzai zzb2 = zzai.zzb(str2);
            zzV(str, zzb2);
            return zzb2;
        } catch (SQLiteException e) {
            zzam.zzt.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzam = this.zze;
        zzal(zzam);
        return zzam;
    }

    public final zzec zzj() {
        return this.zzn.zzj();
    }

    public final zzen zzl() {
        zzen zzen = this.zzd;
        zzal(zzen);
        return zzen;
    }

    public final zzep zzm() {
        zzep zzep = this.zzf;
        if (zzep != null) {
            return zzep;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfi zzo() {
        zzfi zzfi = this.zzc;
        zzal(zzfi);
        return zzfi;
    }

    /* access modifiers changed from: package-private */
    public final zzfr zzq() {
        return this.zzn;
    }

    public final zzic zzr() {
        zzic zzic = this.zzj;
        zzal(zzic);
        return zzic;
    }

    public final zzjo zzs() {
        return this.zzk;
    }

    public final zzkv zzu() {
        zzkv zzkv = this.zzi;
        zzal(zzkv);
        return zzkv;
    }

    public final zzlb zzv() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    /* access modifiers changed from: package-private */
    public final String zzw(zzai zzai) {
        if (!zzai.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzx(zzq zzq2) {
        try {
            return (String) zzaz().zzh(new zzkm(this, zzq2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeh.zzn(zzq2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
