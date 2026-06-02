package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ViewUtils {

    /* JADX INFO: renamed from: a */
    static final Property<View, Float> f1356a;

    /* JADX INFO: renamed from: b */
    static final Property<View, Rect> f1357b;

    /* JADX INFO: renamed from: c */
    private static final ViewUtilsImpl f1358c;

    /* JADX INFO: renamed from: d */
    private static Field f1359d;

    /* JADX INFO: renamed from: e */
    private static boolean f1360e;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f1358c = new ViewUtilsApi22();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1358c = new ViewUtilsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f1358c = new ViewUtilsApi19();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f1358c = new ViewUtilsApi18();
        } else {
            f1358c = new ViewUtilsApi14();
        }
        f1356a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: android.support.transition.ViewUtils.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ViewUtils.m1305c(view));
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f) {
                ViewUtils.m1299a(view, f.floatValue());
            }
        };
        f1357b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: android.support.transition.ViewUtils.2
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return ViewCompat.m2569A(view);
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                ViewCompat.m2581a(view, rect);
            }
        };
    }

    /* JADX INFO: renamed from: a */
    static ViewOverlayImpl m1297a(View view) {
        return f1358c.mo1313a(view);
    }

    /* JADX INFO: renamed from: b */
    static WindowIdImpl m1303b(View view) {
        return f1358c.mo1317b(view);
    }

    /* JADX INFO: renamed from: a */
    static void m1299a(View view, float f) {
        f1358c.mo1314a(view, f);
    }

    /* JADX INFO: renamed from: c */
    static float m1305c(View view) {
        return f1358c.mo1319c(view);
    }

    /* JADX INFO: renamed from: d */
    static void m1307d(View view) {
        f1358c.mo1321d(view);
    }

    /* JADX INFO: renamed from: e */
    static void m1308e(View view) {
        f1358c.mo1322e(view);
    }

    /* JADX INFO: renamed from: a */
    static void m1300a(View view, int i) {
        m1298a();
        if (f1359d != null) {
            try {
                f1359d.setInt(view, (f1359d.getInt(view) & (-13)) | i);
            } catch (IllegalAccessException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m1302a(View view, Matrix matrix) {
        f1358c.mo1316a(view, matrix);
    }

    /* JADX INFO: renamed from: b */
    static void m1304b(View view, Matrix matrix) {
        f1358c.mo1318b(view, matrix);
    }

    /* JADX INFO: renamed from: c */
    static void m1306c(View view, Matrix matrix) {
        f1358c.mo1320c(view, matrix);
    }

    /* JADX INFO: renamed from: a */
    static void m1301a(View view, int i, int i2, int i3, int i4) {
        f1358c.mo1315a(view, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    private static void m1298a() {
        if (!f1360e) {
            try {
                f1359d = View.class.getDeclaredField("mViewFlags");
                f1359d.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f1360e = true;
        }
    }
}
