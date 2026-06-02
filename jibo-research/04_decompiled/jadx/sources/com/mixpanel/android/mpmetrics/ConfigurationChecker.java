package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import com.mixpanel.android.util.MPLog;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
class ConfigurationChecker {

    /* JADX INFO: renamed from: a */
    public static String f11836a = "MixpanelAPI.ConfigurationChecker";

    /* JADX INFO: renamed from: b */
    private static Boolean f11837b;

    /* JADX INFO: renamed from: a */
    public static boolean m11693a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager == null || packageName == null) {
            MPLog.m12028d(f11836a, "Can't check configuration when using a Context with null packageManager or packageName");
            return false;
        }
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
            MPLog.m12028d(f11836a, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
            MPLog.m12026c(f11836a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m11694b(Context context) {
        if (f11837b == null) {
            if (Build.VERSION.SDK_INT < 16) {
                f11837b = false;
                return f11837b.booleanValue();
            }
            Intent intent = new Intent(context, (Class<?>) TakeoverInAppActivity.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(131072);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
                MPLog.m12028d(f11836a, TakeoverInAppActivity.class.getName() + " is not registered as an activity in your application, so takeover in-apps can't be shown.");
                MPLog.m12026c(f11836a, "Please add the child tag <activity android:name=\"com.mixpanel.android.takeoverinapp.TakeoverInAppActivity\" /> to your <application> tag.");
                f11837b = false;
                return f11837b.booleanValue();
            }
            f11837b = true;
        }
        return f11837b.booleanValue();
    }
}
