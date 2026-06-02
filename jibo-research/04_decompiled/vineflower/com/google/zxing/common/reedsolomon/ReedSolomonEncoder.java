package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder {
   private final GenericGF a;
   private final List<GenericGFPoly> b;

   public ReedSolomonEncoder(GenericGF var1) {
      this.a = var1;
      this.b = new ArrayList<>();
      this.b.add(new GenericGFPoly(var1, new int[]{1}));
   }

   private GenericGFPoly a(int var1) {
      if (var1 >= this.b.size()) {
         GenericGFPoly var3 = this.b.get(this.b.size() - 1);

         for (int var2 = this.b.size(); var2 <= var1; var2++) {
            var3 = var3.b(new GenericGFPoly(this.a, new int[]{1, this.a.a(var2 - 1 + this.a.b())}));
            this.b.add(var3);
         }
      }

      return this.b.get(var1);
   }

   public void a(int[] var1, int var2) {
      if (var2 == 0) {
         throw new IllegalArgumentException("No error correction bytes");
      }

      int var3 = var1.length - var2;
      if (var3 <= 0) {
         throw new IllegalArgumentException("No data bytes provided");
      }

      GenericGFPoly var5 = this.a(var2);
      int[] var6 = new int[var3];
      System.arraycopy(var1, 0, var6, 0, var3);
      int[] var8 = new GenericGFPoly(this.a, var6).a(var2, 1).c(var5)[1].a();
      int var4 = var2 - var8.length;

      for (int var7 = 0; var7 < var4; var7++) {
         var1[var3 + var7] = 0;
      }

      System.arraycopy(var8, 0, var1, var3 + var4, var8.length);
   }
}
