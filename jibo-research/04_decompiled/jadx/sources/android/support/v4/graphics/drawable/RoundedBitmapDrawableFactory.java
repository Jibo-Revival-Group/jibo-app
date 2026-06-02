package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GravityCompat;

/* JADX INFO: loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        /* JADX INFO: renamed from: a */
        void mo2008a(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.m2509a(i, i2, i3, rect, rect2, 0);
        }
    }

    /* JADX INFO: renamed from: a */
    public static RoundedBitmapDrawable m2011a(Resources resources, Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 21 ? new RoundedBitmapDrawable21(resources, bitmap) : new DefaultRoundedBitmapDrawable(resources, bitmap);
    }
}
