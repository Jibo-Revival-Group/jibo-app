package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Types {
   private Types() {
   }

   private static Type getActualParameterAtPosition(Type var0, Class<?> var1, int var2) {
      ParameterizedType var5 = getSuperParameterizedType(var0, var1);
      Type var6;
      if (var5 == null) {
         var6 = null;
      } else {
         Type var3 = var5.getActualTypeArguments()[var2];
         var6 = var3;
         if (var3 instanceof TypeVariable) {
            var0 = resolveTypeVariable(Arrays.asList(var0), (TypeVariable<?>)var3);
            var6 = var3;
            if (var0 != null) {
               var6 = var0;
            }
         }
      }

      return var6;
   }

   public static Type getArrayComponentType(Type var0) {
      if (var0 instanceof GenericArrayType) {
         var0 = ((GenericArrayType)var0).getGenericComponentType();
      } else {
         var0 = ((Class)var0).getComponentType();
      }

      return var0;
   }

   public static Type getBound(WildcardType var0) {
      Type[] var1 = var0.getLowerBounds();
      Type var2;
      if (var1.length != 0) {
         var2 = var1[0];
      } else {
         var2 = var0.getUpperBounds()[0];
      }

      return var2;
   }

   public static Type getIterableParameter(Type var0) {
      return getActualParameterAtPosition(var0, Iterable.class, 0);
   }

   public static Type getMapValueParameter(Type var0) {
      return getActualParameterAtPosition(var0, Map.class, 1);
   }

   public static Class<?> getRawArrayComponentType(List<Type> var0, Type var1) {
      if (var1 instanceof TypeVariable) {
         var1 = resolveTypeVariable(var0, (TypeVariable<?>)var1);
      }

      Class var3;
      if (var1 instanceof GenericArrayType) {
         var3 = Array.newInstance(getRawArrayComponentType(var0, getArrayComponentType(var1)), 0).getClass();
      } else if (var1 instanceof Class) {
         var3 = (Class)var1;
      } else if (var1 instanceof ParameterizedType) {
         var3 = getRawClass((ParameterizedType)var1);
      } else {
         boolean var2;
         if (var1 == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2, "wildcard type is not supported: %s", var1);
         var3 = Object.class;
      }

      return var3;
   }

   public static Class<?> getRawClass(ParameterizedType var0) {
      return (Class<?>)var0.getRawType();
   }

   public static ParameterizedType getSuperParameterizedType(Type var0, Class<?> var1) {
      if (var0 instanceof Class || var0 instanceof ParameterizedType) {
         label49:
         while (var0 != null && var0 != Object.class) {
            Class var7;
            if (var0 instanceof Class) {
               var7 = (Class)var0;
            } else {
               ParameterizedType var8 = (ParameterizedType)var0;
               Class var4 = getRawClass(var8);
               if (var4 == var1) {
                  return var8;
               }

               if (var1.isInterface()) {
                  for (Type var5 : var4.getGenericInterfaces()) {
                     if (var5 instanceof Class) {
                        var7 = (Class)var5;
                     } else {
                        var7 = getRawClass((ParameterizedType)var5);
                     }

                     if (var1.isAssignableFrom(var7)) {
                        var0 = var5;
                        continue label49;
                     }
                  }
               }

               var7 = var4;
            }

            var0 = var7.getGenericSuperclass();
         }
      }

      return null;
   }

   private static IllegalArgumentException handleExceptionForNewInstance(Exception var0, Class<?> var1) {
      StringBuilder var3 = new StringBuilder("unable to create new instance of class ").append(var1.getName());
      ArrayList var4 = new ArrayList();
      if (var1.isArray()) {
         var4.add("because it is an array");
      } else if (var1.isPrimitive()) {
         var4.add("because it is primitive");
      } else if (var1 == Void.class) {
         var4.add("because it is void");
      } else {
         if (Modifier.isInterface(var1.getModifiers())) {
            var4.add("because it is an interface");
         } else if (Modifier.isAbstract(var1.getModifiers())) {
            var4.add("because it is abstract");
         }

         if (var1.getEnclosingClass() != null && !Modifier.isStatic(var1.getModifiers())) {
            var4.add("because it is not static");
         }

         if (!Modifier.isPublic(var1.getModifiers())) {
            var4.add("possibly because it is not public");
         } else {
            try {
               var1.getConstructor();
            } catch (NoSuchMethodException var5) {
               var4.add("because it has no accessible default constructor");
            }
         }
      }

      Iterator var6 = var4.iterator();
      boolean var2 = false;

      while (var6.hasNext()) {
         String var7 = (String)var6.next();
         if (var2) {
            var3.append(" and");
         } else {
            var2 = true;
         }

         var3.append(" ").append(var7);
      }

      return new IllegalArgumentException(var3.toString(), var0);
   }

   public static boolean isArray(Type var0) {
      boolean var1;
      if (!(var0 instanceof GenericArrayType) && (!(var0 instanceof Class) || !((Class)var0).isArray())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isAssignableToOrFrom(Class<?> var0, Class<?> var1) {
      boolean var2;
      if (!var0.isAssignableFrom(var1) && !var1.isAssignableFrom(var0)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public static <T> Iterable<T> iterableOf(Object var0) {
      Iterable var2;
      if (var0 instanceof Iterable) {
         var2 = (Iterable)var0;
      } else {
         Class var1 = var0.getClass();
         Preconditions.checkArgument(var1.isArray(), "not an array or Iterable: %s", var1);
         if (!var1.getComponentType().isPrimitive()) {
            var2 = Arrays.asList((T[])((Object[])var0));
         } else {
            var2 = new Iterable<T>(var0) {
               final Object val$value;

               {
                  this.val$value = var1;
               }

               @Override
               public Iterator<T> iterator() {
                  return new Iterator<T>(this) {
                     int index;
                     final int length;
                     final <unrepresentable> this$0;

                     {
                        this.this$0 = var1;
                        this.length = Array.getLength(this.this$0.val$value);
                        this.index = 0;
                     }

                     @Override
                     public boolean hasNext() {
                        boolean var1x;
                        if (this.index < this.length) {
                           var1x = true;
                        } else {
                           var1x = false;
                        }

                        return var1x;
                     }

                     @Override
                     public T next() {
                        if (!this.hasNext()) {
                           throw new NoSuchElementException();
                        }

                        Object var2x = this.this$0.val$value;
                        int var1x = this.index++;
                        return (T)Array.get(var2x, var1x);
                     }

                     @Override
                     public void remove() {
                        throw new UnsupportedOperationException();
                     }
                  };
               }
            };
         }
      }

      return var2;
   }

   public static <T> T newInstance(Class<T> var0) {
      try {
         return (T)var0.newInstance();
      } catch (IllegalAccessException var2) {
         throw handleExceptionForNewInstance(var2, var0);
      } catch (InstantiationException var3) {
         throw handleExceptionForNewInstance(var3, var0);
      }
   }

   public static Type resolveTypeVariable(List<Type> var0, TypeVariable<?> var1) {
      GenericDeclaration var5 = var1.getGenericDeclaration();
      if (var5 instanceof Class) {
         Class var4 = (Class)var5;
         int var2 = var0.size();

         ParameterizedType var3;
         for (var3 = null; var3 == null; var3 = getSuperParameterizedType((Type)var0.get(var2), var4)) {
            if (--var2 < 0) {
               break;
            }
         }

         if (var3 != null) {
            TypeVariable[] var10 = var5.getTypeParameters();
            var2 = 0;

            while (var2 < var10.length && !var10[var2].equals(var1)) {
               var2++;
            }

            Type var9 = var3.getActualTypeArguments()[var2];
            Type var11 = var9;
            if (var9 instanceof TypeVariable) {
               Type var6 = resolveTypeVariable(var0, (TypeVariable<?>)var9);
               var11 = var9;
               if (var6 != null) {
                  return var6;
               }
            }

            return var11;
         }
      }

      return null;
   }

   public static Object toArray(Collection<?> var0, Class<?> var1) {
      Object var4;
      if (var1.isPrimitive()) {
         Object var5 = Array.newInstance(var1, var0.size());
         int var2 = 0;

         for (Iterator var3 = var0.iterator(); var3.hasNext(); var2++) {
            Array.set(var5, var2, var3.next());
         }

         var4 = var5;
      } else {
         var4 = var0.toArray((Object[])Array.newInstance(var1, var0.size()));
      }

      return var4;
   }
}
