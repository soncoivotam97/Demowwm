package com.sangtacviet.vhwwm;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

public class HotfixPatcher {
    private static final String TAG = "HotfixPatcher";
    private static final Pattern dictTableFind = Pattern.compile("\\['name'\\]='translate_words_map_en'");
    private static final Pattern removeFontScript = Pattern.compile("local WWMVH=0;([\\s\\S]*?)local WWMVHEND=0;");
    private static final Pattern voidoutLine = Pattern.compile("\\[[\\-\\d]+\\]=");
    private HotfixDictionary hotfixDict;
    private MainActivity main;

    public HotfixPatcher(MainActivity mainActivity) {
        this.main = mainActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runPatchHotfix(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "HotfixPatcher"
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r8 = android.database.sqlite.SQLiteDatabase.openDatabase(r8, r2, r1)     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = "SELECT id FROM localdb WHERE id LIKE 'hotfix_%'"
            android.database.Cursor r2 = r8.rawQuery(r3, r2)     // Catch:{ Exception -> 0x0067, all -> 0x0064 }
        L_0x000e:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x0058 }
            if (r3 == 0) goto L_0x0047
            java.lang.String r3 = r2.getString(r1)     // Catch:{ all -> 0x0058 }
            byte[] r4 = r7.readBlobSafe(r8, r3)     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r5.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = "Applying hotfix "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = " with content size "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0058 }
            int r6 = r4.length     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.String r6 = " bytes."
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0058 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0058 }
            android.util.Log.d(r0, r5)     // Catch:{ all -> 0x0058 }
            r7.processHotfixRecord(r8, r3, r4)     // Catch:{ all -> 0x0058 }
            goto L_0x000e
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r2.close()     // Catch:{ Exception -> 0x0067, all -> 0x0064 }
        L_0x004c:
            if (r8 == 0) goto L_0x0099
            boolean r7 = r8.isOpen()
            if (r7 == 0) goto L_0x0099
            r8.close()
            goto L_0x0099
        L_0x0058:
            r1 = move-exception
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ all -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch:{ Exception -> 0x0067, all -> 0x0064 }
        L_0x0063:
            throw r1     // Catch:{ Exception -> 0x0067, all -> 0x0064 }
        L_0x0064:
            r7 = move-exception
            r2 = r8
            goto L_0x009a
        L_0x0067:
            r1 = move-exception
            r2 = r8
            goto L_0x006d
        L_0x006a:
            r7 = move-exception
            goto L_0x009a
        L_0x006c:
            r1 = move-exception
        L_0x006d:
            java.lang.String r8 = "Error running hotfix patcher"
            android.util.Log.e(r0, r8, r1)     // Catch:{ all -> 0x006a }
            com.sangtacviet.vhwwm.MainActivity r7 = r7.main     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r8.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "Lỗi Hotfix: "
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ all -> 0x006a }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ all -> 0x006a }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x006a }
            r7.writeLog(r8)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0099
            boolean r7 = r2.isOpen()
            if (r7 == 0) goto L_0x0099
            r2.close()
        L_0x0099:
            return
        L_0x009a:
            if (r2 == 0) goto L_0x00a5
            boolean r8 = r2.isOpen()
            if (r8 == 0) goto L_0x00a5
            r2.close()
        L_0x00a5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.HotfixPatcher.runPatchHotfix(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addLuaText(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "HotfixPatcher"
            java.lang.String r1 = "Đã thêm patch font vào hotfix "
            java.lang.String r2 = "Added lua text to hotfix "
            java.lang.String r3 = "Lỗi thêm Lua: "
            if (r10 == 0) goto L_0x00d5
            boolean r4 = r10.isEmpty()
            if (r4 == 0) goto L_0x0012
            goto L_0x00d5
        L_0x0012:
            r4 = 0
            r5 = 0
            android.database.sqlite.SQLiteDatabase r9 = android.database.sqlite.SQLiteDatabase.openDatabase(r9, r5, r4)     // Catch:{ Exception -> 0x00a1 }
            java.lang.String r6 = "SELECT id, content FROM localdb WHERE id LIKE 'hotfix_2%' AND length(content) > 100 LIMIT 1"
            android.database.Cursor r5 = r9.rawQuery(r6, r5)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x008d }
            if (r6 == 0) goto L_0x007c
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x008d }
            byte[] r6 = r8.readBlobSafe(r9, r4)     // Catch:{ all -> 0x008d }
            byte[] r6 = r8.xorEncryption(r6)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = com.sangtacviet.vhwwm.HotfixPatcher.MsgPackStr.decode(r6)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r7.<init>()     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r6 = r7.append(r6)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "\n"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r10 = r6.append(r10)     // Catch:{ all -> 0x008d }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x008d }
            byte[] r10 = com.sangtacviet.vhwwm.HotfixPatcher.MsgPackStr.encode(r10)     // Catch:{ all -> 0x008d }
            byte[] r10 = r8.xorEncryption(r10)     // Catch:{ all -> 0x008d }
            r8.writeHotfixData(r9, r4, r10)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r10.<init>(r2)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch:{ all -> 0x008d }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x008d }
            android.util.Log.d(r0, r10)     // Catch:{ all -> 0x008d }
            com.sangtacviet.vhwwm.MainActivity r10 = r8.main     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r2.<init>(r1)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r1 = r2.append(r4)     // Catch:{ all -> 0x008d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008d }
            r10.writeLog(r1)     // Catch:{ all -> 0x008d }
        L_0x007c:
            if (r5 == 0) goto L_0x0081
            r5.close()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
        L_0x0081:
            if (r9 == 0) goto L_0x00c8
            boolean r8 = r9.isOpen()
            if (r8 == 0) goto L_0x00c8
            r9.close()
            goto L_0x00c8
        L_0x008d:
            r10 = move-exception
            if (r5 == 0) goto L_0x0098
            r5.close()     // Catch:{ all -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r1 = move-exception
            r10.addSuppressed(r1)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
        L_0x0098:
            throw r10     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
        L_0x0099:
            r8 = move-exception
            r5 = r9
            goto L_0x00c9
        L_0x009c:
            r10 = move-exception
            r5 = r9
            goto L_0x00a2
        L_0x009f:
            r8 = move-exception
            goto L_0x00c9
        L_0x00a1:
            r10 = move-exception
        L_0x00a2:
            java.lang.String r9 = "Error adding lua text"
            android.util.Log.e(r0, r9, r10)     // Catch:{ all -> 0x009f }
            com.sangtacviet.vhwwm.MainActivity r8 = r8.main     // Catch:{ all -> 0x009f }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r9.<init>(r3)     // Catch:{ all -> 0x009f }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x009f }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x009f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x009f }
            r8.writeLog(r9)     // Catch:{ all -> 0x009f }
            if (r5 == 0) goto L_0x00c8
            boolean r8 = r5.isOpen()
            if (r8 == 0) goto L_0x00c8
            r5.close()
        L_0x00c8:
            return
        L_0x00c9:
            if (r5 == 0) goto L_0x00d4
            boolean r9 = r5.isOpen()
            if (r9 == 0) goto L_0x00d4
            r5.close()
        L_0x00d4:
            throw r8
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.HotfixPatcher.addLuaText(java.lang.String, java.lang.String):void");
    }

    public void loadDictionary(String str) {
        if (str != null && !str.isEmpty()) {
            this.hotfixDict = new HotfixDictionary(str);
        }
    }

    public void removeAllPatch(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(str, (SQLiteDatabase.CursorFactory) null, 0);
            sQLiteDatabase.execSQL("DELETE FROM localdb WHERE id LIKE 'hotfix_%'");
            Log.d(TAG, "Removed all hotfix patches.");
            this.main.writeLog("Đã xóa tất cả hotfix.");
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error removing patches", e);
            this.main.writeLog("Lỗi xóa hotfix: " + e.getMessage());
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064 A[Catch:{ Exception -> 0x00d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processHotfixRecord(android.database.sqlite.SQLiteDatabase r12, java.lang.String r13, byte[] r14) {
        /*
            r11 = this;
            java.lang.String r0 = "\n"
            java.lang.String r1 = "HotfixPatcher"
            java.lang.String r2 = "hotfix_meta"
            boolean r2 = r13.contains(r2)
            if (r2 == 0) goto L_0x000d
            return
        L_0x000d:
            byte[] r14 = r11.xorEncryption(r14)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r14 = com.sangtacviet.vhwwm.HotfixPatcher.MsgPackStr.decode(r14)     // Catch:{ Exception -> 0x00d4 }
            r2 = 0
            r3 = 1
            if (r14 == 0) goto L_0x0035
            java.lang.String r4 = "WWMVH"
            boolean r4 = r14.contains(r4)     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x0035
            java.util.regex.Pattern r4 = removeFontScript     // Catch:{ Exception -> 0x00d4 }
            java.util.regex.Matcher r4 = r4.matcher(r14)     // Catch:{ Exception -> 0x00d4 }
            boolean r5 = r4.find()     // Catch:{ Exception -> 0x00d4 }
            if (r5 == 0) goto L_0x0035
            java.lang.String r14 = ""
            java.lang.String r14 = r4.replaceAll(r14)     // Catch:{ Exception -> 0x00d4 }
            r4 = r3
            goto L_0x0036
        L_0x0035:
            r4 = r2
        L_0x0036:
            java.lang.String r5 = "translate_words_map_en"
            boolean r5 = r14.contains(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r6 = "Hotfix "
            if (r5 != 0) goto L_0x0064
            if (r4 == 0) goto L_0x0063
            byte[] r14 = com.sangtacviet.vhwwm.HotfixPatcher.MsgPackStr.encode(r14)     // Catch:{ Exception -> 0x00d4 }
            byte[] r14 = r11.xorEncryption(r14)     // Catch:{ Exception -> 0x00d4 }
            r11.writeHotfixData(r12, r13, r14)     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r11.<init>(r6)     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r11 = r11.append(r13)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r12 = " font script removed."
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00d4 }
            android.util.Log.d(r1, r11)     // Catch:{ Exception -> 0x00d4 }
        L_0x0063:
            return
        L_0x0064:
            r5 = -1
            java.lang.String[] r5 = r14.split(r0, r5)     // Catch:{ Exception -> 0x00d4 }
            r7 = r2
            r8 = r7
        L_0x006b:
            int r9 = r5.length     // Catch:{ Exception -> 0x00d4 }
            if (r2 >= r9) goto L_0x00a4
            java.util.regex.Pattern r9 = dictTableFind     // Catch:{ Exception -> 0x00d4 }
            r10 = r5[r2]     // Catch:{ Exception -> 0x00d4 }
            java.util.regex.Matcher r9 = r9.matcher(r10)     // Catch:{ Exception -> 0x00d4 }
            boolean r9 = r9.find()     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x007d
            r7 = r3
        L_0x007d:
            if (r7 == 0) goto L_0x008a
            r9 = r5[r2]     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = ".hotfix_manager:update_table"
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x008a
            goto L_0x00a4
        L_0x008a:
            if (r7 == 0) goto L_0x00a1
            com.sangtacviet.vhwwm.HotfixPatcher$HotfixDictionary r9 = r11.hotfixDict     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x00a1
            r10 = r5[r2]     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r9 = r11.processHotFixLine(r10, r9)     // Catch:{ Exception -> 0x00d4 }
            r10 = r5[r2]     // Catch:{ Exception -> 0x00d4 }
            boolean r10 = r9.equals(r10)     // Catch:{ Exception -> 0x00d4 }
            if (r10 != 0) goto L_0x00a1
            r5[r2] = r9     // Catch:{ Exception -> 0x00d4 }
            r8 = r3
        L_0x00a1:
            int r2 = r2 + 1
            goto L_0x006b
        L_0x00a4:
            if (r8 == 0) goto L_0x00ab
            java.lang.String r14 = java.lang.String.join(r0, r5)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00ac
        L_0x00ab:
            r3 = r4
        L_0x00ac:
            if (r3 == 0) goto L_0x00e7
            byte[] r14 = com.sangtacviet.vhwwm.HotfixPatcher.MsgPackStr.encode(r14)     // Catch:{ Exception -> 0x00d4 }
            byte[] r14 = r11.xorEncryption(r14)     // Catch:{ Exception -> 0x00d4 }
            r11.writeHotfixData(r12, r13, r14)     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r11.<init>()     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r11 = r11.append(r6)     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r11 = r11.append(r13)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r12 = " updated."
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00d4 }
            android.util.Log.d(r1, r11)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00e7
        L_0x00d4:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "Error processing hotfix "
            r12.<init>(r14)
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            android.util.Log.e(r1, r12, r11)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.HotfixPatcher.processHotfixRecord(android.database.sqlite.SQLiteDatabase, java.lang.String, byte[]):void");
    }

    private String processHotFixLine(String str, HotfixDictionary hotfixDictionary) {
        String value;
        int indexOf;
        int i;
        Matcher matcher = Pattern.compile("\\[([\\-\\d]+)\\]=").matcher(str);
        if (matcher.find() && (value = hotfixDictionary.getValue(matcher.group(1))) != null && (indexOf = str.indexOf("=")) != -1 && (i = indexOf + 1) < str.length()) {
            String substring = str.substring(i, indexOf + 2);
            int indexOf2 = str.indexOf(substring) + 1;
            int lastIndexOf = str.lastIndexOf(substring);
            if (!(indexOf2 == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf2)) {
                return str.substring(0, indexOf2) + value.replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r").replace(substring, "\\" + substring) + str.substring(lastIndexOf);
            }
        }
        return str;
    }

    public static class HotfixDictionary {
        private Map<String, String> dict = new HashMap();

        public HotfixDictionary(String str) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split("=", 2);
                            if (split.length >= 2) {
                                this.dict.put(split[0], split[1].replace("\\n", "\n"));
                            }
                        } else {
                            bufferedReader.close();
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(HotfixPatcher.TAG, "Error loading dictionary", e);
            }
        }

        public String getValue(String str) {
            return this.dict.get(str);
        }
    }

    private void writeHotfixData(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("UPDATE localdb SET content=? WHERE id=?");
        compileStatement.bindBlob(1, bArr);
        compileStatement.bindString(2, str);
        compileStatement.execute();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r4 != null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r4 != null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r4 != null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        r4.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] readBlobSafe(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r10 = 1
            java.lang.String[] r0 = new java.lang.String[r10]
            r1 = 0
            r0[r1] = r12
            java.lang.String r2 = "SELECT length(content) FROM localdb WHERE id = ?"
            android.database.Cursor r0 = r11.rawQuery(r2, r0)
            boolean r2 = r0.moveToFirst()     // Catch:{ all -> 0x0083 }
            r3 = 0
            if (r2 == 0) goto L_0x0019
            long r5 = r0.getLong(r1)     // Catch:{ all -> 0x0083 }
            goto L_0x001a
        L_0x0019:
            r5 = r3
        L_0x001a:
            if (r0 == 0) goto L_0x001f
            r0.close()
        L_0x001f:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0026
            byte[] r10 = new byte[r1]
            return r10
        L_0x0026:
            int r0 = (int) r5
            byte[] r2 = new byte[r0]
            r3 = r1
        L_0x002a:
            long r7 = (long) r3
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0082
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]
            int r7 = r3 + 1
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r4[r1] = r7
            r7 = 1048576(0x100000, float:1.469368E-39)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r4[r10] = r7
            r7 = 2
            r4[r7] = r12
            java.lang.String r7 = "SELECT substr(content, ?, ?) FROM localdb WHERE id = ?"
            android.database.Cursor r4 = r11.rawQuery(r7, r4)
            boolean r7 = r4.moveToFirst()     // Catch:{ all -> 0x0076 }
            if (r7 == 0) goto L_0x0070
            byte[] r7 = r4.getBlob(r1)     // Catch:{ all -> 0x0076 }
            if (r7 == 0) goto L_0x006d
            int r8 = r0 - r3
            int r9 = r7.length     // Catch:{ all -> 0x0076 }
            int r8 = java.lang.Math.min(r9, r8)     // Catch:{ all -> 0x0076 }
            if (r8 <= 0) goto L_0x006a
            java.lang.System.arraycopy(r7, r1, r2, r3, r8)     // Catch:{ all -> 0x0076 }
            int r3 = r3 + r8
            if (r4 == 0) goto L_0x002a
            r4.close()
            goto L_0x002a
        L_0x006a:
            if (r4 == 0) goto L_0x0082
            goto L_0x0072
        L_0x006d:
            if (r4 == 0) goto L_0x0082
            goto L_0x0072
        L_0x0070:
            if (r4 == 0) goto L_0x0082
        L_0x0072:
            r4.close()
            goto L_0x0082
        L_0x0076:
            r10 = move-exception
            if (r4 == 0) goto L_0x0081
            r4.close()     // Catch:{ all -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r11 = move-exception
            r10.addSuppressed(r11)
        L_0x0081:
            throw r10
        L_0x0082:
            return r2
        L_0x0083:
            r10 = move-exception
            if (r0 == 0) goto L_0x008e
            r0.close()     // Catch:{ all -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r11 = move-exception
            r10.addSuppressed(r11)
        L_0x008e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.HotfixPatcher.readBlobSafe(android.database.sqlite.SQLiteDatabase, java.lang.String):byte[]");
    }

    private byte[] xorEncryption(byte[] bArr) {
        byte[] bytes = "netease_hex_xor_encrypt_key".getBytes(StandardCharsets.UTF_8);
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ bytes[i % bytes.length]);
        }
        return bArr2;
    }

    public String luaForUnlockFPS() {
        return luaForUnlockFPS(120);
    }

    public String luaForUnlockFPS(int i) {
        return "local WWMVH = 0\n-- Hook MEngine.SetFrameLimit to force custom FPS\nif MEngine and MEngine.SetFrameLimit then\n    local originalSetFPS = MEngine.SetFrameLimit\n    MEngine.SetFrameLimit = function(value)\n        -- Ignore the original value and use custom FPS\n        return originalSetFPS(" + i + ")\n    end\nend\noriginalSetFPS(" + i + ")\nMEngine.EnableVsync(false)\nlocal WWMVHEND = 0\n";
    }

    public static class MsgPackStr {
        public static String decode(byte[] bArr) {
            int i;
            if (bArr == null || bArr.length == 0 || bArr.length <= 0) {
                return "";
            }
            byte b = bArr[0] & UByte.MAX_VALUE;
            int i2 = 1;
            if (b >= 160 && b <= 191) {
                i = b - 160;
            } else if (b == 217) {
                if (2 > bArr.length) {
                    return "";
                }
                i = bArr[1] & UByte.MAX_VALUE;
                i2 = 2;
            } else if (b == 218) {
                if (3 > bArr.length) {
                    return "";
                }
                i = ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE);
                i2 = 3;
            } else if (b != 219) {
                return new String(bArr, StandardCharsets.UTF_8);
            } else {
                if (5 > bArr.length) {
                    return "";
                }
                i = ((bArr[1] & UByte.MAX_VALUE) << 24) | ((bArr[2] & UByte.MAX_VALUE) << 16) | ((bArr[3] & UByte.MAX_VALUE) << 8) | (bArr[4] & UByte.MAX_VALUE);
                i2 = 5;
            }
            if (i2 + i > bArr.length) {
                return "";
            }
            return new String(bArr, i2, i, StandardCharsets.UTF_8);
        }

        public static byte[] encode(String str) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (length < 32) {
                try {
                    byteArrayOutputStream.write(length | 160);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (length < 256) {
                byteArrayOutputStream.write(217);
                byteArrayOutputStream.write(length);
            } else if (length < 65536) {
                byteArrayOutputStream.write(218);
                byteArrayOutputStream.write((length >> 8) & 255);
                byteArrayOutputStream.write(length & 255);
            } else {
                byteArrayOutputStream.write(219);
                byteArrayOutputStream.write((length >> 24) & 255);
                byteArrayOutputStream.write((length >> 16) & 255);
                byteArrayOutputStream.write((length >> 8) & 255);
                byteArrayOutputStream.write(length & 255);
            }
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        }
    }
}
