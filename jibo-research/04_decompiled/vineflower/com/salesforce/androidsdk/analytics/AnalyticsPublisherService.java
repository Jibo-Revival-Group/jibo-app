package com.salesforce.androidsdk.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;

public class AnalyticsPublisherService extends IntentService {
   public AnalyticsPublisherService() {
      super("AnalyticsPublisherService");
   }

   private void a() {
      UserAccount var1 = UserAccountManager.a().b();
      if (var1 != null) {
         SalesforceAnalyticsManager.a(var1).c();
      }
   }

   public static void a(Context var0) {
      Intent var1 = new Intent(var0, AnalyticsPublisherService.class);
      var1.setAction("com.salesforce.androidsdk.analytics.action.ANALYTICS_PUBLISH");
      var0.startService(var1);
   }

   protected void onHandleIntent(Intent var1) {
      if (var1 != null && "com.salesforce.androidsdk.analytics.action.ANALYTICS_PUBLISH".equals(var1.getAction())) {
         this.a();
      }
   }
}
