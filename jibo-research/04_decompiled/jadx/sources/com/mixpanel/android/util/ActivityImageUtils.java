package com.mixpanel.android.util;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ActivityImageUtils {
    /* JADX INFO: renamed from: a */
    public static Bitmap m11998a(Activity activity, int i, int i2, boolean z) {
        View rootView = activity.findViewById(R.id.content).getRootView();
        boolean zIsDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        Bitmap bitmapCreateScaledBitmap = null;
        if (drawingCache != null && drawingCache.getWidth() > 0 && drawingCache.getHeight() > 0) {
            if (z) {
                i = drawingCache.getWidth() / i;
                i2 = drawingCache.getHeight() / i2;
            }
            if (i > 0 && i2 > 0) {
                try {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(drawingCache, i, i2, false);
                } catch (OutOfMemoryError e) {
                    MPLog.m12026c("MixpanelAPI.ActImgUtils", "Not enough memory to produce scaled image, returning a null screenshot");
                }
            }
        }
        if (!zIsDrawingCacheEnabled) {
            rootView.setDrawingCacheEnabled(false);
        }
        return bitmapCreateScaledBitmap;
    }

    /* JADX INFO: renamed from: a */
    public static int m11997a(Activity activity) {
        int pixel = -16777216;
        Bitmap bitmapM11998a = m11998a(activity, 1, 1, false);
        if (bitmapM11998a != null) {
            pixel = bitmapM11998a.getPixel(0, 0);
        }
        return m11996a(pixel);
    }

    /* JADX INFO: renamed from: a */
    public static int m11996a(int i) {
        float[] fArr = {0.0f, 0.0f, 0.3f};
        Color.colorToHSV(i, fArr);
        return Color.HSVToColor(242, fArr);
    }
}
