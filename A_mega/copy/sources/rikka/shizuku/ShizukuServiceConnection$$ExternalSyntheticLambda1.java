package rikka.shizuku;

import android.os.IBinder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShizukuServiceConnection$$ExternalSyntheticLambda1 implements IBinder.DeathRecipient {
    public final /* synthetic */ ShizukuServiceConnection f$0;

    public /* synthetic */ ShizukuServiceConnection$$ExternalSyntheticLambda1(ShizukuServiceConnection shizukuServiceConnection) {
        this.f$0 = shizukuServiceConnection;
    }

    public final void binderDied() {
        this.f$0.died();
    }
}
