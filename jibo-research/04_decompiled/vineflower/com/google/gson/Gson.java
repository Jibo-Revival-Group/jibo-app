package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
   private static final TypeToken<?> a = TypeToken.get(Object.class);
   private final ThreadLocal<Map<TypeToken<?>, Gson.FutureTypeAdapter<?>>> b = new ThreadLocal<>();
   private final Map<TypeToken<?>, TypeAdapter<?>> c = new ConcurrentHashMap<>();
   private final List<TypeAdapterFactory> d;
   private final ConstructorConstructor e;
   private final Excluder f;
   private final FieldNamingStrategy g;
   private final boolean h;
   private final boolean i;
   private final boolean j;
   private final boolean k;
   private final boolean l;
   private final JsonAdapterAnnotationTypeAdapterFactory m;

   public Gson() {
      this(
         Excluder.a,
         FieldNamingPolicy.IDENTITY,
         Collections.emptyMap(),
         false,
         false,
         false,
         true,
         false,
         false,
         false,
         LongSerializationPolicy.DEFAULT,
         Collections.emptyList()
      );
   }

   Gson(
      Excluder var1,
      FieldNamingStrategy var2,
      Map<Type, InstanceCreator<?>> var3,
      boolean var4,
      boolean var5,
      boolean var6,
      boolean var7,
      boolean var8,
      boolean var9,
      boolean var10,
      LongSerializationPolicy var11,
      List<TypeAdapterFactory> var12
   ) {
      this.e = new ConstructorConstructor(var3);
      this.f = var1;
      this.g = var2;
      this.h = var4;
      this.j = var6;
      this.i = var7;
      this.k = var8;
      this.l = var9;
      ArrayList var13 = new ArrayList();
      var13.add(TypeAdapters.Y);
      var13.add(ObjectTypeAdapter.a);
      var13.add(var1);
      var13.addAll(var12);
      var13.add(TypeAdapters.D);
      var13.add(TypeAdapters.m);
      var13.add(TypeAdapters.g);
      var13.add(TypeAdapters.i);
      var13.add(TypeAdapters.k);
      TypeAdapter var14 = a(var11);
      var13.add(TypeAdapters.a(long.class, Long.class, var14));
      var13.add(TypeAdapters.a(double.class, Double.class, this.a(var10)));
      var13.add(TypeAdapters.a(float.class, Float.class, this.b(var10)));
      var13.add(TypeAdapters.x);
      var13.add(TypeAdapters.o);
      var13.add(TypeAdapters.q);
      var13.add(TypeAdapters.a(AtomicLong.class, a(var14)));
      var13.add(TypeAdapters.a(AtomicLongArray.class, b(var14)));
      var13.add(TypeAdapters.s);
      var13.add(TypeAdapters.z);
      var13.add(TypeAdapters.F);
      var13.add(TypeAdapters.H);
      var13.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.B));
      var13.add(TypeAdapters.a(BigInteger.class, TypeAdapters.C));
      var13.add(TypeAdapters.J);
      var13.add(TypeAdapters.L);
      var13.add(TypeAdapters.P);
      var13.add(TypeAdapters.R);
      var13.add(TypeAdapters.W);
      var13.add(TypeAdapters.N);
      var13.add(TypeAdapters.d);
      var13.add(DateTypeAdapter.a);
      var13.add(TypeAdapters.U);
      var13.add(TimeTypeAdapter.a);
      var13.add(SqlDateTypeAdapter.a);
      var13.add(TypeAdapters.S);
      var13.add(ArrayTypeAdapter.a);
      var13.add(TypeAdapters.b);
      var13.add(new CollectionTypeAdapterFactory(this.e));
      var13.add(new MapTypeAdapterFactory(this.e, var5));
      this.m = new JsonAdapterAnnotationTypeAdapterFactory(this.e);
      var13.add(this.m);
      var13.add(TypeAdapters.Z);
      var13.add(new ReflectiveTypeAdapterFactory(this.e, var2, var1, this.m));
      this.d = Collections.unmodifiableList(var13);
   }

   private static TypeAdapter<Number> a(LongSerializationPolicy var0) {
      TypeAdapter var1;
      if (var0 == LongSerializationPolicy.DEFAULT) {
         var1 = TypeAdapters.t;
      } else {
         var1 = new TypeAdapter<Number>() {
            public Number a(JsonReader var1) throws IOException {
               Long var2;
               if (var1.f() == JsonToken.NULL) {
                  var1.j();
                  var2 = null;
               } else {
                  var2 = var1.l();
               }

               return var2;
            }

            public void a(JsonWriter var1, Number var2) throws IOException {
               if (var2 == null) {
                  var1.f();
               } else {
                  var1.b(var2.toString());
               }
            }
         };
      }

      return var1;
   }

   private static TypeAdapter<AtomicLong> a(TypeAdapter<Number> var0) {
      return (new TypeAdapter<AtomicLong>(var0) {
         final TypeAdapter a;

         {
            this.a = var1;
         }

         public AtomicLong a(JsonReader var1) throws IOException {
            return new AtomicLong(((Number)this.a.read(var1)).longValue());
         }

         public void a(JsonWriter var1, AtomicLong var2) throws IOException {
            this.a.write(var1, var2.get());
         }
      }).nullSafe();
   }

   private TypeAdapter<Number> a(boolean var1) {
      TypeAdapter var2;
      if (var1) {
         var2 = TypeAdapters.v;
      } else {
         var2 = new TypeAdapter<Number>(this) {
            final Gson a;

            {
               this.a = var1;
            }

            public Double a(JsonReader var1) throws IOException {
               Double var2x;
               if (var1.f() == JsonToken.NULL) {
                  var1.j();
                  var2x = null;
               } else {
                  var2x = var1.k();
               }

               return var2x;
            }

            public void a(JsonWriter var1, Number var2x) throws IOException {
               if (var2x == null) {
                  var1.f();
               } else {
                  Gson.a(var2x.doubleValue());
                  var1.a(var2x);
               }
            }
         };
      }

      return var2;
   }

   static void a(double var0) {
      if (Double.isNaN(var0) || Double.isInfinite(var0)) {
         throw new IllegalArgumentException(
            var0
               + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method."
         );
      }
   }

   private static void a(Object var0, JsonReader var1) {
      if (var0 != null) {
         try {
            if (var1.f() != JsonToken.END_DOCUMENT) {
               var0 = new JsonIOException("JSON document was not fully consumed.");
               throw var0;
            }
         } catch (MalformedJsonException var2) {
            throw new JsonSyntaxException(var2);
         } catch (IOException var3) {
            throw new JsonIOException(var3);
         }
      }
   }

   private static TypeAdapter<AtomicLongArray> b(TypeAdapter<Number> var0) {
      return (new TypeAdapter<AtomicLongArray>(var0) {
         final TypeAdapter a;

         {
            this.a = var1;
         }

         public AtomicLongArray a(JsonReader var1) throws IOException {
            ArrayList var4 = new ArrayList();
            var1.a();

            while (var1.e()) {
               var4.add(((Number)this.a.read(var1)).longValue());
            }

            var1.b();
            int var3 = var4.size();
            AtomicLongArray var5 = new AtomicLongArray(var3);

            for (int var2 = 0; var2 < var3; var2++) {
               var5.set(var2, (Long)var4.get(var2));
            }

            return var5;
         }

         public void a(JsonWriter var1, AtomicLongArray var2) throws IOException {
            var1.b();
            int var3 = 0;

            for (int var4 = var2.length(); var3 < var4; var3++) {
               this.a.write(var1, var2.get(var3));
            }

            var1.c();
         }
      }).nullSafe();
   }

   private TypeAdapter<Number> b(boolean var1) {
      TypeAdapter var2;
      if (var1) {
         var2 = TypeAdapters.u;
      } else {
         var2 = new TypeAdapter<Number>(this) {
            final Gson a;

            {
               this.a = var1;
            }

            public Float a(JsonReader var1) throws IOException {
               Float var2x;
               if (var1.f() == JsonToken.NULL) {
                  var1.j();
                  var2x = null;
               } else {
                  var2x = (float)var1.k();
               }

               return var2x;
            }

            public void a(JsonWriter var1, Number var2x) throws IOException {
               if (var2x == null) {
                  var1.f();
               } else {
                  Gson.a(var2x.floatValue());
                  var1.a(var2x);
               }
            }
         };
      }

      return var2;
   }

   public JsonElement a(Object var1) {
      if (var1 == null) {
         var1 = JsonNull.a;
      } else {
         var1 = this.a((Object)var1, (Type)var1.getClass());
      }

      return var1;
   }

   public JsonElement a(Object var1, Type var2) {
      JsonTreeWriter var3 = new JsonTreeWriter();
      this.a(var1, var2, var3);
      return var3.a();
   }

   public <T> TypeAdapter<T> a(TypeAdapterFactory var1, TypeToken<T> var2) {
      TypeAdapterFactory var4 = var1;
      if (!this.d.contains(var1)) {
         var4 = this.m;
      }

      Iterator var6 = this.d.iterator();
      boolean var3 = false;

      while (var6.hasNext()) {
         TypeAdapterFactory var5 = (TypeAdapterFactory)var6.next();
         if (!var3) {
            if (var5 == var4) {
               var3 = true;
            }
         } else {
            TypeAdapter var7 = var5.a(this, var2);
            if (var7 != null) {
               return var7;
            }
         }
      }

      throw new IllegalArgumentException("GSON cannot serialize " + var2);
   }

   public <T> TypeAdapter<T> a(TypeToken<T> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield com/google/gson/Gson.c Ljava/util/Map;
      // 004: astore 4
      // 006: aload 1
      // 007: ifnonnull 020
      // 00a: getstatic com/google/gson/Gson.a Lcom/google/gson/reflect/TypeToken;
      // 00d: astore 3
      // 00e: aload 4
      // 010: aload 3
      // 011: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 016: checkcast com/google/gson/TypeAdapter
      // 019: astore 3
      // 01a: aload 3
      // 01b: ifnull 025
      // 01e: aload 3
      // 01f: areturn
      // 020: aload 1
      // 021: astore 3
      // 022: goto 00e
      // 025: aload 0
      // 026: getfield com/google/gson/Gson.b Ljava/lang/ThreadLocal;
      // 029: invokevirtual java/lang/ThreadLocal.get ()Ljava/lang/Object;
      // 02c: checkcast java/util/Map
      // 02f: astore 4
      // 031: bipush 0
      // 032: istore 2
      // 033: aload 4
      // 035: ifnonnull 10a
      // 038: new java/util/HashMap
      // 03b: dup
      // 03c: invokespecial java/util/HashMap.<init> ()V
      // 03f: astore 4
      // 041: aload 0
      // 042: getfield com/google/gson/Gson.b Ljava/lang/ThreadLocal;
      // 045: aload 4
      // 047: invokevirtual java/lang/ThreadLocal.set (Ljava/lang/Object;)V
      // 04a: bipush 1
      // 04b: istore 2
      // 04c: aload 4
      // 04e: aload 1
      // 04f: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 054: checkcast com/google/gson/Gson$FutureTypeAdapter
      // 057: astore 5
      // 059: aload 5
      // 05b: astore 3
      // 05c: aload 5
      // 05e: ifnonnull 01e
      // 061: new com/google/gson/Gson$FutureTypeAdapter
      // 064: astore 3
      // 065: aload 3
      // 066: invokespecial com/google/gson/Gson$FutureTypeAdapter.<init> ()V
      // 069: aload 4
      // 06b: aload 1
      // 06c: aload 3
      // 06d: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 072: pop
      // 073: aload 0
      // 074: getfield com/google/gson/Gson.d Ljava/util/List;
      // 077: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 07c: astore 6
      // 07e: aload 6
      // 080: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 085: ifeq 0d0
      // 088: aload 6
      // 08a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08f: checkcast com/google/gson/TypeAdapterFactory
      // 092: aload 0
      // 093: aload 1
      // 094: invokeinterface com/google/gson/TypeAdapterFactory.a (Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter; 3
      // 099: astore 5
      // 09b: aload 5
      // 09d: ifnull 07e
      // 0a0: aload 3
      // 0a1: aload 5
      // 0a3: invokevirtual com/google/gson/Gson$FutureTypeAdapter.a (Lcom/google/gson/TypeAdapter;)V
      // 0a6: aload 0
      // 0a7: getfield com/google/gson/Gson.c Ljava/util/Map;
      // 0aa: aload 1
      // 0ab: aload 5
      // 0ad: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0b2: pop
      // 0b3: aload 4
      // 0b5: aload 1
      // 0b6: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0bb: pop
      // 0bc: aload 5
      // 0be: astore 3
      // 0bf: iload 2
      // 0c0: ifeq 01e
      // 0c3: aload 0
      // 0c4: getfield com/google/gson/Gson.b Ljava/lang/ThreadLocal;
      // 0c7: invokevirtual java/lang/ThreadLocal.remove ()V
      // 0ca: aload 5
      // 0cc: astore 3
      // 0cd: goto 01e
      // 0d0: new java/lang/IllegalArgumentException
      // 0d3: astore 3
      // 0d4: new java/lang/StringBuilder
      // 0d7: astore 5
      // 0d9: aload 5
      // 0db: invokespecial java/lang/StringBuilder.<init> ()V
      // 0de: aload 3
      // 0df: aload 5
      // 0e1: ldc_w "GSON cannot handle "
      // 0e4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e7: aload 1
      // 0e8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0eb: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ee: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 0f1: aload 3
      // 0f2: athrow
      // 0f3: astore 3
      // 0f4: aload 4
      // 0f6: aload 1
      // 0f7: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0fc: pop
      // 0fd: iload 2
      // 0fe: ifeq 108
      // 101: aload 0
      // 102: getfield com/google/gson/Gson.b Ljava/lang/ThreadLocal;
      // 105: invokevirtual java/lang/ThreadLocal.remove ()V
      // 108: aload 3
      // 109: athrow
      // 10a: goto 04c
      // try (47 -> 60): 111 null
      // try (60 -> 70): 111 null
      // try (72 -> 81): 111 null
      // try (95 -> 111): 111 null
   }

   public <T> TypeAdapter<T> a(Class<T> var1) {
      return this.a(TypeToken.get(var1));
   }

   public JsonReader a(Reader var1) {
      JsonReader var2 = new JsonReader(var1);
      var2.a(this.l);
      return var2;
   }

   public JsonWriter a(Writer var1) throws IOException {
      if (this.j) {
         var1.write(")]}'\n");
      }

      JsonWriter var2 = new JsonWriter(var1);
      if (this.k) {
         var2.c("  ");
      }

      var2.d(this.h);
      return var2;
   }

   public <T> T a(JsonElement var1, Class<T> var2) throws JsonSyntaxException {
      Object var3 = this.a(var1, (Type)var2);
      return Primitives.<T>a(var2).cast(var3);
   }

   public <T> T a(JsonElement var1, Type var2) throws JsonSyntaxException {
      Object var3;
      if (var1 == null) {
         var3 = null;
      } else {
         var3 = this.a(new JsonTreeReader(var1), var2);
      }

      return (T)var3;
   }

   public <T> T a(JsonReader param1, Type param2) throws JsonIOException, JsonSyntaxException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 1
      // 03: invokevirtual com/google/gson/stream/JsonReader.q ()Z
      // 06: istore 4
      // 08: aload 1
      // 09: bipush 1
      // 0a: invokevirtual com/google/gson/stream/JsonReader.a (Z)V
      // 0d: aload 1
      // 0e: invokevirtual com/google/gson/stream/JsonReader.f ()Lcom/google/gson/stream/JsonToken;
      // 11: pop
      // 12: bipush 0
      // 13: istore 3
      // 14: aload 0
      // 15: aload 2
      // 16: invokestatic com/google/gson/reflect/TypeToken.get (Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
      // 19: invokevirtual com/google/gson/Gson.a (Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;
      // 1c: aload 1
      // 1d: invokevirtual com/google/gson/TypeAdapter.read (Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
      // 20: astore 2
      // 21: aload 1
      // 22: iload 4
      // 24: invokevirtual com/google/gson/stream/JsonReader.a (Z)V
      // 27: aload 2
      // 28: areturn
      // 29: astore 5
      // 2b: iload 3
      // 2c: ifeq 3a
      // 2f: aconst_null
      // 30: astore 2
      // 31: aload 1
      // 32: iload 4
      // 34: invokevirtual com/google/gson/stream/JsonReader.a (Z)V
      // 37: goto 27
      // 3a: new com/google/gson/JsonSyntaxException
      // 3d: astore 2
      // 3e: aload 2
      // 3f: aload 5
      // 41: invokespecial com/google/gson/JsonSyntaxException.<init> (Ljava/lang/Throwable;)V
      // 44: aload 2
      // 45: athrow
      // 46: astore 2
      // 47: aload 1
      // 48: iload 4
      // 4a: invokevirtual com/google/gson/stream/JsonReader.a (Z)V
      // 4d: aload 2
      // 4e: athrow
      // 4f: astore 2
      // 50: new com/google/gson/JsonSyntaxException
      // 53: astore 5
      // 55: aload 5
      // 57: aload 2
      // 58: invokespecial com/google/gson/JsonSyntaxException.<init> (Ljava/lang/Throwable;)V
      // 5b: aload 5
      // 5d: athrow
      // 5e: astore 5
      // 60: new com/google/gson/JsonSyntaxException
      // 63: astore 2
      // 64: aload 2
      // 65: aload 5
      // 67: invokespecial com/google/gson/JsonSyntaxException.<init> (Ljava/lang/Throwable;)V
      // 6a: aload 2
      // 6b: athrow
      // try (8 -> 11): 25 java/io/EOFException
      // try (8 -> 11): 47 java/lang/IllegalStateException
      // try (8 -> 11): 55 java/io/IOException
      // try (8 -> 11): 41 null
      // try (13 -> 20): 25 java/io/EOFException
      // try (13 -> 20): 47 java/lang/IllegalStateException
      // try (13 -> 20): 55 java/io/IOException
      // try (13 -> 20): 41 null
      // try (34 -> 41): 41 null
      // try (48 -> 55): 41 null
      // try (56 -> 63): 41 null
   }

   public <T> T a(Reader var1, Class<T> var2) throws JsonSyntaxException, JsonIOException {
      JsonReader var3 = this.a(var1);
      Object var4 = this.a(var3, var2);
      a(var4, var3);
      return Primitives.<T>a(var2).cast(var4);
   }

   public <T> T a(Reader var1, Type var2) throws JsonIOException, JsonSyntaxException {
      JsonReader var3 = this.a(var1);
      Object var4 = this.a(var3, var2);
      a(var4, var3);
      return (T)var4;
   }

   public <T> T a(String var1, Class<T> var2) throws JsonSyntaxException {
      Object var3 = this.a(var1, (Type)var2);
      return Primitives.<T>a(var2).cast(var3);
   }

   public <T> T a(String var1, Type var2) throws JsonSyntaxException {
      Object var3;
      if (var1 == null) {
         var3 = null;
      } else {
         var3 = this.a(new StringReader(var1), var2);
      }

      return (T)var3;
   }

   public String a(JsonElement var1) {
      StringWriter var2 = new StringWriter();
      this.a(var1, var2);
      return var2.toString();
   }

   public void a(JsonElement var1, JsonWriter var2) throws JsonIOException {
      boolean var3 = var2.g();
      var2.b(true);
      boolean var4 = var2.h();
      var2.c(this.i);
      boolean var5 = var2.i();
      var2.d(this.h);

      try {
         Streams.a(var1, var2);
      } catch (IOException var9) {
         JsonIOException var11 = new JsonIOException(var9);
         throw var11;
      } finally {
         var2.b(var3);
         var2.c(var4);
         var2.d(var5);
      }
   }

   public void a(JsonElement var1, Appendable var2) throws JsonIOException {
      try {
         this.a(var1, this.a(Streams.a(var2)));
      } catch (IOException var3) {
         throw new JsonIOException(var3);
      }
   }

   public void a(Object var1, Type var2, JsonWriter var3) throws JsonIOException {
      TypeAdapter var11 = this.a(TypeToken.get(var2));
      boolean var6 = var3.g();
      var3.b(true);
      boolean var5 = var3.h();
      var3.c(this.i);
      boolean var4 = var3.i();
      var3.d(this.h);

      try {
         var11.write(var3, var1);
      } catch (IOException var9) {
         JsonIOException var12 = new JsonIOException(var9);
         throw var12;
      } finally {
         var3.b(var6);
         var3.c(var5);
         var3.d(var4);
      }
   }

   public void a(Object var1, Type var2, Appendable var3) throws JsonIOException {
      try {
         this.a(var1, var2, this.a(Streams.a(var3)));
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      }
   }

   public String b(Object var1) {
      if (var1 == null) {
         var1 = this.a(JsonNull.a);
      } else {
         var1 = this.b(var1, var1.getClass());
      }

      return var1;
   }

   public String b(Object var1, Type var2) {
      StringWriter var3 = new StringWriter();
      this.a(var1, var2, var3);
      return var3.toString();
   }

   @Override
   public String toString() {
      return "{serializeNulls:" + this.h + ",factories:" + this.d + ",instanceCreators:" + this.e + "}";
   }

   static class FutureTypeAdapter<T> extends TypeAdapter<T> {
      private TypeAdapter<T> a;

      public void a(TypeAdapter<T> var1) {
         if (this.a != null) {
            throw new AssertionError();
         }

         this.a = var1;
      }

      @Override
      public T read(JsonReader var1) throws IOException {
         if (this.a == null) {
            throw new IllegalStateException();
         } else {
            return this.a.read(var1);
         }
      }

      @Override
      public void write(JsonWriter var1, T var2) throws IOException {
         if (this.a == null) {
            throw new IllegalStateException();
         }

         this.a.write(var1, (T)var2);
      }
   }
}
