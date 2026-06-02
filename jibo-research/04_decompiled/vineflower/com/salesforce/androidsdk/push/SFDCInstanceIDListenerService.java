package com.salesforce.androidsdk.push;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

public class SFDCInstanceIDListenerService extends InstanceIDListenerService {
   @Override
   public void a() {
      this.startService(new Intent(this, SFDCRegistrationIntentService.class));
   }
}
