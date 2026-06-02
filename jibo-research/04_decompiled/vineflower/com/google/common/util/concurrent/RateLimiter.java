package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class RateLimiter {
   private final RateLimiter.SleepingStopwatch a;
   private volatile Object b;

   RateLimiter(RateLimiter.SleepingStopwatch var1) {
      this.a = Preconditions.a(var1);
   }

   public static RateLimiter a(double var0, long var2, TimeUnit var4) {
      boolean var5;
      if (var2 >= 0L) {
         var5 = true;
      } else {
         var5 = false;
      }

      Preconditions.a(var5, "warmupPeriod must not be negative: %s", var2);
      return a(var0, var2, var4, 3.0, RateLimiter.SleepingStopwatch.b());
   }

   static RateLimiter a(double var0, long var2, TimeUnit var4, double var5, RateLimiter.SleepingStopwatch var7) {
      SmoothRateLimiter.SmoothWarmingUp var8 = new SmoothRateLimiter.SmoothWarmingUp(var7, var2, var4, var5);
      var8.a(var0);
      return var8;
   }

   private static void c(int var0) {
      boolean var1;
      if (var0 > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.a(var1, "Requested permits (%s) must be positive", var0);
   }

   private Object d() {
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
      // 01: getfield com/google/common/util/concurrent/RateLimiter.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: astore 1
      // 07: aload 2
      // 08: ifnonnull 27
      // 0b: aload 0
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: getfield com/google/common/util/concurrent/RateLimiter.b Ljava/lang/Object;
      // 11: astore 2
      // 12: aload 2
      // 13: astore 1
      // 14: aload 2
      // 15: ifnonnull 25
      // 18: new java/lang/Object
      // 1b: astore 1
      // 1c: aload 1
      // 1d: invokespecial java/lang/Object.<init> ()V
      // 20: aload 0
      // 21: aload 1
      // 22: putfield com/google/common/util/concurrent/RateLimiter.b Ljava/lang/Object;
      // 25: aload 0
      // 26: monitorexit
      // 27: aload 1
      // 28: areturn
      // 29: astore 1
      // 2a: aload 0
      // 2b: monitorexit
      // 2c: aload 1
      // 2d: athrow
      // try (9 -> 12): 27 null
      // try (16 -> 23): 27 null
      // try (23 -> 25): 27 null
      // try (28 -> 30): 27 null
   }

   public final double a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokespecial com/google/common/util/concurrent/RateLimiter.d ()Ljava/lang/Object;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: invokevirtual com/google/common/util/concurrent/RateLimiter.b ()D
      // 0d: dstore 1
      // 0e: aload 4
      // 10: monitorexit
      // 11: dload 1
      // 12: dreturn
      // 13: astore 3
      // 14: aload 4
      // 16: monitorexit
      // 17: aload 3
      // 18: athrow
      // try (5 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   public double a(int var1) {
      long var2 = this.b(var1);
      this.a.a(var2);
      return var2 * 1.0 / TimeUnit.SECONDS.toMicros(1L);
   }

   final long a(int var1, long var2) {
      return Math.max(this.b(var1, var2) - var2, 0L);
   }

   public final void a(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: dload 1
      // 01: dconst_0
      // 02: dcmpl
      // 03: ifle 2e
      // 06: dload 1
      // 07: invokestatic java/lang/Double.isNaN (D)Z
      // 0a: ifne 2e
      // 0d: bipush 1
      // 0e: istore 3
      // 0f: iload 3
      // 10: ldc "rate must be positive"
      // 12: invokestatic com/google/common/base/Preconditions.a (ZLjava/lang/Object;)V
      // 15: aload 0
      // 16: invokespecial com/google/common/util/concurrent/RateLimiter.d ()Ljava/lang/Object;
      // 19: astore 5
      // 1b: aload 5
      // 1d: monitorenter
      // 1e: aload 0
      // 1f: dload 1
      // 20: aload 0
      // 21: getfield com/google/common/util/concurrent/RateLimiter.a Lcom/google/common/util/concurrent/RateLimiter$SleepingStopwatch;
      // 24: invokevirtual com/google/common/util/concurrent/RateLimiter$SleepingStopwatch.a ()J
      // 27: invokevirtual com/google/common/util/concurrent/RateLimiter.a (DJ)V
      // 2a: aload 5
      // 2c: monitorexit
      // 2d: return
      // 2e: bipush 0
      // 2f: istore 3
      // 30: goto 0f
      // 33: astore 4
      // 35: aload 5
      // 37: monitorexit
      // 38: aload 4
      // 3a: athrow
      // try (17 -> 25): 29 null
      // try (30 -> 32): 29 null
   }

   abstract void a(double var1, long var3);

   abstract double b();

   final long b(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: iload 1
      // 01: invokestatic com/google/common/util/concurrent/RateLimiter.c (I)V
      // 04: aload 0
      // 05: invokespecial com/google/common/util/concurrent/RateLimiter.d ()Ljava/lang/Object;
      // 08: astore 4
      // 0a: aload 4
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: iload 1
      // 0f: aload 0
      // 10: getfield com/google/common/util/concurrent/RateLimiter.a Lcom/google/common/util/concurrent/RateLimiter$SleepingStopwatch;
      // 13: invokevirtual com/google/common/util/concurrent/RateLimiter$SleepingStopwatch.a ()J
      // 16: invokevirtual com/google/common/util/concurrent/RateLimiter.a (IJ)J
      // 19: lstore 2
      // 1a: aload 4
      // 1c: monitorexit
      // 1d: lload 2
      // 1e: lreturn
      // 1f: astore 5
      // 21: aload 4
      // 23: monitorexit
      // 24: aload 5
      // 26: athrow
      // try (7 -> 16): 18 null
      // try (19 -> 21): 18 null
   }

   abstract long b(int var1, long var2);

   public double c() {
      return this.a(1);
   }

   @Override
   public String toString() {
      return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", this.a());
   }

   abstract static class SleepingStopwatch {
      protected SleepingStopwatch() {
      }

      public static final RateLimiter.SleepingStopwatch b() {
         return new RateLimiter.SleepingStopwatch() {
            final Stopwatch a = Stopwatch.a();

            @Override
            protected long a() {
               return this.a.a(TimeUnit.MICROSECONDS);
            }

            @Override
            protected void a(long var1) {
               if (var1 > 0L) {
                  Uninterruptibles.a(var1, TimeUnit.MICROSECONDS);
               }
            }
         };
      }

      protected abstract long a();

      protected abstract void a(long var1);
   }
}
