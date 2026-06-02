package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Interceptor.Chain {
   private final List<Interceptor> a;
   private final StreamAllocation b;
   private final HttpCodec c;
   private final RealConnection d;
   private final int e;
   private final Request f;
   private int g;

   public RealInterceptorChain(List<Interceptor> var1, StreamAllocation var2, HttpCodec var3, RealConnection var4, int var5, Request var6) {
      this.a = var1;
      this.d = var4;
      this.b = var2;
      this.c = var3;
      this.e = var5;
      this.f = var6;
   }

   @Override
   public Request a() {
      return this.f;
   }

   @Override
   public Response a(Request var1) throws IOException {
      return this.a(var1, this.b, this.c, this.d);
   }

   public Response a(Request var1, StreamAllocation var2, HttpCodec var3, RealConnection var4) throws IOException {
      if (this.e >= this.a.size()) {
         throw new AssertionError();
      } else {
         this.g++;
         if (this.c != null && !this.d.a(var1.a())) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must retain the same host and port");
         } else if (this.c != null && this.g > 1) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must call proceed() exactly once");
         } else {
            RealInterceptorChain var6 = new RealInterceptorChain(this.a, var2, var3, var4, this.e + 1, var1);
            Interceptor var7 = this.a.get(this.e);
            Response var5 = var7.a(var6);
            if (var3 != null && this.e + 1 < this.a.size() && var6.g != 1) {
               throw new IllegalStateException("network interceptor " + var7 + " must call proceed() exactly once");
            } else if (var5 == null) {
               throw new NullPointerException("interceptor " + var7 + " returned null");
            } else {
               return var5;
            }
         }
      }
   }

   @Override
   public Connection b() {
      return this.d;
   }

   public StreamAllocation c() {
      return this.b;
   }

   public HttpCodec d() {
      return this.c;
   }
}
