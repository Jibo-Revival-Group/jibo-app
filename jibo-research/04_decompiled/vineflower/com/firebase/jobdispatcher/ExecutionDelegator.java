package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

class ExecutionDelegator {
   private static final SimpleArrayMap<String, JobServiceConnection> a = new SimpleArrayMap<>();
   private final IJobCallback b = new IJobCallback.Stub(this) {
      final ExecutionDelegator a;

      {
         this.a = var1;
      }

      @Override
      public void a(Bundle var1, int var2) {
         JobInvocation.Builder var3 = GooglePlayReceiver.b().b(var1);
         if (var3 == null) {
            Log.wtf("FJD.ExternalReceiver", "jobFinished: unknown invocation provided");
         } else {
            this.a.a(var3.a(), var2);
         }
      }
   };
   private final Context c;
   private final ExecutionDelegator.JobFinishedCallback d;

   ExecutionDelegator(Context var1, ExecutionDelegator.JobFinishedCallback var2) {
      this.c = var1;
      this.d = var2;
   }

   private Intent a(JobParameters var1) {
      Intent var2 = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
      var2.setClassName(this.c, var1.i());
      return var2;
   }

   private void a(JobInvocation param1, int param2) {
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
      // 00: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 03: astore 3
      // 04: aload 3
      // 05: monitorenter
      // 06: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 09: aload 1
      // 0a: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 0d: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 10: checkcast com/firebase/jobdispatcher/JobServiceConnection
      // 13: astore 4
      // 15: aload 4
      // 17: ifnull 33
      // 1a: aload 4
      // 1c: aload 1
      // 1d: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a (Lcom/firebase/jobdispatcher/JobInvocation;)V
      // 20: aload 4
      // 22: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a ()Z
      // 25: ifeq 33
      // 28: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 2b: aload 1
      // 2c: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 2f: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 32: pop
      // 33: aload 3
      // 34: monitorexit
      // 35: aload 0
      // 36: getfield com/firebase/jobdispatcher/ExecutionDelegator.d Lcom/firebase/jobdispatcher/ExecutionDelegator$JobFinishedCallback;
      // 39: aload 1
      // 3a: iload 2
      // 3b: invokeinterface com/firebase/jobdispatcher/ExecutionDelegator$JobFinishedCallback.a (Lcom/firebase/jobdispatcher/JobInvocation;I)V 3
      // 40: return
      // 41: astore 1
      // 42: aload 3
      // 43: monitorexit
      // 44: aload 1
      // 45: athrow
      // try (4 -> 10): 31 null
      // try (12 -> 23): 31 null
      // try (23 -> 25): 31 null
      // try (32 -> 34): 31 null
   }

   static void a(JobInvocation param0, boolean param1) {
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
      // 00: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 09: aload 0
      // 0a: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 0d: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 10: checkcast com/firebase/jobdispatcher/JobServiceConnection
      // 13: astore 3
      // 14: aload 3
      // 15: ifnull 30
      // 18: aload 3
      // 19: aload 0
      // 1a: iload 1
      // 1b: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a (Lcom/firebase/jobdispatcher/JobInvocation;Z)V
      // 1e: aload 3
      // 1f: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a ()Z
      // 22: ifeq 30
      // 25: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 28: aload 0
      // 29: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 2c: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 2f: pop
      // 30: aload 2
      // 31: monitorexit
      // 32: return
      // 33: astore 0
      // 34: aload 2
      // 35: monitorexit
      // 36: aload 0
      // 37: athrow
      // try (4 -> 10): 27 null
      // try (12 -> 24): 27 null
      // try (24 -> 26): 27 null
      // try (28 -> 30): 27 null
   }

   void a(JobInvocation param1) {
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
      // 01: ifnonnull 05
      // 04: return
      // 05: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 08: astore 4
      // 0a: aload 4
      // 0c: monitorenter
      // 0d: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 10: aload 1
      // 11: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 14: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 17: checkcast com/firebase/jobdispatcher/JobServiceConnection
      // 1a: astore 3
      // 1b: aload 3
      // 1c: ifnull 45
      // 1f: aload 3
      // 20: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a ()Z
      // 23: ifne 45
      // 26: aload 3
      // 27: astore 2
      // 28: aload 3
      // 29: aload 1
      // 2a: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.c (Lcom/firebase/jobdispatcher/JobInvocation;)Z
      // 2d: ifeq 61
      // 30: aload 3
      // 31: astore 2
      // 32: aload 3
      // 33: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.b ()Z
      // 36: ifne 61
      // 39: aload 4
      // 3b: monitorexit
      // 3c: goto 04
      // 3f: astore 1
      // 40: aload 4
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: new com/firebase/jobdispatcher/JobServiceConnection
      // 48: astore 2
      // 49: aload 2
      // 4a: aload 0
      // 4b: getfield com/firebase/jobdispatcher/ExecutionDelegator.b Lcom/firebase/jobdispatcher/IJobCallback;
      // 4e: aload 0
      // 4f: getfield com/firebase/jobdispatcher/ExecutionDelegator.c Landroid/content/Context;
      // 52: invokespecial com/firebase/jobdispatcher/JobServiceConnection.<init> (Lcom/firebase/jobdispatcher/IJobCallback;Landroid/content/Context;)V
      // 55: getstatic com/firebase/jobdispatcher/ExecutionDelegator.a Landroid/support/v4/util/SimpleArrayMap;
      // 58: aload 1
      // 59: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 5c: aload 2
      // 5d: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 60: pop
      // 61: aload 2
      // 62: aload 1
      // 63: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.b (Lcom/firebase/jobdispatcher/JobInvocation;)Z
      // 66: ifne 9c
      // 69: aload 0
      // 6a: getfield com/firebase/jobdispatcher/ExecutionDelegator.c Landroid/content/Context;
      // 6d: aload 0
      // 6e: aload 1
      // 6f: invokespecial com/firebase/jobdispatcher/ExecutionDelegator.a (Lcom/firebase/jobdispatcher/JobParameters;)Landroid/content/Intent;
      // 72: aload 2
      // 73: bipush 1
      // 74: invokevirtual android/content/Context.bindService (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      // 77: ifne 9c
      // 7a: new java/lang/StringBuilder
      // 7d: astore 3
      // 7e: aload 3
      // 7f: invokespecial java/lang/StringBuilder.<init> ()V
      // 82: ldc "FJD.ExternalReceiver"
      // 84: aload 3
      // 85: ldc "Unable to bind to "
      // 87: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 8a: aload 1
      // 8b: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 8e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 91: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 94: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 97: pop
      // 98: aload 2
      // 99: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.c ()V
      // 9c: aload 4
      // 9e: monitorexit
      // 9f: goto 04
      // try (7 -> 13): 32 null
      // try (15 -> 18): 32 null
      // try (20 -> 24): 32 null
      // try (26 -> 31): 32 null
      // try (33 -> 35): 32 null
      // try (37 -> 51): 32 null
      // try (51 -> 80): 32 null
      // try (80 -> 82): 32 null
   }

   interface JobFinishedCallback {
      void a(JobInvocation var1, int var2);
   }
}
