package com.salesforce.android.service.common.utilities.internal.connectivity;

public enum Technology {
   RADIO(0),
   WIFI(1);

   private static final Technology[] $VALUES = new Technology[]{Technology.WIFI, Technology.RADIO};
   private final int mType;

   Technology(int var3) {
      this.mType = var3;
   }

   static Technology fromType(int var0) {
      Technology[] var4 = values();
      int var2 = var4.length;
      int var1 = 0;

      Technology var3;
      while (true) {
         if (var1 >= var2) {
            var3 = WIFI;
            break;
         }

         var3 = var4[var1];
         if (var3.mType == var0) {
            break;
         }

         var1++;
      }

      return var3;
   }
}
