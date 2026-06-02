package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class AnswersEventsHandler implements EventsStorageListener {
   final ScheduledExecutorService a;
   SessionAnalyticsManagerStrategy b = new DisabledSessionAnalyticsManagerStrategy();
   private final Kit c;
   private final Context d;
   private final AnswersFilesManagerProvider e;
   private final SessionMetadataCollector f;
   private final HttpRequestFactory g;

   public AnswersEventsHandler(
      Kit var1, Context var2, AnswersFilesManagerProvider var3, SessionMetadataCollector var4, HttpRequestFactory var5, ScheduledExecutorService var6
   ) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var4;
      this.g = var5;
      this.a = var6;
   }

   private void a(Runnable var1) {
      try {
         this.a.submit(var1).get();
      } catch (Exception var2) {
         Fabric.h().e("Answers", "Failed to run events task", var2);
      }
   }

   private void b(Runnable var1) {
      try {
         this.a.submit(var1);
      } catch (Exception var2) {
         Fabric.h().e("Answers", "Failed to submit events task", var2);
      }
   }

   public void a() {
      this.b(new Runnable(this) {
         final AnswersEventsHandler a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            try {
               SessionAnalyticsManagerStrategy var2 = this.a.b;
               AnswersEventsHandler var3 = this.a;
               DisabledSessionAnalyticsManagerStrategy var1 = new DisabledSessionAnalyticsManagerStrategy();
               var3.b = var1;
               var2.b();
            } catch (Exception var4) {
               Fabric.h().e("Answers", "Failed to disable events", var4);
            }
         }
      });
   }

   public void a(SessionEvent.Builder var1) {
      this.a(var1, false, false);
   }

   void a(SessionEvent.Builder var1, boolean var2, boolean var3) {
      Runnable var4 = new Runnable(this, var1, var3) {
         final SessionEvent.Builder a;
         final boolean b;
         final AnswersEventsHandler c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public void run() {
            try {
               this.c.b.a(this.a);
               if (this.b) {
                  this.c.b.c();
               }
            } catch (Exception var2x) {
               Fabric.h().e("Answers", "Failed to process event", var2x);
            }
         }
      };
      if (var2) {
         this.a(var4);
      } else {
         this.b(var4);
      }
   }

   public void a(AnalyticsSettingsData var1, String var2) {
      this.b(new Runnable(this, var1, var2) {
         final AnalyticsSettingsData a;
         final String b;
         final AnswersEventsHandler c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         @Override
         public void run() {
            try {
               this.c.b.a(this.a, this.b);
            } catch (Exception var2x) {
               Fabric.h().e("Answers", "Failed to set analytics settings data", var2x);
            }
         }
      });
   }

   @Override
   public void a(String var1) {
      this.b(new Runnable(this) {
         final AnswersEventsHandler a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            try {
               this.a.b.a();
            } catch (Exception var2) {
               Fabric.h().e("Answers", "Failed to send events files", var2);
            }
         }
      });
   }

   public void b() {
      this.b(new Runnable(this) {
         final AnswersEventsHandler a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            try {
               SessionEventMetadata var3 = this.a.f.a();
               SessionAnalyticsFilesManager var1 = this.a.e.a();
               var1.a(this.a);
               AnswersEventsHandler var4 = this.a;
               EnabledSessionAnalyticsManagerStrategy var2 = new EnabledSessionAnalyticsManagerStrategy(this.a.c, this.a.d, this.a.a, var1, this.a.g, var3);
               var4.b = var2;
            } catch (Exception var5) {
               Fabric.h().e("Answers", "Failed to enable events", var5);
            }
         }
      });
   }

   public void b(SessionEvent.Builder var1) {
      this.a(var1, false, true);
   }

   public void c() {
      this.b(new Runnable(this) {
         final AnswersEventsHandler a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            try {
               this.a.b.c();
            } catch (Exception var2) {
               Fabric.h().e("Answers", "Failed to flush events", var2);
            }
         }
      });
   }

   public void c(SessionEvent.Builder var1) {
      this.a(var1, true, false);
   }
}
