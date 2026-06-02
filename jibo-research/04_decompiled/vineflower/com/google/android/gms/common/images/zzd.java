package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzbg;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class zzd extends zza {
   private WeakReference<ImageManager.OnImageLoadedListener> c;

   @Override
   protected final void a(Drawable var1, boolean var2, boolean var3, boolean var4) {
      if (!var3) {
         ImageManager.OnImageLoadedListener var5 = this.c.get();
         if (var5 != null) {
            var5.a(this.a.a, var1, var4);
         }
      }
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof zzd)) {
         var2 = false;
      } else if (this == var1) {
         var2 = true;
      } else {
         var1 = var1;
         ImageManager.OnImageLoadedListener var3 = this.c.get();
         ImageManager.OnImageLoadedListener var4 = var1.c.get();
         if (var4 != null && var3 != null && zzbg.a(var4, var3) && zzbg.a(var1.a, this.a)) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a});
   }
}
