package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

class ManifestUnityVersionProvider implements UnityVersionProvider {
   private final Context a;
   private final String b;

   public ManifestUnityVersionProvider(Context var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public String a() {
      Object var2 = null;
      PackageManager var1 = this.a.getPackageManager();

      Bundle var3;
      try {
         var3 = var1.getApplicationInfo(this.b, 128).metaData;
      } catch (Exception var5) {
         return (String)var2;
      }

      String var6 = (String)var2;
      if (var3 != null) {
         try {
            var6 = var3.getString("io.fabric.unity.crashlytics.version");
         } catch (Exception var4) {
            var6 = (String)var2;
         }
      }

      return var6;
   }
}
