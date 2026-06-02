package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkt extends zzfjm<zzfkt> {
   private static volatile zzfkt[] b;
   public String a = "";

   public zzfkt() {
      this.H = null;
      this.I = -1;
   }

   public static zzfkt[] a() {
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
      // 00: getstatic com/google/android/gms/internal/zzfkt.b [Lcom/google/android/gms/internal/zzfkt;
      // 03: ifnonnull 1b
      // 06: getstatic com/google/android/gms/internal/zzfjq.b Ljava/lang/Object;
      // 09: astore 0
      // 0a: aload 0
      // 0b: monitorenter
      // 0c: getstatic com/google/android/gms/internal/zzfkt.b [Lcom/google/android/gms/internal/zzfkt;
      // 0f: ifnonnull 19
      // 12: bipush 0
      // 13: anewarray 2
      // 16: putstatic com/google/android/gms/internal/zzfkt.b [Lcom/google/android/gms/internal/zzfkt;
      // 19: aload 0
      // 1a: monitorexit
      // 1b: getstatic com/google/android/gms/internal/zzfkt.b [Lcom/google/android/gms/internal/zzfkt;
      // 1e: areturn
      // 1f: astore 1
      // 20: aload 0
      // 21: monitorexit
      // 22: aload 1
      // 23: athrow
      // try (6 -> 11): 15 null
      // try (11 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != null && !this.a.equals("")) {
         var1.a(1, this.a);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2;
         if (!this.a.equals("")) {
            var1 = var2 + zzfjk.b(1, this.a);
         }
      }

      return var1;
   }
}
