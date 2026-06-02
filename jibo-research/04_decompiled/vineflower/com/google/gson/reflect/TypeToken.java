package com.google.gson.reflect;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
   final int hashCode;
   final Class<? super T> rawType;
   final Type type;

   protected TypeToken() {
      this.type = getSuperclassTypeParameter(this.getClass());
      this.rawType = (Class<? super T>)$Gson$Types.e(this.type);
      this.hashCode = this.type.hashCode();
   }

   TypeToken(Type var1) {
      this.type = $Gson$Types.d($Gson$Preconditions.a(var1));
      this.rawType = (Class<? super T>)$Gson$Types.e(this.type);
      this.hashCode = this.type.hashCode();
   }

   private static AssertionError buildUnexpectedTypeError(Type var0, Class<?>... var1) {
      StringBuilder var4 = new StringBuilder("Unexpected type. Expected one of: ");
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         var4.append(var1[var2].getName()).append(", ");
      }

      var4.append("but got: ").append(var0.getClass().getName()).append(", for type token: ").append(var0.toString()).append('.');
      return new AssertionError(var4.toString());
   }

   public static <T> TypeToken<T> get(Class<T> var0) {
      return new TypeToken<>(var0);
   }

   public static TypeToken<?> get(Type var0) {
      return new TypeToken(var0);
   }

   public static TypeToken<?> getArray(Type var0) {
      return new TypeToken($Gson$Types.a(var0));
   }

   public static TypeToken<?> getParameterized(Type var0, Type... var1) {
      return new TypeToken($Gson$Types.a(null, var0, var1));
   }

   static Type getSuperclassTypeParameter(Class<?> var0) {
      Type var1 = var0.getGenericSuperclass();
      if (var1 instanceof Class) {
         throw new RuntimeException("Missing type parameter.");
      } else {
         return $Gson$Types.d(((ParameterizedType)var1).getActualTypeArguments()[0]);
      }
   }

   private static boolean isAssignableFrom(Type var0, GenericArrayType var1) {
      Type var3 = var1.getGenericComponentType();
      boolean var2;
      if (var3 instanceof ParameterizedType) {
         Type var5;
         if (var0 instanceof GenericArrayType) {
            var5 = ((GenericArrayType)var0).getGenericComponentType();
         } else {
            var5 = var0;
            if (var0 instanceof Class) {
               Class var4 = (Class)var0;

               while (true) {
                  var5 = var4;
                  if (!var4.isArray()) {
                     break;
                  }

                  var4 = var4.getComponentType();
               }
            }
         }

         var2 = isAssignableFrom(var5, (ParameterizedType)var3, new HashMap<>());
      } else {
         var2 = true;
      }

      return var2;
   }

   private static boolean isAssignableFrom(Type var0, ParameterizedType var1, Map<String, Type> var2) {
      byte var4 = 0;
      boolean var6 = false;
      if (var0 != null) {
         if (var1.equals(var0)) {
            var6 = true;
         } else {
            Class var8 = $Gson$Types.e(var0);
            if (var0 instanceof ParameterizedType) {
               var0 = var0;
            } else {
               var0 = null;
            }

            if (var0 != null) {
               Type[] var11 = var0.getActualTypeArguments();
               TypeVariable[] var10 = var8.getTypeParameters();

               for (int var3 = 0; var3 < var11.length; var3++) {
                  Type var7 = var11[var3];
                  TypeVariable var9 = var10[var3];

                  while (var7 instanceof TypeVariable) {
                     var7 = (Type)var2.get(((TypeVariable)var7).getName());
                  }

                  var2.put(var9.getName(), var7);
               }

               if (typeEquals(var0, var1, var2)) {
                  var6 = true;
                  return var6;
               }
            }

            Type[] var13 = var8.getGenericInterfaces();
            int var5 = var13.length;
            int var14 = var4;

            while (true) {
               if (var14 >= var5) {
                  var6 = isAssignableFrom(var8.getGenericSuperclass(), var1, new HashMap<>(var2));
                  break;
               }

               if (isAssignableFrom(var13[var14], var1, new HashMap<>(var2))) {
                  var6 = true;
                  break;
               }

               var14++;
            }
         }
      }

      return var6;
   }

   private static boolean matches(Type var0, Type var1, Map<String, Type> var2) {
      boolean var3;
      if (!var1.equals(var0) && (!(var0 instanceof TypeVariable) || !var1.equals(var2.get(((TypeVariable)var0).getName())))) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private static boolean typeEquals(ParameterizedType var0, ParameterizedType var1, Map<String, Type> var2) {
      boolean var5 = false;
      boolean var4 = var5;
      if (var0.getRawType().equals(var1.getRawType())) {
         Type[] var6 = var0.getActualTypeArguments();
         Type[] var7 = var1.getActualTypeArguments();
         int var3 = 0;

         while (true) {
            if (var3 >= var6.length) {
               var4 = true;
               break;
            }

            if (!matches(var6[var3], var7[var3], var2)) {
               var4 = var5;
               break;
            }

            var3++;
         }
      }

      return var4;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof TypeToken && $Gson$Types.a(this.type, ((TypeToken)var1).type)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public final Class<? super T> getRawType() {
      return this.rawType;
   }

   public final Type getType() {
      return this.type;
   }

   @Override
   public final int hashCode() {
      return this.hashCode;
   }

   @Deprecated
   public boolean isAssignableFrom(TypeToken<?> var1) {
      return this.isAssignableFrom(var1.getType());
   }

   @Deprecated
   public boolean isAssignableFrom(Class<?> var1) {
      return this.isAssignableFrom((Type)var1);
   }

   @Deprecated
   public boolean isAssignableFrom(Type var1) {
      boolean var2 = false;
      if (var1 != null) {
         if (this.type.equals(var1)) {
            var2 = true;
         } else if (this.type instanceof Class) {
            var2 = this.rawType.isAssignableFrom($Gson$Types.e(var1));
         } else if (this.type instanceof ParameterizedType) {
            var2 = isAssignableFrom(var1, (ParameterizedType)this.type, new HashMap<>());
         } else {
            if (!(this.type instanceof GenericArrayType)) {
               throw buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
            }

            if (this.rawType.isAssignableFrom($Gson$Types.e(var1)) && isAssignableFrom(var1, (GenericArrayType)this.type)) {
               var2 = true;
            } else {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final String toString() {
      return $Gson$Types.f(this.type);
   }
}
