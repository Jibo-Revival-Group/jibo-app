package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
   private StaggeredGridLayoutManager.SavedState A;
   private int B;
   private final Rect C;
   private final StaggeredGridLayoutManager.AnchorInfo D;
   private boolean E;
   private boolean F;
   private int[] G;
   private final Runnable H;
   StaggeredGridLayoutManager.Span[] a;
   OrientationHelper b;
   OrientationHelper c;
   boolean d;
   boolean e;
   int f;
   int g;
   StaggeredGridLayoutManager.LazySpanLookup h;
   private int i = -1;
   private int j;
   private int k;
   private final LayoutState l;
   private BitSet m;
   private int n;
   private boolean o;
   private boolean z;

   public StaggeredGridLayoutManager(int var1, int var2) {
      this.d = false;
      this.e = false;
      this.f = -1;
      this.g = Integer.MIN_VALUE;
      this.h = new StaggeredGridLayoutManager.LazySpanLookup();
      this.n = 2;
      this.C = new Rect();
      this.D = new StaggeredGridLayoutManager.AnchorInfo(this);
      this.E = false;
      this.F = true;
      this.H = new Runnable(this) {
         final StaggeredGridLayoutManager a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.g();
         }
      };
      this.j = var2;
      this.a(var1);
      this.l = new LayoutState();
      this.N();
   }

   public StaggeredGridLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      this.d = false;
      this.e = false;
      this.f = -1;
      this.g = Integer.MIN_VALUE;
      this.h = new StaggeredGridLayoutManager.LazySpanLookup();
      this.n = 2;
      this.C = new Rect();
      this.D = new StaggeredGridLayoutManager.AnchorInfo(this);
      this.E = false;
      this.F = true;
      this.H = new Runnable(this) {
         final StaggeredGridLayoutManager a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.g();
         }
      };
      RecyclerView.LayoutManager.Properties var5 = a(var1, var2, var3, var4);
      this.b(var5.a);
      this.a(var5.b);
      this.a(var5.c);
      this.l = new LayoutState();
      this.N();
   }

   private void N() {
      this.b = OrientationHelper.a(this, this.j);
      this.c = OrientationHelper.a(this, 1 - this.j);
   }

   private void O() {
      boolean var1 = true;
      if (this.j != 1 && this.j()) {
         if (this.d) {
            var1 = false;
         }

         this.e = var1;
      } else {
         this.e = this.d;
      }
   }

   private void P() {
      if (this.c.h() != 1073741824) {
         float var1 = 0.0F;
         int var5 = this.v();

         for (int var3 = 0; var3 < var5; var3++) {
            View var8 = this.i(var3);
            float var2 = this.c.e(var8);
            if (!(var2 < var1)) {
               if (((StaggeredGridLayoutManager.LayoutParams)var8.getLayoutParams()).a()) {
                  var2 = 1.0F * var2 / this.i;
               }

               var1 = Math.max(var1, var2);
            }
         }

         int var6 = this.k;
         int var4 = Math.round(this.i * var1);
         int var10 = var4;
         if (this.c.h() == Integer.MIN_VALUE) {
            var10 = Math.min(var4, this.c.f());
         }

         this.f(var10);
         if (this.k != var6) {
            for (int var11 = 0; var11 < var5; var11++) {
               View var13 = this.i(var11);
               StaggeredGridLayoutManager.LayoutParams var9 = (StaggeredGridLayoutManager.LayoutParams)var13.getLayoutParams();
               if (!var9.b) {
                  if (this.j() && this.j == 1) {
                     var13.offsetLeftAndRight(-(this.i - 1 - var9.a.e) * this.k - -(this.i - 1 - var9.a.e) * var6);
                  } else {
                     var4 = var9.a.e * this.k;
                     int var7 = var9.a.e * var6;
                     if (this.j == 1) {
                        var13.offsetLeftAndRight(var4 - var7);
                     } else {
                        var13.offsetTopAndBottom(var4 - var7);
                     }
                  }
               }
            }
         }
      }
   }

   private int a(RecyclerView.Recycler var1, LayoutState var2, RecyclerView.State var3) {
      this.m.set(0, this.i, true);
      int var4;
      if (this.l.i) {
         if (var2.e == 1) {
            var4 = Integer.MAX_VALUE;
         } else {
            var4 = Integer.MIN_VALUE;
         }
      } else if (var2.e == 1) {
         var4 = var2.g + var2.b;
      } else {
         var4 = var2.f - var2.b;
      }

      this.a(var2.e, var4);
      int var7;
      if (this.e) {
         var7 = this.b.d();
      } else {
         var7 = this.b.c();
      }

      int var5;
      for (var5 = 0; var2.a(var3) && (this.l.i || !this.m.isEmpty()); var5 = 1) {
         View var12 = var2.a(var1);
         StaggeredGridLayoutManager.LayoutParams var13 = (StaggeredGridLayoutManager.LayoutParams)var12.getLayoutParams();
         int var10 = var13.f();
         var5 = this.h.c(var10);
         boolean var9;
         if (var5 == -1) {
            var9 = 1;
         } else {
            var9 = 0;
         }

         StaggeredGridLayoutManager.Span var11;
         if (var9) {
            if (var13.b) {
               var11 = this.a[0];
            } else {
               var11 = this.a(var2);
            }

            this.h.a(var10, var11);
         } else {
            var11 = this.a[var5];
         }

         var13.a = var11;
         if (var2.e == 1) {
            this.b(var12);
         } else {
            this.b(var12, 0);
         }

         this.a(var12, var13, false);
         int var6;
         int var8;
         if (var2.e == 1) {
            if (var13.b) {
               var5 = this.r(var7);
            } else {
               var5 = var11.b(var7);
            }

            var8 = var5 + this.b.e(var12);
            if (var9 && var13.b) {
               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var14 = this.n(var5);
               var14.b = -1;
               var14.a = var10;
               this.h.a(var14);
               var6 = var5;
            } else {
               var6 = var5;
            }
         } else {
            if (var13.b) {
               var5 = this.q(var7);
            } else {
               var5 = var11.a(var7);
            }

            var6 = var5 - this.b.e(var12);
            if (var9 && var13.b) {
               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var26 = this.o(var5);
               var26.b = 1;
               var26.a = var10;
               this.h.a(var26);
            }

            var8 = var5;
         }

         if (var13.b && var2.d == -1) {
            if (var9) {
               this.E = true;
            } else {
               boolean var21;
               if (var2.e == 1) {
                  if (!this.m()) {
                     var21 = true;
                  } else {
                     var21 = false;
                  }
               } else if (!this.n()) {
                  var21 = true;
               } else {
                  var21 = false;
               }

               if (var21) {
                  StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var27 = this.h.f(var10);
                  if (var27 != null) {
                     var27.d = true;
                  }

                  this.E = true;
               }
            }
         }

         this.a(var12, var13, var2);
         if (this.j() && this.j == 1) {
            if (var13.b) {
               var5 = this.c.d();
            } else {
               var5 = this.c.d() - (this.i - 1 - var11.e) * this.k;
            }

            var9 = var5 - this.c.e(var12);
         } else {
            if (var13.b) {
               var5 = this.c.c();
            } else {
               var5 = var11.e * this.k + this.c.c();
            }

            var10 = var5 + this.c.e(var12);
            var9 = var5;
            var5 = var10;
         }

         if (this.j == 1) {
            this.a(var12, var9, var6, var5, var8);
         } else {
            this.a(var12, var6, var9, var8, var5);
         }

         if (var13.b) {
            this.a(this.l.e, var4);
         } else {
            this.a(var11, this.l.e, var4);
         }

         this.a(var1, this.l);
         if (this.l.h && var12.hasFocusable()) {
            if (var13.b) {
               this.m.clear();
            } else {
               this.m.set(var11.e, false);
            }
         }
      }

      if (!var5) {
         this.a(var1, this.l);
      }

      if (this.l.e == -1) {
         var4 = this.q(this.b.c());
         var4 = this.b.c() - var4;
      } else {
         var4 = this.r(this.b.d()) - this.b.d();
      }

      if (var4 > 0) {
         var4 = Math.min(var2.b, var4);
      } else {
         var4 = 0;
      }

      return var4;
   }

   private StaggeredGridLayoutManager.Span a(LayoutState var1) {
      StaggeredGridLayoutManager.Span var8 = null;
      Object var9 = null;
      byte var3 = -1;
      int var2;
      int var4;
      if (this.t(var1.e)) {
         var2 = this.i - 1;
         var4 = -1;
      } else {
         var4 = this.i;
         var2 = 0;
         var3 = 1;
      }

      if (var1.e == 1) {
         int var7 = this.b.c();
         int var6 = Integer.MAX_VALUE;
         int var5 = var2;
         StaggeredGridLayoutManager.Span var10 = (StaggeredGridLayoutManager.Span)var9;
         var2 = var6;

         while (true) {
            var8 = var10;
            if (var5 == var4) {
               break;
            }

            var8 = this.a[var5];
            var6 = var8.b(var7);
            if (var6 < var2) {
               var10 = var8;
               var2 = var6;
            }

            var5 += var3;
         }
      } else {
         int var18 = this.b.d();
         int var16 = Integer.MIN_VALUE;
         int var14 = var2;
         StaggeredGridLayoutManager.Span var11 = var8;
         var2 = var16;

         while (true) {
            var8 = var11;
            if (var14 == var4) {
               break;
            }

            var8 = this.a[var14];
            var16 = var8.a(var18);
            if (var16 > var2) {
               var11 = var8;
               var2 = var16;
            }

            var14 += var3;
         }
      }

      return var8;
   }

   private void a(int var1, int var2) {
      for (int var3 = 0; var3 < this.i; var3++) {
         if (!this.a[var3].a.isEmpty()) {
            this.a(this.a[var3], var1, var2);
         }
      }
   }

   private void a(RecyclerView.Recycler var1, int var2) {
      while (this.v() > 0) {
         View var5 = this.i(0);
         if (this.b.b(var5) > var2 || this.b.c(var5) > var2) {
            break;
         }

         StaggeredGridLayoutManager.LayoutParams var4 = (StaggeredGridLayoutManager.LayoutParams)var5.getLayoutParams();
         if (!var4.b) {
            if (var4.a.a.size() == 1) {
               break;
            }

            var4.a.h();
         } else {
            for (int var3 = 0; var3 < this.i; var3++) {
               if (this.a[var3].a.size() == 1) {
                  return;
               }
            }

            for (int var6 = 0; var6 < this.i; var6++) {
               this.a[var6].h();
            }
         }

         this.a(var5, var1);
      }
   }

   private void a(RecyclerView.Recycler var1, LayoutState var2) {
      if (var2.a && !var2.i) {
         if (var2.b == 0) {
            if (var2.e == -1) {
               this.b(var1, var2.g);
            } else {
               this.a(var1, var2.f);
            }
         } else if (var2.e == -1) {
            int var3 = var2.f - this.p(var2.f);
            if (var3 < 0) {
               var3 = var2.g;
            } else {
               var3 = var2.g - Math.min(var3, var2.b);
            }

            this.b(var1, var3);
         } else {
            int var4 = this.s(var2.g) - var2.g;
            int var6;
            if (var4 < 0) {
               var6 = var2.f;
            } else {
               var6 = var2.f;
               var6 = Math.min(var4, var2.b) + var6;
            }

            this.a(var1, var6);
         }
      }
   }

   private void a(RecyclerView.Recycler var1, RecyclerView.State var2, boolean var3) {
      StaggeredGridLayoutManager.AnchorInfo var6 = this.D;
      if ((this.A != null || this.f != -1) && var2.e() == 0) {
         this.c(var1);
         var6.a();
      } else {
         boolean var4;
         if (var6.e && this.f == -1 && this.A == null) {
            var4 = false;
         } else {
            var4 = true;
         }

         if (var4) {
            var6.a();
            if (this.A != null) {
               this.a(var6);
            } else {
               this.O();
               var6.c = this.e;
            }

            this.a(var2, var6);
            var6.e = true;
         }

         if (this.A == null && this.f == -1 && (var6.c != this.o || this.j() != this.z)) {
            this.h.a();
            var6.d = true;
         }

         if (this.v() > 0 && (this.A == null || this.A.c < 1)) {
            if (var6.d) {
               for (int var9 = 0; var9 < this.i; var9++) {
                  this.a[var9].e();
                  if (var6.b != Integer.MIN_VALUE) {
                     this.a[var9].c(var6.b);
                  }
               }
            } else if (!var4 && this.D.f != null) {
               for (int var8 = 0; var8 < this.i; var8++) {
                  StaggeredGridLayoutManager.Span var5 = this.a[var8];
                  var5.e();
                  var5.c(this.D.f[var8]);
               }
            } else {
               for (int var7 = 0; var7 < this.i; var7++) {
                  this.a[var7].a(this.e, var6.b);
               }

               this.D.a(this.a);
            }
         }

         this.a(var1);
         this.l.a = false;
         this.E = false;
         this.f(this.c.f());
         this.b(var6.a, var2);
         if (var6.c) {
            this.m(-1);
            this.a(var1, this.l, var2);
            this.m(1);
            this.l.c = var6.a + this.l.d;
            this.a(var1, this.l, var2);
         } else {
            this.m(1);
            this.a(var1, this.l, var2);
            this.m(-1);
            this.l.c = var6.a + this.l.d;
            this.a(var1, this.l, var2);
         }

         this.P();
         if (this.v() > 0) {
            if (this.e) {
               this.b(var1, var2, true);
               this.c(var1, var2, false);
            } else {
               this.c(var1, var2, true);
               this.b(var1, var2, false);
            }
         }

         label92: {
            if (var3 && !var2.a()) {
               if (this.n == 0 || this.v() <= 0 || !this.E && this.h() == null) {
                  var4 = false;
               } else {
                  var4 = true;
               }

               if (var4) {
                  this.a(this.H);
                  if (this.g()) {
                     var4 = true;
                     break label92;
                  }
               }
            }

            var4 = false;
         }

         if (var2.a()) {
            this.D.a();
         }

         this.o = var6.c;
         this.z = this.j();
         if (var4) {
            this.D.a();
            this.a(var1, var2, false);
         }
      }
   }

   private void a(StaggeredGridLayoutManager.AnchorInfo var1) {
      if (this.A.c > 0) {
         if (this.A.c == this.i) {
            for (int var3 = 0; var3 < this.i; var3++) {
               this.a[var3].e();
               int var4 = this.A.d[var3];
               int var2 = var4;
               if (var4 != Integer.MIN_VALUE) {
                  if (this.A.i) {
                     var2 = var4 + this.b.d();
                  } else {
                     var2 = var4 + this.b.c();
                  }
               }

               this.a[var3].c(var2);
            }
         } else {
            this.A.a();
            this.A.a = this.A.b;
         }
      }

      this.z = this.A.j;
      this.a(this.A.h);
      this.O();
      if (this.A.a != -1) {
         this.f = this.A.a;
         var1.c = this.A.i;
      } else {
         var1.c = this.e;
      }

      if (this.A.e > 1) {
         this.h.a = this.A.f;
         this.h.b = this.A.g;
      }
   }

   private void a(StaggeredGridLayoutManager.Span var1, int var2, int var3) {
      int var4 = var1.i();
      if (var2 == -1) {
         if (var4 + var1.b() <= var3) {
            this.m.set(var1.e, false);
         }
      } else if (var1.d() - var4 >= var3) {
         this.m.set(var1.e, false);
      }
   }

   private void a(View var1, int var2, int var3, boolean var4) {
      this.b(var1, this.C);
      StaggeredGridLayoutManager.LayoutParams var5 = (StaggeredGridLayoutManager.LayoutParams)var1.getLayoutParams();
      var2 = this.b(var2, var5.leftMargin + this.C.left, var5.rightMargin + this.C.right);
      var3 = this.b(var3, var5.topMargin + this.C.top, var5.bottomMargin + this.C.bottom);
      if (var4) {
         var4 = this.a(var1, var2, var3, var5);
      } else {
         var4 = this.b(var1, var2, var3, var5);
      }

      if (var4) {
         var1.measure(var2, var3);
      }
   }

   private void a(View var1, StaggeredGridLayoutManager.LayoutParams var2, LayoutState var3) {
      if (var3.e == 1) {
         if (var2.b) {
            this.p(var1);
         } else {
            var2.a.b(var1);
         }
      } else if (var2.b) {
         this.q(var1);
      } else {
         var2.a.a(var1);
      }
   }

   private void a(View var1, StaggeredGridLayoutManager.LayoutParams var2, boolean var3) {
      if (var2.b) {
         if (this.j == 1) {
            this.a(var1, this.B, a(this.z(), this.x(), this.B() + this.D(), var2.height, true), var3);
         } else {
            this.a(var1, a(this.y(), this.w(), this.A() + this.C(), var2.width, true), this.B, var3);
         }
      } else if (this.j == 1) {
         this.a(var1, a(this.k, this.w(), 0, var2.width, false), a(this.z(), this.x(), this.B() + this.D(), var2.height, true), var3);
      } else {
         this.a(var1, a(this.y(), this.w(), this.A() + this.C(), var2.width, true), a(this.k, this.x(), 0, var2.height, false), var3);
      }
   }

   private boolean a(StaggeredGridLayoutManager.Span var1) {
      boolean var2 = true;
      if (this.e) {
         if (var1.d() < this.b.d()) {
            if (!var1.c(var1.a.get(var1.a.size() - 1)).b) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      } else if (var1.b() > this.b.c()) {
         if (var1.c(var1.a.get(0)).b) {
            var2 = false;
         }

         return var2;
      }

      return false;
   }

   private int b(int var1, int var2, int var3) {
      int var6;
      if (var2 == 0 && var3 == 0) {
         var6 = var1;
      } else {
         int var5 = MeasureSpec.getMode(var1);
         if (var5 != Integer.MIN_VALUE) {
            var6 = var1;
            if (var5 != 1073741824) {
               return var6;
            }
         }

         var6 = MeasureSpec.makeMeasureSpec(Math.max(0, MeasureSpec.getSize(var1) - var2 - var3), var5);
      }

      return var6;
   }

   private int b(RecyclerView.State var1) {
      boolean var4 = true;
      int var2 = 0;
      if (this.v() != 0) {
         OrientationHelper var6 = this.b;
         boolean var3;
         if (!this.F) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var5 = this.b(var3);
         if (!this.F) {
            var3 = var4;
         } else {
            var3 = false;
         }

         var2 = ScrollbarHelper.a(var1, var6, var5, this.c(var3), this, this.F, this.e);
      }

      return var2;
   }

   private void b(int var1, RecyclerView.State var2) {
      boolean var5;
      int var9;
      label31: {
         var5 = false;
         this.l.b = 0;
         this.l.c = var1;
         if (this.s()) {
            var9 = var2.c();
            if (var9 != -1) {
               boolean var6 = this.e;
               boolean var4;
               if (var9 < var1) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               if (var6 == var4) {
                  var1 = this.b.f();
                  var9 = 0;
               } else {
                  var9 = this.b.f();
                  var1 = 0;
               }
               break label31;
            }
         }

         var1 = 0;
         var9 = 0;
      }

      if (this.r()) {
         this.l.f = this.b.c() - var9;
         this.l.g = var1 + this.b.d();
      } else {
         this.l.g = var1 + this.b.e();
         this.l.f = -var9;
      }

      this.l.h = false;
      this.l.a = true;
      LayoutState var8 = this.l;
      boolean var10 = var5;
      if (this.b.h() == 0) {
         var10 = var5;
         if (this.b.e() == 0) {
            var10 = true;
         }
      }

      var8.i = var10;
   }

   private void b(RecyclerView.Recycler var1, int var2) {
      for (int var3 = this.v() - 1; var3 >= 0; var3--) {
         View var6 = this.i(var3);
         if (this.b.a(var6) < var2 || this.b.d(var6) < var2) {
            break;
         }

         StaggeredGridLayoutManager.LayoutParams var5 = (StaggeredGridLayoutManager.LayoutParams)var6.getLayoutParams();
         if (var5.b) {
            for (int var4 = 0; var4 < this.i; var4++) {
               if (this.a[var4].a.size() == 1) {
                  return;
               }
            }

            for (int var7 = 0; var7 < this.i; var7++) {
               this.a[var7].g();
            }
         } else {
            if (var5.a.a.size() == 1) {
               break;
            }

            var5.a.g();
         }

         this.a(var6, var1);
      }
   }

   private void b(RecyclerView.Recycler var1, RecyclerView.State var2, boolean var3) {
      int var4 = this.r(Integer.MIN_VALUE);
      if (var4 != Integer.MIN_VALUE) {
         var4 = this.b.d() - var4;
         if (var4 > 0) {
            var4 -= -this.c(-var4, var1, var2);
            if (var3 && var4 > 0) {
               this.b.a(var4);
            }
         }
      }
   }

   private void c(int var1, int var2, int var3) {
      int var6;
      if (this.e) {
         var6 = this.L();
      } else {
         var6 = this.M();
      }

      int var4;
      int var5;
      if (var3 == 8) {
         if (var1 < var2) {
            var5 = var2 + 1;
            var4 = var1;
         } else {
            var5 = var1 + 1;
            var4 = var2;
         }
      } else {
         var5 = var1 + var2;
         var4 = var1;
      }

      this.h.b(var4);
      switch (var3) {
         case 1:
            this.h.b(var1, var2);
            break;
         case 2:
            this.h.a(var1, var2);
            break;
         case 8:
            this.h.a(var1, 1);
            this.h.b(var2, 1);
      }

      if (var5 > var6) {
         if (this.e) {
            var1 = this.M();
         } else {
            var1 = this.L();
         }

         if (var4 <= var1) {
            this.o();
         }
      }
   }

   private void c(RecyclerView.Recycler var1, RecyclerView.State var2, boolean var3) {
      int var4 = this.q(Integer.MAX_VALUE);
      if (var4 != Integer.MAX_VALUE) {
         var4 -= this.b.c();
         if (var4 > 0) {
            var4 -= this.c(var4, var1, var2);
            if (var3 && var4 > 0) {
               this.b.a(-var4);
            }
         }
      }
   }

   private boolean c(RecyclerView.State var1, StaggeredGridLayoutManager.AnchorInfo var2) {
      int var3;
      if (this.o) {
         var3 = this.w(var1.e());
      } else {
         var3 = this.v(var1.e());
      }

      var2.a = var3;
      var2.b = Integer.MIN_VALUE;
      return true;
   }

   private int i(RecyclerView.State var1) {
      boolean var4 = true;
      int var2 = 0;
      if (this.v() != 0) {
         OrientationHelper var6 = this.b;
         boolean var3;
         if (!this.F) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var5 = this.b(var3);
         if (!this.F) {
            var3 = var4;
         } else {
            var3 = false;
         }

         var2 = ScrollbarHelper.a(var1, var6, var5, this.c(var3), this, this.F);
      }

      return var2;
   }

   private int j(RecyclerView.State var1) {
      boolean var4 = true;
      int var2 = 0;
      if (this.v() != 0) {
         OrientationHelper var5 = this.b;
         boolean var3;
         if (!this.F) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var6 = this.b(var3);
         if (!this.F) {
            var3 = var4;
         } else {
            var3 = false;
         }

         var2 = ScrollbarHelper.b(var1, var5, var6, this.c(var3), this, this.F);
      }

      return var2;
   }

   private void m(int var1) {
      byte var2 = 1;
      this.l.e = var1;
      LayoutState var5 = this.l;
      boolean var4 = this.e;
      boolean var3;
      if (var1 == -1) {
         var3 = true;
      } else {
         var3 = false;
      }

      byte var6;
      if (var4 == var3) {
         var6 = var2;
      } else {
         var6 = -1;
      }

      var5.d = var6;
   }

   private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem n(int var1) {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var3 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
      var3.c = new int[this.i];

      for (int var2 = 0; var2 < this.i; var2++) {
         var3.c[var2] = var1 - this.a[var2].b(var1);
      }

      return var3;
   }

   private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem o(int var1) {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var3 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
      var3.c = new int[this.i];

      for (int var2 = 0; var2 < this.i; var2++) {
         var3.c[var2] = this.a[var2].a(var1) - var1;
      }

      return var3;
   }

   private int p(int var1) {
      int var3 = this.a[0].a(var1);
      int var2 = 1;

      while (var2 < this.i) {
         int var5 = this.a[var2].a(var1);
         int var4 = var3;
         if (var5 > var3) {
            var4 = var5;
         }

         var2++;
         var3 = var4;
      }

      return var3;
   }

   private void p(View var1) {
      for (int var2 = this.i - 1; var2 >= 0; var2--) {
         this.a[var2].b(var1);
      }
   }

   private int q(int var1) {
      int var4 = this.a[0].a(var1);
      int var3 = 1;

      while (var3 < this.i) {
         int var5 = this.a[var3].a(var1);
         int var2 = var4;
         if (var5 < var4) {
            var2 = var5;
         }

         var3++;
         var4 = var2;
      }

      return var4;
   }

   private void q(View var1) {
      for (int var2 = this.i - 1; var2 >= 0; var2--) {
         this.a[var2].a(var1);
      }
   }

   private int r(int var1) {
      int var3 = this.a[0].b(var1);
      int var2 = 1;

      while (var2 < this.i) {
         int var5 = this.a[var2].b(var1);
         int var4 = var3;
         if (var5 > var3) {
            var4 = var5;
         }

         var2++;
         var3 = var4;
      }

      return var3;
   }

   private int s(int var1) {
      int var2 = this.a[0].b(var1);
      int var3 = 1;

      while (var3 < this.i) {
         int var5 = this.a[var3].b(var1);
         int var4 = var2;
         if (var5 < var2) {
            var4 = var5;
         }

         var3++;
         var2 = var4;
      }

      return var2;
   }

   private boolean t(int var1) {
      boolean var4 = true;
      boolean var5;
      if (this.j == 0) {
         if (var1 == -1) {
            var5 = true;
         } else {
            var5 = false;
         }

         if (var5 != this.e) {
            var5 = var4;
         } else {
            var5 = false;
         }
      } else {
         if (var1 == -1) {
            var5 = true;
         } else {
            var5 = false;
         }

         boolean var3;
         if (var5 == this.e) {
            var3 = true;
         } else {
            var3 = false;
         }

         var5 = var4;
         if (var3 != this.j()) {
            var5 = false;
         }
      }

      return var5;
   }

   private int u(int var1) {
      byte var3 = -1;
      byte var2 = 1;
      byte var5;
      if (this.v() == 0) {
         if (this.e) {
            var5 = var2;
         } else {
            var5 = -1;
         }
      } else {
         boolean var4;
         if (var1 < this.M()) {
            var4 = true;
         } else {
            var4 = false;
         }

         if (var4 != this.e) {
            var5 = var3;
         } else {
            var5 = 1;
         }
      }

      return var5;
   }

   private int v(int var1) {
      int var4 = this.v();
      int var2 = 0;

      while (true) {
         if (var2 >= var4) {
            var1 = 0;
            break;
         }

         int var3 = this.d(this.i(var2));
         if (var3 >= 0 && var3 < var1) {
            var1 = var3;
            break;
         }

         var2++;
      }

      return var1;
   }

   private int w(int var1) {
      int var2 = this.v() - 1;

      while (true) {
         if (var2 < 0) {
            var1 = 0;
            break;
         }

         int var3 = this.d(this.i(var2));
         if (var3 >= 0 && var3 < var1) {
            var1 = var3;
            break;
         }

         var2--;
      }

      return var1;
   }

   private int x(int var1) {
      byte var2 = -1;
      int var4 = Integer.MIN_VALUE;
      byte var3 = 1;
      switch (var1) {
         case 1:
            var1 = var2;
            if (this.j != 1) {
               var1 = var2;
               if (this.j()) {
                  var1 = 1;
               }
            }
            break;
         case 2:
            if (this.j == 1) {
               var1 = 1;
            } else {
               var1 = var2;
               if (!this.j()) {
                  var1 = 1;
               }
            }
            break;
         case 17:
            var1 = var2;
            if (this.j != 0) {
               var1 = Integer.MIN_VALUE;
            }
            break;
         case 33:
            var1 = var2;
            if (this.j != 1) {
               var1 = Integer.MIN_VALUE;
            }
            break;
         case 66:
            if (this.j == 0) {
               var1 = var3;
            } else {
               var1 = Integer.MIN_VALUE;
            }
            break;
         case 130:
            var1 = var4;
            if (this.j == 1) {
               var1 = 1;
            }
            break;
         default:
            var1 = Integer.MIN_VALUE;
      }

      return var1;
   }

   int L() {
      int var1 = this.v();
      if (var1 == 0) {
         var1 = 0;
      } else {
         var1 = this.d(this.i(var1 - 1));
      }

      return var1;
   }

   int M() {
      int var1 = 0;
      if (this.v() != 0) {
         var1 = this.d(this.i(0));
      }

      return var1;
   }

   @Override
   public int a(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      return this.c(var1, var2, var3);
   }

   @Override
   public int a(RecyclerView.Recycler var1, RecyclerView.State var2) {
      int var3;
      if (this.j == 0) {
         var3 = this.i;
      } else {
         var3 = super.a(var1, var2);
      }

      return var3;
   }

   @Override
   public RecyclerView.LayoutParams a() {
      StaggeredGridLayoutManager.LayoutParams var1;
      if (this.j == 0) {
         var1 = new StaggeredGridLayoutManager.LayoutParams(-2, -1);
      } else {
         var1 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
      }

      return var1;
   }

   @Override
   public RecyclerView.LayoutParams a(Context var1, AttributeSet var2) {
      return new StaggeredGridLayoutManager.LayoutParams(var1, var2);
   }

   @Override
   public RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
      StaggeredGridLayoutManager.LayoutParams var2;
      if (var1 instanceof MarginLayoutParams) {
         var2 = new StaggeredGridLayoutManager.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new StaggeredGridLayoutManager.LayoutParams(var1);
      }

      return var2;
   }

   @Override
   public View a(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
      int var6 = 0;
      if (this.v() == 0) {
         var1 = null;
      } else {
         View var9 = this.e(var1);
         if (var9 == null) {
            var1 = null;
         } else {
            this.O();
            int var7 = this.x(var2);
            if (var7 == Integer.MIN_VALUE) {
               var1 = null;
            } else {
               StaggeredGridLayoutManager.LayoutParams var12 = (StaggeredGridLayoutManager.LayoutParams)var9.getLayoutParams();
               boolean var8 = var12.b;
               StaggeredGridLayoutManager.Span var10 = var12.a;
               if (var7 == 1) {
                  var2 = this.L();
               } else {
                  var2 = this.M();
               }

               this.b(var2, var4);
               this.m(var7);
               this.l.c = this.l.d + var2;
               this.l.b = (int)(0.33333334F * this.b.f());
               this.l.h = true;
               this.l.a = false;
               this.a(var3, this.l, var4);
               this.o = this.e;
               if (!var8) {
                  var1 = var10.a(var2, var7);
                  if (var1 != null && var1 != var9) {
                     return var1;
                  }
               }

               if (this.t(var7)) {
                  for (int var5 = this.i - 1; var5 >= 0; var5--) {
                     var1 = this.a[var5].a(var2, var7);
                     if (var1 != null && var1 != var9) {
                        return var1;
                     }
                  }
               } else {
                  for (int var17 = 0; var17 < this.i; var17++) {
                     var1 = this.a[var17].a(var2, var7);
                     if (var1 != null && var1 != var9) {
                        return var1;
                     }
                  }
               }

               boolean var14;
               if (!this.d) {
                  var14 = true;
               } else {
                  var14 = false;
               }

               boolean var18;
               if (var7 == -1) {
                  var18 = 1;
               } else {
                  var18 = 0;
               }

               if (var14 == var18) {
                  var14 = true;
               } else {
                  var14 = false;
               }

               if (!var8) {
                  if (var14) {
                     var18 = var10.j();
                  } else {
                     var18 = var10.k();
                  }

                  View var16 = this.c(var18);
                  if (var16 != null) {
                     var1 = var16;
                     if (var16 != var9) {
                        return var1;
                     }
                  }
               }

               var18 = var6;
               if (this.t(var7)) {
                  for (int var21 = this.i - 1; var21 >= 0; var21--) {
                     if (var21 != var10.e) {
                        if (var14) {
                           var6 = this.a[var21].j();
                        } else {
                           var6 = this.a[var21].k();
                        }

                        var1 = this.c(var6);
                        if (var1 != null && var1 != var9) {
                           return var1;
                        }
                     }
                  }
               } else {
                  while (var18 < this.i) {
                     if (var14) {
                        var6 = this.a[var18].j();
                     } else {
                        var6 = this.a[var18].k();
                     }

                     var1 = this.c(var6);
                     if (var1 != null && var1 != var9) {
                        return var1;
                     }

                     var18++;
                  }
               }

               var1 = null;
            }
         }
      }

      return var1;
   }

   public void a(int var1) {
      this.a((String)null);
      if (var1 != this.i) {
         this.i();
         this.i = var1;
         this.m = new BitSet(this.i);
         this.a = new StaggeredGridLayoutManager.Span[this.i];

         for (int var2 = 0; var2 < this.i; var2++) {
            this.a[var2] = new StaggeredGridLayoutManager.Span(this, var2);
         }

         this.o();
      }
   }

   @Override
   public void a(int var1, int var2, RecyclerView.State var3, RecyclerView.LayoutManager.LayoutPrefetchRegistry var4) {
      byte var7 = 0;
      if (this.j != 0) {
         var1 = var2;
      }

      if (this.v() != 0 && var1 != 0) {
         this.a(var1, var3);
         if (this.G == null || this.G.length < this.i) {
            this.G = new int[this.i];
         }

         var2 = 0;
         var1 = 0;

         while (var2 < this.i) {
            int var6;
            if (this.l.d == -1) {
               var6 = this.l.f - this.a[var2].a(this.l.f);
            } else {
               var6 = this.a[var2].b(this.l.g) - this.l.g;
            }

            int var5 = var1;
            if (var6 >= 0) {
               this.G[var1] = var6;
               var5 = var1 + 1;
            }

            var2++;
            var1 = var5;
         }

         Arrays.sort(this.G, 0, var1);

         for (int var11 = var7; var11 < var1 && this.l.a(var3); var11++) {
            var4.b(this.l.c, this.G[var11]);
            LayoutState var8 = this.l;
            var8.c = var8.c + this.l.d;
         }
      }
   }

   void a(int var1, RecyclerView.State var2) {
      int var3;
      byte var4;
      if (var1 > 0) {
         var3 = this.L();
         var4 = 1;
      } else {
         var4 = -1;
         var3 = this.M();
      }

      this.l.a = true;
      this.b(var3, var2);
      this.m(var4);
      this.l.c = this.l.d + var3;
      this.l.b = Math.abs(var1);
   }

   @Override
   public void a(Rect var1, int var2, int var3) {
      int var4 = this.A();
      int var6 = this.C() + var4;
      int var5 = this.B() + this.D();
      if (this.j == 1) {
         var4 = a(var3, var5 + var1.height(), this.H());
         var3 = a(var2, var6 + this.k * this.i, this.G());
         var2 = var4;
      } else {
         var4 = a(var2, var6 + var1.width(), this.G());
         var2 = a(var3, var5 + this.k * this.i, this.H());
         var3 = var4;
      }

      this.g(var3, var2);
   }

   @Override
   public void a(Parcelable var1) {
      if (var1 instanceof StaggeredGridLayoutManager.SavedState) {
         this.A = (StaggeredGridLayoutManager.SavedState)var1;
         this.o();
      }
   }

   @Override
   public void a(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, AccessibilityNodeInfoCompat var4) {
      android.view.ViewGroup.LayoutParams var7 = var3.getLayoutParams();
      if (!(var7 instanceof StaggeredGridLayoutManager.LayoutParams)) {
         super.a(var3, var4);
      } else {
         StaggeredGridLayoutManager.LayoutParams var8 = (StaggeredGridLayoutManager.LayoutParams)var7;
         if (this.j == 0) {
            int var6 = var8.b();
            int var5;
            if (var8.b) {
               var5 = this.i;
            } else {
               var5 = 1;
            }

            var4.b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(var6, var5, -1, -1, var8.b, false));
         } else {
            int var10 = var8.b();
            int var9;
            if (var8.b) {
               var9 = this.i;
            } else {
               var9 = 1;
            }

            var4.b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(-1, -1, var10, var9, var8.b, false));
         }
      }
   }

   @Override
   public void a(RecyclerView.State var1) {
      super.a(var1);
      this.f = -1;
      this.g = Integer.MIN_VALUE;
      this.A = null;
      this.D.a();
   }

   void a(RecyclerView.State var1, StaggeredGridLayoutManager.AnchorInfo var2) {
      if (!this.b(var1, var2) && !this.c(var1, var2)) {
         var2.b();
         var2.a = 0;
      }
   }

   @Override
   public void a(RecyclerView var1) {
      this.h.a();
      this.o();
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3) {
      this.c(var2, var3, 1);
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3, int var4) {
      this.c(var2, var3, 8);
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3, Object var4) {
      this.c(var2, var3, 4);
   }

   @Override
   public void a(RecyclerView var1, RecyclerView.Recycler var2) {
      this.a(this.H);

      for (int var3 = 0; var3 < this.i; var3++) {
         this.a[var3].e();
      }

      var1.requestLayout();
   }

   @Override
   public void a(RecyclerView var1, RecyclerView.State var2, int var3) {
      LinearSmoothScroller var4 = new LinearSmoothScroller(var1.getContext());
      var4.d(var3);
      this.a(var4);
   }

   @Override
   public void a(AccessibilityEvent var1) {
      super.a(var1);
      if (this.v() > 0) {
         View var4 = this.b(false);
         View var5 = this.c(false);
         if (var4 != null && var5 != null) {
            int var3 = this.d(var4);
            int var2 = this.d(var5);
            if (var3 < var2) {
               var1.setFromIndex(var3);
               var1.setToIndex(var2);
            } else {
               var1.setFromIndex(var2);
               var1.setToIndex(var3);
            }
         }
      }
   }

   @Override
   public void a(String var1) {
      if (this.A == null) {
         super.a(var1);
      }
   }

   public void a(boolean var1) {
      this.a((String)null);
      if (this.A != null && this.A.h != var1) {
         this.A.h = var1;
      }

      this.d = var1;
      this.o();
   }

   @Override
   public boolean a(RecyclerView.LayoutParams var1) {
      return var1 instanceof StaggeredGridLayoutManager.LayoutParams;
   }

   @Override
   public int b(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      return this.c(var1, var2, var3);
   }

   @Override
   public int b(RecyclerView.Recycler var1, RecyclerView.State var2) {
      int var3;
      if (this.j == 1) {
         var3 = this.i;
      } else {
         var3 = super.b(var1, var2);
      }

      return var3;
   }

   View b(boolean var1) {
      int var4 = this.b.c();
      int var3 = this.b.d();
      int var5 = this.v();
      int var2 = 0;
      View var7 = null;

      View var10;
      while (true) {
         if (var2 >= var5) {
            var10 = var7;
            break;
         }

         View var8 = this.i(var2);
         int var6 = this.b.a(var8);
         var10 = var7;
         if (this.b.b(var8) > var4) {
            if (var6 >= var3) {
               var10 = var7;
            } else {
               var10 = var8;
               if (var6 >= var4) {
                  break;
               }

               if (!var1) {
                  var10 = var8;
                  break;
               }

               var10 = var7;
               if (var7 == null) {
                  var10 = var8;
               }
            }
         }

         var2++;
         var7 = var10;
      }

      return var10;
   }

   public void b(int var1) {
      if (var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation.");
      }

      this.a((String)null);
      if (var1 != this.j) {
         this.j = var1;
         OrientationHelper var2 = this.b;
         this.b = this.c;
         this.c = var2;
         this.o();
      }
   }

   @Override
   public void b(RecyclerView var1, int var2, int var3) {
      this.c(var2, var3, 2);
   }

   @Override
   public boolean b() {
      boolean var1;
      if (this.A == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   boolean b(RecyclerView.State var1, StaggeredGridLayoutManager.AnchorInfo var2) {
      boolean var4 = false;
      boolean var5 = true;
      if (!var1.a() && this.f != -1) {
         if (this.f < 0 || this.f >= var1.e()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            var4 = false;
         } else if (this.A != null && this.A.a != -1 && this.A.c >= 1) {
            var2.b = Integer.MIN_VALUE;
            var2.a = this.f;
            var4 = var5;
         } else {
            View var6 = this.c(this.f);
            if (var6 != null) {
               int var3;
               if (this.e) {
                  var3 = this.L();
               } else {
                  var3 = this.M();
               }

               var2.a = var3;
               if (this.g != Integer.MIN_VALUE) {
                  if (var2.c) {
                     var2.b = this.b.d() - this.g - this.b.b(var6);
                     var4 = var5;
                  } else {
                     var2.b = this.b.c() + this.g - this.b.a(var6);
                     var4 = var5;
                  }
               } else if (this.b.e(var6) > this.b.f()) {
                  if (var2.c) {
                     var3 = this.b.d();
                  } else {
                     var3 = this.b.c();
                  }

                  var2.b = var3;
                  var4 = var5;
               } else {
                  var3 = this.b.a(var6) - this.b.c();
                  if (var3 < 0) {
                     var2.b = -var3;
                     var4 = var5;
                  } else {
                     var3 = this.b.d() - this.b.b(var6);
                     if (var3 < 0) {
                        var2.b = var3;
                        var4 = var5;
                     } else {
                        var2.b = Integer.MIN_VALUE;
                        var4 = var5;
                     }
                  }
               }
            } else {
               var2.a = this.f;
               if (this.g == Integer.MIN_VALUE) {
                  if (this.u(var2.a) == 1) {
                     var4 = true;
                  }

                  var2.c = var4;
                  var2.b();
               } else {
                  var2.a(this.g);
               }

               var2.d = true;
               var4 = var5;
            }
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   int c(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      if (this.v() != 0 && var1 != 0) {
         this.a(var1, var3);
         int var4 = this.a(var2, this.l, var3);
         if (this.l.b >= var4) {
            if (var1 < 0) {
               var1 = -var4;
            } else {
               var1 = var4;
            }
         }

         this.b.a(-var1);
         this.o = this.e;
         this.l.b = 0;
         this.a(var2, this.l);
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public int c(RecyclerView.State var1) {
      return this.b(var1);
   }

   View c(boolean var1) {
      int var4 = this.b.c();
      int var3 = this.b.d();
      int var2 = this.v() - 1;
      View var7 = null;

      View var10;
      while (true) {
         if (var2 < 0) {
            var10 = var7;
            break;
         }

         View var8 = this.i(var2);
         int var5 = this.b.a(var8);
         int var6 = this.b.b(var8);
         var10 = var7;
         if (var6 > var4) {
            if (var5 >= var3) {
               var10 = var7;
            } else {
               var10 = var8;
               if (var6 <= var3) {
                  break;
               }

               if (!var1) {
                  var10 = var8;
                  break;
               }

               var10 = var7;
               if (var7 == null) {
                  var10 = var8;
               }
            }
         }

         var2--;
         var7 = var10;
      }

      return var10;
   }

   @Override
   public void c(RecyclerView.Recycler var1, RecyclerView.State var2) {
      this.a(var1, var2, true);
   }

   @Override
   public boolean c() {
      boolean var1;
      if (this.n != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int d(RecyclerView.State var1) {
      return this.b(var1);
   }

   @Override
   public PointF d(int var1) {
      var1 = this.u(var1);
      PointF var2 = new PointF();
      if (var1 == 0) {
         var2 = null;
      } else if (this.j == 0) {
         var2.x = var1;
         var2.y = 0.0F;
      } else {
         var2.x = 0.0F;
         var2.y = var1;
      }

      return var2;
   }

   @Override
   public Parcelable d() {
      StaggeredGridLayoutManager.SavedState var4;
      if (this.A != null) {
         var4 = new StaggeredGridLayoutManager.SavedState(this.A);
      } else {
         var4 = new StaggeredGridLayoutManager.SavedState();
         var4.h = this.d;
         var4.i = this.o;
         var4.j = this.z;
         if (this.h != null && this.h.a != null) {
            var4.f = this.h.a;
            var4.e = var4.f.length;
            var4.g = this.h.b;
         } else {
            var4.e = 0;
         }

         if (this.v() > 0) {
            int var1;
            if (this.o) {
               var1 = this.L();
            } else {
               var1 = this.M();
            }

            var4.a = var1;
            var4.b = this.k();
            var4.c = this.i;
            var4.d = new int[this.i];

            for (int var2 = 0; var2 < this.i; var2++) {
               if (this.o) {
                  int var3 = this.a[var2].b(Integer.MIN_VALUE);
                  var1 = var3;
                  if (var3 != Integer.MIN_VALUE) {
                     var1 = var3 - this.b.d();
                  }
               } else {
                  int var6 = this.a[var2].a(Integer.MIN_VALUE);
                  var1 = var6;
                  if (var6 != Integer.MIN_VALUE) {
                     var1 = var6 - this.b.c();
                  }
               }

               var4.d[var2] = var1;
            }
         } else {
            var4.a = -1;
            var4.b = -1;
            var4.c = 0;
         }
      }

      return var4;
   }

   @Override
   public int e(RecyclerView.State var1) {
      return this.i(var1);
   }

   @Override
   public void e(int var1) {
      if (this.A != null && this.A.a != var1) {
         this.A.b();
      }

      this.f = var1;
      this.g = Integer.MIN_VALUE;
      this.o();
   }

   @Override
   public boolean e() {
      boolean var1;
      if (this.j == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int f(RecyclerView.State var1) {
      return this.i(var1);
   }

   void f(int var1) {
      this.k = var1 / this.i;
      this.B = MeasureSpec.makeMeasureSpec(var1, this.c.h());
   }

   @Override
   public boolean f() {
      boolean var1 = true;
      if (this.j != 1) {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int g(RecyclerView.State var1) {
      return this.j(var1);
   }

   boolean g() {
      boolean var4 = true;
      if (this.v() != 0 && this.n != 0 && this.q()) {
         int var1;
         int var2;
         if (this.e) {
            var1 = this.L();
            var2 = this.M();
         } else {
            var1 = this.M();
            var2 = this.L();
         }

         if (var1 == 0 && this.h() != null) {
            this.h.a();
            this.J();
            this.o();
         } else if (!this.E) {
            var4 = false;
         } else {
            byte var3;
            if (this.e) {
               var3 = -1;
            } else {
               var3 = 1;
            }

            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var5 = this.h.a(var1, var2 + 1, var3, true);
            if (var5 == null) {
               this.E = false;
               this.h.a(var2 + 1);
               var4 = false;
            } else {
               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var6 = this.h.a(var1, var5.a, var3 * -1, true);
               if (var6 == null) {
                  this.h.a(var5.a);
               } else {
                  this.h.a(var6.a + 1);
               }

               this.J();
               this.o();
            }
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public int h(RecyclerView.State var1) {
      return this.j(var1);
   }

   View h() {
      int var1 = this.v() - 1;
      BitSet var8 = new BitSet(this.i);
      var8.set(0, this.i, true);
      byte var2;
      if (this.j == 1 && this.j()) {
         var2 = 1;
      } else {
         var2 = -1;
      }

      int var3;
      if (this.e) {
         var3 = -1;
      } else {
         var3 = var1 + 1;
         var1 = 0;
      }

      byte var4;
      if (var1 < var3) {
         var4 = 1;
      } else {
         var4 = -1;
      }

      int var5 = var1;

      View var7;
      while (true) {
         if (var5 == var3) {
            var7 = null;
            break;
         }

         var7 = this.i(var5);
         StaggeredGridLayoutManager.LayoutParams var9 = (StaggeredGridLayoutManager.LayoutParams)var7.getLayoutParams();
         if (var8.get(var9.a.e)) {
            if (this.a(var9.a)) {
               break;
            }

            var8.clear(var9.a.e);
         }

         if (!var9.b && var5 + var4 != var3) {
            View var10;
            label65: {
               var10 = this.i(var5 + var4);
               if (this.e) {
                  var1 = this.b.b(var7);
                  int var6 = this.b.b(var10);
                  if (var1 < var6) {
                     break;
                  }

                  if (var1 == var6) {
                     var12 = true;
                     break label65;
                  }
               } else {
                  var1 = this.b.a(var7);
                  int var15 = this.b.a(var10);
                  if (var1 > var15) {
                     break;
                  }

                  if (var1 == var15) {
                     var12 = true;
                     break label65;
                  }
               }

               var12 = false;
            }

            if (var12) {
               StaggeredGridLayoutManager.LayoutParams var17 = (StaggeredGridLayoutManager.LayoutParams)var10.getLayoutParams();
               boolean var14;
               if (var9.a.e - var17.a.e < 0) {
                  var14 = true;
               } else {
                  var14 = false;
               }

               boolean var16;
               if (var2 < 0) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               if (var14 != var16) {
                  break;
               }
            }
         }

         var5 += var4;
      }

      return var7;
   }

   public void i() {
      this.h.a();
      this.o();
   }

   @Override
   public void j(int var1) {
      super.j(var1);

      for (int var2 = 0; var2 < this.i; var2++) {
         this.a[var2].d(var1);
      }
   }

   boolean j() {
      boolean var1 = true;
      if (this.t() != 1) {
         var1 = false;
      }

      return var1;
   }

   int k() {
      View var2;
      if (this.e) {
         var2 = this.c(true);
      } else {
         var2 = this.b(true);
      }

      int var1;
      if (var2 == null) {
         var1 = -1;
      } else {
         var1 = this.d(var2);
      }

      return var1;
   }

   @Override
   public void k(int var1) {
      super.k(var1);

      for (int var2 = 0; var2 < this.i; var2++) {
         this.a[var2].d(var1);
      }
   }

   @Override
   public void l(int var1) {
      if (var1 == 0) {
         this.g();
      }
   }

   boolean m() {
      boolean var4 = true;
      int var2 = this.a[0].b(Integer.MIN_VALUE);
      int var1 = 1;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= this.i) {
            break;
         }

         if (this.a[var1].b(Integer.MIN_VALUE) != var2) {
            var3 = false;
            break;
         }

         var1++;
      }

      return var3;
   }

   boolean n() {
      boolean var4 = true;
      int var2 = this.a[0].a(Integer.MIN_VALUE);
      int var1 = 1;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= this.i) {
            break;
         }

         if (this.a[var1].a(Integer.MIN_VALUE) != var2) {
            var3 = false;
            break;
         }

         var1++;
      }

      return var3;
   }

   class AnchorInfo {
      int a;
      int b;
      boolean c;
      boolean d;
      boolean e;
      int[] f;
      final StaggeredGridLayoutManager g;

      AnchorInfo(StaggeredGridLayoutManager var1) {
         this.g = var1;
         this.a();
      }

      void a() {
         this.a = -1;
         this.b = Integer.MIN_VALUE;
         this.c = false;
         this.d = false;
         this.e = false;
         if (this.f != null) {
            Arrays.fill(this.f, -1);
         }
      }

      void a(int var1) {
         if (this.c) {
            this.b = this.g.b.d() - var1;
         } else {
            this.b = this.g.b.c() + var1;
         }
      }

      void a(StaggeredGridLayoutManager.Span[] var1) {
         int var3 = var1.length;
         if (this.f == null || this.f.length < var3) {
            this.f = new int[this.g.a.length];
         }

         for (int var2 = 0; var2 < var3; var2++) {
            this.f[var2] = var1[var2].a(Integer.MIN_VALUE);
         }
      }

      void b() {
         int var1;
         if (this.c) {
            var1 = this.g.b.d();
         } else {
            var1 = this.g.b.c();
         }

         this.b = var1;
      }
   }

   public static class LayoutParams extends RecyclerView.LayoutParams {
      StaggeredGridLayoutManager.Span a;
      boolean b;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public boolean a() {
         return this.b;
      }

      public final int b() {
         int var1;
         if (this.a == null) {
            var1 = -1;
         } else {
            var1 = this.a.e;
         }

         return var1;
      }
   }

   static class LazySpanLookup {
      int[] a;
      List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> b;

      private void c(int var1, int var2) {
         if (this.b != null) {
            for (int var3 = this.b.size() - 1; var3 >= 0; var3--) {
               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var4 = this.b.get(var3);
               if (var4.a >= var1) {
                  if (var4.a < var1 + var2) {
                     this.b.remove(var3);
                  } else {
                     var4.a -= var2;
                  }
               }
            }
         }
      }

      private void d(int var1, int var2) {
         if (this.b != null) {
            for (int var3 = this.b.size() - 1; var3 >= 0; var3--) {
               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var4 = this.b.get(var3);
               if (var4.a >= var1) {
                  var4.a += var2;
               }
            }
         }
      }

      private int g(int var1) {
         if (this.b == null) {
            var1 = -1;
         } else {
            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var4 = this.f(var1);
            if (var4 != null) {
               this.b.remove(var4);
            }

            int var3 = this.b.size();
            int var2 = 0;

            while (true) {
               if (var2 >= var3) {
                  var2 = -1;
                  break;
               }

               if (this.b.get(var2).a >= var1) {
                  break;
               }

               var2++;
            }

            if (var2 != -1) {
               var4 = this.b.get(var2);
               this.b.remove(var2);
               var1 = var4.a;
            } else {
               var1 = -1;
            }
         }

         return var1;
      }

      int a(int var1) {
         if (this.b != null) {
            for (int var2 = this.b.size() - 1; var2 >= 0; var2--) {
               if (this.b.get(var2).a >= var1) {
                  this.b.remove(var2);
               }
            }
         }

         return this.b(var1);
      }

      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem a(int var1, int var2, int var3, boolean var4) {
         StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var7;
         if (this.b == null) {
            var7 = null;
         } else {
            int var6 = this.b.size();
            int var5 = 0;

            while (true) {
               if (var5 >= var6) {
                  var7 = null;
                  break;
               }

               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var8 = this.b.get(var5);
               if (var8.a >= var2) {
                  var7 = null;
                  break;
               }

               if (var8.a >= var1) {
                  var7 = var8;
                  if (var3 == 0) {
                     break;
                  }

                  var7 = var8;
                  if (var8.b == var3) {
                     break;
                  }

                  if (var4) {
                     var7 = var8;
                     if (var8.d) {
                        break;
                     }
                  }
               }

               var5++;
            }
         }

         return var7;
      }

      void a() {
         if (this.a != null) {
            Arrays.fill(this.a, -1);
         }

         this.b = null;
      }

      void a(int var1, int var2) {
         if (this.a != null && var1 < this.a.length) {
            this.e(var1 + var2);
            System.arraycopy(this.a, var1 + var2, this.a, var1, this.a.length - var1 - var2);
            Arrays.fill(this.a, this.a.length - var2, this.a.length, -1);
            this.c(var1, var2);
         }
      }

      void a(int var1, StaggeredGridLayoutManager.Span var2) {
         this.e(var1);
         this.a[var1] = var2.e;
      }

      public void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var1) {
         if (this.b == null) {
            this.b = new ArrayList<>();
         }

         int var3 = this.b.size();
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               this.b.add(var1);
               break;
            }

            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var4 = this.b.get(var2);
            if (var4.a == var1.a) {
               this.b.remove(var2);
            }

            if (var4.a >= var1.a) {
               this.b.add(var2, var1);
               break;
            }

            var2++;
         }
      }

      int b(int var1) {
         int var3 = -1;
         if (this.a != null && var1 < this.a.length) {
            var3 = this.g(var1);
            if (var3 == -1) {
               Arrays.fill(this.a, var1, this.a.length, -1);
               var3 = this.a.length;
            } else {
               Arrays.fill(this.a, var1, var3 + 1, -1);
               var3++;
            }
         }

         return var3;
      }

      void b(int var1, int var2) {
         if (this.a != null && var1 < this.a.length) {
            this.e(var1 + var2);
            System.arraycopy(this.a, var1, this.a, var1 + var2, this.a.length - var1 - var2);
            Arrays.fill(this.a, var1, var1 + var2, -1);
            this.d(var1, var2);
         }
      }

      int c(int var1) {
         if (this.a != null && var1 < this.a.length) {
            var1 = this.a[var1];
         } else {
            var1 = -1;
         }

         return var1;
      }

      int d(int var1) {
         int var2 = this.a.length;

         while (var2 <= var1) {
            var2 *= 2;
         }

         return var2;
      }

      void e(int var1) {
         if (this.a == null) {
            this.a = new int[Math.max(var1, 10) + 1];
            Arrays.fill(this.a, -1);
         } else if (var1 >= this.a.length) {
            int[] var2 = this.a;
            this.a = new int[this.d(var1)];
            System.arraycopy(var2, 0, this.a, 0, var2.length);
            Arrays.fill(this.a, var2.length, this.a.length, -1);
         }
      }

      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem f(int var1) {
         StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var3;
         if (this.b == null) {
            var3 = null;
         } else {
            int var2 = this.b.size() - 1;

            while (true) {
               if (var2 < 0) {
                  var3 = null;
                  break;
               }

               StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var4 = this.b.get(var2);
               var3 = var4;
               if (var4.a == var1) {
                  break;
               }

               var2--;
            }
         }

         return var3;
      }

      static class FullSpanItem implements Parcelable {
         public static final Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> CREATOR = new Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem>() {
            public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem a(Parcel var1) {
               return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(var1);
            }

            public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] a(int var1) {
               return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[var1];
            }
         };
         int a;
         int b;
         int[] c;
         boolean d;

         FullSpanItem() {
         }

         FullSpanItem(Parcel var1) {
            boolean var3 = true;
            super();
            this.a = var1.readInt();
            this.b = var1.readInt();
            if (var1.readInt() != 1) {
               var3 = false;
            }

            this.d = var3;
            int var2 = var1.readInt();
            if (var2 > 0) {
               this.c = new int[var2];
               var1.readIntArray(this.c);
            }
         }

         int a(int var1) {
            if (this.c == null) {
               var1 = 0;
            } else {
               var1 = this.c[var1];
            }

            return var1;
         }

         public int describeContents() {
            return 0;
         }

         @Override
         public String toString() {
            return "FullSpanItem{mPosition="
               + this.a
               + ", mGapDir="
               + this.b
               + ", mHasUnwantedGapAfter="
               + this.d
               + ", mGapPerSpan="
               + Arrays.toString(this.c)
               + '}';
         }

         public void writeToParcel(Parcel var1, int var2) {
            var1.writeInt(this.a);
            var1.writeInt(this.b);
            byte var3;
            if (this.d) {
               var3 = 1;
            } else {
               var3 = 0;
            }

            var1.writeInt(var3);
            if (this.c != null && this.c.length > 0) {
               var1.writeInt(this.c.length);
               var1.writeIntArray(this.c);
            } else {
               var1.writeInt(0);
            }
         }
      }
   }

   public static class SavedState implements Parcelable {
      public static final Creator<StaggeredGridLayoutManager.SavedState> CREATOR = new Creator<StaggeredGridLayoutManager.SavedState>() {
         public StaggeredGridLayoutManager.SavedState a(Parcel var1) {
            return new StaggeredGridLayoutManager.SavedState(var1);
         }

         public StaggeredGridLayoutManager.SavedState[] a(int var1) {
            return new StaggeredGridLayoutManager.SavedState[var1];
         }
      };
      int a;
      int b;
      int c;
      int[] d;
      int e;
      int[] f;
      List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> g;
      boolean h;
      boolean i;
      boolean j;

      public SavedState() {
      }

      SavedState(Parcel var1) {
         boolean var3 = true;
         super();
         this.a = var1.readInt();
         this.b = var1.readInt();
         this.c = var1.readInt();
         if (this.c > 0) {
            this.d = new int[this.c];
            var1.readIntArray(this.d);
         }

         this.e = var1.readInt();
         if (this.e > 0) {
            this.f = new int[this.e];
            var1.readIntArray(this.f);
         }

         boolean var2;
         if (var1.readInt() == 1) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.h = var2;
         if (var1.readInt() == 1) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.i = var2;
         if (var1.readInt() == 1) {
            var2 = var3;
         } else {
            var2 = false;
         }

         this.j = var2;
         this.g = var1.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      }

      public SavedState(StaggeredGridLayoutManager.SavedState var1) {
         this.c = var1.c;
         this.a = var1.a;
         this.b = var1.b;
         this.d = var1.d;
         this.e = var1.e;
         this.f = var1.f;
         this.h = var1.h;
         this.i = var1.i;
         this.j = var1.j;
         this.g = var1.g;
      }

      void a() {
         this.d = null;
         this.c = 0;
         this.e = 0;
         this.f = null;
         this.g = null;
      }

      void b() {
         this.d = null;
         this.c = 0;
         this.a = -1;
         this.b = -1;
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         byte var3 = 1;
         var1.writeInt(this.a);
         var1.writeInt(this.b);
         var1.writeInt(this.c);
         if (this.c > 0) {
            var1.writeIntArray(this.d);
         }

         var1.writeInt(this.e);
         if (this.e > 0) {
            var1.writeIntArray(this.f);
         }

         byte var4;
         if (this.h) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         var1.writeInt(var4);
         if (this.i) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         var1.writeInt(var4);
         if (this.j) {
            var4 = var3;
         } else {
            var4 = 0;
         }

         var1.writeInt(var4);
         var1.writeList(this.g);
      }
   }

   class Span {
      ArrayList<View> a;
      int b;
      int c;
      int d;
      final int e;
      final StaggeredGridLayoutManager f;

      Span(StaggeredGridLayoutManager var1, int var2) {
         this.f = var1;
         this.a = new ArrayList<>();
         this.b = Integer.MIN_VALUE;
         this.c = Integer.MIN_VALUE;
         this.d = 0;
         this.e = var2;
      }

      int a(int var1) {
         if (this.b != Integer.MIN_VALUE) {
            var1 = this.b;
         } else if (this.a.size() != 0) {
            this.a();
            var1 = this.b;
         }

         return var1;
      }

      int a(int var1, int var2, boolean var3) {
         return this.a(var1, var2, false, false, var3);
      }

      int a(int var1, int var2, boolean var3, boolean var4, boolean var5) {
         int var9 = this.f.b.c();
         int var10 = this.f.b.d();
         byte var7;
         int var8;
         if (var2 > var1) {
            var7 = 1;
            var8 = var1;
         } else {
            var7 = -1;
            var8 = var1;
         }

         while (true) {
            if (var8 == var2) {
               var1 = -1;
               break;
            }

            View var13 = this.a.get(var8);
            int var11 = this.f.b.a(var13);
            int var12 = this.f.b.b(var13);
            boolean var15;
            if (var5) {
               if (var11 <= var10) {
                  var15 = true;
               } else {
                  var15 = false;
               }
            } else if (var11 < var10) {
               var15 = true;
            } else {
               var15 = false;
            }

            boolean var6;
            if (var5) {
               if (var12 >= var9) {
                  var6 = true;
               } else {
                  var6 = false;
               }
            } else if (var12 > var9) {
               var6 = true;
            } else {
               var6 = false;
            }

            if (var15 && var6) {
               if (var3 && var4) {
                  if (var11 >= var9 && var12 <= var10) {
                     var1 = this.f.d(var13);
                     break;
                  }
               } else {
                  if (var4) {
                     var1 = this.f.d(var13);
                     break;
                  }

                  if (var11 < var9 || var12 > var10) {
                     var1 = this.f.d(var13);
                     break;
                  }
               }
            }

            var8 += var7;
         }

         return var1;
      }

      public View a(int var1, int var2) {
         View var4 = null;
         View var5 = null;
         if (var2 == -1) {
            int var3 = this.a.size();
            var2 = 0;
            var4 = var5;

            while (var2 < var3) {
               var5 = this.a.get(var2);
               if (this.f.d && this.f.d(var5) <= var1 || !this.f.d && this.f.d(var5) >= var1 || !var5.hasFocusable()) {
                  break;
               }

               var2++;
               var4 = var5;
            }
         } else {
            var2 = this.a.size() - 1;

            while (var2 >= 0) {
               var5 = this.a.get(var2);
               if (this.f.d && this.f.d(var5) >= var1 || !this.f.d && this.f.d(var5) <= var1 || !var5.hasFocusable()) {
                  break;
               }

               var2--;
               var4 = var5;
            }
         }

         return var4;
      }

      void a() {
         View var2 = this.a.get(0);
         StaggeredGridLayoutManager.LayoutParams var1 = this.c(var2);
         this.b = this.f.b.a(var2);
         if (var1.b) {
            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var3 = this.f.h.f(var1.f());
            if (var3 != null && var3.b == -1) {
               this.b = this.b - var3.a(this.e);
            }
         }
      }

      void a(View var1) {
         StaggeredGridLayoutManager.LayoutParams var2 = this.c(var1);
         var2.a = this;
         this.a.add(0, var1);
         this.b = Integer.MIN_VALUE;
         if (this.a.size() == 1) {
            this.c = Integer.MIN_VALUE;
         }

         if (var2.d() || var2.e()) {
            this.d = this.d + this.f.b.e(var1);
         }
      }

      void a(boolean var1, int var2) {
         int var3;
         if (var1) {
            var3 = this.b(Integer.MIN_VALUE);
         } else {
            var3 = this.a(Integer.MIN_VALUE);
         }

         this.e();
         if (var3 != Integer.MIN_VALUE && (!var1 || var3 >= this.f.b.d()) && (var1 || var3 <= this.f.b.c())) {
            int var4 = var3;
            if (var2 != Integer.MIN_VALUE) {
               var4 = var3 + var2;
            }

            this.c = var4;
            this.b = var4;
         }
      }

      int b() {
         int var1;
         if (this.b != Integer.MIN_VALUE) {
            var1 = this.b;
         } else {
            this.a();
            var1 = this.b;
         }

         return var1;
      }

      int b(int var1) {
         if (this.c != Integer.MIN_VALUE) {
            var1 = this.c;
         } else if (this.a.size() != 0) {
            this.c();
            var1 = this.c;
         }

         return var1;
      }

      void b(View var1) {
         StaggeredGridLayoutManager.LayoutParams var2 = this.c(var1);
         var2.a = this;
         this.a.add(var1);
         this.c = Integer.MIN_VALUE;
         if (this.a.size() == 1) {
            this.b = Integer.MIN_VALUE;
         }

         if (var2.d() || var2.e()) {
            this.d = this.d + this.f.b.e(var1);
         }
      }

      StaggeredGridLayoutManager.LayoutParams c(View var1) {
         return (StaggeredGridLayoutManager.LayoutParams)var1.getLayoutParams();
      }

      void c() {
         View var2 = this.a.get(this.a.size() - 1);
         StaggeredGridLayoutManager.LayoutParams var3 = this.c(var2);
         this.c = this.f.b.b(var2);
         if (var3.b) {
            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem var4 = this.f.h.f(var3.f());
            if (var4 != null && var4.b == 1) {
               int var1 = this.c;
               this.c = var4.a(this.e) + var1;
            }
         }
      }

      void c(int var1) {
         this.b = var1;
         this.c = var1;
      }

      int d() {
         int var1;
         if (this.c != Integer.MIN_VALUE) {
            var1 = this.c;
         } else {
            this.c();
            var1 = this.c;
         }

         return var1;
      }

      void d(int var1) {
         if (this.b != Integer.MIN_VALUE) {
            this.b += var1;
         }

         if (this.c != Integer.MIN_VALUE) {
            this.c += var1;
         }
      }

      void e() {
         this.a.clear();
         this.f();
         this.d = 0;
      }

      void f() {
         this.b = Integer.MIN_VALUE;
         this.c = Integer.MIN_VALUE;
      }

      void g() {
         int var1 = this.a.size();
         View var2 = this.a.remove(var1 - 1);
         StaggeredGridLayoutManager.LayoutParams var3 = this.c(var2);
         var3.a = null;
         if (var3.d() || var3.e()) {
            this.d = this.d - this.f.b.e(var2);
         }

         if (var1 == 1) {
            this.b = Integer.MIN_VALUE;
         }

         this.c = Integer.MIN_VALUE;
      }

      void h() {
         View var2 = this.a.remove(0);
         StaggeredGridLayoutManager.LayoutParams var1 = this.c(var2);
         var1.a = null;
         if (this.a.size() == 0) {
            this.c = Integer.MIN_VALUE;
         }

         if (var1.d() || var1.e()) {
            this.d = this.d - this.f.b.e(var2);
         }

         this.b = Integer.MIN_VALUE;
      }

      public int i() {
         return this.d;
      }

      public int j() {
         int var1;
         if (this.f.d) {
            var1 = this.a(this.a.size() - 1, -1, true);
         } else {
            var1 = this.a(0, this.a.size(), true);
         }

         return var1;
      }

      public int k() {
         int var1;
         if (this.f.d) {
            var1 = this.a(0, this.a.size(), true);
         } else {
            var1 = this.a(this.a.size() - 1, -1, true);
         }

         return var1;
      }
   }
}
