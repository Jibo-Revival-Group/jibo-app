package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

public final class CacheStrategy {
   public final Request a;
   public final Response b;

   CacheStrategy(Request var1, Response var2) {
      this.a = var1;
      this.b = var2;
   }

   public static boolean a(Response var0, Request var1) {
      boolean var3 = false;
      boolean var2;
      switch (var0.c()) {
         case 302:
         case 307:
            if (var0.a("Expires") == null && var0.k().c() == -1 && !var0.k().e()) {
               var2 = var3;
               if (!var0.k().d()) {
                  break;
               }
            }
         case 200:
         case 203:
         case 204:
         case 300:
         case 301:
         case 308:
         case 404:
         case 405:
         case 410:
         case 414:
         case 501:
            var2 = var3;
            if (!var0.k().b()) {
               var2 = var3;
               if (!var1.f().b()) {
                  var2 = true;
               }
            }
            break;
         default:
            var2 = var3;
      }

      return var2;
   }

   public static class Factory {
      final long a;
      final Request b;
      final Response c;
      private Date d;
      private String e;
      private Date f;
      private String g;
      private Date h;
      private long i;
      private long j;
      private String k;
      private int l = -1;

      public Factory(long var1, Request var3, Response var4) {
         this.a = var1;
         this.b = var3;
         this.c = var4;
         if (var4 != null) {
            this.i = var4.l();
            this.j = var4.m();
            Headers var7 = var4.g();
            int var5 = 0;

            for (int var6 = var7.a(); var5 < var6; var5++) {
               String var9 = var7.a(var5);
               String var8 = var7.b(var5);
               if ("Date".equalsIgnoreCase(var9)) {
                  this.d = HttpDate.a(var8);
                  this.e = var8;
               } else if ("Expires".equalsIgnoreCase(var9)) {
                  this.h = HttpDate.a(var8);
               } else if ("Last-Modified".equalsIgnoreCase(var9)) {
                  this.f = HttpDate.a(var8);
                  this.g = var8;
               } else if ("ETag".equalsIgnoreCase(var9)) {
                  this.k = var8;
               } else if ("Age".equalsIgnoreCase(var9)) {
                  this.l = HttpHeaders.b(var8, -1);
               }
            }
         }
      }

      private static boolean a(Request var0) {
         boolean var1;
         if (var0.a("If-Modified-Since") == null && var0.a("If-None-Match") == null) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      private CacheStrategy b() {
         long var7 = 0L;
         CacheStrategy var11;
         if (this.c == null) {
            var11 = new CacheStrategy(this.b, null);
         } else if (this.b.g() && this.c.f() == null) {
            var11 = new CacheStrategy(this.b, null);
         } else if (!CacheStrategy.a(this.c, this.b)) {
            var11 = new CacheStrategy(this.b, null);
         } else {
            CacheControl var15 = this.b.f();
            if (!var15.a() && !a(this.b)) {
               long var9 = this.d();
               long var3 = this.c();
               long var1 = var3;
               if (var15.c() != -1) {
                  var1 = Math.min(var3, TimeUnit.SECONDS.toMillis(var15.c()));
               }

               if (var15.h() != -1) {
                  var3 = TimeUnit.SECONDS.toMillis(var15.h());
               } else {
                  var3 = 0L;
               }

               CacheControl var12 = this.c.k();
               long var5 = var7;
               if (!var12.f()) {
                  var5 = var7;
                  if (var15.g() != -1) {
                     var5 = TimeUnit.SECONDS.toMillis(var15.g());
                  }
               }

               if (!var12.a() && var9 + var3 < var5 + var1) {
                  Response.Builder var17 = this.c.i();
                  if (var3 + var9 >= var1) {
                     var17.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                  }

                  if (var9 > 86400000L && this.e()) {
                     var17.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                  }

                  var11 = new CacheStrategy(null, var17.a());
               } else {
                  String var16;
                  String var18;
                  if (this.k != null) {
                     var18 = "If-None-Match";
                     var16 = this.k;
                  } else if (this.f != null) {
                     var18 = "If-Modified-Since";
                     var16 = this.g;
                  } else {
                     if (this.d == null) {
                        var11 = new CacheStrategy(this.b, null);
                        return var11;
                     }

                     var18 = "If-Modified-Since";
                     var16 = this.e;
                  }

                  Headers.Builder var13 = this.b.c().b();
                  Internal.a.a(var13, var18, var16);
                  var11 = new CacheStrategy(this.b.e().a(var13.a()).c(), this.c);
               }
            } else {
               var11 = new CacheStrategy(this.b, null);
            }
         }

         return var11;
      }

      private long c() {
         long var3 = 0L;
         CacheControl var7 = this.c.k();
         long var1;
         if (var7.c() != -1) {
            var1 = TimeUnit.SECONDS.toMillis(var7.c());
         } else if (this.h != null) {
            if (this.d != null) {
               var1 = this.d.getTime();
            } else {
               var1 = this.j;
            }

            var1 = this.h.getTime() - var1;
            if (var1 <= 0L) {
               var1 = 0L;
            }
         } else {
            var1 = var3;
            if (this.f != null) {
               var1 = var3;
               if (this.c.a().a().m() == null) {
                  if (this.d != null) {
                     var1 = this.d.getTime();
                  } else {
                     var1 = this.i;
                  }

                  long var5 = var1 - this.f.getTime();
                  var1 = var3;
                  if (var5 > 0L) {
                     var1 = var5 / 10L;
                  }
               }
            }
         }

         return var1;
      }

      private long d() {
         long var1 = 0L;
         if (this.d != null) {
            var1 = Math.max(0L, this.j - this.d.getTime());
         }

         long var3 = var1;
         if (this.l != -1) {
            var3 = Math.max(var1, TimeUnit.SECONDS.toMillis(this.l));
         }

         return var3 + (this.j - this.i) + (this.a - this.j);
      }

      private boolean e() {
         boolean var1;
         if (this.c.k().c() == -1 && this.h == null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public CacheStrategy a() {
         CacheStrategy var2 = this.b();
         CacheStrategy var1 = var2;
         if (var2.a != null) {
            var1 = var2;
            if (this.b.f().i()) {
               var1 = new CacheStrategy(null, null);
            }
         }

         return var1;
      }
   }
}
