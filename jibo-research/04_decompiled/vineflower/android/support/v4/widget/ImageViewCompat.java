package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class ImageViewCompat {
   static final ImageViewCompat.ImageViewCompatImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new ImageViewCompat.LollipopViewCompatImpl();
      } else {
         a = new ImageViewCompat.BaseViewCompatImpl();
      }
   }

   public static ColorStateList a(ImageView var0) {
      return a.a(var0);
   }

   public static void a(ImageView var0, ColorStateList var1) {
      a.a(var0, var1);
   }

   public static void a(ImageView var0, Mode var1) {
      a.a(var0, var1);
   }

   public static Mode b(ImageView var0) {
      return a.b(var0);
   }

   static class BaseViewCompatImpl implements ImageViewCompat.ImageViewCompatImpl {
      @Override
      public ColorStateList a(ImageView var1) {
         ColorStateList var2;
         if (var1 instanceof TintableImageSourceView) {
            var2 = ((TintableImageSourceView)var1).getSupportImageTintList();
         } else {
            var2 = null;
         }

         return var2;
      }

      @Override
      public void a(ImageView var1, ColorStateList var2) {
         if (var1 instanceof TintableImageSourceView) {
            ((TintableImageSourceView)var1).setSupportImageTintList(var2);
         }
      }

      @Override
      public void a(ImageView var1, Mode var2) {
         if (var1 instanceof TintableImageSourceView) {
            ((TintableImageSourceView)var1).setSupportImageTintMode(var2);
         }
      }

      @Override
      public Mode b(ImageView var1) {
         Mode var2;
         if (var1 instanceof TintableImageSourceView) {
            var2 = ((TintableImageSourceView)var1).getSupportImageTintMode();
         } else {
            var2 = null;
         }

         return var2;
      }
   }

   interface ImageViewCompatImpl {
      ColorStateList a(ImageView var1);

      void a(ImageView var1, ColorStateList var2);

      void a(ImageView var1, Mode var2);

      Mode b(ImageView var1);
   }

   static class LollipopViewCompatImpl extends ImageViewCompat.BaseViewCompatImpl {
      @Override
      public ColorStateList a(ImageView var1) {
         return var1.getImageTintList();
      }

      @Override
      public void a(ImageView var1, ColorStateList var2) {
         var1.setImageTintList(var2);
         if (VERSION.SDK_INT == 21) {
            Drawable var4 = var1.getDrawable();
            boolean var3;
            if (var1.getImageTintList() != null && var1.getImageTintMode() != null) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var4 != null && var3) {
               if (var4.isStateful()) {
                  var4.setState(var1.getDrawableState());
               }

               var1.setImageDrawable(var4);
            }
         }
      }

      @Override
      public void a(ImageView var1, Mode var2) {
         var1.setImageTintMode(var2);
         if (VERSION.SDK_INT == 21) {
            Drawable var4 = var1.getDrawable();
            boolean var3;
            if (var1.getImageTintList() != null && var1.getImageTintMode() != null) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var4 != null && var3) {
               if (var4.isStateful()) {
                  var4.setState(var1.getDrawableState());
               }

               var1.setImageDrawable(var4);
            }
         }
      }

      @Override
      public Mode b(ImageView var1) {
         return var1.getImageTintMode();
      }
   }
}
