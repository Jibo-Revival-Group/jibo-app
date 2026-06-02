package com.jibo.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.design.widget.Snackbar;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.jibo.ui.view.proxima.ProximaHelper;
import java.text.SimpleDateFormat;

public class UIUtils {
   public static final SimpleDateFormat a = new SimpleDateFormat("hh:mm a");
   public static final SimpleDateFormat b = new SimpleDateFormat("M/d/yy");
   public static final SimpleDateFormat c = new SimpleDateFormat("hh:mm a");

   public static int a() {
      int var0;
      if (VERSION.SDK_INT >= 21) {
         var0 = 2131230809;
      } else {
         var0 = 2131558401;
      }

      return var0;
   }

   public static SpannableStringBuilder a(Context var0, String var1, String var2) {
      var1 = var1 + "\n" + var2;
      SpannableStringBuilder var3 = new SpannableStringBuilder(var1);
      var3.setSpan(new ForegroundColorSpan(var0.getResources().getColor(2131099846)), var1.indexOf(var2), var1.length(), 18);
      var3.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.b), var1.indexOf(var2), var1.length(), 33);
      var3.setSpan(new RelativeSizeSpan(0.85F), var1.indexOf(var2), var1.length(), 33);
      return var3;
   }

   public static void a(Context var0, View var1) {
      if (var1 != null) {
         ((InputMethodManager)var0.getSystemService("input_method")).hideSoftInputFromWindow(var1.getWindowToken(), 0);
      }
   }

   public static void a(View var0, String var1) {
      Snackbar.a(var0, var1, 0).c();
   }

   public static void a(View var0, Throwable var1) {
      a(var0, ErrorHelper.a(var0.getContext().getApplicationContext(), var1));
   }

   public static void a(String var0, TextView var1) {
      a(var0, var1, ImageUtils.b(var1.getContext(), 2131099679));
   }

   public static void a(String var0, TextView var1, int var2) {
      String var21 = var1.getContext().getString(2131755813);
      String var20 = var1.getContext().getString(2131755815);
      String var18 = var1.getContext().getString(2131755816);
      String var17 = var1.getContext().getString(2131755814);
      String var16 = var1.getContext().getString(2131755812, new Object[]{var21, var18, var17, var20});
      boolean var12 = d(var0);
      int var3 = ImageUtils.b(var1.getContext(), 2131099764);
      if (var12) {
         SpannableStringBuilder var22 = new SpannableStringBuilder(var1.getContext().getString(2131755581));
         var22.setSpan(new ForegroundColorSpan(var3), 0, var22.length(), 33);
         var1.setText(var22);
      } else {
         boolean var14 = b(var0);
         var12 = c(var0);
         boolean var15 = e(var0);
         boolean var13 = f(var0);
         if (var14 && var12 && var15 && var13) {
            SpannableStringBuilder var23 = new SpannableStringBuilder(var16);
            var23.setSpan(new ForegroundColorSpan(var2), 0, var23.length(), 33);
            var1.setText(var16);
         } else {
            SpannableStringBuilder var19 = new SpannableStringBuilder(var16);
            int var10 = var16.indexOf(var21);
            int var9 = var16.indexOf(var20);
            int var11 = var16.indexOf(var18);
            int var8 = var16.indexOf(var17);
            int var4;
            if (!var12 && !TextUtils.isEmpty(var0)) {
               var4 = var3;
            } else {
               var4 = var2;
            }

            int var5;
            if (!var15 && !TextUtils.isEmpty(var0)) {
               var5 = var3;
            } else {
               var5 = var2;
            }

            int var6;
            if (!var14 && !TextUtils.isEmpty(var0)) {
               var6 = var3;
            } else {
               var6 = var2;
            }

            int var7 = var2;
            if (!var13) {
               if (TextUtils.isEmpty(var0)) {
                  var7 = var2;
               } else {
                  var7 = var3;
               }
            }

            var19.setSpan(new ForegroundColorSpan(var4), var10, var21.length() + var10, 33);
            var19.setSpan(new ForegroundColorSpan(var6), var9, var20.length() + var9, 33);
            var19.setSpan(new ForegroundColorSpan(var5), var11, var18.length() + var11, 33);
            var19.setSpan(new ForegroundColorSpan(var7), var8, var17.length() + var8, 33);
            var1.setText(var19);
         }
      }
   }

   public static boolean a(String var0) {
      boolean var1;
      if (!TextUtils.isEmpty(var0) && Commons.b.matcher(var0).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static void b(Context var0, View var1) {
      if (var1 != null) {
         ((InputMethodManager)var0.getSystemService("input_method")).showSoftInput(var1, 0);
      }
   }

   public static void b(String var0, TextView var1, int var2) {
      String var15 = var1.getContext().getString(2131755824);
      String var16 = var1.getContext().getString(2131755825);
      String var17 = var1.getContext().getString(2131755826);
      String var13 = var1.getContext().getString(2131755827, new Object[]{var15, var16, var17});
      boolean var10 = d(var0);
      int var3 = ImageUtils.b(var1.getContext(), 2131099764);
      if (var10) {
         SpannableStringBuilder var18 = new SpannableStringBuilder(var1.getContext().getString(2131755581));
         var18.setSpan(new ForegroundColorSpan(var3), 0, var18.length(), 33);
         var1.setText(var18);
      } else {
         boolean var11 = b(var0);
         var10 = c(var0);
         boolean var12 = e(var0);
         if (var11 && var10 && var12) {
            SpannableStringBuilder var19 = new SpannableStringBuilder(var13);
            var19.setSpan(new ForegroundColorSpan(var2), 0, var19.length(), 33);
            var1.setText(var13);
         } else {
            SpannableStringBuilder var14 = new SpannableStringBuilder(var13);
            int var7 = var13.indexOf(var15);
            int var9 = var13.indexOf(var16);
            int var8 = var13.indexOf(var17);
            int var4;
            if (!var10 && !TextUtils.isEmpty(var0)) {
               var4 = var3;
            } else {
               var4 = var2;
            }

            int var5;
            if (!var12 && !TextUtils.isEmpty(var0)) {
               var5 = var3;
            } else {
               var5 = var2;
            }

            int var6 = var2;
            if (!var11) {
               if (TextUtils.isEmpty(var0)) {
                  var6 = var2;
               } else {
                  var6 = var3;
               }
            }

            var14.setSpan(new ForegroundColorSpan(var4), var7, var15.length() + var7, 33);
            var14.setSpan(new ForegroundColorSpan(var6), var9, var16.length() + var9, 33);
            var14.setSpan(new ForegroundColorSpan(var5), var8, var17.length() + var8, 33);
            var1.setText(var14);
         }
      }
   }

   private static boolean b(String var0) {
      return Commons.e.matcher(var0).matches();
   }

   private static boolean c(String var0) {
      boolean var1;
      if (var0.length() >= 8) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static boolean d(String var0) {
      boolean var1;
      if (var0.length() > 64) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static boolean e(String var0) {
      return Commons.c.matcher(var0).find();
   }

   private static boolean f(String var0) {
      return Commons.d.matcher(var0).matches();
   }
}
