package com.salesforce.androidsdk.push;

import android.os.Bundle;
import com.google.android.gms.gcm.GcmListenerService;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

public class SFDCGcmListenerService extends GcmListenerService {
   @Override
   public void a(String var1, Bundle var2) {
      if (var2 != null && SalesforceSDKManager.b()) {
         PushNotificationInterface var3 = SalesforceSDKManager.a().m();
         if (var3 != null) {
            var2.putString("from", var1);
            var3.a(var2);
         }
      }
   }
}
