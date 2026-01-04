package moe.shizuku.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public interface IRemoteProcess extends IInterface {

    public static class Default implements IRemoteProcess {
        public boolean alive() throws RemoteException {
            return false;
        }

        public IBinder asBinder() {
            return null;
        }

        public void destroy() throws RemoteException {
        }

        public int exitValue() throws RemoteException {
            return 0;
        }

        public ParcelFileDescriptor getErrorStream() throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getInputStream() throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getOutputStream() throws RemoteException {
            return null;
        }

        public int waitFor() throws RemoteException {
            return 0;
        }

        public boolean waitForTimeout(long j, String str) throws RemoteException {
            return false;
        }
    }

    boolean alive() throws RemoteException;

    void destroy() throws RemoteException;

    int exitValue() throws RemoteException;

    ParcelFileDescriptor getErrorStream() throws RemoteException;

    ParcelFileDescriptor getInputStream() throws RemoteException;

    ParcelFileDescriptor getOutputStream() throws RemoteException;

    int waitFor() throws RemoteException;

    boolean waitForTimeout(long j, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteProcess {
        private static final String DESCRIPTOR = "moe.shizuku.server.IRemoteProcess";
        static final int TRANSACTION_alive = 7;
        static final int TRANSACTION_destroy = 6;
        static final int TRANSACTION_exitValue = 5;
        static final int TRANSACTION_getErrorStream = 3;
        static final int TRANSACTION_getInputStream = 2;
        static final int TRANSACTION_getOutputStream = 1;
        static final int TRANSACTION_waitFor = 4;
        static final int TRANSACTION_waitForTimeout = 8;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteProcess asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteProcess)) {
                return new Proxy(iBinder);
            }
            return (IRemoteProcess) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        ParcelFileDescriptor outputStream = getOutputStream();
                        parcel2.writeNoException();
                        if (outputStream != null) {
                            parcel2.writeInt(1);
                            outputStream.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        ParcelFileDescriptor inputStream = getInputStream();
                        parcel2.writeNoException();
                        if (inputStream != null) {
                            parcel2.writeInt(1);
                            inputStream.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        ParcelFileDescriptor errorStream = getErrorStream();
                        parcel2.writeNoException();
                        if (errorStream != null) {
                            parcel2.writeInt(1);
                            errorStream.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int waitFor = waitFor();
                        parcel2.writeNoException();
                        parcel2.writeInt(waitFor);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int exitValue = exitValue();
                        parcel2.writeNoException();
                        parcel2.writeInt(exitValue);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        destroy();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean alive = alive();
                        parcel2.writeNoException();
                        parcel2.writeInt(alive ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean waitForTimeout = waitForTimeout(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(waitForTimeout ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IRemoteProcess {
            public static IRemoteProcess sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public ParcelFileDescriptor getOutputStream() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOutputStream();
                    }
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor getInputStream() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInputStream();
                    }
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor getErrorStream() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getErrorStream();
                    }
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int waitFor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().waitFor();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int exitValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().exitValue();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().destroy();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean alive() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().alive();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean waitForTimeout(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().waitForTimeout(j, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteProcess iRemoteProcess) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iRemoteProcess == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iRemoteProcess;
                return true;
            }
        }

        public static IRemoteProcess getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
