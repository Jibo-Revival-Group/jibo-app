package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjj {

    /* JADX INFO: renamed from: a */
    private final byte[] f7939a;

    /* JADX INFO: renamed from: b */
    private final int f7940b;

    /* JADX INFO: renamed from: c */
    private final int f7941c;

    /* JADX INFO: renamed from: d */
    private int f7942d;

    /* JADX INFO: renamed from: e */
    private int f7943e;

    /* JADX INFO: renamed from: f */
    private int f7944f;

    /* JADX INFO: renamed from: g */
    private int f7945g;

    /* JADX INFO: renamed from: i */
    private int f7947i;

    /* JADX INFO: renamed from: h */
    private int f7946h = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: j */
    private int f7948j = 64;

    /* JADX INFO: renamed from: k */
    private int f7949k = 67108864;

    private zzfjj(byte[] bArr, int i, int i2) {
        this.f7939a = bArr;
        this.f7940b = i;
        int i3 = i + i2;
        this.f7942d = i3;
        this.f7941c = i3;
        this.f7944f = i;
    }

    /* JADX INFO: renamed from: a */
    public static zzfjj m8617a(byte[] bArr, int i, int i2) {
        return new zzfjj(bArr, 0, i2);
    }

    /* JADX INFO: renamed from: f */
    private final void m8618f(int i) throws IOException {
        if (i < 0) {
            throw zzfjr.m8706b();
        }
        if (this.f7944f + i > this.f7946h) {
            m8618f(this.f7946h - this.f7944f);
            throw zzfjr.m8705a();
        }
        if (i > this.f7942d - this.f7944f) {
            throw zzfjr.m8705a();
        }
        this.f7944f += i;
    }

    /* JADX INFO: renamed from: n */
    private final void m8619n() {
        this.f7942d += this.f7943e;
        int i = this.f7942d;
        if (i <= this.f7946h) {
            this.f7943e = 0;
        } else {
            this.f7943e = i - this.f7946h;
            this.f7942d -= this.f7943e;
        }
    }

    /* JADX INFO: renamed from: o */
    private final byte m8620o() throws IOException {
        if (this.f7944f == this.f7942d) {
            throw zzfjr.m8705a();
        }
        byte[] bArr = this.f7939a;
        int i = this.f7944f;
        this.f7944f = i + 1;
        return bArr[i];
    }

    /* JADX INFO: renamed from: a */
    public final int m8621a() throws IOException {
        if (this.f7944f == this.f7942d) {
            this.f7945g = 0;
            return 0;
        }
        this.f7945g = m8636h();
        if (this.f7945g == 0) {
            throw new zzfjr("Protocol message contained an invalid tag (zero).");
        }
        return this.f7945g;
    }

    /* JADX INFO: renamed from: a */
    public final void m8622a(int i) throws zzfjr {
        if (this.f7945g != i) {
            throw new zzfjr("Protocol message end-group tag did not match expected tag.");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8623a(zzfjs zzfjsVar) throws IOException {
        int iM8636h = m8636h();
        if (this.f7947i >= this.f7948j) {
            throw zzfjr.m8708d();
        }
        int iM8629c = m8629c(iM8636h);
        this.f7947i++;
        zzfjsVar.mo8446a(this);
        m8622a(0);
        this.f7947i--;
        m8630d(iM8629c);
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m8624a(int i, int i2) {
        if (i2 == 0) {
            return zzfjv.f7977h;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f7939a, this.f7940b + i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: renamed from: b */
    public final long m8625b() throws IOException {
        return m8637i();
    }

    /* JADX INFO: renamed from: b */
    final void m8626b(int i, int i2) {
        if (i > this.f7944f - this.f7940b) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.f7944f - this.f7940b).toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        }
        this.f7944f = this.f7940b + i;
        this.f7945g = i2;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8627b(int i) throws IOException {
        int iM8621a;
        switch (i & 7) {
            case 0:
                m8636h();
                return true;
            case 1:
                m8639k();
                return true;
            case 2:
                m8618f(m8636h());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m8638j();
                return true;
            default:
                throw new zzfjr("Protocol message tag had invalid wire type.");
        }
        do {
            iM8621a = m8621a();
            if (iM8621a != 0) {
            }
            m8622a(((i >>> 3) << 3) | 4);
            return true;
        } while (m8627b(iM8621a));
        m8622a(((i >>> 3) << 3) | 4);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final int m8628c() throws IOException {
        return m8636h();
    }

    /* JADX INFO: renamed from: c */
    public final int m8629c(int i) throws zzfjr {
        if (i < 0) {
            throw zzfjr.m8706b();
        }
        int i2 = this.f7944f + i;
        int i3 = this.f7946h;
        if (i2 > i3) {
            throw zzfjr.m8705a();
        }
        this.f7946h = i2;
        m8619n();
        return i3;
    }

    /* JADX INFO: renamed from: d */
    public final void m8630d(int i) {
        this.f7946h = i;
        m8619n();
    }

    /* JADX INFO: renamed from: d */
    public final boolean m8631d() throws IOException {
        return m8636h() != 0;
    }

    /* JADX INFO: renamed from: e */
    public final String m8632e() throws IOException {
        int iM8636h = m8636h();
        if (iM8636h < 0) {
            throw zzfjr.m8706b();
        }
        if (iM8636h > this.f7942d - this.f7944f) {
            throw zzfjr.m8705a();
        }
        String str = new String(this.f7939a, this.f7944f, iM8636h, zzfjq.f7964a);
        this.f7944f = iM8636h + this.f7944f;
        return str;
    }

    /* JADX INFO: renamed from: e */
    public final void m8633e(int i) {
        m8626b(i, this.f7945g);
    }

    /* JADX INFO: renamed from: f */
    public final byte[] m8634f() throws IOException {
        int iM8636h = m8636h();
        if (iM8636h < 0) {
            throw zzfjr.m8706b();
        }
        if (iM8636h == 0) {
            return zzfjv.f7977h;
        }
        if (iM8636h > this.f7942d - this.f7944f) {
            throw zzfjr.m8705a();
        }
        byte[] bArr = new byte[iM8636h];
        System.arraycopy(this.f7939a, this.f7944f, bArr, 0, iM8636h);
        this.f7944f = iM8636h + this.f7944f;
        return bArr;
    }

    /* JADX INFO: renamed from: g */
    public final long m8635g() throws IOException {
        long jM8637i = m8637i();
        return (-(jM8637i & 1)) ^ (jM8637i >>> 1);
    }

    /* JADX INFO: renamed from: h */
    public final int m8636h() throws IOException {
        byte bM8620o = m8620o();
        if (bM8620o >= 0) {
            return bM8620o;
        }
        int i = bM8620o & 127;
        byte bM8620o2 = m8620o();
        if (bM8620o2 >= 0) {
            return i | (bM8620o2 << 7);
        }
        int i2 = i | ((bM8620o2 & 127) << 7);
        byte bM8620o3 = m8620o();
        if (bM8620o3 >= 0) {
            return i2 | (bM8620o3 << 14);
        }
        int i3 = i2 | ((bM8620o3 & 127) << 14);
        byte bM8620o4 = m8620o();
        if (bM8620o4 >= 0) {
            return i3 | (bM8620o4 << 21);
        }
        int i4 = i3 | ((bM8620o4 & 127) << 21);
        byte bM8620o5 = m8620o();
        int i5 = i4 | (bM8620o5 << 28);
        if (bM8620o5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (m8620o() >= 0) {
                return i5;
            }
        }
        throw zzfjr.m8707c();
    }

    /* JADX INFO: renamed from: i */
    public final long m8637i() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bM8620o = m8620o();
            j |= ((long) (bM8620o & 127)) << i;
            if ((bM8620o & 128) == 0) {
                return j;
            }
        }
        throw zzfjr.m8707c();
    }

    /* JADX INFO: renamed from: j */
    public final int m8638j() throws IOException {
        return (m8620o() & 255) | ((m8620o() & 255) << 8) | ((m8620o() & 255) << 16) | ((m8620o() & 255) << 24);
    }

    /* JADX INFO: renamed from: k */
    public final long m8639k() throws IOException {
        byte bM8620o = m8620o();
        return ((((long) m8620o()) & 255) << 8) | (((long) bM8620o) & 255) | ((((long) m8620o()) & 255) << 16) | ((((long) m8620o()) & 255) << 24) | ((((long) m8620o()) & 255) << 32) | ((((long) m8620o()) & 255) << 40) | ((((long) m8620o()) & 255) << 48) | ((((long) m8620o()) & 255) << 56);
    }

    /* JADX INFO: renamed from: l */
    public final int m8640l() {
        if (this.f7946h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f7946h - this.f7944f;
    }

    /* JADX INFO: renamed from: m */
    public final int m8641m() {
        return this.f7944f - this.f7940b;
    }
}
