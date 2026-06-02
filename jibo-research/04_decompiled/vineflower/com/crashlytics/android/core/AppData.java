package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.common.IdManager;

class AppData {
   public final String a;
   public final String b;
   public final String c;
   public final String d;
   public final String e;
   public final String f;

   AppData(String var1, String var2, String var3, String var4, String var5, String var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public static AppData a(Context var0, IdManager var1, String var2, String var3) throws NameNotFoundException {
      String var4 = var0.getPackageName();
      String var8 = var1.j();
      PackageInfo var6 = var0.getPackageManager().getPackageInfo(var4, 0);
      String var5 = Integer.toString(var6.versionCode);
      String var7;
      if (var6.versionName == null) {
         var7 = "0.0";
      } else {
         var7 = var6.versionName;
      }

      return new AppData(var2, var3, var8, var4, var5, var7);
   }
}
