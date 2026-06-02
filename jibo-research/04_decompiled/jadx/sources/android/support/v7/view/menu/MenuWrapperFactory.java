package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuWrapperFactory {
    /* JADX INFO: renamed from: a */
    public static Menu m3675a(Context context, SupportMenu supportMenu) {
        return new MenuWrapperICS(context, supportMenu);
    }

    /* JADX INFO: renamed from: a */
    public static MenuItem m3676a(Context context, SupportMenuItem supportMenuItem) {
        return Build.VERSION.SDK_INT >= 16 ? new MenuItemWrapperJB(context, supportMenuItem) : new MenuItemWrapperICS(context, supportMenuItem);
    }

    /* JADX INFO: renamed from: a */
    public static SubMenu m3677a(Context context, SupportSubMenu supportSubMenu) {
        return new SubMenuWrapperICS(context, supportSubMenu);
    }
}
