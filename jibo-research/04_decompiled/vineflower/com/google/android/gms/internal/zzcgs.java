package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzbq;

abstract class zzcgs {
   private static volatile Handler b;
   private final zzcim a;
   private final Runnable c;
   private volatile long d;
   private boolean e;

   zzcgs(zzcim var1) {
      zzbq.a(var1);
      this.a = var1;
      this.e = true;
      this.c = new zzcgt(this);
   }

   private final Handler d() {
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
      // 00: getstatic com/google/android/gms/internal/zzcgs.b Landroid/os/Handler;
      // 03: ifnull 0c
      // 06: getstatic com/google/android/gms/internal/zzcgs.b Landroid/os/Handler;
      // 09: astore 1
      // 0a: aload 1
      // 0b: areturn
      // 0c: ldc com/google/android/gms/internal/zzcgs
      // 0e: monitorenter
      // 0f: getstatic com/google/android/gms/internal/zzcgs.b Landroid/os/Handler;
      // 12: ifnonnull 2b
      // 15: new android/os/Handler
      // 18: astore 1
      // 19: aload 1
      // 1a: aload 0
      // 1b: getfield com/google/android/gms/internal/zzcgs.a Lcom/google/android/gms/internal/zzcim;
      // 1e: invokevirtual com/google/android/gms/internal/zzcim.t ()Landroid/content/Context;
      // 21: invokevirtual android/content/Context.getMainLooper ()Landroid/os/Looper;
      // 24: invokespecial android/os/Handler.<init> (Landroid/os/Looper;)V
      // 27: aload 1
      // 28: putstatic com/google/android/gms/internal/zzcgs.b Landroid/os/Handler;
      // 2b: getstatic com/google/android/gms/internal/zzcgs.b Landroid/os/Handler;
      // 2e: astore 1
      // 2f: ldc com/google/android/gms/internal/zzcgs
      // 31: monitorexit
      // 32: goto 0a
      // 35: astore 1
      // 36: ldc com/google/android/gms/internal/zzcgs
      // 38: monitorexit
      // 39: aload 1
      // 3a: athrow
      // try (8 -> 20): 25 null
      // try (20 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   public abstract void a();

   public final void a(long var1) {
      this.c();
      if (var1 >= 0L) {
         this.d = this.a.u().a();
         if (!this.d().postDelayed(this.c, var1)) {
            this.a.f().y().a("Failed to schedule delayed post. time", var1);
         }
      }
   }

   public final boolean b() {
      boolean var1;
      if (this.d != 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final void c() {
      this.d = 0L;
      this.d().removeCallbacks(this.c);
   }
}
