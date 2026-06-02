package android.support.v4.os;

import android.os.Build.VERSION;

public class BuildCompat {
   @Deprecated
   public static boolean a() {
      boolean var0;
      if (VERSION.SDK_INT >= 27) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }
}
