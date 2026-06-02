package com.salesforce.androidsdk.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PushMessaging {
   private static final ExecutorService a = Executors.newFixedThreadPool(2);

   private static String a(UserAccount var0) {
      String var1 = "gcm_prefs";
      if (var0 != null) {
         var1 = "gcm_prefs" + var0.u();
      }

      return var1;
   }

   public static void a(Context var0, UserAccount var1) {
      if (var1 != null && !f(var0, var1)) {
         a(var0, true, var1);
         if (a(var0)) {
            var0.startService(new Intent(var0, SFDCRegistrationIntentService.class));
         }
      } else {
         c(var0, var1);
      }
   }

   private static void a(Context var0, UserAccount var1, Intent var2) {
      if (var1 == null) {
         Bundle var3 = new Bundle();
         var3.putString("account_bundle", "all_accounts");
         var2.putExtra("account_bundle", var3);
         PushService.a(var2);
      } else if (f(var0, var1)) {
         var2.putExtra("account_bundle", var1.w());
         PushService.a(var2);
      }
   }

   public static void a(Context var0, String var1, UserAccount var2) {
      Editor var3 = var0.getSharedPreferences(a(var2), 0).edit();
      var3.putString("c2dm_registration_id", var1);
      var3.putLong("backoff", 30000L);
      var3.commit();
   }

   static void a(Context var0, String var1, String var2, UserAccount var3) {
      Editor var4 = var0.getSharedPreferences(a(var3), 0).edit();
      var4.putString("c2dm_registration_id", var1);
      var4.putString("deviceId", var2);
      var4.putLong("backoff", 30000L);
      var4.putLong("last_registration_change", System.currentTimeMillis());
      var4.putBoolean("inprogress", false);
      var4.commit();
   }

   public static void a(Context var0, boolean var1, UserAccount var2) {
      Editor var3 = var0.getSharedPreferences(a(var2), 0).edit();
      var3.putBoolean("inprogress", var1);
      var3.commit();
   }

   private static boolean a(Context var0) {
      boolean var1;
      if (GoogleApiAvailability.a().a(var0) == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static void b(Context var0, UserAccount var1) {
      if (f(var0, var1)) {
         a(var0, true, var1);
         InstanceID var2 = InstanceID.c(var0);
         a.execute(new Runnable(var2) {
            final InstanceID a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               try {
                  this.a.a();
               } catch (IOException var2x) {
                  SalesforceSDKLogger.a("PushMessaging", "Error deleting InstanceID", var2x);
               }
            }
         });
         d(var0, var1);
      }
   }

   public static void c(Context var0, UserAccount var1) {
      a(var0, var1, new Intent("com.salesforce.mobilesdk.c2dm.intent.RETRY"));
   }

   public static void d(Context var0, UserAccount var1) {
      a(var0, var1, new Intent("com.salesforce.mobilesdk.c2dm.intent.UNREGISTER"));
   }

   public static String e(Context var0, UserAccount var1) {
      return var0.getSharedPreferences(a(var1), 0).getString("c2dm_registration_id", null);
   }

   public static boolean f(Context var0, UserAccount var1) {
      boolean var2 = false;
      if (var0.getSharedPreferences(a(var1), 0).getString("c2dm_registration_id", null) != null) {
         var2 = true;
      }

      return var2;
   }

   public static String g(Context var0, UserAccount var1) {
      return var0.getSharedPreferences(a(var1), 0).getString("deviceId", null);
   }

   public static void h(Context var0, UserAccount var1) {
      Editor var2 = var0.getSharedPreferences(a(var1), 0).edit();
      var2.clear();
      var2.commit();
   }
}
