package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatResources {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<TypedValue> f3109a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b */
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> f3110b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c */
    private static final Object f3111c = new Object();

    /* JADX INFO: renamed from: a */
    public static ColorStateList m3423a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListM3428d = m3428d(context, i);
        if (colorStateListM3428d == null) {
            ColorStateList colorStateListM3427c = m3427c(context, i);
            if (colorStateListM3427c != null) {
                m3425a(context, i, colorStateListM3427c);
                return colorStateListM3427c;
            }
            return ContextCompat.m1838b(context, i);
        }
        return colorStateListM3428d;
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m3426b(Context context, int i) {
        return AppCompatDrawableManager.m3862a().m3881a(context, i);
    }

    /* JADX INFO: renamed from: c */
    private static ColorStateList m3427c(Context context, int i) {
        if (m3429e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return AppCompatColorStateListInflater.m3419a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private static ColorStateList m3428d(Context context, int i) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (f3111c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = f3110b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.f3113b.equals(context.getResources().getConfiguration())) {
                    return colorStateListCacheEntry.f3112a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3425a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f3111c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = f3110b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f3110b.put(context, sparseArray);
            }
            sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* JADX INFO: renamed from: e */
    private static boolean m3429e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValueM3424a = m3424a();
        resources.getValue(i, typedValueM3424a, true);
        return typedValueM3424a.type >= 28 && typedValueM3424a.type <= 31;
    }

    /* JADX INFO: renamed from: a */
    private static TypedValue m3424a() {
        TypedValue typedValue = f3109a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f3109a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static class ColorStateListCacheEntry {

        /* JADX INFO: renamed from: a */
        final ColorStateList f3112a;

        /* JADX INFO: renamed from: b */
        final Configuration f3113b;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
            this.f3112a = colorStateList;
            this.f3113b = configuration;
        }
    }
}
