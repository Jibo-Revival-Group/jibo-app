package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
   static final LayoutInflaterCompat.LayoutInflaterCompatBaseImpl a;
   private static Field b;
   private static boolean c;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new LayoutInflaterCompat.LayoutInflaterCompatApi21Impl();
      } else {
         a = new LayoutInflaterCompat.LayoutInflaterCompatBaseImpl();
      }
   }

   static void a(LayoutInflater var0, Factory2 var1) {
      if (!c) {
         try {
            b = LayoutInflater.class.getDeclaredField("mFactory2");
            b.setAccessible(true);
         } catch (NoSuchFieldException var4) {
            Log.e(
               "LayoutInflaterCompatHC",
               "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.",
               var4
            );
         }

         c = true;
      }

      if (b != null) {
         try {
            b.set(var0, var1);
         } catch (IllegalAccessException var3) {
            Log.e(
               "LayoutInflaterCompatHC",
               "forceSetFactory2 could not set the Factory2 on LayoutInflater " + var0 + "; inflation may have unexpected results.",
               var3
            );
         }
      }
   }

   public static void b(LayoutInflater var0, Factory2 var1) {
      a.a(var0, var1);
   }

   static class LayoutInflaterCompatApi21Impl extends LayoutInflaterCompat.LayoutInflaterCompatBaseImpl {
      @Override
      public void a(LayoutInflater var1, Factory2 var2) {
         var1.setFactory2(var2);
      }
   }

   static class LayoutInflaterCompatBaseImpl {
      public void a(LayoutInflater var1, Factory2 var2) {
         var1.setFactory2(var2);
         Factory var3 = var1.getFactory();
         if (var3 instanceof Factory2) {
            LayoutInflaterCompat.a(var1, (Factory2)var3);
         } else {
            LayoutInflaterCompat.a(var1, var2);
         }
      }
   }
}
