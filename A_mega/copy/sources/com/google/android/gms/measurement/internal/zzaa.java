package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
final class zzaa extends zzkh {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzaa(zzkt zzkt) {
        super(zzkt);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzu = new zzu(this, this.zza, (zzt) null);
        this.zzc.put(num, zzu);
        return zzu;
    }

    private final boolean zzf(int i, int i2) {
        zzu zzu = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzu == null) {
            return false;
        }
        return zzu.zze.get(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v149, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: androidx.collection.ArrayMap} */
    /* JADX WARNING: type inference failed for: r26v22 */
    /* JADX WARNING: type inference failed for: r26v23 */
    /* JADX WARNING: type inference failed for: r26v42 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02c6, code lost:
        if (r5 != null) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02c8, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02d0, code lost:
        if (r5 != null) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02f5, code lost:
        if (r5 != null) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02f8, code lost:
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
        r1 = new androidx.collection.ArrayMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0307, code lost:
        if (r13.isEmpty() == false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0309, code lost:
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x030d, code lost:
        r3 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0319, code lost:
        if (r3.hasNext() == false) goto L_0x0309;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x031b, code lost:
        r4 = ((java.lang.Integer) r3.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzgi) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0335, code lost:
        if (r7 == null) goto L_0x0445;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x033b, code lost:
        if (r7.isEmpty() == false) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x033f, code lost:
        r17 = r0;
        r0 = r10.zzf.zzu().zzq(r6.zzk(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0353, code lost:
        if (r0.isEmpty() != false) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0355, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzgh) r6.zzby();
        r5.zzf();
        r5.zzb(r0);
        r19 = r3;
        r0 = r10.zzf.zzu().zzq(r6.zzn(), r7);
        r5.zzh();
        r5.zzd(r0);
        com.google.android.gms.internal.measurement.zzoc.zzc();
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0389, code lost:
        if (r10.zzt.zzf().zzs((java.lang.String) null, com.google.android.gms.measurement.internal.zzdu.zzas) == false) goto L_0x03f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x038b, code lost:
        r0 = new java.util.ArrayList();
        r3 = r6.zzj().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x039c, code lost:
        if (r3.hasNext() == false) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x039e, code lost:
        r8 = (com.google.android.gms.internal.measurement.zzfr) r3.next();
        r23 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03b4, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r8.zza())) != false) goto L_0x03b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03b6, code lost:
        r0.add(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03b9, code lost:
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03bd, code lost:
        r5.zze();
        r5.zza(r0);
        r0 = new java.util.ArrayList();
        r3 = r6.zzm().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03d4, code lost:
        if (r3.hasNext() == false) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03d6, code lost:
        r6 = (com.google.android.gms.internal.measurement.zzgk) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03e8, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzb())) != false) goto L_0x03d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03ea, code lost:
        r0.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03ee, code lost:
        r5.zzg();
        r5.zzc(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03f5, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03fa, code lost:
        if (r0 >= r6.zza()) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x040c, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zze(r0).zza())) == false) goto L_0x0411;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x040e, code lost:
        r5.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0411, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0414, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0419, code lost:
        if (r0 >= r6.zzc()) goto L_0x0433;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x042b, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzi(r0).zzb())) == false) goto L_0x0430;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x042d, code lost:
        r5.zzj(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0430, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0433, code lost:
        r1.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzgi) r5.zzaC());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0441, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0445, code lost:
        r17 = r0;
        r19 = r3;
        r21 = r8;
        r1.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x044e, code lost:
        r0 = r17;
        r3 = r19;
        r8 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0456, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0785, code lost:
        if (r5 != null) goto L_0x0787;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0787, code lost:
        r5.close();
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0793, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0794, code lost:
        r26 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0797, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0798, code lost:
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x079b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x079c, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x07b9, code lost:
        if (r5 == null) goto L_0x07bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x07c2, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x092e, code lost:
        if (r9 != null) goto L_0x0930;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0930, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x093c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x093d, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x093f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0957, code lost:
        if (r9 != null) goto L_0x0930;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0962, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x0a76, code lost:
        if (r8 != false) goto L_0x0a81;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0156, code lost:
        if (r5 != null) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0158, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x05d5, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x05d5, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:473:0x05d5, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x05d5, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x017a, code lost:
        if (r5 != null) goto L_0x0158;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x060d  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x079b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:261:0x06f3] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x07c2  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x086f  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x093c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:342:0x08af] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0962  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0a9e  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0b36  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01bd A[Catch:{ SQLiteException -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01cb A[SYNTHETIC, Splitter:B:70:0x01cb] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x024d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r64, java.util.List r65, java.util.List r66, java.lang.Long r67, java.lang.Long r68) {
        /*
            r63 = this;
            r10 = r63
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r64)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r65)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r66)
            r0 = r64
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r67
            r10.zzd = r0
            r0 = r68
            r10.zze = r0
            java.util.Iterator r0 = r65.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzft r1 = (com.google.android.gms.internal.measurement.zzft) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = r13
            goto L_0x0048
        L_0x0047:
            r1 = r12
        L_0x0048:
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzW
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzV
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r16 = "data"
            java.lang.String r7 = "audience_id"
            r6 = 2
            if (r15 == 0) goto L_0x0183
            if (r14 == 0) goto L_0x0183
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r17 = r2.zzh()
            java.lang.String[] r0 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0163, all -> 0x0160 }
            r0[r12] = r7     // Catch:{ SQLiteException -> 0x0163, all -> 0x0160 }
            r0[r13] = r16     // Catch:{ SQLiteException -> 0x0163, all -> 0x0160 }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0163, all -> 0x0160 }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x0163, all -> 0x0160 }
            java.lang.String r18 = "event_filters"
            java.lang.String r20 = "app_id=?"
            r23 = 0
            r24 = 0
            r22 = 0
            r19 = r0
            r21 = r5
            android.database.Cursor r5 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0163, all -> 0x0160 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x015e }
            if (r0 == 0) goto L_0x0152
        L_0x00f6:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x015e }
            com.google.android.gms.internal.measurement.zzej r13 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x0130 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x0130 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x0130 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x0130 }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x0130 }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x015e }
            if (r13 != 0) goto L_0x0111
            goto L_0x0142
        L_0x0111:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x015e }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x015e }
            java.lang.Object r17 = r4.get(r13)     // Catch:{ SQLiteException -> 0x015e }
            java.util.List r17 = (java.util.List) r17     // Catch:{ SQLiteException -> 0x015e }
            if (r17 != 0) goto L_0x012a
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x015e }
            r12.<init>()     // Catch:{ SQLiteException -> 0x015e }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x015e }
            goto L_0x012c
        L_0x012a:
            r12 = r17
        L_0x012c:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x015e }
            goto L_0x0142
        L_0x0130:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r12 = r2.zzt     // Catch:{ SQLiteException -> 0x015e }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteException -> 0x015e }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x015e }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x015e }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x015e }
        L_0x0142:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x015e }
            if (r0 != 0) goto L_0x014f
            if (r5 == 0) goto L_0x014d
            r5.close()
        L_0x014d:
            r12 = r4
            goto L_0x0184
        L_0x014f:
            r12 = 0
            r13 = 1
            goto L_0x00f6
        L_0x0152:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x015e }
            if (r5 == 0) goto L_0x0183
        L_0x0158:
            r5.close()
            goto L_0x0183
        L_0x015c:
            r0 = move-exception
            goto L_0x017d
        L_0x015e:
            r0 = move-exception
            goto L_0x0165
        L_0x0160:
            r0 = move-exception
            r5 = 0
            goto L_0x017d
        L_0x0163:
            r0 = move-exception
            r5 = 0
        L_0x0165:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x015c }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x015c }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x015c }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x015c }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x015c }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x015c }
            if (r5 == 0) goto L_0x0183
            goto L_0x0158
        L_0x017d:
            if (r5 == 0) goto L_0x0182
            r5.close()
        L_0x0182:
            throw r0
        L_0x0183:
            r12 = r0
        L_0x0184:
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r17 = r2.zzh()
            java.lang.String[] r0 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r4 = 0
            r0[r4] = r7     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r5 = 1
            r0[r5] = r11     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            java.lang.String[] r13 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r13[r4] = r3     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            java.lang.String r18 = "audience_filter_values"
            java.lang.String r20 = "app_id=?"
            r23 = 0
            r24 = 0
            r22 = 0
            r19 = r0
            r21 = r13
            android.database.Cursor r4 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 != 0) goto L_0x01cb
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0228 }
            if (r4 == 0) goto L_0x01c6
            r4.close()
        L_0x01c6:
            r13 = r0
            r20 = r7
            goto L_0x0251
        L_0x01cb:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0228 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0228 }
        L_0x01d0:
            r13 = 0
            int r17 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0228 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzgh r13 = com.google.android.gms.internal.measurement.zzgi.zzf()     // Catch:{ IOException -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0     // Catch:{ IOException -> 0x01f6 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x0228 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0228 }
            r19 = r5
            r20 = r7
            goto L_0x0212
        L_0x01f6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r13 = r2.zzt     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0228 }
            java.lang.String r6 = "Failed to merge filter results. appId, audienceId, error"
            r19 = r5
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0228 }
            r20 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x0226 }
            r13.zzd(r6, r5, r7, r0)     // Catch:{ SQLiteException -> 0x0226 }
        L_0x0212:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0226 }
            if (r0 != 0) goto L_0x0220
            if (r4 == 0) goto L_0x021d
            r4.close()
        L_0x021d:
            r13 = r19
            goto L_0x0251
        L_0x0220:
            r5 = r19
            r7 = r20
            r6 = 2
            goto L_0x01d0
        L_0x0226:
            r0 = move-exception
            goto L_0x0234
        L_0x0228:
            r0 = move-exception
            r20 = r7
            goto L_0x0234
        L_0x022c:
            r0 = move-exception
            r5 = 0
            goto L_0x0b34
        L_0x0230:
            r0 = move-exception
            r20 = r7
            r4 = 0
        L_0x0234:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0b32 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0b32 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0b32 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0b32 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b32 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b32 }
            if (r4 == 0) goto L_0x0250
            r4.close()
        L_0x0250:
            r13 = r0
        L_0x0251:
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x025d
            r12 = r8
            r13 = r9
            r28 = r20
            goto L_0x0601
        L_0x025d:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x045e
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r0.zzi()
            java.lang.String r4 = r10.zza
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            r6 = 2
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x02dc, all -> 0x02d8 }
            r17 = 0
            r7[r17] = r4     // Catch:{ SQLiteException -> 0x02dc, all -> 0x02d8 }
            r17 = 1
            r7[r17] = r4     // Catch:{ SQLiteException -> 0x02dc, all -> 0x02d8 }
            java.lang.String r6 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r6, r7)     // Catch:{ SQLiteException -> 0x02dc, all -> 0x02d8 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02d6 }
            if (r6 == 0) goto L_0x02cc
        L_0x029b:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02d6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02d6 }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02d6 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02d6 }
            if (r7 != 0) goto L_0x02b4
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02d6 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02d6 }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02d6 }
        L_0x02b4:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02d6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02d6 }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02d6 }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02d6 }
            if (r6 != 0) goto L_0x029b
            if (r5 == 0) goto L_0x02f8
        L_0x02c8:
            r5.close()
            goto L_0x02f8
        L_0x02cc:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02d6 }
            if (r5 == 0) goto L_0x02f8
            goto L_0x02c8
        L_0x02d3:
            r0 = move-exception
            goto L_0x0458
        L_0x02d6:
            r0 = move-exception
            goto L_0x02de
        L_0x02d8:
            r0 = move-exception
            r5 = 0
            goto L_0x0458
        L_0x02dc:
            r0 = move-exception
            r5 = 0
        L_0x02de:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x02d3 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x02d3 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x02d3 }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x02d3 }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x02d3 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02d3 }
            if (r5 == 0) goto L_0x02f8
            goto L_0x02c8
        L_0x02f8:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x030d
        L_0x0309:
            r21 = r8
            goto L_0x0456
        L_0x030d:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0315:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0309
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgi r6 = (com.google.android.gms.internal.measurement.zzgi) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0445
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x033f
            goto L_0x0445
        L_0x033f:
            com.google.android.gms.measurement.internal.zzkt r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r5 = r5.zzu()
            r17 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzq(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x0441
            com.google.android.gms.internal.measurement.zzkb r5 = r6.zzby()
            com.google.android.gms.internal.measurement.zzgh r5 = (com.google.android.gms.internal.measurement.zzgh) r5
            r5.zzf()
            r5.zzb(r0)
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()
            r19 = r3
            java.util.List r3 = r6.zzn()
            java.util.List r0 = r0.zzq(r3, r7)
            r5.zzh()
            r5.zzd(r0)
            com.google.android.gms.internal.measurement.zzoc.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzas
            r21 = r8
            r8 = 0
            boolean r0 = r0.zzs(r8, r3)
            if (r0 == 0) goto L_0x03f5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x0398:
            boolean r22 = r3.hasNext()
            if (r22 == 0) goto L_0x03bd
            java.lang.Object r22 = r3.next()
            r8 = r22
            com.google.android.gms.internal.measurement.zzfr r8 = (com.google.android.gms.internal.measurement.zzfr) r8
            int r22 = r8.zza()
            r23 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            boolean r3 = r7.contains(r3)
            if (r3 != 0) goto L_0x03b9
            r0.add(r8)
        L_0x03b9:
            r3 = r23
            r8 = 0
            goto L_0x0398
        L_0x03bd:
            r5.zze()
            r5.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzm()
            java.util.Iterator r3 = r3.iterator()
        L_0x03d0:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x03ee
            java.lang.Object r6 = r3.next()
            com.google.android.gms.internal.measurement.zzgk r6 = (com.google.android.gms.internal.measurement.zzgk) r6
            int r8 = r6.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r7.contains(r8)
            if (r8 != 0) goto L_0x03d0
            r0.add(r6)
            goto L_0x03d0
        L_0x03ee:
            r5.zzg()
            r5.zzc(r0)
            goto L_0x0433
        L_0x03f5:
            r0 = 0
        L_0x03f6:
            int r3 = r6.zza()
            if (r0 >= r3) goto L_0x0414
            com.google.android.gms.internal.measurement.zzfr r3 = r6.zze(r0)
            int r3 = r3.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0411
            r5.zzi(r0)
        L_0x0411:
            int r0 = r0 + 1
            goto L_0x03f6
        L_0x0414:
            r0 = 0
        L_0x0415:
            int r3 = r6.zzc()
            if (r0 >= r3) goto L_0x0433
            com.google.android.gms.internal.measurement.zzgk r3 = r6.zzi(r0)
            int r3 = r3.zzb()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0430
            r5.zzj(r0)
        L_0x0430:
            int r0 = r0 + 1
            goto L_0x0415
        L_0x0433:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzkf r3 = r5.zzaC()
            com.google.android.gms.internal.measurement.zzgi r3 = (com.google.android.gms.internal.measurement.zzgi) r3
            r1.put(r0, r3)
            goto L_0x044e
        L_0x0441:
            r0 = r17
            goto L_0x0315
        L_0x0445:
            r17 = r0
            r19 = r3
            r21 = r8
            r1.put(r5, r6)
        L_0x044e:
            r0 = r17
            r3 = r19
            r8 = r21
            goto L_0x0315
        L_0x0456:
            r0 = r1
            goto L_0x0461
        L_0x0458:
            if (r5 == 0) goto L_0x045d
            r5.close()
        L_0x045d:
            throw r0
        L_0x045e:
            r21 = r8
            r0 = r13
        L_0x0461:
            java.util.Iterator r17 = r2.iterator()
        L_0x0465:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x05fc
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r19 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgi r1 = (com.google.android.gms.internal.measurement.zzgi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x04cd
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x0497
            goto L_0x04cd
        L_0x0497:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x049f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04cd
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x049f
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzg()
            if (r8 == 0) goto L_0x04c8
            long r22 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x04c9
        L_0x04c8:
            r3 = 0
        L_0x04c9:
            r7.put(r4, r3)
            goto L_0x049f
        L_0x04cd:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x0519
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x04db
            goto L_0x0519
        L_0x04db:
            java.util.List r2 = r1.zzm()
            java.util.Iterator r2 = r2.iterator()
        L_0x04e3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0519
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgk r3 = (com.google.android.gms.internal.measurement.zzgk) r3
            boolean r4 = r3.zzi()
            if (r4 == 0) goto L_0x04e3
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x04e3
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.zza()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.zzc(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x04e3
        L_0x0519:
            r23 = r0
            if (r1 == 0) goto L_0x0568
            r0 = 0
        L_0x051e:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x0568
            java.util.List r2 = r1.zzn()
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzv(r2, r0)
            if (r2 == 0) goto L_0x055a
            com.google.android.gms.measurement.internal.zzfr r2 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzv(r2, r0)
            if (r2 == 0) goto L_0x055c
            r5.set(r0)
            goto L_0x0563
        L_0x055a:
            r22 = r9
        L_0x055c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x0563:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x051e
        L_0x0568:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            if (r15 == 0) goto L_0x05d5
            if (r14 == 0) goto L_0x05d5
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x05d5
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x05d5
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x058a
            goto L_0x05d5
        L_0x058a:
            java.util.Iterator r0 = r0.iterator()
        L_0x058e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05d5
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzek r1 = (com.google.android.gms.internal.measurement.zzek) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x05b6
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x05b6:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x05c7
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x05c7:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x058e
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x058e
        L_0x05d5:
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r63
            r28 = r20
            r18 = r12
            r12 = r21
            r64 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
            r1.put(r2, r0)
            r9 = r13
            r12 = r18
            r0 = r23
            r13 = r64
            goto L_0x0465
        L_0x05fc:
            r13 = r9
            r28 = r20
            r12 = r21
        L_0x0601:
            boolean r0 = r65.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x060d
        L_0x0609:
            r25 = r11
            goto L_0x0867
        L_0x060d:
            com.google.android.gms.measurement.internal.zzw r2 = new com.google.android.gms.measurement.internal.zzw
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r65.iterator()
        L_0x061c:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0609
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.String r6 = r10.zza
            com.google.android.gms.internal.measurement.zzft r6 = r2.zza(r6, r0)
            if (r6 == 0) goto L_0x061c
            com.google.android.gms.measurement.internal.zzkt r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r7 = r7.zzi()
            java.lang.String r8 = r10.zza
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.zzas r14 = r7.zzn(r8, r14)
            if (r14 != 0) goto L_0x0685
            com.google.android.gms.measurement.internal.zzfr r14 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r29 = r7
            java.lang.String r31 = r0.zzh()
            long r38 = r0.zzd()
            r44 = 0
            r45 = 0
            r32 = 1
            r34 = 1
            r36 = 1
            r40 = 0
            r42 = 0
            r43 = 0
            r30 = r8
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)
            goto L_0x06ba
        L_0x0685:
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r46 = r7
            java.lang.String r0 = r14.zza
            r47 = r0
            java.lang.String r0 = r14.zzb
            r48 = r0
            long r8 = r14.zzc
            r17 = 1
            long r49 = r8 + r17
            long r8 = r14.zzd
            long r51 = r8 + r17
            long r8 = r14.zze
            long r53 = r8 + r17
            long r8 = r14.zzf
            r55 = r8
            long r8 = r14.zzg
            r57 = r8
            java.lang.Long r0 = r14.zzh
            r59 = r0
            java.lang.Long r0 = r14.zzi
            r60 = r0
            java.lang.Long r0 = r14.zzj
            r61 = r0
            java.lang.Boolean r0 = r14.zzk
            r62 = r0
            r46.<init>(r47, r48, r49, r51, r53, r55, r57, r59, r60, r61, r62)
        L_0x06ba:
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r0 = r0.zzi()
            r0.zzE(r7)
            long r8 = r7.zzc
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x07c6
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r15 = r0.zzi()
            java.lang.String r3 = r10.zza
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r64 = r2
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r17 = r15.zzh()
            r65 = r5
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x079e, all -> 0x079b }
            r5 = r28
            r18 = 0
            r0[r18] = r5     // Catch:{ SQLiteException -> 0x0797, all -> 0x079b }
            r19 = 1
            r0[r19] = r16     // Catch:{ SQLiteException -> 0x0797, all -> 0x079b }
            r28 = r5
            r25 = r11
            r11 = 2
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0793, all -> 0x079b }
            r5[r18] = r3     // Catch:{ SQLiteException -> 0x0793, all -> 0x079b }
            r5[r19] = r14     // Catch:{ SQLiteException -> 0x0793, all -> 0x079b }
            java.lang.String r18 = "event_filters"
            java.lang.String r20 = "app_id=? AND event_name=?"
            r23 = 0
            r24 = 0
            r22 = 0
            r19 = r0
            r21 = r5
            android.database.Cursor r5 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0793, all -> 0x079b }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x078f }
            if (r0 == 0) goto L_0x077f
        L_0x0722:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x078f }
            com.google.android.gms.internal.measurement.zzej r11 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x075b }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r11, r0)     // Catch:{ IOException -> 0x075b }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x075b }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x075b }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x075b }
            r11 = 0
            int r17 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x078f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x078f }
            java.lang.Object r17 = r2.get(r11)     // Catch:{ SQLiteException -> 0x078f }
            java.util.List r17 = (java.util.List) r17     // Catch:{ SQLiteException -> 0x078f }
            if (r17 != 0) goto L_0x0753
            r26 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x078b }
            r7.<init>()     // Catch:{ SQLiteException -> 0x078b }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x078b }
            goto L_0x0757
        L_0x0753:
            r26 = r7
            r7 = r17
        L_0x0757:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x078b }
            goto L_0x076f
        L_0x075b:
            r0 = move-exception
            r26 = r7
            com.google.android.gms.measurement.internal.zzfr r7 = r15.zzt     // Catch:{ SQLiteException -> 0x078b }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()     // Catch:{ SQLiteException -> 0x078b }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()     // Catch:{ SQLiteException -> 0x078b }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x078b }
            r7.zzc(r13, r11, r0)     // Catch:{ SQLiteException -> 0x078b }
        L_0x076f:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x078b }
            if (r0 != 0) goto L_0x077c
            if (r5 == 0) goto L_0x077a
            r5.close()
        L_0x077a:
            r0 = r2
            goto L_0x07bc
        L_0x077c:
            r7 = r26
            goto L_0x0722
        L_0x077f:
            r26 = r7
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x078b }
            if (r5 == 0) goto L_0x07bc
        L_0x0787:
            r5.close()
            goto L_0x07bc
        L_0x078b:
            r0 = move-exception
            goto L_0x07a4
        L_0x078d:
            r0 = move-exception
            goto L_0x07c0
        L_0x078f:
            r0 = move-exception
            r26 = r7
            goto L_0x07a4
        L_0x0793:
            r0 = move-exception
            r26 = r7
            goto L_0x07a3
        L_0x0797:
            r0 = move-exception
            r28 = r5
            goto L_0x079f
        L_0x079b:
            r0 = move-exception
            r5 = 0
            goto L_0x07c0
        L_0x079e:
            r0 = move-exception
        L_0x079f:
            r26 = r7
            r25 = r11
        L_0x07a3:
            r5 = 0
        L_0x07a4:
            com.google.android.gms.measurement.internal.zzfr r2 = r15.zzt     // Catch:{ all -> 0x078d }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x078d }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x078d }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x078d }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x078d }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x078d }
            if (r5 == 0) goto L_0x07bc
            goto L_0x0787
        L_0x07bc:
            r4.put(r14, r0)
            goto L_0x07ce
        L_0x07c0:
            if (r5 == 0) goto L_0x07c5
            r5.close()
        L_0x07c5:
            throw r0
        L_0x07c6:
            r64 = r2
            r65 = r5
            r26 = r7
            r25 = r11
        L_0x07ce:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x07d6:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x085e
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x0800
            com.google.android.gms.measurement.internal.zzfr r3 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzj()
            r3.zzb(r1, r7)
            goto L_0x07d6
        L_0x0800:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x080b:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x0851
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzek r7 = (com.google.android.gms.internal.measurement.zzek) r7
            com.google.android.gms.measurement.internal.zzx r11 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r14 = r10.zza
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r14 = r10.zzd
            java.lang.Long r15 = r10.zze
            int r7 = r7.zzb()
            boolean r24 = r10.zzf(r3, r7)
            r17 = r11
            r18 = r14
            r19 = r15
            r20 = r6
            r21 = r8
            r23 = r26
            boolean r7 = r17.zzd(r18, r19, r20, r21, r23, r24)
            if (r7 == 0) goto L_0x0848
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.zzu r14 = r10.zzd(r14)
            r14.zzc(r11)
            goto L_0x080b
        L_0x0848:
            java.util.Set r5 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x0851:
            if (r7 != 0) goto L_0x07d6
            java.util.Set r5 = r10.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x07d6
        L_0x085e:
            r2 = r64
            r5 = r65
            r11 = r25
            r3 = 0
            goto L_0x061c
        L_0x0867:
            boolean r0 = r66.isEmpty()
            if (r0 == 0) goto L_0x086f
            goto L_0x0a84
        L_0x086f:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r66.iterator()
        L_0x0878:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0a84
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0966
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r17 = r6.zzh()
            r9 = 2
            java.lang.String[] r0 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x093f, all -> 0x093c }
            r11 = 0
            r0[r11] = r28     // Catch:{ SQLiteException -> 0x0939, all -> 0x093c }
            r13 = 1
            r0[r13] = r16     // Catch:{ SQLiteException -> 0x0939, all -> 0x093c }
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0939, all -> 0x093c }
            r14[r11] = r7     // Catch:{ SQLiteException -> 0x0939, all -> 0x093c }
            r14[r13] = r5     // Catch:{ SQLiteException -> 0x093f, all -> 0x093c }
            java.lang.String r18 = "property_filters"
            java.lang.String r20 = "app_id=? AND property_name=?"
            r23 = 0
            r24 = 0
            r22 = 0
            r19 = r0
            r21 = r14
            android.database.Cursor r9 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x093f, all -> 0x093c }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0936 }
            if (r0 == 0) goto L_0x0929
        L_0x08d5:
            r11 = 1
            byte[] r0 = r9.getBlob(r11)     // Catch:{ SQLiteException -> 0x0936 }
            com.google.android.gms.internal.measurement.zzes r13 = com.google.android.gms.internal.measurement.zzet.zzc()     // Catch:{ IOException -> 0x0907 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x0907 }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x0907 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x0907 }
            com.google.android.gms.internal.measurement.zzet r0 = (com.google.android.gms.internal.measurement.zzet) r0     // Catch:{ IOException -> 0x0907 }
            r13 = 0
            int r14 = r9.getInt(r13)     // Catch:{ SQLiteException -> 0x0934 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x0934 }
            java.lang.Object r15 = r8.get(r14)     // Catch:{ SQLiteException -> 0x0934 }
            java.util.List r15 = (java.util.List) r15     // Catch:{ SQLiteException -> 0x0934 }
            if (r15 != 0) goto L_0x0903
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0934 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x0934 }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x0934 }
        L_0x0903:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x0934 }
            goto L_0x091c
        L_0x0907:
            r0 = move-exception
            r13 = 0
            com.google.android.gms.measurement.internal.zzfr r14 = r6.zzt     // Catch:{ SQLiteException -> 0x0934 }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()     // Catch:{ SQLiteException -> 0x0934 }
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzd()     // Catch:{ SQLiteException -> 0x0934 }
            java.lang.String r15 = "Failed to merge filter"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ SQLiteException -> 0x0934 }
            r14.zzc(r15, r11, r0)     // Catch:{ SQLiteException -> 0x0934 }
        L_0x091c:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0934 }
            if (r0 != 0) goto L_0x08d5
            if (r9 == 0) goto L_0x0927
            r9.close()
        L_0x0927:
            r0 = r8
            goto L_0x095a
        L_0x0929:
            r13 = 0
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0934 }
            if (r9 == 0) goto L_0x095a
        L_0x0930:
            r9.close()
            goto L_0x095a
        L_0x0934:
            r0 = move-exception
            goto L_0x0942
        L_0x0936:
            r0 = move-exception
            r13 = 0
            goto L_0x0942
        L_0x0939:
            r0 = move-exception
            r13 = r11
            goto L_0x0941
        L_0x093c:
            r0 = move-exception
            r5 = 0
            goto L_0x0960
        L_0x093f:
            r0 = move-exception
            r13 = 0
        L_0x0941:
            r9 = 0
        L_0x0942:
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt     // Catch:{ all -> 0x095e }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x095e }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x095e }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x095e }
            r6.zzc(r12, r7, r0)     // Catch:{ all -> 0x095e }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x095e }
            if (r9 == 0) goto L_0x095a
            goto L_0x0930
        L_0x095a:
            r2.put(r5, r0)
            goto L_0x0967
        L_0x095e:
            r0 = move-exception
            r5 = r9
        L_0x0960:
            if (r5 == 0) goto L_0x0965
            r5.close()
        L_0x0965:
            throw r0
        L_0x0966:
            r13 = 0
        L_0x0967:
            java.util.Set r5 = r0.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x096f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0878
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set r7 = r10.zzb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x099a
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            r0.zzb(r1, r8)
            goto L_0x0878
        L_0x099a:
            java.lang.Object r7 = r0.get(r8)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x09a5:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0a76
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzet r8 = (com.google.android.gms.internal.measurement.zzet) r8
            com.google.android.gms.measurement.internal.zzfr r9 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            java.lang.String r9 = r9.zzq()
            r11 = 2
            boolean r9 = android.util.Log.isLoggable(r9, r11)
            if (r9 == 0) goto L_0x0a0c
            com.google.android.gms.measurement.internal.zzfr r9 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            boolean r15 = r8.zzj()
            if (r15 == 0) goto L_0x09df
            int r15 = r8.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09e0
        L_0x09df:
            r15 = 0
        L_0x09e0:
            com.google.android.gms.measurement.internal.zzfr r11 = r10.zzt
            com.google.android.gms.measurement.internal.zzec r11 = r11.zzj()
            java.lang.String r13 = r8.zze()
            java.lang.String r11 = r11.zzf(r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r9.zzd(r13, r14, r15, r11)
            com.google.android.gms.measurement.internal.zzfr r9 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()
            com.google.android.gms.measurement.internal.zzkt r11 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r11 = r11.zzu()
            java.lang.String r11 = r11.zzp(r8)
            java.lang.String r13 = "Filter definition"
            r9.zzb(r13, r11)
        L_0x0a0c:
            boolean r9 = r8.zzj()
            if (r9 == 0) goto L_0x0a4c
            int r9 = r8.zza()
            r11 = 256(0x100, float:3.59E-43)
            if (r9 <= r11) goto L_0x0a1b
            goto L_0x0a4c
        L_0x0a1b:
            com.google.android.gms.measurement.internal.zzz r9 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r11 = r10.zza
            r9.<init>(r10, r11, r6, r8)
            java.lang.Long r11 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r8 = r8.zza()
            boolean r8 = r10.zzf(r6, r8)
            boolean r8 = r9.zzd(r11, r13, r4, r8)
            if (r8 == 0) goto L_0x0a42
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            com.google.android.gms.measurement.internal.zzu r11 = r10.zzd(r11)
            r11.zzc(r9)
            r13 = 0
            goto L_0x09a5
        L_0x0a42:
            java.util.Set r7 = r10.zzb
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            goto L_0x0a76
        L_0x0a4c:
            com.google.android.gms.measurement.internal.zzfr r7 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzk()
            java.lang.String r9 = r10.zza
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)
            boolean r11 = r8.zzj()
            if (r11 == 0) goto L_0x0a6b
            int r8 = r8.zza()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0a6c
        L_0x0a6b:
            r8 = 0
        L_0x0a6c:
            java.lang.String r11 = "Invalid property filter ID. appId, id"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.zzc(r11, r9, r8)
            goto L_0x0a78
        L_0x0a76:
            if (r8 != 0) goto L_0x0a81
        L_0x0a78:
            java.util.Set r7 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
        L_0x0a81:
            r13 = 0
            goto L_0x096f
        L_0x0a84:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a98:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b31
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzu r3 = (com.google.android.gms.measurement.internal.zzu) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfp r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzkt r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgi r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbu()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r7 = r28
            r6.put(r7, r4)
            r4 = r25
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0b16 }
            java.lang.String r8 = "audience_filter_values"
            r9 = 5
            r11 = 0
            long r8 = r0.insertWithOnConflict(r8, r11, r6, r9)     // Catch:{ SQLiteException -> 0x0b14 }
            r12 = -1
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b2b
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt     // Catch:{ SQLiteException -> 0x0b14 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0b14 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0b14 }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ SQLiteException -> 0x0b14 }
            r0.zzb(r6, r8)     // Catch:{ SQLiteException -> 0x0b14 }
            goto L_0x0b2b
        L_0x0b14:
            r0 = move-exception
            goto L_0x0b18
        L_0x0b16:
            r0 = move-exception
            r11 = 0
        L_0x0b18:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()
            java.lang.String r6 = "Error storing filter results. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)
            r3.zzc(r6, r5, r0)
        L_0x0b2b:
            r25 = r4
            r28 = r7
            goto L_0x0a98
        L_0x0b31:
            return r1
        L_0x0b32:
            r0 = move-exception
            r5 = r4
        L_0x0b34:
            if (r5 == 0) goto L_0x0b39
            r5.close()
        L_0x0b39:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
