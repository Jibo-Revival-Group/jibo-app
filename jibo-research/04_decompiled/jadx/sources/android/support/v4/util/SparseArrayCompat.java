package android.support.v4.util;

/* JADX INFO: loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private static final Object f2240a = new Object();

    /* JADX INFO: renamed from: b */
    private boolean f2241b;

    /* JADX INFO: renamed from: c */
    private int[] f2242c;

    /* JADX INFO: renamed from: d */
    private Object[] f2243d;

    /* JADX INFO: renamed from: e */
    private int f2244e;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f2241b = false;
        if (i == 0) {
            this.f2242c = ContainerHelpers.f2195a;
            this.f2243d = ContainerHelpers.f2197c;
        } else {
            int iM2396a = ContainerHelpers.m2396a(i);
            this.f2242c = new int[iM2396a];
            this.f2243d = new Object[iM2396a];
        }
        this.f2244e = 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f2242c = (int[]) this.f2242c.clone();
                sparseArrayCompat.f2243d = (Object[]) this.f2243d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public E m2457a(int i) {
        return m2458a(i, null);
    }

    /* JADX INFO: renamed from: a */
    public E m2458a(int i, E e) {
        int iM2397a = ContainerHelpers.m2397a(this.f2242c, this.f2244e, i);
        return (iM2397a < 0 || this.f2243d[iM2397a] == f2240a) ? e : (E) this.f2243d[iM2397a];
    }

    /* JADX INFO: renamed from: b */
    public void m2460b(int i) {
        int iM2397a = ContainerHelpers.m2397a(this.f2242c, this.f2244e, i);
        if (iM2397a >= 0 && this.f2243d[iM2397a] != f2240a) {
            this.f2243d[iM2397a] = f2240a;
            this.f2241b = true;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2463c(int i) {
        m2460b(i);
    }

    /* JADX INFO: renamed from: d */
    private void m2455d() {
        int i = this.f2244e;
        int[] iArr = this.f2242c;
        Object[] objArr = this.f2243d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2240a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2241b = false;
        this.f2244e = i2;
    }

    /* JADX INFO: renamed from: b */
    public void m2461b(int i, E e) {
        int iM2397a = ContainerHelpers.m2397a(this.f2242c, this.f2244e, i);
        if (iM2397a >= 0) {
            this.f2243d[iM2397a] = e;
            return;
        }
        int iM2397a2 = iM2397a ^ (-1);
        if (iM2397a2 < this.f2244e && this.f2243d[iM2397a2] == f2240a) {
            this.f2242c[iM2397a2] = i;
            this.f2243d[iM2397a2] = e;
            return;
        }
        if (this.f2241b && this.f2244e >= this.f2242c.length) {
            m2455d();
            iM2397a2 = ContainerHelpers.m2397a(this.f2242c, this.f2244e, i) ^ (-1);
        }
        if (this.f2244e >= this.f2242c.length) {
            int iM2396a = ContainerHelpers.m2396a(this.f2244e + 1);
            int[] iArr = new int[iM2396a];
            Object[] objArr = new Object[iM2396a];
            System.arraycopy(this.f2242c, 0, iArr, 0, this.f2242c.length);
            System.arraycopy(this.f2243d, 0, objArr, 0, this.f2243d.length);
            this.f2242c = iArr;
            this.f2243d = objArr;
        }
        if (this.f2244e - iM2397a2 != 0) {
            System.arraycopy(this.f2242c, iM2397a2, this.f2242c, iM2397a2 + 1, this.f2244e - iM2397a2);
            System.arraycopy(this.f2243d, iM2397a2, this.f2243d, iM2397a2 + 1, this.f2244e - iM2397a2);
        }
        this.f2242c[iM2397a2] = i;
        this.f2243d[iM2397a2] = e;
        this.f2244e++;
    }

    /* JADX INFO: renamed from: b */
    public int m2459b() {
        if (this.f2241b) {
            m2455d();
        }
        return this.f2244e;
    }

    /* JADX INFO: renamed from: d */
    public int m2465d(int i) {
        if (this.f2241b) {
            m2455d();
        }
        return this.f2242c[i];
    }

    /* JADX INFO: renamed from: e */
    public E m2466e(int i) {
        if (this.f2241b) {
            m2455d();
        }
        return (E) this.f2243d[i];
    }

    /* JADX INFO: renamed from: f */
    public int m2467f(int i) {
        if (this.f2241b) {
            m2455d();
        }
        return ContainerHelpers.m2397a(this.f2242c, this.f2244e, i);
    }

    /* JADX INFO: renamed from: c */
    public void m2462c() {
        int i = this.f2244e;
        Object[] objArr = this.f2243d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2244e = 0;
        this.f2241b = false;
    }

    /* JADX INFO: renamed from: c */
    public void m2464c(int i, E e) {
        if (this.f2244e != 0 && i <= this.f2242c[this.f2244e - 1]) {
            m2461b(i, e);
            return;
        }
        if (this.f2241b && this.f2244e >= this.f2242c.length) {
            m2455d();
        }
        int i2 = this.f2244e;
        if (i2 >= this.f2242c.length) {
            int iM2396a = ContainerHelpers.m2396a(i2 + 1);
            int[] iArr = new int[iM2396a];
            Object[] objArr = new Object[iM2396a];
            System.arraycopy(this.f2242c, 0, iArr, 0, this.f2242c.length);
            System.arraycopy(this.f2243d, 0, objArr, 0, this.f2243d.length);
            this.f2242c = iArr;
            this.f2243d = objArr;
        }
        this.f2242c[i2] = i;
        this.f2243d[i2] = e;
        this.f2244e = i2 + 1;
    }

    public String toString() {
        if (m2459b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2244e * 28);
        sb.append('{');
        for (int i = 0; i < this.f2244e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m2465d(i));
            sb.append('=');
            E eM2466e = m2466e(i);
            if (eM2466e != this) {
                sb.append(eM2466e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
