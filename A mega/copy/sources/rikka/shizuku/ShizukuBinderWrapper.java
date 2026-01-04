package rikka.shizuku;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.Objects;

public class ShizukuBinderWrapper implements IBinder {
    private final IBinder original;

    public IInterface queryLocalInterface(String str) {
        return null;
    }

    public ShizukuBinderWrapper(IBinder iBinder) {
        this.original = (IBinder) Objects.requireNonNull(iBinder);
    }

    /* JADX INFO: finally extract failed */
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(ShizukuApiConstants.BINDER_DESCRIPTOR);
            obtain.writeStrongBinder(this.original);
            obtain.writeInt(i);
            obtain.appendFrom(parcel, 0, parcel.dataSize());
            Shizuku.transactRemote(obtain, parcel2, i2);
            obtain.recycle();
            return true;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    public String getInterfaceDescriptor() throws RemoteException {
        return this.original.getInterfaceDescriptor();
    }

    public boolean pingBinder() {
        return this.original.pingBinder();
    }

    public boolean isBinderAlive() {
        return this.original.isBinderAlive();
    }

    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        this.original.dump(fileDescriptor, strArr);
    }

    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        this.original.dumpAsync(fileDescriptor, strArr);
    }

    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        this.original.linkToDeath(deathRecipient, i);
    }

    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        return this.original.unlinkToDeath(deathRecipient, i);
    }
}
