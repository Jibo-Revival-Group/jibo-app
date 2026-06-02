package android.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a */
    private Entry<K, V> f9a;

    /* JADX INFO: renamed from: b */
    private Entry<K, V> f10b;

    /* JADX INFO: renamed from: c */
    private WeakHashMap<SupportRemove<K, V>, Boolean> f11c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d */
    private int f12d = 0;

    interface SupportRemove<K, V> {
        /* JADX INFO: renamed from: a_ */
        void mo19a_(Entry<K, V> entry);
    }

    /* JADX INFO: renamed from: a */
    protected Entry<K, V> mo4a(K k) {
        Entry<K, V> entry = this.f9a;
        while (entry != null && !entry.f13a.equals(k)) {
            entry = entry.f15c;
        }
        return entry;
    }

    /* JADX INFO: renamed from: a */
    public V mo5a(K k, V v) {
        Entry<K, V> entryMo4a = mo4a(k);
        if (entryMo4a != null) {
            return entryMo4a.f14b;
        }
        m11b(k, v);
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected Entry<K, V> m11b(K k, V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        this.f12d++;
        if (this.f10b == null) {
            this.f9a = entry;
            this.f10b = this.f9a;
        } else {
            this.f10b.f15c = entry;
            entry.f16d = this.f10b;
            this.f10b = entry;
        }
        return entry;
    }

    /* JADX INFO: renamed from: b */
    public V mo6b(K k) {
        Entry<K, V> entryMo4a = mo4a(k);
        if (entryMo4a == null) {
            return null;
        }
        this.f12d--;
        if (!this.f11c.isEmpty()) {
            Iterator<SupportRemove<K, V>> it = this.f11c.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo19a_(entryMo4a);
            }
        }
        if (entryMo4a.f16d != null) {
            entryMo4a.f16d.f15c = entryMo4a.f15c;
        } else {
            this.f9a = entryMo4a.f15c;
        }
        if (entryMo4a.f15c != null) {
            entryMo4a.f15c.f16d = entryMo4a.f16d;
        } else {
            this.f10b = entryMo4a.f16d;
        }
        entryMo4a.f15c = null;
        entryMo4a.f16d = null;
        return entryMo4a.f14b;
    }

    /* JADX INFO: renamed from: a */
    public int m10a() {
        return this.f12d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f9a, this.f10b);
        this.f11c.put(ascendingIterator, false);
        return ascendingIterator;
    }

    /* JADX INFO: renamed from: b */
    public Iterator<Map.Entry<K, V>> m12b() {
        DescendingIterator descendingIterator = new DescendingIterator(this.f10b, this.f9a);
        this.f11c.put(descendingIterator, false);
        return descendingIterator;
    }

    /* JADX INFO: renamed from: c */
    public SafeIterableMap<K, V>.IteratorWithAdditions m13c() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.f11c.put(iteratorWithAdditions, false);
        return iteratorWithAdditions;
    }

    /* JADX INFO: renamed from: d */
    public Map.Entry<K, V> m14d() {
        return this.f9a;
    }

    /* JADX INFO: renamed from: e */
    public Map.Entry<K, V> m15e() {
        return this.f10b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (m10a() != safeIterableMap.m10a()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if (next == null && next2 != null) {
                return false;
            }
            if (next != null && !next.equals(next2)) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static abstract class ListIterator<K, V> implements SupportRemove<K, V>, Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a */
        Entry<K, V> f20a;

        /* JADX INFO: renamed from: b */
        Entry<K, V> f21b;

        /* JADX INFO: renamed from: a */
        abstract Entry<K, V> mo16a(Entry<K, V> entry);

        /* JADX INFO: renamed from: b */
        abstract Entry<K, V> mo17b(Entry<K, V> entry);

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.f20a = entry2;
            this.f21b = entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21b != null;
        }

        @Override // android.arch.core.internal.SafeIterableMap.SupportRemove
        /* JADX INFO: renamed from: a_ */
        public void mo19a_(Entry<K, V> entry) {
            if (this.f20a == entry && entry == this.f21b) {
                this.f21b = null;
                this.f20a = null;
            }
            if (this.f20a == entry) {
                this.f20a = mo17b(this.f20a);
            }
            if (this.f21b == entry) {
                this.f21b = m20b();
            }
        }

        /* JADX INFO: renamed from: b */
        private Entry<K, V> m20b() {
            if (this.f21b == this.f20a || this.f20a == null) {
                return null;
            }
            return mo16a(this.f21b);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.f21b;
            this.f21b = m20b();
            return entry;
        }
    }

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // android.arch.core.internal.SafeIterableMap.ListIterator
        /* JADX INFO: renamed from: a */
        Entry<K, V> mo16a(Entry<K, V> entry) {
            return entry.f15c;
        }

        @Override // android.arch.core.internal.SafeIterableMap.ListIterator
        /* JADX INFO: renamed from: b */
        Entry<K, V> mo17b(Entry<K, V> entry) {
            return entry.f16d;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // android.arch.core.internal.SafeIterableMap.ListIterator
        /* JADX INFO: renamed from: a */
        Entry<K, V> mo16a(Entry<K, V> entry) {
            return entry.f16d;
        }

        @Override // android.arch.core.internal.SafeIterableMap.ListIterator
        /* JADX INFO: renamed from: b */
        Entry<K, V> mo17b(Entry<K, V> entry) {
            return entry.f15c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class IteratorWithAdditions implements SupportRemove<K, V>, Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b */
        private Entry<K, V> f18b;

        /* JADX INFO: renamed from: c */
        private boolean f19c;

        private IteratorWithAdditions() {
            this.f19c = true;
        }

        @Override // android.arch.core.internal.SafeIterableMap.SupportRemove
        /* JADX INFO: renamed from: a_ */
        public void mo19a_(Entry<K, V> entry) {
            if (entry == this.f18b) {
                this.f18b = this.f18b.f16d;
                this.f19c = this.f18b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19c ? SafeIterableMap.this.f9a != null : (this.f18b == null || this.f18b.f15c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f19c) {
                this.f19c = false;
                this.f18b = SafeIterableMap.this.f9a;
            } else {
                this.f18b = this.f18b != null ? this.f18b.f15c : null;
            }
            return this.f18b;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a */
        final K f13a;

        /* JADX INFO: renamed from: b */
        final V f14b;

        /* JADX INFO: renamed from: c */
        Entry<K, V> f15c;

        /* JADX INFO: renamed from: d */
        Entry<K, V> f16d;

        Entry(K k, V v) {
            this.f13a = k;
            this.f14b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f13a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f14b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f13a + "=" + this.f14b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f13a.equals(entry.f13a) && this.f14b.equals(entry.f14b);
        }
    }
}
