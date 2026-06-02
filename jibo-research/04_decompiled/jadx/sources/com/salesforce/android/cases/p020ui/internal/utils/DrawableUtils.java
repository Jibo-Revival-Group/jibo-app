package com.salesforce.android.cases.p020ui.internal.utils;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public class DrawableUtils {
    /* JADX INFO: renamed from: a */
    public static void m13046a(Menu menu, int i, int... iArr) {
        Drawable icon;
        for (int i2 : iArr) {
            MenuItem menuItemFindItem = menu.findItem(i2);
            if (menuItemFindItem != null && (icon = menuItemFindItem.getIcon()) != null) {
                DrawableCompat.m1987a(DrawableCompat.m2000g(icon).mutate(), i);
            }
        }
    }
}
