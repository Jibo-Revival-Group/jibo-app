package com.salesforce.androidsdk.analytics;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.model.InstrumentationEventBuilder;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class EventBuilderHelper {
   private static boolean a = true;
   private static final ExecutorService b = Executors.newFixedThreadPool(2);

   public static void a(String var0, UserAccount var1, String var2, JSONObject var3) {
      if (a) {
         if (SalesforceSDKManager.a().C()) {
            d(var0, var1, var2, var3);
         } else {
            b.execute(new Runnable(var0, var1, var2, var3) {
               final String a;
               final UserAccount b;
               final String c;
               final JSONObject d;

               {
                  this.a = var1;
                  this.b = var2x;
                  this.c = var3x;
                  this.d = var4;
               }

               @Override
               public void run() {
                  EventBuilderHelper.d(this.a, this.b, this.c, this.d);
               }
            });
         }
      }
   }

   public static void b(String var0, UserAccount var1, String var2, JSONObject var3) {
      d(var0, var1, var2, var3);
   }

   private static void d(String var0, UserAccount var1, String var2, JSONObject var3) {
      if (a) {
         UserAccount var4 = var1;
         if (var1 == null) {
            var4 = UserAccountManager.a().b();
         }

         if (var4 != null) {
            SalesforceAnalyticsManager var9 = SalesforceAnalyticsManager.a(var4);
            InstrumentationEventBuilder var10 = InstrumentationEventBuilder.a(var9.a(), SalesforceSDKManager.a().k());
            var10.a(var0);
            JSONObject var7 = new JSONObject();

            try {
               var7.put("context", var2);
            } catch (JSONException var6) {
               SalesforceSDKLogger.a("EventBuilderHelper", "Exception thrown while building page object", var6);
            }

            var10.b(var7);
            if (var3 != null) {
               var10.a(var3.optLong("startTime"));
               if (var3.has("endTime")) {
                  var10.b(var3.optLong("endTime"));
               }

               var10.a(var3);
            }

            var10.a(InstrumentationEvent.SchemaType.LightningInteraction);
            var10.a(InstrumentationEvent.EventType.system);

            try {
               InstrumentationEvent var8 = var10.a();
               var9.a().d().a(var8);
            } catch (InstrumentationEventBuilder.EventBuilderException var5) {
               SalesforceSDKLogger.a("EventBuilderHelper", "Exception thrown while building event", var5);
            }
         }
      }
   }
}
