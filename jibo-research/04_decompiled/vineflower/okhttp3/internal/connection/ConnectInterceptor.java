package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

public final class ConnectInterceptor implements Interceptor {
   public final OkHttpClient a;

   public ConnectInterceptor(OkHttpClient var1) {
      this.a = var1;
   }

   @Override
   public Response a(Interceptor.Chain var1) throws IOException {
      RealInterceptorChain var4 = (RealInterceptorChain)var1;
      Request var5 = var4.a();
      StreamAllocation var3 = var4.c();
      boolean var2;
      if (!var5.b().equals("GET")) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var4.a(var5, var3, var3.a(this.a, var2), var3.b());
   }
}
