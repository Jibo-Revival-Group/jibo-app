package org.apache.http.impl;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.Args;

@Immutable
public class DefaultHttpRequestFactory implements HttpRequestFactory {
   public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
   private static final String[] RFC2616_COMMON_METHODS = new String[]{"GET"};
   private static final String[] RFC2616_ENTITY_ENC_METHODS = new String[]{"POST", "PUT"};
   private static final String[] RFC2616_SPECIAL_METHODS = new String[]{"HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"};

   private static boolean isOneOf(String[] var0, String var1) {
      boolean var5 = false;
      int var3 = var0.length;
      int var2 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var3) {
            break;
         }

         if (var0[var2].equalsIgnoreCase(var1)) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }

   @Override
   public HttpRequest newHttpRequest(String var1, String var2) throws MethodNotSupportedException {
      BasicHttpRequest var3;
      if (isOneOf(RFC2616_COMMON_METHODS, var1)) {
         var3 = new BasicHttpRequest(var1, var2);
      } else if (isOneOf(RFC2616_ENTITY_ENC_METHODS, var1)) {
         var3 = new BasicHttpEntityEnclosingRequest(var1, var2);
      } else {
         if (!isOneOf(RFC2616_SPECIAL_METHODS, var1)) {
            throw new MethodNotSupportedException(var1 + " method not supported");
         }

         var3 = new BasicHttpRequest(var1, var2);
      }

      return var3;
   }

   @Override
   public HttpRequest newHttpRequest(RequestLine var1) throws MethodNotSupportedException {
      Args.notNull(var1, "Request line");
      String var2 = var1.getMethod();
      BasicHttpRequest var3;
      if (isOneOf(RFC2616_COMMON_METHODS, var2)) {
         var3 = new BasicHttpRequest(var1);
      } else if (isOneOf(RFC2616_ENTITY_ENC_METHODS, var2)) {
         var3 = new BasicHttpEntityEnclosingRequest(var1);
      } else {
         if (!isOneOf(RFC2616_SPECIAL_METHODS, var2)) {
            throw new MethodNotSupportedException(var2 + " method not supported");
         }

         var3 = new BasicHttpRequest(var1);
      }

      return var3;
   }
}
