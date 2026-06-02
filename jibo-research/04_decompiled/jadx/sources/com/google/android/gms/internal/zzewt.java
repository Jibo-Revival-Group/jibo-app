package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewt extends zzfjm<zzewt> {

    /* JADX INFO: renamed from: c */
    private static volatile zzewt[] f7900c;

    /* JADX INFO: renamed from: a */
    public String f7901a = null;

    /* JADX INFO: renamed from: b */
    public String f7902b = null;

    public zzewt() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzewt[] m8609a() {
        if (f7900c == null) {
            synchronized (zzfjq.f7965b) {
                if (f7900c == null) {
                    f7900c = new zzewt[0];
                }
            }
        }
        return f7900c;
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
                    this.f7901a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f7902b = zzfjjVar.m8632e();
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
        if (this.f7901a != null) {
            zzfjkVar.m8670a(1, this.f7901a);
        }
        if (this.f7902b != null) {
            zzfjkVar.m8670a(2, this.f7902b);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7901a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7901a);
        }
        return this.f7902b != null ? iMo8448b + zzfjk.m8653b(2, this.f7902b) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewt)) {
            return false;
        }
        zzewt zzewtVar = (zzewt) obj;
        if (this.f7901a == null) {
            if (zzewtVar.f7901a != null) {
                return false;
            }
        } else if (!this.f7901a.equals(zzewtVar.f7901a)) {
            return false;
        }
        if (this.f7902b == null) {
            if (zzewtVar.f7902b != null) {
                return false;
            }
        } else if (!this.f7902b.equals(zzewtVar.f7902b)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzewtVar.f7951H == null || zzewtVar.f7951H.m8690b() : this.f7951H.equals(zzewtVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7902b == null ? 0 : this.f7902b.hashCode()) + (((this.f7901a == null ? 0 : this.f7901a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
