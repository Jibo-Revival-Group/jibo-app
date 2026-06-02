package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
   static final Map<Class<?>, Constructor<? extends Unbinder>> a = new LinkedHashMap<>();
   private static boolean b = false;

   private ButterKnife() {
      throw new AssertionError("No instances.");
   }

   public static Unbinder a(Activity var0) {
      return b(var0, var0.getWindow().getDecorView());
   }

   public static Unbinder a(View var0) {
      return b(var0, var0);
   }

   public static Unbinder a(Object var0, View var1) {
      return b(var0, var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Constructor<? extends Unbinder> a(Class<?> var0) {
      Constructor var2 = a.get(var0);
      Constructor var1;
      if (var2 != null) {
         var1 = var2;
         if (b) {
            Log.d("ButterKnife", "HIT: Cached in binding map.");
            var1 = var2;
         }
      } else {
         String var3 = var0.getName();
         if (!var3.startsWith("android.") && !var3.startsWith("java.")) {
            label48: {
               label47: {
                  label46: {
                     label57: {
                        try {
                           ClassLoader var8 = var0.getClassLoader();
                           StringBuilder var9 = new StringBuilder();
                           var2 = var8.loadClass(var9.append(var3).append("_ViewBinding").toString()).getConstructor(var0, View.class);
                        } catch (ClassNotFoundException var6) {
                           if (!b) {
                              break label46;
                           }
                           break label57;
                        } catch (NoSuchMethodException var7) {
                           throw new RuntimeException("Unable to find binding constructor for " + var3, var7);
                        }

                        var1 = var2;

                        try {
                           if (!b) {
                              break label48;
                           }

                           Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
                           break label47;
                        } catch (ClassNotFoundException var4) {
                           if (!b) {
                              break label46;
                           }
                        } catch (NoSuchMethodException var5) {
                           throw new RuntimeException("Unable to find binding constructor for " + var3, var5);
                        }
                     }

                     Log.d("ButterKnife", "Not found. Trying superclass " + var0.getSuperclass().getName());
                  }

                  var1 = a(var0.getSuperclass());
                  break label48;
               }

               var1 = var2;
            }

            a.put(var0, var1);
         } else {
            if (b) {
               Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            }

            var1 = null;
         }
      }

      return var1;
   }

   private static Unbinder b(Object var0, View var1) {
      Class var2 = var0.getClass();
      if (b) {
         Log.d("ButterKnife", "Looking up binding for " + var2.getName());
      }

      Constructor var8 = a(var2);
      if (var8 == null) {
         var0 = Unbinder.a;
      } else {
         try {
            var0 = (Unbinder)var8.newInstance(var0, var1);
         } catch (IllegalAccessException var3) {
            throw new RuntimeException("Unable to invoke " + var8, var3);
         } catch (InstantiationException var4) {
            throw new RuntimeException("Unable to invoke " + var8, var4);
         } catch (InvocationTargetException var5) {
            Throwable var7 = var5.getCause();
            if (var7 instanceof RuntimeException) {
               throw (RuntimeException)var7;
            }

            if (var7 instanceof Error) {
               throw (Error)var7;
            }

            throw new RuntimeException("Unable to create binding instance.", var7);
         }
      }

      return var0;
   }

   public interface Action<T extends View> {
   }

   public interface Setter<T extends View, V> {
   }
}
