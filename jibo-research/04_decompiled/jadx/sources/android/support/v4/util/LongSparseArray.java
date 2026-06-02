package android.support.v4.util;

/* JADX INFO: loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private static final Object f2200a = new Object();

    /* JADX INFO: renamed from: b */
    private boolean f2201b;

    /* JADX INFO: renamed from: c */
    private long[] f2202c;

    /* JADX INFO: renamed from: d */
    private Object[] f2203d;

    /* JADX INFO: renamed from: e */
    private int f2204e;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f2201b = false;
        if (i == 0) {
            this.f2202c = ContainerHelpers.f2196b;
            this.f2203d = ContainerHelpers.f2197c;
        } else {
            int iM2400b = ContainerHelpers.m2400b(i);
            this.f2202c = new long[iM2400b];
            this.f2203d = new Object[iM2400b];
        }
        this.f2204e = 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f2202c = (long[]) this.f2202c.clone();
                longSparseArray.f2203d = (Object[]) this.f2203d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public E m2406a(long j) {
        return m2407a(j, null);
    }

    /* JADX INFO: renamed from: a */
    public E m2407a(long j, E e) {
        int iM2398a = ContainerHelpers.m2398a(this.f2202c, this.f2204e, j);
        return (iM2398a < 0 || this.f2203d[iM2398a] == f2200a) ? e : (E) this.f2203d[iM2398a];
    }

    /* JADX INFO: renamed from: b */
    public void m2411b(long j) {
        int iM2398a = ContainerHelpers.m2398a(this.f2202c, this.f2204e, j);
        if (iM2398a >= 0 && this.f2203d[iM2398a] != f2200a) {
            this.f2203d[iM2398a] = f2200a;
            this.f2201b = true;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2408a(int i) {
        if (this.f2203d[i] != f2200a) {
            this.f2203d[i] = f2200a;
            this.f2201b = true;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2404d() {
        int i = this.f2204e;
        long[] jArr = this.f2202c;
        Object[] objArr = this.f2203d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2200a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2201b = false;
        this.f2204e = i2;
    }

    /* JADX INFO: renamed from: b */
    public void m2412b(long j, E e) {
        int iM2398a = ContainerHelpers.m2398a(this.f2202c, this.f2204e, j);
        if (iM2398a >= 0) {
            this.f2203d[iM2398a] = e;
            return;
        }
        int iM2398a2 = iM2398a ^ (-1);
        if (iM2398a2 < this.f2204e && this.f2203d[iM2398a2] == f2200a) {
            this.f2202c[iM2398a2] = j;
            this.f2203d[iM2398a2] = e;
            return;
        }
        if (this.f2201b && this.f2204e >= this.f2202c.length) {
            m2404d();
            iM2398a2 = ContainerHelpers.m2398a(this.f2202c, this.f2204e, j) ^ (-1);
        }
        if (this.f2204e >= this.f2202c.length) {
            int iM2400b = ContainerHelpers.m2400b(this.f2204e + 1);
            long[] jArr = new long[iM2400b];
            Object[] objArr = new Object[iM2400b];
            System.arraycopy(this.f2202c, 0, jArr, 0, this.f2202c.length);
            System.arraycopy(this.f2203d, 0, objArr, 0, this.f2203d.length);
            this.f2202c = jArr;
            this.f2203d = objArr;
        }
        if (this.f2204e - iM2398a2 != 0) {
            System.arraycopy(this.f2202c, iM2398a2, this.f2202c, iM2398a2 + 1, this.f2204e - iM2398a2);
            System.arraycopy(this.f2203d, iM2398a2, this.f2203d, iM2398a2 + 1, this.f2204e - iM2398a2);
        }
        this.f2202c[iM2398a2] = j;
        this.f2203d[iM2398a2] = e;
        this.f2204e++;
    }

    /* JADX INFO: renamed from: b */
    public int m2409b() {
        if (this.f2201b) {
            m2404d();
        }
        return this.f2204e;
    }

    /* JADX INFO: renamed from: b */
    public long m2410b(int i) {
        if (this.f2201b) {
            m2404d();
        }
        return this.f2202c[i];
    }

    /* JADX INFO: renamed from: c */
    public E m2414c(int i) {
        if (this.f2201b) {
            m2404d();
        }
        return (E) this.f2203d[i];
    }

    /* JADX INFO: renamed from: c */
    public int m2413c(long j) {
        if (this.f2201b) {
            m2404d();
        }
        return ContainerHelpers.m2398a(this.f2202c, this.f2204e, j);
    }

    /* JADX INFO: renamed from: c */
    public void m2415c() {
        int i = this.f2204e;
        Object[] objArr = this.f2203d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2204e = 0;
        this.f2201b = false;
    }

    public String toString() {
        if (m2409b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2204e * 28);
        sb.append('{');
        for (int i = 0; i < this.f2204e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m2410b(i));
            sb.append('=');
            E eM2414c = m2414c(i);
            if (eM2414c != this) {
                sb.append(eM2414c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
