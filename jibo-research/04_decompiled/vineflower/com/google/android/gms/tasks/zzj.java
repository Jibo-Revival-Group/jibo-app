package com.google.android.gms.tasks;

final class zzj implements Runnable {
   private Task a;
   private zzi b;

   zzj(zzi var1, Task var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
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
      // 01: getfield com/google/android/gms/tasks/zzj.b Lcom/google/android/gms/tasks/zzi;
      // 04: invokestatic com/google/android/gms/tasks/zzi.a (Lcom/google/android/gms/tasks/zzi;)Ljava/lang/Object;
      // 07: astore 1
      // 08: aload 1
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield com/google/android/gms/tasks/zzj.b Lcom/google/android/gms/tasks/zzi;
      // 0e: invokestatic com/google/android/gms/tasks/zzi.b (Lcom/google/android/gms/tasks/zzi;)Lcom/google/android/gms/tasks/OnSuccessListener;
      // 11: ifnull 27
      // 14: aload 0
      // 15: getfield com/google/android/gms/tasks/zzj.b Lcom/google/android/gms/tasks/zzi;
      // 18: invokestatic com/google/android/gms/tasks/zzi.b (Lcom/google/android/gms/tasks/zzi;)Lcom/google/android/gms/tasks/OnSuccessListener;
      // 1b: aload 0
      // 1c: getfield com/google/android/gms/tasks/zzj.a Lcom/google/android/gms/tasks/Task;
      // 1f: invokevirtual com/google/android/gms/tasks/Task.c ()Ljava/lang/Object;
      // 22: invokeinterface com/google/android/gms/tasks/OnSuccessListener.a (Ljava/lang/Object;)V 2
      // 27: aload 1
      // 28: monitorexit
      // 29: return
      // 2a: astore 2
      // 2b: aload 1
      // 2c: monitorexit
      // 2d: aload 2
      // 2e: athrow
      // try (6 -> 17): 20 null
      // try (17 -> 19): 20 null
      // try (21 -> 23): 20 null
   }
}
