package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzckr implements Runnable {
   private AtomicReference a;
   private String b;
   private String c;
   private String d;
   private boolean e;
   private zzcgi f;
   private zzckg g;

   zzckr(zzckg var1, AtomicReference var2, String var3, String var4, String var5, boolean var6, zzcgi var7) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
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
      // 01: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzckr.g Lcom/google/android/gms/internal/zzckg;
      // 0b: invokestatic com/google/android/gms/internal/zzckg.d (Lcom/google/android/gms/internal/zzckg;)Lcom/google/android/gms/internal/zzche;
      // 0e: astore 2
      // 0f: aload 2
      // 10: ifnonnull 45
      // 13: aload 0
      // 14: getfield com/google/android/gms/internal/zzckr.g Lcom/google/android/gms/internal/zzckg;
      // 17: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1a: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1d: ldc "Failed to get user properties"
      // 1f: aload 0
      // 20: getfield com/google/android/gms/internal/zzckr.b Ljava/lang/String;
      // 23: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 26: aload 0
      // 27: getfield com/google/android/gms/internal/zzckr.c Ljava/lang/String;
      // 2a: aload 0
      // 2b: getfield com/google/android/gms/internal/zzckr.d Ljava/lang/String;
      // 2e: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 31: aload 0
      // 32: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // 35: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 38: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 3b: aload 0
      // 3c: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // 3f: invokevirtual java/lang/Object.notify ()V
      // 42: aload 1
      // 43: monitorexit
      // 44: return
      // 45: aload 0
      // 46: getfield com/google/android/gms/internal/zzckr.b Ljava/lang/String;
      // 49: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 4c: ifeq 84
      // 4f: aload 0
      // 50: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // 53: aload 2
      // 54: aload 0
      // 55: getfield com/google/android/gms/internal/zzckr.c Ljava/lang/String;
      // 58: aload 0
      // 59: getfield com/google/android/gms/internal/zzckr.d Ljava/lang/String;
      // 5c: aload 0
      // 5d: getfield com/google/android/gms/internal/zzckr.e Z
      // 60: aload 0
      // 61: getfield com/google/android/gms/internal/zzckr.f Lcom/google/android/gms/internal/zzcgi;
      // 64: invokeinterface com/google/android/gms/internal/zzche.a (Ljava/lang/String;Ljava/lang/String;ZLcom/google/android/gms/internal/zzcgi;)Ljava/util/List; 5
      // 69: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 6c: aload 0
      // 6d: getfield com/google/android/gms/internal/zzckr.g Lcom/google/android/gms/internal/zzckg;
      // 70: invokestatic com/google/android/gms/internal/zzckg.e (Lcom/google/android/gms/internal/zzckg;)V
      // 73: aload 0
      // 74: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // 77: invokevirtual java/lang/Object.notify ()V
      // 7a: aload 1
      // 7b: monitorexit
      // 7c: goto 44
      // 7f: astore 2
      // 80: aload 1
      // 81: monitorexit
      // 82: aload 2
      // 83: athrow
      // 84: aload 0
      // 85: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // 88: aload 2
      // 89: aload 0
      // 8a: getfield com/google/android/gms/internal/zzckr.b Ljava/lang/String;
      // 8d: aload 0
      // 8e: getfield com/google/android/gms/internal/zzckr.c Ljava/lang/String;
      // 91: aload 0
      // 92: getfield com/google/android/gms/internal/zzckr.d Ljava/lang/String;
      // 95: aload 0
      // 96: getfield com/google/android/gms/internal/zzckr.e Z
      // 99: invokeinterface com/google/android/gms/internal/zzche.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List; 5
      // 9e: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // a1: goto 6c
      // a4: astore 2
      // a5: aload 0
      // a6: getfield com/google/android/gms/internal/zzckr.g Lcom/google/android/gms/internal/zzckg;
      // a9: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // ac: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // af: ldc "Failed to get user properties"
      // b1: aload 0
      // b2: getfield com/google/android/gms/internal/zzckr.b Ljava/lang/String;
      // b5: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // b8: aload 0
      // b9: getfield com/google/android/gms/internal/zzckr.c Ljava/lang/String;
      // bc: aload 2
      // bd: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // c0: aload 0
      // c1: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // c4: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // c7: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // ca: aload 0
      // cb: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // ce: invokevirtual java/lang/Object.notify ()V
      // d1: goto 7a
      // d4: astore 2
      // d5: aload 0
      // d6: getfield com/google/android/gms/internal/zzckr.a Ljava/util/concurrent/atomic/AtomicReference;
      // d9: invokevirtual java/lang/Object.notify ()V
      // dc: aload 2
      // dd: athrow
      // try (5 -> 9): 79 android/os/RemoteException
      // try (5 -> 9): 100 null
      // try (11 -> 28): 79 android/os/RemoteException
      // try (11 -> 28): 100 null
      // try (28 -> 33): 60 null
      // try (34 -> 51): 79 android/os/RemoteException
      // try (34 -> 51): 100 null
      // try (51 -> 54): 79 android/os/RemoteException
      // try (51 -> 54): 100 null
      // try (54 -> 57): 60 null
      // try (57 -> 59): 60 null
      // try (61 -> 63): 60 null
      // try (65 -> 78): 79 android/os/RemoteException
      // try (65 -> 78): 100 null
      // try (80 -> 96): 100 null
      // try (96 -> 99): 60 null
      // try (101 -> 106): 60 null
   }
}
