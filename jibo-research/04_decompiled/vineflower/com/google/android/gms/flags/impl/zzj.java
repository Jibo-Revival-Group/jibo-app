package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;

public final class zzj {
   private static SharedPreferences a = null;

   public static SharedPreferences a(Context param0) throws Exception {
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
      // 00: ldc android/content/SharedPreferences
      // 02: monitorenter
      // 03: getstatic com/google/android/gms/flags/impl/zzj.a Landroid/content/SharedPreferences;
      // 06: ifnonnull 1c
      // 09: new com/google/android/gms/flags/impl/zzk
      // 0c: astore 1
      // 0d: aload 1
      // 0e: aload 0
      // 0f: invokespecial com/google/android/gms/flags/impl/zzk.<init> (Landroid/content/Context;)V
      // 12: aload 1
      // 13: invokestatic com/google/android/gms/internal/zzcbc.a (Ljava/util/concurrent/Callable;)Ljava/lang/Object;
      // 16: checkcast android/content/SharedPreferences
      // 19: putstatic com/google/android/gms/flags/impl/zzj.a Landroid/content/SharedPreferences;
      // 1c: getstatic com/google/android/gms/flags/impl/zzj.a Landroid/content/SharedPreferences;
      // 1f: astore 0
      // 20: ldc android/content/SharedPreferences
      // 22: monitorexit
      // 23: aload 0
      // 24: areturn
      // 25: astore 0
      // 26: ldc android/content/SharedPreferences
      // 28: monitorexit
      // 29: aload 0
      // 2a: athrow
      // try (2 -> 13): 19 null
      // try (13 -> 17): 19 null
      // try (20 -> 22): 19 null
   }
}
