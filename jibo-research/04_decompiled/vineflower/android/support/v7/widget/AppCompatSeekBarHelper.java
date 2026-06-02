package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
   private final SeekBar a;
   private Drawable b;
   private ColorStateList c = null;
   private Mode d = null;
   private boolean e = false;
   private boolean f = false;

   AppCompatSeekBarHelper(SeekBar var1) {
      super(var1);
      this.a = var1;
   }

   private void d() {
      if (this.b != null && (this.e || this.f)) {
         this.b = DrawableCompat.g(this.b.mutate());
         if (this.e) {
            DrawableCompat.a(this.b, this.c);
         }

         if (this.f) {
            DrawableCompat.a(this.b, this.d);
         }

         if (this.b.isStateful()) {
            this.b.setState(this.a.getDrawableState());
         }
      }
   }

   void a(Canvas var1) {
      int var4 = 1;
      if (this.b != null) {
         int var5 = this.a.getMax();
         if (var5 > 1) {
            int var3 = this.b.getIntrinsicWidth();
            int var6 = this.b.getIntrinsicHeight();
            if (var3 >= 0) {
               var3 /= 2;
            } else {
               var3 = 1;
            }

            if (var6 >= 0) {
               var4 = var6 / 2;
            }

            this.b.setBounds(-var3, -var4, var3, var4);
            float var2 = (float)(this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight()) / var5;
            var4 = var1.save();
            var1.translate(this.a.getPaddingLeft(), this.a.getHeight() / 2);

            for (int var8 = 0; var8 <= var5; var8++) {
               this.b.draw(var1);
               var1.translate(var2, 0.0F);
            }

            var1.restoreToCount(var4);
         }
      }
   }

   void a(Drawable var1) {
      if (this.b != null) {
         this.b.setCallback(null);
      }

      this.b = var1;
      if (var1 != null) {
         var1.setCallback(this.a);
         DrawableCompat.b(var1, ViewCompat.e(this.a));
         if (var1.isStateful()) {
            var1.setState(this.a.getDrawableState());
         }

         this.d();
      }

      this.a.invalidate();
   }

   @Override
   void a(AttributeSet var1, int var2) {
      super.a(var1, var2);
      TintTypedArray var3 = TintTypedArray.a(this.a.getContext(), var1, R.styleable.AppCompatSeekBar, var2, 0);
      Drawable var4 = var3.b(R.styleable.AppCompatSeekBar_android_thumb);
      if (var4 != null) {
         this.a.setThumb(var4);
      }

      this.a(var3.a(R.styleable.AppCompatSeekBar_tickMark));
      if (var3.g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
         this.d = DrawableUtils.a(var3.a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
         this.f = true;
      }

      if (var3.g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
         this.c = var3.e(R.styleable.AppCompatSeekBar_tickMarkTint);
         this.e = true;
      }

      var3.a();
      this.d();
   }

   void b() {
      if (this.b != null) {
         this.b.jumpToCurrentState();
      }
   }

   void c() {
      Drawable var1 = this.b;
      if (var1 != null && var1.isStateful() && var1.setState(this.a.getDrawableState())) {
         this.a.invalidateDrawable(var1);
      }
   }
}
