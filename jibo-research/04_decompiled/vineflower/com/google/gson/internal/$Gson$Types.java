package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types {
   static final Type[] a = new Type[0];

   static int a(Object var0) {
      int var1;
      if (var0 != null) {
         var1 = var0.hashCode();
      } else {
         var1 = 0;
      }

      return var1;
   }

   private static int a(Object[] var0, Object var1) {
      int var2 = 0;

      for (int var3 = var0.length; var2 < var3; var2++) {
         if (var1.equals(var0[var2])) {
            return var2;
         }
      }

      throw new NoSuchElementException();
   }

   private static Class<?> a(TypeVariable<?> var0) {
      GenericDeclaration var1 = var0.getGenericDeclaration();
      Class var2;
      if (var1 instanceof Class) {
         var2 = (Class)var1;
      } else {
         var2 = null;
      }

      return var2;
   }

   public static GenericArrayType a(Type var0) {
      return new $Gson$Types.GenericArrayTypeImpl(var0);
   }

   public static ParameterizedType a(Type var0, Type var1, Type... var2) {
      return new $Gson$Types.ParameterizedTypeImpl(var0, var1, var2);
   }

   public static Type a(Type var0, Class<?> var1) {
      Type var4 = b(var0, var1, Collection.class);
      var0 = var4;
      if (var4 instanceof WildcardType) {
         var0 = ((WildcardType)var4).getUpperBounds()[0];
      }

      if (var0 instanceof ParameterizedType) {
         var0 = ((ParameterizedType)var0).getActualTypeArguments()[0];
      } else {
         var0 = Object.class;
      }

      return var0;
   }

   static Type a(Type var0, Class<?> var1, Class<?> var2) {
      if (var2 != var1) {
         if (var2.isInterface()) {
            Class[] var5 = var1.getInterfaces();
            int var3 = 0;

            for (int var4 = var5.length; var3 < var4; var3++) {
               if (var5[var3] == var2) {
                  var0 = var1.getGenericInterfaces()[var3];
                  return var0;
               }

               if (var2.isAssignableFrom(var5[var3])) {
                  var0 = a(var1.getGenericInterfaces()[var3], var5[var3], var2);
                  return var0;
               }
            }
         }

         if (!var1.isInterface()) {
            while (var1 != Object.class) {
               var0 = var1.getSuperclass();
               if (var0 == var2) {
                  var0 = var1.getGenericSuperclass();
                  return var0;
               }

               if (var2.isAssignableFrom(var0)) {
                  var0 = a(var1.getGenericSuperclass(), var0, var2);
                  return var0;
               }

               var1 = var0;
            }
         }

         var0 = var2;
      }

      return var0;
   }

   public static Type a(Type var0, Class<?> var1, Type var2) {
      return a(var0, var1, var2, new HashSet<>());
   }

   private static Type a(Type var0, Class<?> var1, Type var2, Collection<TypeVariable> var3) {
      Type var8 = var2;

      TypeVariable var9;
      do {
         if (!(var8 instanceof TypeVariable)) {
            if (var8 instanceof Class && ((Class)var8).isArray()) {
               var2 = (Class)var8;
               Class var22 = var2.getComponentType();
               var0 = a(var0, var1, var22, var3);
               if (var22 != var0) {
                  var2 = a(var0);
               }
               break;
            }

            if (var8 instanceof GenericArrayType) {
               var2 = (GenericArrayType)var8;
               var8 = var2.getGenericComponentType();
               var0 = a(var0, var1, var8, var3);
               if (var8 != var0) {
                  var2 = a(var0);
               }
            } else if (var8 instanceof ParameterizedType) {
               ParameterizedType var23 = (ParameterizedType)var8;
               var2 = var23.getOwnerType();
               Type var10 = a(var0, var1, var2, var3);
               boolean var4;
               if (var10 != var2) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               Type[] var20 = var23.getActualTypeArguments();
               int var7 = var20.length;
               int var6 = 0;

               while (var6 < var7) {
                  Type var11 = a(var0, var1, var20[var6], var3);
                  Type[] var18 = var20;
                  boolean var5 = var4;
                  if (var11 != var20[var6]) {
                     var18 = var20;
                     var5 = var4;
                     if (!var4) {
                        var18 = (Type[])var20.clone();
                        var5 = true;
                     }

                     var18[var6] = var11;
                  }

                  var6++;
                  var20 = var18;
                  var4 = var5;
               }

               var2 = var23;
               if (var4) {
                  var2 = a(var10, var23.getRawType(), var20);
               }
            } else {
               var2 = var8;
               if (var8 instanceof WildcardType) {
                  WildcardType var21 = (WildcardType)var8;
                  Type[] var25 = var21.getLowerBounds();
                  Type[] var24 = var21.getUpperBounds();
                  if (var25.length == 1) {
                     var0 = a(var0, var1, var25[0], var3);
                     var2 = var21;
                     if (var0 != var25[0]) {
                        var2 = c(var0);
                     }
                  } else {
                     var2 = var21;
                     if (var24.length == 1) {
                        var0 = a(var0, var1, var24[0], var3);
                        var2 = var21;
                        if (var0 != var24[0]) {
                           var2 = b(var0);
                        }
                     }
                  }
               }
            }
            break;
         }

         var9 = (TypeVariable)var8;
         if (var3.contains(var9)) {
            var2 = var8;
            break;
         }

         var3.add(var9);
         var2 = a(var0, var1, var9);
         var8 = var2;
      } while (var2 != var9);

      return var2;
   }

   static Type a(Type var0, Class<?> var1, TypeVariable<?> var2) {
      Class var4 = a(var2);
      if (var4 == null) {
         var0 = var2;
      } else {
         Type var6 = a(var0, var1, var4);
         var0 = var2;
         if (var6 instanceof ParameterizedType) {
            int var3 = a(var4.getTypeParameters(), var2);
            var0 = ((ParameterizedType)var6).getActualTypeArguments()[var3];
         }
      }

      return var0;
   }

   static boolean a(Object var0, Object var1) {
      boolean var2;
      if (var0 != var1 && (var0 == null || !var0.equals(var1))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public static boolean a(Type var0, Type var1) {
      boolean var6 = true;
      boolean var3 = true;
      boolean var4 = true;
      boolean var5 = false;
      boolean var2;
      if (var0 == var1) {
         var2 = true;
      } else if (var0 instanceof Class) {
         var2 = var0.equals(var1);
      } else if (var0 instanceof ParameterizedType) {
         var2 = var5;
         if (var1 instanceof ParameterizedType) {
            ParameterizedType var7 = (ParameterizedType)var0;
            ParameterizedType var11 = (ParameterizedType)var1;
            if (a((Object)var7.getOwnerType(), (Object)var11.getOwnerType())
               && var7.getRawType().equals(var11.getRawType())
               && Arrays.equals(var7.getActualTypeArguments(), var11.getActualTypeArguments())) {
               var2 = var4;
            } else {
               var2 = false;
            }
         }
      } else if (var0 instanceof GenericArrayType) {
         var2 = var5;
         if (var1 instanceof GenericArrayType) {
            GenericArrayType var8 = (GenericArrayType)var0;
            GenericArrayType var12 = (GenericArrayType)var1;
            var2 = a(var8.getGenericComponentType(), var12.getGenericComponentType());
         }
      } else if (var0 instanceof WildcardType) {
         var2 = var5;
         if (var1 instanceof WildcardType) {
            WildcardType var9 = (WildcardType)var0;
            WildcardType var13 = (WildcardType)var1;
            if (Arrays.equals(var9.getUpperBounds(), var13.getUpperBounds()) && Arrays.equals(var9.getLowerBounds(), var13.getLowerBounds())) {
               var2 = var6;
            } else {
               var2 = false;
            }
         }
      } else {
         var2 = var5;
         if (var0 instanceof TypeVariable) {
            var2 = var5;
            if (var1 instanceof TypeVariable) {
               TypeVariable var10 = (TypeVariable)var0;
               TypeVariable var14 = (TypeVariable)var1;
               if (var10.getGenericDeclaration() == var14.getGenericDeclaration() && var10.getName().equals(var14.getName())) {
                  var2 = var3;
               } else {
                  var2 = false;
               }
            }
         }
      }

      return var2;
   }

   static Type b(Type var0, Class<?> var1, Class<?> var2) {
      $Gson$Preconditions.a(var2.isAssignableFrom(var1));
      return a(var0, var1, a(var0, var1, var2));
   }

   public static WildcardType b(Type var0) {
      Type[] var2;
      if (var0 instanceof WildcardType) {
         var2 = ((WildcardType)var0).getUpperBounds();
      } else {
         Type[] var1 = new Type[]{var0};
         var2 = var1;
      }

      return new $Gson$Types.WildcardTypeImpl(var2, a);
   }

   public static Type[] b(Type var0, Class<?> var1) {
      Type[] var2;
      if (var0 == Properties.class) {
         var2 = new Type[]{String.class, String.class};
      } else {
         var0 = b(var0, var1, Map.class);
         if (var0 instanceof ParameterizedType) {
            var2 = ((ParameterizedType)var0).getActualTypeArguments();
         } else {
            var2 = new Type[]{Object.class, Object.class};
         }
      }

      return var2;
   }

   public static WildcardType c(Type var0) {
      Type[] var2;
      if (var0 instanceof WildcardType) {
         var2 = ((WildcardType)var0).getLowerBounds();
      } else {
         Type[] var1 = new Type[]{var0};
         var2 = var1;
      }

      return new $Gson$Types.WildcardTypeImpl(new Type[]{Object.class}, var2);
   }

   public static Type d(Type var0) {
      if (var0 instanceof Class) {
         Serializable var1 = (Class)var0;
         if (var1.isArray()) {
            var1 = new $Gson$Types.GenericArrayTypeImpl(d(var1.getComponentType()));
         }

         var0 = (Type)var1;
      } else if (var0 instanceof ParameterizedType) {
         var0 = var0;
         var0 = new $Gson$Types.ParameterizedTypeImpl(var0.getOwnerType(), var0.getRawType(), var0.getActualTypeArguments());
      } else if (var0 instanceof GenericArrayType) {
         var0 = new $Gson$Types.GenericArrayTypeImpl(((GenericArrayType)var0).getGenericComponentType());
      } else if (var0 instanceof WildcardType) {
         WildcardType var3 = (WildcardType)var0;
         var0 = new $Gson$Types.WildcardTypeImpl(var3.getUpperBounds(), var3.getLowerBounds());
      }

      return var0;
   }

   public static Class<?> e(Type var0) {
      Class var2;
      if (var0 instanceof Class) {
         var2 = (Class)var0;
      } else if (var0 instanceof ParameterizedType) {
         var2 = ((ParameterizedType)var0).getRawType();
         $Gson$Preconditions.a(var2 instanceof Class);
         var2 = var2;
      } else if (var0 instanceof GenericArrayType) {
         var2 = Array.newInstance(e(((GenericArrayType)var0).getGenericComponentType()), 0).getClass();
      } else if (var0 instanceof TypeVariable) {
         var2 = Object.class;
      } else {
         if (!(var0 instanceof WildcardType)) {
            String var1;
            if (var0 == null) {
               var1 = "null";
            } else {
               var1 = var0.getClass().getName();
            }

            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var1);
         }

         var2 = e(((WildcardType)var0).getUpperBounds()[0]);
      }

      return var2;
   }

   public static String f(Type var0) {
      String var1;
      if (var0 instanceof Class) {
         var1 = ((Class)var0).getName();
      } else {
         var1 = var0.toString();
      }

      return var1;
   }

   public static Type g(Type var0) {
      if (var0 instanceof GenericArrayType) {
         var0 = ((GenericArrayType)var0).getGenericComponentType();
      } else {
         var0 = ((Class)var0).getComponentType();
      }

      return var0;
   }

   static void h(Type var0) {
      boolean var1;
      if (var0 instanceof Class && ((Class)var0).isPrimitive()) {
         var1 = false;
      } else {
         var1 = true;
      }

      $Gson$Preconditions.a(var1);
   }

   private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
      private final Type a;

      public GenericArrayTypeImpl(Type var1) {
         this.a = $Gson$Types.d(var1);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof GenericArrayType && $Gson$Types.a(this, (GenericArrayType)var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public Type getGenericComponentType() {
         return this.a;
      }

      @Override
      public int hashCode() {
         return this.a.hashCode();
      }

      @Override
      public String toString() {
         return $Gson$Types.f(this.a) + "[]";
      }
   }

   private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
      private final Type a;
      private final Type b;
      private final Type[] c;

      public ParameterizedTypeImpl(Type var1, Type var2, Type... var3) {
         byte var5 = 0;
         super();
         if (var2 instanceof Class) {
            Class var8 = (Class)var2;
            boolean var4;
            if (!Modifier.isStatic(var8.getModifiers()) && var8.getEnclosingClass() != null) {
               var4 = false;
            } else {
               var4 = true;
            }

            boolean var7;
            if (var1 == null && !var4) {
               var7 = false;
            } else {
               var7 = true;
            }

            $Gson$Preconditions.a(var7);
         }

         if (var1 == null) {
            var1 = null;
         } else {
            var1 = $Gson$Types.d(var1);
         }

         this.a = var1;
         this.b = $Gson$Types.d(var2);
         this.c = (Type[])var3.clone();
         int var6 = this.c.length;

         for (int var10 = var5; var10 < var6; var10++) {
            $Gson$Preconditions.a(this.c[var10]);
            $Gson$Types.h(this.c[var10]);
            this.c[var10] = $Gson$Types.d(this.c[var10]);
         }
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof ParameterizedType && $Gson$Types.a(this, (ParameterizedType)var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public Type[] getActualTypeArguments() {
         return (Type[])this.c.clone();
      }

      @Override
      public Type getOwnerType() {
         return this.a;
      }

      @Override
      public Type getRawType() {
         return this.b;
      }

      @Override
      public int hashCode() {
         return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ $Gson$Types.a((Object)this.a);
      }

      @Override
      public String toString() {
         int var2 = this.c.length;
         String var3;
         if (var2 == 0) {
            var3 = $Gson$Types.f(this.b);
         } else {
            StringBuilder var4 = new StringBuilder((var2 + 1) * 30);
            var4.append($Gson$Types.f(this.b)).append("<").append($Gson$Types.f(this.c[0]));

            for (int var1 = 1; var1 < var2; var1++) {
               var4.append(", ").append($Gson$Types.f(this.c[var1]));
            }

            var3 = var4.append(">").toString();
         }

         return var3;
      }
   }

   private static final class WildcardTypeImpl implements Serializable, WildcardType {
      private final Type a;
      private final Type b;

      public WildcardTypeImpl(Type[] var1, Type[] var2) {
         boolean var4 = true;
         super();
         boolean var3;
         if (var2.length <= 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         $Gson$Preconditions.a(var3);
         if (var1.length == 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         $Gson$Preconditions.a(var3);
         if (var2.length == 1) {
            $Gson$Preconditions.a(var2[0]);
            $Gson$Types.h(var2[0]);
            if (var1[0] == Object.class) {
               var3 = var4;
            } else {
               var3 = false;
            }

            $Gson$Preconditions.a(var3);
            this.b = $Gson$Types.d(var2[0]);
            this.a = Object.class;
         } else {
            $Gson$Preconditions.a(var1[0]);
            $Gson$Types.h(var1[0]);
            this.b = null;
            this.a = $Gson$Types.d(var1[0]);
         }
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof WildcardType && $Gson$Types.a(this, (WildcardType)var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public Type[] getLowerBounds() {
         Type[] var1;
         if (this.b != null) {
            var1 = new Type[]{this.b};
         } else {
            var1 = $Gson$Types.a;
         }

         return var1;
      }

      @Override
      public Type[] getUpperBounds() {
         return new Type[]{this.a};
      }

      @Override
      public int hashCode() {
         int var1;
         if (this.b != null) {
            var1 = this.b.hashCode() + 31;
         } else {
            var1 = 1;
         }

         return var1 ^ this.a.hashCode() + 31;
      }

      @Override
      public String toString() {
         String var1;
         if (this.b != null) {
            var1 = "? super " + $Gson$Types.f(this.b);
         } else if (this.a == Object.class) {
            var1 = "?";
         } else {
            var1 = "? extends " + $Gson$Types.f(this.a);
         }

         return var1;
      }
   }
}
