package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmz extends zzfjm<zzdmz> {

    /* JADX INFO: renamed from: a */
    public String[] f7810a = zzfjv.f7975f;

    /* JADX INFO: renamed from: b */
    public int[] f7811b = zzfjv.f7970a;

    /* JADX INFO: renamed from: c */
    public byte[][] f7812c = zzfjv.f7976g;

    public zzdmz() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzdmz m8523a(byte[] bArr) throws zzfjr {
        return (zzdmz) zzfjs.m8709a(new zzdmz(), bArr);
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
                    int length = this.f7810a == null ? 0 : this.f7810a.length;
                    String[] strArr = new String[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7810a, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzfjjVar.m8632e();
                        zzfjjVar.m8621a();
                        length++;
                    }
                    strArr[length] = zzfjjVar.m8632e();
                    this.f7810a = strArr;
                    break;
                case 16:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 16);
                    int length2 = this.f7811b == null ? 0 : this.f7811b.length;
                    int[] iArr = new int[iM8719a2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7811b, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzfjjVar.m8636h();
                        zzfjjVar.m8621a();
                        length2++;
                    }
                    iArr[length2] = zzfjjVar.m8636h();
                    this.f7811b = iArr;
                    break;
                case 18:
                    int iM8629c = zzfjjVar.m8629c(zzfjjVar.m8636h());
                    int iM8641m = zzfjjVar.m8641m();
                    int i = 0;
                    while (zzfjjVar.m8640l() > 0) {
                        zzfjjVar.m8636h();
                        i++;
                    }
                    zzfjjVar.m8633e(iM8641m);
                    int length3 = this.f7811b == null ? 0 : this.f7811b.length;
                    int[] iArr2 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.f7811b, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzfjjVar.m8636h();
                        length3++;
                    }
                    this.f7811b = iArr2;
                    zzfjjVar.m8630d(iM8629c);
                    break;
                case 26:
                    int iM8719a3 = zzfjv.m8719a(zzfjjVar, 26);
                    int length4 = this.f7812c == null ? 0 : this.f7812c.length;
                    byte[][] bArr = new byte[iM8719a3 + length4][];
                    if (length4 != 0) {
                        System.arraycopy(this.f7812c, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzfjjVar.m8634f();
                        zzfjjVar.m8621a();
                        length4++;
                    }
                    bArr[length4] = zzfjjVar.m8634f();
                    this.f7812c = bArr;
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
        if (this.f7810a != null && this.f7810a.length > 0) {
            for (int i = 0; i < this.f7810a.length; i++) {
                String str = this.f7810a[i];
                if (str != null) {
                    zzfjkVar.m8670a(1, str);
                }
            }
        }
        if (this.f7811b != null && this.f7811b.length > 0) {
            for (int i2 = 0; i2 < this.f7811b.length; i2++) {
                zzfjkVar.m8667a(2, this.f7811b[i2]);
            }
        }
        if (this.f7812c != null && this.f7812c.length > 0) {
            for (int i3 = 0; i3 < this.f7812c.length; i3++) {
                byte[] bArr = this.f7812c[i3];
                if (bArr != null) {
                    zzfjkVar.m8672a(3, bArr);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int length;
        int iMo8448b = super.mo8448b();
        if (this.f7810a == null || this.f7810a.length <= 0) {
            length = iMo8448b;
        } else {
            int iM8646a = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.f7810a.length; i2++) {
                String str = this.f7810a[i2];
                if (str != null) {
                    i++;
                    iM8646a += zzfjk.m8646a(str);
                }
            }
            length = iMo8448b + iM8646a + (i * 1);
        }
        if (this.f7811b != null && this.f7811b.length > 0) {
            int iM8642a = 0;
            for (int i3 = 0; i3 < this.f7811b.length; i3++) {
                iM8642a += zzfjk.m8642a(this.f7811b[i3]);
            }
            length = length + iM8642a + (this.f7811b.length * 1);
        }
        if (this.f7812c == null || this.f7812c.length <= 0) {
            return length;
        }
        int iM8655b = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f7812c.length; i5++) {
            byte[] bArr = this.f7812c[i5];
            if (bArr != null) {
                i4++;
                iM8655b += zzfjk.m8655b(bArr);
            }
        }
        return length + iM8655b + (i4 * 1);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdmz)) {
            return false;
        }
        zzdmz zzdmzVar = (zzdmz) obj;
        if (zzfjq.m8703a(this.f7810a, zzdmzVar.f7810a) && zzfjq.m8701a(this.f7811b, zzdmzVar.f7811b) && zzfjq.m8704a(this.f7812c, zzdmzVar.f7812c)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzdmzVar.f7951H == null || zzdmzVar.f7951H.m8690b() : this.f7951H.equals(zzdmzVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7951H == null || this.f7951H.m8690b()) ? 0 : this.f7951H.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzfjq.m8698a(this.f7810a)) * 31) + zzfjq.m8696a(this.f7811b)) * 31) + zzfjq.m8699a(this.f7812c)) * 31);
    }
}
