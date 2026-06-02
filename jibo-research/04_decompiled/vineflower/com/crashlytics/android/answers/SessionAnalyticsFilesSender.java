package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class SessionAnalyticsFilesSender extends AbstractSpiCall implements FilesSender {
   private final String b;

   public SessionAnalyticsFilesSender(Kit var1, String var2, String var3, HttpRequestFactory var4, String var5) {
      super(var1, var2, var3, var4, HttpMethod.POST);
      this.b = var5;
   }

   @Override
   public boolean a(List<File> var1) {
      boolean var3 = false;
      HttpRequest var6 = this.b()
         .a("X-CRASHLYTICS-API-CLIENT-TYPE", "android")
         .a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a())
         .a("X-CRASHLYTICS-API-KEY", this.b);
      Iterator var5 = var1.iterator();

      for (int var2 = 0; var5.hasNext(); var2++) {
         File var4 = (File)var5.next();
         var6.a("session_analytics_file_" + var2, var4.getName(), "application/vnd.crashlytics.android.events", var4);
      }

      Fabric.h().a("Answers", "Sending " + var1.size() + " analytics files to " + this.a());
      int var7 = var6.b();
      Fabric.h().a("Answers", "Response code for analytics file send is " + var7);
      if (ResponseParser.a(var7) == 0) {
         var3 = true;
      }

      return var3;
   }
}
