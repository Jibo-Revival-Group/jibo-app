package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;

class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
   public DefaultCreateReportSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4) {
      super(var1, var2, var3, var4, HttpMethod.POST);
   }

   private HttpRequest a(HttpRequest var1, CreateReportRequest var2) {
      var1 = var1.a("X-CRASHLYTICS-API-KEY", var2.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
      Iterator var4 = var2.b.e().entrySet().iterator();

      while (var4.hasNext()) {
         var1 = var1.a((Entry<String, String>)var4.next());
      }

      return var1;
   }

   private HttpRequest a(HttpRequest var1, Report var2) {
      int var4 = 0;
      var1.e("report[identifier]", var2.b());
      HttpRequest var6;
      if (var2.d().length == 1) {
         Fabric.h().a("CrashlyticsCore", "Adding single file " + var2.a() + " to report " + var2.b());
         var6 = var1.a("report[file]", var2.a(), "application/octet-stream", var2.c());
      } else {
         File[] var7 = var2.d();
         int var5 = var7.length;
         int var3 = 0;

         while (true) {
            var6 = var1;
            if (var4 >= var5) {
               break;
            }

            File var8 = var7[var4];
            Fabric.h().a("CrashlyticsCore", "Adding file " + var8.getName() + " to report " + var2.b());
            var1.a("report[file" + var3 + "]", var8.getName(), "application/octet-stream", var8);
            var3++;
            var4++;
         }
      }

      return var6;
   }

   @Override
   public boolean a(CreateReportRequest var1) {
      HttpRequest var4 = this.a(this.a(this.b(), var1), var1.b);
      Fabric.h().a("CrashlyticsCore", "Sending report to: " + this.a());
      int var2 = var4.b();
      Fabric.h().a("CrashlyticsCore", "Create report request ID: " + var4.b("X-REQUEST-ID"));
      Fabric.h().a("CrashlyticsCore", "Result was: " + var2);
      boolean var3;
      if (ResponseParser.a(var2) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
