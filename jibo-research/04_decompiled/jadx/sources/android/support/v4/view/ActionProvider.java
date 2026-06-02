package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionProvider {

    /* JADX INFO: renamed from: a */
    private final Context f2256a;

    /* JADX INFO: renamed from: b */
    private SubUiVisibilityListener f2257b;

    /* JADX INFO: renamed from: c */
    private VisibilityListener f2258c;

    public interface SubUiVisibilityListener {
        /* JADX INFO: renamed from: b */
        void mo2498b(boolean z);
    }

    public interface VisibilityListener {
        /* JADX INFO: renamed from: a */
        void mo2499a(boolean z);
    }

    /* JADX INFO: renamed from: a */
    public abstract View mo2487a();

    public ActionProvider(Context context) {
        this.f2256a = context;
    }

    /* JADX INFO: renamed from: a */
    public View mo2488a(MenuItem menuItem) {
        return mo2487a();
    }

    /* JADX INFO: renamed from: b */
    public boolean mo2493b() {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo2494c() {
        return true;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo2495d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo2496e() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void mo2491a(SubMenu subMenu) {
    }

    /* JADX INFO: renamed from: a */
    public void m2492a(boolean z) {
        if (this.f2257b != null) {
            this.f2257b.mo2498b(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2489a(SubUiVisibilityListener subUiVisibilityListener) {
        this.f2257b = subUiVisibilityListener;
    }

    /* JADX INFO: renamed from: a */
    public void mo2490a(VisibilityListener visibilityListener) {
        if (this.f2258c != null && visibilityListener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2258c = visibilityListener;
    }

    /* JADX INFO: renamed from: f */
    public void m2497f() {
        this.f2258c = null;
        this.f2257b = null;
    }
}
