package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    static {
        Method method;
        Method method2 = null;
        try {
            method = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, String.class, Integer.TYPE, String.class});
        } catch (NoSuchMethodException unused) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            }
            method = null;
        }
        zza = method;
        try {
            method2 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
        } catch (NoSuchMethodException unused2) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No myUserId method available");
            }
        }
        zzb = method2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[SYNTHETIC, Splitter:B:18:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r3, android.app.job.JobInfo r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r5 = r3.getSystemService(r5)
            android.app.job.JobScheduler r5 = (android.app.job.JobScheduler) r5
            r5.getClass()
            java.lang.reflect.Method r6 = zza
            if (r6 == 0) goto L_0x0066
            java.lang.String r6 = "android.permission.UPDATE_DEVICE_STATS"
            int r3 = r3.checkSelfPermission(r6)
            if (r3 == 0) goto L_0x0018
            goto L_0x0066
        L_0x0018:
            java.lang.reflect.Method r3 = zzb
            r6 = 0
            if (r3 == 0) goto L_0x003d
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            java.lang.Object r3 = r3.invoke(r0, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            if (r3 == 0) goto L_0x003d
            int r3 = r3.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            goto L_0x003e
        L_0x002e:
            r3 = move-exception
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r3)
        L_0x003d:
            r3 = r6
        L_0x003e:
            java.lang.reflect.Method r0 = zza
            java.lang.String r1 = "com.google.android.gms"
            java.lang.String r2 = "UploadAlarm"
            if (r0 == 0) goto L_0x0061
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005b }
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r1, r3, r2}     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005b }
            java.lang.Object r3 = r0.invoke(r5, r3)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005b }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005b }
            if (r3 == 0) goto L_0x0065
            int r6 = r3.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r3 = move-exception
            java.lang.String r6 = "error calling scheduleAsPackage"
            android.util.Log.e(r2, r6, r3)
        L_0x0061:
            int r6 = r5.schedule(r4)
        L_0x0065:
            return r6
        L_0x0066:
            int r3 = r5.schedule(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
