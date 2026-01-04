package com.sangtacviet.vhwwm;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String PKG = "com.netease.yysls";
    String PROB_BASE = "content://com.netease.yysls.widget_file_provider/widget_external_files/";
    String TAG = "com.sangtacviet.vhwwm";
    Button btnAddFont;
    Button btnSelectMapEn;
    Button btnSelectMapEnDiff;
    Button btnStartGame;
    Button btnUninstall;
    CheckBox cbFont;
    CheckBox cbHotfix;
    CheckBox cbOverwrite;
    CheckBox cbShizuku;
    CheckBox cbUnlockFPS;
    private Context context;
    private String customMapEnDiffPath = "";
    private String customMapEnPath = "";
    private String fontPatchLua = "";
    Button install;
    TextView log;
    WebView mapWebView;
    private ShizukuManager shizukuManager;
    Spinner spFont1;
    Spinner spFont2;
    Spinner spFont3;
    TabHost tabHost;
    TextView tvMapEnDiffPath;
    TextView tvMapEnPath;
    TextView tvPreview1;
    TextView tvPreview2;
    TextView tvPreview3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getApplicationContext();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new MainActivity$$ExternalSyntheticLambda0());
        this.log = (TextView) findViewById(R.id.logTxt);
        this.install = (Button) findViewById(R.id.installBtn);
        this.cbHotfix = (CheckBox) findViewById(R.id.cb_hotfix);
        this.cbFont = (CheckBox) findViewById(R.id.cb_font);
        this.cbOverwrite = (CheckBox) findViewById(R.id.cb_overwrite);
        this.spFont1 = (Spinner) findViewById(R.id.sp_font1);
        this.spFont2 = (Spinner) findViewById(R.id.sp_font2);
        this.spFont3 = (Spinner) findViewById(R.id.sp_font3);
        this.tvPreview1 = (TextView) findViewById(R.id.tv_preview1);
        this.tvPreview2 = (TextView) findViewById(R.id.tv_preview2);
        this.tvPreview3 = (TextView) findViewById(R.id.tv_preview3);
        this.btnAddFont = (Button) findViewById(R.id.btn_add_font);
        this.btnStartGame = (Button) findViewById(R.id.btn_start_game);
        this.btnUninstall = (Button) findViewById(R.id.btn_uninstall);
        this.mapWebView = (WebView) findViewById(R.id.map_webview);
        this.tabHost = (TabHost) findViewById(16908306);
        this.cbUnlockFPS = (CheckBox) findViewById(R.id.cb_unlock_fps);
        this.cbShizuku = (CheckBox) findViewById(R.id.cb_shizuku);
        this.btnSelectMapEn = (Button) findViewById(R.id.btn_select_map_en);
        this.tvMapEnPath = (TextView) findViewById(R.id.tv_map_en_path);
        this.btnSelectMapEnDiff = (Button) findViewById(R.id.btn_select_map_en_diff);
        this.tvMapEnDiffPath = (TextView) findViewById(R.id.tv_map_en_diff_path);
        Button button = (Button) findViewById(R.id.btn_remove_map_en);
        Button button2 = (Button) findViewById(R.id.btn_remove_map_en_diff);
        this.shizukuManager = new ShizukuManager(this);
        this.tabHost.setup();
        TabHost.TabSpec newTabSpec = this.tabHost.newTabSpec("Home");
        newTabSpec.setContent(R.id.tab_home);
        newTabSpec.setIndicator("Trang Chủ");
        this.tabHost.addTab(newTabSpec);
        TabHost.TabSpec newTabSpec2 = this.tabHost.newTabSpec("Map");
        newTabSpec2.setContent(R.id.tab_map);
        newTabSpec2.setIndicator("Bản Đồ");
        this.tabHost.addTab(newTabSpec2);
        TabHost.TabSpec newTabSpec3 = this.tabHost.newTabSpec("Font");
        newTabSpec3.setContent(R.id.tab_font);
        newTabSpec3.setIndicator("Tùy Chọn");
        this.tabHost.addTab(newTabSpec3);
        this.tabHost.setOnTabChangedListener(new MainActivity$$ExternalSyntheticLambda9(this, ((TextView) this.tabHost.findViewById(16908310)).getCurrentTextColor()));
        this.tabHost.setCurrentTab(0);
        TextView textView = (TextView) this.tabHost.getTabWidget().getChildAt(0).findViewById(16908310);
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#007AFF"));
        }
        this.mapWebView.setWebViewClient(new WebViewClient());
        this.mapWebView.getSettings().setJavaScriptEnabled(true);
        this.mapWebView.getSettings().setDomStorageEnabled(true);
        this.install.setOnClickListener(new MainActivity$$ExternalSyntheticLambda10(this));
        this.btnStartGame.setOnClickListener(new MainActivity$$ExternalSyntheticLambda11(this));
        this.btnUninstall.setOnClickListener(new MainActivity$$ExternalSyntheticLambda12(this));
        setupFontManager();
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m179lambda$onCreate$1$comsangtacvietvhwwmMainActivity(int i, String str) {
        TextView textView;
        for (int i2 = 0; i2 < this.tabHost.getTabWidget().getChildCount(); i2++) {
            TextView textView2 = (TextView) this.tabHost.getTabWidget().getChildAt(i2).findViewById(16908310);
            if (textView2 != null) {
                textView2.setTextColor(i);
            }
        }
        View currentTabView = this.tabHost.getCurrentTabView();
        if (!(currentTabView == null || (textView = (TextView) currentTabView.findViewById(16908310)) == null)) {
            textView.setTextColor(Color.parseColor("#007AFF"));
        }
        if (str.equals("Map") && this.mapWebView.getUrl() == null) {
            this.mapWebView.loadUrl("https://wwmmap.pages.dev/");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$3$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m181lambda$onCreate$3$comsangtacvietvhwwmMainActivity(View view) {
        if (!checkIfGameInstalled()) {
            writeLog("Chưa cài đặt game Where Winds Meet, vui lòng cài đặt game trước khi cài đặt Việt Hóa.");
            return;
        }
        findTargetAuthority(this);
        new Thread(new MainActivity$$ExternalSyntheticLambda8(this)).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$2$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m180lambda$onCreate$2$comsangtacvietvhwwmMainActivity() {
        String str;
        String str2;
        String str3;
        try {
            VietHoaInstaller vietHoaInstaller = new VietHoaInstaller(this);
            String obj = this.spFont1.getSelectedItem() != null ? this.spFont1.getSelectedItem().toString() : "Mặc Định";
            if (this.spFont2.getSelectedItem() != null) {
                str = this.spFont2.getSelectedItem().toString();
            } else {
                str = "Mặc Định";
            }
            if (this.spFont3.getSelectedItem() != null) {
                str2 = this.spFont3.getSelectedItem().toString();
            } else {
                str2 = "Mặc Định";
            }
            vietHoaInstaller.setOptions(this.cbHotfix.isChecked(), this.cbFont.isChecked(), this.cbOverwrite.isChecked(), obj, str, str2, this.customMapEnPath, this.customMapEnDiffPath);
            vietHoaInstaller.install();
            if (this.cbHotfix.isChecked() || ((str3 = this.fontPatchLua) != null && !str3.isEmpty())) {
                runHotfix();
            }
            writeLog("Cài đặt gói Việt Hóa hoàn tất, tắt game mở lại để trải nghiệm.");
        } catch (Exception e) {
            writeLog("Cài đặt Việt Hóa thất bại, lỗi: " + e.getMessage());
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
            String message = e.getMessage();
            if (message != null && message.contains("ENOENT")) {
                writeLog("Vui lòng xác định game đã được cập nhật trước khi cài đặt Việt Hóa");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$4$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m182lambda$onCreate$4$comsangtacvietvhwwmMainActivity(View view) {
        startGame();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$5$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m183lambda$onCreate$5$comsangtacvietvhwwmMainActivity(View view) {
        uninstallVietHoa();
    }

    private void startGame() {
        PackageManager packageManager = getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(this.PKG);
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
            return;
        }
        Intent launchIntentForPackage2 = packageManager.getLaunchIntentForPackage("com.netease.yyslshmt");
        if (launchIntentForPackage2 != null) {
            startActivity(launchIntentForPackage2);
        } else {
            writeLog("Không tìm thấy game để khởi động.");
        }
    }

    private void uninstallVietHoa() {
        if (!checkIfGameInstalled()) {
            writeLog("Chưa cài đặt game Where Winds Meet, vui lòng cài đặt game trước khi cài đặt Việt Hóa.");
            return;
        }
        findTargetAuthority(this);
        new Thread(new MainActivity$$ExternalSyntheticLambda14(this)).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$uninstallVietHoa$6$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m193lambda$uninstallVietHoa$6$comsangtacvietvhwwmMainActivity() {
        writeLog("Đang gỡ cài đặt Việt Hóa...");
        try {
            new VietHoaInstaller(this).uninstall();
        } catch (Exception e) {
            writeLog("Lỗi khi gỡ cài đặt: " + e.getMessage());
        }
        try {
            TempFileProcessor readFromProbTmp = readFromProbTmp("LocalData/LocalDB/db_mp", "db_mp");
            if (readFromProbTmp.getCurrentFileSize() > 0) {
                new HotfixPatcher(this).removeAllPatch(readFromProbTmp.getAbsolutePath());
                writeToProb("LocalData/LocalDB/db_mp", readFromProbTmp);
                readFromProbTmp.destroy();
            }
        } catch (Exception e2) {
            writeLog("Lỗi xóa hotfix: " + e2.getMessage());
        }
        writeLog("Đã xóa hotfix. Để khôi phục hoàn toàn file ngôn ngữ gốc, vui lòng sử dụng chức năng Sửa chữa/Verify của game hoặc cài đặt lại game.");
    }

    public void setFontPatchLua(String str) {
        this.fontPatchLua = str;
    }

    private void setupFontManager() {
        final FontManager fontManager = new FontManager(this);
        List<String> availableFonts = fontManager.getAvailableFonts();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, availableFonts);
        arrayAdapter.setDropDownViewResource(17367049);
        this.spFont1.setAdapter(arrayAdapter);
        this.spFont2.setAdapter(arrayAdapter);
        this.spFont3.setAdapter(arrayAdapter);
        SharedPreferences sharedPreferences = getSharedPreferences("FontPrefs", 0);
        String string = sharedPreferences.getString("font_selection_1", "Mặc Định");
        String string2 = sharedPreferences.getString("font_selection_2", "Mặc Định");
        String string3 = sharedPreferences.getString("font_selection_3", "Mặc Định");
        if (availableFonts.contains(string)) {
            this.spFont1.setSelection(availableFonts.indexOf(string));
        }
        if (availableFonts.contains(string2)) {
            this.spFont2.setSelection(availableFonts.indexOf(string2));
        }
        if (availableFonts.contains(string3)) {
            this.spFont3.setSelection(availableFonts.indexOf(string3));
        }
        AnonymousClass1 r1 = new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                TextView textView;
                String obj = adapterView.getSelectedItem().toString();
                SharedPreferences.Editor edit = MainActivity.this.getSharedPreferences("FontPrefs", 0).edit();
                if (adapterView == MainActivity.this.spFont1) {
                    edit.putString("font_selection_1", obj);
                } else if (adapterView == MainActivity.this.spFont2) {
                    edit.putString("font_selection_2", obj);
                } else if (adapterView == MainActivity.this.spFont3) {
                    edit.putString("font_selection_3", obj);
                }
                edit.apply();
                if (adapterView == MainActivity.this.spFont1) {
                    textView = MainActivity.this.tvPreview1;
                } else if (adapterView == MainActivity.this.spFont2) {
                    textView = MainActivity.this.tvPreview2;
                } else {
                    textView = adapterView == MainActivity.this.spFont3 ? MainActivity.this.tvPreview3 : null;
                }
                if (textView == null) {
                    return;
                }
                if (obj.equals("Mặc Định")) {
                    textView.setTypeface(Typeface.DEFAULT);
                    return;
                }
                try {
                    File fontFile = fontManager.getFontFile(obj);
                    if (fontFile != null && fontFile.exists()) {
                        textView.setTypeface(Typeface.createFromFile(fontFile));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.spFont1.setOnItemSelectedListener(r1);
        this.spFont2.setOnItemSelectedListener(r1);
        this.spFont3.setOnItemSelectedListener(r1);
        this.btnAddFont.setOnClickListener(new MainActivity$$ExternalSyntheticLambda1(this));
        this.btnSelectMapEn.setOnClickListener(new MainActivity$$ExternalSyntheticLambda2(this));
        this.btnSelectMapEnDiff.setOnClickListener(new MainActivity$$ExternalSyntheticLambda3(this));
        findViewById(R.id.btn_remove_map_en).setOnClickListener(new MainActivity$$ExternalSyntheticLambda4(this));
        findViewById(R.id.btn_remove_map_en_diff).setOnClickListener(new MainActivity$$ExternalSyntheticLambda5(this));
        this.cbShizuku.setOnCheckedChangeListener(new MainActivity$$ExternalSyntheticLambda6(this));
        this.cbShizuku.setChecked(sharedPreferences.getBoolean("use_shizuku", false));
        String string4 = sharedPreferences.getString("map_en_path", "");
        this.customMapEnPath = string4;
        if (!string4.isEmpty()) {
            this.tvMapEnPath.setText(this.customMapEnPath);
        }
        String string5 = sharedPreferences.getString("map_en_diff_path", "");
        this.customMapEnDiffPath = string5;
        if (!string5.isEmpty()) {
            this.tvMapEnDiffPath.setText(this.customMapEnDiffPath);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$7$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m190lambda$setupFontManager$7$comsangtacvietvhwwmMainActivity(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        startActivityForResult(intent, PointerIconCompat.TYPE_CONTEXT_MENU);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$8$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m191lambda$setupFontManager$8$comsangtacvietvhwwmMainActivity(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        startActivityForResult(intent, PointerIconCompat.TYPE_HAND);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$9$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m192lambda$setupFontManager$9$comsangtacvietvhwwmMainActivity(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        startActivityForResult(intent, PointerIconCompat.TYPE_HELP);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$10$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m184lambda$setupFontManager$10$comsangtacvietvhwwmMainActivity(View view) {
        this.customMapEnPath = "";
        this.tvMapEnPath.setText("Chưa chọn file");
        getSharedPreferences("FontPrefs", 0).edit().remove("map_en_path").apply();
        writeLog("Đã bỏ chọn map_en");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$11$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m185lambda$setupFontManager$11$comsangtacvietvhwwmMainActivity(View view) {
        this.customMapEnDiffPath = "";
        this.tvMapEnDiffPath.setText("Chưa chọn file");
        getSharedPreferences("FontPrefs", 0).edit().remove("map_en_diff_path").apply();
        writeLog("Đã bỏ chọn map_en_diff");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$16$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m189lambda$setupFontManager$16$comsangtacvietvhwwmMainActivity(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (!this.shizukuManager.isShizukuInstalled()) {
                new AlertDialog.Builder(this).setTitle((CharSequence) "Yêu cầu Shizuku").setMessage((CharSequence) "Để sử dụng tính năng này, bạn cần cài đặt ứng dụng Shizuku. Bạn có muốn cài đặt ngay không? Chú ý, tính năng này chỉ nên sử dụng khi cài đặt không thành công do hệ điều hành chặn.").setPositiveButton((CharSequence) "Cài đặt", (DialogInterface.OnClickListener) new MainActivity$$ExternalSyntheticLambda15(this, compoundButton)).setNegativeButton((CharSequence) "Hủy", (DialogInterface.OnClickListener) new MainActivity$$ExternalSyntheticLambda16(compoundButton)).setCancelable(false).show();
                return;
            } else if (!this.shizukuManager.checkPermission()) {
                this.shizukuManager.requestPermission(new MainActivity$$ExternalSyntheticLambda17(this, compoundButton));
            }
        }
        getSharedPreferences("FontPrefs", 0).edit().putBoolean("use_shizuku", z).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$12$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m186lambda$setupFontManager$12$comsangtacvietvhwwmMainActivity(CompoundButton compoundButton, DialogInterface dialogInterface, int i) {
        this.shizukuManager.openPlayStore();
        compoundButton.setChecked(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$15$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m188lambda$setupFontManager$15$comsangtacvietvhwwmMainActivity(CompoundButton compoundButton, int i, int i2) {
        if (i2 != 0) {
            runOnUiThread(new MainActivity$$ExternalSyntheticLambda13(this, compoundButton));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupFontManager$14$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m187lambda$setupFontManager$14$comsangtacvietvhwwmMainActivity(CompoundButton compoundButton) {
        compoundButton.setChecked(false);
        writeLog("Quyền Shizuku bị từ chối.");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            Uri data2 = intent.getData();
            if (data2 != null) {
                String str = "custom_font.ttf";
                try {
                    Cursor query = getContentResolver().query(data2, (String[]) null, (String) null, (String[]) null, (String) null);
                    if (query != null && query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("_display_name");
                        if (columnIndex != -1) {
                            str = query.getString(columnIndex);
                        }
                        query.close();
                    }
                    if (!str.endsWith(".ttf")) {
                        writeLog("Chỉ hỗ trợ file font .ttf");
                        return;
                    }
                    new FontManager(this).addUserFont(getContentResolver().openInputStream(data2), str);
                    writeLog("Đã thêm font: " + str);
                    setupFontManager();
                } catch (Exception e) {
                    writeLog("Lỗi thêm font: " + e.getMessage());
                }
            }
        } else if ((i == 1002 || i == 1003) && i2 == -1 && intent != null && (data = intent.getData()) != null) {
            try {
                getContentResolver().takePersistableUriPermission(data, 1);
            } catch (Exception unused) {
            }
            String uri = data.toString();
            SharedPreferences.Editor edit = getSharedPreferences("FontPrefs", 0).edit();
            if (i == 1002) {
                this.customMapEnPath = uri;
                this.tvMapEnPath.setText(uri);
                edit.putString("map_en_path", uri);
            } else {
                this.customMapEnDiffPath = uri;
                this.tvMapEnDiffPath.setText(uri);
                edit.putString("map_en_diff_path", uri);
            }
            edit.apply();
        }
    }

    public void runHotfix() {
        writeLog("Chuẩn bị khởi chạy hotfix...");
        TempFileProcessor tempFileProcessor = null;
        try {
            tempFileProcessor = readFromProbTmp("LocalData/LocalDB/db_mp", "db_mp");
            if (tempFileProcessor.getCurrentFileSize() == 0) {
                writeLog("Lỗi: File không tồn tại, bỏ qua.");
                if (tempFileProcessor != null) {
                    tempFileProcessor.destroy();
                    return;
                }
                return;
            }
            writeLog("Đang chạy hotfix...");
            HotfixPatcher hotfixPatcher = new HotfixPatcher(this);
            File file = new File(getFilesDir(), "hotfix_map.tmp");
            if (file.exists()) {
                hotfixPatcher.loadDictionary(file.getAbsolutePath());
            }
            if (this.cbHotfix.isChecked()) {
                hotfixPatcher.runPatchHotfix(tempFileProcessor.getAbsolutePath());
            }
            if (this.cbUnlockFPS.isChecked()) {
                if (this.fontPatchLua != null) {
                    this.fontPatchLua += hotfixPatcher.luaForUnlockFPS();
                } else {
                    this.fontPatchLua = hotfixPatcher.luaForUnlockFPS();
                }
            }
            String str = this.fontPatchLua;
            if (str != null && !str.isEmpty()) {
                hotfixPatcher.addLuaText(tempFileProcessor.getAbsolutePath(), this.fontPatchLua);
            }
            writeLog("Đang ghi dữ liệu...");
            writeToProb("LocalData/LocalDB/db_mp", tempFileProcessor);
            writeLog("Hoàn tất chạy hotfix!");
            if (tempFileProcessor == null) {
                return;
            }
            tempFileProcessor.destroy();
        } catch (Exception e) {
            writeLog("Lỗi khi chạy hotfix: " + e.getMessage());
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
            if (tempFileProcessor == null) {
            }
        } catch (Throwable th) {
            if (tempFileProcessor != null) {
                tempFileProcessor.destroy();
            }
            throw th;
        }
    }

    public void writeLog(String str) {
        runOnUiThread(new MainActivity$$ExternalSyntheticLambda7(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$writeLog$17$com-sangtacviet-vhwwm-MainActivity  reason: not valid java name */
    public /* synthetic */ void m194lambda$writeLog$17$comsangtacvietvhwwmMainActivity(String str) {
        TextView textView = this.log;
        if (textView != null) {
            textView.append(str + "\n");
            int lineTop = this.log.getLayout() != null ? this.log.getLayout().getLineTop(this.log.getLineCount()) - this.log.getHeight() : 0;
            if (lineTop > 0) {
                this.log.scrollTo(0, lineTop);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        getPackageManager().getPackageInfo("com.netease.yyslshmt", 0);
        r5.PROB_BASE = "content://com.netease.yyslshmt.widget_file_provider/widget_external_files/";
        r5.PKG = "com.netease.yyslshmt";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkIfGameInstalled() {
        /*
            r5 = this;
            java.lang.String r0 = "com.netease.yyslshmt"
            java.lang.String r1 = "com.netease.yysls"
            r2 = 1
            r3 = 0
            android.content.pm.PackageManager r4 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0014 }
            r4.getPackageInfo(r1, r3)     // Catch:{ NameNotFoundException -> 0x0014 }
            java.lang.String r4 = "content://com.netease.yysls.widget_file_provider/widget_external_files/"
            r5.PROB_BASE = r4     // Catch:{ NameNotFoundException -> 0x0014 }
            r5.PKG = r1     // Catch:{ NameNotFoundException -> 0x0014 }
            return r2
        L_0x0014:
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0022 }
            r1.getPackageInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x0022 }
            java.lang.String r1 = "content://com.netease.yyslshmt.widget_file_provider/widget_external_files/"
            r5.PROB_BASE = r1     // Catch:{ NameNotFoundException -> 0x0022 }
            r5.PKG = r0     // Catch:{ NameNotFoundException -> 0x0022 }
            return r2
        L_0x0022:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sangtacviet.vhwwm.MainActivity.checkIfGameInstalled():boolean");
    }

    public void writeToProb(String str, byte[] bArr) {
        ParcelFileDescriptor openFileDescriptor;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        CheckBox checkBox = this.cbShizuku;
        if (checkBox != null && checkBox.isChecked() && this.shizukuManager.checkPermission()) {
            try {
                File file = new File(getCacheDir(), "shizuku_tmp_" + System.currentTimeMillis());
                fileOutputStream2 = new FileOutputStream(file);
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                String str2 = "/sdcard/Android/data/" + this.PKG + "/files/" + str;
                File file2 = new File(getExternalCacheDir(), file.getName());
                fileOutputStream3 = new FileOutputStream(file2);
                fileOutputStream3.write(bArr);
                fileOutputStream3.close();
                this.shizukuManager.execCommand("mkdir -p " + str2.substring(0, str2.lastIndexOf("/")) + " && cp " + file2.getAbsolutePath() + " " + str2);
                file2.delete();
                file.delete();
                return;
            } catch (Exception e) {
                writeLog("Lỗi Shizuku write: " + e.getMessage());
                FirebaseCrashlytics.getInstance().recordException(e);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        try {
            openFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(this.PROB_BASE + str), "wt");
            if (openFileDescriptor != null) {
                try {
                    fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (FileNotFoundException unused) {
                    writeLog("Không tìm thấy thư mục oversea, vui lòng mở game lên để game update.");
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                    return;
                }
                return;
            } else if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return;
            } else {
                return;
            }
        } catch (IOException e2) {
            if (e2.getMessage() != null && e2.getMessage().contains("No content provider")) {
                writeLog("Lỗi: Không thể kết nối với game. Vui lòng mở game và giữ game chạy ngầm, sau đó thử lại. (Kiểm tra quyền Tự khởi chạy/Autostart trên máy Xiaomi/Vivo/Oppo)");
            }
            FirebaseCrashlytics.getInstance().recordException(e2);
            throw new RuntimeException(e2);
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
        throw th;
        throw th;
        throw th;
        throw th;
    }

    public byte[] readFromProb(String str) throws FileNotFoundException {
        FileInputStream fileInputStream;
        CheckBox checkBox = this.cbShizuku;
        if (checkBox != null && checkBox.isChecked() && this.shizukuManager.checkPermission()) {
            try {
                return readViaShizuku(str, false);
            } catch (Exception e) {
                Log.e(this.TAG, "Shizuku read failed, falling back to provider", e);
            }
        }
        try {
            ParcelFileDescriptor openFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(this.PROB_BASE + str), "r");
            try {
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return bArr;
            } catch (Throwable th) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th;
            }
            throw th;
        } catch (IOException e2) {
            throw new FileNotFoundException(e2.toString());
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public byte[] readFromProbD(String str) throws FileNotFoundException {
        FileInputStream fileInputStream;
        CheckBox checkBox = this.cbShizuku;
        if (checkBox != null && checkBox.isChecked() && this.shizukuManager.checkPermission()) {
            try {
                return readViaShizuku(str, true);
            } catch (Exception e) {
                Log.e(this.TAG, "Shizuku read D failed, falling back to provider", e);
            }
        }
        try {
            ParcelFileDescriptor openFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(this.PROB_BASE.replace("widget_external_files", "widget_files") + str), "r");
            try {
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return bArr;
            } catch (Throwable th) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th;
            }
            throw th;
        } catch (IOException e2) {
            throw new FileNotFoundException(e2.toString());
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private byte[] readViaShizuku(String str, boolean z) throws Exception {
        String str2 = "/sdcard/Android/data/" + this.PKG + "/files/";
        if (z) {
            "/data/user/0/" + this.PKG + "/files/";
            str2 = "/data/data/" + this.PKG + "/files/";
        }
        File file = new File(getExternalCacheDir(), "read_tmp_" + System.currentTimeMillis());
        this.shizukuManager.execCommand("cp " + (str2 + str) + " " + file.getAbsolutePath());
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream.read(bArr);
                fileInputStream.close();
                file.delete();
                return bArr;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new FileNotFoundException("Shizuku cp failed");
        }
        throw th;
    }

    private void replaceAuthorities(String str) {
        this.PROB_BASE = this.PROB_BASE.replace("com.netease.yysls.widget_file_provider", str).replace("com.netease.yyslshmt.widget_file_provider", str);
    }

    public void writeToProb(String str, TempFileProcessor tempFileProcessor) {
        ParcelFileDescriptor openFileDescriptor;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        CheckBox checkBox = this.cbShizuku;
        if (checkBox != null && checkBox.isChecked() && this.shizukuManager.checkPermission()) {
            try {
                File file = new File(tempFileProcessor.getAbsolutePath());
                File file2 = new File(getExternalCacheDir(), file.getName());
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream2 = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            fileOutputStream2.close();
                            fileInputStream.close();
                            String str2 = "/sdcard/Android/data/" + this.PKG + "/files/" + str;
                            this.shizukuManager.execCommand("mkdir -p " + str2.substring(0, str2.lastIndexOf("/")) + " && cp " + file2.getAbsolutePath() + " " + str2);
                            file2.delete();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            } catch (Exception e) {
                writeLog("Lỗi Shizuku write (TempFile): " + e.getMessage());
                FirebaseCrashlytics.getInstance().recordException(e);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        try {
            openFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(this.PROB_BASE + str), "wt");
            if (openFileDescriptor != null) {
                try {
                    fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
                    tempFileProcessor.loadToOutputStream(fileOutputStream);
                    fileOutputStream.close();
                } catch (FileNotFoundException unused) {
                    writeLog("Không tìm thấy thư mục oversea, vui lòng mở game lên để game update.");
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                    return;
                }
                return;
            }
            throw new IOException("FileDescriptor is null");
        } catch (IOException e2) {
            if (e2.getMessage() != null && e2.getMessage().contains("No content provider")) {
                writeLog("Lỗi: Không thể kết nối với game. Vui lòng mở game và giữ game chạy ngầm, sau đó thử lại. (Kiểm tra quyền Tự khởi chạy/Autostart trên máy Xiaomi/Vivo/ZTE/Oppo)");
            }
            FirebaseCrashlytics.getInstance().recordException(e2);
            throw new RuntimeException(e2);
        } catch (Throwable th4) {
            th.addSuppressed(th4);
        }
        throw th;
        throw th;
        throw th;
    }

    public TempFileProcessor readFromProbTmp(String str, String str2) throws FileNotFoundException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        CheckBox checkBox = this.cbShizuku;
        if (checkBox != null && checkBox.isChecked() && this.shizukuManager.checkPermission()) {
            try {
                byte[] readViaShizuku = readViaShizuku(str, false);
                TempFileProcessor tempFileProcessor = new TempFileProcessor(this, str2);
                fileOutputStream = new FileOutputStream(new File(getCacheDir(), str2));
                fileOutputStream.write(readViaShizuku);
                fileOutputStream.close();
                tempFileProcessor.saveFromInputStream(new ByteArrayInputStream(readViaShizuku));
                return tempFileProcessor;
            } catch (Exception e) {
                Log.e(this.TAG, "Shizuku read tmp failed, fallback", e);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        try {
            ParcelFileDescriptor openFileDescriptor = this.context.getContentResolver().openFileDescriptor(Uri.parse(this.PROB_BASE + str), "r");
            try {
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                TempFileProcessor tempFileProcessor2 = new TempFileProcessor(this, str2);
                tempFileProcessor2.saveFromInputStream(fileInputStream);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return tempFileProcessor2;
            } catch (Throwable th2) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th2;
            }
        } catch (IOException e2) {
            throw new FileNotFoundException(e2.toString());
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
        throw th;
    }

    public String findTargetAuthority(Context context2) {
        String str;
        String str2 = ";";
        try {
            PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(this.PKG, 8);
            if (packageInfo.providers == null) {
                FirebaseCrashlytics.getInstance().recordException(new Exception("Provider == null when checking"));
                return null;
            }
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            int length = providerInfoArr.length;
            int i = 0;
            while (i < length) {
                ProviderInfo providerInfo = providerInfoArr[i];
                FirebaseCrashlytics.getInstance().log("Found Provider: " + providerInfo.authority + " | Exported: " + providerInfo.exported + " | Enabled: " + providerInfo.enabled);
                Log.d(this.TAG, "Found Provider: " + providerInfo.authority + " | Exported: " + providerInfo.exported + " | Enabled: " + providerInfo.enabled);
                if (!providerInfo.name.equals("org.gux.widget.provider.view.support.UxFileProvider")) {
                    if (!providerInfo.authority.contains("widget_file_provider")) {
                        str = str2;
                        i++;
                        str2 = str;
                    }
                }
                if (providerInfo.exported) {
                    if (providerInfo.enabled) {
                        String str3 = providerInfo.authority;
                        if (str3.contains(str2)) {
                            String[] split = str3.split(str2);
                            int length2 = split.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    break;
                                }
                                str = str2;
                                String str4 = split[i2];
                                if (str4.contains("widget_file_provider")) {
                                    str3 = str4;
                                    break;
                                }
                                i2++;
                                str2 = str;
                            }
                        }
                        str = str2;
                        ContentProviderClient acquireUnstableContentProviderClient = context2.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://" + str3));
                        if (acquireUnstableContentProviderClient == null) {
                            FirebaseCrashlytics.getInstance().log("Provider found in PM but acquireUnstableContentProviderClient returned null: " + str3);
                            i++;
                            str2 = str;
                        } else {
                            acquireUnstableContentProviderClient.release();
                            FirebaseCrashlytics.getInstance().log("Target Provider found: " + str3 + " | Exported: " + providerInfo.exported);
                            FirebaseCrashlytics.getInstance().recordException(new Exception("Found provider"));
                            replaceAuthorities(str3);
                            return str3;
                        }
                    }
                }
                str = str2;
                FirebaseCrashlytics.getInstance().log("Target Provider found: " + providerInfo.authority + " | Exported: " + providerInfo.exported);
                i++;
                str2 = str;
            }
            FirebaseCrashlytics.getInstance().recordException(new Exception("Cannot found matched provider to work with."));
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            FirebaseCrashlytics.getInstance().recordException(new Exception("Target app not installed or not visible (check <queries>)."));
            return null;
        }
    }

    private void testing() {
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        instance.deleteUnsentReports();
        instance.log("Testing log");
        if (checkFileExistProbe(false, "LocalData/package_info.txt")) {
            instance.log("Probe exist for LocalData/package_info.txt");
        } else if (checkFileExistProbe(true, "LocalData/package_info.txt")) {
            instance.log("D Probe exist for: LocalData/package_info.txt");
        } else if (checkFileExistProbe(false, "Package/HD/oversea/MANIFEST")) {
            instance.log("Probe exist for: Package/HD/oversea/MANIFEST");
        } else if (checkFileExistProbe(true, "Package/HD/oversea/MANIFEST")) {
            instance.log("D Probe exist for: Package/HD/oversea/MANIFEST");
        } else {
            getRealProviderException(this.PROB_BASE + "LocalData/package_info.txt");
            instance.log("Probe not exist for: LocalData/package_info.txt, Package/HD/oversea/MANIFEST");
        }
        instance.recordException(new Exception("Testing exception"));
        instance.sendUnsentReports();
    }

    private boolean checkFileExistProbe(boolean z, String str) {
        if (z) {
            try {
                readFromProbD(str);
                return true;
            } catch (FileNotFoundException unused) {
                return false;
            }
        } else {
            readFromProb(str);
            return true;
        }
    }

    private int checkDirExistProbe(String str) {
        try {
            String type = getContentResolver().getType(Uri.parse(this.PROB_BASE + str));
            if (type != null) {
                return type.equals("application/octet-stream") ? 0 : 3;
            }
            return 2;
        } catch (SecurityException unused) {
            return 1;
        } catch (IllegalArgumentException unused2) {
            return 8;
        } catch (Exception unused3) {
            return 4;
        }
    }

    public void getRealProviderException(String str) {
        Uri parse = Uri.parse(str);
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        ContentProviderClient contentProviderClient = null;
        try {
            instance.log("Attempting to acquire UNSTABLE client...");
            contentProviderClient = this.context.getContentResolver().acquireUnstableContentProviderClient(parse);
            if (contentProviderClient == null) {
                instance.log("FAILURE: Client is NULL (Provider not found in PM).");
                instance.recordException(new Exception("Provider not found in PM"));
                if (contentProviderClient != null) {
                    contentProviderClient.release();
                    return;
                }
                return;
            }
            instance.log("Client acquired. Attempting openFile...");
            ParcelFileDescriptor openFile = contentProviderClient.openFile(parse, "r");
            if (openFile != null) {
                Log.i("Exploit", "SUCCESS: File opened successfully.");
                openFile.close();
            }
            if (contentProviderClient == null) {
                return;
            }
            contentProviderClient.release();
        } catch (DeadObjectException e) {
            instance.log("CRITICAL ERROR: DeadObjectException. The target app crashed or was killed!");
            instance.recordException(e);
            if (contentProviderClient == null) {
            }
        } catch (RemoteException e2) {
            instance.log("CRITICAL ERROR: RemoteException (Binder Transaction Failed).");
            instance.recordException(e2);
            if (contentProviderClient == null) {
            }
        } catch (SecurityException e3) {
            instance.log("SECURITY ERROR: Permission Denied / Not Exported.");
            instance.recordException(e3);
            if (contentProviderClient == null) {
            }
        } catch (FileNotFoundException e4) {
            instance.log("LOGIC ERROR: Provider is running, but path alias is wrong.");
            instance.recordException(e4);
            if (contentProviderClient == null) {
            }
        } catch (Exception e5) {
            instance.log("UNKNOWN ERROR: " + e5.getClass().getSimpleName());
            instance.recordException(e5);
            if (contentProviderClient == null) {
            }
        } catch (Throwable th) {
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
            throw th;
        }
    }
}
