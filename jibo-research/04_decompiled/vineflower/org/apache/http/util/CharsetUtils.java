package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtils {
   public static Charset get(String var0) throws UnsupportedEncodingException {
      Charset var3;
      if (var0 == null) {
         var3 = null;
      } else {
         Charset var1;
         try {
            var1 = Charset.forName(var0);
         } catch (UnsupportedCharsetException var2) {
            throw new UnsupportedEncodingException(var0);
         }

         var3 = var1;
      }

      return var3;
   }

   public static Charset lookup(String var0) {
      Object var1 = null;
      Charset var3;
      if (var0 == null) {
         var3 = (Charset)var1;
      } else {
         try {
            var3 = Charset.forName(var0);
         } catch (UnsupportedCharsetException var2) {
            var3 = (Charset)var1;
         }
      }

      return var3;
   }
}
