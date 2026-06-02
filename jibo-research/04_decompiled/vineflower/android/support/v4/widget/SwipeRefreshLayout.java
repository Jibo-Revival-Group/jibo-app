package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
   private static final int[] D = new int[]{16842766};
   private static final String m = SwipeRefreshLayout.class.getSimpleName();
   private int A;
   private boolean B;
   private final DecelerateInterpolator C;
   private int E;
   private Animation F;
   private Animation G;
   private Animation H;
   private Animation I;
   private Animation J;
   private int K;
   private SwipeRefreshLayout.OnChildScrollUpCallback L;
   private AnimationListener M;
   private final Animation N;
   private final Animation O;
   SwipeRefreshLayout.OnRefreshListener a;
   boolean b = false;
   int c;
   boolean d;
   CircleImageView e;
   protected int f;
   float g;
   protected int h;
   int i;
   CircularProgressDrawable j;
   boolean k;
   boolean l;
   private View n;
   private int o;
   private float p = -1.0F;
   private float q;
   private final NestedScrollingParentHelper r;
   private final NestedScrollingChildHelper s;
   private final int[] t = new int[2];
   private final int[] u = new int[2];
   private boolean v;
   private int w;
   private float x;
   private float y;
   private boolean z;

   public SwipeRefreshLayout(Context var1) {
      this(var1, null);
   }

   public SwipeRefreshLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.A = -1;
      this.E = -1;
      this.M = new AnimationListener(this) {
         final SwipeRefreshLayout a;

         {
            this.a = var1;
         }

         public void onAnimationEnd(Animation var1) {
            if (this.a.b) {
               this.a.j.setAlpha(255);
               this.a.j.start();
               if (this.a.k && this.a.a != null) {
                  this.a.a.n_();
               }

               this.a.c = this.a.e.getTop();
            } else {
               this.a.a();
            }
         }

         public void onAnimationRepeat(Animation var1) {
         }

         public void onAnimationStart(Animation var1) {
         }
      };
      this.N = new Animation(this) {
         final SwipeRefreshLayout a;

         {
            this.a = var1;
         }

         public void applyTransformation(float var1, Transformation var2x) {
            int var3;
            if (!this.a.l) {
               var3 = this.a.i - Math.abs(this.a.h);
            } else {
               var3 = this.a.i;
            }

            int var4 = this.a.f;
            var3 = (int)((var3 - this.a.f) * var1);
            int var5 = this.a.e.getTop();
            this.a.setTargetOffsetTopAndBottom(var3 + var4 - var5);
            this.a.j.b(1.0F - var1);
         }
      };
      this.O = new Animation(this) {
         final SwipeRefreshLayout a;

         {
            this.a = var1;
         }

         public void applyTransformation(float var1, Transformation var2) {
            this.a.a(var1);
         }
      };
      this.o = ViewConfiguration.get(var1).getScaledTouchSlop();
      this.w = this.getResources().getInteger(17694721);
      this.setWillNotDraw(false);
      this.C = new DecelerateInterpolator(2.0F);
      DisplayMetrics var4 = this.getResources().getDisplayMetrics();
      this.K = (int)(40.0F * var4.density);
      this.c();
      this.setChildrenDrawingOrderEnabled(true);
      this.i = (int)(var4.density * 64.0F);
      this.p = this.i;
      this.r = new NestedScrollingParentHelper(this);
      this.s = new NestedScrollingChildHelper(this);
      this.setNestedScrollingEnabled(true);
      int var3 = -this.K;
      this.c = var3;
      this.h = var3;
      this.a(1.0F);
      TypedArray var5 = var1.obtainStyledAttributes(var2, D);
      this.setEnabled(var5.getBoolean(0, true));
      var5.recycle();
   }

   private Animation a(int var1, int var2) {
      Animation var3 = new Animation(this, var1, var2) {
         final int a;
         final int b;
         final SwipeRefreshLayout c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         public void applyTransformation(float var1, Transformation var2x) {
            this.c.j.setAlpha((int)(this.a + (this.b - this.a) * var1));
         }
      };
      var3.setDuration(300L);
      this.e.a(null);
      this.e.clearAnimation();
      this.e.startAnimation(var3);
      return var3;
   }

   private void a(int var1, AnimationListener var2) {
      this.f = var1;
      this.N.reset();
      this.N.setDuration(200L);
      this.N.setInterpolator(this.C);
      if (var2 != null) {
         this.e.a(var2);
      }

      this.e.clearAnimation();
      this.e.startAnimation(this.N);
   }

   private void a(MotionEvent var1) {
      int var2 = var1.getActionIndex();
      if (var1.getPointerId(var2) == this.A) {
         byte var3;
         if (var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.A = var1.getPointerId(var3);
      }
   }

   private void a(boolean var1, boolean var2) {
      if (this.b != var1) {
         this.k = var2;
         this.f();
         this.b = var1;
         if (this.b) {
            this.a(this.c, this.M);
         } else {
            this.a(this.M);
         }
      }
   }

   private boolean a(Animation var1) {
      boolean var2;
      if (var1 != null && var1.hasStarted() && !var1.hasEnded()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private void b(float var1) {
      this.j.a(true);
      float var3 = Math.min(1.0F, Math.abs(var1 / this.p));
      float var4 = (float)Math.max(var3 - 0.4, 0.0) * 5.0F / 3.0F;
      float var5 = Math.abs(var1);
      float var6 = this.p;
      float var2;
      if (this.l) {
         var2 = this.i - this.h;
      } else {
         var2 = this.i;
      }

      var5 = Math.max(0.0F, Math.min(var5 - var6, var2 * 2.0F) / var2);
      var5 = (float)(var5 / 4.0F - Math.pow(var5 / 4.0F, 2.0)) * 2.0F;
      int var8 = this.h;
      int var7 = (int)(var2 * var3 + var2 * var5 * 2.0F);
      if (this.e.getVisibility() != 0) {
         this.e.setVisibility(0);
      }

      if (!this.d) {
         this.e.setScaleX(1.0F);
         this.e.setScaleY(1.0F);
      }

      if (this.d) {
         this.setAnimationProgress(Math.min(1.0F, var1 / this.p));
      }

      if (var1 < this.p) {
         if (this.j.getAlpha() > 76 && !this.a(this.H)) {
            this.d();
         }
      } else if (this.j.getAlpha() < 255 && !this.a(this.I)) {
         this.e();
      }

      this.j.a(0.0F, Math.min(0.8F, var4 * 0.8F));
      this.j.b(Math.min(1.0F, var4));
      this.j.c((-0.25F + var4 * 0.4F + var5 * 2.0F) * 0.5F);
      this.setTargetOffsetTopAndBottom(var7 + var8 - this.c);
   }

   private void b(int var1, AnimationListener var2) {
      if (this.d) {
         this.c(var1, var2);
      } else {
         this.f = var1;
         this.O.reset();
         this.O.setDuration(200L);
         this.O.setInterpolator(this.C);
         if (var2 != null) {
            this.e.a(var2);
         }

         this.e.clearAnimation();
         this.e.startAnimation(this.O);
      }
   }

   private void b(AnimationListener var1) {
      this.e.setVisibility(0);
      this.j.setAlpha(255);
      this.F = new Animation(this) {
         final SwipeRefreshLayout a;

         {
            this.a = var1;
         }

         public void applyTransformation(float var1, Transformation var2) {
            this.a.setAnimationProgress(var1);
         }
      };
      this.F.setDuration(this.w);
      if (var1 != null) {
         this.e.a(var1);
      }

      this.e.clearAnimation();
      this.e.startAnimation(this.F);
   }

   private void c() {
      this.e = new CircleImageView(this.getContext(), -328966);
      this.j = new CircularProgressDrawable(this.getContext());
      this.j.a(1);
      this.e.setImageDrawable(this.j);
      this.e.setVisibility(8);
      this.addView(this.e);
   }

   private void c(float var1) {
      if (var1 > this.p) {
         this.a(true, true);
      } else {
         this.b = false;
         this.j.a(0.0F, 0.0F);
         AnimationListener var2 = null;
         if (!this.d) {
            var2 = new AnimationListener(this) {
               final SwipeRefreshLayout a;

               {
                  this.a = var1;
               }

               public void onAnimationEnd(Animation var1) {
                  if (!this.a.d) {
                     this.a.a(null);
                  }
               }

               public void onAnimationRepeat(Animation var1) {
               }

               public void onAnimationStart(Animation var1) {
               }
            };
         }

         this.b(this.c, var2);
         this.j.a(false);
      }
   }

   private void c(int var1, AnimationListener var2) {
      this.f = var1;
      this.g = this.e.getScaleX();
      this.J = new Animation(this) {
         final SwipeRefreshLayout a;

         {
            this.a = var1;
         }

         public void applyTransformation(float var1, Transformation var2x) {
            float var4 = this.a.g;
            float var3 = -this.a.g;
            this.a.setAnimationProgress(var4 + var3 * var1);
            this.a.a(var1);
         }
      };
      this.J.setDuration(150L);
      if (var2 != null) {
         this.e.a(var2);
      }

      this.e.clearAnimation();
      this.e.startAnimation(this.J);
   }

   private void d() {
      this.H = this.a(this.j.getAlpha(), 76);
   }

   private void d(float var1) {
      if (var1 - this.y > this.o && !this.z) {
         this.x = this.y + this.o;
         this.z = true;
         this.j.setAlpha(76);
      }
   }

   private void e() {
      this.I = this.a(this.j.getAlpha(), 255);
   }

   private void f() {
      if (this.n == null) {
         for (int var1 = 0; var1 < this.getChildCount(); var1++) {
            View var2 = this.getChildAt(var1);
            if (!var2.equals(this.e)) {
               this.n = var2;
               break;
            }
         }
      }
   }

   private void setColorViewAlpha(int var1) {
      this.e.getBackground().setAlpha(var1);
      this.j.setAlpha(var1);
   }

   void a() {
      this.e.clearAnimation();
      this.j.stop();
      this.e.setVisibility(8);
      this.setColorViewAlpha(255);
      if (this.d) {
         this.setAnimationProgress(0.0F);
      } else {
         this.setTargetOffsetTopAndBottom(this.h - this.c);
      }

      this.c = this.e.getTop();
   }

   void a(float var1) {
      this.setTargetOffsetTopAndBottom(this.f + (int)((this.h - this.f) * var1) - this.e.getTop());
   }

   void a(AnimationListener var1) {
      this.G = new Animation(this) {
         final SwipeRefreshLayout a;

         {
            this.a = var1;
         }

         public void applyTransformation(float var1, Transformation var2) {
            this.a.setAnimationProgress(1.0F - var1);
         }
      };
      this.G.setDuration(150L);
      this.e.a(var1);
      this.e.clearAnimation();
      this.e.startAnimation(this.G);
   }

   public boolean b() {
      boolean var1;
      if (this.L != null) {
         var1 = this.L.a(this, this.n);
      } else if (this.n instanceof ListView) {
         var1 = ListViewCompat.b((ListView)this.n, -1);
      } else {
         var1 = this.n.canScrollVertically(-1);
      }

      return var1;
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.s.a(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.s.a(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.s.a(var1, var2, var3, var4);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.s.a(var1, var2, var3, var4, var5);
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      if (this.E < 0) {
         var1 = var2;
      } else if (var2 == var1 - 1) {
         var1 = this.E;
      } else {
         var1 = var2;
         if (var2 >= this.E) {
            var1 = var2 + 1;
         }
      }

      return var1;
   }

   public int getNestedScrollAxes() {
      return this.r.a();
   }

   public int getProgressCircleDiameter() {
      return this.K;
   }

   public int getProgressViewEndOffset() {
      return this.i;
   }

   public int getProgressViewStartOffset() {
      return this.h;
   }

   public boolean hasNestedScrollingParent() {
      return this.s.b();
   }

   @Override
   public boolean isNestedScrollingEnabled() {
      return this.s.a();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.a();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var4 = false;
      this.f();
      int var2 = var1.getActionMasked();
      if (this.B && var2 == 0) {
         this.B = false;
      }

      boolean var3 = var4;
      if (this.isEnabled()) {
         var3 = var4;
         if (!this.B) {
            var3 = var4;
            if (!this.b()) {
               var3 = var4;
               if (!this.b) {
                  if (this.v) {
                     var3 = var4;
                  } else {
                     switch (var2) {
                        case 0:
                           this.setTargetOffsetTopAndBottom(this.h - this.e.getTop());
                           this.A = var1.getPointerId(0);
                           this.z = false;
                           var2 = var1.findPointerIndex(this.A);
                           var3 = var4;
                           if (var2 < 0) {
                              return var3;
                           }

                           this.y = var1.getY(var2);
                           break;
                        case 1:
                        case 3:
                           this.z = false;
                           this.A = -1;
                           break;
                        case 2:
                           if (this.A == -1) {
                              Log.e(m, "Got ACTION_MOVE event but don't have an active pointer id.");
                              var3 = var4;
                              return var3;
                           }

                           var2 = var1.findPointerIndex(this.A);
                           var3 = var4;
                           if (var2 < 0) {
                              return var3;
                           }

                           this.d(var1.getY(var2));
                        case 4:
                        case 5:
                        default:
                           break;
                        case 6:
                           this.a(var1);
                     }

                     var3 = this.z;
                  }
               }
            }
         }
      }

      return var3;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var2 = this.getMeasuredWidth();
      var5 = this.getMeasuredHeight();
      if (this.getChildCount() != 0) {
         if (this.n == null) {
            this.f();
         }

         if (this.n != null) {
            View var6 = this.n;
            var4 = this.getPaddingLeft();
            var3 = this.getPaddingTop();
            var6.layout(var4, var3, var2 - this.getPaddingLeft() - this.getPaddingRight() + var4, var5 - this.getPaddingTop() - this.getPaddingBottom() + var3);
            var3 = this.e.getMeasuredWidth();
            var4 = this.e.getMeasuredHeight();
            this.e.layout(var2 / 2 - var3 / 2, this.c, var2 / 2 + var3 / 2, this.c + var4);
         }
      }
   }

   public void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if (this.n == null) {
         this.f();
      }

      if (this.n != null) {
         this.n
            .measure(
               MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 1073741824),
               MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 1073741824)
            );
         this.e.measure(MeasureSpec.makeMeasureSpec(this.K, 1073741824), MeasureSpec.makeMeasureSpec(this.K, 1073741824));
         this.E = -1;

         for (int var3 = 0; var3 < this.getChildCount(); var3++) {
            if (this.getChildAt(var3) == this.e) {
               this.E = var3;
               break;
            }
         }
      }
   }

   @Override
   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      return this.dispatchNestedFling(var2, var3, var4);
   }

   @Override
   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return this.dispatchNestedPreFling(var2, var3);
   }

   @Override
   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
      if (var3 > 0 && this.q > 0.0F) {
         if (var3 > this.q) {
            var4[1] = var3 - (int)this.q;
            this.q = 0.0F;
         } else {
            this.q -= var3;
            var4[1] = var3;
         }

         this.b(this.q);
      }

      if (this.l && var3 > 0 && this.q == 0.0F && Math.abs(var3 - var4[1]) > 0) {
         this.e.setVisibility(8);
      }

      int[] var5 = this.t;
      if (this.dispatchNestedPreScroll(var2 - var4[0], var3 - var4[1], var5, null)) {
         var4[0] += var5[0];
         var2 = var4[1];
         var4[1] = var5[1] + var2;
      }
   }

   @Override
   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      this.dispatchNestedScroll(var2, var3, var4, var5, this.u);
      var2 = this.u[1] + var5;
      if (var2 < 0 && !this.b()) {
         float var6 = this.q;
         this.q = Math.abs(var2) + var6;
         this.b(this.q);
      }
   }

   @Override
   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.r.a(var1, var2, var3);
      this.startNestedScroll(var3 & 2);
      this.q = 0.0F;
      this.v = true;
   }

   @Override
   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      boolean var4;
      if (this.isEnabled() && !this.B && !this.b && (var3 & 2) != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public void onStopNestedScroll(View var1) {
      this.r.a(var1);
      this.v = false;
      if (this.q > 0.0F) {
         this.c(this.q);
         this.q = 0.0F;
      }

      this.stopNestedScroll();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var6 = false;
      int var4 = var1.getActionMasked();
      if (this.B && var4 == 0) {
         this.B = false;
      }

      boolean var5 = var6;
      if (this.isEnabled()) {
         var5 = var6;
         if (!this.B) {
            var5 = var6;
            if (!this.b()) {
               var5 = var6;
               if (!this.b) {
                  if (this.v) {
                     var5 = var6;
                  } else {
                     var5 = var6;
                     switch (var4) {
                        case 0:
                           this.A = var1.getPointerId(0);
                           this.z = false;
                           break;
                        case 1:
                           var4 = var1.findPointerIndex(this.A);
                           if (var4 < 0) {
                              Log.e(m, "Got ACTION_UP event but don't have an active pointer id.");
                              var5 = var6;
                           } else {
                              if (this.z) {
                                 float var3 = var1.getY(var4);
                                 float var8 = this.x;
                                 this.z = false;
                                 this.c((var3 - var8) * 0.5F);
                              }

                              this.A = -1;
                              var5 = var6;
                           }

                           return var5;
                        case 2:
                           var4 = var1.findPointerIndex(this.A);
                           if (var4 < 0) {
                              Log.e(m, "Got ACTION_MOVE event but have an invalid active pointer id.");
                              return var6;
                           } else {
                              float var2 = var1.getY(var4);
                              this.d(var2);
                              if (this.z) {
                                 var2 = (var2 - this.x) * 0.5F;
                                 var5 = var6;
                                 if (!(var2 > 0.0F)) {
                                    return var5;
                                 }

                                 this.b(var2);
                              }
                              break;
                           }
                        case 3:
                           return var5;
                        case 4:
                        default:
                           break;
                        case 5:
                           var4 = var1.getActionIndex();
                           if (var4 < 0) {
                              Log.e(m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                              return var6;
                           }

                           this.A = var1.getPointerId(var4);
                           break;
                        case 6:
                           this.a(var1);
                     }

                     var5 = true;
                  }
               }
            }
         }
      }

      return var5;
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      if ((VERSION.SDK_INT >= 21 || !(this.n instanceof AbsListView)) && (this.n == null || ViewCompat.w(this.n))) {
         super.requestDisallowInterceptTouchEvent(var1);
      }
   }

   void setAnimationProgress(float var1) {
      this.e.setScaleX(var1);
      this.e.setScaleY(var1);
   }

   @Deprecated
   public void setColorScheme(int... var1) {
      this.setColorSchemeResources(var1);
   }

   public void setColorSchemeColors(int... var1) {
      this.f();
      this.j.a(var1);
   }

   public void setColorSchemeResources(int... var1) {
      Context var3 = this.getContext();
      int[] var4 = new int[var1.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var4[var2] = ContextCompat.c(var3, var1[var2]);
      }

      this.setColorSchemeColors(var4);
   }

   public void setDistanceToTriggerSync(int var1) {
      this.p = var1;
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      if (!var1) {
         this.a();
      }
   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.s.a(var1);
   }

   public void setOnChildScrollUpCallback(SwipeRefreshLayout.OnChildScrollUpCallback var1) {
      this.L = var1;
   }

   public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener var1) {
      this.a = var1;
   }

   @Deprecated
   public void setProgressBackgroundColor(int var1) {
      this.setProgressBackgroundColorSchemeResource(var1);
   }

   public void setProgressBackgroundColorSchemeColor(int var1) {
      this.e.setBackgroundColor(var1);
   }

   public void setProgressBackgroundColorSchemeResource(int var1) {
      this.setProgressBackgroundColorSchemeColor(ContextCompat.c(this.getContext(), var1));
   }

   public void setRefreshing(boolean var1) {
      if (var1 && this.b != var1) {
         this.b = var1;
         int var2;
         if (!this.l) {
            var2 = this.i + this.h;
         } else {
            var2 = this.i;
         }

         this.setTargetOffsetTopAndBottom(var2 - this.c);
         this.k = false;
         this.b(this.M);
      } else {
         this.a(var1, false);
      }
   }

   public void setSize(int var1) {
      if (var1 == 0 || var1 == 1) {
         DisplayMetrics var2 = this.getResources().getDisplayMetrics();
         if (var1 == 0) {
            this.K = (int)(var2.density * 56.0F);
         } else {
            this.K = (int)(var2.density * 40.0F);
         }

         this.e.setImageDrawable(null);
         this.j.a(var1);
         this.e.setImageDrawable(this.j);
      }
   }

   void setTargetOffsetTopAndBottom(int var1) {
      this.e.bringToFront();
      ViewCompat.c(this.e, var1);
      this.c = this.e.getTop();
   }

   public boolean startNestedScroll(int var1) {
      return this.s.b(var1);
   }

   @Override
   public void stopNestedScroll() {
      this.s.c();
   }

   public interface OnChildScrollUpCallback {
      boolean a(SwipeRefreshLayout var1, View var2);
   }

   public interface OnRefreshListener {
      void n_();
   }
}
