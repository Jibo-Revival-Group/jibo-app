package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.salesforce.android.service.common.utilities.internal.android.AndroidInfo;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Locale;

public class DeviceInfoLoader {
   private final String a;
   private String b;
   private String c;
   private String d;
   private String e;

   protected DeviceInfoLoader(DeviceInfoLoader.Builder var1) {
      AndroidInfo var2 = var1.b;
      PackageInfo var3 = var1.c;
      this.a = var1.d.a();
      this.b = var1.a;
      this.c = String.format(Locale.getDefault(), "%s (%d)", var3.versionName, var3.versionCode);
      this.d = String.format("%s %s %s", "android", var2.a(), var2.b());
      this.e = var2.c();
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.c;
   }

   public String c() {
      return this.d;
   }

   public String d() {
      return this.e;
   }

   public static class Builder {
      protected String a;
      protected AndroidInfo b;
      protected PackageInfo c;
      protected DeviceIdentifier d;
      private Context e;

      public DeviceInfoLoader.Builder a(Context var1) {
         this.e = var1;
         return this;
      }

      public DeviceInfoLoader a() {
         Arguments.a((Context)this.e);
         this.a = this.e.getPackageName();
         if (this.b == null) {
            this.b = new AndroidInfo();
         }

         if (this.c == null) {
            try {
               this.c = this.e.getPackageManager().getPackageInfo(this.a, 0);
            } catch (NameNotFoundException var2) {
               throw new RuntimeException(var2);
            }
         }

         if (this.d == null) {
            this.d = new DeviceIdentifier.Builder().a(this.e).a();
         }

         return new DeviceInfoLoader(this);
      }
   }
}
