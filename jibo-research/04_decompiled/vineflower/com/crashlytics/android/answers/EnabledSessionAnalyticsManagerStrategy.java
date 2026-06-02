package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
   final SessionEventMetadata a;
   FilesSender b;
   ApiKey c;
   EventFilter d;
   boolean e;
   boolean f;
   volatile int g;
   private final Kit h;
   private final HttpRequestFactory i;
   private final Context j;
   private final SessionAnalyticsFilesManager k;
   private final ScheduledExecutorService l;
   private final AtomicReference<ScheduledFuture<?>> m = new AtomicReference<>();

   public EnabledSessionAnalyticsManagerStrategy(
      Kit var1, Context var2, ScheduledExecutorService var3, SessionAnalyticsFilesManager var4, HttpRequestFactory var5, SessionEventMetadata var6
   ) {
      this.c = new ApiKey();
      this.d = new KeepAllEventFilter();
      this.e = true;
      this.f = true;
      this.g = -1;
      this.h = var1;
      this.j = var2;
      this.l = var3;
      this.k = var4;
      this.i = var5;
      this.a = var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void a() {
      if (this.b == null) {
         CommonUtils.a(this.j, "skipping files send because we don't yet know the target endpoint");
      } else {
         CommonUtils.a(this.j, "Sending all files");
         List var5 = this.k.e();
         int var1 = 0;

         int var2;
         while (true) {
            var2 = var1;
            int var3 = var1;

            label70: {
               label80: {
                  try {
                     if (var5.size() <= 0) {
                        break;
                     }
                  } catch (Exception var11) {
                     var18 = var11;
                     var1 = var3;
                     break label80;
                  }

                  var3 = var1;

                  try {
                     CommonUtils.a(this.j, String.format(Locale.US, "attempt to send batch of %d files", var5.size()));
                  } catch (Exception var10) {
                     var18 = var10;
                     var1 = var3;
                     break label80;
                  }

                  var3 = var1;

                  boolean var4;
                  try {
                     var4 = this.b.a(var5);
                  } catch (Exception var9) {
                     var18 = var9;
                     var1 = var3;
                     break label80;
                  }

                  var2 = var1;
                  if (var4) {
                     var3 = var1;

                     try {
                        var2 = var5.size();
                     } catch (Exception var8) {
                        var18 = var8;
                        var1 = var3;
                        break label80;
                     }

                     var1 = var2 + var1;

                     try {
                        this.k.a(var5);
                     } catch (Exception var7) {
                        var18 = var7;
                        break label80;
                     }

                     var2 = var1;
                  }

                  if (!var4) {
                     break;
                  }

                  var3 = var2;

                  try {
                     var5 = this.k.e();
                     break label70;
                  } catch (Exception var6) {
                     var18 = var6;
                     var1 = var3;
                  }
               }

               CommonUtils.a(this.j, "Failed to send batch of analytics files to server: " + var18.getMessage(), var18);
               var2 = var1;
               break;
            }

            var1 = var2;
         }

         if (var2 == 0) {
            this.k.g();
         }
      }
   }

   void a(long var1, long var3) {
      boolean var5;
      if (this.m.get() == null) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var5) {
         TimeBasedFileRollOverRunnable var6 = new TimeBasedFileRollOverRunnable(this.j, this);
         CommonUtils.a(this.j, "Scheduling time based file roll over every " + var3 + " seconds");

         try {
            this.m.set(this.l.scheduleAtFixedRate(var6, var1, var3, TimeUnit.SECONDS));
         } catch (RejectedExecutionException var7) {
            CommonUtils.a(this.j, "Failed to schedule time based file roll over", var7);
         }
      }
   }

   @Override
   public void a(SessionEvent.Builder var1) {
      SessionEvent var2 = var1.a(this.a);
      if (!this.e && SessionEvent.Type.CUSTOM.equals(var2.c)) {
         Fabric.h().a("Answers", "Custom events tracking disabled - skipping event: " + var2);
      } else if (!this.f && SessionEvent.Type.PREDEFINED.equals(var2.c)) {
         Fabric.h().a("Answers", "Predefined events tracking disabled - skipping event: " + var2);
      } else if (this.d.a(var2)) {
         Fabric.h().a("Answers", "Skipping filtered event: " + var2);
      } else {
         try {
            this.k.a(var2);
         } catch (IOException var3) {
            Fabric.h().e("Answers", "Failed to write event: " + var2, var3);
         }

         this.e();
      }
   }

   @Override
   public void a(AnalyticsSettingsData var1, String var2) {
      this.b = AnswersRetryFilesSender.a(new SessionAnalyticsFilesSender(this.h, var2, var1.a, this.i, this.c.a(this.j)));
      this.k.a(var1);
      this.e = var1.f;
      Logger var4 = Fabric.h();
      StringBuilder var3 = new StringBuilder().append("Custom event tracking ");
      if (this.e) {
         var2 = "enabled";
      } else {
         var2 = "disabled";
      }

      var4.a("Answers", var3.append(var2).toString());
      this.f = var1.g;
      Logger var7 = Fabric.h();
      StringBuilder var8 = new StringBuilder().append("Predefined event tracking ");
      if (this.f) {
         var2 = "enabled";
      } else {
         var2 = "disabled";
      }

      var7.a("Answers", var8.append(var2).toString());
      if (var1.i > 1) {
         Fabric.h().a("Answers", "Event sampling enabled");
         this.d = new SamplingEventFilter(var1.i);
      }

      this.g = var1.b;
      this.a(0L, this.g);
   }

   @Override
   public void b() {
      this.k.f();
   }

   @Override
   public boolean c() {
      boolean var1;
      try {
         var1 = this.k.d();
      } catch (IOException var3) {
         CommonUtils.a(this.j, "Failed to roll file over.", var3);
         var1 = false;
      }

      return var1;
   }

   @Override
   public void d() {
      if (this.m.get() != null) {
         CommonUtils.a(this.j, "Cancelling time-based rollover because no events are currently being generated.");
         this.m.get().cancel(false);
         this.m.set(null);
      }
   }

   public void e() {
      boolean var1;
      if (this.g != -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (var1) {
         this.a(this.g, this.g);
      }
   }
}
