package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

class ViewGroupUtils {
   private static final ViewGroupUtilsImpl a;

   static {
      if (VERSION.SDK_INT >= 18) {
         a = new ViewGroupUtilsApi18();
      } else {
         a = new ViewGroupUtilsApi14();
      }
   }

   static ViewGroupOverlayImpl a(ViewGroup var0) {
      return a.a(var0);
   }

   static void a(ViewGroup var0, boolean var1) {
      a.a(var0, var1);
   }
}
