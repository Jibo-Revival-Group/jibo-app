package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import com.yalantis.ucrop.util.FileUtils;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public final class CharsToNameCanonicalizer {

    /* JADX INFO: renamed from: a */
    static final CharsToNameCanonicalizer f5635a = new CharsToNameCanonicalizer();

    /* JADX INFO: renamed from: b */
    protected CharsToNameCanonicalizer f5636b;

    /* JADX INFO: renamed from: c */
    protected final int f5637c;

    /* JADX INFO: renamed from: d */
    protected boolean f5638d;

    /* JADX INFO: renamed from: e */
    protected String[] f5639e;

    /* JADX INFO: renamed from: f */
    protected Bucket[] f5640f;

    /* JADX INFO: renamed from: g */
    protected int f5641g;

    /* JADX INFO: renamed from: h */
    protected int f5642h;

    /* JADX INFO: renamed from: i */
    protected int f5643i;

    /* JADX INFO: renamed from: j */
    protected int f5644j;

    /* JADX INFO: renamed from: k */
    protected boolean f5645k;

    /* JADX INFO: renamed from: l */
    protected BitSet f5646l;

    /* JADX INFO: renamed from: m */
    private final int f5647m;

    /* JADX INFO: renamed from: a */
    public static CharsToNameCanonicalizer m6426a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return m6427a((((int) (jCurrentTimeMillis >>> 32)) + ((int) jCurrentTimeMillis)) | 1);
    }

    /* JADX INFO: renamed from: a */
    protected static CharsToNameCanonicalizer m6427a(int i) {
        return f5635a.m6435g(i);
    }

    private CharsToNameCanonicalizer() {
        this.f5638d = true;
        this.f5637c = -1;
        this.f5645k = true;
        this.f5647m = 0;
        this.f5644j = 0;
        m6432e(64);
    }

    /* JADX INFO: renamed from: e */
    private void m6432e(int i) {
        this.f5639e = new String[i];
        this.f5640f = new Bucket[i >> 1];
        this.f5643i = i - 1;
        this.f5641g = 0;
        this.f5644j = 0;
        this.f5642h = m6433f(i);
    }

    /* JADX INFO: renamed from: f */
    private static int m6433f(int i) {
        return i - (i >> 2);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, int i, String[] strArr, Bucket[] bucketArr, int i2, int i3, int i4) {
        this.f5636b = charsToNameCanonicalizer;
        this.f5637c = i;
        this.f5638d = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
        this.f5639e = strArr;
        this.f5640f = bucketArr;
        this.f5641g = i2;
        this.f5647m = i3;
        int length = strArr.length;
        this.f5642h = m6433f(length);
        this.f5643i = length - 1;
        this.f5644j = i4;
        this.f5645k = false;
    }

    /* JADX INFO: renamed from: b */
    public CharsToNameCanonicalizer m6440b(int i) {
        String[] strArr;
        Bucket[] bucketArr;
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            strArr = this.f5639e;
            bucketArr = this.f5640f;
            i2 = this.f5641g;
            i3 = this.f5647m;
            i4 = this.f5644j;
        }
        return new CharsToNameCanonicalizer(this, i, strArr, bucketArr, i2, i3, i4);
    }

    /* JADX INFO: renamed from: g */
    private CharsToNameCanonicalizer m6435g(int i) {
        return new CharsToNameCanonicalizer(null, -1, this.f5639e, this.f5640f, this.f5641g, i, this.f5644j);
    }

    /* JADX INFO: renamed from: a */
    private void m6431a(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.m6442c() > 12000) {
            synchronized (this) {
                m6432e(256);
                this.f5645k = false;
            }
        } else if (charsToNameCanonicalizer.m6442c() > m6442c()) {
            synchronized (this) {
                this.f5639e = charsToNameCanonicalizer.f5639e;
                this.f5640f = charsToNameCanonicalizer.f5640f;
                this.f5641g = charsToNameCanonicalizer.f5641g;
                this.f5642h = charsToNameCanonicalizer.f5642h;
                this.f5643i = charsToNameCanonicalizer.f5643i;
                this.f5644j = charsToNameCanonicalizer.f5644j;
                this.f5645k = false;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6441b() {
        if (m6445d() && this.f5636b != null && this.f5638d) {
            this.f5636b.m6431a(this);
            this.f5645k = false;
        }
    }

    /* JADX INFO: renamed from: c */
    public int m6442c() {
        return this.f5641g;
    }

    /* JADX INFO: renamed from: d */
    public boolean m6445d() {
        return this.f5645k;
    }

    /* JADX INFO: renamed from: e */
    public int m6446e() {
        return this.f5647m;
    }

    /* JADX INFO: renamed from: a */
    public String m6439a(char[] cArr, int i, int i2, int i3) {
        if (i2 < 1) {
            return "";
        }
        if (!this.f5638d) {
            return new String(cArr, i, i2);
        }
        int iM6443c = m6443c(i3);
        String str = this.f5639e[iM6443c];
        if (str != null) {
            if (str.length() == i2) {
                int i4 = 0;
                while (str.charAt(i4) == cArr[i + i4]) {
                    i4++;
                    if (i4 == i2) {
                        return str;
                    }
                }
            }
            Bucket bucket = this.f5640f[iM6443c >> 1];
            if (bucket != null) {
                String strM6447a = bucket.m6447a(cArr, i, i2);
                if (strM6447a == null) {
                    String strM6429a = m6429a(cArr, i, i2, bucket.f5649b);
                    if (strM6429a != null) {
                        return strM6429a;
                    }
                } else {
                    return strM6447a;
                }
            }
        }
        return m6428a(cArr, i, i2, i3, iM6443c);
    }

    /* JADX INFO: renamed from: a */
    private String m6429a(char[] cArr, int i, int i2, Bucket bucket) {
        while (bucket != null) {
            String strM6447a = bucket.m6447a(cArr, i, i2);
            if (strM6447a == null) {
                bucket = bucket.f5649b;
            } else {
                return strM6447a;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private String m6428a(char[] cArr, int i, int i2, int i3, int i4) {
        if (!this.f5645k) {
            m6434f();
            this.f5645k = true;
        } else if (this.f5641g >= this.f5642h) {
            m6436g();
            i4 = m6443c(m6438a(cArr, i, i2));
        }
        String str = new String(cArr, i, i2);
        if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(this.f5637c)) {
            str = InternCache.f5676a.m6467a(str);
        }
        this.f5641g++;
        if (this.f5639e[i4] == null) {
            this.f5639e[i4] = str;
        } else {
            int i5 = i4 >> 1;
            Bucket bucket = new Bucket(str, this.f5640f[i5]);
            int i6 = bucket.f5650c;
            if (i6 > 100) {
                m6430a(i5, bucket);
            } else {
                this.f5640f[i5] = bucket;
                this.f5644j = Math.max(i6, this.f5644j);
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    private void m6430a(int i, Bucket bucket) {
        if (this.f5646l == null) {
            this.f5646l = new BitSet();
            this.f5646l.set(i);
        } else if (this.f5646l.get(i)) {
            if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this.f5637c)) {
                m6444d(100);
            }
            this.f5638d = false;
        } else {
            this.f5646l.set(i);
        }
        this.f5639e[i + i] = bucket.f5648a;
        this.f5640f[i] = null;
        this.f5641g -= bucket.f5650c;
        this.f5644j = -1;
    }

    /* JADX INFO: renamed from: c */
    public int m6443c(int i) {
        int i2 = (i >>> 15) + i;
        int i3 = i2 ^ (i2 << 7);
        return (i3 + (i3 >>> 3)) & this.f5643i;
    }

    /* JADX INFO: renamed from: a */
    public int m6438a(char[] cArr, int i, int i2) {
        int i3 = this.f5647m;
        int i4 = i + i2;
        while (i < i4) {
            i3 = (i3 * 33) + cArr[i];
            i++;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    public int m6437a(String str) {
        int length = str.length();
        int i = this.f5647m;
        int i2 = 0;
        while (i2 < length) {
            int iCharAt = str.charAt(i2) + (i * 33);
            i2++;
            i = iCharAt;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    /* JADX INFO: renamed from: f */
    private void m6434f() {
        String[] strArr = this.f5639e;
        this.f5639e = (String[]) Arrays.copyOf(strArr, strArr.length);
        Bucket[] bucketArr = this.f5640f;
        this.f5640f = (Bucket[]) Arrays.copyOf(bucketArr, bucketArr.length);
    }

    /* JADX INFO: renamed from: g */
    private void m6436g() {
        int length = this.f5639e.length;
        int i = length + length;
        if (i > 65536) {
            this.f5641g = 0;
            this.f5638d = false;
            this.f5639e = new String[64];
            this.f5640f = new Bucket[32];
            this.f5643i = 63;
            this.f5645k = true;
            return;
        }
        String[] strArr = this.f5639e;
        Bucket[] bucketArr = this.f5640f;
        this.f5639e = new String[i];
        this.f5640f = new Bucket[i >> 1];
        this.f5643i = i - 1;
        this.f5642h = m6433f(i);
        int iMax = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            if (str != null) {
                i2++;
                int iM6443c = m6443c(m6437a(str));
                if (this.f5639e[iM6443c] == null) {
                    this.f5639e[iM6443c] = str;
                } else {
                    int i4 = iM6443c >> 1;
                    Bucket bucket = new Bucket(str, this.f5640f[i4]);
                    this.f5640f[i4] = bucket;
                    iMax = Math.max(iMax, bucket.f5650c);
                }
            }
        }
        int i5 = length >> 1;
        int i6 = 0;
        int i7 = i2;
        int i8 = iMax;
        while (i6 < i5) {
            int iMax2 = i8;
            for (Bucket bucket2 = bucketArr[i6]; bucket2 != null; bucket2 = bucket2.f5649b) {
                i7++;
                String str2 = bucket2.f5648a;
                int iM6443c2 = m6443c(m6437a(str2));
                if (this.f5639e[iM6443c2] == null) {
                    this.f5639e[iM6443c2] = str2;
                } else {
                    int i9 = iM6443c2 >> 1;
                    Bucket bucket3 = new Bucket(str2, this.f5640f[i9]);
                    this.f5640f[i9] = bucket3;
                    iMax2 = Math.max(iMax2, bucket3.f5650c);
                }
            }
            i6++;
            i8 = iMax2;
        }
        this.f5644j = i8;
        this.f5646l = null;
        if (i7 != this.f5641g) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.f5641g + " entries; now have " + i7 + FileUtils.HIDDEN_PREFIX);
        }
    }

    /* JADX INFO: renamed from: d */
    protected void m6444d(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f5641g + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    static final class Bucket {

        /* JADX INFO: renamed from: a */
        public final String f5648a;

        /* JADX INFO: renamed from: b */
        public final Bucket f5649b;

        /* JADX INFO: renamed from: c */
        public final int f5650c;

        public Bucket(String str, Bucket bucket) {
            this.f5648a = str;
            this.f5649b = bucket;
            this.f5650c = bucket == null ? 1 : bucket.f5650c + 1;
        }

        /* JADX INFO: renamed from: a */
        public String m6447a(char[] cArr, int i, int i2) {
            if (this.f5648a.length() != i2) {
                return null;
            }
            int i3 = 0;
            while (this.f5648a.charAt(i3) == cArr[i + i3]) {
                i3++;
                if (i3 >= i2) {
                    return this.f5648a;
                }
            }
            return null;
        }
    }
}
