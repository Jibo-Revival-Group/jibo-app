package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class AppCompatProgressBarHelper {
   private static final int[] a = new int[]{16843067, 16843068};
   private final ProgressBar b;
   private Bitmap c;

   AppCompatProgressBarHelper(ProgressBar var1) {
      this.b = var1;
   }

   private Drawable a(Drawable var1) {
      Object var4 = var1;
      if (var1 instanceof AnimationDrawable) {
         AnimationDrawable var6 = (AnimationDrawable)var1;
         int var3 = var6.getNumberOfFrames();
         var4 = new AnimationDrawable();
         var4.setOneShot(var6.isOneShot());

         for (int var2 = 0; var2 < var3; var2++) {
            Drawable var5 = this.a(var6.getFrame(var2), true);
            var5.setLevel(10000);
            var4.addFrame(var5, var6.getDuration(var2));
         }

         var4.setLevel(10000);
      }

      return (Drawable)var4;
   }

   private Drawable a(Drawable var1, boolean var2) {
      byte var4 = 0;
      if (var1 instanceof WrappedDrawable) {
         Drawable var7 = ((WrappedDrawable)var1).a();
         if (var7 != null) {
            var7 = this.a(var7, var2);
            ((WrappedDrawable)var1).a(var7);
         }
      } else if (var1 instanceof LayerDrawable) {
         LayerDrawable var8 = (LayerDrawable)var1;
         int var5 = var8.getNumberOfLayers();
         Drawable[] var13 = new Drawable[var5];

         for (int var3 = 0; var3 < var5; var3++) {
            int var6 = var8.getId(var3);
            var1 = var8.getDrawable(var3);
            if (var6 != 16908301 && var6 != 16908303) {
               var2 = false;
            } else {
               var2 = true;
            }

            var13[var3] = this.a(var1, var2);
         }

         LayerDrawable var14 = new LayerDrawable(var13);
         int var11 = var4;

         while (true) {
            var1 = var14;
            if (var11 >= var5) {
               break;
            }

            var14.setId(var11, var8.getId(var11));
            var11++;
         }
      } else if (var1 instanceof BitmapDrawable) {
         BitmapDrawable var15 = (BitmapDrawable)var1;
         Bitmap var16 = var15.getBitmap();
         if (this.c == null) {
            this.c = var16;
         }

         var1 = new ShapeDrawable(this.b());
         BitmapShader var17 = new BitmapShader(var16, TileMode.REPEAT, TileMode.CLAMP);
         var1.getPaint().setShader(var17);
         var1.getPaint().setColorFilter(var15.getPaint().getColorFilter());
         if (var2) {
            var1 = new ClipDrawable(var1, 3, 1);
         }
      }

      return var1;
   }

   private Shape b() {
      return new RoundRectShape(new float[]{5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F}, null, null);
   }

   Bitmap a() {
      return this.c;
   }

   void a(AttributeSet var1, int var2) {
      TintTypedArray var4 = TintTypedArray.a(this.b.getContext(), var1, a, var2, 0);
      Drawable var3 = var4.b(0);
      if (var3 != null) {
         this.b.setIndeterminateDrawable(this.a(var3));
      }

      var3 = var4.b(1);
      if (var3 != null) {
         this.b.setProgressDrawable(this.a(var3, false));
      }

      var4.a();
   }
}
