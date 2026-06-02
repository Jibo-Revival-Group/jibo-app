package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.arch.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: b */
    private static final Object f45b = new Object();

    /* JADX INFO: renamed from: h */
    private boolean f52h;

    /* JADX INFO: renamed from: i */
    private boolean f53i;

    /* JADX INFO: renamed from: a */
    private final Object f46a = new Object();

    /* JADX INFO: renamed from: c */
    private SafeIterableMap<Observer<T>, LiveData<T>.ObserverWrapper> f47c = new SafeIterableMap<>();

    /* JADX INFO: renamed from: d */
    private int f48d = 0;

    /* JADX INFO: renamed from: e */
    private volatile Object f49e = f45b;

    /* JADX INFO: renamed from: f */
    private volatile Object f50f = f45b;

    /* JADX INFO: renamed from: g */
    private int f51g = -1;

    /* JADX INFO: renamed from: j */
    private final Runnable f54j = new Runnable() { // from class: android.arch.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f46a) {
                obj = LiveData.this.f50f;
                LiveData.this.f50f = LiveData.f45b;
            }
            LiveData.this.mo79b(obj);
        }
    };

    /* JADX INFO: renamed from: a */
    private void m67a(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.f59d) {
            if (!observerWrapper.mo82a()) {
                observerWrapper.m85a(false);
            } else if (observerWrapper.f60e < this.f51g) {
                observerWrapper.f60e = this.f51g;
                observerWrapper.f58c.mo86a((T) this.f49e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m71b(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.f52h) {
            this.f53i = true;
            return;
        }
        this.f52h = true;
        do {
            this.f53i = false;
            if (observerWrapper != null) {
                m67a((ObserverWrapper) observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap<Observer<T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions iteratorWithAdditionsM13c = this.f47c.m13c();
                while (iteratorWithAdditionsM13c.hasNext()) {
                    m67a((ObserverWrapper) iteratorWithAdditionsM13c.next().getValue());
                    if (this.f53i) {
                        break;
                    }
                }
            }
        } while (this.f53i);
        this.f52h = false;
    }

    /* JADX INFO: renamed from: a */
    public void m75a(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().mo38a() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            LiveData<T>.ObserverWrapper observerWrapperMo5a = this.f47c.mo5a(observer, lifecycleBoundObserver);
            if (observerWrapperMo5a != null && !observerWrapperMo5a.mo83a(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (observerWrapperMo5a == null) {
                lifecycleOwner.getLifecycle().mo39a(lifecycleBoundObserver);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo76a(Observer<T> observer) {
        m69a("removeObserver");
        LiveData<T>.ObserverWrapper observerWrapperMo6b = this.f47c.mo6b(observer);
        if (observerWrapperMo6b != null) {
            observerWrapperMo6b.mo84b();
            observerWrapperMo6b.m85a(false);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo77a(T t) {
        boolean z;
        synchronized (this.f46a) {
            z = this.f50f == f45b;
            this.f50f = t;
        }
        if (z) {
            ArchTaskExecutor.m0a().mo2b(this.f54j);
        }
    }

    /* JADX INFO: renamed from: b */
    protected void mo79b(T t) {
        m69a("setValue");
        this.f51g++;
        this.f49e = t;
        m71b((ObserverWrapper) null);
    }

    /* JADX INFO: renamed from: a */
    public T m74a() {
        T t = (T) this.f49e;
        if (t != f45b) {
            return t;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected void mo78b() {
    }

    /* JADX INFO: renamed from: c */
    protected void mo80c() {
    }

    /* JADX INFO: renamed from: d */
    public boolean m81d() {
        return this.f48d > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {

        /* JADX INFO: renamed from: a */
        final LifecycleOwner f56a;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            super(observer);
            this.f56a = lifecycleOwner;
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        /* JADX INFO: renamed from: a */
        boolean mo82a() {
            return this.f56a.getLifecycle().mo38a().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        /* JADX INFO: renamed from: a */
        public void mo30a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (this.f56a.getLifecycle().mo38a() == Lifecycle.State.DESTROYED) {
                LiveData.this.mo76a((Observer) this.f58c);
            } else {
                m85a(mo82a());
            }
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        /* JADX INFO: renamed from: a */
        boolean mo83a(LifecycleOwner lifecycleOwner) {
            return this.f56a == lifecycleOwner;
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        /* JADX INFO: renamed from: b */
        void mo84b() {
            this.f56a.getLifecycle().mo40b(this);
        }
    }

    private abstract class ObserverWrapper {

        /* JADX INFO: renamed from: c */
        final Observer<T> f58c;

        /* JADX INFO: renamed from: d */
        boolean f59d;

        /* JADX INFO: renamed from: e */
        int f60e = -1;

        /* JADX INFO: renamed from: a */
        abstract boolean mo82a();

        ObserverWrapper(Observer<T> observer) {
            this.f58c = observer;
        }

        /* JADX INFO: renamed from: a */
        boolean mo83a(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        void mo84b() {
        }

        /* JADX INFO: renamed from: a */
        void m85a(boolean z) {
            if (z != this.f59d) {
                this.f59d = z;
                boolean z2 = LiveData.this.f48d == 0;
                LiveData liveData = LiveData.this;
                liveData.f48d = (this.f59d ? 1 : -1) + liveData.f48d;
                if (z2 && this.f59d) {
                    LiveData.this.mo78b();
                }
                if (LiveData.this.f48d == 0 && !this.f59d) {
                    LiveData.this.mo80c();
                }
                if (this.f59d) {
                    LiveData.this.m71b(this);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m69a(String str) {
        if (!ArchTaskExecutor.m0a().mo3b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
