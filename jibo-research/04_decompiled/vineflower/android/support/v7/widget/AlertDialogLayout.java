package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;

public class AlertDialogLayout extends LinearLayoutCompat {
   public AlertDialogLayout(Context var1) {
      super(var1);
   }

   public AlertDialogLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void a(View var1, int var2, int var3, int var4, int var5) {
      var1.layout(var2, var3, var2 + var4, var3 + var5);
   }

   private static int c(View var0) {
      int var1 = ViewCompat.k(var0);
      if (var1 <= 0) {
         if (var0 instanceof ViewGroup) {
            ViewGroup var2 = (ViewGroup)var0;
            if (var2.getChildCount() == 1) {
               var1 = c(var2.getChildAt(0));
               return var1;
            }
         }

         var1 = 0;
      }

      return var1;
   }

   private boolean c(int var1, int var2) {
      View var15 = null;
      View var16 = null;
      int var10 = this.getChildCount();
      int var3 = 0;
      View var18 = null;

      boolean var14;
      while (true) {
         if (var3 >= var10) {
            int var12 = MeasureSpec.getMode(var2);
            int var9 = MeasureSpec.getSize(var2);
            int var11 = MeasureSpec.getMode(var1);
            int var5 = 0;
            var3 = this.getPaddingTop();
            var3 = this.getPaddingBottom() + var3;
            int var25 = var3;
            if (var15 != null) {
               var15.measure(var1, 0);
               var25 = var3 + var15.getMeasuredHeight();
               var5 = View.combineMeasuredStates(0, var15.getMeasuredState());
            }

            var3 = 0;
            int var32;
            if (var16 != null) {
               var16.measure(var1, 0);
               var3 = c(var16);
               var32 = var16.getMeasuredHeight();
               var25 += var3;
               var5 = View.combineMeasuredStates(var5, var16.getMeasuredState());
               var32 -= var3;
            } else {
               var32 = 0;
            }

            int var8;
            if (var18 != null) {
               int var7;
               if (var12 == 0) {
                  var7 = 0;
               } else {
                  var7 = MeasureSpec.makeMeasureSpec(Math.max(0, var9 - var25), var12);
               }

               var18.measure(var1, var7);
               var8 = var18.getMeasuredHeight();
               var25 += var8;
               var5 = View.combineMeasuredStates(var5, var18.getMeasuredState());
            } else {
               var8 = 0;
            }

            var9 -= var25;
            if (var16 != null) {
               int var13 = Math.min(var9, var32);
               var32 = var9;
               int var35 = var3;
               if (var13 > 0) {
                  var32 = var9 - var13;
                  var35 = var3 + var13;
               }

               var16.measure(var1, MeasureSpec.makeMeasureSpec(var35, 1073741824));
               var35 = var16.getMeasuredHeight();
               var5 = View.combineMeasuredStates(var5, var16.getMeasuredState());
               var25 = var35 + (var25 - var3);
               var9 = var32;
               var3 = var5;
            } else {
               var3 = var5;
            }

            if (var18 != null && var9 > 0) {
               var18.measure(var1, MeasureSpec.makeMeasureSpec(var9 + var8, var12));
               var5 = var18.getMeasuredHeight();
               var3 = View.combineMeasuredStates(var3, var18.getMeasuredState());
               var5 = var25 - var8 + var5;
               var25 = var3;
               var3 = var5;
            } else {
               var5 = var3;
               var3 = var25;
               var25 = var5;
            }

            var32 = 0;
            var5 = 0;

            while (var5 < var10) {
               var15 = this.getChildAt(var5);
               int var37 = var32;
               if (var15.getVisibility() != 8) {
                  var37 = Math.max(var32, var15.getMeasuredWidth());
               }

               var5++;
               var32 = var37;
            }

            this.setMeasuredDimension(
               View.resolveSizeAndState(var32 + this.getPaddingLeft() + this.getPaddingRight(), var1, var25), View.resolveSizeAndState(var3, var2, 0)
            );
            if (var11 != 1073741824) {
               this.d(var10, var2);
            }

            var14 = true;
            break;
         }

         View var17 = this.getChildAt(var3);
         if (var17.getVisibility() == 8) {
            var17 = var16;
            var16 = var15;
            var15 = var17;
         } else {
            int var4 = var17.getId();
            if (var4 == R.id.topPanel) {
               var15 = var16;
               var16 = var17;
            } else if (var4 == R.id.buttonPanel) {
               var16 = var15;
               var15 = var17;
            } else {
               if (var4 != R.id.contentPanel && var4 != R.id.customPanel) {
                  var14 = false;
                  break;
               }

               if (var18 != null) {
                  var14 = false;
                  break;
               }

               var18 = var17;
               var17 = var16;
               var16 = var15;
               var15 = var17;
            }
         }

         var3++;
         var17 = var16;
         var16 = var15;
         var15 = var17;
      }

      return var14;
   }

