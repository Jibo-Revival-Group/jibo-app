package io.fabric.sdk.android.services.common;

public enum DeliveryMechanism {
   APP_STORE(4),
   DEVELOPER(1),
   TEST_DISTRIBUTION(3),
   USER_SIDELOAD(2);

   private static final DeliveryMechanism[] $VALUES = new DeliveryMechanism[]{
      DeliveryMechanism.DEVELOPER, DeliveryMechanism.USER_SIDELOAD, DeliveryMechanism.TEST_DISTRIBUTION, DeliveryMechanism.APP_STORE
   };
   public static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
   private final int id;

   DeliveryMechanism(int var3) {
      this.id = var3;
   }

   public static DeliveryMechanism determineFrom(String var0) {
      DeliveryMechanism var1;
      if ("io.crash.air".equals(var0)) {
         var1 = TEST_DISTRIBUTION;
      } else if (var0 != null) {
         var1 = APP_STORE;
      } else {
         var1 = DEVELOPER;
      }

      return var1;
   }

   public int getId() {
      return this.id;
   }

   @Override
   public String toString() {
      return Integer.toString(this.id);
   }
}
