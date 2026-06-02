package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ShadowDrawableWrapper extends DrawableWrapper {
   static final double a = Math.cos(Math.toRadians(45.0));
   final Paint b;
   final Paint c;
   final RectF d;
   float e;
   Path f;
   float g;
   float h;
   float i;
   float j;
   private boolean k = true;
   private final int l;
   private final int m;
   private final int n;
   private boolean o = true;
   private float p;
   private boolean q = false;

   public ShadowDrawableWrapper(Context var1, Drawable var2, float var3, float var4, float var5) {
      super(var2);
      this.l = ContextCompat.c(var1, R.color.design_fab_shadow_start_color);
      this.m = ContextCompat.c(var1, R.color.design_fab_shadow_mid_color);
      this.n = ContextCompat.c(var1, R.color.design_fab_shadow_end_color);
      this.b = new Paint(5);
      this.b.setStyle(Style.FILL);
      this.e = Math.round(var3);
      this.d = new RectF();
      this.c = new Paint(this.b);
      this.c.setAntiAlias(false);
      this.a(var4, var5);
   }

   public static float a(float var0, float var1, boolean var2) {
      if (var2) {
         var0 = (float)(1.5F * var0 + (1.0 - a) * var1);
      } else {
         var0 = 1.5F * var0;
      }

      return var0;
   }

   private void a(Canvas var1) {
      int var12 = var1.save();
      var1.rotate(this.p, this.d.centerX(), this.d.centerY());
      float var3 = -this.e - this.i;
      float var2 = this.e;
      boolean var10;
      if (this.d.width() - 2.0F * var2 > 0.0F) {
         var10 = 1;
      } else {
         var10 = 0;
      }

      boolean var11;
      if (this.d.height() - 2.0F * var2 > 0.0F) {
         var11 = true;
      } else {
         var11 = false;
      }

      float var7 = this.j;
      float var8 = this.j;
      float var9 = this.j;
      float var4 = this.j;
      float var6 = this.j;
      float var5 = this.j;
      var4 = var2 / (var9 - var4 * 0.5F + var2);
      var7 = var2 / (var7 - var8 * 0.25F + var2);
      var5 = var2 / (var2 + (var6 - var5 * 1.0F));
      int var13 = var1.save();
      var1.translate(this.d.left + var2, this.d.top + var2);
      var1.scale(var4, var7);
      var1.drawPath(this.f, this.b);
      if (var10) {
         var1.scale(1.0F / var4, 1.0F);
         var1.drawRect(0.0F, var3, this.d.width() - 2.0F * var2, -this.e, this.c);
      }

      var1.restoreToCount(var13);
      var13 = var1.save();
      var1.translate(this.d.right - var2, this.d.bottom - var2);
      var1.scale(var4, var5);
      var1.rotate(180.0F);
      var1.drawPath(this.f, this.b);
      if (var10) {
         var1.scale(1.0F / var4, 1.0F);
         var6 = this.d.width();
         var8 = -this.e;
         var1.drawRect(0.0F, var3, var6 - 2.0F * var2, this.i + var8, this.c);
      }

      var1.restoreToCount(var13);
      var10 = var1.save();
      var1.translate(this.d.left + var2, this.d.bottom - var2);
      var1.scale(var4, var5);
      var1.rotate(270.0F);
      var1.drawPath(this.f, this.b);
      if (var11) {
         var1.scale(1.0F / var5, 1.0F);
         var1.drawRect(0.0F, var3, this.d.height() - 2.0F * var2, -this.e, this.c);
      }

      var1.restoreToCount(var10);
      var10 = var1.save();
      var1.translate(this.d.right - var2, this.d.top + var2);
      var1.scale(var4, var7);
      var1.rotate(90.0F);
      var1.drawPath(this.f, this.b);
      if (var11) {
         var1.scale(1.0F / var7, 1.0F);
         var1.drawRect(0.0F, var3, this.d.height() - 2.0F * var2, -this.e, this.c);
      }

      var1.restoreToCount(var10);
      var1.restoreToCount(var12);
   }

   private void a(Rect var1) {
      float var2 = this.h * 1.5F;
      this.d.set(var1.left + this.h, var1.top + var2, var1.right - this.h, var1.bottom - var2);
      this.b().setBounds((int)this.d.left, (int)this.d.top, (int)this.d.right, (int)this.d.bottom);
      this.c();
   }

   public static float b(float var0, float var1, boolean var2) {
      float var3 = var0;
      if (var2) {
         var3 = (float)(var0 + (1.0 - a) * var1);
      }

      return var3;
   }

   private static int c(float var0) {
      int var2 = Math.round(var0);
      int var1 = var2;
      if (var2 % 2 == 1) {
         var1 = var2 - 1;
      }

      return var1;
   }

   private void c() {
      RectF var8 = new RectF(-this.e, -this.e, this.e, this.e);
      RectF var7 = new RectF(var8);
      var7.inset(-this.i, -this.i);
      if (this.f == null) {
         this.f = new Path();
      } else {
         this.f.reset();
      }

      this.f.setFillType(FillType.EVEN_ODD);
      this.f.moveTo(-this.e, 0.0F);
      this.f.rLineTo(-this.i, 0.0F);
      this.f.arcTo(var7, 180.0F, 90.0F, false);
      this.f.arcTo(var8, 270.0F, -90.0F, false);
      this.f.close();
      float var2 = -var7.top;
      if (var2 > 0.0F) {
         float var1 = this.e / var2;
         float var3 = (1.0F - var1) / 2.0F;
         Paint var9 = this.b;
         int var4 = this.l;
         int var6 = this.m;
         int var5 = this.n;
         TileMode var10 = TileMode.CLAMP;
         var9.setShader(new RadialGradient(0.0F, 0.0F, var2, new int[]{0, var4, var6, var5}, new float[]{0.0F, var1, var1 + var3, 1.0F}, var10));
      }

      Paint var17 = this.c;
      var2 = var8.top;
      float var11 = var7.top;
      int var15 = this.l;
      int var13 = this.m;
      int var14 = this.n;
      TileMode var16 = TileMode.CLAMP;
      var17.setShader(new LinearGradient(0.0F, var2, 0.0F, var11, new int[]{var15, var13, var14}, new float[]{0.0F, 0.5F, 1.0F}, var16));
      this.c.setAntiAlias(false);
   }

   public float a() {
      return this.j;
   }

   final void a(float var1) {
      if (this.p != var1) {
         this.p = var1;
         this.invalidateSelf();
      }
   }

   void a(float var1, float var2) {
      if (!(var1 < 0.0F) && !(var2 < 0.0F)) {
         float var3 = c(var1);
         var2 = c(var2);
         var1 = var3;
         if (var3 > var2) {
            if (!this.q) {
               this.q = true;
            }

            var1 = var2;
         }

         if (this.j != var1 || this.h != var2) {
            this.j = var1;
            this.h = var2;
            this.i = Math.round(var1 * 1.5F);
            this.g = var2;
            this.k = true;
            this.invalidateSelf();
         }
      } else {
         throw new IllegalArgumentException("invalid shadow size");
      }
   }

   public void a(boolean var1) {
      this.o = var1;
      this.invalidateSelf();
   }

   public void b(float var1) {
      this.a(var1, this.h);
   }

   @Override
   public void draw(Canvas var1) {
      if (this.k) {
         this.a(this.getBounds());
         this.k = false;
      }

      this.a(var1);
      super.draw(var1);
   }

   @Override
   public int getOpacity() {
      return -3;
   }

   @Override
   public boolean getPadding(Rect var1) {
      int var2 = (int)Math.ceil(a(this.h, this.e, this.o));
      int var3 = (int)Math.ceil(b(this.h, this.e, this.o));
      var1.set(var3, var2, var3, var2);
      return true;
   }

   @Override
   protected void onBoundsChange(Rect var1) {
      this.k = true;
   }

   @Override
   public void setAlpha(int var1) {
      super.setAlpha(var1);
      this.b.setAlpha(var1);
      this.c.setAlpha(var1);
   }
}
