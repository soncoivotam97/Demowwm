package com.sangtacviet.vhwwm;

import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class VietHoaInstaller {
    public static final String EN_1_URL = "https://wwmmap.pages.dev/data/distribute_translate_words_map_en";
    public static final String EN_2_URL = "https://wwmmap.pages.dev/data/distribute_translate_words_map_en_diff";
    public static final String EN_O1_URL = "https://wwmmap.pages.dev/data/distribute_original_translate_words_map_en";
    public static final String EN_O2_URL = "https://wwmmap.pages.dev/data/distribute_original_translate_words_map_en_diff";
    public static final String HOTFIX_URL = "https://wwmmap.pages.dev/data/distribute_hotfix_map";
    private String customMap1 = null;
    private String customMap2 = null;
    private boolean enableFont = true;
    private boolean enableHotfix = true;
    MainActivity main;
    private boolean overwriteLang = false;
    private String selectedFont1 = "Mặc Định";
    private String selectedFont2 = "Mặc Định";
    private String selectedFont3 = "Mặc Định";

    public VietHoaInstaller(MainActivity mainActivity) {
        this.main = mainActivity;
    }

    public void setOptions(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5) {
        this.enableHotfix = z;
        this.enableFont = z2;
        this.overwriteLang = z3;
        this.selectedFont1 = str;
        this.selectedFont2 = str2;
        this.selectedFont3 = str3;
        this.customMap1 = str4;
        this.customMap2 = str5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void install() {
        /*
            r5 = this;
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Bắt đầu cài đặt gói Việt Hóa..."
            r0.writeLog(r1)
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đang tải/copy phần 1..."
            r0.writeLog(r1)
            java.lang.String r0 = r5.customMap1
            java.lang.String r1 = "tmpEn1"
            r2 = 0
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0033
            java.lang.String r0 = r5.customMap1
            com.sangtacviet.vhwwm.TempFileProcessor r0 = r5.loadLocalFile(r0, r1)
            if (r0 == 0) goto L_0x0034
            boolean r3 = r5.testCustomMapFile(r0)
            if (r3 != 0) goto L_0x0034
            com.sangtacviet.vhwwm.MainActivity r3 = r5.main
            java.lang.String r4 = "Lỗi: File custom 1 không đúng định dạng, đang tải bản mặc định của chúng tôi"
            r3.writeLog(r4)
            r0.destroy()
        L_0x0033:
            r0 = r2
        L_0x0034:
            if (r0 != 0) goto L_0x003c
            java.lang.String r0 = "https://wwmmap.pages.dev/data/distribute_translate_words_map_en"
            com.sangtacviet.vhwwm.TempFileProcessor r0 = r5.downloadFile(r0, r1)
        L_0x003c:
            if (r0 == 0) goto L_0x010a
            com.sangtacviet.vhwwm.MainActivity r1 = r5.main
            java.lang.String r3 = "LocalData/Patch/HD/oversea/locale/translate_words_map_en"
            r1.writeToProb((java.lang.String) r3, (com.sangtacviet.vhwwm.TempFileProcessor) r0)
            com.sangtacviet.vhwwm.MainActivity r1 = r5.main
            java.lang.String r3 = "Đã cài đặt phần 1."
            r1.writeLog(r3)
            r0.destroy()
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đang tải/copy phần 2..."
            r0.writeLog(r1)
            java.lang.String r0 = r5.customMap2
            java.lang.String r1 = "tmpEn2"
            if (r0 == 0) goto L_0x007c
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x007c
            java.lang.String r0 = r5.customMap2
            com.sangtacviet.vhwwm.TempFileProcessor r0 = r5.loadLocalFile(r0, r1)
            if (r0 == 0) goto L_0x007b
            boolean r3 = r5.testCustomMapFile(r0)
            if (r3 != 0) goto L_0x007b
            com.sangtacviet.vhwwm.MainActivity r3 = r5.main
            java.lang.String r4 = "Lỗi: File custom 2 không đúng định dạng, đang tải bản mặc định của chúng tôi."
            r3.writeLog(r4)
            r0.destroy()
            goto L_0x007c
        L_0x007b:
            r2 = r0
        L_0x007c:
            if (r2 != 0) goto L_0x0084
            java.lang.String r0 = "https://wwmmap.pages.dev/data/distribute_translate_words_map_en_diff"
            com.sangtacviet.vhwwm.TempFileProcessor r2 = r5.downloadFile(r0, r1)
        L_0x0084:
            if (r2 == 0) goto L_0x0102
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "LocalData/Patch/HD/oversea/locale/translate_words_map_en_diff"
            r0.writeToProb((java.lang.String) r1, (com.sangtacviet.vhwwm.TempFileProcessor) r2)
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đã cài đặt phần 2."
            r0.writeLog(r1)
            r2.destroy()
            boolean r0 = r5.enableHotfix
            if (r0 == 0) goto L_0x00a9
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đang tải hotfix map..."
            r0.writeLog(r1)
            java.lang.String r0 = "https://wwmmap.pages.dev/data/distribute_hotfix_map"
            java.lang.String r1 = "hotfix_map.tmp"
            r5.downloadFile(r0, r1)
        L_0x00a9:
            r5.setGameLanguageToEnglish()
            boolean r0 = r5.overwriteLang
            if (r0 == 0) goto L_0x00de
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đang tải tiếng Anh..."
            r0.writeLog(r1)
            java.lang.String r0 = "https://wwmmap.pages.dev/data/distribute_original_translate_words_map_en"
            java.lang.String r1 = "tmpEnO1"
            com.sangtacviet.vhwwm.TempFileProcessor r2 = r5.downloadFile(r0, r1)
            com.sangtacviet.vhwwm.MainActivity r3 = r5.main
            java.lang.String r4 = "LocalData/Patch/HD/oversea/locale/translate_words_map_de"
            r3.writeToProb((java.lang.String) r4, (com.sangtacviet.vhwwm.TempFileProcessor) r2)
            r2.destroy()
            com.sangtacviet.vhwwm.TempFileProcessor r0 = r5.downloadFile(r0, r1)
            com.sangtacviet.vhwwm.MainActivity r1 = r5.main
            java.lang.String r2 = "LocalData/Patch/HD/oversea/locale/translate_words_map_de_diff"
            r1.writeToProb((java.lang.String) r2, (com.sangtacviet.vhwwm.TempFileProcessor) r0)
            r0.destroy()
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đã cài đặt tiếng Anh vào tiếng Đức"
            r0.writeLog(r1)
        L_0x00de:
            boolean r0 = r5.enableFont
            if (r0 == 0) goto L_0x0101
            com.sangtacviet.vhwwm.MainActivity r0 = r5.main
            java.lang.String r1 = "Đang cài đặt font..."
            r0.writeLog(r1)
            com.sangtacviet.vhwwm.FontManager r0 = new com.sangtacviet.vhwwm.FontManager
            com.sangtacviet.vhwwm.MainActivity r1 = r5.main
            r0.<init>(r1)
            com.sangtacviet.vhwwm.MainActivity r1 = r5.main
            java.lang.String r2 = r5.selectedFont1
            java.lang.String r3 = r5.selectedFont2
            java.lang.String r4 = r5.selectedFont3
            java.lang.String r0 = r0.applyFontPatch(r1, r2, r3, r4)
            com.sangtacviet.vhwwm.MainActivity r5 = r5.main
            r5.setFontPatchLua(r0)
        L_0x0101:
            return
        L_0x0102:
            com.sangtacviet.vhwwm.MainActivity r5 = r5.main
            java.lang.String r0 = "Lỗi khi tải phần 2."
            r5.writeLog(r0)
            return
        L_0x010a:
            com.sangtacviet.vhwwm.MainActivity r5 = r5.main
            java.lang.String r0 = "Lỗi khi tải phần 1."
            r5.writeLog(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.VietHoaInstaller.install():void");
    }

    public void uninstall() {
        this.main.writeLog("Bắt đầu gỡ cài đặt gói Việt Hóa...");
        this.main.writeLog("Đang khôi phục phần 1...");
        TempFileProcessor downloadFile = downloadFile(EN_O1_URL, "tmpEn1");
        if (downloadFile != null) {
            this.main.writeToProb("LocalData/Patch/HD/oversea/locale/translate_words_map_en", downloadFile);
            this.main.writeLog("Đã khôi phục phần 1.");
            downloadFile.destroy();
            this.main.writeLog("Đang khôi phục phần 2...");
            TempFileProcessor downloadFile2 = downloadFile(EN_O2_URL, "tmpEn2");
            if (downloadFile2 != null) {
                this.main.writeToProb("LocalData/Patch/HD/oversea/locale/translate_words_map_en_diff", downloadFile2);
                this.main.writeLog("Đã khôi phục phần 2.");
                downloadFile2.destroy();
                return;
            }
            this.main.writeLog("Lỗi khi tải phần 2.");
            return;
        }
        this.main.writeLog("Lỗi khi tải phần 1.");
    }

    private void copyFile(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    private byte[] readFromInputStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr, 0, 16384);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] downloadFile(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                byte[] readFromInputStream = readFromInputStream(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                return readFromInputStream;
            }
            this.main.writeLog("Lỗi khi tải file, mã lỗi: " + httpURLConnection.getResponseCode());
            httpURLConnection.disconnect();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.main.writeLog("Lỗi khi tải file: " + e.getMessage());
            return null;
        }
    }

    private TempFileProcessor downloadFile(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                TempFileProcessor tempFileProcessor = new TempFileProcessor(this.main, str2);
                tempFileProcessor.saveFromInputStream(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                return tempFileProcessor;
            }
            this.main.writeLog("Lỗi khi tải file, mã lỗi: " + httpURLConnection.getResponseCode());
            httpURLConnection.disconnect();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.main.writeLog("Lỗi khi tải file: " + e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if ((r1[3] & kotlin.UByte.MAX_VALUE) == 222) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean testCustomMapFile(com.sangtacviet.vhwwm.TempFileProcessor r5) {
        /*
            r4 = this;
            r4 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x004a }
            r0.<init>(r5)     // Catch:{ Exception -> 0x004a }
            r5 = 4
            byte[] r1 = new byte[r5]     // Catch:{ all -> 0x0040 }
            int r2 = r0.read(r1)     // Catch:{ all -> 0x0040 }
            if (r2 != r5) goto L_0x003c
            byte r5 = r1[r4]     // Catch:{ all -> 0x0040 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r2 = 239(0xef, float:3.35E-43)
            if (r5 != r2) goto L_0x0037
            r5 = 1
            byte r2 = r1[r5]     // Catch:{ all -> 0x0040 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 190(0xbe, float:2.66E-43)
            if (r2 != r3) goto L_0x0037
            r2 = 2
            byte r2 = r1[r2]     // Catch:{ all -> 0x0040 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 173(0xad, float:2.42E-43)
            if (r2 != r3) goto L_0x0037
            r2 = 3
            byte r1 = r1[r2]     // Catch:{ all -> 0x0040 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 222(0xde, float:3.11E-43)
            if (r1 != r2) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r5 = r4
        L_0x0038:
            r0.close()     // Catch:{ Exception -> 0x004a }
            return r5
        L_0x003c:
            r0.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x004e
        L_0x0040:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r0 = move-exception
            r5.addSuppressed(r0)     // Catch:{ Exception -> 0x004a }
        L_0x0049:
            throw r5     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.VietHoaInstaller.testCustomMapFile(com.sangtacviet.vhwwm.TempFileProcessor):boolean");
    }

    private TempFileProcessor loadLocalFile(String str, String str2) {
        try {
            InputStream openInputStream = this.main.getContentResolver().openInputStream(Uri.parse(str));
            if (openInputStream == null) {
                return null;
            }
            TempFileProcessor tempFileProcessor = new TempFileProcessor(this.main, str2);
            tempFileProcessor.saveFromInputStream(openInputStream);
            openInputStream.close();
            return tempFileProcessor;
        } catch (Exception e) {
            this.main.writeLog("Lỗi đọc file custom: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private void setGameLanguageToEnglish() {
        try {
            byte[] readFromProb = this.main.readFromProb("LocalData/patch_conf.json");
            if (readFromProb != null) {
                String str = new String(readFromProb);
                if (!str.contains("\"language\":\"en\"")) {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("language", "en");
                    JSONArray jSONArray = jSONObject.getJSONArray("lang_types");
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            jSONArray.put("en");
                            jSONObject.put("lang_types", jSONArray);
                            break;
                        } else if (jSONArray.getString(i).equals("en")) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    this.main.writeToProb("LocalData/patch_conf.json", jSONObject.toString().getBytes());
                    this.main.writeLog("Đã thiết lập ngôn ngữ game sang tiếng Việt.");
                    return;
                }
                return;
            }
            this.main.writeLog("Không tìm thấy file cấu hình ngôn ngữ.");
        } catch (Exception e) {
            this.main.writeLog("Lỗi khi thiết lập ngôn ngữ game.");
            e.printStackTrace();
        }
    }
}
