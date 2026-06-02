package com.google.firebase.iid;

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

   private final void d(Intent param1) {
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
      // 05: invokestatic android/support/v4/content/WakefulBroadcastReceiver.a (Landroid/content/Intent;)Z
      // 08: pop
      // 09: aload 0
      // 0a: getfield com/google/firebase/iid/zzb.c Ljava/lang/Object;
      // 0d: astore 1
      // 0e: aload 1
      // 0f: monitorenter
      // 10: aload 0
      // 11: aload 0
      // 12: getfield com/google/firebase/iid/zzb.e I
      // 15: bipush 1
      // 16: isub
      // 17: putfield com/google/firebase/iid/zzb.e I
      // 1a: aload 0
      // 1b: getfield com/google/firebase/iid/zzb.e I
      // 1e: ifne 2a
      // 21: aload 0
      // 22: aload 0
      // 23: getfield com/google/firebase/iid/zzb.d I
      // 26: invokevirtual com/google/firebase/iid/zzb.stopSelfResult (I)Z
      // 29: pop
      // 2a: aload 1
      // 2b: monitorexit
      // 2c: return
      // 2d: astore 2
      // 2e: aload 1
      // 2f: monitorexit
      // 30: aload 2
      // 31: athrow
      // try (10 -> 24): 27 null
      // try (24 -> 26): 27 null
      // try (28 -> 30): 27 null
   }

   protected Intent a(Intent var1) {
      return var1;
   }

   public abstract void b(Intent var1);

   public boolean c(Intent var1) {
      return false;
   }

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
      // 00: bipush 2
      // 01: istore 2
      // 02: aload 0
      // 03: getfield com/google/firebase/iid/zzb.c Ljava/lang/Object;
      // 06: astore 4
      // 08: aload 4
      // 0a: monitorenter
      // 0b: aload 0
      // 0c: iload 3
      // 0d: putfield com/google/firebase/iid/zzb.d I
      // 10: aload 0
      // 11: aload 0
      // 12: getfield com/google/firebase/iid/zzb.e I
      // 15: bipush 1
      // 16: iadd
      // 17: putfield com/google/firebase/iid/zzb.e I
      // 1a: aload 4
      // 1c: monitorexit
      // 1d: aload 0
      // 1e: aload 1
      // 1f: invokevirtual com/google/firebase/iid/zzb.a (Landroid/content/Intent;)Landroid/content/Intent;
      // 22: astore 4
      // 24: aload 4
      // 26: ifnonnull 36
      // 29: aload 0
      // 2a: aload 1
      // 2b: invokespecial com/google/firebase/iid/zzb.d (Landroid/content/Intent;)V
      // 2e: iload 2
      // 2f: ireturn
      // 30: astore 1
      // 31: aload 4
      // 33: monitorexit
      // 34: aload 1
      // 35: athrow
      // 36: aload 0
      // 37: aload 4
      // 39: invokevirtual com/google/firebase/iid/zzb.c (Landroid/content/Intent;)Z
      // 3c: ifeq 47
      // 3f: aload 0
      // 40: aload 1
      // 41: invokespecial com/google/firebase/iid/zzb.d (Landroid/content/Intent;)V
      // 44: goto 2e
      // 47: aload 0
      // 48: getfield com/google/firebase/iid/zzb.a Ljava/util/concurrent/ExecutorService;
      // 4b: new com/google/firebase/iid/zzc
      // 4e: dup
      // 4f: aload 0
      // 50: aload 4
      // 52: aload 1
      // 53: invokespecial com/google/firebase/iid/zzc.<init> (Lcom/google/firebase/iid/zzb;Landroid/content/Intent;Landroid/content/Intent;)V
      // 56: invokeinterface java/util/concurrent/ExecutorService.execute (Ljava/lang/Runnable;)V 2
      // 5b: bipush 3
      // 5c: istore 2
      // 5d: goto 2e
      // try (7 -> 18): 29 null
      // try (30 -> 32): 29 null
   }
}
