package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class zzcih extends zzcjl {
   private static final AtomicLong k = new AtomicLong(Long.MIN_VALUE);
   private ExecutorService a;
   private zzcil b;
   private zzcil c;
   private final PriorityBlockingQueue<zzcik<?>> d;
   private final BlockingQueue<zzcik<?>> e;
   private final UncaughtExceptionHandler f;
   private final UncaughtExceptionHandler g;
   private final Object h = new Object();
   private final Semaphore i = new Semaphore(2);
   private volatile boolean j;

   zzcih(zzcim var1) {
      super(var1);
      this.d = new PriorityBlockingQueue<>();
      this.e = new LinkedBlockingQueue<>();
      this.f = new zzcij(this, "Thread death: Uncaught exception on worker thread");
      this.g = new zzcij(this, "Thread death: Uncaught exception on network thread");
   }

   private final void a(zzcik<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzcih.h Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzcih.d Ljava/util/concurrent/PriorityBlockingQueue;
      // 0b: aload 1
      // 0c: invokevirtual java/util/concurrent/PriorityBlockingQueue.add (Ljava/lang/Object;)Z
      // 0f: pop
      // 10: aload 0
      // 11: getfield com/google/android/gms/internal/zzcih.b Lcom/google/android/gms/internal/zzcil;
      // 14: ifnonnull 40
      // 17: new com/google/android/gms/internal/zzcil
      // 1a: astore 1
      // 1b: aload 1
      // 1c: aload 0
      // 1d: ldc "Measurement Worker"
      // 1f: aload 0
      // 20: getfield com/google/android/gms/internal/zzcih.d Ljava/util/concurrent/PriorityBlockingQueue;
      // 23: invokespecial com/google/android/gms/internal/zzcil.<init> (Lcom/google/android/gms/internal/zzcih;Ljava/lang/String;Ljava/util/concurrent/BlockingQueue;)V
      // 26: aload 0
      // 27: aload 1
      // 28: putfield com/google/android/gms/internal/zzcih.b Lcom/google/android/gms/internal/zzcil;
      // 2b: aload 0
      // 2c: getfield com/google/android/gms/internal/zzcih.b Lcom/google/android/gms/internal/zzcil;
      // 2f: aload 0
      // 30: getfield com/google/android/gms/internal/zzcih.f Ljava/lang/Thread$UncaughtExceptionHandler;
      // 33: invokevirtual com/google/android/gms/internal/zzcil.setUncaughtExceptionHandler (Ljava/lang/Thread$UncaughtExceptionHandler;)V
      // 36: aload 0
      // 37: getfield com/google/android/gms/internal/zzcih.b Lcom/google/android/gms/internal/zzcil;
      // 3a: invokevirtual com/google/android/gms/internal/zzcil.start ()V
      // 3d: aload 2
      // 3e: monitorexit
      // 3f: return
      // 40: aload 0
      // 41: getfield com/google/android/gms/internal/zzcih.b Lcom/google/android/gms/internal/zzcil;
      // 44: invokevirtual com/google/android/gms/internal/zzcil.a ()V
      // 47: goto 3d
      // 4a: astore 1
      // 4b: aload 2
      // 4c: monitorexit
      // 4d: aload 1
      // 4e: athrow
      // try (5 -> 32): 39 null
      // try (32 -> 34): 39 null
      // try (35 -> 38): 39 null
      // try (40 -> 42): 39 null
   }

   public static boolean y() {
      boolean var0;
      if (Looper.myLooper() == Looper.getMainLooper()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   final ExecutorService A() {
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
      // 01: getfield com/google/android/gms/internal/zzcih.h Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzcih.a Ljava/util/concurrent/ExecutorService;
      // 0b: ifnonnull 33
      // 0e: new java/util/concurrent/ThreadPoolExecutor
      // 11: astore 3
      // 12: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 15: astore 2
      // 16: new java/util/concurrent/ArrayBlockingQueue
      // 19: astore 4
      // 1b: aload 4
      // 1d: bipush 100
      // 1f: invokespecial java/util/concurrent/ArrayBlockingQueue.<init> (I)V
      // 22: aload 3
      // 23: bipush 0
      // 24: bipush 1
      // 25: ldc2_w 30
      // 28: aload 2
      // 29: aload 4
      // 2b: invokespecial java/util/concurrent/ThreadPoolExecutor.<init> (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V
      // 2e: aload 0
      // 2f: aload 3
      // 30: putfield com/google/android/gms/internal/zzcih.a Ljava/util/concurrent/ExecutorService;
      // 33: aload 0
      // 34: getfield com/google/android/gms/internal/zzcih.a Ljava/util/concurrent/ExecutorService;
      // 37: astore 2
      // 38: aload 1
      // 39: monitorexit
      // 3a: aload 2
      // 3b: areturn
      // 3c: astore 2
      // 3d: aload 1
      // 3e: monitorexit
      // 3f: aload 2
      // 40: athrow
      // try (5 -> 27): 34 null
      // try (27 -> 32): 34 null
      // try (35 -> 37): 34 null
   }

   public final <V> Future<V> a(Callable<V> var1) throws IllegalStateException {
      this.Q();
      zzbq.a(var1);
      zzcik var2 = new zzcik(this, var1, false, "Task exception on worker thread");
      if (Thread.currentThread() == this.b) {
         if (!this.d.isEmpty()) {
            this.t().A().a("Callable skipped the worker queue.");
         }

         var2.run();
      } else {
         this.a(var2);
      }

      return var2;
   }

   public final void a(Runnable var1) throws IllegalStateException {
      this.Q();
      zzbq.a(var1);
      this.a(new zzcik(this, var1, false, "Task exception on worker thread"));
   }

   public final <V> Future<V> b(Callable<V> var1) throws IllegalStateException {
      this.Q();
      zzbq.a(var1);
      zzcik var2 = new zzcik(this, var1, true, "Task exception on worker thread");
      if (Thread.currentThread() == this.b) {
         var2.run();
      } else {
         this.a(var2);
      }

      return var2;
   }

   @Override
   public final void b() {
      if (Thread.currentThread() != this.c) {
         throw new IllegalStateException("Call expected from network thread");
      }
   }

   public final void b(Runnable param1) throws IllegalStateException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 04: aload 1
      // 05: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 08: pop
      // 09: new com/google/android/gms/internal/zzcik
      // 0c: dup
      // 0d: aload 0
      // 0e: aload 1
      // 0f: bipush 0
      // 10: ldc "Task exception on network thread"
      // 12: invokespecial com/google/android/gms/internal/zzcik.<init> (Lcom/google/android/gms/internal/zzcih;Ljava/lang/Runnable;ZLjava/lang/String;)V
      // 15: astore 2
      // 16: aload 0
      // 17: getfield com/google/android/gms/internal/zzcih.h Ljava/lang/Object;
      // 1a: astore 1
      // 1b: aload 1
      // 1c: monitorenter
      // 1d: aload 0
      // 1e: getfield com/google/android/gms/internal/zzcih.e Ljava/util/concurrent/BlockingQueue;
      // 21: aload 2
      // 22: invokeinterface java/util/concurrent/BlockingQueue.add (Ljava/lang/Object;)Z 2
      // 27: pop
      // 28: aload 0
      // 29: getfield com/google/android/gms/internal/zzcih.c Lcom/google/android/gms/internal/zzcil;
      // 2c: ifnonnull 58
      // 2f: new com/google/android/gms/internal/zzcil
      // 32: astore 2
      // 33: aload 2
      // 34: aload 0
      // 35: ldc "Measurement Network"
      // 37: aload 0
      // 38: getfield com/google/android/gms/internal/zzcih.e Ljava/util/concurrent/BlockingQueue;
      // 3b: invokespecial com/google/android/gms/internal/zzcil.<init> (Lcom/google/android/gms/internal/zzcih;Ljava/lang/String;Ljava/util/concurrent/BlockingQueue;)V
      // 3e: aload 0
      // 3f: aload 2
      // 40: putfield com/google/android/gms/internal/zzcih.c Lcom/google/android/gms/internal/zzcil;
      // 43: aload 0
      // 44: getfield com/google/android/gms/internal/zzcih.c Lcom/google/android/gms/internal/zzcil;
      // 47: aload 0
      // 48: getfield com/google/android/gms/internal/zzcih.g Ljava/lang/Thread$UncaughtExceptionHandler;
      // 4b: invokevirtual com/google/android/gms/internal/zzcil.setUncaughtExceptionHandler (Ljava/lang/Thread$UncaughtExceptionHandler;)V
      // 4e: aload 0
      // 4f: getfield com/google/android/gms/internal/zzcih.c Lcom/google/android/gms/internal/zzcil;
      // 52: invokevirtual com/google/android/gms/internal/zzcil.start ()V
      // 55: aload 1
      // 56: monitorexit
      // 57: return
      // 58: aload 0
      // 59: getfield com/google/android/gms/internal/zzcih.c Lcom/google/android/gms/internal/zzcil;
      // 5c: invokevirtual com/google/android/gms/internal/zzcil.a ()V
      // 5f: goto 55
      // 62: astore 2
      // 63: aload 1
      // 64: monitorexit
      // 65: aload 2
      // 66: athrow
      // try (18 -> 45): 52 null
      // try (45 -> 47): 52 null
      // try (48 -> 51): 52 null
      // try (53 -> 55): 52 null
   }

   @Override
   public final void c() {
      if (Thread.currentThread() != this.b) {
         throw new IllegalStateException("Call expected from worker thread");
      }
   }

   @Override
   protected final boolean w() {
      return false;
   }

   public final boolean z() {
      boolean var1;
      if (Thread.currentThread() == this.b) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
