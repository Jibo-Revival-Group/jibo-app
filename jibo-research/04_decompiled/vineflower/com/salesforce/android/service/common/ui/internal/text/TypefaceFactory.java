package com.salesforce.android.service.common.ui.internal.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public class TypefaceFactory {
   public static Typeface a(AssetManager var0, String var1) {
      return Typeface.createFromAsset(var0, var1);
   }
}
