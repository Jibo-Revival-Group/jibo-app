package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSink;
import okio.Okio;

public final class CallServerInterceptor implements Interceptor {
   private final boolean a;

   public CallServerInterceptor(boolean var1) {
      this.a = var1;
   }

   @Override
   public Response a(Interceptor.Chain var1) throws IOException {
      var1 = var1;
      HttpCodec var7 = var1.d();
      StreamAllocation var6 = var1.c();
      RealConnection var5 = (RealConnection)var1.b();
      Request var8 = var1.a();
      long var3 = System.currentTimeMillis();
      var7.a(var8);
      Response.Builder var10 = null;
      if (HttpMethod.c(var8.b()) && var8.d() != null) {
         if ("100-continue".equalsIgnoreCase(var8.a("Expect"))) {
            var7.a();
            var10 = var7.a(true);
         }

         if (var10 == null) {
            BufferedSink var13 = Okio.a(var7.a(var8, var8.d().b()));
            var8.d().a(var13);
            var13.close();
         } else if (!var5.f()) {
            var6.d();
         }
      } else {
         var10 = null;
      }

      var7.b();
      Response.Builder var14 = var10;
      if (var10 == null) {
         var14 = var7.a(false);
      }

      Response var11 = var14.a(var8).a(var6.b().e()).a(var3).b(System.currentTimeMillis()).a();
      int var2 = var11.c();
      Response var12;
      if (this.a && var2 == 101) {
         var12 = var11.i().a(Util.c).a();
      } else {
         var12 = var11.i().a(var7.a(var11)).a();
      }

      if ("close".equalsIgnoreCase(var12.a().a("Connection")) || "close".equalsIgnoreCase(var12.a("Connection"))) {
         var6.d();
      }

      if ((var2 == 204 || var2 == 205) && var12.h().b() > 0L) {
         throw new ProtocolException("HTTP " + var2 + " had non-zero Content-Length: " + var12.h().b());
      } else {
         return var12;
      }
   }
}
