package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Executor;

final class zzn<TResult> extends Task<TResult> {
   private final Object a = new Object();
   private final zzl<TResult> b = new zzl<>();
   private boolean c;
   private TResult d;
   private Exception e;

   private final void e() {
      zzbq.a(this.c, "Task is not yet complete");
   }

   private final void f() {
      boolean var1;
      if (!this.c) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzbq.a(var1, "Task is already complete");
   }

   private final void g() {
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
      // 01: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzn.c Z
      // 0b: ifne 11
      // 0e: aload 2
      // 0f: monitorexit
      // 10: return
      // 11: aload 2
      // 12: monitorexit
      // 13: aload 0
      // 14: getfield com/google/android/gms/tasks/zzn.b Lcom/google/android/gms/tasks/zzl;
      // 17: aload 0
      // 18: invokevirtual com/google/android/gms/tasks/zzl.a (Lcom/google/android/gms/tasks/Task;)V
      // 1b: goto 10
      // 1e: astore 1
      // 1f: aload 2
      // 20: monitorexit
      // 21: aload 1
      // 22: athrow
      // try (5 -> 10): 18 null
      // try (11 -> 13): 18 null
      // try (19 -> 21): 18 null
   }

   @Override
   public final Task<TResult> a(Executor var1, OnCompleteListener<TResult> var2) {
      this.b.a(new zze<>(var1, var2));
      this.g();
      return this;
   }

   @Override
   public final Task<TResult> a(Executor var1, OnFailureListener var2) {
      this.b.a(new zzg<>(var1, var2));
      this.g();
      return this;
   }

   @Override
   public final Task<TResult> a(Executor var1, OnSuccessListener<? super TResult> var2) {
      this.b.a(new zzi<>(var1, var2));
      this.g();
      return this;
   }

   public final void a(Exception param1) {
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
      // 00: aload 1
      // 01: ldc "Exception must not be null"
      // 03: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 06: pop
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 0b: astore 2
      // 0c: aload 2
      // 0d: monitorenter
      // 0e: aload 0
      // 0f: invokespecial com/google/android/gms/tasks/zzn.f ()V
      // 12: aload 0
      // 13: bipush 1
      // 14: putfield com/google/android/gms/tasks/zzn.c Z
      // 17: aload 0
      // 18: aload 1
      // 19: putfield com/google/android/gms/tasks/zzn.e Ljava/lang/Exception;
      // 1c: aload 2
      // 1d: monitorexit
      // 1e: aload 0
      // 1f: getfield com/google/android/gms/tasks/zzn.b Lcom/google/android/gms/tasks/zzl;
      // 22: aload 0
      // 23: invokevirtual com/google/android/gms/tasks/zzl.a (Lcom/google/android/gms/tasks/Task;)V
      // 26: return
      // 27: astore 1
      // 28: aload 2
      // 29: monitorexit
      // 2a: aload 1
      // 2b: athrow
      // try (9 -> 19): 24 null
      // try (25 -> 27): 24 null
   }

   public final void a(TResult param1) {
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
      // 01: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial com/google/android/gms/tasks/zzn.f ()V
      // 0b: aload 0
      // 0c: bipush 1
      // 0d: putfield com/google/android/gms/tasks/zzn.c Z
      // 10: aload 0
      // 11: aload 1
      // 12: putfield com/google/android/gms/tasks/zzn.d Ljava/lang/Object;
      // 15: aload 2
      // 16: monitorexit
      // 17: aload 0
      // 18: getfield com/google/android/gms/tasks/zzn.b Lcom/google/android/gms/tasks/zzl;
      // 1b: aload 0
      // 1c: invokevirtual com/google/android/gms/tasks/zzl.a (Lcom/google/android/gms/tasks/Task;)V
      // 1f: return
      // 20: astore 1
      // 21: aload 2
      // 22: monitorexit
      // 23: aload 1
      // 24: athrow
      // try (5 -> 15): 20 null
      // try (21 -> 23): 20 null
   }

