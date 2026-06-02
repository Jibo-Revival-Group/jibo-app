package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtilsApi18 extends ViewGroupUtilsApi14 {

    /* JADX INFO: renamed from: a */
    private static Method f1347a;

    /* JADX INFO: renamed from: b */
    private static boolean f1348b;

    ViewGroupUtilsApi18() {
    }

    @Override // android.support.transition.ViewGroupUtilsApi14, android.support.transition.ViewGroupUtilsImpl
    /* JADX INFO: renamed from: a */
    public ViewGroupOverlayImpl mo1286a(ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    @Override // android.support.transition.ViewGroupUtilsApi14, android.support.transition.ViewGroupUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1287a(ViewGroup viewGroup, boolean z) {
        m1288a();
        if (f1347a != null) {
            try {
                f1347a.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1288a() {
        if (!f1348b) {
            try {
                f1347a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
                f1347a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            f1348b = true;
        }
    }
}
