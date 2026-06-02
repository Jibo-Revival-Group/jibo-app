package com.facebook;

public enum AccessTokenSource {
   CHROME_CUSTOM_TAB(true),
   CLIENT_TOKEN(true),
   DEVICE_AUTH(true),
   FACEBOOK_APPLICATION_NATIVE(true),
   FACEBOOK_APPLICATION_SERVICE(true),
   FACEBOOK_APPLICATION_WEB(true),
   NONE(false),
   TEST_USER(true),
   WEB_VIEW(true);

   private static final AccessTokenSource[] $VALUES = new AccessTokenSource[]{
      AccessTokenSource.NONE,
      AccessTokenSource.FACEBOOK_APPLICATION_WEB,
      AccessTokenSource.FACEBOOK_APPLICATION_NATIVE,
      AccessTokenSource.FACEBOOK_APPLICATION_SERVICE,
      AccessTokenSource.WEB_VIEW,
      AccessTokenSource.CHROME_CUSTOM_TAB,
      AccessTokenSource.TEST_USER,
      AccessTokenSource.CLIENT_TOKEN,
      AccessTokenSource.DEVICE_AUTH
   };
   private final boolean canExtendToken;

   AccessTokenSource(boolean var3) {
      this.canExtendToken = var3;
   }

   boolean canExtendToken() {
      return this.canExtendToken;
   }
}
