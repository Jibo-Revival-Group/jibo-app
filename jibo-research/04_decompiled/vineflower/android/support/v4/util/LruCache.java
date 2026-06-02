package android.support.v4.util;

import java.util.LinkedHashMap;

public class LruCache<K, V> {
   private final LinkedHashMap<K, V> a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;

   public LruCache(int var1) {
      if (var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      }

      this.c = var1;
      this.a = new LinkedHashMap<>(0, 0.75F, true);
   }

   private int c(K var1, V var2) {
      int var3 = this.b((K)var1, (V)var2);
      if (var3 < 0) {
         throw new IllegalStateException("Negative size: " + var1 + "=" + var2);
      } else {
         return var3;
      }
   }

   public final V a(K param1) {
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
      // 00: aload 1
      // 01: ifnonnull 0e
      // 04: new java/lang/NullPointerException
      // 07: dup
      // 08: ldc "key == null"
      // 0a: invokespecial java/lang/NullPointerException.<init> (Ljava/lang/String;)V
      // 0d: athrow
      // 0e: aload 0
      // 0f: monitorenter
      // 10: aload 0
      // 11: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 14: aload 1
      // 15: invokevirtual java/util/LinkedHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 18: astore 2
      // 19: aload 2
      // 1a: ifnull 2d
      // 1d: aload 0
      // 1e: aload 0
      // 1f: getfield android/support/v4/util/LruCache.g I
      // 22: bipush 1
      // 23: iadd
      // 24: putfield android/support/v4/util/LruCache.g I
      // 27: aload 0
      // 28: monitorexit
      // 29: aload 2
      // 2a: astore 1
      // 2b: aload 1
      // 2c: areturn
      // 2d: aload 0
      // 2e: aload 0
      // 2f: getfield android/support/v4/util/LruCache.h I
      // 32: bipush 1
      // 33: iadd
      // 34: putfield android/support/v4/util/LruCache.h I
      // 37: aload 0
      // 38: monitorexit
      // 39: aload 0
      // 3a: aload 1
      // 3b: invokevirtual android/support/v4/util/LruCache.c (Ljava/lang/Object;)Ljava/lang/Object;
      // 3e: astore 3
      // 3f: aload 3
      // 40: ifnonnull 4d
      // 43: aconst_null
      // 44: astore 1
      // 45: goto 2b
      // 48: astore 1
      // 49: aload 0
      // 4a: monitorexit
      // 4b: aload 1
      // 4c: athrow
      // 4d: aload 0
      // 4e: monitorenter
      // 4f: aload 0
      // 50: aload 0
      // 51: getfield android/support/v4/util/LruCache.e I
      // 54: bipush 1
      // 55: iadd
      // 56: putfield android/support/v4/util/LruCache.e I
      // 59: aload 0
      // 5a: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 5d: aload 1
      // 5e: aload 3
      // 5f: invokevirtual java/util/LinkedHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 62: astore 2
      // 63: aload 2
      // 64: ifnull 84
      // 67: aload 0
      // 68: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 6b: aload 1
      // 6c: aload 2
      // 6d: invokevirtual java/util/LinkedHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 70: pop
      // 71: aload 0
      // 72: monitorexit
      // 73: aload 2
      // 74: ifnull 9b
      // 77: aload 0
      // 78: bipush 0
      // 79: aload 1
      // 7a: aload 3
      // 7b: aload 2
      // 7c: invokevirtual android/support/v4/util/LruCache.a (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 7f: aload 2
      // 80: astore 1
      // 81: goto 2b
      // 84: aload 0
      // 85: aload 0
      // 86: getfield android/support/v4/util/LruCache.b I
      // 89: aload 0
      // 8a: aload 1
      // 8b: aload 3
      // 8c: invokespecial android/support/v4/util/LruCache.c (Ljava/lang/Object;Ljava/lang/Object;)I
      // 8f: iadd
      // 90: putfield android/support/v4/util/LruCache.b I
      // 93: goto 71
      // 96: astore 1
      // 97: aload 0
      // 98: monitorexit
      // 99: aload 1
      // 9a: athrow
      // 9b: aload 0
      // 9c: aload 0
      // 9d: getfield android/support/v4/util/LruCache.c I
      // a0: invokevirtual android/support/v4/util/LruCache.a (I)V
      // a3: aload 3
      // a4: astore 1
      // a5: goto 2b
      // try (9 -> 14): 45 null
      // try (16 -> 24): 45 null
      // try (28 -> 36): 45 null
      // try (46 -> 48): 45 null
      // try (52 -> 64): 95 null
      // try (66 -> 72): 95 null
      // try (72 -> 74): 95 null
      // try (85 -> 94): 95 null
      // try (96 -> 98): 95 null
   }

