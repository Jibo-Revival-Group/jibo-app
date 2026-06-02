package com.google.android.gms.internal;

import android.content.Context;

public final class zzbhf {
   private static zzbhf b = new zzbhf();
   private zzbhe a = null;

   public static zzbhe a(Context var0) {
      return b.b(var0);
   }

   private final zzbhe b(Context param1) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/android/gms/internal/zzbhf.a Lcom/google/android/gms/internal/zzbhe;
      // 06: ifnonnull 1e
      // 09: aload 1
      // 0a: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 0d: ifnonnull 27
      // 10: new com/google/android/gms/internal/zzbhe
      // 13: astore 2
      // 14: aload 2
      // 15: aload 1
      // 16: invokespecial com/google/android/gms/internal/zzbhe.<init> (Landroid/content/Context;)V
      // 19: aload 0
      // 1a: aload 2
      // 1b: putfield com/google/android/gms/internal/zzbhf.a Lcom/google/android/gms/internal/zzbhe;
      // 1e: aload 0
      // 1f: getfield com/google/android/gms/internal/zzbhf.a Lcom/google/android/gms/internal/zzbhe;
      // 22: astore 1
      // 23: aload 0
      // 24: monitorexit
      // 25: aload 1
      // 26: areturn
      // 27: aload 1
      // 28: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 2b: astore 1
      // 2c: goto 10
      // 2f: astore 1
      // 30: aload 0
      // 31: monitorexit
      // 32: aload 1
      // 33: athrow
      // try (2 -> 8): 27 null
      // try (8 -> 16): 27 null
      // try (16 -> 19): 27 null
      // try (23 -> 26): 27 null
   }
}
