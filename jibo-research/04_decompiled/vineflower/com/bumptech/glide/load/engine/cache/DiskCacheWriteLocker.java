package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {
   private final Map<Key, DiskCacheWriteLocker.WriteLock> locks = new HashMap<>();
   private final DiskCacheWriteLocker.WriteLockPool writeLockPool = new DiskCacheWriteLocker.WriteLockPool();

   void acquire(Key param1) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.locks Ljava/util/Map;
      // 06: aload 1
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
      // 0f: astore 3
      // 10: aload 3
      // 11: astore 2
      // 12: aload 3
      // 13: ifnonnull 2a
      // 16: aload 0
      // 17: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.writeLockPool Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool;
      // 1a: invokevirtual com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.obtain ()Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock;
      // 1d: astore 2
      // 1e: aload 0
      // 1f: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.locks Ljava/util/Map;
      // 22: aload 1
      // 23: aload 2
      // 24: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 29: pop
      // 2a: aload 2
      // 2b: aload 2
      // 2c: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.interestedThreads I
      // 2f: bipush 1
      // 30: iadd
      // 31: putfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.interestedThreads I
      // 34: aload 0
      // 35: monitorexit
      // 36: aload 2
      // 37: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.lock Ljava/util/concurrent/locks/Lock;
      // 3a: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 3f: return
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // try (2 -> 8): 34 null
      // try (12 -> 22): 34 null
      // try (22 -> 30): 34 null
      // try (35 -> 37): 34 null
   }

   void release(Key param1) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.locks Ljava/util/Map;
      // 06: aload 1
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
      // 0f: astore 3
      // 10: aload 3
      // 11: ifnull 1b
      // 14: aload 3
      // 15: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.interestedThreads I
      // 18: ifgt 5e
      // 1b: new java/lang/IllegalArgumentException
      // 1e: astore 4
      // 20: new java/lang/StringBuilder
      // 23: astore 5
      // 25: aload 5
      // 27: invokespecial java/lang/StringBuilder.<init> ()V
      // 2a: aload 5
      // 2c: ldc "Cannot release a lock that is not held, key: "
      // 2e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31: aload 1
      // 32: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 35: ldc ", interestedThreads: "
      // 37: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3a: astore 1
      // 3b: aload 3
      // 3c: ifnonnull 56
      // 3f: bipush 0
      // 40: istore 2
      // 41: aload 4
      // 43: aload 1
      // 44: iload 2
      // 45: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 48: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4b: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 4e: aload 4
      // 50: athrow
      // 51: astore 1
      // 52: aload 0
      // 53: monitorexit
      // 54: aload 1
      // 55: athrow
      // 56: aload 3
      // 57: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.interestedThreads I
      // 5a: istore 2
      // 5b: goto 41
      // 5e: aload 3
      // 5f: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.interestedThreads I
      // 62: bipush 1
      // 63: isub
      // 64: istore 2
      // 65: aload 3
      // 66: iload 2
      // 67: putfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.interestedThreads I
      // 6a: iload 2
      // 6b: ifne c7
      // 6e: aload 0
      // 6f: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.locks Ljava/util/Map;
      // 72: aload 1
      // 73: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 78: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
      // 7b: astore 5
      // 7d: aload 5
      // 7f: aload 3
      // 80: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 83: ifne be
      // 86: new java/lang/IllegalStateException
      // 89: astore 6
      // 8b: new java/lang/StringBuilder
      // 8e: astore 4
      // 90: aload 4
      // 92: invokespecial java/lang/StringBuilder.<init> ()V
      // 95: aload 6
      // 97: aload 4
      // 99: ldc "Removed the wrong lock, expected to remove: "
      // 9b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9e: aload 3
      // 9f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // a2: ldc ", but actually removed: "
      // a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a7: aload 5
      // a9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // ac: ldc ", key: "
      // ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b1: aload 1
      // b2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // b5: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // b8: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // bb: aload 6
      // bd: athrow
      // be: aload 0
      // bf: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.writeLockPool Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool;
      // c2: aload 5
      // c4: invokevirtual com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.offer (Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock;)V
      // c7: aload 0
      // c8: monitorexit
      // c9: aload 3
      // ca: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.lock Ljava/util/concurrent/locks/Lock;
      // cd: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // d2: return
      // try (2 -> 8): 39 null
      // try (10 -> 13): 39 null
      // try (13 -> 27): 39 null
      // try (31 -> 39): 39 null
      // try (40 -> 42): 39 null
      // try (44 -> 47): 39 null
      // try (48 -> 56): 39 null
      // try (58 -> 92): 39 null
      // try (92 -> 96): 39 null
      // try (96 -> 98): 39 null
   }

   private static class WriteLock {
      int interestedThreads;
      final Lock lock = new ReentrantLock();

      private WriteLock() {
      }
   }

   private static class WriteLockPool {
      private final Queue<DiskCacheWriteLocker.WriteLock> pool = new ArrayDeque<>();

      private WriteLockPool() {
      }

      DiskCacheWriteLocker.WriteLock obtain() {
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
         // 01: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.pool Ljava/util/Queue;
         // 04: astore 1
         // 05: aload 1
         // 06: monitorenter
         // 07: aload 0
         // 08: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.pool Ljava/util/Queue;
         // 0b: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
         // 10: checkcast com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
         // 13: astore 2
         // 14: aload 1
         // 15: monitorexit
         // 16: aload 2
         // 17: astore 1
         // 18: aload 2
         // 19: ifnonnull 25
         // 1c: new com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock
         // 1f: dup
         // 20: aconst_null
         // 21: invokespecial com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.<init> (Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$1;)V
         // 24: astore 1
         // 25: aload 1
         // 26: areturn
         // 27: astore 2
         // 28: aload 1
         // 29: monitorexit
         // 2a: aload 2
         // 2b: athrow
         // try (5 -> 12): 23 null
         // try (24 -> 26): 23 null
      }

      void offer(DiskCacheWriteLocker.WriteLock param1) {
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
         // 00: aload 0
         // 01: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.pool Ljava/util/Queue;
         // 04: astore 2
         // 05: aload 2
         // 06: monitorenter
         // 07: aload 0
         // 08: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.pool Ljava/util/Queue;
         // 0b: invokeinterface java/util/Queue.size ()I 1
         // 10: bipush 10
         // 12: if_icmpge 20
         // 15: aload 0
         // 16: getfield com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.pool Ljava/util/Queue;
         // 19: aload 1
         // 1a: invokeinterface java/util/Queue.offer (Ljava/lang/Object;)Z 2
         // 1f: pop
         // 20: aload 2
         // 21: monitorexit
         // 22: return
         // 23: astore 1
         // 24: aload 2
         // 25: monitorexit
         // 26: aload 1
         // 27: athrow
         // try (5 -> 15): 18 null
         // try (15 -> 17): 18 null
         // try (19 -> 21): 18 null
      }
   }
}
