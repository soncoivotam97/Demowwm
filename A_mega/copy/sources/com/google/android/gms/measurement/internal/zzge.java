package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzpd;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzge implements Callable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgj zzc;

    zzge(zzgj zzgj, zzaw zzaw, String str) {
        this.zzc = zzgj;
        this.zza = zzaw;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzkt zzkt;
        zzky zzky;
        Bundle bundle;
        zzh zzh;
        zzgc zzgc;
        String str;
        long j;
        zzas zzas;
        String str2;
        this.zzc.zza.zzA();
        zzic zzr = this.zzc.zza.zzr();
        zzaw zzaw = this.zza;
        String str3 = this.zzb;
        zzr.zzg();
        zzfr.zzO();
        Preconditions.checkNotNull(zzaw);
        Preconditions.checkNotEmpty(str3);
        if (!zzr.zzt.zzf().zzs(str3, zzdu.zzS)) {
            zzr.zzt.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if ("_iap".equals(zzaw.zza) || "_iapx".equals(zzaw.zza)) {
            zzga zza2 = zzgb.zza();
            zzr.zzf.zzi().zzw();
            zzh zzj = zzr.zzf.zzi().zzj(str3);
            if (zzj == null) {
                zzr.zzt.zzay().zzc().zzb("Log and bundle not available. package_name", str3);
                bArr = new byte[0];
                zzkt = zzr.zzf;
            } else if (!zzj.zzai()) {
                zzr.zzt.zzay().zzc().zzb("Log and bundle disabled. package_name", str3);
                bArr = new byte[0];
                zzkt = zzr.zzf;
            } else {
                zzgc zzt = zzgd.zzt();
                zzt.zzad(1);
                zzt.zzZ("android");
                if (!TextUtils.isEmpty(zzj.zzt())) {
                    zzt.zzD(zzj.zzt());
                }
                if (!TextUtils.isEmpty(zzj.zzv())) {
                    zzt.zzF((String) Preconditions.checkNotNull(zzj.zzv()));
                }
                if (!TextUtils.isEmpty(zzj.zzw())) {
                    zzt.zzG((String) Preconditions.checkNotNull(zzj.zzw()));
                }
                if (zzj.zzb() != -2147483648L) {
                    zzt.zzH((int) zzj.zzb());
                }
                zzt.zzV(zzj.zzm());
                zzt.zzP(zzj.zzk());
                String zzy = zzj.zzy();
                String zzr2 = zzj.zzr();
                if (!TextUtils.isEmpty(zzy)) {
                    zzt.zzU(zzy);
                } else if (!TextUtils.isEmpty(zzr2)) {
                    zzt.zzC(zzr2);
                }
                zzai zzh2 = zzr.zzf.zzh(str3);
                zzt.zzM(zzj.zzj());
                if (zzr.zzt.zzJ() && zzr.zzt.zzf().zzt(zzt.zzap()) && zzh2.zzi(zzah.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzt.zzO((String) null);
                }
                zzt.zzL(zzh2.zzh());
                if (zzh2.zzi(zzah.AD_STORAGE) && zzj.zzah()) {
                    Pair zzd = zzr.zzf.zzs().zzd(zzj.zzt(), zzh2);
                    if (zzj.zzah() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzt.zzae(zzic.zza((String) zzd.first, Long.toString(zzaw.zzd)));
                            if (zzd.second != null) {
                                zzt.zzX(((Boolean) zzd.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzr.zzt.zzay().zzc().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzkt = zzr.zzf;
                        } catch (Throwable th) {
                            zzr.zzf.zzi().zzx();
                            throw th;
                        }
                    }
                }
                zzr.zzt.zzg().zzu();
                zzt.zzN(Build.MODEL);
                zzr.zzt.zzg().zzu();
                zzt.zzY(Build.VERSION.RELEASE);
                zzt.zzaj((int) zzr.zzt.zzg().zzb());
                zzt.zzan(zzr.zzt.zzg().zzc());
                try {
                    if (zzh2.zzi(zzah.ANALYTICS_STORAGE) && zzj.zzu() != null) {
                        zzt.zzE(zzic.zza((String) Preconditions.checkNotNull(zzj.zzu()), Long.toString(zzaw.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzj.zzx())) {
                        zzt.zzT((String) Preconditions.checkNotNull(zzj.zzx()));
                    }
                    String zzt2 = zzj.zzt();
                    List zzu = zzr.zzf.zzi().zzu(zzt2);
                    Iterator it = zzu.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzky = null;
                            break;
                        }
                        zzky = (zzky) it.next();
                        if ("_lte".equals(zzky.zzc)) {
                            break;
                        }
                    }
                    if (zzky == null || zzky.zze == null) {
                        zzky zzky2 = new zzky(zzt2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzr.zzt.zzav().currentTimeMillis(), 0L);
                        zzu.add(zzky2);
                        zzr.zzf.zzi().zzL(zzky2);
                    }
                    zzkv zzu2 = zzr.zzf.zzu();
                    zzu2.zzt.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzu2.zzt.zzg().zze()) {
                        String zzt3 = zzj.zzt();
                        Preconditions.checkNotNull(zzt3);
                        if (zzj.zzah() && zzu2.zzf.zzo().zzn(zzt3)) {
                            zzu2.zzt.zzay().zzc().zza("Turning off ad personalization due to account type");
                            Iterator it2 = zzu.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((zzky) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            zzu.add(new zzky(zzt3, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzu2.zzt.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    zzgm[] zzgmArr = new zzgm[zzu.size()];
                    for (int i = 0; i < zzu.size(); i++) {
                        zzgl zzd2 = zzgm.zzd();
                        zzd2.zzf(((zzky) zzu.get(i)).zzc);
                        zzd2.zzg(((zzky) zzu.get(i)).zzd);
                        zzr.zzf.zzu().zzu(zzd2, ((zzky) zzu.get(i)).zze);
                        zzgmArr[i] = (zzgm) zzd2.zzaC();
                    }
                    zzt.zzj(Arrays.asList(zzgmArr));
                    zzei zzb2 = zzei.zzb(zzaw);
                    zzr.zzt.zzv().zzL(zzb2.zzd, zzr.zzf.zzi().zzi(str3));
                    zzr.zzt.zzv().zzM(zzb2, zzr.zzt.zzf().zzd(str3));
                    Bundle bundle2 = zzb2.zzd;
                    bundle2.putLong("_c", 1);
                    zzr.zzt.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", zzaw.zzc);
                    if (zzr.zzt.zzv().zzae(zzt.zzap())) {
                        zzr.zzt.zzv().zzO(bundle2, "_dbg", 1L);
                        zzr.zzt.zzv().zzO(bundle2, "_r", 1L);
                    }
                    zzas zzn = zzr.zzf.zzi().zzn(str3, zzaw.zza);
                    if (zzn == null) {
                        zzgc = zzt;
                        zzh = zzj;
                        str = str3;
                        bundle = bundle2;
                        zzas = new zzas(str3, zzaw.zza, 0, 0, 0, zzaw.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        zzgc = zzt;
                        zzh = zzj;
                        str = str3;
                        bundle = bundle2;
                        long j2 = zzn.zzf;
                        zzas = zzn.zzc(zzaw.zzd);
                        j = j2;
                    }
                    zzr.zzf.zzi().zzE(zzas);
                    zzar zzar = new zzar(zzr.zzt, zzaw.zzc, str, zzaw.zza, zzaw.zzd, j, bundle);
                    zzfs zze = zzft.zze();
                    zze.zzm(zzar.zzd);
                    zze.zzi(zzar.zzb);
                    zze.zzl(zzar.zze);
                    zzat zzat = new zzat(zzar.zzf);
                    while (zzat.hasNext()) {
                        String zza3 = zzat.next();
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(zza3);
                        Object zzf = zzar.zzf.zzf(zza3);
                        if (zzf != null) {
                            zzr.zzf.zzu().zzt(zze2, zzf);
                            zze.zze(zze2);
                        }
                    }
                    zzgc zzgc2 = zzgc;
                    zzgc2.zzk(zze);
                    com.google.android.gms.internal.measurement.zzge zza4 = zzgg.zza();
                    zzfu zza5 = zzfv.zza();
                    zza5.zza(zzas.zzc);
                    zza5.zzb(zzaw.zza);
                    zza4.zza(zza5);
                    zzgc2.zzaa(zza4);
                    zzgc2.zzf(zzr.zzf.zzf().zza(zzh.zzt(), Collections.emptyList(), zzgc2.zzat(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzgc2.zzai(zze.zzc());
                        zzgc2.zzQ(zze.zzc());
                    }
                    long zzn2 = zzh.zzn();
                    int i2 = (zzn2 > 0 ? 1 : (zzn2 == 0 ? 0 : -1));
                    if (i2 != 0) {
                        zzgc2.zzab(zzn2);
                    }
                    long zzp = zzh.zzp();
                    if (zzp != 0) {
                        zzgc2.zzac(zzp);
                    } else if (i2 != 0) {
                        zzgc2.zzac(zzn2);
                    }
                    String zzB = zzh.zzB();
                    zzpd.zzc();
                    if (zzr.zzt.zzf().zzs((String) null, zzdu.zzal)) {
                        str2 = str;
                        if (zzr.zzt.zzf().zzs(str2, zzdu.zzan) && zzB != null) {
                            zzgc2.zzah(zzB);
                        }
                    } else {
                        str2 = str;
                    }
                    zzh.zzE();
                    zzgc2.zzI((int) zzh.zzo());
                    zzr.zzt.zzf().zzh();
                    zzgc2.zzal(74029);
                    zzgc2.zzak(zzr.zzt.zzav().currentTimeMillis());
                    zzgc2.zzag(Boolean.TRUE.booleanValue());
                    if (zzr.zzt.zzf().zzs((String) null, zzdu.zzar)) {
                        zzr.zzf.zzC(zzgc2.zzap(), zzgc2);
                    }
                    zza2.zza(zzgc2);
                    zzh zzh3 = zzh;
                    zzh3.zzab(zzgc2.zzd());
                    zzh3.zzZ(zzgc2.zzc());
                    zzr.zzf.zzi().zzD(zzh3);
                    zzr.zzf.zzi().zzC();
                    zzr.zzf.zzi().zzx();
                    try {
                        return zzr.zzf.zzu().zzy(((zzgb) zza2.zzaC()).zzbu());
                    } catch (IOException e2) {
                        zzr.zzt.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzeh.zzn(str2), e2);
                        return null;
                    }
                } catch (SecurityException e3) {
                    zzr.zzt.zzay().zzc().zzb("app instance id encryption failed", e3.getMessage());
                    bArr = new byte[0];
                    zzkt = zzr.zzf;
                }
            }
            zzkt.zzi().zzx();
            return bArr;
        } else {
            zzr.zzt.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str3, zzaw.zza);
            return null;
        }
    }
}
