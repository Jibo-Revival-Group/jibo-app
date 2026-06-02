package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzw;

public final class RevocationBoundService extends Service {
   public final IBinder onBind(Intent var1) {
      zzw var4;
      if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(var1.getAction())
         && !"com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(var1.getAction())) {
         String var5 = String.valueOf(var1.getAction());
         String var6;
         if (var5.length() != 0) {
            var6 = "Unknown action sent to RevocationBoundService: ".concat(var5);
         } else {
            var6 = new String("Unknown action sent to RevocationBoundService: ");
         }

         Log.w("RevocationService", var6);
         var4 = null;
      } else {
         if (Log.isLoggable("RevocationService", 2)) {
            String var2 = String.valueOf(var1.getAction());
            String var3;
            if (var2.length() != 0) {
               var3 = "RevocationBoundService handling ".concat(var2);
            } else {
               var3 = new String("RevocationBoundService handling ");
            }

            Log.v("RevocationService", var3);
         }

         var4 = new zzw(this);
      }

      return var4;
   }
}
