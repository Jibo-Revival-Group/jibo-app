package com.yalantis.ucrop.util;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class RectUtils {
    public static float[] getCornersFromRect(RectF rectF) {
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
    }

    public static float[] getRectSidesFromCorners(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow(fArr[0] - fArr[2], 2.0d) + Math.pow(fArr[1] - fArr[3], 2.0d)), (float) Math.sqrt(Math.pow(fArr[2] - fArr[4], 2.0d) + Math.pow(fArr[3] - fArr[5], 2.0d))};
    }

    public static float[] getCenterFromRect(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static RectF trapToRect(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float f = fArr[i - 1];
            float f2 = fArr[i];
            rectF.left = f < rectF.left ? f : rectF.left;
            rectF.top = f2 < rectF.top ? f2 : rectF.top;
            if (f <= rectF.right) {
                f = rectF.right;
            }
            rectF.right = f;
            if (f2 <= rectF.bottom) {
                f2 = rectF.bottom;
            }
            rectF.bottom = f2;
        }
        rectF.sort();
        return rectF;
    }
}
