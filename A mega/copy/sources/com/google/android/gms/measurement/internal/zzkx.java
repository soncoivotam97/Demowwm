package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
public final class zzkx implements Parcelable.Creator {
    static void zza(zzkw zzkw, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, zzkw.zza);
        SafeParcelWriter.writeString(parcel, 2, zzkw.zzb, false);
        SafeParcelWriter.writeLong(parcel, 3, zzkw.zzc);
        SafeParcelWriter.writeLongObject(parcel, 4, zzkw.zzd, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, zzkw.zze, false);
        SafeParcelWriter.writeString(parcel, 7, zzkw.zzf, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, zzkw.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String str = null;
        Long l = null;
        Float f = null;
        String str2 = null;
        String str3 = null;
        Double d = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    l = SafeParcelReader.readLongObject(parcel, readHeader);
                    break;
                case 5:
                    f = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    d = SafeParcelReader.readDoubleObject(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzkw(i, str, j, l, f, str2, str3, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzkw[i];
    }
}
