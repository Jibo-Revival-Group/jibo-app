package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class MapCollections<K, V> {

    /* JADX INFO: renamed from: b */
    MapCollections<K, V>.EntrySet f2213b;

    /* JADX INFO: renamed from: c */
    MapCollections<K, V>.KeySet f2214c;

    /* JADX INFO: renamed from: d */
    MapCollections<K, V>.ValuesCollection f2215d;

    /* JADX INFO: renamed from: a */
    protected abstract int mo2375a();

    /* JADX INFO: renamed from: a */
    protected abstract int mo2376a(Object obj);

    /* JADX INFO: renamed from: a */
    protected abstract Object mo2377a(int i, int i2);

    /* JADX INFO: renamed from: a */
    protected abstract V mo2378a(int i, V v);

    /* JADX INFO: renamed from: a */
    protected abstract void mo2379a(int i);

    /* JADX INFO: renamed from: a */
    protected abstract void mo2380a(K k, V v);

    /* JADX INFO: renamed from: b */
    protected abstract int mo2381b(Object obj);

    /* JADX INFO: renamed from: b */
    protected abstract Map<K, V> mo2382b();

    /* JADX INFO: renamed from: c */
    protected abstract void mo2383c();

    MapCollections() {
    }

    final class ArrayIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a */
        final int f2216a;

        /* JADX INFO: renamed from: b */
        int f2217b;

        /* JADX INFO: renamed from: c */
        int f2218c;

        /* JADX INFO: renamed from: d */
        boolean f2219d = false;

        ArrayIterator(int i) {
            this.f2216a = i;
            this.f2217b = MapCollections.this.mo2375a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2218c < this.f2217b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) MapCollections.this.mo2377a(this.f2218c, this.f2216a);
            this.f2218c++;
            this.f2219d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2219d) {
                throw new IllegalStateException();
            }
            this.f2218c--;
            this.f2217b--;
            this.f2219d = false;
            MapCollections.this.mo2379a(this.f2218c);
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a */
        int f2223a;

        /* JADX INFO: renamed from: c */
        boolean f2225c = false;

        /* JADX INFO: renamed from: b */
        int f2224b = -1;

        MapIterator() {
            this.f2223a = MapCollections.this.mo2375a() - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2224b < this.f2223a;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2224b++;
            this.f2225c = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2225c) {
                throw new IllegalStateException();
            }
            MapCollections.this.mo2379a(this.f2224b);
            this.f2224b--;
            this.f2223a--;
            this.f2225c = false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.f2225c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) MapCollections.this.mo2377a(this.f2224b, 0);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.f2225c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) MapCollections.this.mo2377a(this.f2224b, 1);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (!this.f2225c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) MapCollections.this.mo2378a(this.f2224b, v);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f2225c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ContainerHelpers.m2399a(entry.getKey(), MapCollections.this.mo2377a(this.f2224b, 0)) && ContainerHelpers.m2399a(entry.getValue(), MapCollections.this.mo2377a(this.f2224b, 1));
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f2225c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objMo2377a = MapCollections.this.mo2377a(this.f2224b, 0);
            Object objMo2377a2 = MapCollections.this.mo2377a(this.f2224b, 1);
            return (objMo2377a2 != null ? objMo2377a2.hashCode() : 0) ^ (objMo2377a == null ? 0 : objMo2377a.hashCode());
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class EntrySet implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iMo2375a = MapCollections.this.mo2375a();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.mo2380a(entry.getKey(), entry.getValue());
            }
            return iMo2375a != MapCollections.this.mo2375a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.mo2383c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iMo2376a = MapCollections.this.mo2376a(entry.getKey());
            if (iMo2376a >= 0) {
                return ContainerHelpers.m2399a(MapCollections.this.mo2377a(iMo2376a, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.mo2375a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.mo2375a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.m2426a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iMo2375a = MapCollections.this.mo2375a() - 1;
            int iHashCode = 0;
            while (iMo2375a >= 0) {
                Object objMo2377a = MapCollections.this.mo2377a(iMo2375a, 0);
                Object objMo2377a2 = MapCollections.this.mo2377a(iMo2375a, 1);
                iMo2375a--;
                iHashCode += (objMo2377a2 == null ? 0 : objMo2377a2.hashCode()) ^ (objMo2377a == null ? 0 : objMo2377a.hashCode());
            }
            return iHashCode;
        }
    }

    final class KeySet implements Set<K> {
        KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.mo2383c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return MapCollections.this.mo2376a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.m2425a((Map) MapCollections.this.mo2382b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.mo2375a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iMo2376a = MapCollections.this.mo2376a(obj);
            if (iMo2376a < 0) {
                return false;
            }
            MapCollections.this.mo2379a(iMo2376a);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.m2427b(MapCollections.this.mo2382b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.m2428c(MapCollections.this.mo2382b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.mo2375a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.m2430b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.m2429a(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.m2426a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo2375a = MapCollections.this.mo2375a() - 1; iMo2375a >= 0; iMo2375a--) {
                Object objMo2377a = MapCollections.this.mo2377a(iMo2375a, 0);
                iHashCode += objMo2377a == null ? 0 : objMo2377a.hashCode();
            }
            return iHashCode;
        }
    }

    final class ValuesCollection implements Collection<V> {
        ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            MapCollections.this.mo2383c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return MapCollections.this.mo2381b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.mo2375a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iMo2381b = MapCollections.this.mo2381b(obj);
            if (iMo2381b < 0) {
                return false;
            }
            MapCollections.this.mo2379a(iMo2381b);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int iMo2375a = MapCollections.this.mo2375a();
            boolean z = false;
            while (i < iMo2375a) {
                if (collection.contains(MapCollections.this.mo2377a(i, 1))) {
                    MapCollections.this.mo2379a(i);
                    i--;
                    iMo2375a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int iMo2375a = MapCollections.this.mo2375a();
            boolean z = false;
            while (i < iMo2375a) {
                if (!collection.contains(MapCollections.this.mo2377a(i, 1))) {
                    MapCollections.this.mo2379a(i);
                    i--;
                    iMo2375a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return MapCollections.this.mo2375a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.m2430b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.m2429a(tArr, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public static <K, V> boolean m2425a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static <K, V> boolean m2427b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* JADX INFO: renamed from: c */
    public static <K, V> boolean m2428c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* JADX INFO: renamed from: b */
    public Object[] m2430b(int i) {
        int iMo2375a = mo2375a();
        Object[] objArr = new Object[iMo2375a];
        for (int i2 = 0; i2 < iMo2375a; i2++) {
            objArr[i2] = mo2377a(i2, i);
        }
        return objArr;
    }

    /* JADX INFO: renamed from: a */
    public <T> T[] m2429a(T[] tArr, int i) {
        int iMo2375a = mo2375a();
        Object[] objArr = tArr.length < iMo2375a ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iMo2375a)) : tArr;
        for (int i2 = 0; i2 < iMo2375a; i2++) {
            objArr[i2] = mo2377a(i2, i);
        }
        if (objArr.length > iMo2375a) {
            objArr[iMo2375a] = null;
        }
        return (T[]) objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> boolean m2426a(java.util.Set<T> r4, java.lang.Object r5) {
        /*
            r0 = 1
            r1 = 0
            if (r4 != r5) goto L6
            r1 = r0
        L5:
            return r1
        L6:
            boolean r2 = r5 instanceof java.util.Set
            if (r2 == 0) goto L5
            java.util.Set r5 = (java.util.Set) r5
            int r2 = r4.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            int r3 = r5.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 != r3) goto L1e
            boolean r2 = r4.containsAll(r5)     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 == 0) goto L1e
        L1c:
            r1 = r0
            goto L5
        L1e:
            r0 = r1
            goto L1c
        L20:
            r0 = move-exception
            goto L5
        L22:
            r0 = move-exception
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.MapCollections.m2426a(java.util.Set, java.lang.Object):boolean");
    }

    /* JADX INFO: renamed from: d */
    public Set<Map.Entry<K, V>> m2431d() {
        if (this.f2213b == null) {
            this.f2213b = new EntrySet();
        }
        return this.f2213b;
    }

    /* JADX INFO: renamed from: e */
    public Set<K> m2432e() {
        if (this.f2214c == null) {
            this.f2214c = new KeySet();
        }
        return this.f2214c;
    }

    /* JADX INFO: renamed from: f */
    public Collection<V> m2433f() {
        if (this.f2215d == null) {
            this.f2215d = new ValuesCollection();
        }
        return this.f2215d;
    }
}
