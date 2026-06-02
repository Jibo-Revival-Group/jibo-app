package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

public final class Uninterruptibles {
   public static void a(long param0, TimeUnit param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 5
      // 03: bipush 0
      // 04: istore 4
      // 06: iload 5
      // 08: istore 3
      // 09: aload 2
      // 0a: lload 0
      // 0b: invokevirtual java/util/concurrent/TimeUnit.toNanos (J)J
      // 0e: lstore 6
      // 10: iload 5
      // 12: istore 3
      // 13: invokestatic java/lang/System.nanoTime ()J
      // 16: lstore 8
      // 18: lload 6
      // 1a: lstore 0
      // 1b: iload 4
      // 1d: istore 3
      // 1e: getstatic java/util/concurrent/TimeUnit.NANOSECONDS Ljava/util/concurrent/TimeUnit;
      // 21: lload 0
      // 22: invokevirtual java/util/concurrent/TimeUnit.sleep (J)V
      // 25: iload 4
      // 27: ifeq 30
      // 2a: invokestatic java/lang/Thread.currentThread ()Ljava/lang/Thread;
      // 2d: invokevirtual java/lang/Thread.interrupt ()V
      // 30: return
      // 31: astore 2
      // 32: bipush 1
      // 33: istore 3
      // 34: bipush 1
      // 35: istore 4
      // 37: invokestatic java/lang/System.nanoTime ()J
      // 3a: lstore 0
      // 3b: lload 8
      // 3d: lload 6
      // 3f: ladd
      // 40: lload 0
      // 41: lsub
      // 42: lstore 0
      // 43: goto 1b
      // 46: astore 2
      // 47: iload 3
      // 48: ifeq 51
      // 4b: invokestatic java/lang/Thread.currentThread ()Ljava/lang/Thread;
      // 4e: invokevirtual java/lang/Thread.interrupt ()V
      // 51: aload 2
      // 52: athrow
      // try (6 -> 10): 40 null
      // try (12 -> 14): 40 null
      // try (18 -> 21): 26 java/lang/InterruptedException
      // try (18 -> 21): 40 null
      // try (31 -> 33): 40 null
   }
}
