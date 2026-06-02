package android.support.constraint.solver;

/* JADX INFO: loaded from: classes.dex */
final class Pools {

    interface Pool<T> {
        /* JADX INFO: renamed from: a */
        T mo188a();

        /* JADX INFO: renamed from: a */
        void mo189a(T[] tArr, int i);

        /* JADX INFO: renamed from: a */
        boolean mo190a(T t);
    }

    static class SimplePool<T> implements Pool<T> {

        /* JADX INFO: renamed from: a */
        private final Object[] f231a;

        /* JADX INFO: renamed from: b */
        private int f232b;

        SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f231a = new Object[i];
        }

        @Override // android.support.constraint.solver.Pools.Pool
        /* JADX INFO: renamed from: a */
        public T mo188a() {
            if (this.f232b <= 0) {
                return null;
            }
            int i = this.f232b - 1;
            T t = (T) this.f231a[i];
            this.f231a[i] = null;
            this.f232b--;
            return t;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        /* JADX INFO: renamed from: a */
        public boolean mo190a(T t) {
            if (this.f232b >= this.f231a.length) {
                return false;
            }
            this.f231a[this.f232b] = t;
            this.f232b++;
            return true;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        /* JADX INFO: renamed from: a */
        public void mo189a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.f232b < this.f231a.length) {
                    this.f231a[this.f232b] = t;
                    this.f232b++;
                }
            }
        }
    }
}
