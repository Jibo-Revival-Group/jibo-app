package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Immutable
public class StrictContentLengthStrategy implements ContentLengthStrategy {
   public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
   private final int implicitLen;

   public StrictContentLengthStrategy() {
      this(-1);
   }

   public StrictContentLengthStrategy(int var1) {
      this.implicitLen = var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public long determineLength(HttpMessage var1) throws HttpException {
      Args.notNull(var1, "HTTP message");
      Header var6 = var1.getFirstHeader("Transfer-Encoding");
      long var2;
      if (var6 != null) {
         String var12 = var6.getValue();
         if ("chunked".equalsIgnoreCase(var12)) {
            if (var1.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
               throw new ProtocolException("Chunked transfer encoding not allowed for " + var1.getProtocolVersion());
            }

            var2 = -2L;
         } else {
            if (!"identity".equalsIgnoreCase(var12)) {
               throw new ProtocolException("Unsupported transfer encoding: " + var12);
            }

            var2 = -1L;
         }
      } else {
         Header var10 = var1.getFirstHeader("Content-Length");
         if (var10 != null) {
            String var11 = var10.getValue();

            long var4;
            try {
               var4 = Long.parseLong(var11);
            } catch (NumberFormatException var9) {
               throw new ProtocolException("Invalid content length: " + var11);
            }

            var2 = var4;
            if (var4 < 0L) {
               try {
                  StringBuilder var13 = new StringBuilder();
                  ProtocolException var7 = new ProtocolException(var13.append("Negative content length: ").append(var11).toString());
                  throw var7;
               } catch (NumberFormatException var8) {
                  throw new ProtocolException("Invalid content length: " + var11);
               }
            }
         } else {
            var2 = this.implicitLen;
         }
      }

      return var2;
   }
}
