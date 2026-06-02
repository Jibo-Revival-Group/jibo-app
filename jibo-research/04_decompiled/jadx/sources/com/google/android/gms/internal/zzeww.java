package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzeww extends zzfjm<zzeww> {

    /* JADX INFO: renamed from: c */
    private static volatile zzeww[] f7919c;

    /* JADX INFO: renamed from: a */
    public String f7920a = null;

    /* JADX INFO: renamed from: b */
    public String f7921b = null;

    public zzeww() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzeww[] m8611a() {
        if (f7919c == null) {
            synchronized (zzfjq.f7965b) {
                if (f7919c == null) {
                    f7919c = new zzeww[0];
                }
            }
        }
        return f7919c;
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
                    this.f7920a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f7921b = zzfjjVar.m8632e();
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
        if (this.f7920a != null) {
            zzfjkVar.m8670a(1, this.f7920a);
        }
        if (this.f7921b != null) {
            zzfjkVar.m8670a(2, this.f7921b);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7920a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7920a);
        }
        return this.f7921b != null ? iMo8448b + zzfjk.m8653b(2, this.f7921b) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeww)) {
            return false;
        }
        zzeww zzewwVar = (zzeww) obj;
        if (this.f7920a == null) {
            if (zzewwVar.f7920a != null) {
                return false;
            }
        } else if (!this.f7920a.equals(zzewwVar.f7920a)) {
            return false;
        }
        if (this.f7921b == null) {
            if (zzewwVar.f7921b != null) {
                return false;
            }
        } else if (!this.f7921b.equals(zzewwVar.f7921b)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzewwVar.f7951H == null || zzewwVar.f7951H.m8690b() : this.f7951H.equals(zzewwVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7921b == null ? 0 : this.f7921b.hashCode()) + (((this.f7920a == null ? 0 : this.f7920a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
