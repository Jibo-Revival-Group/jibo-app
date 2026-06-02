package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

public final class GoogleUtils {
   public static final Integer BUGFIX_VERSION = 0;
   public static final Integer MAJOR_VERSION = 1;
   public static final Integer MINOR_VERSION = 23;
   public static final String VERSION;
   static KeyStore certTrustStore;

   static {
      String var0 = String.valueOf(String.valueOf(MAJOR_VERSION));
      String var1 = String.valueOf(String.valueOf(MINOR_VERSION));
      String var2 = String.valueOf(String.valueOf(BUGFIX_VERSION));
      VERSION = new StringBuilder(var0.length() + 2 + var1.length() + var2.length())
         .append(var0)
         .append(".")
         .append(var1)
         .append(".")
         .append(var2)
         .toString()
         .toString();
   }

   private GoogleUtils() {
   }

   public static KeyStore getCertificateTrustStore() throws IOException, GeneralSecurityException {
      synchronized (GoogleUtils.class) {
         if (certTrustStore == null) {
            certTrustStore = SecurityUtils.getJavaKeyStore();
            InputStream var0 = GoogleUtils.class.getResourceAsStream("google.jks");
            SecurityUtils.loadKeyStore(certTrustStore, var0, "notasecret");
         }

         return certTrustStore;
      }
   }
}
