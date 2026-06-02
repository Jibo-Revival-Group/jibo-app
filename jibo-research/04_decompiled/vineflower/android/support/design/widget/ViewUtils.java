package android.support.design.widget;

import android.graphics.PorterDuff.Mode;

class ViewUtils {
   static Mode a(int var0, Mode var1) {
      switch (var0) {
         case 3:
            var1 = Mode.SRC_OVER;
            break;
         case 5:
            var1 = Mode.SRC_IN;
            break;
         case 9:
            var1 = Mode.SRC_ATOP;
            break;
         case 14:
            var1 = Mode.MULTIPLY;
            break;
         case 15:
            var1 = Mode.SCREEN;
      }

      return var1;
   }
}
