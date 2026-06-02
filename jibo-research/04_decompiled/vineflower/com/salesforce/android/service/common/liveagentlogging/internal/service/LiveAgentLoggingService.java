package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LiveAgentLoggingService extends Service {
   private LiveAgentLoggingServiceDelegate a = new LiveAgentLoggingServiceDelegate(this);

   public IBinder onBind(Intent var1) {
      return this.a.a(var1);
   }

   public void onDestroy() {
      this.a.a();
   }
}
