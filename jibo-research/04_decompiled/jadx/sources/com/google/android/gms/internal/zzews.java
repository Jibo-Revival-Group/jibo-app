package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzews extends zzfjm<zzews> {

    /* JADX INFO: renamed from: a */
    public String f7894a = null;

    /* JADX INFO: renamed from: b */
    public String f7895b = null;

    /* JADX INFO: renamed from: c */
    public zzewr f7896c = null;

    /* JADX INFO: renamed from: f */
    private zzewu f7899f = null;

    /* JADX INFO: renamed from: d */
    public Integer f7897d = null;

    /* JADX INFO: renamed from: e */
    public zzewt[] f7898e = zzewt.m8609a();

    public zzews() {
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
    public final com.google.android.gms.internal.zzews mo8446a(com.google.android.gms.internal.zzfjj r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzews.mo8446a(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzews");
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7894a != null) {
            zzfjkVar.m8670a(1, this.f7894a);
        }
        if (this.f7895b != null) {
            zzfjkVar.m8670a(2, this.f7895b);
        }
        if (this.f7896c != null) {
            zzfjkVar.m8669a(3, this.f7896c);
        }
        if (this.f7899f != null) {
            zzfjkVar.m8669a(4, this.f7899f);
        }
        if (this.f7897d != null) {
            zzfjkVar.m8667a(5, this.f7897d.intValue());
        }
        if (this.f7898e != null && this.f7898e.length > 0) {
            for (int i = 0; i < this.f7898e.length; i++) {
                zzewt zzewtVar = this.f7898e[i];
                if (zzewtVar != null) {
                    zzfjkVar.m8669a(6, zzewtVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7894a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7894a);
        }
        if (this.f7895b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7895b);
        }
        if (this.f7896c != null) {
            iMo8448b += zzfjk.m8652b(3, this.f7896c);
        }
        if (this.f7899f != null) {
            iMo8448b += zzfjk.m8652b(4, this.f7899f);
        }
        if (this.f7897d != null) {
            iMo8448b += zzfjk.m8651b(5, this.f7897d.intValue());
        }
        if (this.f7898e == null || this.f7898e.length <= 0) {
            return iMo8448b;
        }
        int iM8652b = iMo8448b;
        for (int i = 0; i < this.f7898e.length; i++) {
            zzewt zzewtVar = this.f7898e[i];
            if (zzewtVar != null) {
                iM8652b += zzfjk.m8652b(6, zzewtVar);
            }
        }
        return iM8652b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzews)) {
            return false;
        }
        zzews zzewsVar = (zzews) obj;
        if (this.f7894a == null) {
            if (zzewsVar.f7894a != null) {
                return false;
            }
        } else if (!this.f7894a.equals(zzewsVar.f7894a)) {
            return false;
        }
        if (this.f7895b == null) {
            if (zzewsVar.f7895b != null) {
                return false;
            }
        } else if (!this.f7895b.equals(zzewsVar.f7895b)) {
            return false;
        }
        if (this.f7896c == null) {
            if (zzewsVar.f7896c != null) {
                return false;
            }
        } else if (!this.f7896c.equals(zzewsVar.f7896c)) {
            return false;
        }
        if (this.f7899f == null) {
            if (zzewsVar.f7899f != null) {
                return false;
            }
        } else if (!this.f7899f.equals(zzewsVar.f7899f)) {
            return false;
        }
        if (this.f7897d == null) {
            if (zzewsVar.f7897d != null) {
                return false;
            }
        } else if (!this.f7897d.equals(zzewsVar.f7897d)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7898e, zzewsVar.f7898e)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzewsVar.f7951H == null || zzewsVar.f7951H.m8690b() : this.f7951H.equals(zzewsVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = (this.f7895b == null ? 0 : this.f7895b.hashCode()) + (((this.f7894a == null ? 0 : this.f7894a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31);
        zzewr zzewrVar = this.f7896c;
        int i = iHashCode2 * 31;
        int iHashCode3 = zzewrVar == null ? 0 : zzewrVar.hashCode();
        zzewu zzewuVar = this.f7899f;
        int iIntValue = ((((this.f7897d == null ? 0 : this.f7897d.intValue()) + (((zzewuVar == null ? 0 : zzewuVar.hashCode()) + ((iHashCode3 + i) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7898e)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iIntValue + iHashCode;
    }
}
