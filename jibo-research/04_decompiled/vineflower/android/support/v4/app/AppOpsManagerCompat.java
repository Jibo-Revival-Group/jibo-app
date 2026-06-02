package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class AppOpsManagerCompat {
   public static int a(Context var0, String var1, String var2) {
      int var3;
      if (VERSION.SDK_INT >= 23) {
         var3 = ((AppOpsManager)var0.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(var1, var2);
      } else {
         var3 = 1;
      }

      return var3;
   }

   public static String a(String var0) {
      if (VERSION.SDK_INT >= 23) {
         var0 = AppOpsManager.permissionToOp(var0);
      } else {
         var0 = null;
      }

      return var0;
   }
}
