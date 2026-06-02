package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfks extends zzfjm<zzfks> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private int f8020a = -1;

    /* JADX INFO: renamed from: b */
    private int f8021b = 0;

    public zzfks() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzfks clone() {
        try {
            return (zzfks) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        return r6;
     */
    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzfks mo8446a(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfks.mo8446a(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfks");
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f8020a != -1) {
            zzfjkVar.m8667a(1, this.f8020a);
        }
        if (this.f8021b != 0) {
            zzfjkVar.m8667a(2, this.f8021b);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f8020a != -1) {
            iMo8448b += zzfjk.m8651b(1, this.f8020a);
        }
        return this.f8021b != 0 ? iMo8448b + zzfjk.m8651b(2, this.f8021b) : iMo8448b;
    }

    @Override // com.google.android.gms.internal.zzfjm
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ zzfjm clone() throws CloneNotSupportedException {
        return (zzfks) clone();
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfks) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfks)) {
            return false;
        }
        zzfks zzfksVar = (zzfks) obj;
        if (this.f8020a == zzfksVar.f8020a && this.f8021b == zzfksVar.f8021b) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzfksVar.f7951H == null || zzfksVar.f7951H.m8690b() : this.f7951H.equals(zzfksVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7951H == null || this.f7951H.m8690b()) ? 0 : this.f7951H.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.f8020a) * 31) + this.f8021b) * 31);
    }
}
