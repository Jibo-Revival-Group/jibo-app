package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi19 extends ViewUtilsApi18 {

    /* JADX INFO: renamed from: a */
    private static Method f1362a;

    /* JADX INFO: renamed from: b */
    private static boolean f1363b;

    /* JADX INFO: renamed from: c */
    private static Method f1364c;

    /* JADX INFO: renamed from: d */
    private static boolean f1365d;

    ViewUtilsApi19() {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1314a(View view, float f) {
        m1323a();
        if (f1362a != null) {
            try {
                f1362a.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException e) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: c */
    public float mo1319c(View view) {
        m1324b();
        if (f1364c != null) {
            try {
                return ((Float) f1364c.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.mo1319c(view);
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: d */
    public void mo1321d(View view) {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: e */
    public void mo1322e(View view) {
    }

    /* JADX INFO: renamed from: a */
    private void m1323a() {
        if (!f1363b) {
            try {
                f1362a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
                f1362a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            f1363b = true;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1324b() {
        if (!f1365d) {
            try {
                f1364c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f1364c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            f1365d = true;
        }
    }
}
