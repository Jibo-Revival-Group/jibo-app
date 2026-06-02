package com.salesforce.android.knowledge.p022ui.internal.views;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtil {
    /* JADX INFO: renamed from: a */
    public static <T extends View> T m13714a(View view, int i) {
        return (T) view.findViewById(i);
    }

    /* JADX INFO: renamed from: a */
    public static void m13716a(Toolbar toolbar, int i) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon != null) {
            m13715a(navigationIcon, i);
        }
        Menu menu = toolbar.getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            Drawable icon = menu.getItem(i2).getIcon();
            if (icon != null) {
                m13715a(icon, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m13715a(Drawable drawable, int i) {
        drawable.mutate().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }
}
