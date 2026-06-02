package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {
    /* JADX INFO: renamed from: a */
    public static float m12036a(float f, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }

    /* JADX INFO: renamed from: a */
    public static int m12037a(int i, int i2) {
        return Color.rgb((Color.red(i) / 2) + (Color.red(i2) / 2), (Color.green(i) / 2) + (Color.green(i2) / 2), (Color.blue(i) / 2) + (Color.blue(i2) / 2));
    }
}
