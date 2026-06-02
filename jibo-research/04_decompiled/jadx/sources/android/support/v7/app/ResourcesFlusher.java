package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ResourcesFlusher {

    /* JADX INFO: renamed from: a */
    private static Field f3030a;

    /* JADX INFO: renamed from: b */
    private static boolean f3031b;

    /* JADX INFO: renamed from: c */
    private static Class f3032c;

    /* JADX INFO: renamed from: d */
    private static boolean f3033d;

    /* JADX INFO: renamed from: e */
    private static Field f3034e;

    /* JADX INFO: renamed from: f */
    private static boolean f3035f;

    /* JADX INFO: renamed from: g */
    private static Field f3036g;

    /* JADX INFO: renamed from: h */
    private static boolean f3037h;

    /* JADX INFO: renamed from: a */
    static boolean m3366a(Resources resources) {
        if (Build.VERSION.SDK_INT >= 24) {
            return m3370d(resources);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return m3369c(resources);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return m3368b(resources);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m3368b(Resources resources) {
        Map map;
        if (!f3031b) {
            try {
                f3030a = Resources.class.getDeclaredField("mDrawableCache");
                f3030a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f3031b = true;
        }
        if (f3030a != null) {
            try {
                map = (Map) f3030a.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private static boolean m3369c(Resources resources) {
        Object obj;
        if (!f3031b) {
            try {
                f3030a = Resources.class.getDeclaredField("mDrawableCache");
                f3030a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f3031b = true;
        }
        if (f3030a == null) {
            obj = null;
        } else {
            try {
                obj = f3030a.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                obj = null;
            }
        }
        if (obj == null) {
            return false;
        }
        return obj != null && m3367a(obj);
    }

    /* JADX INFO: renamed from: d */
    private static boolean m3370d(Resources resources) throws IllegalAccessException {
        Object obj;
        Object obj2;
        if (!f3037h) {
            try {
                f3036g = Resources.class.getDeclaredField("mResourcesImpl");
                f3036g.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f3037h = true;
        }
        if (f3036g == null) {
            return false;
        }
        try {
            obj = f3036g.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        if (!f3031b) {
            try {
                f3030a = obj.getClass().getDeclaredField("mDrawableCache");
                f3030a.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f3031b = true;
        }
        if (f3030a != null) {
            try {
                obj2 = f3030a.get(obj);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        return obj2 != null && m3367a(obj2);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3367a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f3033d) {
            try {
                f3032c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f3033d = true;
        }
        if (f3032c == null) {
            return false;
        }
        if (!f3035f) {
            try {
                f3034e = f3032c.getDeclaredField("mUnthemedEntries");
                f3034e.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f3035f = true;
        }
        if (f3034e == null) {
            return false;
        }
        try {
            longSparseArray = (LongSparseArray) f3034e.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }
}
