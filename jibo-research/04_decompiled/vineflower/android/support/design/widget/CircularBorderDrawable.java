package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;

class CircularBorderDrawable extends Drawable {
   final Paint a;
   final Rect b = new Rect();
   final RectF c = new RectF();
   float d;
   private int e;
   private int f;
   private int g;
   private int h;
   private ColorStateList i;
   private int j;
   private boolean k = true;
   private float l;

   public CircularBorderDrawable() {
      this.a = new Paint(1);
      this.a.setStyle(Style.STROKE);
   }

   private Shader a() {
      Rect var10 = this.b;
      this.copyBounds(var10);
      float var1 = this.d / var10.height();
      int var4 = ColorUtils.a(this.e, this.j);
      int var9 = ColorUtils.a(this.f, this.j);
      int var6 = ColorUtils.a(ColorUtils.b(this.f, 0), this.j);
      int var5 = ColorUtils.a(ColorUtils.b(this.h, 0), this.j);
      int var7 = ColorUtils.a(this.h, this.j);
      int var8 = ColorUtils.a(this.g, this.j);
      float var3 = var10.top;
      float var2 = var10.bottom;
      TileMode var11 = TileMode.CLAMP;
      return new LinearGradient(
         0.0F, var3, 0.0F, var2, new int[]{var4, var9, var6, var5, var7, var8}, new float[]{0.0F, var1, 0.5F, 0.5F, 1.0F - var1, 1.0F}, var11
      );
   }

   void a(float var1) {
      if (this.d != var1) {
         this.d = var1;
         this.a.setStrokeWidth(1.3333F * var1);
         this.k = true;
         this.invalidateSelf();
      }
   }

   void a(int var1, int var2, int var3, int var4) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
   }

   void a(ColorStateList var1) {
      if (var1 != null) {
         this.j = var1.getColorForState(this.getState(), this.j);
      }

      this.i = var1;
      this.k = true;
      this.invalidateSelf();
   }

   final void b(float var1) {
      if (var1 != this.l) {
         this.l = var1;
         this.invalidateSelf();
      }
   }

   public void draw(Canvas var1) {
      if (this.k) {
         this.a.setShader(this.a());
         this.k = false;
      }

      float var2 = this.a.getStrokeWidth() / 2.0F;
      RectF var3 = this.c;
      this.copyBounds(this.b);
      var3.set(this.b);
      var3.left += var2;
      var3.top += var2;
      var3.right -= var2;
      var3.bottom -= var2;
      var1.save();
      var1.rotate(this.l, var3.centerX(), var3.centerY());
      var1.drawOval(var3, this.a);
      var1.restore();
   }

   public int getOpacity() {
      byte var1;
      if (this.d > 0.0F) {
         var1 = -3;
      } else {
         var1 = -2;
      }

      return var1;
   }

   public boolean getPadding(Rect var1) {
      int var2 = Math.round(this.d);
      var1.set(var2, var2, var2, var2);
      return true;
   }

   public boolean isStateful() {
      boolean var1;
      if ((this.i == null || !this.i.isStateful()) && !super.isStateful()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   protected void onBoundsChange(Rect var1) {
      this.k = true;
   }

   protected boolean onStateChange(int[] var1) {
      if (this.i != null) {
         int var2 = this.i.getColorForState(var1, this.j);
         if (var2 != this.j) {
            this.k = true;
            this.j = var2;
         }
      }

      if (this.k) {
         this.invalidateSelf();
      }

      return this.k;
   }

   public void setAlpha(int var1) {
      this.a.setAlpha(var1);
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.a.setColorFilter(var1);
      this.invalidateSelf();
   }
}
