package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ByteQuadsCanonicalizer {

    /* JADX INFO: renamed from: a */
    protected final ByteQuadsCanonicalizer f5599a;

    /* JADX INFO: renamed from: b */
    protected final AtomicReference<TableInfo> f5600b;

    /* JADX INFO: renamed from: c */
    protected boolean f5601c;

    /* JADX INFO: renamed from: d */
    protected final boolean f5602d;

    /* JADX INFO: renamed from: e */
    protected int[] f5603e;

    /* JADX INFO: renamed from: f */
    protected int f5604f;

    /* JADX INFO: renamed from: g */
    protected int f5605g;

    /* JADX INFO: renamed from: h */
    protected int f5606h;

    /* JADX INFO: renamed from: i */
    protected int f5607i;

    /* JADX INFO: renamed from: j */
    protected int f5608j;

    /* JADX INFO: renamed from: k */
    protected String[] f5609k;

    /* JADX INFO: renamed from: l */
    protected int f5610l;

    /* JADX INFO: renamed from: m */
    protected int f5611m;

    /* JADX INFO: renamed from: n */
    private final int f5612n;

    /* JADX INFO: renamed from: o */
    private transient boolean f5613o;

    /* JADX INFO: renamed from: p */
    private boolean f5614p;

    private ByteQuadsCanonicalizer(int i, boolean z, int i2, boolean z2) {
        int i3 = 16;
        this.f5599a = null;
        this.f5612n = i2;
        this.f5601c = z;
        this.f5602d = z2;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.f5600b = new AtomicReference<>(TableInfo.m6422a(i));
    }

    private ByteQuadsCanonicalizer(ByteQuadsCanonicalizer byteQuadsCanonicalizer, boolean z, int i, boolean z2, TableInfo tableInfo) {
        this.f5599a = byteQuadsCanonicalizer;
        this.f5612n = i;
        this.f5601c = z;
        this.f5602d = z2;
        this.f5600b = null;
        this.f5608j = tableInfo.f5616b;
        this.f5604f = tableInfo.f5615a;
        this.f5605g = this.f5604f << 2;
        this.f5606h = this.f5605g + (this.f5605g >> 1);
        this.f5607i = tableInfo.f5617c;
        this.f5603e = tableInfo.f5618d;
        this.f5609k = tableInfo.f5619e;
        this.f5610l = tableInfo.f5620f;
        this.f5611m = tableInfo.f5621g;
        this.f5613o = false;
        this.f5614p = true;
    }

    /* JADX INFO: renamed from: a */
    public static ByteQuadsCanonicalizer m6386a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return m6387a((((int) (jCurrentTimeMillis >>> 32)) + ((int) jCurrentTimeMillis)) | 1);
    }

    /* JADX INFO: renamed from: a */
    protected static ByteQuadsCanonicalizer m6387a(int i) {
        return new ByteQuadsCanonicalizer(64, true, i, true);
    }

    /* JADX INFO: renamed from: b */
    public ByteQuadsCanonicalizer m6411b(int i) {
        return new ByteQuadsCanonicalizer(this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(i), this.f5612n, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(i), this.f5600b.get());
    }

    /* JADX INFO: renamed from: b */
    public void m6412b() {
        if (this.f5599a != null && m6414c()) {
            this.f5599a.m6390a(new TableInfo(this));
            this.f5614p = true;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6390a(TableInfo tableInfo) {
        int i = tableInfo.f5616b;
        TableInfo tableInfo2 = this.f5600b.get();
        if (i != tableInfo2.f5616b) {
            if (i > 6000) {
                tableInfo = TableInfo.m6422a(64);
            }
            this.f5600b.compareAndSet(tableInfo2, tableInfo);
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m6414c() {
        return !this.f5614p;
    }

    /* JADX INFO: renamed from: d */
    public int m6415d() {
        int i = this.f5605g;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.f5603e[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: e */
    public int m6417e() {
        int i = this.f5605g + 3;
        int i2 = this.f5606h;
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4 += 4) {
            if (this.f5603e[i4] != 0) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: f */
    public int m6418f() {
        int i = this.f5606h + 3;
        int i2 = this.f5604f + i;
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4 += 4) {
            if (this.f5603e[i4] != 0) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: g */
    public int m6419g() {
        return (this.f5610l - m6403m()) >> 2;
    }

    /* JADX INFO: renamed from: h */
    public int m6420h() {
        int i = this.f5604f << 3;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.f5603e[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public String toString() {
        int iM6415d = m6415d();
        int iM6417e = m6417e();
        int iM6418f = m6418f();
        int iM6419g = m6419g();
        int iM6420h = m6420h();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", getClass().getName(), Integer.valueOf(this.f5608j), Integer.valueOf(this.f5604f), Integer.valueOf(iM6415d), Integer.valueOf(iM6417e), Integer.valueOf(iM6418f), Integer.valueOf(iM6419g), Integer.valueOf(iM6420h), Integer.valueOf(iM6415d + iM6417e + iM6418f + iM6419g), Integer.valueOf(iM6420h));
    }

    /* JADX INFO: renamed from: c */
    public String m6413c(int i) {
        int iM6398f = m6398f(m6416d(i));
        int[] iArr = this.f5603e;
        int i2 = iArr[iM6398f + 3];
        if (i2 == 1) {
            if (iArr[iM6398f] == i) {
                return this.f5609k[iM6398f >> 2];
            }
        } else if (i2 == 0) {
            return null;
        }
        int i3 = this.f5605g + ((iM6398f >> 3) << 2);
        int i4 = iArr[i3 + 3];
        if (i4 == 1) {
            if (iArr[i3] == i) {
                return this.f5609k[i3 >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        return m6395c(iM6398f, i);
    }

    /* JADX INFO: renamed from: a */
    public String m6404a(int i, int i2) {
        int iM6398f = m6398f(m6408b(i, i2));
        int[] iArr = this.f5603e;
        int i3 = iArr[iM6398f + 3];
        if (i3 == 2) {
            if (i == iArr[iM6398f] && i2 == iArr[iM6398f + 1]) {
                return this.f5609k[iM6398f >> 2];
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = this.f5605g + ((iM6398f >> 3) << 2);
        int i5 = iArr[i4 + 3];
        if (i5 == 2) {
            if (i == iArr[i4] && i2 == iArr[i4 + 1]) {
                return this.f5609k[i4 >> 2];
            }
        } else if (i5 == 0) {
            return null;
        }
        return m6396c(iM6398f, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public String m6405a(int i, int i2, int i3) {
        int iM6398f = m6398f(m6409b(i, i2, i3));
        int[] iArr = this.f5603e;
        int i4 = iArr[iM6398f + 3];
        if (i4 == 3) {
            if (i == iArr[iM6398f] && iArr[iM6398f + 1] == i2 && iArr[iM6398f + 2] == i3) {
                return this.f5609k[iM6398f >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = this.f5605g + ((iM6398f >> 3) << 2);
        int i6 = iArr[i5 + 3];
        if (i6 == 3) {
            if (i == iArr[i5] && iArr[i5 + 1] == i2 && iArr[i5 + 2] == i3) {
                return this.f5609k[i5 >> 2];
            }
        } else if (i6 == 0) {
            return null;
        }
        return m6388a(iM6398f, i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public String m6407a(int[] iArr, int i) {
        if (i < 4) {
            if (i == 3) {
                return m6405a(iArr[0], iArr[1], iArr[2]);
            }
            if (i == 2) {
                return m6404a(iArr[0], iArr[1]);
            }
            return m6413c(iArr[0]);
        }
        int iM6410b = m6410b(iArr, i);
        int iM6398f = m6398f(iM6410b);
        int[] iArr2 = this.f5603e;
        int i2 = iArr2[iM6398f + 3];
        if (iM6410b == iArr2[iM6398f] && i2 == i && m6392a(iArr, i, iArr2[iM6398f + 1])) {
            return this.f5609k[iM6398f >> 2];
        }
        if (i2 == 0) {
            return null;
        }
        int i3 = this.f5605g + ((iM6398f >> 3) << 2);
        int i4 = iArr2[i3 + 3];
        if (iM6410b == iArr2[i3] && i4 == i && m6392a(iArr, i, iArr2[i3 + 1])) {
            return this.f5609k[i3 >> 2];
        }
        if (i2 != 0) {
            return m6389a(iM6398f, iM6410b, iArr, i);
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    private final int m6398f(int i) {
        return ((this.f5604f - 1) & i) << 2;
    }

    /* JADX INFO: renamed from: c */
    private String m6395c(int i, int i2) {
        int i3 = this.f5606h + ((i >> (this.f5607i + 2)) << this.f5607i);
        int[] iArr = this.f5603e;
        int i4 = (1 << this.f5607i) + i3;
        while (i3 < i4) {
            int i5 = iArr[i3 + 3];
            if (i2 == iArr[i3] && 1 == i5) {
                return this.f5609k[i3 >> 2];
            }
            if (i5 == 0) {
                return null;
            }
            i3 += 4;
        }
        for (int iM6403m = m6403m(); iM6403m < this.f5610l; iM6403m += 4) {
            if (i2 == iArr[iM6403m] && 1 == iArr[iM6403m + 3]) {
                return this.f5609k[iM6403m >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private String m6396c(int i, int i2, int i3) {
        int i4 = this.f5606h + ((i >> (this.f5607i + 2)) << this.f5607i);
        int[] iArr = this.f5603e;
        int i5 = (1 << this.f5607i) + i4;
        while (i4 < i5) {
            int i6 = iArr[i4 + 3];
            if (i2 == iArr[i4] && i3 == iArr[i4 + 1] && 2 == i6) {
                return this.f5609k[i4 >> 2];
            }
            if (i6 == 0) {
                return null;
            }
            i4 += 4;
        }
        for (int iM6403m = m6403m(); iM6403m < this.f5610l; iM6403m += 4) {
            if (i2 == iArr[iM6403m] && i3 == iArr[iM6403m + 1] && 2 == iArr[iM6403m + 3]) {
                return this.f5609k[iM6403m >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private String m6388a(int i, int i2, int i3, int i4) {
        int i5 = this.f5606h + ((i >> (this.f5607i + 2)) << this.f5607i);
        int[] iArr = this.f5603e;
        int i6 = (1 << this.f5607i) + i5;
        while (i5 < i6) {
            int i7 = iArr[i5 + 3];
            if (i2 == iArr[i5] && i3 == iArr[i5 + 1] && i4 == iArr[i5 + 2] && 3 == i7) {
                return this.f5609k[i5 >> 2];
            }
            if (i7 == 0) {
                return null;
            }
            i5 += 4;
        }
        for (int iM6403m = m6403m(); iM6403m < this.f5610l; iM6403m += 4) {
            if (i2 == iArr[iM6403m] && i3 == iArr[iM6403m + 1] && i4 == iArr[iM6403m + 2] && 3 == iArr[iM6403m + 3]) {
                return this.f5609k[iM6403m >> 2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private String m6389a(int i, int i2, int[] iArr, int i3) {
        int i4 = this.f5606h + ((i >> (this.f5607i + 2)) << this.f5607i);
        int[] iArr2 = this.f5603e;
        int i5 = (1 << this.f5607i) + i4;
        while (i4 < i5) {
            int i6 = iArr2[i4 + 3];
            if (i2 == iArr2[i4] && i3 == i6 && m6392a(iArr, i3, iArr2[i4 + 1])) {
                return this.f5609k[i4 >> 2];
            }
            if (i6 == 0) {
                return null;
            }
            i4 += 4;
        }
        for (int iM6403m = m6403m(); iM6403m < this.f5610l; iM6403m += 4) {
            if (i2 == iArr2[iM6403m] && i3 == iArr2[iM6403m + 3] && m6392a(iArr, i3, iArr2[iM6403m + 1])) {
                return this.f5609k[iM6403m >> 2];
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m6392a(int[] r8, int r9, int r10) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            int[] r4 = r7.f5603e
            switch(r9) {
                case 4: goto L6a;
                case 5: goto L68;
                case 6: goto L66;
                case 7: goto L64;
                case 8: goto Lc;
                default: goto L7;
            }
        L7:
            boolean r2 = r7.m6393b(r8, r9, r10)
        Lb:
            return r2
        Lc:
            r3 = r8[r2]
            int r0 = r10 + 1
            r5 = r4[r10]
            if (r3 != r5) goto Lb
            r10 = r0
            r0 = r1
        L16:
            int r3 = r0 + 1
            r5 = r8[r0]
            int r0 = r10 + 1
            r6 = r4[r10]
            if (r5 != r6) goto Lb
            r10 = r0
            r0 = r3
        L22:
            int r3 = r0 + 1
            r5 = r8[r0]
            int r0 = r10 + 1
            r6 = r4[r10]
            if (r5 != r6) goto Lb
            r10 = r0
            r0 = r3
        L2e:
            int r3 = r0 + 1
            r5 = r8[r0]
            int r0 = r10 + 1
            r6 = r4[r10]
            if (r5 != r6) goto Lb
            r10 = r0
            r0 = r3
        L3a:
            int r3 = r0 + 1
            r0 = r8[r0]
            int r5 = r10 + 1
            r6 = r4[r10]
            if (r0 != r6) goto Lb
            int r0 = r3 + 1
            r3 = r8[r3]
            int r6 = r5 + 1
            r5 = r4[r5]
            if (r3 != r5) goto Lb
            int r3 = r0 + 1
            r0 = r8[r0]
            int r5 = r6 + 1
            r6 = r4[r6]
            if (r0 != r6) goto Lb
            int r0 = r3 + 1
            r0 = r8[r3]
            int r3 = r5 + 1
            r3 = r4[r5]
            if (r0 != r3) goto Lb
            r2 = r1
            goto Lb
        L64:
            r0 = r2
            goto L16
        L66:
            r0 = r2
            goto L22
        L68:
            r0 = r2
            goto L2e
        L6a:
            r0 = r2
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer.m6392a(int[], int, int):boolean");
    }

    /* JADX INFO: renamed from: b */
    private boolean m6393b(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            int i6 = i2 + 1;
            if (i5 != this.f5603e[i2]) {
                return false;
            }
            if (i4 >= i) {
                return true;
            }
            i2 = i6;
            i3 = i4;
        }
    }

    /* JADX INFO: renamed from: a */
    public String m6406a(String str, int[] iArr, int i) {
        int iM6399g;
        m6401k();
        if (this.f5601c) {
            str = InternCache.f5676a.m6467a(str);
        }
        switch (i) {
            case 1:
                iM6399g = m6399g(m6416d(iArr[0]));
                this.f5603e[iM6399g] = iArr[0];
                this.f5603e[iM6399g + 3] = 1;
                break;
            case 2:
                iM6399g = m6399g(m6408b(iArr[0], iArr[1]));
                this.f5603e[iM6399g] = iArr[0];
                this.f5603e[iM6399g + 1] = iArr[1];
                this.f5603e[iM6399g + 3] = 2;
                break;
            case 3:
                iM6399g = m6399g(m6409b(iArr[0], iArr[1], iArr[2]));
                this.f5603e[iM6399g] = iArr[0];
                this.f5603e[iM6399g + 1] = iArr[1];
                this.f5603e[iM6399g + 2] = iArr[2];
                this.f5603e[iM6399g + 3] = 3;
                break;
            default:
                int iM6410b = m6410b(iArr, i);
                iM6399g = m6399g(iM6410b);
                this.f5603e[iM6399g] = iM6410b;
                this.f5603e[iM6399g + 1] = m6394c(iArr, i);
                this.f5603e[iM6399g + 3] = i;
                break;
        }
        this.f5609k[iM6399g >> 2] = str;
        this.f5608j++;
        m6400j();
        return str;
    }

    /* JADX INFO: renamed from: j */
    private void m6400j() {
        if (this.f5608j > (this.f5604f >> 1)) {
            if (((this.f5610l - m6403m()) >> 2) > ((this.f5608j + 1) >> 7) || this.f5608j > ((double) this.f5604f) * 0.8d) {
                this.f5613o = true;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    private void m6401k() {
        if (this.f5614p) {
            this.f5603e = Arrays.copyOf(this.f5603e, this.f5603e.length);
            this.f5609k = (String[]) Arrays.copyOf(this.f5609k, this.f5609k.length);
            this.f5614p = false;
            m6400j();
        }
        if (this.f5613o) {
            m6402l();
        }
    }

    /* JADX INFO: renamed from: g */
    private int m6399g(int i) {
        int iM6398f = m6398f(i);
        int[] iArr = this.f5603e;
        if (iArr[iM6398f + 3] != 0) {
            int i2 = this.f5605g + ((iM6398f >> 3) << 2);
            if (iArr[i2 + 3] == 0) {
                return i2;
            }
            int i3 = ((iM6398f >> (this.f5607i + 2)) << this.f5607i) + this.f5606h;
            int i4 = (1 << this.f5607i) + i3;
            while (i3 < i4) {
                if (iArr[i3 + 3] != 0) {
                    i3 += 4;
                } else {
                    return i3;
                }
            }
            int i5 = this.f5610l;
            this.f5610l += 4;
            if (this.f5610l >= (this.f5604f << 3)) {
                if (this.f5602d) {
                    m6421i();
                }
                this.f5613o = true;
                return i5;
            }
            return i5;
        }
        return iM6398f;
    }

    /* JADX INFO: renamed from: c */
    private int m6394c(int[] iArr, int i) {
        int i2 = this.f5611m;
        if (i2 + i > this.f5603e.length) {
            this.f5603e = Arrays.copyOf(this.f5603e, Math.max((i2 + i) - this.f5603e.length, Math.min(4096, this.f5604f)) + this.f5603e.length);
        }
        System.arraycopy(iArr, 0, this.f5603e, i2, i);
        this.f5611m += i;
        return i2;
    }

    /* JADX INFO: renamed from: d */
    public int m6416d(int i) {
        int i2 = this.f5612n ^ i;
        int i3 = i2 + (i2 >>> 16);
        int i4 = i3 ^ (i3 << 3);
        return i4 + (i4 >>> 12);
    }

    /* JADX INFO: renamed from: b */
    public int m6408b(int i, int i2) {
        int i3 = (i >>> 15) + i;
        int i4 = ((i3 ^ (i3 >>> 9)) + (i2 * 33)) ^ this.f5612n;
        int i5 = i4 + (i4 >>> 16);
        int i6 = i5 ^ (i5 >>> 4);
        return i6 + (i6 << 3);
    }

    /* JADX INFO: renamed from: b */
    public int m6409b(int i, int i2, int i3) {
        int i4 = this.f5612n ^ i;
        int i5 = (((i4 + (i4 >>> 9)) * 31) + i2) * 33;
        int i6 = (i5 + (i5 >>> 15)) ^ i3;
        int i7 = i6 + (i6 >>> 4);
        int i8 = i7 + (i7 >>> 15);
        return i8 ^ (i8 << 9);
    }

    /* JADX INFO: renamed from: b */
    public int m6410b(int[] iArr, int i) {
        if (i < 4) {
            throw new IllegalArgumentException();
        }
        int i2 = iArr[0] ^ this.f5612n;
        int i3 = i2 + (i2 >>> 9) + iArr[1];
        int i4 = ((i3 + (i3 >>> 15)) * 33) ^ iArr[2];
        int i5 = (i4 >>> 4) + i4;
        for (int i6 = 3; i6 < i; i6++) {
            int i7 = iArr[i6];
            i5 += i7 ^ (i7 >> 21);
        }
        int i8 = 65599 * i5;
        int i9 = i8 + (i8 >>> 19);
        return i9 ^ (i9 << 5);
    }

    /* JADX INFO: renamed from: l */
    private void m6402l() {
        this.f5613o = false;
        this.f5614p = false;
        int[] iArr = this.f5603e;
        String[] strArr = this.f5609k;
        int i = this.f5604f;
        int i2 = this.f5608j;
        int i3 = i + i;
        int i4 = this.f5610l;
        if (i3 > 65536) {
            m6391a(true);
            return;
        }
        this.f5603e = new int[(i << 3) + iArr.length];
        this.f5604f = i3;
        this.f5605g = i3 << 2;
        this.f5606h = this.f5605g + (this.f5605g >> 1);
        this.f5607i = m6397e(i3);
        this.f5609k = new String[strArr.length << 1];
        m6391a(false);
        int[] iArr2 = new int[16];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6 += 4) {
            int i7 = iArr[i6 + 3];
            if (i7 != 0) {
                i5++;
                String str = strArr[i6 >> 2];
                switch (i7) {
                    case 1:
                        iArr2[0] = iArr[i6];
                        m6406a(str, iArr2, 1);
                        break;
                    case 2:
                        iArr2[0] = iArr[i6];
                        iArr2[1] = iArr[i6 + 1];
                        m6406a(str, iArr2, 2);
                        break;
                    case 3:
                        iArr2[0] = iArr[i6];
                        iArr2[1] = iArr[i6 + 1];
                        iArr2[2] = iArr[i6 + 2];
                        m6406a(str, iArr2, 3);
                        break;
                    default:
                        if (i7 > iArr2.length) {
                            iArr2 = new int[i7];
                        }
                        System.arraycopy(iArr, iArr[i6 + 1], iArr2, 0, i7);
                        m6406a(str, iArr2, i7);
                        break;
                }
            }
        }
        if (i5 != i2) {
            throw new IllegalStateException("Failed rehash(): old count=" + i2 + ", copyCount=" + i5);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6391a(boolean z) {
        this.f5608j = 0;
        this.f5610l = m6403m();
        this.f5611m = this.f5604f << 3;
        if (z) {
            Arrays.fill(this.f5603e, 0);
            Arrays.fill(this.f5609k, (Object) null);
        }
    }

    /* JADX INFO: renamed from: m */
    private final int m6403m() {
        int i = this.f5604f;
        return (i << 3) - i;
    }

    /* JADX INFO: renamed from: i */
    protected void m6421i() {
        if (this.f5604f <= 1024) {
        } else {
            throw new IllegalStateException("Spill-over slots in symbol table with " + this.f5608j + " entries, hash area of " + this.f5604f + " slots is now full (all " + (this.f5604f >> 3) + " slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
        }
    }

    /* JADX INFO: renamed from: e */
    static int m6397e(int i) {
        int i2 = i >> 2;
        if (i2 < 64) {
            return 4;
        }
        if (i2 <= 256) {
            return 5;
        }
        if (i2 <= 1024) {
            return 6;
        }
        return 7;
    }

    private static final class TableInfo {

        /* JADX INFO: renamed from: a */
        public final int f5615a;

        /* JADX INFO: renamed from: b */
        public final int f5616b;

        /* JADX INFO: renamed from: c */
        public final int f5617c;

        /* JADX INFO: renamed from: d */
        public final int[] f5618d;

        /* JADX INFO: renamed from: e */
        public final String[] f5619e;

        /* JADX INFO: renamed from: f */
        public final int f5620f;

        /* JADX INFO: renamed from: g */
        public final int f5621g;

        public TableInfo(int i, int i2, int i3, int[] iArr, String[] strArr, int i4, int i5) {
            this.f5615a = i;
            this.f5616b = i2;
            this.f5617c = i3;
            this.f5618d = iArr;
            this.f5619e = strArr;
            this.f5620f = i4;
            this.f5621g = i5;
        }

        public TableInfo(ByteQuadsCanonicalizer byteQuadsCanonicalizer) {
            this.f5615a = byteQuadsCanonicalizer.f5604f;
            this.f5616b = byteQuadsCanonicalizer.f5608j;
            this.f5617c = byteQuadsCanonicalizer.f5607i;
            this.f5618d = byteQuadsCanonicalizer.f5603e;
            this.f5619e = byteQuadsCanonicalizer.f5609k;
            this.f5620f = byteQuadsCanonicalizer.f5610l;
            this.f5621g = byteQuadsCanonicalizer.f5611m;
        }

        /* JADX INFO: renamed from: a */
        public static TableInfo m6422a(int i) {
            int i2 = i << 3;
            return new TableInfo(i, 0, ByteQuadsCanonicalizer.m6397e(i), new int[i2], new String[i << 1], i2 - i, i2);
        }
    }
}
