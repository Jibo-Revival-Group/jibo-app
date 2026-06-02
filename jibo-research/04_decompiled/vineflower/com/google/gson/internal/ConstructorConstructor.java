package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
   private final Map<Type, InstanceCreator<?>> a;

   public ConstructorConstructor(Map<Type, InstanceCreator<?>> var1) {
      this.a = var1;
   }

   private <T> ObjectConstructor<T> a(Class<? super T> var1) {
      try {
         Constructor var2 = var1.getDeclaredConstructor();
         if (!var2.isAccessible()) {
            var2.setAccessible(true);
         }

         var4 = new ObjectConstructor<T>(this, var2) {
            final Constructor a;
            final ConstructorConstructor b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public T a() {
               try {
                  return (T)this.a.newInstance(null);
               } catch (InstantiationException var2x) {
                  throw new RuntimeException("Failed to invoke " + this.a + " with no args", var2x);
               } catch (InvocationTargetException var3) {
                  throw new RuntimeException("Failed to invoke " + this.a + " with no args", var3.getTargetException());
               } catch (IllegalAccessException var4) {
                  throw new AssertionError(var4);
               }
            }
         };
      } catch (NoSuchMethodException var3) {
         var4 = null;
      }

      return var4;
   }

   private <T> ObjectConstructor<T> a(Type var1, Class<? super T> var2) {
      ObjectConstructor var3;
      if (Collection.class.isAssignableFrom(var2)) {
         if (SortedSet.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new TreeSet());
               }
            };
         } else if (EnumSet.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this, var1) {
               final Type a;
               final ConstructorConstructor b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public T a() {
                  if (this.a instanceof ParameterizedType) {
                     Type var1 = ((ParameterizedType)this.a).getActualTypeArguments()[0];
                     if (var1 instanceof Class) {
                        return (T)EnumSet.noneOf((Class)var1);
                     } else {
                        throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
                     }
                  } else {
                     throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
                  }
               }
            };
         } else if (Set.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new LinkedHashSet());
               }
            };
         } else if (Queue.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new ArrayDeque());
               }
            };
         } else {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new ArrayList());
               }
            };
         }
      } else if (Map.class.isAssignableFrom(var2)) {
         if (ConcurrentNavigableMap.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new ConcurrentSkipListMap());
               }
            };
         } else if (ConcurrentMap.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new ConcurrentHashMap());
               }
            };
         } else if (SortedMap.class.isAssignableFrom(var2)) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new TreeMap());
               }
            };
         } else if (var1 instanceof ParameterizedType
            && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)var1).getActualTypeArguments()[0]).getRawType())) {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new LinkedHashMap());
               }
            };
         } else {
            var3 = new ObjectConstructor<T>(this) {
               final ConstructorConstructor a;

               {
                  this.a = var1;
               }

               @Override
               public T a() {
                  return (T)(new LinkedTreeMap());
               }
            };
         }
      } else {
         var3 = null;
      }

      return var3;
   }

   private <T> ObjectConstructor<T> b(Type var1, Class<? super T> var2) {
      return new ObjectConstructor<T>(this, var2, var1) {
         final Class a;
         final Type b;
         final ConstructorConstructor c;
         private final UnsafeAllocator d;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
            this.d = UnsafeAllocator.a();
         }

         @Override
         public T a() {
            try {
               return this.d.a(this.a);
            } catch (Exception var2x) {
               throw new RuntimeException(
                  "Unable to invoke no-args constructor for " + this.b + ". Registering an InstanceCreator with Gson for this type may fix this problem.",
                  var2x
               );
            }
         }
      };
   }

   public <T> ObjectConstructor<T> a(TypeToken<T> var1) {
      Type var3 = var1.getType();
      Class var4 = var1.getRawType();
      InstanceCreator var5 = this.a.get(var3);
      ObjectConstructor var6;
      if (var5 != null) {
         var6 = new ObjectConstructor<T>(this, var5, var3) {
            final InstanceCreator a;
            final Type b;
            final ConstructorConstructor c;

            {
               this.c = var1;
               this.a = var2;
               this.b = var3x;
            }

            @Override
            public T a() {
               return (T)this.a.createInstance(this.b);
            }
         };
      } else {
         InstanceCreator var7 = this.a.get(var4);
         if (var7 != null) {
            var6 = new ObjectConstructor<T>(this, var7, var3) {
               final InstanceCreator a;
               final Type b;
               final ConstructorConstructor c;

               {
                  this.c = var1;
                  this.a = var2;
                  this.b = var3;
               }

               @Override
               public T a() {
                  return (T)this.a.createInstance(this.b);
               }
            };
         } else {
            ObjectConstructor var2 = this.a(var4);
            var6 = var2;
            if (var2 == null) {
               var2 = this.a(var3, var4);
               var6 = var2;
               if (var2 == null) {
                  var6 = this.b(var3, var4);
               }
            }
         }
      }

      return var6;
   }

   @Override
   public String toString() {
      return this.a.toString();
   }
}
