package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, ItemTouchHelper.ViewDropHandler {
   private LinearLayoutManager.LayoutState a;
   private boolean b;
   private boolean c;
   private boolean d;
   private boolean e;
   private boolean f;
   private final LinearLayoutManager.LayoutChunkResult g;
   private int h;
   int i = 1;
   OrientationHelper j;
   boolean k;
   int l;
   int m;
   LinearLayoutManager.SavedState n;
   final LinearLayoutManager.AnchorInfo o;

   public LinearLayoutManager(Context var1) {
      this(var1, 1, false);
   }

   public LinearLayoutManager(Context var1, int var2, boolean var3) {
      this.c = false;
      this.k = false;
      this.d = false;
      this.e = true;
      this.l = -1;
      this.m = Integer.MIN_VALUE;
      this.n = null;
      this.o = new LinearLayoutManager.AnchorInfo();
      this.g = new LinearLayoutManager.LayoutChunkResult();
      this.h = 2;
      this.b(var2);
      this.b(var3);
   }

   public LinearLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      this.c = false;
      this.k = false;
      this.d = false;
      this.e = true;
      this.l = -1;
      this.m = Integer.MIN_VALUE;
      this.n = null;
      this.o = new LinearLayoutManager.AnchorInfo();
      this.g = new LinearLayoutManager.LayoutChunkResult();
      this.h = 2;
      RecyclerView.LayoutManager.Properties var5 = a(var1, var2, var3, var4);
      this.b(var5.a);
      this.b(var5.c);
      this.a(var5.d);
   }

   private void L() {
      boolean var1 = true;
      if (this.i != 1 && this.h()) {
         if (this.c) {
            var1 = false;
         }

         this.k = var1;
      } else {
         this.k = this.c;
      }
   }

   private View M() {
      int var1;
      if (this.k) {
         var1 = this.v() - 1;
      } else {
         var1 = 0;
      }

      return this.i(var1);
   }

   private View N() {
      int var1;
      if (this.k) {
         var1 = 0;
      } else {
         var1 = this.v() - 1;
      }

      return this.i(var1);
   }

   private int a(int var1, RecyclerView.Recycler var2, RecyclerView.State var3, boolean var4) {
      int var5 = this.j.d() - var1;
      if (var5 > 0) {
         int var6 = -this.c(-var5, var2, var3);
         var5 = var6;
         if (var4) {
            var1 = this.j.d() - (var1 + var6);
            var5 = var6;
            if (var1 > 0) {
               this.j.a(var1);
               var5 = var6 + var1;
            }
         }
      } else {
         var5 = 0;
      }

      return var5;
   }

   private View a(boolean var1, boolean var2) {
      View var3;
      if (this.k) {
         var3 = this.a(this.v() - 1, -1, var1, var2);
      } else {
         var3 = this.a(0, this.v(), var1, var2);
      }

      return var3;
   }

   private void a(int var1, int var2) {
      this.a.c = this.j.d() - var2;
      LinearLayoutManager.LayoutState var4 = this.a;
      byte var3;
      if (this.k) {
         var3 = -1;
      } else {
         var3 = 1;
      }

      var4.e = var3;
      this.a.d = var1;
      this.a.f = 1;
      this.a.b = var2;
      this.a.g = Integer.MIN_VALUE;
   }

   private void a(int var1, int var2, boolean var3, RecyclerView.State var4) {
      byte var5 = -1;
      byte var6 = 1;
      this.a.l = this.k();
      this.a.h = this.b(var4);
      this.a.f = var1;
      if (var1 == 1) {
         LinearLayoutManager.LayoutState var11 = this.a;
         var11.h = var11.h + this.j.g();
         View var7 = this.N();
         LinearLayoutManager.LayoutState var12 = this.a;
         byte var8;
         if (this.k) {
            var8 = var5;
         } else {
            var8 = 1;
         }

         var12.e = var8;
         this.a.d = this.d(var7) + this.a.e;
         this.a.b = this.j.b(var7);
         var1 = this.j.b(var7) - this.j.d();
      } else {
         View var13 = this.M();
         LinearLayoutManager.LayoutState var15 = this.a;
         var15.h = var15.h + this.j.c();
         var15 = this.a;
         byte var10;
         if (this.k) {
            var10 = var6;
         } else {
            var10 = -1;
         }

         var15.e = var10;
         this.a.d = this.d(var13) + this.a.e;
         this.a.b = this.j.a(var13);
         var1 = -this.j.a(var13) + this.j.c();
      }

      this.a.c = var2;
      if (var3) {
         LinearLayoutManager.LayoutState var14 = this.a;
         var14.c -= var1;
      }

      this.a.g = var1;
   }

   private void a(LinearLayoutManager.AnchorInfo var1) {
      this.a(var1.b, var1.c);
   }

   private void a(RecyclerView.Recycler var1, int var2) {
      if (var2 >= 0) {
         int var4 = this.v();
         if (this.k) {
            for (int var3 = var4 - 1; var3 >= 0; var3--) {
               View var5 = this.i(var3);
               if (this.j.b(var5) > var2 || this.j.c(var5) > var2) {
                  this.a(var1, var4 - 1, var3);
                  break;
               }
            }
         } else {
            for (int var6 = 0; var6 < var4; var6++) {
               View var7 = this.i(var6);
               if (this.j.b(var7) > var2 || this.j.c(var7) > var2) {
                  this.a(var1, 0, var6);
                  break;
               }
            }
         }
      }
   }

   private void a(RecyclerView.Recycler var1, int var2, int var3) {
      if (var2 != var3) {
         int var4 = var2;
         if (var3 > var2) {
            var3--;

            while (var3 >= var2) {
               this.a(var3, var1);
               var3--;
            }
         } else {
            while (var4 > var3) {
               this.a(var4, var1);
               var4--;
            }
         }
      }
   }

   private void a(RecyclerView.Recycler var1, LinearLayoutManager.LayoutState var2) {
      if (var2.a && !var2.l) {
         if (var2.f == -1) {
            this.b(var1, var2.g);
         } else {
            this.a(var1, var2.g);
         }
      }
   }

   private void a(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3) {
      if (!this.a(var2, var3) && !this.b(var1, var2, var3)) {
         var3.b();
         int var4;
         if (this.d) {
            var4 = var2.e() - 1;
         } else {
            var4 = 0;
         }

         var3.b = var4;
      }
   }

   private boolean a(RecyclerView.State var1, LinearLayoutManager.AnchorInfo var2) {
      boolean var5 = false;
      boolean var6 = true;
      boolean var4;
      if (!var1.a() && this.l != -1) {
         if (this.l >= 0 && this.l < var1.e()) {
            var2.b = this.l;
            if (this.n != null && this.n.a()) {
               var2.d = this.n.c;
               if (var2.d) {
                  var2.c = this.j.d() - this.n.b;
                  var4 = var6;
               } else {
                  var2.c = this.j.c() + this.n.b;
                  var4 = var6;
               }
            } else if (this.m == Integer.MIN_VALUE) {
               View var7 = this.c(this.l);
               if (var7 != null) {
                  if (this.j.e(var7) > this.j.f()) {
                     var2.b();
                     var4 = var6;
                  } else if (this.j.a(var7) - this.j.c() < 0) {
                     var2.c = this.j.c();
                     var2.d = false;
                     var4 = var6;
                  } else if (this.j.d() - this.j.b(var7) < 0) {
                     var2.c = this.j.d();
                     var2.d = true;
                     var4 = var6;
                  } else {
                     int var3;
                     if (var2.d) {
                        var3 = this.j.b(var7) + this.j.b();
                     } else {
                        var3 = this.j.a(var7);
                     }

                     var2.c = var3;
                     var4 = var6;
                  }
               } else {
                  if (this.v() > 0) {
                     int var8 = this.d(this.i(0));
                     if (this.l < var8) {
                        var4 = true;
                     } else {
                        var4 = false;
                     }

                     if (var4 == this.k) {
                        var5 = true;
                     }

                     var2.d = var5;
                  }

                  var2.b();
                  var4 = var6;
               }
            } else {
               var2.d = this.k;
               if (this.k) {
                  var2.c = this.j.d() - this.m;
                  var4 = var6;
               } else {
                  var2.c = this.j.c() + this.m;
                  var4 = var6;
               }
            }
         } else {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            var4 = false;
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   private int b(int var1, RecyclerView.Recycler var2, RecyclerView.State var3, boolean var4) {
      int var5 = var1 - this.j.c();
      if (var5 > 0) {
         int var6 = -this.c(var5, var2, var3);
         var5 = var6;
         if (var4) {
            var1 = var1 + var6 - this.j.c();
            var5 = var6;
            if (var1 > 0) {
               this.j.a(-var1);
               var5 = var6 - var1;
            }
         }
      } else {
         var5 = 0;
      }

      return var5;
   }

   private View b(boolean var1, boolean var2) {
      View var3;
      if (this.k) {
         var3 = this.a(0, this.v(), var1, var2);
      } else {
         var3 = this.a(this.v() - 1, -1, var1, var2);
      }

      return var3;
   }

   private void b(LinearLayoutManager.AnchorInfo var1) {
      this.h(var1.b, var1.c);
   }

   private void b(RecyclerView.Recycler var1, int var2) {
      int var3 = this.v();
      if (var2 >= 0) {
         int var4 = this.j.e() - var2;
         if (this.k) {
            for (int var6 = 0; var6 < var3; var6++) {
               View var5 = this.i(var6);
               if (this.j.a(var5) < var4 || this.j.d(var5) < var4) {
                  this.a(var1, 0, var6);
                  break;
               }
            }
         } else {
            for (int var7 = var3 - 1; var7 >= 0; var7--) {
               View var8 = this.i(var7);
               if (this.j.a(var8) < var4 || this.j.d(var8) < var4) {
                  this.a(var1, var3 - 1, var7);
                  break;
               }
            }
         }
      }
   }

   private void b(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4) {
      if (var2.b() && this.v() != 0 && !var2.a() && this.b()) {
         int var5 = 0;
         int var6 = 0;
         List var12 = var1.c();
         int var9 = var12.size();
         int var10 = this.d(this.i(0));
         int var7 = 0;

         while (var7 < var9) {
            RecyclerView.ViewHolder var13 = (RecyclerView.ViewHolder)var12.get(var7);
            if (var13.isRemoved()) {
               int var8 = var6;
               var6 = var5;
               var5 = var8;
            } else {
               boolean var11;
               if (var13.getLayoutPosition() < var10) {
                  var11 = true;
               } else {
                  var11 = false;
               }

               byte var17;
               if (var11 != this.k) {
                  var17 = -1;
               } else {
                  var17 = 1;
               }

               if (var17 == -1) {
                  var17 = this.j.e(var13.itemView) + var5;
                  var5 = var6;
                  var6 = var17;
               } else {
                  var17 = this.j.e(var13.itemView) + var6;
                  var6 = var5;
                  var5 = var17;
               }
            }

            int var20 = var7 + 1;
            var7 = var6;
            var6 = var5;
            var5 = var7;
            var7 = var20;
         }

         this.a.k = var12;
         if (var5 > 0) {
            this.h(this.d(this.M()), var3);
            this.a.h = var5;
            this.a.c = 0;
            this.a.a();
            this.a(var1, this.a, var2, false);
         }

         if (var6 > 0) {
            this.a(this.d(this.N()), var4);
            this.a.h = var6;
            this.a.c = 0;
            this.a.a();
            this.a(var1, this.a, var2, false);
         }

         this.a.k = null;
      }
   }

   private boolean b(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3) {
      int var4 = 0;
      boolean var6 = false;
      boolean var5;
      if (this.v() == 0) {
         var5 = var6;
      } else {
         View var7 = this.E();
         if (var7 != null && var3.a(var7, var2)) {
            var3.a(var7, this.d(var7));
            var5 = true;
         } else {
            var5 = var6;
            if (this.b == this.d) {
               View var8;
               if (var3.d) {
                  var8 = this.f(var1, var2);
               } else {
                  var8 = this.g(var1, var2);
               }

               var5 = var6;
               if (var8 != null) {
                  var3.b(var8, this.d(var8));
                  if (!var2.a() && this.b()) {
                     if (this.j.a(var8) >= this.j.d() || this.j.b(var8) < this.j.c()) {
                        var4 = 1;
                     }

                     if (var4) {
                        if (var3.d) {
                           var4 = this.j.d();
                        } else {
                           var4 = this.j.c();
                        }

                        var3.c = var4;
                     }
                  }

                  var5 = true;
               }
            }
         }
      }

      return var5;
   }

   private View f(RecyclerView.Recycler var1, RecyclerView.State var2) {
      View var3;
      if (this.k) {
         var3 = this.h(var1, var2);
      } else {
         var3 = this.i(var1, var2);
      }

      return var3;
   }

   private View g(RecyclerView.Recycler var1, RecyclerView.State var2) {
      View var3;
      if (this.k) {
         var3 = this.i(var1, var2);
      } else {
         var3 = this.h(var1, var2);
      }

      return var3;
   }

   private View h(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.a(var1, var2, 0, this.v(), var2.e());
   }

   private void h(int var1, int var2) {
      this.a.c = var2 - this.j.c();
      this.a.d = var1;
      LinearLayoutManager.LayoutState var3 = this.a;
      byte var4;
      if (this.k) {
         var4 = 1;
      } else {
         var4 = -1;
      }

      var3.e = var4;
      this.a.f = -1;
      this.a.b = var2;
      this.a.g = Integer.MIN_VALUE;
   }

   private int i(RecyclerView.State var1) {
      boolean var4 = false;
      int var2 = 0;
      if (this.v() != 0) {
         this.i();
         OrientationHelper var5 = this.j;
         boolean var3;
         if (!this.e) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var6 = this.a(var3, true);
         var3 = var4;
         if (!this.e) {
            var3 = true;
         }

         var2 = ScrollbarHelper.a(var1, var5, var6, this.b(var3, true), this, this.e, this.k);
      }

      return var2;
   }

   private View i(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.a(var1, var2, this.v() - 1, -1, var2.e());
   }

   private int j(RecyclerView.State var1) {
      boolean var4 = false;
      int var2 = 0;
      if (this.v() != 0) {
         this.i();
         OrientationHelper var5 = this.j;
         boolean var3;
         if (!this.e) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var6 = this.a(var3, true);
         var3 = var4;
         if (!this.e) {
            var3 = true;
         }

         var2 = ScrollbarHelper.a(var1, var5, var6, this.b(var3, true), this, this.e);
      }

      return var2;
   }

   private View j(RecyclerView.Recycler var1, RecyclerView.State var2) {
      View var3;
      if (this.k) {
         var3 = this.l(var1, var2);
      } else {
         var3 = this.m(var1, var2);
      }

      return var3;
   }

   private int k(RecyclerView.State var1) {
      boolean var4 = false;
      int var2 = 0;
      if (this.v() != 0) {
         this.i();
         OrientationHelper var6 = this.j;
         boolean var3;
         if (!this.e) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var5 = this.a(var3, true);
         var3 = var4;
         if (!this.e) {
            var3 = true;
         }

         var2 = ScrollbarHelper.b(var1, var6, var5, this.b(var3, true), this, this.e);
      }

      return var2;
   }

   private View k(RecyclerView.Recycler var1, RecyclerView.State var2) {
      View var3;
      if (this.k) {
         var3 = this.m(var1, var2);
      } else {
         var3 = this.l(var1, var2);
      }

      return var3;
   }

   private View l(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.c(0, this.v());
   }

   private View m(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.c(this.v() - 1, -1);
   }

   @Override
   public int a(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      if (this.i == 1) {
         var1 = 0;
      } else {
         var1 = this.c(var1, var2, var3);
      }

      return var1;
   }

   int a(RecyclerView.Recycler var1, LinearLayoutManager.LayoutState var2, RecyclerView.State var3, boolean var4) {
      int var7 = var2.c;
      if (var2.g != Integer.MIN_VALUE) {
         if (var2.c < 0) {
            var2.g = var2.g + var2.c;
         }

         this.a(var1, var2);
      }

      int var6 = var2.c + var2.h;
      LinearLayoutManager.LayoutChunkResult var8 = this.g;

      while ((var2.l || var6 > 0) && var2.a(var3)) {
         var8.a();
         this.a(var1, var3, var2, var8);
         if (var8.b) {
            break;
         }

         int var5;
         label44: {
            var2.b = var2.b + var8.a * var2.f;
            if (var8.c && this.a.k == null) {
               var5 = var6;
               if (var3.a()) {
                  break label44;
               }
            }

            var2.c = var2.c - var8.a;
            var5 = var6 - var8.a;
         }

         if (var2.g != Integer.MIN_VALUE) {
            var2.g = var2.g + var8.a;
            if (var2.c < 0) {
               var2.g = var2.g + var2.c;
            }

            this.a(var1, var2);
         }

         var6 = var5;
         if (var4) {
            var6 = var5;
            if (var8.d) {
               break;
            }
         }
      }

      return var7 - var2.c;
   }

   @Override
   public RecyclerView.LayoutParams a() {
      return new RecyclerView.LayoutParams(-2, -2);
   }

   View a(int var1, int var2, boolean var3, boolean var4) {
      short var6 = 320;
      this.i();
      short var5;
      if (var3) {
         var5 = 24579;
      } else {
         var5 = 320;
      }

      if (!var4) {
         var6 = 0;
      }

      View var7;
      if (this.i == 0) {
         var7 = this.r.a(var1, var2, var5, var6);
      } else {
         var7 = this.s.a(var1, var2, var5, var6);
      }

      return var7;
   }

   View a(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4, int var5) {
      View var14 = null;
      this.i();
      int var7 = this.j.c();
      int var8 = this.j.d();
      byte var6;
      if (var4 > var3) {
         var6 = 1;
      } else {
         var6 = -1;
      }

      View var12 = null;

      View var11;
      while (true) {
         if (var3 == var4) {
            if (var14 == null) {
               var14 = var12;
            }

            var11 = var14;
            break;
         }

         label39: {
            View var10 = this.i(var3);
            int var9 = this.d(var10);
            if (var9 >= 0 && var9 < var5) {
               if (((RecyclerView.LayoutParams)var10.getLayoutParams()).d()) {
                  if (var12 == null) {
                     var13 = var14;
                     var15 = var10;
                     break label39;
                  }
               } else {
                  if (this.j.a(var10) < var8) {
                     var11 = var10;
                     if (this.j.b(var10) >= var7) {
                        break;
                     }
                  }

                  if (var14 == null) {
                     var15 = var12;
                     var13 = var10;
                     break label39;
                  }
               }
            }

            var10 = var12;
            var13 = var14;
            var15 = var10;
         }

         var3 += var6;
         View var17 = var15;
         var14 = var13;
         var12 = var17;
      }

      return var11;
   }

   @Override
   public View a(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
      this.L();
      if (this.v() == 0) {
         var1 = null;
      } else {
         var2 = this.f(var2);
         if (var2 == Integer.MIN_VALUE) {
            var1 = null;
         } else {
            this.i();
            this.i();
            this.a(var2, (int)(0.33333334F * this.j.f()), false, var4);
            this.a.g = Integer.MIN_VALUE;
            this.a.a = false;
            this.a(var3, this.a, var4, true);
            View var7;
            if (var2 == -1) {
               var7 = this.k(var3, var4);
            } else {
               var7 = this.j(var3, var4);
            }

            if (var2 == -1) {
               var1 = this.M();
            } else {
               var1 = this.N();
            }

            if (var1.hasFocusable()) {
               if (var7 == null) {
                  var1 = null;
               }
            } else {
               var1 = var7;
            }
         }
      }

      return var1;
   }

   @Override
   public void a(int var1, int var2, RecyclerView.State var3, RecyclerView.LayoutManager.LayoutPrefetchRegistry var4) {
      if (this.i != 0) {
         var1 = var2;
      }

      if (this.v() != 0 && var1 != 0) {
         this.i();
         byte var5;
         if (var1 > 0) {
            var5 = 1;
         } else {
            var5 = -1;
         }

         this.a(var5, Math.abs(var1), true, var3);
         this.a(var3, this.a, var4);
      }
   }

   @Override
   public void a(int var1, RecyclerView.LayoutManager.LayoutPrefetchRegistry var2) {
      int var3;
      boolean var7;
      if (this.n != null && this.n.a()) {
         var7 = this.n.c;
         var3 = this.n.a;
      } else {
         this.L();
         var7 = this.k;
         if (this.l == -1) {
            if (var7) {
               var3 = var1 - 1;
            } else {
               var3 = 0;
            }
         } else {
            var3 = this.l;
         }
      }

      byte var4;
      if (var7) {
         var4 = -1;
      } else {
         var4 = 1;
      }

      byte var6 = 0;
      int var5 = var3;

      for (int var8 = var6; var8 < this.h && var5 >= 0 && var5 < var1; var8++) {
         var2.b(var5, 0);
         var5 += var4;
      }
   }

   @Override
   public void a(Parcelable var1) {
      if (var1 instanceof LinearLayoutManager.SavedState) {
         this.n = (LinearLayoutManager.SavedState)var1;
         this.o();
      }
   }

   void a(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3, int var4) {
   }

   void a(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.LayoutState var3, LinearLayoutManager.LayoutChunkResult var4) {
      View var11 = var3.a(var1);
      if (var11 == null) {
         var4.b = true;
      } else {
         RecyclerView.LayoutParams var12 = (RecyclerView.LayoutParams)var11.getLayoutParams();
         if (var3.k == null) {
            boolean var10 = this.k;
            boolean var9;
            if (var3.f == -1) {
               var9 = true;
            } else {
               var9 = false;
            }

            if (var10 == var9) {
               this.b(var11);
            } else {
               this.b(var11, 0);
            }
         } else {
            boolean var15 = this.k;
            boolean var14;
            if (var3.f == -1) {
               var14 = true;
            } else {
               var14 = false;
            }

            if (var15 == var14) {
               this.a(var11);
            } else {
               this.a(var11, 0);
            }
         }

         this.a(var11, 0, 0);
         var4.a = this.j.e(var11);
         int var5;
         int var6;
         int var7;
         int var8;
         if (this.i == 1) {
            if (this.h()) {
               var5 = this.y() - this.C();
               var6 = var5 - this.j.f(var11);
            } else {
               var6 = this.A();
               var5 = this.j.f(var11) + var6;
            }

            if (var3.f == -1) {
               var8 = var3.b;
               var7 = var3.b - var4.a;
            } else {
               var7 = var3.b;
               var8 = var3.b;
               var8 = var4.a + var8;
            }
         } else {
            var7 = this.B();
            var8 = var7 + this.j.f(var11);
            if (var3.f == -1) {
               var5 = var3.b;
               var6 = var3.b - var4.a;
            } else {
               var6 = var3.b;
               var5 = var3.b + var4.a;
            }
         }

         this.a(var11, var6, var7, var5, var8);
         if (var12.d() || var12.e()) {
            var4.c = true;
         }

         var4.d = var11.hasFocusable();
      }
   }

   @Override
   public void a(RecyclerView.State var1) {
      super.a(var1);
      this.n = null;
      this.l = -1;
      this.m = Integer.MIN_VALUE;
      this.o.a();
   }

   void a(RecyclerView.State var1, LinearLayoutManager.LayoutState var2, RecyclerView.LayoutManager.LayoutPrefetchRegistry var3) {
      int var4 = var2.d;
      if (var4 >= 0 && var4 < var1.e()) {
         var3.b(var4, Math.max(0, var2.g));
      }
   }

   @Override
   public void a(RecyclerView var1, RecyclerView.Recycler var2) {
      super.a(var1, var2);
      if (this.f) {
         this.c(var2);
         var2.a();
      }
   }

   @Override
   public void a(RecyclerView var1, RecyclerView.State var2, int var3) {
      LinearSmoothScroller var4 = new LinearSmoothScroller(var1.getContext());
      var4.d(var3);
      this.a(var4);
   }

   @Override
   public void a(View var1, View var2, int var3, int var4) {
      this.a("Cannot drop a view during a scroll or layout calculation");
      this.i();
      this.L();
      var3 = this.d(var1);
      var4 = this.d(var2);
      byte var6;
      if (var3 < var4) {
         var6 = 1;
      } else {
         var6 = -1;
      }

      if (this.k) {
         if (var6 == 1) {
            this.b(var4, this.j.d() - (this.j.a(var2) + this.j.e(var1)));
         } else {
            this.b(var4, this.j.d() - this.j.b(var2));
         }
      } else if (var6 == -1) {
         this.b(var4, this.j.a(var2));
      } else {
         this.b(var4, this.j.b(var2) - this.j.e(var1));
      }
   }

   @Override
   public void a(AccessibilityEvent var1) {
      super.a(var1);
      if (this.v() > 0) {
         var1.setFromIndex(this.m());
         var1.setToIndex(this.n());
      }
   }

   @Override
   public void a(String var1) {
      if (this.n == null) {
         super.a(var1);
      }
   }

   public void a(boolean var1) {
      this.a((String)null);
      if (this.d != var1) {
         this.d = var1;
         this.o();
      }
   }

   @Override
   public int b(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      if (this.i == 0) {
         var1 = 0;
      } else {
         var1 = this.c(var1, var2, var3);
      }

      return var1;
   }

   protected int b(RecyclerView.State var1) {
      int var2;
      if (var1.d()) {
         var2 = this.j.f();
      } else {
         var2 = 0;
      }

      return var2;
   }

   public void b(int var1) {
      if (var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation:" + var1);
      }

      this.a((String)null);
      if (var1 != this.i || this.j == null) {
         this.j = OrientationHelper.a(this, var1);
         this.o.a = this.j;
         this.i = var1;
         this.o();
      }
   }

   public void b(int var1, int var2) {
      this.l = var1;
      this.m = var2;
      if (this.n != null) {
         this.n.b();
      }

      this.o();
   }

   public void b(boolean var1) {
      this.a((String)null);
      if (var1 != this.c) {
         this.c = var1;
         this.o();
      }
   }

   @Override
   public boolean b() {
      boolean var1;
      if (this.n == null && this.b == this.d) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   int c(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      if (this.v() != 0 && var1 != 0) {
         this.a.a = true;
         this.i();
         byte var4;
         if (var1 > 0) {
            var4 = 1;
         } else {
            var4 = -1;
         }

         int var6 = Math.abs(var1);
         this.a(var4, var6, true, var3);
         int var5 = this.a.g + this.a(var2, this.a, var3, false);
         if (var5 < 0) {
            var1 = 0;
         } else {
            if (var6 > var5) {
               var1 = var4 * var5;
            }

            this.j.a(-var1);
            this.a.j = var1;
         }
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public int c(RecyclerView.State var1) {
      return this.i(var1);
   }

   @Override
   public View c(int var1) {
      int var2 = this.v();
      View var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         int var3 = var1 - this.d(this.i(0));
         if (var3 >= 0 && var3 < var2) {
            View var5 = this.i(var3);
            var4 = var5;
            if (this.d(var5) == var1) {
               return var4;
            }
         }

         var4 = super.c(var1);
      }

      return var4;
   }

   View c(int var1, int var2) {
      this.i();
      byte var3;
      if (var2 > var1) {
         var3 = 1;
      } else if (var2 < var1) {
         var3 = -1;
      } else {
         var3 = 0;
      }

      View var5;
      if (var3 == 0) {
         var5 = this.i(var1);
      } else {
         short var4;
         if (this.j.a(this.i(var1)) < this.j.c()) {
            var3 = 16644;
            var4 = 16388;
         } else {
            var3 = 4161;
            var4 = 4097;
         }

         if (this.i == 0) {
            var5 = this.r.a(var1, var2, var3, var4);
         } else {
            var5 = this.s.a(var1, var2, var3, var4);
         }
      }

      return var5;
   }

   @Override
   public void c(RecyclerView.Recycler var1, RecyclerView.State var2) {
      int var5 = -1;
      if ((this.n != null || this.l != -1) && var2.e() == 0) {
         this.c(var1);
      } else {
         if (this.n != null && this.n.a()) {
            this.l = this.n.a;
         }

         this.i();
         this.a.a = false;
         this.L();
         View var8 = this.E();
         if (this.o.e && this.l == -1 && this.n == null) {
            if (var8 != null && (this.j.a(var8) >= this.j.d() || this.j.b(var8) <= this.j.c())) {
               this.o.a(var8, this.d(var8));
            }
         } else {
            this.o.a();
            this.o.d = this.k ^ this.d;
            this.a(var1, var2, this.o);
            this.o.e = true;
         }

         int var3 = this.b(var2);
         int var4;
         if (this.a.j >= 0) {
            var4 = 0;
         } else {
            var4 = var3;
            var3 = 0;
         }

         int var6 = var4 + this.j.c();
         int var7 = var3 + this.j.g();
         var4 = var7;
         var3 = var6;
         if (var2.a()) {
            var4 = var7;
            var3 = var6;
            if (this.l != -1) {
               var4 = var7;
               var3 = var6;
               if (this.m != Integer.MIN_VALUE) {
                  var8 = this.c(this.l);
                  var4 = var7;
                  var3 = var6;
                  if (var8 != null) {
                     if (this.k) {
                        var3 = this.j.d() - this.j.b(var8) - this.m;
                     } else {
                        var4 = this.j.a(var8);
                        var3 = this.j.c();
                        var3 = this.m - (var4 - var3);
                     }

                     if (var3 > 0) {
                        var3 = var6 + var3;
                        var4 = var7;
                     } else {
                        var4 = var7 - var3;
                        var3 = var6;
                     }
                  }
               }
            }
         }

         if (this.o.d) {
            if (this.k) {
               var5 = 1;
            }
         } else if (!this.k) {
            var5 = 1;
         }

         this.a(var1, var2, this.o, var5);
         this.a(var1);
         this.a.l = this.k();
         this.a.i = var2.a();
         if (this.o.d) {
            this.b(this.o);
            this.a.h = var3;
            this.a(var1, this.a, var2, false);
            var6 = this.a.b;
            var7 = this.a.d;
            var3 = var4;
            if (this.a.c > 0) {
               var3 = var4 + this.a.c;
            }

            this.a(this.o);
            this.a.h = var3;
            LinearLayoutManager.LayoutState var36 = this.a;
            var36.d = var36.d + this.a.e;
            this.a(var1, this.a, var2, false);
            var5 = this.a.b;
            if (this.a.c > 0) {
               var3 = this.a.c;
               this.h(var7, var6);
               this.a.h = var3;
               this.a(var1, this.a, var2, false);
               var3 = this.a.b;
            } else {
               var3 = var6;
            }

            var4 = var3;
            var3 = var5;
         } else {
            this.a(this.o);
            this.a.h = var4;
            this.a(var1, this.a, var2, false);
            var5 = this.a.b;
            var7 = this.a.d;
            var4 = var3;
            if (this.a.c > 0) {
               var4 = var3 + this.a.c;
            }

            this.b(this.o);
            this.a.h = var4;
            LinearLayoutManager.LayoutState var37 = this.a;
            var37.d = var37.d + this.a.e;
            this.a(var1, this.a, var2, false);
            var6 = this.a.b;
            var3 = var5;
            var4 = var6;
            if (this.a.c > 0) {
               var3 = this.a.c;
               this.a(var7, var5);
               this.a.h = var3;
               this.a(var1, this.a, var2, false);
               var3 = this.a.b;
               var4 = var6;
            }
         }

         var6 = var3;
         var5 = var4;
         if (this.v() > 0) {
            if (this.k ^ this.d) {
               var6 = this.a(var3, var1, var2, true);
               var5 = var4 + var6;
               var4 = this.b(var5, var1, var2, false);
               var5 += var4;
               var6 = var3 + var6 + var4;
            } else {
               var5 = this.b(var4, var1, var2, true);
               var6 = var3 + var5;
               var3 = this.a(var6, var1, var2, false);
               var5 = var4 + var5 + var3;
               var6 += var3;
            }
         }

         this.b(var1, var2, var5, var6);
         if (!var2.a()) {
            this.j.a();
         } else {
            this.o.a();
         }

         this.b = this.d;
      }
   }

   @Override
   public boolean c() {
      return true;
   }

   @Override
   public int d(RecyclerView.State var1) {
      return this.i(var1);
   }

   @Override
   public PointF d(int var1) {
      byte var2 = 1;
      boolean var3 = false;
      PointF var4;
      if (this.v() == 0) {
         var4 = null;
      } else {
         if (var1 < this.d(this.i(0))) {
            var3 = true;
         }

         byte var5 = var2;
         if (var3 != this.k) {
            var5 = -1;
         }

         if (this.i == 0) {
            var4 = new PointF(var5, 0.0F);
         } else {
            var4 = new PointF(0.0F, var5);
         }
      }

      return var4;
   }

   @Override
   public Parcelable d() {
      LinearLayoutManager.SavedState var2;
      if (this.n != null) {
         var2 = new LinearLayoutManager.SavedState(this.n);
      } else {
         var2 = new LinearLayoutManager.SavedState();
         if (this.v() > 0) {
            this.i();
            boolean var1 = this.b ^ this.k;
            var2.c = var1;
            if (var1) {
               View var3 = this.N();
               var2.b = this.j.d() - this.j.b(var3);
               var2.a = this.d(var3);
            } else {
               View var4 = this.M();
               var2.a = this.d(var4);
               var2.b = this.j.a(var4) - this.j.c();
            }
         } else {
            var2.b();
         }
      }

      return var2;
   }

   @Override
   public int e(RecyclerView.State var1) {
      return this.j(var1);
   }

   @Override
   public void e(int var1) {
      this.l = var1;
      this.m = Integer.MIN_VALUE;
      if (this.n != null) {
         this.n.b();
      }

      this.o();
   }

   @Override
   public boolean e() {
      boolean var1;
      if (this.i == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   int f(int var1) {
      byte var2 = -1;
      int var3 = Integer.MIN_VALUE;
      byte var4 = 1;
      switch (var1) {
         case 1:
            var1 = var2;
            if (this.i != 1) {
               var1 = var2;
               if (this.h()) {
                  var1 = 1;
               }
            }
            break;
         case 2:
            if (this.i == 1) {
               var1 = 1;
            } else {
               var1 = var2;
               if (!this.h()) {
                  var1 = 1;
               }
            }
            break;
         case 17:
            var1 = var2;
            if (this.i != 0) {
               var1 = Integer.MIN_VALUE;
            }
            break;
         case 33:
            var1 = var2;
            if (this.i != 1) {
               var1 = Integer.MIN_VALUE;
            }
            break;
         case 66:
            if (this.i == 0) {
               var1 = var4;
            } else {
               var1 = Integer.MIN_VALUE;
            }
            break;
         case 130:
            var1 = var3;
            if (this.i == 1) {
               var1 = 1;
            }
            break;
         default:
            var1 = Integer.MIN_VALUE;
      }

      return var1;
   }

   @Override
   public int f(RecyclerView.State var1) {
      return this.j(var1);
   }

   @Override
   public boolean f() {
      boolean var1 = true;
      if (this.i != 1) {
         var1 = false;
      }

      return var1;
   }

   public int g() {
      return this.i;
   }

   @Override
   public int g(RecyclerView.State var1) {
      return this.k(var1);
   }

   @Override
   public int h(RecyclerView.State var1) {
      return this.k(var1);
   }

   protected boolean h() {
      boolean var1 = true;
      if (this.t() != 1) {
         var1 = false;
      }

      return var1;
   }

   void i() {
      if (this.a == null) {
         this.a = this.j();
      }
   }

   LinearLayoutManager.LayoutState j() {
      return new LinearLayoutManager.LayoutState();
   }

   boolean k() {
      boolean var1;
      if (this.j.h() == 0 && this.j.e() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   boolean l() {
      boolean var1;
      if (this.x() != 1073741824 && this.w() != 1073741824 && this.K()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public int m() {
      View var2 = this.a(0, this.v(), false, true);
      int var1;
      if (var2 == null) {
         var1 = -1;
      } else {
         var1 = this.d(var2);
      }

      return var1;
   }

   public int n() {
      int var1 = -1;
      View var2 = this.a(this.v() - 1, -1, false, true);
      if (var2 != null) {
         var1 = this.d(var2);
      }

      return var1;
   }

   static class AnchorInfo {
      OrientationHelper a;
      int b;
      int c;
      boolean d;
      boolean e;

      AnchorInfo() {
         this.a();
      }

      void a() {
         this.b = -1;
         this.c = Integer.MIN_VALUE;
         this.d = false;
         this.e = false;
      }

      public void a(View var1, int var2) {
         int var3 = this.a.b();
         if (var3 >= 0) {
            this.b(var1, var2);
         } else {
            this.b = var2;
            if (this.d) {
               var2 = this.a.d() - var3 - this.a.b(var1);
               this.c = this.a.d() - var2;
               if (var2 > 0) {
                  var3 = this.a.e(var1);
                  int var4 = this.c;
                  int var5 = this.a.c();
                  var3 = var4 - var3 - (var5 + Math.min(this.a.a(var1) - var5, 0));
                  if (var3 < 0) {
                     var4 = this.c;
                     this.c = Math.min(var2, -var3) + var4;
                  }
               }
            } else {
               int var6 = this.a.a(var1);
               var2 = var6 - this.a.c();
               this.c = var6;
               if (var2 > 0) {
                  int var7 = this.a.e(var1);
                  int var14 = this.a.d();
                  int var15 = this.a.b(var1);
                  var3 = this.a.d() - Math.min(0, var14 - var3 - var15) - (var6 + var7);
                  if (var3 < 0) {
                     this.c = this.c - Math.min(var2, -var3);
                  }
               }
            }
         }
      }

      boolean a(View var1, RecyclerView.State var2) {
         RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         boolean var3;
         if (!var4.d() && var4.f() >= 0 && var4.f() < var2.e()) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      void b() {
         int var1;
         if (this.d) {
            var1 = this.a.d();
         } else {
            var1 = this.a.c();
         }

         this.c = var1;
      }

      public void b(View var1, int var2) {
         if (this.d) {
            this.c = this.a.b(var1) + this.a.b();
         } else {
            this.c = this.a.a(var1);
         }

         this.b = var2;
      }

      @Override
      public String toString() {
         return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
      }
   }

   protected static class LayoutChunkResult {
      public int a;
      public boolean b;
      public boolean c;
      public boolean d;

      void a() {
         this.a = 0;
         this.b = false;
         this.c = false;
         this.d = false;
      }
   }

   static class LayoutState {
      boolean a = true;
      int b;
      int c;
      int d;
      int e;
      int f;
      int g;
      int h = 0;
      boolean i = false;
      int j;
      List<RecyclerView.ViewHolder> k = null;
      boolean l;

      private View b() {
         int var2 = this.k.size();
         int var1 = 0;

         View var3;
         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = this.k.get(var1).itemView;
            RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var3.getLayoutParams();
            if (!var4.d() && this.d == var4.f()) {
               this.a(var3);
               break;
            }

            var1++;
         }

         return var3;
      }

      View a(RecyclerView.Recycler var1) {
         View var2;
         if (this.k != null) {
            var2 = this.b();
         } else {
            var2 = var1.c(this.d);
            this.d = this.d + this.e;
         }

         return var2;
      }

      public void a() {
         this.a((View)null);
      }

      public void a(View var1) {
         var1 = this.b(var1);
         if (var1 == null) {
            this.d = -1;
         } else {
            this.d = ((RecyclerView.LayoutParams)var1.getLayoutParams()).f();
         }
      }

      boolean a(RecyclerView.State var1) {
         boolean var2;
         if (this.d >= 0 && this.d < var1.e()) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public View b(View var1) {
         int var5 = this.k.size();
         View var6 = null;
         int var2 = Integer.MAX_VALUE;
         int var3 = 0;

         View var7;
         while (true) {
            if (var3 >= var5) {
               var7 = var6;
               break;
            }

            var7 = this.k.get(var3).itemView;
            RecyclerView.LayoutParams var8 = (RecyclerView.LayoutParams)var7.getLayoutParams();
            if (var7 != var1 && !var8.d()) {
               int var4 = (var8.f() - this.d) * this.e;
               if (var4 >= 0 && var4 < var2) {
                  if (var4 == 0) {
                     break;
                  }

                  var6 = var7;
                  var2 = var4;
               }
            }

            var3++;
         }

         return var7;
      }
   }

   public static class SavedState implements Parcelable {
      public static final Creator<LinearLayoutManager.SavedState> CREATOR = new Creator<LinearLayoutManager.SavedState>() {
         public LinearLayoutManager.SavedState a(Parcel var1) {
            return new LinearLayoutManager.SavedState(var1);
         }

         public LinearLayoutManager.SavedState[] a(int var1) {
            return new LinearLayoutManager.SavedState[var1];
         }
      };
      int a;
      int b;
      boolean c;

      public SavedState() {
      }

      SavedState(Parcel var1) {
         boolean var2 = true;
         super();
         this.a = var1.readInt();
         this.b = var1.readInt();
         if (var1.readInt() != 1) {
            var2 = false;
         }

         this.c = var2;
      }

      public SavedState(LinearLayoutManager.SavedState var1) {
         this.a = var1.a;
         this.b = var1.b;
         this.c = var1.c;
      }

      boolean a() {
         boolean var1;
         if (this.a >= 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      void b() {
         this.a = -1;
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.a);
         var1.writeInt(this.b);
         byte var3;
         if (this.c) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }
}
