package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
final class zzhu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhw zze;

    zzhu(zzhw zzhw, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhw;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087 A[SYNTHETIC, Splitter:B:27:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd A[Catch:{ RuntimeException -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf A[Catch:{ RuntimeException -> 0x015f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            com.google.android.gms.measurement.internal.zzhw r0 = r14.zze
            boolean r1 = r14.zza
            android.net.Uri r2 = r14.zzb
            java.lang.String r3 = r14.zzc
            java.lang.String r14 = r14.zzd
            com.google.android.gms.measurement.internal.zzhx r4 = r0.zza
            r4.zzg()
            com.google.android.gms.measurement.internal.zzhx r4 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzlb r4 = r4.zzv()     // Catch:{ RuntimeException -> 0x015f }
            boolean r5 = android.text.TextUtils.isEmpty(r14)     // Catch:{ RuntimeException -> 0x015f }
            java.lang.String r6 = "Activity created with data 'referrer' without required params"
            java.lang.String r7 = "utm_medium"
            java.lang.String r8 = "_cis"
            java.lang.String r9 = "utm_source"
            java.lang.String r10 = "utm_campaign"
            r11 = 0
            java.lang.String r12 = "gclid"
            if (r5 == 0) goto L_0x002c
        L_0x002a:
            r4 = r11
            goto L_0x0083
        L_0x002c:
            boolean r5 = r14.contains(r12)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            boolean r5 = r14.contains(r10)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            boolean r5 = r14.contains(r9)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            boolean r5 = r14.contains(r7)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            java.lang.String r5 = "utm_id"
            boolean r5 = r14.contains(r5)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            java.lang.String r5 = "dclid"
            boolean r5 = r14.contains(r5)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            java.lang.String r5 = "srsltid"
            boolean r5 = r14.contains(r5)     // Catch:{ RuntimeException -> 0x015f }
            if (r5 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzc()     // Catch:{ RuntimeException -> 0x015f }
            r4.zza(r6)     // Catch:{ RuntimeException -> 0x015f }
            goto L_0x002a
        L_0x006a:
            java.lang.String r5 = "https://google.com/search?"
            java.lang.String r13 = java.lang.String.valueOf(r14)     // Catch:{ RuntimeException -> 0x015f }
            java.lang.String r5 = r5.concat(r13)     // Catch:{ RuntimeException -> 0x015f }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ RuntimeException -> 0x015f }
            android.os.Bundle r4 = r4.zzs(r5)     // Catch:{ RuntimeException -> 0x015f }
            if (r4 == 0) goto L_0x0083
            java.lang.String r5 = "referrer"
            r4.putString(r8, r5)     // Catch:{ RuntimeException -> 0x015f }
        L_0x0083:
            java.lang.String r5 = "_cmp"
            if (r1 == 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzhx r1 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzlb r1 = r1.zzv()     // Catch:{ RuntimeException -> 0x015f }
            android.os.Bundle r1 = r1.zzs(r2)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 == 0) goto L_0x00c7
            java.lang.String r2 = "intent"
            r1.putString(r8, r2)     // Catch:{ RuntimeException -> 0x015f }
            boolean r2 = r1.containsKey(r12)     // Catch:{ RuntimeException -> 0x015f }
            if (r2 != 0) goto L_0x00bb
            if (r4 == 0) goto L_0x00bb
            boolean r2 = r4.containsKey(r12)     // Catch:{ RuntimeException -> 0x015f }
            if (r2 == 0) goto L_0x00bb
            java.lang.String r2 = r4.getString(r12)     // Catch:{ RuntimeException -> 0x015f }
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch:{ RuntimeException -> 0x015f }
            java.lang.String r8 = "_cer"
            java.lang.String r13 = "gclid=%s"
            java.lang.String r2 = java.lang.String.format(r13, r2)     // Catch:{ RuntimeException -> 0x015f }
            r1.putString(r8, r2)     // Catch:{ RuntimeException -> 0x015f }
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzhx r2 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            r2.zzG(r3, r5, r1)     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzhx r2 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzb     // Catch:{ RuntimeException -> 0x015f }
            r2.zza(r3, r1)     // Catch:{ RuntimeException -> 0x015f }
        L_0x00c7:
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 == 0) goto L_0x00cf
            goto L_0x014e
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzhx r1 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzc()     // Catch:{ RuntimeException -> 0x015f }
            java.lang.String r2 = "Activity created with referrer"
            r1.zzb(r2, r14)     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzhx r1 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzY     // Catch:{ RuntimeException -> 0x015f }
            boolean r1 = r1.zzs(r11, r2)     // Catch:{ RuntimeException -> 0x015f }
            r2 = 1
            java.lang.String r8 = "_ldl"
            java.lang.String r13 = "auto"
            if (r1 == 0) goto L_0x011b
            if (r4 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzhx r14 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            r14.zzG(r3, r5, r4)     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzhx r14 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzb     // Catch:{ RuntimeException -> 0x015f }
            r14.zza(r3, r4)     // Catch:{ RuntimeException -> 0x015f }
            goto L_0x0115
        L_0x0104:
            com.google.android.gms.measurement.internal.zzhx r1 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzc()     // Catch:{ RuntimeException -> 0x015f }
            java.lang.String r3 = "Referrer does not contain valid parameters"
            r1.zzb(r3, r14)     // Catch:{ RuntimeException -> 0x015f }
        L_0x0115:
            com.google.android.gms.measurement.internal.zzhx r14 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            r14.zzW(r13, r8, r11, r2)     // Catch:{ RuntimeException -> 0x015f }
            return
        L_0x011b:
            boolean r1 = r14.contains(r12)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 == 0) goto L_0x014f
            boolean r1 = r14.contains(r10)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 != 0) goto L_0x0143
            boolean r1 = r14.contains(r9)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 != 0) goto L_0x0143
            boolean r1 = r14.contains(r7)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 != 0) goto L_0x0143
            java.lang.String r1 = "utm_term"
            boolean r1 = r14.contains(r1)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 != 0) goto L_0x0143
            java.lang.String r1 = "utm_content"
            boolean r1 = r14.contains(r1)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 == 0) goto L_0x014f
        L_0x0143:
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ RuntimeException -> 0x015f }
            if (r1 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzhx r1 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            r1.zzW(r13, r8, r14, r2)     // Catch:{ RuntimeException -> 0x015f }
        L_0x014e:
            return
        L_0x014f:
            com.google.android.gms.measurement.internal.zzhx r14 = r0.zza     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()     // Catch:{ RuntimeException -> 0x015f }
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzc()     // Catch:{ RuntimeException -> 0x015f }
            r14.zza(r6)     // Catch:{ RuntimeException -> 0x015f }
            return
        L_0x015f:
            r14 = move-exception
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zza
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()
            java.lang.String r1 = "Throwable caught in handleReferrerForOnActivityCreated"
            r0.zzb(r1, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhu.run():void");
    }
}
