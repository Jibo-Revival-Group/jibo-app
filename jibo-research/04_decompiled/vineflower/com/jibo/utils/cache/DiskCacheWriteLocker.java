package com.jibo.utils.cache;

import com.bumptech.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {
   private final Map<Key, DiskCacheWriteLocker.WriteLock> a = new HashMap<>();
   private final DiskCacheWriteLocker.WriteLockPool b = new DiskCacheWriteLocker.WriteLockPool();

   void a(Key param1) {
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
      // 03: getfield com/jibo/utils/cache/DiskCacheWriteLocker.a Ljava/util/Map;
      // 06: aload 1
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock
      // 0f: astore 3
      // 10: aload 3
      // 11: astore 2
      // 12: aload 3
      // 13: ifnonnull 2a
      // 16: aload 0
      // 17: getfield com/jibo/utils/cache/DiskCacheWriteLocker.b Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;
      // 1a: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a ()Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;
      // 1d: astore 2
      // 1e: aload 0
      // 1f: getfield com/jibo/utils/cache/DiskCacheWriteLocker.a Ljava/util/Map;
      // 22: aload 1
      // 23: aload 2
      // 24: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 29: pop
      // 2a: aload 2
      // 2b: aload 2
      // 2c: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 2f: bipush 1
      // 30: iadd
      // 31: putfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 34: aload 0
      // 35: monitorexit
      // 36: aload 2
      // 37: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.a Ljava/util/concurrent/locks/Lock;
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

   void b(Key param1) {
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
      // 03: getfield com/jibo/utils/cache/DiskCacheWriteLocker.a Ljava/util/Map;
      // 06: aload 1
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: invokestatic com/jibo/utils/cache/Preconditions.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock
      // 12: astore 2
      // 13: aload 2
      // 14: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 17: bipush 1
      // 18: if_icmpge 4e
      // 1b: new java/lang/IllegalStateException
      // 1e: astore 3
      // 1f: new java/lang/StringBuilder
      // 22: astore 4
      // 24: aload 4
      // 26: invokespecial java/lang/StringBuilder.<init> ()V
      // 29: aload 3
      // 2a: aload 4
      // 2c: ldc "Cannot release a lock that is not held, key: "
      // 2e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31: aload 1
      // 32: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 35: ldc ", interestedThreads: "
      // 37: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3a: aload 2
      // 3b: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 3e: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 41: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 44: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 47: aload 3
      // 48: athrow
      // 49: astore 1
      // 4a: aload 0
      // 4b: monitorexit
      // 4c: aload 1
      // 4d: athrow
      // 4e: aload 2
      // 4f: aload 2
      // 50: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 53: bipush 1
      // 54: isub
      // 55: putfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 58: aload 2
      // 59: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.b I
      // 5c: ifne b5
      // 5f: aload 0
      // 60: getfield com/jibo/utils/cache/DiskCacheWriteLocker.a Ljava/util/Map;
      // 63: aload 1
      // 64: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 69: checkcast com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock
      // 6c: astore 4
      // 6e: aload 4
      // 70: aload 2
      // 71: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 74: ifne ac
      // 77: new java/lang/IllegalStateException
      // 7a: astore 5
      // 7c: new java/lang/StringBuilder
      // 7f: astore 3
      // 80: aload 3
      // 81: invokespecial java/lang/StringBuilder.<init> ()V
      // 84: aload 5
      // 86: aload 3
      // 87: ldc "Removed the wrong lock, expected to remove: "
      // 89: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 8c: aload 2
      // 8d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 90: ldc ", but actually removed: "
      // 92: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 95: aload 4
      // 97: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 9a: ldc ", key: "
      // 9c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9f: aload 1
      // a0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // a3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a6: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // a9: aload 5
      // ab: athrow
      // ac: aload 0
      // ad: getfield com/jibo/utils/cache/DiskCacheWriteLocker.b Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;
      // b0: aload 4
      // b2: invokevirtual com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a (Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;)V
      // b5: aload 0
      // b6: monitorexit
      // b7: aload 2
      // b8: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.a Ljava/util/concurrent/locks/Lock;
      // bb: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // c0: return
      // try (2 -> 34): 34 null
      // try (35 -> 37): 34 null
      // try (39 -> 82): 34 null
      // try (82 -> 86): 34 null
      // try (86 -> 88): 34 null
   }

   private static class WriteLock {
      final Lock a = new ReentrantLock();
      int b;

      private WriteLock() {
      }
   }

   private static class WriteLockPool {
      private final Queue<DiskCacheWriteLocker.WriteLock> a = new ArrayDeque<>();

      private WriteLockPool() {
      }

      DiskCacheWriteLocker.WriteLock a() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a Ljava/util/Queue;
         // 04: astore 1
         // 05: aload 1
         // 06: monitorenter
         // 07: aload 0
         // 08: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a Ljava/util/Queue;
         // 0b: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
         // 10: checkcast com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock
         // 13: astore 2
         // 14: aload 1
         // 15: monitorexit
         // 16: aload 2
         // 17: astore 1
         // 18: aload 2
         // 19: ifnonnull 25
         // 1c: new com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock
         // 1f: dup
         // 20: aconst_null
         // 21: invokespecial com/jibo/utils/cache/DiskCacheWriteLocker$WriteLock.<init> (Lcom/jibo/utils/cache/DiskCacheWriteLocker$1;)V
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

      void a(DiskCacheWriteLocker.WriteLock param1) {
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
         // 01: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a Ljava/util/Queue;
         // 04: astore 2
         // 05: aload 2
         // 06: monitorenter
         // 07: aload 0
         // 08: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a Ljava/util/Queue;
         // 0b: invokeinterface java/util/Queue.size ()I 1
         // 10: bipush 10
         // 12: if_icmpge 20
         // 15: aload 0
         // 16: getfield com/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool.a Ljava/util/Queue;
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