   private void d(int var1, int var2) {
      int var4 = MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);

      for (int var3 = 0; var3 < var1; var3++) {
         View var6 = this.getChildAt(var3);
         if (var6.getVisibility() != 8) {
            LinearLayoutCompat.LayoutParams var7 = (LinearLayoutCompat.LayoutParams)var6.getLayoutParams();
            if (var7.width == -1) {
               int var5 = var7.height;
               var7.height = var6.getMeasuredHeight();
               this.measureChildWithMargins(var6, var4, 0, var2, 0);
               var7.height = var5;
            }
         }
      }
   }

   @Override
   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var7 = this.getPaddingLeft();
      int var12 = var4 - var2;
      int var10 = this.getPaddingRight();
      int var9 = this.getPaddingRight();
      var4 = this.getMeasuredHeight();
      int var11 = this.getChildCount();
      int var8 = this.getGravity();
      switch (var8 & 112) {
         case 16:
            var2 = this.getPaddingTop();
            var2 = (var5 - var3 - var4) / 2 + var2;
            break;
         case 80:
            var2 = this.getPaddingTop() + var5 - var3 - var4;
            break;
         default:
            var2 = this.getPaddingTop();
      }

      Drawable var15 = this.getDividerDrawable();
      if (var15 == null) {
         var4 = 0;
      } else {
         var4 = var15.getIntrinsicHeight();
      }

      var5 = 0;

      while (var5 < var11) {
         View var16 = this.getChildAt(var5);
         var3 = var2;
         if (var16 != null) {
            var3 = var2;
            if (var16.getVisibility() != 8) {
               int var13 = var16.getMeasuredWidth();
               int var14 = var16.getMeasuredHeight();
               LinearLayoutCompat.LayoutParams var26 = (LinearLayoutCompat.LayoutParams)var16.getLayoutParams();
               int var6 = var26.h;
               var3 = var6;
               if (var6 < 0) {
                  var3 = var8 & 8388615;
               }

               switch (GravityCompat.a(var3, ViewCompat.e(this)) & 7) {
                  case 1:
                     var3 = (var12 - var7 - var9 - var13) / 2 + var7 + var26.leftMargin - var26.rightMargin;
                     break;
                  case 5:
                     var3 = var12 - var10 - var13 - var26.rightMargin;
                     break;
                  default:
                     var3 = var7 + var26.leftMargin;
               }

               if (this.c(var5)) {
                  var2 += var4;
               }

               var2 = var26.topMargin + var2;
               this.a(var16, var3, var2, var13, var14);
               var3 = var2 + var26.bottomMargin + var14;
            }
         }

         var5++;
         var2 = var3;
      }
   }

   @Override
   protected void onMeasure(int var1, int var2) {
      if (!this.c(var1, var2)) {
         super.onMeasure(var1, var2);
      }
   }
}
