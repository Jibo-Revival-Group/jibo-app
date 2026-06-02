package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* JADX INFO: renamed from: a */
    private Context f3164a;

    /* JADX INFO: renamed from: b */
    private ActionBarContextView f3165b;

    /* JADX INFO: renamed from: c */
    private ActionMode.Callback f3166c;

    /* JADX INFO: renamed from: d */
    private WeakReference<View> f3167d;

    /* JADX INFO: renamed from: e */
    private boolean f3168e;

    /* JADX INFO: renamed from: f */
    private boolean f3169f;

    /* JADX INFO: renamed from: g */
    private MenuBuilder f3170g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f3164a = context;
        this.f3165b = actionBarContextView;
        this.f3166c = callback;
        this.f3170g = new MenuBuilder(actionBarContextView.getContext()).m3580a(1);
        this.f3170g.mo3587a(this);
        this.f3169f = z;
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: b */
    public void mo3408b(CharSequence charSequence) {
        this.f3165b.setTitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: a */
    public void mo3404a(CharSequence charSequence) {
        this.f3165b.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: a */
    public void mo3402a(int i) {
        mo3408b(this.f3164a.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: b */
    public void mo3407b(int i) {
        mo3404a((CharSequence) this.f3164a.getString(i));
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: a */
    public void mo3405a(boolean z) {
        super.mo3405a(z);
        this.f3165b.setTitleOptional(z);
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: h */
    public boolean mo3414h() {
        return this.f3165b.m3698d();
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: a */
    public void mo3403a(View view) {
        this.f3165b.setCustomView(view);
        this.f3167d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: d */
    public void mo3410d() {
        this.f3166c.mo3332b(this, this.f3170g);
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: c */
    public void mo3409c() {
        if (!this.f3168e) {
            this.f3168e = true;
            this.f3165b.sendAccessibilityEvent(32);
            this.f3166c.mo3329a(this);
        }
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: b */
    public Menu mo3406b() {
        return this.f3170g;
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: f */
    public CharSequence mo3412f() {
        return this.f3165b.getTitle();
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: g */
    public CharSequence mo3413g() {
        return this.f3165b.getSubtitle();
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: i */
    public View mo3415i() {
        if (this.f3167d != null) {
            return this.f3167d.get();
        }
        return null;
    }

    @Override // android.support.v7.view.ActionMode
    /* JADX INFO: renamed from: a */
    public MenuInflater mo3401a() {
        return new SupportMenuInflater(this.f3165b.getContext());
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    /* JADX INFO: renamed from: a */
    public boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f3166c.mo3331a(this, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    /* JADX INFO: renamed from: a */
    public void mo517a(MenuBuilder menuBuilder) {
        mo3410d();
        this.f3165b.mo3690a();
    }
}
