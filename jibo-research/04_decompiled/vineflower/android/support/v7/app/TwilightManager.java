package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import java.util.Calendar;

class TwilightManager {
   private static TwilightManager a;
   private final Context b;
   private final LocationManager c;
   private final TwilightManager.TwilightState d = new TwilightManager.TwilightState();

   TwilightManager(Context var1, LocationManager var2) {
      this.b = var1;
      this.c = var2;
   }

   private Location a(String var1) {
      try {
         if (this.c.isProviderEnabled(var1)) {
            return this.c.getLastKnownLocation(var1);
         }
      } catch (Exception var2) {
         Log.d("TwilightManager", "Failed to get last known location", var2);
      }

      return null;
   }

   static TwilightManager a(Context var0) {
      if (a == null) {
         var0 = var0.getApplicationContext();
         a = new TwilightManager(var0, (LocationManager)var0.getSystemService("location"));
      }

      return a;
   }

   private void a(Location var1) {
      TwilightManager.TwilightState var14 = this.d;
      long var2 = System.currentTimeMillis();
      TwilightCalculator var13 = TwilightCalculator.a();
      var13.a(var2 - 86400000L, var1.getLatitude(), var1.getLongitude());
      long var10 = var13.a;
      var13.a(var2, var1.getLatitude(), var1.getLongitude());
      boolean var12;
      if (var13.c == 1) {
         var12 = true;
      } else {
         var12 = false;
      }

      long var8 = var13.b;
      long var4 = var13.a;
      var13.a(86400000L + var2, var1.getLatitude(), var1.getLongitude());
      long var6 = var13.b;
      if (var8 != -1L && var4 != -1L) {
         if (var2 > var4) {
            var2 = 0L + var6;
         } else if (var2 > var8) {
            var2 = 0L + var4;
         } else {
            var2 = 0L + var8;
         }

         var2 += 60000L;
      } else {
         var2 = 43200000L + var2;
      }

      var14.a = var12;
      var14.b = var10;
      var14.c = var8;
      var14.d = var4;
      var14.e = var6;
      var14.f = var2;
   }

   @SuppressLint("MissingPermission")
   private Location b() {
      Location var2 = null;
      Location var1;
      if (PermissionChecker.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
         var1 = this.a("network");
      } else {
         var1 = null;
      }

      if (PermissionChecker.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
         var2 = this.a("gps");
      }

      Location var3;
      if (var2 != null && var1 != null) {
         var3 = var1;
         if (var2.getTime() > var1.getTime()) {
            var3 = var2;
         }
      } else {
         if (var2 == null) {
            var2 = var1;
         }

         var3 = var2;
      }

      return var3;
   }

   private boolean c() {
      boolean var1;
      if (this.d.f > System.currentTimeMillis()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   boolean a() {
      TwilightManager.TwilightState var4 = this.d;
      boolean var2;
      if (this.c()) {
         var2 = var4.a;
      } else {
         Location var3 = this.b();
         if (var3 != null) {
            this.a(var3);
            var2 = var4.a;
         } else {
            Log.i(
               "TwilightManager",
               "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."
            );
            int var1 = Calendar.getInstance().get(11);
            if (var1 >= 6 && var1 < 22) {
               var2 = false;
            } else {
               var2 = true;
            }
         }
      }

      return var2;
   }

   private static class TwilightState {
      boolean a;
      long b;
      long c;
      long d;
      long e;
      long f;

      TwilightState() {
      }
   }
}
