package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import android.support.v7.cardview.R;

class RoundRectDrawableWithShadow extends Drawable {
   static RoundRectDrawableWithShadow.RoundRectHelper a;
   private static final double b = Math.cos(Math.toRadians(45.0));
   private final int c;
   private Paint d;
   private Paint e;
   private Paint f;
   private final RectF g;
   private float h;
   private Path i;
   private float j;
   private float k;
   private float l;
   private ColorStateList m;
   private boolean n = true;
   private final int o;
   private final int p;
   private boolean q = true;
   private boolean r = false;

   RoundRectDrawableWithShadow(Resources var1, ColorStateList var2, float var3, float var4, float var5) {
      this.o = var1.getColor(R.color.cardview_shadow_start_color);
      this.p = var1.getColor(R.color.cardview_shadow_end_color);
      this.c = var1.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
      this.d = new Paint(5);
      this.b(var2);
      this.e = new Paint(5);
      this.e.setStyle(Style.FILL);
      this.h = (int)(0.5F + var3);
      this.g = new RectF();
      this.f = new Paint(this.e);
      this.f.setAntiAlias(false);
      this.a(var4, var5);
   }

   static float a(float var0, float var1, boolean var2) {
      if (var2) {
         var0 = (float)(1.5F * var0 + (1.0 - b) * var1);
      } else {
         var0 = 1.5F * var0;
      }

      return var0;
   }

   private void a(float var1, float var2) {
      if (var1 < 0.0F) {
         throw new IllegalArgumentException("Invalid shadow size " + var1 + ". Must be >= 0");
      }

      if (var2 < 0.0F) {
         throw new IllegalArgumentException("Invalid max shadow size " + var2 + ". Must be >= 0");
      }

      float var3 = this.d(var1);
      var2 = this.d(var2);
      var1 = var3;
      if (var3 > var2) {
         if (!this.r) {
            this.r = true;
         }

         var1 = var2;
      }

      if (this.l != var1 || this.j != var2) {
         this.l = var1;
         this.j = var2;
         this.k = (int)(var1 * 1.5F + this.c + 0.5F);
         this.n = true;
         this.invalidateSelf();
      }
   }

   private void a(Canvas var1) {
      float var2 = -this.h - this.k;
      float var3 = this.h + this.c + this.l / 2.0F;
      boolean var6;
      if (this.g.width() - 2.0F * var3 > 0.0F) {
         var6 = 1;
      } else {
         var6 = 0;
      }

      boolean var7;
      if (this.g.height() - 2.0F * var3 > 0.0F) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var8 = var1.save();
      var1.translate(this.g.left + var3, this.g.top + var3);
      var1.drawPath(this.i, this.e);
      if (var6) {
         var1.drawRect(0.0F, var2, this.g.width() - 2.0F * var3, -this.h, this.f);
      }

      var1.restoreToCount(var8);
      var8 = var1.save();
      var1.translate(this.g.right - var3, this.g.bottom - var3);
      var1.rotate(180.0F);
      var1.drawPath(this.i, this.e);
      if (var6) {
         float var4 = this.g.width();
         float var5 = -this.h;
         var1.drawRect(0.0F, var2, var4 - 2.0F * var3, this.k + var5, this.f);
      }

      var1.restoreToCount(var8);
      var6 = var1.save();
      var1.translate(this.g.left + var3, this.g.bottom - var3);
      var1.rotate(270.0F);
      var1.drawPath(this.i, this.e);
      if (var7) {
         var1.drawRect(0.0F, var2, this.g.height() - 2.0F * var3, -this.h, this.f);
      }

      var1.restoreToCount(var6);
      var6 = var1.save();
      var1.translate(this.g.right - var3, this.g.top + var3);
      var1.rotate(90.0F);
      var1.drawPath(this.i, this.e);
      if (var7) {
         var1.drawRect(0.0F, var2, this.g.height() - 2.0F * var3, -this.h, this.f);
      }

      var1.restoreToCount(var6);
   }

   static float b(float var0, float var1, boolean var2) {
      float var3 = var0;
      if (var2) {
         var3 = (float)(var0 + (1.0 - b) * var1);
      }

      return var3;
   }

   private void b(ColorStateList var1) {
      ColorStateList var2 = var1;
      if (var1 == null) {
         var2 = ColorStateList.valueOf(0);
      }

      this.m = var2;
      this.d.setColor(this.m.getColorForState(this.getState(), this.m.getDefaultColor()));
   }

   private void b(Rect var1) {
      float var2 = this.j * 1.5F;
      this.g.set(var1.left + this.j, var1.top + var2, var1.right - this.j, var1.bottom - var2);
      this.g();
   }

