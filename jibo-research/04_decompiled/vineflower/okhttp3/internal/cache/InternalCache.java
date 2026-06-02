package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

public interface InternalCache {
   Response a(Request var1) throws IOException;

   CacheRequest a(Response var1) throws IOException;

   void a();

   void a(Response var1, Response var2);

   void a(CacheStrategy var1);

   void b(Request var1) throws IOException;
}
