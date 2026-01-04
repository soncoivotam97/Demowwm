package moe.shizuku.server;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IShizukuApplication extends IInterface {

    public static class Default implements IShizukuApplication {
        public IBinder asBinder() {
            return null;
        }

        public void bindApplication(Bundle bundle) throws RemoteException {
        }

        public void dispatchRequestPermissionResult(int i, Bundle bundle) throws RemoteException {
        }

        public void showPermissionConfirmation(int i, int i2, String str, int i3) throws RemoteException {
        }
    }

    void bindApplication(Bundle bundle) throws RemoteException;

    void dispatchRequestPermissionResult(int i, Bundle bundle) throws RemoteException;

    void showPermissionConfirmation(int i, int i2, String str, int i3) throws RemoteException;

    public static abstract class Stub extends Binder implements IShizukuApplication {
        private static final String DESCRIPTOR = "moe.shizuku.server.IShizukuApplication";
        static final int TRANSACTION_bindApplication = 2;
        static final int TRANSACTION_dispatchRequestPermissionResult = 3;
        static final int TRANSACTION_showPermissionConfirmation = 10001;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IShizukuApplication asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IShizukuApplication)) {
                return new Proxy(iBinder);
            }
            return (IShizukuApplication) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 2
                r1 = 0
                r2 = 1
                java.lang.String r3 = "moe.shizuku.server.IShizukuApplication"
                if (r5 == r0) goto L_0x0050
                r0 = 3
                if (r5 == r0) goto L_0x0036
                r0 = 10001(0x2711, float:1.4014E-41)
                if (r5 == r0) goto L_0x001c
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r5 == r0) goto L_0x0018
                boolean r4 = super.onTransact(r5, r6, r7, r8)
                return r4
            L_0x0018:
                r7.writeString(r3)
                return r2
            L_0x001c:
                r6.enforceInterface(r3)
                int r5 = r6.readInt()
                int r8 = r6.readInt()
                java.lang.String r0 = r6.readString()
                int r6 = r6.readInt()
                r4.showPermissionConfirmation(r5, r8, r0, r6)
                r7.writeNoException()
                return r2
            L_0x0036:
                r6.enforceInterface(r3)
                int r5 = r6.readInt()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x004c
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r7.createFromParcel(r6)
                r1 = r6
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x004c:
                r4.dispatchRequestPermissionResult(r5, r1)
                return r2
            L_0x0050:
                r6.enforceInterface(r3)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0062
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0062:
                r4.bindApplication(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: moe.shizuku.server.IShizukuApplication.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        private static class Proxy implements IShizukuApplication {
            public static IShizukuApplication sDefaultImpl;
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

            public void bindApplication(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().bindApplication(bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void dispatchRequestPermissionResult(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().dispatchRequestPermissionResult(i, bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void showPermissionConfirmation(int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(Stub.TRANSACTION_showPermissionConfirmation, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().showPermissionConfirmation(i, i2, str, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IShizukuApplication iShizukuApplication) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iShizukuApplication == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iShizukuApplication;
                return true;
            }
        }

        public static IShizukuApplication getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
