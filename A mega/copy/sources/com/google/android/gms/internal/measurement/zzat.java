package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzat implements Iterable, zzap {
    /* access modifiers changed from: private */
    public final String zza;

    public zzat(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.zza.equals(((zzat) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        String str = this.zza;
        return "\"" + str + "\"";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0186, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0187, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r20.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x019b, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r20.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01b1, code lost:
        r0 = r20;
        com.google.android.gms.internal.measurement.zzh.zzh(r6, 0, r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01bb, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLowerCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r20.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d1, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLocaleLowerCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r20.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e6, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r5, 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r20.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fc, code lost:
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("substring", 2, r1);
        r0 = r20.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x020b, code lost:
        if (r23.isEmpty() != false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x020d, code lost:
        r3 = r22;
        r2 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0227, code lost:
        r3 = r22;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x022f, code lost:
        if (r23.size() <= 1) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0231, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0249, code lost:
        r1 = r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024d, code lost:
        r2 = java.lang.Math.min(java.lang.Math.max(r2, 0), r0.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r0.length());
        r3 = new com.google.android.gms.internal.measurement.zzat(r0.substring(java.lang.Math.min(r2, r1), java.lang.Math.max(r2, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0279, code lost:
        r0 = r20;
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("split", 2, r1);
        r2 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0289, code lost:
        if (r2.length() != 0) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x028b, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x029c, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02a6, code lost:
        if (r23.isEmpty() == false) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02a8, code lost:
        r5.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02ad, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02c0, code lost:
        if (r23.size() <= 1) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c2, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zzd(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02d9, code lost:
        r3 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02e0, code lost:
        if (r3 != 0) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02e9, code lost:
        r1 = r2.split(java.util.regex.Pattern.quote(r0), ((int) r3) + 1);
        r2 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02f9, code lost:
        if (r0.isEmpty() == false) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02fb, code lost:
        if (r2 <= 0) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02fd, code lost:
        r6 = r2 - 1;
        r16 = r1[0].isEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x030e, code lost:
        if (r1[r6].isEmpty() != false) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0310, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0312, code lost:
        r6 = r2;
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0318, code lost:
        if (((long) r2) <= r3) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x031a, code lost:
        r6 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x031c, code lost:
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x031e, code lost:
        if (r0 >= r6) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0320, code lost:
        r5.add(new com.google.android.gms.internal.measurement.zzat(r1[r0]));
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0334, code lost:
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r1);
        r0 = r20.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0344, code lost:
        if (r23.isEmpty() != false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0346, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x035a, code lost:
        r4 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x035c, code lost:
        r4 = com.google.android.gms.internal.measurement.zzh.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0364, code lost:
        if (r4 >= 0.0d) goto L_0x0371;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0366, code lost:
        r4 = java.lang.Math.max(((double) r0.length()) + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0371, code lost:
        r4 = java.lang.Math.min(r4, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x037a, code lost:
        r2 = (int) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0380, code lost:
        if (r23.size() <= 1) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0382, code lost:
        r3 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0395, code lost:
        r3 = (double) r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x039a, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03a2, code lost:
        if (r3 >= 0.0d) goto L_0x03af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a4, code lost:
        r3 = java.lang.Math.max(((double) r0.length()) + r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03af, code lost:
        r3 = java.lang.Math.min(r3, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b8, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzat(r0.substring(r2, java.lang.Math.max(0, ((int) r3) - r2) + r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03cb, code lost:
        r0 = r20;
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj(com.google.firebase.analytics.FirebaseAnalytics.Event.SEARCH, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03da, code lost:
        if (r23.isEmpty() != false) goto L_0x03ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03dc, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03ea, code lost:
        r0 = java.util.regex.Pattern.compile(r17).matcher(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03f8, code lost:
        if (r0.find() == false) goto L_0x040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03fa, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0417, code lost:
        r0 = r20;
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("replace", 2, r1);
        r2 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0427, code lost:
        if (r23.isEmpty() != false) goto L_0x0449;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0429, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x043d, code lost:
        if (r23.size() <= 1) goto L_0x0449;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x043f, code lost:
        r2 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0449, code lost:
        r1 = r17;
        r4 = r0.zza;
        r5 = r4.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0451, code lost:
        if (r5 < 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0455, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x047c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0457, code lost:
        r2 = ((com.google.android.gms.internal.measurement.zzai) r2).zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r1), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r5)), r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04a7, code lost:
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("match", 1, r1);
        r0 = r20.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x04b7, code lost:
        if (r23.size() > 0) goto L_0x04bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x04b9, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04bc, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04cb, code lost:
        r0 = java.util.regex.Pattern.compile(r1).matcher(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x04d7, code lost:
        if (r0.find() == false) goto L_0x04f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x04d9, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r0.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04f7, code lost:
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r1);
        r0 = r20.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0508, code lost:
        if (r23.size() > 0) goto L_0x050b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x050b, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0519, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x051f, code lost:
        if (r23.size() >= 2) goto L_0x0524;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0521, code lost:
        r1 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0524, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x053b, code lost:
        if (java.lang.Double.isNaN(r1) == false) goto L_0x0540;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x053d, code lost:
        r1 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0540, code lost:
        r1 = com.google.android.gms.internal.measurement.zzh.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0544, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0.lastIndexOf(r4, (int) r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0554, code lost:
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r1);
        r0 = r20.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0566, code lost:
        if (r23.size() > 0) goto L_0x0569;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0569, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0578, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x057e, code lost:
        if (r23.size() >= 2) goto L_0x0582;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0580, code lost:
        r1 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0582, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0595, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0.indexOf(r4, (int) com.google.android.gms.internal.measurement.zzh.zza(r1))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x05ab, code lost:
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzh(r19, 1, r1);
        r0 = r20.zza;
        r1 = r22.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05ce, code lost:
        if ("length".equals(r1.zzi()) == false) goto L_0x05d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05d4, code lost:
        r1 = r1.zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05e2, code lost:
        if (r1 != java.lang.Math.floor(r1)) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x05e4, code lost:
        r1 = (int) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x05e5, code lost:
        if (r1 < 0) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x05eb, code lost:
        if (r1 >= r0.length()) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x05f5, code lost:
        r0 = r20;
        r3 = r22;
        r1 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x05ff, code lost:
        if (r23.isEmpty() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0601, code lost:
        r2 = new java.lang.StringBuilder(r0.zza);
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x060d, code lost:
        if (r0 >= r23.size()) goto L_0x0623;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x060f, code lost:
        r2.append(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(r0)).zzi());
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x062d, code lost:
        r0 = r20;
        r3 = r22;
        r1 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj(r18, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x063d, code lost:
        if (r23.isEmpty() != false) goto L_0x0658;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x063f, code lost:
        r3 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0658, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x065a, code lost:
        r0 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x065c, code lost:
        if (r3 < 0) goto L_0x0674;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0662, code lost:
        if (r3 < r0.length()) goto L_0x0665;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0665, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzat(java.lang.String.valueOf(r0.charAt(r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r4.substring(0, r5) + r2.zzi() + r4.substring(r5 + r1.length()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return com.google.android.gms.internal.measurement.zzaf.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return com.google.android.gms.internal.measurement.zzaf.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return com.google.android.gms.internal.measurement.zzaf.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        r3 = r17;
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0127, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0150, code lost:
        r3 = r17;
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0175, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0176, code lost:
        r17 = "undefined";
        r19 = r3;
        r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x017c, code lost:
        switch(r1) {
            case 0: goto L_0x062d;
            case 1: goto L_0x05f5;
            case 2: goto L_0x05ab;
            case 3: goto L_0x0554;
            case 4: goto L_0x04f7;
            case 5: goto L_0x04a7;
            case 6: goto L_0x0417;
            case 7: goto L_0x03cb;
            case 8: goto L_0x0334;
            case 9: goto L_0x0279;
            case 10: goto L_0x01fc;
            case 11: goto L_0x01e6;
            case 12: goto L_0x01d1;
            case 13: goto L_0x01bb;
            case 14: goto L_0x01b1;
            case 15: goto L_0x019b;
            case 16: goto L_0x0187;
            default: goto L_0x017f;
        };
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zzbR(java.lang.String r21, com.google.android.gms.internal.measurement.zzg r22, java.util.List r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "concat"
            java.lang.String r7 = "indexOf"
            java.lang.String r8 = "replace"
            java.lang.String r9 = "substring"
            java.lang.String r10 = "split"
            java.lang.String r11 = "slice"
            java.lang.String r12 = "match"
            java.lang.String r13 = "lastIndexOf"
            java.lang.String r14 = "toLocaleUpperCase"
            java.lang.String r15 = "search"
            java.lang.String r2 = "toLowerCase"
            java.lang.String r0 = "toLocaleLowerCase"
            java.lang.String r3 = "toString"
            r16 = r4
            java.lang.String r4 = "hasOwnProperty"
            r17 = r14
            java.lang.String r14 = "toUpperCase"
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r7.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r13.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r12.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r8.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r15.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r11.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r10.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r9.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r2.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r0.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r3.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r14.equals(r1)
            if (r5 != 0) goto L_0x00a9
            r5 = r17
            boolean r17 = r5.equals(r1)
            if (r17 != 0) goto L_0x00ab
            r17 = r4
            java.lang.String r4 = "trim"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0099
            goto L_0x00ad
        L_0x0099:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[]{r21}
            java.lang.String r2 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x00a9:
            r5 = r17
        L_0x00ab:
            r17 = r4
        L_0x00ad:
            int r4 = r21.hashCode()
            r18 = r3
            switch(r4) {
                case -1789698943: goto L_0x0167;
                case -1776922004: goto L_0x0155;
                case -1464939364: goto L_0x0146;
                case -1361633751: goto L_0x0138;
                case -1354795244: goto L_0x012a;
                case -1137582698: goto L_0x011f;
                case -906336856: goto L_0x0117;
                case -726908483: goto L_0x010e;
                case -467511597: goto L_0x0106;
                case -399551817: goto L_0x00fd;
                case 3568674: goto L_0x00f2;
                case 103668165: goto L_0x00ea;
                case 109526418: goto L_0x00e1;
                case 109648666: goto L_0x00d8;
                case 530542161: goto L_0x00cf;
                case 1094496948: goto L_0x00c7;
                case 1943291465: goto L_0x00be;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            r4 = r16
        L_0x00b8:
            r3 = r17
            r6 = r18
            goto L_0x0175
        L_0x00be:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00b6
            r1 = 3
            goto L_0x0127
        L_0x00c7:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00b6
            r1 = 6
            goto L_0x0127
        L_0x00cf:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00b6
            r1 = 10
            goto L_0x0127
        L_0x00d8:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00b6
            r1 = 9
            goto L_0x0127
        L_0x00e1:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00b6
            r1 = 8
            goto L_0x0127
        L_0x00ea:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00b6
            r1 = 5
            goto L_0x0127
        L_0x00f2:
            java.lang.String r4 = "trim"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00b6
            r1 = 16
            goto L_0x0127
        L_0x00fd:
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00b6
            r1 = 15
            goto L_0x0127
        L_0x0106:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00b6
            r1 = 4
            goto L_0x0127
        L_0x010e:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00b6
            r1 = 11
            goto L_0x0127
        L_0x0117:
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00b6
            r1 = 7
            goto L_0x0127
        L_0x011f:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00b6
            r1 = 13
        L_0x0127:
            r4 = r16
            goto L_0x0150
        L_0x012a:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00b6
            r4 = r16
            r3 = r17
            r6 = r18
            r1 = 1
            goto L_0x0176
        L_0x0138:
            r4 = r16
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00b8
            r3 = r17
            r6 = r18
            r1 = 0
            goto L_0x0176
        L_0x0146:
            r4 = r16
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 12
        L_0x0150:
            r3 = r17
            r6 = r18
            goto L_0x0176
        L_0x0155:
            r4 = r16
            r6 = r18
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0164
            r1 = 14
            r3 = r17
            goto L_0x0176
        L_0x0164:
            r3 = r17
            goto L_0x0175
        L_0x0167:
            r4 = r16
            r3 = r17
            r6 = r18
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0175
            r1 = 2
            goto L_0x0176
        L_0x0175:
            r1 = -1
        L_0x0176:
            java.lang.String r17 = "undefined"
            r19 = r3
            r18 = r4
            switch(r1) {
                case 0: goto L_0x062d;
                case 1: goto L_0x05f5;
                case 2: goto L_0x05ab;
                case 3: goto L_0x0554;
                case 4: goto L_0x04f7;
                case 5: goto L_0x04a7;
                case 6: goto L_0x0417;
                case 7: goto L_0x03cb;
                case 8: goto L_0x0334;
                case 9: goto L_0x0279;
                case 10: goto L_0x01fc;
                case 11: goto L_0x01e6;
                case 12: goto L_0x01d1;
                case 13: goto L_0x01bb;
                case 14: goto L_0x01b1;
                case 15: goto L_0x019b;
                case 16: goto L_0x0187;
                default: goto L_0x017f;
            }
        L_0x017f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0187:
            r1 = r23
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r3, r1)
            r0 = r20
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
            goto L_0x01f9
        L_0x019b:
            r3 = 0
            r0 = r20
            r1 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r3, r1)
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            goto L_0x01f9
        L_0x01b1:
            r3 = 0
            r0 = r20
            r1 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r3, r1)
            goto L_0x0676
        L_0x01bb:
            r3 = 0
            r0 = r20
            r1 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            goto L_0x01f9
        L_0x01d1:
            r3 = 0
            r1 = r23
            r2 = r0
            r0 = r20
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            goto L_0x01f9
        L_0x01e6:
            r3 = 0
            r0 = r20
            r1 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r5, r3, r1)
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
        L_0x01f9:
            r0 = r1
            goto L_0x0676
        L_0x01fc:
            r0 = r20
            r1 = r23
            r2 = 2
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r9, r2, r1)
            java.lang.String r0 = r0.zza
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x0227
            java.lang.Object r2 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            r3 = r22
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            java.lang.Double r2 = r2.zzh()
            double r4 = r2.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            int r2 = (int) r4
            goto L_0x022a
        L_0x0227:
            r3 = r22
            r2 = 0
        L_0x022a:
            int r4 = r23.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0249
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            int r1 = (int) r3
            goto L_0x024d
        L_0x0249:
            int r1 = r0.length()
        L_0x024d:
            r3 = 0
            int r2 = java.lang.Math.max(r2, r3)
            int r4 = r0.length()
            int r2 = java.lang.Math.min(r2, r4)
            int r1 = java.lang.Math.max(r1, r3)
            int r3 = r0.length()
            int r1 = java.lang.Math.min(r1, r3)
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            int r4 = java.lang.Math.min(r2, r1)
            int r1 = java.lang.Math.max(r2, r1)
            java.lang.String r0 = r0.substring(r4, r1)
            r3.<init>(r0)
            goto L_0x05a8
        L_0x0279:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r2, r1)
            java.lang.String r2 = r0.zza
            int r4 = r2.length()
            if (r4 != 0) goto L_0x029c
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r2 = 1
            com.google.android.gms.internal.measurement.zzap[] r2 = new com.google.android.gms.internal.measurement.zzap[r2]
            r4 = 0
            r2[r4] = r0
            java.util.List r0 = java.util.Arrays.asList(r2)
            r1.<init>(r0)
            goto L_0x01f9
        L_0x029c:
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r6 = r23.isEmpty()
            if (r6 == 0) goto L_0x02ad
            r5.add(r0)
            goto L_0x032d
        L_0x02ad:
            java.lang.Object r0 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.String r0 = r0.zzi()
            int r4 = r23.size()
            r6 = 1
            if (r4 <= r6) goto L_0x02d9
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            long r3 = com.google.android.gms.internal.measurement.zzh.zzd(r3)
            goto L_0x02dc
        L_0x02d9:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02dc:
            r6 = 0
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x02e9
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x0676
        L_0x02e9:
            java.lang.String r1 = java.util.regex.Pattern.quote(r0)
            int r6 = (int) r3
            r7 = 1
            int r6 = r6 + r7
            java.lang.String[] r1 = r2.split(r1, r6)
            int r2 = r1.length
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0312
            if (r2 <= 0) goto L_0x0312
            r0 = 0
            r0 = r1[r0]
            boolean r0 = r0.isEmpty()
            int r6 = r2 + -1
            r7 = r1[r6]
            boolean r7 = r7.isEmpty()
            r16 = r0
            if (r7 != 0) goto L_0x0315
            r6 = r2
            goto L_0x0315
        L_0x0312:
            r6 = r2
            r16 = 0
        L_0x0315:
            long r7 = (long) r2
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x031c
            int r6 = r6 + -1
        L_0x031c:
            r0 = r16
        L_0x031e:
            if (r0 >= r6) goto L_0x032d
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            r3 = r1[r0]
            r2.<init>(r3)
            r5.add(r2)
            int r0 = r0 + 1
            goto L_0x031e
        L_0x032d:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>(r5)
            goto L_0x0676
        L_0x0334:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r11, r2, r1)
            java.lang.String r0 = r0.zza
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x035a
            r2 = 0
            java.lang.Object r4 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r4)
            java.lang.Double r2 = r2.zzh()
            double r4 = r2.doubleValue()
            goto L_0x035c
        L_0x035a:
            r4 = 0
        L_0x035c:
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0371
            int r2 = r0.length()
            double r8 = (double) r2
            double r8 = r8 + r4
            double r4 = java.lang.Math.max(r8, r6)
            goto L_0x037a
        L_0x0371:
            int r2 = r0.length()
            double r6 = (double) r2
            double r4 = java.lang.Math.min(r4, r6)
        L_0x037a:
            int r2 = (int) r4
            int r4 = r23.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0395
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            goto L_0x039a
        L_0x0395:
            int r1 = r0.length()
            double r3 = (double) r1
        L_0x039a:
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x03af
            int r1 = r0.length()
            double r7 = (double) r1
            double r7 = r7 + r3
            double r3 = java.lang.Math.max(r7, r5)
            goto L_0x03b8
        L_0x03af:
            int r1 = r0.length()
            double r5 = (double) r1
            double r3 = java.lang.Math.min(r3, r5)
        L_0x03b8:
            int r1 = (int) r3
            int r1 = r1 - r2
            r4 = 0
            int r1 = java.lang.Math.max(r4, r1)
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r2, r1)
            r3.<init>(r0)
            goto L_0x05a8
        L_0x03cb:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = 1
            r4 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r2, r1)
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x03ea
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.String r17 = r1.zzi()
        L_0x03ea:
            java.lang.String r0 = r0.zza
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r17)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x040a
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r0 = r0.start()
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x01f9
        L_0x040a:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x0676
        L_0x0417:
            r2 = 2
            r0 = r20
            r3 = r22
            r1 = r23
            com.google.android.gms.internal.measurement.zzh.zzj(r8, r2, r1)
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r4 = r23.isEmpty()
            if (r4 != 0) goto L_0x0449
            r4 = 0
            java.lang.Object r5 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r5)
            java.lang.String r17 = r4.zzi()
            int r4 = r23.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0449
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r1)
        L_0x0449:
            r1 = r17
            java.lang.String r4 = r0.zza
            int r5 = r4.indexOf(r1)
            if (r5 < 0) goto L_0x0676
            boolean r6 = r2 instanceof com.google.android.gms.internal.measurement.zzai
            if (r6 == 0) goto L_0x047c
            com.google.android.gms.internal.measurement.zzai r2 = (com.google.android.gms.internal.measurement.zzai) r2
            r6 = 3
            com.google.android.gms.internal.measurement.zzap[] r6 = new com.google.android.gms.internal.measurement.zzap[r6]
            com.google.android.gms.internal.measurement.zzat r7 = new com.google.android.gms.internal.measurement.zzat
            r7.<init>(r1)
            r8 = 0
            r6[r8] = r7
            com.google.android.gms.internal.measurement.zzah r7 = new com.google.android.gms.internal.measurement.zzah
            double r8 = (double) r5
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 1
            r6[r8] = r7
            r7 = 2
            r6[r7] = r0
            java.util.List r0 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzap r2 = r2.zza(r3, r0)
        L_0x047c:
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            r3 = 0
            java.lang.String r3 = r4.substring(r3, r5)
            java.lang.String r2 = r2.zzi()
            int r1 = r1.length()
            int r5 = r5 + r1
            java.lang.String r1 = r4.substring(r5)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            goto L_0x0676
        L_0x04a7:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r12, r2, r1)
            java.lang.String r0 = r0.zza
            int r2 = r23.size()
            if (r2 > 0) goto L_0x04bc
            java.lang.String r1 = ""
            goto L_0x04cb
        L_0x04bc:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.String r1 = r1.zzi()
        L_0x04cb:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x04f3
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r2 = 1
            com.google.android.gms.internal.measurement.zzap[] r2 = new com.google.android.gms.internal.measurement.zzap[r2]
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.group()
            r3.<init>(r0)
            r4 = 0
            r2[r4] = r3
            java.util.List r0 = java.util.Arrays.asList(r2)
            r1.<init>(r0)
            goto L_0x01f9
        L_0x04f3:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzg
            goto L_0x0676
        L_0x04f7:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = 2
            r4 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r13, r2, r1)
            java.lang.String r0 = r0.zza
            int r5 = r23.size()
            if (r5 > 0) goto L_0x050b
            goto L_0x0519
        L_0x050b:
            java.lang.Object r4 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.String r17 = r4.zzi()
        L_0x0519:
            r4 = r17
            int r5 = r23.size()
            if (r5 >= r2) goto L_0x0524
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0537
        L_0x0524:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
        L_0x0537:
            boolean r3 = java.lang.Double.isNaN(r1)
            if (r3 == 0) goto L_0x0540
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x0544
        L_0x0540:
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
        L_0x0544:
            com.google.android.gms.internal.measurement.zzah r3 = new com.google.android.gms.internal.measurement.zzah
            int r1 = (int) r1
            int r0 = r0.lastIndexOf(r4, r1)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3.<init>(r0)
            goto L_0x05a8
        L_0x0554:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = 2
            r5 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r2, r1)
            java.lang.String r0 = r0.zza
            int r4 = r23.size()
            if (r4 > 0) goto L_0x0569
            goto L_0x0578
        L_0x0569:
            r4 = 0
            java.lang.Object r4 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.String r17 = r4.zzi()
        L_0x0578:
            r4 = r17
            int r7 = r23.size()
            if (r7 >= r2) goto L_0x0582
            r1 = r5
            goto L_0x0595
        L_0x0582:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
        L_0x0595:
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
            com.google.android.gms.internal.measurement.zzah r3 = new com.google.android.gms.internal.measurement.zzah
            int r1 = (int) r1
            int r0 = r0.indexOf(r4, r1)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3.<init>(r0)
        L_0x05a8:
            r0 = r3
            goto L_0x0676
        L_0x05ab:
            r0 = r20
            r3 = r22
            r1 = r23
            r2 = r19
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r4, r1)
            java.lang.String r0 = r0.zza
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.String r2 = "length"
            java.lang.String r3 = r1.zzi()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x05d4
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzaf.zzk
            goto L_0x0676
        L_0x05d4:
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
            double r3 = java.lang.Math.floor(r1)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x05f1
            int r1 = (int) r1
            if (r1 < 0) goto L_0x05f1
            int r0 = r0.length()
            if (r1 >= r0) goto L_0x05f1
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzaf.zzk
            goto L_0x0676
        L_0x05f1:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzaf.zzl
            goto L_0x0676
        L_0x05f5:
            r0 = r20
            r3 = r22
            r1 = r23
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x0676
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = r0.zza
            r2.<init>(r0)
            r0 = 0
        L_0x0609:
            int r4 = r23.size()
            if (r0 >= r4) goto L_0x0623
            java.lang.Object r4 = r1.get(r0)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.String r4 = r4.zzi()
            r2.append(r4)
            int r0 = r0 + 1
            goto L_0x0609
        L_0x0623:
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            goto L_0x0676
        L_0x062d:
            r0 = r20
            r3 = r22
            r1 = r23
            r4 = r18
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r4, r2, r1)
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x0658
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
            int r3 = (int) r1
            goto L_0x065a
        L_0x0658:
            r2 = 0
            r3 = r2
        L_0x065a:
            java.lang.String r0 = r0.zza
            if (r3 < 0) goto L_0x0674
            int r1 = r0.length()
            if (r3 < r1) goto L_0x0665
            goto L_0x0674
        L_0x0665:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            char r0 = r0.charAt(r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r0)
            goto L_0x01f9
        L_0x0674:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzm
        L_0x0676:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbR(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public final zzap zzd() {
        return new zzat(this.zza);
    }

    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzi() {
        return this.zza;
    }

    public final Iterator zzl() {
        return new zzar(this);
    }
}
