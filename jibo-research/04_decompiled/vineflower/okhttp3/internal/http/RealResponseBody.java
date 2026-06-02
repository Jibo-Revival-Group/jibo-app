package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
   private final Headers a;
   private final BufferedSource b;

   public RealResponseBody(Headers var1, BufferedSource var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public MediaType a() {
      String var1 = this.a.a("Content-Type");
      MediaType var2;
      if (var1 != null) {
         var2 = MediaType.a(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public long b() {
      return HttpHeaders.a(this.a);
   }

   @Override
   public BufferedSource c() {
      return this.b;
   }
}
