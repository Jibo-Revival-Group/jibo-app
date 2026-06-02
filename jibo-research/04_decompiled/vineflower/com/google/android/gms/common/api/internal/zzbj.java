package com.google.android.gms.common.api.internal;

abstract class zzbj {
   private final zzbh a;

   protected zzbj(zzbh var1) {
      this.a = var1;
   }

   protected abstract void a();

   public final void a(zzbi param1) {
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
      // 00: aload 1
      // 01: invokestatic com/google/android/gms/common/api/internal/zzbi.a (Lcom/google/android/gms/common/api/internal/zzbi;)Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 1
      // 0a: invokestatic com/google/android/gms/common/api/internal/zzbi.b (Lcom/google/android/gms/common/api/internal/zzbi;)Lcom/google/android/gms/common/api/internal/zzbh;
      // 0d: astore 2
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/api/internal/zzbj.a Lcom/google/android/gms/common/api/internal/zzbh;
      // 12: astore 3
      // 13: aload 2
      // 14: aload 3
      // 15: if_acmpeq 22
      // 18: aload 1
      // 19: invokestatic com/google/android/gms/common/api/internal/zzbi.a (Lcom/google/android/gms/common/api/internal/zzbi;)Ljava/util/concurrent/locks/Lock;
      // 1c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 21: return
      // 22: aload 0
      // 23: invokevirtual com/google/android/gms/common/api/internal/zzbj.a ()V
      // 26: aload 1
      // 27: invokestatic com/google/android/gms/common/api/internal/zzbi.a (Lcom/google/android/gms/common/api/internal/zzbi;)Ljava/util/concurrent/locks/Lock;
      // 2a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 2f: goto 21
      // 32: astore 2
      // 33: aload 1
      // 34: invokestatic com/google/android/gms/common/api/internal/zzbi.a (Lcom/google/android/gms/common/api/internal/zzbi;)Ljava/util/concurrent/locks/Lock;
      // 37: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 3c: aload 2
      // 3d: athrow
      // try (3 -> 9): 22 null
      // try (16 -> 18): 22 null
   }
}
