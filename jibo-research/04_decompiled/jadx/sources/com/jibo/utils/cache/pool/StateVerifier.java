package com.jibo.utils.cache.pool;

/* JADX INFO: loaded from: classes.dex */
public abstract class StateVerifier {
    /* JADX INFO: renamed from: a */
    abstract void mo11524a(boolean z);

    /* JADX INFO: renamed from: a */
    public static StateVerifier m11523a() {
        return new DefaultStateVerifier();
    }

    private StateVerifier() {
    }

    private static class DefaultStateVerifier extends StateVerifier {

        /* JADX INFO: renamed from: a */
        private volatile boolean f11723a;

        private DefaultStateVerifier() {
            super();
        }

        @Override // com.jibo.utils.cache.pool.StateVerifier
        /* JADX INFO: renamed from: a */
        public void mo11524a(boolean z) {
            this.f11723a = z;
        }
    }
}
