package com.salesforce.androidsdk.config;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.RestrictionsManager;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class RuntimeConfig {
   private static RuntimeConfig d = null;
   private final ExecutorService a = Executors.newFixedThreadPool(1);
   private boolean b = false;
   private Bundle c = null;

   private RuntimeConfig(Context var1) {
      if (VERSION.SDK_INT >= 21) {
         this.c = this.b(var1);
         this.b = this.c(var1);
         if (this.b && this.c != null && !this.c.isEmpty()) {
            SalesforceSDKManager.a().e("MM");
            if (this.c(RuntimeConfig.ConfigKey.RequireCertAuth)) {
               SalesforceSDKManager.a().e("CT");
            }
         }

         this.a.execute(new Runnable(this) {
            final RuntimeConfig a;

            {
               this.a = var1;
            }

            // $VF: Duplicated exception handlers to handle obfuscated exceptions
            @Override
            public void run() {
               JSONObject var1x = new JSONObject();

               label36: {
                  JSONObject var3;
                  Iterator var4;
                  try {
                     var1x.put("mdmIsActive", this.a.b);
                     if (this.a.c == null) {
                        break label36;
                     }

                     var3 = new JSONObject();
                     var4 = this.a.c.keySet().iterator();
                  } catch (JSONException var6) {
                     SalesforceSDKLogger.a("RuntimeConfig", "Exception thrown while creating JSON", var6);
                     break label36;
                  }

                  while (true) {
                     try {
                        if (!var4.hasNext()) {
                           break;
                        }

                        String var2 = (String)var4.next();
                        var3.put(var2, JSONObject.wrap(this.a.c.get(var2)));
                     } catch (JSONException var7) {
                        SalesforceSDKLogger.a("RuntimeConfig", "Exception thrown while creating JSON", var7);
                        break label36;
                     }
                  }

                  try {
                     var1x.put("mdmConfigs", var3);
                  } catch (JSONException var5) {
                     SalesforceSDKLogger.a("RuntimeConfig", "Exception thrown while creating JSON", var5);
                  }
               }

               EventBuilderHelper.b("mdmConfiguration", null, "RuntimeConfig", var1x);
            }
         });
      }
   }

   public static RuntimeConfig a(Context var0) {
      if (d == null) {
         d = new RuntimeConfig(var0);
      }

      return d;
   }

   @TargetApi(21)
   private Bundle b(Context var1) {
      return ((RestrictionsManager)var1.getSystemService("restrictions")).getApplicationRestrictions();
   }

   @TargetApi(21)
   private boolean c(Context var1) {
      return ((RestrictionsManager)var1.getSystemService("restrictions")).hasRestrictionsProvider();
   }

   public String a(RuntimeConfig.ConfigKey var1) {
      String var2;
      if (this.c == null) {
         var2 = null;
      } else {
         var2 = this.c.getString(var1.name());
      }

      return var2;
   }

   public boolean a() {
      return this.b;
   }

   public String[] b(RuntimeConfig.ConfigKey var1) {
      String[] var2;
      if (this.c == null) {
         var2 = null;
      } else {
         var2 = this.c.getStringArray(var1.name());
      }

      return var2;
   }

   public Boolean c(RuntimeConfig.ConfigKey var1) {
      boolean var2;
      if (this.c == null) {
         var2 = false;
      } else {
         var2 = this.c.getBoolean(var1.name());
      }

      return var2;
   }

   public enum ConfigKey {
      AppServiceHostLabels,
      AppServiceHosts,
      ManagedAppCallbackURL,
      ManagedAppCertAlias,
      ManagedAppOAuthID,
      OnlyShowAuthorizedHosts,
      RequireCertAuth;

      private static final RuntimeConfig.ConfigKey[] $VALUES = new RuntimeConfig.ConfigKey[]{
         RuntimeConfig.ConfigKey.AppServiceHosts,
         RuntimeConfig.ConfigKey.AppServiceHostLabels,
         RuntimeConfig.ConfigKey.ManagedAppOAuthID,
         RuntimeConfig.ConfigKey.ManagedAppCallbackURL,
         RuntimeConfig.ConfigKey.RequireCertAuth,
         RuntimeConfig.ConfigKey.ManagedAppCertAlias,
         RuntimeConfig.ConfigKey.OnlyShowAuthorizedHosts
      };
   }
}
