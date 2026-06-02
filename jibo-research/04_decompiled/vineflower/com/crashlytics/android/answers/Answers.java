package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

public class Answers extends Kit<Boolean> {
   SessionAnalyticsManager a;

   @Override
   public String a() {
      return "1.3.13.dev";
   }

   public void a(Crash.FatalException var1) {
      if (this.a != null) {
         this.a.a(var1.a(), var1.b());
      }
   }

   public void a(Crash.LoggedException var1) {
      if (this.a != null) {
         this.a.a(var1.a());
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @SuppressLint("NewApi")
   @Override
   protected boolean a_() {
      boolean var1 = false;

      String var4;
      Context var5;
      String var6;
      String var7;
      PackageManager var8;
      PackageInfo var9;
      label48: {
         label54: {
            try {
               var5 = this.r();
               var8 = var5.getPackageManager();
               var7 = var5.getPackageName();
               var9 = var8.getPackageInfo(var7, 0);
               var6 = Integer.toString(var9.versionCode);
               if (var9.versionName == null) {
                  break label54;
               }
            } catch (Exception var14) {
               Fabric.h().e("Answers", "Error retrieving app properties", var14);
               return var1;
            }

            try {
               var4 = var9.versionName;
               break label48;
            } catch (Exception var13) {
               Fabric.h().e("Answers", "Error retrieving app properties", var13);
               return var1;
            }
         }

         var4 = "0.0";
      }

      long var2;
      label55: {
         try {
            if (VERSION.SDK_INT >= 9) {
               var2 = var9.firstInstallTime;
               break label55;
            }
         } catch (Exception var12) {
            Fabric.h().e("Answers", "Error retrieving app properties", var12);
            return var1;
         }

         try {
            ApplicationInfo var15 = var8.getApplicationInfo(var7, 0);
            File var16 = new File(var15.sourceDir);
            var2 = var16.lastModified();
         } catch (Exception var11) {
            Fabric.h().e("Answers", "Error retrieving app properties", var11);
            return var1;
         }
      }

      try {
         this.a = SessionAnalyticsManager.a(this, var5, this.q(), var6, var4, var2);
         this.a.b();
      } catch (Exception var10) {
         Fabric.h().e("Answers", "Error retrieving app properties", var10);
         return var1;
      }

      return true;
   }

   @Override
   public String b() {
      return "com.crashlytics.sdk.android:answers";
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected Boolean d() {
      SettingsData var6;
      try {
         var6 = Settings.a().b();
      } catch (Exception var5) {
         Fabric.h().e("Answers", "Error dealing with settings", var5);
         return false;
      }

      Boolean var1;
      if (var6 == null) {
         try {
            Fabric.h().e("Answers", "Failed to retrieve settings");
            var1 = false;
         } catch (Exception var2) {
            Fabric.h().e("Answers", "Error dealing with settings", var2);
            var1 = false;
         }
      } else {
         try {
            if (var6.d.d) {
               Fabric.h().a("Answers", "Analytics collection enabled");
               this.a.a(var6.e, this.e());
               Boolean var9 = true;
               return var9;
            }
         } catch (Exception var4) {
            Fabric.h().e("Answers", "Error dealing with settings", var4);
            Boolean var7 = false;
            return var7;
         }

         try {
            Fabric.h().a("Answers", "Analytics collection disabled");
            this.a.c();
         } catch (Exception var3) {
            Fabric.h().e("Answers", "Error dealing with settings", var3);
            Boolean var8 = false;
            return var8;
         }

         var1 = false;
      }

      return var1;
   }

   String e() {
      return CommonUtils.b(this.r(), "com.crashlytics.ApiEndpoint");
   }
}
