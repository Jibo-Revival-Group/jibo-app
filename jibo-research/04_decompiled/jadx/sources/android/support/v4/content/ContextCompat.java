package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ContextCompat {

    /* JADX INFO: renamed from: a */
    private static final Object f1779a = new Object();

    /* JADX INFO: renamed from: b */
    private static TypedValue f1780b;

    /* JADX INFO: renamed from: a */
    public static boolean m1834a(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m1833a(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: a */
    public static File[] m1836a(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(str) : new File[]{context.getExternalFilesDir(str)};
    }

    /* JADX INFO: renamed from: a */
    public static File[] m1835a(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    /* JADX INFO: renamed from: a */
    public static Drawable m1832a(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f1779a) {
            if (f1780b == null) {
                f1780b = new TypedValue();
            }
            context.getResources().getValue(i, f1780b, true);
            i2 = f1780b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m1838b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    /* JADX INFO: renamed from: c */
    public static int m1840c(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    /* JADX INFO: renamed from: b */
    public static int m1837b(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1839b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }
}
