package android.support.v4.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {

    /* JADX INFO: renamed from: a */
    static final LayoutInflaterCompatBaseImpl f2286a;

    /* JADX INFO: renamed from: b */
    private static Field f2287b;

    /* JADX INFO: renamed from: c */
    private static boolean f2288c;

    /* JADX INFO: renamed from: a */
    static void m2510a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2288c) {
            try {
                f2287b = LayoutInflater.class.getDeclaredField("mFactory2");
                f2287b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f2288c = true;
        }
        if (f2287b != null) {
            try {
                f2287b.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    static class LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public void mo2512a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                LayoutInflaterCompat.m2510a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                LayoutInflaterCompat.m2510a(layoutInflater, factory2);
            }
        }
    }

    static class LayoutInflaterCompatApi21Impl extends LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatApi21Impl() {
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2512a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f2286a = new LayoutInflaterCompatApi21Impl();
        } else {
            f2286a = new LayoutInflaterCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2511b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        f2286a.mo2512a(layoutInflater, factory2);
    }
}
