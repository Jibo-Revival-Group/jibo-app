package android.support.v4.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

public final class PermissionChecker {
   public static int a(Context var0, String var1) {
      return a(var0, var1, Process.myPid(), Process.myUid(), var0.getPackageName());
   }

   public static int a(Context var0, String var1, int var2, int var3, String var4) {
      byte var5 = -1;
      byte var9;
      if (var0.checkPermission(var1, var2, var3) == -1) {
         var9 = var5;
      } else {
         String var6 = AppOpsManagerCompat.a(var1);
         if (var6 == null) {
            var9 = 0;
         } else {
            var1 = var4;
            if (var4 == null) {
               String[] var8 = var0.getPackageManager().getPackagesForUid(var3);
               var9 = var5;
               if (var8 == null) {
                  return var9;
               }

               var9 = var5;
               if (var8.length <= 0) {
                  return var9;
               }

               var1 = var8[0];
            }

            if (AppOpsManagerCompat.a(var0, var6, var1) != 0) {
               var9 = -2;
            } else {
               var9 = 0;
            }
         }
      }

      return var9;
   }

   public static int b(Context var0, String var1) {
      String var2;
      if (Binder.getCallingPid() == Process.myPid()) {
         var2 = var0.getPackageName();
      } else {
         var2 = null;
      }

      return a(var0, var1, Binder.getCallingPid(), Binder.getCallingUid(), var2);
   }
}
