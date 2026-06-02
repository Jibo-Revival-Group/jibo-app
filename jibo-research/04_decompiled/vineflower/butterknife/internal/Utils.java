package butterknife.internal;

import android.util.TypedValue;
import android.view.View;

public final class Utils {
   private static final TypedValue a = new TypedValue();

   public static View a(View var0, int var1, String var2) {
      View var3 = var0.findViewById(var1);
      if (var3 != null) {
         return var3;
      }

      String var4 = a(var0, var1);
      throw new IllegalStateException(
         "Required view '"
            + var4
            + "' with ID "
            + var1
            + " for "
            + var2
            + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation."
      );
   }

   public static <T> T a(View var0, int var1, String var2, Class<T> var3) {
      return c(var0.findViewById(var1), var1, var2, var3);
   }

   private static String a(View var0, int var1) {
      String var2;
      if (var0.isInEditMode()) {
         var2 = "<unavailable while editing>";
      } else {
         var2 = var0.getContext().getResources().getResourceEntryName(var1);
      }

      return var2;
   }

   public static <T> T b(View var0, int var1, String var2, Class<T> var3) {
      return c(a(var0, var1, var2), var1, var2, var3);
   }

   public static <T> T c(View var0, int var1, String var2, Class<T> var3) {
      try {
         return (T)var3.cast(var0);
      } catch (ClassCastException var4) {
         String var5 = a(var0, var1);
         throw new IllegalStateException("View '" + var5 + "' with ID " + var1 + " for " + var2 + " was of the wrong type. See cause for more info.", var4);
      }
   }
}
