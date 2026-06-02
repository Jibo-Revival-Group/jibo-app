package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewr extends zzfjm<zzewr> {

    /* JADX INFO: renamed from: a */
    public String f7891a = null;

    /* JADX INFO: renamed from: b */
    public String f7892b = null;

    /* JADX INFO: renamed from: c */
    public String f7893c = null;

    public zzewr() {
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
                case 10:
                    this.f7891a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f7892b = zzfjjVar.m8632e();
                    break;
                case 26:
                    this.f7893c = zzfjjVar.m8632e();
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
        if (this.f7891a != null) {
            zzfjkVar.m8670a(1, this.f7891a);
        }
        if (this.f7892b != null) {
            zzfjkVar.m8670a(2, this.f7892b);
        }
        if (this.f7893c != null) {
            zzfjkVar.m8670a(3, this.f7893c);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7891a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7891a);
        }
        if (this.f7892b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7892b);
        }
        return this.f7893c != null ? iMo8448b + zzfjk.m8653b(3, this.f7893c) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewr)) {
            return false;
        }
        zzewr zzewrVar = (zzewr) obj;
        if (this.f7891a == null) {
            if (zzewrVar.f7891a != null) {
                return false;
            }
        } else if (!this.f7891a.equals(zzewrVar.f7891a)) {
            return false;
        }
        if (this.f7892b == null) {
            if (zzewrVar.f7892b != null) {
                return false;
            }
        } else if (!this.f7892b.equals(zzewrVar.f7892b)) {
            return false;
        }
        if (this.f7893c == null) {
            if (zzewrVar.f7893c != null) {
                return false;
            }
        } else if (!this.f7893c.equals(zzewrVar.f7893c)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzewrVar.f7951H == null || zzewrVar.f7951H.m8690b() : this.f7951H.equals(zzewrVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7893c == null ? 0 : this.f7893c.hashCode()) + (((this.f7892b == null ? 0 : this.f7892b.hashCode()) + (((this.f7891a == null ? 0 : this.f7891a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
