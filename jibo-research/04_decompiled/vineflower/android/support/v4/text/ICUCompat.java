package android.support.v4.text;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
   private static Method a;
   private static Method b;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static {
      if (VERSION.SDK_INT >= 21) {
         try {
            b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
         } catch (Exception var2) {
            throw new IllegalStateException(var2);
         }
      } else {
         label23: {
            Class var0;
            try {
               var0 = Class.forName("libcore.icu.ICU");
            } catch (Exception var3) {
               a = null;
               b = null;
               Log.w("ICUCompat", var3);
               break label23;
            }

            if (var0 != null) {
               try {
                  a = var0.getMethod("getScript", String.class);
                  b = var0.getMethod("addLikelySubtags", String.class);
               } catch (Exception var1) {
                  a = null;
                  b = null;
                  Log.w("ICUCompat", var1);
               }
            }
         }
      }
   }

   private static String a(String var0) {
      try {
         if (a != null) {
            return (String)a.invoke(null, var0);
         }
      } catch (IllegalAccessException var1) {
         Log.w("ICUCompat", var1);
      } catch (InvocationTargetException var2) {
         Log.w("ICUCompat", var2);
      }

      return null;
   }

   public static String a(Locale var0) {
      Object var1 = null;
      String var5;
      if (VERSION.SDK_INT >= 21) {
         label26: {
            try {
               var1 = ((Locale)b.invoke(null, var0)).getScript();
               break label26;
            } catch (InvocationTargetException var3) {
               Log.w("ICUCompat", var3);
            } catch (IllegalAccessException var4) {
               Log.w("ICUCompat", var4);
            }

            return var0.getScript();
         }

         var5 = (String)var1;
      } else {
         String var2 = b(var0);
         var5 = (String)var1;
         if (var2 != null) {
            var5 = a(var2);
         }
      }

      return var5;
   }

   private static String b(Locale var0) {
      String var4 = var0.toString();

      String var1;
      try {
         if (b == null) {
            return var4;
         }

         var1 = (String)b.invoke(null, var4);
      } catch (IllegalAccessException var2) {
         Log.w("ICUCompat", var2);
         return var4;
      } catch (InvocationTargetException var3) {
         Log.w("ICUCompat", var3);
         return var4;
      }

      return var1;
   }
}
