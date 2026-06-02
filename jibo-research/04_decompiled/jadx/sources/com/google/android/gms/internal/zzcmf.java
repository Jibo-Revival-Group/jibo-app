package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmf extends zzfjm<zzcmf> {

    /* JADX INFO: renamed from: a */
    public long[] f7711a = zzfjv.f7971b;

    /* JADX INFO: renamed from: b */
    public long[] f7712b = zzfjv.f7971b;

    public zzcmf() {
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
                case 8:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 8);
                    int length = this.f7711a == null ? 0 : this.f7711a.length;
                    long[] jArr = new long[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7711a, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzfjjVar.m8637i();
                        zzfjjVar.m8621a();
                        length++;
                    }
                    jArr[length] = zzfjjVar.m8637i();
                    this.f7711a = jArr;
                    break;
                case 10:
                    int iM8629c = zzfjjVar.m8629c(zzfjjVar.m8636h());
                    int iM8641m = zzfjjVar.m8641m();
                    int i = 0;
                    while (zzfjjVar.m8640l() > 0) {
                        zzfjjVar.m8637i();
                        i++;
                    }
                    zzfjjVar.m8633e(iM8641m);
                    int length2 = this.f7711a == null ? 0 : this.f7711a.length;
                    long[] jArr2 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7711a, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzfjjVar.m8637i();
                        length2++;
                    }
                    this.f7711a = jArr2;
                    zzfjjVar.m8630d(iM8629c);
                    break;
                case 16:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 16);
                    int length3 = this.f7712b == null ? 0 : this.f7712b.length;
                    long[] jArr3 = new long[iM8719a2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.f7712b, 0, jArr3, 0, length3);
                    }
                    while (length3 < jArr3.length - 1) {
                        jArr3[length3] = zzfjjVar.m8637i();
                        zzfjjVar.m8621a();
                        length3++;
                    }
                    jArr3[length3] = zzfjjVar.m8637i();
                    this.f7712b = jArr3;
                    break;
                case 18:
                    int iM8629c2 = zzfjjVar.m8629c(zzfjjVar.m8636h());
                    int iM8641m2 = zzfjjVar.m8641m();
                    int i2 = 0;
                    while (zzfjjVar.m8640l() > 0) {
                        zzfjjVar.m8637i();
                        i2++;
                    }
                    zzfjjVar.m8633e(iM8641m2);
                    int length4 = this.f7712b == null ? 0 : this.f7712b.length;
                    long[] jArr4 = new long[i2 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.f7712b, 0, jArr4, 0, length4);
                    }
                    while (length4 < jArr4.length) {
                        jArr4[length4] = zzfjjVar.m8637i();
                        length4++;
                    }
                    this.f7712b = jArr4;
                    zzfjjVar.m8630d(iM8629c2);
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
        if (this.f7711a != null && this.f7711a.length > 0) {
            for (int i = 0; i < this.f7711a.length; i++) {
                zzfjkVar.m8668a(1, this.f7711a[i]);
            }
        }
        if (this.f7712b != null && this.f7712b.length > 0) {
            for (int i2 = 0; i2 < this.f7712b.length; i2++) {
                zzfjkVar.m8668a(2, this.f7712b[i2]);
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int length;
        int iMo8448b = super.mo8448b();
        if (this.f7711a == null || this.f7711a.length <= 0) {
            length = iMo8448b;
        } else {
            int iM8643a = 0;
            for (int i = 0; i < this.f7711a.length; i++) {
                iM8643a += zzfjk.m8643a(this.f7711a[i]);
            }
            length = iMo8448b + iM8643a + (this.f7711a.length * 1);
        }
        if (this.f7712b == null || this.f7712b.length <= 0) {
            return length;
        }
        int iM8643a2 = 0;
        for (int i2 = 0; i2 < this.f7712b.length; i2++) {
            iM8643a2 += zzfjk.m8643a(this.f7712b[i2]);
        }
        return length + iM8643a2 + (this.f7712b.length * 1);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmf)) {
            return false;
        }
        zzcmf zzcmfVar = (zzcmf) obj;
        if (zzfjq.m8702a(this.f7711a, zzcmfVar.f7711a) && zzfjq.m8702a(this.f7712b, zzcmfVar.f7712b)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmfVar.f7951H == null || zzcmfVar.f7951H.m8690b() : this.f7951H.equals(zzcmfVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7951H == null || this.f7951H.m8690b()) ? 0 : this.f7951H.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + zzfjq.m8697a(this.f7711a)) * 31) + zzfjq.m8697a(this.f7712b)) * 31);
    }
}
