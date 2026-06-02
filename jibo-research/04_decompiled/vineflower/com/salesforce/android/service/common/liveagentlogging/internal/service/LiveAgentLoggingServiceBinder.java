package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.os.Binder;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class LiveAgentLoggingServiceBinder extends Binder {
   private final LiveAgentLoggingSession a;

   protected LiveAgentLoggingServiceBinder(LiveAgentLoggingServiceBinder.Builder var1) {
      this.a = var1.a;
   }

   LiveAgentLoggingSession a() {
      return this.a;
   }

   public static class Builder {
      protected LiveAgentLoggingSession a;

      LiveAgentLoggingServiceBinder.Builder a(LiveAgentLoggingSession var1) {
         this.a = var1;
         return this;
      }

      LiveAgentLoggingServiceBinder a() {
         Arguments.a(this.a);
         return new LiveAgentLoggingServiceBinder(this);
      }
   }
}
