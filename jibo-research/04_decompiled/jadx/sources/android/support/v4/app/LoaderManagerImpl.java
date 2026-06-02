package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class LoaderManagerImpl extends LoaderManager {

    /* JADX INFO: renamed from: a */
    static boolean f1648a = false;

    /* JADX INFO: renamed from: b */
    private final LifecycleOwner f1649b;

    /* JADX INFO: renamed from: c */
    private final LoaderViewModel f1650c;

    /* JADX INFO: renamed from: d */
    private boolean f1651d;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* JADX INFO: renamed from: a */
        private final int f1652a;

        /* JADX INFO: renamed from: b */
        private final Bundle f1653b;

        /* JADX INFO: renamed from: c */
        private final Loader<D> f1654c;

        /* JADX INFO: renamed from: d */
        private LifecycleOwner f1655d;

        /* JADX INFO: renamed from: e */
        private LoaderObserver<D> f1656e;

        LoaderInfo(int i, Bundle bundle, Loader<D> loader) {
            this.f1652a = i;
            this.f1653b = bundle;
            this.f1654c = loader;
            this.f1654c.m1859a(i, this);
        }

        /* JADX INFO: renamed from: f */
        Loader<D> m1697f() {
            return this.f1654c;
        }

        @Override // android.arch.lifecycle.LiveData
        /* JADX INFO: renamed from: b */
        protected void mo78b() {
            if (LoaderManagerImpl.f1648a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f1654c.m1868r();
        }

        @Override // android.arch.lifecycle.LiveData
        /* JADX INFO: renamed from: c */
        protected void mo80c() {
            if (LoaderManagerImpl.f1648a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f1654c.m1871u();
        }

        /* JADX INFO: renamed from: a */
        Loader<D> m1694a(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.f1654c, loaderCallbacks);
            m75a(lifecycleOwner, loaderObserver);
            if (this.f1656e != null) {
                mo76a((Observer) this.f1656e);
            }
            this.f1655d = lifecycleOwner;
            this.f1656e = loaderObserver;
            return this.f1654c;
        }

        /* JADX INFO: renamed from: g */
        void m1698g() {
            LifecycleOwner lifecycleOwner = this.f1655d;
            LoaderObserver<D> loaderObserver = this.f1656e;
            if (lifecycleOwner != null && loaderObserver != null) {
                mo76a((Observer) loaderObserver);
                m75a(lifecycleOwner, loaderObserver);
            }
        }

        /* JADX INFO: renamed from: h */
        boolean m1699h() {
            return (!m81d() || this.f1656e == null || this.f1656e.m1702a()) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        /* JADX INFO: renamed from: a */
        public void mo76a(Observer<D> observer) {
            super.mo76a((Observer) observer);
            this.f1655d = null;
            this.f1656e = null;
        }

        /* JADX INFO: renamed from: i */
        void m1700i() {
            if (LoaderManagerImpl.f1648a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f1654c.m1869s();
            this.f1654c.m1872v();
            LoaderObserver<D> loaderObserver = this.f1656e;
            if (loaderObserver != null) {
                mo76a((Observer) loaderObserver);
                loaderObserver.m1703b();
            }
            this.f1654c.m1860a(this);
            this.f1654c.m1874x();
        }

        @Override // android.support.v4.content.Loader.OnLoadCompleteListener
        /* JADX INFO: renamed from: a */
        public void mo1695a(Loader<D> loader, D d) {
            if (LoaderManagerImpl.f1648a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo79b(d);
                return;
            }
            if (LoaderManagerImpl.f1648a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            mo77a(d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1652a);
            sb.append(" : ");
            DebugUtils.m2402a(this.f1654c, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* JADX INFO: renamed from: a */
        public void m1696a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1652a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1653b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1654c);
            this.f1654c.mo1820a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f1656e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f1656e);
                this.f1656e.m1701a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m1697f().m1861c(m74a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(m81d());
        }
    }

    static class LoaderObserver<D> implements Observer<D> {

        /* JADX INFO: renamed from: a */
        private final Loader<D> f1657a;

        /* JADX INFO: renamed from: b */
        private final LoaderManager.LoaderCallbacks<D> f1658b;

        /* JADX INFO: renamed from: c */
        private boolean f1659c = false;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f1657a = loader;
            this.f1658b = loaderCallbacks;
        }

        @Override // android.arch.lifecycle.Observer
        /* JADX INFO: renamed from: a */
        public void mo86a(D d) {
            if (LoaderManagerImpl.f1648a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f1657a + ": " + this.f1657a.m1861c(d));
            }
            this.f1658b.mo1691a(this.f1657a, d);
            this.f1659c = true;
        }

        /* JADX INFO: renamed from: a */
        boolean m1702a() {
            return this.f1659c;
        }

        /* JADX INFO: renamed from: b */
        void m1703b() {
            if (this.f1659c) {
                if (LoaderManagerImpl.f1648a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f1657a);
                }
                this.f1658b.mo1690a(this.f1657a);
            }
        }

        public String toString() {
            return this.f1658b.toString();
        }

        /* JADX INFO: renamed from: a */
        public void m1701a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f1659c);
        }
    }

    static class LoaderViewModel extends ViewModel {

        /* JADX INFO: renamed from: a */
        private static final ViewModelProvider.Factory f1660a = new ViewModelProvider.Factory() { // from class: android.support.v4.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // android.arch.lifecycle.ViewModelProvider.Factory
            /* JADX INFO: renamed from: a */
            public <T extends ViewModel> T mo99a(Class<T> cls) {
                return new LoaderViewModel();
            }
        };

        /* JADX INFO: renamed from: b */
        private SparseArrayCompat<LoaderInfo> f1661b = new SparseArrayCompat<>();

        LoaderViewModel() {
        }

        /* JADX INFO: renamed from: a */
        static LoaderViewModel m1704a(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f1660a).m97a(LoaderViewModel.class);
        }

        /* JADX INFO: renamed from: a */
        void m1706a(int i, LoaderInfo loaderInfo) {
            this.f1661b.m2461b(i, loaderInfo);
        }

        /* JADX INFO: renamed from: a */
        <D> LoaderInfo<D> m1705a(int i) {
            return this.f1661b.m2457a(i);
        }

        /* JADX INFO: renamed from: b */
        void m1708b(int i) {
            this.f1661b.m2463c(i);
        }

        /* JADX INFO: renamed from: b */
        boolean m1709b() {
            int iM2459b = this.f1661b.m2459b();
            for (int i = 0; i < iM2459b; i++) {
                if (this.f1661b.m2466e(i).m1699h()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: c */
        void m1710c() {
            int iM2459b = this.f1661b.m2459b();
            for (int i = 0; i < iM2459b; i++) {
                this.f1661b.m2466e(i).m1698g();
            }
        }

        @Override // android.arch.lifecycle.ViewModel
        /* JADX INFO: renamed from: a */
        protected void mo96a() {
            super.mo96a();
            int iM2459b = this.f1661b.m2459b();
            for (int i = 0; i < iM2459b; i++) {
                this.f1661b.m2466e(i).m1700i();
            }
            this.f1661b.m2462c();
        }

        /* JADX INFO: renamed from: a */
        public void m1707a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1661b.m2459b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.f1661b.m2459b()) {
                        LoaderInfo loaderInfoM2466e = this.f1661b.m2466e(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(this.f1661b.m2465d(i2));
                        printWriter.print(": ");
                        printWriter.println(loaderInfoM2466e.toString());
                        loaderInfoM2466e.m1696a(str2, fileDescriptor, printWriter, strArr);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f1649b = lifecycleOwner;
        this.f1650c = LoaderViewModel.m1704a(viewModelStore);
    }

    /* JADX INFO: renamed from: c */
    private <D> Loader<D> m1692c(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        try {
            this.f1651d = true;
            Loader<D> loaderMo1689a = loaderCallbacks.mo1689a(i, bundle);
            if (loaderMo1689a.getClass().isMemberClass() && !Modifier.isStatic(loaderMo1689a.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + loaderMo1689a);
            }
            LoaderInfo loaderInfo = new LoaderInfo(i, bundle, loaderMo1689a);
            if (f1648a) {
                Log.v("LoaderManager", "  Created new loader " + loaderInfo);
            }
            this.f1650c.m1706a(i, loaderInfo);
            this.f1651d = false;
            return loaderInfo.m1694a(this.f1649b, loaderCallbacks);
        } catch (Throwable th) {
            this.f1651d = false;
            throw th;
        }
    }

    @Override // android.support.v4.app.LoaderManager
    /* JADX INFO: renamed from: a */
    public <D> Loader<D> mo1683a(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f1651d) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        LoaderInfo<D> loaderInfoM1705a = this.f1650c.m1705a(i);
        if (f1648a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfoM1705a == null) {
            return m1692c(i, bundle, loaderCallbacks);
        }
        if (f1648a) {
            Log.v("LoaderManager", "  Re-using existing loader " + loaderInfoM1705a);
        }
        return loaderInfoM1705a.m1694a(this.f1649b, loaderCallbacks);
    }

    @Override // android.support.v4.app.LoaderManager
    /* JADX INFO: renamed from: b */
    public <D> Loader<D> mo1688b(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f1651d) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        if (f1648a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        mo1684a(i);
        return m1692c(i, bundle, loaderCallbacks);
    }

    @Override // android.support.v4.app.LoaderManager
    /* JADX INFO: renamed from: a */
    public void mo1684a(int i) {
        if (this.f1651d) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (f1648a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        LoaderInfo loaderInfoM1705a = this.f1650c.m1705a(i);
        if (loaderInfoM1705a != null) {
            loaderInfoM1705a.m1700i();
            this.f1650c.m1708b(i);
        }
    }

    @Override // android.support.v4.app.LoaderManager
    /* JADX INFO: renamed from: b */
    public <D> Loader<D> mo1687b(int i) {
        if (this.f1651d) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo<D> loaderInfoM1705a = this.f1650c.m1705a(i);
        if (loaderInfoM1705a != null) {
            return loaderInfoM1705a.m1697f();
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    void m1693b() {
        this.f1650c.m1710c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.m2402a(this.f1649b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // android.support.v4.app.LoaderManager
    /* JADX INFO: renamed from: a */
    public void mo1685a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1650c.m1707a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.support.v4.app.LoaderManager
    /* JADX INFO: renamed from: a */
    public boolean mo1686a() {
        return this.f1650c.m1709b();
    }
}
