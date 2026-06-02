package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzexa extends zzfjm<zzexa> {

    /* JADX INFO: renamed from: c */
    private static volatile zzexa[] f7936c;

    /* JADX INFO: renamed from: a */
    public String f7937a = null;

    /* JADX INFO: renamed from: b */
    public String f7938b = null;

    public zzexa() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzexa[] m8615a() {
        if (f7936c == null) {
            synchronized (zzfjq.f7965b) {
                if (f7936c == null) {
                    f7936c = new zzexa[0];
                }
            }
        }
        return f7936c;
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
                    this.f7937a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f7938b = zzfjjVar.m8632e();
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
        if (this.f7937a != null) {
            zzfjkVar.m8670a(1, this.f7937a);
        }
        if (this.f7938b != null) {
            zzfjkVar.m8670a(2, this.f7938b);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7937a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7937a);
        }
        return this.f7938b != null ? iMo8448b + zzfjk.m8653b(2, this.f7938b) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzexa)) {
            return false;
        }
        zzexa zzexaVar = (zzexa) obj;
        if (this.f7937a == null) {
            if (zzexaVar.f7937a != null) {
                return false;
            }
        } else if (!this.f7937a.equals(zzexaVar.f7937a)) {
            return false;
        }
        if (this.f7938b == null) {
            if (zzexaVar.f7938b != null) {
                return false;
            }
        } else if (!this.f7938b.equals(zzexaVar.f7938b)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzexaVar.f7951H == null || zzexaVar.f7951H.m8690b() : this.f7951H.equals(zzexaVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7938b == null ? 0 : this.f7938b.hashCode()) + (((this.f7937a == null ? 0 : this.f7937a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
