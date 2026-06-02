package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class ResponseConnControl implements HttpResponseInterceptor {
   @Override
   public void process(HttpResponse var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      var2 = HttpCoreContext.adapt(var2);
      int var3 = var1.getStatusLine().getStatusCode();
      if (var3 != 400 && var3 != 408 && var3 != 411 && var3 != 413 && var3 != 414 && var3 != 503 && var3 != 501) {
         Header var4 = var1.getFirstHeader("Connection");
         if (var4 == null || !"Close".equalsIgnoreCase(var4.getValue())) {
            HttpEntity var5 = var1.getEntity();
            if (var5 != null) {
               ProtocolVersion var8 = var1.getStatusLine().getProtocolVersion();
               if (var5.getContentLength() < 0L && (!var5.isChunked() || var8.lessEquals(HttpVersion.HTTP_1_0))) {
                  var1.setHeader("Connection", "Close");
                  return;
               }
            }

            HttpRequest var7 = var2.getRequest();
            if (var7 != null) {
               var4 = var7.getFirstHeader("Connection");
               if (var4 != null) {
                  var1.setHeader("Connection", var4.getValue());
               } else if (var7.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                  var1.setHeader("Connection", "Close");
               }
            }
         }
      } else {
         var1.setHeader("Connection", "Close");
      }
   }
}
