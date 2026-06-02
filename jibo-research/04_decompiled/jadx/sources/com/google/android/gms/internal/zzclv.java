package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclv extends zzfjm<zzclv> {

    /* JADX INFO: renamed from: d */
    private static volatile zzclv[] f7635d;

    /* JADX INFO: renamed from: a */
    public Integer f7636a = null;

    /* JADX INFO: renamed from: b */
    public String f7637b = null;

    /* JADX INFO: renamed from: c */
    public zzclt f7638c = null;

    public zzclv() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzclv[] m8452a() {
        if (f7635d == null) {
            synchronized (zzfjq.f7965b) {
                if (f7635d == null) {
                    f7635d = new zzclv[0];
                }
            }
        }
        return f7635d;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ zzfjs mo8446a(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int iM8621a = zzfjjVar.m8621a();
            switch (iM8621a) {
                case 0:
                    break;
                case 8:
                    this.f7636a = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 18:
                    this.f7637b = zzfjjVar.m8632e();
                    break;
                case 26:
                    if (this.f7638c == null) {
                        this.f7638c = new zzclt();
                    }
                    zzfjjVar.m8623a(this.f7638c);
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
        if (this.f7636a != null) {
            zzfjkVar.m8667a(1, this.f7636a.intValue());
        }
        if (this.f7637b != null) {
            zzfjkVar.m8670a(2, this.f7637b);
        }
        if (this.f7638c != null) {
            zzfjkVar.m8669a(3, this.f7638c);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7636a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7636a.intValue());
        }
        if (this.f7637b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7637b);
        }
        return this.f7638c != null ? iMo8448b + zzfjk.m8652b(3, this.f7638c) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclv)) {
            return false;
        }
        zzclv zzclvVar = (zzclv) obj;
        if (this.f7636a == null) {
            if (zzclvVar.f7636a != null) {
                return false;
            }
        } else if (!this.f7636a.equals(zzclvVar.f7636a)) {
            return false;
        }
        if (this.f7637b == null) {
            if (zzclvVar.f7637b != null) {
                return false;
            }
        } else if (!this.f7637b.equals(zzclvVar.f7637b)) {
            return false;
        }
        if (this.f7638c == null) {
            if (zzclvVar.f7638c != null) {
                return false;
            }
        } else if (!this.f7638c.equals(zzclvVar.f7638c)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzclvVar.f7951H == null || zzclvVar.f7951H.m8690b() : this.f7951H.equals(zzclvVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = (this.f7637b == null ? 0 : this.f7637b.hashCode()) + (((this.f7636a == null ? 0 : this.f7636a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31);
        zzclt zzcltVar = this.f7638c;
        int iHashCode3 = ((zzcltVar == null ? 0 : zzcltVar.hashCode()) + (iHashCode2 * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode3 + iHashCode;
    }
}
