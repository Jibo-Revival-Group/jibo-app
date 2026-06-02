package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class ListViewCompat {
   public static void a(ListView var0, int var1) {
      if (VERSION.SDK_INT >= 19) {
         var0.scrollListBy(var1);
      } else {
         int var2 = var0.getFirstVisiblePosition();
         if (var2 != -1) {
            View var3 = var0.getChildAt(0);
            if (var3 != null) {
               var0.setSelectionFromTop(var2, var3.getTop() - var1);
            }
         }
      }
   }

   public static boolean b(ListView var0, int var1) {
      boolean var5 = false;
      boolean var4;
      if (VERSION.SDK_INT >= 19) {
         var4 = var0.canScrollList(var1);
      } else {
         int var3 = var0.getChildCount();
         var4 = var5;
         if (var3 != 0) {
            int var2 = var0.getFirstVisiblePosition();
            if (var1 > 0) {
               var1 = var0.getChildAt(var3 - 1).getBottom();
               if (var3 + var2 >= var0.getCount()) {
                  var4 = var5;
                  if (var1 <= var0.getHeight() - var0.getListPaddingBottom()) {
                     return var4;
                  }
               }

               var4 = true;
            } else {
               var1 = var0.getChildAt(0).getTop();
               if (var2 <= 0) {
                  var4 = var5;
                  if (var1 >= var0.getListPaddingTop()) {
                     return var4;
                  }
               }

               var4 = true;
            }
         }
      }

      return var4;
   }
}
