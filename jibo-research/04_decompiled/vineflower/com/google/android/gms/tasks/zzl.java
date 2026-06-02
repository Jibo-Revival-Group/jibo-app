package com.google.android.gms.tasks;

import java.util.Queue;

final class zzl<TResult> {
   private final Object a = new Object();
   private Queue<zzk<TResult>> b;
   private boolean c;

   public final void a(Task<TResult> param1) {
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
      // 01: getfield com/google/android/gms/tasks/zzl.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzl.b Ljava/util/Queue;
      // 0b: ifnull 15
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/tasks/zzl.c Z
      // 12: ifeq 18
      // 15: aload 2
      // 16: monitorexit
      // 17: return
      // 18: aload 0
      // 19: bipush 1
      // 1a: putfield com/google/android/gms/tasks/zzl.c Z
      // 1d: aload 2
      // 1e: monitorexit
      // 1f: aload 0
      // 20: getfield com/google/android/gms/tasks/zzl.a Ljava/lang/Object;
      // 23: astore 2
      // 24: aload 2
      // 25: monitorenter
      // 26: aload 0
      // 27: getfield com/google/android/gms/tasks/zzl.b Ljava/util/Queue;
      // 2a: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 2f: checkcast com/google/android/gms/tasks/zzk
      // 32: astore 3
      // 33: aload 3
      // 34: ifnonnull 4b
      // 37: aload 0
      // 38: bipush 0
      // 39: putfield com/google/android/gms/tasks/zzl.c Z
      // 3c: aload 2
      // 3d: monitorexit
      // 3e: goto 17
      // 41: astore 1
      // 42: aload 2
      // 43: monitorexit
      // 44: aload 1
      // 45: athrow
      // 46: astore 1
      // 47: aload 2
      // 48: monitorexit
      // 49: aload 1
      // 4a: athrow
      // 4b: aload 2
      // 4c: monitorexit
      // 4d: aload 3
      // 4e: aload 1
      // 4f: invokeinterface com/google/android/gms/tasks/zzk.a (Lcom/google/android/gms/tasks/Task;)V 2
      // 54: goto 1f
      // try (5 -> 11): 42 null
      // try (11 -> 13): 42 null
      // try (14 -> 19): 42 null
      // try (24 -> 29): 37 null
      // try (31 -> 36): 37 null
      // try (38 -> 40): 37 null
      // try (43 -> 45): 42 null
      // try (47 -> 49): 37 null
   }

   public final void a(zzk<TResult> param1) {
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
      // 01: getfield com/google/android/gms/tasks/zzl.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzl.b Ljava/util/Queue;
      // 0b: ifnonnull 1b
      // 0e: new java/util/ArrayDeque
      // 11: astore 3
      // 12: aload 3
      // 13: invokespecial java/util/ArrayDeque.<init> ()V
      // 16: aload 0
      // 17: aload 3
      // 18: putfield com/google/android/gms/tasks/zzl.b Ljava/util/Queue;
      // 1b: aload 0
      // 1c: getfield com/google/android/gms/tasks/zzl.b Ljava/util/Queue;
      // 1f: aload 1
      // 20: invokeinterface java/util/Queue.add (Ljava/lang/Object;)Z 2
      // 25: pop
      // 26: aload 2
      // 27: monitorexit
      // 28: return
      // 29: astore 1
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: aload 1
      // 2d: athrow
      // try (5 -> 15): 23 null
      // try (15 -> 22): 23 null
      // try (24 -> 26): 23 null
   }
}
