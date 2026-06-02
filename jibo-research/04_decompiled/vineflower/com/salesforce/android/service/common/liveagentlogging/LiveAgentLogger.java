package com.salesforce.android.service.common.liveagentlogging;

import android.content.Context;
import android.content.Intent;
import com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceConnection;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class LiveAgentLogger {
   private final LiveAgentLoggingServiceConnection a;
   private final LiveAgentLoggingConfiguration b;

   protected LiveAgentLogger(LiveAgentLogger.Builder var1) {
      this.b = var1.a;
      this.a = var1.b.a();
   }

   public Async<LiveAgentLoggingSession> a(Context var1) {
      Intent var2 = this.a.a(var1, this.b);
      return this.a.a(var1, var2);
   }

   public void a() {
      this.a.a();
   }

   public static class Builder {
      protected LiveAgentLoggingConfiguration a;
      protected LiveAgentLoggingServiceConnection.Builder b;

      public LiveAgentLogger.Builder a(LiveAgentLoggingConfiguration var1) {
         this.a = var1;
         return this;
      }

      public LiveAgentLogger a() {
         Arguments.a(this.a);
         if (this.b == null) {
            this.b = new LiveAgentLoggingServiceConnection.Builder();
         }

         return new LiveAgentLogger(this);
      }
   }
}
