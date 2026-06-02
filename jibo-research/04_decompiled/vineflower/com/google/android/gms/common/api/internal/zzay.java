package com.google.android.gms.common.api.internal;

abstract class zzay implements Runnable {
   private zzao a;

   private zzay(zzao var1) {
      this.a = var1;
      super();
   }

   protected abstract void a();

   @Override
   public void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/common/api/internal/zzay.a Lcom/google/android/gms/common/api/internal/zzao;
      // 04: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 07: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 0c: invokestatic java/lang/Thread.interrupted ()Z
      // 0f: istore 1
      // 10: iload 1
      // 11: ifeq 21
      // 14: aload 0
      // 15: getfield com/google/android/gms/common/api/internal/zzay.a Lcom/google/android/gms/common/api/internal/zzao;
      // 18: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 1b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 20: return
      // 21: aload 0
      // 22: invokevirtual com/google/android/gms/common/api/internal/zzay.a ()V
      // 25: aload 0
      // 26: getfield com/google/android/gms/common/api/internal/zzay.a Lcom/google/android/gms/common/api/internal/zzao;
      // 29: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 2c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 31: goto 20
      // 34: astore 2
      // 35: aload 0
      // 36: getfield com/google/android/gms/common/api/internal/zzay.a Lcom/google/android/gms/common/api/internal/zzao;
      // 39: invokestatic com/google/android/gms/common/api/internal/zzao.d (Lcom/google/android/gms/common/api/internal/zzao;)Lcom/google/android/gms/common/api/internal/zzbi;
      // 3c: aload 2
      // 3d: invokevirtual com/google/android/gms/common/api/internal/zzbi.a (Ljava/lang/RuntimeException;)V
      // 40: aload 0
      // 41: getfield com/google/android/gms/common/api/internal/zzay.a Lcom/google/android/gms/common/api/internal/zzao;
      // 44: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 47: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 4c: goto 20
      // 4f: astore 2
      // 50: aload 0
      // 51: getfield com/google/android/gms/common/api/internal/zzay.a Lcom/google/android/gms/common/api/internal/zzao;
      // 54: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 57: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 5c: aload 2
      // 5d: athrow
      // try (4 -> 6): 20 java/lang/RuntimeException
      // try (4 -> 6): 31 null
      // try (13 -> 15): 20 java/lang/RuntimeException
      // try (13 -> 15): 31 null
      // try (21 -> 26): 31 null
   }
}
