package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.util.zzq;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zza {
   static zza a;
   private final Context b;
   private String c;
   private final AtomicInteger d = new AtomicInteger((int)SystemClock.elapsedRealtime());

   private zza(Context var1) {
      this.b = var1.getApplicationContext();
   }

   private final Bundle a() {
      ApplicationInfo var1 = null;

      label22: {
         ApplicationInfo var2;
         try {
            var2 = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128);
         } catch (NameNotFoundException var3) {
            break label22;
         }

         var1 = var2;
      }

      Bundle var4;
      if (var1 != null && var1.metaData != null) {
         var4 = var1.metaData;
      } else {
         var4 = Bundle.EMPTY;
      }

      return var4;
   }

   static zza a(Context var0) {
      synchronized (zza.class) {
         if (a == null) {
            zza var1 = new zza(var0);
            a = var1;
         }

         return a;
      }
   }

   static String a(Bundle var0, String var1) {
      String var3 = var0.getString(var1);
      String var2 = var3;
      if (var3 == null) {
         var2 = var0.getString(var1.replace("gcm.n.", "gcm.notification."));
      }

      return var2;
   }

   static void a(Bundle var0) {
      Bundle var3 = new Bundle();
      Iterator var4 = var0.keySet().iterator();

      while (var4.hasNext()) {
         String var2 = (String)var4.next();
         String var5 = var0.getString(var2);
         String var1 = var2;
         if (var2.startsWith("gcm.notification.")) {
            var1 = var2.replace("gcm.notification.", "gcm.n.");
         }

         if (var1.startsWith("gcm.n.")) {
            if (!"gcm.n.e".equals(var1)) {
               var3.putString(var1.substring(6), var5);
            }

            var4.remove();
         }
      }

      String var6 = var3.getString("sound2");
      if (var6 != null) {
         var3.remove("sound2");
         var3.putString("sound", var6);
      }

      if (!var3.isEmpty()) {
         var0.putBundle("notification", var3);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final String b(Bundle var1, String var2) {
      String var5 = a(var1, var2);
      String var15;
      if (!TextUtils.isEmpty(var5)) {
         var15 = var5;
      } else {
         var5 = String.valueOf(var2);
         String var6 = String.valueOf("_loc_key");
         if (var6.length() != 0) {
            var5 = var5.concat(var6);
         } else {
            var5 = new String(var5);
         }

         var6 = a(var1, var5);
         if (TextUtils.isEmpty(var6)) {
            var15 = null;
         } else {
            Resources var7 = this.b.getResources();
            int var4 = var7.getIdentifier(var6, "string", this.b.getPackageName());
            if (var4 == 0) {
               String var16 = String.valueOf(var2);
               var2 = String.valueOf("_loc_key");
               String var17;
               if (var2.length() != 0) {
                  var17 = var16.concat(var2);
               } else {
                  var17 = new String(var16);
               }

               String var18 = var17.substring(6);
               Log.w(
                  "GcmNotification",
                  new StringBuilder(String.valueOf(var18).length() + 49 + String.valueOf(var6).length())
                     .append(var18)
                     .append(" resource not found: ")
                     .append(var6)
                     .append(" Default value will be used.")
                     .toString()
               );
               var15 = null;
            } else {
               var5 = String.valueOf(var2);
               String var8 = String.valueOf("_loc_args");
               if (var8.length() != 0) {
                  var5 = var5.concat(var8);
               } else {
                  var5 = new String(var5);
               }

               var5 = a(var1, var5);
               if (TextUtils.isEmpty(var5)) {
                  var15 = var7.getString(var4);
               } else {
                  label73: {
                     label72: {
                        label71: {
                           label82: {
                              try {
                                 var31 = new JSONArray(var5);
                                 var20 = new String[var31.length()];
                              } catch (JSONException var13) {
                                 var19 = String.valueOf(var2);
                                 var2 = String.valueOf("_loc_args");
                                 if (var2.length() != 0) {
                                    break label71;
                                 }
                                 break label82;
                              } catch (MissingFormatArgumentException var14) {
                                 Log.w(
                                    "GcmNotification",
                                    new StringBuilder(String.valueOf(var6).length() + 58 + String.valueOf(var5).length())
                                       .append("Missing format argument for ")
                                       .append(var6)
                                       .append(": ")
                                       .append(var5)
                                       .append(" Default value will be used.")
                                       .toString(),
                                    var14
                                 );
                                 break label73;
                              }

                              int var3 = 0;

                              while (true) {
                                 try {
                                    if (var3 >= var20.length) {
                                       break;
                                    }

                                    var20[var3] = (String)var31.opt(var3);
                                 } catch (JSONException var11) {
                                    var19 = String.valueOf(var2);
                                    var2 = String.valueOf("_loc_args");
                                    if (var2.length() != 0) {
                                       break label71;
                                    }
                                    break label82;
                                 } catch (MissingFormatArgumentException var12) {
                                    Log.w(
                                       "GcmNotification",
                                       new StringBuilder(String.valueOf(var6).length() + 58 + String.valueOf(var5).length())
                                          .append("Missing format argument for ")
                                          .append(var6)
                                          .append(": ")
                                          .append(var5)
                                          .append(" Default value will be used.")
                                          .toString(),
                                       var12
                                    );
                                    break label73;
                                 }

                                 var3++;
                              }

                              try {
                                 String var32 = var7.getString(var4, var20);
                                 return var32;
                              } catch (JSONException var9) {
                                 var19 = String.valueOf(var2);
                                 var2 = String.valueOf("_loc_args");
                                 if (var2.length() != 0) {
                                    break label71;
                                 }
                              } catch (MissingFormatArgumentException var10) {
                                 Log.w(
                                    "GcmNotification",
                                    new StringBuilder(String.valueOf(var6).length() + 58 + String.valueOf(var5).length())
                                       .append("Missing format argument for ")
                                       .append(var6)
                                       .append(": ")
                                       .append(var5)
                                       .append(" Default value will be used.")
                                       .toString(),
                                    var10
                                 );
                                 break label73;
                              }
                           }

                           var21 = new String(var19);
                           break label72;
                        }

                        var21 = var19.concat(var2);
                     }

                     String var22 = var21.substring(6);
                     Log.w(
                        "GcmNotification",
                        new StringBuilder(String.valueOf(var22).length() + 41 + String.valueOf(var5).length())
                           .append("Malformed ")
                           .append(var22)
                           .append(": ")
                           .append(var5)
                           .append("  Default value will be used.")
                           .toString()
                     );
                  }

                  var15 = null;
               }
            }
         }
      }

      return var15;
   }

   static boolean b(Context var0) {
      boolean var2;
      if (((KeyguardManager)var0.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
         var2 = false;
      } else {
         int var1 = Process.myPid();
         List var4 = ((ActivityManager)var0.getSystemService("activity")).getRunningAppProcesses();
         if (var4 != null) {
            for (RunningAppProcessInfo var5 : var4) {
               if (var5.pid == var1) {
                  if (var5.importance == 100) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  return var2;
               }
            }
         }

         var2 = false;
      }

      return var2;
   }

   private final PendingIntent c(Bundle var1) {
      String var2 = a(var1, "gcm.n.click_action");
      Intent var7;
      if (!TextUtils.isEmpty(var2)) {
         var7 = new Intent(var2);
         var7.setPackage(this.b.getPackageName());
         var7.setFlags(268435456);
      } else {
         var7 = this.b.getPackageManager().getLaunchIntentForPackage(this.b.getPackageName());
         if (var7 == null) {
            Log.w("GcmNotification", "No activity found to launch app");
            return null;
         }
      }

      var1 = new Bundle(var1);
      GcmListenerService.a(var1);
      var7.putExtras(var1);

      for (String var3 : var1.keySet()) {
         if (var3.startsWith("gcm.n.") || var3.startsWith("gcm.notification.")) {
            var7.removeExtra(var3);
         }
      }

      return PendingIntent.getActivity(this.b, this.d.getAndIncrement(), var7, 1073741824);
   }

   final boolean b(Bundle var1) {
      String var6 = null;
      CharSequence var8 = this.b(var1, "gcm.n.title");
      if (TextUtils.isEmpty(var8)) {
         var8 = this.b.getApplicationInfo().loadLabel(this.b.getPackageManager());
      }

      int var2;
      String var10;
      label127: {
         var10 = this.b(var1, "gcm.n.body");
         String var7 = a(var1, "gcm.n.icon");
         if (!TextUtils.isEmpty(var7)) {
            Resources var9 = this.b.getResources();
            var2 = var9.getIdentifier(var7, "drawable", this.b.getPackageName());
            if (var2 != 0) {
               break label127;
            }

            var2 = var9.getIdentifier(var7, "mipmap", this.b.getPackageName());
            if (var2 != 0) {
               break label127;
            }

            Log.w(
               "GcmNotification",
               new StringBuilder(String.valueOf(var7).length() + 57)
                  .append("Icon resource ")
                  .append(var7)
                  .append(" not found. Notification will use app icon.")
                  .toString()
            );
         }

         int var3 = this.b.getApplicationInfo().icon;
         var2 = var3;
         if (var3 == 0) {
            var2 = 17301651;
         }
      }

      String var11 = a(var1, "gcm.n.color");
      String var17 = a(var1, "gcm.n.sound2");
      Uri var18;
      if (TextUtils.isEmpty(var17)) {
         var18 = null;
      } else if (!"default".equals(var17) && this.b.getResources().getIdentifier(var17, "raw", this.b.getPackageName()) != 0) {
         String var21 = this.b.getPackageName();
         var18 = Uri.parse(
            new StringBuilder(String.valueOf("android.resource://").length() + 5 + String.valueOf(var21).length() + String.valueOf(var17).length())
               .append("android.resource://")
               .append(var21)
               .append("/raw/")
               .append(var17)
               .toString()
         );
      } else {
         var18 = RingtoneManager.getDefaultUri(2);
      }

      PendingIntent var12 = this.c(var1);
      Notification var15;
      if (zzq.h() && this.b.getApplicationInfo().targetSdkVersion > 25) {
         String var22 = a(var1, "gcm.n.android_channel_id");
         label107:
         if (zzq.h()) {
            NotificationManager var16 = (NotificationManager)this.b.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(var22)) {
               if (var16.getNotificationChannel(var22) != null) {
                  var6 = var22;
                  break label107;
               }

               Log.w(
                  "GcmNotification",
                  new StringBuilder(String.valueOf(var22).length() + 122)
                     .append("Notification Channel requested (")
                     .append(var22)
                     .append(") has not been created by the app. Manifest configuration, or default, value will be used.")
                     .toString()
               );
            }

            if (this.c != null) {
               var6 = this.c;
            } else {
               label136: {
                  this.c = this.a().getString("com.google.android.gms.gcm.default_notification_channel_id");
                  if (!TextUtils.isEmpty(this.c)) {
                     if (var16.getNotificationChannel(this.c) != null) {
                        var6 = this.c;
                        break label136;
                     }

                     Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                  } else {
                     Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                  }

                  if (var16.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                     var16.createNotificationChannel(
                        new NotificationChannel("fcm_fallback_notification_channel", this.b.getString(R.string.gcm_fallback_notification_channel_label), 3)
                     );
                  }

                  this.c = "fcm_fallback_notification_channel";
                  var6 = this.c;
               }
            }
         }

         Builder var23 = new Builder(this.b).setAutoCancel(true).setSmallIcon(var2);
         if (!TextUtils.isEmpty(var8)) {
            var23.setContentTitle(var8);
         }

         if (!TextUtils.isEmpty(var10)) {
            var23.setContentText(var10);
            var23.setStyle(new BigTextStyle().bigText(var10));
         }

         if (!TextUtils.isEmpty(var11)) {
            var23.setColor(Color.parseColor(var11));
         }

         if (var18 != null) {
            var23.setSound(var18);
         }

         if (var12 != null) {
            var23.setContentIntent(var12);
         }

         if (var6 != null) {
            var23.setChannelId(var6);
         }

         var15 = var23.build();
      } else {
         NotificationCompat.Builder var14 = new NotificationCompat.Builder(this.b).a(true).a(var2);
         if (!TextUtils.isEmpty(var8)) {
            var14.a(var8);
         }

         if (!TextUtils.isEmpty(var10)) {
            var14.b(var10);
         }

         if (!TextUtils.isEmpty(var11)) {
            var14.d(Color.parseColor(var11));
         }

         if (var18 != null) {
            var14.a(var18);
         }

         if (var12 != null) {
            var14.a(var12);
         }

         var15 = var14.b();
      }

      var17 = a(var1, "gcm.n.tag");
      if (Log.isLoggable("GcmNotification", 3)) {
         Log.d("GcmNotification", "Showing notification");
      }

      NotificationManager var20 = (NotificationManager)this.b.getSystemService("notification");
      String var13 = var17;
      if (TextUtils.isEmpty(var17)) {
         long var4 = SystemClock.uptimeMillis();
         var13 = new StringBuilder(37).append("GCM-Notification:").append(var4).toString();
      }

      var20.notify(var13, 0, var15);
      return true;
   }
}
