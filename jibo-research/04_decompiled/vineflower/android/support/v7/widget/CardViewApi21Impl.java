package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class CardViewApi21Impl implements CardViewImpl {
   private RoundRectDrawable j(CardViewDelegate var1) {
      return (RoundRectDrawable)var1.c();
   }

   @Override
   public float a(CardViewDelegate var1) {
      return this.j(var1).a();
   }

   @Override
   public void a() {
   }

   @Override
   public void a(CardViewDelegate var1, float var2) {
      this.j(var1).a(var2);
   }

   @Override
   public void a(CardViewDelegate var1, Context var2, ColorStateList var3, float var4, float var5, float var6) {
      var1.a(new RoundRectDrawable(var3, var4));
      View var7 = var1.d();
      var7.setClipToOutline(true);
      var7.setElevation(var5);
      this.b(var1, var6);
   }

   @Override
   public void a(CardViewDelegate var1, ColorStateList var2) {
      this.j(var1).a(var2);
   }

   @Override
   public float b(CardViewDelegate var1) {
      return this.d(var1) * 2.0F;
   }

   @Override
   public void b(CardViewDelegate var1, float var2) {
      this.j(var1).a(var2, var1.a(), var1.b());
      this.f(var1);
   }

   @Override
   public float c(CardViewDelegate var1) {
      return this.d(var1) * 2.0F;
   }

   @Override
   public void c(CardViewDelegate var1, float var2) {
      var1.d().setElevation(var2);
   }

   @Override
   public float d(CardViewDelegate var1) {
      return this.j(var1).b();
   }

   @Override
   public float e(CardViewDelegate var1) {
      return var1.d().getElevation();
   }

   public void f(CardViewDelegate var1) {
      if (!var1.a()) {
         var1.a(0, 0, 0, 0);
      } else {
         float var2 = this.a(var1);
         float var3 = this.d(var1);
         int var4 = (int)Math.ceil(RoundRectDrawableWithShadow.b(var2, var3, var1.b()));
         int var5 = (int)Math.ceil(RoundRectDrawableWithShadow.a(var2, var3, var1.b()));
         var1.a(var4, var5, var4, var5);
      }
   }

   @Override
   public void g(CardViewDelegate var1) {
      this.b(var1, this.a(var1));
   }

   @Override
   public void h(CardViewDelegate var1) {
      this.b(var1, this.a(var1));
   }

   @Override
   public ColorStateList i(CardViewDelegate var1) {
      return this.j(var1).c();
   }
}
