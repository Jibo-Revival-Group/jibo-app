package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Immutable
public class LaxContentLengthStrategy implements ContentLengthStrategy {
   public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
   private final int implicitLen;

   public LaxContentLengthStrategy() {
      this(-1);
   }

   public LaxContentLengthStrategy(int var1) {
      this.implicitLen = var1;
   }

   @Override
   public long determineLength(HttpMessage var1) throws HttpException {
      long var7 = -1L;
      Args.notNull(var1, "HTTP message");
      Header var9 = var1.getFirstHeader("Transfer-Encoding");
      long var3;
      if (var9 != null) {
         try {
            var12 = var9.getElements();
         } catch (ParseException var10) {
            throw new ProtocolException("Invalid Transfer-Encoding header value: " + var9, var10);
         }

         int var2 = var12.length;
         if ("identity".equalsIgnoreCase(var9.getValue())) {
            var3 = var7;
         } else {
            var3 = var7;
            if (var2 > 0) {
               var3 = var7;
               if ("chunked".equalsIgnoreCase(var12[var2 - 1].getName())) {
                  var3 = -2L;
               }
            }
         }
      } else if (var1.getFirstHeader("Content-Length") != null) {
         Header[] var13 = var1.getHeaders("Content-Length");
         int var14 = var13.length - 1;

         long var5;
         while (true) {
            if (var14 < 0) {
               var5 = -1L;
               break;
            }

            var9 = var13[var14];

            try {
               var5 = Long.parseLong(var9.getValue());
               break;
            } catch (NumberFormatException var11) {
               var14--;
            }
         }

         var3 = var7;
         if (var5 >= 0L) {
            var3 = var5;
         }
      } else {
         var3 = this.implicitLen;
      }

      return var3;
   }
}
