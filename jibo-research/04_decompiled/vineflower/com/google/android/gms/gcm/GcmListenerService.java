package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.iid.zzb;
import java.util.Iterator;

public class GcmListenerService extends zzb {
   static void a(Bundle var0) {
      Iterator var2 = var0.keySet().iterator();

      while (var2.hasNext()) {
         String var1 = (String)var2.next();
         if (var1 != null && var1.startsWith("google.c.")) {
            var2.remove();
         }
      }
   }

   public void a() {
   }

   public void a(String var1) {
   }

   public void a(String var1, Bundle var2) {
   }

   public void a(String var1, String var2) {
   }

   @Override
   public void handleIntent(Intent var1) {
      if (!"com.google.android.c2dm.intent.RECEIVE".equals(var1.getAction())) {
         String var5 = String.valueOf(var1.getAction());
         String var6;
         if (var5.length() != 0) {
            var6 = "Unknown intent action: ".concat(var5);
         } else {
            var6 = new String("Unknown intent action: ");
         }

         Log.w("GcmListenerService", var6);
      } else {
         String var4 = var1.getStringExtra("message_type");
         String var3 = var4;
         if (var4 == null) {
            var3 = "gcm";
         }

         switch (var3) {
            case "gcm":
               Bundle var12 = var1.getExtras();
               var12.remove("message_type");
               var12.remove("android.support.content.wakelockid");
               boolean var10;
               if (!"1".equals(zza.a(var12, "gcm.n.e")) && zza.a(var12, "gcm.n.icon") == null) {
                  var10 = false;
               } else {
                  var10 = true;
               }

               if (var10) {
                  if (!zza.b(this)) {
                     zza.a(this).b(var12);
                     break;
                  }

                  zza.a(var12);
               }

               String var9 = var12.getString("from");
               var12.remove("from");
               a(var12);
               this.a(var9, var12);
               break;
            case "deleted_messages":
               this.a();
               break;
            case "send_event":
               this.a(var1.getStringExtra("google.message_id"));
               break;
            case "send_error":
               var4 = var1.getStringExtra("google.message_id");
               var3 = var4;
               if (var4 == null) {
                  var3 = var1.getStringExtra("message_id");
               }

               this.a(var3, var1.getStringExtra("error"));
               break;
            default:
               String var7 = String.valueOf(var3);
               String var8;
               if (var7.length() != 0) {
                  var8 = "Received message with unknown type: ".concat(var7);
               } else {
                  var8 = new String("Received message with unknown type: ");
               }

               Log.w("GcmListenerService", var8);
         }
      }
   }
}
