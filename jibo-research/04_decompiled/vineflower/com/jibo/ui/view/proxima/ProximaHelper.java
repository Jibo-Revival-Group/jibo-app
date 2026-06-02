package com.jibo.ui.view.proxima;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class ProximaHelper {
   public static Typeface a = null;
   public static Typeface b = null;
   public static Typeface c = null;
   public static Typeface d = null;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Typeface a(Context var0, String var1) {
      Typeface var3 = a;
      Typeface var2 = var3;

      try {
         if (TextUtils.isEmpty(var1)) {
            return var2;
         }
      } catch (Exception var5) {
         var2 = a;
         return var2;
      }

      var2 = var3;

      try {
         if (!var1.contains("ProximaNova-Regular.ttf")) {
            AssetManager var6 = var0.getAssets();
            StringBuilder var7 = new StringBuilder();
            var2 = Typeface.createFromAsset(var6, var7.append("fonts/").append(var1).toString());
         }
      } catch (Exception var4) {
         var2 = a;
      }

      return var2;
   }

   public static void a(Context var0) {
      b = Typeface.createFromAsset(var0.getAssets(), "fonts/ProximaNova-Light.ttf");
      a = Typeface.createFromAsset(var0.getAssets(), "fonts/ProximaNova-Regular.ttf");
      c = Typeface.createFromAsset(var0.getAssets(), "fonts/ProximaNova-Semibold.ttf");
      d = Typeface.createFromAsset(var0.getAssets(), "fonts/ProximaNova-Bold.otf");
   }

   public static void a(View var0) {
      if (var0 instanceof TextView) {
         ((TextView)var0).setTypeface(a);
      } else if (var0 instanceof TextInputLayout) {
         ((TextInputLayout)var0).setTypeface(a);
      }
   }

   public static void a(View var0, String var1) {
      Typeface var2 = a(var0.getContext(), var1);
      if (var0 instanceof TextView) {
         ((TextView)var0).setTypeface(var2);
      } else if (var0 instanceof TextInputLayout) {
         ((TextInputLayout)var0).setTypeface(var2);
      }
   }

   public static void b(View var0) {
      if (var0 instanceof TextView) {
         ((TextView)var0).setTypeface(c);
      } else if (var0 instanceof TextInputLayout) {
         ((TextInputLayout)var0).setTypeface(c);
      }
   }
}
