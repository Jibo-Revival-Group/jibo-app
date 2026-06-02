package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;

final class zzcil extends Thread {
   private final Object a;
   private final BlockingQueue<zzcik<?>> b;
   private zzcih c;

   public zzcil(zzcih var1, String var2, BlockingQueue var3) {
      this.c = var1;
      super();
      zzbq.a((String)var2);
      zzbq.a(var3);
      this.a = new Object();
      this.b = var3;
      this.setName(var2);
   }

   private final void a(InterruptedException var1) {
      this.c.t().A().a(String.valueOf(this.getName()).concat(" was interrupted"), var1);
   }

   public final void a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzcil.a Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzcil.a Ljava/lang/Object;
      // 0b: invokevirtual java/lang/Object.notifyAll ()V
      // 0e: aload 1
      // 0f: monitorexit
      // 10: return
      // 11: astore 2
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 2
      // 15: athrow
      // try (5 -> 10): 11 null
      // try (12 -> 14): 11 null
   }

   @Override
   public final void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 1
      // 002: iload 1
      // 003: ifne 020
      // 006: aload 0
      // 007: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 00a: invokestatic com/google/android/gms/internal/zzcih.a (Lcom/google/android/gms/internal/zzcih;)Ljava/util/concurrent/Semaphore;
      // 00d: invokevirtual java/util/concurrent/Semaphore.acquire ()V
      // 010: bipush 1
      // 011: istore 1
      // 012: goto 002
      // 015: astore 4
      // 017: aload 0
      // 018: aload 4
      // 01a: invokespecial com/google/android/gms/internal/zzcil.a (Ljava/lang/InterruptedException;)V
      // 01d: goto 002
      // 020: invokestatic android/os/Process.myTid ()I
      // 023: invokestatic android/os/Process.getThreadPriority (I)I
      // 026: istore 2
      // 027: aload 0
      // 028: getfield com/google/android/gms/internal/zzcil.b Ljava/util/concurrent/BlockingQueue;
      // 02b: invokeinterface java/util/concurrent/BlockingQueue.poll ()Ljava/lang/Object; 1
      // 030: checkcast com/google/android/gms/internal/zzcik
      // 033: astore 4
      // 035: aload 4
      // 037: ifnull 092
      // 03a: aload 4
      // 03c: getfield com/google/android/gms/internal/zzcik.a Z
      // 03f: ifeq 08c
      // 042: iload 2
      // 043: istore 1
      // 044: iload 1
      // 045: invokestatic android/os/Process.setThreadPriority (I)V
      // 048: aload 4
      // 04a: invokevirtual com/google/android/gms/internal/zzcik.run ()V
      // 04d: goto 027
      // 050: astore 5
      // 052: aload 0
      // 053: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 056: invokestatic com/google/android/gms/internal/zzcih.c (Lcom/google/android/gms/internal/zzcih;)Ljava/lang/Object;
      // 059: astore 4
      // 05b: aload 4
      // 05d: monitorenter
      // 05e: aload 0
      // 05f: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 062: invokestatic com/google/android/gms/internal/zzcih.a (Lcom/google/android/gms/internal/zzcih;)Ljava/util/concurrent/Semaphore;
      // 065: invokevirtual java/util/concurrent/Semaphore.release ()V
      // 068: aload 0
      // 069: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 06c: invokestatic com/google/android/gms/internal/zzcih.c (Lcom/google/android/gms/internal/zzcih;)Ljava/lang/Object;
      // 06f: invokevirtual java/lang/Object.notifyAll ()V
      // 072: aload 0
      // 073: aload 0
      // 074: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 077: invokestatic com/google/android/gms/internal/zzcih.d (Lcom/google/android/gms/internal/zzcih;)Lcom/google/android/gms/internal/zzcil;
      // 07a: if_acmpne 165
      // 07d: aload 0
      // 07e: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 081: aconst_null
      // 082: invokestatic com/google/android/gms/internal/zzcih.a (Lcom/google/android/gms/internal/zzcih;Lcom/google/android/gms/internal/zzcil;)Lcom/google/android/gms/internal/zzcil;
      // 085: pop
      // 086: aload 4
      // 088: monitorexit
      // 089: aload 5
      // 08b: athrow
      // 08c: bipush 10
      // 08e: istore 1
      // 08f: goto 044
      // 092: aload 0
      // 093: getfield com/google/android/gms/internal/zzcil.a Ljava/lang/Object;
      // 096: astore 4
      // 098: aload 4
      // 09a: monitorenter
      // 09b: aload 0
      // 09c: getfield com/google/android/gms/internal/zzcil.b Ljava/util/concurrent/BlockingQueue;
      // 09f: invokeinterface java/util/concurrent/BlockingQueue.peek ()Ljava/lang/Object; 1
      // 0a4: ifnonnull 0bd
      // 0a7: aload 0
      // 0a8: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 0ab: invokestatic com/google/android/gms/internal/zzcih.b (Lcom/google/android/gms/internal/zzcih;)Z
      // 0ae: istore 3
      // 0af: iload 3
      // 0b0: ifne 0bd
      // 0b3: aload 0
      // 0b4: getfield com/google/android/gms/internal/zzcil.a Ljava/lang/Object;
      // 0b7: ldc2_w 30000
      // 0ba: invokevirtual java/lang/Object.wait (J)V
      // 0bd: aload 4
      // 0bf: monitorexit
      // 0c0: aload 0
      // 0c1: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 0c4: invokestatic com/google/android/gms/internal/zzcih.c (Lcom/google/android/gms/internal/zzcih;)Ljava/lang/Object;
      // 0c7: astore 5
      // 0c9: aload 5
      // 0cb: monitorenter
      // 0cc: aload 0
      // 0cd: getfield com/google/android/gms/internal/zzcil.b Ljava/util/concurrent/BlockingQueue;
      // 0d0: invokeinterface java/util/concurrent/BlockingQueue.peek ()Ljava/lang/Object; 1
      // 0d5: ifnonnull 157
      // 0d8: aload 5
      // 0da: monitorexit
      // 0db: aload 0
      // 0dc: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 0df: invokestatic com/google/android/gms/internal/zzcih.c (Lcom/google/android/gms/internal/zzcih;)Ljava/lang/Object;
      // 0e2: astore 4
      // 0e4: aload 4
      // 0e6: monitorenter
      // 0e7: aload 0
      // 0e8: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 0eb: invokestatic com/google/android/gms/internal/zzcih.a (Lcom/google/android/gms/internal/zzcih;)Ljava/util/concurrent/Semaphore;
      // 0ee: invokevirtual java/util/concurrent/Semaphore.release ()V
      // 0f1: aload 0
      // 0f2: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 0f5: invokestatic com/google/android/gms/internal/zzcih.c (Lcom/google/android/gms/internal/zzcih;)Ljava/lang/Object;
      // 0f8: invokevirtual java/lang/Object.notifyAll ()V
      // 0fb: aload 0
      // 0fc: aload 0
      // 0fd: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 100: invokestatic com/google/android/gms/internal/zzcih.d (Lcom/google/android/gms/internal/zzcih;)Lcom/google/android/gms/internal/zzcil;
      // 103: if_acmpne 126
      // 106: aload 0
      // 107: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 10a: aconst_null
      // 10b: invokestatic com/google/android/gms/internal/zzcih.a (Lcom/google/android/gms/internal/zzcih;Lcom/google/android/gms/internal/zzcil;)Lcom/google/android/gms/internal/zzcil;
      // 10e: pop
      // 10f: aload 4
      // 111: monitorexit
      // 112: return
      // 113: astore 5
      // 115: aload 0
      // 116: aload 5
      // 118: invokespecial com/google/android/gms/internal/zzcil.a (Ljava/lang/InterruptedException;)V
      // 11b: goto 0bd
      // 11e: astore 5
      // 120: aload 4
      // 122: monitorexit
      // 123: aload 5
      // 125: athrow
      // 126: aload 0
      // 127: aload 0
      // 128: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 12b: invokestatic com/google/android/gms/internal/zzcih.e (Lcom/google/android/gms/internal/zzcih;)Lcom/google/android/gms/internal/zzcil;
      // 12e: if_acmpne 145
      // 131: aload 0
      // 132: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 135: aconst_null
      // 136: invokestatic com/google/android/gms/internal/zzcih.b (Lcom/google/android/gms/internal/zzcih;Lcom/google/android/gms/internal/zzcil;)Lcom/google/android/gms/internal/zzcil;
      // 139: pop
      // 13a: goto 10f
      // 13d: astore 5
      // 13f: aload 4
      // 141: monitorexit
      // 142: aload 5
      // 144: athrow
      // 145: aload 0
      // 146: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 149: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 14c: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 14f: ldc "Current scheduler thread is neither worker nor network"
      // 151: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 154: goto 10f
      // 157: aload 5
      // 159: monitorexit
      // 15a: goto 027
      // 15d: astore 4
      // 15f: aload 5
      // 161: monitorexit
      // 162: aload 4
      // 164: athrow
      // 165: aload 0
      // 166: aload 0
      // 167: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 16a: invokestatic com/google/android/gms/internal/zzcih.e (Lcom/google/android/gms/internal/zzcih;)Lcom/google/android/gms/internal/zzcil;
      // 16d: if_acmpne 184
      // 170: aload 0
      // 171: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 174: aconst_null
      // 175: invokestatic com/google/android/gms/internal/zzcih.b (Lcom/google/android/gms/internal/zzcih;Lcom/google/android/gms/internal/zzcil;)Lcom/google/android/gms/internal/zzcil;
      // 178: pop
      // 179: goto 086
      // 17c: astore 5
      // 17e: aload 4
      // 180: monitorexit
      // 181: aload 5
      // 183: athrow
      // 184: aload 0
      // 185: getfield com/google/android/gms/internal/zzcil.c Lcom/google/android/gms/internal/zzcih;
      // 188: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 18b: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 18e: ldc "Current scheduler thread is neither worker nor network"
      // 190: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 193: goto 086
      // try (4 -> 8): 11 java/lang/InterruptedException
      // try (16 -> 19): 36 null
      // try (19 -> 24): 36 null
      // try (26 -> 29): 36 null
      // try (31 -> 35): 36 null
      // try (43 -> 61): 180 null
      // try (61 -> 63): 180 null
      // try (68 -> 73): 36 null
      // try (73 -> 81): 133 null
      // try (83 -> 87): 128 java/lang/InterruptedException
      // try (83 -> 87): 133 null
      // try (87 -> 89): 133 null
      // try (89 -> 95): 36 null
      // try (95 -> 101): 164 null
      // try (107 -> 125): 149 null
      // try (125 -> 127): 149 null
      // try (129 -> 132): 133 null
      // try (134 -> 136): 133 null
      // try (136 -> 138): 36 null
      // try (138 -> 148): 149 null
      // try (150 -> 152): 149 null
      // try (154 -> 160): 149 null
      // try (161 -> 163): 164 null
      // try (165 -> 167): 164 null
      // try (167 -> 169): 36 null
      // try (169 -> 179): 180 null
      // try (181 -> 183): 180 null
      // try (185 -> 191): 180 null
   }
}
