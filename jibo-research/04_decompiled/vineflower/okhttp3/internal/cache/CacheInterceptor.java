package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor implements Interceptor {
   final InternalCache a;

   public CacheInterceptor(InternalCache var1) {
      this.a = var1;
   }

   private static Headers a(Headers var0, Headers var1) {
      byte var3 = 0;
      Headers.Builder var5 = new Headers.Builder();
      int var4 = var0.a();

      for (int var2 = 0; var2 < var4; var2++) {
         String var6 = var0.a(var2);
         String var7 = var0.b(var2);
         if ((!"Warning".equalsIgnoreCase(var6) || !var7.startsWith("1")) && (!a(var6) || var1.a(var6) == null)) {
            Internal.a.a(var5, var6, var7);
         }
      }

      var4 = var1.a();

      for (int var9 = var3; var9 < var4; var9++) {
         String var8 = var1.a(var9);
         if (!"Content-Length".equalsIgnoreCase(var8) && a(var8)) {
            Internal.a.a(var5, var8, var1.b(var9));
         }
      }

      return var5.a();
   }

   private static Response a(Response var0) {
      Response var1 = var0;
      if (var0 != null) {
         var1 = var0;
         if (var0.h() != null) {
            var1 = var0.i().a((ResponseBody)null).a();
         }
      }

      return var1;
   }

   private Response a(CacheRequest var1, Response var2) throws IOException {
      Response var3;
      if (var1 == null) {
         var3 = var2;
      } else {
         Sink var4 = var1.b();
         var3 = var2;
         if (var4 != null) {
            Source var5 = new Source(this, var2.h().c(), var1, Okio.a(var4)) {
               boolean a;
               final BufferedSource b;
               final CacheRequest c;
               final BufferedSink d;
               final CacheInterceptor e;

               {
                  this.e = var1;
                  this.b = var2x;
                  this.c = var3x;
                  this.d = var4x;
               }

               @Override
               public long a(Buffer var1, long var2x) throws IOException {
                  try {
                     var2x = this.b.a(var1, var2x);
                  } catch (IOException var4x) {
                     if (!this.a) {
                        this.a = true;
                        this.c.a();
                     }

                     throw var4x;
                  }

                  if (var2x == -1L) {
                     if (!this.a) {
                        this.a = true;
                        this.d.close();
                     }

                     var2x = -1L;
                  } else {
                     var1.a(this.d.c(), var1.b() - var2x, var2x);
                     this.d.x();
                  }

                  return var2x;
               }

               @Override
               public Timeout a() {
                  return this.b.a();
               }

               @Override
               public void close() throws IOException {
                  if (!this.a && !Util.a(this, 100, TimeUnit.MILLISECONDS)) {
                     this.a = true;
                     this.c.a();
                  }

                  this.b.close();
               }
            };
            var3 = var2.i().a(new RealResponseBody(var2.g(), Okio.a(var5))).a();
         }
      }

      return var3;
   }

   static boolean a(String var0) {
      boolean var1;
      if (!"Connection".equalsIgnoreCase(var0)
         && !"Keep-Alive".equalsIgnoreCase(var0)
         && !"Proxy-Authenticate".equalsIgnoreCase(var0)
         && !"Proxy-Authorization".equalsIgnoreCase(var0)
         && !"TE".equalsIgnoreCase(var0)
         && !"Trailers".equalsIgnoreCase(var0)
         && !"Transfer-Encoding".equalsIgnoreCase(var0)
         && !"Upgrade".equalsIgnoreCase(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public Response a(Interceptor.Chain var1) throws IOException {
      Response var2;
      if (this.a != null) {
         var2 = this.a.a(var1.a());
      } else {
         var2 = null;
      }

      CacheStrategy var5 = new CacheStrategy.Factory(System.currentTimeMillis(), var1.a(), var2).a();
      Request var3 = var5.a;
      Response var4 = var5.b;
      if (this.a != null) {
         this.a.a(var5);
      }

      if (var2 != null && var4 == null) {
         Util.a(var2.h());
      }

      Response var11;
      if (var3 == null && var4 == null) {
         var11 = new Response.Builder()
            .a(var1.a())
            .a(Protocol.HTTP_1_1)
            .a(504)
            .a("Unsatisfiable Request (only-if-cached)")
            .a(Util.c)
            .a(-1L)
            .b(System.currentTimeMillis())
            .a();
      } else if (var3 == null) {
         var11 = var4.i().b(a(var4)).a();
      } else {
         boolean var8 = false /* VF: Semaphore variable */;

         try {
            var8 = true;
            var13 = var1.a(var3);
            var8 = false;
         } finally {
            if (var8) {
               if (true && var2 != null) {
                  Util.a(var2.h());
               }
            }
         }

         if (var13 == null && var2 != null) {
            Util.a(var2.h());
         }

         if (var4 != null) {
            if (var13.c() == 304) {
               Response var17 = var4.i().a(a(var4.g(), var13.g())).a(var13.l()).b(var13.m()).b(a(var4)).a(a(var13)).a();
               var13.h().close();
               this.a.a();
               this.a.a(var4, var17);
               return var17;
            }

            Util.a(var4.h());
         }

         var2 = var13.i().b(a(var4)).a(a(var13)).a();
         var11 = var2;
         if (this.a != null) {
            if (HttpHeaders.d(var2) && CacheStrategy.a(var2, var3)) {
               var11 = this.a(this.a.a(var2), var2);
            } else {
               var11 = var2;
               if (HttpMethod.a(var3.b())) {
                  try {
                     this.a.b(var3);
                  } catch (IOException var10) {
                     Response var16 = var2;
                     return var16;
                  }

                  var11 = var2;
               }
            }
         }
      }

      return var11;
   }
}
