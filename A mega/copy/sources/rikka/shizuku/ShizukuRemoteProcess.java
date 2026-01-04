package rikka.shizuku;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import moe.shizuku.server.IRemoteProcess;

public class ShizukuRemoteProcess extends Process implements Parcelable {
    private static final Set<ShizukuRemoteProcess> CACHE = Collections.synchronizedSet(new ArraySet());
    public static final Parcelable.Creator<ShizukuRemoteProcess> CREATOR = new Parcelable.Creator<ShizukuRemoteProcess>() {
        public ShizukuRemoteProcess createFromParcel(Parcel parcel) {
            return new ShizukuRemoteProcess(parcel);
        }

        public ShizukuRemoteProcess[] newArray(int i) {
            return new ShizukuRemoteProcess[i];
        }
    };
    private static final String TAG = "ShizukuRemoteProcess";
    private InputStream is;
    private OutputStream os;
    private IRemoteProcess remote;

    public int describeContents() {
        return 0;
    }

    ShizukuRemoteProcess(IRemoteProcess iRemoteProcess) {
        this.remote = iRemoteProcess;
        try {
            iRemoteProcess.asBinder().linkToDeath(new ShizukuRemoteProcess$$ExternalSyntheticLambda0(this), 0);
        } catch (RemoteException e) {
            Log.e(TAG, "linkToDeath", e);
        }
        CACHE.add(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$rikka-shizuku-ShizukuRemoteProcess  reason: not valid java name */
    public /* synthetic */ void m1779lambda$new$0$rikkashizukuShizukuRemoteProcess() {
        this.remote = null;
        Log.v(TAG, "remote process is dead");
        CACHE.remove(this);
    }

    public OutputStream getOutputStream() {
        if (this.os == null) {
            try {
                this.os = new ParcelFileDescriptor.AutoCloseOutputStream(this.remote.getOutputStream());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return this.os;
    }

    public InputStream getInputStream() {
        if (this.is == null) {
            try {
                this.is = new ParcelFileDescriptor.AutoCloseInputStream(this.remote.getInputStream());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return this.is;
    }

    public InputStream getErrorStream() {
        try {
            return new ParcelFileDescriptor.AutoCloseInputStream(this.remote.getErrorStream());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public int waitFor() throws InterruptedException {
        try {
            return this.remote.waitFor();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public int exitValue() {
        try {
            return this.remote.exitValue();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
        try {
            this.remote.destroy();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean alive() {
        try {
            return this.remote.alive();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean waitForTimeout(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.remote.waitForTimeout(j, timeUnit.toString());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public IBinder asBinder() {
        return this.remote.asBinder();
    }

    private ShizukuRemoteProcess(Parcel parcel) {
        this.remote = IRemoteProcess.Stub.asInterface(parcel.readStrongBinder());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.remote.asBinder());
    }
}
