package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {
   private static Map<Class, Integer> a = new HashMap<>();
   private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> b = new HashMap<>();

   private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> var0, Object var1) {
      try {
         return (GeneratedAdapter)var0.newInstance(var1);
      } catch (IllegalAccessException var2) {
         throw new RuntimeException(var2);
      } catch (InstantiationException var3) {
         throw new RuntimeException(var3);
      } catch (InvocationTargetException var4) {
         throw new RuntimeException(var4);
      }
   }

   static GenericLifecycleObserver a(Object var0) {
      GenericLifecycleObserver var4;
      if (var0 instanceof FullLifecycleObserver) {
         var4 = new FullLifecycleObserverAdapter((FullLifecycleObserver)var0);
      } else if (var0 instanceof GenericLifecycleObserver) {
         var4 = (GenericLifecycleObserver)var0;
      } else {
         Class var2 = var0.getClass();
         if (b(var2) == 2) {
            List var5 = b.get(var2);
            if (var5.size() == 1) {
               var4 = new SingleGeneratedAdapterObserver(a((Constructor<? extends GeneratedAdapter>)var5.get(0), var0));
            } else {
               GeneratedAdapter[] var3 = new GeneratedAdapter[var5.size()];

               for (int var1 = 0; var1 < var5.size(); var1++) {
                  var3[var1] = a((Constructor<? extends GeneratedAdapter>)var5.get(var1), var0);
               }

               var4 = new CompositeGeneratedAdaptersObserver(var3);
            }
         } else {
            var4 = new ReflectiveGenericLifecycleObserver(var0);
         }
      }

      return var4;
   }

   public static String a(String var0) {
      return var0.replace(".", "_") + "_LifecycleAdapter";
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Constructor<? extends GeneratedAdapter> a(Class<?> var0) {
      Package var1;
      String var2;
      try {
         var1 = var0.getPackage();
         var2 = var0.getCanonicalName();
      } catch (ClassNotFoundException var18) {
         return null;
      } catch (NoSuchMethodException var19) {
         throw new RuntimeException(var19);
      }

      String var21;
      if (var1 != null) {
         try {
            var21 = var1.getName();
         } catch (ClassNotFoundException var16) {
            return null;
         } catch (NoSuchMethodException var17) {
            throw new RuntimeException(var17);
         }
      } else {
         var21 = "";
      }

      label90: {
         try {
            if (var21.isEmpty()) {
               break label90;
            }
         } catch (ClassNotFoundException var14) {
            return null;
         } catch (NoSuchMethodException var15) {
            throw new RuntimeException(var15);
         }

         try {
            var2 = var2.substring(var21.length() + 1);
         } catch (ClassNotFoundException var12) {
            return null;
         } catch (NoSuchMethodException var13) {
            throw new RuntimeException(var13);
         }
      }

      label71: {
         label91: {
            try {
               var2 = a(var2);
               if (var21.isEmpty()) {
                  break label91;
               }
            } catch (ClassNotFoundException var10) {
               return null;
            } catch (NoSuchMethodException var11) {
               throw new RuntimeException(var11);
            }

            try {
               StringBuilder var3 = new StringBuilder();
               var22 = var3.append(var21).append(".").append(var2).toString();
               break label71;
            } catch (ClassNotFoundException var8) {
               return null;
            } catch (NoSuchMethodException var9) {
               throw new RuntimeException(var9);
            }
         }

         var22 = var2;
      }

      try {
         var23 = Class.forName(var22).getDeclaredConstructor(var0);
      } catch (ClassNotFoundException var6) {
         return null;
      } catch (NoSuchMethodException var7) {
         throw new RuntimeException(var7);
      }

      Constructor var20 = var23;

      try {
         if (var23.isAccessible()) {
            return var20;
         }

         var23.setAccessible(true);
      } catch (ClassNotFoundException var4) {
         Object var25 = null;
         return (Constructor<? extends GeneratedAdapter>)var25;
      } catch (NoSuchMethodException var5) {
         throw new RuntimeException(var5);
      }

      return var23;
   }

   private static int b(Class<?> var0) {
      int var1;
      if (a.containsKey(var0)) {
         var1 = a.get(var0);
      } else {
         var1 = c(var0);
         a.put(var0, var1);
      }

      return var1;
   }

   private static int c(Class<?> var0) {
      byte var1;
      if (var0.getCanonicalName() == null) {
         var1 = 1;
      } else {
         Constructor var3 = a(var0);
         if (var3 != null) {
            b.put(var0, Collections.singletonList(var3));
            var1 = 2;
         } else if (ClassesInfoCache.a.a(var0)) {
            var1 = 1;
         } else {
            Class var4 = var0.getSuperclass();
            ArrayList var7 = null;
            if (d(var4)) {
               if (b(var4) == 1) {
                  var1 = (byte)1;
                  return var1;
               }

               var7 = new ArrayList<>(b.get(var4));
            }

            Class[] var8 = var0.getInterfaces();
            int var2 = var8.length;
            var1 = 0;

            while (true) {
               if (var1 >= var2) {
                  if (var7 != null) {
                     b.put(var0, var7);
                     var1 = 2;
                  } else {
                     var1 = 1;
                  }
                  break;
               }

               Class var5 = var8[var1];
               if (d(var5)) {
                  if (b(var5) == 1) {
                     var1 = 1;
                     break;
                  }

                  if (var7 == null) {
                     var7 = new ArrayList();
                  }

                  var7.addAll(b.get(var5));
               }

               var1++;
            }
         }
      }

      return var1;
   }

   private static boolean d(Class<?> var0) {
      boolean var1;
      if (var0 != null && LifecycleObserver.class.isAssignableFrom(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
