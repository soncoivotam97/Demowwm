package com.google.firebase.crashlytics.internal.persistence;

import android.app.Application;
import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileStore {
    private static final String CRASHLYTICS_PATH_V1 = ".com.google.firebase.crashlytics.files.v1";
    private static final String CRASHLYTICS_PATH_V2 = ".com.google.firebase.crashlytics.files.v2";
    private static final String NATIVE_REPORTS_PATH = "native-reports";
    private static final String NATIVE_SESSION_SUBDIR = "native";
    private static final String PRIORITY_REPORTS_PATH = "priority-reports";
    private static final String REPORTS_PATH = "reports";
    private static final String SESSIONS_PATH = "open-sessions";
    private final File crashlyticsDir;
    private final File filesDir;
    private final File nativeReportsDir;
    private final File priorityReportsDir;
    private final File reportsDir;
    private final File sessionsDir;

    private static boolean useV2FileSystem() {
        return true;
    }

    public FileStore(Context context) {
        String str;
        File filesDir2 = context.getFilesDir();
        this.filesDir = filesDir2;
        if (useV2FileSystem()) {
            str = CRASHLYTICS_PATH_V2 + File.pathSeparator + sanitizeName(Application.getProcessName());
        } else {
            str = CRASHLYTICS_PATH_V1;
        }
        File prepareBaseDir = prepareBaseDir(new File(filesDir2, str));
        this.crashlyticsDir = prepareBaseDir;
        this.sessionsDir = prepareBaseDir(new File(prepareBaseDir, SESSIONS_PATH));
        this.reportsDir = prepareBaseDir(new File(prepareBaseDir, REPORTS_PATH));
        this.priorityReportsDir = prepareBaseDir(new File(prepareBaseDir, PRIORITY_REPORTS_PATH));
        this.nativeReportsDir = prepareBaseDir(new File(prepareBaseDir, NATIVE_REPORTS_PATH));
    }

    public void deleteAllCrashlyticsFiles() {
        recursiveDelete(this.crashlyticsDir);
    }

    public void cleanupPreviousFileSystems() {
        cleanupDir(new File(this.filesDir, ".com.google.firebase.crashlytics"));
        cleanupDir(new File(this.filesDir, ".com.google.firebase.crashlytics-ndk"));
        if (useV2FileSystem()) {
            cleanupDir(new File(this.filesDir, CRASHLYTICS_PATH_V1));
        }
    }

    private void cleanupDir(File file) {
        if (file.exists() && recursiveDelete(file)) {
            Logger.getLogger().d("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    static boolean recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveDelete : listFiles) {
                recursiveDelete(recursiveDelete);
            }
        }
        return file.delete();
    }

    public File getCommonFile(String str) {
        return new File(this.crashlyticsDir, str);
    }

    public List<File> getCommonFiles(FilenameFilter filenameFilter) {
        return safeArrayToList(this.crashlyticsDir.listFiles(filenameFilter));
    }

    private File getSessionDir(String str) {
        return prepareDir(new File(this.sessionsDir, str));
    }

    public File getSessionFile(String str, String str2) {
        return new File(getSessionDir(str), str2);
    }

    public List<File> getSessionFiles(String str, FilenameFilter filenameFilter) {
        return safeArrayToList(getSessionDir(str).listFiles(filenameFilter));
    }

    public File getNativeSessionDir(String str) {
        return prepareDir(new File(getSessionDir(str), NATIVE_SESSION_SUBDIR));
    }

    public boolean deleteSessionFiles(String str) {
        return recursiveDelete(new File(this.sessionsDir, str));
    }

    public List<String> getAllOpenSessionIds() {
        return safeArrayToList(this.sessionsDir.list());
    }

    public File getReport(String str) {
        return new File(this.reportsDir, str);
    }

    public List<File> getReports() {
        return safeArrayToList(this.reportsDir.listFiles());
    }

    public File getPriorityReport(String str) {
        return new File(this.priorityReportsDir, str);
    }

    public List<File> getPriorityReports() {
        return safeArrayToList(this.priorityReportsDir.listFiles());
    }

    public File getNativeReport(String str) {
        return new File(this.nativeReportsDir, str);
    }

    public List<File> getNativeReports() {
        return safeArrayToList(this.nativeReportsDir.listFiles());
    }

    private static File prepareDir(File file) {
        file.mkdirs();
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File prepareBaseDir(java.io.File r5) {
        /*
            java.lang.String r0 = "Unexpected non-directory file: "
            java.lang.String r1 = "Could not create Crashlytics-specific directory: "
            java.lang.Class<com.google.firebase.crashlytics.internal.persistence.FileStore> r2 = com.google.firebase.crashlytics.internal.persistence.FileStore.class
            monitor-enter(r2)
            boolean r3 = r5.exists()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0032
            boolean r3 = r5.isDirectory()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0015
            monitor-exit(r2)
            return r5
        L_0x0015:
            com.google.firebase.crashlytics.internal.Logger r3 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r4.<init>(r0)     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r0 = r4.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "; deleting file and creating new directory."
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004e }
            r3.d(r0)     // Catch:{ all -> 0x004e }
            r5.delete()     // Catch:{ all -> 0x004e }
        L_0x0032:
            boolean r0 = r5.mkdirs()     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x004c
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r3.<init>(r1)     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r1 = r3.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004e }
            r0.e(r1)     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r2)
            return r5
        L_0x004e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.persistence.FileStore.prepareBaseDir(java.io.File):java.io.File");
    }

    private static <T> List<T> safeArrayToList(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    static String sanitizeName(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }
}
