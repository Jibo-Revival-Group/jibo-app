package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
   public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

   private boolean canResponseHaveBody(HttpResponse var1) {
      int var2 = var1.getStatusLine().getStatusCode();
      boolean var3;
      if (var2 >= 200 && var2 != 204 && var2 != 304 && var2 != 205) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   protected TokenIterator createTokenIterator(HeaderIterator var1) {
      return new BasicTokenIterator(var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean keepAlive(HttpResponse var1, HttpContext var2) {
      boolean var6 = true;
      boolean var5 = false;
      Args.notNull(var1, "HTTP response");
      Args.notNull(var2, "HTTP context");
      ProtocolVersion var8 = var1.getStatusLine().getProtocolVersion();
      Header var14 = var1.getFirstHeader("Transfer-Encoding");
      if (var14 != null) {
         if (!"chunked".equalsIgnoreCase(var14.getValue())) {
            return var5;
         }
      } else if (this.canResponseHaveBody(var1)) {
         Header[] var15 = var1.getHeaders("Content-Length");
         boolean var4 = var5;
         if (var15.length != 1) {
            return var4;
         }

         Header var16 = var15[0];

         int var3;
         try {
            var3 = Integer.parseInt(var16.getValue());
         } catch (NumberFormatException var12) {
            var4 = var5;
            return var4;
         }

         var4 = var5;
         if (var3 < 0) {
            return var4;
         }
      }

      HeaderIterator var7 = var1.headerIterator("Connection");
      HeaderIterator var17 = var7;
      if (!var7.hasNext()) {
         var17 = var1.headerIterator("Proxy-Connection");
      }

      if (var17.hasNext()) {
         try {
            var18 = this.createTokenIterator(var17);
         } catch (ParseException var10) {
            boolean var23 = var5;
            return var23;
         }

         boolean var19 = false;

         while (true) {
            try {
               if (!var18.hasNext()) {
                  break;
               }

               var13 = var18.nextToken();
            } catch (ParseException var11) {
               boolean var24 = var5;
               return var24;
            }

            boolean var25 = var5;

            try {
               if ("Close".equalsIgnoreCase(var13)) {
                  return var25;
               }

               var25 = "Keep-Alive".equalsIgnoreCase(var13);
            } catch (ParseException var9) {
               var25 = var5;
               return var25;
            }

            if (var25) {
               var19 = true;
            }
         }

         if (var19) {
            boolean var28 = true;
            return var28;
         }
      }

      boolean var27;
      if (!var8.lessEquals(HttpVersion.HTTP_1_0)) {
         var27 = var6;
      } else {
         var27 = false;
      }

      return var27;
   }
}
