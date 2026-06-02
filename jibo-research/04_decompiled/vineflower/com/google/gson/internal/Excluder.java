package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
   public static final Excluder a = new Excluder();
   private double b = -1.0;
   private int c = 136;
   private boolean d = true;
   private boolean e;
   private List<ExclusionStrategy> f = Collections.emptyList();
   private List<ExclusionStrategy> g = Collections.emptyList();

   private boolean a(Since var1) {
      boolean var2;
      if (var1 != null && var1.a() > this.b) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private boolean a(Since var1, Until var2) {
      boolean var3;
      if (this.a(var1) && this.a(var2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private boolean a(Until var1) {
      boolean var2;
      if (var1 != null && var1.a() <= this.b) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private boolean a(Class<?> var1) {
      boolean var2;
      if (Enum.class.isAssignableFrom(var1) || !var1.isAnonymousClass() && !var1.isLocalClass()) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private boolean b(Class<?> var1) {
      boolean var2;
      if (var1.isMemberClass() && !this.c(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private boolean c(Class<?> var1) {
      boolean var2;
      if ((var1.getModifiers() & 8) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
      Class var5 = var2.getRawType();
      boolean var3 = this.a(var5, true);
      boolean var4 = this.a(var5, false);
      TypeAdapter var6;
      if (!var3 && !var4) {
         var6 = null;
      } else {
         var6 = new TypeAdapter<T>(this, var4, var3, var1, var2) {
            final boolean a;
            final boolean b;
            final Gson c;
            final TypeToken d;
            final Excluder e;
            private TypeAdapter<T> f;

            {
               this.e = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5x;
            }

            private TypeAdapter<T> a() {
               TypeAdapter var1x = this.f;
               if (var1x == null) {
                  var1x = this.c.a(this.e, this.d);
                  this.f = var1x;
               }

               return var1x;
            }

            @Override
            public T read(JsonReader var1) throws IOException {
               Object var2x;
               if (this.a) {
                  var1.n();
                  var2x = null;
               } else {
                  var2x = this.a().read(var1);
               }

               return (T)var2x;
            }

            @Override
            public void write(JsonWriter var1, T var2x) throws IOException {
               if (this.b) {
                  var1.f();
               } else {
                  this.a().write(var1, var2x);
               }
            }
         };
      }

      return var6;
   }

   protected Excluder a() {
      try {
         return (Excluder)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError(var2);
      }
   }

   public boolean a(Class<?> var1, boolean var2) {
      if (this.b != -1.0 && !this.a(var1.getAnnotation(Since.class), var1.getAnnotation(Until.class))) {
         var2 = true;
      } else if (!this.d && this.b(var1)) {
         var2 = true;
      } else if (this.a(var1)) {
         var2 = true;
      } else {
         List var3;
         if (var2) {
            var3 = this.f;
         } else {
            var3 = this.g;
         }

         Iterator var5 = var3.iterator();

         while (true) {
            if (!var5.hasNext()) {
               var2 = false;
               break;
            }

            if (((ExclusionStrategy)var5.next()).a(var1)) {
               var2 = true;
               break;
            }
         }
      }

      return var2;
   }

   public boolean a(Field var1, boolean var2) {
      if ((this.c & var1.getModifiers()) != 0) {
         var2 = true;
      } else if (this.b != -1.0 && !this.a(var1.getAnnotation(Since.class), var1.getAnnotation(Until.class))) {
         var2 = true;
      } else if (var1.isSynthetic()) {
         var2 = true;
      } else {
         if (this.e) {
            Expose var3 = var1.getAnnotation(Expose.class);
            if (var3 == null || (var2 ? !var3.a() : !var3.b())) {
               var2 = true;
               return var2;
            }
         }

         if (!this.d && this.b(var1.getType())) {
            var2 = true;
         } else if (this.a(var1.getType())) {
            var2 = true;
         } else {
            List var6;
            if (var2) {
               var6 = this.f;
            } else {
               var6 = this.g;
            }

            if (!var6.isEmpty()) {
               FieldAttributes var4 = new FieldAttributes(var1);
               Iterator var7 = var6.iterator();

               while (var7.hasNext()) {
                  if (((ExclusionStrategy)var7.next()).a(var4)) {
                     var2 = true;
                     return var2;
                  }
               }
            }

            var2 = false;
         }
      }

      return var2;
   }
}
