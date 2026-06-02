package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkt extends zzfjm<zzfkt> {

    /* JADX INFO: renamed from: b */
    private static volatile zzfkt[] f8022b;

    /* JADX INFO: renamed from: a */
    public String f8023a = "";

    public zzfkt() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzfkt[] m8729a() {
        if (f8022b == null) {
            synchronized (zzfjq.f7965b) {
                if (f8022b == null) {
                    f8022b = new zzfkt[0];
                }
            }
        }
        return f8022b;
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
                    this.f8023a = zzfjjVar.m8632e();
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
        if (this.f8023a != null && !this.f8023a.equals("")) {
            zzfjkVar.m8670a(1, this.f8023a);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        return (this.f8023a == null || this.f8023a.equals("")) ? iMo8448b : iMo8448b + zzfjk.m8653b(1, this.f8023a);
    }
}
