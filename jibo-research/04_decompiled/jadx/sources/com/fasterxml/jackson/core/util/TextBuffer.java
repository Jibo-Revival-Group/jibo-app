package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.p000io.NumberInput;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class TextBuffer {

    /* JADX INFO: renamed from: a */
    static final char[] f5678a = new char[0];

    /* JADX INFO: renamed from: b */
    private final BufferRecycler f5679b;

    /* JADX INFO: renamed from: c */
    private char[] f5680c;

    /* JADX INFO: renamed from: d */
    private int f5681d;

    /* JADX INFO: renamed from: e */
    private int f5682e;

    /* JADX INFO: renamed from: f */
    private ArrayList<char[]> f5683f;

    /* JADX INFO: renamed from: g */
    private boolean f5684g = false;

    /* JADX INFO: renamed from: h */
    private int f5685h;

    /* JADX INFO: renamed from: i */
    private char[] f5686i;

    /* JADX INFO: renamed from: j */
    private int f5687j;

    /* JADX INFO: renamed from: k */
    private String f5688k;

    /* JADX INFO: renamed from: l */
    private char[] f5689l;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this.f5679b = bufferRecycler;
    }

    /* JADX INFO: renamed from: a */
    public void m6474a() {
        if (this.f5679b == null) {
            m6479b();
        } else if (this.f5686i != null) {
            m6479b();
            char[] cArr = this.f5686i;
            this.f5686i = null;
            this.f5679b.m6449a(2, cArr);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6479b() {
        this.f5681d = -1;
        this.f5687j = 0;
        this.f5682e = 0;
        this.f5680c = null;
        this.f5688k = null;
        this.f5689l = null;
        if (this.f5684g) {
            m6472o();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6477a(char[] cArr, int i, int i2) {
        this.f5688k = null;
        this.f5689l = null;
        this.f5680c = cArr;
        this.f5681d = i;
        this.f5682e = i2;
        if (this.f5684g) {
            m6472o();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6480b(char[] cArr, int i, int i2) {
        this.f5680c = null;
        this.f5681d = -1;
        this.f5682e = 0;
        this.f5688k = null;
        this.f5689l = null;
        if (this.f5684g) {
            m6472o();
        } else if (this.f5686i == null) {
            this.f5686i = m6468c(i2);
        }
        this.f5685h = 0;
        this.f5687j = 0;
        m6482c(cArr, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m6476a(String str) {
        this.f5680c = null;
        this.f5681d = -1;
        this.f5682e = 0;
        this.f5688k = str;
        this.f5689l = null;
        if (this.f5684g) {
            m6472o();
        }
        this.f5687j = 0;
    }

    /* JADX INFO: renamed from: c */
    private char[] m6468c(int i) {
        return this.f5679b != null ? this.f5679b.m6453b(2, i) : new char[Math.max(i, 1000)];
    }

    /* JADX INFO: renamed from: o */
    private void m6472o() {
        this.f5684g = false;
        this.f5683f.clear();
        this.f5685h = 0;
        this.f5687j = 0;
    }

    /* JADX INFO: renamed from: c */
    public int m6481c() {
        if (this.f5681d >= 0) {
            return this.f5682e;
        }
        if (this.f5689l != null) {
            return this.f5689l.length;
        }
        if (this.f5688k != null) {
            return this.f5688k.length();
        }
        return this.f5685h + this.f5687j;
    }

    /* JADX INFO: renamed from: d */
    public int m6483d() {
        if (this.f5681d >= 0) {
            return this.f5681d;
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public char[] m6484e() {
        if (this.f5681d >= 0) {
            return this.f5680c;
        }
        if (this.f5689l != null) {
            return this.f5689l;
        }
        if (this.f5688k != null) {
            char[] charArray = this.f5688k.toCharArray();
            this.f5689l = charArray;
            return charArray;
        }
        if (this.f5684g) {
            return m6486g();
        }
        return this.f5686i == null ? f5678a : this.f5686i;
    }

    /* JADX INFO: renamed from: f */
    public String m6485f() {
        if (this.f5688k == null) {
            if (this.f5689l != null) {
                this.f5688k = new String(this.f5689l);
            } else if (this.f5681d >= 0) {
                if (this.f5682e < 1) {
                    this.f5688k = "";
                    return "";
                }
                this.f5688k = new String(this.f5680c, this.f5681d, this.f5682e);
            } else {
                int i = this.f5685h;
                int i2 = this.f5687j;
                if (i == 0) {
                    this.f5688k = i2 == 0 ? "" : new String(this.f5686i, 0, i2);
                } else {
                    StringBuilder sb = new StringBuilder(i + i2);
                    if (this.f5683f != null) {
                        int size = this.f5683f.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            char[] cArr = this.f5683f.get(i3);
                            sb.append(cArr, 0, cArr.length);
                        }
                    }
                    sb.append(this.f5686i, 0, this.f5687j);
                    this.f5688k = sb.toString();
                }
            }
        }
        return this.f5688k;
    }

    /* JADX INFO: renamed from: g */
    public char[] m6486g() {
        char[] cArr = this.f5689l;
        if (cArr == null) {
            char[] cArrM6473p = m6473p();
            this.f5689l = cArrM6473p;
            return cArrM6473p;
        }
        return cArr;
    }

    /* JADX INFO: renamed from: h */
    public BigDecimal m6487h() throws NumberFormatException {
        if (this.f5689l != null) {
            return NumberInput.m6182a(this.f5689l);
        }
        if (this.f5681d >= 0 && this.f5680c != null) {
            return NumberInput.m6187c(this.f5680c, this.f5681d, this.f5682e);
        }
        if (this.f5685h == 0 && this.f5686i != null) {
            return NumberInput.m6187c(this.f5686i, 0, this.f5687j);
        }
        return NumberInput.m6182a(m6486g());
    }

    /* JADX INFO: renamed from: i */
    public double m6488i() throws NumberFormatException {
        return NumberInput.m6180a(m6485f());
    }

    /* JADX INFO: renamed from: c */
    public void m6482c(char[] cArr, int i, int i2) {
        if (this.f5681d >= 0) {
            m6469d(i2);
        }
        this.f5688k = null;
        this.f5689l = null;
        char[] cArr2 = this.f5686i;
        int length = cArr2.length - this.f5687j;
        if (length >= i2) {
            System.arraycopy(cArr, i, cArr2, this.f5687j, i2);
            this.f5687j += i2;
            return;
        }
        if (length > 0) {
            System.arraycopy(cArr, i, cArr2, this.f5687j, length);
            i += length;
            i2 -= length;
        }
        do {
            m6470e(i2);
            int iMin = Math.min(this.f5686i.length, i2);
            System.arraycopy(cArr, i, this.f5686i, 0, iMin);
            this.f5687j += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    /* JADX INFO: renamed from: j */
    public char[] m6489j() {
        if (this.f5681d >= 0) {
            m6469d(1);
        } else {
            char[] cArr = this.f5686i;
            if (cArr == null) {
                this.f5686i = m6468c(0);
            } else if (this.f5687j >= cArr.length) {
                m6470e(1);
            }
        }
        return this.f5686i;
    }

    /* JADX INFO: renamed from: k */
    public char[] m6490k() {
        this.f5681d = -1;
        this.f5687j = 0;
        this.f5682e = 0;
        this.f5680c = null;
        this.f5688k = null;
        this.f5689l = null;
        if (this.f5684g) {
            m6472o();
        }
        char[] cArr = this.f5686i;
        if (cArr == null) {
            char[] cArrM6468c = m6468c(0);
            this.f5686i = cArrM6468c;
            return cArrM6468c;
        }
        return cArr;
    }

    /* JADX INFO: renamed from: l */
    public int m6491l() {
        return this.f5687j;
    }

    /* JADX INFO: renamed from: a */
    public void m6475a(int i) {
        this.f5687j = i;
    }

    /* JADX INFO: renamed from: b */
    public String m6478b(int i) {
        this.f5687j = i;
        if (this.f5685h > 0) {
            return m6485f();
        }
        int i2 = this.f5687j;
        String str = i2 == 0 ? "" : new String(this.f5686i, 0, i2);
        this.f5688k = str;
        return str;
    }

    /* JADX INFO: renamed from: m */
    public char[] m6492m() {
        int i = 1000;
        if (this.f5683f == null) {
            this.f5683f = new ArrayList<>();
        }
        this.f5684g = true;
        this.f5683f.add(this.f5686i);
        int length = this.f5686i.length;
        this.f5685h += length;
        this.f5687j = 0;
        int i2 = length + (length >> 1);
        if (i2 >= 1000) {
            i = i2 > 262144 ? 262144 : i2;
        }
        char[] cArrM6471f = m6471f(i);
        this.f5686i = cArrM6471f;
        return cArrM6471f;
    }

    /* JADX INFO: renamed from: n */
    public char[] m6493n() {
        char[] cArr = this.f5686i;
        int length = cArr.length;
        int i = (length >> 1) + length;
        if (i > 262144) {
            i = (length >> 2) + length;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i);
        this.f5686i = cArrCopyOf;
        return cArrCopyOf;
    }

    public String toString() {
        return m6485f();
    }

    /* JADX INFO: renamed from: d */
    private void m6469d(int i) {
        int i2 = this.f5682e;
        this.f5682e = 0;
        char[] cArr = this.f5680c;
        this.f5680c = null;
        int i3 = this.f5681d;
        this.f5681d = -1;
        int i4 = i2 + i;
        if (this.f5686i == null || i4 > this.f5686i.length) {
            this.f5686i = m6468c(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.f5686i, 0, i2);
        }
        this.f5685h = 0;
        this.f5687j = i2;
    }

    /* JADX INFO: renamed from: e */
    private void m6470e(int i) {
        int i2 = 1000;
        if (this.f5683f == null) {
            this.f5683f = new ArrayList<>();
        }
        char[] cArr = this.f5686i;
        this.f5684g = true;
        this.f5683f.add(cArr);
        this.f5685h += cArr.length;
        this.f5687j = 0;
        int length = cArr.length;
        int i3 = length + (length >> 1);
        if (i3 >= 1000) {
            i2 = i3 > 262144 ? 262144 : i3;
        }
        this.f5686i = m6471f(i2);
    }

    /* JADX INFO: renamed from: p */
    private char[] m6473p() {
        int i;
        if (this.f5688k != null) {
            return this.f5688k.toCharArray();
        }
        if (this.f5681d >= 0) {
            int i2 = this.f5682e;
            if (i2 < 1) {
                return f5678a;
            }
            int i3 = this.f5681d;
            if (i3 == 0) {
                return Arrays.copyOf(this.f5680c, i2);
            }
            return Arrays.copyOfRange(this.f5680c, i3, i2 + i3);
        }
        int iM6481c = m6481c();
        if (iM6481c < 1) {
            return f5678a;
        }
        char[] cArrM6471f = m6471f(iM6481c);
        if (this.f5683f != null) {
            int size = this.f5683f.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                char[] cArr = this.f5683f.get(i5);
                int length = cArr.length;
                System.arraycopy(cArr, 0, cArrM6471f, i4, length);
                i4 += length;
            }
            i = i4;
        } else {
            i = 0;
        }
        System.arraycopy(this.f5686i, 0, cArrM6471f, i, this.f5687j);
        return cArrM6471f;
    }

    /* JADX INFO: renamed from: f */
    private char[] m6471f(int i) {
        return new char[i];
    }
}
