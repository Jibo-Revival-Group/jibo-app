package com.facebook.login;

public enum DefaultAudience {
   EVERYONE("everyone"),
   FRIENDS("friends"),
   NONE(null),
   ONLY_ME("only_me");

   private static final DefaultAudience[] $VALUES = new DefaultAudience[]{
      DefaultAudience.NONE, DefaultAudience.ONLY_ME, DefaultAudience.FRIENDS, DefaultAudience.EVERYONE
   };
   private final String nativeProtocolAudience;

   DefaultAudience(String var3) {
      this.nativeProtocolAudience = var3;
   }

   public String getNativeProtocolAudience() {
      return this.nativeProtocolAudience;
   }
}
