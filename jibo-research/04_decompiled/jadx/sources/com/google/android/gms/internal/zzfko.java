package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfko extends zzfjm<zzfko> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private int f7987a = 0;

    /* JADX INFO: renamed from: b */
    private String f7988b = "";

    /* JADX INFO: renamed from: c */
    private String f7989c = "";

    public zzfko() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzfko clone() {
        try {
            return (zzfko) super.clone();
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
                case 8:
                    this.f7987a = zzfjjVar.m8628c();
                    break;
                case 18:
                    this.f7988b = zzfjjVar.m8632e();
                    break;
                case 26:
                    this.f7989c = zzfjjVar.m8632e();
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
        if (this.f7987a != 0) {
            zzfjkVar.m8667a(1, this.f7987a);
        }
        if (this.f7988b != null && !this.f7988b.equals("")) {
            zzfjkVar.m8670a(2, this.f7988b);
        }
        if (this.f7989c != null && !this.f7989c.equals("")) {
            zzfjkVar.m8670a(3, this.f7989c);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7987a != 0) {
            iMo8448b += zzfjk.m8651b(1, this.f7987a);
        }
        if (this.f7988b != null && !this.f7988b.equals("")) {
            iMo8448b += zzfjk.m8653b(2, this.f7988b);
        }
        return (this.f7989c == null || this.f7989c.equals("")) ? iMo8448b : iMo8448b + zzfjk.m8653b(3, this.f7989c);
    }

    @Override // com.google.android.gms.internal.zzfjm
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ zzfjm clone() throws CloneNotSupportedException {
        return (zzfko) clone();
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfko) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfko)) {
            return false;
        }
        zzfko zzfkoVar = (zzfko) obj;
        if (this.f7987a != zzfkoVar.f7987a) {
            return false;
        }
        if (this.f7988b == null) {
            if (zzfkoVar.f7988b != null) {
                return false;
            }
        } else if (!this.f7988b.equals(zzfkoVar.f7988b)) {
            return false;
        }
        if (this.f7989c == null) {
            if (zzfkoVar.f7989c != null) {
                return false;
            }
        } else if (!this.f7989c.equals(zzfkoVar.f7989c)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzfkoVar.f7951H == null || zzfkoVar.f7951H.m8690b() : this.f7951H.equals(zzfkoVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7989c == null ? 0 : this.f7989c.hashCode()) + (((this.f7988b == null ? 0 : this.f7988b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f7987a) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
