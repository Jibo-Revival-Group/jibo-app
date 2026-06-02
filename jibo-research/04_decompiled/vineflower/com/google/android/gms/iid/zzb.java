package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
   final ExecutorService a = Executors.newSingleThreadExecutor();
   private Binder b;
   private final Object c = new Object();
   private int d;
   private int e = 0;

   private final void a(Intent param1) {
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
      // 00: aload 1
      // 01: ifnull 09
      // 04: aload 1
      // 05: invokestatic com/google/android/gms/internal/zzcxs.a (Landroid/content/Intent;)Z
      // 08: pop
      // 09: aload 0
      // 0a: getfield com/google/android/gms/iid/zzb.c Ljava/lang/Object;
      // 0d: astore 2
      // 0e: aload 2
      // 0f: monitorenter
      // 10: aload 0
      // 11: aload 0
      // 12: getfield com/google/android/gms/iid/zzb.e I
      // 15: bipush 1
      // 16: isub
      // 17: putfield com/google/android/gms/iid/zzb.e I
      // 1a: aload 0
      // 1b: getfield com/google/android/gms/iid/zzb.e I
      // 1e: ifne 2a
      // 21: aload 0
      // 22: aload 0
      // 23: getfield com/google/android/gms/iid/zzb.d I
      // 26: invokevirtual com/google/android/gms/iid/zzb.stopSelfResult (I)Z
      // 29: pop
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: return
      // 2d: astore 1
      // 2e: aload 2
      // 2f: monitorexit
      // 30: aload 1
      // 31: athrow
      // try (10 -> 24): 27 null
      // try (24 -> 26): 27 null
      // try (28 -> 30): 27 null
   }

   public abstract void handleIntent(Intent var1);

   public final IBinder onBind(Intent var1) {
      synchronized (this) {
         if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
         }

         if (this.b == null) {
            zzf var4 = new zzf(this);
            this.b = var4;
         }

         return this.b;
      }
   }

   public final int onStartCommand(Intent param1, int param2, int param3) {
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
      // 01: getfield com/google/android/gms/iid/zzb.c Ljava/lang/Object;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: iload 3
      // 0b: putfield com/google/android/gms/iid/zzb.d I
      // 0e: aload 0
      // 0f: aload 0
      // 10: getfield com/google/android/gms/iid/zzb.e I
      // 13: bipush 1
      // 14: iadd
      // 15: putfield com/google/android/gms/iid/zzb.e I
      // 18: aload 4
      // 1a: monitorexit
      // 1b: aload 1
      // 1c: ifnonnull 2e
      // 1f: aload 0
      // 20: aload 1
      // 21: invokespecial com/google/android/gms/iid/zzb.a (Landroid/content/Intent;)V
      // 24: bipush 2
      // 25: istore 2
      // 26: iload 2
      // 27: ireturn
      // 28: astore 1
      // 29: aload 4
      // 2b: monitorexit
      // 2c: aload 1
      // 2d: athrow
      // 2e: aload 0
      // 2f: getfield com/google/android/gms/iid/zzb.a Ljava/util/concurrent/ExecutorService;
      // 32: new com/google/android/gms/iid/zzc
      // 35: dup
      // 36: aload 0
      // 37: aload 1
      // 38: aload 1
      // 39: invokespecial com/google/android/gms/iid/zzc.<init> (Lcom/google/android/gms/iid/zzb;Landroid/content/Intent;Landroid/content/Intent;)V
      // 3c: invokeinterface java/util/concurrent/ExecutorService.execute (Ljava/lang/Runnable;)V 2
      // 41: bipush 3
      // 42: istore 2
      // 43: goto 26
      // try (5 -> 16): 25 null
      // try (26 -> 28): 25 null
   }
}
