package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources extends Resources {
   private final WeakReference<Context> a;

   public VectorEnabledTintResources(Context var1, Resources var2) {
      super(var2.getAssets(), var2.getDisplayMetrics(), var2.getConfiguration());
      this.a = new WeakReference<>(var1);
   }

   public static boolean a() {
      boolean var0;
      if (AppCompatDelegate.l() && VERSION.SDK_INT <= 20) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   final Drawable a(int var1) {
      return super.getDrawable(var1);
   }

   public Drawable getDrawable(int var1) throws NotFoundException {
      Context var2 = this.a.get();
      Drawable var3;
      if (var2 != null) {
         var3 = AppCompatDrawableManager.a().a(var2, this, var1);
      } else {
         var3 = super.getDrawable(var1);
      }

      return var3;
   }
}
