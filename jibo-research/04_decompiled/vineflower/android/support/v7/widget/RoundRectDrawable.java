package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class RoundRectDrawable extends Drawable {
   private float a;
   private final Paint b;
   private final RectF c;
   private final Rect d;
   private float e;
   private boolean f = false;
   private boolean g = true;
   private ColorStateList h;
   private PorterDuffColorFilter i;
   private ColorStateList j;
   private Mode k = Mode.SRC_IN;

   RoundRectDrawable(ColorStateList var1, float var2) {
      this.a = var2;
      this.b = new Paint(5);
      this.b(var1);
      this.c = new RectF();
      this.d = new Rect();
   }

   private PorterDuffColorFilter a(ColorStateList var1, Mode var2) {
      PorterDuffColorFilter var3;
      if (var1 != null && var2 != null) {
         var3 = new PorterDuffColorFilter(var1.getColorForState(this.getState(), 0), var2);
      } else {
         var3 = null;
      }

      return var3;
   }

   private void a(Rect var1) {
      Rect var4 = var1;
      if (var1 == null) {
         var4 = this.getBounds();
      }

      this.c.set(var4.left, var4.top, var4.right, var4.bottom);
      this.d.set(var4);
      if (this.f) {
         float var3 = RoundRectDrawableWithShadow.a(this.e, this.a, this.g);
         float var2 = RoundRectDrawableWithShadow.b(this.e, this.a, this.g);
         this.d.inset((int)Math.ceil(var2), (int)Math.ceil(var3));
         this.c.set(this.d);
      }
   }

   private void b(ColorStateList var1) {
      ColorStateList var2 = var1;
      if (var1 == null) {
         var2 = ColorStateList.valueOf(0);
      }

      this.h = var2;
      this.b.setColor(this.h.getColorForState(this.getState(), this.h.getDefaultColor()));
   }

   float a() {
      return this.e;
   }

   void a(float var1) {
      if (var1 != this.a) {
         this.a = var1;
         this.a((Rect)null);
         this.invalidateSelf();
      }
   }

   void a(float var1, boolean var2, boolean var3) {
      if (var1 != this.e || this.f != var2 || this.g != var3) {
         this.e = var1;
         this.f = var2;
         this.g = var3;
         this.a((Rect)null);
         this.invalidateSelf();
      }
   }

   public void a(ColorStateList var1) {
      this.b(var1);
      this.invalidateSelf();
   }

   public float b() {
      return this.a;
   }

   public ColorStateList c() {
      return this.h;
   }

   public void draw(Canvas var1) {
      Paint var3 = this.b;
      boolean var2;
      if (this.i != null && var3.getColorFilter() == null) {
         var3.setColorFilter(this.i);
         var2 = true;
      } else {
         var2 = false;
      }

      var1.drawRoundRect(this.c, this.a, this.a, var3);
      if (var2) {
         var3.setColorFilter(null);
      }
   }

   public int getOpacity() {
      return -3;
   }

   public void getOutline(Outline var1) {
      var1.setRoundRect(this.d, this.a);
   }

   public boolean isStateful() {
      boolean var1;
      if ((this.j == null || !this.j.isStateful()) && (this.h == null || !this.h.isStateful()) && !super.isStateful()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   protected void onBoundsChange(Rect var1) {
      super.onBoundsChange(var1);
      this.a(var1);
   }

   protected boolean onStateChange(int[] var1) {
      boolean var4 = true;
      int var2 = this.h.getColorForState(var1, this.h.getDefaultColor());
      boolean var3;
      if (var2 != this.b.getColor()) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (var3) {
         this.b.setColor(var2);
      }

      if (this.j != null && this.k != null) {
         this.i = this.a(this.j, this.k);
         var3 = var4;
      }

      return var3;
   }

   public void setAlpha(int var1) {
      this.b.setAlpha(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.b.setColorFilter(var1);
   }

   public void setTintList(ColorStateList var1) {
      this.j = var1;
      this.i = this.a(this.j, this.k);
      this.invalidateSelf();
   }

   public void setTintMode(Mode var1) {
      this.k = var1;
      this.i = this.a(this.j, this.k);
      this.invalidateSelf();
   }
}
