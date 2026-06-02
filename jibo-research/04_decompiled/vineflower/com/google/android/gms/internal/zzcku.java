package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

public final class zzcku implements ServiceConnection, zzf, zzg {
   final zzckg a;
   private volatile boolean b;
   private volatile zzchl c;

   protected zzcku(zzckg var1) {
      this.a = var1;
   }

   public final void a() {
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
      // 01: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 04: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 0b: invokevirtual com/google/android/gms/internal/zzcjk.l ()Landroid/content/Context;
      // 0e: astore 1
      // 0f: aload 0
      // 10: monitorenter
      // 11: aload 0
      // 12: getfield com/google/android/gms/internal/zzcku.b Z
      // 15: ifeq 2a
      // 18: aload 0
      // 19: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 1c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1f: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 22: ldc "Connection attempt already in progress"
      // 24: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 27: aload 0
      // 28: monitorexit
      // 29: return
      // 2a: aload 0
      // 2b: getfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 2e: ifnull 4a
      // 31: aload 0
      // 32: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 35: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 38: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 3b: ldc "Already awaiting connection attempt"
      // 3d: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 40: aload 0
      // 41: monitorexit
      // 42: goto 29
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // 4a: new com/google/android/gms/internal/zzchl
      // 4d: astore 2
      // 4e: aload 2
      // 4f: aload 1
      // 50: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 53: aload 0
      // 54: aload 0
      // 55: invokespecial com/google/android/gms/internal/zzchl.<init> (Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/zzf;Lcom/google/android/gms/common/internal/zzg;)V
      // 58: aload 0
      // 59: aload 2
      // 5a: putfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 5d: aload 0
      // 5e: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 61: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 64: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 67: ldc "Connecting to remote service"
      // 69: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 6c: aload 0
      // 6d: bipush 1
      // 6e: putfield com/google/android/gms/internal/zzcku.b Z
      // 71: aload 0
      // 72: getfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 75: invokevirtual com/google/android/gms/common/internal/zzd.r ()V
      // 78: aload 0
      // 79: monitorexit
      // 7a: goto 29
      // try (9 -> 20): 33 null
      // try (21 -> 32): 33 null
      // try (34 -> 36): 33 null
      // try (38 -> 63): 33 null
   }

   @Override
   public final void a(int var1) {
      zzbq.b("MeasurementServiceConnection.onConnectionSuspended");
      this.a.t().D().a("Service connection suspended");
      this.a.s().a(new zzcky(this));
   }

   public final void a(Intent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 04: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 0b: invokevirtual com/google/android/gms/internal/zzcjk.l ()Landroid/content/Context;
      // 0e: astore 2
      // 0f: invokestatic com/google/android/gms/common/stats/zza.a ()Lcom/google/android/gms/common/stats/zza;
      // 12: astore 3
      // 13: aload 0
      // 14: monitorenter
      // 15: aload 0
      // 16: getfield com/google/android/gms/internal/zzcku.b Z
      // 19: ifeq 2e
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 20: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 23: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 26: ldc "Connection attempt already in progress"
      // 28: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 2b: aload 0
      // 2c: monitorexit
      // 2d: return
      // 2e: aload 0
      // 2f: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 32: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 35: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 38: ldc "Using local app measurement service"
      // 3a: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 3d: aload 0
      // 3e: bipush 1
      // 3f: putfield com/google/android/gms/internal/zzcku.b Z
      // 42: aload 3
      // 43: aload 2
      // 44: aload 1
      // 45: aload 0
      // 46: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 49: invokestatic com/google/android/gms/internal/zzckg.a (Lcom/google/android/gms/internal/zzckg;)Lcom/google/android/gms/internal/zzcku;
      // 4c: sipush 129
      // 4f: invokevirtual com/google/android/gms/common/stats/zza.a (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      // 52: pop
      // 53: aload 0
      // 54: monitorexit
      // 55: goto 2d
      // 58: astore 1
      // 59: aload 0
      // 5a: monitorexit
      // 5b: aload 1
      // 5c: athrow
      // try (11 -> 22): 44 null
      // try (23 -> 43): 44 null
      // try (45 -> 47): 44 null
   }

