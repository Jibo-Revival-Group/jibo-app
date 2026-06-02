package com.jibo.utils.cache.pool;

import android.support.v4.util.Pools;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class FactoryPools {

    /* JADX INFO: renamed from: a */
    private static final Resetter<Object> f11719a = new Resetter<Object>() { // from class: com.jibo.utils.cache.pool.FactoryPools.1
        @Override // com.jibo.utils.cache.pool.FactoryPools.Resetter
        /* JADX INFO: renamed from: a */
        public void mo11522a(Object obj) {
        }
    };

    public interface Factory<T> {
        /* JADX INFO: renamed from: b */
        T mo11515b();
    }

    public interface Poolable {
        /* JADX INFO: renamed from: a */
        StateVerifier mo11517a();
    }

    public interface Resetter<T> {
        /* JADX INFO: renamed from: a */
        void mo11522a(T t);
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Poolable> Pools.Pool<T> m11518a(int i, Factory<T> factory) {
        return m11519a(new Pools.SynchronizedPool(i), factory);
    }

    /* JADX INFO: renamed from: a */
    private static <T extends Poolable> Pools.Pool<T> m11519a(Pools.Pool<T> pool, Factory<T> factory) {
        return m11520a(pool, factory, m11521a());
    }

    /* JADX INFO: renamed from: a */
    private static <T> Pools.Pool<T> m11520a(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    /* JADX INFO: renamed from: a */
    private static <T> Resetter<T> m11521a() {
        return (Resetter<T>) f11719a;
    }

    private static final class FactoryPool<T> implements Pools.Pool<T> {

        /* JADX INFO: renamed from: a */
        private final Factory<T> f11720a;

        /* JADX INFO: renamed from: b */
        private final Resetter<T> f11721b;

        /* JADX INFO: renamed from: c */
        private final Pools.Pool<T> f11722c;

        FactoryPool(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
            this.f11722c = pool;
            this.f11720a = factory;
            this.f11721b = resetter;
        }

        @Override // android.support.v4.util.Pools.Pool
        /* JADX INFO: renamed from: a */
        public T mo2438a() {
            T tMo2438a = this.f11722c.mo2438a();
            if (tMo2438a == null) {
                tMo2438a = this.f11720a.mo11515b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tMo2438a.getClass());
                }
            }
            if (tMo2438a instanceof Poolable) {
                ((Poolable) tMo2438a).mo11517a().mo11524a(false);
            }
            return tMo2438a;
        }

        @Override // android.support.v4.util.Pools.Pool
        /* JADX INFO: renamed from: a */
        public boolean mo2439a(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).mo11517a().mo11524a(true);
            }
            this.f11721b.mo11522a(t);
            return this.f11722c.mo2439a(t);
        }
    }
}
