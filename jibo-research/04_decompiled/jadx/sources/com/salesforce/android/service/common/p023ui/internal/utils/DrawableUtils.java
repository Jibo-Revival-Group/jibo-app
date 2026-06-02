package com.salesforce.android.service.common.p023ui.internal.utils;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class DrawableUtils {
    /* JADX INFO: renamed from: a */
    public static Drawable m14012a(Drawable drawable, int i) {
        drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        return drawable;
    }
}
