package com.salesforce.android.cases.ui.internal.logging;

import android.content.Context;
import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLogger;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.event.DeviceEvent;
import com.salesforce.android.service.common.liveagentlogging.event.OrientationEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.internal.device.BatteryLevelTracker;
import com.salesforce.android.service.common.utilities.internal.device.DeviceInfoLoader;
import com.salesforce.android.service.common.utilities.internal.device.OrientationTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LiveAgentCasesLogger
   implements ServiceAnalyticsListener,
   LiveAgentLoggingSession.Listener,
   ConnectivityTracker.Listener,
   OrientationTracker.Listener {
   private static final ServiceLogger a = ServiceLogging.a(LiveAgentCasesLogger.class);
   private final Context b;
   private final String c;
   private final Optional<String> d;
   private LiveAgentLogger e;
   private LiveAgentLoggingSession f;
   private final OrientationTracker g;
   private final BatteryLevelTracker h;
   private final ConnectivityTracker i;
   private final DeviceInfoLoader j;
   private boolean k = false;
   private final List<BaseEvent> l = new ArrayList<>();

   private LiveAgentCasesLogger(LiveAgentCasesLogger.Builder var1) {
      this.b = var1.a;
      this.c = var1.b;
      this.d = Optional.a(var1.c);
      this.g = var1.d.a(this).a();
      this.h = var1.e.a();
      this.i = var1.f.a(this).a();
      this.j = var1.g.a();
   }

   private void b(String var1, Map<String, Object> var2) {
      byte var4 = 0;
      byte var5 = 0;
      byte var6 = 0;
      CaseBasicInfo var7 = new CaseBasicInfo(
         (String)var2.get("communityUrl"), (String)var2.get("caseListname"), (String)var2.get("createCaseActionName"), (String)var2.get("userType")
      );
      switch (var1) {
         case "CASE_USER_CASE_PUBLISHER_LAYOUT_EVENT":
            this.a(new CaseLayoutEvent(var7, this.c, (String)var2.get("eventType")));
            break;
         case "CASE_USER_CASE_SUBMISSION_EVENT":
            int var10;
            if (var2.get("wordCount") == null) {
               var10 = var6;
            } else {
               var10 = (Integer)var2.get("wordCount");
            }

            this.a(new CaseSubmissionEvent(var7, this.c, (String)var2.get("eventType"), (String)var2.get("result"), (String)var2.get("caseId"), var10));
            break;
         case "CASE_USER_CASE_LIST_EVENT":
            int var9;
            if (var2.get("caseCount") == null) {
               var9 = var4;
            } else {
               var9 = (Integer)var2.get("caseCount");
            }

            this.a(new CaseListEvent(var7, this.c, (String)var2.get("eventType"), var9));
            break;
         case "CASE_USER_CASE_DETAIL_EVENT":
            this.a(new CaseDetailEvent(var7, this.c, (String)var2.get("eventType"), (String)var2.get("caseId")));
            break;
         case "CASE_RESPONSE_MESSAGE_EVENT":
            this.a(new CaseMessageEvent(var7, this.c, (String)var2.get("sender"), (String)var2.get("caseId")));
            break;
         case "CASE_RESPONSE_NOTIFICATION_EVENT":
            this.a(new CaseNotificationEvent(var7, this.c, (String)var2.get("caseId")));
            break;
         case "CASE_USER_EXIT_PUBLISHER_WITH_DATA_ENTERED_EVENT":
            int var8;
            if (var2.get("wordCount") == null) {
               var8 = var5;
            } else {
               var8 = (Integer)var2.get("wordCount");
            }

            this.a(new CaseDataEnteredEvent(var7, this.c, var8));
      }
   }

   private void f() {
      this.a(new BatteryEvent("case", this.c, this.h.a()));
      this.a(new DeviceEvent("case", this.c, "1.0", this.j.c(), this.j.a(), this.j.b(), this.j.d()));
      ConnectionInfo var2 = this.i.b();
      String var1 = var2.b().name();
      String var3 = var2.c().getRadioName();
      this.a(new ConnectivityEvent("case", this.c, var1, var3));
   }

   public void a() {
      if (!this.k) {
         this.k = true;
         this.f();
         LiveAgentLoggingConfiguration var1 = new LiveAgentLoggingConfiguration.Builder().a();
         this.e = new LiveAgentLogger.Builder().a(var1).a();
         this.e.a(this.b).a(new Async.ResultHandler<LiveAgentLoggingSession>(this) {
            final LiveAgentCasesLogger a;

            {
               this.a = var1;
            }

            public void a(Async<?> var1, LiveAgentLoggingSession var2) {
               this.a.f = var2;
               this.a.f.a(this.a);
               this.a.f.a(this.a.l);
               this.a.l.clear();
            }
         });
      }
   }

   void a(BaseEvent var1) {
      this.d.a(new Consumer<String>(this, var1) {
         final BaseEvent a;
         final LiveAgentCasesLogger b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void a(String var1) {
            this.a.a(var1);
         }
      });
      if (this.f == null) {
         this.l.add(var1);
      } else {
         this.f.a(var1);
      }
   }

   @Override
   public void a(Async<BatchedEventsResponse> var1) {
      var1.a(new Async.CompletionHandler(this) {
         final LiveAgentCasesLogger a;

         {
            this.a = var1;
         }

         @Override
         public void a(Async<?> var1) {
            LiveAgentCasesLogger.a.c("Log event sent successfully");
         }
      }).a(new Async.ErrorHandler(this) {
         final LiveAgentCasesLogger a;

         {
            this.a = var1;
         }

         @Override
         public void a(Async<?> var1, Throwable var2) {
            LiveAgentCasesLogger.a.e("Log flush ERROR {}", var2.getMessage());
         }
      });
   }

   @Override
   public void a(ConnectionInfo var1, ConnectivityState var2, ConnectivityState var3) {
      String var5 = var1.b().name();
      String var4 = var1.c().getRadioName();
      this.a(new ConnectivityEvent("case", this.c, var5, var4));
   }

   @Override
   public void a(Orientation var1) {
      this.a(new OrientationEvent("case", this.c, var1));
   }

   @Override
   public void a(String var1, Map<String, Object> var2) {
      this.b(var1, var2);
   }

   public void b() {
      this.k = false;
      if (this.f != null) {
         this.e.a();

         try {
            this.i.c();
         } catch (IllegalArgumentException var3) {
         }

         try {
            this.g.a();
         } catch (IllegalArgumentException var2) {
         }

         this.f = null;
      }
   }

   @Override
   public void c() {
      a.c("Logging session connected");
      if (this.f != null) {
         this.f.a();
      }
   }

   @Override
   public void d() {
      a.c("Logging session ended");
   }

   public static class Builder {
      private Context a;
      private String b;
      private String c;
      private OrientationTracker.Builder d;
      private BatteryLevelTracker.Builder e;
      private ConnectivityTracker.Builder f;
      private DeviceInfoLoader.Builder g;

      public LiveAgentCasesLogger.Builder a(Context var1) {
         this.a = var1;
         return this;
      }

      public LiveAgentCasesLogger.Builder a(String var1) {
         if (var1.length() > 15) {
            this.c = var1.substring(0, 15);
         } else {
            this.c = var1;
         }

         return this;
      }

      public LiveAgentCasesLogger a() {
         Arguments.a((Context)this.a);
         if (this.b == null) {
            this.b = new UUIDProvider().a().toString();
         }

         if (this.d == null) {
            this.d = new OrientationTracker.Builder().a(this.a);
         }

         if (this.e == null) {
            this.e = new BatteryLevelTracker.Builder().a(this.a);
         }

         if (this.f == null) {
            this.f = new ConnectivityTracker.Builder().a(this.a);
         }

         if (this.g == null) {
            this.g = new DeviceInfoLoader.Builder().a(this.a);
         }

         return new LiveAgentCasesLogger(this);
      }
   }
}
