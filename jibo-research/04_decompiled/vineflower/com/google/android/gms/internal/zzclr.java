package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclr extends zzfjm<zzclr> {
   private static volatile zzclr[] d;
   public Integer a = null;
   public zzclv[] b = zzclv.a();
   public zzcls[] c = zzcls.a();

   public zzclr() {
      this.H = null;
      this.I = -1;
   }

   public static zzclr[] a() {
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
      // 00: getstatic com/google/android/gms/internal/zzclr.d [Lcom/google/android/gms/internal/zzclr;
      // 03: ifnonnull 1b
      // 06: getstatic com/google/android/gms/internal/zzfjq.b Ljava/lang/Object;
      // 09: astore 1
      // 0a: aload 1
      // 0b: monitorenter
      // 0c: getstatic com/google/android/gms/internal/zzclr.d [Lcom/google/android/gms/internal/zzclr;
      // 0f: ifnonnull 19
      // 12: bipush 0
      // 13: anewarray 2
      // 16: putstatic com/google/android/gms/internal/zzclr.d [Lcom/google/android/gms/internal/zzclr;
      // 19: aload 1
      // 1a: monitorexit
      // 1b: getstatic com/google/android/gms/internal/zzclr.d [Lcom/google/android/gms/internal/zzclr;
      // 1e: areturn
      // 1f: astore 0
      // 20: aload 1
      // 21: monitorexit
      // 22: aload 0
      // 23: athrow
      // try (6 -> 11): 15 null
      // try (11 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      byte var3 = 0;
      if (this.a != null) {
         var1.a(1, this.a);
      }

      if (this.b != null && this.b.length > 0) {
         for (int var2 = 0; var2 < this.b.length; var2++) {
            zzclv var4 = this.b[var2];
            if (var4 != null) {
               var1.a(2, var4);
            }
         }
      }

      if (this.c != null && this.c.length > 0) {
         for (int var5 = var3; var5 < this.c.length; var5++) {
            zzcls var6 = this.c[var5];
            if (var6 != null) {
               var1.a(3, var6);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      byte var4 = 0;
      int var1 = super.b();
      int var2 = var1;
      if (this.a != null) {
         var2 = var1 + zzfjk.b(1, this.a);
      }

      var1 = var2;
      if (this.b != null) {
         var1 = var2;
         if (this.b.length > 0) {
            var1 = var2;
            var2 = 0;

            while (var2 < this.b.length) {
               zzclv var5 = this.b[var2];
               int var3 = var1;
               if (var5 != null) {
                  var3 = var1 + zzfjk.b(2, var5);
               }

               var2++;
               var1 = var3;
            }
         }
      }

      int var9 = var1;
      if (this.c != null) {
         var9 = var1;
         if (this.c.length > 0) {
            var2 = var4;

            while (true) {
               var9 = var1;
               if (var2 >= this.c.length) {
                  break;
               }

               zzcls var11 = this.c[var2];
               var9 = var1;
               if (var11 != null) {
                  var9 = var1 + zzfjk.b(3, var11);
               }

               var2++;
               var1 = var9;
            }
         }
      }

      return var9;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzclr)) {
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

         if (!zzfjq.a(this.b, var1.b)) {
            var2 = false;
         } else if (!zzfjq.a(this.c, var1.c)) {
            var2 = false;
         } else if (this.H != null && !this.H.b()) {
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
      byte var3 = 0;
      int var4 = this.getClass().getName().hashCode();
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      int var6 = zzfjq.a(this.b);
      int var5 = zzfjq.a(this.c);
      int var2 = var3;
      if (this.H != null) {
         if (this.H.b()) {
            var2 = var3;
         } else {
            var2 = this.H.hashCode();
         }
      }

      return (((var1 + (var4 + 527) * 31) * 31 + var6) * 31 + var5) * 31 + var2;
   }
}
