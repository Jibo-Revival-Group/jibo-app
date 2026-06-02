package com.google.android.gms.internal;

final class zzckv implements Runnable {
   private zzche a;
   private zzcku b;

   zzckv(zzcku var1, zzche var2) {
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
      // 01: getfield com/google/android/gms/internal/zzckv.b Lcom/google/android/gms/internal/zzcku;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzckv.b Lcom/google/android/gms/internal/zzcku;
      // 0b: bipush 0
      // 0c: invokestatic com/google/android/gms/internal/zzcku.a (Lcom/google/android/gms/internal/zzcku;Z)Z
      // 0f: pop
      // 10: aload 0
      // 11: getfield com/google/android/gms/internal/zzckv.b Lcom/google/android/gms/internal/zzcku;
      // 14: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 17: invokevirtual com/google/android/gms/internal/zzckg.y ()Z
      // 1a: ifne 3d
      // 1d: aload 0
      // 1e: getfield com/google/android/gms/internal/zzckv.b Lcom/google/android/gms/internal/zzcku;
      // 21: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 24: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 27: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 2a: ldc "Connected to service"
      // 2c: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 2f: aload 0
      // 30: getfield com/google/android/gms/internal/zzckv.b Lcom/google/android/gms/internal/zzcku;
      // 33: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 36: aload 0
      // 37: getfield com/google/android/gms/internal/zzckv.a Lcom/google/android/gms/internal/zzche;
      // 3a: invokevirtual com/google/android/gms/internal/zzckg.a (Lcom/google/android/gms/internal/zzche;)V
      // 3d: aload 1
      // 3e: monitorexit
      // 3f: return
      // 40: astore 2
      // 41: aload 1
      // 42: monitorexit
      // 43: aload 2
      // 44: athrow
      // try (5 -> 28): 31 null
      // try (28 -> 30): 31 null
      // try (32 -> 34): 31 null
   }
}
