package android.support.v4.text;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
   private static final Locale a = new Locale("", "");

   public static int a(Locale var0) {
      int var1;
      if (VERSION.SDK_INT >= 17) {
         var1 = TextUtils.getLayoutDirectionFromLocale(var0);
      } else {
         if (var0 != null && !var0.equals(a)) {
            String var2 = ICUCompat.a(var0);
            if (var2 == null) {
               var1 = b(var0);
               return var1;
            }

            if (var2.equalsIgnoreCase("Arab") || var2.equalsIgnoreCase("Hebr")) {
               byte var3 = 1;
               return var3;
            }
         }

         var1 = 0;
      }

      return var1;
   }

   private static int b(Locale var0) {
      byte var1 = 0;
      switch (Character.getDirectionality(var0.getDisplayName(var0).charAt(0))) {
         case 1:
         case 2:
            var1 = 1;
         default:
            return var1;
      }
   }
}
