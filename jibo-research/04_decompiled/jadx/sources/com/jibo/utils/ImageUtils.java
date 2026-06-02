package com.jibo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuItem;
import com.jibo.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ImageUtils {
    /* JADX INFO: renamed from: a */
    private static int m11388a(BitmapFactory.Options options, int i, int i2) {
        if (options.outWidth <= i && options.outHeight <= i2) {
            return 1;
        }
        return (int) Math.max(Math.round(((double) options.outWidth) / ((double) i)), Math.round(((double) options.outHeight) / ((double) i2)));
    }

    /* JADX INFO: renamed from: a */
    public static Bitmap m11390a(String str, int i, int i2) throws FileNotFoundException {
        if (!new File(str).exists()) {
            throw new FileNotFoundException();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = m11388a(options, i, i2);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX INFO: renamed from: a */
    public static void m11397a(String str, InputStream inputStream) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (inputStream != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[102400];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            }
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11396a(File file, File file2) {
        try {
            if (file2.exists()) {
                file2.delete();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            }
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static Bitmap m11389a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int i = iMin / 2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect((bitmap.getWidth() / 2) - i, (bitmap.getHeight() / 2) - i, (bitmap.getWidth() / 2) + i, (bitmap.getHeight() / 2) + i);
        Rect rect2 = new Rect(0, 0, iMin, iMin);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(i, i, i, paint);
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a */
    public static void m11395a(Fragment fragment, int i, Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.addFlags(3);
        if (uri != null) {
            intent.putExtra("output", uri);
            intent.putExtra("android.intent.extra.videoQuality", 1);
        }
        fragment.startActivityForResult(intent, i);
    }

    /* JADX INFO: renamed from: b */
    public static void m11401b(Fragment fragment, int i, Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.addFlags(3);
        if (uri != null) {
            intent.putExtra("output", uri);
            intent.putExtra("android.intent.extra.videoQuality", 1);
        }
        if (fragment.getParentFragment() == null) {
            fragment.startActivityForResult(intent, i);
        } else {
            fragment.getParentFragment().startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Drawable m11391a(Context context, int i) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable = context.getResources().getDrawable(i, context.getTheme());
        } else {
            drawable = context.getResources().getDrawable(i);
        }
        return DrawableCompat.m2000g(drawable);
    }

    /* JADX INFO: renamed from: b */
    public static int m11399b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColor(i, context.getTheme());
        }
        return context.getResources().getColor(i);
    }

    /* JADX INFO: renamed from: c */
    public static ColorStateList m11402c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColorStateList(i, context.getTheme());
        }
        return context.getResources().getColorStateList(i);
    }

    /* JADX INFO: renamed from: a */
    public static Drawable m11392a(Context context, int i, int i2) {
        int iM11399b = m11399b(context, i2);
        Drawable drawableM11391a = m11391a(context, i);
        DrawableCompat.m1987a(drawableM11391a, iM11399b);
        return drawableM11391a;
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m11400b(Context context, int i, int i2) {
        ColorStateList colorStateListM11402c = m11402c(context, i2);
        Drawable drawableM11391a = m11391a(context, i);
        DrawableCompat.m1989a(drawableM11391a, colorStateListM11402c);
        return drawableM11391a;
    }

    /* JADX INFO: renamed from: a */
    public static void m11394a(Context context, MenuItem menuItem, int i) {
        Drawable icon;
        if (menuItem != null && (icon = menuItem.getIcon()) != null) {
            Drawable drawableM2000g = DrawableCompat.m2000g(icon);
            DrawableCompat.m1987a(drawableM2000g, m11399b(context, i));
            menuItem.setIcon(drawableM2000g);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11393a(Context context, Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            m11394a(context, menu.getItem(i), R.color.white);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11398a(String str, String str2, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        float f = i / i2;
        int iMin = Math.min(options.outHeight, (int) (Math.min(i, options.outWidth) / f));
        Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(str), (int) (f * iMin), iMin);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
        bitmapExtractThumbnail.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
        fileOutputStream.close();
    }
}
