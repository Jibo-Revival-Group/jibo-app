package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

public class SidePropagation extends VisibilityPropagation {
   private float a = 3.0F;
   private int b = 80;

   private int a(View var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      byte var12 = 5;
      byte var11 = 3;
      boolean var13 = true;
      int var10 = 1;
      if (this.b == 8388611) {
         if (ViewCompat.e(var1) != 1) {
            var10 = 0;
         }

         if (var10) {
            var10 = var12;
         } else {
            var10 = 3;
         }
      } else if (this.b == 8388613) {
         boolean var16;
         if (ViewCompat.e(var1) == 1) {
            var16 = var13;
         } else {
            var16 = false;
         }

         if (var16) {
            var10 = var11;
         } else {
            var10 = 5;
         }
      } else {
         var10 = this.b;
      }

      switch (var10) {
         case 3:
            var2 = var8 - var2 + Math.abs(var5 - var3);
            break;
         case 5:
            var2 = var2 - var6 + Math.abs(var5 - var3);
            break;
         case 48:
            var2 = var9 - var3 + Math.abs(var4 - var2);
            break;
         case 80:
            var2 = var3 - var7 + Math.abs(var4 - var2);
            break;
         default:
            var2 = 0;
      }

      return var2;
   }

   private int a(ViewGroup var1) {
      int var2;
      switch (this.b) {
         case 3:
         case 5:
         case 8388611:
         case 8388613:
            var2 = var1.getWidth();
            break;
         default:
            var2 = var1.getHeight();
      }

      return var2;
   }

   @Override
   public long a(ViewGroup var1, Transition var2, TransitionValues var3, TransitionValues var4) {
      long var21;
      if (var3 == null && var4 == null) {
         var21 = 0L;
      } else {
         Rect var19 = var2.m();
         byte var6;
         if (var4 != null && this.b(var3) != 0) {
            var6 = 1;
         } else {
            var6 = -1;
            var4 = var3;
         }

         int var14 = this.c(var4);
         int var9 = this.d(var4);
         int[] var20 = new int[2];
         var1.getLocationOnScreen(var20);
         int var10 = var20[0] + Math.round(var1.getTranslationX());
         int var12 = var20[1] + Math.round(var1.getTranslationY());
         int var11 = var10 + var1.getWidth();
         int var13 = var12 + var1.getHeight();
         int var7;
         int var8;
         if (var19 != null) {
            var8 = var19.centerX();
            var7 = var19.centerY();
         } else {
            var8 = (var10 + var11) / 2;
            var7 = (var12 + var13) / 2;
         }

         float var5 = (float)this.a(var1, var14, var9, var8, var7, var10, var12, var11, var13) / this.a(var1);
         long var17 = var2.b();
         var21 = var17;
         if (var17 < 0L) {
            var21 = 300L;
         }

         var21 = Math.round((float)(var21 * var6) / this.a * var5);
      }

      return var21;
   }

   public void a(int var1) {
      this.b = var1;
   }
}
