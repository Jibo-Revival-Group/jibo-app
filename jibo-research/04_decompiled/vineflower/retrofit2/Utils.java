package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.ResponseBody;
import okio.Buffer;

final class Utils {
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
      for (int var2 = 0; var2 < var0.length; var2++) {
         if (var1.equals(var0[var2])) {
            return var2;
         }
      }

      throw new NoSuchElementException();
   }

   static Class<?> a(Type var0) {
      a(var0, "type == null");
      Class var1;
      if (var0 instanceof Class) {
         var1 = (Class)var0;
      } else if (var0 instanceof ParameterizedType) {
         var1 = ((ParameterizedType)var0).getRawType();
         if (!(var1 instanceof Class)) {
            throw new IllegalArgumentException();
         }

         var1 = var1;
      } else if (var0 instanceof GenericArrayType) {
         var1 = Array.newInstance(a(((GenericArrayType)var0).getGenericComponentType()), 0).getClass();
      } else if (var0 instanceof TypeVariable) {
         var1 = Object.class;
      } else {
         if (!(var0 instanceof WildcardType)) {
            throw new IllegalArgumentException(
               "Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var0.getClass().getName()
            );
         }

         var1 = a(((WildcardType)var0).getUpperBounds()[0]);
      }

      return var1;
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

   static <T> T a(T var0, String var1) {
      if (var0 == null) {
         throw new NullPointerException(var1);
      } else {
         return (T)var0;
      }
   }

   static Type a(int var0, ParameterizedType var1) {
      Type[] var2 = var1.getActualTypeArguments();
      if (var0 >= 0 && var0 < var2.length) {
         Type var4 = var2[var0];
         Type var3 = var4;
         if (var4 instanceof WildcardType) {
            var3 = ((WildcardType)var4).getUpperBounds()[0];
         }

         return var3;
      } else {
         throw new IllegalArgumentException("Index " + var0 + " not in range [0," + var2.length + ") for " + var1);
      }
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

   static Type a(Type var0, Class<?> var1, Type var2) {
      Type var7 = var2;

      while (true) {
         if (!(var7 instanceof TypeVariable)) {
            if (var7 instanceof Class && ((Class)var7).isArray()) {
               var2 = (Class)var7;
               Class var23 = var2.getComponentType();
               var0 = a(var0, var1, (Type)var23);
               if (var23 != var0) {
                  var2 = new Utils.GenericArrayTypeImpl(var0);
               }
               break;
            }

            if (var7 instanceof GenericArrayType) {
               var2 = (GenericArrayType)var7;
               var7 = var2.getGenericComponentType();
               var0 = a(var0, var1, var7);
               if (var7 != var0) {
                  var2 = new Utils.GenericArrayTypeImpl(var0);
               }
            } else if (var7 instanceof ParameterizedType) {
               ParameterizedType var8 = (ParameterizedType)var7;
               var2 = var8.getOwnerType();
               Type var9 = a(var0, var1, var2);
               boolean var3;
               if (var9 != var2) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               Type[] var21 = var8.getActualTypeArguments();
               int var6 = var21.length;
               int var5 = 0;

               while (var5 < var6) {
                  Type var10 = a(var0, var1, var21[var5]);
                  Type[] var18 = var21;
                  boolean var4 = var3;
                  if (var10 != var21[var5]) {
                     var18 = var21;
                     var4 = var3;
                     if (!var3) {
                        var18 = (Type[])var21.clone();
                        var4 = true;
                     }

                     var18[var5] = var10;
                  }

                  var5++;
                  var21 = var18;
                  var3 = var4;
               }

               var2 = var8;
               if (var3) {
                  var2 = new Utils.ParameterizedTypeImpl(var9, var8.getRawType(), var21);
               }
            } else {
               var2 = var7;
               if (var7 instanceof WildcardType) {
                  WildcardType var22 = (WildcardType)var7;
                  Type[] var25 = var22.getLowerBounds();
                  Type[] var24 = var22.getUpperBounds();
                  if (var25.length == 1) {
                     var0 = a(var0, var1, var25[0]);
                     var2 = var22;
                     if (var0 != var25[0]) {
                        var2 = new Utils.WildcardTypeImpl(new Type[]{Object.class}, new Type[]{var0});
                     }
                  } else {
                     var2 = var22;
                     if (var24.length == 1) {
                        var0 = a(var0, var1, var24[0]);
                        var2 = var22;
                        if (var0 != var24[0]) {
                           Type[] var15 = a;
                           var2 = new Utils.WildcardTypeImpl(new Type[]{var0}, var15);
                        }
                     }
                  }
               }
            }
            break;
         }

         TypeVariable var19 = (TypeVariable)var7;
         var2 = a(var0, var1, var19);
         if (var2 == var19) {
            break;
         }

         var7 = var2;
      }

      return var2;
   }

   private static Type a(Type var0, Class<?> var1, TypeVariable<?> var2) {
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

   static ResponseBody a(ResponseBody var0) throws IOException {
      Buffer var1 = new Buffer();
      var0.c().a(var1);
      return ResponseBody.a(var0.a(), var0.b(), var1);
   }

   static <T> void a(Class<T> var0) {
      if (!var0.isInterface()) {
         throw new IllegalArgumentException("API declarations must be interfaces.");
      }

      if (var0.getInterfaces().length > 0) {
         throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
      }
   }

   private static boolean a(Object var0, Object var1) {
      boolean var2;
      if (var0 != var1 && (var0 == null || !var0.equals(var1))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   static boolean a(Type var0, Type var1) {
      boolean var4 = true;
      boolean var3 = true;
      boolean var6 = true;
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
               var2 = var6;
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
               var2 = var4;
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

   static boolean a(Annotation[] var0, Class<? extends Annotation> var1) {
      boolean var5 = false;
      int var3 = var0.length;
      int var2 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var3) {
            break;
         }

         if (var1.isInstance(var0[var2])) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }

   static String b(Type var0) {
      String var1;
      if (var0 instanceof Class) {
         var1 = ((Class)var0).getName();
      } else {
         var1 = var0.toString();
      }

      return var1;
   }

   static Type b(Type var0, Class<?> var1, Class<?> var2) {
      if (!var2.isAssignableFrom(var1)) {
         throw new IllegalArgumentException();
      } else {
         return a(var0, var1, a(var0, var1, var2));
      }
   }

   static void c(Type var0) {
      if (var0 instanceof Class && ((Class)var0).isPrimitive()) {
         throw new IllegalArgumentException();
      }
   }

   static boolean d(Type var0) {
      boolean var4 = false;
      boolean var3;
      if (var0 instanceof Class) {
         var3 = var4;
      } else if (var0 instanceof ParameterizedType) {
         Type[] var6 = ((ParameterizedType)var0).getActualTypeArguments();
         int var2 = var6.length;
         int var1 = 0;

         while (true) {
            var3 = var4;
            if (var1 >= var2) {
               break;
            }

            if (d(var6[var1])) {
               var3 = true;
               break;
            }

            var1++;
         }
      } else if (var0 instanceof GenericArrayType) {
         var3 = d(((GenericArrayType)var0).getGenericComponentType());
      } else if (var0 instanceof TypeVariable) {
         var3 = true;
      } else {
         if (!(var0 instanceof WildcardType)) {
            String var5;
            if (var0 == null) {
               var5 = "null";
            } else {
               var5 = var0.getClass().getName();
            }

            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var5);
         }

         var3 = true;
      }

      return var3;
   }

   static Type e(Type var0) {
      if (!(var0 instanceof ParameterizedType)) {
         throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
      } else {
         return a(0, (ParameterizedType)var0);
      }
   }

   private static final class GenericArrayTypeImpl implements GenericArrayType {
      private final Type a;

      GenericArrayTypeImpl(Type var1) {
         this.a = var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof GenericArrayType && Utils.a(this, (GenericArrayType)var1)) {
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
         return Utils.b(this.a) + "[]";
      }
   }

   private static final class ParameterizedTypeImpl implements ParameterizedType {
      private final Type a;
      private final Type b;
      private final Type[] c;

      ParameterizedTypeImpl(Type var1, Type var2, Type... var3) {
         int var5 = 1;
         byte var6 = 0;
         super();
         if (var2 instanceof Class) {
            boolean var4;
            if (var1 == null) {
               var4 = true;
            } else {
               var4 = false;
            }

            if (((Class)var2).getEnclosingClass() != null) {
               var5 = 0;
            }

            if (var4 != var5) {
               throw new IllegalArgumentException();
            }
         }

         var5 = var3.length;

         for (int var8 = var6; var8 < var5; var8++) {
            Type var7 = var3[var8];
            Utils.a(var7, "typeArgument == null");
            Utils.c(var7);
         }

         this.a = var1;
         this.b = var2;
         this.c = (Type[])var3.clone();
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof ParameterizedType && Utils.a(this, (ParameterizedType)var1)) {
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
         return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ Utils.a((Object)this.a);
      }

      @Override
      public String toString() {
         String var2;
         if (this.c.length == 0) {
            var2 = Utils.b(this.b);
         } else {
            StringBuilder var3 = new StringBuilder((this.c.length + 1) * 30);
            var3.append(Utils.b(this.b));
            var3.append("<").append(Utils.b(this.c[0]));

            for (int var1 = 1; var1 < this.c.length; var1++) {
               var3.append(", ").append(Utils.b(this.c[var1]));
            }

            var2 = var3.append(">").toString();
         }

         return var2;
      }
   }

   private static final class WildcardTypeImpl implements WildcardType {
      private final Type a;
      private final Type b;

      WildcardTypeImpl(Type[] var1, Type[] var2) {
         if (var2.length > 1) {
            throw new IllegalArgumentException();
         }

         if (var1.length != 1) {
            throw new IllegalArgumentException();
         }

         if (var2.length == 1) {
            if (var2[0] == null) {
               throw new NullPointerException();
            }

            Utils.c(var2[0]);
            if (var1[0] != Object.class) {
               throw new IllegalArgumentException();
            }

            this.b = var2[0];
            this.a = Object.class;
         } else {
            if (var1[0] == null) {
               throw new NullPointerException();
            }

            Utils.c(var1[0]);
            this.b = null;
            this.a = var1[0];
         }
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof WildcardType && Utils.a(this, (WildcardType)var1)) {
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
            var1 = Utils.a;
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
            var1 = "? super " + Utils.b(this.b);
         } else if (this.a == Object.class) {
            var1 = "?";
         } else {
            var1 = "? extends " + Utils.b(this.a);
         }

         return var1;
      }
   }
}
