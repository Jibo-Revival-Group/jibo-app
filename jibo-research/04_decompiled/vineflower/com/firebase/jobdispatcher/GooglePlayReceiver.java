package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Build.VERSION;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.util.Pair;

public class GooglePlayReceiver extends Service implements ExecutionDelegator.JobFinishedCallback {
   private static final JobCoder d = new JobCoder("com.firebase.jobdispatcher.");
   private static final SimpleArrayMap<String, SimpleArrayMap<String, JobCallback>> h = new SimpleArrayMap<>(1);
   Messenger a;
   Driver b;
   ValidationEnforcer c;
   private final GooglePlayCallbackExtractor e = new GooglePlayCallbackExtractor();
   private ExecutionDelegator f;
   private int g;

   static void a(Job param0) {
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
      // 00: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 09: aload 0
      // 0a: invokevirtual com/firebase/jobdispatcher/Job.i ()Ljava/lang/String;
      // 0d: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 10: checkcast android/support/v4/util/SimpleArrayMap
      // 13: astore 2
      // 14: aload 2
      // 15: ifnonnull 1b
      // 18: aload 1
      // 19: monitorexit
      // 1a: return
      // 1b: aload 2
      // 1c: aload 0
      // 1d: invokevirtual com/firebase/jobdispatcher/Job.e ()Ljava/lang/String;
      // 20: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 23: checkcast com/firebase/jobdispatcher/JobCallback
      // 26: ifnonnull 33
      // 29: aload 1
      // 2a: monitorexit
      // 2b: goto 1a
      // 2e: astore 0
      // 2f: aload 1
      // 30: monitorexit
      // 31: aload 0
      // 32: athrow
      // 33: new com/firebase/jobdispatcher/JobInvocation$Builder
      // 36: astore 2
      // 37: aload 2
      // 38: invokespecial com/firebase/jobdispatcher/JobInvocation$Builder.<init> ()V
      // 3b: aload 2
      // 3c: aload 0
      // 3d: invokevirtual com/firebase/jobdispatcher/Job.e ()Ljava/lang/String;
      // 40: invokevirtual com/firebase/jobdispatcher/JobInvocation$Builder.a (Ljava/lang/String;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
      // 43: aload 0
      // 44: invokevirtual com/firebase/jobdispatcher/Job.i ()Ljava/lang/String;
      // 47: invokevirtual com/firebase/jobdispatcher/JobInvocation$Builder.b (Ljava/lang/String;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
      // 4a: aload 0
      // 4b: invokevirtual com/firebase/jobdispatcher/Job.f ()Lcom/firebase/jobdispatcher/JobTrigger;
      // 4e: invokevirtual com/firebase/jobdispatcher/JobInvocation$Builder.a (Lcom/firebase/jobdispatcher/JobTrigger;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
      // 51: invokevirtual com/firebase/jobdispatcher/JobInvocation$Builder.a ()Lcom/firebase/jobdispatcher/JobInvocation;
      // 54: bipush 0
      // 55: invokestatic com/firebase/jobdispatcher/ExecutionDelegator.a (Lcom/firebase/jobdispatcher/JobInvocation;Z)V
      // 58: aload 1
      // 59: monitorexit
      // 5a: goto 1a
      // try (4 -> 10): 24 null
      // try (12 -> 14): 24 null
      // try (15 -> 23): 24 null
      // try (25 -> 27): 24 null
      // try (29 -> 48): 24 null
   }

   private static void a(JobCallback var0, int var1) {
      try {
         var0.a(var1);
      } catch (Throwable var2) {
         Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", var2.getCause());
      }
   }

   private void a(JobInvocation var1) {
      Job var2 = new Job.Builder(this.e(), var1).a(true).j();
      this.d().a(var2);
   }

   private static boolean a(JobParameters var0, int var1) {
      boolean var2 = true;
      if (!var0.h() || !(var0.f() instanceof JobTrigger.ContentUriTrigger) || var1 == 1) {
         var2 = false;
      }

      return var2;
   }

   static JobCoder b() {
      return d;
   }

   private Messenger c() {
      synchronized (this) {
         if (this.a == null) {
            GooglePlayMessageHandler var1 = new GooglePlayMessageHandler(Looper.getMainLooper(), this);
            Messenger var2 = new Messenger(var1);
            this.a = var2;
         }

         return this.a;
      }
   }

