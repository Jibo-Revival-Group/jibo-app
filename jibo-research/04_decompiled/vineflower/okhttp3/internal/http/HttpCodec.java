package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

public interface HttpCodec {
   Response.Builder a(boolean var1) throws IOException;

   ResponseBody a(Response var1) throws IOException;

   Sink a(Request var1, long var2);

   void a() throws IOException;

   void a(Request var1) throws IOException;

   void b() throws IOException;

   void c();
}
