package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

final class zzk implements ServiceConnection {
   int a;
   final Messenger b;
   zzp c;
   final Queue<zzr<?>> d;
   final SparseArray<zzr<?>> e;
   final zzi f;

   private zzk(zzi var1) {
      this.f = var1;
      this.a = 0;
      this.b = new Messenger(new Handler(Looper.getMainLooper(), new zzl(this)));
      this.d = new ArrayDeque<>();
      this.e = new SparseArray();
   }

   private final void a(zzs var1) {
      Iterator var3 = this.d.iterator();

      while (var3.hasNext()) {
         ((zzr)var3.next()).a(var1);
      }

      this.d.clear();

      for (int var2 = 0; var2 < this.e.size(); var2++) {
         ((zzr)this.e.valueAt(var2)).a(var1);
      }

      this.e.clear();
   }

   private final void c() {
      zzi.b(this.f).execute(new zzn(this));
   }

   final void a() {
      synchronized (this) {
         if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
               Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }

            this.a = 3;
            com.google.android.gms.common.stats.zza.a();
            zzi.a(this.f).unbindService(this);
         }
      }
   }

   final void a(int param1) {
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
      // 03: getfield com/google/firebase/iid/zzk.e Landroid/util/SparseArray;
      // 06: iload 1
      // 07: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 0a: checkcast com/google/firebase/iid/zzr
      // 0d: astore 2
      // 0e: aload 2
      // 0f: ifnull 4b
      // 12: new java/lang/StringBuilder
      // 15: astore 3
      // 16: aload 3
      // 17: bipush 31
      // 19: invokespecial java/lang/StringBuilder.<init> (I)V
      // 1c: ldc "MessengerIpcClient"
      // 1e: aload 3
      // 1f: ldc "Timing out request: "
      // 21: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 24: iload 1
      // 25: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 28: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2b: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 2e: pop
      // 2f: aload 0
      // 30: getfield com/google/firebase/iid/zzk.e Landroid/util/SparseArray;
      // 33: iload 1
      // 34: invokevirtual android/util/SparseArray.remove (I)V
      // 37: new com/google/firebase/iid/zzs
      // 3a: astore 3
      // 3b: aload 3
      // 3c: bipush 3
      // 3d: ldc "Timed out waiting for response"
      // 3f: invokespecial com/google/firebase/iid/zzs.<init> (ILjava/lang/String;)V
      // 42: aload 2
      // 43: aload 3
      // 44: invokevirtual com/google/firebase/iid/zzr.a (Lcom/google/firebase/iid/zzs;)V
      // 47: aload 0
      // 48: invokevirtual com/google/firebase/iid/zzk.a ()V
      // 4b: aload 0
      // 4c: monitorexit
      // 4d: return
      // 4e: astore 2
      // 4f: aload 0
      // 50: monitorexit
      // 51: aload 2
      // 52: athrow
      // try (2 -> 8): 42 null
      // try (10 -> 39): 42 null
   }

   final void a(int param1, String param2) {
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
      // 02: ldc "MessengerIpcClient"
      // 04: bipush 3
      // 05: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 08: ifeq 25
      // 0b: aload 2
      // 0c: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0f: astore 3
      // 10: aload 3
      // 11: invokevirtual java/lang/String.length ()I
      // 14: ifeq 77
      // 17: ldc "Disconnected: "
      // 19: aload 3
      // 1a: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 1d: astore 3
      // 1e: ldc "MessengerIpcClient"
      // 20: aload 3
      // 21: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 24: pop
      // 25: aload 0
      // 26: getfield com/google/firebase/iid/zzk.a I
      // 29: tableswitch 35 0 4 91 101 101 156 153
      // 4c: new java/lang/IllegalStateException
      // 4f: astore 3
      // 50: aload 0
      // 51: getfield com/google/firebase/iid/zzk.a I
      // 54: istore 1
      // 55: new java/lang/StringBuilder
      // 58: astore 2
      // 59: aload 2
      // 5a: bipush 26
      // 5c: invokespecial java/lang/StringBuilder.<init> (I)V
      // 5f: aload 3
      // 60: aload 2
      // 61: ldc "Unknown state: "
      // 63: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 66: iload 1
      // 67: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 6a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 6d: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 70: aload 3
      // 71: athrow
      // 72: astore 2
      // 73: aload 0
      // 74: monitorexit
      // 75: aload 2
      // 76: athrow
      // 77: new java/lang/String
      // 7a: dup
      // 7b: ldc "Disconnected: "
      // 7d: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 80: astore 3
      // 81: goto 1e
      // 84: new java/lang/IllegalStateException
      // 87: astore 2
      // 88: aload 2
      // 89: invokespecial java/lang/IllegalStateException.<init> ()V
      // 8c: aload 2
      // 8d: athrow
      // 8e: ldc "MessengerIpcClient"
      // 90: bipush 2
      // 91: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 94: ifeq 9f
      // 97: ldc "MessengerIpcClient"
      // 99: ldc "Unbinding service"
      // 9b: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 9e: pop
      // 9f: aload 0
      // a0: bipush 4
      // a1: putfield com/google/firebase/iid/zzk.a I
      // a4: invokestatic com/google/android/gms/common/stats/zza.a ()Lcom/google/android/gms/common/stats/zza;
      // a7: pop
      // a8: aload 0
      // a9: getfield com/google/firebase/iid/zzk.f Lcom/google/firebase/iid/zzi;
      // ac: invokestatic com/google/firebase/iid/zzi.a (Lcom/google/firebase/iid/zzi;)Landroid/content/Context;
      // af: aload 0
      // b0: invokevirtual android/content/Context.unbindService (Landroid/content/ServiceConnection;)V
      // b3: new com/google/firebase/iid/zzs
      // b6: astore 3
      // b7: aload 3
      // b8: iload 1
      // b9: aload 2
      // ba: invokespecial com/google/firebase/iid/zzs.<init> (ILjava/lang/String;)V
      // bd: aload 0
      // be: aload 3
      // bf: invokespecial com/google/firebase/iid/zzk.a (Lcom/google/firebase/iid/zzs;)V
      // c2: aload 0
      // c3: monitorexit
      // c4: return
      // c5: aload 0
      // c6: bipush 4
      // c7: putfield com/google/firebase/iid/zzk.a I
      // ca: goto c2
      // try (2 -> 16): 43 null
      // try (16 -> 20): 43 null
      // try (20 -> 23): 43 null
      // try (23 -> 43): 43 null
      // try (48 -> 53): 43 null
      // try (54 -> 60): 43 null
      // try (60 -> 68): 43 null
      // try (68 -> 87): 43 null
      // try (90 -> 93): 43 null
   }

   final boolean a(Message param1) {
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
      // 01: getfield android/os/Message.arg1 I
      // 04: istore 2
      // 05: ldc "MessengerIpcClient"
      // 07: bipush 3
      // 08: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0b: ifeq 29
      // 0e: ldc "MessengerIpcClient"
      // 10: new java/lang/StringBuilder
      // 13: dup
      // 14: bipush 41
      // 16: invokespecial java/lang/StringBuilder.<init> (I)V
      // 19: ldc "Received response to request: "
      // 1b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e: iload 2
      // 1f: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 22: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 25: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 28: pop
      // 29: aload 0
      // 2a: monitorenter
      // 2b: aload 0
      // 2c: getfield com/google/firebase/iid/zzk.e Landroid/util/SparseArray;
      // 2f: iload 2
      // 30: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 33: checkcast com/google/firebase/iid/zzr
      // 36: astore 3
      // 37: aload 3
      // 38: ifnonnull 5c
      // 3b: new java/lang/StringBuilder
      // 3e: astore 1
      // 3f: aload 1
      // 40: bipush 50
      // 42: invokespecial java/lang/StringBuilder.<init> (I)V
      // 45: ldc "MessengerIpcClient"
      // 47: aload 1
      // 48: ldc "Received response for unknown request: "
      // 4a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4d: iload 2
      // 4e: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 51: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 54: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 57: pop
      // 58: aload 0
      // 59: monitorexit
      // 5a: bipush 1
      // 5b: ireturn
      // 5c: aload 0
      // 5d: getfield com/google/firebase/iid/zzk.e Landroid/util/SparseArray;
      // 60: iload 2
      // 61: invokevirtual android/util/SparseArray.remove (I)V
      // 64: aload 0
      // 65: invokevirtual com/google/firebase/iid/zzk.a ()V
      // 68: aload 0
      // 69: monitorexit
      // 6a: aload 1
      // 6b: invokevirtual android/os/Message.getData ()Landroid/os/Bundle;
      // 6e: astore 1
      // 6f: aload 1
      // 70: ldc "unsupported"
      // 72: bipush 0
      // 73: invokevirtual android/os/Bundle.getBoolean (Ljava/lang/String;Z)Z
      // 76: ifeq 8f
      // 79: aload 3
      // 7a: new com/google/firebase/iid/zzs
      // 7d: dup
      // 7e: bipush 4
      // 7f: ldc "Not supported by GmsCore"
      // 81: invokespecial com/google/firebase/iid/zzs.<init> (ILjava/lang/String;)V
      // 84: invokevirtual com/google/firebase/iid/zzr.a (Lcom/google/firebase/iid/zzs;)V
      // 87: goto 5a
      // 8a: astore 1
      // 8b: aload 0
      // 8c: monitorexit
      // 8d: aload 1
      // 8e: athrow
      // 8f: aload 3
      // 90: aload 1
      // 91: invokevirtual com/google/firebase/iid/zzr.a (Landroid/os/Bundle;)V
      // 94: goto 5a
      // try (21 -> 27): 71 null
      // try (29 -> 45): 71 null
      // try (47 -> 55): 71 null
      // try (72 -> 74): 71 null
   }

   final boolean a(zzr param1) {
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
      // 000: bipush 0
      // 001: istore 3
      // 002: bipush 1
      // 003: istore 4
      // 005: aload 0
      // 006: monitorenter
      // 007: aload 0
      // 008: getfield com/google/firebase/iid/zzk.a I
      // 00b: tableswitch 33 0 4 79 216 233 254 254
      // 02c: new java/lang/IllegalStateException
      // 02f: astore 1
      // 030: aload 0
      // 031: getfield com/google/firebase/iid/zzk.a I
      // 034: istore 2
      // 035: new java/lang/StringBuilder
      // 038: astore 5
      // 03a: aload 5
      // 03c: bipush 26
      // 03e: invokespecial java/lang/StringBuilder.<init> (I)V
      // 041: aload 1
      // 042: aload 5
      // 044: ldc "Unknown state: "
      // 046: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 049: iload 2
      // 04a: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 04d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 050: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 053: aload 1
      // 054: athrow
      // 055: astore 1
      // 056: aload 0
      // 057: monitorexit
      // 058: aload 1
      // 059: athrow
      // 05a: aload 0
      // 05b: getfield com/google/firebase/iid/zzk.d Ljava/util/Queue;
      // 05e: aload 1
      // 05f: invokeinterface java/util/Queue.add (Ljava/lang/Object;)Z 2
      // 064: pop
      // 065: aload 0
      // 066: getfield com/google/firebase/iid/zzk.a I
      // 069: ifne 06e
      // 06c: bipush 1
      // 06d: istore 3
      // 06e: iload 3
      // 06f: invokestatic com/google/android/gms/common/internal/zzbq.a (Z)V
      // 072: ldc "MessengerIpcClient"
      // 074: bipush 2
      // 075: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 078: ifeq 083
      // 07b: ldc "MessengerIpcClient"
      // 07d: ldc "Starting bind to GmsCore"
      // 07f: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 082: pop
      // 083: aload 0
      // 084: bipush 1
      // 085: putfield com/google/firebase/iid/zzk.a I
      // 088: new android/content/Intent
      // 08b: astore 1
      // 08c: aload 1
      // 08d: ldc "com.google.android.c2dm.intent.REGISTER"
      // 08f: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
      // 092: aload 1
      // 093: ldc "com.google.android.gms"
      // 095: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
      // 098: pop
      // 099: invokestatic com/google/android/gms/common/stats/zza.a ()Lcom/google/android/gms/common/stats/zza;
      // 09c: aload 0
      // 09d: getfield com/google/firebase/iid/zzk.f Lcom/google/firebase/iid/zzi;
      // 0a0: invokestatic com/google/firebase/iid/zzi.a (Lcom/google/firebase/iid/zzi;)Landroid/content/Context;
      // 0a3: aload 1
      // 0a4: aload 0
      // 0a5: bipush 1
      // 0a6: invokevirtual com/google/android/gms/common/stats/zza.a (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      // 0a9: ifne 0bb
      // 0ac: aload 0
      // 0ad: bipush 0
      // 0ae: ldc_w "Unable to bind to service"
      // 0b1: invokevirtual com/google/firebase/iid/zzk.a (ILjava/lang/String;)V
      // 0b4: iload 4
      // 0b6: istore 3
      // 0b7: aload 0
      // 0b8: monitorexit
      // 0b9: iload 3
      // 0ba: ireturn
      // 0bb: aload 0
      // 0bc: getfield com/google/firebase/iid/zzk.f Lcom/google/firebase/iid/zzi;
      // 0bf: invokestatic com/google/firebase/iid/zzi.b (Lcom/google/firebase/iid/zzi;)Ljava/util/concurrent/ScheduledExecutorService;
      // 0c2: astore 1
      // 0c3: new com/google/firebase/iid/zzm
      // 0c6: astore 5
      // 0c8: aload 5
      // 0ca: aload 0
      // 0cb: invokespecial com/google/firebase/iid/zzm.<init> (Lcom/google/firebase/iid/zzk;)V
      // 0ce: aload 1
      // 0cf: aload 5
      // 0d1: ldc2_w 30
      // 0d4: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 0d7: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 5
      // 0dc: pop
      // 0dd: iload 4
      // 0df: istore 3
      // 0e0: goto 0b7
      // 0e3: aload 0
      // 0e4: getfield com/google/firebase/iid/zzk.d Ljava/util/Queue;
      // 0e7: aload 1
      // 0e8: invokeinterface java/util/Queue.add (Ljava/lang/Object;)Z 2
      // 0ed: pop
      // 0ee: iload 4
      // 0f0: istore 3
      // 0f1: goto 0b7
      // 0f4: aload 0
      // 0f5: getfield com/google/firebase/iid/zzk.d Ljava/util/Queue;
      // 0f8: aload 1
      // 0f9: invokeinterface java/util/Queue.add (Ljava/lang/Object;)Z 2
      // 0fe: pop
      // 0ff: aload 0
      // 100: invokespecial com/google/firebase/iid/zzk.c ()V
      // 103: iload 4
      // 105: istore 3
      // 106: goto 0b7
      // 109: bipush 0
      // 10a: istore 3
      // 10b: goto 0b7
      // try (6 -> 9): 29 null
      // try (9 -> 29): 29 null
      // try (34 -> 39): 29 null
      // try (39 -> 42): 29 null
      // try (44 -> 54): 29 null
      // try (54 -> 79): 29 null
      // try (85 -> 100): 29 null
      // try (103 -> 108): 29 null
      // try (111 -> 118): 29 null
   }

   final void b() {
      synchronized (this) {
         if (this.a == 1) {
            this.a(1, "Timed out while binding");
         }
      }
   }

   public final void onServiceConnected(ComponentName param1, IBinder param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: ldc "MessengerIpcClient"
      // 04: bipush 2
      // 05: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 08: ifeq 14
      // 0b: ldc "MessengerIpcClient"
      // 0d: ldc_w "Service connected"
      // 10: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 13: pop
      // 14: aload 2
      // 15: ifnonnull 23
      // 18: aload 0
      // 19: bipush 0
      // 1a: ldc_w "Null service connection"
      // 1d: invokevirtual com/google/firebase/iid/zzk.a (ILjava/lang/String;)V
      // 20: aload 0
      // 21: monitorexit
      // 22: return
      // 23: new com/google/firebase/iid/zzp
      // 26: astore 1
      // 27: aload 1
      // 28: aload 2
      // 29: invokespecial com/google/firebase/iid/zzp.<init> (Landroid/os/IBinder;)V
      // 2c: aload 0
      // 2d: aload 1
      // 2e: putfield com/google/firebase/iid/zzk.c Lcom/google/firebase/iid/zzp;
      // 31: aload 0
      // 32: bipush 2
      // 33: putfield com/google/firebase/iid/zzk.a I
      // 36: aload 0
      // 37: invokespecial com/google/firebase/iid/zzk.c ()V
      // 3a: goto 20
      // 3d: astore 1
      // 3e: aload 0
      // 3f: monitorexit
      // 40: aload 1
      // 41: athrow
      // 42: astore 1
      // 43: aload 0
      // 44: bipush 0
      // 45: aload 1
      // 46: invokevirtual android/os/RemoteException.getMessage ()Ljava/lang/String;
      // 49: invokevirtual com/google/firebase/iid/zzk.a (ILjava/lang/String;)V
      // 4c: goto 20
      // try (2 -> 10): 33 null
      // try (12 -> 16): 33 null
      // try (19 -> 27): 38 android/os/RemoteException
      // try (19 -> 27): 33 null
      // try (27 -> 32): 33 null
      // try (39 -> 44): 33 null
   }

   public final void onServiceDisconnected(ComponentName var1) {
      synchronized (this) {
         if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
         }

         this.a(2, "Service disconnected");
      }
   }
}
