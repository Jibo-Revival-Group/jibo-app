package com.salesforce.android.service.common.ui.internal.utils;

import android.view.View;
import android.view.ViewGroup;

public class ViewGroupHelper {
   public static void a(ViewGroup var0, boolean var1) {
      int var3 = var0.getChildCount();

      for (int var2 = 0; var2 < var3; var2++) {
         View var4 = var0.getChildAt(var2);
         var4.setEnabled(var1);
         if (var4 instanceof ViewGroup) {
            a((ViewGroup)var4, var1);
         }
      }
   }
}