   private Driver d() {
      synchronized (this) {
         if (this.b == null) {
            GooglePlayDriver var1 = new GooglePlayDriver(this.getApplicationContext());
            this.b = var1;
         }

         return this.b;
      }
   }

   private ValidationEnforcer e() {
      synchronized (this) {
         if (this.c == null) {
            ValidationEnforcer var1 = new ValidationEnforcer(this.d().a());
            this.c = var1;
         }

         return this.c;
      }
   }

   ExecutionDelegator a() {
      synchronized (this) {
         if (this.f == null) {
            ExecutionDelegator var1 = new ExecutionDelegator(this, this);
            this.f = var1;
         }

         return this.f;
      }
   }

   JobInvocation a(Intent var1) {
      Object var2 = null;
      Bundle var3 = var1.getExtras();
      JobInvocation var4;
      if (var3 == null) {
         Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
         var4 = (JobInvocation)var2;
      } else {
         Pair var5 = this.e.a(var3);
         if (var5 == null) {
            Log.i("FJD.GooglePlayReceiver", "no callback found");
            var4 = (JobInvocation)var2;
         } else {
            var4 = this.a((JobCallback)var5.first, (Bundle)var5.second);
         }
      }

      return var4;
   }

   JobInvocation a(JobCallback param1, Bundle param2) {
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
      // 00: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.d Lcom/firebase/jobdispatcher/JobCoder;
      // 03: aload 2
      // 04: invokevirtual com/firebase/jobdispatcher/JobCoder.a (Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation;
      // 07: astore 3
      // 08: aload 3
      // 09: ifnonnull 1d
      // 0c: ldc "FJD.GooglePlayReceiver"
      // 0e: ldc "unable to decode job"
      // 10: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 13: pop
      // 14: aload 1
      // 15: bipush 2
      // 16: invokestatic com/firebase/jobdispatcher/GooglePlayReceiver.a (Lcom/firebase/jobdispatcher/JobCallback;I)V
      // 19: aconst_null
      // 1a: astore 1
      // 1b: aload 1
      // 1c: areturn
      // 1d: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 20: astore 5
      // 22: aload 5
      // 24: monitorenter
      // 25: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 28: aload 3
      // 29: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 2c: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 2f: checkcast android/support/v4/util/SimpleArrayMap
      // 32: astore 4
      // 34: aload 4
      // 36: astore 2
      // 37: aload 4
      // 39: ifnonnull 51
      // 3c: new android/support/v4/util/SimpleArrayMap
      // 3f: astore 2
      // 40: aload 2
      // 41: bipush 1
      // 42: invokespecial android/support/v4/util/SimpleArrayMap.<init> (I)V
      // 45: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 48: aload 3
      // 49: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 4c: aload 2
      // 4d: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 50: pop
      // 51: aload 2
      // 52: aload 3
      // 53: invokevirtual com/firebase/jobdispatcher/JobInvocation.e ()Ljava/lang/String;
      // 56: aload 1
      // 57: invokevirtual android/support/v4/util/SimpleArrayMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 5a: pop
      // 5b: aload 5
      // 5d: monitorexit
      // 5e: aload 3
      // 5f: astore 1
      // 60: goto 1b
      // 63: astore 1
      // 64: aload 5
      // 66: monitorexit
      // 67: aload 1
      // 68: athrow
      // try (21 -> 27): 53 null
      // try (31 -> 42): 53 null
      // try (42 -> 50): 53 null
      // try (54 -> 56): 53 null
   }

