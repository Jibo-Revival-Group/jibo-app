package com.google.android.gms.internal;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.TimeUnit;

final class zzewj {
   private static final long a = TimeUnit.MINUTES.toMicros(1L);
   private long b;
   private long c;
   private zzewn d;
   private long e;
   private final zzewk f;
   private long g;
   private long h;
   private long i;
   private long j;
   private final boolean k;

   zzewj(long var1, long var3, zzewk var5, Map<String, Long> var6, zzewi var7, boolean var8) {
      this.f = var5;
      this.b = var3;
      this.c = var1;
      this.e = var3;
      this.d = new zzewn();
      var1 = var7.zzckf();
      var3 = var7.zzckg();
      long var11 = var7.zzckh();
      long var9 = var7.zzcki();
      if (var6.containsKey(var7.zzckj())) {
         long var13 = (Long)var6.get(var7.zzckj());
         var1 = var13;
         if (var13 == 0L) {
            var1 = var7.zzckf();
         }
      }

      if (var6.containsKey(var7.zzckk())) {
         var3 = (Long)var6.get(var7.zzckk());
      }

      this.g = var3 / var1;
      this.h = var3;
      if (this.h != var7.zzckg() || this.g != var7.zzckg() / var7.zzckf()) {
         Log.d("FirebasePerformance", String.format("Foreground %s logging rate:%d, burst capacity:%d", var7.toString(), this.g, this.h));
      }

      if (var6.containsKey(var7.zzckl())) {
         var1 = (Long)var6.get(var7.zzckl());
         if (var1 == 0L) {
            var1 = var7.zzckh();
         }
      } else {
         var1 = var11;
      }

      if (var6.containsKey(var7.zzckm())) {
         var3 = (Long)var6.get(var7.zzckm());
      } else {
         var3 = var9;
      }

      this.i = var3 / var1;
      this.j = var3;
      if (this.j != var7.zzcki() || this.i != var7.zzcki() / var7.zzckh()) {
         Log.d("FirebasePerformance", String.format("Background %s logging rate:%d, capacity:%d", var7.toString(), this.i, this.j));
      }

      this.k = var8;
   }

   final void a(boolean param1) {
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
      // 02: iload 1
      // 03: ifeq 21
      // 06: aload 0
      // 07: getfield com/google/android/gms/internal/zzewj.g J
      // 0a: lstore 2
      // 0b: aload 0
      // 0c: lload 2
      // 0d: putfield com/google/android/gms/internal/zzewj.c J
      // 10: iload 1
      // 11: ifeq 29
      // 14: aload 0
      // 15: getfield com/google/android/gms/internal/zzewj.h J
      // 18: lstore 2
      // 19: aload 0
      // 1a: lload 2
      // 1b: putfield com/google/android/gms/internal/zzewj.b J
      // 1e: aload 0
      // 1f: monitorexit
      // 20: return
      // 21: aload 0
      // 22: getfield com/google/android/gms/internal/zzewj.i J
      // 25: lstore 2
      // 26: goto 0b
      // 29: aload 0
      // 2a: getfield com/google/android/gms/internal/zzewj.j J
      // 2d: lstore 2
      // 2e: goto 19
      // 31: astore 4
      // 33: aload 0
      // 34: monitorexit
      // 35: aload 4
      // 37: athrow
      // try (4 -> 7): 29 null
      // try (7 -> 10): 29 null
      // try (12 -> 15): 29 null
      // try (15 -> 18): 29 null
      // try (21 -> 24): 29 null
      // try (25 -> 28): 29 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   final boolean a(zzewx var1) {
      synchronized (this){} // $VF: monitorenter 
      boolean var4 = false /* VF: Semaphore variable */;

      boolean var2;
      label42: {
         label41: {
            try {
               var4 = true;
               zzewn var6 = new zzewn();
               this.e = Math.min(Math.max(0L, this.d.a(var6) * this.c / a) + this.e, this.b);
               if (this.e > 0L) {
                  this.e--;
                  this.d = var6;
                  var4 = false;
                  break label41;
               }

               if (this.k) {
                  Log.w("FirebasePerformance", "Exceeded log rate limit, dropping the log.");
                  var4 = false;
               } else {
                  var4 = false;
               }
            } finally {
               if (var4) {
                  // $VF: monitorexit
               }
            }

            var2 = false;
            break label42;
         }

         var2 = true;
      }

      // $VF: monitorexit
      return var2;
   }
}
