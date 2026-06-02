package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclz extends zzfjm<zzclz> {

    /* JADX INFO: renamed from: c */
    private static volatile zzclz[] f7654c;

    /* JADX INFO: renamed from: a */
    public String f7655a = null;

    /* JADX INFO: renamed from: b */
    public String f7656b = null;

    public zzclz() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzclz[] m8455a() {
        if (f7654c == null) {
            synchronized (zzfjq.f7965b) {
                if (f7654c == null) {
                    f7654c = new zzclz[0];
                }
            }
        }
        return f7654c;
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
                    this.f7655a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f7656b = zzfjjVar.m8632e();
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
        if (this.f7655a != null) {
            zzfjkVar.m8670a(1, this.f7655a);
        }
        if (this.f7656b != null) {
            zzfjkVar.m8670a(2, this.f7656b);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7655a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7655a);
        }
        return this.f7656b != null ? iMo8448b + zzfjk.m8653b(2, this.f7656b) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclz)) {
            return false;
        }
        zzclz zzclzVar = (zzclz) obj;
        if (this.f7655a == null) {
            if (zzclzVar.f7655a != null) {
                return false;
            }
        } else if (!this.f7655a.equals(zzclzVar.f7655a)) {
            return false;
        }
        if (this.f7656b == null) {
            if (zzclzVar.f7656b != null) {
                return false;
            }
        } else if (!this.f7656b.equals(zzclzVar.f7656b)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzclzVar.f7951H == null || zzclzVar.f7951H.m8690b() : this.f7951H.equals(zzclzVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7656b == null ? 0 : this.f7656b.hashCode()) + (((this.f7655a == null ? 0 : this.f7655a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
