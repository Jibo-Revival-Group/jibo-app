package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    static class BundleCompatBaseImpl {

        /* JADX INFO: renamed from: a */
        private static Method f1440a;

        /* JADX INFO: renamed from: b */
        private static boolean f1441b;

        /* JADX INFO: renamed from: c */
        private static Method f1442c;

        /* JADX INFO: renamed from: d */
        private static boolean f1443d;

        /* JADX INFO: renamed from: a */
        public static IBinder m1398a(Bundle bundle, String str) {
            if (!f1441b) {
                try {
                    f1440a = Bundle.class.getMethod("getIBinder", String.class);
                    f1440a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f1441b = true;
            }
            if (f1440a != null) {
                try {
                    return (IBinder) f1440a.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f1440a = null;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        public static void m1399a(Bundle bundle, String str, IBinder iBinder) {
            if (!f1443d) {
                try {
                    f1442c = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f1442c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                f1443d = true;
            }
            if (f1442c != null) {
                try {
                    f1442c.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    f1442c = null;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static IBinder m1396a(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : BundleCompatBaseImpl.m1398a(bundle, str);
    }

    /* JADX INFO: renamed from: a */
    public static void m1397a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            BundleCompatBaseImpl.m1399a(bundle, str, iBinder);
        }
    }
}
