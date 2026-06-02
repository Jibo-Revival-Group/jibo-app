package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkn extends zzfjm<zzfkn> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private String[] f7982a = zzfjv.f7975f;

    /* JADX INFO: renamed from: b */
    private String[] f7983b = zzfjv.f7975f;

    /* JADX INFO: renamed from: c */
    private int[] f7984c = zzfjv.f7970a;

    /* JADX INFO: renamed from: d */
    private long[] f7985d = zzfjv.f7971b;

    /* JADX INFO: renamed from: e */
    private long[] f7986e = zzfjv.f7971b;

    public zzfkn() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzfkn clone() {
        try {
            zzfkn zzfknVar = (zzfkn) super.clone();
            if (this.f7982a != null && this.f7982a.length > 0) {
                zzfknVar.f7982a = (String[]) this.f7982a.clone();
            }
            if (this.f7983b != null && this.f7983b.length > 0) {
                zzfknVar.f7983b = (String[]) this.f7983b.clone();
            }
            if (this.f7984c != null && this.f7984c.length > 0) {
                zzfknVar.f7984c = (int[]) this.f7984c.clone();
            }
            if (this.f7985d != null && this.f7985d.length > 0) {
                zzfknVar.f7985d = (long[]) this.f7985d.clone();
            }
            if (this.f7986e != null && this.f7986e.length > 0) {
                zzfknVar.f7986e = (long[]) this.f7986e.clone();
            }
            return zzfknVar;
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
                case 10:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 10);
                    int length = this.f7982a == null ? 0 : this.f7982a.length;
                    String[] strArr = new String[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7982a, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzfjjVar.m8632e();
                        zzfjjVar.m8621a();
                        length++;
                    }
                    strArr[length] = zzfjjVar.m8632e();
                    this.f7982a = strArr;
                    break;
                case 18:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 18);
                    int length2 = this.f7983b == null ? 0 : this.f7983b.length;
                    String[] strArr2 = new String[iM8719a2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7983b, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = zzfjjVar.m8632e();
                        zzfjjVar.m8621a();
                        length2++;
                    }
                    strArr2[length2] = zzfjjVar.m8632e();
                    this.f7983b = strArr2;
                    break;
                case 24:
                    int iM8719a3 = zzfjv.m8719a(zzfjjVar, 24);
                    int length3 = this.f7984c == null ? 0 : this.f7984c.length;
                    int[] iArr = new int[iM8719a3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.f7984c, 0, iArr, 0, length3);
                    }
                    while (length3 < iArr.length - 1) {
                        iArr[length3] = zzfjjVar.m8628c();
                        zzfjjVar.m8621a();
                        length3++;
                    }
                    iArr[length3] = zzfjjVar.m8628c();
                    this.f7984c = iArr;
                    break;
                case 26:
                    int iM8629c = zzfjjVar.m8629c(zzfjjVar.m8636h());
                    int iM8641m = zzfjjVar.m8641m();
                    int i = 0;
                    while (zzfjjVar.m8640l() > 0) {
                        zzfjjVar.m8628c();
                        i++;
                    }
                    zzfjjVar.m8633e(iM8641m);
                    int length4 = this.f7984c == null ? 0 : this.f7984c.length;
                    int[] iArr2 = new int[i + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.f7984c, 0, iArr2, 0, length4);
                    }
                    while (length4 < iArr2.length) {
                        iArr2[length4] = zzfjjVar.m8628c();
                        length4++;
                    }
                    this.f7984c = iArr2;
                    zzfjjVar.m8630d(iM8629c);
                    break;
                case 32:
                    int iM8719a4 = zzfjv.m8719a(zzfjjVar, 32);
                    int length5 = this.f7985d == null ? 0 : this.f7985d.length;
                    long[] jArr = new long[iM8719a4 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.f7985d, 0, jArr, 0, length5);
                    }
                    while (length5 < jArr.length - 1) {
                        jArr[length5] = zzfjjVar.m8625b();
                        zzfjjVar.m8621a();
                        length5++;
                    }
                    jArr[length5] = zzfjjVar.m8625b();
                    this.f7985d = jArr;
                    break;
                case 34:
                    int iM8629c2 = zzfjjVar.m8629c(zzfjjVar.m8636h());
                    int iM8641m2 = zzfjjVar.m8641m();
                    int i2 = 0;
                    while (zzfjjVar.m8640l() > 0) {
                        zzfjjVar.m8625b();
                        i2++;
                    }
                    zzfjjVar.m8633e(iM8641m2);
                    int length6 = this.f7985d == null ? 0 : this.f7985d.length;
                    long[] jArr2 = new long[i2 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.f7985d, 0, jArr2, 0, length6);
                    }
                    while (length6 < jArr2.length) {
                        jArr2[length6] = zzfjjVar.m8625b();
                        length6++;
                    }
                    this.f7985d = jArr2;
                    zzfjjVar.m8630d(iM8629c2);
                    break;
                case 40:
                    int iM8719a5 = zzfjv.m8719a(zzfjjVar, 40);
                    int length7 = this.f7986e == null ? 0 : this.f7986e.length;
                    long[] jArr3 = new long[iM8719a5 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.f7986e, 0, jArr3, 0, length7);
                    }
                    while (length7 < jArr3.length - 1) {
                        jArr3[length7] = zzfjjVar.m8625b();
                        zzfjjVar.m8621a();
                        length7++;
                    }
                    jArr3[length7] = zzfjjVar.m8625b();
                    this.f7986e = jArr3;
                    break;
                case 42:
                    int iM8629c3 = zzfjjVar.m8629c(zzfjjVar.m8636h());
                    int iM8641m3 = zzfjjVar.m8641m();
                    int i3 = 0;
                    while (zzfjjVar.m8640l() > 0) {
                        zzfjjVar.m8625b();
                        i3++;
                    }
                    zzfjjVar.m8633e(iM8641m3);
                    int length8 = this.f7986e == null ? 0 : this.f7986e.length;
                    long[] jArr4 = new long[i3 + length8];
                    if (length8 != 0) {
                        System.arraycopy(this.f7986e, 0, jArr4, 0, length8);
                    }
                    while (length8 < jArr4.length) {
                        jArr4[length8] = zzfjjVar.m8625b();
                        length8++;
                    }
                    this.f7986e = jArr4;
                    zzfjjVar.m8630d(iM8629c3);
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
        if (this.f7982a != null && this.f7982a.length > 0) {
            for (int i = 0; i < this.f7982a.length; i++) {
                String str = this.f7982a[i];
                if (str != null) {
                    zzfjkVar.m8670a(1, str);
                }
            }
        }
        if (this.f7983b != null && this.f7983b.length > 0) {
            for (int i2 = 0; i2 < this.f7983b.length; i2++) {
                String str2 = this.f7983b[i2];
                if (str2 != null) {
                    zzfjkVar.m8670a(2, str2);
                }
            }
        }
        if (this.f7984c != null && this.f7984c.length > 0) {
            for (int i3 = 0; i3 < this.f7984c.length; i3++) {
                zzfjkVar.m8667a(3, this.f7984c[i3]);
            }
        }
        if (this.f7985d != null && this.f7985d.length > 0) {
            for (int i4 = 0; i4 < this.f7985d.length; i4++) {
                zzfjkVar.m8674b(4, this.f7985d[i4]);
            }
        }
        if (this.f7986e != null && this.f7986e.length > 0) {
            for (int i5 = 0; i5 < this.f7986e.length; i5++) {
                zzfjkVar.m8674b(5, this.f7986e[i5]);
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int length;
        int iMo8448b = super.mo8448b();
        if (this.f7982a == null || this.f7982a.length <= 0) {
            length = iMo8448b;
        } else {
            int iM8646a = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.f7982a.length; i2++) {
                String str = this.f7982a[i2];
                if (str != null) {
                    i++;
                    iM8646a += zzfjk.m8646a(str);
                }
            }
            length = iMo8448b + iM8646a + (i * 1);
        }
        if (this.f7983b != null && this.f7983b.length > 0) {
            int iM8646a2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f7983b.length; i4++) {
                String str2 = this.f7983b[i4];
                if (str2 != null) {
                    i3++;
                    iM8646a2 += zzfjk.m8646a(str2);
                }
            }
            length = length + iM8646a2 + (i3 * 1);
        }
        if (this.f7984c != null && this.f7984c.length > 0) {
            int iM8642a = 0;
            for (int i5 = 0; i5 < this.f7984c.length; i5++) {
                iM8642a += zzfjk.m8642a(this.f7984c[i5]);
            }
            length = length + iM8642a + (this.f7984c.length * 1);
        }
        if (this.f7985d != null && this.f7985d.length > 0) {
            int iM8643a = 0;
            for (int i6 = 0; i6 < this.f7985d.length; i6++) {
                iM8643a += zzfjk.m8643a(this.f7985d[i6]);
            }
            length = length + iM8643a + (this.f7985d.length * 1);
        }
        if (this.f7986e == null || this.f7986e.length <= 0) {
            return length;
        }
        int iM8643a2 = 0;
        for (int i7 = 0; i7 < this.f7986e.length; i7++) {
            iM8643a2 += zzfjk.m8643a(this.f7986e[i7]);
        }
        return length + iM8643a2 + (this.f7986e.length * 1);
    }

    @Override // com.google.android.gms.internal.zzfjm
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ zzfjm clone() throws CloneNotSupportedException {
        return (zzfkn) clone();
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfkn) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkn)) {
            return false;
        }
        zzfkn zzfknVar = (zzfkn) obj;
        if (zzfjq.m8703a(this.f7982a, zzfknVar.f7982a) && zzfjq.m8703a(this.f7983b, zzfknVar.f7983b) && zzfjq.m8701a(this.f7984c, zzfknVar.f7984c) && zzfjq.m8702a(this.f7985d, zzfknVar.f7985d) && zzfjq.m8702a(this.f7986e, zzfknVar.f7986e)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzfknVar.f7951H == null || zzfknVar.f7951H.m8690b() : this.f7951H.equals(zzfknVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7951H == null || this.f7951H.m8690b()) ? 0 : this.f7951H.hashCode()) + ((((((((((((getClass().getName().hashCode() + 527) * 31) + zzfjq.m8698a(this.f7982a)) * 31) + zzfjq.m8698a(this.f7983b)) * 31) + zzfjq.m8696a(this.f7984c)) * 31) + zzfjq.m8697a(this.f7985d)) * 31) + zzfjq.m8697a(this.f7986e)) * 31);
    }
}
