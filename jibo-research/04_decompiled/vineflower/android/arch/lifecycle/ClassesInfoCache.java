package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ClassesInfoCache {
   static ClassesInfoCache a = new ClassesInfoCache();
   private final Map<Class, ClassesInfoCache.CallbackInfo> b = new HashMap<>();
   private final Map<Class, Boolean> c = new HashMap<>();

   private ClassesInfoCache.CallbackInfo a(Class var1, Method[] var2) {
      Class var8 = var1.getSuperclass();
      HashMap var7 = new HashMap();
      if (var8 != null) {
         ClassesInfoCache.CallbackInfo var14 = this.b(var8);
         if (var14 != null) {
            var7.putAll(var14.b);
         }
      }

      Class[] var10 = var1.getInterfaces();
      int var4 = var10.length;

      for (int var3 = 0; var3 < var4; var3++) {
         for (Entry var9 : this.b(var10[var3]).b.entrySet()) {
            this.a(var7, (ClassesInfoCache.MethodReference)var9.getKey(), (Lifecycle.Event)var9.getValue(), var1);
         }
      }

      if (var2 == null) {
         var2 = this.c(var1);
      }

      int var5 = var2.length;
      var4 = 0;
      boolean var6 = false;

      while (var4 < var5) {
         Method var17 = var2[var4];
         OnLifecycleEvent var18 = var17.getAnnotation(OnLifecycleEvent.class);
         if (var18 != null) {
            Class[] var16 = var17.getParameterTypes();
            byte var12;
            if (var16.length > 0) {
               if (!var16[0].isAssignableFrom(LifecycleOwner.class)) {
                  throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
               }

               var12 = 1;
            } else {
               var12 = 0;
            }

            Lifecycle.Event var19 = var18.a();
            if (var16.length > 1) {
               if (!var16[1].isAssignableFrom(Lifecycle.Event.class)) {
                  throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
               }

               if (var19 != Lifecycle.Event.ON_ANY) {
                  throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
               }

               var12 = 2;
            }

            if (var16.length > 2) {
               throw new IllegalArgumentException("cannot have more than 2 params");
            }

            this.a(var7, new ClassesInfoCache.MethodReference(var12, var17), var19, var1);
            var6 = true;
         }

         var4++;
      }

      ClassesInfoCache.CallbackInfo var11 = new ClassesInfoCache.CallbackInfo(var7);
      this.b.put(var1, var11);
      this.c.put(var1, var6);
      return var11;
   }

   private void a(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> var1, ClassesInfoCache.MethodReference var2, Lifecycle.Event var3, Class var4) {
      Lifecycle.Event var5 = (Lifecycle.Event)var1.get(var2);
      if (var5 != null && var3 != var5) {
         Method var6 = var2.b;
         throw new IllegalArgumentException(
            "Method "
               + var6.getName()
               + " in "
               + var4.getName()
               + " already declared with different @OnLifecycleEvent value: previous"
               + " value "
               + var5
               + ", new value "
               + var3
         );
      }

      if (var5 == null) {
         var1.put(var2, var3);
      }
   }

   private Method[] c(Class var1) {
      try {
         return var1.getDeclaredMethods();
      } catch (NoClassDefFoundError var2) {
         throw new IllegalArgumentException(
            "The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.",
            var2
         );
      }
   }

   boolean a(Class var1) {
      boolean var4;
      if (this.c.containsKey(var1)) {
         var4 = this.c.get(var1);
      } else {
         Method[] var5 = this.c(var1);
         int var3 = var5.length;
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               this.c.put(var1, false);
               var4 = false;
               break;
            }

            if (var5[var2].getAnnotation(OnLifecycleEvent.class) != null) {
               this.a(var1, var5);
               var4 = true;
               break;
            }

            var2++;
         }
      }

      return var4;
   }

   ClassesInfoCache.CallbackInfo b(Class var1) {
      ClassesInfoCache.CallbackInfo var2 = this.b.get(var1);
      ClassesInfoCache.CallbackInfo var3;
      if (var2 != null) {
         var3 = var2;
      } else {
         var3 = this.a(var1, null);
      }

      return var3;
   }

   static class CallbackInfo {
      final Map<Lifecycle.Event, List<ClassesInfoCache.MethodReference>> a;
      final Map<ClassesInfoCache.MethodReference, Lifecycle.Event> b;

      CallbackInfo(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> var1) {
         this.b = var1;
         this.a = new HashMap<>();

         for (Entry var5 : var1.entrySet()) {
            Lifecycle.Event var4 = (Lifecycle.Event)var5.getValue();
            List var2 = this.a.get(var4);
            List var6 = var2;
            if (var2 == null) {
               var6 = new ArrayList();
               this.a.put(var4, var6);
            }

            var6.add(var5.getKey());
         }
      }

      private static void a(List<ClassesInfoCache.MethodReference> var0, LifecycleOwner var1, Lifecycle.Event var2, Object var3) {
         if (var0 != null) {
            for (int var4 = var0.size() - 1; var4 >= 0; var4--) {
               ((ClassesInfoCache.MethodReference)var0.get(var4)).a(var1, var2, var3);
            }
         }
      }

      void a(LifecycleOwner var1, Lifecycle.Event var2, Object var3) {
         a(this.a.get(var2), var1, var2, var3);
         a(this.a.get(Lifecycle.Event.ON_ANY), var1, var2, var3);
      }
   }

   static class MethodReference {
      final int a;
      final Method b;

      MethodReference(int var1, Method var2) {
         this.a = var1;
         this.b = var2;
         this.b.setAccessible(true);
      }

      void a(LifecycleOwner var1, Lifecycle.Event var2, Object var3) {
         try {
            switch (this.a) {
               case 0:
                  this.b.invoke(var3);
                  break;
               case 1:
                  this.b.invoke(var3, var1);
                  break;
               case 2:
                  this.b.invoke(var3, var1, var2);
            }
         } catch (InvocationTargetException var4) {
            throw new RuntimeException("Failed to call observer method", var4.getCause());
         } catch (IllegalAccessException var5) {
            throw new RuntimeException(var5);
         }
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 != null && this.getClass() == var1.getClass()) {
               var1 = var1;
               if (this.a != var1.a || !this.b.getName().equals(var1.b.getName())) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a * 31 + this.b.getName().hashCode();
      }
   }
}
