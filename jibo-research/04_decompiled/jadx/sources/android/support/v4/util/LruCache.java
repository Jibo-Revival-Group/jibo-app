package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<K, V> {

    /* JADX INFO: renamed from: a */
    private final LinkedHashMap<K, V> f2205a;

    /* JADX INFO: renamed from: b */
    private int f2206b;

    /* JADX INFO: renamed from: c */
    private int f2207c;

    /* JADX INFO: renamed from: d */
    private int f2208d;

    /* JADX INFO: renamed from: e */
    private int f2209e;

    /* JADX INFO: renamed from: f */
    private int f2210f;

    /* JADX INFO: renamed from: g */
    private int f2211g;

    /* JADX INFO: renamed from: h */
    private int f2212h;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2207c = i;
        this.f2205a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX INFO: renamed from: a */
    public final V m2417a(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f2205a.get(k);
            if (v != null) {
                this.f2211g++;
                return v;
            }
            this.f2212h++;
            V vM2424c = m2424c(k);
            if (vM2424c == null) {
                return null;
            }
            synchronized (this) {
                this.f2209e++;
                vPut = this.f2205a.put(k, vM2424c);
                if (vPut != null) {
                    this.f2205a.put(k, vPut);
                } else {
                    this.f2206b += m2416c(k, vM2424c);
                }
            }
            if (vPut != null) {
                mo2421a(false, k, vM2424c, vPut);
                return vPut;
            }
            m2420a(this.f2207c);
            return vM2424c;
        }
    }

    /* JADX INFO: renamed from: a */
    public final V m2418a(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2208d++;
            this.f2206b += m2416c(k, v);
            vPut = this.f2205a.put(k, v);
            if (vPut != null) {
                this.f2206b -= m2416c(k, vPut);
            }
        }
        if (vPut != null) {
            mo2421a(false, k, vPut, v);
        }
        m2420a(this.f2207c);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m2420a(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f2206b     // Catch: java.lang.Throwable -> L32
            if (r0 < 0) goto L11
            java.util.LinkedHashMap<K, V> r0 = r4.f2205a     // Catch: java.lang.Throwable -> L32
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L35
            int r0 = r4.f2206b     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L35
        L11:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r1.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.Class r2 = r4.getClass()     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L32
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L32
            throw r0     // Catch: java.lang.Throwable -> L32
        L32:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            throw r0
        L35:
            int r0 = r4.f2206b     // Catch: java.lang.Throwable -> L32
            if (r0 <= r5) goto L41
            java.util.LinkedHashMap<K, V> r0 = r4.f2205a     // Catch: java.lang.Throwable -> L32
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L43
        L41:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            return
        L43:
            java.util.LinkedHashMap<K, V> r0 = r4.f2205a     // Catch: java.lang.Throwable -> L32
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L32
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L32
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L32
            java.util.LinkedHashMap<K, V> r2 = r4.f2205a     // Catch: java.lang.Throwable -> L32
            r2.remove(r1)     // Catch: java.lang.Throwable -> L32
            int r2 = r4.f2206b     // Catch: java.lang.Throwable -> L32
            int r3 = r4.m2416c(r1, r0)     // Catch: java.lang.Throwable -> L32
            int r2 = r2 - r3
            r4.f2206b = r2     // Catch: java.lang.Throwable -> L32
            int r2 = r4.f2210f     // Catch: java.lang.Throwable -> L32
            int r2 = r2 + 1
            r4.f2210f = r2     // Catch: java.lang.Throwable -> L32
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L32
            r2 = 1
            r3 = 0
            r4.mo2421a(r2, r1, r0, r3)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.m2420a(int):void");
    }

    /* JADX INFO: renamed from: b */
    public final V m2423b(K k) {
        V vRemove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            vRemove = this.f2205a.remove(k);
            if (vRemove != null) {
                this.f2206b -= m2416c(k, vRemove);
            }
        }
        if (vRemove != null) {
            mo2421a(false, k, vRemove, null);
        }
        return vRemove;
    }

    /* JADX INFO: renamed from: a */
    protected void mo2421a(boolean z, K k, V v, V v2) {
    }

    /* JADX INFO: renamed from: c */
    protected V m2424c(K k) {
        return null;
    }

    /* JADX INFO: renamed from: c */
    private int m2416c(K k, V v) {
        int iMo2422b = mo2422b(k, v);
        if (iMo2422b < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return iMo2422b;
    }

    /* JADX INFO: renamed from: b */
    protected int mo2422b(K k, V v) {
        return 1;
    }

    /* JADX INFO: renamed from: a */
    public final void m2419a() {
        m2420a(-1);
    }

    public final synchronized String toString() {
        String str;
        synchronized (this) {
            int i = this.f2211g + this.f2212h;
            str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2207c), Integer.valueOf(this.f2211g), Integer.valueOf(this.f2212h), Integer.valueOf(i != 0 ? (this.f2211g * 100) / i : 0));
        }
        return str;
    }
}
