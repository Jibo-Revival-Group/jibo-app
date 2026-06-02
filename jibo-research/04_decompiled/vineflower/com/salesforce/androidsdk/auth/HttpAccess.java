package com.salesforce.androidsdk.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.TlsVersion;

public class HttpAccess {
   public static HttpAccess a;
   static final boolean b;
   private String c;
   private OkHttpClient d;
   private final ConnectivityManager e;

   static {
      boolean var0;
      if (!HttpAccess.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
   }

   public HttpAccess(Context var1, String var2) {
      this.c = var2;
      if (var1 == null) {
         this.e = null;
      } else {
         this.e = (ConnectivityManager)var1.getSystemService("connectivity");
      }
   }

   public static void a(Context var0, String var1) {
      if (!b && a != null) {
         throw new AssertionError("HttpAccess.init should be called once per process");
      }

      a = new HttpAccess(var0, var1);
   }

   public OkHttpClient.Builder a() {
      ConnectionSpec var1 = new ConnectionSpec.Builder(ConnectionSpec.a).a(TlsVersion.TLS_1_1, TlsVersion.TLS_1_2).a();
      OkHttpClient.Builder var5 = new OkHttpClient.Builder()
         .a(Collections.singletonList(var1))
         .a(60L, TimeUnit.SECONDS)
         .b(20L, TimeUnit.SECONDS)
         .b(new HttpAccess.UserAgentInterceptor(this.c));
      if (VERSION.SDK_INT < 21) {
         try {
            var5.a(SalesforceTLSSocketFactory.getInstance());
         } catch (KeyManagementException var3) {
            SalesforceSDKLogger.a("HttpAccess", "Exception thrown while setting SSL socket factory", var3);
         } catch (NoSuchAlgorithmException var4) {
            SalesforceSDKLogger.a("HttpAccess", "Exception thrown while setting SSL socket factory", var4);
         }
      }

      return var5;
   }

   public OkHttpClient b() {
      synchronized (this) {
         if (this.d == null) {
            this.d = this.a().a();
         }

         return this.d;
      }
   }

   public static class UserAgentInterceptor implements Interceptor {
      private final String a;

      public UserAgentInterceptor(String var1) {
         this.a = var1;
      }

      @Override
      public Response a(Interceptor.Chain var1) throws IOException {
         return var1.a(var1.a().e().a("User-Agent", this.a).c());
      }
   }
}
