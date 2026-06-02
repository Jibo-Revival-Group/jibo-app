package org.apache.http.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.http.annotation.Immutable;

@Immutable
public class SSLContexts {
   public static SSLContext createDefault() throws SSLInitializationException {
      try {
         SSLContext var0 = SSLContext.getInstance("TLS");
         var0.init(null, null, null);
         return var0;
      } catch (NoSuchAlgorithmException var1) {
         throw new SSLInitializationException(var1.getMessage(), var1);
      } catch (KeyManagementException var2) {
         throw new SSLInitializationException(var2.getMessage(), var2);
      }
   }

   public static SSLContext createSystemDefault() throws SSLInitializationException {
      SSLContext var0;
      try {
         var0 = SSLContext.getDefault();
      } catch (NoSuchAlgorithmException var1) {
         var0 = createDefault();
      }

      return var0;
   }

   public static SSLContextBuilder custom() {
      return SSLContextBuilder.create();
   }
}
