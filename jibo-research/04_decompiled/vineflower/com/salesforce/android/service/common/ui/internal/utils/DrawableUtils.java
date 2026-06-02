package com.salesforce.android.service.common.ui.internal.utils;

import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public class DrawableUtils {
   public static Drawable a(Drawable var0, int var1) {
      var0.setColorFilter(new PorterDuffColorFilter(var1, Mode.SRC_IN));
      return var0;
   }
}
