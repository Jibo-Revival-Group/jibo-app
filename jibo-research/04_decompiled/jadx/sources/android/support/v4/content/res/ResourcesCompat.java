package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat {
    /* JADX INFO: renamed from: a */
    public static Drawable m1919a(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static abstract class FontCallback {
        /* JADX INFO: renamed from: a */
        public abstract void mo1920a(int i);

        /* JADX INFO: renamed from: a */
        public abstract void mo1922a(Typeface typeface);

        /* JADX INFO: renamed from: a */
        public final void m1923a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.content.res.ResourcesCompat.FontCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.mo1922a(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public final void m1921a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.content.res.ResourcesCompat.FontCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.mo1920a(i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m1916a(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m1917a(context, i, typedValue, i2, fontCallback, null, true);
    }

    /* JADX INFO: renamed from: a */
    private static Typeface m1917a(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceM1918a = m1918a(context, resources, typedValue, i, i2, fontCallback, handler, z);
        if (typefaceM1918a == null && fontCallback == null) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return typefaceM1918a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface m1918a(android.content.Context r9, android.content.res.Resources r10, android.util.TypedValue r11, int r12, int r13, android.support.v4.content.res.ResourcesCompat.FontCallback r14, android.os.Handler r15, boolean r16) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.res.ResourcesCompat.m1918a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
