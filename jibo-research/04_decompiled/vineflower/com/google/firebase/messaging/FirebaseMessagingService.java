package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.zzi;
import com.google.firebase.iid.zzx;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class FirebaseMessagingService extends com.google.firebase.iid.zzb {
   private static final Queue<String> b = new ArrayDeque<>(10);

   static void a(Bundle var0) {
      Iterator var1 = var0.keySet().iterator();

      while (var1.hasNext()) {
         String var2 = (String)var1.next();
         if (var2 != null && var2.startsWith("google.c.")) {
            var1.remove();
         }
      }
   }

   static boolean b(Bundle var0) {
      boolean var1;
      if (var0 == null) {
         var1 = false;
      } else {
         var1 = "1".equals(var0.getString("google.c.a.e"));
      }

      return var1;
   }

   @Override
   protected final Intent a(Intent var1) {
      return zzx.a().b();
   }

   public void a() {
   }

   public void a(RemoteMessage var1) {
   }

   public void a(String var1) {
   }

   public void a(String var1, Exception var2) {
   }

   @Override
   public final void b(Intent var1) {
      byte var3 = 0;
      String var5 = var1.getAction();
      String var4 = var5;
      if (var5 == null) {
         var4 = "";
      }

      byte var2;
      label116: {
         switch (var4.hashCode()) {
            case 75300319:
               if (var4.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
                  var2 = 1;
                  break label116;
               }
               break;
            case 366519424:
               if (var4.equals("com.google.android.c2dm.intent.RECEIVE")) {
                  var2 = 0;
                  break label116;
               }
         }

         var2 = -1;
      }

      switch (var2) {
         case 0:
            String var6 = var1.getStringExtra("google.message_id");
            boolean var12;
            if (TextUtils.isEmpty(var6)) {
               var12 = 0;
            } else if (b.contains(var6)) {
               if (Log.isLoggable("FirebaseMessaging", 3)) {
                  var4 = String.valueOf(var6);
                  if (var4.length() != 0) {
                     var4 = "Received duplicate message: ".concat(var4);
                  } else {
                     var4 = new String("Received duplicate message: ");
                  }

                  Log.d("FirebaseMessaging", var4);
               }

               var12 = 1;
            } else {
               if (b.size() >= 10) {
                  b.remove();
               }

               b.add(var6);
               var12 = 0;
            }

            if (!var12) {
               var5 = var1.getStringExtra("message_type");
               var4 = var5;
               if (var5 == null) {
                  var4 = "gcm";
               }

               label104: {
                  switch (var4.hashCode()) {
                     case -2062414158:
                        if (var4.equals("deleted_messages")) {
                           var12 = 1;
                           break label104;
                        }
                        break;
                     case 102161:
                        if (var4.equals("gcm")) {
                           var12 = var3;
                           break label104;
                        }
                        break;
                     case 814694033:
                        if (var4.equals("send_error")) {
                           var12 = 3;
                           break label104;
                        }
                        break;
                     case 814800675:
                        if (var4.equals("send_event")) {
                           var12 = 2;
                           break label104;
                        }
                  }

                  var12 = -1;
               }

               switch (var12) {
                  case 0:
                     if (b(var1.getExtras())) {
                        zzd.a(this, var1);
                     }

                     Bundle var21 = var1.getExtras();
                     Bundle var18 = var21;
                     if (var21 == null) {
                        var18 = new Bundle();
                     }

                     var18.remove("android.support.content.wakelockid");
                     if (zza.a(var18)) {
                        if (zza.a(this).c(var18)) {
                           break;
                        }

                        if (b(var18)) {
                           zzd.d(this, var1);
                        }
                     }

                     this.a(new RemoteMessage(var18));
                     break;
                  case 1:
                     this.a();
                     break;
                  case 2:
                     this.a(var1.getStringExtra("google.message_id"));
                     break;
                  case 3:
                     var5 = var1.getStringExtra("google.message_id");
                     var4 = var5;
                     if (var5 == null) {
                        var4 = var1.getStringExtra("message_id");
                     }

                     this.a(var4, new SendException(var1.getStringExtra("error")));
                     break;
                  default:
                     String var9 = String.valueOf(var4);
                     String var10;
                     if (var9.length() != 0) {
                        var10 = "Received message with unknown type: ".concat(var9);
                     } else {
                        var10 = new String("Received message with unknown type: ");
                     }

                     Log.w("FirebaseMessaging", var10);
               }
            }

            if (!TextUtils.isEmpty(var6)) {
               Bundle var11 = new Bundle();
               var11.putString("google.message_id", var6);
               zzi.a(this).a(2, var11);
            }
            break;
         case 1:
            if (b(var1.getExtras())) {
               zzd.c(this, var1);
            }
            break;
         default:
            String var7 = String.valueOf(var1.getAction());
            String var8;
            if (var7.length() != 0) {
               var8 = "Unknown intent action: ".concat(var7);
            } else {
               var8 = new String("Unknown intent action: ");
            }

            Log.d("FirebaseMessaging", var8);
      }
   }

   @Override
   public final boolean c(Intent var1) {
      boolean var2;
      if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(var1.getAction())) {
         PendingIntent var3 = (PendingIntent)var1.getParcelableExtra("pending_intent");
         if (var3 != null) {
            try {
               var3.send();
            } catch (CanceledException var4) {
               Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
         }

         if (b(var1.getExtras())) {
            zzd.b(this, var1);
         }

         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
