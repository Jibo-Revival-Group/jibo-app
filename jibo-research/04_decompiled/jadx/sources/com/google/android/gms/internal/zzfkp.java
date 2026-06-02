package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkp extends zzfjm<zzfkp> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private byte[] f7990a = zzfjv.f7977h;

    /* JADX INFO: renamed from: b */
    private String f7991b = "";

    /* JADX INFO: renamed from: c */
    private byte[][] f7992c = zzfjv.f7976g;

    /* JADX INFO: renamed from: d */
    private boolean f7993d = false;

    public zzfkp() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzfkp clone() {
        try {
            zzfkp zzfkpVar = (zzfkp) super.clone();
            if (this.f7992c != null && this.f7992c.length > 0) {
                zzfkpVar.f7992c = (byte[][]) this.f7992c.clone();
            }
            return zzfkpVar;
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
                    this.f7990a = zzfjjVar.m8634f();
                    break;
                case 18:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 18);
                    int length = this.f7992c == null ? 0 : this.f7992c.length;
                    byte[][] bArr = new byte[iM8719a + length][];
                    if (length != 0) {
                        System.arraycopy(this.f7992c, 0, bArr, 0, length);
                    }
                    while (length < bArr.length - 1) {
                        bArr[length] = zzfjjVar.m8634f();
                        zzfjjVar.m8621a();
                        length++;
                    }
                    bArr[length] = zzfjjVar.m8634f();
                    this.f7992c = bArr;
                    break;
                case 24:
                    this.f7993d = zzfjjVar.m8631d();
                    break;
                case 34:
                    this.f7991b = zzfjjVar.m8632e();
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
        if (!Arrays.equals(this.f7990a, zzfjv.f7977h)) {
            zzfjkVar.m8672a(1, this.f7990a);
        }
        if (this.f7992c != null && this.f7992c.length > 0) {
            for (int i = 0; i < this.f7992c.length; i++) {
                byte[] bArr = this.f7992c[i];
                if (bArr != null) {
                    zzfjkVar.m8672a(2, bArr);
                }
            }
        }
        if (this.f7993d) {
            zzfjkVar.m8671a(3, this.f7993d);
        }
        if (this.f7991b != null && !this.f7991b.equals("")) {
            zzfjkVar.m8670a(4, this.f7991b);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (!Arrays.equals(this.f7990a, zzfjv.f7977h)) {
            iMo8448b += zzfjk.m8654b(1, this.f7990a);
        }
        if (this.f7992c != null && this.f7992c.length > 0) {
            int iM8655b = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.f7992c.length; i2++) {
                byte[] bArr = this.f7992c[i2];
                if (bArr != null) {
                    i++;
                    iM8655b += zzfjk.m8655b(bArr);
                }
            }
            iMo8448b = iMo8448b + iM8655b + (i * 1);
        }
        if (this.f7993d) {
            iMo8448b += zzfjk.m8650b(3) + 1;
        }
        return (this.f7991b == null || this.f7991b.equals("")) ? iMo8448b : iMo8448b + zzfjk.m8653b(4, this.f7991b);
    }

    @Override // com.google.android.gms.internal.zzfjm
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ zzfjm clone() throws CloneNotSupportedException {
        return (zzfkp) clone();
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfkp) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkp)) {
            return false;
        }
        zzfkp zzfkpVar = (zzfkp) obj;
        if (!Arrays.equals(this.f7990a, zzfkpVar.f7990a)) {
            return false;
        }
        if (this.f7991b == null) {
            if (zzfkpVar.f7991b != null) {
                return false;
            }
        } else if (!this.f7991b.equals(zzfkpVar.f7991b)) {
            return false;
        }
        if (zzfjq.m8704a(this.f7992c, zzfkpVar.f7992c) && this.f7993d == zzfkpVar.f7993d) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzfkpVar.f7951H == null || zzfkpVar.f7951H.m8690b() : this.f7951H.equals(zzfkpVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7993d ? 1231 : 1237) + (((((this.f7991b == null ? 0 : this.f7991b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f7990a)) * 31)) * 31) + zzfjq.m8699a(this.f7992c)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
