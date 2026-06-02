package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    Context f3330a;

    /* JADX INFO: renamed from: b */
    LayoutInflater f3331b;

    /* JADX INFO: renamed from: c */
    MenuBuilder f3332c;

    /* JADX INFO: renamed from: d */
    ExpandedMenuView f3333d;

    /* JADX INFO: renamed from: e */
    int f3334e;

    /* JADX INFO: renamed from: f */
    int f3335f;

    /* JADX INFO: renamed from: g */
    int f3336g;

    /* JADX INFO: renamed from: h */
    MenuAdapter f3337h;

    /* JADX INFO: renamed from: i */
    private MenuPresenter.Callback f3338i;

    /* JADX INFO: renamed from: j */
    private int f3339j;

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f3330a = context;
        this.f3331b = LayoutInflater.from(this.f3330a);
    }

    public ListMenuPresenter(int i, int i2) {
        this.f3336g = i;
        this.f3335f = i2;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo346a(Context context, MenuBuilder menuBuilder) {
        if (this.f3335f != 0) {
            this.f3330a = new ContextThemeWrapper(context, this.f3335f);
            this.f3331b = LayoutInflater.from(this.f3330a);
        } else if (this.f3330a != null) {
            this.f3330a = context;
            if (this.f3331b == null) {
                this.f3331b = LayoutInflater.from(this.f3330a);
            }
        }
        this.f3332c = menuBuilder;
        if (this.f3337h != null) {
            this.f3337h.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public MenuView m3559a(ViewGroup viewGroup) {
        if (this.f3333d == null) {
            this.f3333d = (ExpandedMenuView) this.f3331b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f3337h == null) {
                this.f3337h = new MenuAdapter();
            }
            this.f3333d.setAdapter((ListAdapter) this.f3337h);
            this.f3333d.setOnItemClickListener(this);
        }
        return this.f3333d;
    }

    /* JADX INFO: renamed from: d */
    public ListAdapter m3562d() {
        if (this.f3337h == null) {
            this.f3337h = new MenuAdapter();
        }
        return this.f3337h;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        if (this.f3337h != null) {
            this.f3337h.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo350a(MenuPresenter.Callback callback) {
        this.f3338i = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).m3627a((IBinder) null);
        if (this.f3338i != null) {
            this.f3338i.mo3328a(subMenuBuilder);
        }
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
        if (this.f3338i != null) {
            this.f3338i.mo3327a(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f3332c.m3595a(this.f3337h.getItem(i), this, 0);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo352a() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo353a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: b */
    public boolean mo357b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m3560a(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        if (this.f3333d != null) {
            this.f3333d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    /* JADX INFO: renamed from: b */
    public void m3561b(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f3333d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: b */
    public int mo355b() {
        return this.f3339j;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: c */
    public Parcelable mo358c() {
        if (this.f3333d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m3560a(bundle);
        return bundle;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo347a(Parcelable parcelable) {
        m3561b((Bundle) parcelable);
    }

    private class MenuAdapter extends BaseAdapter {

        /* JADX INFO: renamed from: b */
        private int f3341b = -1;

        public MenuAdapter() {
            m3564a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f3332c.m3619l().size() - ListMenuPresenter.this.f3334e;
            return this.f3341b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> arrayListM3619l = ListMenuPresenter.this.f3332c.m3619l();
            int i2 = ListMenuPresenter.this.f3334e + i;
            if (this.f3341b >= 0 && i2 >= this.f3341b) {
                i2++;
            }
            return arrayListM3619l.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = view == null ? ListMenuPresenter.this.f3331b.inflate(ListMenuPresenter.this.f3336g, viewGroup, false) : view;
            ((MenuView.ItemView) viewInflate).mo336a(getItem(i), 0);
            return viewInflate;
        }

        /* JADX INFO: renamed from: a */
        void m3564a() {
            MenuItemImpl menuItemImplM3625r = ListMenuPresenter.this.f3332c.m3625r();
            if (menuItemImplM3625r != null) {
                ArrayList<MenuItemImpl> arrayListM3619l = ListMenuPresenter.this.f3332c.m3619l();
                int size = arrayListM3619l.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListM3619l.get(i) == menuItemImplM3625r) {
                        this.f3341b = i;
                        return;
                    }
                }
            }
            this.f3341b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m3564a();
            super.notifyDataSetChanged();
        }
    }
}
