package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;

@ThreadSafe
abstract class PoolEntryFuture<T> implements Future<T> {
   private final FutureCallback<T> callback;
   private volatile boolean cancelled;
   private volatile boolean completed;
   private final Condition condition;
   private final Lock lock;
   private T result;

   PoolEntryFuture(Lock var1, FutureCallback<T> var2) {
      this.lock = var1;
      this.condition = var1.newCondition();
      this.callback = var2;
   }

   public boolean await(Date param1) throws InterruptedException {
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
      // 01: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield org/apache/http/pool/PoolEntryFuture.cancelled Z
      // 0d: ifeq 28
      // 10: new java/lang/InterruptedException
      // 13: astore 1
      // 14: aload 1
      // 15: ldc "Operation interrupted"
      // 17: invokespecial java/lang/InterruptedException.<init> (Ljava/lang/String;)V
      // 1a: aload 1
      // 1b: athrow
      // 1c: astore 1
      // 1d: aload 0
      // 1e: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 21: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 26: aload 1
      // 27: athrow
      // 28: aload 1
      // 29: ifnull 4a
      // 2c: aload 0
      // 2d: getfield org/apache/http/pool/PoolEntryFuture.condition Ljava/util/concurrent/locks/Condition;
      // 30: aload 1
      // 31: invokeinterface java/util/concurrent/locks/Condition.awaitUntil (Ljava/util/Date;)Z 2
      // 36: istore 2
      // 37: aload 0
      // 38: getfield org/apache/http/pool/PoolEntryFuture.cancelled Z
      // 3b: ifeq 58
      // 3e: new java/lang/InterruptedException
      // 41: astore 1
      // 42: aload 1
      // 43: ldc "Operation interrupted"
      // 45: invokespecial java/lang/InterruptedException.<init> (Ljava/lang/String;)V
      // 48: aload 1
      // 49: athrow
      // 4a: aload 0
      // 4b: getfield org/apache/http/pool/PoolEntryFuture.condition Ljava/util/concurrent/locks/Condition;
      // 4e: invokeinterface java/util/concurrent/locks/Condition.await ()V 1
      // 53: bipush 1
      // 54: istore 2
      // 55: goto 37
      // 58: aload 0
      // 59: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 5c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 61: iload 2
      // 62: ireturn
      // try (3 -> 13): 13 null
      // try (21 -> 26): 13 null
      // try (26 -> 36): 13 null
      // try (36 -> 39): 13 null
   }

   @Override
   public boolean cancel(boolean param1) {
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
      // 00: bipush 1
      // 01: istore 1
      // 02: aload 0
      // 03: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 06: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 0b: aload 0
      // 0c: getfield org/apache/http/pool/PoolEntryFuture.completed Z
      // 0f: istore 2
      // 10: iload 2
      // 11: ifeq 21
      // 14: bipush 0
      // 15: istore 1
      // 16: aload 0
      // 17: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 1a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 1f: iload 1
      // 20: ireturn
      // 21: aload 0
      // 22: bipush 1
      // 23: putfield org/apache/http/pool/PoolEntryFuture.completed Z
      // 26: aload 0
      // 27: bipush 1
      // 28: putfield org/apache/http/pool/PoolEntryFuture.cancelled Z
      // 2b: aload 0
      // 2c: getfield org/apache/http/pool/PoolEntryFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 2f: ifnull 3b
      // 32: aload 0
      // 33: getfield org/apache/http/pool/PoolEntryFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 36: invokeinterface org/apache/http/concurrent/FutureCallback.cancelled ()V 1
      // 3b: aload 0
      // 3c: getfield org/apache/http/pool/PoolEntryFuture.condition Ljava/util/concurrent/locks/Condition;
      // 3f: invokeinterface java/util/concurrent/locks/Condition.signalAll ()V 1
      // 44: aload 0
      // 45: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 48: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 4d: goto 1f
      // 50: astore 3
      // 51: aload 0
      // 52: getfield org/apache/http/pool/PoolEntryFuture.lock Ljava/util/concurrent/locks/Lock;
      // 55: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 5a: aload 3
      // 5b: athrow
      // try (5 -> 8): 36 null
      // try (17 -> 29): 36 null
      // try (29 -> 32): 36 null
   }

   @Override
   public T get() throws InterruptedException, ExecutionException {
      try {
         return this.get(0L, TimeUnit.MILLISECONDS);
      } catch (TimeoutException var2) {
         throw new ExecutionException(var2);
      }
   }

   @Override
   public T get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      Args.notNull(var3, "Time unit");
      this.lock.lock();

      try {
         if (this.completed) {
            var9 = this.result;
         } else {
            this.result = this.getPoolEntry(var1, var3);
            this.completed = true;
            if (this.callback != null) {
               this.callback.completed(this.result);
            }

            var9 = this.result;
         }
      } catch (IOException var7) {
         this.completed = true;
         this.result = null;
         if (this.callback != null) {
            this.callback.failed(var7);
         }

         ExecutionException var4 = new ExecutionException(var7);
         throw var4;
      } finally {
         this.lock.unlock();
      }

      return (T)var9;
   }

   protected abstract T getPoolEntry(long var1, TimeUnit var3) throws IOException, InterruptedException, TimeoutException;

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public boolean isDone() {
      return this.completed;
   }

   public void wakeup() {
      this.lock.lock();

      try {
         this.condition.signalAll();
      } finally {
         this.lock.unlock();
      }
   }
}
