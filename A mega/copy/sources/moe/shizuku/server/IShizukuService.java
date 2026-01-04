package moe.shizuku.server;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import moe.shizuku.server.IRemoteProcess;

public interface IShizukuService extends IInterface {

    public static class Default implements IShizukuService {
        public int addUserService(IShizukuServiceConnection iShizukuServiceConnection, Bundle bundle) throws RemoteException {
            return 0;
        }

        public IBinder asBinder() {
            return null;
        }

        public void attachApplication(IShizukuApplication iShizukuApplication, String str) throws RemoteException {
        }

        public void attachUserService(IBinder iBinder, Bundle bundle) throws RemoteException {
        }

        public int checkPermission(String str) throws RemoteException {
            return 0;
        }

        public boolean checkSelfPermission() throws RemoteException {
            return false;
        }

        public void dispatchPackageChanged(Intent intent) throws RemoteException {
        }

        public void dispatchPermissionConfirmationResult(int i, int i2, int i3, Bundle bundle) throws RemoteException {
        }

        public void exit() throws RemoteException {
        }

        public int getFlagsForUid(int i, int i2) throws RemoteException {
            return 0;
        }

        public String getSELinuxContext() throws RemoteException {
            return null;
        }

        public String getSystemProperty(String str, String str2) throws RemoteException {
            return null;
        }

        public int getUid() throws RemoteException {
            return 0;
        }

        public int getVersion() throws RemoteException {
            return 0;
        }

        public boolean isHidden(int i) throws RemoteException {
            return false;
        }

        public IRemoteProcess newProcess(String[] strArr, String[] strArr2, String str) throws RemoteException {
            return null;
        }

        public int removeUserService(IShizukuServiceConnection iShizukuServiceConnection, Bundle bundle) throws RemoteException {
            return 0;
        }

        public void requestPermission(int i) throws RemoteException {
        }

        public void setSystemProperty(String str, String str2) throws RemoteException {
        }

        public boolean shouldShowRequestPermissionRationale() throws RemoteException {
            return false;
        }

        public void updateFlagsForUid(int i, int i2, int i3) throws RemoteException {
        }
    }

    int addUserService(IShizukuServiceConnection iShizukuServiceConnection, Bundle bundle) throws RemoteException;

    void attachApplication(IShizukuApplication iShizukuApplication, String str) throws RemoteException;

    void attachUserService(IBinder iBinder, Bundle bundle) throws RemoteException;

    int checkPermission(String str) throws RemoteException;

    boolean checkSelfPermission() throws RemoteException;

    void dispatchPackageChanged(Intent intent) throws RemoteException;

    void dispatchPermissionConfirmationResult(int i, int i2, int i3, Bundle bundle) throws RemoteException;

    void exit() throws RemoteException;

    int getFlagsForUid(int i, int i2) throws RemoteException;

    String getSELinuxContext() throws RemoteException;

    String getSystemProperty(String str, String str2) throws RemoteException;

    int getUid() throws RemoteException;

    int getVersion() throws RemoteException;

    boolean isHidden(int i) throws RemoteException;

    IRemoteProcess newProcess(String[] strArr, String[] strArr2, String str) throws RemoteException;

    int removeUserService(IShizukuServiceConnection iShizukuServiceConnection, Bundle bundle) throws RemoteException;

    void requestPermission(int i) throws RemoteException;

    void setSystemProperty(String str, String str2) throws RemoteException;

    boolean shouldShowRequestPermissionRationale() throws RemoteException;

    void updateFlagsForUid(int i, int i2, int i3) throws RemoteException;

