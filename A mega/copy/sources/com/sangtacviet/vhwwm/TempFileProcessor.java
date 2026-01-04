package com.sangtacviet.vhwwm;

import android.content.Context;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TempFileProcessor {
    private FileDescriptor fileDescriptor;
    private final File tempFile;

    public TempFileProcessor(Context context) throws IOException {
        this(context, "tmp_processor");
    }

    public TempFileProcessor(Context context, String str) throws IOException {
        str = (str == null || str.trim().isEmpty()) ? "tmp_processor" : str;
        File file = new File(context.getFilesDir(), !str.contains(".") ? str + ".tmp" : str);
        this.tempFile = file;
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.fileDescriptor = fileOutputStream.getFD();
        fileOutputStream.close();
    }

    public FileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public void saveFromInputStream(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.tempFile);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public void loadToOutputStream(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.tempFile);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
            if (outputStream != null) {
                outputStream.close();
            }
            fileInputStream.close();
            return;
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

    public long getCurrentFileSize() {
        if (this.tempFile.exists()) {
            return this.tempFile.length();
        }
        return 0;
    }

    public String getAbsolutePath() {
        return this.tempFile.getAbsolutePath();
    }

    public void destroy() {
        if (this.tempFile.exists()) {
            this.tempFile.delete();
        }
        this.fileDescriptor = null;
    }
}
