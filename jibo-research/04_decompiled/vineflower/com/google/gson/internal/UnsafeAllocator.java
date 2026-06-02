package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
   public static UnsafeAllocator a() {
      UnsafeAllocator var1;
      try {
         Class var8 = Class.forName("sun.misc.Unsafe");
         Field var10 = var8.getDeclaredField("theUnsafe");
         var10.setAccessible(true);
         Object var11 = var10.get(null);
         Method var3 = var8.getMethod("allocateInstance", Class.class);
         var1 = new UnsafeAllocator(var3, var11) {
            final Method a;
            final Object b;

            {
               this.a = var1;
               this.b = var2;
            }

            @Override
            public <T> T a(Class<T> var1) throws Exception {
               b(var1);
               return (T)this.a.invoke(this.b, var1);
            }
         };
      } catch (Exception var6) {
         try {
            Method var7 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            var7.setAccessible(true);
            int var0 = (Integer)var7.invoke(null, Object.class);
            Method var9 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, int.class);
            var9.setAccessible(true);
            var1 = new UnsafeAllocator(var9, var0) {
               final Method a;
               final int b;

               {
                  this.a = var1;
                  this.b = var2;
               }

               @Override
               public <T> T a(Class<T> var1) throws Exception {
                  b(var1);
                  return (T)this.a.invoke(null, var1, this.b);
               }
            };
         } catch (Exception var5) {
            try {
               Method var2 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
               var2.setAccessible(true);
               var1 = new UnsafeAllocator(var2) {
                  final Method a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public <T> T a(Class<T> var1) throws Exception {
                     b(var1);
                     return (T)this.a.invoke(null, var1, Object.class);
                  }
               };
            } catch (Exception var4) {
               var1 = new UnsafeAllocator() {
                  @Override
                  public <T> T a(Class<T> var1) {
                     throw new UnsupportedOperationException("Cannot allocate " + var1);
                  }
               };
            }
         }
      }

      return var1;
   }

   static void b(Class<?> var0) {
      int var1 = var0.getModifiers();
      if (Modifier.isInterface(var1)) {
         throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + var0.getName());
      }

      if (Modifier.isAbstract(var1)) {
         throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + var0.getName());
      }
   }

   public abstract <T> T a(Class<T> var1) throws Exception;
}
