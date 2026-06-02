package com.jibo.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.jibo.utils.ImageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CroppingCircleView extends ImageView {
   public static int a = 500;
   private static String b = "radius";
   private static String c = "x";
   private static String d = "y";
   private boolean A;
   private boolean B;
   private Paint e;
   private Paint f;
   private Paint g;
   private Path h;
   private RectF i;
   private RectF j;
   private RectF k;
   private Rect l;
   private Path m;
   private int n = -1;
   private int o = -1;
   private int p = -1;
   private int q = -1;
   private int r;
   private int s;
   private int t;
   private int u;
   private int v;
   private float w;
   private float x;
   private float y;
   private File z;

   public CroppingCircleView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.A = false;
      this.B = false;
      this.a();
   }

   public CroppingCircleView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.A = false;
      this.B = false;
      this.a();
   }

   private int a(int var1, int var2) {
      float[] var6 = this.getBitmapInViewBounds();
      int var4 = (int)(this.getWidth() / 2 - var6[0] / 2.0F) + 2;
      float var3 = this.getWidth() / 2;
      int var5 = (int)(var6[0] / 2.0F + var3) - 2;
      if (var2 - var1 < var4) {
         var2 = var4 + var1;
      }

      var4 = var2;
      if (var2 + var1 > var5) {
         var4 = var5 - var1;
      }

      return var4;
   }

   private int a(int var1, int var2, int var3, int var4) {
      if (var3 == this.a(var2, var3)) {
         var3 = var2;
         if (var4 == this.b(var2, var4)) {
            return var3;
         }
      }

      return var1;
   }

   private void a() {
      this.p = this.getResources().getDimensionPixelSize(2131165271);
      this.q = this.p - 2;
      this.s = this.getResources().getDimensionPixelSize(2131165269);
      this.r = (int)(this.getResources().getDimensionPixelSize(2131165271) - this.getResources().getDimensionPixelSize(2131165271) * 0.1F);
      this.v = this.p / 4;
      this.e = new Paint();
      this.e.setARGB(100, 0, 0, 0);
      this.e.setStrokeCap(Cap.SQUARE);
      this.e.setStrokeWidth(0.0F);
      this.f = new Paint();
      this.f.setColor(-1);
      this.f.setStrokeWidth(4.0F);
      this.f.setStyle(Style.STROKE);
      this.f.setAntiAlias(true);
      this.g = new Paint();
      this.g.setColor(this.getResources().getColor(2131099771));
      this.g.setStrokeWidth(6.0F);
      this.g.setStyle(Style.STROKE);
      this.g.setAntiAlias(true);
      this.h = new Path();
      this.h.setFillType(FillType.INVERSE_EVEN_ODD);
      this.m = new Path();
      this.m.setFillType(FillType.EVEN_ODD);
   }

   private int b(int var1, int var2) {
      float[] var6 = this.getBitmapInViewBounds();
      int var4 = (int)(this.getHeight() / 2 - var6[1] / 2.0F) + 2;
      float var3 = this.getHeight() / 2;
      int var5 = (int)(var6[1] / 2.0F + var3) - 2;
      if (var2 - var1 < var4) {
         var2 = var4 + var1;
      }

      var4 = var2;
      if (var2 + var1 > var5) {
         var4 = var5 - var1;
      }

      return var4;
   }

   private void b() {
      if (this.z != null && this.getWidth() != 0 && this.getHeight() != 0) {
         this.k = new RectF(this.n - this.p, this.o - this.p, this.n + this.p, this.o + this.p);
         this.i = new RectF(this.n - this.q, this.o - this.q, this.n + this.q, this.o + this.q);
         this.j = new RectF(this.i.left - 1.0F, this.i.top - 1.0F, this.i.right - 1.0F, this.i.bottom - 1.0F);
         int var7 = this.n - this.getWidth() / 2;
         int var1 = this.o - this.getHeight() / 2;
         int var6 = this.t / 2;
         int var4 = (int)((-var7 + this.q) * this.w);
         int var2 = this.u / 2;
         int var3 = (int)((-var1 + this.q) * this.w);
         int var5 = this.t / 2;
         int var8 = (int)((var7 + this.q) * this.w);
         var7 = this.u / 2;
         this.l = new Rect(var6 - var4, var2 - var3, var8 + var5, (int)((var1 + this.q) * this.w) + var7);
      }
   }

   private void c() {
      if (this.z != null && this.getWidth() != 0 && this.getHeight() != 0) {
         try {
            Options var1 = new Options();
            var1.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.z.getPath(), var1);
            this.t = var1.outWidth;
            this.u = var1.outHeight;
            this.setImageBitmap(ImageUtils.a(this.z.getPath(), this.getWidth(), this.getHeight()));
            float[] var3 = this.getBitmapInViewBounds();
            this.w = this.t / var3[0];
         } catch (FileNotFoundException var2) {
         }
      }
   }

   private float[] getBitmapInViewBounds() {
      float[] var4 = new float[]{this.getWidth(), this.getHeight()};
      float var3 = (float)this.getDrawable().getIntrinsicWidth() / this.getDrawable().getIntrinsicHeight();
      float var1 = (float)this.getWidth() / this.getDrawable().getIntrinsicWidth();
      float var2 = (float)this.getHeight() / this.getDrawable().getIntrinsicHeight();
      if (var3 > 1.0F) {
         var4[1] = this.getDrawable().getIntrinsicHeight() * var1;
      } else if (this.getDrawable().getIntrinsicHeight() * var1 < this.getHeight()) {
         var4[1] = this.getDrawable().getIntrinsicHeight() * var1;
      } else {
         var4[0] = this.getDrawable().getIntrinsicWidth() * var2;
      }

      return var4;
   }

   public Bitmap getCroppedImage() {
      Object var1 = null;

      Bitmap var2;
      try {
         var2 = BitmapRegionDecoder.newInstance(this.z.getPath(), false).decodeRegion(this.l, null);
      } catch (Exception var3) {
         return (Bitmap)var1;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.k != null) {
         this.h.reset();
         this.h.addOval(this.k, Direction.CW);
         this.m.reset();
         int var2 = this.p + 2;
         this.m.moveTo(this.n - var2, this.o - var2);
         this.m.lineTo(this.n + var2, this.o - var2);
         this.m.lineTo(this.n + var2, this.o + var2);
         this.m.lineTo(this.n - var2, this.o + var2);
         this.m.lineTo(this.n - var2, this.o - var2);
         this.m.lineTo(0.0F, 0.0F);
         this.m.lineTo(0.0F, this.getHeight());
         this.m.lineTo(this.getWidth(), this.getHeight());
         this.m.lineTo(this.getWidth(), 0.0F);
         this.m.lineTo(0.0F, 0.0F);
         this.m.close();
         var1.drawPath(this.h, this.e);
         var1.drawPath(this.m, this.e);
         var1.drawOval(this.i, this.f);
         var1.drawArc(this.j, 290.0F, 50.0F, false, this.g);
         if (this.B) {
            Rect var4 = new Rect(0, this.getHeight() - a, a, this.getHeight());

            Bitmap var5;
            try {
               var5 = BitmapRegionDecoder.newInstance(this.z.getPath(), false).decodeRegion(this.l, null);
            } catch (IOException var7) {
               return;
            }

            if (var5 != null) {
               try {
                  Rect var3 = new Rect(0, 0, var5.getWidth(), var5.getHeight());
                  var1.drawBitmap(var5, var3, var4, null);
               } catch (IOException var6) {
               }
            }
         }
      }
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (var1 instanceof Bundle) {
         this.p = ((Bundle)var1).getInt(b);
         this.q = this.p - 2;
         this.v = this.p / 4;
         this.n = ((Bundle)var1).getInt(c);
         this.o = ((Bundle)var1).getInt(d);
         this.b();
         super.onRestoreInstanceState(((Bundle)var1).getParcelable("instanceState"));
      } else {
         super.onRestoreInstanceState(var1);
      }
   }

   protected Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      var1.putInt(b, this.p);
      var1.putInt(c, this.n);
      var1.putInt(d, this.o);
      var1.putParcelable("instanceState", super.onSaveInstanceState());
      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if (this.n == -1) {
         var1 /= 2;
      } else {
         var1 = this.n;
      }

      this.n = var1;
      if (this.o == -1) {
         var1 = var2 / 2;
      } else {
         var1 = this.o;
      }

      this.o = var1;
      this.c();
      this.b();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (var1.getPointerCount() == 1 && this.getDrawable() != null) {
         float var8 = var1.getX();
         float var9 = var1.getY();
         switch (var1.getActionMasked()) {
            case 0:
               if (var8 >= this.n + this.p - this.v * 2 && var8 <= this.n + this.p && var9 >= this.o - this.p && var9 <= this.o - this.p + this.v * 2) {
                  this.A = true;
                  this.x = var8;
                  this.y = var9;
                  break;
               }

               this.A = false;
               this.n = this.a(this.q, (int)(var8 - this.p / 2));
               this.o = this.b(this.q, (int)(var9 - this.p / 2));
               break;
            case 1:
               this.A = false;
               break;
            case 2:
               if (this.A) {
                  double var2 = Math.sqrt(Math.pow(var8 - this.n, 2.0) + Math.pow(var9 - this.o, 2.0));
                  double var6 = Math.sqrt(Math.pow(this.x - this.n, 2.0) + Math.pow(this.y - this.o, 2.0));
                  double var4 = this.p;
                  int var10 = Math.min(Math.max((int)Math.round(var2 / var6 * var4), this.r), this.s);
                  this.p = this.a(this.p, var10, this.n, this.o);
                  this.q = this.p - 2;
                  this.v = this.p / 4;
                  this.x = var8;
                  this.y = var9;
               } else {
                  this.n = this.a(this.q, (int)(var8 - this.p / 2));
                  this.o = this.b(this.q, (int)(var9 - this.p / 2));
               }
         }

         this.b();
         this.invalidate();
      }

      return true;
   }

   public void setCropPreview(boolean var1) {
      this.B = var1;
   }

   public void setImageFile(File var1) {
      this.z = var1;
      this.c();
      this.b();
   }
}
