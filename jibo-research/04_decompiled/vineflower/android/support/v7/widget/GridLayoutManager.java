package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
   boolean a = false;
   int b = -1;
   int[] c;
   View[] d;
   final SparseIntArray e = new SparseIntArray();
   final SparseIntArray f = new SparseIntArray();
   GridLayoutManager.SpanSizeLookup g = new GridLayoutManager.DefaultSpanSizeLookup();
   final Rect h = new Rect();

   public GridLayoutManager(Context var1, int var2) {
      super(var1);
      this.a(var2);
   }

   public GridLayoutManager(Context var1, int var2, int var3, boolean var4) {
      super(var1, var3, var4);
      this.a(var2);
   }

   public GridLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.a(a(var1, var2, var3, var4).b);
   }

   private void L() {
      this.e.clear();
      this.f.clear();
   }

   private void M() {
      int var2 = this.v();

      for (int var1 = 0; var1 < var2; var1++) {
         GridLayoutManager.LayoutParams var4 = (GridLayoutManager.LayoutParams)this.i(var1).getLayoutParams();
         int var3 = var4.f();
         this.e.put(var3, var4.b());
         this.f.put(var3, var4.a());
      }
   }

   private void N() {
      int var1;
      if (this.g() == 1) {
         var1 = this.y() - this.C() - this.A();
      } else {
         var1 = this.z() - this.D() - this.B();
      }

      this.m(var1);
   }

   private void O() {
      if (this.d == null || this.d.length != this.b) {
         this.d = new View[this.b];
      }
   }

   private int a(RecyclerView.Recycler var1, RecyclerView.State var2, int var3) {
      if (!var2.a()) {
         var3 = this.g.c(var3, this.b);
      } else {
         int var4 = var1.b(var3);
         if (var4 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + var3);
            var3 = 0;
         } else {
            var3 = this.g.c(var4, this.b);
         }
      }

      return var3;
   }

   private void a(float var1, int var2) {
      this.m(Math.max(Math.round(this.b * var1), var2));
   }

   private void a(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4, boolean var5) {
      int var6;
      byte var13;
      if (var5) {
         var13 = 1;
         byte var7 = 0;
         var6 = var3;
         var3 = var7;
      } else {
         var6 = -1;
         var3--;
         var13 = -1;
      }

      byte var8 = 0;
      int var14 = var3;
      var3 = var8;

      while (var14 != var6) {
         View var10 = this.d[var14];
         GridLayoutManager.LayoutParams var9 = (GridLayoutManager.LayoutParams)var10.getLayoutParams();
         var9.b = this.c(var1, var2, this.d(var10));
         var9.a = var3;
         var3 += var9.b;
         var14 += var13;
      }
   }

   private void a(View var1, int var2, int var3, boolean var4) {
      RecyclerView.LayoutParams var5 = (RecyclerView.LayoutParams)var1.getLayoutParams();
      if (var4) {
         var4 = this.a(var1, var2, var3, var5);
      } else {
         var4 = this.b(var1, var2, var3, var5);
      }

      if (var4) {
         var1.measure(var2, var3);
      }
   }

   private void a(View var1, int var2, boolean var3) {
      GridLayoutManager.LayoutParams var8 = (GridLayoutManager.LayoutParams)var1.getLayoutParams();
      Rect var9 = var8.d;
      int var4 = var9.top + var9.bottom + var8.topMargin + var8.bottomMargin;
      int var7 = var9.left;
      int var5 = var9.right;
      int var6 = var8.leftMargin;
      var5 = var8.rightMargin + var5 + var7 + var6;
      var6 = this.a(var8.a, var8.b);
      if (this.i == 1) {
         var2 = a(var6, var2, var5, var8.width, false);
         var4 = a(this.j.f(), this.x(), var4, var8.height, true);
      } else {
         var4 = a(var6, var2, var4, var8.height, false);
         var2 = a(this.j.f(), this.w(), var5, var8.width, true);
      }

      this.a(var1, var2, var4, var3);
   }

   static int[] a(int[] var0, int var1, int var2) {
      byte var5;
      int[] var8;
      label30: {
         var5 = 0;
         if (var0 != null && var0.length == var1 + 1) {
            var8 = var0;
            if (var0[var0.length - 1] == var2) {
               break label30;
            }
         }

         var8 = new int[var1 + 1];
      }

      var8[0] = 0;
      int var6 = var2 / var1;
      int var7 = var2 % var1;
      int var3 = 1;
      int var4 = 0;
      var2 = var5;

      while (var3 <= var1) {
         var2 += var7;
         if (var2 > 0 && var1 - var2 < var7) {
            var5 = var6 + 1;
            var2 -= var1;
         } else {
            var5 = var6;
         }

         var4 += var5;
         var8[var3] = var4;
         var3++;
      }

      return var8;
   }

   private int b(RecyclerView.Recycler var1, RecyclerView.State var2, int var3) {
      int var4;
      if (!var2.a()) {
         var4 = this.g.b(var3, this.b);
      } else {
         int var5 = this.f.get(var3, -1);
         var4 = var5;
         if (var5 == -1) {
            var4 = var1.b(var3);
            if (var4 == -1) {
               Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + var3);
               var4 = 0;
            } else {
               var4 = this.g.b(var4, this.b);
            }
         }
      }

      return var4;
   }

   private void b(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3, int var4) {
      int var5 = 1;
      if (var4 != 1) {
         var5 = 0;
      }

      var4 = this.b(var1, var2, var3.b);
      if (var5) {
         while (var4 > 0 && var3.b > 0) {
            var3.b--;
            var4 = this.b(var1, var2, var3.b);
         }
      } else {
         int var7 = var2.e();
         int var6 = var3.b;
         var5 = var4;
         var4 = var6;

         while (var4 < var7 - 1) {
            var6 = this.b(var1, var2, var4 + 1);
            if (var6 <= var5) {
               break;
            }

            var4++;
            var5 = var6;
         }

         var3.b = var4;
      }
   }

   private int c(RecyclerView.Recycler var1, RecyclerView.State var2, int var3) {
      int var4;
      if (!var2.a()) {
         var4 = this.g.a(var3);
      } else {
         int var5 = this.e.get(var3, -1);
         var4 = var5;
         if (var5 == -1) {
            var4 = var1.b(var3);
            if (var4 == -1) {
               Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + var3);
               var4 = 1;
            } else {
               var4 = this.g.a(var4);
            }
         }
      }

      return var4;
   }

   private void m(int var1) {
      this.c = a(this.c, this.b, var1);
   }

   int a(int var1, int var2) {
      if (this.i == 1 && this.h()) {
         var1 = this.c[this.b - var1] - this.c[this.b - var1 - var2];
      } else {
         var1 = this.c[var1 + var2] - this.c[var1];
      }

      return var1;
   }

   @Override
   public int a(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      this.N();
      this.O();
      return super.a(var1, var2, var3);
   }

   @Override
   public int a(RecyclerView.Recycler var1, RecyclerView.State var2) {
      int var3;
      if (this.i == 0) {
         var3 = this.b;
      } else if (var2.e() < 1) {
         var3 = 0;
      } else {
         var3 = this.a(var1, var2, var2.e() - 1) + 1;
      }

      return var3;
   }

   @Override
   public RecyclerView.LayoutParams a() {
      GridLayoutManager.LayoutParams var1;
      if (this.i == 0) {
         var1 = new GridLayoutManager.LayoutParams(-2, -1);
      } else {
         var1 = new GridLayoutManager.LayoutParams(-1, -2);
      }

      return var1;
   }

   @Override
   public RecyclerView.LayoutParams a(Context var1, AttributeSet var2) {
      return new GridLayoutManager.LayoutParams(var1, var2);
   }

   @Override
   public RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
      GridLayoutManager.LayoutParams var2;
      if (var1 instanceof MarginLayoutParams) {
         var2 = new GridLayoutManager.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new GridLayoutManager.LayoutParams(var1);
      }

      return var2;
   }

   @Override
   View a(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4, int var5) {
      View var11 = null;
      this.i();
      int var8 = this.j.c();
      int var7 = this.j.d();
      byte var6;
      if (var4 > var3) {
         var6 = 1;
      } else {
         var6 = -1;
      }

      View var10 = null;

      View var13;
      while (true) {
         if (var3 == var4) {
            if (var11 == null) {
               var11 = var10;
            }

            var13 = var11;
            break;
         }

         label43: {
            View var12 = this.i(var3);
            int var9 = this.d(var12);
            if (var9 >= 0 && var9 < var5) {
               if (this.b(var1, var2, var9) != 0) {
                  var12 = var11;
                  var11 = var10;
                  var10 = var12;
                  break label43;
               }

               if (((RecyclerView.LayoutParams)var12.getLayoutParams()).d()) {
                  if (var10 == null) {
                     var10 = var11;
                     var11 = var12;
                     break label43;
                  }
               } else {
                  if (this.j.a(var12) < var7) {
                     var13 = var12;
                     if (this.j.b(var12) >= var8) {
                        break;
                     }
                  }

                  if (var11 == null) {
                     var11 = var10;
                     var10 = var12;
                     break label43;
                  }
               }
            }

            var12 = var11;
            var11 = var10;
            var10 = var12;
         }

         var3 += var6;
         View var18 = var11;
         var11 = var10;
         var10 = var18;
      }

      return var13;
   }

   @Override
   public View a(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
      View var24 = this.e(var1);
      View var22;
      if (var24 == null) {
         var22 = null;
      } else {
         GridLayoutManager.LayoutParams var21 = (GridLayoutManager.LayoutParams)var24.getLayoutParams();
         int var16 = var21.a;
         int var15 = var21.a + var21.b;
         if (super.a(var1, var2, var3, var4) == null) {
            var22 = null;
         } else {
            boolean var20;
            if (this.f(var2) == 1) {
               var20 = true;
            } else {
               var20 = false;
            }

            boolean var28;
            if (var20 != this.k) {
               var28 = 1;
            } else {
               var28 = 0;
            }

            int var9;
            byte var10;
            if (var28) {
               var28 = this.v() - 1;
               var10 = -1;
               var9 = -1;
            } else {
               var9 = this.v();
               var28 = 0;
               var10 = 1;
            }

            boolean var11;
            if (this.i == 1 && this.h()) {
               var11 = true;
            } else {
               var11 = false;
            }

            var1 = null;
            int var8 = -1;
            int var7 = 0;
            View var41 = null;
            int var5 = -1;
            int var6 = 0;
            int var17 = this.a(var3, var4, var28);
            int var12 = var28;

            while (var12 != var9) {
               var28 = this.a(var3, var4, var12);
               View var23 = this.i(var12);
               if (var23 == var24) {
                  break;
               }

               label133: {
                  if (var23.hasFocusable() && var28 != var17) {
                     if (var1 != null) {
                        break;
                     }
                  } else {
                     GridLayoutManager.LayoutParams var25 = (GridLayoutManager.LayoutParams)var23.getLayoutParams();
                     int var18 = var25.a;
                     int var19 = var25.a + var25.b;
                     if (var23.hasFocusable() && var18 == var16) {
                        var22 = var23;
                        if (var19 == var15) {
                           return var22;
                        }
                     }

                     boolean var14 = false;
                     boolean var31;
                     if ((!var23.hasFocusable() || var1 != null) && (var23.hasFocusable() || var41 != null)) {
                        var31 = Math.max(var18, var16);
                        int var13 = Math.min(var19, var15) - var31;
                        if (var23.hasFocusable()) {
                           if (var13 > var7) {
                              var31 = 1;
                           } else {
                              var31 = var14;
                              if (var13 == var7) {
                                 boolean var39;
                                 if (var18 > var8) {
                                    var39 = true;
                                 } else {
                                    var39 = false;
                                 }

                                 var31 = var14;
                                 if (var11 == var39) {
                                    var31 = 1;
                                 }
                              }
                           }
                        } else {
                           var31 = var14;
                           if (var1 == null) {
                              var31 = var14;
                              if (this.a(var23, false, true)) {
                                 if (var13 > var6) {
                                    var31 = 1;
                                 } else {
                                    var31 = var14;
                                    if (var13 == var6) {
                                       boolean var40;
                                       if (var18 > var5) {
                                          var40 = true;
                                       } else {
                                          var40 = false;
                                       }

                                       var31 = var14;
                                       if (var11 == var40) {
                                          var31 = 1;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        var31 = 1;
                     }

                     if (var31) {
                        if (var23.hasFocusable()) {
                           var7 = var25.a;
                           var31 = Math.min(var19, var15);
                           var8 = Math.max(var18, var16);
                           var1 = var41;
                           var8 = var31 - var8;
                           var28 = var6;
                           var42 = var23;
                           var6 = var7;
                           var7 = var8;
                        } else {
                           var5 = var25.a;
                           var28 = Math.min(var19, var15) - Math.max(var18, var16);
                           var6 = var8;
                           var42 = var1;
                           var1 = var23;
                        }
                        break label133;
                     }
                  }

                  var28 = var6;
                  var6 = var8;
                  var22 = var41;
                  var42 = var1;
                  var1 = var22;
               }

               var12 += var10;
               var22 = var42;
               var8 = var6;
               var6 = var28;
               var41 = var1;
               var1 = var22;
            }

            if (var1 == null) {
               var1 = var41;
            }

            var22 = var1;
         }
      }

      return var22;
   }

   public void a(int var1) {
      if (var1 != this.b) {
         this.a = true;
         if (var1 < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + var1);
         }

         this.b = var1;
         this.g.a();
         this.o();
      }
   }

   @Override
   public void a(Rect var1, int var2, int var3) {
      if (this.c == null) {
         super.a(var1, var2, var3);
      }

      int var4 = this.A();
      var4 = this.C() + var4;
      int var5 = this.B() + this.D();
      if (this.i == 1) {
         var3 = a(var3, var5 + var1.height(), this.H());
         var2 = a(var2, var4 + this.c[this.c.length - 1], this.G());
      } else {
         var2 = a(var2, var4 + var1.width(), this.G());
         var3 = a(var3, var5 + this.c[this.c.length - 1], this.H());
      }

      this.g(var2, var3);
   }

   public void a(GridLayoutManager.SpanSizeLookup var1) {
      this.g = var1;
   }

   @Override
   void a(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3, int var4) {
      super.a(var1, var2, var3, var4);
      this.N();
      if (var2.e() > 0 && !var2.a()) {
         this.b(var1, var2, var3, var4);
      }

      this.O();
   }

   @Override
   void a(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.LayoutState var3, LinearLayoutManager.LayoutChunkResult var4) {
      int var14 = this.j.i();
      boolean var8;
      if (var14 != 1073741824) {
         var8 = 1;
      } else {
         var8 = 0;
      }

      int var10;
      if (this.v() > 0) {
         var10 = this.c[this.b];
      } else {
         var10 = 0;
      }

      if (var8) {
         this.N();
      }

      boolean var15;
      if (var3.e == 1) {
         var15 = true;
      } else {
         var15 = false;
      }

      int var13 = 0;
      int var12 = 0;
      int var7 = this.b;
      int var11 = var13;
      int var9 = var12;
      if (!var15) {
         var7 = this.b(var1, var2, var3.d) + this.c(var1, var2, var3.d);
         var9 = var12;
         var11 = var13;
      }

      while (var11 < this.b && var3.a(var2) && var7 > 0) {
         var13 = var3.d;
         var12 = this.c(var1, var2, var13);
         if (var12 > this.b) {
            throw new IllegalArgumentException(
               "Item at position " + var13 + " requires " + var12 + " spans but GridLayoutManager has only " + this.b + " spans."
            );
         }

         var7 -= var12;
         if (var7 < 0) {
            break;
         }

         View var16 = var3.a(var1);
         if (var16 == null) {
            break;
         }

         var9 += var12;
         this.d[var11] = var16;
         var11++;
      }

      if (var11 == 0) {
         var4.b = true;
      } else {
         this.a(var1, var2, var11, var9, var15);
         var9 = 0;
         float var5 = 0.0F;
         var7 = 0;

         while (var9 < var11) {
            View var17 = this.d[var9];
            if (var3.k == null) {
               if (var15) {
                  this.b(var17);
               } else {
                  this.b(var17, 0);
               }
            } else if (var15) {
               this.a(var17);
            } else {
               this.a(var17, 0);
            }

            this.b(var17, this.h);
            this.a(var17, var14, false);
            var13 = this.j.e(var17);
            var12 = var7;
            if (var13 > var7) {
               var12 = var13;
            }

            GridLayoutManager.LayoutParams var21 = (GridLayoutManager.LayoutParams)var17.getLayoutParams();
            float var6 = this.j.f(var17) * 1.0F / var21.b;
            if (var6 > var5) {
               var5 = var6;
            }

            var9++;
            var7 = var12;
         }

         var9 = var7;
         if (var8) {
            this.a(var5, var10);
            var7 = 0;
            var8 = 0;

            while (true) {
               var9 = var7;
               if (var8 >= var11) {
                  break;
               }

               View var18 = this.d[var8];
               this.a(var18, 1073741824, true);
               var9 = this.j.e(var18);
               if (var9 > var7) {
                  var7 = var9;
               }

               var8++;
            }
         }

         for (int var26 = 0; var26 < var11; var26++) {
            View var22 = this.d[var26];
            if (this.j.e(var22) != var9) {
               GridLayoutManager.LayoutParams var54 = (GridLayoutManager.LayoutParams)var22.getLayoutParams();
               Rect var19 = var54.d;
               var10 = var19.top + var19.bottom + var54.topMargin + var54.bottomMargin;
               var8 = var19.left;
               var8 = var19.right + var8 + var54.leftMargin + var54.rightMargin;
               var12 = this.a(var54.a, var54.b);
               if (this.i == 1) {
                  var8 = a(var12, 1073741824, var8, var54.width, false);
                  var10 = MeasureSpec.makeMeasureSpec(var9 - var10, 1073741824);
               } else {
                  var8 = MeasureSpec.makeMeasureSpec(var9 - var8, 1073741824);
                  var10 = a(var12, 1073741824, var10, var54.height, false);
               }

               this.a(var22, var8, var10, true);
            }
         }

         var4.a = var9;
         var10 = 0;
         if (this.i == 1) {
            if (var3.f == -1) {
               var10 = var3.b;
               var7 = var10 - var9;
               var8 = 0;
               var9 = 0;
            } else {
               var7 = var3.b;
               var10 = var7 + var9;
               var8 = 0;
               var9 = 0;
            }
         } else if (var3.f == -1) {
            var7 = var3.b;
            var8 = var7;
            var9 = var7 - var9;
            var7 = 0;
         } else {
            var12 = var3.b;
            var8 = var9 + var12;
            var7 = 0;
            var9 = var12;
         }

         var12 = var10;
         var10 = var9;
         byte var53 = 0;
         var9 = var12;
         var12 = var7;
         var7 = var10;

         for (int var44 = var53; var44 < var11; var44++) {
            View var20 = this.d[var44];
            GridLayoutManager.LayoutParams var23 = (GridLayoutManager.LayoutParams)var20.getLayoutParams();
            if (this.i == 1) {
               if (this.h()) {
                  var8 = this.A() + this.c[this.b - var23.a];
                  var7 = var8 - this.j.f(var20);
               } else {
                  var7 = this.A() + this.c[var23.a];
                  var8 = var7 + this.j.f(var20);
               }
            } else {
               var12 = this.B() + this.c[var23.a];
               var9 = var12 + this.j.f(var20);
            }

            this.a(var20, var7, var12, var8, var9);
            if (var23.d() || var23.e()) {
               var4.c = true;
            }

            var4.d = var4.d | var20.hasFocusable();
         }

         Arrays.fill(this.d, null);
      }
   }

   @Override
   public void a(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, AccessibilityNodeInfoCompat var4) {
      android.view.ViewGroup.LayoutParams var9 = var3.getLayoutParams();
      if (!(var9 instanceof GridLayoutManager.LayoutParams)) {
         super.a(var3, var4);
      } else {
         GridLayoutManager.LayoutParams var10 = (GridLayoutManager.LayoutParams)var9;
         int var5 = this.a(var1, var2, var10.f());
         if (this.i == 0) {
            int var6 = var10.a();
            int var7 = var10.b();
            boolean var8;
            if (this.b > 1 && var10.b() == this.b) {
               var8 = true;
            } else {
               var8 = false;
            }

            var4.b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(var6, var7, var5, 1, var8, false));
         } else {
            int var11 = var10.a();
            int var12 = var10.b();
            boolean var13;
            if (this.b > 1 && var10.b() == this.b) {
               var13 = true;
            } else {
               var13 = false;
            }

            var4.b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(var5, 1, var11, var12, var13, false));
         }
      }
   }

   @Override
   public void a(RecyclerView.State var1) {
      super.a(var1);
      this.a = false;
   }

   @Override
   void a(RecyclerView.State var1, LinearLayoutManager.LayoutState var2, RecyclerView.LayoutManager.LayoutPrefetchRegistry var3) {
      int var4 = this.b;

      for (int var5 = 0; var5 < this.b && var2.a(var1) && var4 > 0; var5++) {
         int var6 = var2.d;
         var3.b(var6, Math.max(0, var2.g));
         var4 -= this.g.a(var6);
         var2.d = var2.d + var2.e;
      }
   }

   @Override
   public void a(RecyclerView var1) {
      this.g.a();
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3) {
      this.g.a();
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3, int var4) {
      this.g.a();
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3, Object var4) {
      this.g.a();
   }

   @Override
   public void a(boolean var1) {
      if (var1) {
         throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
      }

      super.a(false);
   }

   @Override
   public boolean a(RecyclerView.LayoutParams var1) {
      return var1 instanceof GridLayoutManager.LayoutParams;
   }

   @Override
   public int b(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      this.N();
      this.O();
      return super.b(var1, var2, var3);
   }

   @Override
   public int b(RecyclerView.Recycler var1, RecyclerView.State var2) {
      int var3;
      if (this.i == 1) {
         var3 = this.b;
      } else if (var2.e() < 1) {
         var3 = 0;
      } else {
         var3 = this.a(var1, var2, var2.e() - 1) + 1;
      }

      return var3;
   }

   @Override
   public void b(RecyclerView var1, int var2, int var3) {
      this.g.a();
   }

   @Override
   public boolean b() {
      boolean var1;
      if (this.n == null && !this.a) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void c(RecyclerView.Recycler var1, RecyclerView.State var2) {
      if (var2.a()) {
         this.M();
      }

      super.c(var1, var2);
      this.L();
   }

   public static final class DefaultSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
      @Override
      public int a(int var1) {
         return 1;
      }

      @Override
      public int a(int var1, int var2) {
         return var1 % var2;
      }
   }

   public static class LayoutParams extends RecyclerView.LayoutParams {
      int a = -1;
      int b = 0;

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

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }
   }

   public abstract static class SpanSizeLookup {
      final SparseIntArray a = new SparseIntArray();
      private boolean b = false;

      public abstract int a(int var1);

      public int a(int var1, int var2) {
         byte var5 = 0;
         int var8 = this.a(var1);
         if (var8 == var2) {
            var1 = var5;
         } else {
            int var3;
            int var4;
            label28: {
               if (this.b && this.a.size() > 0) {
                  var4 = this.b(var1);
                  if (var4 >= 0) {
                     var3 = this.a.get(var4) + this.a(var4);
                     var4++;
                     break label28;
                  }
               }

               var4 = 0;
               var3 = 0;
            }

            for (; var4 < var1; var4++) {
               int var7 = this.a(var4);
               int var6 = var3 + var7;
               if (var6 == var2) {
                  var3 = 0;
               } else {
                  var3 = var7;
                  if (var6 <= var2) {
                     var3 = var6;
                  }
               }
            }

            var1 = var5;
            if (var3 + var8 <= var2) {
               var1 = var3;
            }
         }

         return var1;
      }

      public void a() {
         this.a.clear();
      }

      int b(int var1) {
         int var2 = 0;
         int var3 = this.a.size() - 1;

         while (var2 <= var3) {
            int var4 = var2 + var3 >>> 1;
            if (this.a.keyAt(var4) < var1) {
               var2 = var4 + 1;
            } else {
               var3 = var4 - 1;
            }
         }

         var1 = var2 - 1;
         if (var1 >= 0 && var1 < this.a.size()) {
            var1 = this.a.keyAt(var1);
         } else {
            var1 = -1;
         }

         return var1;
      }

      int b(int var1, int var2) {
         int var3;
         if (!this.b) {
            var3 = this.a(var1, var2);
         } else {
            int var4 = this.a.get(var1, -1);
            var3 = var4;
            if (var4 == -1) {
               var3 = this.a(var1, var2);
               this.a.put(var1, var3);
            }
         }

         return var3;
      }

      public int c(int var1, int var2) {
         int var7 = this.a(var1);
         int var5 = 0;
         int var3 = 0;
         int var4 = 0;

         while (var5 < var1) {
            int var6 = this.a(var5);
            var4 += var6;
            if (var4 == var2) {
               var4 = var3 + 1;
               var3 = 0;
            } else if (var4 > var2) {
               var4 = var3 + 1;
               var3 = var6;
            } else {
               var6 = var4;
               var4 = var3;
               var3 = var6;
            }

            var6 = var5 + 1;
            var5 = var3;
            var3 = var4;
            var4 = var5;
            var5 = var6;
         }

         var1 = var3;
         if (var4 + var7 > var2) {
            var1 = var3 + 1;
         }

         return var1;
      }
   }
}
