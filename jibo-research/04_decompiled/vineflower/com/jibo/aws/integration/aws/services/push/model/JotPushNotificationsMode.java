package com.jibo.aws.integration.aws.services.push.model;

public enum JotPushNotificationsMode {
   always("always"),
   none("none"),
   tagged("tagged");

   private static final JotPushNotificationsMode[] $VALUES = new JotPushNotificationsMode[]{
      JotPushNotificationsMode.always, JotPushNotificationsMode.tagged, JotPushNotificationsMode.none
   };
   private final String name;

   JotPushNotificationsMode(String var3) {
      this.name = var3;
   }

   public String getName() {
      return this.name;
   }
}
