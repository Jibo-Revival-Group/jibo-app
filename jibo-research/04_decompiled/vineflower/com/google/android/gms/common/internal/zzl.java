package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class zzl implements ServiceConnection {
   private final int a;
   private zzd b;

   public zzl(zzd var1, int var2) {
      this.b = var1;
      super();
      this.a = var2;
   }

   public final void onServiceConnected(ComponentName param1, IBinder param2) {
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
      // 00: aload 2
      // 01: ifnonnull 0e
      // 04: aload 0
      // 05: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 08: bipush 16
      // 0a: invokestatic com/google/android/gms/common/internal/zzd.a (Lcom/google/android/gms/common/internal/zzd;I)V
      // 0d: return
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 12: invokestatic com/google/android/gms/common/internal/zzd.a (Lcom/google/android/gms/common/internal/zzd;)Ljava/lang/Object;
      // 15: astore 3
      // 16: aload 3
      // 17: monitorenter
      // 18: aload 0
      // 19: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 1c: astore 4
      // 1e: aload 2
      // 1f: ifnonnull 3d
      // 22: aconst_null
      // 23: astore 1
      // 24: aload 4
      // 26: aload 1
      // 27: invokestatic com/google/android/gms/common/internal/zzd.a (Lcom/google/android/gms/common/internal/zzd;Lcom/google/android/gms/common/internal/zzay;)Lcom/google/android/gms/common/internal/zzay;
      // 2a: pop
      // 2b: aload 3
      // 2c: monitorexit
      // 2d: aload 0
      // 2e: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 31: bipush 0
      // 32: aconst_null
      // 33: aload 0
      // 34: getfield com/google/android/gms/common/internal/zzl.a I
      // 37: invokevirtual com/google/android/gms/common/internal/zzd.a (ILandroid/os/Bundle;I)V
      // 3a: goto 0d
      // 3d: aload 2
      // 3e: ldc "com.google.android.gms.common.internal.IGmsServiceBroker"
      // 40: invokeinterface android/os/IBinder.queryLocalInterface (Ljava/lang/String;)Landroid/os/IInterface; 2
      // 45: astore 1
      // 46: aload 1
      // 47: ifnull 59
      // 4a: aload 1
      // 4b: instanceof com/google/android/gms/common/internal/zzay
      // 4e: ifeq 59
      // 51: aload 1
      // 52: checkcast com/google/android/gms/common/internal/zzay
      // 55: astore 1
      // 56: goto 24
      // 59: new com/google/android/gms/common/internal/zzaz
      // 5c: dup
      // 5d: aload 2
      // 5e: invokespecial com/google/android/gms/common/internal/zzaz.<init> (Landroid/os/IBinder;)V
      // 61: astore 1
      // 62: goto 24
      // 65: astore 1
      // 66: aload 3
      // 67: monitorexit
      // 68: aload 1
      // 69: athrow
      // try (13 -> 16): 53 null
      // try (20 -> 26): 53 null
      // try (34 -> 38): 53 null
      // try (40 -> 46): 53 null
      // try (47 -> 52): 53 null
      // try (54 -> 56): 53 null
   }

   public final void onServiceDisconnected(ComponentName param1) {
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
      // 01: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 04: invokestatic com/google/android/gms/common/internal/zzd.a (Lcom/google/android/gms/common/internal/zzd;)Ljava/lang/Object;
      // 07: astore 2
      // 08: aload 2
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 0e: aconst_null
      // 0f: invokestatic com/google/android/gms/common/internal/zzd.a (Lcom/google/android/gms/common/internal/zzd;Lcom/google/android/gms/common/internal/zzay;)Lcom/google/android/gms/common/internal/zzay;
      // 12: pop
      // 13: aload 2
      // 14: monitorexit
      // 15: aload 0
      // 16: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 19: getfield com/google/android/gms/common/internal/zzd.a Landroid/os/Handler;
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/common/internal/zzl.b Lcom/google/android/gms/common/internal/zzd;
      // 20: getfield com/google/android/gms/common/internal/zzd.a Landroid/os/Handler;
      // 23: bipush 6
      // 25: aload 0
      // 26: getfield com/google/android/gms/common/internal/zzl.a I
      // 29: bipush 1
      // 2a: invokevirtual android/os/Handler.obtainMessage (III)Landroid/os/Message;
      // 2d: invokevirtual android/os/Handler.sendMessage (Landroid/os/Message;)Z
      // 30: pop
      // 31: return
      // 32: astore 1
      // 33: aload 2
      // 34: monitorexit
      // 35: aload 1
      // 36: athrow
      // try (6 -> 13): 27 null
      // try (28 -> 30): 27 null
   }
}
