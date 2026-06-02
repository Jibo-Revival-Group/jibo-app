package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public class FieldInfo {
   private static final Map<Field, FieldInfo> CACHE = new WeakHashMap<>();
   private final Field field;
   private final boolean isPrimitive;
   private final String name;

   FieldInfo(Field var1, String var2) {
      this.field = var1;
      String var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = var2.intern();
      }

      this.name = var3;
      this.isPrimitive = Data.isPrimitive(this.getType());
   }

   public static Object getFieldValue(Field var0, Object var1) {
      try {
         return var0.get(var1);
      } catch (IllegalAccessException var2) {
         throw new IllegalArgumentException(var2);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static FieldInfo of(Enum<?> var0) {
      boolean var1 = true;

      FieldInfo var2;
      try {
         var2 = of(var0.getClass().getField(var0.name()));
      } catch (NoSuchFieldException var4) {
         throw new RuntimeException(var4);
      }

      if (var2 == null) {
         var1 = false;
      }

      try {
         Preconditions.checkArgument(var1, "enum constant missing @Value or @NullValue annotation: %s", var0);
         return var2;
      } catch (NoSuchFieldException var3) {
         throw new RuntimeException(var3);
      }
   }

   public static FieldInfo of(Field param0) {
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
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 0
      // 03: ifnonnull 0a
      // 06: aload 2
      // 07: astore 0
      // 08: aload 0
      // 09: areturn
      // 0a: getstatic com/google/api/client/util/FieldInfo.CACHE Ljava/util/Map;
      // 0d: astore 4
      // 0f: aload 4
      // 11: monitorenter
      // 12: getstatic com/google/api/client/util/FieldInfo.CACHE Ljava/util/Map;
      // 15: aload 0
      // 16: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1b: checkcast com/google/api/client/util/FieldInfo
      // 1e: astore 3
      // 1f: aload 0
      // 20: invokevirtual java/lang/reflect/Field.isEnumConstant ()Z
      // 23: istore 1
      // 24: aload 3
      // 25: ifnonnull c1
      // 28: iload 1
      // 29: ifne 36
      // 2c: aload 0
      // 2d: invokevirtual java/lang/reflect/Field.getModifiers ()I
      // 30: invokestatic java/lang/reflect/Modifier.isStatic (I)Z
      // 33: ifne c1
      // 36: iload 1
      // 37: ifeq 99
      // 3a: aload 0
      // 3b: ldc com/google/api/client/util/Value
      // 3d: invokevirtual java/lang/reflect/Field.getAnnotation (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      // 40: checkcast com/google/api/client/util/Value
      // 43: astore 3
      // 44: aload 3
      // 45: ifnull 80
      // 48: aload 3
      // 49: invokeinterface com/google/api/client/util/Value.value ()Ljava/lang/String; 1
      // 4e: astore 2
      // 4f: ldc "##default"
      // 51: aload 2
      // 52: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 55: ifeq be
      // 58: aload 0
      // 59: invokevirtual java/lang/reflect/Field.getName ()Ljava/lang/String;
      // 5c: astore 2
      // 5d: new com/google/api/client/util/FieldInfo
      // 60: astore 3
      // 61: aload 3
      // 62: aload 0
      // 63: aload 2
      // 64: invokespecial com/google/api/client/util/FieldInfo.<init> (Ljava/lang/reflect/Field;Ljava/lang/String;)V
      // 67: getstatic com/google/api/client/util/FieldInfo.CACHE Ljava/util/Map;
      // 6a: aload 0
      // 6b: aload 3
      // 6c: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 71: pop
      // 72: aload 3
      // 73: astore 0
      // 74: aload 4
      // 76: monitorexit
      // 77: goto 08
      // 7a: astore 0
      // 7b: aload 4
      // 7d: monitorexit
      // 7e: aload 0
      // 7f: athrow
      // 80: aload 0
      // 81: ldc com/google/api/client/util/NullValue
      // 83: invokevirtual java/lang/reflect/Field.getAnnotation (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      // 86: checkcast com/google/api/client/util/NullValue
      // 89: ifnull 91
      // 8c: aconst_null
      // 8d: astore 2
      // 8e: goto 4f
      // 91: aload 4
      // 93: monitorexit
      // 94: aload 2
      // 95: astore 0
      // 96: goto 08
      // 99: aload 0
      // 9a: ldc com/google/api/client/util/Key
      // 9c: invokevirtual java/lang/reflect/Field.getAnnotation (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      // 9f: checkcast com/google/api/client/util/Key
      // a2: astore 3
      // a3: aload 3
      // a4: ifnonnull af
      // a7: aload 4
      // a9: monitorexit
      // aa: aload 2
      // ab: astore 0
      // ac: goto 08
      // af: aload 3
      // b0: invokeinterface com/google/api/client/util/Key.value ()Ljava/lang/String; 1
      // b5: astore 2
      // b6: aload 0
      // b7: bipush 1
      // b8: invokevirtual java/lang/reflect/Field.setAccessible (Z)V
      // bb: goto 4f
      // be: goto 5d
      // c1: aload 3
      // c2: astore 0
      // c3: goto 74
      // try (12 -> 20): 63 null
      // try (24 -> 28): 63 null
      // try (30 -> 35): 63 null
      // try (37 -> 40): 63 null
      // try (40 -> 47): 63 null
      // try (47 -> 58): 63 null
      // try (60 -> 62): 63 null
      // try (64 -> 66): 63 null
      // try (68 -> 73): 63 null
      // try (76 -> 78): 63 null
      // try (81 -> 86): 63 null
      // try (88 -> 90): 63 null
      // try (93 -> 99): 63 null
   }

   public static void setFieldValue(Field var0, Object var1, Object var2) {
      if (Modifier.isFinal(var0.getModifiers())) {
         String var3 = (String)getFieldValue(var0, var1);
         if (var2 == null ? var3 != null : !var2.equals(var3)) {
            var3 = String.valueOf(String.valueOf(var3));
            var2 = String.valueOf(String.valueOf(var2));
            String var6 = String.valueOf(String.valueOf(var0.getName()));
            var1 = String.valueOf(String.valueOf(var1.getClass().getName()));
            throw new IllegalArgumentException(
               new StringBuilder(var3.length() + 48 + var2.length() + var6.length() + var1.length())
                  .append("expected final value <")
                  .append(var3)
                  .append("> but was <")
                  .append(var2)
                  .append("> on ")
                  .append(var6)
                  .append(" field in ")
                  .append(var1)
                  .toString()
            );
         }
      } else {
         try {
            var0.set(var1, var2);
         } catch (SecurityException var4) {
            throw new IllegalArgumentException(var4);
         } catch (IllegalAccessException var5) {
            throw new IllegalArgumentException(var5);
         }
      }
   }

   public <T extends Enum<T>> T enumValue() {
      return Enum.valueOf((Class<T>)this.field.getDeclaringClass(), this.field.getName());
   }

   public ClassInfo getClassInfo() {
      return ClassInfo.of(this.field.getDeclaringClass());
   }

   public Field getField() {
      return this.field;
   }

   public Type getGenericType() {
      return this.field.getGenericType();
   }

   public String getName() {
      return this.name;
   }

   public Class<?> getType() {
      return this.field.getType();
   }

   public Object getValue(Object var1) {
      return getFieldValue(this.field, var1);
   }

   public boolean isFinal() {
      return Modifier.isFinal(this.field.getModifiers());
   }

   public boolean isPrimitive() {
      return this.isPrimitive;
   }

   public void setValue(Object var1, Object var2) {
      setFieldValue(this.field, var1, var2);
   }
}
