package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

class ThemeUtils {
   static final int[] a = new int[]{-16842910};
   static final int[] b = new int[]{16842908};
   static final int[] c = new int[]{16843518};
   static final int[] d = new int[]{16842919};
   static final int[] e = new int[]{16842912};
   static final int[] f = new int[]{16842913};
   static final int[] g = new int[]{-16842919, -16842908};
   static final int[] h = new int[0];
   private static final ThreadLocal<TypedValue> i = new ThreadLocal<>();
   private static final int[] j = new int[1];

   public static int a(Context var0, int var1) {
      j[0] = var1;
      TintTypedArray var5 = TintTypedArray.a(var0, null, j);

      try {
         return var5.b(0, 0);
      } finally {
         var5.a();
      }
   }

   static int a(Context var0, int var1, float var2) {
      var1 = a(var0, var1);
      return ColorUtils.b(var1, Math.round(Color.alpha(var1) * var2));
   }

   private static TypedValue a() {
      TypedValue var1 = i.get();
      TypedValue var0 = var1;
      if (var1 == null) {
         var0 = new TypedValue();
         i.set(var0);
      }

      return var0;
   }

   public static ColorStateList b(Context var0, int var1) {
      j[0] = var1;
      TintTypedArray var5 = TintTypedArray.a(var0, null, j);

      try {
         return var5.e(0);
      } finally {
         var5.a();
      }
   }

   public static int c(Context var0, int var1) {
      ColorStateList var2 = b(var0, var1);
      if (var2 != null && var2.isStateful()) {
         var1 = var2.getColorForState(a, var2.getDefaultColor());
      } else {
         TypedValue var4 = a();
         var0.getTheme().resolveAttribute(16842803, var4, true);
         var1 = a(var0, var1, var4.getFloat());
      }

      return var1;
   }
}
