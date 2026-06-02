package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclw extends zzfjm<zzclw> {

    /* JADX INFO: renamed from: a */
    public Integer f7639a = null;

    /* JADX INFO: renamed from: b */
    public String f7640b = null;

    /* JADX INFO: renamed from: c */
    public Boolean f7641c = null;

    /* JADX INFO: renamed from: d */
    public String[] f7642d = zzfjv.f7975f;

    public zzclw() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        return r7;
     */
    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzclw mo8446a(com.google.android.gms.internal.zzfjj r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
        L1:
            int r0 = r8.m8621a()
            switch(r0) {
                case 0: goto Le;
                case 8: goto Lf;
                case 18: goto L44;
                case 24: goto L4b;
                case 34: goto L56;
                default: goto L8;
            }
        L8:
            boolean r0 = super.m8679a(r8, r0)
            if (r0 != 0) goto L1
        Le:
            return r7
        Lf:
            int r2 = r8.m8641m()
            int r3 = r8.m8636h()     // Catch: java.lang.IllegalArgumentException -> L35
            switch(r3) {
                case 0: goto L3d;
                case 1: goto L3d;
                case 2: goto L3d;
                case 3: goto L3d;
                case 4: goto L3d;
                case 5: goto L3d;
                case 6: goto L3d;
                default: goto L1a;
            }     // Catch: java.lang.IllegalArgumentException -> L35
        L1a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch: java.lang.IllegalArgumentException -> L35
            r5 = 41
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> L35
            r6.<init>(r5)     // Catch: java.lang.IllegalArgumentException -> L35
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch: java.lang.IllegalArgumentException -> L35
            java.lang.String r5 = " is not a valid enum MatchType"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.IllegalArgumentException -> L35
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalArgumentException -> L35
            r4.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L35
            throw r4     // Catch: java.lang.IllegalArgumentException -> L35
        L35:
            r3 = move-exception
            r8.m8633e(r2)
            r7.m8679a(r8, r0)
            goto L1
        L3d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.IllegalArgumentException -> L35
            r7.f7639a = r3     // Catch: java.lang.IllegalArgumentException -> L35
            goto L1
        L44:
            java.lang.String r0 = r8.m8632e()
            r7.f7640b = r0
            goto L1
        L4b:
            boolean r0 = r8.m8631d()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.f7641c = r0
            goto L1
        L56:
            r0 = 34
            int r2 = com.google.android.gms.internal.zzfjv.m8719a(r8, r0)
            java.lang.String[] r0 = r7.f7642d
            if (r0 != 0) goto L7c
            r0 = r1
        L61:
            int r2 = r2 + r0
            java.lang.String[] r2 = new java.lang.String[r2]
            if (r0 == 0) goto L6b
            java.lang.String[] r3 = r7.f7642d
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L6b:
            int r3 = r2.length
            int r3 = r3 + (-1)
            if (r0 >= r3) goto L80
            java.lang.String r3 = r8.m8632e()
            r2[r0] = r3
            r8.m8621a()
            int r0 = r0 + 1
            goto L6b
        L7c:
            java.lang.String[] r0 = r7.f7642d
            int r0 = r0.length
            goto L61
        L80:
            java.lang.String r3 = r8.m8632e()
            r2[r0] = r3
            r7.f7642d = r2
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclw.mo8446a(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzclw");
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7639a != null) {
            zzfjkVar.m8667a(1, this.f7639a.intValue());
        }
        if (this.f7640b != null) {
            zzfjkVar.m8670a(2, this.f7640b);
        }
        if (this.f7641c != null) {
            zzfjkVar.m8671a(3, this.f7641c.booleanValue());
        }
        if (this.f7642d != null && this.f7642d.length > 0) {
            for (int i = 0; i < this.f7642d.length; i++) {
                String str = this.f7642d[i];
                if (str != null) {
                    zzfjkVar.m8670a(4, str);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7639a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7639a.intValue());
        }
        if (this.f7640b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7640b);
        }
        if (this.f7641c != null) {
            this.f7641c.booleanValue();
            iMo8448b += zzfjk.m8650b(3) + 1;
        }
        if (this.f7642d == null || this.f7642d.length <= 0) {
            return iMo8448b;
        }
        int iM8646a = 0;
        int i = 0;
        for (int i2 = 0; i2 < this.f7642d.length; i2++) {
            String str = this.f7642d[i2];
            if (str != null) {
                i++;
                iM8646a += zzfjk.m8646a(str);
            }
        }
        return iMo8448b + iM8646a + (i * 1);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclw)) {
            return false;
        }
        zzclw zzclwVar = (zzclw) obj;
        if (this.f7639a == null) {
            if (zzclwVar.f7639a != null) {
                return false;
            }
        } else if (!this.f7639a.equals(zzclwVar.f7639a)) {
            return false;
        }
        if (this.f7640b == null) {
            if (zzclwVar.f7640b != null) {
                return false;
            }
        } else if (!this.f7640b.equals(zzclwVar.f7640b)) {
            return false;
        }
        if (this.f7641c == null) {
            if (zzclwVar.f7641c != null) {
                return false;
            }
        } else if (!this.f7641c.equals(zzclwVar.f7641c)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7642d, zzclwVar.f7642d)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzclwVar.f7951H == null || zzclwVar.f7951H.m8690b() : this.f7951H.equals(zzclwVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((this.f7641c == null ? 0 : this.f7641c.hashCode()) + (((this.f7640b == null ? 0 : this.f7640b.hashCode()) + (((this.f7639a == null ? 0 : this.f7639a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7642d)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
