package android.support.v4.widget;

import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class PopupWindowCompat {

    /* JADX INFO: renamed from: a */
    static final PopupWindowCompatBaseImpl f2673a;

    static class PopupWindowCompatBaseImpl {

        /* JADX INFO: renamed from: a */
        private static Method f2675a;

        /* JADX INFO: renamed from: b */
        private static boolean f2676b;

        PopupWindowCompatBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public void mo3063a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((GravityCompat.m2508a(i3, ViewCompat.m2601e(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void mo3064a(PopupWindow popupWindow, boolean z) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3065a(PopupWindow popupWindow, int i) {
            if (!f2676b) {
                try {
                    f2675a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    f2675a.setAccessible(true);
                } catch (Exception e) {
                }
                f2676b = true;
            }
            if (f2675a != null) {
                try {
                    f2675a.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception e2) {
                }
            }
        }
    }

    static class PopupWindowCompatApi19Impl extends PopupWindowCompatBaseImpl {
        PopupWindowCompatApi19Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3063a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    static class PopupWindowCompatApi21Impl extends PopupWindowCompatApi19Impl {

        /* JADX INFO: renamed from: a */
        private static Field f2674a;

        PopupWindowCompatApi21Impl() {
        }

        static {
            try {
                f2674a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f2674a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3064a(PopupWindow popupWindow, boolean z) {
            if (f2674a != null) {
                try {
                    f2674a.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    static class PopupWindowCompatApi23Impl extends PopupWindowCompatApi21Impl {
        PopupWindowCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl, android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3064a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3065a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f2673a = new PopupWindowCompatApi23Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            f2673a = new PopupWindowCompatApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f2673a = new PopupWindowCompatApi19Impl();
        } else {
            f2673a = new PopupWindowCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3061a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f2673a.mo3063a(popupWindow, view, i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m3062a(PopupWindow popupWindow, boolean z) {
        f2673a.mo3064a(popupWindow, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m3060a(PopupWindow popupWindow, int i) {
        f2673a.mo3065a(popupWindow, i);
    }
}
