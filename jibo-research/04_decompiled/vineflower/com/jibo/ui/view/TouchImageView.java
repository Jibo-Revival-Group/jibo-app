package com.jibo.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.ImageView.ScaleType;

public class TouchImageView extends ImageView {
   private OnTouchListener A;
   private TouchImageView.OnTouchImageViewListener B;
   private float a;
   private Matrix b;
   private Matrix c;
   private TouchImageView.State d;
   private float e;
   private float f;
   private float g;
   private float h;
   private float[] i;
   private Context j;
   private TouchImageView.Fling k;
   private ScaleType l;
   private boolean m;
   private boolean n;
   private TouchImageView.ZoomVariables o;
   private int p;
   private int q;
   private int r;
   private int s;
   private float t;
   private float u;
   private float v;
   private float w;
   private ScaleGestureDetector x;
   private GestureDetector y;
   private OnDoubleTapListener z = null;

   public TouchImageView(Context var1) {
      super(var1);
      this.A = null;
      this.B = null;
      this.a(var1);
   }

   public TouchImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.A = null;
      this.B = null;
      this.a(var1);
   }

   public TouchImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.A = null;
      this.B = null;
      this.a(var1);
   }

   private PointF a(float var1, float var2) {
      this.b.getValues(this.i);
      float var4 = this.getDrawable().getIntrinsicWidth();
      float var3 = this.getDrawable().getIntrinsicHeight();
      var1 /= var4;
      var4 = var2 / var3;
      var3 = this.i[2];
      var2 = this.getImageWidth();
      float var5 = this.i[5];
      return new PointF(var1 * var2 + var3, var4 * this.getImageHeight() + var5);
   }

   private PointF a(float var1, float var2, boolean var3) {
      this.b.getValues(this.i);
      float var7 = this.getDrawable().getIntrinsicWidth();
      float var6 = this.getDrawable().getIntrinsicHeight();
      float var4 = this.i[2];
      float var5 = this.i[5];
      var4 = (var1 - var4) * var7 / this.getImageWidth();
      var5 = (var2 - var5) * var6 / this.getImageHeight();
      var2 = var5;
      var1 = var4;
      if (var3) {
         var1 = Math.min(Math.max(var4, 0.0F), var7);
         var2 = Math.min(Math.max(var5, 0.0F), var6);
      }

      return new PointF(var1, var2);
   }

   private void a(double var1, float var3, float var4, boolean var5) {
      float var6;
      float var7;
      if (var5) {
         var7 = this.g;
         var6 = this.h;
      } else {
         var7 = this.e;
         var6 = this.f;
      }

      float var8 = this.a;
      this.a = (float)(this.a * var1);
      if (this.a > var6) {
         this.a = var6;
         var1 = var6 / var8;
      } else if (this.a < var7) {
         this.a = var7;
         var1 = var7 / var8;
      }

      this.b.postScale((float)var1, (float)var1, var3, var4);
      this.e();
   }

   private void a(int var1, float var2, float var3, float var4, int var5, int var6, int var7) {
      if (var4 < var6) {
         this.i[var1] = (var6 - var7 * this.i[0]) * 0.5F;
      } else if (var2 > 0.0F) {
         this.i[var1] = -((var4 - var6) * 0.5F);
      } else {
         var2 = (Math.abs(var2) + var5 * 0.5F) / var3;
         this.i[var1] = -(var2 * var4 - var6 * 0.5F);
      }
   }

   private void a(Context var1) {
      super.setClickable(true);
      this.j = var1;
      this.x = new ScaleGestureDetector(var1, new TouchImageView.ScaleListener(this));
      this.y = new GestureDetector(var1, new TouchImageView.GestureListener(this));
      this.b = new Matrix();
      this.c = new Matrix();
      this.i = new float[9];
      this.a = 1.0F;
      if (this.l == null) {
         this.l = ScaleType.FIT_CENTER;
      }

      this.e = 1.0F;
      this.f = 3.0F;
      this.g = 0.75F * this.e;
      this.h = 1.25F * this.f;
      this.setImageMatrix(this.b);
      this.setScaleType(ScaleType.MATRIX);
      this.setState(TouchImageView.State.NONE);
      this.n = false;
      super.setOnTouchListener(new TouchImageView.PrivateOnTouchListener(this));
   }

   @TargetApi(16)
   private void a(Runnable var1) {
      if (VERSION.SDK_INT >= 16) {
         this.postOnAnimation(var1);
      } else {
         this.postDelayed(var1, 16L);
      }
   }

   private float b(float var1, float var2, float var3) {
      float var4 = 0.0F;
      if (var3 <= var2) {
         var3 = var2 - var3;
         var2 = 0.0F;
      } else {
         var2 -= var3;
         var3 = 0.0F;
      }

      if (var1 < var2) {
         var2 = -var1 + var2;
      } else {
         var2 = var4;
         if (var1 > var3) {
            var2 = -var1 + var3;
         }
      }

      return var2;
   }

   private float c(float var1, float var2, float var3) {
      if (var3 <= var2) {
         var1 = 0.0F;
      }

      return var1;
   }

   private void c() {
      if (this.b != null && this.q != 0 && this.p != 0) {
         this.b.getValues(this.i);
         this.c.setValues(this.i);
         this.w = this.u;
         this.v = this.t;
         this.s = this.q;
         this.r = this.p;
      }
   }

   private void d() {
      this.b.getValues(this.i);
      float var2 = this.i[2];
      float var1 = this.i[5];
      var2 = this.b(var2, this.p, this.getImageWidth());
      var1 = this.b(var1, this.q, this.getImageHeight());
      if (var2 != 0.0F || var1 != 0.0F) {
         this.b.postTranslate(var2, var1);
      }
   }

   private void e() {
      this.d();
      this.b.getValues(this.i);
      if (this.getImageWidth() < this.p) {
         this.i[2] = (this.p - this.getImageWidth()) / 2.0F;
      }

      if (this.getImageHeight() < this.q) {
         this.i[5] = (this.q - this.getImageHeight()) / 2.0F;
      }

      this.b.setValues(this.i);
   }

   private void f() {
      Drawable var9 = this.getDrawable();
      if (var9 != null && var9.getIntrinsicWidth() != 0 && var9.getIntrinsicHeight() != 0 && this.b != null && this.c != null) {
         int var7 = var9.getIntrinsicWidth();
         int var8 = var9.getIntrinsicHeight();
         float var3 = (float)this.p / var7;
         float var4 = (float)this.q / var8;
         float var1 = (float)(this.p * this.q) / (var7 * var8);
         if (var1 > 1.0F) {
            this.setMaxZoom(3.0F);
         } else {
            this.setMaxZoom(1.0F / var1 + 3.0F);
         }

         var1 = var4;
         float var2 = var3;
         float var6 = var4;
         float var5 = var3;
         switch (<unrepresentable>.a[this.l.ordinal()]) {
            case 1:
               var1 = 1.0F;
               var2 = 1.0F;
               break;
            case 2:
               var1 = Math.max(var3, var4);
               var2 = var1;
               break;
            case 3:
               var6 = Math.min(1.0F, Math.min(var3, var4));
               var5 = var6;
            case 4:
               var1 = Math.min(var5, var6);
               var2 = var1;
            case 5:
               break;
            default:
               throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
         }

         var3 = this.p - var7 * var2;
         var4 = this.q - var8 * var1;
         this.t = this.p - var3;
         this.u = this.q - var4;
         if (!this.a() && !this.m) {
            this.b.setScale(var2, var1);
            this.b.postTranslate(var3 / 2.0F, var4 / 2.0F);
            this.a = 1.0F;
         } else {
            if (this.v == 0.0F || this.w == 0.0F) {
               this.c();
            }

            this.c.getValues(this.i);
            this.i[0] = this.t / var7 * this.a;
            this.i[4] = this.u / var8 * this.a;
            var1 = this.i[2];
            var2 = this.i[5];
            var3 = this.v;
            this.a(2, var1, this.a * var3, this.getImageWidth(), this.r, this.p, var7);
            this.a(5, var2, this.w * this.a, this.getImageHeight(), this.s, this.q, var8);
            this.b.setValues(this.i);
         }

         this.d();
         this.setImageMatrix(this.b);
      }
   }

   private float getImageHeight() {
      return this.u * this.a;
   }

   private float getImageWidth() {
      return this.t * this.a;
   }

   private void setState(TouchImageView.State var1) {
      this.d = var1;
   }

   public void a(float var1, float var2, float var3) {
      this.a(var1, var2, var3, this.l);
   }

   public void a(float var1, float var2, float var3, ScaleType var4) {
      if (!this.n) {
         this.o = new TouchImageView.ZoomVariables(this, var1, var2, var3, var4);
      } else {
         if (var4 != this.l) {
            this.setScaleType(var4);
         }

         this.b();
         this.a(var1, this.p / 2, this.q / 2, true);
         this.b.getValues(this.i);
         this.i[2] = -(this.getImageWidth() * var2 - this.p * 0.5F);
         this.i[5] = -(this.getImageHeight() * var3 - this.q * 0.5F);
         this.b.setValues(this.i);
         this.d();
         this.setImageMatrix(this.b);
      }
   }

   public boolean a() {
      boolean var1;
      if (this.a != 1.0F) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean a(int var1) {
      return this.canScrollHorizontally(var1);
   }

   public void b() {
      this.a = 1.0F;
      this.f();
   }

   public boolean canScrollHorizontally(int var1) {
      boolean var4 = false;
      this.b.getValues(this.i);
      float var2 = this.i[2];
      boolean var3;
      if (this.getImageWidth() < this.p) {
         var3 = var4;
      } else {
         if (var2 >= -1.0F) {
            var3 = var4;
            if (var1 < 0) {
               return var3;
            }
         }

         if (Math.abs(var2) + this.p + 1.0F >= this.getImageWidth()) {
            var3 = var4;
            if (var1 > 0) {
               return var3;
            }
         }

         var3 = true;
      }

      return var3;
   }

   public float getCurrentZoom() {
      return this.a;
   }

   public float getMaxZoom() {
      return this.f;
   }

   public float getMinZoom() {
      return this.e;
   }

   public ScaleType getScaleType() {
      return this.l;
   }

   public PointF getScrollPosition() {
      Drawable var3 = this.getDrawable();
      PointF var4;
      if (var3 == null) {
         var4 = null;
      } else {
         int var1 = var3.getIntrinsicWidth();
         int var2 = var3.getIntrinsicHeight();
         var4 = this.a(this.p / 2, this.q / 2, true);
         var4.x /= var1;
         var4.y /= var2;
      }

      return var4;
   }

   public RectF getZoomedRect() {
      if (this.l == ScaleType.FIT_XY) {
         throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
      }

      PointF var4 = this.a(0.0F, 0.0F, true);
      PointF var3 = this.a(this.p, this.q, true);
      float var1 = this.getDrawable().getIntrinsicWidth();
      float var2 = this.getDrawable().getIntrinsicHeight();
      return new RectF(var4.x / var1, var4.y / var2, var3.x / var1, var3.y / var2);
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.c();
   }

   protected void onDraw(Canvas var1) {
      this.n = true;
      this.m = true;
      if (this.o != null) {
         this.a(this.o.a, this.o.b, this.o.c, this.o.d);
         this.o = null;
      }

      super.onDraw(var1);
   }

   protected void onMeasure(int var1, int var2) {
      Drawable var5 = this.getDrawable();
      if (var5 != null && var5.getIntrinsicWidth() != 0 && var5.getIntrinsicHeight() != 0) {
         int var4 = this.p;
         int var3 = this.q;
         this.p = MeasureSpec.getSize(var1);
         this.q = MeasureSpec.getSize(var2);
         if (this.q < this.getLayoutParams().height) {
            var1 = this.getLayoutParams().height;
         } else {
            var1 = this.q;
         }

         this.q = var1;
         this.setMeasuredDimension(this.p, this.q);
         if (var4 != this.p || var3 != this.q) {
            this.f();
         }
      } else {
         this.p = MeasureSpec.getSize(var1);
         this.q = MeasureSpec.getSize(var2);
         if (this.q < this.getLayoutParams().height) {
            var1 = this.getLayoutParams().height;
         } else {
            var1 = this.q;
         }

         this.q = var1;
         this.setMeasuredDimension(this.p, this.q);
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if (var1 instanceof Bundle) {
         Bundle var2 = (Bundle)var1;
         this.a = var2.getFloat("saveScale");
         this.i = var2.getFloatArray("matrix");
         this.c.setValues(this.i);
         this.w = var2.getFloat("matchViewHeight");
         this.v = var2.getFloat("matchViewWidth");
         this.s = var2.getInt("viewHeight");
         this.r = var2.getInt("viewWidth");
         this.m = var2.getBoolean("imageRendered");
         super.onRestoreInstanceState(var2.getParcelable("instanceState"));
      } else {
         super.onRestoreInstanceState(var1);
      }
   }

   public Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      var1.putParcelable("instanceState", super.onSaveInstanceState());
      var1.putFloat("saveScale", this.a);
      var1.putFloat("matchViewHeight", this.u);
      var1.putFloat("matchViewWidth", this.t);
      var1.putInt("viewWidth", this.p);
      var1.putInt("viewHeight", this.q);
      this.b.getValues(this.i);
      var1.putFloatArray("matrix", this.i);
      var1.putBoolean("imageRendered", this.m);
      return var1;
   }

   public void setImageBitmap(Bitmap var1) {
      super.setImageBitmap(var1);
      this.c();
      this.f();
   }

   public void setImageDrawable(Drawable var1) {
      super.setImageDrawable(var1);
      this.c();
      this.f();
   }

   public void setImageResource(int var1) {
      super.setImageResource(var1);
      this.c();
      this.f();
   }

   public void setImageURI(Uri var1) {
      super.setImageURI(var1);
      this.c();
      this.f();
   }

   public void setMaxZoom(float var1) {
      this.f = var1;
      this.h = 1.25F * this.f;
   }

   public void setMinZoom(float var1) {
      this.e = var1;
      this.g = 0.75F * this.e;
   }

   public void setOnDoubleTapListener(OnDoubleTapListener var1) {
      this.z = var1;
   }

   public void setOnTouchImageViewListener(TouchImageView.OnTouchImageViewListener var1) {
      this.B = var1;
   }

   public void setOnTouchListener(OnTouchListener var1) {
      this.A = var1;
   }

   public void setScaleType(ScaleType var1) {
      if (var1 != ScaleType.FIT_START && var1 != ScaleType.FIT_END) {
         if (var1 == ScaleType.MATRIX) {
            super.setScaleType(ScaleType.MATRIX);
         } else {
            this.l = var1;
            if (this.n) {
               this.a(1.0F, 0.5F, 0.5F, this.getScaleType());
            }
         }
      } else {
         throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
      }
   }

   public void setZoom(float var1) {
      this.a(var1, 0.5F, 0.5F);
   }

   public void setZoom(TouchImageView var1) {
      PointF var2 = var1.getScrollPosition();
      this.a(var1.getCurrentZoom(), var2.x, var2.y, var1.getScaleType());
   }

   @TargetApi(9)
   private class CompatScroller {
      Scroller a;
      OverScroller b;
      boolean c;
      final TouchImageView d;

      public CompatScroller(TouchImageView var1, Context var2) {
         this.d = var1;
         if (VERSION.SDK_INT < 9) {
            this.c = true;
            this.a = new Scroller(var2);
         } else {
            this.c = false;
            this.b = new OverScroller(var2);
         }
      }

      public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
         if (this.c) {
            this.a.fling(var1, var2, var3, var4, var5, var6, var7, var8);
         } else {
            this.b.fling(var1, var2, var3, var4, var5, var6, var7, var8);
         }
      }

      public void a(boolean var1) {
         if (this.c) {
            this.a.forceFinished(var1);
         } else {
            this.b.forceFinished(var1);
         }
      }

      public boolean a() {
         boolean var1;
         if (this.c) {
            var1 = this.a.isFinished();
         } else {
            var1 = this.b.isFinished();
         }

         return var1;
      }

      public boolean b() {
         boolean var1;
         if (this.c) {
            var1 = this.a.computeScrollOffset();
         } else {
            this.b.computeScrollOffset();
            var1 = this.b.computeScrollOffset();
         }

         return var1;
      }

      public int c() {
         int var1;
         if (this.c) {
            var1 = this.a.getCurrX();
         } else {
            var1 = this.b.getCurrX();
         }

         return var1;
      }

      public int d() {
         int var1;
         if (this.c) {
            var1 = this.a.getCurrY();
         } else {
            var1 = this.b.getCurrY();
         }

         return var1;
      }
   }

   private class DoubleTapZoom implements Runnable {
      final TouchImageView a;
      private long b;
      private float c;
      private float d;
      private float e;
      private float f;
      private boolean g;
      private AccelerateDecelerateInterpolator h;
      private PointF i;
      private PointF j;

      DoubleTapZoom(TouchImageView var1, float var2, float var3, float var4, boolean var5) {
         this.a = var1;
         this.h = new AccelerateDecelerateInterpolator();
         var1.setState(TouchImageView.State.ANIMATE_ZOOM);
         this.b = System.currentTimeMillis();
         this.c = var1.a;
         this.d = var2;
         this.g = var5;
         PointF var6 = var1.a(var3, var4, false);
         this.e = var6.x;
         this.f = var6.y;
         this.i = var1.a(this.e, this.f);
         this.j = new PointF(var1.p / 2, var1.q / 2);
      }

      private float a() {
         float var1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.b) / 500.0F);
         return this.h.getInterpolation(var1);
      }

      private void a(float var1) {
         float var5 = this.i.x;
         float var3 = this.j.x;
         float var2 = this.i.x;
         float var7 = this.i.y;
         float var4 = this.j.y;
         float var6 = this.i.y;
         PointF var8 = this.a.a(this.e, this.f);
         this.a.b.postTranslate(var5 + (var3 - var2) * var1 - var8.x, var7 + (var4 - var6) * var1 - var8.y);
      }

      private double b(float var1) {
         return (double)(this.c + (this.d - this.c) * var1) / this.a.a;
      }

      @Override
      public void run() {
         float var3 = this.a();
         double var1 = this.b(var3);
         this.a.a(var1, this.e, this.f, this.g);
         this.a(var3);
         this.a.e();
         this.a.setImageMatrix(this.a.b);
         if (this.a.B != null) {
            this.a.B.a();
         }

         if (var3 < 1.0F) {
            this.a.a(this);
         } else {
            this.a.setState(TouchImageView.State.NONE);
         }
      }
   }

   private class Fling implements Runnable {
      TouchImageView.CompatScroller a;
      int b;
      int c;
      final TouchImageView d;

      Fling(TouchImageView var1, int var2, int var3) {
         this.d = var1;
         var1.setState(TouchImageView.State.FLING);
         this.a = var1.new CompatScroller(var1, var1.j);
         var1.b.getValues(var1.i);
         int var4 = (int)var1.i[2];
         int var5 = (int)var1.i[5];
         int var6;
         int var7;
         if (var1.getImageWidth() > var1.p) {
            var6 = var1.p - (int)var1.getImageWidth();
            var7 = 0;
         } else {
            var7 = var4;
            var6 = var4;
         }

         int var8;
         int var9;
         if (var1.getImageHeight() > var1.q) {
            var9 = var1.q - (int)var1.getImageHeight();
            var8 = 0;
         } else {
            var8 = var5;
            var9 = var5;
         }

         this.a.a(var4, var5, var2, var3, var6, var7, var9, var8);
         this.b = var4;
         this.c = var5;
      }

      public void a() {
         if (this.a != null) {
            this.d.setState(TouchImageView.State.NONE);
            this.a.a(true);
         }
      }

      @Override
      public void run() {
         if (this.d.B != null) {
            this.d.B.a();
         }

         if (this.a.a()) {
            this.a = null;
         } else if (this.a.b()) {
            int var1 = this.a.c();
            int var3 = this.a.d();
            int var4 = this.b;
            int var2 = this.c;
            this.b = var1;
            this.c = var3;
            this.d.b.postTranslate(var1 - var4, var3 - var2);
            this.d.d();
            this.d.setImageMatrix(this.d.b);
            this.d.a(this);
         }
      }
   }

   private class GestureListener extends SimpleOnGestureListener {
      final TouchImageView a;

      private GestureListener(TouchImageView var1) {
         this.a = var1;
      }

      public boolean onDoubleTap(MotionEvent var1) {
         boolean var3;
         if (this.a.z != null) {
            var3 = this.a.z.onDoubleTap(var1);
         } else {
            var3 = false;
         }

         if (this.a.d == TouchImageView.State.NONE) {
            float var2;
            if (this.a.a == this.a.e) {
               var2 = this.a.f;
            } else {
               var2 = this.a.e;
            }

            TouchImageView.DoubleTapZoom var4 = this.a.new DoubleTapZoom(this.a, var2, var1.getX(), var1.getY(), false);
            this.a.a(var4);
            var3 = true;
         }

         return var3;
      }

      public boolean onDoubleTapEvent(MotionEvent var1) {
         boolean var2;
         if (this.a.z != null) {
            var2 = this.a.z.onDoubleTapEvent(var1);
         } else {
            var2 = false;
         }

         return var2;
      }

      public boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         if (this.a.k != null) {
            this.a.k.a();
         }

         this.a.k = this.a.new Fling(this.a, (int)var3, (int)var4);
         this.a.a(this.a.k);
         return super.onFling(var1, var2, var3, var4);
      }

      public void onLongPress(MotionEvent var1) {
         this.a.performLongClick();
      }

      public boolean onSingleTapConfirmed(MotionEvent var1) {
         boolean var2;
         if (this.a.z != null) {
            var2 = this.a.z.onSingleTapConfirmed(var1);
         } else {
            var2 = this.a.performClick();
         }

         return var2;
      }
   }

   public interface OnTouchImageViewListener {
      void a();
   }

   private class PrivateOnTouchListener implements OnTouchListener {
      final TouchImageView a;
      private PointF b;

      private PrivateOnTouchListener(TouchImageView var1) {
         this.a = var1;
         this.b = new PointF();
      }

      public boolean onTouch(View var1, MotionEvent var2) {
         this.a.x.onTouchEvent(var2);
         this.a.y.onTouchEvent(var2);
         PointF var7 = new PointF(var2.getX(), var2.getY());
         if (this.a.d == TouchImageView.State.NONE || this.a.d == TouchImageView.State.DRAG || this.a.d == TouchImageView.State.FLING) {
            switch (var2.getAction()) {
               case 0:
                  this.b.set(var7);
                  if (this.a.k != null) {
                     this.a.k.a();
                  }

                  this.a.setState(TouchImageView.State.DRAG);
                  break;
               case 1:
               case 6:
                  this.a.setState(TouchImageView.State.NONE);
                  break;
               case 2:
                  if (this.a.d == TouchImageView.State.DRAG) {
                     float var5 = var7.x;
                     float var6 = this.b.x;
                     float var3 = var7.y;
                     float var4 = this.b.y;
                     var5 = this.a.c(var5 - var6, this.a.p, this.a.getImageWidth());
                     var3 = this.a.c(var3 - var4, this.a.q, this.a.getImageHeight());
                     this.a.b.postTranslate(var5, var3);
                     this.a.d();
                     this.b.set(var7.x, var7.y);
                  }
               case 3:
               case 4:
               case 5:
            }
         }

         this.a.setImageMatrix(this.a.b);
         if (this.a.A != null) {
            this.a.A.onTouch(var1, var2);
         }

         if (this.a.B != null) {
            this.a.B.a();
         }

         return true;
      }
   }

   private class ScaleListener extends SimpleOnScaleGestureListener {
      final TouchImageView a;

      private ScaleListener(TouchImageView var1) {
         this.a = var1;
      }

      public boolean onScale(ScaleGestureDetector var1) {
         this.a.a(var1.getScaleFactor(), var1.getFocusX(), var1.getFocusY(), true);
         if (this.a.B != null) {
            this.a.B.a();
         }

         return true;
      }

      public boolean onScaleBegin(ScaleGestureDetector var1) {
         this.a.setState(TouchImageView.State.ZOOM);
         return true;
      }

      public void onScaleEnd(ScaleGestureDetector var1) {
         super.onScaleEnd(var1);
         this.a.setState(TouchImageView.State.NONE);
         boolean var3 = false;
         float var2 = this.a.a;
         if (this.a.a > this.a.f) {
            var2 = this.a.f;
            var3 = true;
         } else if (this.a.a < this.a.e) {
            var2 = this.a.e;
            var3 = true;
         }

         if (var3) {
            TouchImageView.DoubleTapZoom var4 = this.a.new DoubleTapZoom(this.a, var2, this.a.p / 2, this.a.q / 2, true);
            this.a.a(var4);
         }
      }
   }

   private enum State {
      ANIMATE_ZOOM,
      DRAG,
      FLING,
      NONE,
      ZOOM;

      private static final TouchImageView.State[] $VALUES = new TouchImageView.State[]{
         TouchImageView.State.NONE, TouchImageView.State.DRAG, TouchImageView.State.ZOOM, TouchImageView.State.FLING, TouchImageView.State.ANIMATE_ZOOM
      };
   }

   private class ZoomVariables {
      public float a;
      public float b;
      public float c;
      public ScaleType d;
      final TouchImageView e;

      public ZoomVariables(TouchImageView var1, float var2, float var3, float var4, ScaleType var5) {
         this.e = var1;
         this.a = var2;
         this.b = var3;
         this.c = var4;
         this.d = var5;
      }
   }
}
