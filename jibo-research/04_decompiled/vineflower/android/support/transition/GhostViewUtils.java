package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils {
   private static final GhostViewImpl.Creator a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new GhostViewApi21.Creator();
      } else {
         a = new GhostViewApi14.Creator();
      }
   }

   static GhostViewImpl a(View var0, ViewGroup var1, Matrix var2) {
      return a.a(var0, var1, var2);
   }

   static void a(View var0) {
      a.a(var0);
   }
}
