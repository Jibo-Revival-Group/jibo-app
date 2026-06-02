package android.support.v4.widget;

import android.support.v4.util.Pools;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {

    /* JADX INFO: renamed from: a */
    private final Pools.Pool<ArrayList<T>> f2581a = new Pools.SimplePool(10);

    /* JADX INFO: renamed from: b */
    private final SimpleArrayMap<T, ArrayList<T>> f2582b = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: c */
    private final ArrayList<T> f2583c = new ArrayList<>();

    /* JADX INFO: renamed from: d */
    private final HashSet<T> f2584d = new HashSet<>();

    /* JADX INFO: renamed from: a */
    public void m2949a(T t) {
        if (!this.f2582b.containsKey(t)) {
            this.f2582b.put(t, null);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m2952b(T t) {
        return this.f2582b.containsKey(t);
    }

    /* JADX INFO: renamed from: a */
    public void m2950a(T t, T t2) {
        if (!this.f2582b.containsKey(t) || !this.f2582b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListM2947c = this.f2582b.get(t);
        if (arrayListM2947c == null) {
            arrayListM2947c = m2947c();
            this.f2582b.put(t, arrayListM2947c);
        }
        arrayListM2947c.add(t2);
    }

    /* JADX INFO: renamed from: c */
    public List m2953c(T t) {
        return this.f2582b.get(t);
    }

    /* JADX INFO: renamed from: d */
    public List<T> m2954d(T t) {
        ArrayList arrayList = null;
        int size = this.f2582b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM2453c = this.f2582b.m2453c(i);
            if (arrayListM2453c != null && arrayListM2453c.contains(t)) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.add(this.f2582b.m2452b(i));
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public boolean m2955e(T t) {
        int size = this.f2582b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM2453c = this.f2582b.m2453c(i);
            if (arrayListM2453c != null && arrayListM2453c.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m2948a() {
        int size = this.f2582b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM2453c = this.f2582b.m2453c(i);
            if (arrayListM2453c != null) {
                m2946a((ArrayList) arrayListM2453c);
            }
        }
        this.f2582b.clear();
    }

    /* JADX INFO: renamed from: b */
    public ArrayList<T> m2951b() {
        this.f2583c.clear();
        this.f2584d.clear();
        int size = this.f2582b.size();
        for (int i = 0; i < size; i++) {
            m2945a(this.f2582b.m2452b(i), this.f2583c, this.f2584d);
        }
        return this.f2583c;
    }

    /* JADX INFO: renamed from: a */
    private void m2945a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f2582b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m2945a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    /* JADX INFO: renamed from: c */
    private ArrayList<T> m2947c() {
        ArrayList<T> arrayListMo2438a = this.f2581a.mo2438a();
        if (arrayListMo2438a == null) {
            return new ArrayList<>();
        }
        return arrayListMo2438a;
    }

    /* JADX INFO: renamed from: a */
    private void m2946a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2581a.mo2439a(arrayList);
    }
}
