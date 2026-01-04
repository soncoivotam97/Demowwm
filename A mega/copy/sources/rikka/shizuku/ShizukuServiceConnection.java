package rikka.shizuku;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import java.util.HashSet;
import java.util.Set;
import moe.shizuku.server.IShizukuServiceConnection;
import rikka.shizuku.Shizuku;

class ShizukuServiceConnection extends IShizukuServiceConnection.Stub {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private final ComponentName componentName;
    private final Set<ServiceConnection> connections = new HashSet();
    private boolean dead = false;

    public ShizukuServiceConnection(Shizuku.UserServiceArgs userServiceArgs) {
        this.componentName = userServiceArgs.componentName;
    }

    public void addConnection(ServiceConnection serviceConnection) {
        if (serviceConnection != null) {
            this.connections.add(serviceConnection);
        }
    }

    public void removeConnection(ServiceConnection serviceConnection) {
        if (serviceConnection != null) {
            this.connections.remove(serviceConnection);
        }
    }

    public void connected(IBinder iBinder) {
        MAIN_HANDLER.post(new ShizukuServiceConnection$$ExternalSyntheticLambda0(this, iBinder));
        try {
            iBinder.linkToDeath(new ShizukuServiceConnection$$ExternalSyntheticLambda1(this), 0);
        } catch (RemoteException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$connected$0$rikka-shizuku-ShizukuServiceConnection  reason: not valid java name */
    public /* synthetic */ void m1780lambda$connected$0$rikkashizukuShizukuServiceConnection(IBinder iBinder) {
        for (ServiceConnection onServiceConnected : this.connections) {
            onServiceConnected.onServiceConnected(this.componentName, iBinder);
        }
    }

    public void died() {
        if (!this.dead) {
            this.dead = true;
            MAIN_HANDLER.post(new ShizukuServiceConnection$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$died$1$rikka-shizuku-ShizukuServiceConnection  reason: not valid java name */
    public /* synthetic */ void m1781lambda$died$1$rikkashizukuShizukuServiceConnection() {
        for (ServiceConnection onServiceDisconnected : this.connections) {
            onServiceDisconnected.onServiceDisconnected(this.componentName);
        }
    }
}
