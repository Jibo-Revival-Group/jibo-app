package org.apache.http.ssl;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.apache.http.util.Args;

public final class PrivateKeyDetails {
   private final X509Certificate[] certChain;
   private final String type;

   public PrivateKeyDetails(String var1, X509Certificate[] var2) {
      this.type = Args.notNull(var1, "Private key type");
      this.certChain = var2;
   }

   public X509Certificate[] getCertChain() {
      return this.certChain;
   }

   public String getType() {
      return this.type;
   }

   @Override
   public String toString() {
      return this.type + ':' + Arrays.toString(this.certChain);
   }
}
