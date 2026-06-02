package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

public final class GestureDetectorCompat {
   private final GestureDetectorCompat.GestureDetectorCompatImpl a;

   public GestureDetectorCompat(Context var1, OnGestureListener var2) {
      this(var1, var2, null);
   }

   public GestureDetectorCompat(Context var1, OnGestureListener var2, Handler var3) {
      if (VERSION.SDK_INT > 17) {
         this.a = new GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr2(var1, var2, var3);
      } else {
         this.a = new GestureDetectorCompat.GestureDetectorCompatImplBase(var1, var2, var3);
      }
   }

   public boolean a(MotionEvent var1) {
      return this.a.a(var1);
   }

   interface GestureDetectorCompatImpl {
      boolean a(MotionEvent var1);
   }

   static class GestureDetectorCompatImplBase implements GestureDetectorCompat.GestureDetectorCompatImpl {
      private static final int j = ViewConfiguration.getLongPressTimeout();
      private static final int k = ViewConfiguration.getTapTimeout();
      private static final int l = ViewConfiguration.getDoubleTapTimeout();
      final OnGestureListener a;
      OnDoubleTapListener b;
      boolean c;
      boolean d;
      MotionEvent e;
      private int f;
      private int g;
      private int h;
      private int i;
      private final Handler m;
      private boolean n;
      private boolean o;
      private boolean p;
      private MotionEvent q;
      private boolean r;
      private float s;
      private float t;
      private float u;
      private float v;
      private boolean w;
      private VelocityTracker x;

      GestureDetectorCompatImplBase(Context var1, OnGestureListener var2, Handler var3) {
         if (var3 != null) {
            this.m = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this, var3);
         } else {
            this.m = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this);
         }

         this.a = var2;
         if (var2 instanceof OnDoubleTapListener) {
            this.a((OnDoubleTapListener)var2);
         }