   @Override
   public final void a(Bundle param1) {
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
      // 00: ldc "MeasurementServiceConnection.onConnected"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.b (Ljava/lang/String;)V
      // 05: aload 0
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 0b: invokevirtual com/google/android/gms/common/internal/zzd.v ()Landroid/os/IInterface;
      // 0e: checkcast com/google/android/gms/internal/zzche
      // 11: astore 2
      // 12: aload 0
      // 13: aconst_null
      // 14: putfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 17: aload 0
      // 18: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 1b: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 1e: astore 3
      // 1f: new com/google/android/gms/internal/zzckx
      // 22: astore 1
      // 23: aload 1
      // 24: aload 0
      // 25: aload 2
      // 26: invokespecial com/google/android/gms/internal/zzckx.<init> (Lcom/google/android/gms/internal/zzcku;Lcom/google/android/gms/internal/zzche;)V
      // 29: aload 3
      // 2a: aload 1
      // 2b: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 2e: aload 0
      // 2f: monitorexit
      // 30: return
      // 31: astore 1
      // 32: aload 0
      // 33: aconst_null
      // 34: putfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 37: aload 0
      // 38: bipush 0
      // 39: putfield com/google/android/gms/internal/zzcku.b Z
      // 3c: goto 2e
      // 3f: astore 1
      // 40: aload 0
      // 41: monitorexit
      // 42: aload 1
      // 43: athrow
      // 44: astore 1
      // 45: goto 32
      // try (4 -> 25): 41 android/os/DeadObjectException
      // try (4 -> 25): 28 java/lang/IllegalStateException
      // try (4 -> 25): 36 null
      // try (25 -> 27): 36 null
      // try (29 -> 35): 36 null
      // try (37 -> 39): 36 null
   }

   @Override
   public final void a(ConnectionResult param1) {
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
      // 00: ldc "MeasurementServiceConnection.onConnectionFailed"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.b (Ljava/lang/String;)V
      // 05: aload 0
      // 06: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 09: getfield com/google/android/gms/internal/zzckg.p Lcom/google/android/gms/internal/zzcim;
      // 0c: invokevirtual com/google/android/gms/internal/zzcim.g ()Lcom/google/android/gms/internal/zzchm;
      // 0f: astore 2
      // 10: aload 2
      // 11: ifnull 1e
      // 14: aload 2
      // 15: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 18: ldc "Service connection failed"
      // 1a: aload 1
      // 1b: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 1e: aload 0
      // 1f: monitorenter
      // 20: aload 0
      // 21: bipush 0
      // 22: putfield com/google/android/gms/internal/zzcku.b Z
      // 25: aload 0
      // 26: aconst_null
      // 27: putfield com/google/android/gms/internal/zzcku.c Lcom/google/android/gms/internal/zzchl;
      // 2a: aload 0
      // 2b: monitorexit
      // 2c: aload 0
      // 2d: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 30: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 33: new com/google/android/gms/internal/zzckz
      // 36: dup
      // 37: aload 0
      // 38: invokespecial com/google/android/gms/internal/zzckz.<init> (Lcom/google/android/gms/internal/zzcku;)V
      // 3b: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 3e: return
      // 3f: astore 1
      // 40: aload 0
      // 41: monitorexit
      // 42: aload 1
      // 43: athrow
      // try (16 -> 24): 33 null
      // try (34 -> 36): 33 null
   }

