package com.salesforce.androidsdk.push;

import android.app.IntentService;
import android.content.Intent;
import com.google.android.gms.iid.InstanceID;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;

public class SFDCRegistrationIntentService extends IntentService {
   public SFDCRegistrationIntentService() {
      super("RegIntentService");
   }

   protected void onHandleIntent(Intent var1) {
      try {
         String var2 = InstanceID.c(this).b(BootConfig.a(this).d(), "GCM", null);
         UserAccount var4 = SalesforceSDKManager.a().o().b();
         PushMessaging.a(this, var2, var4);
         PushMessaging.c(this, var4);
      } catch (Exception var3) {
         SalesforceSDKLogger.a("RegIntentService", "Error during GCM registration", var3);
      }
   }
}
