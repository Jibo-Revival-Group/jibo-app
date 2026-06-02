package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;

public final class NavUtils {
   public static Intent a(Activity var0) {
      if (VERSION.SDK_INT >= 16) {
         Intent var1 = var0.getParentActivityIntent();
         if (var1 != null) {
            Intent var7 = var1;
            return var7;
         }
      }

      String var6 = b(var0);
      Intent var4;
      if (var6 == null) {
         var4 = null;
      } else {
         ComponentName var2 = new ComponentName(var0, var6);

         try {
            if (b(var0, var2) == null) {
               var4 = Intent.makeMainActivity(var2);
            } else {
               Intent var5 = new Intent();
               var4 = var5.setComponent(var2);
            }
         } catch (NameNotFoundException var3) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + var6 + "' in manifest");
            var4 = null;
         }
      }

      return var4;
   }

   public static Intent a(Context var0, ComponentName var1) throws NameNotFoundException {
      String var2 = b(var0, var1);
      Intent var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var1 = new ComponentName(var1.getPackageName(), var2);
         if (b(var0, var1) == null) {
            var3 = Intent.makeMainActivity(var1);
         } else {
            var3 = new Intent().setComponent(var1);
         }
      }

      return var3;
   }

   public static boolean a(Activity var0, Intent var1) {
      boolean var2;
      if (VERSION.SDK_INT >= 16) {
         var2 = var0.shouldUpRecreateTask(var1);
      } else {
         String var3 = var0.getIntent().getAction();
         if (var3 != null && !var3.equals("android.intent.action.MAIN")) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public static String b(Activity var0) {
      try {
         return b(var0, var0.getComponentName());
      } catch (NameNotFoundException var1) {
         throw new IllegalArgumentException(var1);
      }
   }

   public static String b(Context var0, ComponentName var1) throws NameNotFoundException {
      ActivityInfo var2 = var0.getPackageManager().getActivityInfo(var1, 128);
      if (VERSION.SDK_INT >= 16) {
         String var3 = var2.parentActivityName;
         if (var3 != null) {
            return var3;
         }
      }

      String var5;
      if (var2.metaData == null) {
         var5 = null;
      } else {
         String var4 = var2.metaData.getString("android.support.PARENT_ACTIVITY");
         if (var4 == null) {
            var5 = null;
         } else {
            var5 = var4;
            if (var4.charAt(0) == '.') {
               var5 = var0.getPackageName() + var4;
            }
         }
      }

      return var5;
   }

   public static void b(Activity var0, Intent var1) {
      if (VERSION.SDK_INT >= 16) {
         var0.navigateUpTo(var1);
      } else {
         var1.addFlags(67108864);
         var0.startActivity(var1);
         var0.finish();
      }
   }
}
