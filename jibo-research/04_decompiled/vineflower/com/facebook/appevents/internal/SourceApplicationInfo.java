package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import bolts.AppLinks;
import com.facebook.FacebookSdk;

class SourceApplicationInfo {
   private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
   private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
   private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
   private String callingApplicationPackage;
   private boolean openedByApplink;

   private SourceApplicationInfo(String var1, boolean var2) {
      this.callingApplicationPackage = var1;
      this.openedByApplink = var2;
   }

   public static void clearSavedSourceApplicationInfoFromDisk() {
      Editor var0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
      var0.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
      var0.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
      var0.apply();
   }

   public static SourceApplicationInfo getStoredSourceApplicatioInfo() {
      SourceApplicationInfo var0 = null;
      SharedPreferences var1 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
      if (var1.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
         var0 = new SourceApplicationInfo(
            var1.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null),
            var1.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false)
         );
      }

      return var0;
   }

   public String getCallingApplicationPackage() {
      return this.callingApplicationPackage;
   }

   public boolean isOpenedByApplink() {
      return this.openedByApplink;
   }

   @Override
   public String toString() {
      String var1 = "Unclassified";
      if (this.openedByApplink) {
         var1 = "Applink";
      }

      String var2 = var1;
      if (this.callingApplicationPackage != null) {
         var2 = var1 + "(" + this.callingApplicationPackage + ")";
      }

      return var2;
   }

   public void writeSourceApplicationInfoToDisk() {
      Editor var1 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
      var1.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.callingApplicationPackage);
      var1.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.openedByApplink);
      var1.apply();
   }

   public static class Factory {
      public static SourceApplicationInfo create(Activity var0) {
         boolean var2 = false;
         ComponentName var3 = var0.getCallingActivity();
         SourceApplicationInfo var6;
         if (var3 == null) {
            var6 = null;
         } else {
            String var9 = var3.getPackageName();
            if (var9.equals(var0.getPackageName())) {
               var6 = null;
            } else {
               Intent var4 = var0.getIntent();
               String var7 = var9;
               boolean var1 = var2;
               if (var4 != null) {
                  var7 = var9;
                  var1 = var2;
                  if (!var4.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)) {
                     var4.putExtra("_fbSourceApplicationHasBeenSet", true);
                     Bundle var5 = AppLinks.a(var4);
                     var7 = var9;
                     var1 = var2;
                     if (var5 != null) {
                        Bundle var8 = var5.getBundle("referer_app_link");
                        if (var8 != null) {
                           var7 = var8.getString("package");
                           var1 = true;
                        } else {
                           var1 = true;
                           var7 = var9;
                        }
                     }
                  }
               }

               var4.putExtra("_fbSourceApplicationHasBeenSet", true);
               var6 = new SourceApplicationInfo(var7, var1);
            }
         }

         return var6;
      }
   }
}
