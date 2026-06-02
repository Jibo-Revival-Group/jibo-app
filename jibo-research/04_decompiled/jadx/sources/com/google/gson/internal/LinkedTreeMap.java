package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: f */
    static final /* synthetic */ boolean f8870f;

    /* JADX INFO: renamed from: g */
    private static final Comparator<Comparable> f8871g;

    /* JADX INFO: renamed from: a */
    Comparator<? super K> f8872a;

    /* JADX INFO: renamed from: b */
    Node<K, V> f8873b;

    /* JADX INFO: renamed from: c */
    int f8874c;

    /* JADX INFO: renamed from: d */
    int f8875d;

    /* JADX INFO: renamed from: e */
    final Node<K, V> f8876e;

    /* JADX INFO: renamed from: h */
    private LinkedTreeMap<K, V>.EntrySet f8877h;

    /* JADX INFO: renamed from: i */
    private LinkedTreeMap<K, V>.KeySet f8878i;

    static {
        f8870f = !LinkedTreeMap.class.desiredAssertionStatus();
        f8871g = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    public LinkedTreeMap() {
        this(f8871g);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.f8874c = 0;
        this.f8875d = 0;
        this.f8876e = new Node<>();
        this.f8872a = comparator == null ? f8871g : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f8874c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> nodeM9476a = m9476a(obj);
        if (nodeM9476a != null) {
            return nodeM9476a.f8893g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m9476a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        Node<K, V> nodeM9477a = m9477a((Object) k, true);
        V v2 = nodeM9477a.f8893g;
        nodeM9477a.f8893g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f8873b = null;
        this.f8874c = 0;
        this.f8875d++;
        Node<K, V> node = this.f8876e;
        node.f8891e = node;
        node.f8890d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> nodeM9480b = m9480b(obj);
        if (nodeM9480b != null) {
            return nodeM9480b.f8893g;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    Node<K, V> m9477a(K k, boolean z) {
        Node<K, V> node;
        int i;
        Node<K, V> node2;
        int iCompare;
        Comparator<? super K> comparator = this.f8872a;
        Node<K, V> node3 = this.f8873b;
        if (node3 == null) {
            node = node3;
            i = 0;
        } else {
            Comparable comparable = comparator == f8871g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    iCompare = comparable.compareTo(node3.f8892f);
                } else {
                    iCompare = comparator.compare(k, node3.f8892f);
                }
                if (iCompare == 0) {
                    return node3;
                }
                Node<K, V> node4 = iCompare < 0 ? node3.f8888b : node3.f8889c;
                if (node4 == null) {
                    int i2 = iCompare;
                    node = node3;
                    i = i2;
                    break;
                }
                node3 = node4;
            }
        }
        if (!z) {
            return null;
        }
        Node<K, V> node5 = this.f8876e;
        if (node == null) {
            if (comparator == f8871g && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            node2 = new Node<>(node, k, node5, node5.f8891e);
            this.f8873b = node2;
        } else {
            node2 = new Node<>(node, k, node5, node5.f8891e);
            if (i < 0) {
                node.f8888b = node2;
            } else {
                node.f8889c = node2;
            }
            m9475b(node, true);
        }
        this.f8874c++;
        this.f8875d++;
        return node2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    Node<K, V> m9476a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return m9477a(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    Node<K, V> m9478a(Map.Entry<?, ?> entry) {
        Node<K, V> nodeM9476a = m9476a(entry.getKey());
        if (nodeM9476a != null && m9473a(nodeM9476a.f8893g, entry.getValue())) {
            return nodeM9476a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9473a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    void m9479a(Node<K, V> node, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            node.f8891e.f8890d = node.f8890d;
            node.f8890d.f8891e = node.f8891e;
        }
        Node<K, V> node2 = node.f8888b;
        Node<K, V> node3 = node.f8889c;
        Node<K, V> node4 = node.f8887a;
        if (node2 != null && node3 != null) {
            Node<K, V> nodeM9485b = node2.f8894h > node3.f8894h ? node2.m9485b() : node3.m9484a();
            m9479a((Node) nodeM9485b, false);
            Node<K, V> node5 = node.f8888b;
            if (node5 != null) {
                i = node5.f8894h;
                nodeM9485b.f8888b = node5;
                node5.f8887a = nodeM9485b;
                node.f8888b = null;
            } else {
                i = 0;
            }
            Node<K, V> node6 = node.f8889c;
            if (node6 != null) {
                i2 = node6.f8894h;
                nodeM9485b.f8889c = node6;
                node6.f8887a = nodeM9485b;
                node.f8889c = null;
            }
            nodeM9485b.f8894h = Math.max(i, i2) + 1;
            m9472a((Node) node, (Node) nodeM9485b);
            return;
        }
        if (node2 != null) {
            m9472a((Node) node, (Node) node2);
            node.f8888b = null;
        } else if (node3 != null) {
            m9472a((Node) node, (Node) node3);
            node.f8889c = null;
        } else {
            m9472a((Node) node, (Node) null);
        }
        m9475b(node4, false);
        this.f8874c--;
        this.f8875d++;
    }

    /* JADX INFO: renamed from: b */
    Node<K, V> m9480b(Object obj) {
        Node<K, V> nodeM9476a = m9476a(obj);
        if (nodeM9476a != null) {
            m9479a((Node) nodeM9476a, true);
        }
        return nodeM9476a;
    }

    /* JADX INFO: renamed from: a */
    private void m9472a(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.f8887a;
        node.f8887a = null;
        if (node2 != null) {
            node2.f8887a = node3;
        }
        if (node3 != null) {
            if (node3.f8888b == node) {
                node3.f8888b = node2;
                return;
            } else {
                if (!f8870f && node3.f8889c != node) {
                    throw new AssertionError();
                }
                node3.f8889c = node2;
                return;
            }
        }
        this.f8873b = node2;
    }

    /* JADX INFO: renamed from: b */
    private void m9475b(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.f8888b;
            Node<K, V> node3 = node.f8889c;
            int i = node2 != null ? node2.f8894h : 0;
            int i2 = node3 != null ? node3.f8894h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node<K, V> node4 = node3.f8888b;
                Node<K, V> node5 = node3.f8889c;
                int i4 = (node4 != null ? node4.f8894h : 0) - (node5 != null ? node5.f8894h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    m9471a((Node) node);
                } else {
                    if (!f8870f && i4 != 1) {
                        throw new AssertionError();
                    }
                    m9474b((Node) node3);
                    m9471a((Node) node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                Node<K, V> node6 = node2.f8888b;
                Node<K, V> node7 = node2.f8889c;
                int i5 = (node6 != null ? node6.f8894h : 0) - (node7 != null ? node7.f8894h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    m9474b((Node) node);
                } else {
                    if (!f8870f && i5 != -1) {
                        throw new AssertionError();
                    }
                    m9471a((Node) node2);
                    m9474b((Node) node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.f8894h = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!f8870f && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                node.f8894h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.f8887a;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9471a(Node<K, V> node) {
        Node<K, V> node2 = node.f8888b;
        Node<K, V> node3 = node.f8889c;
        Node<K, V> node4 = node3.f8888b;
        Node<K, V> node5 = node3.f8889c;
        node.f8889c = node4;
        if (node4 != null) {
            node4.f8887a = node;
        }
        m9472a((Node) node, (Node) node3);
        node3.f8888b = node;
        node.f8887a = node3;
        node.f8894h = Math.max(node2 != null ? node2.f8894h : 0, node4 != null ? node4.f8894h : 0) + 1;
        node3.f8894h = Math.max(node.f8894h, node5 != null ? node5.f8894h : 0) + 1;
    }

    /* JADX INFO: renamed from: b */
    private void m9474b(Node<K, V> node) {
        Node<K, V> node2 = node.f8888b;
        Node<K, V> node3 = node.f8889c;
        Node<K, V> node4 = node2.f8888b;
        Node<K, V> node5 = node2.f8889c;
        node.f8888b = node5;
        if (node5 != null) {
            node5.f8887a = node;
        }
        m9472a((Node) node, (Node) node2);
        node2.f8889c = node;
        node.f8887a = node2;
        node.f8894h = Math.max(node3 != null ? node3.f8894h : 0, node5 != null ? node5.f8894h : 0) + 1;
        node2.f8894h = Math.max(node.f8894h, node4 != null ? node4.f8894h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.f8877h;
        if (entrySet != null) {
            return entrySet;
        }
        LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.f8877h = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.f8878i;
        if (keySet != null) {
            return keySet;
        }
        LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.f8878i = keySet2;
        return keySet2;
    }

    static final class Node<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a */
        Node<K, V> f8887a;

        /* JADX INFO: renamed from: b */
        Node<K, V> f8888b;

        /* JADX INFO: renamed from: c */
        Node<K, V> f8889c;

        /* JADX INFO: renamed from: d */
        Node<K, V> f8890d;

        /* JADX INFO: renamed from: e */
        Node<K, V> f8891e;

        /* JADX INFO: renamed from: f */
        final K f8892f;

        /* JADX INFO: renamed from: g */
        V f8893g;

        /* JADX INFO: renamed from: h */
        int f8894h;

        Node() {
            this.f8892f = null;
            this.f8891e = this;
            this.f8890d = this;
        }

        Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.f8887a = node;
            this.f8892f = k;
            this.f8894h = 1;
            this.f8890d = node2;
            this.f8891e = node3;
            node3.f8890d = this;
            node2.f8891e = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f8892f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f8893g;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f8893g;
            this.f8893g = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f8892f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f8892f.equals(entry.getKey())) {
                return false;
            }
            if (this.f8893g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f8893g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.f8892f == null ? 0 : this.f8892f.hashCode()) ^ (this.f8893g != null ? this.f8893g.hashCode() : 0);
        }

        public String toString() {
            return this.f8892f + "=" + this.f8893g;
        }

        /* JADX INFO: renamed from: a */
        public Node<K, V> m9484a() {
            for (Node<K, V> node = this.f8888b; node != null; node = node.f8888b) {
                this = node;
            }
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Node<K, V> m9485b() {
            for (Node<K, V> node = this.f8889c; node != null; node = node.f8889c) {
                this = node;
            }
            return this;
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: b */
        Node<K, V> f8883b;

        /* JADX INFO: renamed from: c */
        Node<K, V> f8884c = null;

        /* JADX INFO: renamed from: d */
        int f8885d;

        LinkedTreeMapIterator() {
            this.f8883b = LinkedTreeMap.this.f8876e.f8890d;
            this.f8885d = LinkedTreeMap.this.f8875d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f8883b != LinkedTreeMap.this.f8876e;
        }

        /* JADX INFO: renamed from: b */
        final Node<K, V> m9483b() {
            Node<K, V> node = this.f8883b;
            if (node == LinkedTreeMap.this.f8876e) {
                throw new NoSuchElementException();
            }
            if (LinkedTreeMap.this.f8875d != this.f8885d) {
                throw new ConcurrentModificationException();
            }
            this.f8883b = node.f8890d;
            this.f8884c = node;
            return node;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f8884c == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.m9479a((Node) this.f8884c, true);
            this.f8884c = null;
            this.f8885d = LinkedTreeMap.this.f8875d;
        }
    }

    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f8874c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> next() {
                    return m9483b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.m9478a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> nodeM9478a;
            if (!(obj instanceof Map.Entry) || (nodeM9478a = LinkedTreeMap.this.m9478a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.m9479a((Node) nodeM9478a, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f8874c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return m9483b().f8892f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.m9480b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
