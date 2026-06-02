package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
   int a;
   int b;
   boolean c;
   int d = 4;
   ViewDragHelper e;
   int f;
   WeakReference<V> g;
   WeakReference<View> h;
   int i;
   boolean j;
   private float k;
   private int l;
   private boolean m;
   private int n;
   private boolean o;
   private boolean p;
   private int q;
   private boolean r;
   private BottomSheetBehavior.BottomSheetCallback s;
   private VelocityTracker t;
   private int u;
   private final ViewDragHelper.Callback v = new ViewDragHelper.Callback(this) {
      final BottomSheetBehavior a;

      {
         this.a = var1;
      }

      @Override
      public int a(View var1) {
         int var2;
         if (this.a.c) {
            var2 = this.a.f - this.a.a;
         } else {
            var2 = this.a.b - this.a.a;
         }

         return var2;
      }

      @Override
      public int a(View var1, int var2, int var3) {
         int var4 = this.a.a;
         if (this.a.c) {
            var3 = this.a.f;
         } else {
            var3 = this.a.b;
         }

         return MathUtils.a(var2, var4, var3);
      }

      @Override
      public void a(int var1) {
         if (var1 == 1) {
            this.a.c(1);
         }
      }

      @Override
      public void a(View var1, float var2, float var3) {
         byte var5 = 3;
         int var4;
         if (var3 < 0.0F) {
            var4 = this.a.a;
         } else if (this.a.c && this.a.a(var1, var3)) {
            var4 = this.a.f;
            var5 = 5;
         } else if (var3 == 0.0F) {
            var4 = var1.getTop();
            if (Math.abs(var4 - this.a.a) < Math.abs(var4 - this.a.b)) {
               var4 = this.a.a;
            } else {
               var4 = this.a.b;
               var5 = 4;
            }
         } else {
            var4 = this.a.b;
            var5 = 4;
         }

         if (this.a.e.a(var1.getLeft(), var4)) {
            this.a.c(2);
            ViewCompat.a(var1, this.a.new SettleRunnable(this.a, var1, var5));
         } else {
            this.a.c(var5);
         }
      }

      @Override
      public void a(View var1, int var2, int var3, int var4, int var5) {
         this.a.d(var3);
      }

      @Override
      public boolean a(View var1, int var2) {
         boolean var4 = false;
         boolean var3;
         if (this.a.d == 1) {
            var3 = var4;
         } else {
            var3 = var4;
            if (!this.a.j) {
               if (this.a.d == 3 && this.a.i == var2) {
                  View var5 = this.a.h.get();
                  if (var5 != null) {
                     var3 = var4;
                     if (var5.canScrollVertically(-1)) {
                        return var3;
                     }
                  }
               }

               if (this.a.g != null && this.a.g.get() == var1) {
                  var3 = true;
               } else {
                  var3 = false;
               }
            }
         }

         return var3;
      }

      @Override
      public int b(View var1, int var2, int var3) {
         return var1.getLeft();
      }
   };

   public BottomSheetBehavior() {
   }

   public BottomSheetBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.BottomSheetBehavior_Layout);
      TypedValue var3 = var4.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
      if (var3 != null && var3.data == -1) {
         this.a(var3.data);
      } else {
         this.a(var4.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
      }

      this.a(var4.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
      this.b(var4.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
      var4.recycle();
      this.k = ViewConfiguration.get(var1).getScaledMaximumFlingVelocity();
   }

   private void a() {
      this.i = -1;
      if (this.t != null) {
         this.t.recycle();
         this.t = null;
      }
   }

   private float b() {
      this.t.computeCurrentVelocity(1000, this.k);
      return this.t.getYVelocity(this.i);
   }

   public static <V extends View> BottomSheetBehavior<V> b(V var0) {
      LayoutParams var1 = var0.getLayoutParams();
      if (!(var1 instanceof CoordinatorLayout.LayoutParams)) {
         throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
      } else {
         CoordinatorLayout.Behavior var2 = ((CoordinatorLayout.LayoutParams)var1).b();
         if (!(var2 instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
         } else {
            return (BottomSheetBehavior<V>)var2;
         }
      }
   }

   View a(View var1) {
      if (!ViewCompat.w(var1)) {
         if (var1 instanceof ViewGroup) {
            ViewGroup var4 = (ViewGroup)var1;
            int var3 = var4.getChildCount();

            for (int var2 = 0; var2 < var3; var2++) {
               var1 = this.a(var4.getChildAt(var2));
               if (var1 != null) {
                  return var1;
               }
            }
         }

         var1 = null;
      }

      return var1;
   }

   public final void a(int var1) {
      label29: {
         boolean var2 = true;
         if (var1 == -1) {
            if (!this.m) {
               this.m = true;
               var4 = var2;
               break label29;
            }
         } else if (this.m || this.l != var1) {
            this.m = false;
            this.l = Math.max(0, var1);
            this.b = this.f - var1;
            var4 = var2;
            break label29;
         }

         var4 = false;
      }

      if (var4 && this.d == 4 && this.g != null) {
         View var3 = this.g.get();
         if (var3 != null) {
            var3.requestLayout();
         }
      }
   }

   public void a(BottomSheetBehavior.BottomSheetCallback var1) {
      this.s = var1;
   }

   @Override
   public void a(CoordinatorLayout var1, V var2, Parcelable var3) {
      var3 = var3;
      super.a(var1, (V)var2, var3.a());
      if (var3.a != 1 && var3.a != 2) {
         this.d = var3.a;
      } else {
         this.d = 4;
      }
   }

   @Override
   public void a(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int[] var6) {
      if (var3 == this.h.get()) {
         int var7 = var2.getTop();
         var4 = var7 - var5;
         if (var5 > 0) {
            if (var4 < this.a) {
               var6[1] = var7 - this.a;
               ViewCompat.c(var2, -var6[1]);
               this.c(3);
            } else {
               var6[1] = var5;
               ViewCompat.c(var2, -var5);
               this.c(1);
            }
         } else if (var5 < 0 && !var3.canScrollVertically(-1)) {
            if (var4 > this.b && !this.c) {
               var6[1] = var7 - this.b;
               ViewCompat.c(var2, -var6[1]);
               this.c(4);
            } else {
               var6[1] = var5;
               ViewCompat.c(var2, -var5);
               this.c(1);
            }
         }

         this.d(var2.getTop());
         this.q = var5;
         this.r = true;
      }
   }

   void a(View var1, int var2) {
      int var3;
      if (var2 == 4) {
         var3 = this.b;
      } else if (var2 == 3) {
         var3 = this.a;
      } else {
         if (!this.c || var2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + var2);
         }

         var3 = this.f;
      }

      if (this.e.a(var1, var1.getLeft(), var3)) {
         this.c(2);
         ViewCompat.a(var1, new BottomSheetBehavior.SettleRunnable(this, var1, var2));
      } else {
         this.c(var2);
      }
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, int var3) {
      if (ViewCompat.r(var1) && !ViewCompat.r(var2)) {
         ViewCompat.b(var2, true);
      }

      int var4 = var2.getTop();
      var1.a(var2, var3);
      this.f = var1.getHeight();
      if (this.m) {
         if (this.n == 0) {
            this.n = var1.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
         }

         var3 = Math.max(this.n, this.f - var1.getWidth() * 9 / 16);
      } else {
         var3 = this.l;
      }

      this.a = Math.max(0, this.f - var2.getHeight());
      this.b = Math.max(this.f - var3, this.a);
      if (this.d == 3) {
         ViewCompat.c(var2, this.a);
      } else if (this.c && this.d == 5) {
         ViewCompat.c(var2, this.f);
      } else if (this.d == 4) {
         ViewCompat.c(var2, this.b);
      } else if (this.d == 1 || this.d == 2) {
         ViewCompat.c(var2, var4 - var2.getTop());
      }

      if (this.e == null) {
         this.e = ViewDragHelper.a(var1, this.v);
      }

      this.g = new WeakReference<>((V)var2);
      this.h = new WeakReference<>(this.a(var2));
      return true;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, MotionEvent var3) {
      boolean var7 = true;
      boolean var6 = false;
      if (!var2.isShown()) {
         this.p = true;
      } else {
         int var4 = var3.getActionMasked();
         if (var4 == 0) {
            this.a();
         }

         if (this.t == null) {
            this.t = VelocityTracker.obtain();
         }

         this.t.addMovement(var3);
         switch (var4) {
            case 0:
               int var5 = (int)var3.getX();
               this.u = (int)var3.getY();
               View var8;
               if (this.h != null) {
                  var8 = this.h.get();
               } else {
                  var8 = null;
               }

               if (var8 != null && var1.a(var8, var5, this.u)) {
                  this.i = var3.getPointerId(var3.getActionIndex());
                  this.j = true;
               }

               if (this.i == -1 && !var1.a(var2, var5, this.u)) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               this.p = var6;
               break;
            case 1:
            case 3:
               this.j = false;
               this.i = -1;
               if (this.p) {
                  this.p = false;
                  return var6;
               }
            case 2:
         }

         if (!this.p && this.e.a(var3)) {
            var6 = true;
         } else {
            var2 = this.h.get();
            if (var4 == 2
               && var2 != null
               && !this.p
               && this.d != 1
               && !var1.a(var2, (int)var3.getX(), (int)var3.getY())
               && Math.abs(this.u - var3.getY()) > this.e.d()) {
               var6 = var7;
            } else {
               var6 = false;
            }
         }
      }

      return var6;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, View var3, float var4, float var5) {
      boolean var6;
      if (var3 != this.h.get() || this.d == 3 && !super.a(var1, (V)var2, var3, var4, var5)) {
         var6 = false;
      } else {
         var6 = true;
      }

      return var6;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
      boolean var6 = false;
      this.q = 0;
      this.r = false;
      if ((var5 & 2) != 0) {
         var6 = true;
      }

      return var6;
   }

   boolean a(View var1, float var2) {
      boolean var3 = true;
      if (!this.o) {
         if (var1.getTop() < this.b) {
            var3 = false;
         } else if (!(Math.abs(var1.getTop() + 0.1F * var2 - this.b) / this.l > 0.5F)) {
            var3 = false;
         }
      }

      return var3;
   }

   @Override
   public Parcelable b(CoordinatorLayout var1, V var2) {
      return new BottomSheetBehavior.SavedState(super.b(var1, (V)var2), this.d);
   }

   public final void b(int var1) {
      if (var1 != this.d) {
         if (this.g == null) {
            if (var1 == 4 || var1 == 3 || this.c && var1 == 5) {
               this.d = var1;
            }
         } else {
            View var3 = this.g.get();
            if (var3 != null) {
               ViewParent var2 = var3.getParent();
               if (var2 != null && var2.isLayoutRequested() && ViewCompat.B(var3)) {
                  var3.post(new Runnable(this, var3, var1) {
                     final View a;
                     final int b;
                     final BottomSheetBehavior c;

                     {
                        this.c = var1;
                        this.a = var2x;
                        this.b = var3x;
                     }

                     @Override
                     public void run() {
                        this.c.a(this.a, this.b);
                     }
                  });
               } else {
                  this.a(var3, var1);
               }
            }
         }
      }
   }

   public void b(boolean var1) {
      this.o = var1;
   }

   @Override
   public boolean b(CoordinatorLayout var1, V var2, MotionEvent var3) {
      boolean var6 = true;
      boolean var5;
      if (!var2.isShown()) {
         var5 = false;
      } else {
         int var4 = var3.getActionMasked();
         if (this.d == 1) {
            var5 = var6;
            if (var4 == 0) {
               return var5;
            }
         }

         if (this.e != null) {
            this.e.b(var3);
         }

         if (var4 == 0) {
            this.a();
         }

         if (this.t == null) {
            this.t = VelocityTracker.obtain();
         }

         this.t.addMovement(var3);
         if (var4 == 2 && !this.p && Math.abs(this.u - var3.getY()) > this.e.d()) {
            this.e.a(var2, var3.getPointerId(var3.getActionIndex()));
         }

         var5 = var6;
         if (this.p) {
            var5 = false;
         }
      }

      return var5;
   }

   void c(int var1) {
      if (this.d != var1) {
         this.d = var1;
         View var2 = this.g.get();
         if (var2 != null && this.s != null) {
            this.s.a(var2, var1);
         }
      }
   }

   @Override
   public void c(CoordinatorLayout var1, V var2, View var3) {
      byte var5 = 3;
      if (var2.getTop() == this.a) {
         this.c(3);
      } else if (this.h != null && var3 == this.h.get() && this.r) {
         int var6;
         if (this.q > 0) {
            var6 = this.a;
         } else if (this.c && this.a(var2, this.b())) {
            var6 = this.f;
            var5 = 5;
         } else if (this.q == 0) {
            var6 = var2.getTop();
            if (Math.abs(var6 - this.a) < Math.abs(var6 - this.b)) {
               var6 = this.a;
            } else {
               var6 = this.b;
               var5 = 4;
            }
         } else {
            var6 = this.b;
            var5 = 4;
         }

         if (this.e.a(var2, var2.getLeft(), var6)) {
            this.c(2);
            ViewCompat.a(var2, new BottomSheetBehavior.SettleRunnable(this, var2, var5));
         } else {
            this.c(var5);
         }

         this.r = false;
      }
   }

   void d(int var1) {
      View var2 = this.g.get();
      if (var2 != null && this.s != null) {
         if (var1 > this.b) {
            this.s.a(var2, (float)(this.b - var1) / (this.f - this.b));
         } else {
            this.s.a(var2, (float)(this.b - var1) / (this.b - this.a));
         }
      }
   }

   public abstract static class BottomSheetCallback {
      public abstract void a(View var1, float var2);

      public abstract void a(View var1, int var2);
   }

   protected static class SavedState extends AbsSavedState {
      public static final Creator<BottomSheetBehavior.SavedState> CREATOR = new ClassLoaderCreator<BottomSheetBehavior.SavedState>() {
         public BottomSheetBehavior.SavedState a(Parcel var1) {
            return new BottomSheetBehavior.SavedState(var1, null);
         }

         public BottomSheetBehavior.SavedState a(Parcel var1, ClassLoader var2) {
            return new BottomSheetBehavior.SavedState(var1, var2);
         }

         public BottomSheetBehavior.SavedState[] a(int var1) {
            return new BottomSheetBehavior.SavedState[var1];
         }
      };
      final int a;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a = var1.readInt();
      }

      public SavedState(Parcelable var1, int var2) {
         super(var1);
         this.a = var2;
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.a);
      }
   }

   private class SettleRunnable implements Runnable {
      final BottomSheetBehavior a;
      private final View b;
      private final int c;

      SettleRunnable(BottomSheetBehavior var1, View var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public void run() {
         if (this.a.e != null && this.a.e.a(true)) {
            ViewCompat.a(this.b, this);
         } else {
            this.a.c(this.c);
         }
      }
   }
}
