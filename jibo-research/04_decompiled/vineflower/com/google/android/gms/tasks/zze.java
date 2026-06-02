package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zze<TResult> implements zzk<TResult> {
   private final Executor a;
   private final Object b = new Object();
   private OnCompleteListener<TResult> c;

   public zze(Executor var1, OnCompleteListener<TResult> var2) {
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
      // 00: aload 0
      // 01: getfield com/google/android/gms/tasks/zze.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zze.c Lcom/google/android/gms/tasks/OnCompleteListener;
      // 0b: ifnonnull 11
      // 0e: aload 2
      // 0f: monitorexit
      // 10: return
      // 11: aload 2
      // 12: monitorexit
      // 13: aload 0
      // 14: getfield com/google/android/gms/tasks/zze.a Ljava/util/concurrent/Executor;
      // 17: new com/google/android/gms/tasks/zzf
      // 1a: dup
      // 1b: aload 0
      // 1c: aload 1
      // 1d: invokespecial com/google/android/gms/tasks/zzf.<init> (Lcom/google/android/gms/tasks/zze;Lcom/google/android/gms/tasks/Task;)V
      // 20: invokeinterface java/util/concurrent/Executor.execute (Ljava/lang/Runnable;)V 2
      // 25: goto 10
      // 28: astore 1
      // 29: aload 2
      // 2a: monitorexit
      // 2b: aload 1
      // 2c: athrow
      // try (5 -> 10): 22 null
      // try (11 -> 13): 22 null
      // try (23 -> 25): 22 null
   }
}
