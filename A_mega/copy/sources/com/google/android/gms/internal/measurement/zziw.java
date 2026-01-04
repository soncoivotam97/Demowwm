package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
final class zziw implements Comparator {
    zziw() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzje zzje = (zzje) obj;
        zzje zzje2 = (zzje) obj2;
        zziv zziv = new zziv(zzje);
        zziv zziv2 = new zziv(zzje2);
        while (zziv.hasNext() && zziv2.hasNext()) {
            int compareTo = Integer.valueOf(zziv.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zziv2.zza() & UByte.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzje.zzd()).compareTo(Integer.valueOf(zzje2.zzd()));
    }
}
