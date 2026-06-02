package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewv extends zzfjm<zzewv> {

    /* JADX INFO: renamed from: a */
    public String f7907a = null;

    /* JADX INFO: renamed from: b */
    public Integer f7908b = null;

    /* JADX INFO: renamed from: c */
    public Long f7909c = null;

    /* JADX INFO: renamed from: d */
    public Long f7910d = null;

    /* JADX INFO: renamed from: e */
    public Integer f7911e = null;

    /* JADX INFO: renamed from: f */
    public Integer f7912f = null;

    /* JADX INFO: renamed from: g */
    public String f7913g = null;

    /* JADX INFO: renamed from: h */
    public Long f7914h = null;

    /* JADX INFO: renamed from: i */
    public Long f7915i = null;

    /* JADX INFO: renamed from: j */
    public Long f7916j = null;

    /* JADX INFO: renamed from: k */
    public Long f7917k = null;

    /* JADX INFO: renamed from: l */
    public zzeww[] f7918l = zzeww.m8611a();

    public zzewv() {
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
    public final com.google.android.gms.internal.zzewv mo8446a(com.google.android.gms.internal.zzfjj r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzewv.mo8446a(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzewv");
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7907a != null) {
            zzfjkVar.m8670a(1, this.f7907a);
        }
        if (this.f7908b != null) {
            zzfjkVar.m8667a(2, this.f7908b.intValue());
        }
        if (this.f7909c != null) {
            zzfjkVar.m8674b(3, this.f7909c.longValue());
        }
        if (this.f7910d != null) {
            zzfjkVar.m8674b(4, this.f7910d.longValue());
        }
        if (this.f7912f != null) {
            zzfjkVar.m8667a(5, this.f7912f.intValue());
        }
        if (this.f7913g != null) {
            zzfjkVar.m8670a(6, this.f7913g);
        }
        if (this.f7914h != null) {
            zzfjkVar.m8674b(7, this.f7914h.longValue());
        }
        if (this.f7915i != null) {
            zzfjkVar.m8674b(8, this.f7915i.longValue());
        }
        if (this.f7916j != null) {
            zzfjkVar.m8674b(9, this.f7916j.longValue());
        }
        if (this.f7917k != null) {
            zzfjkVar.m8674b(10, this.f7917k.longValue());
        }
        if (this.f7911e != null) {
            zzfjkVar.m8667a(11, this.f7911e.intValue());
        }
        if (this.f7918l != null && this.f7918l.length > 0) {
            for (int i = 0; i < this.f7918l.length; i++) {
                zzeww zzewwVar = this.f7918l[i];
                if (zzewwVar != null) {
                    zzfjkVar.m8669a(12, zzewwVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7907a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7907a);
        }
        if (this.f7908b != null) {
            iMo8448b += zzfjk.m8651b(2, this.f7908b.intValue());
        }
        if (this.f7909c != null) {
            iMo8448b += zzfjk.m8660d(3, this.f7909c.longValue());
        }
        if (this.f7910d != null) {
            iMo8448b += zzfjk.m8660d(4, this.f7910d.longValue());
        }
        if (this.f7912f != null) {
            iMo8448b += zzfjk.m8651b(5, this.f7912f.intValue());
        }
        if (this.f7913g != null) {
            iMo8448b += zzfjk.m8653b(6, this.f7913g);
        }
        if (this.f7914h != null) {
            iMo8448b += zzfjk.m8660d(7, this.f7914h.longValue());
        }
        if (this.f7915i != null) {
            iMo8448b += zzfjk.m8660d(8, this.f7915i.longValue());
        }
        if (this.f7916j != null) {
            iMo8448b += zzfjk.m8660d(9, this.f7916j.longValue());
        }
        if (this.f7917k != null) {
            iMo8448b += zzfjk.m8660d(10, this.f7917k.longValue());
        }
        if (this.f7911e != null) {
            iMo8448b += zzfjk.m8651b(11, this.f7911e.intValue());
        }
        if (this.f7918l == null || this.f7918l.length <= 0) {
            return iMo8448b;
        }
        int iM8652b = iMo8448b;
        for (int i = 0; i < this.f7918l.length; i++) {
            zzeww zzewwVar = this.f7918l[i];
            if (zzewwVar != null) {
                iM8652b += zzfjk.m8652b(12, zzewwVar);
            }
        }
        return iM8652b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewv)) {
            return false;
        }
        zzewv zzewvVar = (zzewv) obj;
        if (this.f7907a == null) {
            if (zzewvVar.f7907a != null) {
                return false;
            }
        } else if (!this.f7907a.equals(zzewvVar.f7907a)) {
            return false;
        }
        if (this.f7908b == null) {
            if (zzewvVar.f7908b != null) {
                return false;
            }
        } else if (!this.f7908b.equals(zzewvVar.f7908b)) {
            return false;
        }
        if (this.f7909c == null) {
            if (zzewvVar.f7909c != null) {
                return false;
            }
        } else if (!this.f7909c.equals(zzewvVar.f7909c)) {
            return false;
        }
        if (this.f7910d == null) {
            if (zzewvVar.f7910d != null) {
                return false;
            }
        } else if (!this.f7910d.equals(zzewvVar.f7910d)) {
            return false;
        }
        if (this.f7911e == null) {
            if (zzewvVar.f7911e != null) {
                return false;
            }
        } else if (!this.f7911e.equals(zzewvVar.f7911e)) {
            return false;
        }
        if (this.f7912f == null) {
            if (zzewvVar.f7912f != null) {
                return false;
            }
        } else if (!this.f7912f.equals(zzewvVar.f7912f)) {
            return false;
        }
        if (this.f7913g == null) {
            if (zzewvVar.f7913g != null) {
                return false;
            }
        } else if (!this.f7913g.equals(zzewvVar.f7913g)) {
            return false;
        }
        if (this.f7914h == null) {
            if (zzewvVar.f7914h != null) {
                return false;
            }
        } else if (!this.f7914h.equals(zzewvVar.f7914h)) {
            return false;
        }
        if (this.f7915i == null) {
            if (zzewvVar.f7915i != null) {
                return false;
            }
        } else if (!this.f7915i.equals(zzewvVar.f7915i)) {
            return false;
        }
        if (this.f7916j == null) {
            if (zzewvVar.f7916j != null) {
                return false;
            }
        } else if (!this.f7916j.equals(zzewvVar.f7916j)) {
            return false;
        }
        if (this.f7917k == null) {
            if (zzewvVar.f7917k != null) {
                return false;
            }
        } else if (!this.f7917k.equals(zzewvVar.f7917k)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7918l, zzewvVar.f7918l)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzewvVar.f7951H == null || zzewvVar.f7951H.m8690b() : this.f7951H.equals(zzewvVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((this.f7917k == null ? 0 : this.f7917k.hashCode()) + (((this.f7916j == null ? 0 : this.f7916j.hashCode()) + (((this.f7915i == null ? 0 : this.f7915i.hashCode()) + (((this.f7914h == null ? 0 : this.f7914h.hashCode()) + (((this.f7913g == null ? 0 : this.f7913g.hashCode()) + (((this.f7912f == null ? 0 : this.f7912f.hashCode()) + (((this.f7911e == null ? 0 : this.f7911e.intValue()) + (((this.f7910d == null ? 0 : this.f7910d.hashCode()) + (((this.f7909c == null ? 0 : this.f7909c.hashCode()) + (((this.f7908b == null ? 0 : this.f7908b.intValue()) + (((this.f7907a == null ? 0 : this.f7907a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7918l)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
