package android.support.v7.widget.helper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
   private ItemTouchHelper.ItemTouchHelperGestureListener A;
   private final RecyclerView.OnItemTouchListener B;
   private Rect C;
   private long D;
   final List<View> a = new ArrayList<>();
   RecyclerView.ViewHolder b;
   float c;
   float d;
   float e;
   float f;
   float g;
   float h;
   float i;
   float j;
   int k;
   ItemTouchHelper.Callback l;
   int m;
   int n;
   List<ItemTouchHelper.RecoverAnimation> o;
   RecyclerView p;
   final Runnable q;
   VelocityTracker r;
   View s;
   int t;
   GestureDetectorCompat u;
   private final float[] v = new float[2];
   private int w;
   private List<RecyclerView.ViewHolder> x;
   private List<Integer> y;
   private RecyclerView.ChildDrawingOrderCallback z;

   public ItemTouchHelper(ItemTouchHelper.Callback var1) {
      this.b = null;
      this.k = -1;
      this.m = 0;
      this.o = new ArrayList<>();
      this.q = new Runnable(this) {
         final ItemTouchHelper a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.b != null && this.a.b()) {
               if (this.a.b != null) {
                  this.a.a(this.a.b);
               }

               this.a.p.removeCallbacks(this.a.q);
               ViewCompat.a(this.a.p, this);
            }
         }
      };
      this.z = null;
      this.s = null;
      this.t = -1;
      this.B = new RecyclerView.OnItemTouchListener(this) {
         final ItemTouchHelper a;

         {
            this.a = var1;
         }

         @Override
         public void a(boolean var1) {
            if (var1) {
               this.a.a((RecyclerView.ViewHolder)null, 0);
            }
         }

         @Override
         public boolean a(RecyclerView var1, MotionEvent var2) {
            boolean var5 = true;
            this.a.u.a(var2);
            int var4 = var2.getActionMasked();
            if (var4 == 0) {
               this.a.k = var2.getPointerId(0);
               this.a.c = var2.getX();
               this.a.d = var2.getY();
               this.a.c();
               if (this.a.b == null) {
                  ItemTouchHelper.RecoverAnimation var7 = this.a.b(var2);
                  if (var7 != null) {
                     ItemTouchHelper var6 = this.a;
                     var6.c = var6.c - var7.l;
                     var6 = this.a;
                     var6.d = var6.d - var7.m;
                     this.a.a(var7.h, true);
                     if (this.a.a.remove(var7.h.itemView)) {
                        this.a.l.d(this.a.p, var7.h);
                     }

                     this.a.a(var7.h, var7.i);
                     this.a.a(var2, this.a.n, 0);
                  }
               }
            } else if (var4 == 3 || var4 == 1) {
               this.a.k = -1;
               this.a.a((RecyclerView.ViewHolder)null, 0);
            } else if (this.a.k != -1) {
               int var3 = var2.findPointerIndex(this.a.k);
               if (var3 >= 0) {
                  this.a.a(var4, var2, var3);
               }
            }

            if (this.a.r != null) {
               this.a.r.addMovement(var2);
            }

            if (this.a.b == null) {
               var5 = false;
            }

            return var5;
         }

         @Override
         public void b(RecyclerView var1, MotionEvent var2) {
            byte var3 = 0;
            this.a.u.a(var2);
            if (this.a.r != null) {
               this.a.r.addMovement(var2);
            }

            if (this.a.k != -1) {
               int var4 = var2.getActionMasked();
               int var5 = var2.findPointerIndex(this.a.k);
               if (var5 >= 0) {
                  this.a.a(var4, var2, var5);
               }

               RecyclerView.ViewHolder var6 = this.a.b;
               if (var6 != null) {
                  switch (var4) {
                     case 2:
                        if (var5 >= 0) {
                           this.a.a(var2, this.a.n, var5);
                           this.a.a(var6);
                           this.a.p.removeCallbacks(this.a.q);
                           this.a.q.run();
                           this.a.p.invalidate();
                        }
                        break;
                     case 3:
                        if (this.a.r != null) {
                           this.a.r.clear();
                        }
                     case 1:
                        this.a.a((RecyclerView.ViewHolder)null, 0);
                        this.a.k = -1;
                     case 4:
                     case 5:
                     default:
                        break;
                     case 6:
                        var4 = var2.getActionIndex();
                        if (var2.getPointerId(var4) == this.a.k) {
                           if (var4 == 0) {
                              var3 = 1;
                           }

                           this.a.k = var2.getPointerId(var3);
                           this.a.a(var2, this.a.n, var4);
                        }
                  }
               }
            }
         }
      };
      this.l = var1;
   }

   private void a(float[] var1) {
      if ((this.n & 12) != 0) {
         var1[0] = this.i + this.g - this.b.itemView.getLeft();
      } else {
         var1[0] = this.b.itemView.getTranslationX();
      }

      if ((this.n & 3) != 0) {
         var1[1] = this.j + this.h - this.b.itemView.getTop();
      } else {
         var1[1] = this.b.itemView.getTranslationY();
      }
   }

   private static boolean a(View var0, float var1, float var2, float var3, float var4) {
      boolean var5;
      if (var1 >= var3 && var1 <= var0.getWidth() + var3 && var2 >= var4 && var2 <= var0.getHeight() + var4) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   private int b(RecyclerView.ViewHolder var1, int var2) {
      byte var6 = 8;
      if ((var2 & 12) != 0) {
         byte var5;
         if (this.g > 0.0F) {
            var5 = 8;
         } else {
            var5 = 4;
         }

         if (this.r != null && this.k > -1) {
            this.r.computeCurrentVelocity(1000, this.l.b(this.f));
            float var4 = this.r.getXVelocity(this.k);
            float var3 = this.r.getYVelocity(this.k);
            if (!(var4 > 0.0F)) {
               var6 = 4;
            }

            var4 = Math.abs(var4);
            if ((var6 & var2) != 0 && var5 == var6 && var4 >= this.l.a(this.e) && var4 > Math.abs(var3)) {
               return var6;
            }
         }

         float var7 = this.p.getWidth();
         float var9 = this.l.a(var1);
         if ((var2 & var5) != 0 && Math.abs(this.g) > var7 * var9) {
            var6 = var5;
            return var6;
         }
      }

      return 0;
   }

   private List<RecyclerView.ViewHolder> b(RecyclerView.ViewHolder var1) {
      if (this.x == null) {
         this.x = new ArrayList<>();
         this.y = new ArrayList<>();
      } else {
         this.x.clear();
         this.y.clear();
      }

      int var2 = this.l.c();
      int var6 = Math.round(this.i + this.g) - var2;
      int var7 = Math.round(this.j + this.h) - var2;
      int var5 = var1.itemView.getWidth() + var6 + var2 * 2;
      int var8 = var1.itemView.getHeight() + var7 + var2 * 2;
      int var9 = (var6 + var5) / 2;
      int var11 = (var7 + var8) / 2;
      RecyclerView.LayoutManager var14 = this.p.getLayoutManager();
      int var10 = var14.v();

      for (int var17 = 0; var17 < var10; var17++) {
         View var15 = var14.i(var17);
         if (var15 != var1.itemView && var15.getBottom() >= var7 && var15.getTop() <= var8 && var15.getRight() >= var6 && var15.getLeft() <= var5) {
            RecyclerView.ViewHolder var16 = this.p.getChildViewHolder(var15);
            if (this.l.a(this.p, this.b, var16)) {
               int var3 = Math.abs(var9 - (var15.getLeft() + var15.getRight()) / 2);
               int var4 = var15.getTop();
               var4 = Math.abs(var11 - (var15.getBottom() + var4) / 2);
               int var12 = var3 * var3 + var4 * var4;
               int var13 = this.x.size();
               var3 = 0;

               for (int var20 = 0; var20 < var13 && var12 > this.y.get(var20); var20++) {
                  var3++;
               }

               this.x.add(var3, var16);
               this.y.add(var3, var12);
            }
         }
      }

      return this.x;
   }

   private int c(RecyclerView.ViewHolder var1) {
      byte var3 = 0;
      int var2;
      if (this.m == 2) {
         var2 = var3;
      } else {
         int var5 = this.l.a(this.p, var1);
         int var4 = (this.l.d(var5, ViewCompat.e(this.p)) & 0xFF00) >> 8;
         var2 = var3;
         if (var4 != 0) {
            var5 = (var5 & 0xFF00) >> 8;
            if (Math.abs(this.g) > Math.abs(this.h)) {
               var2 = this.b(var1, var4);
               if (var2 > 0) {
                  if ((var5 & var2) == 0) {
                     var2 = ItemTouchHelper.Callback.a(var2, ViewCompat.e(this.p));
                  }
               } else {
                  var4 = this.c(var1, var4);
                  var2 = var3;
                  if (var4 > 0) {
                     var2 = var4;
                  }
               }
            } else {
               var2 = this.c(var1, var4);
               if (var2 <= 0) {
                  var4 = this.b(var1, var4);
                  var2 = var3;
                  if (var4 > 0) {
                     if ((var5 & var4) == 0) {
                        var2 = ItemTouchHelper.Callback.a(var4, ViewCompat.e(this.p));
                     } else {
                        var2 = var4;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   private int c(RecyclerView.ViewHolder var1, int var2) {
      byte var6 = 2;
      if ((var2 & 3) != 0) {
         byte var5;
         if (this.h > 0.0F) {
            var5 = 2;
         } else {
            var5 = 1;
         }

         if (this.r != null && this.k > -1) {
            this.r.computeCurrentVelocity(1000, this.l.b(this.f));
            float var3 = this.r.getXVelocity(this.k);
            float var4 = this.r.getYVelocity(this.k);
            if (!(var4 > 0.0F)) {
               var6 = 1;
            }

            var4 = Math.abs(var4);
            if ((var6 & var2) != 0 && var6 == var5 && var4 >= this.l.a(this.e) && var4 > Math.abs(var3)) {
               return var6;
            }
         }

         float var9 = this.p.getHeight();
         float var7 = this.l.a(var1);
         if ((var2 & var5) != 0 && Math.abs(this.h) > var9 * var7) {
            var6 = var5;
            return var6;
         }
      }

      return 0;
   }

   private RecyclerView.ViewHolder c(MotionEvent var1) {
      Object var8 = null;
      RecyclerView.LayoutManager var9 = this.p.getLayoutManager();
      RecyclerView.ViewHolder var7;
      if (this.k == -1) {
         var7 = (RecyclerView.ViewHolder)var8;
      } else {
         int var6 = var1.findPointerIndex(this.k);
         float var5 = var1.getX(var6);
         float var4 = this.c;
         float var3 = var1.getY(var6);
         float var2 = this.d;
         var4 = Math.abs(var5 - var4);
         var2 = Math.abs(var3 - var2);
         if (var4 < this.w) {
            var7 = (RecyclerView.ViewHolder)var8;
            if (var2 < this.w) {
               return var7;
            }
         }

         if (var4 > var2) {
            var7 = (RecyclerView.ViewHolder)var8;
            if (var9.e()) {
               return var7;
            }
         }

         if (var2 > var4) {
            var7 = (RecyclerView.ViewHolder)var8;
            if (var9.f()) {
               return var7;
            }
         }

         View var10 = this.a(var1);
         var7 = (RecyclerView.ViewHolder)var8;
         if (var10 != null) {
            var7 = this.p.getChildViewHolder(var10);
         }
      }

      return var7;
   }

   private void d() {
      this.w = ViewConfiguration.get(this.p.getContext()).getScaledTouchSlop();
      this.p.addItemDecoration(this);
      this.p.addOnItemTouchListener(this.B);
      this.p.addOnChildAttachStateChangeListener(this);
      this.f();
   }

   private void e() {
      this.p.removeItemDecoration(this);
      this.p.removeOnItemTouchListener(this.B);
      this.p.removeOnChildAttachStateChangeListener(this);

      for (int var1 = this.o.size() - 1; var1 >= 0; var1--) {
         ItemTouchHelper.RecoverAnimation var2 = this.o.get(0);
         this.l.d(this.p, var2.h);
      }

      this.o.clear();
      this.s = null;
      this.t = -1;
      this.h();
      this.g();
   }

   private void f() {
      this.A = new ItemTouchHelper.ItemTouchHelperGestureListener(this);
      this.u = new GestureDetectorCompat(this.p.getContext(), this.A);
   }

   private void g() {
      if (this.A != null) {
         this.A.a();
         this.A = null;
      }

      if (this.u != null) {
         this.u = null;
      }
   }

   private void h() {
      if (this.r != null) {
         this.r.recycle();
         this.r = null;
      }
   }

   private void i() {
      if (VERSION.SDK_INT < 21) {
         if (this.z == null) {
            this.z = new RecyclerView.ChildDrawingOrderCallback(this) {
               final ItemTouchHelper a;

               {
                  this.a = var1;
               }

               @Override
               public int a(int var1, int var2) {
                  if (this.a.s == null) {
                     var1 = var2;
                  } else {
                     int var4 = this.a.t;
                     int var3 = var4;
                     if (var4 == -1) {
                        var3 = this.a.p.indexOfChild(this.a.s);
                        this.a.t = var3;
                     }

                     if (var2 == var1 - 1) {
                        var1 = var3;
                     } else {
                        var1 = var2;
                        if (var2 >= var3) {
                           var1 = var2 + 1;
                        }
                     }
                  }

                  return var1;
               }
            };
         }

         this.p.setChildDrawingOrderCallback(this.z);
      }
   }

   int a(RecyclerView.ViewHolder var1, boolean var2) {
      int var3 = this.o.size() - 1;

      while (true) {
         if (var3 < 0) {
            var3 = 0;
            break;
         }

         ItemTouchHelper.RecoverAnimation var4 = this.o.get(var3);
         if (var4.h == var1) {
            var4.n |= var2;
            if (!var4.o) {
               var4.b();
            }

            this.o.remove(var3);
            var3 = var4.j;
            break;
         }

         var3--;
      }

      return var3;
   }

   View a(MotionEvent var1) {
      float var3 = var1.getX();
      float var2 = var1.getY();
      if (this.b != null) {
         View var6 = this.b.itemView;
         if (a(var6, var3, var2, this.i + this.g, this.j + this.h)) {
            return var6;
         }
      }

      int var4 = this.o.size() - 1;

      while (true) {
         if (var4 < 0) {
            var7 = this.p.findChildViewUnder(var3, var2);
            break;
         }

         ItemTouchHelper.RecoverAnimation var5 = this.o.get(var4);
         var7 = var5.h.itemView;
         if (a(var7, var3, var2, var5.l, var5.m)) {
            break;
         }

         var4--;
      }

      return var7;
   }

   @Override
   public void a(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      float var4 = 0.0F;
      float var5;
      if (this.b != null) {
         this.a(this.v);
         var5 = this.v[0];
         var4 = this.v[1];
      } else {
         var5 = 0.0F;
      }

      this.l.b(var1, var2, this.b, this.o, this.m, var5, var4);
   }

   @Override
   public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
      var1.setEmpty();
   }

   void a(RecyclerView.ViewHolder var1) {
      if (!this.p.isLayoutRequested() && this.m == 2) {
         float var2 = this.l.b(var1);
         int var3 = (int)(this.i + this.g);
         int var6 = (int)(this.j + this.h);
         if (!(Math.abs(var6 - var1.itemView.getTop()) < var1.itemView.getHeight() * var2)
            || !(Math.abs(var3 - var1.itemView.getLeft()) < var2 * var1.itemView.getWidth())) {
            List var7 = this.b(var1);
            if (var7.size() != 0) {
               RecyclerView.ViewHolder var8 = this.l.a(var1, var7, var3, var6);
               if (var8 == null) {
                  this.x.clear();
                  this.y.clear();
               } else {
                  int var5 = var8.getAdapterPosition();
                  int var4 = var1.getAdapterPosition();
                  if (this.l.b(this.p, var1, var8)) {
                     this.l.a(this.p, var1, var4, var8, var5, var3, var6);
                  }
               }
            }
         }
      }
   }

   void a(RecyclerView.ViewHolder var1, int var2) {
      if (var1 != this.b || var2 != this.m) {
         this.D = Long.MIN_VALUE;
         int var9 = this.m;
         this.a(var1, true);
         this.m = var2;
         if (var2 == 2) {
            this.s = var1.itemView;
            this.i();
         }

         byte var7 = 0;
         int var8 = 0;
         if (this.b != null) {
            RecyclerView.ViewHolder var11 = this.b;
            if (var11.itemView.getParent() != null) {
               if (var9 == 2) {
                  var8 = 0;
               } else {
                  var8 = this.c(var11);
               }

               this.h();
               float var3;
               float var4;
               switch (var8) {
                  case 1:
                  case 2:
                     var3 = 0.0F;
                     var4 = Math.signum(this.h) * this.p.getHeight();
                     break;
                  case 4:
                  case 8:
                  case 16:
                  case 32:
                     var4 = 0.0F;
                     var3 = Math.signum(this.g) * this.p.getWidth();
                     break;
                  default:
                     var3 = 0.0F;
                     var4 = 0.0F;
               }

               if (var9 == 2) {
                  var7 = 8;
               } else if (var8 > 0) {
                  var7 = 2;
               } else {
                  var7 = 4;
               }

               this.a(this.v);
               float var6 = this.v[0];
               float var5 = this.v[1];
               ItemTouchHelper.RecoverAnimation var15 = new ItemTouchHelper.RecoverAnimation(this, var11, var7, var9, var6, var5, var3, var4, var8, var11) {
                  final int a;
                  final RecyclerView.ViewHolder b;
                  final ItemTouchHelper c;

                  {
                     this.c = var1;
                     this.a = var9x;
                     this.b = var10;
                  }

                  @Override
                  public void onAnimationEnd(Animator var1) {
                     super.onAnimationEnd(var1);
                     if (!this.n) {
                        if (this.a <= 0) {
                           this.c.l.d(this.c.p, this.b);
                        } else {
                           this.c.a.add(this.b.itemView);
                           this.k = true;
                           if (this.a > 0) {
                              this.c.a(this, this.a);
                           }
                        }

                        if (this.c.s == this.b.itemView) {
                           this.c.c(this.b.itemView);
                        }
                     }
                  }
               };
               var15.a(this.l.a(this.p, var7, var3 - var6, var4 - var5));
               this.o.add(var15);
               var15.a();
               var7 = 1;
            } else {
               this.c(var11.itemView);
               this.l.d(this.p, var11);
               var7 = (byte)var8;
            }

            this.b = null;
         }

         if (var1 != null) {
            this.n = (this.l.b(this.p, var1) & (1 << var2 * 8 + 8) - 1) >> this.m * 8;
            this.i = var1.itemView.getLeft();
            this.j = var1.itemView.getTop();
            this.b = var1;
            if (var2 == 2) {
               this.b.itemView.performHapticFeedback(0);
            }
         }

         ViewParent var12 = this.p.getParent();
         if (var12 != null) {
            boolean var10;
            if (this.b != null) {
               var10 = true;
            } else {
               var10 = false;
            }

            var12.requestDisallowInterceptTouchEvent(var10);
         }

         if (!var7) {
            this.p.getLayoutManager().J();
         }

         this.l.b(this.b, this.m);
         this.p.invalidate();
      }
   }

   public void a(RecyclerView var1) {
      if (this.p != var1) {
         if (this.p != null) {
            this.e();
         }

         this.p = var1;
         if (var1 != null) {
            Resources var2 = var1.getResources();
            this.e = var2.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.f = var2.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            this.d();
         }
      }
   }

   void a(ItemTouchHelper.RecoverAnimation var1, int var2) {
      this.p.post(new Runnable(this, var1, var2) {
         final ItemTouchHelper.RecoverAnimation a;
         final int b;
         final ItemTouchHelper c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         @Override
         public void run() {
            if (this.c.p != null && this.c.p.isAttachedToWindow() && !this.a.n && this.a.h.getAdapterPosition() != -1) {
               RecyclerView.ItemAnimator var1x = this.c.p.getItemAnimator();
               if ((var1x == null || !var1x.a(null)) && !this.c.a()) {
                  this.c.l.a(this.a.h, this.b);
               } else {
                  this.c.p.post(this);
               }
            }
         }
      });
   }

   void a(MotionEvent var1, int var2, int var3) {
      float var4 = var1.getX(var3);
      float var5 = var1.getY(var3);
      this.g = var4 - this.c;
      this.h = var5 - this.d;
      if ((var2 & 4) == 0) {
         this.g = Math.max(0.0F, this.g);
      }

      if ((var2 & 8) == 0) {
         this.g = Math.min(0.0F, this.g);
      }

      if ((var2 & 1) == 0) {
         this.h = Math.max(0.0F, this.h);
      }

      if ((var2 & 2) == 0) {
         this.h = Math.min(0.0F, this.h);
      }
   }

   @Override
   public void a(View var1) {
   }

   boolean a() {
      int var2 = this.o.size();
      int var1 = 0;

      boolean var3;
      while (true) {
         if (var1 >= var2) {
            var3 = false;
            break;
         }

         if (!this.o.get(var1).o) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   boolean a(int var1, MotionEvent var2, int var3) {
      boolean var9 = false;
      boolean var8 = var9;
      if (this.b == null) {
         var8 = var9;
         if (var1 == 2) {
            var8 = var9;
            if (this.m != 2) {
               if (!this.l.b()) {
                  var8 = var9;
               } else {
                  var8 = var9;
                  if (this.p.getScrollState() != 1) {
                     RecyclerView.ViewHolder var10 = this.c(var2);
                     var8 = var9;
                     if (var10 != null) {
                        var1 = (this.l.b(this.p, var10) & 0xFF00) >> 8;
                        var8 = var9;
                        if (var1 != 0) {
                           float var4 = var2.getX(var3);
                           float var5 = var2.getY(var3);
                           var4 -= this.c;
                           var5 -= this.d;
                           float var6 = Math.abs(var4);
                           float var7 = Math.abs(var5);
                           if (var6 < this.w) {
                              var8 = var9;
                              if (var7 < this.w) {
                                 return var8;
                              }
                           }

                           if (var6 > var7) {
                              if (var4 < 0.0F) {
                                 var8 = var9;
                                 if ((var1 & 4) == 0) {
                                    return var8;
                                 }
                              }

                              if (var4 > 0.0F) {
                                 var8 = var9;
                                 if ((var1 & 8) == 0) {
                                    return var8;
                                 }
                              }
                           } else {
                              if (var5 < 0.0F) {
                                 var8 = var9;
                                 if ((var1 & 1) == 0) {
                                    return var8;
                                 }
                              }

                              if (var5 > 0.0F && (var1 & 2) == 0) {
                                 var8 = var9;
                                 return var8;
                              }
                           }

                           this.h = 0.0F;
                           this.g = 0.0F;
                           this.k = var2.getPointerId(0);
                           this.a(var10, 1);
                           var8 = true;
                        }
                     }
                  }
               }
            }
         }
      }

      return var8;
   }

   ItemTouchHelper.RecoverAnimation b(MotionEvent var1) {
      ItemTouchHelper.RecoverAnimation var5;
      if (this.o.isEmpty()) {
         var5 = null;
      } else {
         View var4 = this.a(var1);
         int var2 = this.o.size() - 1;

         while (true) {
            if (var2 < 0) {
               var5 = null;
               break;
            }

            ItemTouchHelper.RecoverAnimation var3 = this.o.get(var2);
            var5 = var3;
            if (var3.h.itemView == var4) {
               break;
            }

            var2--;
         }
      }

      return var5;
   }

   @Override
   public void b(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      float var4 = 0.0F;
      this.t = -1;
      float var5;
      if (this.b != null) {
         this.a(this.v);
         var5 = this.v[0];
         var4 = this.v[1];
      } else {
         var5 = 0.0F;
      }

      this.l.a(var1, var2, this.b, this.o, this.m, var5, var4);
   }

   @Override
   public void b(View var1) {
      this.c(var1);
      RecyclerView.ViewHolder var2 = this.p.getChildViewHolder(var1);
      if (var2 != null) {
         if (this.b != null && var2 == this.b) {
            this.a((RecyclerView.ViewHolder)null, 0);
         } else {
            this.a(var2, false);
            if (this.a.remove(var2.itemView)) {
               this.l.d(this.p, var2);
            }
         }
      }
   }

   boolean b() {
      boolean var8 = false;
      if (this.b == null) {
         this.D = Long.MIN_VALUE;
      } else {
         long var6 = System.currentTimeMillis();
         long var4;
         if (this.D == Long.MIN_VALUE) {
            var4 = 0L;
         } else {
            var4 = var6 - this.D;
         }

         RecyclerView.LayoutManager var9 = this.p.getLayoutManager();
         if (this.C == null) {
            this.C = new Rect();
         }

         int var1;
         label63: {
            var9.b(this.b.itemView, this.C);
            if (var9.e()) {
               int var2 = (int)(this.i + this.g);
               var1 = var2 - this.C.left - this.p.getPaddingLeft();
               if (this.g < 0.0F && var1 < 0) {
                  break label63;
               }

               if (this.g > 0.0F) {
                  var2 = var2 + this.b.itemView.getWidth() + this.C.right - (this.p.getWidth() - this.p.getPaddingRight());
                  var1 = var2;
                  if (var2 > 0) {
                     break label63;
                  }
               }
            }

            var1 = 0;
         }

         int var11;
         label54: {
            if (var9.f()) {
               int var3 = (int)(this.j + this.h);
               var11 = var3 - this.C.top - this.p.getPaddingTop();
               if (this.h < 0.0F && var11 < 0) {
                  break label54;
               }

               if (this.h > 0.0F) {
                  var3 = var3 + this.b.itemView.getHeight() + this.C.bottom - (this.p.getHeight() - this.p.getPaddingBottom());
                  var11 = var3;
                  if (var3 > 0) {
                     break label54;
                  }
               }
            }

            var11 = 0;
         }

         if (var1 != 0) {
            var1 = this.l.a(this.p, this.b.itemView.getWidth(), var1, this.p.getWidth(), var4);
         }

         if (var11 != 0) {
            var11 = this.l.a(this.p, this.b.itemView.getHeight(), var11, this.p.getHeight(), var4);
         }

         if (var1 == 0 && var11 == 0) {
            this.D = Long.MIN_VALUE;
         } else {
            if (this.D == Long.MIN_VALUE) {
               this.D = var6;
            }

            this.p.scrollBy(var1, var11);
            var8 = true;
         }
      }

      return var8;
   }

   void c() {
      if (this.r != null) {
         this.r.recycle();
      }

      this.r = VelocityTracker.obtain();
   }

   void c(View var1) {
      if (var1 == this.s) {
         this.s = null;
         if (this.z != null) {
            this.p.setChildDrawingOrderCallback(null);
         }
      }
   }

   public abstract static class Callback {
      private static final ItemTouchUIUtil a;
      private static final Interpolator b = new Interpolator() {
         public float getInterpolation(float var1) {
            return var1 * var1 * var1 * var1 * var1;
         }
      };
      private static final Interpolator c = new Interpolator() {
         public float getInterpolation(float var1) {
            return --var1 * (var1 * var1 * var1 * var1) + 1.0F;
         }
      };
      private int d = -1;

      static {
         if (VERSION.SDK_INT >= 21) {
            a = new ItemTouchUIUtilImpl.Api21Impl();
         } else {
            a = new ItemTouchUIUtilImpl.BaseImpl();
         }
      }

      public static int a(int var0, int var1) {
         int var2 = var0 & 789516;
         if (var2 != 0) {
            var0 = ~var2 & var0;
            if (var1 == 0) {
               var0 |= var2 << 2;
            } else {
               var0 = var0 | var2 << 1 & -789517 | (var2 << 1 & 789516) << 2;
            }
         }

         return var0;
      }

      private int a(RecyclerView var1) {
         if (this.d == -1) {
            this.d = var1.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
         }

         return this.d;
      }

      public static int b(int var0, int var1) {
         return c(0, var1 | var0) | c(1, var1) | c(2, var0);
      }

      public static int c(int var0, int var1) {
         return var1 << var0 * 8;
      }

      public float a(float var1) {
         return var1;
      }

      public float a(RecyclerView.ViewHolder var1) {
         return 0.5F;
      }

      public int a(RecyclerView var1, int var2, int var3, int var4, long var5) {
         float var7 = 1.0F;
         int var9 = this.a(var1);
         int var10 = Math.abs(var3);
         var4 = (int)Math.signum(var3);
         float var8 = Math.min(1.0F, var10 * 1.0F / var2);
         var2 = (int)(var9 * var4 * c.getInterpolation(var8));
         if (var5 <= 2000L) {
            var7 = (float)var5 / 2000.0F;
         }

         var8 = var2;
         var4 = (int)(b.getInterpolation(var7) * var8);
         var2 = var4;
         if (var4 == 0) {
            if (var3 > 0) {
               var2 = 1;
            } else {
               var2 = -1;
            }
         }

         return var2;
      }

      public abstract int a(RecyclerView var1, RecyclerView.ViewHolder var2);

      public long a(RecyclerView var1, int var2, float var3, float var4) {
         RecyclerView.ItemAnimator var7 = var1.getItemAnimator();
         long var5;
         if (var7 == null) {
            if (var2 == 8) {
               var5 = 200L;
            } else {
               var5 = 250L;
            }
         } else if (var2 == 8) {
            var5 = var7.e();
         } else {
            var5 = var7.g();
         }

         return var5;
      }

      public RecyclerView.ViewHolder a(RecyclerView.ViewHolder var1, List<RecyclerView.ViewHolder> var2, int var3, int var4) {
         int var8 = var1.itemView.getWidth();
         int var9 = var1.itemView.getHeight();
         RecyclerView.ViewHolder var14 = null;
         int var5 = -1;
         int var12 = var3 - var1.itemView.getLeft();
         int var11 = var4 - var1.itemView.getTop();
         int var10 = var2.size();
         int var6 = 0;

         while (var6 < var10) {
            RecyclerView.ViewHolder var13 = (RecyclerView.ViewHolder)var2.get(var6);
            if (var12 > 0) {
               int var7 = var13.itemView.getRight() - (var3 + var8);
               if (var7 < 0 && var13.itemView.getRight() > var1.itemView.getRight()) {
                  var7 = Math.abs(var7);
                  if (var7 > var5) {
                     var5 = var7;
                     var14 = var13;
                  }
               }
            }

            if (var12 < 0) {
               int var16 = var13.itemView.getLeft() - var3;
               if (var16 > 0 && var13.itemView.getLeft() < var1.itemView.getLeft()) {
                  var16 = Math.abs(var16);
                  if (var16 > var5) {
                     var14 = var13;
                     var5 = var16;
                  }
               }
            }

            if (var11 < 0) {
               int var18 = var13.itemView.getTop() - var4;
               if (var18 > 0 && var13.itemView.getTop() < var1.itemView.getTop()) {
                  var18 = Math.abs(var18);
                  if (var18 > var5) {
                     var14 = var13;
                     var5 = var18;
                  }
               }
            }

            label52: {
               if (var11 > 0) {
                  int var20 = var13.itemView.getBottom() - (var4 + var9);
                  if (var20 < 0 && var13.itemView.getBottom() > var1.itemView.getBottom()) {
                     var20 = Math.abs(var20);
                     if (var20 > var5) {
                        var5 = var20;
                        break label52;
                     }
                  }
               }

               var13 = var14;
            }

            var6++;
            var14 = var13;
         }

         return var14;
      }

      public void a(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, float var4, float var5, int var6, boolean var7) {
         a.a(var1, var2, var3.itemView, var4, var5, var6, var7);
      }

      void a(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, List<ItemTouchHelper.RecoverAnimation> var4, int var5, float var6, float var7) {
         int var9 = var4.size();

         for (int var8 = 0; var8 < var9; var8++) {
            ItemTouchHelper.RecoverAnimation var11 = (ItemTouchHelper.RecoverAnimation)var4.get(var8);
            var11.c();
            int var10 = var1.save();
            this.a(var1, var2, var11.h, var11.l, var11.m, var11.i, false);
            var1.restoreToCount(var10);
         }

         if (var3 != null) {
            int var12 = var1.save();
            this.a(var1, var2, var3, var6, var7, var5, true);
            var1.restoreToCount(var12);
         }
      }

      public abstract void a(RecyclerView.ViewHolder var1, int var2);

      public void a(RecyclerView var1, RecyclerView.ViewHolder var2, int var3, RecyclerView.ViewHolder var4, int var5, int var6, int var7) {
         RecyclerView.LayoutManager var8 = var1.getLayoutManager();
         if (var8 instanceof ItemTouchHelper.ViewDropHandler) {
            ((ItemTouchHelper.ViewDropHandler)var8).a(var2.itemView, var4.itemView, var6, var7);
         } else {
            if (var8.e()) {
               if (var8.h(var4.itemView) <= var1.getPaddingLeft()) {
                  var1.scrollToPosition(var5);
               }

               if (var8.j(var4.itemView) >= var1.getWidth() - var1.getPaddingRight()) {
                  var1.scrollToPosition(var5);
               }
            }

            if (var8.f()) {
               if (var8.i(var4.itemView) <= var1.getPaddingTop()) {
                  var1.scrollToPosition(var5);
               }

               if (var8.k(var4.itemView) >= var1.getHeight() - var1.getPaddingBottom()) {
                  var1.scrollToPosition(var5);
               }
            }
         }
      }

      public boolean a() {
         return true;
      }

      public boolean a(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3) {
         return true;
      }

      public float b(float var1) {
         return var1;
      }

      public float b(RecyclerView.ViewHolder var1) {
         return 0.5F;
      }

      final int b(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return this.d(this.a(var1, var2), ViewCompat.e(var1));
      }

      public void b(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, float var4, float var5, int var6, boolean var7) {
         a.b(var1, var2, var3.itemView, var4, var5, var6, var7);
      }

      void b(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, List<ItemTouchHelper.RecoverAnimation> var4, int var5, float var6, float var7) {
         int var9 = var4.size();

         for (int var8 = 0; var8 < var9; var8++) {
            ItemTouchHelper.RecoverAnimation var11 = (ItemTouchHelper.RecoverAnimation)var4.get(var8);
            int var10 = var1.save();
            this.b(var1, var2, var11.h, var11.l, var11.m, var11.i, false);
            var1.restoreToCount(var10);
         }

         if (var3 != null) {
            int var14 = var1.save();
            this.b(var1, var2, var3, var6, var7, var5, true);
            var1.restoreToCount(var14);
         }

         boolean var13 = false;

         for (int var15 = var9 - 1; var15 >= 0; var15--) {
            ItemTouchHelper.RecoverAnimation var12 = (ItemTouchHelper.RecoverAnimation)var4.get(var15);
            if (var12.o && !var12.k) {
               var4.remove(var15);
            } else if (!var12.o) {
               var13 = true;
            }
         }

         if (var13) {
            var2.invalidate();
         }
      }

      public void b(RecyclerView.ViewHolder var1, int var2) {
         if (var1 != null) {
            a.b(var1.itemView);
         }
      }

      public boolean b() {
         return true;
      }

      public abstract boolean b(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3);

      public int c() {
         return 0;
      }

      boolean c(RecyclerView var1, RecyclerView.ViewHolder var2) {
         boolean var3;
         if ((this.b(var1, var2) & 0xFF0000) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      public int d(int var1, int var2) {
         int var3 = var1 & 3158064;
         if (var3 != 0) {
            var1 = ~var3 & var1;
            if (var2 == 0) {
               var1 |= var3 >> 2;
            } else {
               var1 = var1 | var3 >> 1 & -3158065 | (var3 >> 1 & 3158064) >> 2;
            }
         }

         return var1;
      }

      public void d(RecyclerView var1, RecyclerView.ViewHolder var2) {
         a.a(var2.itemView);
      }
   }

   private class ItemTouchHelperGestureListener extends SimpleOnGestureListener {
      final ItemTouchHelper a;
      private boolean b;

      ItemTouchHelperGestureListener(ItemTouchHelper var1) {
         this.a = var1;
         this.b = true;
      }

      void a() {
         this.b = false;
      }

      public boolean onDown(MotionEvent var1) {
         return true;
      }

      public void onLongPress(MotionEvent var1) {
         if (this.b) {
            View var5 = this.a.a(var1);
            if (var5 != null) {
               RecyclerView.ViewHolder var7 = this.a.p.getChildViewHolder(var5);
               if (var7 != null && this.a.l.c(this.a.p, var7) && var1.getPointerId(0) == this.a.k) {
                  int var4 = var1.findPointerIndex(this.a.k);
                  float var2 = var1.getX(var4);
                  float var3 = var1.getY(var4);
                  this.a.c = var2;
                  this.a.d = var3;
                  ItemTouchHelper var6 = this.a;
                  this.a.h = 0.0F;
                  var6.g = 0.0F;
                  if (this.a.l.a()) {
                     this.a.a(var7, 2);
                  }
               }
            }
         }
      }
   }

   private static class RecoverAnimation implements AnimatorListener {
      private final ValueAnimator a;
      private float b;
      final float d;
      final float e;
      final float f;
      final float g;
      final RecyclerView.ViewHolder h;
      final int i;
      final int j;
      public boolean k;
      float l;
      float m;
      boolean n = false;
      boolean o = false;

      RecoverAnimation(RecyclerView.ViewHolder var1, int var2, int var3, float var4, float var5, float var6, float var7) {
         this.i = var3;
         this.j = var2;
         this.h = var1;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.a = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
         this.a.addUpdateListener(new AnimatorUpdateListener(this) {
            final ItemTouchHelper.RecoverAnimation a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.a(var1.getAnimatedFraction());
            }
         });
         this.a.setTarget(var1.itemView);
         this.a.addListener(this);
         this.a(0.0F);
      }

      public void a() {
         this.h.setIsRecyclable(false);
         this.a.start();
      }

      public void a(float var1) {
         this.b = var1;
      }

      public void a(long var1) {
         this.a.setDuration(var1);
      }

      public void b() {
         this.a.cancel();
      }

      public void c() {
         if (this.d == this.f) {
            this.l = this.h.itemView.getTranslationX();
         } else {
            this.l = this.d + this.b * (this.f - this.d);
         }

         if (this.e == this.g) {
            this.m = this.h.itemView.getTranslationY();
         } else {
            this.m = this.e + this.b * (this.g - this.e);
         }
      }

      public void onAnimationCancel(Animator var1) {
         this.a(1.0F);
      }

      public void onAnimationEnd(Animator var1) {
         if (!this.o) {
            this.h.setIsRecyclable(true);
         }

         this.o = true;
      }

      public void onAnimationRepeat(Animator var1) {
      }

      public void onAnimationStart(Animator var1) {
      }
   }

   public abstract static class SimpleCallback extends ItemTouchHelper.Callback {
      private int a;
      private int b;

      public SimpleCallback(int var1, int var2) {
         this.a = var2;
         this.b = var1;
      }

      @Override
      public int a(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return b(this.f(var1, var2), this.e(var1, var2));
      }

      public int e(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return this.a;
      }

      public int f(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return this.b;
      }
   }

   public interface ViewDropHandler {
      void a(View var1, View var2, int var3, int var4);
   }
}
