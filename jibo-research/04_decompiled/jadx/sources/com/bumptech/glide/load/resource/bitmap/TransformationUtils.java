package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class TransformationUtils {
    /* JADX INFO: renamed from: a */
    public static Bitmap m5435a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float width;
        float width2;
        float height = CropImageView.DEFAULT_ASPECT_RATIO;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() != i || bitmap2.getHeight() != i2) {
            Matrix matrix = new Matrix();
            if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
                width = i2 / bitmap2.getHeight();
                width2 = (i - (bitmap2.getWidth() * width)) * 0.5f;
            } else {
                width = i / bitmap2.getWidth();
                width2 = 0.0f;
                height = (i2 - (bitmap2.getHeight() * width)) * 0.5f;
            }
            matrix.setScale(width, width);
            matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(i, i2, m5434a(bitmap2));
            }
            m5439a(bitmap2, bitmap);
            new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
            return bitmap;
        }
        return bitmap2;
    }

    /* JADX INFO: renamed from: a */
    public static Bitmap m5437a(Bitmap bitmap, BitmapPool bitmapPool, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
                return bitmap;
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * fMin);
        int height = (int) (bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                return bitmap;
            }
            return bitmap;
        }
        Bitmap.Config configM5434a = m5434a(bitmap);
        Bitmap bitmapCreateBitmap = bitmapPool.get(width, height, configM5434a);
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, configM5434a);
        }
        m5439a(bitmap, bitmapCreateBitmap);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapCreateBitmap.getWidth() + "x" + bitmapCreateBitmap.getHeight());
            Log.v("TransformationUtils", "minPct:   " + fMin);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapCreateBitmap;
    }

    @TargetApi(12)
    /* JADX INFO: renamed from: a */
    public static void m5439a(Bitmap bitmap, Bitmap bitmap2) {
        if (Build.VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m5433a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Bitmap m5436a(Bitmap bitmap, BitmapPool bitmapPool, int i) {
        Matrix matrix = new Matrix();
        m5438a(i, matrix);
        if (!matrix.isIdentity()) {
            RectF rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            int iRound = Math.round(rectF.width());
            int iRound2 = Math.round(rectF.height());
            Bitmap.Config configM5434a = m5434a(bitmap);
            Bitmap bitmapCreateBitmap = bitmapPool.get(iRound, iRound2, configM5434a);
            if (bitmapCreateBitmap == null) {
                bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, configM5434a);
            }
            matrix.postTranslate(-rectF.left, -rectF.top);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(6));
            return bitmapCreateBitmap;
        }
        return bitmap;
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap.Config m5434a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    /* JADX INFO: renamed from: a */
    static void m5438a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }
}
