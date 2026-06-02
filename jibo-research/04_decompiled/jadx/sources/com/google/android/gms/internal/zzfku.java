package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfku extends zzfjm<zzfku> {

    /* JADX INFO: renamed from: a */
    public String f8024a = "";

    /* JADX INFO: renamed from: b */
    public String f8025b = "";

    /* JADX INFO: renamed from: c */
    public long f8026c = 0;

    /* JADX INFO: renamed from: d */
    public String f8027d = "";

    /* JADX INFO: renamed from: e */
    public long f8028e = 0;

    /* JADX INFO: renamed from: f */
    public long f8029f = 0;

    /* JADX INFO: renamed from: g */
    public String f8030g = "";

    /* JADX INFO: renamed from: h */
    public String f8031h = "";

    /* JADX INFO: renamed from: i */
    public String f8032i = "";

    /* JADX INFO: renamed from: j */
    public String f8033j = "";

    /* JADX INFO: renamed from: k */
    public String f8034k = "";

    /* JADX INFO: renamed from: l */
    public int f8035l = 0;

    /* JADX INFO: renamed from: m */
    public zzfkt[] f8036m = zzfkt.m8729a();

    public zzfku() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzfku m8730a(byte[] bArr) throws zzfjr {
        return (zzfku) zzfjs.m8709a(new zzfku(), bArr);
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
                    this.f8024a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f8025b = zzfjjVar.m8632e();
                    break;
                case 24:
                    this.f8026c = zzfjjVar.m8625b();
                    break;
                case 34:
                    this.f8027d = zzfjjVar.m8632e();
                    break;
                case 40:
                    this.f8028e = zzfjjVar.m8625b();
                    break;
                case 48:
                    this.f8029f = zzfjjVar.m8625b();
                    break;
                case 58:
                    this.f8030g = zzfjjVar.m8632e();
                    break;
                case 66:
                    this.f8031h = zzfjjVar.m8632e();
                    break;
                case 74:
                    this.f8032i = zzfjjVar.m8632e();
                    break;
                case 82:
                    this.f8033j = zzfjjVar.m8632e();
                    break;
                case 90:
                    this.f8034k = zzfjjVar.m8632e();
                    break;
                case 96:
                    this.f8035l = zzfjjVar.m8628c();
                    break;
                case 106:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 106);
                    int length = this.f8036m == null ? 0 : this.f8036m.length;
                    zzfkt[] zzfktVarArr = new zzfkt[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f8036m, 0, zzfktVarArr, 0, length);
                    }
                    while (length < zzfktVarArr.length - 1) {
                        zzfktVarArr[length] = new zzfkt();
                        zzfjjVar.m8623a(zzfktVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzfktVarArr[length] = new zzfkt();
                    zzfjjVar.m8623a(zzfktVarArr[length]);
                    this.f8036m = zzfktVarArr;
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
        if (this.f8024a != null && !this.f8024a.equals("")) {
            zzfjkVar.m8670a(1, this.f8024a);
        }
        if (this.f8025b != null && !this.f8025b.equals("")) {
            zzfjkVar.m8670a(2, this.f8025b);
        }
        if (this.f8026c != 0) {
            zzfjkVar.m8674b(3, this.f8026c);
        }
        if (this.f8027d != null && !this.f8027d.equals("")) {
            zzfjkVar.m8670a(4, this.f8027d);
        }
        if (this.f8028e != 0) {
            zzfjkVar.m8674b(5, this.f8028e);
        }
        if (this.f8029f != 0) {
            zzfjkVar.m8674b(6, this.f8029f);
        }
        if (this.f8030g != null && !this.f8030g.equals("")) {
            zzfjkVar.m8670a(7, this.f8030g);
        }
        if (this.f8031h != null && !this.f8031h.equals("")) {
            zzfjkVar.m8670a(8, this.f8031h);
        }
        if (this.f8032i != null && !this.f8032i.equals("")) {
            zzfjkVar.m8670a(9, this.f8032i);
        }
        if (this.f8033j != null && !this.f8033j.equals("")) {
            zzfjkVar.m8670a(10, this.f8033j);
        }
        if (this.f8034k != null && !this.f8034k.equals("")) {
            zzfjkVar.m8670a(11, this.f8034k);
        }
        if (this.f8035l != 0) {
            zzfjkVar.m8667a(12, this.f8035l);
        }
        if (this.f8036m != null && this.f8036m.length > 0) {
            for (int i = 0; i < this.f8036m.length; i++) {
                zzfkt zzfktVar = this.f8036m[i];
                if (zzfktVar != null) {
                    zzfjkVar.m8669a(13, zzfktVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f8024a != null && !this.f8024a.equals("")) {
            iMo8448b += zzfjk.m8653b(1, this.f8024a);
        }
        if (this.f8025b != null && !this.f8025b.equals("")) {
            iMo8448b += zzfjk.m8653b(2, this.f8025b);
        }
        if (this.f8026c != 0) {
            iMo8448b += zzfjk.m8660d(3, this.f8026c);
        }
        if (this.f8027d != null && !this.f8027d.equals("")) {
            iMo8448b += zzfjk.m8653b(4, this.f8027d);
        }
        if (this.f8028e != 0) {
            iMo8448b += zzfjk.m8660d(5, this.f8028e);
        }
        if (this.f8029f != 0) {
            iMo8448b += zzfjk.m8660d(6, this.f8029f);
        }
        if (this.f8030g != null && !this.f8030g.equals("")) {
            iMo8448b += zzfjk.m8653b(7, this.f8030g);
        }
        if (this.f8031h != null && !this.f8031h.equals("")) {
            iMo8448b += zzfjk.m8653b(8, this.f8031h);
        }
        if (this.f8032i != null && !this.f8032i.equals("")) {
            iMo8448b += zzfjk.m8653b(9, this.f8032i);
        }
        if (this.f8033j != null && !this.f8033j.equals("")) {
            iMo8448b += zzfjk.m8653b(10, this.f8033j);
        }
        if (this.f8034k != null && !this.f8034k.equals("")) {
            iMo8448b += zzfjk.m8653b(11, this.f8034k);
        }
        if (this.f8035l != 0) {
            iMo8448b += zzfjk.m8651b(12, this.f8035l);
        }
        if (this.f8036m == null || this.f8036m.length <= 0) {
            return iMo8448b;
        }
        int iM8652b = iMo8448b;
        for (int i = 0; i < this.f8036m.length; i++) {
            zzfkt zzfktVar = this.f8036m[i];
            if (zzfktVar != null) {
                iM8652b += zzfjk.m8652b(13, zzfktVar);
            }
        }
        return iM8652b;
    }
}
