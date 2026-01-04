package rikka.shizuku;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SystemServiceHelper {
    private static final Map<String, IBinder> SYSTEM_SERVICE_CACHE = new HashMap();
    private static final Map<String, Integer> TRANSACT_CODE_CACHE = new HashMap();
    private static Method getService;

    static {
        try {
            getService = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.w("SystemServiceHelper", Log.getStackTraceString(e));
        }
    }

    public static IBinder getSystemService(String str) {
        IBinder iBinder = SYSTEM_SERVICE_CACHE.get(str);
        if (iBinder == null) {
            try {
                iBinder = (IBinder) getService.invoke((Object) null, new Object[]{str});
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.w("SystemServiceHelper", Log.getStackTraceString(e));
            }
            SYSTEM_SERVICE_CACHE.put(str, iBinder);
        }
        return iBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3 = r10.getDeclaredFields();
        r4 = r3.length;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r5 < r4) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r6 = r3[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        if (r6.getType() != java.lang.Integer.TYPE) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r7 = r6.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007b, code lost:
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095 A[ExcHandler: ClassNotFoundException | IllegalAccessException (r10v1 'e' java.lang.ReflectiveOperationException A[CUSTOM_DECLARE]), Splitter:B:4:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Integer getTransactionCode(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "TRANSACTION_"
            r0.<init>(r1)
            java.lang.StringBuilder r11 = r0.append(r11)
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r1 = "."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.util.Map<java.lang.String, java.lang.Integer> r1 = TRANSACT_CODE_CACHE
            java.lang.Object r1 = r1.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L_0x0031
            return r1
        L_0x0031:
            r1 = 0
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            r2 = 1
            java.lang.reflect.Field r11 = r10.getDeclaredField(r11)     // Catch:{ NoSuchFieldException -> 0x003c, ClassNotFoundException | IllegalAccessException -> 0x0095 }
            goto L_0x0081
        L_0x003c:
            java.lang.reflect.Field[] r3 = r10.getDeclaredFields()     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            int r4 = r3.length     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            r5 = 0
        L_0x0042:
            if (r5 >= r4) goto L_0x0080
            r6 = r3[r5]     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.Class r7 = r6.getType()     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            if (r7 == r8) goto L_0x004f
            goto L_0x007d
        L_0x004f:
            java.lang.String r7 = r6.getName()     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            r8.<init>()     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.String r9 = "_"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.String r8 = r8.toString()     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            boolean r8 = r7.startsWith(r8)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            if (r8 == 0) goto L_0x007d
            int r8 = r11.length()     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            int r8 = r8 + r2
            java.lang.String r7 = r7.substring(r8)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            boolean r7 = android.text.TextUtils.isDigitsOnly(r7)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            if (r7 == 0) goto L_0x007d
            r11 = r6
            goto L_0x0081
        L_0x007d:
            int r5 = r5 + 1
            goto L_0x0042
        L_0x0080:
            r11 = r1
        L_0x0081:
            if (r11 != 0) goto L_0x0084
            return r1
        L_0x0084:
            r11.setAccessible(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            int r10 = r11.getInt(r10)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            java.util.Map<java.lang.String, java.lang.Integer> r11 = TRANSACT_CODE_CACHE     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            r11.put(r0, r10)     // Catch:{ ClassNotFoundException | IllegalAccessException -> 0x0095 }
            return r10
        L_0x0095:
            r10 = move-exception
            r10.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: rikka.shizuku.SystemServiceHelper.getTransactionCode(java.lang.String, java.lang.String):java.lang.Integer");
    }

    public static Parcel obtainParcel(String str, String str2, String str3) {
        return obtainParcel(str, str2, str2 + "$Stub", str3);
    }

    public static Parcel obtainParcel(String str, String str2, String str3, String str4) {
        IBinder systemService = getSystemService(str);
        Integer transactionCode = getTransactionCode(str3, str4);
        Objects.requireNonNull(systemService, "can't find system service " + str);
        Objects.requireNonNull(transactionCode, "can't find transaction code of " + str4 + " in " + str3);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(ShizukuApiConstants.BINDER_DESCRIPTOR);
        obtain.writeStrongBinder(systemService);
        obtain.writeInt(transactionCode.intValue());
        obtain.writeInterfaceToken(str2);
        return obtain;
    }
}
