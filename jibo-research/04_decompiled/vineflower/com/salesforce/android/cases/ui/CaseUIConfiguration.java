package com.salesforce.android.cases.ui;

import com.salesforce.android.cases.core.CaseConfiguration;

public class CaseUIConfiguration {
   private final CaseConfiguration a;
   private final int b;

   private CaseUIConfiguration(CaseConfiguration var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   private int a(int var1) {
      byte var2;
      switch (var1) {
         case 0:
         case 1:
            var2 = -2;
            break;
         case 2:
            var2 = -1;
            break;
         case 3:
         default:
            var2 = 0;
            break;
         case 4:
            var2 = 1;
            break;
         case 5:
            var2 = 2;
      }

      return var2;
   }

   public static CaseUIConfiguration a(CaseConfiguration var0) {
      return a(var0, 4);
   }

   public static CaseUIConfiguration a(CaseConfiguration var0, int var1) {
      return new CaseUIConfiguration(var0, var1);
   }

   public int a() {
      return this.b;
   }

   public int b() {
      return this.a(this.b);
   }

   public CaseConfiguration c() {
      return this.a;
   }
}
