package android.support.v4.util;

/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    public interface Pool<T> {
        /* JADX INFO: renamed from: a */
        T mo2438a();

        /* JADX INFO: renamed from: a */
        boolean mo2439a(T t);
    }

    public static class SimplePool<T> implements Pool<T> {

        /* JADX INFO: renamed from: a */
        private final Object[] f2230a;

        /* JADX INFO: renamed from: b */
        private int f2231b;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2230a = new Object[i];
        }

        @Override // android.support.v4.util.Pools.Pool
        /* JADX INFO: renamed from: a */
        public T mo2438a() {
            if (this.f2231b <= 0) {
                return null;
            }
            int i = this.f2231b - 1;
            T t = (T) this.f2230a[i];
            this.f2230a[i] = null;
            this.f2231b--;
            return t;
        }

        @Override // android.support.v4.util.Pools.Pool
        /* JADX INFO: renamed from: a */
        public boolean mo2439a(T t) {
            if (m2440b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.f2231b >= this.f2230a.length) {
                return false;
            }
            this.f2230a[this.f2231b] = t;
            this.f2231b++;
            return true;
        }

        /* JADX INFO: renamed from: b */
        private boolean m2440b(T t) {
            for (int i = 0; i < this.f2231b; i++) {
                if (this.f2230a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* JADX INFO: renamed from: a */
        private final Object f2232a;

        public SynchronizedPool(int i) {
            super(i);
            this.f2232a = new Object();
        }

        @Override // android.support.v4.util.Pools.SimplePool, android.support.v4.util.Pools.Pool
        /* JADX INFO: renamed from: a */
        public T mo2438a() {
            T t;
            synchronized (this.f2232a) {
                t = (T) super.mo2438a();
            }
            return t;
        }

        @Override // android.support.v4.util.Pools.SimplePool, android.support.v4.util.Pools.Pool
        /* JADX INFO: renamed from: a */
        public boolean mo2439a(T t) {
            boolean zMo2439a;
            synchronized (this.f2232a) {
                zMo2439a = super.mo2439a(t);
            }
            return zMo2439a;
        }
    }
}
