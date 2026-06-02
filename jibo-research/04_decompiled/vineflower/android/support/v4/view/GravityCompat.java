package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class GravityCompat {
   public static int a(int var0, int var1) {
      if (VERSION.SDK_INT >= 17) {
         var0 = Gravity.getAbsoluteGravity(var0, var1);
      } else {
         var0 = -8388609 & var0;
      }

      return var0;
   }

   public static void a(int var0, int var1, int var2, Rect var3, Rect var4, int var5) {
      if (VERSION.SDK_INT >= 17) {
         Gravity.apply(var0, var1, var2, var3, var4, var5);
      } else {
         Gravity.apply(var0, var1, var2, var3, var4);
      }
   }
}
