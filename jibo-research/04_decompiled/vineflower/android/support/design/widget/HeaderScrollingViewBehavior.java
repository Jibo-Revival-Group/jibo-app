package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
   final Rect a = new Rect();
   final Rect b = new Rect();
   private int c = 0;
   private int d;

   public HeaderScrollingViewBehavior() {
   }

   public HeaderScrollingViewBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private static int c(int var0) {
      int var1 = var0;
      if (var0 == 0) {
         var1 = 8388659;
      }

      return var1;
   }

   float a(View var1) {
      return 1.0F;
   }

   final int a() {
      return this.c;
   }

   @Override
   public boolean a(CoordinatorLayout var1, View var2, int var3, int var4, int var5, int var6) {
      int var8 = var2.getLayoutParams().height;
      if (var8 == -1 || var8 == -2) {
         View var12 = this.b(var1.c(var2));
         if (var12 != null) {
            if (ViewCompat.r(var12) && !ViewCompat.r(var2)) {
               ViewCompat.b(var2, true);
               if (ViewCompat.r(var2)) {
                  var2.requestLayout();
                  return true;
               }
            }

            int var7 = MeasureSpec.getSize(var5);
            var5 = var7;
            if (var7 == 0) {
               var5 = var1.getHeight();
            }

            int var10 = var12.getMeasuredHeight();
            int var9 = this.b(var12);
            if (var8 == -1) {
               var7 = 1073741824;
            } else {
               var7 = Integer.MIN_VALUE;
            }

            var1.a(var2, var3, var4, MeasureSpec.makeMeasureSpec(var9 + (var5 - var10), var7), var6);
            return true;
         }
      }

      return false;
   }

   int b(View var1) {
      return var1.getMeasuredHeight();
   }

   abstract View b(List<View> var1);

   public final void b(int var1) {
      this.d = var1;
   }

   @Override
   protected void b(CoordinatorLayout var1, View var2, int var3) {
      View var4 = this.b(var1.c(var2));
      if (var4 != null) {
         CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
         Rect var6 = this.a;
         var6.set(
            var1.getPaddingLeft() + var5.leftMargin,
            var4.getBottom() + var5.topMargin,
            var1.getWidth() - var1.getPaddingRight() - var5.rightMargin,
            var1.getHeight() + var4.getBottom() - var1.getPaddingBottom() - var5.bottomMargin
         );
         WindowInsetsCompat var7 = var1.getLastWindowInsets();
         if (var7 != null && ViewCompat.r(var1) && !ViewCompat.r(var2)) {
            var6.left = var6.left + var7.a();
            var6.right = var6.right - var7.c();
         }

         Rect var8 = this.b;
         GravityCompat.a(c(var5.c), var2.getMeasuredWidth(), var2.getMeasuredHeight(), var6, var8, var3);
         var3 = this.c(var4);
         var2.layout(var8.left, var8.top - var3, var8.right, var8.bottom - var3);
         this.c = var8.top - var4.getBottom();
      } else {
         super.b(var1, var2, var3);
         this.c = 0;
      }
   }

   final int c(View var1) {
      int var2 = 0;
      if (this.d != 0) {
         var2 = MathUtils.a((int)(this.a(var1) * this.d), 0, this.d);
      }

      return var2;
   }

   public final int d() {
      return this.d;
   }
}
