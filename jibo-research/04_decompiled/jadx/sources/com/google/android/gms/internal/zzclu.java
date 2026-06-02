package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclu extends zzfjm<zzclu> {

    /* JADX INFO: renamed from: a */
    public Integer f7630a = null;

    /* JADX INFO: renamed from: b */
    public Boolean f7631b = null;

    /* JADX INFO: renamed from: c */
    public String f7632c = null;

    /* JADX INFO: renamed from: d */
    public String f7633d = null;

    /* JADX INFO: renamed from: e */
    public String f7634e = null;

    public zzclu() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        return r6;
     */
    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzclu mo8446a(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
        /*
            r6 = this;
        L0:
            int r0 = r7.m8621a()
            switch(r0) {
                case 0: goto Ld;
                case 8: goto Le;
                case 16: goto L43;
                case 26: goto L4e;
                case 34: goto L55;
                case 42: goto L5c;
                default: goto L7;
            }
        L7:
            boolean r0 = super.m8679a(r7, r0)
            if (r0 != 0) goto L0
        Ld:
            return r6
        Le:
            int r1 = r7.m8641m()
            int r2 = r7.m8636h()     // Catch: java.lang.IllegalArgumentException -> L34
            switch(r2) {
                case 0: goto L3c;
                case 1: goto L3c;
                case 2: goto L3c;
                case 3: goto L3c;
                case 4: goto L3c;
                default: goto L19;
            }     // Catch: java.lang.IllegalArgumentException -> L34
        L19:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch: java.lang.IllegalArgumentException -> L34
            r4 = 46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> L34
            r5.<init>(r4)     // Catch: java.lang.IllegalArgumentException -> L34
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.IllegalArgumentException -> L34
            java.lang.String r4 = " is not a valid enum ComparisonType"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.IllegalArgumentException -> L34
            java.lang.String r2 = r2.toString()     // Catch: java.lang.IllegalArgumentException -> L34
            r3.<init>(r2)     // Catch: java.lang.IllegalArgumentException -> L34
            throw r3     // Catch: java.lang.IllegalArgumentException -> L34
        L34:
            r2 = move-exception
            r7.m8633e(r1)
            r6.m8679a(r7, r0)
            goto L0
        L3c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.IllegalArgumentException -> L34
            r6.f7630a = r2     // Catch: java.lang.IllegalArgumentException -> L34
            goto L0
        L43:
            boolean r0 = r7.m8631d()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.f7631b = r0
            goto L0
        L4e:
            java.lang.String r0 = r7.m8632e()
            r6.f7632c = r0
            goto L0
        L55:
            java.lang.String r0 = r7.m8632e()
            r6.f7633d = r0
            goto L0
        L5c:
            java.lang.String r0 = r7.m8632e()
            r6.f7634e = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclu.mo8446a(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzclu");
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7630a != null) {
            zzfjkVar.m8667a(1, this.f7630a.intValue());
        }
        if (this.f7631b != null) {
            zzfjkVar.m8671a(2, this.f7631b.booleanValue());
        }
        if (this.f7632c != null) {
            zzfjkVar.m8670a(3, this.f7632c);
        }
        if (this.f7633d != null) {
            zzfjkVar.m8670a(4, this.f7633d);
        }
        if (this.f7634e != null) {
            zzfjkVar.m8670a(5, this.f7634e);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7630a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7630a.intValue());
        }
        if (this.f7631b != null) {
            this.f7631b.booleanValue();
            iMo8448b += zzfjk.m8650b(2) + 1;
        }
        if (this.f7632c != null) {
            iMo8448b += zzfjk.m8653b(3, this.f7632c);
        }
        if (this.f7633d != null) {
            iMo8448b += zzfjk.m8653b(4, this.f7633d);
        }
        return this.f7634e != null ? iMo8448b + zzfjk.m8653b(5, this.f7634e) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclu)) {
            return false;
        }
        zzclu zzcluVar = (zzclu) obj;
        if (this.f7630a == null) {
            if (zzcluVar.f7630a != null) {
                return false;
            }
        } else if (!this.f7630a.equals(zzcluVar.f7630a)) {
            return false;
        }
        if (this.f7631b == null) {
            if (zzcluVar.f7631b != null) {
                return false;
            }
        } else if (!this.f7631b.equals(zzcluVar.f7631b)) {
            return false;
        }
        if (this.f7632c == null) {
            if (zzcluVar.f7632c != null) {
                return false;
            }
        } else if (!this.f7632c.equals(zzcluVar.f7632c)) {
            return false;
        }
        if (this.f7633d == null) {
            if (zzcluVar.f7633d != null) {
                return false;
            }
        } else if (!this.f7633d.equals(zzcluVar.f7633d)) {
            return false;
        }
        if (this.f7634e == null) {
            if (zzcluVar.f7634e != null) {
                return false;
            }
        } else if (!this.f7634e.equals(zzcluVar.f7634e)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzcluVar.f7951H == null || zzcluVar.f7951H.m8690b() : this.f7951H.equals(zzcluVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7634e == null ? 0 : this.f7634e.hashCode()) + (((this.f7633d == null ? 0 : this.f7633d.hashCode()) + (((this.f7632c == null ? 0 : this.f7632c.hashCode()) + (((this.f7631b == null ? 0 : this.f7631b.hashCode()) + (((this.f7630a == null ? 0 : this.f7630a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
