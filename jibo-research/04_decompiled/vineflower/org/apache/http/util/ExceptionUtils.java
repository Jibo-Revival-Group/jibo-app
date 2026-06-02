package org.apache.http.util;

import java.lang.reflect.Method;

@Deprecated
public final class ExceptionUtils {
   private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();

   private ExceptionUtils() {
   }

   private static Method getInitCauseMethod() {
      Method var0;
      try {
         var0 = Throwable.class.getMethod("initCause", Throwable.class);
      } catch (NoSuchMethodException var1) {
         var0 = null;
      }

      return var0;
   }

   public static void initCause(Throwable var0, Throwable var1) {
      if (INIT_CAUSE_METHOD != null) {
         try {
            INIT_CAUSE_METHOD.invoke(var0, var1);
         } catch (Exception var2) {
         }
      }
   }
}
