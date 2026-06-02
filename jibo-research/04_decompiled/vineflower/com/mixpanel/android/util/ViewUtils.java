package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Color;

public class ViewUtils {
   public static float a(float var0, Context var1) {
      return var1.getResources().getDisplayMetrics().densityDpi / 160.0F * var0;
   }

   public static int a(int var0, int var1) {
      float var2 = Color.red(var0) / 2 + Color.red(var1) / 2;
      float var4 = Color.green(var0) / 2 + Color.green(var1) / 2;
      float var3 = Color.blue(var0) / 2 + Color.blue(var1) / 2;
      return Color.rgb((int)var2, (int)var4, (int)var3);
   }
}
