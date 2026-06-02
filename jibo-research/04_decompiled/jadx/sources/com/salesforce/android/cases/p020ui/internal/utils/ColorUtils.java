package com.salesforce.android.cases.p020ui.internal.utils;

import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public class ColorUtils {
    /* JADX INFO: renamed from: a */
    public static int m13045a(int i, float f) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() == 8) {
            hexString = hexString.substring(2, 8);
        }
        if (hexString.length() >= 6) {
            return Color.rgb((int) (((Integer.parseInt(hexString.substring(0, 2), 16) * (1.0f - f)) / 255.0f) * 255.0f), (int) (((Integer.parseInt(hexString.substring(2, 4), 16) * (1.0f - f)) / 255.0f) * 255.0f), (int) (((Integer.parseInt(hexString.substring(4, 6), 16) * (1.0f - f)) / 255.0f) * 255.0f));
        }
        return i;
    }
}
