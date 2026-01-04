package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
public final class zzaz extends zzaw {
    protected zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    private static zzap zzc(zzg zzg, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzb = zzg.zzb((zzap) list.get(0));
        zzap zzb2 = zzg.zzb((zzap) list.get(1));
        if (zzb2 instanceof zzae) {
            List zzm = ((zzae) zzb2).zzm();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzao(zzb.zzi(), zzm, arrayList, zzg);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{zzb2.getClass().getCanonicalName()}));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0129, code lost:
        if (r7.equals("continue") == false) goto L_0x012d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r8, com.google.android.gms.internal.measurement.zzg r9, java.util.List r10) {
        /*
            r7 = this;
            com.google.android.gms.internal.measurement.zzbl r0 = com.google.android.gms.internal.measurement.zzbl.ADD
            com.google.android.gms.internal.measurement.zzbl r0 = com.google.android.gms.internal.measurement.zzh.zze(r8)
            int r0 = r0.ordinal()
            r1 = 3
            r2 = 1
            r3 = 2
            r4 = 0
            if (r0 == r3) goto L_0x0211
            r5 = 15
            if (r0 == r5) goto L_0x0205
            r5 = 25
            if (r0 == r5) goto L_0x0200
            r5 = 41
            if (r0 == r5) goto L_0x01ae
            r5 = 54
            if (r0 == r5) goto L_0x01a8
            r5 = 57
            java.lang.String r6 = "return"
            if (r0 == r5) goto L_0x0185
            r5 = 19
            if (r0 == r5) goto L_0x0164
            r5 = 20
            if (r0 == r5) goto L_0x0140
            r5 = 60
            if (r0 == r5) goto L_0x008b
            r5 = 61
            if (r0 == r5) goto L_0x0058
            switch(r0) {
                case 11: goto L_0x004a;
                case 12: goto L_0x003e;
                case 13: goto L_0x0164;
                default: goto L_0x0039;
            }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzap r7 = super.zzb(r8)
            return r7
        L_0x003e:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.BREAK
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r7, r4, r10)
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzi
            return r7
        L_0x004a:
            com.google.android.gms.internal.measurement.zzg r7 = r9.zza()
            com.google.android.gms.internal.measurement.zzae r8 = new com.google.android.gms.internal.measurement.zzae
            r8.<init>(r10)
            com.google.android.gms.internal.measurement.zzap r7 = r7.zzc(r8)
            return r7
        L_0x0058:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.TERNARY
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r7, r1, r10)
            java.lang.Object r7 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            java.lang.Boolean r7 = r7.zzg()
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0080
            java.lang.Object r7 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            goto L_0x008a
        L_0x0080:
            java.lang.Object r7 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
        L_0x008a:
            return r7
        L_0x008b:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.SWITCH
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r7, r1, r10)
            java.lang.Object r7 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            java.lang.Object r8 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r10 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.zzae
            if (r0 == 0) goto L_0x0138
            boolean r0 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r0 == 0) goto L_0x0130
            com.google.android.gms.internal.measurement.zzae r8 = (com.google.android.gms.internal.measurement.zzae) r8
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            r0 = r4
            r1 = r0
        L_0x00c0:
            int r3 = r8.zzc()
            if (r0 >= r3) goto L_0x00fb
            if (r1 != 0) goto L_0x00d9
            com.google.android.gms.internal.measurement.zzap r1 = r8.zze(r0)
            com.google.android.gms.internal.measurement.zzap r1 = r9.zzb(r1)
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r1 = r4
            goto L_0x00f8
        L_0x00d9:
            com.google.android.gms.internal.measurement.zzap r1 = r10.zze(r0)
            com.google.android.gms.internal.measurement.zzap r1 = r9.zzb(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r3 == 0) goto L_0x00f7
            r7 = r1
            com.google.android.gms.internal.measurement.zzag r7 = (com.google.android.gms.internal.measurement.zzag) r7
            java.lang.String r7 = r7.zzc()
            java.lang.String r8 = "break"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x012c
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzf
            return r7
        L_0x00f7:
            r1 = r2
        L_0x00f8:
            int r0 = r0 + 1
            goto L_0x00c0
        L_0x00fb:
            int r7 = r8.zzc()
            int r7 = r7 + r2
            int r0 = r10.zzc()
            if (r7 != r0) goto L_0x012d
            int r7 = r8.zzc()
            com.google.android.gms.internal.measurement.zzap r7 = r10.zze(r7)
            com.google.android.gms.internal.measurement.zzap r1 = r9.zzb(r7)
            boolean r7 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r7 == 0) goto L_0x012d
            r7 = r1
            com.google.android.gms.internal.measurement.zzag r7 = (com.google.android.gms.internal.measurement.zzag) r7
            java.lang.String r7 = r7.zzc()
            boolean r8 = r7.equals(r6)
            if (r8 != 0) goto L_0x012c
            java.lang.String r8 = "continue"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            return r1
        L_0x012d:
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzf
            return r7
        L_0x0130:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Malformed SWITCH statement, case statements are not a list"
            r7.<init>(r8)
            throw r7
        L_0x0138:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Malformed SWITCH statement, cases are not a list"
            r7.<init>(r8)
            throw r7
        L_0x0140:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.DEFINE_FUNCTION
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzi(r7, r3, r10)
            com.google.android.gms.internal.measurement.zzap r7 = zzc(r9, r10)
            r8 = r7
            com.google.android.gms.internal.measurement.zzai r8 = (com.google.android.gms.internal.measurement.zzai) r8
            java.lang.String r10 = r8.zzc()
            if (r10 != 0) goto L_0x015c
            java.lang.String r8 = ""
            r9.zzg(r8, r7)
            goto L_0x0163
        L_0x015c:
            java.lang.String r8 = r8.zzc()
            r9.zzg(r8, r7)
        L_0x0163:
            return r7
        L_0x0164:
            boolean r7 = r10.isEmpty()
            if (r7 == 0) goto L_0x016d
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0184
        L_0x016d:
            java.lang.Object r7 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            boolean r8 = r7 instanceof com.google.android.gms.internal.measurement.zzae
            if (r8 == 0) goto L_0x0182
            com.google.android.gms.internal.measurement.zzae r7 = (com.google.android.gms.internal.measurement.zzae) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzc(r7)
            goto L_0x0184
        L_0x0182:
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0184:
            return r7
        L_0x0185:
            boolean r7 = r10.isEmpty()
            if (r7 == 0) goto L_0x018e
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzj
            goto L_0x01a7
        L_0x018e:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.RETURN
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r7, r2, r10)
            java.lang.Object r7 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            com.google.android.gms.internal.measurement.zzag r8 = new com.google.android.gms.internal.measurement.zzag
            r8.<init>(r6, r7)
            r7 = r8
        L_0x01a7:
            return r7
        L_0x01a8:
            com.google.android.gms.internal.measurement.zzae r7 = new com.google.android.gms.internal.measurement.zzae
            r7.<init>(r10)
            return r7
        L_0x01ae:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.IF
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzi(r7, r3, r10)
            java.lang.Object r7 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            java.lang.Object r8 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            int r0 = r10.size()
            if (r0 <= r3) goto L_0x01dc
            java.lang.Object r10 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            goto L_0x01dd
        L_0x01dc:
            r10 = 0
        L_0x01dd:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            java.lang.Boolean r7 = r7.zzg()
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x01f0
            com.google.android.gms.internal.measurement.zzae r8 = (com.google.android.gms.internal.measurement.zzae) r8
            com.google.android.gms.internal.measurement.zzap r0 = r9.zzc(r8)
            goto L_0x01f8
        L_0x01f0:
            if (r10 == 0) goto L_0x01f8
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            com.google.android.gms.internal.measurement.zzap r0 = r9.zzc(r10)
        L_0x01f8:
            boolean r7 = r0 instanceof com.google.android.gms.internal.measurement.zzag
            if (r7 == 0) goto L_0x01fd
            return r0
        L_0x01fd:
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzf
            return r7
        L_0x0200:
            com.google.android.gms.internal.measurement.zzap r7 = zzc(r9, r10)
            return r7
        L_0x0205:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.BREAK
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r7, r4, r10)
            com.google.android.gms.internal.measurement.zzap r7 = com.google.android.gms.internal.measurement.zzap.zzh
            return r7
        L_0x0211:
            com.google.android.gms.internal.measurement.zzbl r7 = com.google.android.gms.internal.measurement.zzbl.APPLY
            java.lang.String r7 = r7.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r7, r1, r10)
            java.lang.Object r7 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r9.zzb(r7)
            java.lang.Object r8 = r10.get(r2)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.String r8 = r8.zzi()
            java.lang.Object r10 = r10.get(r3)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            boolean r0 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r0 == 0) goto L_0x0259
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0251
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            java.util.List r10 = r10.zzm()
            com.google.android.gms.internal.measurement.zzap r7 = r7.zzbR(r8, r9, r10)
            return r7
        L_0x0251:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Function name for apply is undefined"
            r7.<init>(r8)
            throw r7
        L_0x0259:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.Class r8 = r10.getClass()
            java.lang.String r8 = r8.getCanonicalName()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.String r9 = "Function arguments for Apply are not a list found %s"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaz.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
