package com.jibo.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;

public class ServiceUtils {
   private static String a(Context var0) {
      String var2;
      if (VERSION.SDK_INT >= 26) {
         NotificationChannel var1 = new NotificationChannel("my_service", "My Background Service", 0);
         var1.setLightColor(-16776961);
         var1.setLockscreenVisibility(0);
         ((NotificationManager)var0.getSystemService("notification")).createNotificationChannel(var1);
         var2 = "my_service";
      } else {
         var2 = "";
      }

      return var2;
   }

   public static void a(Service var0) {
      var0.startForeground(1, new NotificationCompat.Builder(var0, a(var0)).b());
   }

   public static void a(Context var0, Intent var1) {
      if (VERSION.SDK_INT >= 26) {
         var0.startForegroundService(var1);
      } else {
         var0.startService(var1);
      }
   }

   public static void b(Service var0) {
      var0.stopForeground(true);
   }
}
