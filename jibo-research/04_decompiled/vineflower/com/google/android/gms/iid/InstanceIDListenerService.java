package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InstanceIDListenerService extends zzb {
   static void a(Context var0, zzo var1) {
      var1.b();
      Intent var2 = new Intent("com.google.android.gms.iid.InstanceID");
      var2.putExtra("CMD", "RST");
      var2.setClassName(var0, "com.google.android.gms.gcm.GcmReceiver");
      var0.sendBroadcast(var2);
   }

   public void a() {
   }

   @Override
   public void handleIntent(Intent var1) {
      if ("com.google.android.gms.iid.InstanceID".equals(var1.getAction())) {
         Bundle var2 = null;
         String var3 = var1.getStringExtra("subtype");
         if (var3 != null) {
            var2 = new Bundle();
            var2.putString("subtype", var3);
         }

         InstanceID var5 = InstanceID.a(this, var2);
         String var4 = var1.getStringExtra("CMD");
         if (Log.isLoggable("InstanceID", 3)) {
            Log.d(
               "InstanceID",
               new StringBuilder(String.valueOf(var3).length() + 34 + String.valueOf(var4).length())
                  .append("Service command. subtype:")
                  .append(var3)
                  .append(" command:")
                  .append(var4)
                  .toString()
            );
         }

         if ("gcm.googleapis.com/refresh".equals(var1.getStringExtra("from"))) {
            InstanceID.c().c(var3);
            this.a();
         } else if ("RST".equals(var4)) {
            var5.b();
            this.a();
         } else if ("RST_FULL".equals(var4)) {
            if (!InstanceID.c().a()) {
               InstanceID.c().b();
               this.a();
            }
         } else if ("SYNC".equals(var4)) {
            InstanceID.c().c(var3);
            this.a();
         }
      }
   }
}
