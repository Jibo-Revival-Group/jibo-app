package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* JADX INFO: renamed from: a */
    private static Method f1366a;

    /* JADX INFO: renamed from: b */
    private static boolean f1367b;

    /* JADX INFO: renamed from: c */
    private static Method f1368c;

    /* JADX INFO: renamed from: d */
    private static boolean f1369d;

    /* JADX INFO: renamed from: e */
    private static Method f1370e;

    /* JADX INFO: renamed from: f */
    private static boolean f1371f;

    ViewUtilsApi21() {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1316a(View view, Matrix matrix) {
        m1325a();
        if (f1366a != null) {
            try {
                f1366a.invoke(view, matrix);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: b */
    public void mo1318b(View view, Matrix matrix) {
        m1326b();
        if (f1368c != null) {
            try {
                f1368c.invoke(view, matrix);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: c */
    public void mo1320c(View view, Matrix matrix) {
        m1327c();
        if (f1370e != null) {
            try {
                f1370e.invoke(view, matrix);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getCause());
            } catch (InvocationTargetException e2) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1325a() {
        if (!f1367b) {
            try {
                f1366a = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
                f1366a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
            }
            f1367b = true;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1326b() {
        if (!f1369d) {
            try {
                f1368c = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
                f1368c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
            }
            f1369d = true;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1327c() {
        if (!f1371f) {
            try {
                f1370e = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
                f1370e.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", e);
            }
            f1371f = true;
        }
    }
}
