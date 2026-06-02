package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmd extends zzfjm<zzcmd> {

    /* JADX INFO: renamed from: a */
    public zzcme[] f7674a = zzcme.m8459a();

    public zzcmd() {
        this.f7951H = null;
        this.f7967I = -1;
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
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 10);
                    int length = this.f7674a == null ? 0 : this.f7674a.length;
                    zzcme[] zzcmeVarArr = new zzcme[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7674a, 0, zzcmeVarArr, 0, length);
                    }
                    while (length < zzcmeVarArr.length - 1) {
                        zzcmeVarArr[length] = new zzcme();
                        zzfjjVar.m8623a(zzcmeVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzcmeVarArr[length] = new zzcme();
                    zzfjjVar.m8623a(zzcmeVarArr[length]);
                    this.f7674a = zzcmeVarArr;
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
        if (this.f7674a != null && this.f7674a.length > 0) {
            for (int i = 0; i < this.f7674a.length; i++) {
                zzcme zzcmeVar = this.f7674a[i];
                if (zzcmeVar != null) {
                    zzfjkVar.m8669a(1, zzcmeVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7674a != null && this.f7674a.length > 0) {
            for (int i = 0; i < this.f7674a.length; i++) {
                zzcme zzcmeVar = this.f7674a[i];
                if (zzcmeVar != null) {
                    iMo8448b += zzfjk.m8652b(1, zzcmeVar);
                }
            }
        }
        return iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmd)) {
            return false;
        }
        zzcmd zzcmdVar = (zzcmd) obj;
        if (zzfjq.m8703a(this.f7674a, zzcmdVar.f7674a)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmdVar.f7951H == null || zzcmdVar.f7951H.m8690b() : this.f7951H.equals(zzcmdVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7951H == null || this.f7951H.m8690b()) ? 0 : this.f7951H.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzfjq.m8698a(this.f7674a)) * 31);
    }
}
