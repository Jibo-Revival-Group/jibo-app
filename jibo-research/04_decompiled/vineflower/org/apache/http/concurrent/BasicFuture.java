package org.apache.http.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasicFuture<T> implements Future<T>, Cancellable {
   private final FutureCallback<T> callback;
   private volatile boolean cancelled;
   private volatile boolean completed;
   private volatile Exception ex;
   private volatile T result;

   public BasicFuture(FutureCallback<T> var1) {
      this.callback = var1;
   }

   private T getResult() throws ExecutionException {
      if (this.ex != null) {
         throw new ExecutionException(this.ex);
      } else {
         return this.result;
      }
   }

   @Override
   public boolean cancel() {
      return this.cancel(true);
   }

   @Override
   public boolean cancel(boolean param1) {
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
      // 00: bipush 1
      // 01: istore 2
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield org/apache/http/concurrent/BasicFuture.completed Z
      // 08: ifeq 11
      // 0b: bipush 0
      // 0c: istore 1
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: iload 1
      // 10: ireturn
      // 11: aload 0
      // 12: bipush 1
      // 13: putfield org/apache/http/concurrent/BasicFuture.completed Z
      // 16: aload 0
      // 17: bipush 1
      // 18: putfield org/apache/http/concurrent/BasicFuture.cancelled Z
      // 1b: aload 0
      // 1c: invokevirtual java/lang/Object.notifyAll ()V
      // 1f: aload 0
      // 20: monitorexit
      // 21: iload 2
      // 22: istore 1
      // 23: aload 0
      // 24: getfield org/apache/http/concurrent/BasicFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 27: ifnull 0f
      // 2a: aload 0
      // 2b: getfield org/apache/http/concurrent/BasicFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 2e: invokeinterface org/apache/http/concurrent/FutureCallback.cancelled ()V 1
      // 33: iload 2
      // 34: istore 1
      // 35: goto 0f
      // 38: astore 3
      // 39: aload 0
      // 3a: monitorexit
      // 3b: aload 3
      // 3c: athrow
      // try (4 -> 7): 34 null
      // try (9 -> 11): 34 null
      // try (13 -> 23): 34 null
      // try (35 -> 37): 34 null
   }

   public boolean completed(T param1) {
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
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield org/apache/http/concurrent/BasicFuture.completed Z
      // 08: ifeq 11
      // 0b: bipush 0
      // 0c: istore 2
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: iload 2
      // 10: ireturn
      // 11: aload 0
      // 12: bipush 1
      // 13: putfield org/apache/http/concurrent/BasicFuture.completed Z
      // 16: aload 0
      // 17: aload 1
      // 18: putfield org/apache/http/concurrent/BasicFuture.result Ljava/lang/Object;
      // 1b: aload 0
      // 1c: invokevirtual java/lang/Object.notifyAll ()V
      // 1f: aload 0
      // 20: monitorexit
      // 21: iload 3
      // 22: istore 2
      // 23: aload 0
      // 24: getfield org/apache/http/concurrent/BasicFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 27: ifnull 0f
      // 2a: aload 0
      // 2b: getfield org/apache/http/concurrent/BasicFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 2e: aload 1
      // 2f: invokeinterface org/apache/http/concurrent/FutureCallback.completed (Ljava/lang/Object;)V 2
      // 34: iload 3
      // 35: istore 2
      // 36: goto 0f
      // 39: astore 1
      // 3a: aload 0
      // 3b: monitorexit
      // 3c: aload 1
      // 3d: athrow
      // try (4 -> 7): 35 null
      // try (9 -> 11): 35 null
      // try (13 -> 23): 35 null
      // try (36 -> 38): 35 null
   }

   public boolean failed(Exception param1) {
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
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield org/apache/http/concurrent/BasicFuture.completed Z
      // 08: ifeq 11
      // 0b: bipush 0
      // 0c: istore 2
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: iload 2
      // 10: ireturn
      // 11: aload 0
      // 12: bipush 1
      // 13: putfield org/apache/http/concurrent/BasicFuture.completed Z
      // 16: aload 0
      // 17: aload 1
      // 18: putfield org/apache/http/concurrent/BasicFuture.ex Ljava/lang/Exception;
      // 1b: aload 0
      // 1c: invokevirtual java/lang/Object.notifyAll ()V
      // 1f: aload 0
      // 20: monitorexit
      // 21: iload 3
      // 22: istore 2
      // 23: aload 0
      // 24: getfield org/apache/http/concurrent/BasicFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 27: ifnull 0f
      // 2a: aload 0
      // 2b: getfield org/apache/http/concurrent/BasicFuture.callback Lorg/apache/http/concurrent/FutureCallback;
      // 2e: aload 1
      // 2f: invokeinterface org/apache/http/concurrent/FutureCallback.failed (Ljava/lang/Exception;)V 2
      // 34: iload 3
      // 35: istore 2
      // 36: goto 0f
      // 39: astore 1
      // 3a: aload 0
      // 3b: monitorexit
      // 3c: aload 1
      // 3d: athrow
      // try (4 -> 7): 35 null
      // try (9 -> 11): 35 null
      // try (13 -> 23): 35 null
      // try (36 -> 38): 35 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public T get() throws InterruptedException, ExecutionException {
      synchronized (this){} // $VF: monitorenter 

      Object var1;
      while (true) {
         boolean var3 = false /* VF: Semaphore variable */;

         try {
            var3 = true;
            if (this.completed) {
               var1 = this.getResult();
               var3 = false;
               break;
            }

            this.wait();
            var3 = false;
         } finally {
            if (var3) {
               // $VF: monitorexit
            }
         }
      }

      // $VF: monitorexit
      return (T)var1;
   }

   @Override
   public T get(long param1, TimeUnit param3) throws InterruptedException, ExecutionException, TimeoutException {
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
      // 01: monitorenter
      // 02: aload 3
      // 03: ldc "Time unit"
      // 05: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 08: pop
      // 09: aload 3
      // 0a: lload 1
      // 0b: invokevirtual java/util/concurrent/TimeUnit.toMillis (J)J
      // 0e: lstore 6
      // 10: lload 6
      // 12: lconst_0
      // 13: lcmp
      // 14: ifgt 29
      // 17: lconst_0
      // 18: lstore 1
      // 19: aload 0
      // 1a: getfield org/apache/http/concurrent/BasicFuture.completed Z
      // 1d: ifeq 30
      // 20: aload 0
      // 21: invokespecial org/apache/http/concurrent/BasicFuture.getResult ()Ljava/lang/Object;
      // 24: astore 3
      // 25: aload 0
      // 26: monitorexit
      // 27: aload 3
      // 28: areturn
      // 29: invokestatic java/lang/System.currentTimeMillis ()J
      // 2c: lstore 1
      // 2d: goto 19
      // 30: lload 6
      // 32: lconst_0
      // 33: lcmp
      // 34: ifgt 46
      // 37: new java/util/concurrent/TimeoutException
      // 3a: astore 3
      // 3b: aload 3
      // 3c: invokespecial java/util/concurrent/TimeoutException.<init> ()V
      // 3f: aload 3
      // 40: athrow
      // 41: astore 3
      // 42: aload 0
      // 43: monitorexit
      // 44: aload 3
      // 45: athrow
      // 46: lload 6
      // 48: lstore 4
      // 4a: aload 0
      // 4b: lload 4
      // 4d: invokevirtual java/lang/Object.wait (J)V
      // 50: aload 0
      // 51: getfield org/apache/http/concurrent/BasicFuture.completed Z
      // 54: ifeq 5f
      // 57: aload 0
      // 58: invokespecial org/apache/http/concurrent/BasicFuture.getResult ()Ljava/lang/Object;
      // 5b: astore 3
      // 5c: goto 25
      // 5f: lload 6
      // 61: invokestatic java/lang/System.currentTimeMillis ()J
      // 64: lload 1
      // 65: lsub
      // 66: lsub
      // 67: lstore 8
      // 69: lload 8
      // 6b: lstore 4
      // 6d: lload 8
      // 6f: lconst_0
      // 70: lcmp
      // 71: ifgt 4a
      // 74: new java/util/concurrent/TimeoutException
      // 77: astore 3
      // 78: aload 3
      // 79: invokespecial java/util/concurrent/TimeoutException.<init> ()V
      // 7c: aload 3
      // 7d: athrow
      // try (2 -> 10): 39 null
      // try (16 -> 22): 39 null
      // try (26 -> 28): 39 null
      // try (33 -> 39): 39 null
      // try (46 -> 55): 39 null
      // try (56 -> 62): 39 null
      // try (68 -> 74): 39 null
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public boolean isDone() {
      return this.completed;
   }
}
