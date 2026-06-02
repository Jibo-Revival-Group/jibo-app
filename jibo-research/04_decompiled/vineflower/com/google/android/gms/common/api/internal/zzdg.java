package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;

public final class zzdg<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
   private ResultTransform<? super R, ? extends Result> a;
   private zzdg<? extends Result> b;
   private volatile ResultCallbacks<? super R> c;
   private PendingResult<R> d;
   private final Object e;
   private Status f;
   private final WeakReference<GoogleApiClient> g;
   private final zzdi h;
   private boolean i;

   private final void a(Status param1) {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzdg.e Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: putfield com/google/android/gms/common/api/internal/zzdg.f Lcom/google/android/gms/common/api/Status;
      // 0c: aload 0
      // 0d: aload 0
      // 0e: getfield com/google/android/gms/common/api/internal/zzdg.f Lcom/google/android/gms/common/api/Status;
      // 11: invokespecial com/google/android/gms/common/api/internal/zzdg.b (Lcom/google/android/gms/common/api/Status;)V
      // 14: aload 2
      // 15: monitorexit
      // 16: return
      // 17: astore 1
      // 18: aload 2
      // 19: monitorexit
      // 1a: aload 1
      // 1b: athrow
      // try (5 -> 14): 15 null
      // try (16 -> 18): 15 null
   }

   private final void b() {
      if (this.a != null || this.c != null) {
         GoogleApiClient var1 = this.g.get();
         if (!this.i && this.a != null && var1 != null) {
            var1.a(this);
            this.i = true;
         }

         if (this.f != null) {
            this.b(this.f);
         } else if (this.d != null) {
            this.d.a(this);
         }
      }
   }

   private static void b(Result var0) {
      if (var0 instanceof Releasable) {
         try {
            ((Releasable)var0).c_();
         } catch (RuntimeException var2) {
            String var3 = String.valueOf(var0);
            Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(var3).length() + 18).append("Unable to release ").append(var3).toString(), var2);
         }
      }
   }

   private final void b(Status param1) {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzdg.e Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/api/internal/zzdg.a Lcom/google/android/gms/common/api/ResultTransform;
      // 0b: ifnull 29
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/api/internal/zzdg.a Lcom/google/android/gms/common/api/ResultTransform;
      // 12: aload 1
      // 13: invokevirtual com/google/android/gms/common/api/ResultTransform.a (Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Status;
      // 16: astore 1
      // 17: aload 1
      // 18: ldc "onFailure must not return null"
      // 1a: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 1d: pop
      // 1e: aload 0
      // 1f: getfield com/google/android/gms/common/api/internal/zzdg.b Lcom/google/android/gms/common/api/internal/zzdg;
      // 22: aload 1
      // 23: invokespecial com/google/android/gms/common/api/internal/zzdg.a (Lcom/google/android/gms/common/api/Status;)V
      // 26: aload 2
      // 27: monitorexit
      // 28: return
      // 29: aload 0
      // 2a: invokespecial com/google/android/gms/common/api/internal/zzdg.c ()Z
      // 2d: ifeq 26
      // 30: aload 0
      // 31: getfield com/google/android/gms/common/api/internal/zzdg.c Lcom/google/android/gms/common/api/ResultCallbacks;
      // 34: aload 1
      // 35: invokevirtual com/google/android/gms/common/api/ResultCallbacks.a (Lcom/google/android/gms/common/api/Status;)V
      // 38: goto 26
      // 3b: astore 1
      // 3c: aload 2
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: athrow
      // try (5 -> 21): 32 null
      // try (21 -> 23): 32 null
      // try (24 -> 31): 32 null
      // try (33 -> 35): 32 null
   }

   private final boolean c() {
      GoogleApiClient var2 = this.g.get();
      boolean var1;
      if (this.c != null && var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   final void a() {
      this.c = null;
   }

   public final void a(PendingResult<?> param1) {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzdg.e Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: putfield com/google/android/gms/common/api/internal/zzdg.d Lcom/google/android/gms/common/api/PendingResult;
      // 0c: aload 0
      // 0d: invokespecial com/google/android/gms/common/api/internal/zzdg.b ()V
      // 10: aload 2
      // 11: monitorexit
      // 12: return
      // 13: astore 1
      // 14: aload 2
      // 15: monitorexit
      // 16: aload 1
      // 17: athrow
      // try (5 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   @Override
   public final void a(R param1) {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzdg.e Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 1
      // 08: invokeinterface com/google/android/gms/common/api/Result.a ()Lcom/google/android/gms/common/api/Status; 1
      // 0d: invokevirtual com/google/android/gms/common/api/Status.c ()Z
      // 10: ifeq 4d
      // 13: aload 0
      // 14: getfield com/google/android/gms/common/api/internal/zzdg.a Lcom/google/android/gms/common/api/ResultTransform;
      // 17: ifnull 36
      // 1a: invokestatic com/google/android/gms/common/api/internal/zzcs.a ()Ljava/util/concurrent/ExecutorService;
      // 1d: astore 3
      // 1e: new com/google/android/gms/common/api/internal/zzdh
      // 21: astore 4
      // 23: aload 4
      // 25: aload 0
      // 26: aload 1
      // 27: invokespecial com/google/android/gms/common/api/internal/zzdh.<init> (Lcom/google/android/gms/common/api/internal/zzdg;Lcom/google/android/gms/common/api/Result;)V
      // 2a: aload 3
      // 2b: aload 4
      // 2d: invokeinterface java/util/concurrent/ExecutorService.submit (Ljava/lang/Runnable;)Ljava/util/concurrent/Future; 2
      // 32: pop
      // 33: aload 2
      // 34: monitorexit
      // 35: return
      // 36: aload 0
      // 37: invokespecial com/google/android/gms/common/api/internal/zzdg.c ()Z
      // 3a: ifeq 33
      // 3d: aload 0
      // 3e: getfield com/google/android/gms/common/api/internal/zzdg.c Lcom/google/android/gms/common/api/ResultCallbacks;
      // 41: aload 1
      // 42: invokevirtual com/google/android/gms/common/api/ResultCallbacks.b (Lcom/google/android/gms/common/api/Result;)V
      // 45: goto 33
      // 48: astore 1
      // 49: aload 2
      // 4a: monitorexit
      // 4b: aload 1
      // 4c: athrow
      // 4d: aload 0
      // 4e: aload 1
      // 4f: invokeinterface com/google/android/gms/common/api/Result.a ()Lcom/google/android/gms/common/api/Status; 1
      // 54: invokespecial com/google/android/gms/common/api/internal/zzdg.a (Lcom/google/android/gms/common/api/Status;)V
      // 57: aload 1
      // 58: invokestatic com/google/android/gms/common/api/internal/zzdg.b (Lcom/google/android/gms/common/api/Result;)V
      // 5b: goto 33
      // try (5 -> 24): 35 null
      // try (24 -> 26): 35 null
      // try (27 -> 34): 35 null
      // try (36 -> 38): 35 null
      // try (40 -> 46): 35 null
   }
}
