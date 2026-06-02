package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a */
    MapCollections<K, V> f2182a;

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    /* JADX INFO: renamed from: b */
    private MapCollections<K, V> m2373b() {
        if (this.f2182a == null) {
            this.f2182a = new MapCollections<K, V>() { // from class: android.support.v4.util.ArrayMap.1
                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected int mo2375a() {
                    return ArrayMap.this.f2239h;
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected Object mo2377a(int i, int i2) {
                    return ArrayMap.this.f2238g[(i << 1) + i2];
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected int mo2376a(Object obj) {
                    return ArrayMap.this.m2446a(obj);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: b */
                protected int mo2381b(Object obj) {
                    return ArrayMap.this.m2451b(obj);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: b */
                protected Map<K, V> mo2382b() {
                    return ArrayMap.this;
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected void mo2380a(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected V mo2378a(int i, V v) {
                    return ArrayMap.this.m2448a(i, v);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: a */
                protected void mo2379a(int i) {
                    ArrayMap.this.m2454d(i);
                }

                @Override // android.support.v4.util.MapCollections
                /* JADX INFO: renamed from: c */
                protected void mo2383c() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.f2182a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m2449a(this.f2239h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2374a(Collection<?> collection) {
        return MapCollections.m2428c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m2373b().m2431d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m2373b().m2432e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m2373b().m2433f();
    }
}
