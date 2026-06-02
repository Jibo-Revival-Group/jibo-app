package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;

class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {
   private final Context a;

   public AdvertisingInfoReflectionStrategy(Context var1) {
      this.a = var1.getApplicationContext();
   }

   private String b() {
      String var1;
      try {
         var1 = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId").invoke(this.d());
      } catch (Exception var2) {
         Fabric.h().d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
         var1 = null;
      }

      return var1;
   }

   private boolean c() {
      boolean var1;
      try {
         var1 = (Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled").invoke(this.d());
      } catch (Exception var3) {
         Fabric.h().d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
         var1 = false;
      }

      return var1;
   }

   private Object d() {
      Object var1 = null;

      Object var2;
      try {
         var2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient")
            .getMethod("getAdvertisingIdInfo", Context.class)
            .invoke(null, this.a);
      } catch (Exception var3) {
         Fabric.h().d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
         return var1;
      }

      return var2;
   }

   @Override
   public AdvertisingInfo a() {
      AdvertisingInfo var1;
      if (this.a(this.a)) {
         var1 = new AdvertisingInfo(this.b(), this.c());
      } else {
         var1 = null;
      }

      return var1;
   }

   boolean a(Context var1) {
      int var2;
      try {
         var2 = (Integer)Class.forName("com.google.android.gms.common.GooglePlayServicesUtil")
            .getMethod("isGooglePlayServicesAvailable", Context.class)
            .invoke(null, var1);
      } catch (Exception var4) {
         return false;
      }

      boolean var3;
      if (var2 == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
