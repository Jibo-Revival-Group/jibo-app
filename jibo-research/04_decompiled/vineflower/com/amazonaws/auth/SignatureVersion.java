package com.amazonaws.auth;

public enum SignatureVersion {
   V1("1"),
   V2("2");

   private static final SignatureVersion[] $VALUES = new SignatureVersion[]{SignatureVersion.V1, SignatureVersion.V2};
   private String value;

   SignatureVersion(String var3) {
      this.value = var3;
   }

   @Override
   public String toString() {
      return this.value;
   }
}
