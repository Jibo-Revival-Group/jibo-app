package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SignerFactory {
   private static final Map<String, Class<? extends Signer>> SIGNERS = new ConcurrentHashMap<>();

   static {
      SIGNERS.put("QueryStringSignerType", QueryStringSigner.class);
      SIGNERS.put("AWS3SignerType", AWS3Signer.class);
      SIGNERS.put("AWS4SignerType", AWS4Signer.class);
      SIGNERS.put("NoOpSignerType", NoOpSigner.class);
   }

   private static Signer createSigner(String var0, String var1) {
      Class var5 = SIGNERS.get(var0);
      if (var5 == null) {
         throw new IllegalArgumentException();
      }

      Signer var2;
      try {
         var2 = (Signer)var5.newInstance();
      } catch (InstantiationException var3) {
         throw new IllegalStateException("Cannot create an instance of " + var5.getName(), var3);
      } catch (IllegalAccessException var4) {
         throw new IllegalStateException("Cannot create an instance of " + var5.getName(), var4);
      }

      if (var2 instanceof ServiceAwareSigner) {
         ((ServiceAwareSigner)var2).setServiceName(var1);
      }

      return var2;
   }

   public static Signer getSigner(String var0, String var1) {
      return lookupAndCreateSigner(var0, var1);
   }

   public static Signer getSignerByTypeAndService(String var0, String var1) {
      return createSigner(var0, var1);
   }

   private static Signer lookupAndCreateSigner(String var0, String var1) {
      return createSigner(InternalConfig.Factory.getInternalConfig().getSignerConfig(var0, var1).getSignerType(), var0);
   }
}
