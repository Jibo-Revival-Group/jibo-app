package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {

    /* JADX INFO: renamed from: a */
    final Context f3272a;

    /* JADX INFO: renamed from: c */
    private Map<SupportMenuItem, MenuItem> f3273c;

    /* JADX INFO: renamed from: d */
    private Map<SupportSubMenu, SubMenu> f3274d;

    BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f3272a = context;
    }

    /* JADX INFO: renamed from: a */
    final MenuItem m3523a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f3273c == null) {
            this.f3273c = new ArrayMap();
        }
        MenuItem menuItem2 = this.f3273c.get(menuItem);
        if (menuItem2 == null) {
            MenuItem menuItemM3676a = MenuWrapperFactory.m3676a(this.f3272a, supportMenuItem);
            this.f3273c.put(supportMenuItem, menuItemM3676a);
            return menuItemM3676a;
        }
        return menuItem2;
    }

    /* JADX INFO: renamed from: a */
    final SubMenu m3524a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f3274d == null) {
            this.f3274d = new ArrayMap();
        }
        SubMenu subMenu2 = this.f3274d.get(supportSubMenu);
        if (subMenu2 == null) {
            SubMenu subMenuM3677a = MenuWrapperFactory.m3677a(this.f3272a, supportSubMenu);
            this.f3274d.put(supportSubMenu, subMenuM3677a);
            return subMenuM3677a;
        }
        return subMenu2;
    }

    /* JADX INFO: renamed from: a */
    final void m3525a() {
        if (this.f3273c != null) {
            this.f3273c.clear();
        }
        if (this.f3274d != null) {
            this.f3274d.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m3526a(int i) {
        if (this.f3273c != null) {
            Iterator<SupportMenuItem> it = this.f3273c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    final void m3527b(int i) {
        if (this.f3273c != null) {
            Iterator<SupportMenuItem> it = this.f3273c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
