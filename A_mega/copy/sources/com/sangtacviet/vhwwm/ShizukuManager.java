package com.sangtacviet.vhwwm;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import rikka.shizuku.Shizuku;
import rikka.shizuku.ShizukuRemoteProcess;

public class ShizukuManager {
    private static final String TAG = "ShizukuManager";
    private Context context;

    public ShizukuManager(Context context2) {
        this.context = context2;
    }

    public boolean isShizukuInstalled() {
        try {
            this.context.getPackageManager().getPackageInfo("moe.shizuku.privileged.api", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean checkPermission() {
        if (Shizuku.isPreV11()) {
            return false;
        }
        try {
            if (Shizuku.checkSelfPermission() == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e(TAG, "Shizuku check permission failed", th);
            return false;
        }
    }

    public void requestPermission(Shizuku.OnRequestPermissionResultListener onRequestPermissionResultListener) {
        if (!Shizuku.isPreV11()) {
            try {
                if (Shizuku.checkSelfPermission() != 0) {
                    Shizuku.shouldShowRequestPermissionRationale();
                    Shizuku.addRequestPermissionResultListener(onRequestPermissionResultListener);
                    Shizuku.requestPermission(0);
                    return;
                }
                onRequestPermissionResultListener.onRequestPermissionResult(0, 0);
            } catch (Throwable th) {
                Log.e(TAG, "Shizuku request permission failed", th);
            }
        }
    }

    public void execCommand(String str) {
        BufferedReader bufferedReader;
        try {
            ShizukuRemoteProcess newProcess = Shizuku.newProcess(new String[]{"sh", "-c", str}, (String[]) null, (String) null);
            newProcess.waitFor();
            if (newProcess.exitValue() != 0) {
                bufferedReader = new BufferedReader(new InputStreamReader(newProcess.getErrorStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        Log.e(TAG, "Shizuku Err: " + readLine);
                    } else {
                        bufferedReader.close();
                        throw new RuntimeException("Exit code " + newProcess.exitValue());
                    }
                }
            } else {
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void openPlayStore() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=moe.shizuku.privileged.api"));
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=moe.shizuku.privileged.api"));
            intent2.addFlags(268435456);
            this.context.startActivity(intent2);
        }
    }
}
