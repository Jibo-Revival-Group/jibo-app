package com.google.android.gms.internal;

import android.util.Log;
import java.util.AbstractMap;

/* JADX INFO: loaded from: classes.dex */
final class zzewf extends zzewg {

    /* JADX INFO: renamed from: a */
    private zzewy f7870a;

    zzewf(zzewy zzewyVar) {
        this.f7870a = zzewyVar;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8585a(zzewy zzewyVar) {
        if (zzewyVar.f7929d.length > 0) {
            return true;
        }
        for (zzewy zzewyVar2 : zzewyVar.f7930e) {
            if (zzewyVar2.f7929d.length > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean m8586a(com.google.android.gms.internal.zzewy r8, int r9) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            if (r8 != 0) goto Ld
            java.lang.String r0 = "FirebasePerformance"
            java.lang.String r2 = "TraceMetric is null"
            android.util.Log.w(r0, r2)
            r0 = r1
        Lc:
            return r0
        Ld:
            if (r9 <= r0) goto L18
            java.lang.String r0 = "FirebasePerformance"
            java.lang.String r2 = "Exceed MAX_SUBTRACE_DEEP:1"
            android.util.Log.w(r0, r2)
            r0 = r1
            goto Lc
        L18:
            java.lang.String r2 = r8.f7926a
            if (r2 == 0) goto L4a
            java.lang.String r2 = r2.trim()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L4a
            int r2 = r2.length()
            r3 = 100
            if (r2 > r3) goto L4a
            r2 = r0
        L2f:
            if (r2 != 0) goto L52
            java.lang.String r2 = "FirebasePerformance"
            java.lang.String r3 = "invalid TraceId:"
            java.lang.String r0 = r8.f7926a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L4c
            java.lang.String r0 = r3.concat(r0)
        L45:
            android.util.Log.w(r2, r0)
            r0 = r1
            goto Lc
        L4a:
            r2 = r1
            goto L2f
        L4c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            goto L45
        L52:
            if (r8 == 0) goto L92
            java.lang.Long r2 = r8.f7928c
            if (r2 == 0) goto L92
            java.lang.Long r2 = r8.f7928c
            long r2 = r2.longValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L92
            r2 = r0
        L65:
            if (r2 != 0) goto L94
            java.lang.String r0 = "FirebasePerformance"
            java.lang.Long r2 = r8.f7928c
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 22
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "invalid TraceDuration:"
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r0, r2)
            r0 = r1
            goto Lc
        L92:
            r2 = r1
            goto L65
        L94:
            java.lang.Long r2 = r8.f7927b
            if (r2 != 0) goto La2
            java.lang.String r0 = "FirebasePerformance"
            java.lang.String r2 = "clientStartTimeUs is null."
            android.util.Log.w(r0, r2)
            r0 = r1
            goto Lc
        La2:
            com.google.android.gms.internal.zzewy[] r3 = r8.f7930e
            int r4 = r3.length
            r2 = r1
        La6:
            if (r2 >= r4) goto Lb8
            r5 = r3[r2]
            int r6 = r9 + 1
            boolean r5 = r7.m8586a(r5, r6)
            if (r5 != 0) goto Lb5
            r0 = r1
            goto Lc
        Lb5:
            int r2 = r2 + 1
            goto La6
        Lb8:
            com.google.android.gms.internal.zzexa[] r2 = r8.f7931f
            if (r2 == 0) goto Lc
            com.google.android.gms.internal.zzexa[] r2 = r8.f7931f
            boolean r2 = m8587a(r2)
            if (r2 != 0) goto Lc
            r0 = r1
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzewf.m8586a(com.google.android.gms.internal.zzewy, int):boolean");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8587a(zzexa[] zzexaVarArr) {
        for (zzexa zzexaVar : zzexaVarArr) {
            String strM8589a = zzewg.m8589a(new AbstractMap.SimpleEntry(zzexaVar.f7937a, zzexaVar.f7938b));
            if (strM8589a != null) {
                Log.w("FirebasePerformance", strM8589a);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private final boolean m8588b(zzewy zzewyVar, int i) {
        boolean z;
        if (zzewyVar == null) {
            return false;
        }
        if (i > 1) {
            Log.w("FirebasePerformance", "Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (zzewz zzewzVar : zzewyVar.f7929d) {
            String str = zzewzVar.f7934a;
            if (str == null) {
                z = false;
            } else {
                String strTrim = str.trim();
                if (strTrim.isEmpty()) {
                    Log.w("FirebasePerformance", "counterId is empty");
                    z = false;
                } else if (strTrim.length() > 100) {
                    Log.w("FirebasePerformance", "counterId exceeded max length 100");
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z) {
                String strValueOf = String.valueOf(zzewzVar.f7934a);
                Log.w("FirebasePerformance", strValueOf.length() != 0 ? "invalid CounterId:".concat(strValueOf) : new String("invalid CounterId:"));
                return false;
            }
            Long l = zzewzVar.f7935b;
            if (!(l != null && l.longValue() >= 0)) {
                String strValueOf2 = String.valueOf(zzewzVar.f7935b);
                Log.w("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf2).length() + 21).append("invalid CounterValue:").append(strValueOf2).toString());
                return false;
            }
        }
        for (zzewy zzewyVar2 : zzewyVar.f7930e) {
            if (!m8588b(zzewyVar2, i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.zzewg
    /* JADX INFO: renamed from: a */
    public final boolean mo8560a() {
        if (!m8586a(this.f7870a, 0)) {
            String strValueOf = String.valueOf(this.f7870a.f7926a);
            Log.w("FirebasePerformance", strValueOf.length() != 0 ? "Invalid Trace:".concat(strValueOf) : new String("Invalid Trace:"));
            return false;
        }
        if (!m8585a(this.f7870a) || m8588b(this.f7870a, 0)) {
            return true;
        }
        String strValueOf2 = String.valueOf(this.f7870a.f7926a);
        Log.w("FirebasePerformance", strValueOf2.length() != 0 ? "Invalid Counters for Trace:".concat(strValueOf2) : new String("Invalid Counters for Trace:"));
        return false;
    }
}
