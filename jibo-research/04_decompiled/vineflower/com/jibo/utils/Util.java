package com.jibo.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TypefaceSpan;
import android.util.Patterns;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.ui.view.proxima.ProximaHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Locale;

public class Util {
   public static Comparator<String> a = new Comparator<String>() {
      public int a(String var1, String var2) {
         int var3;
         if (var1 == null && var2 == null) {
            var3 = 0;
         } else if (var1 == null) {
            var3 = 1;
         } else if (var2 == null) {
            var3 = -1;
         } else {
            var3 = var1.compareTo(var2);
         }

         return var3;
      }
   };

   public static SpannableStringBuilder a(String var0, String var1) {
      SpannableStringBuilder var2 = new SpannableStringBuilder(var0);
      var2.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.b), 0, var0.indexOf(var1), 33);
      var2.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.d), var0.indexOf(var1) + 1, var0.length(), 33);
      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String a(Context var0) {
      String var1 = "1.0";

      String var2;
      try {
         var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionName;
      } catch (NameNotFoundException var7) {
         LogUtils.a("getAppVersion", var7.getMessage());
         return var1;
      }

      var1 = var2;

      StringBuilder var3;
      try {
         var3 = new StringBuilder;
      } catch (NameNotFoundException var6) {
         LogUtils.a("getAppVersion", var6.getMessage());
         return var1;
      }

      var1 = var2;

      try {
         var3./* $VF: Unable to resugar constructor */<init>();
      } catch (NameNotFoundException var5) {
         LogUtils.a("getAppVersion", var5.getMessage());
         return var1;
      }

      var1 = var2;

      try {
         var8 = var3.append(var2).append(".").append(var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionCode).toString();
      } catch (NameNotFoundException var4) {
         LogUtils.a("getAppVersion", var4.getMessage());
         return var1;
      }

      return var8;
   }

   public static String a(String var0) {
      String var1 = var0;
      if (var0 != null) {
         if (!var0.startsWith("\"") || !var0.endsWith("\"")) {
            var1 = var0;
            if (!var0.startsWith("'")) {
               return var1;
            }

            var1 = var0;
            if (!var0.endsWith("'")) {
               return var1;
            }
         }

         var1 = var0.substring(1, var0.length() - 1);
      }

      return var1;
   }

   public static void a(Context var0, ImageView var1, Member var2) {
      int var3;
      if (var2 == null || var2.getAccount() == null || DateTimeUtils.isAdult(var2.getAccount().getBirthday())) {
         var3 = 2131230833;
      } else if (LoopHelper.isMemberAccepted(var2)) {
         var3 = 2131230830;
      } else {
         var3 = 2131230831;
      }

      if (var2 != null && var2.getAccount() != null) {
         Glide.b(var0).a(var2.getAccount().getPhotoUrl()).a(var3).b(var3).c(var3).a(DiskCacheStrategy.ALL).d().a(var1);
      } else {
         var1.setImageResource(var3);
      }
   }

   public static void a(TextView var0, String var1) {
      SpannableStringBuilder var2 = new SpannableStringBuilder(var1);
      if (var1 != null) {
         var2.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), 0, var1.length(), 33);
      }

      var0.setText(var2);
   }

   public static void a(TextView var0, String var1, String var2) {
      String var3;
      if (Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
         var3 = var1;
      } else {
         var3 = var2;
         var2 = var1;
      }

      SpannableStringBuilder var4 = new SpannableStringBuilder(var2 + " " + var3);
      if (var2 != null) {
         var4.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), 0, var2.length(), 33);
      }

      if (var3 != null) {
         var4.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.b), var2.length() + 1, var4.length(), 33);
      }

      var0.setText(var4);
   }

   public static void a(InputStream var0, OutputStream var1) throws IOException {
      byte[] var3 = new byte[1024];

      while (true) {
         int var2 = var0.read(var3);
         if (var2 == -1) {
            var0.close();
            var1.close();
            return;
         }

         var1.write(var3, 0, var2);
      }
   }

   public static boolean a(CharSequence var0) {
      boolean var1;
      if (!TextUtils.isEmpty(var0) && Patterns.EMAIL_ADDRESS.matcher(var0).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static String b(String var0) throws NoSuchAlgorithmException {
      byte[] var2 = MessageDigest.getInstance("SHA1").digest(var0.getBytes());
      StringBuffer var3 = new StringBuffer();

      for (int var1 = 0; var1 < var2.length; var1++) {
         var3.append(Integer.toString((var2[var1] & 255) + 256, 16).substring(1));
      }

      return var3.toString();
   }

   public static void b(TextView var0, String var1) {
      if (var0 != null) {
         SpannableStringBuilder var4 = new SpannableStringBuilder(var1);
         int var3 = var1.lastIndexOf(" Jibo");
         Util.CustomTypefaceSpan var5 = new Util.CustomTypefaceSpan("", ProximaHelper.c);
         int var2;
         if (var3 > 0) {
            var2 = var3;
         } else {
            var2 = var1.length();
         }

         var4.setSpan(var5, 0, var2, 33);
         if (var3 > 0) {
            var4.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.b), var3, var4.length(), 33);
         }

         var0.setText(var4);
      }
   }

   public static String c(String var0) {
      char[] var3 = var0.toLowerCase().toCharArray();
      int var2 = 0;
      boolean var1 = false;

      while (var2 < var3.length) {
         if (!var1 && Character.isLetter(var3[var2])) {
            var3[var2] = Character.toUpperCase(var3[var2]);
            var1 = true;
         } else if (Character.isWhitespace(var3[var2]) || var3[var2] == '.' || var3[var2] == '\'') {
            var1 = false;
         }

         var2++;
      }

      return String.valueOf(var3);
   }

   public static String d(String var0) {
      int var1 = 1;
      if (var0 == null) {
         var0 = null;
      } else {
         String[] var3 = var0.split(" ");
         var0 = "";
         if (var3.length == 1) {
            var0 = var3[0];
            var0 = "";
         } else if (var3.length > 1) {
            String var2 = var3[0];

            while (var1 < var3.length) {
               var0 = var0 + var3[var1] + " ";
               var1++;
            }

            var0.trim();
            var0 = var2;
         } else {
            var0 = "";
         }
      }

      return var0;
   }

   public static String e(String var0) {
      int var1 = 1;
      if (var0 == null) {
         var0 = null;
      } else {
         String[] var3 = var0.split(" ");
         String var2 = "";
         if (var3.length == 1) {
            var0 = var3[0];
         } else {
            var0 = var2;
            if (var3.length > 1) {
               var0 = var3[0];

               while (var1 < var3.length) {
                  var2 = var2 + var3[var1] + " ";
                  var1++;
               }

               var0 = var2.trim();
            }
         }
      }

      return var0;
   }

   public static class CustomTypefaceSpan extends TypefaceSpan {
      private final Typeface a;

      public CustomTypefaceSpan(String var1, Typeface var2) {
         super(var1);
         this.a = var2;
      }

      private static void a(Paint var0, Typeface var1) {
         Typeface var3 = var0.getTypeface();
         int var2;
         if (var3 == null) {
            var2 = 0;
         } else {
            var2 = var3.getStyle();
         }

         var2 &= ~var1.getStyle();
         if ((var2 & 1) != 0) {
            var0.setFakeBoldText(true);
         }

         if ((var2 & 2) != 0) {
            var0.setTextSkewX(-0.25F);
         }

         var0.setTypeface(var1);
      }

      public void updateDrawState(TextPaint var1) {
         a(var1, this.a);
      }

      public void updateMeasureState(TextPaint var1) {
         a(var1, this.a);
      }
   }
}
