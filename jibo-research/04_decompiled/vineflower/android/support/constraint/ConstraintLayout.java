package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class ConstraintLayout extends ViewGroup {
   SparseArray<View> a = new SparseArray();
   ConstraintWidgetContainer b;
   private final ArrayList<ConstraintWidget> c = new ArrayList<>(100);
   private int d;
   private int e;
   private int f;
   private int g;
   private boolean h;
   private int i;
   private ConstraintSet j;

   public ConstraintLayout(Context var1) {
      super(var1);
      this.b = new ConstraintWidgetContainer();
      this.d = 0;
      this.e = 0;
      this.f = Integer.MAX_VALUE;
      this.g = Integer.MAX_VALUE;
      this.h = true;
      this.i = 2;
      this.j = null;
      this.b(null);
   }

   public ConstraintLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.b = new ConstraintWidgetContainer();
      this.d = 0;
      this.e = 0;
      this.f = Integer.MAX_VALUE;
      this.g = Integer.MAX_VALUE;
      this.h = true;
      this.i = 2;
      this.j = null;
      this.b(var2);
   }

   public ConstraintLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.b = new ConstraintWidgetContainer();
      this.d = 0;
      this.e = 0;
      this.f = Integer.MAX_VALUE;
      this.g = Integer.MAX_VALUE;
      this.h = true;
      this.i = 2;
      this.j = null;
      this.b(var2);
   }

   private final ConstraintWidget a(int var1) {
      ConstraintWidget var2;
      if (var1 == 0) {
         var2 = this.b;
      } else {
         View var3 = (View)this.a.get(var1);
         if (var3 == this) {
            var2 = this.b;
         } else if (var3 == null) {
            var2 = null;
         } else {
            var2 = ((ConstraintLayout.LayoutParams)var3.getLayoutParams()).Z;
         }
      }

      return var2;
   }

   private final ConstraintWidget a(View var1) {
      ConstraintWidget var2;
      if (var1 == this) {
         var2 = this.b;
      } else if (var1 == null) {
         var2 = null;
      } else {
         var2 = ((ConstraintLayout.LayoutParams)var1.getLayoutParams()).Z;
      }

      return var2;
   }

   private void a(int var1, int var2) {
      int var12 = this.getPaddingTop() + this.getPaddingBottom();
      int var10 = this.getPaddingLeft() + this.getPaddingRight();
      int var11 = this.getChildCount();

      for (int var5 = 0; var5 < var11; var5++) {
         View var15 = this.getChildAt(var5);
         if (var15.getVisibility() != 8) {
            ConstraintLayout.LayoutParams var14 = (ConstraintLayout.LayoutParams)var15.getLayoutParams();
            ConstraintWidget var13 = var14.Z;
            if (!var14.R) {
               int var6 = var14.width;
               int var8 = var14.height;
               boolean var3;
               if (!var14.O && !var14.P && (var14.O || var14.F != 1) && var14.width != -1 && (var14.P || var14.G != 1 && var14.height != -1)) {
                  var3 = 0;
               } else {
                  var3 = 1;
               }

               boolean var9 = false;
               int var7 = 0;
               boolean var4 = false;
               if (!var3) {
                  var3 = var6;
                  var4 = var9;
               } else {
                  boolean var16;
                  if (var6 != 0 && var6 != -1) {
                     var6 = getChildMeasureSpec(var1, var10, var6);
                     var16 = false;
                  } else {
                     var6 = getChildMeasureSpec(var1, var10, -2);
                     var16 = true;
                  }

                  if (var8 != 0 && var8 != -1) {
                     var7 = getChildMeasureSpec(var2, var12, var8);
                  } else {
                     var7 = getChildMeasureSpec(var2, var12, -2);
                     var4 = true;
                  }

                  var15.measure(var6, var7);
                  var7 = var15.getMeasuredWidth();
                  var8 = var15.getMeasuredHeight();
                  boolean var21 = var16;
                  var3 = var7;
                  var7 = var4;
                  var4 = var21;
               }

               var13.d(var3);
               var13.e(var8);
               if (var4) {
                  var13.h(var3);
               }

               if (var7) {
                  var13.i(var8);
               }

               if (var14.Q) {
                  var3 = var15.getBaseline();
                  if (var3 != -1) {
                     var13.j(var3);
                  }
               }
            }
         }
      }
   }

   private void b(int var1, int var2) {
      int var6 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      int var3 = MeasureSpec.getMode(var2);
      var2 = MeasureSpec.getSize(var2);
      int var5 = this.getPaddingTop();
      int var4 = this.getPaddingBottom();
      int var7 = this.getPaddingLeft();
      int var8 = this.getPaddingRight();
      ConstraintWidget.DimensionBehaviour var9 = ConstraintWidget.DimensionBehaviour.FIXED;
      ConstraintWidget.DimensionBehaviour var10 = ConstraintWidget.DimensionBehaviour.FIXED;
      this.getLayoutParams();
      switch (var6) {
         case Integer.MIN_VALUE:
            var9 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            break;
         case 0:
            var9 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            var1 = 0;
            break;
         case 1073741824:
            var1 = Math.min(this.f, var1) - (var7 + var8);
            break;
         default:
            var1 = 0;
      }

      switch (var3) {
         case Integer.MIN_VALUE:
            var10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            break;
         case 0:
            var10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            var2 = 0;
            break;
         case 1073741824:
            var2 = Math.min(this.g, var2) - (var5 + var4);
            break;
         default:
            var2 = 0;
      }

      this.b.f(0);
      this.b.g(0);
      this.b.a(var9);
      this.b.d(var1);
      this.b.b(var10);
      this.b.e(var2);
      this.b.f(this.d - this.getPaddingLeft() - this.getPaddingRight());
      this.b.g(this.e - this.getPaddingTop() - this.getPaddingBottom());
   }

   private void b(AttributeSet var1) {
      this.b.a(this);
      this.a.put(this.getId(), this);
      this.j = null;
      if (var1 != null) {
         TypedArray var5 = this.getContext().obtainStyledAttributes(var1, R.styleable.ConstraintLayout_Layout);
         int var3 = var5.getIndexCount();

         for (int var2 = 0; var2 < var3; var2++) {
            int var4 = var5.getIndex(var2);
            if (var4 == R.styleable.ConstraintLayout_Layout_android_minWidth) {
               this.d = var5.getDimensionPixelOffset(var4, this.d);
            } else if (var4 == R.styleable.ConstraintLayout_Layout_android_minHeight) {
               this.e = var5.getDimensionPixelOffset(var4, this.e);
            } else if (var4 == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
               this.f = var5.getDimensionPixelOffset(var4, this.f);
            } else if (var4 == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
               this.g = var5.getDimensionPixelOffset(var4, this.g);
            } else if (var4 == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
               this.i = var5.getInt(var4, this.i);
            } else if (var4 == R.styleable.ConstraintLayout_Layout_constraintSet) {
               var4 = var5.getResourceId(var4, 0);
               this.j = new ConstraintSet();
               this.j.a(this.getContext(), var4);
            }
         }

         var5.recycle();
      }

      this.b.m(this.i);
   }

   private void c() {
      boolean var3 = false;
      int var4 = this.getChildCount();
      int var1 = 0;

      boolean var2;
      while (true) {
         var2 = var3;
         if (var1 >= var4) {
            break;
         }

         if (this.getChildAt(var1).isLayoutRequested()) {
            var2 = true;
            break;
         }

         var1++;
      }

      if (var2) {
         this.c.clear();
         this.d();
      }
   }

   private void d() {
      if (this.j != null) {
         this.j.a(this);
      }

      int var16 = this.getChildCount();
      this.b.I();

      for (int var12 = 0; var12 < var16; var12++) {
         View var19 = this.getChildAt(var12);
         android.support.constraint.solver.widgets.Guideline var18 = this.a(var19);
         if (var18 != null) {
            ConstraintLayout.LayoutParams var17 = (ConstraintLayout.LayoutParams)var19.getLayoutParams();
            var18.a();
            var18.a(var19.getVisibility());
            var18.a(var19);
            this.b.b(var18);
            if (!var17.P || !var17.O) {
               this.c.add(var18);
            }

            if (var17.R) {
               var18 = var18;
               if (var17.a != -1) {
                  var18.n(var17.a);
               }

               if (var17.b != -1) {
                  var18.o(var17.b);
               }

               if (var17.c != -1.0F) {
                  var18.e(var17.c);
               }
            } else if (var17.S != -1
               || var17.T != -1
               || var17.U != -1
               || var17.V != -1
               || var17.h != -1
               || var17.i != -1
               || var17.j != -1
               || var17.k != -1
               || var17.l != -1
               || var17.L != -1
               || var17.M != -1
               || var17.width == -1
               || var17.height == -1) {
               float var1;
               int var5;
               int var13;
               int var21;
               int var22;
               int var24;
               int var26;
               label167: {
                  int var10 = var17.S;
                  int var11 = var17.T;
                  int var9 = var17.U;
                  var26 = var17.V;
                  var24 = var17.W;
                  int var8 = var17.X;
                  float var2 = var17.Y;
                  if (VERSION.SDK_INT < 17) {
                     var26 = var17.d;
                     var24 = var17.e;
                     int var15 = var17.f;
                     int var14 = var17.g;
                     var13 = var17.q;
                     var5 = var17.s;
                     var1 = var17.w;
                     var22 = var24;
                     var21 = var26;
                     if (var26 == -1) {
                        var22 = var24;
                        var21 = var26;
                        if (var24 == -1) {
                           if (var17.n != -1) {
                              var21 = var17.n;
                              var22 = var24;
                           } else {
                              var22 = var24;
                              var21 = var26;
                              if (var17.m != -1) {
                                 var22 = var17.m;
                                 var21 = var26;
                              }
                           }
                        }
                     }

                     var2 = var1;
                     var8 = var5;
                     var26 = var14;
                     var9 = var15;
                     var24 = var13;
                     var11 = var22;
                     var10 = var21;
                     if (var15 == -1) {
                        var2 = var1;
                        var8 = var5;
                        var26 = var14;
                        var9 = var15;
                        var24 = var13;
                        var11 = var22;
                        var10 = var21;
                        if (var14 == -1) {
                           if (var17.o != -1) {
                              var26 = var17.o;
                              var8 = var22;
                              var24 = var14;
                              var22 = var21;
                              var21 = var8;
                              break label167;
                           }

                           var2 = var1;
                           var8 = var5;
                           var26 = var14;
                           var9 = var15;
                           var24 = var13;
                           var11 = var22;
                           var10 = var21;
                           if (var17.p != -1) {
                              var24 = var17.p;
                              var26 = var15;
                              var8 = var21;
                              var21 = var22;
                              var22 = var8;
                              break label167;
                           }
                        }
                     }
                  }

                  var1 = var2;
                  var21 = var11;
                  var5 = var8;
                  var22 = var10;
                  var13 = var24;
                  var24 = var26;
                  var26 = var9;
               }

               if (var22 != -1) {
                  ConstraintWidget var30 = this.a(var22);
                  if (var30 != null) {
                     var18.a(ConstraintAnchor.Type.LEFT, var30, ConstraintAnchor.Type.LEFT, var17.leftMargin, var13);
                  }
               } else if (var21 != -1) {
                  ConstraintWidget var31 = this.a(var21);
                  if (var31 != null) {
                     var18.a(ConstraintAnchor.Type.LEFT, var31, ConstraintAnchor.Type.RIGHT, var17.leftMargin, var13);
                  }
               }

               if (var26 != -1) {
                  ConstraintWidget var32 = this.a(var26);
                  if (var32 != null) {
                     var18.a(ConstraintAnchor.Type.RIGHT, var32, ConstraintAnchor.Type.LEFT, var17.rightMargin, var5);
                  }
               } else if (var24 != -1) {
                  ConstraintWidget var33 = this.a(var24);
                  if (var33 != null) {
                     var18.a(ConstraintAnchor.Type.RIGHT, var33, ConstraintAnchor.Type.RIGHT, var17.rightMargin, var5);
                  }
               }

               if (var17.h != -1) {
                  ConstraintWidget var34 = this.a(var17.h);
                  if (var34 != null) {
                     var18.a(ConstraintAnchor.Type.TOP, var34, ConstraintAnchor.Type.TOP, var17.topMargin, var17.r);
                  }
               } else if (var17.i != -1) {
                  ConstraintWidget var35 = this.a(var17.i);
                  if (var35 != null) {
                     var18.a(ConstraintAnchor.Type.TOP, var35, ConstraintAnchor.Type.BOTTOM, var17.topMargin, var17.r);
                  }
               }

               if (var17.j != -1) {
                  ConstraintWidget var36 = this.a(var17.j);
                  if (var36 != null) {
                     var18.a(ConstraintAnchor.Type.BOTTOM, var36, ConstraintAnchor.Type.TOP, var17.bottomMargin, var17.t);
                  }
               } else if (var17.k != -1) {
                  ConstraintWidget var37 = this.a(var17.k);
                  if (var37 != null) {
                     var18.a(ConstraintAnchor.Type.BOTTOM, var37, ConstraintAnchor.Type.BOTTOM, var17.bottomMargin, var17.t);
                  }
               }

               if (var17.l != -1) {
                  View var20 = (View)this.a.get(var17.l);
                  ConstraintWidget var38 = this.a(var17.l);
                  if (var38 != null && var20 != null && var20.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                     ConstraintLayout.LayoutParams var39 = (ConstraintLayout.LayoutParams)var20.getLayoutParams();
                     var17.Q = true;
                     var39.Q = true;
                     var18.a(ConstraintAnchor.Type.BASELINE).a(var38.a(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                     var18.a(ConstraintAnchor.Type.TOP).i();
                     var18.a(ConstraintAnchor.Type.BOTTOM).i();
                  }
               }

               if (var1 >= 0.0F && var1 != 0.5F) {
                  var18.a(var1);
               }

               if (var17.x >= 0.0F && var17.x != 0.5F) {
                  var18.b(var17.x);
               }

               if (this.isInEditMode() && (var17.L != -1 || var17.M != -1)) {
                  var18.a(var17.L, var17.M);
               }

               if (!var17.O) {
                  if (var17.width == -1) {
                     var18.a(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                     var18.a(ConstraintAnchor.Type.LEFT).d = var17.leftMargin;
                     var18.a(ConstraintAnchor.Type.RIGHT).d = var17.rightMargin;
                  } else {
                     var18.a(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                     var18.d(0);
                  }
               } else {
                  var18.a(ConstraintWidget.DimensionBehaviour.FIXED);
                  var18.d(var17.width);
               }

               if (!var17.P) {
                  if (var17.height == -1) {
                     var18.b(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                     var18.a(ConstraintAnchor.Type.TOP).d = var17.topMargin;
                     var18.a(ConstraintAnchor.Type.BOTTOM).d = var17.bottomMargin;
                  } else {
                     var18.b(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                     var18.e(0);
                  }
               } else {
                  var18.b(ConstraintWidget.DimensionBehaviour.FIXED);
                  var18.e(var17.height);
               }

               if (var17.y != null) {
                  var18.a(var17.y);
               }

               var18.c(var17.B);
               var18.d(var17.C);
               var18.k(var17.D);
               var18.l(var17.E);
               var18.a(var17.F, var17.H, var17.J);
               var18.b(var17.G, var17.I, var17.K);
            }
         }
      }
   }

   public ConstraintLayout.LayoutParams a(AttributeSet var1) {
      return new ConstraintLayout.LayoutParams(this.getContext(), var1);
   }

   protected void a() {
      this.b.F();
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      super.addView(var1, var2, var3);
      if (VERSION.SDK_INT < 14) {
         this.onViewAdded(var1);
      }
   }

   protected ConstraintLayout.LayoutParams b() {
      return new ConstraintLayout.LayoutParams(-2, -2);
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof ConstraintLayout.LayoutParams;
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return new ConstraintLayout.LayoutParams(var1);
   }

   public int getMaxHeight() {
      return this.g;
   }

   public int getMaxWidth() {
      return this.f;
   }

   public int getMinHeight() {
      return this.e;
   }

   public int getMinWidth() {
      return this.d;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var3 = this.getChildCount();
      var1 = this.isInEditMode();

      for (int var9 = 0; var9 < var3; var9++) {
         View var6 = this.getChildAt(var9);
         ConstraintLayout.LayoutParams var7 = (ConstraintLayout.LayoutParams)var6.getLayoutParams();
         if (var6.getVisibility() != 8 || var7.R || var1) {
            ConstraintWidget var13 = var7.Z;
            var5 = var13.n();
            var4 = var13.o();
            var6.layout(var5, var4, var13.h() + var5, var13.l() + var4);
         }
      }
   }

   protected void onMeasure(int var1, int var2) {
      int var4 = this.getPaddingLeft();
      int var6 = this.getPaddingTop();
      this.b.b(var4);
      this.b.c(var6);
      this.b(var1, var2);
      if (this.h) {
         this.h = false;
         this.c();
      }

      this.a(var1, var2);
      if (this.getChildCount() > 0) {
         this.a();
      }

      int var5 = 0;
      int var3 = 0;
      int var11 = this.c.size();
      int var10 = var6 + this.getPaddingBottom();
      int var12 = var4 + this.getPaddingRight();
      if (var11 > 0) {
         int var25 = 0;
         boolean var34;
         if (this.b.B() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            var34 = true;
         } else {
            var34 = false;
         }

         boolean var7;
         if (this.b.C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            var7 = true;
         } else {
            var7 = false;
         }

         for (int var8 = 0; var8 < var11; var8++) {
            ConstraintWidget var15 = this.c.get(var8);
            if (!(var15 instanceof android.support.constraint.solver.widgets.Guideline)) {
               View var13 = (View)var15.x();
               if (var13 != null && var13.getVisibility() != 8) {
                  ConstraintLayout.LayoutParams var14 = (ConstraintLayout.LayoutParams)var13.getLayoutParams();
                  if (var14.width == -2) {
                     var5 = getChildMeasureSpec(var1, var12, var14.width);
                  } else {
                     var5 = MeasureSpec.makeMeasureSpec(var15.h(), 1073741824);
                  }

                  int var9;
                  if (var14.height == -2) {
                     var9 = getChildMeasureSpec(var2, var10, var14.height);
                  } else {
                     var9 = MeasureSpec.makeMeasureSpec(var15.l(), 1073741824);
                  }

                  var13.measure(var5, var9);
                  var5 = var13.getMeasuredWidth();
                  var9 = var13.getMeasuredHeight();
                  boolean var32;
                  if (var5 != var15.h()) {
                     var15.d(var5);
                     if (var34 && var15.t() > this.b.h()) {
                        var25 = var15.t();
                        var32 = var15.a(ConstraintAnchor.Type.RIGHT).d();
                        this.b.d(Math.max(this.d, var25 + var32));
                     }

                     var32 = 1;
                  } else {
                     var32 = var25;
                  }

                  if (var9 != var15.l()) {
                     var15.e(var9);
                     if (var7 && var15.u() > this.b.l()) {
                        var32 = var15.u();
                        var25 = var15.a(ConstraintAnchor.Type.BOTTOM).d();
                        this.b.e(Math.max(this.e, var32 + var25));
                     }

                     var32 = 1;
                  }

                  var25 = var32;
                  if (var14.Q) {
                     var9 = var13.getBaseline();
                     var25 = var32;
                     if (var9 != -1) {
                        var25 = var32;
                        if (var9 != var15.w()) {
                           var15.j(var9);
                           var25 = 1;
                        }
                     }
                  }

                  if (VERSION.SDK_INT >= 11) {
                     var3 = combineMeasuredStates(var3, var13.getMeasuredState());
                  }
               }
            }
         }

         var5 = var3;
         if (var25) {
            this.a();
            var5 = var3;
         }
      }

      var3 = this.b.h() + var12;
      var4 = this.b.l() + var10;
      if (VERSION.SDK_INT >= 11) {
         var1 = resolveSizeAndState(var3, var1, var5);
         var2 = resolveSizeAndState(var4, var2, var5 << 16);
         var3 = Math.min(this.f, var1);
         var1 = Math.min(this.g, var2);
         var2 = var3 & 16777215;
         var3 = var1 & 16777215;
         var1 = var2;
         if (this.b.D()) {
            var1 = var2 | 16777216;
         }

         var2 = var3;
         if (this.b.E()) {
            var2 = var3 | 16777216;
         }

         this.setMeasuredDimension(var1, var2);
      } else {
         this.setMeasuredDimension(var3, var4);
      }
   }

   public void onViewAdded(View var1) {
      if (VERSION.SDK_INT >= 14) {
         super.onViewAdded(var1);
      }

      ConstraintWidget var2 = this.a(var1);
      if (var1 instanceof Guideline && !(var2 instanceof android.support.constraint.solver.widgets.Guideline)) {
         ConstraintLayout.LayoutParams var3 = (ConstraintLayout.LayoutParams)var1.getLayoutParams();
         var3.Z = new android.support.constraint.solver.widgets.Guideline();
         var3.R = true;
         ((android.support.constraint.solver.widgets.Guideline)var3.Z).m(var3.N);
         var2 = var3.Z;
      }

      this.a.put(var1.getId(), var1);
      this.h = true;
   }

   public void onViewRemoved(View var1) {
      if (VERSION.SDK_INT >= 14) {
         super.onViewRemoved(var1);
      }

      this.a.remove(var1.getId());
      this.b.c(this.a(var1));
      this.h = true;
   }

   public void removeView(View var1) {
      super.removeView(var1);
      if (VERSION.SDK_INT < 14) {
         this.onViewRemoved(var1);
      }
   }

   public void requestLayout() {
      super.requestLayout();
      this.h = true;
   }

   public void setConstraintSet(ConstraintSet var1) {
      this.j = var1;
   }

   public void setId(int var1) {
      this.a.remove(this.getId());
      super.setId(var1);
      this.a.put(this.getId(), this);
   }

   public void setMaxHeight(int var1) {
      if (var1 != this.g) {
         this.g = var1;
         this.requestLayout();
      }
   }

   public void setMaxWidth(int var1) {
      if (var1 != this.f) {
         this.f = var1;
         this.requestLayout();
      }
   }

   public void setMinHeight(int var1) {
      if (var1 != this.e) {
         this.e = var1;
         this.requestLayout();
      }
   }

   public void setMinWidth(int var1) {
      if (var1 != this.d) {
         this.d = var1;
         this.requestLayout();
      }
   }

   public void setOptimizationLevel(int var1) {
      this.b.m(var1);
   }

   public static class LayoutParams extends MarginLayoutParams {
      int A;
      public float B;
      public float C;
      public int D;
      public int E;
      public int F;
      public int G;
      public int H;
      public int I;
      public int J;
      public int K;
      public int L;
      public int M;
      public int N;
      boolean O;
      boolean P;
      boolean Q;
      boolean R;
      int S;
      int T;
      int U;
      int V;
      int W;
      int X;
      float Y;
      ConstraintWidget Z;
      public int a = -1;
      public int b = -1;
      public float c = -1.0F;
      public int d = -1;
      public int e = -1;
      public int f = -1;
      public int g = -1;
      public int h = -1;
      public int i = -1;
      public int j = -1;
      public int k = -1;
      public int l = -1;
      public int m = -1;
      public int n = -1;
      public int o = -1;
      public int p = -1;
      public int q = -1;
      public int r = -1;
      public int s = -1;
      public int t = -1;
      public int u = -1;
      public int v = -1;
      public float w = 0.5F;
      public float x = 0.5F;
      public String y = null;
      float z = 0.0F;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.A = 1;
         this.B = 0.0F;
         this.C = 0.0F;
         this.D = 0;
         this.E = 0;
         this.F = 0;
         this.G = 0;
         this.H = 0;
         this.I = 0;
         this.J = 0;
         this.K = 0;
         this.L = -1;
         this.M = -1;
         this.N = -1;
         this.O = true;
         this.P = true;
         this.Q = false;
         this.R = false;
         this.S = -1;
         this.T = -1;
         this.U = -1;
         this.V = -1;
         this.W = -1;
         this.X = -1;
         this.Y = 0.5F;
         this.Z = new ConstraintWidget();
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         this.A = 1;
         this.B = 0.0F;
         this.C = 0.0F;
         this.D = 0;
         this.E = 0;
         this.F = 0;
         this.G = 0;
         this.H = 0;
         this.I = 0;
         this.J = 0;
         this.K = 0;
         this.L = -1;
         this.M = -1;
         this.N = -1;
         this.O = true;
         this.P = true;
         this.Q = false;
         this.R = false;
         this.S = -1;
         this.T = -1;
         this.U = -1;
         this.V = -1;
         this.W = -1;
         this.X = -1;
         this.Y = 0.5F;
         this.Z = new ConstraintWidget();
         TypedArray var15 = var1.obtainStyledAttributes(var2, R.styleable.ConstraintLayout_Layout);
         int var7 = var15.getIndexCount();

         for (int var5 = 0; var5 < var7; var5++) {
            int var6 = var15.getIndex(var5);
            if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
               this.d = var15.getResourceId(var6, this.d);
               if (this.d == -1) {
                  this.d = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
               this.e = var15.getResourceId(var6, this.e);
               if (this.e == -1) {
                  this.e = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
               this.f = var15.getResourceId(var6, this.f);
               if (this.f == -1) {
                  this.f = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
               this.g = var15.getResourceId(var6, this.g);
               if (this.g == -1) {
                  this.g = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
               this.h = var15.getResourceId(var6, this.h);
               if (this.h == -1) {
                  this.h = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
               this.i = var15.getResourceId(var6, this.i);
               if (this.i == -1) {
                  this.i = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
               this.j = var15.getResourceId(var6, this.j);
               if (this.j == -1) {
                  this.j = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
               this.k = var15.getResourceId(var6, this.k);
               if (this.k == -1) {
                  this.k = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
               this.l = var15.getResourceId(var6, this.l);
               if (this.l == -1) {
                  this.l = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX) {
               this.L = var15.getDimensionPixelOffset(var6, this.L);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY) {
               this.M = var15.getDimensionPixelOffset(var6, this.M);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin) {
               this.a = var15.getDimensionPixelOffset(var6, this.a);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end) {
               this.b = var15.getDimensionPixelOffset(var6, this.b);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent) {
               this.c = var15.getFloat(var6, this.c);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_android_orientation) {
               this.N = var15.getInt(var6, this.N);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
               this.m = var15.getResourceId(var6, this.m);
               if (this.m == -1) {
                  this.m = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
               this.n = var15.getResourceId(var6, this.n);
               if (this.n == -1) {
                  this.n = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
               this.o = var15.getResourceId(var6, this.o);
               if (this.o == -1) {
                  this.o = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
               this.p = var15.getResourceId(var6, this.p);
               if (this.p == -1) {
                  this.p = var15.getInt(var6, -1);
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft) {
               this.q = var15.getDimensionPixelSize(var6, this.q);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop) {
               this.r = var15.getDimensionPixelSize(var6, this.r);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight) {
               this.s = var15.getDimensionPixelSize(var6, this.s);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom) {
               this.t = var15.getDimensionPixelSize(var6, this.t);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart) {
               this.u = var15.getDimensionPixelSize(var6, this.u);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd) {
               this.v = var15.getDimensionPixelSize(var6, this.v);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
               this.w = var15.getFloat(var6, this.w);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias) {
               this.x = var15.getFloat(var6, this.x);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
               this.y = var15.getString(var6);
               this.z = Float.NaN;
               this.A = -1;
               if (this.y != null) {
                  int var8 = this.y.length();
                  var6 = this.y.indexOf(44);
                  if (var6 > 0 && var6 < var8 - 1) {
                     String var16 = this.y.substring(0, var6);
                     if (var16.equalsIgnoreCase("W")) {
                        this.A = 0;
                     } else if (var16.equalsIgnoreCase("H")) {
                        this.A = 1;
                     }

                     var6++;
                  } else {
                     var6 = 0;
                  }

                  int var9 = this.y.indexOf(58);
                  if (var9 >= 0 && var9 < var8 - 1) {
                     String var10 = this.y.substring(var6, var9);
                     String var18 = this.y.substring(var9 + 1);
                     if (var10.length() > 0 && var18.length() > 0) {
                        float var3;
                        float var4;
                        try {
                           var3 = Float.parseFloat(var10);
                           var4 = Float.parseFloat(var18);
                        } catch (NumberFormatException var13) {
                           continue;
                        }

                        if (var3 > 0.0F && var4 > 0.0F) {
                           try {
                              if (this.A == 1) {
                                 this.z = Math.abs(var4 / var3);
                                 continue;
                              }
                           } catch (NumberFormatException var14) {
                              continue;
                           }

                           var3 /= var4;

                           try {
                              this.z = Math.abs(var3);
                           } catch (NumberFormatException var12) {
                           }
                        }
                     }
                  } else {
                     String var17 = this.y.substring(var6);
                     if (var17.length() > 0) {
                        try {
                           this.z = Float.parseFloat(var17);
                        } catch (NumberFormatException var11) {
                        }
                     }
                  }
               }
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
               this.B = var15.getFloat(var6, 0.0F);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight) {
               this.C = var15.getFloat(var6, 0.0F);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
               this.D = var15.getInt(var6, 0);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
               this.E = var15.getInt(var6, 0);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default) {
               this.F = var15.getInt(var6, 0);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default) {
               this.G = var15.getInt(var6, 0);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min) {
               this.H = var15.getDimensionPixelSize(var6, this.H);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max) {
               this.J = var15.getDimensionPixelSize(var6, this.J);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min) {
               this.I = var15.getDimensionPixelSize(var6, this.I);
            } else if (var6 == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max) {
               this.K = var15.getDimensionPixelSize(var6, this.K);
            } else if (var6 != R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator
               && var6 != R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator
               && var6 != R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator
               && var6 != R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator
               && var6 == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator) {
            }
         }

         var15.recycle();
         this.a();
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
         this.A = 1;
         this.B = 0.0F;
         this.C = 0.0F;
         this.D = 0;
         this.E = 0;
         this.F = 0;
         this.G = 0;
         this.H = 0;
         this.I = 0;
         this.J = 0;
         this.K = 0;
         this.L = -1;
         this.M = -1;
         this.N = -1;
         this.O = true;
         this.P = true;
         this.Q = false;
         this.R = false;
         this.S = -1;
         this.T = -1;
         this.U = -1;
         this.V = -1;
         this.W = -1;
         this.X = -1;
         this.Y = 0.5F;
         this.Z = new ConstraintWidget();
      }

      public void a() {
         this.R = false;
         this.O = true;
         this.P = true;
         if (this.width == 0 || this.width == -1) {
            this.O = false;
         }

         if (this.height == 0 || this.height == -1) {
            this.P = false;
         }

         if (this.c != -1.0F || this.a != -1 || this.b != -1) {
            this.R = true;
            this.O = true;
            this.P = true;
            if (!(this.Z instanceof android.support.constraint.solver.widgets.Guideline)) {
               this.Z = new android.support.constraint.solver.widgets.Guideline();
            }

            ((android.support.constraint.solver.widgets.Guideline)this.Z).m(this.N);
         }
      }

      @TargetApi(17)
      public void resolveLayoutDirection(int var1) {
         boolean var2 = true;
         super.resolveLayoutDirection(var1);
         this.U = -1;
         this.V = -1;
         this.S = -1;
         this.T = -1;
         this.W = -1;
         this.X = -1;
         this.W = this.q;
         this.X = this.s;
         this.Y = this.w;
         boolean var3;
         if (1 == this.getLayoutDirection()) {
            var3 = var2;
         } else {
            var3 = false;
         }

         if (var3) {
            if (this.m != -1) {
               this.U = this.m;
            } else if (this.n != -1) {
               this.V = this.n;
            }

            if (this.o != -1) {
               this.T = this.o;
            }

            if (this.p != -1) {
               this.S = this.p;
            }

            if (this.u != -1) {
               this.X = this.u;
            }

            if (this.v != -1) {
               this.W = this.v;
            }

            this.Y = 1.0F - this.w;
         } else {
            if (this.m != -1) {
               this.T = this.m;
            }

            if (this.n != -1) {
               this.S = this.n;
            }

            if (this.o != -1) {
               this.U = this.o;
            }

            if (this.p != -1) {
               this.V = this.p;
            }

            if (this.u != -1) {
               this.W = this.u;
            }

            if (this.v != -1) {
               this.X = this.v;
            }
         }

         if (this.o == -1 && this.p == -1) {
            if (this.f != -1) {
               this.U = this.f;
            } else if (this.g != -1) {
               this.V = this.g;
            }
         }

         if (this.n == -1 && this.m == -1) {
            if (this.d != -1) {
               this.S = this.d;
            } else if (this.e != -1) {
               this.T = this.e;
            }
         }
      }
   }
}
