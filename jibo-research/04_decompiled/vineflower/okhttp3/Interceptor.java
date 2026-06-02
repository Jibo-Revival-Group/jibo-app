package okhttp3;

import java.io.IOException;

public interface Interceptor {
   Response a(Interceptor.Chain var1) throws IOException;

   interface Chain {
      Request a();

      Response a(Request var1) throws IOException;

      Connection b();
   }
}
