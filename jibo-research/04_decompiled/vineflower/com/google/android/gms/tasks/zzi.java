package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzi<TResult> implements zzk<TResult> {
   private final Executor a;
   private final Object b = new Object();
   private OnSuccessListener<? super TResult> c;

   public zzi(Executor var1, OnSuccessListener<? super TResult> var2) {
      this.a = var1;
      this.c = var2;
   }

   @Override
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
      // 00: aload 1
      // 01: invokevirtual com/google/android/gms/tasks/Task.b ()Z
      // 04: ifeq 17
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzi.b Ljava/lang/Object;
      // 0b: astore 2
      // 0c: aload 2
      // 0d: monitorenter
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/tasks/zzi.c Lcom/google/android/gms/tasks/OnSuccessListener;
      // 12: ifnonnull 18
      // 15: aload 2
      // 16: monitorexit
      // 17: return
      // 18: aload 2
      // 19: monitorexit
      // 1a: aload 0
      // 1b: getfield com/google/android/gms/tasks/zzi.a Ljava/util/concurrent/Executor;
      // 1e: new com/google/android/gms/tasks/zzj
      // 21: dup
      // 22: aload 0
      // 23: aload 1
      // 24: invokespecial com/google/android/gms/tasks/zzj.<init> (Lcom/google/android/gms/tasks/zzi;Lcom/google/android/gms/tasks/Task;)V
      // 27: invokeinterface java/util/concurrent/Executor.execute (Ljava/lang/Runnable;)V 2
      // 2c: goto 17
      // 2f: astore 1
      // 30: aload 2
      // 31: monitorexit
      // 32: aload 1
      // 33: athrow
      // try (8 -> 13): 25 null
      // try (14 -> 16): 25 null
      // try (26 -> 28): 25 null
   }
}
