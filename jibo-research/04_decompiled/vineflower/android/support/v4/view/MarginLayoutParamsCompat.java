package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class MarginLayoutParamsCompat {
   public static int a(MarginLayoutParams var0) {
      int var1;
      if (VERSION.SDK_INT >= 17) {
         var1 = var0.getMarginStart();
      } else {
         var1 = var0.leftMargin;
      }

      return var1;
   }

   public static int b(MarginLayoutParams var0) {
      int var1;
      if (VERSION.SDK_INT >= 17) {
         var1 = var0.getMarginEnd();
      } else {
         var1 = var0.rightMargin;
      }

      return var1;
   }
}
