package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher {
   private static Field a;
   private static boolean b;
   private static Class c;
   private static boolean d;
   private static Field e;
   private static boolean f;
   private static Field g;
   private static boolean h;

   static boolean a(Resources var0) {
      boolean var1;
      if (VERSION.SDK_INT >= 24) {
         var1 = d(var0);
      } else if (VERSION.SDK_INT >= 23) {
         var1 = c(var0);
      } else if (VERSION.SDK_INT >= 21) {
         var1 = b(var0);
      } else {
         var1 = false;
      }

      return var1;
   }

   private static boolean a(Object var0) {
      if (!d) {
         try {
            c = Class.forName("android.content.res.ThemedResourceCache");
         } catch (ClassNotFoundException var5) {
            Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", var5);
         }

         d = true;
      }

      boolean var1;
      if (c == null) {
         var1 = false;
      } else {
         if (!f) {
            try {
               e = c.getDeclaredField("mUnthemedEntries");
               e.setAccessible(true);
            } catch (NoSuchFieldException var4) {
               Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", var4);
            }

            f = true;
         }

         if (e == null) {
            var1 = false;
         } else {
            try {
               var0 = (LongSparseArray)e.get(var0);
            } catch (IllegalAccessException var3) {
               Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", var3);
               var0 = null;
            }

            if (var0 != null) {
               var0.clear();
               var1 = true;
            } else {
               var1 = false;
            }
         }
      }

      return var1;
   }

   private static boolean b(Resources var0) {
      if (!b) {
         try {
            a = Resources.class.getDeclaredField("mDrawableCache");
            a.setAccessible(true);
         } catch (NoSuchFieldException var4) {
            Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", var4);
         }

         b = true;
      }

      if (a != null) {
         try {
            var5 = (Map)a.get(var0);
         } catch (IllegalAccessException var3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", var3);
            var5 = null;
         }

         if (var5 != null) {
            var5.clear();
            return true;
         }
      }

      return false;
   }

   private static boolean c(Resources var0) {
      boolean var1 = false;
      boolean var2 = true;
      if (!b) {
         try {
            a = Resources.class.getDeclaredField("mDrawableCache");
            a.setAccessible(true);
         } catch (NoSuchFieldException var4) {
            Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", var4);
         }

         b = true;
      }

      label35: {
         if (a != null) {
            try {
               var6 = a.get(var0);
               break label35;
            } catch (IllegalAccessException var5) {
               Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", var5);
            }
         }

         var6 = null;
      }

      if (var6 != null) {
         if (var6 != null && a(var6)) {
            var1 = var2;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   private static boolean d(Resources var0) {
      boolean var1 = false;
      boolean var2 = true;
      if (!h) {
         try {
            g = Resources.class.getDeclaredField("mResourcesImpl");
            g.setAccessible(true);
         } catch (NoSuchFieldException var6) {
            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", var6);
         }

         h = true;
      }

      if (g != null) {
         try {
            var8 = g.get(var0);
         } catch (IllegalAccessException var5) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", var5);
            var8 = null;
         }

         if (var8 != null) {
            if (!b) {
               try {
                  a = var8.getClass().getDeclaredField("mDrawableCache");
                  a.setAccessible(true);
               } catch (NoSuchFieldException var4) {
                  Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", var4);
               }

               b = true;
            }

            label46: {
               if (a != null) {
                  try {
                     var9 = a.get(var8);
                     break label46;
                  } catch (IllegalAccessException var7) {
                     Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", var7);
                  }
               }

               var9 = null;
            }

            if (var9 != null && a(var9)) {
               var1 = var2;
            } else {
               var1 = false;
            }
         }
      }

      return var1;
   }
}
