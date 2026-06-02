package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {
   private final WeakReference<Context> a;

   public TintResources(Context var1, Resources var2) {
      super(var2);
      this.a = new WeakReference<>(var1);
   }

   @Override
   public Drawable getDrawable(int var1) throws NotFoundException {
      Drawable var3 = super.getDrawable(var1);
      Context var2 = this.a.get();
      if (var3 != null && var2 != null) {
         AppCompatDrawableManager.a();
         AppCompatDrawableManager.a(var2, var1, var3);
      }

      return var3;
   }
}
