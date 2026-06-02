package android.support.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* JADX INFO: renamed from: a */
    private static Method f1372a;

    /* JADX INFO: renamed from: b */
    private static boolean f1373b;

    ViewUtilsApi22() {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1315a(View view, int i, int i2, int i3, int i4) {
        m1328a();
        if (f1372a != null) {
            try {
                f1372a.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* JADX INFO: renamed from: a */
    private void m1328a() {
        if (!f1373b) {
            try {
                f1372a = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                f1372a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
            }
            f1373b = true;
        }
    }
}
