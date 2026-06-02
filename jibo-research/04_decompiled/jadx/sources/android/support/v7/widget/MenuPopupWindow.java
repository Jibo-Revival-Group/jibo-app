package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {

    /* JADX INFO: renamed from: a */
    private static Method f4045a;

    /* JADX INFO: renamed from: b */
    private MenuItemHoverListener f4046b;

    static {
        try {
            f4045a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.ListPopupWindow
    /* JADX INFO: renamed from: a */
    DropDownListView mo4362a(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    /* JADX INFO: renamed from: a */
    public void m4388a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f4019g.setEnterTransition((Transition) obj);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4389b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f4019g.setExitTransition((Transition) obj);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4387a(MenuItemHoverListener menuItemHoverListener) {
        this.f4046b = menuItemHoverListener;
    }

    /* JADX INFO: renamed from: c */
    public void m4390c(boolean z) {
        if (f4045a != null) {
            try {
                f4045a.invoke(this.f4019g, Boolean.valueOf(z));
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // android.support.v7.widget.MenuItemHoverListener
    /* JADX INFO: renamed from: b */
    public void mo3552b(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f4046b != null) {
            this.f4046b.mo3552b(menuBuilder, menuItem);
        }
    }

    @Override // android.support.v7.widget.MenuItemHoverListener
    /* JADX INFO: renamed from: a */
    public void mo3551a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f4046b != null) {
            this.f4046b.mo3551a(menuBuilder, menuItem);
        }
    }

    public static class MenuDropDownListView extends DropDownListView {

        /* JADX INFO: renamed from: a */
        final int f4047a;

        /* JADX INFO: renamed from: b */
        final int f4048b;

        /* JADX INFO: renamed from: c */
        private MenuItemHoverListener f4049c;

        /* JADX INFO: renamed from: d */
        private MenuItem f4050d;

        @Override // android.support.v7.widget.DropDownListView
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ int mo4129a(int i, int i2, int i3, int i4, int i5) {
            return super.mo4129a(i, i2, i3, i4, i5);
        }

        @Override // android.support.v7.widget.DropDownListView
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo4130a(MotionEvent motionEvent, int i) {
            return super.mo4130a(motionEvent, i);
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.support.v7.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f4047a = 21;
                this.f4048b = 22;
            } else {
                this.f4047a = 22;
                this.f4048b = 21;
            }
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.f4049c = menuItemHoverListener;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f4047a) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.f4048b) {
                setSelection(-1);
                ((MenuAdapter) getAdapter()).m3565a().m3600b(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // android.support.v7.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            MenuAdapter menuAdapter;
            MenuItemImpl item;
            int iPointToPosition;
            int i;
            if (this.f4049c != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                if (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= menuAdapter.getCount()) {
                    item = null;
                } else {
                    item = menuAdapter.getItem(i);
                }
                MenuItem menuItem = this.f4050d;
                if (menuItem != item) {
                    MenuBuilder menuBuilderM3565a = menuAdapter.m3565a();
                    if (menuItem != null) {
                        this.f4049c.mo3551a(menuBuilderM3565a, menuItem);
                    }
                    this.f4050d = item;
                    if (item != null) {
                        this.f4049c.mo3552b(menuBuilderM3565a, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
