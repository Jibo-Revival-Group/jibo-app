package android.arch.core.internal;

import android.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* JADX INFO: renamed from: a */
    private HashMap<K, SafeIterableMap.Entry<K, V>> f8a = new HashMap<>();

    @Override // android.arch.core.internal.SafeIterableMap
    /* JADX INFO: renamed from: a */
    protected SafeIterableMap.Entry<K, V> mo4a(K k) {
        return this.f8a.get(k);
    }

    @Override // android.arch.core.internal.SafeIterableMap
    /* JADX INFO: renamed from: a */
    public V mo5a(K k, V v) {
        SafeIterableMap.Entry<K, V> entryMo4a = mo4a(k);
        if (entryMo4a != null) {
            return entryMo4a.f14b;
        }
        this.f8a.put(k, m11b(k, v));
        return null;
    }

    @Override // android.arch.core.internal.SafeIterableMap
    /* JADX INFO: renamed from: b */
    public V mo6b(K k) {
        V v = (V) super.mo6b(k);
        this.f8a.remove(k);
        return v;
    }

    /* JADX INFO: renamed from: c */
    public boolean m7c(K k) {
        return this.f8a.containsKey(k);
    }

    /* JADX INFO: renamed from: d */
    public Map.Entry<K, V> m8d(K k) {
        if (m7c(k)) {
            return this.f8a.get(k).f16d;
        }
        return null;
    }
}
