package rikka.shizuku;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import moe.shizuku.server.IShizukuApplication;
import moe.shizuku.server.IShizukuService;
import moe.shizuku.server.IShizukuServiceConnection;

public class Shizuku {
    private static final List<OnBinderDeadListener> DEAD_LISTENERS = new CopyOnWriteArrayList();
    private static final IBinder.DeathRecipient DEATH_RECIPIENT = new Shizuku$$ExternalSyntheticLambda2();
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final List<OnRequestPermissionResultListener> PERMISSION_LISTENERS = new CopyOnWriteArrayList();
    private static final List<OnBinderReceivedListener> RECEIVED_LISTENERS = new CopyOnWriteArrayList();
    private static final IShizukuApplication SHIZUKU_APPLICATION = new IShizukuApplication.Stub() {
        public void showPermissionConfirmation(int i, int i2, String str, int i3) {
        }

        public void bindApplication(Bundle bundle) {
            int unused = Shizuku.serverUid = bundle.getInt(ShizukuApiConstants.ATTACH_REPLY_SERVER_UID, -1);
            int unused2 = Shizuku.serverApiVersion = bundle.getInt(ShizukuApiConstants.ATTACH_REPLY_SERVER_VERSION, -1);
            int unused3 = Shizuku.serverPatchVersion = bundle.getInt(ShizukuApiConstants.ATTACH_REPLY_SERVER_PATCH_VERSION, -1);
            String unused4 = Shizuku.serverContext = bundle.getString(ShizukuApiConstants.ATTACH_REPLY_SERVER_SECONTEXT);
            boolean unused5 = Shizuku.permissionGranted = bundle.getBoolean(ShizukuApiConstants.ATTACH_REPLY_PERMISSION_GRANTED, false);
            boolean unused6 = Shizuku.shouldShowRequestPermissionRationale = bundle.getBoolean(ShizukuApiConstants.ATTACH_REPLY_SHOULD_SHOW_REQUEST_PERMISSION_RATIONALE, false);
            Shizuku.scheduleBinderReceivedListeners();
        }

        public void dispatchRequestPermissionResult(int i, Bundle bundle) {
            int i2 = 0;
            if (!bundle.getBoolean(ShizukuApiConstants.REQUEST_PERMISSION_REPLY_ALLOWED, false)) {
                i2 = -1;
            }
            Shizuku.scheduleRequestPermissionResultListener(i, i2);
        }
    };
    private static IBinder binder = null;
    private static boolean binderReady = false;
    /* access modifiers changed from: private */
    public static boolean permissionGranted = false;
    private static boolean preV11 = false;
    /* access modifiers changed from: private */
    public static int serverApiVersion = -1;
    /* access modifiers changed from: private */
    public static String serverContext = null;
    /* access modifiers changed from: private */
    public static int serverPatchVersion = -1;
    /* access modifiers changed from: private */
    public static int serverUid = -1;
    private static IShizukuService service = null;
    /* access modifiers changed from: private */
    public static boolean shouldShowRequestPermissionRationale = false;

    public interface OnBinderDeadListener {
        void onBinderDead();
    }

    public interface OnBinderReceivedListener {
        void onBinderReceived();
    }

    public interface OnRequestPermissionResultListener {
        void onRequestPermissionResult(int i, int i2);
    }

    public static int getLatestServiceVersion() {
        return 12;
    }

    static /* synthetic */ void lambda$static$0() {
        binderReady = false;
        onBinderReceived((IBinder) null, (String) null);
    }

