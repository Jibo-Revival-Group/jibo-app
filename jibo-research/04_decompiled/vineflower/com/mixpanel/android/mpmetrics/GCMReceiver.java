package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import com.mixpanel.android.util.MPLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GCMReceiver extends BroadcastReceiver {
   private Intent a(Context var1, String var2, String var3, String var4, String var5) {
      Uri var7;
      if (var2 != null) {
         var7 = Uri.parse(var2);
      } else {
         var7 = null;
      }

      Intent var6;
      if (var7 == null) {
         var6 = this.a(var1);
      } else {
         var6 = new Intent("android.intent.action.VIEW", var7);
      }

      if (var3 != null) {
         var6.putExtra("mp_campaign_id", var3);
      }

      if (var4 != null) {
         var6.putExtra("mp_message_id", var4);
      }

      if (var5 != null) {
         var6.putExtra("mp", var5);
      }

      return var6;
   }

   private void a(Context var1, Intent var2) {
      String var4 = MPConfig.a(var1).x();
      String var3 = var4;
      if (var4 == null) {
         var3 = var1.getPackageName();
      }

      ResourceReader.Drawables var6 = new ResourceReader.Drawables(var3, var1);
      Notification var5 = this.b(var1.getApplicationContext(), var2, var6);
      if (var5 != null) {
         ((NotificationManager)var1.getSystemService("notification")).notify(0, var5);
      }
   }

   private void a(Intent var1) {
      String var2 = var1.getStringExtra("registration_id");
      if (var1.getStringExtra("error") != null) {
         MPLog.e("MixpanelAPI.GCMReceiver", "Error when registering for GCM: " + var1.getStringExtra("error"));
      } else if (var2 != null) {
         MPLog.b("MixpanelAPI.GCMReceiver", "Registering GCM ID: " + var2);
         MixpanelAPI.a(new MixpanelAPI.InstanceProcessor(this, var2) {
            final String a;
            final GCMReceiver b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void a(MixpanelAPI var1) {
               var1.c().b(this.a);
            }
         });
      } else if (var1.getStringExtra("unregistered") != null) {
         MPLog.b("MixpanelAPI.GCMReceiver", "Unregistering from GCM");
         MixpanelAPI.a(new MixpanelAPI.InstanceProcessor(this) {
            final GCMReceiver a;

            {
               this.a = var1;
            }

            @Override
            public void a(MixpanelAPI var1) {
               var1.c().a();
            }
         });
      }
   }

   private void a(String var1, String var2, String var3) {
      if (var1 != null && var2 != null) {
         MixpanelAPI.a(new MixpanelAPI.InstanceProcessor(this, var3, var1, var2) {
            final String a;
            final String b;
            final String c;
            final GCMReceiver d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4;
            }

            @Override
            public void a(MixpanelAPI var1) {
               if (var1.g()) {
                  JSONObject var2x = new JSONObject();

                  label22: {
                     JSONObject var3x;
                     try {
                        if (this.a == null) {
                           break label22;
                        }

                        var3x = new JSONObject(this.a);
                     } catch (JSONException var5) {
                        break label22;
                     }

                     var2x = var3x;
                  }

                  try {
                     var2x.put("campaign_id", Integer.valueOf(this.b));
                     var2x.put("message_id", Integer.valueOf(this.c));
                     var2x.put("message_type", "push");
                     var1.a("$campaign_received", var2x);
                  } catch (JSONException var4) {
                  }
               }
            }
         });
      }
   }

   private Notification b(Context var1, Intent var2, ResourceIds var3) {
      GCMReceiver.NotificationData var5 = this.a(var1, var2, var3);
      Notification var4;
      if (var5 == null) {
         var4 = null;
      } else {
         MPLog.b("MixpanelAPI.GCMReceiver", "MP GCM notification received: " + var5.e);
         PendingIntent var6 = PendingIntent.getActivity(var1, 0, var5.f, 134217728);
         if (VERSION.SDK_INT >= 26) {
            var4 = this.e(var1, var6, var5);
         } else if (VERSION.SDK_INT >= 21) {
            var4 = this.d(var1, var6, var5);
         } else if (VERSION.SDK_INT >= 16) {
            var4 = this.c(var1, var6, var5);
         } else if (VERSION.SDK_INT >= 11) {
            var4 = this.b(var1, var6, var5);
         } else {
            var4 = this.a(var1, var6, var5);
         }
      }

      return var4;
   }

   @TargetApi(9)
   protected Notification a(Context var1, PendingIntent var2, GCMReceiver.NotificationData var3) {
      NotificationCompat.Builder var5 = new NotificationCompat.Builder(var1)
         .a(var3.a)
         .c(var3.e)
         .a(System.currentTimeMillis())
         .a(var3.d)
         .b(var3.e)
         .a(var2)
         .b(MPConfig.a(var1).r());
      if (var3.b != -1) {
         var5.a(BitmapFactory.decodeResource(var1.getResources(), var3.b));
      }

      Notification var4 = var5.a();
      var4.flags |= 16;
      return var4;
   }

   Intent a(Context var1) {
      return var1.getPackageManager().getLaunchIntentForPackage(var1.getPackageName());
   }

   GCMReceiver.NotificationData a(Context var1, Intent var2, ResourceIds var3) {
      PackageManager var15 = var1.getPackageManager();
      String var11 = var2.getStringExtra("mp_message");
      String var16 = var2.getStringExtra("mp_icnm");
      String var18 = var2.getStringExtra("mp_icnm_l");
      String var17 = var2.getStringExtra("mp_icnm_w");
      String var10 = var2.getStringExtra("mp_cta");
      String var9 = var2.getStringExtra("mp_title");
      String var19 = var2.getStringExtra("mp_color");
      String var13 = var2.getStringExtra("mp_campaign_id");
      String var12 = var2.getStringExtra("mp_message_id");
      String var14 = var2.getStringExtra("mp");
      int var4 = -1;
      this.a(var13, var12, var14);
      int var6 = var4;
      if (var19 != null) {
         try {
            var6 = Color.parseColor(var19);
         } catch (IllegalArgumentException var21) {
            var6 = var4;
         }
      }

      GCMReceiver.NotificationData var22;
      if (var11 == null) {
         var22 = null;
      } else {
         int var5 = -1;
         var4 = var5;
         if (var16 != null) {
            var4 = var5;
            if (var3.a(var16)) {
               var4 = var3.b(var16);
            }
         }

         int var7;
         if (var18 != null && var3.a(var18)) {
            var7 = var3.b(var18);
         } else {
            var7 = -1;
         }

         int var8;
         if (var17 != null && var3.a(var17)) {
            var8 = var3.b(var17);
         } else {
            var8 = -1;
         }

         try {
            var24 = var15.getApplicationInfo(var1.getPackageName(), 0);
         } catch (NameNotFoundException var20) {
            var24 = null;
         }

         var5 = var4;
         if (var4 == -1) {
            var5 = var4;
            if (var24 != null) {
               var5 = var24.icon;
            }
         }

         if (var5 == -1) {
            var5 = 17301651;
         }

         CharSequence var23 = var9;
         if (var9 == null) {
            var23 = var9;
            if (var24 != null) {
               var23 = var15.getApplicationLabel(var24);
            }
         }

         if (var23 == null) {
            var23 = "A message for you";
         }

         var22 = new GCMReceiver.NotificationData(var5, var7, var8, var23, var11, this.a(var1, var10, var13, var12, var14), var6);
      }

      return var22;
   }

   @TargetApi(11)
   protected Notification b(Context var1, PendingIntent var2, GCMReceiver.NotificationData var3) {
      Builder var5 = new Builder(var1)
         .setSmallIcon(var3.a)
         .setTicker(var3.e)
         .setWhen(System.currentTimeMillis())
         .setContentTitle(var3.d)
         .setContentText(var3.e)
         .setContentIntent(var2)
         .setDefaults(MPConfig.a(var1).r());
      if (var3.b != -1) {
         var5.setLargeIcon(BitmapFactory.decodeResource(var1.getResources(), var3.b));
      }

      Notification var4 = var5.getNotification();
      var4.flags |= 16;
      return var4;
   }

   @SuppressLint("NewApi")
   @TargetApi(16)
   protected Notification c(Context var1, PendingIntent var2, GCMReceiver.NotificationData var3) {
      Builder var5 = new Builder(var1)
         .setSmallIcon(var3.a)
         .setTicker(var3.e)
         .setWhen(System.currentTimeMillis())
         .setContentTitle(var3.d)
         .setContentText(var3.e)
         .setContentIntent(var2)
         .setStyle(new BigTextStyle().bigText(var3.e))
         .setDefaults(MPConfig.a(var1).r());
      if (var3.b != -1) {
         var5.setLargeIcon(BitmapFactory.decodeResource(var1.getResources(), var3.b));
      }

      Notification var4 = var5.build();
      var4.flags |= 16;
      return var4;
   }

   @SuppressLint("NewApi")
   @TargetApi(21)
   protected Notification d(Context var1, PendingIntent var2, GCMReceiver.NotificationData var3) {
      Builder var5 = new Builder(var1)
         .setTicker(var3.e)
         .setWhen(System.currentTimeMillis())
         .setContentTitle(var3.d)
         .setContentText(var3.e)
         .setContentIntent(var2)
         .setStyle(new BigTextStyle().bigText(var3.e))
         .setDefaults(MPConfig.a(var1).r());
      if (var3.c != -1) {
         var5.setSmallIcon(var3.c);
      } else {
         var5.setSmallIcon(var3.a);
      }

      if (var3.b != -1) {
         var5.setLargeIcon(BitmapFactory.decodeResource(var1.getResources(), var3.b));
      }

      if (var3.g != -1) {
         var5.setColor(var3.g);
      }

      Notification var4 = var5.build();
      var4.flags |= 16;
      return var4;
   }

   @SuppressLint("NewApi")
   @TargetApi(26)
   protected Notification e(Context var1, PendingIntent var2, GCMReceiver.NotificationData var3) {
      NotificationManager var6 = (NotificationManager)var1.getSystemService("notification");
      String var5 = MPConfig.a(var1).u();
      NotificationChannel var7 = new NotificationChannel(var5, MPConfig.a(var1).v(), MPConfig.a(var1).w());
      int var4 = MPConfig.a(var1).r();
      if (var4 == 2 || var4 == -1) {
         var7.enableVibration(true);
      }

      if (var4 == 4 || var4 == -1) {
         var7.enableLights(true);
         var7.setLightColor(-1);
      }

      var6.createNotificationChannel(var7);
      Builder var9 = new Builder(var1)
         .setTicker(var3.e)
         .setWhen(System.currentTimeMillis())
         .setContentTitle(var3.d)
         .setContentText(var3.e)
         .setContentIntent(var2)
         .setStyle(new BigTextStyle().bigText(var3.e))
         .setChannelId(var5);
      if (var3.c != -1) {
         var9.setSmallIcon(var3.c);
      } else {
         var9.setSmallIcon(var3.a);
      }

      if (var3.b != -1) {
         var9.setLargeIcon(BitmapFactory.decodeResource(var1.getResources(), var3.b));
      }

      if (var3.g != -1) {
         var9.setColor(var3.g);
      }

      Notification var8 = var9.build();
      var8.flags |= 16;
      return var8;
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if ("com.google.android.c2dm.intent.REGISTRATION".equals(var3)) {
         this.a(var2);
      } else if ("com.google.android.c2dm.intent.RECEIVE".equals(var3)) {
         this.a(var1, var2);
      }
   }

   protected static class NotificationData {
      public final int a;
      public final int b;
      public final int c;
      public final CharSequence d;
      public final String e;
      public final Intent f;
      public final int g;

      private NotificationData(int var1, int var2, int var3, CharSequence var4, String var5, Intent var6, int var7) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
      }
   }
}
