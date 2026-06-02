package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T> {
   private final Class<?> a;
   private final String b;
   private final Class[] c;

   OptionalMethod(Class<?> var1, String var2, Class... var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private Method a(Class<?> var1) {
      Object var3 = null;
      Method var2 = (Method)var3;
      if (this.b != null) {
         var2 = a(var1, this.b, this.c);
         if (var2 != null && this.a != null && !this.a.isAssignableFrom(var2.getReturnType())) {
            var2 = (Method)var3;
         }
      }

      return var2;
   }

   private static Method a(Class<?> var0, String var1, Class[] var2) {
      Object var4 = null;

      try {
         var7 = var0.getMethod(var1, var2);
      } catch (NoSuchMethodException var6) {
         return (Method)var4;
      }

      int var3;
      try {
         var3 = var7.getModifiers();
      } catch (NoSuchMethodException var5) {
         return var7;
      }

      if ((var3 & 1) == 0) {
         var7 = (Method)var4;
      }

      return var7;
   }

   public Object a(T var1, Object... var2) throws InvocationTargetException {
      Object var3 = null;
      Method var4 = this.a(var1.getClass());
      if (var4 == null) {
         var1 = var3;
      } else {
         try {
            var1 = var4.invoke(var1, var2);
         } catch (IllegalAccessException var5) {
            var1 = var3;
         }
      }

      return var1;
   }

   public boolean a(T var1) {
      boolean var2;
      if (this.a(var1.getClass()) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Object b(T var1, Object... var2) {
      try {
         return this.a((T)var1, var2);
      } catch (InvocationTargetException var3) {
         var1 = var3.getTargetException();
         if (var1 instanceof RuntimeException) {
            throw (RuntimeException)var1;
         }

         AssertionError var5 = new AssertionError("Unexpected exception");
         var5.initCause(var1);
         throw var5;
      }
   }

   public Object c(T var1, Object... var2) throws InvocationTargetException {
      Method var3 = this.a(var1.getClass());
      if (var3 == null) {
         throw new AssertionError("Method " + this.b + " not supported for object " + var1);
      }

      try {
         return var3.invoke(var1, var2);
      } catch (IllegalAccessException var4) {
         AssertionError var5 = new AssertionError("Unexpectedly could not call: " + var3);
         var5.initCause(var4);
         throw var5;
      }
   }

   public Object d(T var1, Object... var2) {
      try {
         return this.c((T)var1, var2);
      } catch (InvocationTargetException var3) {
         var1 = var3.getTargetException();
         if (var1 instanceof RuntimeException) {
            throw (RuntimeException)var1;
         }

         AssertionError var5 = new AssertionError("Unexpected exception");
         var5.initCause(var1);
         throw var5;
      }
   }
}
