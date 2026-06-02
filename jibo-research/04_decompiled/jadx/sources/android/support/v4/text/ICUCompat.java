package android.support.v4.text;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {

    /* JADX INFO: renamed from: a */
    private static Method f2166a;

    /* JADX INFO: renamed from: b */
    private static Method f2167b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f2167b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f2166a = cls.getMethod("getScript", String.class);
                f2167b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f2166a = null;
            f2167b = null;
            Log.w("ICUCompat", e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m2363a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f2167b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String strM2364b = m2364b(locale);
        if (strM2364b != null) {
            return m2362a(strM2364b);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static String m2362a(String str) {
        try {
            if (f2166a != null) {
                return (String) f2166a.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private static String m2364b(Locale locale) {
        String string = locale.toString();
        try {
            if (f2167b != null) {
                return (String) f2167b.invoke(null, string);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return string;
    }
}