   @Override
   public final boolean a() {
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
      // 01: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzn.c Z
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
   public final boolean b() {
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
      // 01: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzn.c Z
      // 0b: ifeq 1b
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/tasks/zzn.e Ljava/lang/Exception;
      // 12: ifnonnull 1b
      // 15: bipush 1
      // 16: istore 1
      // 17: aload 2
      // 18: monitorexit
      // 19: iload 1
      // 1a: ireturn
      // 1b: bipush 0
      // 1c: istore 1
      // 1d: goto 17
      // 20: astore 3
      // 21: aload 2
      // 22: monitorexit
      // 23: aload 3
      // 24: athrow
      // try (5 -> 11): 20 null
      // try (13 -> 15): 20 null
      // try (21 -> 23): 20 null
   }

   public final boolean b(Exception param1) {
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
      // 01: istore 2
      // 02: aload 1
      // 03: ldc "Exception must not be null"
      // 05: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 08: pop
      // 09: aload 0
      // 0a: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 0d: astore 3
      // 0e: aload 3
      // 0f: monitorenter
      // 10: aload 0
      // 11: getfield com/google/android/gms/tasks/zzn.c Z
      // 14: ifeq 1d
      // 17: bipush 0
      // 18: istore 2
      // 19: aload 3
      // 1a: monitorexit
      // 1b: iload 2
      // 1c: ireturn
      // 1d: aload 0
      // 1e: bipush 1
      // 1f: putfield com/google/android/gms/tasks/zzn.c Z
      // 22: aload 0
      // 23: aload 1
      // 24: putfield com/google/android/gms/tasks/zzn.e Ljava/lang/Exception;
      // 27: aload 3
      // 28: monitorexit
      // 29: aload 0
      // 2a: getfield com/google/android/gms/tasks/zzn.b Lcom/google/android/gms/tasks/zzl;
      // 2d: aload 0
      // 2e: invokevirtual com/google/android/gms/tasks/zzl.a (Lcom/google/android/gms/tasks/Task;)V
      // 31: goto 1b
      // 34: astore 1
      // 35: aload 3
      // 36: monitorexit
      // 37: aload 1
      // 38: athrow
      // try (11 -> 14): 33 null
      // try (16 -> 18): 33 null
      // try (20 -> 28): 33 null
      // try (34 -> 36): 33 null
   }

   public final boolean b(TResult param1) {
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
      // 01: istore 2
      // 02: aload 0
      // 03: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 06: astore 3
      // 07: aload 3
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/google/android/gms/tasks/zzn.c Z
      // 0d: ifeq 16
      // 10: bipush 0
      // 11: istore 2
      // 12: aload 3
      // 13: monitorexit
      // 14: iload 2
      // 15: ireturn
      // 16: aload 0
      // 17: bipush 1
      // 18: putfield com/google/android/gms/tasks/zzn.c Z
      // 1b: aload 0
      // 1c: aload 1
      // 1d: putfield com/google/android/gms/tasks/zzn.d Ljava/lang/Object;
      // 20: aload 3
      // 21: monitorexit
      // 22: aload 0
      // 23: getfield com/google/android/gms/tasks/zzn.b Lcom/google/android/gms/tasks/zzl;
      // 26: aload 0
      // 27: invokevirtual com/google/android/gms/tasks/zzl.a (Lcom/google/android/gms/tasks/Task;)V
      // 2a: goto 14
      // 2d: astore 1
      // 2e: aload 3
      // 2f: monitorexit
      // 30: aload 1
      // 31: athrow
      // try (7 -> 10): 29 null
      // try (12 -> 14): 29 null
      // try (16 -> 24): 29 null
      // try (30 -> 32): 29 null
   }

   @Override
   public final TResult c() {
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
      // 01: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: invokespecial com/google/android/gms/tasks/zzn.e ()V
      // 0b: aload 0
      // 0c: getfield com/google/android/gms/tasks/zzn.e Ljava/lang/Exception;
      // 0f: ifnull 25
      // 12: new com/google/android/gms/tasks/RuntimeExecutionException
      // 15: astore 2
      // 16: aload 2
      // 17: aload 0
      // 18: getfield com/google/android/gms/tasks/zzn.e Ljava/lang/Exception;
      // 1b: invokespecial com/google/android/gms/tasks/RuntimeExecutionException.<init> (Ljava/lang/Throwable;)V
      // 1e: aload 2
      // 1f: athrow
      // 20: astore 2
      // 21: aload 1
      // 22: monitorexit
      // 23: aload 2
      // 24: athrow
      // 25: aload 0
      // 26: getfield com/google/android/gms/tasks/zzn.d Ljava/lang/Object;
      // 29: astore 2
      // 2a: aload 1
      // 2b: monitorexit
      // 2c: aload 2
      // 2d: areturn
      // try (5 -> 18): 18 null
      // try (19 -> 21): 18 null
      // try (23 -> 28): 18 null
   }

   @Override
   public final Exception d() {
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
      // 01: getfield com/google/android/gms/tasks/zzn.a Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/tasks/zzn.e Ljava/lang/Exception;
      // 0b: astore 2
      // 0c: aload 1
      // 0d: monitorexit
      // 0e: aload 2
      // 0f: areturn
      // 10: astore 2
      // 11: aload 1
      // 12: monitorexit
      // 13: aload 2
      // 14: athrow
      // try (5 -> 10): 12 null
      // try (13 -> 15): 12 null
   }
}
