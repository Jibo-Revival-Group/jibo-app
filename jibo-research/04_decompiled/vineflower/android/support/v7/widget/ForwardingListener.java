package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;

public abstract class ForwardingListener implements OnAttachStateChangeListener, OnTouchListener {
   private final float a;
   private final int b;
   final View c;
   private final int d;
   private Runnable e;
   private Runnable f;
   private boolean g;
   private int h;
   private final int[] i = new int[2];

   public ForwardingListener(View var1) {
      this.c = var1;
      var1.setLongClickable(true);
      var1.addOnAttachStateChangeListener(this);
      this.a = ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      this.b = ViewConfiguration.getTapTimeout();
      this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
   }

   private boolean a(MotionEvent var1) {
      boolean var4 = false;
      View var5 = this.c;
      boolean var3;
      if (!var5.isEnabled()) {
         var3 = var4;
      } else {
         switch (var1.getActionMasked()) {
            case 0:
               this.h = var1.getPointerId(0);
               if (this.e == null) {
                  this.e = new ForwardingListener.DisallowIntercept(this);
               }

               var5.postDelayed(this.e, this.b);
               if (this.f == null) {
                  this.f = new ForwardingListener.TriggerLongPress(this);
               }

               var5.postDelayed(this.f, this.d);
               var3 = var4;
               break;
            case 1:
            case 3:
               this.e();
               var3 = var4;
               break;
            case 2:
               int var2 = var1.findPointerIndex(this.h);
               var3 = var4;
               if (var2 >= 0) {
                  var3 = var4;
                  if (!a(var5, var1.getX(var2), var1.getY(var2), this.a)) {
                     this.e();
                     var5.getParent().requestDisallowInterceptTouchEvent(true);
                     var3 = true;
                  }
               }
               break;
            default:
               var3 = var4;
         }
      }

      return var3;
   }

   private static boolean a(View var0, float var1, float var2, float var3) {
      boolean var4;
      if (var1 >= -var3 && var2 >= -var3 && var1 < var0.getRight() - var0.getLeft() + var3 && var2 < var0.getBottom() - var0.getTop() + var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   private boolean a(View var1, MotionEvent var2) {
      int[] var3 = this.i;
      var1.getLocationOnScreen(var3);
      var2.offsetLocation(-var3[0], -var3[1]);
      return true;
   }

   private boolean b(MotionEvent var1) {
      boolean var4 = false;
      View var5 = this.c;
      ShowableListMenu var6 = this.a();
      boolean var3 = var4;
      if (var6 != null) {
         if (!var6.f()) {
            var3 = var4;
         } else {
            DropDownListView var7 = (DropDownListView)var6.g();
            var3 = var4;
            if (var7 != null) {
               var3 = var4;
               if (var7.isShown()) {
                  MotionEvent var10 = MotionEvent.obtainNoHistory(var1);
                  this.b(var5, var10);
                  this.a(var7, var10);
                  var3 = var7.a(var10, this.h);
                  var10.recycle();
                  int var2 = var1.getActionMasked();
                  boolean var8;
                  if (var2 != 1 && var2 != 3) {
                     var8 = true;
                  } else {
                     var8 = false;
                  }

                  if (var3 && var8) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }
               }
            }
         }
      }

      return var3;
   }

   private boolean b(View var1, MotionEvent var2) {
      int[] var3 = this.i;
      var1.getLocationOnScreen(var3);
      var2.offsetLocation(var3[0], var3[1]);
      return true;
   }

   private void e() {
      if (this.f != null) {
         this.c.removeCallbacks(this.f);
      }

      if (this.e != null) {
         this.c.removeCallbacks(this.e);
      }
   }

   public abstract ShowableListMenu a();

   protected boolean b() {
      ShowableListMenu var1 = this.a();
      if (var1 != null && !var1.f()) {
         var1.d();
      }

      return true;
   }

   protected boolean c() {
      ShowableListMenu var1 = this.a();
      if (var1 != null && var1.f()) {
         var1.e();
      }

      return true;
   }

   void d() {
      this.e();
      View var4 = this.c;
      if (var4.isEnabled() && !var4.isLongClickable() && this.b()) {
         var4.getParent().requestDisallowInterceptTouchEvent(true);
         long var1 = SystemClock.uptimeMillis();
         MotionEvent var3 = MotionEvent.obtain(var1, var1, 3, 0.0F, 0.0F, 0);
         var4.onTouchEvent(var3);
         var3.recycle();
         this.g = true;
      }
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      boolean var4 = false;
      boolean var5 = this.g;
      boolean var3;
      if (var5) {
         if (!this.b(var2) && this.c()) {
            var3 = false;
         } else {
            var3 = true;
         }
      } else {
         if (this.a(var2) && this.b()) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var3) {
            long var6 = SystemClock.uptimeMillis();
            MotionEvent var8 = MotionEvent.obtain(var6, var6, 3, 0.0F, 0.0F, 0);
            this.c.onTouchEvent(var8);
            var8.recycle();
         }
      }

      this.g = var3;
      if (!var3) {
         var3 = var4;
         if (!var5) {
            return var3;
         }
      }

      return true;
   }

   public void onViewAttachedToWindow(View var1) {
   }

   public void onViewDetachedFromWindow(View var1) {
      this.g = false;
      this.h = -1;
      if (this.e != null) {
         this.c.removeCallbacks(this.e);
      }
   }

   private class DisallowIntercept implements Runnable {
      final ForwardingListener a;

      DisallowIntercept(ForwardingListener var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         ViewParent var1 = this.a.c.getParent();
         if (var1 != null) {
            var1.requestDisallowInterceptTouchEvent(true);
         }
      }
   }

   private class TriggerLongPress implements Runnable {
      final ForwardingListener a;

      TriggerLongPress(ForwardingListener var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.d();
      }
   }
}
