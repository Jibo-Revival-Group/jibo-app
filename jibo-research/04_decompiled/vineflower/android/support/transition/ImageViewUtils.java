package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

class ImageViewUtils {
   private static final ImageViewUtilsImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new ImageViewUtilsApi21();
      } else {
         a = new ImageViewUtilsApi14();
      }
   }

   static void a(ImageView var0) {
      a.a(var0);
   }

   static void a(ImageView var0, Animator var1) {
      a.a(var0, var1);
   }

   static void a(ImageView var0, Matrix var1) {
      a.a(var0, var1);
   }
}
