package com.salesforce.androidsdk.config;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.salesforce.androidsdk.R;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public class BootConfig {
   private static final String a = "www" + System.getProperty("file.separator") + "bootconfig.json";
   private static BootConfig k = null;
   private String b;
   private String c;
   private String[] d;
   private boolean e;
   private String f;
   private String g;
   private boolean h;
   private boolean i;
   private String j;

   public static BootConfig a(Context var0) {
      if (k == null) {
         k = new BootConfig();
         if (SalesforceSDKManager.a().A()) {
            k.c(var0);
         } else {
            k.d(var0);
         }

         k.b(var0);
      }

      return k;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(String var1) {
      JSONObject var3;
      try {
         var3 = new JSONObject(var1);
         this.b = var3.getString("remoteAccessConsumerKey");
         this.c = var3.getString("oauthRedirectURI");
         var7 = var3.getJSONArray("oauthScopes");
         this.d = new String[var7.length()];
      } catch (JSONException var5) {
         throw new BootConfig.BootConfigException("Failed to parse " + a, var5);
      }

      int var2 = 0;

      while (true) {
         try {
            if (var2 >= this.d.length) {
               break;
            }

            this.d[var2] = var7.getString(var2);
         } catch (JSONException var6) {
            throw new BootConfig.BootConfigException("Failed to parse " + a, var6);
         }

         var2++;
      }

      try {
         this.e = var3.getBoolean("isLocal");
         this.f = var3.getString("startPage");
         this.g = var3.getString("errorPage");
         this.j = var3.optString("androidPushNotificationClientId");
         this.h = var3.optBoolean("shouldAuthenticate", true);
         this.i = var3.optBoolean("attemptOfflineLoad", true);
      } catch (JSONException var4) {
         throw new BootConfig.BootConfigException("Failed to parse " + a, var4);
      }
   }

   private void b(Context var1) {
      RuntimeConfig var2 = RuntimeConfig.a(var1);
      String var3 = var2.a(RuntimeConfig.ConfigKey.ManagedAppOAuthID);
      String var4 = var2.a(RuntimeConfig.ConfigKey.ManagedAppCallbackURL);
      if (!TextUtils.isEmpty(var3)) {
         this.b = var3;
      }

      if (!TextUtils.isEmpty(var4)) {
         this.c = var4;
      }
   }

   private void c(Context var1) {
      this.a(this.e(var1));
   }

   private void d(Context var1) {
      Resources var2 = var1.getResources();
      this.b = var2.getString(R.string.remoteAccessConsumerKey);
      this.c = var2.getString(R.string.oauthRedirectURI);
      this.d = var2.getStringArray(R.array.oauthScopes);
      this.j = var2.getString(R.string.androidPushNotificationClientId);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private String e(Context var1) {
      Scanner var2;
      String var86;
      label405: {
         label406: {
            label407: {
               label399: {
                  try {
                     var2 = new Scanner(var1.getAssets().open(a));
                     break label399;
                  } catch (IOException var76) {
                     var3 = var76;
                  } finally {
                     ;
                  }

                  var2 = null;
                  break label407;
               }

               Scanner var78 = var2;

               try {
                  try {
                     var86 = var2.useDelimiter("\\A").next();
                     break label405;
                  } catch (IOException var74) {
                     var3 = var74;
                  }
               } catch (Throwable var75) {
                  var85 = var78;
                  var79 = var75;
                  break label406;
               }
            }

            Scanner var80 = var2;

            BootConfig.BootConfigException var4;
            try {
               var4 = new BootConfig.BootConfigException;
            } catch (Throwable var73) {
               var85 = var80;
               var79 = var73;
               break label406;
            }

            Scanner var81 = var2;

            StringBuilder var5;
            try {
               var5 = new StringBuilder;
            } catch (Throwable var72) {
               var85 = var81;
               var79 = var72;
               break label406;
            }

            Scanner var82 = var2;

            try {
               var5./* $VF: Unable to resugar constructor */<init>();
            } catch (Throwable var71) {
               var85 = var82;
               var79 = var71;
               break label406;
            }

            Scanner var83 = var2;

            try {
               var4./* $VF: Unable to resugar constructor */<init>(var5.append("Failed to open ").append(a).toString(), var3);
            } catch (Throwable var70) {
               var85 = var83;
               var79 = var70;
               break label406;
            }

            Scanner var84 = var2;

            label371:
            try {
               throw var4;
            } catch (Throwable var69) {
               var85 = var84;
               var79 = var69;
               break label371;
            }
         }

         if (var85 != null) {
            var85.close();
         }

         throw var79;
      }

      if (var2 != null) {
         var2.close();
      }

      return var86;
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.c;
   }

   public String[] c() {
      return this.d;
   }

   public String d() {
      return this.j;
   }

   public static class BootConfigException extends RuntimeException {
      public BootConfigException(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