   @Override
   public void a(JobInvocation param1, int param2) {
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
      // 00: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 03: astore 3
      // 04: aload 3
      // 05: monitorenter
      // 06: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 09: aload 1
      // 0a: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 0d: invokevirtual android/support/v4/util/SimpleArrayMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 10: checkcast android/support/v4/util/SimpleArrayMap
      // 13: astore 5
      // 15: aload 5
      // 17: ifnonnull 2e
      // 1a: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 1d: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 20: ifeq 2b
      // 23: aload 0
      // 24: aload 0
      // 25: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 28: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 2b: aload 3
      // 2c: monitorexit
      // 2d: return
      // 2e: aload 5
      // 30: aload 1
      // 31: invokevirtual com/firebase/jobdispatcher/JobInvocation.e ()Ljava/lang/String;
      // 34: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 37: checkcast com/firebase/jobdispatcher/JobCallback
      // 3a: astore 4
      // 3c: aload 4
      // 3e: ifnonnull 5c
      // 41: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 44: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 47: ifeq 52
      // 4a: aload 0
      // 4b: aload 0
      // 4c: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 4f: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 52: aload 3
      // 53: monitorexit
      // 54: goto 2d
      // 57: astore 1
      // 58: aload 3
      // 59: monitorexit
      // 5a: aload 1
      // 5b: athrow
      // 5c: aload 5
      // 5e: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 61: ifeq 6f
      // 64: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 67: aload 1
      // 68: invokevirtual com/firebase/jobdispatcher/JobInvocation.i ()Ljava/lang/String;
      // 6b: invokevirtual android/support/v4/util/SimpleArrayMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 6e: pop
      // 6f: aload 1
      // 70: iload 2
      // 71: invokestatic com/firebase/jobdispatcher/GooglePlayReceiver.a (Lcom/firebase/jobdispatcher/JobParameters;I)Z
      // 74: ifeq 92
      // 77: aload 0
      // 78: aload 1
      // 79: invokespecial com/firebase/jobdispatcher/GooglePlayReceiver.a (Lcom/firebase/jobdispatcher/JobInvocation;)V
      // 7c: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 7f: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 82: ifeq 8d
      // 85: aload 0
      // 86: aload 0
      // 87: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 8a: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 8d: aload 3
      // 8e: monitorexit
      // 8f: goto 2d
      // 92: ldc "FJD.GooglePlayReceiver"
      // 94: bipush 2
      // 95: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 98: ifeq c7
      // 9b: new java/lang/StringBuilder
      // 9e: astore 5
      // a0: aload 5
      // a2: invokespecial java/lang/StringBuilder.<init> ()V
      // a5: ldc "FJD.GooglePlayReceiver"
      // a7: aload 5
      // a9: ldc_w "sending jobFinished for "
      // ac: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // af: aload 1
      // b0: invokevirtual com/firebase/jobdispatcher/JobInvocation.e ()Ljava/lang/String;
      // b3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b6: ldc_w " = "
      // b9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // bc: iload 2
      // bd: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // c0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // c3: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // c6: pop
      // c7: aload 4
      // c9: iload 2
      // ca: invokestatic com/firebase/jobdispatcher/GooglePlayReceiver.a (Lcom/firebase/jobdispatcher/JobCallback;I)V
      // cd: goto 7c
      // d0: astore 1
      // d1: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // d4: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // d7: ifeq e2
      // da: aload 0
      // db: aload 0
      // dc: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // df: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // e2: aload 1
      // e3: athrow
      // try (4 -> 10): 96 null
      // try (12 -> 19): 40 null
      // try (19 -> 21): 40 null
      // try (22 -> 28): 96 null
      // try (30 -> 37): 40 null
      // try (37 -> 39): 40 null
      // try (41 -> 43): 40 null
      // try (45 -> 53): 96 null
      // try (53 -> 60): 96 null
      // try (60 -> 67): 40 null
      // try (67 -> 69): 40 null
      // try (70 -> 92): 96 null
      // try (92 -> 95): 96 null
      // try (97 -> 104): 40 null
      // try (104 -> 106): 40 null
   }

   public IBinder onBind(Intent var1) {
      IBinder var2;
      if (var1 != null && VERSION.SDK_INT >= 21 && "com.google.android.gms.gcm.ACTION_TASK_READY".equals(var1.getAction())) {
         var2 = this.c().getBinder();
      } else {
         var2 = null;
      }

      return var2;
   }