   private int d(float var1) {
      int var3 = (int)(0.5F + var1);
      int var2 = var3;
      if (var3 % 2 == 1) {
         var2 = var3 - 1;
      }

      return var2;
   }

   private void g() {
      RectF var8 = new RectF(-this.h, -this.h, this.h, this.h);
      RectF var9 = new RectF(var8);
      var9.inset(-this.k, -this.k);
      if (this.i == null) {
         this.i = new Path();
      } else {
         this.i.reset();
      }

      this.i.setFillType(FillType.EVEN_ODD);
      this.i.moveTo(-this.h, 0.0F);
      this.i.rLineTo(-this.k, 0.0F);
      this.i.arcTo(var9, 180.0F, 90.0F, false);
      this.i.arcTo(var8, 270.0F, -90.0F, false);
      this.i.close();
      float var2 = this.h / (this.h + this.k);
      Paint var18 = this.e;
      float var1 = this.h;
      float var3 = this.k;
      int var5 = this.o;
      int var6 = this.o;
      int var7 = this.p;
      TileMode var16 = TileMode.CLAMP;
      var18.setShader(new RadialGradient(0.0F, 0.0F, var1 + var3, new int[]{var5, var6, var7}, new float[]{0.0F, var2, 1.0F}, var16));
      Paint var19 = this.f;
      var3 = -this.h;
      var1 = this.k;
      float var4 = -this.h;
      var2 = this.k;
      var6 = this.o;
      var7 = this.o;
      var5 = this.p;
      TileMode var17 = TileMode.CLAMP;
      var19.setShader(new LinearGradient(0.0F, var3 + var1, 0.0F, var4 - var2, new int[]{var6, var7, var5}, new float[]{0.0F, 0.5F, 1.0F}, var17));
      this.f.setAntiAlias(false);
   }

   float a() {
      return this.h;
   }

   void a(float var1) {
      if (var1 < 0.0F) {
         throw new IllegalArgumentException("Invalid radius " + var1 + ". Must be >= 0");
      }

      var1 = (int)(0.5F + var1);
      if (this.h != var1) {
         this.h = var1;
         this.n = true;
         this.invalidateSelf();
      }
   }

   void a(ColorStateList var1) {
      this.b(var1);
      this.invalidateSelf();
   }

   void a(Rect var1) {
      this.getPadding(var1);
   }

   void a(boolean var1) {
      this.q = var1;
      this.invalidateSelf();
   }

   float b() {
      return this.l;
   }

   void b(float var1) {
      this.a(var1, this.j);
   }

   float c() {
      return this.j;
   }

   void c(float var1) {
      this.a(this.l, var1);
   }

   float d() {
      return Math.max(this.j, this.h + this.c + this.j / 2.0F) * 2.0F + (this.j + this.c) * 2.0F;
   }

   public void draw(Canvas var1) {
      if (this.n) {
         this.b(this.getBounds());
         this.n = false;
      }

      var1.translate(0.0F, this.l / 2.0F);
      this.a(var1);
      var1.translate(0.0F, -this.l / 2.0F);
      a.a(var1, this.g, this.h, this.d);
   }

   float e() {
      return Math.max(this.j, this.h + this.c + this.j * 1.5F / 2.0F) * 2.0F + (this.j * 1.5F + this.c) * 2.0F;
   }

   ColorStateList f() {
      return this.m;
   }

   public int getOpacity() {
      return -3;
   }

   public boolean getPadding(Rect var1) {
      int var2 = (int)Math.ceil(a(this.j, this.h, this.q));
      int var3 = (int)Math.ceil(b(this.j, this.h, this.q));
      var1.set(var3, var2, var3, var2);
      return true;
   }

   public boolean isStateful() {
      boolean var1;
      if ((this.m == null || !this.m.isStateful()) && !super.isStateful()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   protected void onBoundsChange(Rect var1) {
      super.onBoundsChange(var1);
      this.n = true;
   }

   protected boolean onStateChange(int[] var1) {
      boolean var3 = true;
      int var2 = this.m.getColorForState(var1, this.m.getDefaultColor());
      if (this.d.getColor() == var2) {
         var3 = false;
      } else {
         this.d.setColor(var2);
         this.n = true;
         this.invalidateSelf();
      }

      return var3;
   }

   public void setAlpha(int var1) {
      this.d.setAlpha(var1);
      this.e.setAlpha(var1);
      this.f.setAlpha(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.d.setColorFilter(var1);
   }

   interface RoundRectHelper {
      void a(Canvas var1, RectF var2, float var3, Paint var4);
   }
}
