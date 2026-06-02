package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
   static final ThreadLocal<Boolean> a = new zzs();
   private final Object b = new Object();
   private BasePendingResult.zza<R> c;
   private WeakReference<GoogleApiClient> d;
   private final CountDownLatch e = new CountDownLatch(1);
   private final ArrayList<PendingResult.zza> f = new ArrayList<>();
   private ResultCallback<? super R> g;
   private final AtomicReference<zzdm> h = new AtomicReference<>();
   private R i;
   private Status j;
   private volatile boolean k;
   private boolean l;
   private boolean m;
   @KeepName
   private BasePendingResult.zzb mResultGuardian;
   private com.google.android.gms.common.internal.zzaq n;
   private volatile zzdg<R> o;
   private boolean p = false;

   @Deprecated
   BasePendingResult() {
      this.c = new BasePendingResult.zza<>(Looper.getMainLooper());
      this.d = new WeakReference<>(null);
   }

   @Deprecated
   protected BasePendingResult(Looper var1) {
      this.c = new BasePendingResult.zza<>(var1);
      this.d = new WeakReference<>(null);
   }

   protected BasePendingResult(GoogleApiClient var1) {
      Looper var2;
      if (var1 != null) {
         var2 = var1.c();
      } else {
         var2 = Looper.getMainLooper();
      }

      this.c = new BasePendingResult.zza<>(var2);
      this.d = new WeakReference<>(var1);
   }

   public static void b(Result var0) {
      if (var0 instanceof Releasable) {
         try {
            ((Releasable)var0).c_();
         } catch (RuntimeException var2) {
            String var3 = String.valueOf(var0);
            Log.w("BasePendingResult", new StringBuilder(String.valueOf(var3).length() + 18).append("Unable to release ").append(var3).toString(), var2);
         }
      }
   }

   private final void c(R var1) {
      this.i = (R)var1;
      this.n = null;
      this.e.countDown();
      this.j = this.i.a();
      if (this.l) {
         this.g = null;
      } else if (this.g == null) {
         if (this.i instanceof Releasable) {
            this.mResultGuardian = new BasePendingResult.zzb(this, null);
         }
      } else {
         this.c.removeMessages(2);
         this.c.a(this.g, this.g());
      }

      ArrayList var4 = this.f;
      int var3 = var4.size();
      int var2 = 0;

      while (var2 < var3) {
         Object var5 = var4.get(var2);
         var2++;
         ((PendingResult.zza)var5).a(this.j);
      }

      this.f.clear();
   }

   private final R g() {
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
      // 00: bipush 1
      // 01: istore 1
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 06: astore 3
      // 07: aload 3
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/api/internal/BasePendingResult.k Z
      // 0d: ifne 4e
      // 10: iload 1
      // 11: ldc "Result has already been consumed."
      // 13: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 16: aload 0
      // 17: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.d ()Z
      // 1a: ldc "Result is not ready."
      // 1c: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 1f: aload 0
      // 20: getfield com/google/android/gms/common/api/internal/BasePendingResult.i Lcom/google/android/gms/common/api/Result;
      // 23: astore 2
      // 24: aload 0
      // 25: aconst_null
      // 26: putfield com/google/android/gms/common/api/internal/BasePendingResult.i Lcom/google/android/gms/common/api/Result;
      // 29: aload 0
      // 2a: aconst_null
      // 2b: putfield com/google/android/gms/common/api/internal/BasePendingResult.g Lcom/google/android/gms/common/api/ResultCallback;
      // 2e: aload 0
      // 2f: bipush 1
      // 30: putfield com/google/android/gms/common/api/internal/BasePendingResult.k Z
      // 33: aload 3
      // 34: monitorexit
      // 35: aload 0
      // 36: getfield com/google/android/gms/common/api/internal/BasePendingResult.h Ljava/util/concurrent/atomic/AtomicReference;
      // 39: aconst_null
      // 3a: invokevirtual java/util/concurrent/atomic/AtomicReference.getAndSet (Ljava/lang/Object;)Ljava/lang/Object;
      // 3d: checkcast com/google/android/gms/common/api/internal/zzdm
      // 40: astore 3
      // 41: aload 3
      // 42: ifnull 4c
      // 45: aload 3
      // 46: aload 0
      // 47: invokeinterface com/google/android/gms/common/api/internal/zzdm.a (Lcom/google/android/gms/common/api/internal/BasePendingResult;)V 2
      // 4c: aload 2
      // 4d: areturn
      // 4e: bipush 0
      // 4f: istore 1
      // 50: goto 10
      // 53: astore 2
      // 54: aload 3
      // 55: monitorexit
      // 56: aload 2
      // 57: athrow
      // try (7 -> 10): 47 null
      // try (10 -> 31): 47 null
      // try (48 -> 50): 47 null
   }

   @Override
   public final R a(long var1, TimeUnit var3) {
      boolean var5 = true;
      if (var1 > 0L) {
         com.google.android.gms.common.internal.zzbq.c("await must not be called on the UI thread when time is greater than zero.");
      }

      boolean var4;
      if (!this.k) {
         var4 = true;
      } else {
         var4 = false;
      }

      com.google.android.gms.common.internal.zzbq.a(var4, "Result has already been consumed.");
      if (this.o == null) {
         var4 = var5;
      } else {
         var4 = false;
      }

      com.google.android.gms.common.internal.zzbq.a(var4, "Cannot await if then() has been called.");

      try {
         if (!this.e.await(var1, var3)) {
            this.b(Status.d);
         }
      } catch (InterruptedException var6) {
         this.b(Status.b);
      }

      com.google.android.gms.common.internal.zzbq.a(this.d(), "Result is not ready.");
      return this.g();
   }

   protected abstract R a(Status var1);

   @Override
   public void a() {
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
      // 01: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/api/internal/BasePendingResult.l Z
      // 0b: ifne 15
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/api/internal/BasePendingResult.k Z
      // 12: ifeq 18
      // 15: aload 1
      // 16: monitorexit
      // 17: return
      // 18: aload 0
      // 19: getfield com/google/android/gms/common/api/internal/BasePendingResult.n Lcom/google/android/gms/common/internal/zzaq;
      // 1c: astore 2
      // 1d: aload 2
      // 1e: ifnull 2a
      // 21: aload 0
      // 22: getfield com/google/android/gms/common/api/internal/BasePendingResult.n Lcom/google/android/gms/common/internal/zzaq;
      // 25: invokeinterface com/google/android/gms/common/internal/zzaq.a ()V 1
      // 2a: aload 0
      // 2b: getfield com/google/android/gms/common/api/internal/BasePendingResult.i Lcom/google/android/gms/common/api/Result;
      // 2e: invokestatic com/google/android/gms/common/api/internal/BasePendingResult.b (Lcom/google/android/gms/common/api/Result;)V
      // 31: aload 0
      // 32: bipush 1
      // 33: putfield com/google/android/gms/common/api/internal/BasePendingResult.l Z
      // 36: aload 0
      // 37: aload 0
      // 38: getstatic com/google/android/gms/common/api/Status.e Lcom/google/android/gms/common/api/Status;
      // 3b: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.a (Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
      // 3e: invokespecial com/google/android/gms/common/api/internal/BasePendingResult.c (Lcom/google/android/gms/common/api/Result;)V
      // 41: aload 1
      // 42: monitorexit
      // 43: goto 17
      // 46: astore 2
      // 47: aload 1
      // 48: monitorexit
      // 49: aload 2
      // 4a: athrow
      // 4b: astore 2
      // 4c: goto 2a
      // try (5 -> 11): 36 null
      // try (11 -> 13): 36 null
      // try (14 -> 17): 36 null
      // try (19 -> 22): 41 android/os/RemoteException
      // try (19 -> 22): 36 null
      // try (22 -> 35): 36 null
      // try (37 -> 39): 36 null
   }

   @Override
   public final void a(PendingResult.zza param1) {
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
      // 00: aload 1
      // 01: ifnull 28
      // 04: bipush 1
      // 05: istore 2
      // 06: iload 2
      // 07: ldc_w "Callback cannot be null."
      // 0a: invokestatic com/google/android/gms/common/internal/zzbq.b (ZLjava/lang/Object;)V
      // 0d: aload 0
      // 0e: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 11: astore 3
      // 12: aload 3
      // 13: monitorenter
      // 14: aload 0
      // 15: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.d ()Z
      // 18: ifeq 2d
      // 1b: aload 1
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/common/api/internal/BasePendingResult.j Lcom/google/android/gms/common/api/Status;
      // 20: invokeinterface com/google/android/gms/common/api/PendingResult$zza.a (Lcom/google/android/gms/common/api/Status;)V 2
      // 25: aload 3
      // 26: monitorexit
      // 27: return
      // 28: bipush 0
      // 29: istore 2
      // 2a: goto 06
      // 2d: aload 0
      // 2e: getfield com/google/android/gms/common/api/internal/BasePendingResult.f Ljava/util/ArrayList;
      // 31: aload 1
      // 32: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 35: pop
      // 36: goto 25
      // 39: astore 1
      // 3a: aload 3
      // 3b: monitorexit
      // 3c: aload 1
      // 3d: athrow
      // try (12 -> 19): 31 null
      // try (19 -> 21): 31 null
      // try (25 -> 30): 31 null
      // try (32 -> 34): 31 null
   }

   public final void a(R param1) {
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
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 06: astore 4
      // 08: aload 4
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: getfield com/google/android/gms/common/api/internal/BasePendingResult.m Z
      // 0f: ifne 49
      // 12: aload 0
      // 13: getfield com/google/android/gms/common/api/internal/BasePendingResult.l Z
      // 16: ifne 49
      // 19: aload 0
      // 1a: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.d ()Z
      // 1d: ifeq 20
      // 20: aload 0
      // 21: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.d ()Z
      // 24: ifne 59
      // 27: bipush 1
      // 28: istore 2
      // 29: iload 2
      // 2a: ldc_w "Results have already been set"
      // 2d: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 30: aload 0
      // 31: getfield com/google/android/gms/common/api/internal/BasePendingResult.k Z
      // 34: ifne 5e
      // 37: iload 3
      // 38: istore 2
      // 39: iload 2
      // 3a: ldc_w "Result has already been consumed"
      // 3d: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 40: aload 0
      // 41: aload 1
      // 42: invokespecial com/google/android/gms/common/api/internal/BasePendingResult.c (Lcom/google/android/gms/common/api/Result;)V
      // 45: aload 4
      // 47: monitorexit
      // 48: return
      // 49: aload 1
      // 4a: invokestatic com/google/android/gms/common/api/internal/BasePendingResult.b (Lcom/google/android/gms/common/api/Result;)V
      // 4d: aload 4
      // 4f: monitorexit
      // 50: goto 48
      // 53: astore 1
      // 54: aload 4
      // 56: monitorexit
      // 57: aload 1
      // 58: athrow
      // 59: bipush 0
      // 5a: istore 2
      // 5b: goto 29
      // 5e: bipush 0
      // 5f: istore 2
      // 60: goto 39
      // try (7 -> 16): 43 null
      // try (16 -> 19): 43 null
      // try (21 -> 27): 43 null
      // try (29 -> 37): 43 null
      // try (38 -> 42): 43 null
      // try (44 -> 46): 43 null
   }

   @Override
   public final void a(ResultCallback<? super R> param1) {
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
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 06: astore 4
      // 08: aload 4
      // 0a: monitorenter
      // 0b: aload 1
      // 0c: ifnonnull 18
      // 0f: aload 0
      // 10: aconst_null
      // 11: putfield com/google/android/gms/common/api/internal/BasePendingResult.g Lcom/google/android/gms/common/api/ResultCallback;
      // 14: aload 4
      // 16: monitorexit
      // 17: return
      // 18: aload 0
      // 19: getfield com/google/android/gms/common/api/internal/BasePendingResult.k Z
      // 1c: ifne 4a
      // 1f: bipush 1
      // 20: istore 2
      // 21: iload 2
      // 22: ldc "Result has already been consumed."
      // 24: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 27: aload 0
      // 28: getfield com/google/android/gms/common/api/internal/BasePendingResult.o Lcom/google/android/gms/common/api/internal/zzdg;
      // 2b: ifnonnull 4f
      // 2e: iload 3
      // 2f: istore 2
      // 30: iload 2
      // 31: ldc_w "Cannot set callbacks if then() has been called."
      // 34: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 37: aload 0
      // 38: invokevirtual com/google/android/gms/common/api/PendingResult.b ()Z
      // 3b: ifeq 54
      // 3e: aload 4
      // 40: monitorexit
      // 41: goto 17
      // 44: astore 1
      // 45: aload 4
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // 4a: bipush 0
      // 4b: istore 2
      // 4c: goto 21
      // 4f: bipush 0
      // 50: istore 2
      // 51: goto 30
      // 54: aload 0
      // 55: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.d ()Z
      // 58: ifeq 6d
      // 5b: aload 0
      // 5c: getfield com/google/android/gms/common/api/internal/BasePendingResult.c Lcom/google/android/gms/common/api/internal/BasePendingResult$zza;
      // 5f: aload 1
      // 60: aload 0
      // 61: invokespecial com/google/android/gms/common/api/internal/BasePendingResult.g ()Lcom/google/android/gms/common/api/Result;
      // 64: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult$zza.a (Lcom/google/android/gms/common/api/ResultCallback;Lcom/google/android/gms/common/api/Result;)V
      // 67: aload 4
      // 69: monitorexit
      // 6a: goto 17
      // 6d: aload 0
      // 6e: aload 1
      // 6f: putfield com/google/android/gms/common/api/internal/BasePendingResult.g Lcom/google/android/gms/common/api/ResultCallback;
      // 72: goto 67
      // try (9 -> 14): 37 null
      // try (15 -> 18): 37 null
      // try (20 -> 26): 37 null
      // try (28 -> 36): 37 null
      // try (38 -> 40): 37 null
      // try (48 -> 57): 37 null
      // try (57 -> 59): 37 null
      // try (60 -> 63): 37 null
   }

   public final void a(zzdm var1) {
      this.h.set(var1);
   }

   public final void b(Status param1) {
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
      // 01: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.d ()Z
      // 0b: ifne 1c
      // 0e: aload 0
      // 0f: aload 0
      // 10: aload 1
      // 11: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.a (Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
      // 14: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.a (Lcom/google/android/gms/common/api/Result;)V
      // 17: aload 0
      // 18: bipush 1
      // 19: putfield com/google/android/gms/common/api/internal/BasePendingResult.m Z
      // 1c: aload 2
      // 1d: monitorexit
      // 1e: return
      // 1f: astore 1
      // 20: aload 2
      // 21: monitorexit
      // 22: aload 1
      // 23: athrow
      // try (5 -> 16): 19 null
      // try (16 -> 18): 19 null
      // try (20 -> 22): 19 null
   }

   @Override
   public boolean b() {
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
      // 01: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/api/internal/BasePendingResult.l Z
      // 0b: istore 1
      // 0c: aload 3
      // 0d: monitorexit
      // 0e: iload 1
      // 0f: ireturn
      // 10: astore 2
      // 11: aload 3
      // 12: monitorexit
      // 13: aload 2
      // 14: athrow
      // try (5 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   @Override
   public final Integer c() {
      return null;
   }

   public final boolean d() {
      boolean var1;
      if (this.e.getCount() == 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean e() {
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
      // 01: getfield com/google/android/gms/common/api/internal/BasePendingResult.b Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/api/internal/BasePendingResult.d Ljava/lang/ref/WeakReference;
      // 0b: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 0e: checkcast com/google/android/gms/common/api/GoogleApiClient
      // 11: ifnull 1b
      // 14: aload 0
      // 15: getfield com/google/android/gms/common/api/internal/BasePendingResult.p Z
      // 18: ifne 1f
      // 1b: aload 0
      // 1c: invokevirtual com/google/android/gms/common/api/PendingResult.a ()V
      // 1f: aload 0
      // 20: invokevirtual com/google/android/gms/common/api/PendingResult.b ()Z
      // 23: istore 1
      // 24: aload 2
      // 25: monitorexit
      // 26: iload 1
      // 27: ireturn
      // 28: astore 3
      // 29: aload 2
      // 2a: monitorexit
      // 2b: aload 3
      // 2c: athrow
      // try (5 -> 13): 22 null
      // try (13 -> 15): 22 null
      // try (15 -> 20): 22 null
      // try (23 -> 25): 22 null
   }

   public final void f() {
      boolean var1;
      if (!this.p && !a.get()) {
         var1 = false;
      } else {
         var1 = true;
      }

      this.p = var1;
   }

   public static final class zza<R extends Result> extends Handler {
      public zza() {
         this(Looper.getMainLooper());
      }

      public zza(Looper var1) {
         super(var1);
      }

      public final void a(ResultCallback<? super R> var1, R var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public final void handleMessage(Message var1) {
         switch (var1.what) {
            case 1:
               Pair var3 = (Pair)var1.obj;
               ResultCallback var5 = (ResultCallback)var3.first;
               Result var6 = (Result)var3.second;

               try {
                  var5.a(var6);
                  break;
               } catch (RuntimeException var4) {
                  BasePendingResult.b(var6);
                  throw var4;
               }
            case 2:
               ((BasePendingResult)var1.obj).b(Status.d);
               break;
            default:
               int var2 = var1.what;
               Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(var2).toString(), new Exception());
         }
      }
   }

   final class zzb {
      private BasePendingResult a;

      private zzb(BasePendingResult var1) {
         this.a = var1;
         super();
      }

      @Override
      protected final void finalize() throws Throwable {
         BasePendingResult.b(this.a.i);
         super.finalize();
      }
   }
}