   public final int onStartCommand(Intent param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: aload 1
      // 002: iload 2
      // 003: iload 3
      // 004: invokespecial android/app/Service.onStartCommand (Landroid/content/Intent;II)I
      // 007: pop
      // 008: aload 1
      // 009: ifnonnull 03c
      // 00c: ldc "FJD.GooglePlayReceiver"
      // 00e: ldc_w "Null Intent passed, terminating"
      // 011: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 014: pop
      // 015: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 018: astore 1
      // 019: aload 1
      // 01a: monitorenter
      // 01b: aload 0
      // 01c: iload 3
      // 01d: putfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 020: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 023: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 026: ifeq 031
      // 029: aload 0
      // 02a: aload 0
      // 02b: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 02e: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 031: aload 1
      // 032: monitorexit
      // 033: bipush 2
      // 034: ireturn
      // 035: astore 5
      // 037: aload 1
      // 038: monitorexit
      // 039: aload 5
      // 03b: athrow
      // 03c: aload 1
      // 03d: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 040: astore 5
      // 042: ldc_w "com.google.android.gms.gcm.ACTION_TASK_READY"
      // 045: aload 5
      // 047: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 04a: ifeq 083
      // 04d: aload 0
      // 04e: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.a ()Lcom/firebase/jobdispatcher/ExecutionDelegator;
      // 051: aload 0
      // 052: aload 1
      // 053: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.a (Landroid/content/Intent;)Lcom/firebase/jobdispatcher/JobInvocation;
      // 056: invokevirtual com/firebase/jobdispatcher/ExecutionDelegator.a (Lcom/firebase/jobdispatcher/JobInvocation;)V
      // 059: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 05c: astore 5
      // 05e: aload 5
      // 060: monitorenter
      // 061: aload 0
      // 062: iload 3
      // 063: putfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 066: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 069: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 06c: ifeq 077
      // 06f: aload 0
      // 070: aload 0
      // 071: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 074: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 077: aload 5
      // 079: monitorexit
      // 07a: goto 033
      // 07d: astore 1
      // 07e: aload 5
      // 080: monitorexit
      // 081: aload 1
      // 082: athrow
      // 083: ldc_w "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE"
      // 086: aload 5
      // 088: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 08b: istore 4
      // 08d: iload 4
      // 08f: ifeq 0ba
      // 092: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 095: astore 1
      // 096: aload 1
      // 097: monitorenter
      // 098: aload 0
      // 099: iload 3
      // 09a: putfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 09d: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 0a0: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 0a3: ifeq 0ae
      // 0a6: aload 0
      // 0a7: aload 0
      // 0a8: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 0ab: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 0ae: aload 1
      // 0af: monitorexit
      // 0b0: goto 033
      // 0b3: astore 5
      // 0b5: aload 1
      // 0b6: monitorexit
      // 0b7: aload 5
      // 0b9: athrow
      // 0ba: ldc "FJD.GooglePlayReceiver"
      // 0bc: ldc_w "Unknown action received, terminating"
      // 0bf: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 0c2: pop
      // 0c3: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 0c6: astore 1
      // 0c7: aload 1
      // 0c8: monitorenter
      // 0c9: aload 0
      // 0ca: iload 3
      // 0cb: putfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 0ce: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 0d1: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 0d4: ifeq 0df
      // 0d7: aload 0
      // 0d8: aload 0
      // 0d9: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 0dc: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 0df: aload 1
      // 0e0: monitorexit
      // 0e1: goto 033
      // 0e4: astore 5
      // 0e6: aload 1
      // 0e7: monitorexit
      // 0e8: aload 5
      // 0ea: athrow
      // 0eb: astore 5
      // 0ed: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 0f0: astore 1
      // 0f1: aload 1
      // 0f2: monitorenter
      // 0f3: aload 0
      // 0f4: iload 3
      // 0f5: putfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 0f8: getstatic com/firebase/jobdispatcher/GooglePlayReceiver.h Landroid/support/v4/util/SimpleArrayMap;
      // 0fb: invokevirtual android/support/v4/util/SimpleArrayMap.isEmpty ()Z
      // 0fe: ifeq 109
      // 101: aload 0
      // 102: aload 0
      // 103: getfield com/firebase/jobdispatcher/GooglePlayReceiver.g I
      // 106: invokevirtual com/firebase/jobdispatcher/GooglePlayReceiver.stopSelf (I)V
      // 109: aload 1
      // 10a: monitorexit
      // 10b: aload 5
      // 10d: athrow
      // 10e: astore 5
      // 110: aload 1
      // 111: monitorexit
      // 112: aload 5
      // 114: athrow
      // try (0 -> 6): 124 null
      // try (8 -> 12): 124 null
      // try (16 -> 26): 30 null
      // try (26 -> 28): 30 null
      // try (31 -> 33): 30 null
      // try (35 -> 48): 124 null
      // try (52 -> 62): 65 null
      // try (62 -> 64): 65 null
      // try (66 -> 68): 65 null
      // try (70 -> 74): 124 null
      // try (80 -> 90): 93 null
      // try (90 -> 92): 93 null
      // try (94 -> 96): 93 null
      // try (98 -> 102): 124 null
      // try (106 -> 116): 119 null
      // try (116 -> 118): 119 null
      // try (120 -> 122): 119 null
      // try (129 -> 139): 143 null
      // try (139 -> 141): 143 null
      // try (144 -> 146): 143 null
   }
}