    public static void onBinderReceived(IBinder iBinder, String str) {
        Parcel obtain;
        Parcel obtain2;
        IBinder iBinder2 = binder;
        if (iBinder2 != iBinder) {
            if (iBinder == null) {
                binder = null;
                service = null;
                serverUid = -1;
                serverApiVersion = -1;
                serverContext = null;
                scheduleBinderDeadListeners();
                return;
            }
            if (iBinder2 != null) {
                iBinder2.unlinkToDeath(DEATH_RECIPIENT, 0);
            }
            binder = iBinder;
            service = IShizukuService.Stub.asInterface(iBinder);
            try {
                binder.linkToDeath(DEATH_RECIPIENT, 0);
            } catch (Throwable unused) {
                Log.i("ShizukuApplication", "attachApplication");
            }
            try {
                obtain = Parcel.obtain();
                obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken(ShizukuApiConstants.BINDER_DESCRIPTOR);
                obtain.writeStrongBinder(SHIZUKU_APPLICATION.asBinder());
                obtain.writeString(str);
                preV11 = !binder.transact(14, obtain, obtain2, 0);
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
                Log.i("ShizukuApplication", "attachApplication");
            } catch (Throwable th) {
                Log.w("ShizukuApplication", Log.getStackTraceString(th));
            }
            if (preV11) {
                binderReady = true;
                scheduleBinderReceivedListeners();
            }
        }
    }

    public static void addBinderReceivedListener(OnBinderReceivedListener onBinderReceivedListener) {
        addBinderReceivedListener((OnBinderReceivedListener) Objects.requireNonNull(onBinderReceivedListener), false);
    }

    public static void addBinderReceivedListenerSticky(OnBinderReceivedListener onBinderReceivedListener) {
        addBinderReceivedListener((OnBinderReceivedListener) Objects.requireNonNull(onBinderReceivedListener), true);
    }

