package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewu extends zzfjm<zzewu> {

    /* JADX INFO: renamed from: a */
    private String f7903a = null;

    /* JADX INFO: renamed from: b */
    private String f7904b = null;

    /* JADX INFO: renamed from: c */
    private String f7905c = null;

    /* JADX INFO: renamed from: d */
    private zzfks f7906d = null;

    public zzewu() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ zzfjs mo8446a(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int iM8621a = zzfjjVar.m8621a();
            switch (iM8621a) {
                case 0:
                    break;
                case 18:
                    this.f7903a = zzfjjVar.m8632e();
                    break;
                case 26:
                    this.f7904b = zzfjjVar.m8632e();
                    break;
                case 34:
                    this.f7905c = zzfjjVar.m8632e();
                    break;
                case 42:
                    if (this.f7906d == null) {
                        this.f7906d = new zzfks();
                    }
                    zzfjjVar.m8623a(this.f7906d);
                    break;
                default:
                    if (!super.m8679a(zzfjjVar, iM8621a)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7903a != null) {
            zzfjkVar.m8670a(2, this.f7903a);
        }
        if (this.f7904b != null) {
            zzfjkVar.m8670a(3, this.f7904b);
        }
        if (this.f7905c != null) {
            zzfjkVar.m8670a(4, this.f7905c);
        }
        if (this.f7906d != null) {
            zzfjkVar.m8669a(5, this.f7906d);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7903a != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7903a);
        }
        if (this.f7904b != null) {
            iMo8448b += zzfjk.m8653b(3, this.f7904b);
        }
        if (this.f7905c != null) {
            iMo8448b += zzfjk.m8653b(4, this.f7905c);
        }
        return this.f7906d != null ? iMo8448b + zzfjk.m8652b(5, this.f7906d) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewu)) {
            return false;
        }
        zzewu zzewuVar = (zzewu) obj;
        if (this.f7903a == null) {
            if (zzewuVar.f7903a != null) {
                return false;
            }
        } else if (!this.f7903a.equals(zzewuVar.f7903a)) {
            return false;
        }
        if (this.f7904b == null) {
            if (zzewuVar.f7904b != null) {
                return false;
            }
        } else if (!this.f7904b.equals(zzewuVar.f7904b)) {
            return false;
        }
        if (this.f7905c == null) {
            if (zzewuVar.f7905c != null) {
                return false;
            }
        } else if (!this.f7905c.equals(zzewuVar.f7905c)) {
            return false;
        }
        if (this.f7906d == null) {
            if (zzewuVar.f7906d != null) {
                return false;
            }
        } else if (!this.f7906d.equals(zzewuVar.f7906d)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzewuVar.f7951H == null || zzewuVar.f7951H.m8690b() : this.f7951H.equals(zzewuVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = (this.f7905c == null ? 0 : this.f7905c.hashCode()) + (((this.f7904b == null ? 0 : this.f7904b.hashCode()) + (((this.f7903a == null ? 0 : this.f7903a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31);
        zzfks zzfksVar = this.f7906d;
        int iHashCode3 = ((zzfksVar == null ? 0 : zzfksVar.hashCode()) + (iHashCode2 * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode3 + iHashCode;
    }
}
