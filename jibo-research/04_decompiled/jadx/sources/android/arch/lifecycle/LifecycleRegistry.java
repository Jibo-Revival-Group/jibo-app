package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.core.internal.SafeIterableMap;
import android.arch.lifecycle.Lifecycle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* JADX INFO: renamed from: c */
    private final WeakReference<LifecycleOwner> f34c;

    /* JADX INFO: renamed from: a */
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> f32a = new FastSafeIterableMap<>();

    /* JADX INFO: renamed from: d */
    private int f35d = 0;

    /* JADX INFO: renamed from: e */
    private boolean f36e = false;

    /* JADX INFO: renamed from: f */
    private boolean f37f = false;

    /* JADX INFO: renamed from: g */
    private ArrayList<Lifecycle.State> f38g = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private Lifecycle.State f33b = Lifecycle.State.INITIALIZED;

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.f34c = new WeakReference<>(lifecycleOwner);
    }

    /* JADX INFO: renamed from: a */
    public void m54a(Lifecycle.State state) {
        m44b(state);
    }

    /* JADX INFO: renamed from: a */
    public void m53a(Lifecycle.Event event) {
        m44b(m43b(event));
    }

    /* JADX INFO: renamed from: b */
    private void m44b(Lifecycle.State state) {
        if (this.f33b != state) {
            this.f33b = state;
            if (this.f36e || this.f35d != 0) {
                this.f37f = true;
                return;
            }
            this.f36e = true;
            m51d();
            this.f36e = false;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m46b() {
        if (this.f32a.m10a() == 0) {
            return true;
        }
        Lifecycle.State state = this.f32a.m14d().getValue().f41a;
        Lifecycle.State state2 = this.f32a.m15e().getValue().f41a;
        return state == state2 && this.f33b == state2;
    }

    /* JADX INFO: renamed from: c */
    private Lifecycle.State m47c(LifecycleObserver lifecycleObserver) {
        Map.Entry<LifecycleObserver, ObserverWithState> entryM8d = this.f32a.m8d(lifecycleObserver);
        return m41a(m41a(this.f33b, entryM8d != null ? entryM8d.getValue().f41a : null), !this.f38g.isEmpty() ? this.f38g.get(this.f38g.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    /* JADX INFO: renamed from: a */
    public void mo39a(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, this.f33b == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.f32a.mo5a(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.f34c.get()) != null) {
            boolean z = this.f35d != 0 || this.f36e;
            Lifecycle.State stateM47c = m47c(lifecycleObserver);
            this.f35d++;
            while (observerWithState.f41a.compareTo(stateM47c) < 0 && this.f32a.m7c(lifecycleObserver)) {
                m49c(observerWithState.f41a);
                observerWithState.m55a(lifecycleOwner, m52e(observerWithState.f41a));
                m48c();
                stateM47c = m47c(lifecycleObserver);
            }
            if (!z) {
                m51d();
            }
            this.f35d--;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m48c() {
        this.f38g.remove(this.f38g.size() - 1);
    }

    /* JADX INFO: renamed from: c */
    private void m49c(Lifecycle.State state) {
        this.f38g.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    /* JADX INFO: renamed from: b */
    public void mo40b(LifecycleObserver lifecycleObserver) {
        this.f32a.mo6b(lifecycleObserver);
    }

    @Override // android.arch.lifecycle.Lifecycle
    /* JADX INFO: renamed from: a */
    public Lifecycle.State mo38a() {
        return this.f33b;
    }

    /* JADX INFO: renamed from: b */
    static Lifecycle.State m43b(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    /* JADX INFO: renamed from: d */
    private static Lifecycle.Event m50d(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return Lifecycle.Event.ON_DESTROY;
            case STARTED:
                return Lifecycle.Event.ON_STOP;
            case RESUMED:
                return Lifecycle.Event.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    /* JADX INFO: renamed from: e */
    private static Lifecycle.Event m52e(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Lifecycle.Event.ON_CREATE;
            case CREATED:
                return Lifecycle.Event.ON_START;
            case STARTED:
                return Lifecycle.Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m42a(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions iteratorWithAdditionsC = this.f32a.m13c();
        while (iteratorWithAdditionsC.hasNext() && !this.f37f) {
            Map.Entry next = iteratorWithAdditionsC.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.f41a.compareTo(this.f33b) < 0 && !this.f37f && this.f32a.m7c((LifecycleObserver) next.getKey())) {
                m49c(observerWithState.f41a);
                observerWithState.m55a(lifecycleOwner, m52e(observerWithState.f41a));
                m48c();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m45b(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> itB = this.f32a.m12b();
        while (itB.hasNext() && !this.f37f) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = itB.next();
            ObserverWithState value = next.getValue();
            while (value.f41a.compareTo(this.f33b) > 0 && !this.f37f && this.f32a.m7c(next.getKey())) {
                Lifecycle.Event eventM50d = m50d(value.f41a);
                m49c(m43b(eventM50d));
                value.m55a(lifecycleOwner, eventM50d);
                m48c();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m51d() {
        LifecycleOwner lifecycleOwner = this.f34c.get();
        if (lifecycleOwner == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m46b()) {
            this.f37f = false;
            if (this.f33b.compareTo(this.f32a.m14d().getValue().f41a) < 0) {
                m45b(lifecycleOwner);
            }
            Map.Entry<LifecycleObserver, ObserverWithState> entryE = this.f32a.m15e();
            if (!this.f37f && entryE != null && this.f33b.compareTo(entryE.getValue().f41a) > 0) {
                m42a(lifecycleOwner);
            }
        }
        this.f37f = false;
    }

    /* JADX INFO: renamed from: a */
    static Lifecycle.State m41a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    static class ObserverWithState {

        /* JADX INFO: renamed from: a */
        Lifecycle.State f41a;

        /* JADX INFO: renamed from: b */
        GenericLifecycleObserver f42b;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f42b = Lifecycling.m58a(lifecycleObserver);
            this.f41a = state;
        }

        /* JADX INFO: renamed from: a */
        void m55a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State stateM43b = LifecycleRegistry.m43b(event);
            this.f41a = LifecycleRegistry.m41a(this.f41a, stateM43b);
            this.f42b.mo30a(lifecycleOwner, event);
            this.f41a = stateM43b;
        }
    }
}
