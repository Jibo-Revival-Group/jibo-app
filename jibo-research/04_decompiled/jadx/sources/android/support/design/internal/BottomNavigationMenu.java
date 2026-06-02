package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public final class BottomNavigationMenu extends MenuBuilder {
    public BottomNavigationMenu(Context context) {
        super(context);
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    protected MenuItem mo338a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        m3614g();
        MenuItem menuItemMo338a = super.mo338a(i, i2, i3, charSequence);
        if (menuItemMo338a instanceof MenuItemImpl) {
            ((MenuItemImpl) menuItemMo338a).m3634a(true);
        }
        m3615h();
        return menuItemMo338a;
    }
}
