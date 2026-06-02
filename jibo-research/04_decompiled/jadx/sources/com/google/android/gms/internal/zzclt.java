package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclt extends zzfjm<zzclt> {

    /* JADX INFO: renamed from: e */
    private static volatile zzclt[] f7625e;

    /* JADX INFO: renamed from: a */
    public zzclw f7626a = null;

    /* JADX INFO: renamed from: b */
    public zzclu f7627b = null;

    /* JADX INFO: renamed from: c */
    public Boolean f7628c = null;

    /* JADX INFO: renamed from: d */
    public String f7629d = null;

    public zzclt() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzclt[] m8450a() {
        if (f7625e == null) {
            synchronized (zzfjq.f7965b) {
                if (f7625e == null) {
                    f7625e = new zzclt[0];
                }
            }
        }
        return f7625e;
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
                    if (this.f7626a == null) {
                        this.f7626a = new zzclw();
                    }
                    zzfjjVar.m8623a(this.f7626a);
                    break;
                case 18:
                    if (this.f7627b == null) {
                        this.f7627b = new zzclu();
                    }
                    zzfjjVar.m8623a(this.f7627b);
                    break;
                case 24:
                    this.f7628c = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 34:
                    this.f7629d = zzfjjVar.m8632e();
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
        if (this.f7626a != null) {
            zzfjkVar.m8669a(1, this.f7626a);
        }
        if (this.f7627b != null) {
            zzfjkVar.m8669a(2, this.f7627b);
        }
        if (this.f7628c != null) {
            zzfjkVar.m8671a(3, this.f7628c.booleanValue());
        }
        if (this.f7629d != null) {
            zzfjkVar.m8670a(4, this.f7629d);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7626a != null) {
            iMo8448b += zzfjk.m8652b(1, this.f7626a);
        }
        if (this.f7627b != null) {
            iMo8448b += zzfjk.m8652b(2, this.f7627b);
        }
        if (this.f7628c != null) {
            this.f7628c.booleanValue();
            iMo8448b += zzfjk.m8650b(3) + 1;
        }
        return this.f7629d != null ? iMo8448b + zzfjk.m8653b(4, this.f7629d) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclt)) {
            return false;
        }
        zzclt zzcltVar = (zzclt) obj;
        if (this.f7626a == null) {
            if (zzcltVar.f7626a != null) {
                return false;
            }
        } else if (!this.f7626a.equals(zzcltVar.f7626a)) {
            return false;
        }
        if (this.f7627b == null) {
            if (zzcltVar.f7627b != null) {
                return false;
            }
        } else if (!this.f7627b.equals(zzcltVar.f7627b)) {
            return false;
        }
        if (this.f7628c == null) {
            if (zzcltVar.f7628c != null) {
                return false;
            }
        } else if (!this.f7628c.equals(zzcltVar.f7628c)) {
            return false;
        }
        if (this.f7629d == null) {
            if (zzcltVar.f7629d != null) {
                return false;
            }
        } else if (!this.f7629d.equals(zzcltVar.f7629d)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzcltVar.f7951H == null || zzcltVar.f7951H.m8690b() : this.f7951H.equals(zzcltVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = getClass().getName().hashCode() + 527;
        zzclw zzclwVar = this.f7626a;
        int i = iHashCode2 * 31;
        int iHashCode3 = zzclwVar == null ? 0 : zzclwVar.hashCode();
        zzclu zzcluVar = this.f7627b;
        int iHashCode4 = ((this.f7629d == null ? 0 : this.f7629d.hashCode()) + (((this.f7628c == null ? 0 : this.f7628c.hashCode()) + (((zzcluVar == null ? 0 : zzcluVar.hashCode()) + ((iHashCode3 + i) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode4 + iHashCode;
    }
}
