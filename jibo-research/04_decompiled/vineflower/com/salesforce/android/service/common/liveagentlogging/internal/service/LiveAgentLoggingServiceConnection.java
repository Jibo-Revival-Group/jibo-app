package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;

public class LiveAgentLoggingServiceConnection implements ServiceConnection {
   private final IntentFactory a;
   private Context b;
   private LiveAgentLoggingServiceConnection.OnDisconnectedListener c;
   private BasicAsync<LiveAgentLoggingSession> d;
   private boolean e = false;

   protected LiveAgentLoggingServiceConnection(LiveAgentLoggingServiceConnection.Builder var1) {
      this.a = var1.a;
   }

   public Intent a(Context var1, LiveAgentLoggingConfiguration var2) {
      Intent var3 = this.a.a(var1, LiveAgentLoggingService.class);
      var3.putExtra("com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration", var2);
      return var3;
   }

   public Async<LiveAgentLoggingSession> a(Context var1, Intent var2) {
      this.b = var1.getApplicationContext();
      this.e = this.b.bindService(var2, this, 1);
      BasicAsync var3;
      if (!this.e) {
         var3 = BasicAsync.c(new Exception("Unable to bind to LiveAgentLoggingService."));
      } else {
         this.d = BasicAsync.g();
         var3 = this.d;
      }

      return var3;
   }

   public void a() {
      if (this.e && this.b != null) {
         this.e = false;
         this.b.unbindService(this);
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      if (var2 instanceof LiveAgentLoggingServiceBinder && this.d != null) {
         LiveAgentLoggingSession var3 = ((LiveAgentLoggingServiceBinder)var2).a();
         this.d.a(var3);
         this.d.a();
         this.d = null;
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
      if (this.c != null) {
         this.c.a();
      }
   }

   public static class Builder {
      protected IntentFactory a;

      public LiveAgentLoggingServiceConnection a() {
         if (this.a == null) {
            this.a = new IntentFactory();
         }

         return new LiveAgentLoggingServiceConnection(this);
      }
   }

   public interface OnDisconnectedListener {
      void a();
   }
}
