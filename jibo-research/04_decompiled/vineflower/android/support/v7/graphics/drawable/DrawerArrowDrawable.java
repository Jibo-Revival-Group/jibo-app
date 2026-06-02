package android.support.v7.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

public class DrawerArrowDrawable extends Drawable {
   private static final float b = (float)Math.toRadians(45.0);
   private final Paint a;
   private float c;
   private float d;
   private float e;
   private float f;
   private boolean g;
   private final Path h;
   private final int i;
   private boolean j;
   private float k;
   private float l;
   private int m;

   private static float a(float var0, float var1, float var2) {
      return (var1 - var0) * var2 + var0;
   }

   public void a(float var1) {
      if (this.k != var1) {
         this.k = var1;
         this.invalidateSelf();
      }
   }

   public void a(boolean var1) {
      if (this.j != var1) {
         this.j = var1;
         this.invalidateSelf();
      }
   }

   public void draw(Canvas var1) {
      Rect var10 = this.getBounds();
      boolean var9;
      switch (this.m) {
         case 0:
            var9 = 0;
            break;
         case 1:
            var9 = 1;
            break;
         case 2:
         default:
            if (DrawableCompat.i(this) == 1) {
               var9 = 1;
            } else {
               var9 = 0;
            }
            break;
         case 3:
            if (DrawableCompat.i(this) == 0) {
               var9 = 1;
            } else {
               var9 = 0;
            }
      }

      float var2 = (float)Math.sqrt(this.c * this.c * 2.0F);
      float var7 = a(this.d, var2, this.k);
      float var5 = a(this.d, this.e, this.k);
      float var4 = Math.round(a(0.0F, this.l, this.k));
      float var6 = a(0.0F, b, this.k);
      if (var9) {
         var2 = 0.0F;
      } else {
         var2 = -180.0F;
      }

      float var3;
      if (var9) {
         var3 = 180.0F;
      } else {
         var3 = 0.0F;
      }

      var2 = a(var2, var3, this.k);
      var3 = (float)Math.round(var7 * Math.cos(var6));
      var6 = (float)Math.round(var7 * Math.sin(var6));
      this.h.rewind();
      var7 = a(this.f + this.a.getStrokeWidth(), -this.l, this.k);
      float var8 = -var5 / 2.0F;
      this.h.moveTo(var8 + var4, 0.0F);
      this.h.rLineTo(var5 - var4 * 2.0F, 0.0F);
      this.h.moveTo(var8, var7);
      this.h.rLineTo(var3, var6);
      this.h.moveTo(var8, -var7);
      this.h.rLineTo(var3, -var6);
      this.h.close();
      var1.save();
      var5 = this.a.getStrokeWidth();
      var4 = (int)(var10.height() - 3.0F * var5 - this.f * 2.0F) / 4 * 2;
      var3 = this.f;
      var1.translate(var10.centerX(), var5 * 1.5F + var3 + var4);
      if (this.g) {
         if (var9 ^ this.j) {
            var9 = -1;
         } else {
            var9 = 1;
         }

         var1.rotate(var9 * var2);
      } else if (var9) {
         var1.rotate(180.0F);
      }

      var1.drawPath(this.h, this.a);
      var1.restore();
   }

   public int getIntrinsicHeight() {
      return this.i;
   }

   public int getIntrinsicWidth() {
      return this.i;
   }

   public int getOpacity() {
      return -3;
   }

   public void setAlpha(int var1) {
      if (var1 != this.a.getAlpha()) {
         this.a.setAlpha(var1);
         this.invalidateSelf();
      }
   }

   public void setColorFilter(ColorFilter var1) {
      this.a.setColorFilter(var1);
      this.invalidateSelf();
   }
}
