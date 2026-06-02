package com.amazonaws.util;

public enum Classes {
   private static final Classes[] $VALUES = new Classes[0];

   public static Class<?> childClassOf(Class<?> var0, Object var1) {
      if (var1 != null && var1 != Object.class) {
         if (var0 == null || !var0.isInterface()) {
            var1 = var1.getClass();

            while (true) {
               Class var2 = var1.getSuperclass();
               if (var2 == var0) {
                  break;
               }

               if (var2 == null) {
                  var1 = null;
                  break;
               }

               var1 = var2;
            }
         } else {
            var1 = null;
         }
      } else {
         var1 = null;
      }

      return var1;
   }
}
