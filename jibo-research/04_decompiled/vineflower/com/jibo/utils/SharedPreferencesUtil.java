package com.jibo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import java.util.ArrayList;
import java.util.Collections;

public class SharedPreferencesUtil {
   public static void a(Context var0) {
      SharedPreferences var2 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      int var1;
      if (var2.contains("PREF_APP_OPEN_NUM")) {
         var1 = var2.getInt("PREF_APP_OPEN_NUM", 0) + 1;
      } else {
         var1 = 1;
      }

      var2.edit().putInt("PREF_APP_OPEN_NUM", var1).apply();
   }

   public static void a(Context var0, Loop var1) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putString(Loop.class.getSimpleName(), new Gson().b(var1)).apply();
   }

   public static void a(Context var0, String var1) {
      SharedPreferences var2 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var3 = new ArrayList();
      Collections.addAll(var3, var2.getString("PREF_PARENTS_MEMBERS", "").split(","));
      var3.remove("");
      var3.remove(var1);
      var3.add(var1);
      var2.edit().putString("PREF_PARENTS_MEMBERS", TextUtils.join(",", var3)).apply();
   }

   public static void a(Context var0, String var1, boolean var2) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putBoolean(var1, var2).apply();
   }

   public static void a(Context var0, boolean var1) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putBoolean("PREF_PUSHES_ON_GALLERY_CONTENT", var1).apply();
   }

   public static void b(Context var0) {
      SharedPreferences var1 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      var1.edit().putString("PREF_PUSH_SERVICE_TOKEN", "").apply();
      var1.edit().putString("PREF_INSTANCE_ID", "").apply();
      var1.edit().putInt("PREF_MEDIA_TAB_MODE", 0).apply();
      var1.edit().putString(Loop.class.getSimpleName(), "").apply();
      var1.edit().putString("PREF_PARENTS_MEMBERS", "").apply();
      var1.edit().putBoolean("PREF_ENCRYPTION_ENABLED", true).apply();
      var1.edit().putString("PREF_LOOPS_IN_TIMEOUT", "").apply();
      var1.edit().putString("PREF_LOOPS_ALERTED_TIMEOUT", "").apply();
      var1.edit().putString("PREF_LOOPS_NO_HOLIDAYS", "").apply();
      var1.edit().putBoolean("PREF_PUSHES_ON_GALLERY_CONTENT", true).apply();
      var1.edit().putBoolean("PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN", false).apply();
   }

   public static void b(Context var0, String var1) {
      SharedPreferences var2 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var3 = new ArrayList();
      Collections.addAll(var3, var2.getString("PREF_PARENTS_MEMBERS", "").split(","));
      var3.remove("");
      var3.remove(var1);
      var2.edit().putString("PREF_PARENTS_MEMBERS", TextUtils.join(",", var3)).apply();
   }

   public static void b(Context var0, boolean var1) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putBoolean("PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN", var1).apply();
   }

   public static void c(Context var0, String var1) {
      SharedPreferences var2 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var3 = new ArrayList();
      Collections.addAll(var3, var2.getString("PREF_LOOPS_IN_TIMEOUT", "").split(","));
      var3.remove("");
      var3.remove(var1);
      var3.add(var1);
      var2.edit().putString("PREF_LOOPS_IN_TIMEOUT", TextUtils.join(",", var3)).apply();
   }

   public static boolean c(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getBoolean("PREF_ACQUISITION", false);
   }

   public static void d(Context var0) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putBoolean("PREF_ACQUISITION", true).apply();
   }

   public static void d(Context var0, String var1) {
      SharedPreferences var3 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, var3.getString("PREF_LOOPS_IN_TIMEOUT", "").split(","));
      var2.remove("");
      var2.remove(var1);
      var3.edit().putString("PREF_LOOPS_IN_TIMEOUT", TextUtils.join(",", var2)).apply();
   }

   public static int e(Context var0) {
      SharedPreferences var2 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      int var1 = var2.getInt("PREF_APP_OPEN_NUM", 0);
      var2.edit().remove("PREF_APP_OPEN_NUM").apply();
      return var1;
   }

   public static void e(Context var0, String var1) {
      d(var0, var1);
      f(var0, var1);
   }

   public static Loop f(Context var0) {
      String var1 = var0.getSharedPreferences(var0.getString(2131755063), 0).getString(Loop.class.getSimpleName(), "");
      Loop var2;
      if (TextUtils.isEmpty(var1)) {
         var2 = null;
      } else {
         var2 = new Gson().a(var1, Loop.class);
      }

      return var2;
   }

   public static void f(Context var0, String var1) {
      SharedPreferences var2 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var3 = new ArrayList();
      Collections.addAll(var3, var2.getString("PREF_LOOPS_ALERTED_TIMEOUT", "").split(","));
      var3.remove("");
      var3.remove(var1);
      var3.add(var1);
      var2.edit().putString("PREF_LOOPS_ALERTED_TIMEOUT", TextUtils.join(",", var3)).apply();
   }

   public static void g(Context var0, String var1) {
      SharedPreferences var3 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, var3.getString("PREF_LOOPS_NO_HOLIDAYS", "").split(","));
      var2.remove("");
      var2.remove(var1);
      var2.add(var1);
      var3.edit().putString("PREF_LOOPS_NO_HOLIDAYS", TextUtils.join(",", var2)).apply();
   }

   public static boolean g(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getBoolean("PREF_ENCRYPTION_ENABLED", true);
   }

   public static void h(Context var0, String var1) {
      SharedPreferences var3 = var0.getSharedPreferences(var0.getString(2131755063), 0);
      ArrayList var2 = new ArrayList();
      Collections.addAll(var2, var3.getString("PREF_LOOPS_NO_HOLIDAYS", "").split(","));
      var2.remove("");
      var2.remove(var1);
      var3.edit().putString("PREF_LOOPS_NO_HOLIDAYS", TextUtils.join(",", var2)).apply();
   }

   public static String[] h(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getString("PREF_PARENTS_MEMBERS", "").split(",");
   }

   public static boolean i(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getBoolean("PREF_FIRST_TIME_TIPS", true);
   }

   public static void j(Context var0) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putBoolean("PREF_FIRST_TIME_TIPS", false).apply();
   }

   public static boolean k(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getBoolean("PREF_SHOW_INVITE_CONGRATS", true);
   }

   public static void l(Context var0) {
      var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putBoolean("PREF_SHOW_INVITE_CONGRATS", false).apply();
   }

   public static String[] m(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getString("PREF_LOOPS_IN_TIMEOUT", "").split(",");
   }

   public static String[] n(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getString("PREF_LOOPS_ALERTED_TIMEOUT", "").split(",");
   }

   public static String[] o(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getString("PREF_LOOPS_NO_HOLIDAYS", "").split(",");
   }

   public static boolean p(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getBoolean("PREF_PUSHES_ON_GALLERY_CONTENT", true);
   }

   public static boolean q(Context var0) {
      return var0.getSharedPreferences(var0.getString(2131755063), 0).getBoolean("PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN", false);
   }
}
