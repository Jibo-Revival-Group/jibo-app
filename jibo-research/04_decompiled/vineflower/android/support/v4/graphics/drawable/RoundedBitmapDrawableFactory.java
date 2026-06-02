package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;

public final class RoundedBitmapDrawableFactory {
   public static RoundedBitmapDrawable a(Resources var0, Bitmap var1) {
      RoundedBitmapDrawable var2;
      if (VERSION.SDK_INT >= 21) {
         var2 = new RoundedBitmapDrawable21(var0, var1);
      } else {
         var2 = new RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(var0, var1);
      }

      return var2;
   }

   private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
      DefaultRoundedBitmapDrawable(Resources var1, Bitmap var2) {
         super(var1, var2);
      }

      @Override
      void a(int var1, int var2, int var3, Rect var4, Rect var5) {
         GravityCompat.a(var1, var2, var3, var4, var5, 0);
      }
   }
}