    private static void addBinderReceivedListener(OnBinderReceivedListener onBinderReceivedListener, boolean z) {
        if (z && binderReady) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                onBinderReceivedListener.onBinderReceived();
            } else {
                Handler handler = MAIN_HANDLER;
                Objects.requireNonNull(onBinderReceivedListener);
                handler.post(new Shizuku$$ExternalSyntheticLambda4(onBinderReceivedListener));
            }
        }
        RECEIVED_LISTENERS.add(onBinderReceivedListener);
    }

    public static boolean removeBinderReceivedListener(OnBinderReceivedListener onBinderReceivedListener) {
        return RECEIVED_LISTENERS.remove(onBinderReceivedListener);
    }

    /* access modifiers changed from: private */
    public static void scheduleBinderReceivedListeners() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            dispatchBinderReceivedListeners();
        } else {
            MAIN_HANDLER.post(new Shizuku$$ExternalSyntheticLambda0());
        }
    }

    /* access modifiers changed from: private */
    public static void dispatchBinderReceivedListeners() {
        for (OnBinderReceivedListener onBinderReceived : RECEIVED_LISTENERS) {
            onBinderReceived.onBinderReceived();
        }
        binderReady = true;
    }

    public static void addBinderDeadListener(OnBinderDeadListener onBinderDeadListener) {
        DEAD_LISTENERS.add(onBinderDeadListener);
    }

    public static boolean removeBinderDeadListener(OnBinderDeadListener onBinderDeadListener) {
        return DEAD_LISTENERS.remove(onBinderDeadListener);
    }

    private static void scheduleBinderDeadListeners() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            dispatchBinderDeadListeners();
        } else {
            MAIN_HANDLER.post(new Shizuku$$ExternalSyntheticLambda3());
        }
    }

    /* access modifiers changed from: private */
    public static void dispatchBinderDeadListeners() {
        for (OnBinderDeadListener onBinderDead : DEAD_LISTENERS) {
            onBinderDead.onBinderDead();
        }
    }

    public static void addRequestPermissionResultListener(OnRequestPermissionResultListener onRequestPermissionResultListener) {
        PERMISSION_LISTENERS.add(onRequestPermissionResultListener);
    }

    public static boolean removeRequestPermissionResultListener(OnRequestPermissionResultListener onRequestPermissionResultListener) {
        return PERMISSION_LISTENERS.remove(onRequestPermissionResultListener);
    }

    static void scheduleRequestPermissionResultListener(int i, int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            dispatchRequestPermissionResultListener(i, i2);
        } else {
            MAIN_HANDLER.post(new Shizuku$$ExternalSyntheticLambda1(i, i2));
        }
    }

    /* access modifiers changed from: package-private */
    public static void dispatchRequestPermissionResultListener(int i, int i2) {
        for (OnRequestPermissionResultListener onRequestPermissionResult : PERMISSION_LISTENERS) {
            onRequestPermissionResult.onRequestPermissionResult(i, i2);
        }
    }

    protected static IShizukuService requireService() {
        IShizukuService iShizukuService = service;
        if (iShizukuService != null) {
            return iShizukuService;
        }
        throw new IllegalStateException("binder haven't been received");
    }

    public static IBinder getBinder() {
        return binder;
    }

    public static boolean pingBinder() {
        IBinder iBinder = binder;
        return iBinder != null && iBinder.pingBinder();
    }

    private static RuntimeException rethrowAsRuntimeException(RemoteException remoteException) {
        return new RuntimeException(remoteException);
    }

    public static void transactRemote(Parcel parcel, Parcel parcel2, int i) {
        try {
            requireService().asBinder().transact(1, parcel, parcel2, i);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static ShizukuRemoteProcess newProcess(String[] strArr, String[] strArr2, String str) {
        try {
            return new ShizukuRemoteProcess(requireService().newProcess(strArr, strArr2, str));
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static int getUid() {
        int i = serverUid;
        if (i != -1) {
            return i;
        }
        try {
            int uid = requireService().getUid();
            serverUid = uid;
            return uid;
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        } catch (SecurityException unused) {
            return -1;
        }
    }

    public static int getVersion() {
        int i = serverApiVersion;
        if (i != -1) {
            return i;
        }
        try {
            int version = requireService().getVersion();
            serverApiVersion = version;
            return version;
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        } catch (SecurityException unused) {
            return -1;
        }
    }

    public static boolean isPreV11() {
        return preV11;
    }

    public static String getSELinuxContext() {
        String str = serverContext;
        if (str != null) {
            return str;
        }
        try {
            String sELinuxContext = requireService().getSELinuxContext();
            serverContext = sELinuxContext;
            return sELinuxContext;
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static class UserServiceArgs {
        final ComponentName componentName;
        boolean daemon = true;
        boolean debuggable = false;
        String processName;
        String tag;
        boolean use32BitAppProcess = false;
        int versionCode = 1;

        public UserServiceArgs(ComponentName componentName2) {
            this.componentName = componentName2;
        }

        public UserServiceArgs daemon(boolean z) {
            this.daemon = z;
            return this;
        }

        public UserServiceArgs tag(String str) {
            this.tag = str;
            return this;
        }

        public UserServiceArgs version(int i) {
            this.versionCode = i;
            return this;
        }

        public UserServiceArgs debuggable(boolean z) {
            this.debuggable = z;
            return this;
        }

        public UserServiceArgs processNameSuffix(String str) {
            this.processName = str;
            return this;
        }

        private UserServiceArgs use32BitAppProcess(boolean z) {
            this.use32BitAppProcess = z;
            return this;
        }

        /* access modifiers changed from: private */
        public Bundle forAdd() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ShizukuApiConstants.USER_SERVICE_ARG_COMPONENT, this.componentName);
            bundle.putBoolean(ShizukuApiConstants.USER_SERVICE_ARG_DEBUGGABLE, this.debuggable);
            bundle.putInt(ShizukuApiConstants.USER_SERVICE_ARG_VERSION_CODE, this.versionCode);
            bundle.putBoolean(ShizukuApiConstants.USER_SERVICE_ARG_DAEMON, this.daemon);
            bundle.putBoolean(ShizukuApiConstants.USER_SERVICE_ARG_USE_32_BIT_APP_PROCESS, this.use32BitAppProcess);
            bundle.putString(ShizukuApiConstants.USER_SERVICE_ARG_PROCESS_NAME, (String) Objects.requireNonNull(this.processName, "process name suffix must not be null"));
            String str = this.tag;
            if (str != null) {
                bundle.putString(ShizukuApiConstants.USER_SERVICE_ARG_TAG, str);
            }
            return bundle;
        }

        /* access modifiers changed from: private */
        public Bundle forRemove() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ShizukuApiConstants.USER_SERVICE_ARG_COMPONENT, this.componentName);
            String str = this.tag;
            if (str != null) {
                bundle.putString(ShizukuApiConstants.USER_SERVICE_ARG_TAG, str);
            }
            return bundle;
        }
    }

    public static void bindUserService(UserServiceArgs userServiceArgs, ServiceConnection serviceConnection) {
        ShizukuServiceConnection orCreate = ShizukuServiceConnections.getOrCreate(userServiceArgs);
        orCreate.addConnection(serviceConnection);
        try {
            requireService().addUserService(orCreate, userServiceArgs.forAdd());
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static boolean peekUserService(UserServiceArgs userServiceArgs, ServiceConnection serviceConnection) {
        ShizukuServiceConnection orCreate = ShizukuServiceConnections.getOrCreate(userServiceArgs);
        orCreate.addConnection(serviceConnection);
        try {
            Bundle access$700 = userServiceArgs.forAdd();
            access$700.putBoolean(ShizukuApiConstants.USER_SERVICE_ARG_NO_CREATE, true);
            if (requireService().addUserService(orCreate, access$700) == 0) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static void unbindUserService(UserServiceArgs userServiceArgs, ServiceConnection serviceConnection, boolean z) {
        ShizukuServiceConnection shizukuServiceConnection = ShizukuServiceConnections.get(userServiceArgs);
        if (shizukuServiceConnection != null) {
            shizukuServiceConnection.removeConnection(serviceConnection);
        }
        if (z) {
            try {
                requireService().removeUserService((IShizukuServiceConnection) null, userServiceArgs.forRemove());
            } catch (RemoteException e) {
                throw rethrowAsRuntimeException(e);
            }
        }
    }

    public static int checkRemotePermission(String str) {
        if (serverUid == 0) {
            return 0;
        }
        try {
            return requireService().checkPermission(str);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static void requestPermission(int i) {
        try {
            requireService().requestPermission(i);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static int checkSelfPermission() {
        if (permissionGranted) {
            return 0;
        }
        try {
            boolean checkSelfPermission = requireService().checkSelfPermission();
            permissionGranted = checkSelfPermission;
            if (checkSelfPermission) {
                return 0;
            }
            return -1;
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static boolean shouldShowRequestPermissionRationale() {
        if (permissionGranted) {
            return false;
        }
        if (shouldShowRequestPermissionRationale) {
            return true;
        }
        try {
            boolean shouldShowRequestPermissionRationale2 = requireService().shouldShowRequestPermissionRationale();
            shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale2;
            return shouldShowRequestPermissionRationale2;
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static void exit() {
        try {
            requireService().exit();
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static void attachUserService(IBinder iBinder, Bundle bundle) {
        try {
            requireService().attachUserService(iBinder, bundle);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static void dispatchPermissionConfirmationResult(int i, int i2, int i3, Bundle bundle) {
        try {
            requireService().dispatchPermissionConfirmationResult(i, i2, i3, bundle);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static int getFlagsForUid(int i, int i2) {
        try {
            return requireService().getFlagsForUid(i, i2);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static void updateFlagsForUid(int i, int i2, int i3) {
        try {
            requireService().updateFlagsForUid(i, i2, i3);
        } catch (RemoteException e) {
            throw rethrowAsRuntimeException(e);
        }
    }

    public static int getServerPatchVersion() {
        return serverPatchVersion;
    }
}
