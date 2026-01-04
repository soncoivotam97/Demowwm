package com.sangtacviet.vhwwm;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FontManager {
    private static final String F1_GAME_NAME = "AlegreyaSans-Regular.ttf";
    private static final String F2_GAME_NAME = "AlegreyaSans-Medium.ttf";
    private static final String F3_GAME_NAME = "MrsEavSmaCap.ttf";
    private static final String TAG = "FontManager";
    private List<String> availableFonts;
    private Context context;
    private File userFontDir;

    public FontManager(Context context2) {
        this.context = context2;
        File file = new File(context2.getFilesDir(), "Fonts");
        this.userFontDir = file;
        if (!file.exists()) {
            this.userFontDir.mkdirs();
        }
        refreshAvailableFonts();
    }

    public void refreshAvailableFonts() {
        ArrayList arrayList = new ArrayList();
        this.availableFonts = arrayList;
        arrayList.add("Mặc Định");
        try {
            String[] list = this.context.getAssets().list("fonts");
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ttf")) {
                        this.availableFonts.add(str.replace(".ttf", ""));
                    }
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Error listing asset fonts", e);
        }
        File[] listFiles = this.userFontDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().endsWith(".ttf")) {
                    String replace = file.getName().replace(".ttf", "");
                    if (!this.availableFonts.contains(replace)) {
                        this.availableFonts.add(replace);
                    }
                }
            }
        }
    }

    public List<String> getAvailableFonts() {
        return this.availableFonts;
    }

    public void addUserFont(InputStream inputStream, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.userFontDir, str));
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    refreshAvailableFonts();
                    return;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8 A[SYNTHETIC, Splitter:B:25:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e2 A[Catch:{ all -> 0x00ff, all -> 0x0105, all -> 0x00d4, all -> 0x00dc, IOException -> 0x010b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String applyFontPatch(com.sangtacviet.vhwwm.MainActivity r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 3
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r0 = "AlegreyaSans-Regular.ttf"
            r6 = 0
            r5[r6] = r0
            java.lang.String r0 = "AlegreyaSans-Medium.ttf"
            r7 = 1
            r5[r7] = r0
            java.lang.String r0 = "MrsEavSmaCap.ttf"
            r8 = 2
            r5[r8] = r0
            java.lang.String[] r9 = new java.lang.String[r4]
            r9[r6] = r18
            r9[r7] = r19
            r9[r8] = r20
            r8 = r6
        L_0x0024:
            if (r8 >= r4) goto L_0x0127
            r10 = r9[r8]
            r11 = r5[r8]
            if (r10 == 0) goto L_0x0122
            java.lang.String r0 = "Mặc Định"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0036
            goto L_0x0122
        L_0x0036:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r12 = ".ttf"
            java.lang.StringBuilder r0 = r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.io.File r13 = new java.io.File
            java.io.File r0 = r1.userFontDir
            r13.<init>(r0, r12)
            android.content.Context r0 = r1.context     // Catch:{ IOException -> 0x0070 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ IOException -> 0x0070 }
            java.lang.String r14 = "fonts"
            java.lang.String[] r0 = r0.list(r14)     // Catch:{ IOException -> 0x0070 }
            if (r0 == 0) goto L_0x0074
            int r14 = r0.length     // Catch:{ IOException -> 0x0070 }
            r15 = r6
        L_0x0060:
            if (r15 >= r14) goto L_0x0074
            r4 = r0[r15]     // Catch:{ IOException -> 0x0070 }
            boolean r4 = r4.equals(r12)     // Catch:{ IOException -> 0x0070 }
            if (r4 == 0) goto L_0x006c
            r0 = r7
            goto L_0x0075
        L_0x006c:
            int r15 = r15 + 1
            r4 = 3
            goto L_0x0060
        L_0x0070:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0074:
            r0 = r6
        L_0x0075:
            boolean r4 = r13.exists()
            if (r4 != 0) goto L_0x0097
            if (r0 != 0) goto L_0x0097
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Font '"
            r0.<init>(r4)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r4 = "' không tồn tại."
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            r2.writeLog(r0)
            goto L_0x0122
        L_0x0097:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "LocalData/"
            r4.<init>(r10)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r4 = r4.toString()
            if (r0 == 0) goto L_0x00e2
            android.content.Context r0 = r1.context     // Catch:{ IOException -> 0x010b }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ IOException -> 0x010b }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010b }
            r10.<init>()     // Catch:{ IOException -> 0x010b }
            java.lang.String r13 = "fonts/"
            java.lang.StringBuilder r10 = r10.append(r13)     // Catch:{ IOException -> 0x010b }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ IOException -> 0x010b }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x010b }
            java.io.InputStream r10 = r0.open(r10)     // Catch:{ IOException -> 0x010b }
            int r0 = r10.available()     // Catch:{ all -> 0x00d4 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00d4 }
            r10.read(r0)     // Catch:{ all -> 0x00d4 }
            if (r10 == 0) goto L_0x00f4
            r10.close()     // Catch:{ IOException -> 0x010b }
            goto L_0x00f4
        L_0x00d4:
            r0 = move-exception
            r4 = r0
            if (r10 == 0) goto L_0x00e1
            r10.close()     // Catch:{ all -> 0x00dc }
            goto L_0x00e1
        L_0x00dc:
            r0 = move-exception
            r10 = r0
            r4.addSuppressed(r10)     // Catch:{ IOException -> 0x010b }
        L_0x00e1:
            throw r4     // Catch:{ IOException -> 0x010b }
        L_0x00e2:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ IOException -> 0x010b }
            r10.<init>(r13)     // Catch:{ IOException -> 0x010b }
            long r13 = r13.length()     // Catch:{ all -> 0x00ff }
            int r0 = (int) r13     // Catch:{ all -> 0x00ff }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00ff }
            r10.read(r0)     // Catch:{ all -> 0x00ff }
            r10.close()     // Catch:{ IOException -> 0x010b }
        L_0x00f4:
            r2.writeToProb((java.lang.String) r4, (byte[]) r0)     // Catch:{ IOException -> 0x010b }
            java.lang.String r0 = r1.getLuaScriptForFont(r11, r12)     // Catch:{ IOException -> 0x010b }
            r3.append(r0)     // Catch:{ IOException -> 0x010b }
            goto L_0x0122
        L_0x00ff:
            r0 = move-exception
            r4 = r0
            r10.close()     // Catch:{ all -> 0x0105 }
            goto L_0x010a
        L_0x0105:
            r0 = move-exception
            r10 = r0
            r4.addSuppressed(r10)     // Catch:{ IOException -> 0x010b }
        L_0x010a:
            throw r4     // Catch:{ IOException -> 0x010b }
        L_0x010b:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "Lỗi khi copy font: "
            r4.<init>(r10)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            r2.writeLog(r0)
        L_0x0122:
            int r8 = r8 + 1
            r4 = 3
            goto L_0x0024
        L_0x0127:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.FontManager.applyFontPatch(com.sangtacviet.vhwwm.MainActivity, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private String getLuaScriptForFont(String str, String str2) {
        return "local WWMVH=0;\nlocal dir = MEngine.GetFileSystemBasePath('LocalData')\nMPatch.CopyFileSync(dir .. '/" + str2 + "', dir .. '/Fonts/" + str2 + "')\nMUI.OverrideFontCache('" + str + "','" + str2 + "',0)\nlocal WWMVHEND=0;\n";
    }

    public File getFontFile(String str) {
        FileOutputStream fileOutputStream;
        if (str != null && !str.equals("Mặc Định")) {
            File file = new File(this.userFontDir, str + ".ttf");
            if (file.exists()) {
                return file;
            }
            try {
                String[] list = this.context.getAssets().list("fonts");
                if (list != null) {
                    for (String str2 : list) {
                        if (str2.equals(str + ".ttf")) {
                            File file2 = new File(this.context.getCacheDir(), str2);
                            if (!file2.exists()) {
                                InputStream open = this.context.getAssets().open("fonts/" + str2);
                                try {
                                    fileOutputStream = new FileOutputStream(file2);
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = open.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.close();
                                    if (open != null) {
                                        open.close();
                                    }
                                } catch (Throwable th) {
                                    if (open != null) {
                                        open.close();
                                    }
                                    throw th;
                                }
                            }
                            return file2;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return null;
        throw th;
    }
}
