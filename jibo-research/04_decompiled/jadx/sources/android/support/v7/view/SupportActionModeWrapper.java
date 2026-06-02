package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* JADX INFO: renamed from: a */
    final Context f3171a;

    /* JADX INFO: renamed from: b */
    final ActionMode f3172b;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f3171a = context;
        this.f3172b = actionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f3172b.m3471j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f3172b.m3470a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f3172b.mo3408b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f3172b.mo3404a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f3172b.mo3410d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f3172b.mo3409c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.m3675a(this.f3171a, (SupportMenu) this.f3172b.mo3406b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f3172b.mo3412f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f3172b.mo3402a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f3172b.mo3413g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f3172b.mo3407b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f3172b.mo3415i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f3172b.mo3403a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f3172b.mo3401a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f3172b.m3472k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f3172b.mo3405a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f3172b.mo3414h();
    }

    public static class CallbackWrapper implements ActionMode.Callback {

        /* JADX INFO: renamed from: a */
        final ActionMode.Callback f3173a;

        /* JADX INFO: renamed from: b */
        final Context f3174b;

        /* JADX INFO: renamed from: c */
        final ArrayList<SupportActionModeWrapper> f3175c = new ArrayList<>();

        /* JADX INFO: renamed from: d */
        final SimpleArrayMap<Menu, Menu> f3176d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f3174b = context;
            this.f3173a = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3330a(ActionMode actionMode, Menu menu) {
            return this.f3173a.onCreateActionMode(m3480b(actionMode), m3479a(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: b */
        public boolean mo3332b(ActionMode actionMode, Menu menu) {
            return this.f3173a.onPrepareActionMode(m3480b(actionMode), m3479a(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3331a(ActionMode actionMode, MenuItem menuItem) {
            return this.f3173a.onActionItemClicked(m3480b(actionMode), MenuWrapperFactory.m3676a(this.f3174b, (SupportMenuItem) menuItem));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public void mo3329a(ActionMode actionMode) {
            this.f3173a.onDestroyActionMode(m3480b(actionMode));
        }

        /* JADX INFO: renamed from: a */
        private Menu m3479a(Menu menu) {
            Menu menu2 = this.f3176d.get(menu);
            if (menu2 == null) {
                Menu menuM3675a = MenuWrapperFactory.m3675a(this.f3174b, (SupportMenu) menu);
                this.f3176d.put(menu, menuM3675a);
                return menuM3675a;
            }
            return menu2;
        }

        /* JADX INFO: renamed from: b */
        public android.view.ActionMode m3480b(ActionMode actionMode) {
            int size = this.f3175c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f3175c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f3172b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f3174b, actionMode);
            this.f3175c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }
}
