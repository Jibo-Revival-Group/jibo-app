package com.google.android.gms.internal;

import java.io.IOException;

public final class zzewz extends zzfjm<zzewz> {
   private static volatile zzewz[] c;
   public String a = null;
   public Long b = null;

   public zzewz() {
      this.H = null;
      this.I = -1;
   }

   public static zzewz[] a() {
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
      // 00: getstatic com/google/android/gms/internal/zzewz.c [Lcom/google/android/gms/internal/zzewz;
      // 03: ifnonnull 1b
      // 06: getstatic com/google/android/gms/internal/zzfjq.b Ljava/lang/Object;
      // 09: astore 0
      // 0a: aload 0
      // 0b: monitorenter
      // 0c: getstatic com/google/android/gms/internal/zzewz.c [Lcom/google/android/gms/internal/zzewz;
      // 0f: ifnonnull 19
      // 12: bipush 0
      // 13: anewarray 2
      // 16: putstatic com/google/android/gms/internal/zzewz.c [Lcom/google/android/gms/internal/zzewz;
      // 19: aload 0
      // 1a: monitorexit
      // 1b: getstatic com/google/android/gms/internal/zzewz.c [Lcom/google/android/gms/internal/zzewz;
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
      if (this.a != null) {
         var1.a(1, this.a);
      }

      if (this.b != null) {
         var1.b(2, this.b);
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2 + zzfjk.b(1, this.a);
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1 + zzfjk.d(2, this.b);
      }

      return var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzewz)) {
         var2 = false;
      } else {
         var1 = var1;
         if (this.a == null) {
            if (var1.a != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.a.equals(var1.a)) {
            var2 = false;
            return var2;
         }

         if (this.b == null) {
            if (var1.b != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.b.equals(var1.b)) {
            var2 = false;
            return var2;
         }

         if (this.H != null && !this.H.b()) {
            var2 = this.H.equals(var1.H);
         } else {
            var2 = var3;
            if (var1.H != null) {
               var2 = var3;
               if (!var1.H.b()) {
                  var2 = false;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      byte var4 = 0;
      int var5 = this.getClass().getName().hashCode();
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      int var2;
      if (this.b == null) {
         var2 = 0;
      } else {
         var2 = this.b.hashCode();
      }

      int var3 = var4;
      if (this.H != null) {
         if (this.H.b()) {
            var3 = var4;
         } else {
            var3 = this.H.hashCode();
         }
      }

      return (var2 + (var1 + (var5 + 527) * 31) * 31) * 31 + var3;
   }
}
