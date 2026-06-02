package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
   private int a = -1;

   public BaselineLayout(Context var1) {
      super(var1, null, 0);
   }

   public BaselineLayout(Context var1, AttributeSet var2) {
      super(var1, var2, 0);
   }

   public BaselineLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public int getBaseline() {
      return this.a;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var8 = this.getChildCount();
      int var7 = this.getPaddingLeft();
      int var9 = this.getPaddingRight();
      int var6 = this.getPaddingTop();

      for (int var14 = 0; var14 < var8; var14++) {
         View var13 = this.getChildAt(var14);
         if (var13.getVisibility() != 8) {
            int var12 = var13.getMeasuredWidth();
            int var10 = var13.getMeasuredHeight();
            int var11 = var7 + (var4 - var2 - var9 - var7 - var12) / 2;
            if (this.a != -1 && var13.getBaseline() != -1) {
               var5 = this.a + var6 - var13.getBaseline();
            } else {
               var5 = var6;
            }

            var13.layout(var11, var5, var12 + var11, var10 + var5);
         }
      }
   }

   protected void onMeasure(int var1, int var2) {
      int var11 = this.getChildCount();
      int var9 = 0;
      int var5 = 0;
      int var4 = -1;
      int var6 = 0;
      int var10 = 0;
      int var3 = -1;

      while (var9 < var11) {
         View var13 = this.getChildAt(var9);
         if (var13.getVisibility() == 8) {
            int var7 = var5;
            var5 = var3;
            var3 = var7;
         } else {
            this.measureChild(var13, var1, var2);
            int var12 = var13.getBaseline();
            int var8 = var3;
            int var17 = var4;
            if (var12 != -1) {
               var17 = Math.max(var4, var12);
               var8 = Math.max(var3, var13.getMeasuredHeight() - var12);
            }

            var10 = Math.max(var10, var13.getMeasuredWidth());
            var6 = Math.max(var6, var13.getMeasuredHeight());
            var3 = View.combineMeasuredStates(var5, var13.getMeasuredState());
            var4 = var17;
            var5 = var8;
         }

         var9++;
         int var18 = var5;
         var5 = var3;
         var3 = var18;
      }

      int var19 = var6;
      if (var4 != -1) {
         var19 = Math.max(var6, Math.max(var3, this.getPaddingBottom()) + var4);
         this.a = var4;
      }

      var3 = Math.max(var19, this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(
         View.resolveSizeAndState(Math.max(var10, this.getSuggestedMinimumWidth()), var1, var5), View.resolveSizeAndState(var3, var2, var5 << 16)
      );
   }
}