   public final V a(K param1, V param2) {
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
      // 00: aload 1
      // 01: ifnull 08
      // 04: aload 2
      // 05: ifnonnull 12
      // 08: new java/lang/NullPointerException
      // 0b: dup
      // 0c: ldc "key == null || value == null"
      // 0e: invokespecial java/lang/NullPointerException.<init> (Ljava/lang/String;)V
      // 11: athrow
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: aload 0
      // 16: getfield android/support/v4/util/LruCache.d I
      // 19: bipush 1
      // 1a: iadd
      // 1b: putfield android/support/v4/util/LruCache.d I
      // 1e: aload 0
      // 1f: aload 0
      // 20: getfield android/support/v4/util/LruCache.b I
      // 23: aload 0
      // 24: aload 1
      // 25: aload 2
      // 26: invokespecial android/support/v4/util/LruCache.c (Ljava/lang/Object;Ljava/lang/Object;)I
      // 29: iadd
      // 2a: putfield android/support/v4/util/LruCache.b I
      // 2d: aload 0
      // 2e: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 31: aload 1
      // 32: aload 2
      // 33: invokevirtual java/util/LinkedHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 36: astore 3
      // 37: aload 3
      // 38: ifnull 4a
      // 3b: aload 0
      // 3c: aload 0
      // 3d: getfield android/support/v4/util/LruCache.b I
      // 40: aload 0
      // 41: aload 1
      // 42: aload 3
      // 43: invokespecial android/support/v4/util/LruCache.c (Ljava/lang/Object;Ljava/lang/Object;)I
      // 46: isub
      // 47: putfield android/support/v4/util/LruCache.b I
      // 4a: aload 0
      // 4b: monitorexit
      // 4c: aload 3
      // 4d: ifnull 58
      // 50: aload 0
      // 51: bipush 0
      // 52: aload 1
      // 53: aload 3
      // 54: aload 2
      // 55: invokevirtual android/support/v4/util/LruCache.a (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 58: aload 0
      // 59: aload 0
      // 5a: getfield android/support/v4/util/LruCache.c I
      // 5d: invokevirtual android/support/v4/util/LruCache.a (I)V
      // 60: aload 3
      // 61: areturn
      // 62: astore 1
      // 63: aload 0
      // 64: monitorexit
      // 65: aload 1
      // 66: athrow
      // try (11 -> 32): 59 null
      // try (34 -> 43): 59 null
      // try (43 -> 45): 59 null
      // try (60 -> 62): 59 null
   }

   public final void a() {
      this.a(-1);
   }

