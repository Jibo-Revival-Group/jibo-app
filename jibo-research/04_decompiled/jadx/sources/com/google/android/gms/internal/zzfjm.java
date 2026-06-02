package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfjm;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfjm<M extends zzfjm<M>> extends zzfjs {

    /* JADX INFO: renamed from: H */
    protected zzfjo f7951H;

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7951H == null) {
            return;
        }
        for (int i = 0; i < this.f7951H.m8686a(); i++) {
            this.f7951H.m8689b(i).m8694a(zzfjkVar);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final boolean m8679a(zzfjj zzfjjVar, int i) throws IOException {
        int iM8641m = zzfjjVar.m8641m();
        if (!zzfjjVar.m8627b(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzfju zzfjuVar = new zzfju(i, zzfjjVar.m8624a(iM8641m, zzfjjVar.m8641m() - iM8641m));
        zzfjp zzfjpVarM8687a = null;
        if (this.f7951H == null) {
            this.f7951H = new zzfjo();
        } else {
            zzfjpVarM8687a = this.f7951H.m8687a(i2);
        }
        if (zzfjpVarM8687a == null) {
            zzfjpVarM8687a = new zzfjp();
            this.f7951H.m8688a(i2, zzfjpVarM8687a);
        }
        zzfjpVarM8687a.m8695a(zzfjuVar);
        return true;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected int mo8448b() {
        if (this.f7951H == null) {
            return 0;
        }
        int iM8693a = 0;
        for (int i = 0; i < this.f7951H.m8686a(); i++) {
            iM8693a += this.f7951H.m8689b(i).m8693a();
        }
        return iM8693a;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzfjq.m8700a(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfjm) clone();
    }
}
