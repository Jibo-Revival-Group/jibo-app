package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzag {
   private static final Object a = new Object();
   private static zzag b;

   public static zzag a(Context param0) {
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
      // 00: getstatic com/google/android/gms/common/internal/zzag.a Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/internal/zzag.b Lcom/google/android/gms/common/internal/zzag;
      // 09: ifnonnull 1c
      // 0c: new com/google/android/gms/common/internal/zzai
      // 0f: astore 2
      // 10: aload 2
      // 11: aload 0
      // 12: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 15: invokespecial com/google/android/gms/common/internal/zzai.<init> (Landroid/content/Context;)V
      // 18: aload 2
      // 19: putstatic com/google/android/gms/common/internal/zzag.b Lcom/google/android/gms/common/internal/zzag;
      // 1c: aload 1
      // 1d: monitorexit
      // 1e: getstatic com/google/android/gms/common/internal/zzag.b Lcom/google/android/gms/common/internal/zzag;
      // 21: areturn
      // 22: astore 0
      // 23: aload 1
      // 24: monitorexit
      // 25: aload 0
      // 26: athrow
      // try (4 -> 14): 18 null
      // try (14 -> 16): 18 null
      // try (19 -> 21): 18 null
   }

   public final void a(String var1, String var2, int var3, ServiceConnection var4, String var5) {
      this.b(new zzah(var1, var2, var3), var4, var5);
   }

   public final boolean a(ComponentName var1, ServiceConnection var2, String var3) {
      return this.a(new zzah(var1, 129), var2, var3);
   }

   protected abstract boolean a(zzah var1, ServiceConnection var2, String var3);

   public final void b(ComponentName var1, ServiceConnection var2, String var3) {
      this.b(new zzah(var1, 129), var2, var3);
   }

   protected abstract void b(zzah var1, ServiceConnection var2, String var3);
}
