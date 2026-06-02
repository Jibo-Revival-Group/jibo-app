package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives {
   private static final Map<Class<?>, Class<?>> a;
   private static final Map<Class<?>, Class<?>> b;

   static {
      HashMap var0 = new HashMap(16);
      HashMap var1 = new HashMap(16);
      a(var0, var1, boolean.class, Boolean.class);
      a(var0, var1, byte.class, Byte.class);
      a(var0, var1, char.class, Character.class);
      a(var0, var1, double.class, Double.class);
      a(var0, var1, float.class, Float.class);
      a(var0, var1, int.class, Integer.class);
      a(var0, var1, long.class, Long.class);
      a(var0, var1, short.class, Short.class);
      a(var0, var1, void.class, Void.class);
      a = Collections.unmodifiableMap(var0);
      b = Collections.unmodifiableMap(var1);
   }

   public static <T> Class<T> a(Class<T> var0) {
      Class var1 = a.get($Gson$Preconditions.a(var0));
      if (var1 != null) {
         var0 = var1;
      }

      return var0;
   }

   private static void a(Map<Class<?>, Class<?>> var0, Map<Class<?>, Class<?>> var1, Class<?> var2, Class<?> var3) {
      var0.put(var2, var3);
      var1.put(var3, var2);
   }

   public static boolean a(Type var0) {
      return a.containsKey(var0);
   }
}
