package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AdvertisingInfoProvider {
   private final Context a;
   private final PreferenceStore b;

   public AdvertisingInfoProvider(Context var1) {
      this.a = var1.getApplicationContext();
      this.b = new PreferenceStoreImpl(var1, "TwitterAdvertisingInfoPreferences");
   }

   private void a(AdvertisingInfo var1) {
      new Thread(new BackgroundPriorityRunnable(this, var1) {
         final AdvertisingInfo a;
         final AdvertisingInfoProvider b;

         {
            this.b = var1;
            this.a = var2;
         }

         @Override
         public void a() {
            AdvertisingInfo var1x = this.b.e();
            if (!this.a.equals(var1x)) {
               Fabric.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
               this.b.b(var1x);
            }
         }
      }).start();
   }

   @SuppressLint("CommitPrefEdits")
   private void b(AdvertisingInfo var1) {
      if (this.c(var1)) {
         this.b.a(this.b.b().putString("advertising_id", var1.a).putBoolean("limit_ad_tracking_enabled", var1.b));
      } else {
         this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
      }
   }

   private boolean c(AdvertisingInfo var1) {
      boolean var2;
      if (var1 != null && !TextUtils.isEmpty(var1.a)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private AdvertisingInfo e() {
      AdvertisingInfo var1 = this.c().a();
      if (!this.c(var1)) {
         var1 = this.d().a();
         if (!this.c(var1)) {
            Fabric.h().a("Fabric", "AdvertisingInfo not present");
         } else {
            Fabric.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
         }
      } else {
         Fabric.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
      }

      return var1;
   }

   public AdvertisingInfo a() {
      AdvertisingInfo var1 = this.b();
      if (this.c(var1)) {
         Fabric.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
         this.a(var1);
      } else {
         var1 = this.e();
         this.b(var1);
      }

      return var1;
   }

   protected AdvertisingInfo b() {
      return new AdvertisingInfo(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
   }

   public AdvertisingInfoStrategy c() {
      return new AdvertisingInfoReflectionStrategy(this.a);
   }

   public AdvertisingInfoStrategy d() {
      return new AdvertisingInfoServiceStrategy(this.a);
   }
}
