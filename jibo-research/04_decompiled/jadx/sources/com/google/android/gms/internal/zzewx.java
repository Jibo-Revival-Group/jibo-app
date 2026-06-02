package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewx extends zzfjm<zzewx> {

    /* JADX INFO: renamed from: a */
    public zzews f7922a = null;

    /* JADX INFO: renamed from: b */
    public zzewy f7923b = null;

    /* JADX INFO: renamed from: c */
    public zzewv f7924c = null;

    public zzewx() {
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
                    if (this.f7922a == null) {
                        this.f7922a = new zzews();
                    }
                    zzfjjVar.m8623a(this.f7922a);
                    break;
                case 18:
                    if (this.f7923b == null) {
                        this.f7923b = new zzewy();
                    }
                    zzfjjVar.m8623a(this.f7923b);
                    break;
                case 26:
                    if (this.f7924c == null) {
                        this.f7924c = new zzewv();
                    }
                    zzfjjVar.m8623a(this.f7924c);
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
        if (this.f7922a != null) {
            zzfjkVar.m8669a(1, this.f7922a);
        }
        if (this.f7923b != null) {
            zzfjkVar.m8669a(2, this.f7923b);
        }
        if (this.f7924c != null) {
            zzfjkVar.m8669a(3, this.f7924c);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7922a != null) {
            iMo8448b += zzfjk.m8652b(1, this.f7922a);
        }
        if (this.f7923b != null) {
            iMo8448b += zzfjk.m8652b(2, this.f7923b);
        }
        return this.f7924c != null ? iMo8448b + zzfjk.m8652b(3, this.f7924c) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewx)) {
            return false;
        }
        zzewx zzewxVar = (zzewx) obj;
        if (this.f7922a == null) {
            if (zzewxVar.f7922a != null) {
                return false;
            }
        } else if (!this.f7922a.equals(zzewxVar.f7922a)) {
            return false;
        }
        if (this.f7923b == null) {
            if (zzewxVar.f7923b != null) {
                return false;
            }
        } else if (!this.f7923b.equals(zzewxVar.f7923b)) {
            return false;
        }
        if (this.f7924c == null) {
            if (zzewxVar.f7924c != null) {
                return false;
            }
        } else if (!this.f7924c.equals(zzewxVar.f7924c)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzewxVar.f7951H == null || zzewxVar.f7951H.m8690b() : this.f7951H.equals(zzewxVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode() + 527;
        zzews zzewsVar = this.f7922a;
        int i = iHashCode2 * 31;
        int iHashCode3 = zzewsVar == null ? 0 : zzewsVar.hashCode();
        zzewy zzewyVar = this.f7923b;
        int i2 = (iHashCode3 + i) * 31;
        int iHashCode4 = zzewyVar == null ? 0 : zzewyVar.hashCode();
        zzewv zzewvVar = this.f7924c;
        int iHashCode5 = ((zzewvVar == null ? 0 : zzewvVar.hashCode()) + ((iHashCode4 + i2) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode5 + iHashCode;
    }
}
