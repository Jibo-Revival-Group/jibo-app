package com.salesforce.android.knowledge.ui.internal.logging;

import android.content.Context;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLogger;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.DeviceEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.internal.device.BatteryLevelTracker;
import com.salesforce.android.service.common.utilities.internal.device.DeviceInfoLoader;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.ArrayList;
import java.util.List;

public class LiveAgentKnowledgeLogger implements AnalyticsHook.Listener, CommonEventHook.Listener, LiveAgentLoggingSession.Listener {
   private static final ServiceLogger a = ServiceLogging.a(LiveAgentKnowledgeLogger.class);
   private final DeviceInfoLoader.Builder b;
   private final LiveAgentLogger.Builder c;
   private final AnalyticsHook d;
   private final CommonEventHook e;
   private final String f;
   private LiveAgentLogger g;
   private LiveAgentLoggingSession h;
   private final List<BaseEvent> i = new ArrayList<>();

   LiveAgentKnowledgeLogger(String var1, CommonEventHook var2, AnalyticsHook var3, DeviceInfoLoader.Builder var4, LiveAgentLogger.Builder var5) {
      this.f = var1;
      this.d = var3;
      this.e = var2;
      this.b = var4;
      this.c = var5;
   }

   public static LiveAgentKnowledgeLogger a(String var0, String var1, String var2, ActivityTracker var3) {
      KbBasicInfo var4 = new KbBasicInfo(var0, var1, var2, false);
      var1 = new UUIDProvider().a().toString();
      AnalyticsHook var6 = new AnalyticsHook();
      new Translator().a(var4, var1, var6);
      return new LiveAgentKnowledgeLogger(var1, CommonEventHook.a(var3, var1), var6, new DeviceInfoLoader.Builder(), new LiveAgentLogger.Builder());
   }

   private void a(Context var1, DeviceInfoLoader var2) {
      this.c(new DeviceEvent("KB", this.f, "3.0.0+android", var2.c(), var2.a(), var2.b(), var2.d()));
      BatteryLevelTracker var3 = new BatteryLevelTracker.Builder().a(var1).a();
      this.c(new BatteryEvent("KB", this.f, var3.a()));
   }

   private void b(LiveAgentLoggingSession var1) {
      var1.a(this.i);
      this.i.clear();
   }

   private void c(BaseEvent var1) {
      if (this.h != null) {
         this.h.a(var1);
      } else {
         this.i.add(var1);
      }
   }

   public void a() {
      this.e.a((CommonEventHook.Listener)null);
      this.e.a();
      this.d.a(null);
      this.d.b();
      if (this.g != null) {
         this.g.a();
         this.g = null;
         this.h = null;
      }
   }

   public void a(Context var1) {
      if (this.g == null) {
         DeviceInfoLoader var2 = this.b.a(var1).a();
         LiveAgentLoggingConfiguration var3 = new LiveAgentLoggingConfiguration.Builder().a();
         this.g = this.c.a(var3).a();
         this.g.a(var1).a(new Async.ResultHandler<LiveAgentLoggingSession>(this) {
            final LiveAgentKnowledgeLogger a;

            {
               this.a = var1;
            }

            public void a(Async<?> var1, LiveAgentLoggingSession var2x) {
               this.a.a(var2x);
            }
         });
         this.a(var1, var2);
         this.d.a(this);
         this.d.a();
         this.e.a(this);
         this.e.a(var1);
      }
   }

   void a(LiveAgentLoggingSession var1) {
      this.h = var1;
      this.b(var1);
   }

   @Override
   public void a(BaseEvent var1) {
      this.c(var1);
   }

   @Override
   public void a(Async<BatchedEventsResponse> var1) {
   }

   @Override
   public void b(BaseEvent var1) {
      this.c(var1);
   }

   @Override
   public void c() {
      a.c("Logging session connected");
      this.h.a();
   }

   @Override
   public void d() {
      a.c("Logging session ended");
   }
}
