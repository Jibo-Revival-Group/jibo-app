package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzckj implements Runnable {
   private AtomicReference a;
   private zzcgi b;
   private zzckg c;

   zzckj(zzckg var1, AtomicReference var2, zzcgi var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
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
      // 01: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzckj.c Lcom/google/android/gms/internal/zzckg;
      // 0b: invokestatic com/google/android/gms/internal/zzckg.d (Lcom/google/android/gms/internal/zzckg;)Lcom/google/android/gms/internal/zzche;
      // 0e: astore 2
      // 0f: aload 2
      // 10: ifnonnull 2c
      // 13: aload 0
      // 14: getfield com/google/android/gms/internal/zzckj.c Lcom/google/android/gms/internal/zzckg;
      // 17: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1a: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1d: ldc "Failed to get app instance id"
      // 1f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 22: aload 0
      // 23: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 26: invokevirtual java/lang/Object.notify ()V
      // 29: aload 1
      // 2a: monitorexit
      // 2b: return
      // 2c: aload 0
      // 2d: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 30: aload 2
      // 31: aload 0
      // 32: getfield com/google/android/gms/internal/zzckj.b Lcom/google/android/gms/internal/zzcgi;
      // 35: invokeinterface com/google/android/gms/internal/zzche.c (Lcom/google/android/gms/internal/zzcgi;)Ljava/lang/String; 2
      // 3a: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 3d: aload 0
      // 3e: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 41: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 44: checkcast java/lang/String
      // 47: astore 2
      // 48: aload 2
      // 49: ifnull 65
      // 4c: aload 0
      // 4d: getfield com/google/android/gms/internal/zzckj.c Lcom/google/android/gms/internal/zzckg;
      // 50: invokevirtual com/google/android/gms/internal/zzcjk.f ()Lcom/google/android/gms/internal/zzcjn;
      // 53: aload 2
      // 54: invokevirtual com/google/android/gms/internal/zzcjn.a (Ljava/lang/String;)V
      // 57: aload 0
      // 58: getfield com/google/android/gms/internal/zzckj.c Lcom/google/android/gms/internal/zzckg;
      // 5b: invokevirtual com/google/android/gms/internal/zzcjk.u ()Lcom/google/android/gms/internal/zzchx;
      // 5e: getfield com/google/android/gms/internal/zzchx.i Lcom/google/android/gms/internal/zzcic;
      // 61: aload 2
      // 62: invokevirtual com/google/android/gms/internal/zzcic.a (Ljava/lang/String;)V
      // 65: aload 0
      // 66: getfield com/google/android/gms/internal/zzckj.c Lcom/google/android/gms/internal/zzckg;
      // 69: invokestatic com/google/android/gms/internal/zzckg.e (Lcom/google/android/gms/internal/zzckg;)V
      // 6c: aload 0
      // 6d: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 70: invokevirtual java/lang/Object.notify ()V
      // 73: aload 1
      // 74: monitorexit
      // 75: goto 2b
      // 78: astore 2
      // 79: aload 1
      // 7a: monitorexit
      // 7b: aload 2
      // 7c: athrow
      // 7d: astore 2
      // 7e: aload 0
      // 7f: getfield com/google/android/gms/internal/zzckj.c Lcom/google/android/gms/internal/zzckg;
      // 82: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 85: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 88: ldc "Failed to get app instance id"
      // 8a: aload 2
      // 8b: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 8e: aload 0
      // 8f: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 92: invokevirtual java/lang/Object.notify ()V
      // 95: goto 73
      // 98: astore 2
      // 99: aload 0
      // 9a: getfield com/google/android/gms/internal/zzckj.a Ljava/util/concurrent/atomic/AtomicReference;
      // 9d: invokevirtual java/lang/Object.notify ()V
      // a0: aload 2
      // a1: athrow
      // try (5 -> 9): 62 android/os/RemoteException
      // try (5 -> 9): 74 null
      // try (11 -> 17): 62 android/os/RemoteException
      // try (11 -> 17): 74 null
      // try (17 -> 22): 57 null
      // try (23 -> 35): 62 android/os/RemoteException
      // try (23 -> 35): 74 null
      // try (37 -> 48): 62 android/os/RemoteException
      // try (37 -> 48): 74 null
      // try (48 -> 51): 62 android/os/RemoteException
      // try (48 -> 51): 74 null
      // try (51 -> 54): 57 null
      // try (54 -> 56): 57 null
      // try (58 -> 60): 57 null
      // try (63 -> 70): 74 null
      // try (70 -> 73): 57 null
      // try (75 -> 80): 57 null
   }
}
