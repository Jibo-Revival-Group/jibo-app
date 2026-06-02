package com.salesforce.android.knowledge.ui.internal.views;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

class ViewUtil {
   public static <T extends View> T a(View var0, int var1) {
      return (T)var0.findViewById(var1);
   }

   public static void a(Drawable var0, int var1) {
      var0.mutate().setColorFilter(var1, Mode.SRC_IN);
   }

   public static void a(Toolbar var0, int var1) {
      Drawable var3 = var0.getNavigationIcon();
      if (var3 != null) {
         a(var3, var1);
      }

      Menu var5 = var0.getMenu();

      for (int var2 = 0; var2 < var5.size(); var2++) {
         Drawable var4 = var5.getItem(var2).getIcon();
         if (var4 != null) {
            a(var4, var1);
         }
      }
   }
}
