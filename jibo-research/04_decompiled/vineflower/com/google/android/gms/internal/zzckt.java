package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzckt implements Runnable {
   private AtomicReference a;
   private zzcgi b;
   private boolean c;
   private zzckg d;

   zzckt(zzckg var1, AtomicReference var2, zzcgi var3, boolean var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      super();
   }

   @Override
   public final void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzckt.a Ljava/util/concurrent/atomic/AtomicReference;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzckt.d Lcom/google/android/gms/internal/zzckg;
      // 0b: invokestatic com/google/android/gms/internal/zzckg.d (Lcom/google/android/gms/internal/zzckg;)Lcom/google/android/gms/internal/zzche;
      // 0e: astore 2
      // 0f: aload 2
      // 10: ifnonnull 2c
      // 13: aload 0
      // 14: getfield com/google/android/gms/internal/zzckt.d Lcom/google/android/gms/internal/zzckg;
      // 17: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1a: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1d: ldc "Failed to get user properties"
      // 1f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 22: aload 0
      // 23: getfield com/google/android/gms/internal/zzckt.a Ljava/util/concurrent/atomic/AtomicReference;
      // 26: invokevirtual java/lang/Object.notify ()V
      // 29: aload 1
      // 2a: monitorexit
      // 2b: return
      // 2c: aload 0
      // 2d: getfield com/google/android/gms/internal/zzckt.a Ljava/util/concurrent/atomic/AtomicReference;
      // 30: aload 2
      // 31: aload 0
      // 32: getfield com/google/android/gms/internal/zzckt.b Lcom/google/android/gms/internal/zzcgi;
      // 35: aload 0
      // 36: getfield com/google/android/gms/internal/zzckt.c Z
      // 39: invokeinterface com/google/android/gms/internal/zzche.a (Lcom/google/android/gms/internal/zzcgi;Z)Ljava/util/List; 3
      // 3e: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 41: aload 0
      // 42: getfield com/google/android/gms/internal/zzckt.d Lcom/google/android/gms/internal/zzckg;
      // 45: invokestatic com/google/android/gms/internal/zzckg.e (Lcom/google/android/gms/internal/zzckg;)V
      // 48: aload 0
      // 49: getfield com/google/android/gms/internal/zzckt.a Ljava/util/concurrent/atomic/AtomicReference;
      // 4c: invokevirtual java/lang/Object.notify ()V
      // 4f: aload 1
      // 50: monitorexit
      // 51: goto 2b
      // 54: astore 2
      // 55: aload 1
      // 56: monitorexit
      // 57: aload 2
      // 58: athrow
      // 59: astore 2
      // 5a: aload 0
      // 5b: getfield com/google/android/gms/internal/zzckt.d Lcom/google/android/gms/internal/zzckg;
      // 5e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 61: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 64: ldc "Failed to get user properties"
      // 66: aload 2
      // 67: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 6a: aload 0
      // 6b: getfield com/google/android/gms/internal/zzckt.a Ljava/util/concurrent/atomic/AtomicReference;
      // 6e: invokevirtual java/lang/Object.notify ()V
      // 71: goto 4f
      // 74: astore 2
      // 75: aload 0
      // 76: getfield com/google/android/gms/internal/zzckt.a Ljava/util/concurrent/atomic/AtomicReference;
      // 79: invokevirtual java/lang/Object.notify ()V
      // 7c: aload 2
      // 7d: athrow
      // try (5 -> 9): 46 android/os/RemoteException
      // try (5 -> 9): 58 null
      // try (11 -> 17): 46 android/os/RemoteException
      // try (11 -> 17): 58 null
      // try (17 -> 22): 41 null
      // try (23 -> 35): 46 android/os/RemoteException
      // try (23 -> 35): 58 null
      // try (35 -> 38): 41 null
      // try (38 -> 40): 41 null
      // try (42 -> 44): 41 null
      // try (47 -> 54): 58 null
      // try (54 -> 57): 41 null
      // try (59 -> 64): 41 null
   }
}
