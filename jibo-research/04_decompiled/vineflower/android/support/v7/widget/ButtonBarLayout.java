package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ButtonBarLayout extends LinearLayout {
   private boolean a;
   private int b = -1;
   private int c = 0;

   public ButtonBarLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.ButtonBarLayout);
      this.a = var3.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
      var3.recycle();
   }

   private int a(int var1) {
      int var2 = this.getChildCount();

      while (true) {
         if (var1 >= var2) {
            var1 = -1;
            break;
         }

         if (this.getChildAt(var1).getVisibility() == 0) {
            break;
         }

         var1++;
      }

      return var1;
   }

   private boolean a() {
      boolean var1 = true;
      if (this.getOrientation() != 1) {
         var1 = false;
      }

      return var1;
   }

   private void setStacked(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.setOrientation(var2);
      if (var1) {
         var2 = 5;
      } else {
         var2 = 80;
      }

      this.setGravity(var2);
      View var3 = this.findViewById(R.id.spacer);
      if (var3 != null) {
         if (var1) {
            var2 = 8;
         } else {
            var2 = 4;
         }

         var3.setVisibility(var2);
      }

      for (int var6 = this.getChildCount() - 2; var6 >= 0; var6--) {
         this.bringChildToFront(this.getChildAt(var6));
      }
   }

   public int getMinimumHeight() {
      return Math.max(this.c, super.getMinimumHeight());
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getSize(var1);
      if (this.a) {
         if (var3 > this.b && this.a()) {
            this.setStacked(false);
         }

         this.b = var3;
      }

      int var4;
      boolean var12;
      if (!this.a() && MeasureSpec.getMode(var1) == 1073741824) {
         var4 = MeasureSpec.makeMeasureSpec(var3, Integer.MIN_VALUE);
         var12 = 1;
      } else {
         var4 = var1;
         var12 = 0;
      }

      super.onMeasure(var4, var2);
      int var15 = var12;
      if (this.a) {
         var15 = var12;
         if (!this.a()) {
            boolean var5;
            if ((this.getMeasuredWidthAndState() & 0xFF000000) == 16777216) {
               var5 = true;
            } else {
               var5 = false;
            }

            var15 = var12;
            if (var5) {
               this.setStacked(true);
               var15 = 1;
            }
         }
      }

      if (var15) {
         super.onMeasure(var1, var2);
      }

      var1 = this.a(0);
      if (var1 >= 0) {
         View var6 = this.getChildAt(var1);
         LayoutParams var7 = (LayoutParams)var6.getLayoutParams();
         var12 = this.getPaddingTop();
         var2 = var6.getMeasuredHeight();
         var15 = var7.topMargin;
         var2 = var7.bottomMargin + var2 + var12 + var15 + 0;
         if (this.a()) {
            var12 = this.a(var1 + 1);
            var1 = var2;
            if (var12 >= 0) {
               var1 = var2 + this.getChildAt(var12).getPaddingTop() + (int)(16.0F * this.getResources().getDisplayMetrics().density);
            }
         } else {
            var1 = var2 + this.getPaddingBottom();
         }
      } else {
         var1 = 0;
      }

      if (ViewCompat.k(this) != var1) {
         this.setMinimumHeight(var1);
      }
   }

   public void setAllowStacking(boolean var1) {
      if (this.a != var1) {
         this.a = var1;
         if (!this.a && this.getOrientation() == 1) {
            this.setStacked(false);
         }

         this.requestLayout();
      }
   }
}
