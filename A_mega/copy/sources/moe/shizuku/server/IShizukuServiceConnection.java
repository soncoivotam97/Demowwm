package moe.shizuku.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IShizukuServiceConnection extends IInterface {

    public static class Default implements IShizukuServiceConnection {
        public IBinder asBinder() {
            return null;
        }

        public void connected(IBinder iBinder) throws RemoteException {
        }

        public void died() throws RemoteException {
        }
    }

    void connected(IBinder iBinder) throws RemoteException;

    void died() throws RemoteException;

    public static abstract class Stub extends Binder implements IShizukuServiceConnection {
        private static final String DESCRIPTOR = "moe.shizuku.server.IShizukuServiceConnection";
        static final int TRANSACTION_connected = 1;
        static final int TRANSACTION_died = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IShizukuServiceConnection asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IShizukuServiceConnection)) {
                return new Proxy(iBinder);
            }
            return (IShizukuServiceConnection) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                connected(parcel.readStrongBinder());
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                died();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IShizukuServiceConnection {
            public static IShizukuServiceConnection sDefaultImpl;
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

            public void connected(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().connected(iBinder);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void died() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().died();
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IShizukuServiceConnection iShizukuServiceConnection) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iShizukuServiceConnection == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iShizukuServiceConnection;
                return true;
            }
        }

        public static IShizukuServiceConnection getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
