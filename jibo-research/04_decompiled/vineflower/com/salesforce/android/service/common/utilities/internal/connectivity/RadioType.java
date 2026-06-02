package com.salesforce.android.service.common.utilities.internal.connectivity;

public enum RadioType {
   CDMA(4, "CDMA", false),
   EDGE(2, "EDGE", false),
   EHRPD(14, "EHRPD", false),
   EVDO_0(5, "EVDO_0", true),
   EVDO_A(6, "EVDO_A", true),
   EVDO_B(12, "EVDO_B", true),
   GPRS(1, "GPRS", false),
   HSDPA(8, "HSDPA", true),
   HSPA(10, "HSPA", true),
   HSPAP(15, "HSPAP", true),
   HSUPA(9, "HSUPA", true),
   IDEN(11, "IDEN", false),
   LTE(13, "LTE", true),
   RTT(7, "1xRTT", false),
   UMTS(3, "UMTS", true),
   UNKNOWN(0, "UNKNOWN", false);

   private static final RadioType[] $VALUES = new RadioType[]{
      RadioType.RTT,
      RadioType.CDMA,
      RadioType.EDGE,
      RadioType.EHRPD,
      RadioType.EVDO_0,
      RadioType.EVDO_A,
      RadioType.EVDO_B,
      RadioType.GPRS,
      RadioType.HSDPA,
      RadioType.HSPA,
      RadioType.HSPAP,
      RadioType.HSUPA,
      RadioType.IDEN,
      RadioType.LTE,
      RadioType.UMTS,
      RadioType.UNKNOWN
   };
   private final boolean mIsFastConnection;
   private final String mRadioName;
   private final int mType;

   RadioType(int var3, String var4, boolean var5) {
      this.mType = var3;
      this.mRadioName = var4;
      this.mIsFastConnection = var5;
   }

   static RadioType fromType(int var0) {
      RadioType[] var4 = values();
      int var2 = var4.length;
      int var1 = 0;

      RadioType var3;
      while (true) {
         if (var1 >= var2) {
            var3 = UNKNOWN;
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

   public String getRadioName() {
      return this.mRadioName;
   }

   public int getType() {
      return this.mType;
   }

   public boolean isFastConnection() {
      return this.mIsFastConnection;
   }
}
