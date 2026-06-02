package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewz extends zzfjm<zzewz> {

    /* JADX INFO: renamed from: c */
    private static volatile zzewz[] f7933c;

    /* JADX INFO: renamed from: a */
    public String f7934a = null;

    /* JADX INFO: renamed from: b */
    public Long f7935b = null;

    public zzewz() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzewz[] m8613a() {
        if (f7933c == null) {
            synchronized (zzfjq.f7965b) {
                if (f7933c == null) {
                    f7933c = new zzewz[0];
                }
            }
        }
        return f7933c;
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
                    this.f7934a = zzfjjVar.m8632e();
                    break;
                case 16:
                    this.f7935b = Long.valueOf(zzfjjVar.m8637i());
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
        if (this.f7934a != null) {
            zzfjkVar.m8670a(1, this.f7934a);
        }
        if (this.f7935b != null) {
            zzfjkVar.m8674b(2, this.f7935b.longValue());
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7934a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7934a);
        }
        return this.f7935b != null ? iMo8448b + zzfjk.m8660d(2, this.f7935b.longValue()) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewz)) {
            return false;
        }
        zzewz zzewzVar = (zzewz) obj;
        if (this.f7934a == null) {
            if (zzewzVar.f7934a != null) {
                return false;
            }
        } else if (!this.f7934a.equals(zzewzVar.f7934a)) {
            return false;
        }
        if (this.f7935b == null) {
            if (zzewzVar.f7935b != null) {
                return false;
            }
        } else if (!this.f7935b.equals(zzewzVar.f7935b)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzewzVar.f7951H == null || zzewzVar.f7951H.m8690b() : this.f7951H.equals(zzewzVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7935b == null ? 0 : this.f7935b.hashCode()) + (((this.f7934a == null ? 0 : this.f7934a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
