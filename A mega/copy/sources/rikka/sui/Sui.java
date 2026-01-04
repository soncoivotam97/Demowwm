package rikka.sui;

import android.os.IBinder;
import android.os.Parcel;
import rikka.shizuku.Shizuku;
import rikka.shizuku.SystemServiceHelper;

public class Sui {
    private static final int BRIDGE_ACTION_GET_BINDER = 2;
    private static final String BRIDGE_SERVICE_DESCRIPTOR = "android.app.IActivityManager";
    private static final String BRIDGE_SERVICE_NAME = "activity";
    private static final int BRIDGE_TRANSACTION_CODE = 1599296841;
    private static boolean isSui;

    private static IBinder requestBinder() {
        IBinder systemService = SystemServiceHelper.getSystemService(BRIDGE_SERVICE_NAME);
        if (systemService == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(BRIDGE_SERVICE_DESCRIPTOR);
            obtain.writeInt(2);
            systemService.transact(BRIDGE_TRANSACTION_CODE, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            if (readStrongBinder != null) {
                obtain.recycle();
                obtain2.recycle();
                return readStrongBinder;
            }
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
        return null;
    }

    public static boolean isSui() {
        return isSui;
    }

    public static boolean init(String str) {
        IBinder requestBinder = requestBinder();
        if (requestBinder != null) {
            Shizuku.onBinderReceived(requestBinder, str);
            isSui = true;
            return true;
        }
        isSui = false;
        return false;
    }
}
