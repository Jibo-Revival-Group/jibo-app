package org.apache.http;

import java.io.Serializable;
import org.apache.http.annotation.Immutable;

@Immutable
public final class HttpVersion extends ProtocolVersion implements Serializable {
   public static final String HTTP = "HTTP";
   public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
   public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
   public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
   private static final long serialVersionUID = -5856653513894415344L;

   public HttpVersion(int var1, int var2) {
      super("HTTP", var1, var2);
   }

   @Override
   public ProtocolVersion forVersion(int var1, int var2) {
      HttpVersion var3;
      if (var1 == this.major && var2 == this.minor) {
         var3 = this;
      } else {
         if (var1 == 1) {
            if (var2 == 0) {
               var3 = HTTP_1_0;
               return var3;
            }

            if (var2 == 1) {
               var3 = HTTP_1_1;
               return var3;
            }
         }

         if (var1 == 0 && var2 == 9) {
            var3 = HTTP_0_9;
         } else {
            var3 = new HttpVersion(var1, var2);
         }
      }

      return var3;
   }
}
