package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionMode {

    /* JADX INFO: renamed from: a */
    private Object f3157a;

    /* JADX INFO: renamed from: b */
    private boolean f3158b;

    public interface Callback {
        /* JADX INFO: renamed from: a */
        void mo3329a(ActionMode actionMode);

        /* JADX INFO: renamed from: a */
        boolean mo3330a(ActionMode actionMode, Menu menu);

        /* JADX INFO: renamed from: a */
        boolean mo3331a(ActionMode actionMode, MenuItem menuItem);

        /* JADX INFO: renamed from: b */
        boolean mo3332b(ActionMode actionMode, Menu menu);
    }

    /* JADX INFO: renamed from: a */
    public abstract MenuInflater mo3401a();

    /* JADX INFO: renamed from: a */
    public abstract void mo3402a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo3403a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo3404a(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    public abstract Menu mo3406b();

    /* JADX INFO: renamed from: b */
    public abstract void mo3407b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo3408b(CharSequence charSequence);

    /* JADX INFO: renamed from: c */
    public abstract void mo3409c();

    /* JADX INFO: renamed from: d */
    public abstract void mo3410d();

    /* JADX INFO: renamed from: f */
    public abstract CharSequence mo3412f();

    /* JADX INFO: renamed from: g */
    public abstract CharSequence mo3413g();

    /* JADX INFO: renamed from: i */
    public abstract View mo3415i();

    /* JADX INFO: renamed from: a */
    public void m3470a(Object obj) {
        this.f3157a = obj;
    }

    /* JADX INFO: renamed from: j */
    public Object m3471j() {
        return this.f3157a;
    }

    /* JADX INFO: renamed from: a */
    public void mo3405a(boolean z) {
        this.f3158b = z;
    }

    /* JADX INFO: renamed from: k */
    public boolean m3472k() {
        return this.f3158b;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo3414h() {
        return false;
    }
}
