package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.annotation.TargetApi;
import android.os.Build.VERSION;

public class SalesforceNotificationChannel implements NotificationChannel {
   private NotificationChannel a;

   public SalesforceNotificationChannel(String var1, CharSequence var2, int var3) {
      if (VERSION.SDK_INT >= 26) {
         this.a = new SalesforceNotificationChannel.OreoNotificationChannel(var1, var2, var3);
      } else {
         this.a = new SalesforceNotificationChannel.CompatNotificationChannel();
      }
   }

   @Override
   public String a() {
      return this.a.a();
   }

   @Override
   public android.app.NotificationChannel b() {
      return this.a.b();
   }

   protected static class CompatNotificationChannel implements NotificationChannel {
      @Override
      public String a() {
         return "";
      }

      @Override
      public android.app.NotificationChannel b() {
         throw new IllegalStateException("Notification Channels are not supported by this version of Android.");
      }
   }

   @TargetApi(26)
   protected static class OreoNotificationChannel implements NotificationChannel {
      private android.app.NotificationChannel a;

      OreoNotificationChannel(String var1, CharSequence var2, int var3) {
         this.a = new android.app.NotificationChannel(var1, var2, var3);
      }

      @Override
      public String a() {
         return this.a.getId();
      }

      @Override
      public android.app.NotificationChannel b() {
         return this.a;
      }
   }
}
