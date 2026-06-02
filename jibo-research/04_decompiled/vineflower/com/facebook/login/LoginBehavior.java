package com.facebook.login;

public enum LoginBehavior {
   DEVICE_AUTH(false, false, false, true, false, false),
   KATANA_ONLY(false, true, false, false, false, false),
   NATIVE_ONLY(true, true, false, false, false, true),
   NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
   WEB_ONLY(false, false, true, false, true, false),
   WEB_VIEW_ONLY(false, false, true, false, false, false);

   private static final LoginBehavior[] $VALUES = new LoginBehavior[]{
      LoginBehavior.NATIVE_WITH_FALLBACK,
      LoginBehavior.NATIVE_ONLY,
      LoginBehavior.KATANA_ONLY,
      LoginBehavior.WEB_ONLY,
      LoginBehavior.WEB_VIEW_ONLY,
      LoginBehavior.DEVICE_AUTH
   };
   private final boolean allowsCustomTabAuth;
   private final boolean allowsDeviceAuth;
   private final boolean allowsFacebookLiteAuth;
   private final boolean allowsGetTokenAuth;
   private final boolean allowsKatanaAuth;
   private final boolean allowsWebViewAuth;

   LoginBehavior(boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8) {
      this.allowsGetTokenAuth = var3;
      this.allowsKatanaAuth = var4;
      this.allowsWebViewAuth = var5;
      this.allowsDeviceAuth = var6;
      this.allowsCustomTabAuth = var7;
      this.allowsFacebookLiteAuth = var8;
   }

   boolean allowsCustomTabAuth() {
      return this.allowsCustomTabAuth;
   }

   boolean allowsDeviceAuth() {
      return this.allowsDeviceAuth;
   }

   boolean allowsFacebookLiteAuth() {
      return this.allowsFacebookLiteAuth;
   }

   boolean allowsGetTokenAuth() {
      return this.allowsGetTokenAuth;
   }

   boolean allowsKatanaAuth() {
      return this.allowsKatanaAuth;
   }

   boolean allowsWebViewAuth() {
      return this.allowsWebViewAuth;
   }
}
