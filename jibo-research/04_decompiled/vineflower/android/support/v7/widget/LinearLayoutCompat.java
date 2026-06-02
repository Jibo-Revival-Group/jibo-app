package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayoutCompat extends ViewGroup {
   private boolean a = true;
   private int b = -1;
   private int c = 0;
   private int d;
   private int e = 8388659;
   private int f;
   private float g;
   private boolean h;
   private int[] i;
   private int[] j;
   private Drawable k;
   private int l;
   private int m;
   private int n;
   private int o;

   public LinearLayoutCompat(Context var1) {
      this(var1, null);
   }

   public LinearLayoutCompat(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public LinearLayoutCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TintTypedArray var5 = TintTypedArray.a(var1, var2, R.styleable.LinearLayoutCompat, var3, 0);
      var3 = var5.a(R.styleable.LinearLayoutCompat_android_orientation, -1);
      if (var3 >= 0) {
         this.setOrientation(var3);
      }

      var3 = var5.a(R.styleable.LinearLayoutCompat_android_gravity, -1);
      if (var3 >= 0) {
         this.setGravity(var3);
      }

      boolean var4 = var5.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
      if (!var4) {
         this.setBaselineAligned(var4);
      }

      this.g = var5.a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
      this.b = var5.a(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
      this.h = var5.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
      this.setDividerDrawable(var5.a(R.styleable.LinearLayoutCompat_divider));
      this.n = var5.a(R.styleable.LinearLayoutCompat_showDividers, 0);
      this.o = var5.e(R.styleable.LinearLayoutCompat_dividerPadding, 0);
      var5.a();
   }

   private void a(View var1, int var2, int var3, int var4, int var5) {
      var1.layout(var2, var3, var2 + var4, var3 + var5);
   }

   private void c(int var1, int var2) {
      int var4 = MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);

      for (int var3 = 0; var3 < var1; var3++) {
         View var6 = this.b(var3);
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

   private void d(int var1, int var2) {
      int var4 = MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824);

      for (int var3 = 0; var3 < var1; var3++) {
         View var7 = this.b(var3);
         if (var7.getVisibility() != 8) {
            LinearLayoutCompat.LayoutParams var6 = (LinearLayoutCompat.LayoutParams)var7.getLayoutParams();
            if (var6.height == -1) {
               int var5 = var6.width;
               var6.width = var7.getMeasuredWidth();
               this.measureChildWithMargins(var7, var2, 0, var4, 0);
               var6.width = var5;
            }
         }
      }
   }

   int a(View var1) {
      return 0;
   }

   int a(View var1, int var2) {
      return 0;
   }

   void a(int var1, int var2) {
      this.f = 0;
      int var6 = 0;
      int var5 = 0;
      int var10 = 0;
      int var13 = 0;
      int var7 = 1;
      float var3 = 0.0F;
      int var19 = this.getVirtualChildCount();
      int var20 = MeasureSpec.getMode(var1);
      int var21 = MeasureSpec.getMode(var2);
      int var12 = 0;
      int var9 = 0;
      int var22 = this.b;
      boolean var23 = this.h;
      int var8 = 0;
      int var11 = 0;

      while (var11 < var19) {
         View var25 = this.b(var11);
         boolean var26;
         if (var25 == null) {
            this.f = this.f + this.d(var11);
            int var14 = var8;
            boolean var15 = (boolean)var9;
            var8 = var6;
            var9 = var5;
            var26 = var15;
            var6 = var14;
         } else if (var25.getVisibility() == 8) {
            int var84 = var11 + this.a(var25, var11);
            int var74 = var8;
            boolean var64 = (boolean)var9;
            var9 = var5;
            var8 = var6;
            var6 = var74;
            var26 = var64;
            var11 = var84;
         } else {
            if (this.c(var11)) {
               this.f = this.f + this.m;
            }

            LinearLayoutCompat.LayoutParams var24 = (LinearLayoutCompat.LayoutParams)var25.getLayoutParams();
            var3 += var24.g;
            int var77;
            boolean var87;
            if (var21 == 1073741824 && var24.height == 0 && var24.g > 0.0F) {
               var9 = this.f;
               this.f = Math.max(var9, var24.topMargin + var9 + var24.bottomMargin);
               var87 = 1;
               var77 = var8;
            } else {
               var87 = Integer.MIN_VALUE;
               var77 = var87;
               if (var24.height == 0) {
                  var77 = var87;
                  if (var24.g > 0.0F) {
                     var77 = 0;
                     var24.height = -2;
                  }
               }

               if (var3 == 0.0F) {
                  var87 = this.f;
               } else {
                  var87 = 0;
               }

               this.a(var25, var11, var1, 0, var2, var87);
               if (var77 != Integer.MIN_VALUE) {
                  var24.height = var77;
               }

               int var16 = var25.getMeasuredHeight();
               var77 = this.f;
               this.f = Math.max(var77, var77 + var16 + var24.topMargin + var24.bottomMargin + this.b(var25));
               var77 = var8;
               var87 = var9;
               if (var23) {
                  var77 = Math.max(var16, var8);
                  var87 = var9;
               }
            }

            if (var22 >= 0 && var22 == var11 + 1) {
               this.c = this.f;
            }

            if (var11 < var22 && var24.g > 0.0F) {
               throw new RuntimeException(
                  "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
               );
            }

            boolean var47 = false;
            boolean var38;
            if (var20 != 1073741824 && var24.width == -1) {
               var38 = true;
               var47 = true;
            } else {
               var38 = (boolean)var12;
            }

            var12 = var24.leftMargin;
            int var91 = var24.rightMargin + var12;
            var12 = var25.getMeasuredWidth() + var91;
            int var18 = Math.max(var6, var12);
            int var17 = View.combineMeasuredStates(var5, var25.getMeasuredState());
            if (var7 && var24.width == -1) {
               var7 = 1;
            } else {
               var7 = 0;
            }

            if (var24.g > 0.0F) {
               if (var47) {
                  var26 = var91;
               } else {
                  var26 = var12;
               }

               var6 = Math.max(var13, var26);
               var26 = var10;
            } else {
               if (var47) {
                  var12 = var91;
               }

               var26 = Math.max(var10, var12);
               var6 = var13;
            }

            var11 += this.a(var25, var11);
            var13 = var6;
            var10 = var26;
            var12 = var18;
            var6 = var77;
            var9 = var17;
            boolean var78 = var38;
            var26 = var87;
            var8 = var12;
            var12 = var78;
         }

         var11++;
         boolean var79 = (boolean)var26;
         var5 = var9;
         int var88 = var8;
         var8 = var6;
         var9 = var79;
         var6 = var88;
      }

      if (this.f > 0 && this.c(var19)) {
         this.f = this.f + this.m;
      }

      if (var23 && (var21 == Integer.MIN_VALUE || var21 == 0)) {
         this.f = 0;

         for (int var65 = 0; var65 < var19; var65++) {
            View var96 = this.b(var65);
            if (var96 == null) {
               this.f = this.f + this.d(var65);
            } else if (var96.getVisibility() == 8) {
               var65 += this.a(var96, var65);
            } else {
               LinearLayoutCompat.LayoutParams var93 = (LinearLayoutCompat.LayoutParams)var96.getLayoutParams();
               int var80 = this.f;
               int var89 = var93.topMargin;
               this.f = Math.max(var80, var93.bottomMargin + var80 + var8 + var89 + this.b(var96));
            }
         }
      }

      this.f = this.f + this.getPaddingTop() + this.getPaddingBottom();
      int var90 = View.resolveSizeAndState(Math.max(this.f, this.getSuggestedMinimumHeight()), var2, 0);
      var11 = (16777215 & var90) - this.f;
      if (var9 || var11 != 0 && var3 > 0.0F) {
         if (this.g > 0.0F) {
            var3 = this.g;
         }

         this.f = 0;
         int var41 = 0;
         int var50 = var7;
         var7 = var10;
         var10 = var11;
         var11 = var41;
         var8 = var6;
         boolean var33 = (boolean)var50;
         var50 = var10;

         while (var11 < var19) {
            View var97 = this.b(var11);
            if (var97.getVisibility() == 8) {
               var10 = var7;
               var7 = var8;
               var41 = var10;
            } else {
               LinearLayoutCompat.LayoutParams var95 = (LinearLayoutCompat.LayoutParams)var97.getLayoutParams();
               float var4 = var95.g;
               if (!(var4 > 0.0F)) {
                  var10 = var50;
                  var50 = var5;
                  var5 = var10;
               } else {
                  var13 = (int)(var50 * var4 / var3);
                  int var92 = getChildMeasureSpec(var1, this.getPaddingLeft() + this.getPaddingRight() + var95.leftMargin + var95.rightMargin, var95.width);
                  if (var95.height == 0 && var21 == 1073741824) {
                     if (var13 > 0) {
                        var10 = var13;
                     } else {
                        var10 = 0;
                     }

                     var97.measure(var92, MeasureSpec.makeMeasureSpec(var10, 1073741824));
                  } else {
                     int var81 = var13 + var97.getMeasuredHeight();
                     var10 = var81;
                     if (var81 < 0) {
                        var10 = 0;
                     }

                     var97.measure(var92, MeasureSpec.makeMeasureSpec(var10, 1073741824));
                  }

                  var10 = View.combineMeasuredStates(var5, var97.getMeasuredState() & -256);
                  var5 = var50 - var13;
                  var50 = var10;
                  var3 -= var4;
               }

               int var82 = var95.leftMargin + var95.rightMargin;
               var13 = var97.getMeasuredWidth() + var82;
               var10 = Math.max(var8, var13);
               boolean var43;
               if (var20 != 1073741824 && var95.width == -1) {
                  var43 = 1;
               } else {
                  var43 = 0;
               }

               if (var43) {
                  var43 = var82;
               } else {
                  var43 = var13;
               }

               var41 = Math.max(var7, var43);
               if (var33 && var95.width == -1) {
                  var33 = true;
               } else {
                  var33 = false;
               }

               var7 = this.f;
               var82 = var97.getMeasuredHeight();
               var13 = var95.topMargin;
               this.f = Math.max(var7, var95.bottomMargin + var82 + var7 + var13 + this.b(var97));
               var7 = var10;
               var10 = var5;
               var5 = var50;
               var50 = var10;
            }

            var11++;
            var10 = var41;
            var8 = var7;
            var7 = var10;
         }

         this.f = this.f + this.getPaddingTop() + this.getPaddingBottom();
         boolean var53 = var33;
         var6 = var7;
         var7 = var53;
      } else {
         var10 = Math.max(var10, var13);
         if (var23 && var21 != 1073741824) {
            for (int var48 = 0; var48 < var19; var48++) {
               View var94 = this.b(var48);
               if (var94 != null && var94.getVisibility() != 8 && ((LinearLayoutCompat.LayoutParams)var94.getLayoutParams()).g > 0.0F) {
                  var94.measure(MeasureSpec.makeMeasureSpec(var94.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(var8, 1073741824));
               }
            }
         }

         var8 = var10;
         var9 = var6;
         var6 = var8;
         var8 = var9;
      }

      if (var7 || var20 == 1073741824) {
         var6 = var8;
      }

      this.setMeasuredDimension(
         View.resolveSizeAndState(Math.max(var6 + this.getPaddingLeft() + this.getPaddingRight(), this.getSuggestedMinimumWidth()), var1, var5), var90
      );
      if (var12) {
         this.c(var19, var2);
      }
   }

   void a(int var1, int var2, int var3, int var4) {
      int var5 = this.getPaddingLeft();
      int var10 = var3 - var1;
      int var8 = this.getPaddingRight();
      int var7 = this.getPaddingRight();
      int var6 = this.getVirtualChildCount();
      var1 = this.e;
      int var9 = this.e;
      switch (var1 & 112) {
         case 16:
            var1 = this.getPaddingTop() + (var4 - var2 - this.f) / 2;
            break;
         case 80:
            var1 = this.getPaddingTop() + var4 - var2 - this.f;
            break;
         default:
            var1 = this.getPaddingTop();
      }

      int var20 = 0;
      var2 = var1;

      for (int var17 = var20; var17 < var6; var17++) {
         View var13 = this.b(var17);
         if (var13 == null) {
            var2 += this.d(var17);
         } else if (var13.getVisibility() != 8) {
            int var12 = var13.getMeasuredWidth();
            int var11 = var13.getMeasuredHeight();
            LinearLayoutCompat.LayoutParams var14 = (LinearLayoutCompat.LayoutParams)var13.getLayoutParams();
            var4 = var14.h;
            var20 = var4;
            if (var4 < 0) {
               var20 = var9 & 8388615;
            }

            switch (GravityCompat.a(var20, ViewCompat.e(this)) & 7) {
               case 1:
                  var20 = (var10 - var5 - var7 - var12) / 2 + var5 + var14.leftMargin - var14.rightMargin;
                  break;
               case 5:
                  var20 = var10 - var8 - var12 - var14.rightMargin;
                  break;
               default:
                  var20 = var5 + var14.leftMargin;
            }

            if (this.c(var17)) {
               var2 += this.m;
            }

            var2 += var14.topMargin;
            this.a(var13, var20, var2 + this.a(var13), var12, var11);
            var2 += var14.bottomMargin + var11 + this.b(var13);
            var17 += this.a(var13, var17);
         }
      }
   }

   void a(Canvas var1) {
      int var3 = this.getVirtualChildCount();

      for (int var2 = 0; var2 < var3; var2++) {
         View var5 = this.b(var2);
         if (var5 != null && var5.getVisibility() != 8 && this.c(var2)) {
            LinearLayoutCompat.LayoutParams var4 = (LinearLayoutCompat.LayoutParams)var5.getLayoutParams();
            this.a(var1, var5.getTop() - var4.topMargin - this.m);
         }
      }

      if (this.c(var3)) {
         View var8 = this.b(var3 - 1);
         int var6;
         if (var8 == null) {
            var6 = this.getHeight() - this.getPaddingBottom() - this.m;
         } else {
            LinearLayoutCompat.LayoutParams var9 = (LinearLayoutCompat.LayoutParams)var8.getLayoutParams();
            var6 = var8.getBottom();
            var6 = var9.bottomMargin + var6;
         }

         this.a(var1, var6);
      }
   }

   void a(Canvas var1, int var2) {
      this.k.setBounds(this.getPaddingLeft() + this.o, var2, this.getWidth() - this.getPaddingRight() - this.o, this.m + var2);
      this.k.draw(var1);
   }

   void a(View var1, int var2, int var3, int var4, int var5, int var6) {
      this.measureChildWithMargins(var1, var3, var4, var5, var6);
   }

   int b(View var1) {
      return 0;
   }

   public LinearLayoutCompat.LayoutParams b(AttributeSet var1) {
      return new LinearLayoutCompat.LayoutParams(this.getContext(), var1);
   }

   protected LinearLayoutCompat.LayoutParams b(android.view.ViewGroup.LayoutParams var1) {
      return new LinearLayoutCompat.LayoutParams(var1);
   }

   View b(int var1) {
      return this.getChildAt(var1);
   }

   void b(int var1, int var2) {
      this.f = 0;
      int var7 = 0;
      int var6 = 0;
      int var10 = 0;
      int var12 = 0;
      int var5 = 1;
      float var3 = 0.0F;
      int var20 = this.getVirtualChildCount();
      int var22 = MeasureSpec.getMode(var1);
      int var21 = MeasureSpec.getMode(var2);
      int var11 = 0;
      int var9 = 0;
      if (this.i == null || this.j == null) {
         this.i = new int[4];
         this.j = new int[4];
      }

      int[] var26 = this.i;
      int[] var25 = this.j;
      var26[3] = -1;
      var26[2] = -1;
      var26[1] = -1;
      var26[0] = -1;
      var25[3] = -1;
      var25[2] = -1;
      var25[1] = -1;
      var25[0] = -1;
      boolean var23 = this.a;
      boolean var24 = this.h;
      boolean var16;
      if (var22 == 1073741824) {
         var16 = true;
      } else {
         var16 = false;
      }

      int var8 = 0;
      int var13 = 0;

      while (var13 < var20) {
         View var27 = this.b(var13);
         boolean var52;
         if (var27 == null) {
            this.f = this.f + this.d(var13);
            int var14 = var8;
            boolean var15 = (boolean)var9;
            var9 = var7;
            var7 = var6;
            var52 = (boolean)var5;
            var5 = var15;
            var6 = var14;
         } else if (var27.getVisibility() == 8) {
            int var17 = var13 + this.a(var27, var13);
            var13 = var8;
            boolean var95 = (boolean)var9;
            var52 = (boolean)var5;
            int var83 = var6;
            var9 = var7;
            var6 = var13;
            var5 = var95;
            var13 = var17;
            var7 = var83;
         } else {
            if (this.c(var13)) {
               this.f = this.f + this.l;
            }

            LinearLayoutCompat.LayoutParams var28 = (LinearLayoutCompat.LayoutParams)var27.getLayoutParams();
            var3 += var28.g;
            int var86;
            boolean var98;
            if (var22 == 1073741824 && var28.width == 0 && var28.g > 0.0F) {
               if (var16) {
                  this.f = this.f + var28.leftMargin + var28.rightMargin;
               } else {
                  var86 = this.f;
                  this.f = Math.max(var86, var28.leftMargin + var86 + var28.rightMargin);
               }

               if (var23) {
                  var86 = MeasureSpec.makeMeasureSpec(0, 0);
                  var27.measure(var86, var86);
                  var98 = var9;
                  var86 = var8;
               } else {
                  var98 = 1;
                  var86 = var8;
               }
            } else {
               var98 = Integer.MIN_VALUE;
               var86 = var98;
               if (var28.width == 0) {
                  var86 = var98;
                  if (var28.g > 0.0F) {
                     var86 = 0;
                     var28.width = -2;
                  }
               }

               if (var3 == 0.0F) {
                  var98 = this.f;
               } else {
                  var98 = 0;
               }

               this.a(var27, var13, var1, var98, var2, 0);
               if (var86 != Integer.MIN_VALUE) {
                  var28.width = var86;
               }

               int var103 = var27.getMeasuredWidth();
               if (var16) {
                  this.f = this.f + var28.leftMargin + var103 + var28.rightMargin + this.b(var27);
               } else {
                  var86 = this.f;
                  this.f = Math.max(var86, var86 + var103 + var28.leftMargin + var28.rightMargin + this.b(var27));
               }

               var86 = var8;
               var98 = var9;
               if (var24) {
                  var86 = Math.max(var103, var8);
                  var98 = var9;
               }
            }

            boolean var61 = false;
            if (var21 != 1073741824 && var28.height == -1) {
               var52 = true;
               var61 = true;
            } else {
               var52 = (boolean)var11;
            }

            var11 = var28.topMargin;
            var11 = var28.bottomMargin + var11;
            int var104 = var27.getMeasuredHeight() + var11;
            int var18 = View.combineMeasuredStates(var6, var27.getMeasuredState());
            if (var23) {
               int var19 = var27.getBaseline();
               if (var19 != -1) {
                  if (var28.h < 0) {
                     var6 = this.e;
                  } else {
                     var6 = var28.h;
                  }

                  var6 = ((var6 & 112) >> 4 & -2) >> 1;
                  var26[var6] = Math.max(var26[var6], var19);
                  var25[var6] = Math.max(var25[var6], var104 - var19);
               }
            }

            int var106 = Math.max(var7, var104);
            boolean var43;
            if (var5 && var28.height == -1) {
               var43 = true;
            } else {
               var43 = false;
            }

            if (var28.g > 0.0F) {
               if (!var61) {
                  var11 = var104;
               }

               var6 = Math.max(var12, var11);
               var5 = var10;
            } else {
               if (!var61) {
                  var11 = var104;
               }

               var5 = Math.max(var10, var11);
               var6 = var12;
            }

            var13 += this.a(var27, var13);
            var12 = var6;
            var10 = var5;
            var9 = var106;
            var6 = var86;
            var86 = var18;
            var11 = var52;
            var5 = (boolean)var98;
            var52 = var43;
            var7 = var86;
         }

         var13++;
         int var99 = var6;
         boolean var90 = var52;
         var6 = var7;
         var7 = var9;
         var8 = var99;
         var9 = var5;
         var5 = var90;
      }

      if (this.f > 0 && this.c(var20)) {
         this.f = this.f + this.l;
      }

      if (var26[1] == -1 && var26[0] == -1 && var26[2] == -1 && var26[3] == -1) {
         var13 = var7;
      } else {
         var13 = Math.max(
            var7, Math.max(var26[3], Math.max(var26[0], Math.max(var26[1], var26[2]))) + Math.max(var25[3], Math.max(var25[0], Math.max(var25[1], var25[2])))
         );
      }

      if (var24 && (var22 == Integer.MIN_VALUE || var22 == 0)) {
         this.f = 0;

         for (int var44 = 0; var44 < var20; var44++) {
            View var110 = this.b(var44);
            if (var110 == null) {
               this.f = this.f + this.d(var44);
            } else if (var110.getVisibility() == 8) {
               var44 += this.a(var110, var44);
            } else {
               LinearLayoutCompat.LayoutParams var108 = (LinearLayoutCompat.LayoutParams)var110.getLayoutParams();
               if (var16) {
                  int var91 = this.f;
                  int var100 = var108.leftMargin;
                  this.f = var108.rightMargin + var100 + var8 + this.b(var110) + var91;
               } else {
                  int var101 = this.f;
                  int var92 = var108.leftMargin;
                  this.f = Math.max(var101, var108.rightMargin + var101 + var8 + var92 + this.b(var110));
               }
            }
         }
      }

      this.f = this.f + this.getPaddingLeft() + this.getPaddingRight();
      int var105 = View.resolveSizeAndState(Math.max(this.f, this.getSuggestedMinimumWidth()), var1, 0);
      var7 = (16777215 & var105) - this.f;
      boolean var63;
      if (var9 || var7 != 0 && var3 > 0.0F) {
         if (this.g > 0.0F) {
            var3 = this.g;
         }

         var26[3] = -1;
         var26[2] = -1;
         var26[1] = -1;
         var26[0] = -1;
         var25[3] = -1;
         var25[2] = -1;
         var25[1] = -1;
         var25[0] = -1;
         this.f = 0;
         int var79 = 0;
         var12 = var10;
         var63 = var6;
         var8 = var7;
         var7 = -1;
         var10 = var79;
         var6 = var12;

         while (var10 < var20) {
            View var109 = this.b(var10);
            boolean var39;
            if (var109 != null) {
               if (var109.getVisibility() == 8) {
                  var12 = var8;
                  var8 = var7;
                  var7 = var6;
                  var39 = var5;
                  var5 = var12;
               } else {
                  LinearLayoutCompat.LayoutParams var111 = (LinearLayoutCompat.LayoutParams)var109.getLayoutParams();
                  float var4 = var111.g;
                  if (var4 > 0.0F) {
                     var79 = (int)(var8 * var4 / var3);
                     var12 = var8 - var79;
                     int var93 = getChildMeasureSpec(
                        var2, this.getPaddingTop() + this.getPaddingBottom() + var111.topMargin + var111.bottomMargin, var111.height
                     );
                     if (var111.width == 0 && var22 == 1073741824) {
                        if (var79 > 0) {
                           var8 = var79;
                        } else {
                           var8 = 0;
                        }

                        var109.measure(MeasureSpec.makeMeasureSpec(var8, 1073741824), var93);
                     } else {
                        var79 += var109.getMeasuredWidth();
                        var8 = var79;
                        if (var79 < 0) {
                           var8 = 0;
                        }

                        var109.measure(MeasureSpec.makeMeasureSpec(var8, 1073741824), var93);
                     }

                     var63 = View.combineMeasuredStates(var63, var109.getMeasuredState() & 0xFF000000);
                     var3 -= var4;
                     var8 = var12;
                  }

                  if (var16) {
                     this.f = this.f + var109.getMeasuredWidth() + var111.leftMargin + var111.rightMargin + this.b(var109);
                  } else {
                     var12 = this.f;
                     this.f = Math.max(var12, var109.getMeasuredWidth() + var12 + var111.leftMargin + var111.rightMargin + this.b(var109));
                  }

                  boolean var73;
                  if (var21 != 1073741824 && var111.height == -1) {
                     var73 = 1;
                  } else {
                     var73 = 0;
                  }

                  int var102 = var111.topMargin + var111.bottomMargin;
                  int var94 = var109.getMeasuredHeight() + var102;
                  var79 = Math.max(var7, var94);
                  if (var73) {
                     var7 = var102;
                  } else {
                     var7 = var94;
                  }

                  var7 = Math.max(var6, var7);
                  boolean var33;
                  if (var5 && var111.height == -1) {
                     var33 = true;
                  } else {
                     var33 = false;
                  }

                  if (var23) {
                     var73 = var109.getBaseline();
                     if (var73 != -1) {
                        if (var111.h < 0) {
                           var39 = this.e;
                        } else {
                           var39 = var111.h;
                        }

                        var39 = ((var39 & 112) >> 4 & -2) >> 1;
                        var26[var39] = Math.max(var26[var39], var73);
                        var25[var39] = Math.max(var25[var39], var94 - var73);
                     }
                  }

                  var39 = var33;
                  var5 = var8;
                  var8 = var79;
               }
            } else {
               var12 = var8;
               var8 = var7;
               var7 = var6;
               var39 = var5;
               var5 = var12;
            }

            var12 = var10 + 1;
            var10 = var7;
            var7 = var8;
            var8 = var5;
            var5 = var39;
            var6 = var10;
            var10 = var12;
         }

         label223: {
            this.f = this.f + this.getPaddingLeft() + this.getPaddingRight();
            if (var26[1] == -1 && var26[0] == -1 && var26[2] == -1) {
               var8 = var7;
               if (var26[3] == -1) {
                  break label223;
               }
            }

            var8 = Math.max(
               var7,
               Math.max(var26[3], Math.max(var26[0], Math.max(var26[1], var26[2]))) + Math.max(var25[3], Math.max(var25[0], Math.max(var25[1], var25[2])))
            );
         }

         boolean var51 = (boolean)var5;
         var5 = var63;
         var63 = var51;
         var7 = var8;
         var8 = var6;
      } else {
         var63 = Math.max(var10, var12);
         if (var24 && var22 != 1073741824) {
            for (int var46 = 0; var46 < var20; var46++) {
               View var107 = this.b(var46);
               if (var107 != null && var107.getVisibility() != 8 && ((LinearLayoutCompat.LayoutParams)var107.getLayoutParams()).g > 0.0F) {
                  var107.measure(MeasureSpec.makeMeasureSpec(var8, 1073741824), MeasureSpec.makeMeasureSpec(var107.getMeasuredHeight(), 1073741824));
               }
            }
         }

         var8 = var63;
         var7 = var13;
         var63 = var5;
         var5 = var6;
      }

      if (var63 || var21 == 1073741824) {
         var8 = var7;
      }

      this.setMeasuredDimension(
         0xFF000000 & var5 | var105,
         View.resolveSizeAndState(Math.max(var8 + this.getPaddingTop() + this.getPaddingBottom(), this.getSuggestedMinimumHeight()), var2, var5 << 16)
      );
      if (var11) {
         this.d(var20, var1);
      }
   }

   void b(int var1, int var2, int var3, int var4) {
      boolean var17 = ViewUtils.a(this);
      int var7 = this.getPaddingTop();
      int var9 = var4 - var2;
      int var10 = this.getPaddingBottom();
      int var12 = this.getPaddingBottom();
      int var13 = this.getVirtualChildCount();
      var2 = this.e;
      int var11 = this.e;
      boolean var18 = this.a;
      int[] var21 = this.i;
      int[] var22 = this.j;
      switch (GravityCompat.a(var2 & 8388615, ViewCompat.e(this))) {
         case 1:
            var1 = this.getPaddingLeft() + (var3 - var1 - this.f) / 2;
            break;
         case 5:
            var1 = this.getPaddingLeft() + var3 - var1 - this.f;
            break;
         default:
            var1 = this.getPaddingLeft();
      }

      byte var5;
      if (var17) {
         var5 = -1;
         var4 = var13 - 1;
      } else {
         var5 = 1;
         var4 = 0;
      }

      var2 = 0;
      var3 = var1;

      while (var2 < var13) {
         int var14 = var4 + var5 * var2;
         View var20 = this.b(var14);
         if (var20 == null) {
            var3 += this.d(var14);
            var1 = var2;
         } else if (var20.getVisibility() != 8) {
            int var15 = var20.getMeasuredWidth();
            int var16 = var20.getMeasuredHeight();
            LinearLayoutCompat.LayoutParams var19 = (LinearLayoutCompat.LayoutParams)var20.getLayoutParams();
            int var6;
            if (var18 && var19.height != -1) {
               var6 = var20.getBaseline();
            } else {
               var6 = -1;
            }

            int var8 = var19.h;
            var1 = var8;
            if (var8 < 0) {
               var1 = var11 & 112;
            }

            switch (var1 & 112) {
               case 16:
                  var1 = (var9 - var7 - var12 - var16) / 2 + var7 + var19.topMargin - var19.bottomMargin;
                  break;
               case 48:
                  var8 = var7 + var19.topMargin;
                  var1 = var8;
                  if (var6 != -1) {
                     var1 = var8 + (var21[1] - var6);
                  }
                  break;
               case 80:
                  var8 = var9 - var10 - var16 - var19.bottomMargin;
                  var1 = var8;
                  if (var6 != -1) {
                     var1 = var20.getMeasuredHeight();
                     var1 = var8 - (var22[2] - (var1 - var6));
                  }
                  break;
               default:
                  var1 = var7;
            }

            if (this.c(var14)) {
               var3 += this.l;
            }

            var3 += var19.leftMargin;
            this.a(var20, var3 + this.a(var20), var1, var15, var16);
            var3 += var19.rightMargin + var15 + this.b(var20);
            var1 = this.a(var20, var14) + var2;
         } else {
            var1 = var2;
         }

         var2 = var1 + 1;
      }
   }

   void b(Canvas var1) {
      int var4 = this.getVirtualChildCount();
      boolean var5 = ViewUtils.a(this);

      for (int var2 = 0; var2 < var4; var2++) {
         View var7 = this.b(var2);
         if (var7 != null && var7.getVisibility() != 8 && this.c(var2)) {
            LinearLayoutCompat.LayoutParams var6 = (LinearLayoutCompat.LayoutParams)var7.getLayoutParams();
            int var10;
            if (var5) {
               var10 = var7.getRight();
               var10 = var6.rightMargin + var10;
            } else {
               var10 = var7.getLeft() - var6.leftMargin - this.l;
            }

            this.b(var1, var10);
         }
      }

      if (this.c(var4)) {
         View var12 = this.b(var4 - 1);
         int var8;
         if (var12 == null) {
            if (var5) {
               var8 = this.getPaddingLeft();
            } else {
               var8 = this.getWidth() - this.getPaddingRight() - this.l;
            }
         } else {
            LinearLayoutCompat.LayoutParams var11 = (LinearLayoutCompat.LayoutParams)var12.getLayoutParams();
            if (var5) {
               var8 = var12.getLeft() - var11.leftMargin - this.l;
            } else {
               var8 = var12.getRight();
               var8 = var11.rightMargin + var8;
            }
         }

         this.b(var1, var8);
      }
   }

   void b(Canvas var1, int var2) {
      this.k.setBounds(var2, this.getPaddingTop() + this.o, this.l + var2, this.getHeight() - this.getPaddingBottom() - this.o);
      this.k.draw(var1);
   }

   protected boolean c(int var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == 0) {
         if ((this.n & 1) != 0) {
            var2 = var3;
         } else {
            var2 = false;
         }
      } else if (var1 == this.getChildCount()) {
         var2 = var3;
         if ((this.n & 4) == 0) {
            var2 = false;
         }
      } else if ((this.n & 2) != 0) {
         var1--;

         while (true) {
            if (var1 < 0) {
               var2 = false;
               break;
            }

            var2 = var3;
            if (this.getChildAt(var1).getVisibility() != 8) {
               break;
            }

            var1--;
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof LinearLayoutCompat.LayoutParams;
   }

   int d(int var1) {
      return 0;
   }

   public int getBaseline() {
      int var1 = -1;
      if (this.b < 0) {
         var1 = super.getBaseline();
      } else {
         if (this.getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
         }

         View var4 = this.getChildAt(this.b);
         int var2 = var4.getBaseline();
         if (var2 == -1) {
            if (this.b != 0) {
               throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
         } else {
            var1 = this.c;
            if (this.d == 1) {
               int var3 = this.e & 112;
               if (var3 != 48) {
                  switch (var3) {
                     case 16:
                        var1 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
                        break;
                     case 80:
                        var1 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f;
                  }
               }
            }

            var1 = ((LinearLayoutCompat.LayoutParams)var4.getLayoutParams()).topMargin + var1 + var2;
         }
      }

      return var1;
   }

   public int getBaselineAlignedChildIndex() {
      return this.b;
   }

   public Drawable getDividerDrawable() {
      return this.k;
   }

   public int getDividerPadding() {
      return this.o;
   }

   public int getDividerWidth() {
      return this.l;
   }

   public int getGravity() {
      return this.e;
   }

   public int getOrientation() {
      return this.d;
   }

   public int getShowDividers() {
      return this.n;
   }

   int getVirtualChildCount() {
      return this.getChildCount();
   }

   public float getWeightSum() {
      return this.g;
   }

   protected LinearLayoutCompat.LayoutParams j() {
      LinearLayoutCompat.LayoutParams var1;
      if (this.d == 0) {
         var1 = new LinearLayoutCompat.LayoutParams(-2, -2);
      } else if (this.d == 1) {
         var1 = new LinearLayoutCompat.LayoutParams(-1, -2);
      } else {
         var1 = null;
      }

      return var1;
   }

   protected void onDraw(Canvas var1) {
      if (this.k != null) {
         if (this.d == 1) {
            this.a(var1);
         } else {
            this.b(var1);
         }
      }
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName(LinearLayoutCompat.class.getName());
   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      super.onInitializeAccessibilityNodeInfo(var1);
      var1.setClassName(LinearLayoutCompat.class.getName());
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if (this.d == 1) {
         this.a(var2, var3, var4, var5);
      } else {
         this.b(var2, var3, var4, var5);
      }
   }

   protected void onMeasure(int var1, int var2) {
      if (this.d == 1) {
         this.a(var1, var2);
      } else {
         this.b(var1, var2);
      }
   }

   public void setBaselineAligned(boolean var1) {
      this.a = var1;
   }

   public void setBaselineAlignedChildIndex(int var1) {
      if (var1 >= 0 && var1 < this.getChildCount()) {
         this.b = var1;
      } else {
         throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
      }
   }

   public void setDividerDrawable(Drawable var1) {
      boolean var2 = false;
      if (var1 != this.k) {
         this.k = var1;
         if (var1 != null) {
            this.l = var1.getIntrinsicWidth();
            this.m = var1.getIntrinsicHeight();
         } else {
            this.l = 0;
            this.m = 0;
         }

         if (var1 == null) {
            var2 = true;
         }

         this.setWillNotDraw(var2);
         this.requestLayout();
      }
   }

   public void setDividerPadding(int var1) {
      this.o = var1;
   }

   public void setGravity(int var1) {
      if (this.e != var1) {
         if ((8388615 & var1) == 0) {
            var1 |= 8388611;
         }

         int var2 = var1;
         if ((var1 & 112) == 0) {
            var2 = var1 | 48;
         }

         this.e = var2;
         this.requestLayout();
      }
   }

   public void setHorizontalGravity(int var1) {
      var1 &= 8388615;
      if ((this.e & 8388615) != var1) {
         this.e = var1 | this.e & -8388616;
         this.requestLayout();
      }
   }

   public void setMeasureWithLargestChildEnabled(boolean var1) {
      this.h = var1;
   }

   public void setOrientation(int var1) {
      if (this.d != var1) {
         this.d = var1;
         this.requestLayout();
      }
   }

   public void setShowDividers(int var1) {
      if (var1 != this.n) {
         this.requestLayout();
      }

      this.n = var1;
   }

   public void setVerticalGravity(int var1) {
      var1 &= 112;
      if ((this.e & 112) != var1) {
         this.e = var1 | this.e & -113;
         this.requestLayout();
      }
   }

   public void setWeightSum(float var1) {
      this.g = Math.max(0.0F, var1);
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }

   public static class LayoutParams extends MarginLayoutParams {
      public float g;
      public int h = -1;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.g = 0.0F;
      }

      public LayoutParams(int var1, int var2, float var3) {
         super(var1, var2);
         this.g = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.LinearLayoutCompat_Layout);
         this.g = var3.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
         this.h = var3.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
         var3.recycle();
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }
   }
}
