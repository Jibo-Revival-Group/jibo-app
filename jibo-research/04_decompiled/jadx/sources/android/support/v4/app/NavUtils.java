package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    /* JADX INFO: renamed from: a */
    public static boolean m1713a(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public static void m1716b(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.content.Intent] */
    /* JADX INFO: renamed from: a */
    public static Intent m1711a(Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT < 16 || (parentActivityIntent = activity.getParentActivityIntent()) == null) {
            String strM1714b = m1714b(activity);
            if (strM1714b == 0) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, (String) strM1714b);
            try {
                if (m1715b(activity, componentName) == null) {
                    strM1714b = Intent.makeMainActivity(componentName);
                } else {
                    strM1714b = new Intent().setComponent(componentName);
                }
                return strM1714b;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strM1714b + "' in manifest");
                return null;
            }
        }
        return parentActivityIntent;
    }

    /* JADX INFO: renamed from: a */
    public static Intent m1712a(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strM1715b = m1715b(context, componentName);
        if (strM1715b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strM1715b);
        if (m1715b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    /* JADX INFO: renamed from: b */
    public static String m1714b(Activity activity) {
        try {
            return m1715b(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m1715b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        String str;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 128);
        if (Build.VERSION.SDK_INT < 16 || (str = activityInfo.parentActivityName) == null) {
            if (activityInfo.metaData != null && (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) != null) {
                if (string.charAt(0) == '.') {
                    return context.getPackageName() + string;
                }
                return string;
            }
            return null;
        }
        return str;
    }
}
