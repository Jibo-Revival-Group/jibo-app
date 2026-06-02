package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import com.mixpanel.android.util.MPLog;

class ConfigurationChecker {
   public static String a = "MixpanelAPI.ConfigurationChecker";
   private static Boolean b;

   public static boolean a(Context var0) {
      boolean var1 = false;
      PackageManager var2 = var0.getPackageManager();
      String var3 = var0.getPackageName();
      if (var2 == null || var3 == null) {
         MPLog.d(a, "Can't check configuration when using a Context with null packageManager or packageName");
      } else if (var2.checkPermission("android.permission.INTERNET", var3) != 0) {
         MPLog.d(a, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
         MPLog.c(
            a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />"
         );
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean b(Context var0) {
      if (b == null) {
         if (VERSION.SDK_INT < 16) {
            b = false;
            return b;
         }

         Intent var2 = new Intent(var0, TakeoverInAppActivity.class);
         var2.addFlags(268435456);
         var2.addFlags(131072);
         if (var0.getPackageManager().queryIntentActivities(var2, 0).size() == 0) {
            MPLog.d(a, TakeoverInAppActivity.class.getName() + " is not registered as an activity in your application, so takeover in-apps can't be shown.");
            MPLog.c(
               a, "Please add the child tag <activity android:name=\"com.mixpanel.android.takeoverinapp.TakeoverInAppActivity\" /> to your <application> tag."
            );
            b = false;
            return b;
         }

         b = true;
      }

      return b;
   }
}
