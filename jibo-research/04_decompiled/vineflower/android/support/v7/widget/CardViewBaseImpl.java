package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class CardViewBaseImpl implements CardViewImpl {
   private final RectF a = new RectF();

   private RoundRectDrawableWithShadow a(Context var1, ColorStateList var2, float var3, float var4, float var5) {
      return new RoundRectDrawableWithShadow(var1.getResources(), var2, var3, var4, var5);
   }

   private RoundRectDrawableWithShadow j(CardViewDelegate var1) {
      return (RoundRectDrawableWithShadow)var1.c();
   }

   @Override
   public float a(CardViewDelegate var1) {
      return this.j(var1).c();
   }

   @Override
   public void a() {
      RoundRectDrawableWithShadow.a = new RoundRectDrawableWithShadow.RoundRectHelper(this) {
         final CardViewBaseImpl a;

         {
            this.a = var1;
         }

         @Override
         public void a(Canvas var1, RectF var2, float var3, Paint var4) {
            float var6 = 2.0F * var3;
            float var8 = var2.width() - var6 - 1.0F;
            float var5 = var2.height();
            if (var3 >= 1.0F) {
               float var7 = var3 + 0.5F;
               this.a.a.set(-var7, -var7, var7, var7);
               int var9 = var1.save();
               var1.translate(var2.left + var7, var2.top + var7);
               var1.drawArc(this.a.a, 180.0F, 90.0F, true, var4);
               var1.translate(var8, 0.0F);
               var1.rotate(90.0F);
               var1.drawArc(this.a.a, 180.0F, 90.0F, true, var4);
               var1.translate(var5 - var6 - 1.0F, 0.0F);
               var1.rotate(90.0F);
               var1.drawArc(this.a.a, 180.0F, 90.0F, true, var4);
               var1.translate(var8, 0.0F);
               var1.rotate(90.0F);
               var1.drawArc(this.a.a, 180.0F, 90.0F, true, var4);
               var1.restoreToCount(var9);
               var1.drawRect(var2.left + var7 - 1.0F, var2.top, 1.0F + (var2.right - var7), var2.top + var7, var4);
               var1.drawRect(var2.left + var7 - 1.0F, var2.bottom - var7, 1.0F + (var2.right - var7), var2.bottom, var4);
            }

            var1.drawRect(var2.left, var2.top + var3, var2.right, var2.bottom - var3, var4);
         }
      };
   }

   @Override
   public void a(CardViewDelegate var1, float var2) {
      this.j(var1).a(var2);
      this.f(var1);
   }

   @Override
   public void a(CardViewDelegate var1, Context var2, ColorStateList var3, float var4, float var5, float var6) {
      RoundRectDrawableWithShadow var7 = this.a(var2, var3, var4, var5, var6);
      var7.a(var1.b());
      var1.a(var7);
      this.f(var1);
   }

   @Override
   public void a(CardViewDelegate var1, ColorStateList var2) {
      this.j(var1).a(var2);
   }

   @Override
   public float b(CardViewDelegate var1) {
      return this.j(var1).d();
   }

   @Override
   public void b(CardViewDelegate var1, float var2) {
      this.j(var1).c(var2);
      this.f(var1);
   }

   @Override
   public float c(CardViewDelegate var1) {
      return this.j(var1).e();
   }

   @Override
   public void c(CardViewDelegate var1, float var2) {
      this.j(var1).b(var2);
   }

   @Override
   public float d(CardViewDelegate var1) {
      return this.j(var1).a();
   }

   @Override
   public float e(CardViewDelegate var1) {
      return this.j(var1).b();
   }

   public void f(CardViewDelegate var1) {
      Rect var2 = new Rect();
      this.j(var1).a(var2);
      var1.a((int)Math.ceil(this.b(var1)), (int)Math.ceil(this.c(var1)));
      var1.a(var2.left, var2.top, var2.right, var2.bottom);
   }

   @Override
   public void g(CardViewDelegate var1) {
   }

   @Override
   public void h(CardViewDelegate var1) {
      this.j(var1).a(var1.b());
      this.f(var1);
   }

   @Override
   public ColorStateList i(CardViewDelegate var1) {
      return this.j(var1).f();
   }
}
