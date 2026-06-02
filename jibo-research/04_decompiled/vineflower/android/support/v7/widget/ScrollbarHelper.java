package android.support.v7.widget;

import android.view.View;

class ScrollbarHelper {
   static int a(RecyclerView.State var0, OrientationHelper var1, View var2, View var3, RecyclerView.LayoutManager var4, boolean var5) {
      int var6;
      if (var4.v() == 0 || var0.e() == 0 || var2 == null || var3 == null) {
         var6 = 0;
      } else if (!var5) {
         var6 = Math.abs(var4.d(var2) - var4.d(var3)) + 1;
      } else {
         int var7 = var1.b(var3);
         var6 = var1.a(var2);
         var6 = Math.min(var1.f(), var7 - var6);
      }

      return var6;
   }

   static int a(RecyclerView.State var0, OrientationHelper var1, View var2, View var3, RecyclerView.LayoutManager var4, boolean var5, boolean var6) {
      int var8 = 0;
      int var9 = var8;
      if (var4.v() != 0) {
         var9 = var8;
         if (var0.e() != 0) {
            var9 = var8;
            if (var2 != null) {
               if (var3 == null) {
                  var9 = var8;
               } else {
                  var8 = Math.min(var4.d(var2), var4.d(var3));
                  var9 = Math.max(var4.d(var2), var4.d(var3));
                  if (var6) {
                     var8 = Math.max(0, var0.e() - var9 - 1);
                  } else {
                     var8 = Math.max(0, var8);
                  }

                  var9 = var8;
                  if (var5) {
                     int var10 = Math.abs(var1.b(var3) - var1.a(var2));
                     var9 = Math.abs(var4.d(var2) - var4.d(var3));
                     float var7 = (float)var10 / (var9 + 1);
                     var9 = Math.round(var8 * var7 + (var1.c() - var1.a(var2)));
                  }
               }
            }
         }
      }

      return var9;
   }

   static int b(RecyclerView.State var0, OrientationHelper var1, View var2, View var3, RecyclerView.LayoutManager var4, boolean var5) {
      int var6;
      if (var4.v() == 0 || var0.e() == 0 || var2 == null || var3 == null) {
         var6 = 0;
      } else if (!var5) {
         var6 = var0.e();
      } else {
         int var7 = var1.b(var3);
         var6 = var1.a(var2);
         int var8 = Math.abs(var4.d(var2) - var4.d(var3));
         var6 = (int)((float)(var7 - var6) / (var8 + 1) * var0.e());
      }

      return var6;
   }
}