    public static abstract class Stub extends Binder implements IShizukuService {
        private static final String DESCRIPTOR = "moe.shizuku.server.IShizukuService";
        static final int TRANSACTION_addUserService = 12;
        static final int TRANSACTION_attachApplication = 14;
        static final int TRANSACTION_attachUserService = 102;
        static final int TRANSACTION_checkPermission = 5;
        static final int TRANSACTION_checkSelfPermission = 16;
        static final int TRANSACTION_dispatchPackageChanged = 103;
        static final int TRANSACTION_dispatchPermissionConfirmationResult = 105;
        static final int TRANSACTION_exit = 101;
        static final int TRANSACTION_getFlagsForUid = 106;
        static final int TRANSACTION_getSELinuxContext = 9;
        static final int TRANSACTION_getSystemProperty = 10;
        static final int TRANSACTION_getUid = 4;
        static final int TRANSACTION_getVersion = 3;
        static final int TRANSACTION_isHidden = 104;
        static final int TRANSACTION_newProcess = 8;
        static final int TRANSACTION_removeUserService = 13;
        static final int TRANSACTION_requestPermission = 15;
        static final int TRANSACTION_setSystemProperty = 11;
        static final int TRANSACTION_shouldShowRequestPermissionRationale = 17;
        static final int TRANSACTION_updateFlagsForUid = 107;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "moe.shizuku.server.IShizukuService");
        }

        public static IShizukuService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("moe.shizuku.server.IShizukuService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IShizukuService)) {
                return new Proxy(iBinder);
            }
            return (IShizukuService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v4 */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v16, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r0v23 */
        /* JADX WARNING: type inference failed for: r0v24 */
        /* JADX WARNING: type inference failed for: r0v25 */
        /* JADX WARNING: type inference failed for: r0v26 */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 3
                r1 = 1
                java.lang.String r2 = "moe.shizuku.server.IShizukuService"
                if (r4 == r0) goto L_0x01be
                r0 = 4
                if (r4 == r0) goto L_0x01b0
                r0 = 5
                if (r4 == r0) goto L_0x019e
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r4 == r0) goto L_0x019a
                r0 = 0
                switch(r4) {
                    case 8: goto L_0x017a;
                    case 9: goto L_0x016c;
                    case 10: goto L_0x0156;
                    case 11: goto L_0x0144;
                    case 12: goto L_0x011f;
                    case 13: goto L_0x00fa;
                    case 14: goto L_0x00e4;
                    case 15: goto L_0x00d6;
                    case 16: goto L_0x00c8;
                    case 17: goto L_0x00ba;
                    default: goto L_0x0015;
                }
            L_0x0015:
                switch(r4) {
                    case 101: goto L_0x00b0;
                    case 102: goto L_0x0093;
                    case 103: goto L_0x007d;
                    case 104: goto L_0x006b;
                    case 105: goto L_0x0049;
                    case 106: goto L_0x0033;
                    case 107: goto L_0x001d;
                    default: goto L_0x0018;
                }
            L_0x0018:
                boolean r3 = super.onTransact(r4, r5, r6, r7)
                return r3
            L_0x001d:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                int r7 = r5.readInt()
                int r5 = r5.readInt()
                r3.updateFlagsForUid(r4, r7, r5)
                r6.writeNoException()
                return r1
            L_0x0033:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                int r5 = r5.readInt()
                int r3 = r3.getFlagsForUid(r4, r5)
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x0049:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                int r6 = r5.readInt()
                int r7 = r5.readInt()
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0067
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r0.createFromParcel(r5)
                r0 = r5
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0067:
                r3.dispatchPermissionConfirmationResult(r4, r6, r7, r0)
                return r1
            L_0x006b:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                boolean r3 = r3.isHidden(r4)
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x007d:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x008f
                android.os.Parcelable$Creator r4 = android.content.Intent.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r0 = r4
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x008f:
                r3.dispatchPackageChanged(r0)
                return r1
            L_0x0093:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x00a9
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r0 = r5
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00a9:
                r3.attachUserService(r4, r0)
                r6.writeNoException()
                return r1
            L_0x00b0:
                r5.enforceInterface(r2)
                r3.exit()
                r6.writeNoException()
                return r1
            L_0x00ba:
                r5.enforceInterface(r2)
                boolean r3 = r3.shouldShowRequestPermissionRationale()
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x00c8:
                r5.enforceInterface(r2)
                boolean r3 = r3.checkSelfPermission()
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x00d6:
                r5.enforceInterface(r2)
                int r4 = r5.readInt()
                r3.requestPermission(r4)
                r6.writeNoException()
                return r1
            L_0x00e4:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                moe.shizuku.server.IShizukuApplication r4 = moe.shizuku.server.IShizukuApplication.Stub.asInterface(r4)
                java.lang.String r5 = r5.readString()
                r3.attachApplication(r4, r5)
                r6.writeNoException()
                return r1
            L_0x00fa:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                moe.shizuku.server.IShizukuServiceConnection r4 = moe.shizuku.server.IShizukuServiceConnection.Stub.asInterface(r4)
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0114
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r0 = r5
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0114:
                int r3 = r3.removeUserService(r4, r0)
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x011f:
                r5.enforceInterface(r2)
                android.os.IBinder r4 = r5.readStrongBinder()
                moe.shizuku.server.IShizukuServiceConnection r4 = moe.shizuku.server.IShizukuServiceConnection.Stub.asInterface(r4)
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0139
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r7.createFromParcel(r5)
                r0 = r5
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0139:
                int r3 = r3.addUserService(r4, r0)
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x0144:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                java.lang.String r5 = r5.readString()
                r3.setSystemProperty(r4, r5)
                r6.writeNoException()
                return r1
            L_0x0156:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                java.lang.String r5 = r5.readString()
                java.lang.String r3 = r3.getSystemProperty(r4, r5)
                r6.writeNoException()
                r6.writeString(r3)
                return r1
            L_0x016c:
                r5.enforceInterface(r2)
                java.lang.String r3 = r3.getSELinuxContext()
                r6.writeNoException()
                r6.writeString(r3)
                return r1
            L_0x017a:
                r5.enforceInterface(r2)
                java.lang.String[] r4 = r5.createStringArray()
                java.lang.String[] r7 = r5.createStringArray()
                java.lang.String r5 = r5.readString()
                moe.shizuku.server.IRemoteProcess r3 = r3.newProcess(r4, r7, r5)
                r6.writeNoException()
                if (r3 == 0) goto L_0x0196
                android.os.IBinder r0 = r3.asBinder()
            L_0x0196:
                r6.writeStrongBinder(r0)
                return r1
            L_0x019a:
                r6.writeString(r2)
                return r1
            L_0x019e:
                r5.enforceInterface(r2)
                java.lang.String r4 = r5.readString()
                int r3 = r3.checkPermission(r4)
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x01b0:
                r5.enforceInterface(r2)
                int r3 = r3.getUid()
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            L_0x01be:
                r5.enforceInterface(r2)
                int r3 = r3.getVersion()
                r6.writeNoException()
                r6.writeInt(r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: moe.shizuku.server.IShizukuService.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        private static class Proxy implements IShizukuService {
            public static IShizukuService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "moe.shizuku.server.IShizukuService";
            }

            public int getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVersion();
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

            public int getUid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUid();
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

            public int checkPermission(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkPermission(str);
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

            public IRemoteProcess newProcess(String[] strArr, String[] strArr2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newProcess(strArr, strArr2, str);
                    }
                    obtain2.readException();
                    IRemoteProcess asInterface = IRemoteProcess.Stub.asInterface(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return asInterface;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSELinuxContext() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSELinuxContext();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSystemProperty(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSystemProperty(str, str2);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSystemProperty(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setSystemProperty(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addUserService(IShizukuServiceConnection iShizukuServiceConnection, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeStrongBinder(iShizukuServiceConnection != null ? iShizukuServiceConnection.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().addUserService(iShizukuServiceConnection, bundle);
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

            public int removeUserService(IShizukuServiceConnection iShizukuServiceConnection, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeStrongBinder(iShizukuServiceConnection != null ? iShizukuServiceConnection.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeUserService(iShizukuServiceConnection, bundle);
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

            public void attachApplication(IShizukuApplication iShizukuApplication, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeStrongBinder(iShizukuApplication != null ? iShizukuApplication.asBinder() : null);
                    obtain.writeString(str);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().attachApplication(iShizukuApplication, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestPermission(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeInt(i);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().requestPermission(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean checkSelfPermission() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    boolean z = false;
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkSelfPermission();
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

            public boolean shouldShowRequestPermissionRationale() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    boolean z = false;
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().shouldShowRequestPermissionRationale();
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

            public void exit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if (this.mRemote.transact(101, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().exit();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void attachUserService(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(102, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().attachUserService(iBinder, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void dispatchPackageChanged(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_dispatchPackageChanged, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().dispatchPackageChanged(intent);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean isHidden(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeInt(i);
                    boolean z = false;
                    if (!this.mRemote.transact(104, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isHidden(i);
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

            public void dispatchPermissionConfirmationResult(int i, int i2, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_dispatchPermissionConfirmationResult, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().dispatchPermissionConfirmationResult(i, i2, i3, bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public int getFlagsForUid(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getFlagsForUid, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFlagsForUid(i, i2);
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

            public void updateFlagsForUid(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(Stub.TRANSACTION_updateFlagsForUid, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().updateFlagsForUid(i, i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IShizukuService iShizukuService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iShizukuService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iShizukuService;
                return true;
            }
        }

        public static IShizukuService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
