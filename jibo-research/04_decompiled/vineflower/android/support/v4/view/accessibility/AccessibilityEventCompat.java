package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat {
   public static int a(AccessibilityEvent var0) {
      int var1;
      if (VERSION.SDK_INT >= 19) {
         var1 = var0.getContentChangeTypes();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public static void a(AccessibilityEvent var0, int var1) {
      if (VERSION.SDK_INT >= 19) {
         var0.setContentChangeTypes(var1);
      }
   }
}
