package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: a */
    private static final int[] f2184a = new int[0];

    /* JADX INFO: renamed from: b */
    private static final Object[] f2185b = new Object[0];

    /* JADX INFO: renamed from: c */
    private static Object[] f2186c;

    /* JADX INFO: renamed from: d */
    private static int f2187d;

    /* JADX INFO: renamed from: e */
    private static Object[] f2188e;

    /* JADX INFO: renamed from: f */
    private static int f2189f;

    /* JADX INFO: renamed from: g */
    private int[] f2190g;

    /* JADX INFO: renamed from: h */
    private Object[] f2191h;

    /* JADX INFO: renamed from: i */
    private int f2192i;

    /* JADX INFO: renamed from: j */
    private MapCollections<E, E> f2193j;

    /* JADX INFO: renamed from: a */
    private int m2385a(Object obj, int i) {
        int i2 = this.f2192i;
        if (i2 == 0) {
            return -1;
        }
        int iM2397a = ContainerHelpers.m2397a(this.f2190g, i2, i);
        if (iM2397a >= 0 && !obj.equals(this.f2191h[iM2397a])) {
            int i3 = iM2397a + 1;
            while (i3 < i2 && this.f2190g[i3] == i) {
                if (obj.equals(this.f2191h[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iM2397a - 1; i4 >= 0 && this.f2190g[i4] == i; i4--) {
                if (obj.equals(this.f2191h[i4])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return iM2397a;
    }

    /* JADX INFO: renamed from: a */
    private int m2384a() {
        int i = this.f2192i;
        if (i == 0) {
            return -1;
        }
        int iM2397a = ContainerHelpers.m2397a(this.f2190g, i, 0);
        if (iM2397a >= 0 && this.f2191h[iM2397a] != null) {
            int i2 = iM2397a + 1;
            while (i2 < i && this.f2190g[i2] == 0) {
                if (this.f2191h[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = iM2397a - 1; i3 >= 0 && this.f2190g[i3] == 0; i3--) {
                if (this.f2191h[i3] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return iM2397a;
    }

    /* JADX INFO: renamed from: d */
    private void m2390d(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (f2188e != null) {
                    Object[] objArr = f2188e;
                    this.f2191h = objArr;
                    f2188e = (Object[]) objArr[0];
                    this.f2190g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2189f--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (f2186c != null) {
                    Object[] objArr2 = f2186c;
                    this.f2191h = objArr2;
                    f2186c = (Object[]) objArr2[0];
                    this.f2190g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2187d--;
                    return;
                }
            }
        }
        this.f2190g = new int[i];
        this.f2191h = new Object[i];
    }

    /* JADX INFO: renamed from: a */
    private static void m2386a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f2189f < 10) {
                    objArr[0] = f2188e;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f2188e = objArr;
                    f2189f++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f2187d < 10) {
                    objArr[0] = f2186c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2186c = objArr;
                    f2187d++;
                }
            }
        }
    }

    public ArraySet() {
        this(0);
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.f2190g = f2184a;
            this.f2191h = f2185b;
        } else {
            m2390d(i);
        }
        this.f2192i = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (this.f2192i != 0) {
            m2386a(this.f2190g, this.f2191h, this.f2192i);
            this.f2190g = f2184a;
            this.f2191h = f2185b;
            this.f2192i = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2392a(int i) {
        if (this.f2190g.length < i) {
            int[] iArr = this.f2190g;
            Object[] objArr = this.f2191h;
            m2390d(i);
            if (this.f2192i > 0) {
                System.arraycopy(iArr, 0, this.f2190g, 0, this.f2192i);
                System.arraycopy(objArr, 0, this.f2191h, 0, this.f2192i);
            }
            m2386a(iArr, objArr, this.f2192i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return m2391a(obj) >= 0;
    }

    /* JADX INFO: renamed from: a */
    public int m2391a(Object obj) {
        return obj == null ? m2384a() : m2385a(obj, obj.hashCode());
    }

    /* JADX INFO: renamed from: b */
    public E m2394b(int i) {
        return (E) this.f2191h[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f2192i <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int iHashCode;
        int iM2385a;
        int i = 8;
        if (e == null) {
            iM2385a = m2384a();
            iHashCode = 0;
        } else {
            iHashCode = e.hashCode();
            iM2385a = m2385a(e, iHashCode);
        }
        if (iM2385a >= 0) {
            return false;
        }
        int i2 = iM2385a ^ (-1);
        if (this.f2192i >= this.f2190g.length) {
            if (this.f2192i >= 8) {
                i = this.f2192i + (this.f2192i >> 1);
            } else if (this.f2192i < 4) {
                i = 4;
            }
            int[] iArr = this.f2190g;
            Object[] objArr = this.f2191h;
            m2390d(i);
            if (this.f2190g.length > 0) {
                System.arraycopy(iArr, 0, this.f2190g, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2191h, 0, objArr.length);
            }
            m2386a(iArr, objArr, this.f2192i);
        }
        if (i2 < this.f2192i) {
            System.arraycopy(this.f2190g, i2, this.f2190g, i2 + 1, this.f2192i - i2);
            System.arraycopy(this.f2191h, i2, this.f2191h, i2 + 1, this.f2192i - i2);
        }
        this.f2190g[i2] = iHashCode;
        this.f2191h[i2] = e;
        this.f2192i++;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m2393a(ArraySet<? extends E> arraySet) {
        int i = arraySet.f2192i;
        m2392a(this.f2192i + i);
        if (this.f2192i == 0) {
            if (i > 0) {
                System.arraycopy(arraySet.f2190g, 0, this.f2190g, 0, i);
                System.arraycopy(arraySet.f2191h, 0, this.f2191h, 0, i);
                this.f2192i = i;
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            add(arraySet.m2394b(i2));
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iM2391a = m2391a(obj);
        if (iM2391a < 0) {
            return false;
        }
        m2395c(iM2391a);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public E m2395c(int i) {
        E e = (E) this.f2191h[i];
        if (this.f2192i <= 1) {
            m2386a(this.f2190g, this.f2191h, this.f2192i);
            this.f2190g = f2184a;
            this.f2191h = f2185b;
            this.f2192i = 0;
        } else if (this.f2190g.length > 8 && this.f2192i < this.f2190g.length / 3) {
            int i2 = this.f2192i > 8 ? this.f2192i + (this.f2192i >> 1) : 8;
            int[] iArr = this.f2190g;
            Object[] objArr = this.f2191h;
            m2390d(i2);
            this.f2192i--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f2190g, 0, i);
                System.arraycopy(objArr, 0, this.f2191h, 0, i);
            }
            if (i < this.f2192i) {
                System.arraycopy(iArr, i + 1, this.f2190g, i, this.f2192i - i);
                System.arraycopy(objArr, i + 1, this.f2191h, i, this.f2192i - i);
            }
        } else {
            this.f2192i--;
            if (i < this.f2192i) {
                System.arraycopy(this.f2190g, i + 1, this.f2190g, i, this.f2192i - i);
                System.arraycopy(this.f2191h, i + 1, this.f2191h, i, this.f2192i - i);
            }
            this.f2191h[this.f2192i] = null;
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f2192i;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[this.f2192i];
        System.arraycopy(this.f2191h, 0, objArr, 0, this.f2192i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = tArr.length < this.f2192i ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2192i)) : tArr;
        System.arraycopy(this.f2191h, 0, objArr, 0, this.f2192i);
        if (objArr.length > this.f2192i) {
            objArr[this.f2192i] = null;
        }
        return (T[]) objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        for (int i = 0; i < this.f2192i; i++) {
            try {
                if (!set.contains(m2394b(i))) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f2190g;
        int i = this.f2192i;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2192i * 14);
        sb.append('{');
        for (int i = 0; i < this.f2192i; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eM2394b = m2394b(i);
            if (eM2394b != this) {
                sb.append(eM2394b);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    private MapCollections<E, E> m2388b() {
        if (this.f2193j == null) {
            this.f2193j = new MapCollections<E, E>() { // from class: android.support.v4.util.ArraySet.1
                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected int mo2375a() {
                    return ArraySet.this.f2192i;
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected Object mo2377a(int i, int i2) {
                    return ArraySet.this.f2191h[i];
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected int mo2376a(Object obj) {
                    return ArraySet.this.m2391a(obj);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: b */
                protected int mo2381b(Object obj) {
                    return ArraySet.this.m2391a(obj);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: b */
                protected Map<E, E> mo2382b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected void mo2380a(E e, E e2) {
                    ArraySet.this.add(e);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected E mo2378a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected void mo2379a(int i) {
                    ArraySet.this.m2395c(i);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: c */
                protected void mo2383c() {
                    ArraySet.this.clear();
                }
            };
        }
        return this.f2193j;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return m2388b().m2432e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        m2392a(this.f2192i + collection.size());
        boolean zAdd = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean zRemove = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f2192i - 1; i >= 0; i--) {
            if (!collection.contains(this.f2191h[i])) {
                m2395c(i);
                z = true;
            }
        }
        return z;
    }
}
