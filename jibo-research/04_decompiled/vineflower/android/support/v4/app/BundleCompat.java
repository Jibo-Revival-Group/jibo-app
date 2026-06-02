package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class BundleCompat {
   public static IBinder a(Bundle var0, String var1) {
      IBinder var2;
      if (VERSION.SDK_INT >= 18) {
         var2 = var0.getBinder(var1);
      } else {
         var2 = BundleCompat.BundleCompatBaseImpl.a(var0, var1);
      }

      return var2;
   }

   public static void a(Bundle var0, String var1, IBinder var2) {
      if (VERSION.SDK_INT >= 18) {
         var0.putBinder(var1, var2);
      } else {
         BundleCompat.BundleCompatBaseImpl.a(var0, var1, var2);
      }
   }

   static class BundleCompatBaseImpl {
      private static Method a;
      private static boolean b;
      private static Method c;
      private static boolean d;

      public static IBinder a(Bundle var0, String var1) {
         if (!b) {
            try {
               a = Bundle.class.getMethod("getIBinder", String.class);
               a.setAccessible(true);
            } catch (NoSuchMethodException var3) {
               Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", var3);
            }

            b = true;
         }

         if (a != null) {
            try {
               return (IBinder)a.invoke(var0, var1);
            } catch (InvocationTargetException var4) {
               var7 = var4;
            } catch (IllegalAccessException var5) {
               var7 = var5;
            } catch (IllegalArgumentException var6) {
               var7 = var6;
            }

            Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", var7);
            a = null;
         }

         return null;
      }

      public static void a(Bundle var0, String var1, IBinder var2) {
         if (!d) {
            try {
               c = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
               c.setAccessible(true);
            } catch (NoSuchMethodException var4) {
               Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", var4);
            }

            d = true;
         }

         if (c != null) {
            try {
               c.invoke(var0, var1, var2);
               return;
            } catch (InvocationTargetException var5) {
               var8 = var5;
            } catch (IllegalAccessException var6) {
               var8 = var6;
            } catch (IllegalArgumentException var7) {
               var8 = var7;
            }

            Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", var8);
            c = null;
         }
      }
   }
}
