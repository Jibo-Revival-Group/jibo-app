package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

public final class BridgeInterceptor implements Interceptor {
   private final CookieJar a;

   public BridgeInterceptor(CookieJar var1) {
      this.a = var1;
   }

   private String a(List<Cookie> var1) {
      StringBuilder var5 = new StringBuilder();
      int var3 = var1.size();

      for (int var2 = 0; var2 < var3; var2++) {
         if (var2 > 0) {
            var5.append("; ");
         }

         Cookie var4 = (Cookie)var1.get(var2);
         var5.append(var4.a()).append('=').append(var4.b());
      }

      return var5.toString();
   }

   @Override
   public Response a(Interceptor.Chain var1) throws IOException {
      boolean var3 = false;
      Request var6 = var1.a();
      Request.Builder var7 = var6.e();
      RequestBody var8 = var6.d();
      if (var8 != null) {
         MediaType var9 = var8.a();
         if (var9 != null) {
            var7.a("Content-Type", var9.toString());
         }

         long var4 = var8.b();
         if (var4 != -1L) {
            var7.a("Content-Length", Long.toString(var4));
            var7.b("Transfer-Encoding");
         } else {
            var7.a("Transfer-Encoding", "chunked");
            var7.b("Content-Length");
         }
      }

      if (var6.a("Host") == null) {
         var7.a("Host", Util.a(var6.a(), false));
      }

      if (var6.a("Connection") == null) {
         var7.a("Connection", "Keep-Alive");
      }

      boolean var2 = var3;
      if (var6.a("Accept-Encoding") == null) {
         var2 = var3;
         if (var6.a("Range") == null) {
            var2 = true;
            var7.a("Accept-Encoding", "gzip");
         }
      }

      List var14 = this.a.a(var6.a());
      if (!var14.isEmpty()) {
         var7.a("Cookie", this.a(var14));
      }

      if (var6.a("User-Agent") == null) {
         var7.a("User-Agent", Version.a());
      }

      Response var12 = var1.a(var7.c());
      HttpHeaders.a(this.a, var6.a(), var12.g());
      Response.Builder var10 = var12.i().a(var6);
      if (var2 && "gzip".equalsIgnoreCase(var12.a("Content-Encoding")) && HttpHeaders.d(var12)) {
         GzipSource var11 = new GzipSource(var12.h().c());
         Headers var13 = var12.g().b().b("Content-Encoding").b("Content-Length").a();
         var10.a(var13);
         var10.a(new RealResponseBody(var13, Okio.a(var11)));
      }

      return var10.a();
   }
}
