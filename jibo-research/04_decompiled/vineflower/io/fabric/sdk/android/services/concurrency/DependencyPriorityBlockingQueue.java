package io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DependencyPriorityBlockingQueue<E extends Dependency & Task & PriorityProvider> extends PriorityBlockingQueue<E> {
   final Queue<E> a = new LinkedList<>();
   private final ReentrantLock b = new ReentrantLock();

   public E a() throws InterruptedException {
      return this.b(0, null, null);
   }

   E a(int var1, Long var2, TimeUnit var3) throws InterruptedException {
      Dependency var4;
      switch (var1) {
         case 0:
            var4 = super.take();
            break;
         case 1:
            var4 = super.peek();
            break;
         case 2:
            var4 = super.poll();
            break;
         case 3:
            var4 = super.poll(var2, var3);
            break;
         default:
            var4 = null;
      }

      return (E)var4;
   }

   public E a(long var1, TimeUnit var3) throws InterruptedException {
      return this.b(3, var1, var3);
   }

   boolean a(int param1, E param2) {
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
      // 01: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 04: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 07: iload 1
      // 08: bipush 1
      // 09: if_icmpne 12
      // 0c: aload 0
      // 0d: aload 2
      // 0e: invokespecial java/util/concurrent/PriorityBlockingQueue.remove (Ljava/lang/Object;)Z
      // 11: pop
      // 12: aload 0
      // 13: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 16: aload 2
      // 17: invokeinterface java/util/Queue.offer (Ljava/lang/Object;)Z 2
      // 1c: istore 3
      // 1d: aload 0
      // 1e: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 21: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 24: iload 3
      // 25: ireturn
      // 26: astore 2
      // 27: aload 0
      // 28: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 2b: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 2e: aload 2
      // 2f: athrow
      // try (0 -> 3): 20 null
      // try (6 -> 10): 20 null
      // try (10 -> 15): 20 null
   }

   boolean a(E var1) {
      return var1.d();
   }

   <T> T[] a(T[] var1, T[] var2) {
      int var4 = var1.length;
      int var3 = var2.length;
      Object[] var5 = (Object[])Array.newInstance(var1.getClass().getComponentType(), var4 + var3);
      System.arraycopy(var1, 0, var5, 0, var4);
      System.arraycopy(var2, 0, var5, var4, var3);
      return (T[])var5;
   }

   public E b() {
      Object var1 = null;

      Dependency var2;
      try {
         var2 = this.b(1, null, null);
      } catch (InterruptedException var3) {
         return (E)var1;
      }

      return (E)var2;
   }

   E b(int var1, Long var2, TimeUnit var3) throws InterruptedException {
      while (true) {
         Dependency var4 = this.a(var1, var2, var3);
         if (var4 == null || this.a((E)var4)) {
            return (E)var4;
         }

         this.a(var1, (E)var4);
      }
   }

   public E c() {
      Object var1 = null;

      Dependency var2;
      try {
         var2 = this.b(2, null, null);
      } catch (InterruptedException var3) {
         return (E)var1;
      }

      return (E)var2;
   }

   @Override
   public void clear() {
      try {
         this.b.lock();
         this.a.clear();
         super.clear();
      } finally {
         this.b.unlock();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public boolean contains(Object var1) {
      boolean var4 = false /* VF: Semaphore variable */;

      boolean var6;
      label34: {
         label33: {
            try {
               var4 = true;
               this.b.lock();
               if (super.contains(var1)) {
                  var4 = false;
                  break label33;
               }

               var6 = this.a.contains(var1);
               var4 = false;
            } finally {
               if (var4) {
                  this.b.unlock();
               }
            }

            if (!var6) {
               var6 = false;
               break label34;
            }
         }

         var6 = true;
      }

      this.b.unlock();
      return var6;
   }

   public void d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 04: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 07: aload 0
      // 08: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 0b: invokeinterface java/util/Queue.iterator ()Ljava/util/Iterator; 1
      // 10: astore 1
      // 11: aload 1
      // 12: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17: ifeq 45
      // 1a: aload 1
      // 1b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20: checkcast io/fabric/sdk/android/services/concurrency/Dependency
      // 23: astore 2
      // 24: aload 0
      // 25: aload 2
      // 26: invokevirtual io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a (Lio/fabric/sdk/android/services/concurrency/Dependency;)Z
      // 29: ifeq 11
      // 2c: aload 0
      // 2d: aload 2
      // 2e: invokespecial java/util/concurrent/PriorityBlockingQueue.offer (Ljava/lang/Object;)Z
      // 31: pop
      // 32: aload 1
      // 33: invokeinterface java/util/Iterator.remove ()V 1
      // 38: goto 11
      // 3b: astore 1
      // 3c: aload 0
      // 3d: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 40: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 43: aload 1
      // 44: athrow
      // 45: aload 0
      // 46: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 49: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 4c: return
      // try (0 -> 7): 25 null
      // try (7 -> 24): 25 null
   }

   @Override
   public int drainTo(Collection<? super E> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 04: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 07: aload 0
      // 08: aload 1
      // 09: invokespecial java/util/concurrent/PriorityBlockingQueue.drainTo (Ljava/util/Collection;)I
      // 0c: istore 2
      // 0d: aload 0
      // 0e: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 11: invokeinterface java/util/Queue.size ()I 1
      // 16: istore 3
      // 17: aload 0
      // 18: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 1b: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 20: ifne 40
      // 23: aload 1
      // 24: aload 0
      // 25: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 28: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 2d: invokeinterface java/util/Collection.add (Ljava/lang/Object;)Z 2
      // 32: pop
      // 33: goto 17
      // 36: astore 1
      // 37: aload 0
      // 38: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 3b: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 3e: aload 1
      // 3f: athrow
      // 40: aload 0
      // 41: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 44: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 47: iload 2
      // 48: iload 3
      // 49: iadd
      // 4a: ireturn
      // try (0 -> 11): 22 null
      // try (11 -> 21): 22 null
   }

   @Override
   public int drainTo(Collection<? super E> param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 04: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 07: aload 0
      // 08: aload 1
      // 09: iload 2
      // 0a: invokespecial java/util/concurrent/PriorityBlockingQueue.drainTo (Ljava/util/Collection;I)I
      // 0d: istore 3
      // 0e: aload 0
      // 0f: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 12: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 17: ifne 35
      // 1a: iload 3
      // 1b: iload 2
      // 1c: if_icmpgt 35
      // 1f: aload 1
      // 20: aload 0
      // 21: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.a Ljava/util/Queue;
      // 24: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 29: invokeinterface java/util/Collection.add (Ljava/lang/Object;)Z 2
      // 2e: pop
      // 2f: iinc 3 1
      // 32: goto 0e
      // 35: aload 0
      // 36: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 39: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 3c: iload 3
      // 3d: ireturn
      // 3e: astore 1
      // 3f: aload 0
      // 40: getfield io/fabric/sdk/android/services/concurrency/DependencyPriorityBlockingQueue.b Ljava/util/concurrent/locks/ReentrantLock;
      // 43: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 46: aload 1
      // 47: athrow
      // try (0 -> 8): 28 null
      // try (8 -> 12): 28 null
      // try (15 -> 21): 28 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public boolean remove(Object var1) {
      boolean var4 = false /* VF: Semaphore variable */;

      boolean var6;
      label34: {
         label33: {
            try {
               var4 = true;
               this.b.lock();
               if (super.remove(var1)) {
                  var4 = false;
                  break label33;
               }

               var6 = this.a.remove(var1);
               var4 = false;
            } finally {
               if (var4) {
                  this.b.unlock();
               }
            }

            if (!var6) {
               var6 = false;
               break label34;
            }
         }

         var6 = true;
      }

      this.b.unlock();
      return var6;
   }

   @Override
   public boolean removeAll(Collection<?> var1) {
      boolean var2;
      boolean var3;
      try {
         this.b.lock();
         var2 = super.removeAll(var1);
         var3 = this.a.removeAll(var1);
      } finally {
         this.b.unlock();
      }

      return var2 | var3;
   }

   @Override
   public int size() {
      int var1;
      int var2;
      try {
         this.b.lock();
         var2 = this.a.size();
         var1 = super.size();
      } finally {
         this.b.unlock();
      }

      return var2 + var1;
   }

   @Override
   public Object[] toArray() {
      try {
         this.b.lock();
         return this.a(super.toArray(), this.a.toArray());
      } finally {
         this.b.unlock();
      }
   }

   @Override
   public <T> T[] toArray(T[] var1) {
      try {
         this.b.lock();
         return (T[])this.a(super.toArray(var1), this.a.toArray(var1));
      } finally {
         this.b.unlock();
      }
   }
}
