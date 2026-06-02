package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor a;
   private final FieldNamingStrategy b;
   private final Excluder c;
   private final JsonAdapterAnnotationTypeAdapterFactory d;

   public ReflectiveTypeAdapterFactory(ConstructorConstructor var1, FieldNamingStrategy var2, Excluder var3, JsonAdapterAnnotationTypeAdapterFactory var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   private ReflectiveTypeAdapterFactory.BoundField a(Gson var1, Field var2, String var3, TypeToken<?> var4, boolean var5, boolean var6) {
      boolean var8 = Primitives.a((Type)var4.getRawType());
      JsonAdapter var10 = var2.getAnnotation(JsonAdapter.class);
      TypeAdapter var9 = null;
      if (var10 != null) {
         var9 = this.d.a(this.a, var1, var4, var10);
      }

      boolean var7;
      if (var9 != null) {
         var7 = true;
      } else {
         var7 = false;
      }

      TypeAdapter var11 = var9;
      if (var9 == null) {
         var11 = var1.a(var4);
      }

      return new ReflectiveTypeAdapterFactory.BoundField(this, var3, var5, var6, var2, var7, var11, var1, var4, var8) {
         final Field a;
         final boolean b;
         final TypeAdapter c;
         final Gson d;
         final TypeToken e;
         final boolean f;
         final ReflectiveTypeAdapterFactory g;

         {
            this.g = var1;
            this.a = var5x;
            this.b = var6x;
            this.c = var7x;
            this.d = var8x;
            this.e = var9x;
            this.f = var10x;
         }

         @Override
         void a(JsonReader var1, Object var2x) throws IOException, IllegalAccessException {
            Object var3x = this.c.read(var1);
            if (var3x != null || !this.f) {
               this.a.set(var2x, var3x);
            }
         }

         @Override
         void a(JsonWriter var1, Object var2x) throws IOException, IllegalAccessException {
            Object var3x = this.a.get(var2x);
            if (this.b) {
               var2x = this.c;
            } else {
               var2x = new TypeAdapterRuntimeTypeWrapper(this.d, this.c, this.e.getType());
            }

            var2x.write(var1, var3x);
         }

         @Override
         public boolean a(Object var1) throws IOException, IllegalAccessException {
            boolean var2x = false;
            if (this.i && this.a.get(var1) != var1) {
               var2x = true;
            }

            return var2x;
         }
      };
   }

   private List<String> a(Field var1) {
      SerializedName var4 = var1.getAnnotation(SerializedName.class);
      List var6;
      if (var4 == null) {
         var6 = Collections.singletonList(this.b.translateName(var1));
      } else {
         String var7 = var4.a();
         String[] var5 = var4.b();
         if (var5.length == 0) {
            var6 = Collections.singletonList(var7);
         } else {
            ArrayList var8 = new ArrayList(var5.length + 1);
            var8.add(var7);
            int var3 = var5.length;
            int var2 = 0;

            while (true) {
               var6 = var8;
               if (var2 >= var3) {
                  break;
               }

               var8.add(var5[var2]);
               var2++;
            }
         }
      }

      return var6;
   }

   private Map<String, ReflectiveTypeAdapterFactory.BoundField> a(Gson var1, TypeToken<?> var2, Class<?> var3) {
      LinkedHashMap var12 = new LinkedHashMap();
      if (!var3.isInterface()) {
         Type var13 = var2.getType();

         for (TypeToken var10 = var2; var3 != Object.class; var3 = var10.getRawType()) {
            for (Field var17 : var3.getDeclaredFields()) {
               boolean var8 = this.a(var17, true);
               boolean var9 = this.a(var17, false);
               if (var8 || var9) {
                  var17.setAccessible(true);
                  Type var16 = $Gson$Types.a(var10.getType(), var3, var17.getGenericType());
                  List var15 = this.a(var17);
                  ReflectiveTypeAdapterFactory.BoundField var18 = null;
                  int var7 = var15.size();

                  for (int var5 = 0; var5 < var7; var5++) {
                     String var11 = (String)var15.get(var5);
                     if (var5 != 0) {
                        var8 = false;
                     }

                     ReflectiveTypeAdapterFactory.BoundField var19 = var12.put(var11, this.a(var1, var17, var11, TypeToken.get(var16), var8, var9));
                     if (var18 == null) {
                        var18 = var19;
                     }
                  }

                  if (var18 != null) {
                     throw new IllegalArgumentException(var13 + " declares multiple JSON fields named " + var18.h);
                  }
               }
            }

            var10 = TypeToken.get($Gson$Types.a(var10.getType(), var3, var3.getGenericSuperclass()));
         }
      }

      return var12;
   }

   static boolean a(Field var0, boolean var1, Excluder var2) {
      if (!var2.a(var0.getType(), var1) && !var2.a(var0, var1)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
      Class var3 = var2.getRawType();
      ReflectiveTypeAdapterFactory.Adapter var4;
      if (!Object.class.isAssignableFrom(var3)) {
         var4 = null;
      } else {
         var4 = new ReflectiveTypeAdapterFactory.Adapter(this.a.a(var2), this.a(var1, var2, var3));
      }

      return var4;
   }

   public boolean a(Field var1, boolean var2) {
      return a(var1, var2, this.c);
   }

   public static final class Adapter<T> extends TypeAdapter<T> {
      private final ObjectConstructor<T> a;
      private final Map<String, ReflectiveTypeAdapterFactory.BoundField> b;

      Adapter(ObjectConstructor<T> var1, Map<String, ReflectiveTypeAdapterFactory.BoundField> var2) {
         this.a = var1;
         this.b = var2;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public T read(JsonReader var1) throws IOException {
         Object var14;
         if (var1.f() == JsonToken.NULL) {
            var1.j();
            var14 = null;
         } else {
            Object var2 = this.a.a();

            try {
               var1.c();
            } catch (IllegalStateException var8) {
               throw new JsonSyntaxException(var8);
            } catch (IllegalAccessException var9) {
               throw new AssertionError(var9);
            }

            while (true) {
               ReflectiveTypeAdapterFactory.BoundField var15;
               try {
                  if (!var1.e()) {
                     break;
                  }

                  String var3 = var1.g();
                  var15 = this.b.get(var3);
               } catch (IllegalStateException var10) {
                  throw new JsonSyntaxException(var10);
               } catch (IllegalAccessException var11) {
                  throw new AssertionError(var11);
               }

               label64: {
                  if (var15 != null) {
                     try {
                        if (var15.j) {
                           break label64;
                        }
                     } catch (IllegalStateException var12) {
                        throw new JsonSyntaxException(var12);
                     } catch (IllegalAccessException var13) {
                        throw new AssertionError(var13);
                     }
                  }

                  try {
                     var1.n();
                     continue;
                  } catch (IllegalStateException var6) {
                     throw new JsonSyntaxException(var6);
                  } catch (IllegalAccessException var7) {
                     throw new AssertionError(var7);
                  }
               }

               try {
                  var15.a(var1, var2);
               } catch (IllegalStateException var4) {
                  throw new JsonSyntaxException(var4);
               } catch (IllegalAccessException var5) {
                  throw new AssertionError(var5);
               }
            }

            var1.d();
            var14 = var2;
         }

         return (T)var14;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void write(JsonWriter var1, T var2) throws IOException {
         if (var2 == null) {
            var1.f();
         } else {
            var1.d();

            Iterator var4;
            try {
               var4 = this.b.values().iterator();
            } catch (IllegalAccessException var5) {
               throw new AssertionError(var5);
            }

            while (true) {
               try {
                  if (!var4.hasNext()) {
                     break;
                  }

                  ReflectiveTypeAdapterFactory.BoundField var3 = (ReflectiveTypeAdapterFactory.BoundField)var4.next();
                  if (var3.a(var2)) {
                     var1.a(var3.h);
                     var3.a(var1, var2);
                  }
               } catch (IllegalAccessException var6) {
                  throw new AssertionError(var6);
               }
            }

            var1.e();
         }
      }
   }

   abstract static class BoundField {
      final String h;
      final boolean i;
      final boolean j;

      protected BoundField(String var1, boolean var2, boolean var3) {
         this.h = var1;
         this.i = var2;
         this.j = var3;
      }

      abstract void a(JsonReader var1, Object var2) throws IOException, IllegalAccessException;

      abstract void a(JsonWriter var1, Object var2) throws IOException, IllegalAccessException;

      abstract boolean a(Object var1) throws IOException, IllegalAccessException;
   }
}
