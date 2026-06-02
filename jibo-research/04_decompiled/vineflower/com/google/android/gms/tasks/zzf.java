package com.google.android.gms.tasks;

final class zzf implements Runnable {
   private Task a;
   private zze b;

   zzf(zze var1, Task var2) {
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
      // 01: getfield com/google/android/gms/tasks/zzf.b Lcom/google/android/gms/tasks/zze;
      // 04: invokestatic com/google/android/gms/tasks/zze.a (Lcom/google/android/gms/tasks/zze;)Ljava/lang/Object;
      // 07: astore 2
      // 08: aload 2
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield com/google/android/gms/tasks/zzf.b Lcom/google/android/gms/tasks/zze;
      // 0e: invokestatic com/google/android/gms/tasks/zze.b (Lcom/google/android/gms/tasks/zze;)Lcom/google/android/gms/tasks/OnCompleteListener;
      // 11: ifnull 24
      // 14: aload 0
      // 15: getfield com/google/android/gms/tasks/zzf.b Lcom/google/android/gms/tasks/zze;
      // 18: invokestatic com/google/android/gms/tasks/zze.b (Lcom/google/android/gms/tasks/zze;)Lcom/google/android/gms/tasks/OnCompleteListener;
      // 1b: aload 0
      // 1c: getfield com/google/android/gms/tasks/zzf.a Lcom/google/android/gms/tasks/Task;
      // 1f: invokeinterface com/google/android/gms/tasks/OnCompleteListener.a (Lcom/google/android/gms/tasks/Task;)V 2
      // 24: aload 2
      // 25: monitorexit
      // 26: return
      // 27: astore 1
      // 28: aload 2
      // 29: monitorexit
      // 2a: aload 1
      // 2b: athrow
      // try (6 -> 16): 19 null
      // try (16 -> 18): 19 null
      // try (20 -> 22): 19 null
   }
}
