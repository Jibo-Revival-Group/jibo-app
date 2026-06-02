package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;

public class ApiKey {
   protected String a() {
      return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
   }

   public String a(Context var1) {
      String var3 = this.b(var1);
      String var2 = var3;
      if (TextUtils.isEmpty(var3)) {
         var2 = this.c(var1);
      }

      if (TextUtils.isEmpty(var2)) {
         this.d(var1);
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected String b(Context var1) {
      Object var3 = null;
      Object var4 = null;
      String var2 = (String)var3;

      String var5;
      try {
         var5 = var1.getPackageName();
      } catch (Exception var10) {
         Fabric.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + var10);
         return var2;
      }

      var2 = var3;

      try {
         var17 = var1.getPackageManager().getApplicationInfo(var5, 128).metaData;
      } catch (Exception var9) {
         Fabric.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + var9);
         return (String)var2;
      }

      String var11 = (String)var4;
      if (var17 != null) {
         var2 = var3;

         try {
            var3 = var17.getString("io.fabric.ApiKey");
         } catch (Exception var8) {
            Fabric.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + var8);
            Object var18 = var2;
            return (String)var18;
         }

         var11 = (String)var3;
         if (var3 == null) {
            var2 = (String)var3;

            try {
               Fabric.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
            } catch (Exception var7) {
               Fabric.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + var7);
               String var19 = var2;
               return var19;
            }

            var2 = (String)var3;

            try {
               var11 = var17.getString("com.crashlytics.ApiKey");
            } catch (Exception var6) {
               Fabric.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + var6);
               var11 = var2;
            }
         }
      }

      return var11;
   }

   protected String c(Context var1) {
      String var4 = null;
      int var3 = CommonUtils.a(var1, "io.fabric.ApiKey", "string");
      int var2 = var3;
      if (var3 == 0) {
         Fabric.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
         var2 = CommonUtils.a(var1, "com.crashlytics.ApiKey", "string");
      }

      if (var2 != 0) {
         var4 = var1.getResources().getString(var2);
      }

      return var4;
   }

   protected void d(Context var1) {
      if (!Fabric.i() && !CommonUtils.i(var1)) {
         Fabric.h().e("Fabric", this.a());
      } else {
         throw new IllegalArgumentException(this.a());
      }
   }
}
