package android.support.v4.util;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {

    /* JADX INFO: renamed from: b */
    static Object[] f2233b;

    /* JADX INFO: renamed from: c */
    static int f2234c;

    /* JADX INFO: renamed from: d */
    static Object[] f2235d;

    /* JADX INFO: renamed from: e */
    static int f2236e;

    /* JADX INFO: renamed from: f */
    int[] f2237f;

    /* JADX INFO: renamed from: g */
    Object[] f2238g;

    /* JADX INFO: renamed from: h */
    int f2239h;

    /* JADX INFO: renamed from: a */
    private static int m2442a(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.m2397a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: a */
    int m2447a(Object obj, int i) {
        int i2 = this.f2239h;
        if (i2 == 0) {
            return -1;
        }
        int iM2442a = m2442a(this.f2237f, i2, i);
        if (iM2442a >= 0 && !obj.equals(this.f2238g[iM2442a << 1])) {
            int i3 = iM2442a + 1;
            while (i3 < i2 && this.f2237f[i3] == i) {
                if (obj.equals(this.f2238g[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iM2442a - 1; i4 >= 0 && this.f2237f[i4] == i; i4--) {
                if (obj.equals(this.f2238g[i4 << 1])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return iM2442a;
    }

    /* JADX INFO: renamed from: a */
    int m2445a() {
        int i = this.f2239h;
        if (i == 0) {
            return -1;
        }
        int iM2442a = m2442a(this.f2237f, i, 0);
        if (iM2442a >= 0 && this.f2238g[iM2442a << 1] != null) {
            int i2 = iM2442a + 1;
            while (i2 < i && this.f2237f[i2] == 0) {
                if (this.f2238g[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = iM2442a - 1; i3 >= 0 && this.f2237f[i3] == 0; i3--) {
                if (this.f2238g[i3 << 1] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return iM2442a;
    }

    /* JADX INFO: renamed from: e */
    private void m2444e(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f2235d != null) {
                    Object[] objArr = f2235d;
                    this.f2238g = objArr;
                    f2235d = (Object[]) objArr[0];
                    this.f2237f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2236e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f2233b != null) {
                    Object[] objArr2 = f2233b;
                    this.f2238g = objArr2;
                    f2233b = (Object[]) objArr2[0];
                    this.f2237f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2234c--;
                    return;
                }
            }
        }
        this.f2237f = new int[i];
        this.f2238g = new Object[i << 1];
    }

    /* JADX INFO: renamed from: a */
    private static void m2443a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f2236e < 10) {
                    objArr[0] = f2235d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f2235d = objArr;
                    f2236e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f2234c < 10) {
                    objArr[0] = f2233b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2233b = objArr;
                    f2234c++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.f2237f = ContainerHelpers.f2195a;
        this.f2238g = ContainerHelpers.f2197c;
        this.f2239h = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f2237f = ContainerHelpers.f2195a;
            this.f2238g = ContainerHelpers.f2197c;
        } else {
            m2444e(i);
        }
        this.f2239h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            m2450a((SimpleArrayMap) simpleArrayMap);
        }
    }

    public void clear() {
        if (this.f2239h > 0) {
            int[] iArr = this.f2237f;
            Object[] objArr = this.f2238g;
            int i = this.f2239h;
            this.f2237f = ContainerHelpers.f2195a;
            this.f2238g = ContainerHelpers.f2197c;
            this.f2239h = 0;
            m2443a(iArr, objArr, i);
        }
        if (this.f2239h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2449a(int i) {
        int i2 = this.f2239h;
        if (this.f2237f.length < i) {
            int[] iArr = this.f2237f;
            Object[] objArr = this.f2238g;
            m2444e(i);
            if (this.f2239h > 0) {
                System.arraycopy(iArr, 0, this.f2237f, 0, i2);
                System.arraycopy(objArr, 0, this.f2238g, 0, i2 << 1);
            }
            m2443a(iArr, objArr, i2);
        }
        if (this.f2239h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m2446a(obj) >= 0;
    }

    /* JADX INFO: renamed from: a */
    public int m2446a(Object obj) {
        return obj == null ? m2445a() : m2447a(obj, obj.hashCode());
    }

    /* JADX INFO: renamed from: b */
    int m2451b(Object obj) {
        int i = 1;
        int i2 = this.f2239h * 2;
        Object[] objArr = this.f2238g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] != null) {
                    i += 2;
                } else {
                    return i >> 1;
                }
            }
        } else {
            while (i < i2) {
                if (!obj.equals(objArr[i])) {
                    i += 2;
                } else {
                    return i >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m2451b(obj) >= 0;
    }

    public V get(Object obj) {
        int iM2446a = m2446a(obj);
        if (iM2446a >= 0) {
            return (V) this.f2238g[(iM2446a << 1) + 1];
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public K m2452b(int i) {
        return (K) this.f2238g[i << 1];
    }

    /* JADX INFO: renamed from: c */
    public V m2453c(int i) {
        return (V) this.f2238g[(i << 1) + 1];
    }

    /* JADX INFO: renamed from: a */
    public V m2448a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.f2238g[i2];
        this.f2238g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f2239h <= 0;
    }

    public V put(K k, V v) {
        int iHashCode;
        int iM2447a;
        int i = 8;
        int i2 = this.f2239h;
        if (k == null) {
            iM2447a = m2445a();
            iHashCode = 0;
        } else {
            iHashCode = k.hashCode();
            iM2447a = m2447a(k, iHashCode);
        }
        if (iM2447a >= 0) {
            int i3 = (iM2447a << 1) + 1;
            V v2 = (V) this.f2238g[i3];
            this.f2238g[i3] = v;
            return v2;
        }
        int i4 = iM2447a ^ (-1);
        if (i2 >= this.f2237f.length) {
            if (i2 >= 8) {
                i = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i = 4;
            }
            int[] iArr = this.f2237f;
            Object[] objArr = this.f2238g;
            m2444e(i);
            if (i2 != this.f2239h) {
                throw new ConcurrentModificationException();
            }
            if (this.f2237f.length > 0) {
                System.arraycopy(iArr, 0, this.f2237f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2238g, 0, objArr.length);
            }
            m2443a(iArr, objArr, i2);
        }
        if (i4 < i2) {
            System.arraycopy(this.f2237f, i4, this.f2237f, i4 + 1, i2 - i4);
            System.arraycopy(this.f2238g, i4 << 1, this.f2238g, (i4 + 1) << 1, (this.f2239h - i4) << 1);
        }
        if (i2 != this.f2239h || i4 >= this.f2237f.length) {
            throw new ConcurrentModificationException();
        }
        this.f2237f[i4] = iHashCode;
        this.f2238g[i4 << 1] = k;
        this.f2238g[(i4 << 1) + 1] = v;
        this.f2239h++;
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m2450a(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f2239h;
        m2449a(this.f2239h + i);
        if (this.f2239h == 0) {
            if (i > 0) {
                System.arraycopy(simpleArrayMap.f2237f, 0, this.f2237f, 0, i);
                System.arraycopy(simpleArrayMap.f2238g, 0, this.f2238g, 0, i << 1);
                this.f2239h = i;
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            put(simpleArrayMap.m2452b(i2), simpleArrayMap.m2453c(i2));
        }
    }

    public V remove(Object obj) {
        int iM2446a = m2446a(obj);
        if (iM2446a >= 0) {
            return m2454d(iM2446a);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public V m2454d(int i) {
        int i2;
        V v = (V) this.f2238g[(i << 1) + 1];
        int i3 = this.f2239h;
        if (i3 <= 1) {
            m2443a(this.f2237f, this.f2238g, i3);
            this.f2237f = ContainerHelpers.f2195a;
            this.f2238g = ContainerHelpers.f2197c;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.f2237f.length > 8 && this.f2239h < this.f2237f.length / 3) {
                int i5 = i3 > 8 ? (i3 >> 1) + i3 : 8;
                int[] iArr = this.f2237f;
                Object[] objArr = this.f2238g;
                m2444e(i5);
                if (i3 != this.f2239h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f2237f, 0, i);
                    System.arraycopy(objArr, 0, this.f2238g, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(iArr, i + 1, this.f2237f, i, i4 - i);
                    System.arraycopy(objArr, (i + 1) << 1, this.f2238g, i << 1, (i4 - i) << 1);
                }
                i2 = i4;
            } else {
                if (i < i4) {
                    System.arraycopy(this.f2237f, i + 1, this.f2237f, i, i4 - i);
                    System.arraycopy(this.f2238g, (i + 1) << 1, this.f2238g, i << 1, (i4 - i) << 1);
                }
                this.f2238g[i4 << 1] = null;
                this.f2238g[(i4 << 1) + 1] = null;
                i2 = i4;
            }
        }
        if (i3 != this.f2239h) {
            throw new ConcurrentModificationException();
        }
        this.f2239h = i2;
        return v;
    }

    public int size() {
        return this.f2239h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i = 0; i < this.f2239h; i++) {
                try {
                    K kM2452b = m2452b(i);
                    V vM2453c = m2453c(i);
                    Object obj2 = simpleArrayMap.get(kM2452b);
                    if (vM2453c == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kM2452b)) {
                            return false;
                        }
                    } else if (!vM2453c.equals(obj2)) {
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
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f2239h; i2++) {
            try {
                K kM2452b2 = m2452b(i2);
                V vM2453c2 = m2453c(i2);
                Object obj3 = map.get(kM2452b2);
                if (vM2453c2 == null) {
                    if (obj3 != null || !map.containsKey(kM2452b2)) {
                        return false;
                    }
                } else if (!vM2453c2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException e3) {
                return false;
            } catch (NullPointerException e4) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f2237f;
        Object[] objArr = this.f2238g;
        int i = this.f2239h;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2239h * 28);
        sb.append('{');
        for (int i = 0; i < this.f2239h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kM2452b = m2452b(i);
            if (kM2452b != this) {
                sb.append(kM2452b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vM2453c = m2453c(i);
            if (vM2453c != this) {
                sb.append(vM2453c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
