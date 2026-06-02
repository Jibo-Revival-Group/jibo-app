package android.arch.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* JADX INFO: renamed from: a */
    public abstract State mo38a();

    /* JADX INFO: renamed from: a */
    public abstract void mo39a(LifecycleObserver lifecycleObserver);

    /* JADX INFO: renamed from: b */
    public abstract void mo40b(LifecycleObserver lifecycleObserver);

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }
}
