package com.google.firebase.perf.network;

import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class FirebasePerfHttpClient {
   private FirebasePerfHttpClient() {
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static <T> T a(HttpClient var0, HttpHost var1, HttpRequest var2, ResponseHandler<? extends T> var3, zzewn var4, zzevz var5) throws IOException {
      zzevv var6 = zzevv.a(var5);

      label41: {
         try {
            var13 = String.valueOf(var1.toURI());
            String var7 = String.valueOf(var2.getRequestLine().getUri());
            if (var7.length() != 0) {
               var14 = var13.concat(var7);
               break label41;
            }
         } catch (IOException var12) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var12;
         }

         try {
            var14 = new String(var13);
         } catch (IOException var11) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var11;
         }
      }

      try {
         var6.a(var14).b(var2.getRequestLine().getMethod());
         var15 = zzh.a(var2);
      } catch (IOException var10) {
         var6.f(var4.c());
         zzh.a(var6);
         throw var10;
      }

      if (var15 != null) {
         try {
            var6.a(var15);
         } catch (IOException var9) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var9;
         }
      }

      try {
         var4.a();
         var6.c(var4.b());
         zzf var16 = new zzf(var3, var4, var6);
         return (T)var0.execute(var1, var2, var16);
      } catch (IOException var8) {
         var6.f(var4.c());
         zzh.a(var6);
         throw var8;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static <T> T a(HttpClient var0, HttpHost var1, HttpRequest var2, ResponseHandler<? extends T> var3, HttpContext var4, zzewn var5, zzevz var6) throws IOException {
      zzevv var7 = zzevv.a(var6);

      label41: {
         try {
            var14 = String.valueOf(var1.toURI());
            String var8 = String.valueOf(var2.getRequestLine().getUri());
            if (var8.length() != 0) {
               var15 = var14.concat(var8);
               break label41;
            }
         } catch (IOException var13) {
            var7.f(var5.c());
            zzh.a(var7);
            throw var13;
         }

         try {
            var15 = new String(var14);
         } catch (IOException var12) {
            var7.f(var5.c());
            zzh.a(var7);
            throw var12;
         }
      }

      try {
         var7.a(var15).b(var2.getRequestLine().getMethod());
         var16 = zzh.a(var2);
      } catch (IOException var11) {
         var7.f(var5.c());
         zzh.a(var7);
         throw var11;
      }

      if (var16 != null) {
         try {
            var7.a(var16);
         } catch (IOException var10) {
            var7.f(var5.c());
            zzh.a(var7);
            throw var10;
         }
      }

      try {
         var5.a();
         var7.c(var5.b());
         zzf var17 = new zzf(var3, var5, var7);
         return (T)var0.execute(var1, var2, var17, var4);
      } catch (IOException var9) {
         var7.f(var5.c());
         zzh.a(var7);
         throw var9;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static <T> T a(HttpClient var0, HttpUriRequest var1, ResponseHandler<T> var2, zzewn var3, zzevz var4) throws IOException {
      zzevv var9 = zzevv.a(var4);

      Long var5;
      try {
         var9.a(var1.getURI().toString()).b(var1.getMethod());
         var5 = zzh.a(var1);
      } catch (IOException var8) {
         var9.f(var3.c());
         zzh.a(var9);
         throw var8;
      }

      if (var5 != null) {
         try {
            var9.a(var5);
         } catch (IOException var7) {
            var9.f(var3.c());
            zzh.a(var9);
            throw var7;
         }
      }

      try {
         var3.a();
         var9.c(var3.b());
         zzf var10 = new zzf(var2, var3, var9);
         return (T)var0.execute(var1, var10);
      } catch (IOException var6) {
         var9.f(var3.c());
         zzh.a(var9);
         throw var6;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static <T> T a(HttpClient var0, HttpUriRequest var1, ResponseHandler<T> var2, HttpContext var3, zzewn var4, zzevz var5) throws IOException {
      zzevv var10 = zzevv.a(var5);

      Long var6;
      try {
         var10.a(var1.getURI().toString()).b(var1.getMethod());
         var6 = zzh.a(var1);
      } catch (IOException var9) {
         var10.f(var4.c());
         zzh.a(var10);
         throw var9;
      }

      if (var6 != null) {
         try {
            var10.a(var6);
         } catch (IOException var8) {
            var10.f(var4.c());
            zzh.a(var10);
            throw var8;
         }
      }

      try {
         var4.a();
         var10.c(var4.b());
         zzf var11 = new zzf(var2, var4, var10);
         return (T)var0.execute(var1, var11, var3);
      } catch (IOException var7) {
         var10.f(var4.c());
         zzh.a(var10);
         throw var7;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static HttpResponse a(HttpClient var0, HttpHost var1, HttpRequest var2, zzewn var3, zzevz var4) throws IOException {
      zzevv var5 = zzevv.a(var4);

      label66: {
         try {
            var19 = String.valueOf(var1.toURI());
            String var6 = String.valueOf(var2.getRequestLine().getUri());
            if (var6.length() != 0) {
               var20 = var19.concat(var6);
               break label66;
            }
         } catch (IOException var15) {
            var5.f(var3.c());
            zzh.a(var5);
            throw var15;
         }

         try {
            var20 = new String(var19);
         } catch (IOException var14) {
            var5.f(var3.c());
            zzh.a(var5);
            throw var14;
         }
      }

      try {
         var5.a(var20).b(var2.getRequestLine().getMethod());
         var21 = zzh.a(var2);
      } catch (IOException var13) {
         var5.f(var3.c());
         zzh.a(var5);
         throw var13;
      }

      if (var21 != null) {
         try {
            var5.a(var21);
         } catch (IOException var12) {
            var5.f(var3.c());
            zzh.a(var5);
            throw var12;
         }
      }

      try {
         var3.a();
         var5.c(var3.b());
         var16 = var0.execute(var1, var2);
         var5.f(var3.c());
         var5.a(var16.getStatusLine().getStatusCode());
         var17 = zzh.a((HttpMessage)var16);
      } catch (IOException var11) {
         var5.f(var3.c());
         zzh.a(var5);
         throw var11;
      }

      if (var17 != null) {
         try {
            var5.b(var17);
         } catch (IOException var10) {
            var5.f(var3.c());
            zzh.a(var5);
            throw var10;
         }
      }

      try {
         var18 = zzh.a(var16);
      } catch (IOException var9) {
         var5.f(var3.c());
         zzh.a(var5);
         throw var9;
      }

      if (var18 != null) {
         try {
            var5.c(var18);
         } catch (IOException var8) {
            var5.f(var3.c());
            zzh.a(var5);
            throw var8;
         }
      }

      try {
         var5.d();
         return var16;
      } catch (IOException var7) {
         var5.f(var3.c());
         zzh.a(var5);
         throw var7;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static HttpResponse a(HttpClient var0, HttpHost var1, HttpRequest var2, HttpContext var3, zzewn var4, zzevz var5) throws IOException {
      zzevv var6 = zzevv.a(var5);

      label66: {
         String var7;
         try {
            var7 = String.valueOf(var1.toURI());
            String var20 = String.valueOf(var2.getRequestLine().getUri());
            if (var20.length() != 0) {
               var21 = var7.concat(var20);
               break label66;
            }
         } catch (IOException var16) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var16;
         }

         try {
            var21 = new String(var7);
         } catch (IOException var15) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var15;
         }
      }

      try {
         var6.a(var21).b(var2.getRequestLine().getMethod());
         var22 = zzh.a(var2);
      } catch (IOException var14) {
         var6.f(var4.c());
         zzh.a(var6);
         throw var14;
      }

      if (var22 != null) {
         try {
            var6.a(var22);
         } catch (IOException var13) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var13;
         }
      }

      try {
         var4.a();
         var6.c(var4.b());
         var17 = var0.execute(var1, var2, var3);
         var6.f(var4.c());
         var6.a(var17.getStatusLine().getStatusCode());
         var18 = zzh.a((HttpMessage)var17);
      } catch (IOException var12) {
         var6.f(var4.c());
         zzh.a(var6);
         throw var12;
      }

      if (var18 != null) {
         try {
            var6.b(var18);
         } catch (IOException var11) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var11;
         }
      }

      try {
         var19 = zzh.a(var17);
      } catch (IOException var10) {
         var6.f(var4.c());
         zzh.a(var6);
         throw var10;
      }

      if (var19 != null) {
         try {
            var6.c(var19);
         } catch (IOException var9) {
            var6.f(var4.c());
            zzh.a(var6);
            throw var9;
         }
      }

      try {
         var6.d();
         return var17;
      } catch (IOException var8) {
         var6.f(var4.c());
         zzh.a(var6);
         throw var8;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static HttpResponse a(HttpClient var0, HttpUriRequest var1, zzewn var2, zzevz var3) throws IOException {
      zzevv var15 = zzevv.a(var3);

      Long var4;
      try {
         var15.a(var1.getURI().toString()).b(var1.getMethod());
         var4 = zzh.a(var1);
      } catch (IOException var11) {
         var15.f(var2.c());
         zzh.a(var15);
         throw var11;
      }

      if (var4 != null) {
         try {
            var15.a(var4);
         } catch (IOException var10) {
            var15.f(var2.c());
            zzh.a(var15);
            throw var10;
         }
      }

      try {
         var2.a();
         var15.c(var2.b());
         var12 = var0.execute(var1);
         var15.f(var2.c());
         var15.a(var12.getStatusLine().getStatusCode());
         var13 = zzh.a((HttpMessage)var12);
      } catch (IOException var9) {
         var15.f(var2.c());
         zzh.a(var15);
         throw var9;
      }

      if (var13 != null) {
         try {
            var15.b(var13);
         } catch (IOException var8) {
            var15.f(var2.c());
            zzh.a(var15);
            throw var8;
         }
      }

      try {
         var14 = zzh.a(var12);
      } catch (IOException var7) {
         var15.f(var2.c());
         zzh.a(var15);
         throw var7;
      }

      if (var14 != null) {
         try {
            var15.c(var14);
         } catch (IOException var6) {
            var15.f(var2.c());
            zzh.a(var15);
            throw var6;
         }
      }

      try {
         var15.d();
         return var12;
      } catch (IOException var5) {
         var15.f(var2.c());
         zzh.a(var15);
         throw var5;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static HttpResponse a(HttpClient var0, HttpUriRequest var1, HttpContext var2, zzewn var3, zzevz var4) throws IOException {
      zzevv var16 = zzevv.a(var4);

      Long var5;
      try {
         var16.a(var1.getURI().toString()).b(var1.getMethod());
         var5 = zzh.a(var1);
      } catch (IOException var12) {
         var16.f(var3.c());
         zzh.a(var16);
         throw var12;
      }

      if (var5 != null) {
         try {
            var16.a(var5);
         } catch (IOException var11) {
            var16.f(var3.c());
            zzh.a(var16);
            throw var11;
         }
      }

      try {
         var3.a();
         var16.c(var3.b());
         var13 = var0.execute(var1, var2);
         var16.f(var3.c());
         var16.a(var13.getStatusLine().getStatusCode());
         var14 = zzh.a((HttpMessage)var13);
      } catch (IOException var10) {
         var16.f(var3.c());
         zzh.a(var16);
         throw var10;
      }

      if (var14 != null) {
         try {
            var16.b(var14);
         } catch (IOException var9) {
            var16.f(var3.c());
            zzh.a(var16);
            throw var9;
         }
      }

      try {
         var15 = zzh.a(var13);
      } catch (IOException var8) {
         var16.f(var3.c());
         zzh.a(var16);
         throw var8;
      }

      if (var15 != null) {
         try {
            var16.c(var15);
         } catch (IOException var7) {
            var16.f(var3.c());
            zzh.a(var16);
            throw var7;
         }
      }

      try {
         var16.d();
         return var13;
      } catch (IOException var6) {
         var16.f(var3.c());
         zzh.a(var16);
         throw var6;
      }
   }

   @Keep
   public static <T> T execute(HttpClient var0, HttpHost var1, HttpRequest var2, ResponseHandler<? extends T> var3) throws IOException {
      return a(var0, var1, var2, var3, new zzewn(), zzevz.a());
   }

   @Keep
   public static <T> T execute(HttpClient var0, HttpHost var1, HttpRequest var2, ResponseHandler<? extends T> var3, HttpContext var4) throws IOException {
      return a(var0, var1, var2, var3, var4, new zzewn(), zzevz.a());
   }

   @Keep
   public static <T> T execute(HttpClient var0, HttpUriRequest var1, ResponseHandler<T> var2) throws IOException {
      return a(var0, var1, var2, new zzewn(), zzevz.a());
   }

   @Keep
   public static <T> T execute(HttpClient var0, HttpUriRequest var1, ResponseHandler<T> var2, HttpContext var3) throws IOException {
      return a(var0, var1, var2, var3, new zzewn(), zzevz.a());
   }

   @Keep
   public static HttpResponse execute(HttpClient var0, HttpHost var1, HttpRequest var2) throws IOException {
      return a(var0, var1, var2, new zzewn(), zzevz.a());
   }

   @Keep
   public static HttpResponse execute(HttpClient var0, HttpHost var1, HttpRequest var2, HttpContext var3) throws IOException {
      return a(var0, var1, var2, var3, new zzewn(), zzevz.a());
   }

   @Keep
   public static HttpResponse execute(HttpClient var0, HttpUriRequest var1) throws IOException {
      return a(var0, var1, new zzewn(), zzevz.a());
   }

   @Keep
   public static HttpResponse execute(HttpClient var0, HttpUriRequest var1, HttpContext var2) throws IOException {
      return a(var0, var1, var2, new zzewn(), zzevz.a());
   }
}