   public final void onServiceConnected(ComponentName param1, IBinder param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc "MeasurementServiceConnection.onServiceConnected"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.b (Ljava/lang/String;)V
      // 05: aload 0
      // 06: monitorenter
      // 07: aload 2
      // 08: ifnonnull 22
      // 0b: aload 0
      // 0c: bipush 0
      // 0d: putfield com/google/android/gms/internal/zzcku.b Z
      // 10: aload 0
      // 11: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 14: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 17: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1a: ldc "Service connected with null binder"
      // 1c: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 1f: aload 0
      // 20: monitorexit
      // 21: return
      // 22: aload 2
      // 23: invokeinterface android/os/IBinder.getInterfaceDescriptor ()Ljava/lang/String; 1
      // 28: astore 1
      // 29: ldc "com.google.android.gms.measurement.internal.IMeasurementService"
      // 2b: aload 1
      // 2c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2f: istore 3
      // 30: iload 3
      // 31: ifeq aa
      // 34: aload 2
      // 35: ifnonnull 71
      // 38: aconst_null
      // 39: astore 1
      // 3a: aload 0
      // 3b: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 3e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 41: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 44: ldc "Bound to IMeasurementService interface"
      // 46: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 49: aload 1
      // 4a: ifnonnull bf
      // 4d: aload 0
      // 4e: bipush 0
      // 4f: putfield com/google/android/gms/internal/zzcku.b Z
      // 52: invokestatic com/google/android/gms/common/stats/zza.a ()Lcom/google/android/gms/common/stats/zza;
      // 55: pop
      // 56: aload 0
      // 57: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 5a: invokevirtual com/google/android/gms/internal/zzcjk.l ()Landroid/content/Context;
      // 5d: aload 0
      // 5e: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 61: invokestatic com/google/android/gms/internal/zzckg.a (Lcom/google/android/gms/internal/zzckg;)Lcom/google/android/gms/internal/zzcku;
      // 64: invokevirtual android/content/Context.unbindService (Landroid/content/ServiceConnection;)V
      // 67: aload 0
      // 68: monitorexit
      // 69: goto 21
      // 6c: astore 1
      // 6d: aload 0
      // 6e: monitorexit
      // 6f: aload 1
      // 70: athrow
      // 71: aload 2
      // 72: ldc "com.google.android.gms.measurement.internal.IMeasurementService"
      // 74: invokeinterface android/os/IBinder.queryLocalInterface (Ljava/lang/String;)Landroid/os/IInterface; 2
      // 79: astore 1
      // 7a: aload 1
      // 7b: instanceof com/google/android/gms/internal/zzche
      // 7e: ifeq 89
      // 81: aload 1
      // 82: checkcast com/google/android/gms/internal/zzche
      // 85: astore 1
      // 86: goto 3a
      // 89: new com/google/android/gms/internal/zzchg
      // 8c: dup
      // 8d: aload 2
      // 8e: invokespecial com/google/android/gms/internal/zzchg.<init> (Landroid/os/IBinder;)V
      // 91: astore 1
      // 92: goto 3a
      // 95: astore 1
      // 96: aconst_null
      // 97: astore 1
      // 98: aload 0
      // 99: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // 9c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 9f: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // a2: ldc "Service connect failed to get IMeasurementService"
      // a4: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // a7: goto 49
      // aa: aload 0
      // ab: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // ae: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // b1: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // b4: ldc "Got binder with a wrong descriptor"
      // b6: aload 1
      // b7: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // ba: aconst_null
      // bb: astore 1
      // bc: goto 49
      // bf: aload 0
      // c0: getfield com/google/android/gms/internal/zzcku.a Lcom/google/android/gms/internal/zzckg;
      // c3: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // c6: astore 2
      // c7: new com/google/android/gms/internal/zzckv
      // ca: astore 4
      // cc: aload 4
      // ce: aload 0
      // cf: aload 1
      // d0: invokespecial com/google/android/gms/internal/zzckv.<init> (Lcom/google/android/gms/internal/zzcku;Lcom/google/android/gms/internal/zzche;)V
      // d3: aload 2
      // d4: aload 4
      // d6: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // d9: goto 67
      // dc: astore 1
      // dd: goto 67
      // e0: astore 2
      // e1: goto 98
      // try (6 -> 17): 54 null
      // try (18 -> 25): 76 android/os/RemoteException
      // try (18 -> 25): 54 null
      // try (31 -> 37): 112 android/os/RemoteException
      // try (31 -> 37): 54 null
      // try (39 -> 42): 54 null
      // try (42 -> 51): 110 java/lang/IllegalArgumentException
      // try (42 -> 51): 54 null
      // try (51 -> 53): 54 null
      // try (55 -> 57): 54 null
      // try (59 -> 69): 76 android/os/RemoteException
      // try (59 -> 69): 54 null
      // try (70 -> 75): 76 android/os/RemoteException
      // try (70 -> 75): 54 null
      // try (79 -> 85): 54 null
      // try (86 -> 93): 76 android/os/RemoteException
      // try (86 -> 93): 54 null
      // try (96 -> 109): 54 null
   }

   public final void onServiceDisconnected(ComponentName var1) {
      zzbq.b("MeasurementServiceConnection.onServiceDisconnected");
      this.a.t().D().a("Service disconnected");
      this.a.s().a(new zzckw(this, var1));
   }
}