         this.a(var1);
      }

      private void a(Context var1) {
         if (var1 == null) {
            throw new IllegalArgumentException("Context must not be null");
         }

         if (this.a == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
         }

         this.w = true;
         ViewConfiguration var4 = ViewConfiguration.get(var1);
         int var3 = var4.getScaledTouchSlop();
         int var2 = var4.getScaledDoubleTapSlop();
         this.h = var4.getScaledMinimumFlingVelocity();
         this.i = var4.getScaledMaximumFlingVelocity();
         this.f = var3 * var3;
         this.g = var2 * var2;
      }

      private boolean a(MotionEvent var1, MotionEvent var2, MotionEvent var3) {
         boolean var7 = false;
         boolean var6;
         if (!this.p) {
            var6 = var7;
         } else {
            var6 = var7;
            if (var3.getEventTime() - var2.getEventTime() <= l) {
               int var4 = (int)var1.getX() - (int)var3.getX();
               int var5 = (int)var1.getY() - (int)var3.getY();
               var6 = var7;
               if (var4 * var4 + var5 * var5 < this.g) {
                  var6 = true;
               }
            }
         }

         return var6;
      }

      private void b() {
         this.m.removeMessages(1);
         this.m.removeMessages(2);
         this.m.removeMessages(3);
         this.x.recycle();
         this.x = null;
         this.r = false;
         this.c = false;
         this.o = false;
         this.p = false;
         this.d = false;
         if (this.n) {
            this.n = false;
         }
      }

      private void c() {
         this.m.removeMessages(1);
         this.m.removeMessages(2);
         this.m.removeMessages(3);
         this.r = false;
         this.o = false;
         this.p = false;
         this.d = false;
         if (this.n) {
            this.n = false;
         }
      }

      void a() {
         this.m.removeMessages(3);
         this.d = false;
         this.n = true;
         this.a.onLongPress(this.e);
      }

      public void a(OnDoubleTapListener var1) {
         this.b = var1;
      }

      @Override
      public boolean a(MotionEvent var1) {
         boolean var12 = false;
         int var10 = var1.getAction();
         if (this.x == null) {
            this.x = VelocityTracker.obtain();
         }

         this.x.addMovement(var1);
         boolean var6;
         if ((var10 & 0xFF) == 6) {
            var6 = 1;
         } else {
            var6 = 0;
         }

         int var7;
         if (var6) {
            var7 = var1.getActionIndex();
         } else {
            var7 = -1;
         }

         int var9 = var1.getPointerCount();
         int var8 = 0;
         float var2 = 0.0F;
         float var3 = 0.0F;

         while (var8 < var9) {
            if (var7 != var8) {
               var3 += var1.getX(var8);
               var2 += var1.getY(var8);
            }

            var8++;
         }

         if (var6) {
            var6 = var9 - 1;
         } else {
            var6 = var9;
         }

         var3 /= var6;
         float var4 = var2 / var6;
         boolean var11 = var12;
         switch (var10 & 0xFF) {
            case 0:
               label107: {
                  if (this.b != null) {
                     var11 = this.m.hasMessages(3);
                     if (var11) {
                        this.m.removeMessages(3);
                     }

                     if (this.e != null && this.q != null && var11 && this.a(this.e, this.q, var1)) {
                        this.r = true;
                        var28 = this.b.onDoubleTap(this.e) | false | this.b.onDoubleTapEvent(var1);
                        break label107;
                     }

                     this.m.sendEmptyMessageDelayed(3, l);
                  }

                  var28 = false;
               }

               this.s = var3;
               this.u = var3;
               this.t = var4;
               this.v = var4;
               if (this.e != null) {
                  this.e.recycle();
               }

               this.e = MotionEvent.obtain(var1);
               this.o = true;
               this.p = true;
               this.c = true;
               this.n = false;
               this.d = false;
               if (this.w) {
                  this.m.removeMessages(2);
                  this.m.sendEmptyMessageAtTime(2, this.e.getDownTime() + k + j);
               }

               this.m.sendEmptyMessageAtTime(1, this.e.getDownTime() + k);
               var11 = var28 | this.a.onDown(var1);
               break;
            case 1:
               this.c = false;
               MotionEvent var13 = MotionEvent.obtain(var1);
               if (this.r) {
                  var11 = this.b.onDoubleTapEvent(var1) | false;
               } else if (this.n) {
                  this.m.removeMessages(3);
                  this.n = false;
                  var11 = false;
               } else if (this.o) {
                  var12 = this.a.onSingleTapUp(var1);
                  var11 = var12;
                  if (this.d) {
                     var11 = var12;
                     if (this.b != null) {
                        this.b.onSingleTapConfirmed(var1);
                        var11 = var12;
                     }
                  }
               } else {
                  VelocityTracker var14 = this.x;
                  var6 = var1.getPointerId(0);
                  var14.computeCurrentVelocity(1000, this.i);
                  var3 = var14.getYVelocity(var6);
                  var2 = var14.getXVelocity(var6);
                  if (!(Math.abs(var3) > this.h) && !(Math.abs(var2) > this.h)) {
                     var11 = false;
                  } else {
                     var11 = this.a.onFling(this.e, var1, var2, var3);
                  }
               }

               if (this.q != null) {
                  this.q.recycle();
               }

               this.q = var13;
               if (this.x != null) {
                  this.x.recycle();
                  this.x = null;
               }

               this.r = false;
               this.d = false;
               this.m.removeMessages(1);
               this.m.removeMessages(2);
               break;
            case 2:
               var11 = var12;
               if (!this.n) {
                  var2 = this.s - var3;
                  float var5 = this.t - var4;
                  if (this.r) {
                     var11 = false | this.b.onDoubleTapEvent(var1);
                  } else if (this.o) {
                     var7 = (int)(var3 - this.u);
                     var6 = (int)(var4 - this.v);
                     var6 = var7 * var7 + var6 * var6;
                     if (var6 > this.f) {
                        var11 = this.a.onScroll(this.e, var1, var2, var5);
                        this.s = var3;
                        this.t = var4;
                        this.o = false;
                        this.m.removeMessages(3);
                        this.m.removeMessages(1);
                        this.m.removeMessages(2);
                     } else {
                        var11 = false;
                     }

                     if (var6 > this.f) {
                        this.p = false;
                     }
                  } else {
                     if (!(Math.abs(var2) >= 1.0F)) {
                        var11 = var12;
                        if (!(Math.abs(var5) >= 1.0F)) {
                           return var11;
                        }
                     }

                     var11 = this.a.onScroll(this.e, var1, var2, var5);
                     this.s = var3;
                     this.t = var4;
                  }
               }
               break;
            case 3:
               this.b();
               var11 = var12;
            case 4:
               break;
            case 5:
               this.s = var3;
               this.u = var3;
               this.t = var4;
               this.v = var4;
               this.c();
               var11 = var12;
               break;
            case 6:
               this.s = var3;
               this.u = var3;
               this.t = var4;
               this.v = var4;
               this.x.computeCurrentVelocity(1000, this.i);
               var7 = var1.getActionIndex();
               var6 = var1.getPointerId(var7);
               var2 = this.x.getXVelocity(var6);
               var4 = this.x.getYVelocity(var6);
               var6 = 0;

               while (true) {
                  var11 = var12;
                  if (var6 >= var9) {
                     return var11;
                  }

                  if (var6 != var7) {
                     var8 = var1.getPointerId(var6);
                     var3 = this.x.getXVelocity(var8);
                     if (this.x.getYVelocity(var8) * var4 + var3 * var2 < 0.0F) {
                        this.x.clear();
                        var11 = var12;
                        return var11;
                     }
                  }

                  var6++;
               }
            default:
               var11 = var12;
         }

         return var11;
      }

      private class GestureHandler extends Handler {
         final GestureDetectorCompat.GestureDetectorCompatImplBase a;

         GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase var1) {
            this.a = var1;
         }

         GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase var1, Handler var2) {
            super(var2.getLooper());
            this.a = var1;
         }

         public void handleMessage(Message var1) {
            switch (var1.what) {
               case 1:
                  this.a.a.onShowPress(this.a.e);
                  break;
               case 2:
                  this.a.a();
                  break;
               case 3:
                  if (this.a.b != null) {
                     if (!this.a.c) {
                        this.a.b.onSingleTapConfirmed(this.a.e);
                     } else {
                        this.a.d = true;
                     }
                  }
                  break;
               default:
                  throw new RuntimeException("Unknown message " + var1);
            }
         }
      }
   }

   static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompat.GestureDetectorCompatImpl {
      private final GestureDetector a;

      GestureDetectorCompatImplJellybeanMr2(Context var1, OnGestureListener var2, Handler var3) {
         this.a = new GestureDetector(var1, var2, var3);
      }

      @Override
      public boolean a(MotionEvent var1) {
         return this.a.onTouchEvent(var1);
      }
   }
}
