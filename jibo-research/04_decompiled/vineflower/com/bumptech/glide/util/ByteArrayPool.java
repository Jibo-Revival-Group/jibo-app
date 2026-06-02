package com.bumptech.glide.util;

import java.util.Queue;

public final class ByteArrayPool {
   private static final ByteArrayPool b = new ByteArrayPool();
   private final Queue<byte[]> a = Util.a(0);

   private ByteArrayPool() {
   }

   public static ByteArrayPool a() {
      return b;
   }

   public boolean a(byte[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: bipush 0
      // 03: istore 3
      // 04: aload 1
      // 05: arraylength
      // 06: ldc 65536
      // 08: if_icmpeq 0f
      // 0b: iload 3
      // 0c: istore 2
      // 0d: iload 2
      // 0e: ireturn
      // 0f: aload 0
      // 10: getfield com/bumptech/glide/util/ByteArrayPool.a Ljava/util/Queue;
      // 13: astore 4
      // 15: aload 4
      // 17: monitorenter
      // 18: aload 0
      // 19: getfield com/bumptech/glide/util/ByteArrayPool.a Ljava/util/Queue;
      // 1c: invokeinterface java/util/Queue.size ()I 1
      // 21: bipush 32
      // 23: if_icmpge 33
      // 26: bipush 1
      // 27: istore 2
      // 28: aload 0
      // 29: getfield com/bumptech/glide/util/ByteArrayPool.a Ljava/util/Queue;
      // 2c: aload 1
      // 2d: invokeinterface java/util/Queue.offer (Ljava/lang/Object;)Z 2
      // 32: pop
      // 33: aload 4
      // 35: monitorexit
      // 36: goto 0d
      // 39: astore 1
      // 3a: aload 4
      // 3c: monitorexit
      // 3d: aload 1
      // 3e: athrow
      // try (17 -> 22): 32 null
      // try (24 -> 29): 32 null
      // try (29 -> 31): 32 null
      // try (33 -> 35): 32 null
   }

   public byte[] b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/bumptech/glide/util/ByteArrayPool.a Ljava/util/Queue;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/bumptech/glide/util/ByteArrayPool.a Ljava/util/Queue;
      // 0b: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 10: checkcast [B
      // 13: astore 2
      // 14: aload 1
      // 15: monitorexit
      // 16: aload 2
      // 17: astore 1
      // 18: aload 2
      // 19: ifnonnull 36
      // 1c: ldc 65536
      // 1e: newarray 8
      // 20: astore 2
      // 21: aload 2
      // 22: astore 1
      // 23: ldc "ByteArrayPool"
      // 25: bipush 3
      // 26: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 29: ifeq 36
      // 2c: ldc "ByteArrayPool"
      // 2e: ldc "Created temp bytes"
      // 30: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 33: pop
      // 34: aload 2
      // 35: astore 1
      // 36: aload 1
      // 37: areturn
      // 38: astore 2
      // 39: aload 1
      // 3a: monitorexit
      // 3b: aload 2
      // 3c: athrow
      // try (5 -> 12): 33 null
      // try (34 -> 36): 33 null
   }
}
