package com.salesforce.android.cases.ui.internal.client;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.CaseClient;
import com.salesforce.android.cases.core.NotificationHandler;
import com.salesforce.android.cases.core.internal.local.DbUtils;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.CaseUIConfiguration;
import com.salesforce.android.cases.ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity;
import com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedPresenterProvider;
import com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity;
import com.salesforce.android.cases.ui.internal.features.caselist.CaseListPresenterProvider;
import com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity;
import com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherPresenterProvider;
import com.salesforce.android.cases.ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.ui.internal.features.shared.manager.PresenterManager;
import com.salesforce.android.cases.ui.internal.logging.LiveAgentCasesLogger;
import com.salesforce.android.service.common.analytics.ServiceAnalytics;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationManager;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.Random;

public class CaseUIClientImpl implements NotificationHandler, CaseUIClient {
   private final CaseUIConfiguration a;
   private final CaseClient b;
   private final PresenterManager c;
   private final ActivityTracker d;
   private final NotificationManager e;
   private final NotificationChannel f;
   private final SalesforceNotificationBuilder.Builder g;

   private CaseUIClientImpl(Context var1, CaseUIConfiguration var2, CaseClient var3, PresenterManager var4, SalesforceNotificationBuilder.Builder var5) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = new ActivityTracker();
      this.f = new SalesforceNotificationChannel(
         var1.getString(R.string.case_notification_channel_id), var1.getString(R.string.case_notification_channel_name), var2.a()
      );
      this.e = SalesforceNotificationManager.a(var1);
      this.e.a(this.f);
      this.g = var5;
      if (var1 instanceof Application) {
         LiveAgentCasesLogger.Builder var6 = new LiveAgentCasesLogger.Builder().a(var1.getApplicationContext());
         if (SalesforceSDKManager.a().o() != null && SalesforceSDKManager.a().o().b() != null) {
            var6.a(SalesforceSDKManager.a().o().b().f());
         }

         LiveAgentCasesLogger var7 = var6.a();
         ServiceAnalytics.a(var7);
         this.d.a(var1.getApplicationContext());
         this.d.a(new ActivityTracker.OnStartListener(this, var7) {
            final LiveAgentCasesLogger a;
            final CaseUIClientImpl b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void a(Activity var1) {
               if (var1 instanceof CasesSdkActivity) {
                  this.a.a();
               }
            }
         });
         this.d.a(new ActivityTracker.OnStopListener(this, var7) {
            final LiveAgentCasesLogger a;
            final CaseUIClientImpl b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Activity var1) {
               if (!(this.b.d.b() instanceof CasesSdkActivity)) {
                  this.a.b();
               }
            }
         });
      }
   }

   private int a(String var1) {
      int var2;
      if (var1 == null) {
         var2 = new Random().nextInt();
      } else {
         var2 = var1.hashCode();
      }

      return var2;
   }

   public static CaseUIClientImpl a(Context var0, CaseUIConfiguration var1, CaseClient var2) {
      return new CaseUIClientImpl(
         var0,
         var1,
         var2,
         PresenterManager.a(new CasePublisherPresenterProvider(), new CaseListPresenterProvider(), new CaseFeedPresenterProvider()),
         new SalesforceNotificationBuilder.Builder()
      );
   }

   @Override
   public CaseClient a() {
      return this.b;
   }

   @Override
   public void a(Context var1) {
      if (this.e()) {
         this.c(var1);
      } else {
         this.b(var1);
      }
   }

   @Override
   public void a(Context var1, PushNotification var2) {
      String var4 = this.b();
      String var6 = this.d();
      String var5 = this.c();
      String var3;
      if (this.e()) {
         var3 = "authenticated";
      } else {
         var3 = "guest";
      }

      CasesUIAnalyticsEmit.a(var4, var6, var5, var3, "agent", var2.a());
      Intent var8 = new Intent(var1, CaseListActivity.class);
      var8.addFlags(335544320);
      PendingIntent var9 = PendingIntent.getActivity(var1, 0, var8, 1073741824);
      NotificationBuilder var7 = this.g
         .a(this.f)
         .a(var1)
         .a(var2.b())
         .a(this.a.c().g())
         .b(-1)
         .a(new NotificationCompat.BigTextStyle().b(var2.b()))
         .a(true)
         .c(this.a.b())
         .a(var9);
      this.e.a(this.a(var2.a()), var7.a());
   }

   @Override
   public void a(Context var1, String var2) {
      CaseFeedActivity.a(var1, var2);
   }

   @Override
   public void a(PushNotification var1) {
      String var5 = this.b();
      String var3 = this.d();
      String var4 = this.c();
      String var2;
      if (this.e()) {
         var2 = "authenticated";
      } else {
         var2 = "guest";
      }

      CasesUIAnalyticsEmit.b(var5, var3, var4, var2, var1.a(), var1.b());
   }

   @Override
   public String b() {
      return this.a.c().a();
   }

   @Override
   public void b(Context var1) {
      CasePublisherActivity.a(var1);
   }

   @Override
   public String c() {
      return this.a.c().b();
   }

   public void c(Context var1) {
      CaseListActivity.a(var1);
   }

   @Override
   public String d() {
      return this.a.c().c();
   }

   @Override
   public boolean e() {
      return DbUtils.a(this.a.c().i());
   }

   @Override
   public void f() {
      this.d.a();
   }

   public PresenterManager g() {
      return this.c;
   }
}
