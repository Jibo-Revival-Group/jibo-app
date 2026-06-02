package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class PointerIconCompat {
   private Object a;

   private PointerIconCompat(Object var1) {
      this.a = var1;
   }

   public static PointerIconCompat a(Context var0, int var1) {
      PointerIconCompat var2;
      if (VERSION.SDK_INT >= 24) {
         var2 = new PointerIconCompat(PointerIcon.getSystemIcon(var0, var1));
      } else {
         var2 = new PointerIconCompat(null);
      }

      return var2;
   }

   public Object a() {
      return this.a;
   }
}
