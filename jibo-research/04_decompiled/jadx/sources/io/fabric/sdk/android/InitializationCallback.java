package io.fabric.sdk.android;

/* JADX INFO: loaded from: classes2.dex */
public interface InitializationCallback<T> {

    /* JADX INFO: renamed from: d */
    public static final InitializationCallback f14527d = new Empty();

    /* JADX INFO: renamed from: a */
    void mo15099a(Exception exc);

    /* JADX INFO: renamed from: a */
    void mo15100a(T t);

    public static class Empty implements InitializationCallback<Object> {
        private Empty() {
        }

        @Override // io.fabric.sdk.android.InitializationCallback
        /* JADX INFO: renamed from: a */
        public void mo15100a(Object obj) {
        }

        @Override // io.fabric.sdk.android.InitializationCallback
        /* JADX INFO: renamed from: a */
        public void mo15099a(Exception exc) {
        }
    }
}
