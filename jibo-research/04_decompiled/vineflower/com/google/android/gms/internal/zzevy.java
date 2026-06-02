package com.google.android.gms.internal;

import android.util.Log;

public final class zzevy extends zzewg {
   private final zzews a;

   zzevy(zzews var1) {
      this.a = var1;
   }

   @Override
   public final boolean a() {
      boolean var2 = false;
      boolean var1;
      if (this.a == null) {
         Log.w("FirebasePerformance", "ApplicationInfo is null");
         var1 = false;
      } else if (this.a.a == null) {
         Log.w("FirebasePerformance", "GoogleAppId is null");
         var1 = false;
      } else if (this.a.b == null) {
         Log.w("FirebasePerformance", "AppInstanceId is null");
         var1 = false;
      } else if (this.a.d == null) {
         Log.w("FirebasePerformance", "ApplicationProcessState is null");
         var1 = false;
      } else {
         label29: {
            if (this.a.c != null) {
               if (this.a.c.a == null) {
                  Log.w("FirebasePerformance", "AndroidAppInfo.packageName is null");
                  var1 = false;
                  break label29;
               }

               if (this.a.c.b == null) {
                  Log.w("FirebasePerformance", "AndroidAppInfo.sdkVersion is null");
                  var1 = false;
                  break label29;
               }
            }

            var1 = true;
         }
      }

      if (!var1) {
         Log.w("FirebasePerformance", "ApplicationInfo is invalid");
      } else {
         var2 = true;
      }

      return var2;
   }
}
