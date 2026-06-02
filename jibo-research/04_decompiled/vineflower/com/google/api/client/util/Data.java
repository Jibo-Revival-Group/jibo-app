package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Data {
   public static final BigDecimal NULL_BIG_DECIMAL = new BigDecimal("0");
   public static final BigInteger NULL_BIG_INTEGER = new BigInteger("0");
   public static final Boolean NULL_BOOLEAN = new Boolean(true);
   public static final Byte NULL_BYTE = new Byte((byte)0);
   private static final ConcurrentHashMap<Class<?>, Object> NULL_CACHE = new ConcurrentHashMap<>();
   public static final Character NULL_CHARACTER = new Character('\u0000');
   public static final DateTime NULL_DATE_TIME = new DateTime(0L);
   public static final Double NULL_DOUBLE = new Double(0.0);
   public static final Float NULL_FLOAT = new Float(0.0F);
   public static final Integer NULL_INTEGER = new Integer(0);
   public static final Long NULL_LONG = new Long(0L);
   public static final Short NULL_SHORT = new Short((short)0);
   public static final String NULL_STRING = new String();

   static {
      NULL_CACHE.put(Boolean.class, NULL_BOOLEAN);
      NULL_CACHE.put(String.class, NULL_STRING);
      NULL_CACHE.put(Character.class, NULL_CHARACTER);
      NULL_CACHE.put(Byte.class, NULL_BYTE);
      NULL_CACHE.put(Short.class, NULL_SHORT);
      NULL_CACHE.put(Integer.class, NULL_INTEGER);
      NULL_CACHE.put(Float.class, NULL_FLOAT);
      NULL_CACHE.put(Long.class, NULL_LONG);
      NULL_CACHE.put(Double.class, NULL_DOUBLE);
      NULL_CACHE.put(BigInteger.class, NULL_BIG_INTEGER);
      NULL_CACHE.put(BigDecimal.class, NULL_BIG_DECIMAL);
      NULL_CACHE.put(DateTime.class, NULL_DATE_TIME);
   }

   public static <T> T clone(T var0) {
      Object var1;
      if (var0 == null || isPrimitive(var0.getClass())) {
         var1 = (Class)var0;
      } else if (var0 instanceof GenericData) {
         var1 = ((GenericData)var0).clone();
      } else {
         var1 = var0.getClass();
         if (var1.isArray()) {
            var1 = (Class)Array.newInstance(var1.getComponentType(), Array.getLength(var0));
         } else if (var0 instanceof ArrayMap) {
            var1 = ((ArrayMap)var0).clone();
         } else {
            if ("java.util.Arrays$ArrayList".equals(var1.getName())) {
               Object[] var2 = ((List)var0).toArray();
               deepCopy(var2, var2);
               List var4 = Arrays.asList(var2);
               return (T)var4;
            }

            var1 = Types.newInstance(var1);
         }

         deepCopy(var0, var1);
      }

      return (T)var1;
   }

   public static void deepCopy(Object var0, Object var1) {
      boolean var5 = true;
      int var2 = 0;
      byte var3 = 0;
      Class var6 = var0.getClass();
      boolean var4;
      if (var6 == var1.getClass()) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      if (var6.isArray()) {
         if (Array.getLength(var0) == Array.getLength(var1)) {
            var4 = var5;
         } else {
            var4 = false;
         }

         Preconditions.checkArgument(var4);
         Iterator var10 = Types.iterableOf(var0).iterator();

         for (int var18 = var3; var10.hasNext(); var18++) {
            Array.set(var1, var18, clone(var10.next()));
         }
      } else if (Collection.class.isAssignableFrom(var6)) {
         Collection var11 = (Collection)var0;
         if (ArrayList.class.isAssignableFrom(var6)) {
            ((ArrayList)var1).ensureCapacity(var11.size());
         }

         Collection var15 = (Collection)var1;
         Iterator var12 = var11.iterator();

         while (var12.hasNext()) {
            var15.add(clone(var12.next()));
         }
      } else {
         var4 = GenericData.class.isAssignableFrom(var6);
         if (!var4 && Map.class.isAssignableFrom(var6)) {
            if (ArrayMap.class.isAssignableFrom(var6)) {
               ArrayMap var16 = (ArrayMap)var1;
               ArrayMap var13 = (ArrayMap)var0;

               for (int var19 = var13.size(); var2 < var19; var2++) {
                  var16.set(var2, clone(var13.getValue(var2)));
               }
            } else {
               Map var17 = (Map)var1;

               for (Entry var14 : ((Map)var0).entrySet()) {
                  var17.put(var14.getKey(), clone(var14.getValue()));
               }
            }
         } else {
            ClassInfo var22;
            if (var4) {
               var22 = ((GenericData)var0).classInfo;
            } else {
               var22 = ClassInfo.of(var6);
            }

            Iterator var9 = var22.names.iterator();

            while (var9.hasNext()) {
               FieldInfo var8 = var22.getFieldInfo((String)var9.next());
               if (!var8.isFinal() && (!var4 || !var8.isPrimitive())) {
                  Object var7 = var8.getValue(var0);
                  if (var7 != null) {
                     var8.setValue(var1, clone(var7));
                  }
               }
            }
         }
      }
   }

   public static boolean isNull(Object var0) {
      boolean var1;
      if (var0 != null && var0 == NULL_CACHE.get(var0.getClass())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isPrimitive(Type var0) {
      boolean var1 = false;
      if (var0 instanceof WildcardType) {
         var0 = Types.getBound((WildcardType)var0);
      }

      if (var0 instanceof Class) {
         Class var2 = (Class)var0;
         if (!var2.isPrimitive()
            && var2 != Character.class
            && var2 != String.class
            && var2 != Integer.class
            && var2 != Long.class
            && var2 != Short.class
            && var2 != Byte.class
            && var2 != Float.class
            && var2 != Double.class
            && var2 != BigInteger.class
            && var2 != BigDecimal.class
            && var2 != DateTime.class
            && var2 != Boolean.class) {
            var1 = false;
         } else {
            var1 = true;
         }
      }

      return var1;
   }

   public static boolean isValueOfPrimitiveType(Object var0) {
      boolean var1;
      if (var0 != null && !isPrimitive(var0.getClass())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static Map<String, Object> mapOf(Object var0) {
      if (var0 == null || isNull(var0)) {
         var0 = Collections.emptyMap();
      } else if (var0 instanceof Map) {
         var0 = var0;
      } else {
         var0 = new DataMap(var0, false);
      }

      return var0;
   }

   public static Collection<Object> newCollectionInstance(Type var0) {
      if (var0 instanceof WildcardType) {
         var0 = Types.getBound((WildcardType)var0);
      }

      if (var0 instanceof ParameterizedType) {
         var0 = ((ParameterizedType)var0).getRawType();
      }

      Class var1;
      if (var0 instanceof Class) {
         var1 = (Class)var0;
      } else {
         var1 = null;
      }

      Collection var2;
      if (var0 != null && !(var0 instanceof GenericArrayType) && (var1 == null || !var1.isArray() && !var1.isAssignableFrom(ArrayList.class))) {
         if (var1 == null) {
            String var3 = String.valueOf(String.valueOf(var0));
            throw new IllegalArgumentException(new StringBuilder(var3.length() + 39).append("unable to create new instance of type: ").append(var3).toString());
         }

         if (var1.isAssignableFrom(HashSet.class)) {
            var2 = new HashSet();
         } else if (var1.isAssignableFrom(TreeSet.class)) {
            var2 = new TreeSet();
         } else {
            var2 = Types.newInstance(var1);
         }
      } else {
         var2 = new ArrayList();
      }

      return var2;
   }

   public static Map<String, Object> newMapInstance(Class<?> var0) {
      Map var1;
      if (var0 == null || var0.isAssignableFrom(ArrayMap.class)) {
         var1 = ArrayMap.create();
      } else if (var0.isAssignableFrom(TreeMap.class)) {
         var1 = new TreeMap();
      } else {
         var1 = Types.newInstance(var0);
      }

      return var1;
   }

   public static <T> T nullOf(Class<?> param0) {
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
      // 00: bipush 0
      // 01: istore 1
      // 02: getstatic com/google/api/client/util/Data.NULL_CACHE Ljava/util/concurrent/ConcurrentHashMap;
      // 05: aload 0
      // 06: invokevirtual java/util/concurrent/ConcurrentHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 09: astore 4
      // 0b: aload 4
      // 0d: astore 3
      // 0e: aload 4
      // 10: ifnonnull 61
      // 13: getstatic com/google/api/client/util/Data.NULL_CACHE Ljava/util/concurrent/ConcurrentHashMap;
      // 16: astore 5
      // 18: aload 5
      // 1a: monitorenter
      // 1b: getstatic com/google/api/client/util/Data.NULL_CACHE Ljava/util/concurrent/ConcurrentHashMap;
      // 1e: aload 0
      // 1f: invokevirtual java/util/concurrent/ConcurrentHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 22: astore 4
      // 24: aload 4
      // 26: astore 3
      // 27: aload 4
      // 29: ifnonnull 5e
      // 2c: aload 0
      // 2d: invokevirtual java/lang/Class.isArray ()Z
      // 30: ifeq 63
      // 33: aload 0
      // 34: astore 3
      // 35: aload 3
      // 36: invokevirtual java/lang/Class.getComponentType ()Ljava/lang/Class;
      // 39: astore 4
      // 3b: iload 1
      // 3c: bipush 1
      // 3d: iadd
      // 3e: istore 2
      // 3f: aload 4
      // 41: astore 3
      // 42: iload 2
      // 43: istore 1
      // 44: aload 4
      // 46: invokevirtual java/lang/Class.isArray ()Z
      // 49: ifne 35
      // 4c: aload 4
      // 4e: iload 2
      // 4f: newarray 10
      // 51: invokestatic java/lang/reflect/Array.newInstance (Ljava/lang/Class;[I)Ljava/lang/Object;
      // 54: astore 3
      // 55: getstatic com/google/api/client/util/Data.NULL_CACHE Ljava/util/concurrent/ConcurrentHashMap;
      // 58: aload 0
      // 59: aload 3
      // 5a: invokevirtual java/util/concurrent/ConcurrentHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 5d: pop
      // 5e: aload 5
      // 60: monitorexit
      // 61: aload 3
      // 62: areturn
      // 63: aload 0
      // 64: invokevirtual java/lang/Class.isEnum ()Z
      // 67: ifeq 8b
      // 6a: aload 0
      // 6b: invokestatic com/google/api/client/util/ClassInfo.of (Ljava/lang/Class;)Lcom/google/api/client/util/ClassInfo;
      // 6e: aconst_null
      // 6f: invokevirtual com/google/api/client/util/ClassInfo.getFieldInfo (Ljava/lang/String;)Lcom/google/api/client/util/FieldInfo;
      // 72: astore 3
      // 73: aload 3
      // 74: ldc_w "enum missing constant with @NullValue annotation: %s"
      // 77: bipush 1
      // 78: anewarray 4
      // 7b: dup
      // 7c: bipush 0
      // 7d: aload 0
      // 7e: aastore
      // 7f: invokestatic com/google/api/client/util/Preconditions.checkNotNull (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      // 82: pop
      // 83: aload 3
      // 84: invokevirtual com/google/api/client/util/FieldInfo.enumValue ()Ljava/lang/Enum;
      // 87: astore 3
      // 88: goto 55
      // 8b: aload 0
      // 8c: invokestatic com/google/api/client/util/Types.newInstance (Ljava/lang/Class;)Ljava/lang/Object;
      // 8f: astore 3
      // 90: goto 55
      // 93: astore 0
      // 94: aload 5
      // 96: monitorexit
      // 97: aload 0
      // 98: athrow
      // try (14 -> 18): 81 null
      // try (22 -> 25): 81 null
      // try (27 -> 30): 81 null
      // try (38 -> 46): 81 null
      // try (46 -> 51): 81 null
      // try (51 -> 53): 81 null
      // try (55 -> 76): 81 null
      // try (77 -> 80): 81 null
      // try (82 -> 84): 81 null
   }

   public static Object parsePrimitiveValue(Type var0, String var1) {
      Class var3;
      if (var0 instanceof Class) {
         var3 = (Class)var0;
      } else {
         var3 = null;
      }

      if (var0 == null || var3 != null) {
         if (var3 == Void.class) {
            Object var20 = null;
            return var20;
         }

         String var2 = var1;
         if (var1 == null) {
            return var2;
         }

         var2 = var1;
         if (var3 == null) {
            return var2;
         }

         var2 = var1;
         if (var3.isAssignableFrom(String.class)) {
            return var2;
         }

         if (var3 == Character.class || var3 == char.class) {
            if (var1.length() != 1) {
               String var5 = String.valueOf(String.valueOf(var3));
               throw new IllegalArgumentException(new StringBuilder(var5.length() + 37).append("expected type Character/char but got ").append(var5).toString());
            }

            Character var19 = var1.charAt(0);
            return var19;
         }

         if (var3 == Boolean.class || var3 == boolean.class) {
            Boolean var18 = Boolean.valueOf(var1);
            return var18;
         }

         if (var3 == Byte.class || var3 == byte.class) {
            Byte var17 = Byte.valueOf(var1);
            return var17;
         }

         if (var3 == Short.class || var3 == short.class) {
            Short var16 = Short.valueOf(var1);
            return var16;
         }

         if (var3 == Integer.class || var3 == int.class) {
            Integer var15 = Integer.valueOf(var1);
            return var15;
         }

         if (var3 == Long.class || var3 == long.class) {
            Long var14 = Long.valueOf(var1);
            return var14;
         }

         if (var3 == Float.class || var3 == float.class) {
            Float var13 = Float.valueOf(var1);
            return var13;
         }

         if (var3 == Double.class || var3 == double.class) {
            Double var12 = Double.valueOf(var1);
            return var12;
         }

         if (var3 == DateTime.class) {
            DateTime var11 = DateTime.parseRfc3339(var1);
            return var11;
         }

         if (var3 == BigInteger.class) {
            BigInteger var10 = new BigInteger(var1);
            return var10;
         }

         if (var3 == BigDecimal.class) {
            BigDecimal var9 = new BigDecimal(var1);
            return var9;
         }

         if (var3.isEnum()) {
            Enum var8 = ClassInfo.of(var3).getFieldInfo(var1).enumValue();
            return var8;
         }
      }

      String var4 = String.valueOf(String.valueOf(var0));
      throw new IllegalArgumentException(new StringBuilder(var4.length() + 35).append("expected primitive class, but got: ").append(var4).toString());
   }

   public static Type resolveWildcardTypeOrTypeVariable(List<Type> var0, Type var1) {
      if (var1 instanceof WildcardType) {
         var1 = Types.getBound((WildcardType)var1);
      }

      while (var1 instanceof TypeVariable) {
         Type var2 = Types.resolveTypeVariable(var0, (TypeVariable<?>)var1);
         if (var2 != null) {
            var1 = var2;
         }

         if (var1 instanceof TypeVariable) {
            var1 = ((TypeVariable)var1).getBounds()[0];
         }
      }

      return var1;
   }
}
