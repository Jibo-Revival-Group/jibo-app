package android.support.v7.view.menu;

/* JADX INFO: loaded from: classes.dex */
class BaseWrapper<T> {

    /* JADX INFO: renamed from: b */
    final T f3275b;

    BaseWrapper(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f3275b = t;
    }
}
