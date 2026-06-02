package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;

class ThemeUtils {
   private static final int[] a = new int[]{R.attr.colorPrimary};

   static void a(Context var0) {
      boolean var1 = false;
      TypedArray var2 = var0.obtainStyledAttributes(a);
      if (!var2.hasValue(0)) {
         var1 = true;
      }

      var2.recycle();
      if (var1) {
         throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
      }
   }
}
