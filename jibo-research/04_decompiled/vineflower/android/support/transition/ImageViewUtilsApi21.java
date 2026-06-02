package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ImageViewUtilsApi21 implements ImageViewUtilsImpl {
   private static Method a;
   private static boolean b;

   private void a() {
      if (!b) {
         try {
            a = ImageView.class.getDeclaredMethod("animateTransform", Matrix.class);
            a.setAccessible(true);
         } catch (NoSuchMethodException var2) {
            Log.i("ImageViewUtilsApi21", "Failed to retrieve animateTransform method", var2);
         }

         b = true;
      }
   }

   @Override
   public void a(ImageView var1) {
   }

   @Override
   public void a(ImageView var1, Animator var2) {
   }

   @Override
   public void a(ImageView var1, Matrix var2) {
      this.a();
      if (a != null) {
         try {
            a.invoke(var1, var2);
         } catch (IllegalAccessException var3) {
         } catch (InvocationTargetException var4) {
            throw new RuntimeException(var4.getCause());
         }
      }
   }
}
