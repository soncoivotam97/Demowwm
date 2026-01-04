package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final class zzfo extends zzgl {
    /* access modifiers changed from: private */
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzfn zzb;
    /* access modifiers changed from: private */
    public zzfn zzc;
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final BlockingQueue zze = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzf = new zzfl(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzg = new zzfl(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzh = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzi = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzj;

    zzfo(zzfr zzfr) {
        super(zzfr);
    }

    private final void zzt(zzfm zzfm) {
        synchronized (this.zzh) {
            this.zzd.add(zzfm);
            zzfn zzfn = this.zzb;
            if (zzfn == null) {
                zzfn zzfn2 = new zzfn(this, "Measurement Worker", this.zzd);
                this.zzb = zzfn2;
                zzfn2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzfn.zza();
            }
        }
    }

    public final void zzax() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2.zzt.zzay().zzk().zza("Timed out waiting for ".concat(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2 = r2.zzt.zzay().zzk();
        r2.zza("Interrupted waiting for " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r3 = r3.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r3 != null) goto L_0x0029;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(java.util.concurrent.atomic.AtomicReference r3, long r4, java.lang.String r6, java.lang.Runnable r7) {
        /*
            r2 = this;
            java.lang.String r0 = "Interrupted waiting for "
            monitor-enter(r3)
            com.google.android.gms.measurement.internal.zzfr r1 = r2.zzt     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzfo r1 = r1.zzaz()     // Catch:{ all -> 0x0046 }
            r1.zzp(r7)     // Catch:{ all -> 0x0046 }
            r3.wait(r4)     // Catch:{ InterruptedException -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            java.lang.Object r3 = r3.get()
            if (r3 != 0) goto L_0x0029
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r6)
            r2.zza(r4)
        L_0x0029:
            return r3
        L_0x002a:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r4.<init>(r0)     // Catch:{ all -> 0x0046 }
            r4.append(r6)     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0046 }
            r2.zza(r4)     // Catch:{ all -> 0x0046 }
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            r2 = 0
            return r2
        L_0x0046:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzfm zzfm = new zzfm(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                this.zzt.zzay().zzk().zza("Callable skipped the worker queue.");
            }
            zzfm.run();
        } else {
            zzt(zzfm);
        }
        return zzfm;
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzfm zzfm = new zzfm(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zzfm.run();
        } else {
            zzt(zzfm);
        }
        return zzfm;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzfm zzfm = new zzfm(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzfm);
            zzfn zzfn = this.zzc;
            if (zzfn == null) {
                zzfn zzfn2 = new zzfn(this, "Measurement Network", this.zze);
                this.zzc = zzfn2;
                zzfn2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                zzfn.zza();
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfm(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfm(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        return Thread.currentThread() == this.zzb;
    }
}
