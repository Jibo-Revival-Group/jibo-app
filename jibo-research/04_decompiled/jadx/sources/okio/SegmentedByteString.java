package okio;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class SegmentedByteString extends ByteString {

    /* JADX INFO: renamed from: f */
    final transient byte[][] f15693f;

    /* JADX INFO: renamed from: g */
    final transient int[] f15694g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SegmentedByteString(Buffer buffer, int i) {
        super(null);
        int i2 = 0;
        Util.m16387a(buffer.f15643b, 0L, i);
        Segment segment = buffer.f15642a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (segment.f15686c == segment.f15685b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += segment.f15686c - segment.f15685b;
            i3++;
            segment = segment.f15689f;
        }
        this.f15693f = new byte[i3][];
        this.f15694g = new int[i3 * 2];
        Segment segment2 = buffer.f15642a;
        int i5 = 0;
        while (i2 < i) {
            this.f15693f[i5] = segment2.f15684a;
            int i6 = (segment2.f15686c - segment2.f15685b) + i2;
            if (i6 > i) {
                i6 = i;
            }
            this.f15694g[i5] = i6;
            this.f15694g[this.f15693f.length + i5] = segment2.f15685b;
            segment2.f15687d = true;
            i5++;
            segment2 = segment2.f15689f;
            i2 = i6;
        }
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: a */
    public String mo16323a() {
        return m16384j().mo16323a();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: b */
    public String mo16330b() {
        return m16384j().mo16330b();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: f */
    public String mo16334f() {
        return m16384j().mo16334f();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: g */
    public ByteString mo16335g() {
        return m16384j().mo16335g();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: c */
    public ByteString mo16331c() {
        return m16384j().mo16331c();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: d */
    public ByteString mo16332d() {
        return m16384j().mo16332d();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: e */
    public ByteString mo16333e() {
        return m16384j().mo16333e();
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: a */
    public ByteString mo16324a(int i, int i2) {
        return m16384j().mo16324a(i, i2);
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: a */
    public byte mo16322a(int i) {
        Util.m16387a(this.f15694g[this.f15693f.length - 1], i, 1L);
        int iM16383b = m16383b(i);
        return this.f15693f[iM16383b][(i - (iM16383b == 0 ? 0 : this.f15694g[iM16383b - 1])) + this.f15694g[this.f15693f.length + iM16383b]];
    }

    /* JADX INFO: renamed from: b */
    private int m16383b(int i) {
        int iBinarySearch = Arrays.binarySearch(this.f15694g, 0, this.f15693f.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : iBinarySearch ^ (-1);
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: h */
    public int mo16336h() {
        return this.f15694g[this.f15693f.length - 1];
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: i */
    public byte[] mo16337i() {
        int i = 0;
        byte[] bArr = new byte[this.f15694g[this.f15693f.length - 1]];
        int length = this.f15693f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f15694g[length + i];
            int i4 = this.f15694g[i];
            System.arraycopy(this.f15693f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: a */
    void mo16325a(Buffer buffer) {
        int i = 0;
        int length = this.f15693f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f15694g[length + i];
            int i4 = this.f15694g[i];
            Segment segment = new Segment(this.f15693f[i], i3, (i3 + i4) - i2);
            if (buffer.f15642a == null) {
                segment.f15690g = segment;
                segment.f15689f = segment;
                buffer.f15642a = segment;
            } else {
                buffer.f15642a.f15690g.m16378a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f15643b = ((long) i2) + buffer.f15643b;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: a */
    public boolean mo16326a(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > mo16336h() - i3) {
            return false;
        }
        int iM16383b = m16383b(i);
        while (i3 > 0) {
            int i4 = iM16383b == 0 ? 0 : this.f15694g[iM16383b - 1];
            int iMin = Math.min(i3, ((this.f15694g[iM16383b] - i4) + i4) - i);
            if (!byteString.mo16327a(i2, this.f15693f[iM16383b], (i - i4) + this.f15694g[this.f15693f.length + iM16383b], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iM16383b++;
        }
        return true;
    }

    @Override // okio.ByteString
    /* JADX INFO: renamed from: a */
    public boolean mo16327a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo16336h() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iM16383b = m16383b(i);
        while (i3 > 0) {
            int i4 = iM16383b == 0 ? 0 : this.f15694g[iM16383b - 1];
            int iMin = Math.min(i3, ((this.f15694g[iM16383b] - i4) + i4) - i);
            if (!Util.m16389a(this.f15693f[iM16383b], (i - i4) + this.f15694g[this.f15693f.length + iM16383b], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iM16383b++;
        }
        return true;
    }

    /* JADX INFO: renamed from: j */
    private ByteString m16384j() {
        return new ByteString(mo16337i());
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ByteString) && ((ByteString) obj).mo16336h() == mo16336h() && mo16326a(0, (ByteString) obj, 0, mo16336h());
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.f15649d;
        if (i == 0) {
            i = 1;
            int length = this.f15693f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f15693f[i2];
                int i4 = this.f15694g[length + i2];
                int i5 = this.f15694g[i2];
                int i6 = (i5 - i3) + i4;
                int i7 = i;
                for (int i8 = i4; i8 < i6; i8++) {
                    i7 = (i7 * 31) + bArr[i8];
                }
                i2++;
                i3 = i5;
                i = i7;
            }
            this.f15649d = i;
        }
        return i;
    }

    @Override // okio.ByteString
    public String toString() {
        return m16384j().toString();
    }

    private Object writeReplace() {
        return m16384j();
    }
}
