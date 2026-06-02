package com.fasterxml.jackson.core.p000io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;

/* JADX INFO: loaded from: classes.dex */
public class IOContext {

    /* JADX INFO: renamed from: a */
    protected final Object f5474a;

    /* JADX INFO: renamed from: b */
    protected JsonEncoding f5475b;

    /* JADX INFO: renamed from: c */
    protected final boolean f5476c;

    /* JADX INFO: renamed from: d */
    protected final BufferRecycler f5477d;

    /* JADX INFO: renamed from: e */
    protected byte[] f5478e = null;

    /* JADX INFO: renamed from: f */
    protected byte[] f5479f = null;

    /* JADX INFO: renamed from: g */
    protected byte[] f5480g = null;

    /* JADX INFO: renamed from: h */
    protected char[] f5481h = null;

    /* JADX INFO: renamed from: i */
    protected char[] f5482i = null;

    /* JADX INFO: renamed from: j */
    protected char[] f5483j = null;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z) {
        this.f5477d = bufferRecycler;
        this.f5474a = obj;
        this.f5476c = z;
    }

    /* JADX INFO: renamed from: a */
    public void m6156a(JsonEncoding jsonEncoding) {
        this.f5475b = jsonEncoding;
    }

    /* JADX INFO: renamed from: a */
    public Object m6155a() {
        return this.f5474a;
    }

    /* JADX INFO: renamed from: b */
    public JsonEncoding m6163b() {
        return this.f5475b;
    }

    /* JADX INFO: renamed from: c */
    public boolean m6167c() {
        return this.f5476c;
    }

    /* JADX INFO: renamed from: d */
    public TextBuffer m6168d() {
        return new TextBuffer(this.f5477d);
    }

    /* JADX INFO: renamed from: e */
    public byte[] m6169e() {
        m6157a((Object) this.f5478e);
        byte[] bArrM6450a = this.f5477d.m6450a(0);
        this.f5478e = bArrM6450a;
        return bArrM6450a;
    }

    /* JADX INFO: renamed from: f */
    public byte[] m6170f() {
        m6157a((Object) this.f5479f);
        byte[] bArrM6450a = this.f5477d.m6450a(1);
        this.f5479f = bArrM6450a;
        return bArrM6450a;
    }

    /* JADX INFO: renamed from: g */
    public char[] m6171g() {
        m6157a((Object) this.f5481h);
        char[] cArrM6452b = this.f5477d.m6452b(0);
        this.f5481h = cArrM6452b;
        return cArrM6452b;
    }

    /* JADX INFO: renamed from: a */
    public char[] m6162a(int i) {
        m6157a((Object) this.f5481h);
        char[] cArrM6453b = this.f5477d.m6453b(0, i);
        this.f5481h = cArrM6453b;
        return cArrM6453b;
    }

    /* JADX INFO: renamed from: h */
    public char[] m6172h() {
        m6157a((Object) this.f5482i);
        char[] cArrM6452b = this.f5477d.m6452b(1);
        this.f5482i = cArrM6452b;
        return cArrM6452b;
    }

    /* JADX INFO: renamed from: a */
    public void m6158a(byte[] bArr) {
        if (bArr != null) {
            m6159a(bArr, this.f5478e);
            this.f5478e = null;
            this.f5477d.m6448a(0, bArr);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6164b(byte[] bArr) {
        if (bArr != null) {
            m6159a(bArr, this.f5479f);
            this.f5479f = null;
            this.f5477d.m6448a(1, bArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6160a(char[] cArr) {
        if (cArr != null) {
            m6161a(cArr, this.f5481h);
            this.f5481h = null;
            this.f5477d.m6449a(0, cArr);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6165b(char[] cArr) {
        if (cArr != null) {
            m6161a(cArr, this.f5482i);
            this.f5482i = null;
            this.f5477d.m6449a(1, cArr);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6166c(char[] cArr) {
        if (cArr != null) {
            m6161a(cArr, this.f5483j);
            this.f5483j = null;
            this.f5477d.m6449a(3, cArr);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m6157a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m6159a(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length <= bArr2.length) {
            throw m6154i();
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m6161a(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length <= cArr2.length) {
            throw m6154i();
        }
    }

    /* JADX INFO: renamed from: i */
    private IllegalArgumentException m6154i() {
        return new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
}
