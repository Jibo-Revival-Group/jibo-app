package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;

public class SalesforceNotificationBuilder implements NotificationBuilder {
   private final NotificationCompat.Builder a;

   protected SalesforceNotificationBuilder(NotificationCompat.Builder var1) {
      this.a = var1;
   }

   @Override
   public Notification a() {
      return this.a.b();
   }

   @Override
   public NotificationBuilder a(int var1) {
      this.a.a(var1);
      return this;
   }

   @Override
   public NotificationBuilder a(PendingIntent var1) {
      this.a.a(var1);
      return this;
   }

   @Override
   public NotificationBuilder a(NotificationCompat.Style var1) {
      this.a.a(var1);
      return this;
   }

   public NotificationBuilder a(CharSequence var1) {
      this.a.b(var1);
      return this;
   }

   @Override
   public NotificationBuilder a(boolean var1) {
      this.a.a(var1);
      return this;
   }

   @Override
   public NotificationBuilder b(int var1) {
      this.a.b(var1);
      return this;
   }

   @Override
   public NotificationBuilder c(int var1) {
      this.a.c(var1);
      return this;
   }

   public static class Builder {
      private NotificationCompat.Builder a;
      private String b;

      public SalesforceNotificationBuilder.Builder a(NotificationChannel var1) {
         if (var1 != null) {
            this.b = var1.a();
         }

         return this;
      }

      public SalesforceNotificationBuilder a(Context var1) {
         if (this.b == null && VERSION.SDK_INT >= 26) {
            this.b = "miscellaneous";
         }

         if (this.a == null) {
            this.a = new NotificationCompat.Builder(var1, this.b);
         }

         return new SalesforceNotificationBuilder(this.a);
      }
   }
}
