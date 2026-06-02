package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView extends ImageView {
   int a;
   private AnimationListener b;

   CircleImageView(Context var1, int var2) {
      super(var1);
      float var3 = this.getContext().getResources().getDisplayMetrics().density;
      int var5 = (int)(1.75F * var3);
      int var4 = (int)(0.0F * var3);
      this.a = (int)(3.5F * var3);
      ShapeDrawable var6;
      if (this.a()) {
         var6 = new ShapeDrawable(new OvalShape());
         ViewCompat.a(this, var3 * 4.0F);
      } else {
         var6 = new ShapeDrawable(new CircleImageView.OvalShadow(this, this.a));
         this.setLayerType(1, var6.getPaint());
         var6.getPaint().setShadowLayer(this.a, var4, var5, 503316480);
         var4 = this.a;
         this.setPadding(var4, var4, var4, var4);
      }

      var6.getPaint().setColor(var2);
      ViewCompat.a(this, var6);
   }

   private boolean a() {
      boolean var1;
      if (VERSION.SDK_INT >= 21) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void a(AnimationListener var1) {
      this.b = var1;
   }

   public void onAnimationEnd() {
      super.onAnimationEnd();
      if (this.b != null) {
         this.b.onAnimationEnd(this.getAnimation());
      }
   }

   public void onAnimationStart() {
      super.onAnimationStart();
      if (this.b != null) {
         this.b.onAnimationStart(this.getAnimation());
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if (!this.a()) {
         this.setMeasuredDimension(this.getMeasuredWidth() + this.a * 2, this.getMeasuredHeight() + this.a * 2);
      }
   }

   public void setBackgroundColor(int var1) {
      if (this.getBackground() instanceof ShapeDrawable) {
         ((ShapeDrawable)this.getBackground()).getPaint().setColor(var1);
      }
   }

   private class OvalShadow extends OvalShape {
      final CircleImageView a;
      private RadialGradient b;
      private Paint c;

      OvalShadow(CircleImageView var1, int var2) {
         this.a = var1;
         this.c = new Paint();
         var1.a = var2;
         this.a((int)this.rect().width());
      }

      private void a(int var1) {
         float var4 = var1 / 2;
         float var3 = var1 / 2;
         float var2 = this.a.a;
         TileMode var5 = TileMode.CLAMP;
         this.b = new RadialGradient(var4, var3, var2, new int[]{1023410176, 0}, null, var5);
         this.c.setShader(this.b);
      }

      public void draw(Canvas var1, Paint var2) {
         int var4 = this.a.getWidth();
         int var3 = this.a.getHeight();
         var1.drawCircle(var4 / 2, var3 / 2, var4 / 2, this.c);
         var1.drawCircle(var4 / 2, var3 / 2, var4 / 2 - this.a.a, var2);
      }

      protected void onResize(float var1, float var2) {
         super.onResize(var1, var2);
         this.a((int)var1);
      }
   }
}
