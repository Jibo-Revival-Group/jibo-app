package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfjs {

    /* JADX INFO: renamed from: I */
    protected volatile int f7967I = -1;

    /* JADX INFO: renamed from: a */
    public static final <T extends zzfjs> T m8709a(T t, byte[] bArr) throws zzfjr {
        return (T) m8710a(t, bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    private static <T extends zzfjs> T m8710a(T t, byte[] bArr, int i, int i2) throws zzfjr {
        try {
            zzfjj zzfjjVarM8617a = zzfjj.m8617a(bArr, 0, i2);
            t.mo8446a(zzfjjVarM8617a);
            zzfjjVarM8617a.m8622a(0);
            return t;
        } catch (zzfjr e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final byte[] m8711a(zzfjs zzfjsVar) {
        byte[] bArr = new byte[zzfjsVar.m8713f()];
        try {
            zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
            zzfjsVar.mo8447a(zzfjkVarM8648a);
            zzfjkVarM8648a.m8664a();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract zzfjs mo8446a(zzfjj zzfjjVar) throws IOException;

    /* JADX INFO: renamed from: a */
    public void mo8447a(zzfjk zzfjkVar) throws IOException {
    }

    /* JADX INFO: renamed from: b */
    protected int mo8448b() {
        return 0;
    }

    @Override // 
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public zzfjs clone() throws CloneNotSupportedException {
        return (zzfjs) super.clone();
    }

    /* JADX INFO: renamed from: e */
    public final int m8712e() {
        if (this.f7967I < 0) {
            m8713f();
        }
        return this.f7967I;
    }

    /* JADX INFO: renamed from: f */
    public final int m8713f() {
        int iMo8448b = mo8448b();
        this.f7967I = iMo8448b;
        return iMo8448b;
    }

    public String toString() {
        return zzfjt.m8714a(this);
    }
}
