package com.dangson.wwm

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private val client = OkHttpClient()

    private val gamePackage = "com.netease.yysls"  // Bản Global chính thức

    // Danh sách authority thử lần lượt (bản global hay dùng cái nào thì trúng cái đó)
    private val possibleAuthorities = listOf(
        "com.netease.yysls.prob",
        "com.netease.yysls.fileprovider",
        "com.netease.yysls.patch",
        "com.netease.yysls.files"
    )

    private val localePath = "LocalData/Patch/HD/oversea/locale"

    private val en1Url = "https://wwmmap.pages.dev/data/distribute_translate_words_map_en"
    private val en2Url = "https://wwmmap.pages.dev/data/distribute_translate_words_map_en_diff"
    private val enO1Url = "https://wwmmap.pages.dev/data/distribute_original_translate_words_map_en"
    private val enO2Url = "https://wwmmap.pages.dev/data/distribute_original_translate_words_map_en_diff"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Mở thẳng màn hình Cài đặt
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, InstallFragment())
                .commit()
        }

        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    fun isGameInstalled(): Boolean {
        return try {
            packageManager.getPackageInfo(gamePackage, 0) != null
        } catch (e: Exception) {
            false
        }
    }

    fun installVietHoa(onLog: (String) -> Unit, onFinish: () -> Unit) {
        if (!isGameInstalled()) {
            onLog("❌ Không tìm thấy game Yến Vân Thập Lục Thanh (Global)!\nVui lòng cài bản Global từ Play Store.\n\n")
            Toast.makeText(this, "Chưa cài game Global!", Toast.LENGTH_LONG).show()
            return
        }

        onLog("✅ Đã tìm thấy game Global!\nBắt đầu tải bản Việt hóa...\n\n")

        taiVaGhiThang(en1Url, "$localePath/translate_words_map_en", onLog) {
            taiVaGhiThang(en2Url, "$localePath/translate_words_map_en_diff", onLog) {
                onLog("\n🎉 VIỆT HÓA THÀNH CÔNG!\nMở game để trải nghiệm tiếng Việt đầy đủ!\n")
                Toast.makeText(this, "Việt hóa thành công!", Toast.LENGTH_LONG).show()
                onFinish()
            }
        }
    }

    fun uninstallVietHoa(onLog: (String) -> Unit, onFinish: () -> Unit) {
        if (!isGameInstalled()) {
            onLog("❌ Không tìm thấy game để gỡ!\n")
            return
        }

        onLog("🗑️ Bắt đầu gỡ Việt hóa (khôi phục bản gốc)...\n\n")

        taiVaGhiThang(enO1Url, "$localePath/translate_words_map_en", onLog) {
            taiVaGhiThang(enO2Url, "$localePath/translate_words_map_en_diff", onLog) {
                onLog("\n✅ ĐÃ GỠ THÀNH CÔNG!\nGame trở về tiếng Anh gốc.\n")
                Toast.makeText(this, "Gỡ thành công!", Toast.LENGTH_LONG).show()
                onFinish()
            }
        }
    }

    private fun taiVaGhiThang(url: String, relativePath: String, onLog: (String) -> Unit, xong: () -> Unit) {
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread { onLog("❌ Lỗi mạng: ${e.message}\n\n") }
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    runOnUiThread { onLog("❌ Lỗi server: ${response.code}\n\n") }
                    return
                }

                try {
                    val tempFile = File(filesDir, "temp_locale.tmp")
                    response.body?.byteStream()?.use { input ->
                        FileOutputStream(tempFile).use { output ->
                            input.copyTo(output)
                        }
                    }

                    runOnUiThread { onLog("⬇️ Tải xong file (${tempFile.length() / 1024} KB)\n") }

                    // Thử từng authority cho đến khi ghi thành công
                    var success = false
                    for (authority in possibleAuthorities) {
                        try {
                            val uri = Uri.parse("content://$authority/$relativePath")
                            contentResolver.openOutputStream(uri)?.use { output ->
                                FileInputStream(tempFile).use { input ->
                                    input.copyTo(output)
                                }
                            }
                            runOnUiThread { onLog("✅ Ghi đè thành công bằng: $authority\n\n") }
                            success = true
                            break
                        } catch (e: Exception) {
                            // Thử authority tiếp theo
                            continue
                        }
                    }

                    if (!success) {
                        runOnUiThread { onLog("❌ Không thể ghi file – game chưa hỗ trợ patch hoặc authority sai.\n\n") }
                    }

                    tempFile.delete()
                    if (success) xong()
                } catch (e: Exception) {
                    runOnUiThread { onLog("❌ Lỗi xử lý: ${e.message}\n\n") }
                }
            }
        })
    }
}