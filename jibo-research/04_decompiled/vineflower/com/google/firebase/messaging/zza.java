package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
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
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.util.zzq;
import com.google.firebase.iid.zzx;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zza {
   private static zza a;
   private final Context b;
   private Bundle c;
   private Method d;
   private Method e;
   private final AtomicInteger f = new AtomicInteger((int)SystemClock.elapsedRealtime());

   private zza(Context var1) {
      this.b = var1.getApplicationContext();
   }

   @TargetApi(26)
   private final Notification a(CharSequence var1, String var2, int var3, Integer var4, Uri var5, PendingIntent var6, PendingIntent var7, String var8) {
      Builder var9 = new Builder(this.b).setAutoCancel(true).setSmallIcon(var3);
      if (!TextUtils.isEmpty(var1)) {
         var9.setContentTitle(var1);
      }

      if (!TextUtils.isEmpty(var2)) {
         var9.setContentText(var2);
         var9.setStyle(new BigTextStyle().bigText(var2));
      }

      if (var4 != null) {
         var9.setColor(var4);
      }

      if (var5 != null) {
         var9.setSound(var5);
      }

      if (var6 != null) {
         var9.setContentIntent(var6);
      }

      if (var7 != null) {
         var9.setDeleteIntent(var7);
      }

      if (var8 != null) {
         if (this.d == null) {
            this.d = a("setChannelId");
         }

         if (this.d == null) {
            this.d = a("setChannel");
         }

         if (this.d == null) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel");
         } else {
            try {
               this.d.invoke(var9, var8);
            } catch (IllegalAccessException var10) {
               Log.e("FirebaseMessaging", "Error while setting the notification channel", var10);
            } catch (InvocationTargetException var11) {
               Log.e("FirebaseMessaging", "Error while setting the notification channel", var11);
            } catch (SecurityException var12) {
               Log.e("FirebaseMessaging", "Error while setting the notification channel", var12);
            } catch (IllegalArgumentException var13) {
               Log.e("FirebaseMessaging", "Error while setting the notification channel", var13);
            }
         }
      }

      return var9.build();
   }

   private final Bundle a() {
      Bundle var1;
      if (this.c != null) {
         var1 = this.c;
      } else {
         ApplicationInfo var4 = null;

         label23: {
            ApplicationInfo var2;
            try {
               var2 = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128);
            } catch (NameNotFoundException var3) {
               break label23;
            }

            var4 = var2;
         }

         if (var4 != null && var4.metaData != null) {
            this.c = var4.metaData;
            var1 = this.c;
         } else {
            var1 = Bundle.EMPTY;
         }
      }

      return var1;
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

   @TargetApi(26)
   private static Method a(String var0) {
      try {
         return Builder.class.getMethod(var0, String.class);
      } catch (NoSuchMethodException var1) {
      } catch (SecurityException var2) {
      }

      return null;
   }

   private static void a(Intent var0, Bundle var1) {
      for (String var3 : var1.keySet()) {
         if (var3.startsWith("google.c.a.") || var3.equals("from")) {
            var0.putExtra(var3, var1.getString(var3));
         }
      }
   }

   @TargetApi(26)
   private final boolean a(int var1) {
      boolean var2 = true;
      if (VERSION.SDK_INT == 26) {
         try {
            Drawable var3 = this.b.getResources().getDrawable(var1, null);
            if (var3.getBounds().height() != 0 && var3.getBounds().width() != 0) {
               return var2;
            }

            StringBuilder var5 = new StringBuilder(72);
            Log.e("FirebaseMessaging", var5.append("Icon with id: ").append(var1).append(" uses an invalid gradient. Using fallback icon.").toString());
         } catch (NotFoundException var4) {
            var2 = false;
            return var2;
         }

         var2 = false;
      }

      return var2;
   }

   static boolean a(Bundle var0) {
      boolean var1;
      if (!"1".equals(a(var0, "gcm.n.e")) && a(var0, "gcm.n.icon") == null) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   static Uri b(Bundle var0) {
      String var2 = a(var0, "gcm.n.link_android");
      String var1 = var2;
      if (TextUtils.isEmpty(var2)) {
         var1 = a(var0, "gcm.n.link");
      }

      Uri var3;
      if (!TextUtils.isEmpty(var1)) {
         var3 = Uri.parse(var1);
      } else {
         var3 = null;
      }

      return var3;
   }

   private final Integer b(String var1) {
      Object var3 = null;
      Integer var7;
      if (VERSION.SDK_INT < 21) {
         var7 = (Integer)var3;
      } else {
         label26:
         if (!TextUtils.isEmpty(var1)) {
            int var9;
            try {
               var9 = Color.parseColor(var1);
            } catch (IllegalArgumentException var6) {
               Log.w(
                  "FirebaseMessaging",
                  new StringBuilder(String.valueOf(var1).length() + 54)
                     .append("Color ")
                     .append(var1)
                     .append(" not valid. Notification will use default color.")
                     .toString()
               );
               break label26;
            }

            Integer var11 = var9;
            return var11;
         }

         int var2 = this.a().getInt("com.google.firebase.messaging.default_notification_color", 0);
         var7 = (Integer)var3;
         if (var2 != 0) {
            try {
               var2 = ContextCompat.c(this.b, var2);
            } catch (NotFoundException var5) {
               Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
               Object var10 = var3;
               return (Integer)var10;
            }

            var7 = var2;
         }
      }

      return var7;
   }

   static String b(Bundle var0, String var1) {
      var1 = String.valueOf(var1);
      String var2 = String.valueOf("_loc_key");
      if (var2.length() != 0) {
         var1 = var1.concat(var2);
      } else {
         var1 = new String(var1);
      }

      return a(var0, var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @TargetApi(26)
   private final String c(String var1) {
      String var3;
      if (!zzq.h()) {
         var3 = null;
      } else {
         NotificationManager var4 = (NotificationManager)this.b.getSystemService(NotificationManager.class);

         label185: {
            label177: {
               try {
                  if (this.e == null) {
                     this.e = var4.getClass().getMethod("getNotificationChannel", String.class);
                  }
               } catch (InstantiationException var53) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var53);
                  break label177;
               } catch (InvocationTargetException var54) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var54);
                  break label177;
               } catch (NoSuchMethodException var55) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var55);
                  break label177;
               } catch (IllegalAccessException var56) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var56);
                  break label177;
               } catch (ClassNotFoundException var57) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var57);
                  break label177;
               } catch (SecurityException var58) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var58);
                  break label177;
               } catch (IllegalArgumentException var59) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var59);
                  break label177;
               } catch (LinkageError var60) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var60);
                  break label177;
               }

               label178: {
                  try {
                     if (TextUtils.isEmpty(var1)) {
                        break label178;
                     }
                  } catch (InstantiationException var45) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var45);
                     break label177;
                  } catch (InvocationTargetException var46) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var46);
                     break label177;
                  } catch (NoSuchMethodException var47) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var47);
                     break label177;
                  } catch (IllegalAccessException var48) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var48);
                     break label177;
                  } catch (ClassNotFoundException var49) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var49);
                     break label177;
                  } catch (SecurityException var50) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var50);
                     break label177;
                  } catch (IllegalArgumentException var51) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var51);
                     break label177;
                  } catch (LinkageError var52) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var52);
                     break label177;
                  }

                  var3 = var1;

                  try {
                     if (this.e.invoke(var4, var1) != null) {
                        return var3;
                     }

                     int var2 = String.valueOf(var1).length();
                     StringBuilder var63 = new StringBuilder(var2 + 122);
                     Log.w(
                        "FirebaseMessaging",
                        var63.append("Notification Channel requested (")
                           .append(var1)
                           .append(") has not been created by the app. Manifest configuration, or default, value will be used.")
                           .toString()
                     );
                  } catch (InstantiationException var37) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var37);
                     break label177;
                  } catch (InvocationTargetException var38) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var38);
                     break label177;
                  } catch (NoSuchMethodException var39) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var39);
                     break label177;
                  } catch (IllegalAccessException var40) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var40);
                     break label177;
                  } catch (ClassNotFoundException var41) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var41);
                     break label177;
                  } catch (SecurityException var42) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var42);
                     break label177;
                  } catch (IllegalArgumentException var43) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var43);
                     break label177;
                  } catch (LinkageError var44) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var44);
                     break label177;
                  }
               }

               label179: {
                  label180: {
                     try {
                        var1 = this.a().getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(var1)) {
                           break label180;
                        }
                     } catch (InstantiationException var29) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var29);
                        break label177;
                     } catch (InvocationTargetException var30) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var30);
                        break label177;
                     } catch (NoSuchMethodException var31) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var31);
                        break label177;
                     } catch (IllegalAccessException var32) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var32);
                        break label177;
                     } catch (ClassNotFoundException var33) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var33);
                        break label177;
                     } catch (SecurityException var34) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var34);
                        break label177;
                     } catch (IllegalArgumentException var35) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var35);
                        break label177;
                     } catch (LinkageError var36) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var36);
                        break label177;
                     }

                     try {
                        Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        break label179;
                     } catch (InstantiationException var21) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var21);
                        break label177;
                     } catch (InvocationTargetException var22) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var22);
                        break label177;
                     } catch (NoSuchMethodException var23) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var23);
                        break label177;
                     } catch (IllegalAccessException var24) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var24);
                        break label177;
                     } catch (ClassNotFoundException var25) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var25);
                        break label177;
                     } catch (SecurityException var26) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var26);
                        break label177;
                     } catch (IllegalArgumentException var27) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var27);
                        break label177;
                     } catch (LinkageError var28) {
                        Log.e("FirebaseMessaging", "Error while setting the notification channel", var28);
                        break label177;
                     }
                  }

                  var3 = var1;

                  try {
                     if (this.e.invoke(var4, var1) != null) {
                        return var3;
                     }

                     Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                  } catch (InstantiationException var13) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var13);
                     break label177;
                  } catch (InvocationTargetException var14) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var14);
                     break label177;
                  } catch (NoSuchMethodException var15) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var15);
                     break label177;
                  } catch (IllegalAccessException var16) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var16);
                     break label177;
                  } catch (ClassNotFoundException var17) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var17);
                     break label177;
                  } catch (SecurityException var18) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var18);
                     break label177;
                  } catch (IllegalArgumentException var19) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var19);
                     break label177;
                  } catch (LinkageError var20) {
                     Log.e("FirebaseMessaging", "Error while setting the notification channel", var20);
                     break label177;
                  }
               }

               try {
                  if (this.e.invoke(var4, "fcm_fallback_notification_channel") == null) {
                     Class var64 = Class.forName("android.app.NotificationChannel");
                     Object var62 = var64.getConstructor(String.class, CharSequence.class, int.class)
                        .newInstance("fcm_fallback_notification_channel", this.b.getString(R.string.fcm_fallback_notification_channel_label), 3);
                     var4.getClass().getMethod("createNotificationChannel", var64).invoke(var4, var62);
                  }
                  break label185;
               } catch (InstantiationException var5) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var5);
               } catch (InvocationTargetException var6) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var6);
               } catch (NoSuchMethodException var7) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var7);
               } catch (IllegalAccessException var8) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var8);
               } catch (ClassNotFoundException var9) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var9);
               } catch (SecurityException var10) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var10);
               } catch (IllegalArgumentException var11) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var11);
               } catch (LinkageError var12) {
                  Log.e("FirebaseMessaging", "Error while setting the notification channel", var12);
               }
            }

            var3 = null;
            return var3;
         }

         var3 = "fcm_fallback_notification_channel";
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static Object[] c(Bundle var0, String var1) {
      String[] var3 = String.valueOf(var1);
      String var4 = String.valueOf("_loc_args");
      if (var4.length() != 0) {
         var3 = var3.concat(var4);
      } else {
         var3 = new String(var3);
      }

      var4 = a(var0, var3);
      Object var8;
      if (TextUtils.isEmpty(var4)) {
         var8 = null;
      } else {
         label42: {
            label41: {
               label48: {
                  JSONArray var5;
                  try {
                     var5 = new JSONArray(var4);
                     var3 = new String[var5.length()];
                  } catch (JSONException var7) {
                     var1 = String.valueOf(var1);
                     var8 = String.valueOf("_loc_args");
                     if (var8.length() != 0) {
                        break label41;
                     }
                     break label48;
                  }

                  int var2 = 0;

                  while (true) {
                     String[] var16 = var3;

                     try {
                        if (var2 >= var3.length) {
                           return var16;
                        }

                        var3[var2] = (String)var5.opt(var2);
                     } catch (JSONException var6) {
                        var1 = String.valueOf(var1);
                        var8 = String.valueOf("_loc_args");
                        if (var8.length() != 0) {
                           break label41;
                        }
                        break;
                     }

                     var2++;
                  }
               }

               var8 = new String(var1);
               break label42;
            }

            var8 = var1.concat(var8);
         }

         var8 = var8.substring(6);
         Log.w(
            "FirebaseMessaging",
            new StringBuilder(String.valueOf(var8).length() + 41 + String.valueOf(var4).length())
               .append("Malformed ")
               .append(var8)
               .append(": ")
               .append(var4)
               .append("  Default value will be used.")
               .toString()
         );
         var8 = null;
      }

      return var8;
   }

   static String d(Bundle var0) {
      String var2 = a(var0, "gcm.n.sound2");
      String var1 = var2;
      if (TextUtils.isEmpty(var2)) {
         var1 = a(var0, "gcm.n.sound");
      }

      return var1;
   }

   private final String d(Bundle var1, String var2) {
      String var4 = a(var1, var2);
      String var7;
      if (!TextUtils.isEmpty(var4)) {
         var7 = var4;
      } else {
         var4 = b(var1, var2);
         if (TextUtils.isEmpty(var4)) {
            var7 = null;
         } else {
            Resources var5 = this.b.getResources();
            int var3 = var5.getIdentifier(var4, "string", this.b.getPackageName());
            if (var3 == 0) {
               String var8 = String.valueOf(var2);
               var2 = String.valueOf("_loc_key");
               String var9;
               if (var2.length() != 0) {
                  var9 = var8.concat(var2);
               } else {
                  var9 = new String(var8);
               }

               String var10 = var9.substring(6);
               Log.w(
                  "FirebaseMessaging",
                  new StringBuilder(String.valueOf(var10).length() + 49 + String.valueOf(var4).length())
                     .append(var10)
                     .append(" resource not found: ")
                     .append(var4)
                     .append(" Default value will be used.")
                     .toString()
               );
               var7 = null;
            } else {
               Object[] var12 = c(var1, var2);
               if (var12 == null) {
                  var7 = var5.getString(var3);
               } else {
                  try {
                     var7 = var5.getString(var3, var12);
                  } catch (MissingFormatArgumentException var6) {
                     var2 = Arrays.toString(var12);
                     Log.w(
                        "FirebaseMessaging",
                        new StringBuilder(String.valueOf(var4).length() + 58 + String.valueOf(var2).length())
                           .append("Missing format argument for ")
                           .append(var4)
                           .append(": ")
                           .append(var2)
                           .append(" Default value will be used.")
                           .toString(),
                        var6
                     );
                     var7 = null;
                  }
               }
            }
         }
      }

      return var7;
   }

   private final PendingIntent e(Bundle var1) {
      String var2 = a(var1, "gcm.n.click_action");
      Intent var7;
      if (!TextUtils.isEmpty(var2)) {
         var7 = new Intent(var2);
         var7.setPackage(this.b.getPackageName());
         var7.setFlags(268435456);
      } else {
         Uri var3 = b(var1);
         if (var3 != null) {
            var7 = new Intent("android.intent.action.VIEW");
            var7.setPackage(this.b.getPackageName());
            var7.setData(var3);
         } else {
            var7 = this.b.getPackageManager().getLaunchIntentForPackage(this.b.getPackageName());
            if (var7 == null) {
               Log.w("FirebaseMessaging", "No activity found to launch app");
            }
         }
      }

      PendingIntent var4;
      if (var7 == null) {
         var4 = null;
      } else {
         var7.addFlags(67108864);
         var1 = new Bundle(var1);
         FirebaseMessagingService.a(var1);
         var7.putExtras(var1);

         for (String var6 : var1.keySet()) {
            if (var6.startsWith("gcm.n.") || var6.startsWith("gcm.notification.")) {
               var7.removeExtra(var6);
            }
         }

         var4 = PendingIntent.getActivity(this.b, this.f.incrementAndGet(), var7, 1073741824);
      }

      return var4;
   }

   final boolean c(Bundle var1) {
      boolean var4;
      if ("1".equals(a(var1, "gcm.n.noui"))) {
         var4 = true;
      } else {
         int var15;
         label130: {
            if (!((KeyguardManager)this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
               if (!zzq.f()) {
                  SystemClock.sleep(10L);
               }

               var15 = Process.myPid();
               List var7 = ((ActivityManager)this.b.getSystemService("activity")).getRunningAppProcesses();
               if (var7 != null) {
                  for (RunningAppProcessInfo var20 : var7) {
                     if (var20.pid == var15) {
                        if (var20.importance == 100) {
                           var15 = 1;
                        } else {
                           var15 = 0;
                        }
                        break label130;
                     }
                  }
               }
            }

            var15 = 0;
         }

         if (var15) {
            var4 = false;
         } else {
            String var21 = this.d(var1, "gcm.n.title");
            CharSequence var26 = var21;
            if (TextUtils.isEmpty(var21)) {
               var26 = this.b.getApplicationInfo().loadLabel(this.b.getPackageManager());
            }

            String var11;
            label135: {
               var11 = this.d(var1, "gcm.n.body");
               String var9 = a(var1, "gcm.n.icon");
               if (!TextUtils.isEmpty(var9)) {
                  Resources var22 = this.b.getResources();
                  var15 = var22.getIdentifier(var9, "drawable", this.b.getPackageName());
                  if (var15 != 0 && this.a(var15)) {
                     break label135;
                  }

                  int var3 = var22.getIdentifier(var9, "mipmap", this.b.getPackageName());
                  if (var3 != 0) {
                     var15 = var3;
                     if (this.a(var3)) {
                        break label135;
                     }
                  }

                  Log.w(
                     "FirebaseMessaging",
                     new StringBuilder(String.valueOf(var9).length() + 61)
                        .append("Icon resource ")
                        .append(var9)
                        .append(" not found. Notification will use default icon.")
                        .toString()
                  );
               }

               label114: {
                  int var18 = this.a().getInt("com.google.firebase.messaging.default_notification_icon", 0);
                  if (var18 != 0) {
                     var15 = var18;
                     if (this.a(var18)) {
                        break label114;
                     }
                  }

                  var15 = this.b.getApplicationInfo().icon;
               }

               int var19;
               label109: {
                  if (var15 != 0) {
                     var19 = var15;
                     if (this.a(var15)) {
                        break label109;
                     }
                  }

                  var19 = 17301651;
               }

               var15 = var19;
            }

            Integer var12 = this.b(a(var1, "gcm.n.color"));
            var21 = d(var1);
            Uri var24;
            if (TextUtils.isEmpty(var21)) {
               var24 = null;
            } else if (!"default".equals(var21) && this.b.getResources().getIdentifier(var21, "raw", this.b.getPackageName()) != 0) {
               String var28 = this.b.getPackageName();
               var24 = Uri.parse(
                  new StringBuilder(String.valueOf("android.resource://").length() + 5 + String.valueOf(var28).length() + String.valueOf(var21).length())
                     .append("android.resource://")
                     .append(var28)
                     .append("/raw/")
                     .append(var21)
                     .toString()
               );
            } else {
               var24 = RingtoneManager.getDefaultUri(2);
            }

            PendingIntent var29 = this.e(var1);
            PendingIntent var32;
            if (FirebaseMessagingService.b(var1)) {
               Intent var10 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
               a(var10, var1);
               var10.putExtra("pending_intent", var29);
               var29 = zzx.a(this.b, this.f.incrementAndGet(), var10, 1073741824);
               Intent var31 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
               a(var31, var1);
               var32 = zzx.a(this.b, this.f.incrementAndGet(), var31, 1073741824);
            } else {
               var32 = null;
            }

            Notification var25;
            if (zzq.h() && this.b.getApplicationInfo().targetSdkVersion > 25) {
               var25 = this.a(var26, var11, var15, var12, var24, var29, var32, this.c(a(var1, "gcm.n.android_channel_id")));
            } else {
               NotificationCompat.Builder var13 = new NotificationCompat.Builder(this.b).a(true).a(var15);
               if (!TextUtils.isEmpty(var26)) {
                  var13.a(var26);
               }

               if (!TextUtils.isEmpty(var11)) {
                  var13.b(var11);
                  var13.a(new NotificationCompat.BigTextStyle().b(var11));
               }

               if (var12 != null) {
                  var13.d(var12);
               }

               if (var24 != null) {
                  var13.a(var24);
               }

               if (var29 != null) {
                  var13.a(var29);
               }

               if (var32 != null) {
                  var13.b(var32);
               }

               var25 = var13.b();
            }

            var26 = a(var1, "gcm.n.tag");
            if (Log.isLoggable("FirebaseMessaging", 3)) {
               Log.d("FirebaseMessaging", "Showing notification");
            }

            NotificationManager var30 = (NotificationManager)this.b.getSystemService("notification");
            String var14 = var26;
            if (TextUtils.isEmpty(var26)) {
               long var5 = SystemClock.uptimeMillis();
               var14 = new StringBuilder(37).append("FCM-Notification:").append(var5).toString();
            }

            var30.notify(var14, 0, var25);
            var4 = true;
         }
      }

      return var4;
   }
}
