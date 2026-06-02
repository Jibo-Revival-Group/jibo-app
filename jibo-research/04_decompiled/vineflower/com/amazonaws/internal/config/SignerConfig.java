package com.amazonaws.internal.config;

public class SignerConfig {
   private final String signerType;

   SignerConfig(String var1) {
      this.signerType = var1;
   }

   public String getSignerType() {
      return this.signerType;
   }

   @Override
   public String toString() {
      return this.signerType;
   }
}
