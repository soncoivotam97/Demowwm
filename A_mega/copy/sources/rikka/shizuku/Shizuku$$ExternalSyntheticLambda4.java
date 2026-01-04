package rikka.shizuku;

import rikka.shizuku.Shizuku;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Shizuku$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ Shizuku.OnBinderReceivedListener f$0;

    public /* synthetic */ Shizuku$$ExternalSyntheticLambda4(Shizuku.OnBinderReceivedListener onBinderReceivedListener) {
        this.f$0 = onBinderReceivedListener;
    }

    public final void run() {
        this.f$0.onBinderReceived();
    }
}
