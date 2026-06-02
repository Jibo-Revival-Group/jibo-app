package org.apache.http.protocol;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.http.HttpConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class RequestTargetHost implements HttpRequestInterceptor {
   @Override
   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      HttpCoreContext var4 = HttpCoreContext.adapt(var2);
      ProtocolVersion var5 = var1.getRequestLine().getProtocolVersion();
      if ((!var1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !var5.lessEquals(HttpVersion.HTTP_1_0)) && !var1.containsHeader("Host")) {
         HttpHost var7 = var4.getTargetHost();
         HttpHost var9;
         if (var7 == null) {
            HttpConnection var6 = var4.getConnection();
            if (var6 instanceof HttpInetConnection) {
               InetAddress var8 = ((HttpInetConnection)var6).getRemoteAddress();
               int var3 = ((HttpInetConnection)var6).getRemotePort();
               if (var8 != null) {
                  var7 = new HttpHost(var8.getHostName(), var3);
               }
            }

            var9 = var7;
            if (var7 == null) {
               if (!var5.lessEquals(HttpVersion.HTTP_1_0)) {
                  throw new ProtocolException("Target host missing");
               }

               return;
            }
         } else {
            var9 = var7;
         }

         var1.addHeader("Host", var9.toHostString());
      }
   }
}
