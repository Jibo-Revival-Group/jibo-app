package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuPopup implements MenuPresenter, ShowableListMenu, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private Rect f3422a;

    /* JADX INFO: renamed from: a */
    public abstract void mo3538a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo3539a(MenuBuilder menuBuilder);

    /* JADX INFO: renamed from: a */
    public abstract void mo3540a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo3541a(PopupWindow.OnDismissListener onDismissListener);

    /* JADX INFO: renamed from: b */
    public abstract void mo3542b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo3543b(boolean z);

    /* JADX INFO: renamed from: c */
    public abstract void mo3544c(int i);

    /* JADX INFO: renamed from: c */
    public abstract void mo3545c(boolean z);

    MenuPopup() {
    }

    /* JADX INFO: renamed from: a */
    public void m3659a(Rect rect) {
        this.f3422a = rect;
    }

    /* JADX INFO: renamed from: i */
    public Rect m3660i() {
        return this.f3422a;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo346a(Context context, MenuBuilder menuBuilder) {
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

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: b */
    public int mo355b() {
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m3657a(listAdapter).f3343b.m3595a((MenuItem) listAdapter.getItem(i), this, mo3550h() ? 0 : 4);
    }

    /* JADX INFO: renamed from: a */
    protected static int m3656a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            ViewGroup frameLayout = viewGroup2 == null ? new FrameLayout(context) : viewGroup2;
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth < i) {
                if (measuredWidth <= i4) {
                    measuredWidth = i4;
                }
                i2++;
                i4 = measuredWidth;
                viewGroup2 = frameLayout;
            } else {
                return i;
            }
        }
        return i4;
    }

    /* JADX INFO: renamed from: a */
    protected static MenuAdapter m3657a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (MenuAdapter) listAdapter;
    }

    /* JADX INFO: renamed from: b */
    protected static boolean m3658b(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    protected boolean mo3550h() {
        return true;
    }
}
