package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationManagerCompat;

public class SalesforceNotificationManager implements NotificationManager {
   private NotificationManagerCompat a;
   private android.app.NotificationManager b;

   private SalesforceNotificationManager(Context var1) {
      this.a = NotificationManagerCompat.a(var1);
      this.b = (android.app.NotificationManager)var1.getSystemService("notification");
   }

   public static SalesforceNotificationManager a(Context var0) {
      return new SalesforceNotificationManager(var0);
   }

   @Override
   public void a(int var1, Notification var2) {
      this.a.a(var1, var2);
   }

   @Override
   public void a(NotificationChannel var1) {
      if (VERSION.SDK_INT >= 26) {
         this.b.createNotificationChannel(var1.b());
      }
   }
}
