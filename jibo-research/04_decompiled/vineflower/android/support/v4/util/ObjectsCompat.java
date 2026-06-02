package android.support.v4.util;

import android.os.Build.VERSION;
import java.util.Objects;

public class ObjectsCompat {
   public static boolean a(Object var0, Object var1) {
      boolean var2;
      if (VERSION.SDK_INT >= 19) {
         var2 = Objects.equals(var0, var1);
      } else if (var0 != var1 && (var0 == null || !var0.equals(var1))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }
}
