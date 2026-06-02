package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
   private final UriPatternMatcher<HttpRequestHandler> matcher;

   public UriHttpRequestHandlerMapper() {
      this(new UriPatternMatcher<>());
   }

   protected UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> var1) {
      this.matcher = Args.notNull(var1, "Pattern matcher");
   }

   protected String getRequestPath(HttpRequest var1) {
      String var3 = var1.getRequestLine().getUri();
      int var2 = var3.indexOf("?");
      String var4;
      if (var2 != -1) {
         var4 = var3.substring(0, var2);
      } else {
         var2 = var3.indexOf("#");
         var4 = var3;
         if (var2 != -1) {
            var4 = var3.substring(0, var2);
         }
      }

      return var4;
   }

   @Override
   public HttpRequestHandler lookup(HttpRequest var1) {
      Args.notNull(var1, "HTTP request");
      return this.matcher.lookup(this.getRequestPath(var1));
   }

   public void register(String var1, HttpRequestHandler var2) {
      Args.notNull(var1, "Pattern");
      Args.notNull(var2, "Handler");
      this.matcher.register(var1, var2);
   }

   public void unregister(String var1) {
      this.matcher.unregister(var1);
   }
}
