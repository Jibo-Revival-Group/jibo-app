package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkr extends zzfjm<zzfkr> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private static volatile zzfkr[] f8017a;

    /* JADX INFO: renamed from: b */
    private String f8018b = "";

    /* JADX INFO: renamed from: c */
    private String f8019c = "";

    public zzfkr() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzfkr[] m8725a() {
        if (f8017a == null) {
            synchronized (zzfjq.f7965b) {
                if (f8017a == null) {
                    f8017a = new zzfkr[0];
                }
            }
        }
        return f8017a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public zzfkr clone() {
        try {
            return (zzfkr) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
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
                    this.f8018b = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f8019c = zzfjjVar.m8632e();
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
        if (this.f8018b != null && !this.f8018b.equals("")) {
            zzfjkVar.m8670a(1, this.f8018b);
        }
        if (this.f8019c != null && !this.f8019c.equals("")) {
            zzfjkVar.m8670a(2, this.f8019c);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f8018b != null && !this.f8018b.equals("")) {
            iMo8448b += zzfjk.m8653b(1, this.f8018b);
        }
        return (this.f8019c == null || this.f8019c.equals("")) ? iMo8448b : iMo8448b + zzfjk.m8653b(2, this.f8019c);
    }

    @Override // com.google.android.gms.internal.zzfjm
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ zzfjm clone() throws CloneNotSupportedException {
        return (zzfkr) clone();
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfkr) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkr)) {
            return false;
        }
        zzfkr zzfkrVar = (zzfkr) obj;
        if (this.f8018b == null) {
            if (zzfkrVar.f8018b != null) {
                return false;
            }
        } else if (!this.f8018b.equals(zzfkrVar.f8018b)) {
            return false;
        }
        if (this.f8019c == null) {
            if (zzfkrVar.f8019c != null) {
                return false;
            }
        } else if (!this.f8019c.equals(zzfkrVar.f8019c)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzfkrVar.f7951H == null || zzfkrVar.f7951H.m8690b() : this.f7951H.equals(zzfkrVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f8019c == null ? 0 : this.f8019c.hashCode()) + (((this.f8018b == null ? 0 : this.f8018b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
