package com.google.firebase.iid;

// $VF: synthetic class
final class zzn implements Runnable {
   private final zzk a;

   zzn(zzk var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
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
      // 000: aload 0
      // 001: getfield com/google/firebase/iid/zzn.a Lcom/google/firebase/iid/zzk;
      // 004: astore 1
      // 005: aload 1
      // 006: monitorenter
      // 007: aload 1
      // 008: getfield com/google/firebase/iid/zzk.a I
      // 00b: bipush 2
      // 00c: if_icmpeq 012
      // 00f: aload 1
      // 010: monitorexit
      // 011: return
      // 012: aload 1
      // 013: getfield com/google/firebase/iid/zzk.d Ljava/util/Queue;
      // 016: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 01b: ifeq 02c
      // 01e: aload 1
      // 01f: invokevirtual com/google/firebase/iid/zzk.a ()V
      // 022: aload 1
      // 023: monitorexit
      // 024: goto 011
      // 027: astore 2
      // 028: aload 1
      // 029: monitorexit
      // 02a: aload 2
      // 02b: athrow
      // 02c: aload 1
      // 02d: getfield com/google/firebase/iid/zzk.d Ljava/util/Queue;
      // 030: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 035: checkcast com/google/firebase/iid/zzr
      // 038: astore 2
      // 039: aload 1
      // 03a: getfield com/google/firebase/iid/zzk.e Landroid/util/SparseArray;
      // 03d: aload 2
      // 03e: getfield com/google/firebase/iid/zzr.a I
      // 041: aload 2
      // 042: invokevirtual android/util/SparseArray.put (ILjava/lang/Object;)V
      // 045: aload 1
      // 046: getfield com/google/firebase/iid/zzk.f Lcom/google/firebase/iid/zzi;
      // 049: invokestatic com/google/firebase/iid/zzi.b (Lcom/google/firebase/iid/zzi;)Ljava/util/concurrent/ScheduledExecutorService;
      // 04c: astore 4
      // 04e: new com/google/firebase/iid/zzo
      // 051: astore 3
      // 052: aload 3
      // 053: aload 1
      // 054: aload 2
      // 055: invokespecial com/google/firebase/iid/zzo.<init> (Lcom/google/firebase/iid/zzk;Lcom/google/firebase/iid/zzr;)V
      // 058: aload 4
      // 05a: aload 3
      // 05b: ldc2_w 30
      // 05e: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 061: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 5
      // 066: pop
      // 067: aload 1
      // 068: monitorexit
      // 069: ldc "MessengerIpcClient"
      // 06b: bipush 3
      // 06c: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 06f: ifeq 09a
      // 072: aload 2
      // 073: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 076: astore 3
      // 077: ldc "MessengerIpcClient"
      // 079: new java/lang/StringBuilder
      // 07c: dup
      // 07d: aload 3
      // 07e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 081: invokevirtual java/lang/String.length ()I
      // 084: bipush 8
      // 086: iadd
      // 087: invokespecial java/lang/StringBuilder.<init> (I)V
      // 08a: ldc "Sending "
      // 08c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08f: aload 3
      // 090: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 093: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 096: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 099: pop
      // 09a: aload 1
      // 09b: getfield com/google/firebase/iid/zzk.f Lcom/google/firebase/iid/zzi;
      // 09e: invokestatic com/google/firebase/iid/zzi.a (Lcom/google/firebase/iid/zzi;)Landroid/content/Context;
      // 0a1: astore 4
      // 0a3: aload 1
      // 0a4: getfield com/google/firebase/iid/zzk.b Landroid/os/Messenger;
      // 0a7: astore 5
      // 0a9: invokestatic android/os/Message.obtain ()Landroid/os/Message;
      // 0ac: astore 3
      // 0ad: aload 3
      // 0ae: aload 2
      // 0af: getfield com/google/firebase/iid/zzr.c I
      // 0b2: putfield android/os/Message.what I
      // 0b5: aload 3
      // 0b6: aload 2
      // 0b7: getfield com/google/firebase/iid/zzr.a I
      // 0ba: putfield android/os/Message.arg1 I
      // 0bd: aload 3
      // 0be: aload 5
      // 0c0: putfield android/os/Message.replyTo Landroid/os/Messenger;
      // 0c3: new android/os/Bundle
      // 0c6: dup
      // 0c7: invokespecial android/os/Bundle.<init> ()V
      // 0ca: astore 5
      // 0cc: aload 5
      // 0ce: ldc "oneWay"
      // 0d0: aload 2
      // 0d1: invokevirtual com/google/firebase/iid/zzr.a ()Z
      // 0d4: invokevirtual android/os/Bundle.putBoolean (Ljava/lang/String;Z)V
      // 0d7: aload 5
      // 0d9: ldc "pkg"
      // 0db: aload 4
      // 0dd: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 0e0: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0e3: aload 5
      // 0e5: ldc "data"
      // 0e7: aload 2
      // 0e8: getfield com/google/firebase/iid/zzr.d Landroid/os/Bundle;
      // 0eb: invokevirtual android/os/Bundle.putBundle (Ljava/lang/String;Landroid/os/Bundle;)V
      // 0ee: aload 3
      // 0ef: aload 5
      // 0f1: invokevirtual android/os/Message.setData (Landroid/os/Bundle;)V
      // 0f4: aload 1
      // 0f5: getfield com/google/firebase/iid/zzk.c Lcom/google/firebase/iid/zzp;
      // 0f8: aload 3
      // 0f9: invokevirtual com/google/firebase/iid/zzp.a (Landroid/os/Message;)V
      // 0fc: goto 005
      // 0ff: astore 2
      // 100: aload 1
      // 101: bipush 2
      // 102: aload 2
      // 103: invokevirtual android/os/RemoteException.getMessage ()Ljava/lang/String;
      // 106: invokevirtual com/google/firebase/iid/zzk.a (ILjava/lang/String;)V
      // 109: goto 005
      // try (5 -> 11): 21 null
      // try (12 -> 20): 21 null
      // try (22 -> 24): 21 null
      // try (26 -> 55): 21 null
      // try (120 -> 124): 125 android/os/RemoteException
   }
}
