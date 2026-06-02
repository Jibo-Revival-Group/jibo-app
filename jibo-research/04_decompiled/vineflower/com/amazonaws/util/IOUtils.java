package com.amazonaws.util;

import java.io.InputStream;

public enum IOUtils {
   private static final IOUtils[] $VALUES = new IOUtils[0];

   public static byte[] toByteArray(InputStream param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: new java/io/ByteArrayOutputStream
      // 03: dup
      // 04: invokespecial java/io/ByteArrayOutputStream.<init> ()V
      // 07: astore 2
      // 08: sipush 4096
      // 0b: newarray 8
      // 0d: astore 3
      // 0e: aload 0
      // 0f: aload 3
      // 10: invokevirtual java/io/InputStream.read ([B)I
      // 13: istore 1
      // 14: iload 1
      // 15: bipush -1
      // 16: if_icmpeq 2a
      // 19: aload 2
      // 1a: aload 3
      // 1b: bipush 0
      // 1c: iload 1
      // 1d: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 20: goto 0e
      // 23: astore 0
      // 24: aload 2
      // 25: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 28: aload 0
      // 29: athrow
      // 2a: aload 2
      // 2b: invokevirtual java/io/ByteArrayOutputStream.toByteArray ()[B
      // 2e: astore 0
      // 2f: aload 2
      // 30: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 33: aload 0
      // 34: areturn
      // try (4 -> 7): 20 null
      // try (7 -> 11): 20 null
      // try (14 -> 19): 20 null
      // try (25 -> 28): 20 null
   }

   public static String toString(InputStream var0) {
      return new String(toByteArray(var0), StringUtils.UTF8);
   }
}
