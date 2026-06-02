package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public abstract class RoundedBitmapDrawable extends Drawable {
   final Bitmap a;
   final Rect b;
   private int c = 160;
   private int d = 119;
   private final Paint e = new Paint(3);
   private final BitmapShader f;
   private final Matrix g = new Matrix();
   private float h;
   private final RectF i;
   private boolean j;
   private boolean k;
   private int l;
   private int m;

   RoundedBitmapDrawable(Resources var1, Bitmap var2) {
      this.b = new Rect();
      this.i = new RectF();
      this.j = true;
      if (var1 != null) {
         this.c = var1.getDisplayMetrics().densityDpi;
      }

      this.a = var2;
      if (this.a != null) {
         this.c();
         this.f = new BitmapShader(this.a, TileMode.CLAMP, TileMode.CLAMP);
      } else {
         this.m = -1;
         this.l = -1;
         this.f = null;
      }
   }

   private static boolean b(float var0) {
      boolean var1;
      if (var0 > 0.05F) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void c() {
      this.l = this.a.getScaledWidth(this.c);
      this.m = this.a.getScaledHeight(this.c);
   }

   private void d() {
      this.h = Math.min(this.m, this.l) / 2;
   }

   void a() {
      if (this.j) {
         if (this.k) {
            int var1 = Math.min(this.l, this.m);
            this.a(this.d, var1, var1, this.getBounds(), this.b);
            int var2 = Math.min(this.b.width(), this.b.height());
            var1 = Math.max(0, (this.b.width() - var2) / 2);
            int var3 = Math.max(0, (this.b.height() - var2) / 2);
            this.b.inset(var1, var3);
            this.h = var2 * 0.5F;
         } else {
            this.a(this.d, this.l, this.m, this.getBounds(), this.b);
         }

         this.i.set(this.b);
         if (this.f != null) {
            this.g.setTranslate(this.i.left, this.i.top);
            this.g.preScale(this.i.width() / this.a.getWidth(), this.i.height() / this.a.getHeight());
            this.f.setLocalMatrix(this.g);
            this.e.setShader(this.f);
         }

         this.j = false;
      }
   }

   public void a(float var1) {
      if (this.h != var1) {
         this.k = false;
         if (b(var1)) {
            this.e.setShader(this.f);
         } else {
            this.e.setShader(null);
         }

         this.h = var1;
         this.invalidateSelf();
      }
   }

   void a(int var1, int var2, int var3, Rect var4, Rect var5) {
      throw new UnsupportedOperationException();
   }

   public void a(boolean var1) {
      this.k = var1;
      this.j = true;
      if (var1) {
         this.d();
         this.e.setShader(this.f);
         this.invalidateSelf();
      } else {
         this.a(0.0F);
      }
   }

   public float b() {
      return this.h;
   }

   public void draw(Canvas var1) {
      Bitmap var2 = this.a;
      if (var2 != null) {
         this.a();
         if (this.e.getShader() == null) {
            var1.drawBitmap(var2, null, this.b, this.e);
         } else {
            var1.drawRoundRect(this.i, this.h, this.h, this.e);
         }
      }
   }

   public int getAlpha() {
      return this.e.getAlpha();
   }

   public ColorFilter getColorFilter() {
      return this.e.getColorFilter();
   }

   public int getIntrinsicHeight() {
      return this.m;
   }

   public int getIntrinsicWidth() {
      return this.l;
   }

   public int getOpacity() {
      byte var2 = -3;
      byte var1 = var2;
      if (this.d == 119) {
         if (this.k) {
            var1 = var2;
         } else {
            Bitmap var3 = this.a;
            var1 = var2;
            if (var3 != null) {
               var1 = var2;
               if (!var3.hasAlpha()) {
                  var1 = var2;
                  if (this.e.getAlpha() >= 255) {
                     var1 = var2;
                     if (!b(this.h)) {
                        var1 = -1;
                     }
                  }
               }
            }
         }
      }

      return var1;
   }

   protected void onBoundsChange(Rect var1) {
      super.onBoundsChange(var1);
      if (this.k) {
         this.d();
      }

      this.j = true;
   }

   public void setAlpha(int var1) {
      if (var1 != this.e.getAlpha()) {
         this.e.setAlpha(var1);
         this.invalidateSelf();
      }
   }

   public void setColorFilter(ColorFilter var1) {
      this.e.setColorFilter(var1);
      this.invalidateSelf();
   }

   public void setDither(boolean var1) {
      this.e.setDither(var1);
      this.invalidateSelf();
   }

   public void setFilterBitmap(boolean var1) {
      this.e.setFilterBitmap(var1);
      this.invalidateSelf();
   }
}
