package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class JobService extends Service {
   private static final Handler a = new Handler(Looper.getMainLooper());
   private final SimpleArrayMap<String, JobService.JobCallback> b = new SimpleArrayMap<>(1);
   private final IRemoteJobService.Stub c = new IRemoteJobService.Stub(this) {
      final JobService a;

      {
         this.a = var1;
      }

      @Override
      public void a(Bundle var1, IJobCallback var2) {
         JobInvocation.Builder var3 = GooglePlayReceiver.b().b(var1);
         if (var3 == null) {
            Log.wtf("FJD.JobService", "start: unknown invocation provided");
         } else {
            this.a.a(var3.a(), var2);
         }
      }

      @Override
      public void a(Bundle var1, boolean var2) {
         JobInvocation.Builder var3 = GooglePlayReceiver.b().b(var1);
         if (var3 == null) {
            Log.wtf("FJD.JobService", "stop: unknown invocation provided");
         } else {
            this.a.a(var3.a(), var2);
         }
      }
   };

   void a(JobParameters param1, IJobCallback param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 0b: aload 1
      // 0c: invokeinterface com/firebase/jobdispatcher/JobParameters.e ()Ljava/lang/String; 1
      // 11: invokevirtual android/support/v4/util/SimpleArrayMap.containsKey (Ljava/lang/Object;)Z
      // 14: ifeq 35
      // 17: ldc "FJD.JobService"
      // 19: getstatic java/util/Locale.US Ljava/util/Locale;
      // 1c: ldc "Job with tag = %s was already running."
      // 1e: bipush 1
      // 1f: anewarray 75
      // 22: dup
      // 23: bipush 0
      // 24: aload 1
      // 25: invokeinterface com/firebase/jobdispatcher/JobParameters.e ()Ljava/lang/String; 1
      // 2a: aastore
      // 2b: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 2e: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 31: pop
      // 32: aload 3
      // 33: monitorexit
      // 34: return
      // 35: aload 0
      // 36: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 39: astore 5
      // 3b: aload 1
      // 3c: invokeinterface com/firebase/jobdispatcher/JobParameters.e ()Ljava/lang/String; 1
      // 41: astore 6
      // 43: new com/firebase/jobdispatcher/JobService$JobCallback
      // 46: astore 4
      // 48: aload 4
      // 4a: aload 1
      // 4b: aload 2
      // 4c: aconst_null
      // 4d: invokespecial com/firebase/jobdispatcher/JobService$JobCallback.<init> (Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;Lcom/firebase/jobdispatcher/JobService$1;)V
      // 50: aload 5
      // 52: aload 6
      // 54: aload 4
      // 56: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 59: pop
      // 5a: getstatic com/firebase/jobdispatcher/JobService.a Landroid/os/Handler;
      // 5d: astore 2
      // 5e: new com/firebase/jobdispatcher/JobService$2
      // 61: astore 4
      // 63: aload 4
      // 65: aload 0
      // 66: aload 1
      // 67: invokespecial com/firebase/jobdispatcher/JobService$2.<init> (Lcom/firebase/jobdispatcher/JobService;Lcom/firebase/jobdispatcher/JobParameters;)V
      // 6a: aload 2
      // 6b: aload 4
      // 6d: invokevirtual android/os/Handler.post (Ljava/lang/Runnable;)Z
      // 70: pop
      // 71: aload 3
      // 72: monitorexit
      // 73: goto 34
      // 76: astore 1
      // 77: aload 3
      // 78: monitorexit
      // 79: aload 1
      // 7a: athrow
      // try (5 -> 26): 60 null
      // try (27 -> 59): 60 null
      // try (61 -> 63): 60 null
   }

   void a(JobParameters param1, boolean param2) {
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
      // 01: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 0b: aload 1
      // 0c: invokeinterface com/firebase/jobdispatcher/JobParameters.e ()Ljava/lang/String; 1
      // 11: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 14: checkcast com/firebase/jobdispatcher/JobService$JobCallback
      // 17: astore 6
      // 19: aload 6
      // 1b: ifnonnull 32
      // 1e: ldc "FJD.JobService"
      // 20: bipush 3
      // 21: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 24: ifeq 2f
      // 27: ldc "FJD.JobService"
      // 29: ldc "Provided job has already been executed."
      // 2b: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 2e: pop
      // 2f: aload 3
      // 30: monitorexit
      // 31: return
      // 32: getstatic com/firebase/jobdispatcher/JobService.a Landroid/os/Handler;
      // 35: astore 4
      // 37: new com/firebase/jobdispatcher/JobService$3
      // 3a: astore 5
      // 3c: aload 5
      // 3e: aload 0
      // 3f: aload 1
      // 40: iload 2
      // 41: aload 6
      // 43: invokespecial com/firebase/jobdispatcher/JobService$3.<init> (Lcom/firebase/jobdispatcher/JobService;Lcom/firebase/jobdispatcher/JobParameters;ZLcom/firebase/jobdispatcher/JobService$JobCallback;)V
      // 46: aload 4
      // 48: aload 5
      // 4a: invokevirtual android/os/Handler.post (Ljava/lang/Runnable;)Z
      // 4d: pop
      // 4e: aload 3
      // 4f: monitorexit
      // 50: goto 31
      // 53: astore 1
      // 54: aload 3
      // 55: monitorexit
      // 56: aload 1
      // 57: athrow
      // try (5 -> 12): 42 null
      // try (14 -> 22): 42 null
      // try (22 -> 24): 42 null
      // try (25 -> 41): 42 null
      // try (43 -> 45): 42 null
   }

   public abstract boolean a(JobParameters var1);

   public final void b(JobParameters param1, boolean param2) {
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
      // 01: ifnonnull 0d
      // 04: ldc "FJD.JobService"
      // 06: ldc "jobFinished called with a null JobParameters"
      // 08: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 0b: pop
      // 0c: return
      // 0d: aload 0
      // 0e: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 11: astore 4
      // 13: aload 4
      // 15: monitorenter
      // 16: aload 0
      // 17: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 1a: aload 1
      // 1b: invokeinterface com/firebase/jobdispatcher/JobParameters.e ()Ljava/lang/String; 1
      // 20: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 23: checkcast com/firebase/jobdispatcher/JobService$JobCallback
      // 26: astore 1
      // 27: aload 1
      // 28: ifnull 36
      // 2b: iload 2
      // 2c: ifeq 42
      // 2f: bipush 1
      // 30: istore 3
      // 31: aload 1
      // 32: iload 3
      // 33: invokevirtual com/firebase/jobdispatcher/JobService$JobCallback.a (I)V
      // 36: aload 4
      // 38: monitorexit
      // 39: goto 0c
      // 3c: astore 1
      // 3d: aload 4
      // 3f: monitorexit
      // 40: aload 1
      // 41: athrow
      // 42: bipush 0
      // 43: istore 3
      // 44: goto 31
      // try (12 -> 19): 31 null
      // try (25 -> 28): 31 null
      // try (28 -> 30): 31 null
      // try (32 -> 34): 31 null
   }

   public abstract boolean b(JobParameters var1);

   protected final void dump(FileDescriptor var1, PrintWriter var2, String[] var3) {
      super.dump(var1, var2, var3);
   }

   public final IBinder onBind(Intent var1) {
      return this.c;
   }

   public final void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
   }

   public final void onRebind(Intent var1) {
      super.onRebind(var1);
   }

   public final void onStart(Intent var1, int var2) {
   }

   public final int onStartCommand(Intent var1, int var2, int var3) {
      this.stopSelf(var3);
      return 2;
   }

   public final void onTaskRemoved(Intent var1) {
      super.onTaskRemoved(var1);
   }

   public final boolean onUnbind(Intent param1) {
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
      // 01: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 0d: invokevirtual android/support/v4/util/SimpleArrayMap.size ()I
      // 10: bipush 1
      // 11: isub
      // 12: istore 2
      // 13: iload 2
      // 14: iflt 4f
      // 17: aload 0
      // 18: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 1b: aload 0
      // 1c: getfield com/firebase/jobdispatcher/JobService.b Landroid/support/v4/util/SimpleArrayMap;
      // 1f: iload 2
      // 20: invokevirtual android/support/v4/util/SimpleArrayMap.b (I)Ljava/lang/Object;
      // 23: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 26: checkcast com/firebase/jobdispatcher/JobService$JobCallback
      // 29: astore 5
      // 2b: aload 5
      // 2d: ifnull 44
      // 30: aload 0
      // 31: aload 5
      // 33: getfield com/firebase/jobdispatcher/JobService$JobCallback.a Lcom/firebase/jobdispatcher/JobParameters;
      // 36: invokevirtual com/firebase/jobdispatcher/JobService.b (Lcom/firebase/jobdispatcher/JobParameters;)Z
      // 39: ifeq 4a
      // 3c: bipush 1
      // 3d: istore 3
      // 3e: aload 5
      // 40: iload 3
      // 41: invokevirtual com/firebase/jobdispatcher/JobService$JobCallback.a (I)V
      // 44: iinc 2 -1
      // 47: goto 13
      // 4a: bipush 2
      // 4b: istore 3
      // 4c: goto 3e
      // 4f: aload 4
      // 51: monitorexit
      // 52: aload 0
      // 53: aload 1
      // 54: invokespecial android/app/Service.onUnbind (Landroid/content/Intent;)Z
      // 57: ireturn
      // 58: astore 1
      // 59: aload 4
      // 5b: monitorexit
      // 5c: aload 1
      // 5d: athrow
      // try (5 -> 11): 45 null
      // try (13 -> 22): 45 null
      // try (24 -> 29): 45 null
      // try (31 -> 34): 45 null
      // try (39 -> 41): 45 null
      // try (46 -> 48): 45 null
   }

   private static final class JobCallback {
      final JobParameters a;
      final IJobCallback b;

      private JobCallback(JobParameters var1, IJobCallback var2) {
         this.a = var1;
         this.b = var2;
      }

      void a(int var1) {
         try {
            IJobCallback var5 = this.b;
            JobCoder var3 = GooglePlayReceiver.b();
            JobParameters var4 = this.a;
            Bundle var2 = new Bundle();
            var5.a(var3.a(var4, var2), var1);
         } catch (RemoteException var6) {
            Log.e("FJD.JobService", "Failed to send result to driver", var6);
         }
      }
   }
}