   public void a(int param1) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield android/support/v4/util/LruCache.b I
      // 06: iflt 1a
      // 09: aload 0
      // 0a: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 0d: invokevirtual java/util/LinkedHashMap.isEmpty ()Z
      // 10: ifeq 44
      // 13: aload 0
      // 14: getfield android/support/v4/util/LruCache.b I
      // 17: ifeq 44
      // 1a: new java/lang/IllegalStateException
      // 1d: astore 2
      // 1e: new java/lang/StringBuilder
      // 21: astore 3
      // 22: aload 3
      // 23: invokespecial java/lang/StringBuilder.<init> ()V
      // 26: aload 2
      // 27: aload 3
      // 28: aload 0
      // 29: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 2c: invokevirtual java/lang/Class.getName ()Ljava/lang/String;
      // 2f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 32: ldc ".sizeOf() is reporting inconsistent results!"
      // 34: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 37: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3a: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 3d: aload 2
      // 3e: athrow
      // 3f: astore 2
      // 40: aload 0
      // 41: monitorexit
      // 42: aload 2
      // 43: athrow
      // 44: aload 0
      // 45: getfield android/support/v4/util/LruCache.b I
      // 48: iload 1
      // 49: if_icmple 56
      // 4c: aload 0
      // 4d: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 50: invokevirtual java/util/LinkedHashMap.isEmpty ()Z
      // 53: ifeq 59
      // 56: aload 0
      // 57: monitorexit
      // 58: return
      // 59: aload 0
      // 5a: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 5d: invokevirtual java/util/LinkedHashMap.entrySet ()Ljava/util/Set;
      // 60: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 65: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 6a: checkcast java/util/Map$Entry
      // 6d: astore 3
      // 6e: aload 3
      // 6f: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 74: astore 2
      // 75: aload 3
      // 76: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 7b: astore 3
      // 7c: aload 0
      // 7d: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 80: aload 2
      // 81: invokevirtual java/util/LinkedHashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 84: pop
      // 85: aload 0
      // 86: aload 0
      // 87: getfield android/support/v4/util/LruCache.b I
      // 8a: aload 0
      // 8b: aload 2
      // 8c: aload 3
      // 8d: invokespecial android/support/v4/util/LruCache.c (Ljava/lang/Object;Ljava/lang/Object;)I
      // 90: isub
      // 91: putfield android/support/v4/util/LruCache.b I
      // 94: aload 0
      // 95: aload 0
      // 96: getfield android/support/v4/util/LruCache.f I
      // 99: bipush 1
      // 9a: iadd
      // 9b: putfield android/support/v4/util/LruCache.f I
      // 9e: aload 0
      // 9f: monitorexit
      // a0: aload 0
      // a1: bipush 1
      // a2: aload 2
      // a3: aload 3
      // a4: aconst_null
      // a5: invokevirtual android/support/v4/util/LruCache.a (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // a8: goto 00
      // try (2 -> 12): 30 null
      // try (12 -> 30): 30 null
      // try (31 -> 33): 30 null
      // try (35 -> 43): 30 null
      // try (43 -> 45): 30 null
      // try (46 -> 81): 30 null
   }

   protected void a(boolean var1, K var2, V var3, V var4) {
   }

   protected int b(K var1, V var2) {
      return 1;
   }

   public final V b(K param1) {
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
      // 00: aload 1
      // 01: ifnonnull 0e
      // 04: new java/lang/NullPointerException
      // 07: dup
      // 08: ldc "key == null"
      // 0a: invokespecial java/lang/NullPointerException.<init> (Ljava/lang/String;)V
      // 0d: athrow
      // 0e: aload 0
      // 0f: monitorenter
      // 10: aload 0
      // 11: getfield android/support/v4/util/LruCache.a Ljava/util/LinkedHashMap;
      // 14: aload 1
      // 15: invokevirtual java/util/LinkedHashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 18: astore 2
      // 19: aload 2
      // 1a: ifnull 2c
      // 1d: aload 0
      // 1e: aload 0
      // 1f: getfield android/support/v4/util/LruCache.b I
      // 22: aload 0
      // 23: aload 1
      // 24: aload 2
      // 25: invokespecial android/support/v4/util/LruCache.c (Ljava/lang/Object;Ljava/lang/Object;)I
      // 28: isub
      // 29: putfield android/support/v4/util/LruCache.b I
      // 2c: aload 0
      // 2d: monitorexit
      // 2e: aload 2
      // 2f: ifnull 3a
      // 32: aload 0
      // 33: bipush 0
      // 34: aload 1
      // 35: aload 2
      // 36: aconst_null
      // 37: invokevirtual android/support/v4/util/LruCache.a (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 3a: aload 2
      // 3b: areturn
      // 3c: astore 1
      // 3d: aload 0
      // 3e: monitorexit
      // 3f: aload 1
      // 40: athrow
      // try (9 -> 14): 37 null
      // try (16 -> 25): 37 null
      // try (25 -> 27): 37 null
      // try (38 -> 40): 37 null
   }

   protected V c(K var1) {
      return null;
   }

   @Override
   public final String toString() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield android/support/v4/util/LruCache.g I
      // 08: aload 0
      // 09: getfield android/support/v4/util/LruCache.h I
      // 0c: iadd
      // 0d: istore 2
      // 0e: iload 2
      // 0f: ifeq 1c
      // 12: aload 0
      // 13: getfield android/support/v4/util/LruCache.g I
      // 16: bipush 100
      // 18: imul
      // 19: iload 2
      // 1a: idiv
      // 1b: istore 1
      // 1c: getstatic java/util/Locale.US Ljava/util/Locale;
      // 1f: ldc "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]"
      // 21: bipush 4
      // 22: anewarray 5
      // 25: dup
      // 26: bipush 0
      // 27: aload 0
      // 28: getfield android/support/v4/util/LruCache.c I
      // 2b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 2e: aastore
      // 2f: dup
      // 30: bipush 1
      // 31: aload 0
      // 32: getfield android/support/v4/util/LruCache.g I
      // 35: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 38: aastore
      // 39: dup
      // 3a: bipush 2
      // 3b: aload 0
      // 3c: getfield android/support/v4/util/LruCache.h I
      // 3f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 42: aastore
      // 43: dup
      // 44: bipush 3
      // 45: iload 1
      // 46: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 49: aastore
      // 4a: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 4d: astore 3
      // 4e: aload 0
      // 4f: monitorexit
      // 50: aload 3
      // 51: areturn
      // 52: astore 3
      // 53: aload 0
      // 54: monitorexit
      // 55: aload 3
      // 56: athrow
      // try (4 -> 10): 52 null
      // try (12 -> 19): 52 null
      // try (19 -> 48): 52 null
   }
}
