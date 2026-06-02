package android.support.transition;

import android.graphics.Matrix;
import android.support.transition.GhostViewImpl;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class GhostViewApi21 implements GhostViewImpl {

    /* JADX INFO: renamed from: a */
    private static Class<?> f1211a;

    /* JADX INFO: renamed from: b */
    private static boolean f1212b;

    /* JADX INFO: renamed from: c */
    private static Method f1213c;

    /* JADX INFO: renamed from: d */
    private static boolean f1214d;

    /* JADX INFO: renamed from: e */
    private static Method f1215e;

    /* JADX INFO: renamed from: f */
    private static boolean f1216f;

    /* JADX INFO: renamed from: g */
    private final View f1217g;

    static class Creator implements GhostViewImpl.Creator {
        Creator() {
        }

        @Override // android.support.transition.GhostViewImpl.Creator
        /* JADX INFO: renamed from: a */
        public GhostViewImpl mo1159a(View view, ViewGroup viewGroup, Matrix matrix) {
            GhostViewApi21.m1166f();
            if (GhostViewApi21.f1213c != null) {
                try {
                    return new GhostViewApi21((View) GhostViewApi21.f1213c.invoke(null, view, viewGroup, matrix));
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
            return null;
        }

        @Override // android.support.transition.GhostViewImpl.Creator
        /* JADX INFO: renamed from: a */
        public void mo1160a(View view) {
            GhostViewApi21.m1167g();
            if (GhostViewApi21.f1215e != null) {
                try {
                    GhostViewApi21.f1215e.invoke(null, view);
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }
    }

    private GhostViewApi21(View view) {
        this.f1217g = view;
    }

    @Override // android.support.transition.GhostViewImpl
    public void setVisibility(int i) {
        this.f1217g.setVisibility(i);
    }

    @Override // android.support.transition.GhostViewImpl
    /* JADX INFO: renamed from: a */
    public void mo1157a(ViewGroup viewGroup, View view) {
    }

    /* JADX INFO: renamed from: e */
    private static void m1165e() {
        if (!f1212b) {
            try {
                f1211a = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e);
            }
            f1212b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public static void m1166f() {
        if (!f1214d) {
            try {
                m1165e();
                f1213c = f1211a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                f1213c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e);
            }
            f1214d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public static void m1167g() {
        if (!f1216f) {
            try {
                m1165e();
                f1215e = f1211a.getDeclaredMethod("removeGhost", View.class);
                f1215e.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
            }
            f1216f = true;
        }
    }
}
