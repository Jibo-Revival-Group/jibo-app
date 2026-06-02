package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.BroadcastReceiver.PendingResult;
import android.os.IBinder;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzh implements ServiceConnection {
   private final Context a;
   private final Intent b;
   private final ScheduledExecutorService c;
   private final Queue<zzd> d = new LinkedList<>();
   private zzf e;
   private boolean f = false;

   public zzh(Context var1, String var2) {
      this(var1, var2, new ScheduledThreadPoolExecutor(0));
   }

   private zzh(Context var1, String var2, ScheduledExecutorService var3) {
      this.a = var1.getApplicationContext();
      this.b = new Intent(var2).setPackage(this.a.getPackageName());
      this.c = var3;
   }

   private final void a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: ldc "EnhancedIntentService"
      // 04: bipush 3
      // 05: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 08: ifeq 13
      // 0b: ldc "EnhancedIntentService"
      // 0d: ldc "flush queue called"
      // 0f: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 12: pop
      // 13: aload 0
      // 14: getfield com/google/android/gms/iid/zzh.d Ljava/util/Queue;
      // 17: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 1c: ifne c0
      // 1f: ldc "EnhancedIntentService"
      // 21: bipush 3
      // 22: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 25: ifeq 30
      // 28: ldc "EnhancedIntentService"
      // 2a: ldc "found intent to be delivered"
      // 2c: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 2f: pop
      // 30: aload 0
      // 31: getfield com/google/android/gms/iid/zzh.e Lcom/google/android/gms/iid/zzf;
      // 34: ifnull 6f
      // 37: aload 0
      // 38: getfield com/google/android/gms/iid/zzh.e Lcom/google/android/gms/iid/zzf;
      // 3b: invokevirtual com/google/android/gms/iid/zzf.isBinderAlive ()Z
      // 3e: ifeq 6f
      // 41: ldc "EnhancedIntentService"
      // 43: bipush 3
      // 44: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 47: ifeq 52
      // 4a: ldc "EnhancedIntentService"
      // 4c: ldc "binder is alive, sending the intent."
      // 4e: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 51: pop
      // 52: aload 0
      // 53: getfield com/google/android/gms/iid/zzh.d Ljava/util/Queue;
      // 56: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 5b: checkcast com/google/android/gms/iid/zzd
      // 5e: astore 2
      // 5f: aload 0
      // 60: getfield com/google/android/gms/iid/zzh.e Lcom/google/android/gms/iid/zzf;
      // 63: aload 2
      // 64: invokevirtual com/google/android/gms/iid/zzf.a (Lcom/google/android/gms/iid/zzd;)V
      // 67: goto 13
      // 6a: astore 2
      // 6b: aload 0
      // 6c: monitorexit
      // 6d: aload 2
      // 6e: athrow
      // 6f: ldc "EnhancedIntentService"
      // 71: bipush 3
      // 72: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 75: ifeq 9e
      // 78: aload 0
      // 79: getfield com/google/android/gms/iid/zzh.f Z
      // 7c: ifne c3
      // 7f: bipush 1
      // 80: istore 1
      // 81: new java/lang/StringBuilder
      // 84: astore 2
      // 85: aload 2
      // 86: bipush 39
      // 88: invokespecial java/lang/StringBuilder.<init> (I)V
      // 8b: ldc "EnhancedIntentService"
      // 8d: aload 2
      // 8e: ldc "binder is dead. start connection? "
      // 90: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 93: iload 1
      // 94: invokevirtual java/lang/StringBuilder.append (Z)Ljava/lang/StringBuilder;
      // 97: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 9a: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 9d: pop
      // 9e: aload 0
      // 9f: getfield com/google/android/gms/iid/zzh.f Z
      // a2: ifne c0
      // a5: aload 0
      // a6: bipush 1
      // a7: putfield com/google/android/gms/iid/zzh.f Z
      // aa: invokestatic com/google/android/gms/common/stats/zza.a ()Lcom/google/android/gms/common/stats/zza;
      // ad: aload 0
      // ae: getfield com/google/android/gms/iid/zzh.a Landroid/content/Context;
      // b1: aload 0
      // b2: getfield com/google/android/gms/iid/zzh.b Landroid/content/Intent;
      // b5: aload 0
      // b6: bipush 65
      // b8: invokevirtual com/google/android/gms/common/stats/zza.a (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      // bb: istore 1
      // bc: iload 1
      // bd: ifeq c8
      // c0: aload 0
      // c1: monitorexit
      // c2: return
      // c3: bipush 0
      // c4: istore 1
      // c5: goto 81
      // c8: ldc "EnhancedIntentService"
      // ca: ldc "binding to the service failed"
      // cc: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // cf: pop
      // d0: aload 0
      // d1: getfield com/google/android/gms/iid/zzh.d Ljava/util/Queue;
      // d4: invokeinterface java/util/Queue.isEmpty ()Z 1
      // d9: ifne c0
      // dc: aload 0
      // dd: getfield com/google/android/gms/iid/zzh.d Ljava/util/Queue;
      // e0: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // e5: checkcast com/google/android/gms/iid/zzd
      // e8: invokevirtual com/google/android/gms/iid/zzd.a ()V
      // eb: goto d0
      // ee: astore 2
      // ef: ldc "EnhancedIntentService"
      // f1: ldc "Exception while binding the service"
      // f3: aload 2
      // f4: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // f7: pop
      // f8: goto d0
      // try (2 -> 10): 47 null
      // try (10 -> 22): 47 null
      // try (22 -> 37): 47 null
      // try (37 -> 46): 47 null
      // try (52 -> 59): 47 null
      // try (61 -> 75): 47 null
      // try (75 -> 81): 47 null
      // try (81 -> 90): 112 java/lang/SecurityException
      // try (81 -> 90): 47 null
      // try (98 -> 102): 112 java/lang/SecurityException
      // try (98 -> 102): 47 null
      // try (102 -> 111): 47 null
      // try (113 -> 118): 47 null
   }

   public final void a(Intent var1, PendingResult var2) {
      synchronized (this) {
         if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
         }

         Queue var3 = this.d;
         zzd var4 = new zzd(var1, var2, this.c);
         var3.add(var4);
         this.a();
      }
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: bipush 0
      // 04: putfield com/google/android/gms/iid/zzh.f Z
      // 07: aload 0
      // 08: aload 2
      // 09: checkcast com/google/android/gms/iid/zzf
      // 0c: putfield com/google/android/gms/iid/zzh.e Lcom/google/android/gms/iid/zzf;
      // 0f: ldc "EnhancedIntentService"
      // 11: bipush 3
      // 12: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 15: ifeq 44
      // 18: aload 1
      // 19: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1c: astore 1
      // 1d: aload 1
      // 1e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 21: invokevirtual java/lang/String.length ()I
      // 24: istore 3
      // 25: new java/lang/StringBuilder
      // 28: astore 2
      // 29: aload 2
      // 2a: iload 3
      // 2b: bipush 20
      // 2d: iadd
      // 2e: invokespecial java/lang/StringBuilder.<init> (I)V
      // 31: ldc "EnhancedIntentService"
      // 33: aload 2
      // 34: ldc "onServiceConnected: "
      // 36: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 39: aload 1
      // 3a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 40: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 43: pop
      // 44: aload 0
      // 45: invokespecial com/google/android/gms/iid/zzh.a ()V
      // 48: aload 0
      // 49: monitorexit
      // 4a: return
      // 4b: astore 1
      // 4c: aload 0
      // 4d: monitorexit
      // 4e: aload 1
      // 4f: athrow
      // try (2 -> 36): 41 null
      // try (36 -> 40): 41 null
      // try (42 -> 44): 41 null
   }

   public final void onServiceDisconnected(ComponentName var1) {
      if (Log.isLoggable("EnhancedIntentService", 3)) {
         String var2 = String.valueOf(var1);
         Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(var2).length() + 23).append("onServiceDisconnected: ").append(var2).toString());
      }

      this.a();
   }
}
