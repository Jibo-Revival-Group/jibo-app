package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

class JobServiceConnection implements ServiceConnection {
   private final Map<JobInvocation, Boolean> a = new HashMap<>();
   private final IJobCallback b;
   private final Context c;
   private boolean d = false;
   private IRemoteJobService e;

   JobServiceConnection(IJobCallback var1, Context var2) {
      this.b = var1;
      this.c = var2;
   }

   private static Bundle a(JobParameters var0) {
      return GooglePlayReceiver.b().a(var0, new Bundle());
   }

   private void a(boolean var1, JobInvocation var2) {
      synchronized (this) {
         try {
            this.e.a(a((JobParameters)var2), var1);
         } catch (RemoteException var5) {
            Log.e("FJD.ExternalReceiver", "Failed to stop a job", var5);
            this.c();
         }
      }
   }

   void a(JobInvocation var1) {
      synchronized (this) {
         this.a.remove(var1);
         if (this.a.isEmpty()) {
            this.c();
         }
      }
   }

   void a(JobInvocation param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a ()Z
      // 06: ifne 40
      // 09: getstatic java/lang/Boolean.TRUE Ljava/lang/Boolean;
      // 0c: aload 0
      // 0d: getfield com/firebase/jobdispatcher/JobServiceConnection.a Ljava/util/Map;
      // 10: aload 1
      // 11: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 16: invokevirtual java/lang/Boolean.equals (Ljava/lang/Object;)Z
      // 19: ifeq 29
      // 1c: aload 0
      // 1d: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.b ()Z
      // 20: ifeq 29
      // 23: aload 0
      // 24: iload 2
      // 25: aload 1
      // 26: invokespecial com/firebase/jobdispatcher/JobServiceConnection.a (ZLcom/firebase/jobdispatcher/JobInvocation;)V
      // 29: iload 2
      // 2a: ifne 3d
      // 2d: aload 0
      // 2e: getfield com/firebase/jobdispatcher/JobServiceConnection.a Ljava/util/Map;
      // 31: invokeinterface java/util/Map.isEmpty ()Z 1
      // 36: ifeq 3d
      // 39: aload 0
      // 3a: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.c ()V
      // 3d: aload 0
      // 3e: monitorexit
      // 3f: return
      // 40: ldc "FJD.ExternalReceiver"
      // 42: ldc "Can't send stop request because service was unbound."
      // 44: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 47: pop
      // 48: goto 3d
      // 4b: astore 1
      // 4c: aload 0
      // 4d: monitorexit
      // 4e: aload 1
      // 4f: athrow
      // try (2 -> 19): 35 null
      // try (21 -> 27): 35 null
      // try (30 -> 34): 35 null
   }

