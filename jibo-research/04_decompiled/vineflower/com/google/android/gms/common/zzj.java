package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzj extends zzh {
   private static final WeakReference<byte[]> b = new WeakReference<>(null);
   private WeakReference<byte[]> a = b;

   zzj(byte[] var1) {
      super(var1);
   }

   @Override
   final byte[] c() {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/zzj.a Ljava/lang/ref/WeakReference;
      // 06: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 09: checkcast [B
      // 0c: astore 2
      // 0d: aload 2
      // 0e: astore 1
      // 0f: aload 2
      // 10: ifnonnull 26
      // 13: aload 0
      // 14: invokevirtual com/google/android/gms/common/zzj.d ()[B
      // 17: astore 1
      // 18: new java/lang/ref/WeakReference
      // 1b: astore 2
      // 1c: aload 2
      // 1d: aload 1
      // 1e: invokespecial java/lang/ref/WeakReference.<init> (Ljava/lang/Object;)V
      // 21: aload 0
      // 22: aload 2
      // 23: putfield com/google/android/gms/common/zzj.a Ljava/lang/ref/WeakReference;
      // 26: aload 0
      // 27: monitorexit
      // 28: aload 1
      // 29: areturn
      // 2a: astore 1
      // 2b: aload 0
      // 2c: monitorexit
      // 2d: aload 1
      // 2e: athrow
      // try (2 -> 7): 26 null
      // try (11 -> 22): 26 null
      // try (22 -> 24): 26 null
      // try (27 -> 29): 26 null
   }

   protected abstract byte[] d();
}
