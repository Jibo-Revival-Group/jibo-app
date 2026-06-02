package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

public class FirebaseInstanceIdService extends zzb {
   @Override
   protected final Intent a(Intent var1) {
      return zzx.a().a.poll();
   }

   public void a() {
   }

   @Override
   public final void b(Intent var1) {
      if ("com.google.firebase.iid.TOKEN_REFRESH".equals(var1.getAction())) {
         this.a();
      } else {
         String var2 = var1.getStringExtra("CMD");
         if (var2 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
               String var3 = String.valueOf(var1.getExtras());
               Log.d(
                  "FirebaseInstanceId",
                  new StringBuilder(String.valueOf(var2).length() + 21 + String.valueOf(var3).length())
                     .append("Received command: ")
                     .append(var2)
                     .append(" - ")
                     .append(var3)
                     .toString()
               );
            }

            if ("RST".equals(var2) || "RST_FULL".equals(var2)) {
               FirebaseInstanceId.a().i();
            } else if ("SYNC".equals(var2)) {
               FirebaseInstanceId.a().j();
            }
         }
      }
   }
}