   boolean a() {
      synchronized (this) {
         return this.d;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   boolean b() {
      synchronized (this){} // $VF: monitorenter 
      boolean var4 = false /* VF: Semaphore variable */;

      IRemoteJobService var2;
      try {
         var4 = true;
         var2 = this.e;
         var4 = false;
      } finally {
         if (var4) {
            // $VF: monitorexit
         }
      }

      boolean var1;
      if (var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      // $VF: monitorexit
      return var1;
   }

   boolean b(JobInvocation param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.b ()Z
      // 06: istore 2
      // 07: iload 2
      // 08: ifeq 55
      // 0b: aload 0
      // 0c: getfield com/firebase/jobdispatcher/JobServiceConnection.a Ljava/util/Map;
      // 0f: aload 1
      // 10: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 15: checkcast java/lang/Boolean
      // 18: astore 3
      // 19: getstatic java/lang/Boolean.TRUE Ljava/lang/Boolean;
      // 1c: aload 3
      // 1d: invokevirtual java/lang/Boolean.equals (Ljava/lang/Object;)Z
      // 20: ifeq 44
      // 23: new java/lang/StringBuilder
      // 26: astore 3
      // 27: aload 3
      // 28: invokespecial java/lang/StringBuilder.<init> ()V
      // 2b: ldc "FJD.ExternalReceiver"
      // 2d: aload 3
      // 2e: ldc "Received an execution request for already running job "
      // 30: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 33: aload 1
      // 34: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 37: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3a: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 3d: pop
      // 3e: aload 0
      // 3f: bipush 0
      // 40: aload 1
      // 41: invokespecial com/firebase/jobdispatcher/JobServiceConnection.a (ZLcom/firebase/jobdispatcher/JobInvocation;)V
      // 44: aload 0
      // 45: getfield com/firebase/jobdispatcher/JobServiceConnection.e Lcom/firebase/jobdispatcher/IRemoteJobService;
      // 48: aload 1
      // 49: invokestatic com/firebase/jobdispatcher/JobServiceConnection.a (Lcom/firebase/jobdispatcher/JobParameters;)Landroid/os/Bundle;
      // 4c: aload 0
      // 4d: getfield com/firebase/jobdispatcher/JobServiceConnection.b Lcom/firebase/jobdispatcher/IJobCallback;
      // 50: invokeinterface com/firebase/jobdispatcher/IRemoteJobService.a (Landroid/os/Bundle;Lcom/firebase/jobdispatcher/IJobCallback;)V 3
      // 55: aload 0
      // 56: getfield com/firebase/jobdispatcher/JobServiceConnection.a Ljava/util/Map;
      // 59: aload 1
      // 5a: iload 2
      // 5b: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 5e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 63: pop
      // 64: aload 0
      // 65: monitorexit
      // 66: iload 2
      // 67: ireturn
      // 68: astore 4
      // 6a: new java/lang/StringBuilder
      // 6d: astore 3
      // 6e: aload 3
      // 6f: invokespecial java/lang/StringBuilder.<init> ()V
      // 72: ldc "FJD.ExternalReceiver"
      // 74: aload 3
      // 75: ldc "Failed to start the job "
      // 77: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7a: aload 1
      // 7b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 7e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 81: aload 4
      // 83: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 86: pop
      // 87: aload 0
      // 88: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.c ()V
      // 8b: bipush 0
      // 8c: istore 2
      // 8d: goto 64
      // 90: astore 1
      // 91: aload 0
      // 92: monitorexit
      // 93: aload 1
      // 94: athrow
      // try (2 -> 5): 72 null
      // try (7 -> 34): 72 null
      // try (34 -> 41): 52 android/os/RemoteException
      // try (34 -> 41): 72 null
      // try (41 -> 48): 72 null
      // try (53 -> 69): 72 null
   }

   void c() {
      synchronized (this) {
         if (!this.a()) {
            this.e = null;
            this.d = true;

            try {
               this.c.unbindService(this);
            } catch (IllegalArgumentException var5) {
               StringBuilder var1 = new StringBuilder();
               Log.w("FJD.ExternalReceiver", var1.append("Error unbinding service: ").append(var5.getMessage()).toString());
            }
         }
      }
   }

   boolean c(JobInvocation var1) {
      synchronized (this) {
         return this.a.containsKey(var1);
      }
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.a ()Z
      // 06: ifeq 14
      // 09: ldc "FJD.ExternalReceiver"
      // 0b: ldc "Connection have been used already."
      // 0d: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 10: pop
      // 11: aload 0
      // 12: monitorexit
      // 13: return
      // 14: aload 0
      // 15: aload 2
      // 16: invokestatic com/firebase/jobdispatcher/IRemoteJobService$Stub.a (Landroid/os/IBinder;)Lcom/firebase/jobdispatcher/IRemoteJobService;
      // 19: putfield com/firebase/jobdispatcher/JobServiceConnection.e Lcom/firebase/jobdispatcher/IRemoteJobService;
      // 1c: new java/util/HashSet
      // 1f: astore 2
      // 20: aload 2
      // 21: invokespecial java/util/HashSet.<init> ()V
      // 24: aload 0
      // 25: getfield com/firebase/jobdispatcher/JobServiceConnection.a Ljava/util/Map;
      // 28: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 2d: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 32: astore 4
      // 34: aload 4
      // 36: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3b: ifeq b3
      // 3e: aload 4
      // 40: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 45: checkcast java/util/Map$Entry
      // 48: astore 1
      // 49: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 4c: aload 1
      // 4d: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 52: invokevirtual java/lang/Boolean.equals (Ljava/lang/Object;)Z
      // 55: istore 3
      // 56: iload 3
      // 57: ifeq 34
      // 5a: aload 0
      // 5b: getfield com/firebase/jobdispatcher/JobServiceConnection.e Lcom/firebase/jobdispatcher/IRemoteJobService;
      // 5e: aload 1
      // 5f: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 64: checkcast com/firebase/jobdispatcher/JobParameters
      // 67: invokestatic com/firebase/jobdispatcher/JobServiceConnection.a (Lcom/firebase/jobdispatcher/JobParameters;)Landroid/os/Bundle;
      // 6a: aload 0
      // 6b: getfield com/firebase/jobdispatcher/JobServiceConnection.b Lcom/firebase/jobdispatcher/IJobCallback;
      // 6e: invokeinterface com/firebase/jobdispatcher/IRemoteJobService.a (Landroid/os/Bundle;Lcom/firebase/jobdispatcher/IJobCallback;)V 3
      // 73: aload 2
      // 74: aload 1
      // 75: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 7a: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 7f: pop
      // 80: goto 34
      // 83: astore 4
      // 85: new java/lang/StringBuilder
      // 88: astore 2
      // 89: aload 2
      // 8a: invokespecial java/lang/StringBuilder.<init> ()V
      // 8d: ldc "FJD.ExternalReceiver"
      // 8f: aload 2
      // 90: ldc "Failed to start job "
      // 92: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 95: aload 1
      // 96: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 9b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 9e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a1: aload 4
      // a3: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // a6: pop
      // a7: aload 0
      // a8: invokevirtual com/firebase/jobdispatcher/JobServiceConnection.c ()V
      // ab: goto 11
      // ae: astore 1
      // af: aload 0
      // b0: monitorexit
      // b1: aload 1
      // b2: athrow
      // b3: aload 2
      // b4: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // b9: astore 1
      // ba: aload 1
      // bb: invokeinterface java/util/Iterator.hasNext ()Z 1
      // c0: ifeq 11
      // c3: aload 1
      // c4: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // c9: checkcast com/firebase/jobdispatcher/JobInvocation
      // cc: astore 2
      // cd: aload 0
      // ce: getfield com/firebase/jobdispatcher/JobServiceConnection.a Ljava/util/Map;
      // d1: aload 2
      // d2: bipush 1
      // d3: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // d6: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // db: pop
      // dc: goto ba
      // try (2 -> 9): 73 null
      // try (12 -> 25): 73 null
      // try (25 -> 37): 73 null
      // try (39 -> 53): 54 android/os/RemoteException
      // try (39 -> 53): 73 null
      // try (55 -> 72): 73 null
      // try (78 -> 81): 73 null
      // try (81 -> 95): 73 null
   }

   public void onServiceDisconnected(ComponentName var1) {
      synchronized (this) {
         this.c();
      }
   }
}
