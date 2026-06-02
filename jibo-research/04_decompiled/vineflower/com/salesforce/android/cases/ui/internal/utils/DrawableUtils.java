package com.salesforce.android.cases.ui.internal.utils;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuItem;

public class DrawableUtils {
   public static void a(Menu var0, int var1, int... var2) {
      int var4 = var2.length;

      for (int var3 = 0; var3 < var4; var3++) {
         MenuItem var5 = var0.findItem(var2[var3]);
         if (var5 != null) {
            Drawable var6 = var5.getIcon();
            if (var6 != null) {
               DrawableCompat.a(DrawableCompat.g(var6).mutate(), var1);
            }
         }
      }
   }
}
