package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class DeviceIdentifier {
   private final SharedPreferences a;
   private final String b;

   protected DeviceIdentifier(DeviceIdentifier.Builder var1) {
      this.a = var1.a;
      if (this.b()) {
         this.b = this.c();
      } else {
         this.b = var1.b.a().toString();
         this.a(this.b);
      }
   }

   private void a(String var1) {
      this.a.edit().putString("unique_device_id", var1).apply();
   }

   private boolean b() {
      return this.a.contains("unique_device_id");
   }

   private String c() {
      return this.a.getString("unique_device_id", "UNKNOWN-DEVICE-ID");
   }

   public String a() {
      return this.b;
   }

   public static class Builder {
      protected SharedPreferences a;
      protected UUIDProvider b;
      private Context c;

      public DeviceIdentifier.Builder a(Context var1) {
         this.c = var1;
         return this;
      }

      public DeviceIdentifier a() {
         Arguments.a((Context)this.c);
         if (this.a == null) {
            this.a = this.c.getSharedPreferences("com.salesforce.android.service", 0);
         }

         if (this.b == null) {
            this.b = new UUIDProvider();
         }

         return new DeviceIdentifier(this);
      }
   }
}
