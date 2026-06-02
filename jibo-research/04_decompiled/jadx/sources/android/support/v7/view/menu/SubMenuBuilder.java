package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* JADX INFO: renamed from: d */
    private MenuBuilder f3458d;

    /* JADX INFO: renamed from: e */
    private MenuItemImpl f3459e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f3458d = menuBuilder;
        this.f3459e = menuItemImpl;
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f3458d.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: b */
    public boolean mo3601b() {
        return this.f3458d.mo3601b();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: c */
    public boolean mo3605c() {
        return this.f3458d.mo3605c();
    }

    /* JADX INFO: renamed from: s */
    public Menu m3682s() {
        return this.f3458d;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f3459e;
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    public void mo3587a(MenuBuilder.Callback callback) {
        this.f3458d.mo3587a(callback);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: p */
    public MenuBuilder mo3623p() {
        return this.f3458d.mo3623p();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    boolean mo3593a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo3593a(menuBuilder, menuItem) || this.f3458d.mo3593a(menuBuilder, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f3459e.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f3459e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m3581a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m3612e(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m3583a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m3608d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m3582a(view);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: c */
    public boolean mo3606c(MenuItemImpl menuItemImpl) {
        return this.f3458d.mo3606c(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: d */
    public boolean mo3610d(MenuItemImpl menuItemImpl) {
        return this.f3458d.mo3610d(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    public String mo3585a() {
        int itemId = this.f3459e != null ? this.f3459e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo3585a() + ":" + itemId;
    }
}
