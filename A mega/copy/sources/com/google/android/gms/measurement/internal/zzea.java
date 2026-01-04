package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final class zzea extends zzf {
    private final zzdz zza;
    private boolean zzb;

    zzea(zzfr zzfr) {
        super(zzfr);
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        this.zza = new zzdz(this, zzau, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A[SYNTHETIC, Splitter:B:47:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzq(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzg()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r3.put(r0, r4)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            r0.zzf()
            r4 = 5
            r5 = r2
            r6 = r4
        L_0x0028:
            if (r5 >= r4) goto L_0x012d
            r7 = 1
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r16.zzh()     // Catch:{ SQLiteFullException -> 0x00fb, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00c2, all -> 0x00bf }
            if (r9 != 0) goto L_0x0035
            r1.zzb = r7     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            r11 = 0
            if (r10 == 0) goto L_0x0054
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0054
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            goto L_0x0121
        L_0x0050:
            r0 = move-exception
            goto L_0x00b9
        L_0x0052:
            r0 = move-exception
            goto L_0x00bd
        L_0x0054:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            java.lang.String r13 = "messages"
            if (r0 < 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r14 = "Data loss, local db full"
            r0.zza(r14)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r14 = 100001(0x186a1, double:4.9407E-319)
            long r14 = r14 - r11
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r0[r2] = r11     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            int r0 = r9.delete(r13, r11, r0)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r11 = (long) r0     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r0 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r0.zzd(r4, r2, r7, r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009f:
            r9.insertOrThrow(r13, r8, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r10 == 0) goto L_0x00ad
            r10.close()
        L_0x00ad:
            r9.close()
            r1 = 1
            return r1
        L_0x00b2:
            r8 = r10
            goto L_0x00ea
        L_0x00b4:
            r0 = move-exception
            goto L_0x0122
        L_0x00b7:
            r0 = move-exception
            r10 = r8
        L_0x00b9:
            r8 = r9
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            r10 = r8
        L_0x00bd:
            r8 = r9
            goto L_0x00fd
        L_0x00bf:
            r0 = move-exception
            r9 = r8
            goto L_0x0122
        L_0x00c2:
            r0 = move-exception
            r10 = r8
        L_0x00c4:
            if (r8 == 0) goto L_0x00cf
            boolean r2 = r8.inTransaction()     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x00cf
            r8.endTransaction()     // Catch:{ all -> 0x011f }
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x011f }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x00e6
            r10.close()
        L_0x00e6:
            if (r8 == 0) goto L_0x0119
            goto L_0x0116
        L_0x00e9:
            r9 = r8
        L_0x00ea:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x00b4 }
            int r6 = r6 + 20
            if (r8 == 0) goto L_0x00f5
            r8.close()
        L_0x00f5:
            if (r9 == 0) goto L_0x0119
            r9.close()
            goto L_0x0119
        L_0x00fb:
            r0 = move-exception
            r10 = r8
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x011f }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x0114
            r10.close()
        L_0x0114:
            if (r8 == 0) goto L_0x0119
        L_0x0116:
            r8.close()
        L_0x0119:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0028
        L_0x011f:
            r0 = move-exception
            r9 = r8
        L_0x0121:
            r8 = r10
        L_0x0122:
            if (r8 == 0) goto L_0x0127
            r8.close()
        L_0x0127:
            if (r9 == 0) goto L_0x012c
            r9.close()
        L_0x012c:
            throw r0
        L_0x012d:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            java.lang.String r1 = "Failed to write entry to local database"
            r0.zza(r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzq(int, byte[]):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:70|71|72|73) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:85|86|87|88) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:57|58|59|60|201) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r12.recycle();
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r12.recycle();
        r13 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x0119 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0151 */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01ec A[SYNTHETIC, Splitter:B:127:0x01ec] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0211 A[SYNTHETIC, Splitter:B:155:0x0211] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x01ef A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x025e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x025e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x025e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzi(int r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "rowid"
            java.lang.String r3 = "Error reading entries from local database"
            r23.zzg()
            boolean r0 = r1.zzb
            r4 = 0
            if (r0 == 0) goto L_0x000f
            return r4
        L_0x000f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r0 = r23.zzl()
            if (r0 == 0) goto L_0x0280
            r6 = 5
            r7 = 0
            r9 = r6
            r8 = r7
        L_0x001e:
            if (r8 >= r6) goto L_0x0270
            r10 = 1
            android.database.sqlite.SQLiteDatabase r15 = r23.zzh()     // Catch:{ SQLiteFullException -> 0x0244, SQLiteDatabaseLockedException -> 0x0231, SQLiteException -> 0x020c, all -> 0x0209 }
            if (r15 != 0) goto L_0x002a
            r1.zzb = r10     // Catch:{ SQLiteFullException -> 0x0204, SQLiteDatabaseLockedException -> 0x0200, SQLiteException -> 0x01fb, all -> 0x01f6 }
            return r4
        L_0x002a:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0204, SQLiteDatabaseLockedException -> 0x0200, SQLiteException -> 0x01fb, all -> 0x01f6 }
            java.lang.String r0 = "3"
            java.lang.String r12 = "messages"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ all -> 0x01e7 }
            r13[r7] = r2     // Catch:{ all -> 0x01e7 }
            java.lang.String r14 = "type=?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ all -> 0x01e7 }
            r11[r7] = r0     // Catch:{ all -> 0x01e7 }
            java.lang.String r18 = "rowid desc"
            java.lang.String r19 = "1"
            r16 = 0
            r17 = 0
            r0 = r11
            r11 = r15
            r24 = r15
            r15 = r0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01e3 }
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x01df }
            r20 = -1
            if (r0 == 0) goto L_0x005e
            long r12 = r11.getLong(r7)     // Catch:{ all -> 0x01df }
            if (r11 == 0) goto L_0x0079
            r11.close()     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            goto L_0x0079
        L_0x005e:
            if (r11 == 0) goto L_0x0077
            r11.close()     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            goto L_0x0077
        L_0x0064:
            r0 = move-exception
            r13 = r24
            goto L_0x01f8
        L_0x0069:
            r0 = move-exception
            r13 = r24
            goto L_0x01fd
        L_0x006e:
            r13 = r24
            goto L_0x0201
        L_0x0072:
            r0 = move-exception
            r13 = r24
            goto L_0x0206
        L_0x0077:
            r12 = r20
        L_0x0079:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            r11[r7] = r12     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            r14 = r0
            r15 = r11
            goto L_0x008c
        L_0x008a:
            r14 = r4
            r15 = r14
        L_0x008c:
            r0 = 3
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            r13[r7] = r2     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            java.lang.String r11 = "type"
            r13[r10] = r11     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            java.lang.String r11 = "entry"
            r12 = 2
            r13[r12] = r11     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            java.lang.String r16 = "messages"
            java.lang.String r18 = "rowid asc"
            r11 = 100
            java.lang.String r19 = java.lang.Integer.toString(r11)     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
            r17 = 0
            r22 = 0
            r11 = r24
            r6 = r12
            r12 = r16
            r16 = r17
            r17 = r22
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x006e, SQLiteException -> 0x0069, all -> 0x0064 }
        L_0x00b5:
            boolean r12 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            if (r12 == 0) goto L_0x0193
            long r20 = r11.getLong(r7)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            int r12 = r11.getInt(r10)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            byte[] r13 = r11.getBlob(r6)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            if (r12 != 0) goto L_0x00fe
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            int r14 = r13.length     // Catch:{ ParseException -> 0x00e7 }
            r12.unmarshall(r13, r7, r14)     // Catch:{ ParseException -> 0x00e7 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00e7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaw> r13 = com.google.android.gms.measurement.internal.zzaw.CREATOR     // Catch:{ ParseException -> 0x00e7 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x00e7 }
            com.google.android.gms.measurement.internal.zzaw r13 = (com.google.android.gms.measurement.internal.zzaw) r13     // Catch:{ ParseException -> 0x00e7 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            if (r13 == 0) goto L_0x00b5
            r5.add(r13)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x00b5
        L_0x00e5:
            r0 = move-exception
            goto L_0x00fa
        L_0x00e7:
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x00e5 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ all -> 0x00e5 }
            java.lang.String r14 = "Failed to load event from local database"
            r13.zza(r14)     // Catch:{ all -> 0x00e5 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x00b5
        L_0x00fa:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            throw r0     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
        L_0x00fe:
            if (r12 != r10) goto L_0x0136
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            int r14 = r13.length     // Catch:{ ParseException -> 0x0119 }
            r12.unmarshall(r13, r7, r14)     // Catch:{ ParseException -> 0x0119 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x0119 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r13 = com.google.android.gms.measurement.internal.zzkw.CREATOR     // Catch:{ ParseException -> 0x0119 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x0119 }
            com.google.android.gms.measurement.internal.zzkw r13 = (com.google.android.gms.measurement.internal.zzkw) r13     // Catch:{ ParseException -> 0x0119 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x012c
        L_0x0117:
            r0 = move-exception
            goto L_0x0132
        L_0x0119:
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ all -> 0x0117 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x0117 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ all -> 0x0117 }
            java.lang.String r14 = "Failed to load user property from local database"
            r13.zza(r14)     // Catch:{ all -> 0x0117 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            r13 = r4
        L_0x012c:
            if (r13 == 0) goto L_0x00b5
            r5.add(r13)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x00b5
        L_0x0132:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            throw r0     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
        L_0x0136:
            if (r12 != r6) goto L_0x016f
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            int r14 = r13.length     // Catch:{ ParseException -> 0x0151 }
            r12.unmarshall(r13, r7, r14)     // Catch:{ ParseException -> 0x0151 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x0151 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzac> r13 = com.google.android.gms.measurement.internal.zzac.CREATOR     // Catch:{ ParseException -> 0x0151 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x0151 }
            com.google.android.gms.measurement.internal.zzac r13 = (com.google.android.gms.measurement.internal.zzac) r13     // Catch:{ ParseException -> 0x0151 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x0164
        L_0x014f:
            r0 = move-exception
            goto L_0x016b
        L_0x0151:
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ all -> 0x014f }
            java.lang.String r14 = "Failed to load conditional user property from local database"
            r13.zza(r14)     // Catch:{ all -> 0x014f }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            r13 = r4
        L_0x0164:
            if (r13 == 0) goto L_0x00b5
            r5.add(r13)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x00b5
        L_0x016b:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            throw r0     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
        L_0x016f:
            if (r12 != r0) goto L_0x0182
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzk()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            java.lang.String r13 = "Skipping app launch break"
            r12.zza(r13)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x00b5
        L_0x0182:
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            java.lang.String r13 = "Unknown record type in local database"
            r12.zza(r13)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            goto L_0x00b5
        L_0x0193:
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            java.lang.String r6 = java.lang.Long.toString(r20)     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            r0[r7] = r6     // Catch:{ SQLiteFullException -> 0x01db, SQLiteDatabaseLockedException -> 0x01d8, SQLiteException -> 0x01d4, all -> 0x01cf }
            java.lang.String r6 = "messages"
            java.lang.String r12 = "rowid <= ?"
            r13 = r24
            int r0 = r13.delete(r6, r12, r0)     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            int r6 = r5.size()     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            if (r0 >= r6) goto L_0x01ba
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            java.lang.String r6 = "Fewer entries removed from local database than expected"
            r0.zza(r6)     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
        L_0x01ba:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x01cd, SQLiteDatabaseLockedException -> 0x0202, SQLiteException -> 0x01cb, all -> 0x01c9 }
            if (r11 == 0) goto L_0x01c5
            r11.close()
        L_0x01c5:
            r13.close()
            return r5
        L_0x01c9:
            r0 = move-exception
            goto L_0x01d2
        L_0x01cb:
            r0 = move-exception
            goto L_0x01fe
        L_0x01cd:
            r0 = move-exception
            goto L_0x0207
        L_0x01cf:
            r0 = move-exception
            r13 = r24
        L_0x01d2:
            r4 = r11
            goto L_0x01f8
        L_0x01d4:
            r0 = move-exception
            r13 = r24
            goto L_0x01fe
        L_0x01d8:
            r13 = r24
            goto L_0x0202
        L_0x01db:
            r0 = move-exception
            r13 = r24
            goto L_0x0207
        L_0x01df:
            r0 = move-exception
            r13 = r24
            goto L_0x01ea
        L_0x01e3:
            r0 = move-exception
            r13 = r24
            goto L_0x01e9
        L_0x01e7:
            r0 = move-exception
            r13 = r15
        L_0x01e9:
            r11 = r4
        L_0x01ea:
            if (r11 == 0) goto L_0x01ef
            r11.close()     // Catch:{ SQLiteFullException -> 0x01f4, SQLiteDatabaseLockedException -> 0x0201, SQLiteException -> 0x01f2, all -> 0x01f0 }
        L_0x01ef:
            throw r0     // Catch:{ SQLiteFullException -> 0x01f4, SQLiteDatabaseLockedException -> 0x0201, SQLiteException -> 0x01f2, all -> 0x01f0 }
        L_0x01f0:
            r0 = move-exception
            goto L_0x01f8
        L_0x01f2:
            r0 = move-exception
            goto L_0x01fd
        L_0x01f4:
            r0 = move-exception
            goto L_0x0206
        L_0x01f6:
            r0 = move-exception
            r13 = r15
        L_0x01f8:
            r15 = r13
            goto L_0x0265
        L_0x01fb:
            r0 = move-exception
            r13 = r15
        L_0x01fd:
            r11 = r4
        L_0x01fe:
            r15 = r13
            goto L_0x020f
        L_0x0200:
            r13 = r15
        L_0x0201:
            r11 = r4
        L_0x0202:
            r15 = r13
            goto L_0x0233
        L_0x0204:
            r0 = move-exception
            r13 = r15
        L_0x0206:
            r11 = r4
        L_0x0207:
            r15 = r13
            goto L_0x0247
        L_0x0209:
            r0 = move-exception
            r15 = r4
            goto L_0x0265
        L_0x020c:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x020f:
            if (r15 == 0) goto L_0x021a
            boolean r6 = r15.inTransaction()     // Catch:{ all -> 0x0263 }
            if (r6 == 0) goto L_0x021a
            r15.endTransaction()     // Catch:{ all -> 0x0263 }
        L_0x021a:
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzt     // Catch:{ all -> 0x0263 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0263 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x0263 }
            r6.zzb(r3, r0)     // Catch:{ all -> 0x0263 }
            r1.zzb = r10     // Catch:{ all -> 0x0263 }
            if (r11 == 0) goto L_0x022e
            r11.close()
        L_0x022e:
            if (r15 == 0) goto L_0x025e
            goto L_0x0240
        L_0x0231:
            r11 = r4
            r15 = r11
        L_0x0233:
            long r12 = (long) r9
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x0263 }
            int r9 = r9 + 20
            if (r11 == 0) goto L_0x023e
            r11.close()
        L_0x023e:
            if (r15 == 0) goto L_0x025e
        L_0x0240:
            r15.close()
            goto L_0x025e
        L_0x0244:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0247:
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzt     // Catch:{ all -> 0x0263 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0263 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x0263 }
            r6.zzb(r3, r0)     // Catch:{ all -> 0x0263 }
            r1.zzb = r10     // Catch:{ all -> 0x0263 }
            if (r11 == 0) goto L_0x025b
            r11.close()
        L_0x025b:
            if (r15 == 0) goto L_0x025e
            goto L_0x0240
        L_0x025e:
            int r8 = r8 + 1
            r6 = 5
            goto L_0x001e
        L_0x0263:
            r0 = move-exception
            r4 = r11
        L_0x0265:
            if (r4 == 0) goto L_0x026a
            r4.close()
        L_0x026a:
            if (r15 == 0) goto L_0x026f
            r15.close()
        L_0x026f:
            throw r0
        L_0x0270:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r1 = "Failed to read events from database in reasonable time"
            r0.zza(r1)
            return r4
        L_0x0280:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzi(int):java.util.List");
    }

    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh != null && (delete = zzh.delete("messages", (String) null, (String[]) null)) > 0) {
                this.zzt.zzay().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            this.zzt.zzay().zzd().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        return zzau.getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i = 5;
            int i2 = 0;
            while (i2 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzh = zzh();
                    if (zzh == null) {
                        this.zzb = true;
                        return false;
                    }
                    zzh.beginTransaction();
                    zzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzh.setTransactionSuccessful();
                    zzh.endTransaction();
                    zzh.close();
                    return true;
                } catch (SQLiteFullException e) {
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e);
                    this.zzb = true;
                    if (sQLiteDatabase == null) {
                        i2++;
                    }
                    sQLiteDatabase.close();
                    i2++;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i);
                    i += 20;
                    if (sQLiteDatabase == null) {
                        i2++;
                    }
                    sQLiteDatabase.close();
                    i2++;
                } catch (SQLiteException e2) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e2);
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        i2++;
                    } else {
                        i2++;
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            this.zzt.zzay().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzac) {
        byte[] zzan = this.zzt.zzv().zzan(zzac);
        if (zzan.length <= 131072) {
            return zzq(2, zzan);
        }
        this.zzt.zzay().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzaw zzaw) {
        Parcel obtain = Parcel.obtain();
        zzax.zza(zzaw, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(0, marshall);
        }
        this.zzt.zzay().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzkw zzkw) {
        Parcel obtain = Parcel.obtain();
        zzkx.zza(zzkw, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(1, marshall);
        }
        this.zzt.zzay().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
