package com.salesforce.android.knowledge.ui.internal.home;

import android.graphics.Color;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.ui.internal.models.ColorSelector;

class ColorCalculator implements ColorSelector {
   private final int a;
   private final int b;
   private final int c;

   ColorCalculator(int var1, int var2, int var3) {
      if (var3 > var2) {
         throw new IllegalArgumentException("Gradient range cannot be greater than gradient size");
      }

      if (var3 >= 0 && var2 >= 0) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      } else {
         throw new IllegalArgumentException("Gradient range/size cannot be negative");
      }
   }

   @Override
   public int a(DataCategorySummary var1, int var2) {
      if (this.c != 0 && this.b != 0) {
         float[] var4 = new float[3];
         Color.colorToHSV(this.a, var4);
         float var3 = var4[2] / this.b;
         var2 = Math.abs((this.c + var2) % (this.c * 2) - this.c);
         var4[2] -= var3 * var2;
         var2 = Color.HSVToColor(var4);
      } else {
         var2 = this.a;
      }

      return var2;
   }
}
