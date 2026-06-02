package okhttp3.logging;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

public final class HttpLoggingInterceptor implements Interceptor {
   private static final Charset a = Charset.forName("UTF-8");
   private final HttpLoggingInterceptor.Logger b;
   private volatile HttpLoggingInterceptor.Level c = HttpLoggingInterceptor.Level.NONE;

   public HttpLoggingInterceptor() {
      this(HttpLoggingInterceptor.Logger.a);
   }

   public HttpLoggingInterceptor(HttpLoggingInterceptor.Logger var1) {
      this.b = var1;
   }

   private boolean a(Headers var1) {
      String var3 = var1.a("Content-Encoding");
      boolean var2;
      if (var3 != null && !var3.equalsIgnoreCase("identity")) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static boolean a(Buffer var0) {
      long var3 = 64L;

      Buffer var6;
      try {
         var6 = new Buffer();
      } catch (EOFException var11) {
         return false;
      }

      try {
         if (var0.b() < 64L) {
            var3 = var0.b();
         }
      } catch (EOFException var10) {
         return false;
      }

      try {
         var0.a(var6, 0L, var3);
      } catch (EOFException var9) {
         return false;
      }

      for (int var1 = 0; var1 < 16; var1++) {
         try {
            if (var6.f()) {
               break;
            }
         } catch (EOFException var7) {
            return false;
         }

         boolean var12;
         try {
            int var2 = var6.s();
            if (!Character.isISOControl(var2)) {
               continue;
            }

            var12 = Character.isWhitespace(var2);
         } catch (EOFException var8) {
            return false;
         }

         if (!var12) {
            return false;
         }
      }

      return true;
   }

   @Override
   public Response a(Interceptor.Chain var1) throws IOException {
      HttpLoggingInterceptor.Level var11 = this.c;
      Request var13 = var1.a();
      Response var17;
      if (var11 == HttpLoggingInterceptor.Level.NONE) {
         var17 = var1.a(var13);
      } else {
         boolean var2;
         if (var11 == HttpLoggingInterceptor.Level.BODY) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3;
         if (!var2 && var11 != HttpLoggingInterceptor.Level.HEADERS) {
            var3 = 0;
         } else {
            var3 = 1;
         }

         RequestBody var14 = var13.d();
         boolean var4;
         if (var14 != null) {
            var4 = true;
         } else {
            var4 = false;
         }

         Connection var21 = var1.b();
         Protocol var22;
         if (var21 != null) {
            var22 = var21.b();
         } else {
            var22 = Protocol.HTTP_1_1;
         }

         String var12 = "--> " + var13.b() + ' ' + var13.a() + ' ' + var22;
         String var23 = var12;
         if (!var3) {
            var23 = var12;
            if (var4) {
               var23 = var12 + " (" + var14.b() + "-byte body)";
            }
         }

         this.b.a(var23);
         if (var3) {
            if (var4) {
               if (var14.a() != null) {
                  this.b.a("Content-Type: " + var14.a());
               }

               if (var14.b() != -1L) {
                  this.b.a("Content-Length: " + var14.b());
               }
            }

            Headers var31 = var13.c();
            int var5 = 0;

            for (int var6 = var31.a(); var5 < var6; var5++) {
               String var24 = var31.a(var5);
               if (!"Content-Type".equalsIgnoreCase(var24) && !"Content-Length".equalsIgnoreCase(var24)) {
                  this.b.a(var24 + ": " + var31.b(var5));
               }
            }

            if (!var2 || !var4) {
               this.b.a("--> END " + var13.b());
            } else if (this.a(var13.c())) {
               this.b.a("--> END " + var13.b() + " (encoded body omitted)");
            } else {
               Buffer var32 = new Buffer();
               var14.a(var32);
               Charset var25 = a;
               MediaType var15 = var14.a();
               if (var15 != null) {
                  var25 = var15.a(a);
               }

               this.b.a("");
               if (a(var32)) {
                  this.b.a(var32.a(var25));
                  this.b.a("--> END " + var13.b() + " (" + var14.b() + "-byte body)");
               } else {
                  this.b.a("--> END " + var13.b() + " (binary " + var14.b() + "-byte body omitted)");
               }
            }
         }

         long var7 = System.nanoTime();

         try {
            var17 = var1.a(var13);
         } catch (Exception var16) {
            this.b.a("<-- HTTP FAILED: " + var16);
            throw var16;
         }

         long var9 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - var7);
         ResponseBody var33 = var17.h();
         var7 = var33.b();
         String var26;
         if (var7 != -1L) {
            var26 = var7 + "-byte";
         } else {
            var26 = "unknown-length";
         }

         HttpLoggingInterceptor.Logger var37 = this.b;
         StringBuilder var35 = new StringBuilder()
            .append("<-- ")
            .append(var17.c())
            .append(' ')
            .append(var17.e())
            .append(' ')
            .append(var17.a().a())
            .append(" (")
            .append(var9)
            .append("ms");
         String var27;
         if (!var3) {
            var27 = ", " + var26 + " body";
         } else {
            var27 = "";
         }

         var37.a(var35.append(var27).append(')').toString());
         if (var3) {
            Headers var28 = var17.g();
            var3 = 0;

            for (int var19 = var28.a(); var3 < var19; var3++) {
               this.b.a(var28.a(var3) + ": " + var28.b(var3));
            }

            if (!var2 || !HttpHeaders.d(var17)) {
               this.b.a("<-- END HTTP");
            } else if (this.a(var17.g())) {
               this.b.a("<-- END HTTP (encoded body omitted)");
            } else {
               BufferedSource var29 = var33.c();
               var29.b(Long.MAX_VALUE);
               Buffer var36 = var29.c();
               Charset var30 = a;
               MediaType var34 = var33.a();
               if (var34 != null) {
                  var30 = var34.a(a);
               }

               if (!a(var36)) {
                  this.b.a("");
                  this.b.a("<-- END HTTP (binary " + var36.b() + "-byte body omitted)");
               } else {
                  if (var7 != 0L) {
                     this.b.a("");
                     this.b.a(var36.v().a(var30));
                  }

                  this.b.a("<-- END HTTP (" + var36.b() + "-byte body)");
               }
            }
         }
      }

      return var17;
   }

   public HttpLoggingInterceptor a(HttpLoggingInterceptor.Level var1) {
      if (var1 == null) {
         throw new NullPointerException("level == null. Use Level.NONE instead.");
      }

      this.c = var1;
      return this;
   }

   public enum Level {
      BASIC,
      BODY,
      HEADERS,
      NONE;

      private static final HttpLoggingInterceptor.Level[] $VALUES = new HttpLoggingInterceptor.Level[]{
         HttpLoggingInterceptor.Level.NONE, HttpLoggingInterceptor.Level.BASIC, HttpLoggingInterceptor.Level.HEADERS, HttpLoggingInterceptor.Level.BODY
      };
   }

   public interface Logger {
      HttpLoggingInterceptor.Logger a = new HttpLoggingInterceptor.Logger() {
         @Override
         public void a(String var1) {
            Platform.b().a(4, var1, null);
         }
      };

      void a(String var1);
   }
}
