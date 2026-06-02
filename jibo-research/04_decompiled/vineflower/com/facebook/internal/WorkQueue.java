package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

public class WorkQueue {
   static final boolean $assertionsDisabled;
   public static final int DEFAULT_MAX_CONCURRENT = 8;
   private final Executor executor;
   private final int maxConcurrent;
   private WorkQueue.WorkNode pendingJobs;
   private int runningCount;
   private WorkQueue.WorkNode runningJobs;
   private final Object workLock = new Object();

   static {
      boolean var0;
      if (!WorkQueue.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public WorkQueue() {
      this(8);
   }

   public WorkQueue(int var1) {
      this(var1, FacebookSdk.getExecutor());
   }

   public WorkQueue(int var1, Executor var2) {
      this.runningJobs = null;
      this.runningCount = 0;
      this.maxConcurrent = var1;
      this.executor = var2;
   }

   private void execute(WorkQueue.WorkNode var1) {
      this.executor.execute(new Runnable(this, var1) {
         final WorkQueue this$0;
         final WorkQueue.WorkNode val$node;

         {
            this.this$0 = var1;
            this.val$node = var2;
         }

         @Override
         public void run() {
            try {
               this.val$node.getCallback().run();
            } finally {
               this.this$0.finishItemAndStartNew(this.val$node);
            }
         }
      });
   }

   private void finishItemAndStartNew(WorkQueue.WorkNode param1) {
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
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 0
      // 03: getfield com/facebook/internal/WorkQueue.workLock Ljava/lang/Object;
      // 06: astore 3
      // 07: aload 3
      // 08: monitorenter
      // 09: aload 1
      // 0a: ifnull 23
      // 0d: aload 0
      // 0e: aload 1
      // 0f: aload 0
      // 10: getfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 13: invokevirtual com/facebook/internal/WorkQueue$WorkNode.removeFromList (Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
      // 16: putfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 19: aload 0
      // 1a: aload 0
      // 1b: getfield com/facebook/internal/WorkQueue.runningCount I
      // 1e: bipush 1
      // 1f: isub
      // 20: putfield com/facebook/internal/WorkQueue.runningCount I
      // 23: aload 2
      // 24: astore 1
      // 25: aload 0
      // 26: getfield com/facebook/internal/WorkQueue.runningCount I
      // 29: aload 0
      // 2a: getfield com/facebook/internal/WorkQueue.maxConcurrent I
      // 2d: if_icmpge 65
      // 30: aload 0
      // 31: getfield com/facebook/internal/WorkQueue.pendingJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 34: astore 2
      // 35: aload 2
      // 36: astore 1
      // 37: aload 2
      // 38: ifnull 65
      // 3b: aload 0
      // 3c: aload 2
      // 3d: aload 0
      // 3e: getfield com/facebook/internal/WorkQueue.pendingJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 41: invokevirtual com/facebook/internal/WorkQueue$WorkNode.removeFromList (Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
      // 44: putfield com/facebook/internal/WorkQueue.pendingJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 47: aload 0
      // 48: aload 2
      // 49: aload 0
      // 4a: getfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 4d: bipush 0
      // 4e: invokevirtual com/facebook/internal/WorkQueue$WorkNode.addToList (Lcom/facebook/internal/WorkQueue$WorkNode;Z)Lcom/facebook/internal/WorkQueue$WorkNode;
      // 51: putfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 54: aload 0
      // 55: aload 0
      // 56: getfield com/facebook/internal/WorkQueue.runningCount I
      // 59: bipush 1
      // 5a: iadd
      // 5b: putfield com/facebook/internal/WorkQueue.runningCount I
      // 5e: aload 2
      // 5f: bipush 1
      // 60: invokevirtual com/facebook/internal/WorkQueue$WorkNode.setIsRunning (Z)V
      // 63: aload 2
      // 64: astore 1
      // 65: aload 3
      // 66: monitorexit
      // 67: aload 1
      // 68: ifnull 70
      // 6b: aload 0
      // 6c: aload 1
      // 6d: invokespecial com/facebook/internal/WorkQueue.execute (Lcom/facebook/internal/WorkQueue$WorkNode;)V
      // 70: return
      // 71: astore 1
      // 72: aload 3
      // 73: monitorexit
      // 74: aload 1
      // 75: athrow
      // try (9 -> 21): 67 null
      // try (23 -> 31): 67 null
      // try (35 -> 57): 67 null
      // try (59 -> 61): 67 null
      // try (68 -> 70): 67 null
   }

   private void startItem() {
      this.finishItemAndStartNew(null);
   }

   public WorkQueue.WorkItem addActiveWorkItem(Runnable var1) {
      return this.addActiveWorkItem(var1, true);
   }

   public WorkQueue.WorkItem addActiveWorkItem(Runnable param1, boolean param2) {
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
      // 00: new com/facebook/internal/WorkQueue$WorkNode
      // 03: dup
      // 04: aload 0
      // 05: aload 1
      // 06: invokespecial com/facebook/internal/WorkQueue$WorkNode.<init> (Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V
      // 09: astore 3
      // 0a: aload 0
      // 0b: getfield com/facebook/internal/WorkQueue.workLock Ljava/lang/Object;
      // 0e: astore 1
      // 0f: aload 1
      // 10: monitorenter
      // 11: aload 0
      // 12: aload 3
      // 13: aload 0
      // 14: getfield com/facebook/internal/WorkQueue.pendingJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 17: iload 2
      // 18: invokevirtual com/facebook/internal/WorkQueue$WorkNode.addToList (Lcom/facebook/internal/WorkQueue$WorkNode;Z)Lcom/facebook/internal/WorkQueue$WorkNode;
      // 1b: putfield com/facebook/internal/WorkQueue.pendingJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 1e: aload 1
      // 1f: monitorexit
      // 20: aload 0
      // 21: invokespecial com/facebook/internal/WorkQueue.startItem ()V
      // 24: aload 3
      // 25: areturn
      // 26: astore 3
      // 27: aload 1
      // 28: monitorexit
      // 29: aload 3
      // 2a: athrow
      // try (11 -> 20): 24 null
      // try (25 -> 27): 24 null
   }

   public void validate() {
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
      // 01: getfield com/facebook/internal/WorkQueue.workLock Ljava/lang/Object;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: bipush 0
      // 0a: istore 1
      // 0b: bipush 0
      // 0c: istore 2
      // 0d: aload 0
      // 0e: getfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 11: ifnull 3a
      // 14: aload 0
      // 15: getfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 18: astore 3
      // 19: iload 2
      // 1a: istore 1
      // 1b: aload 3
      // 1c: bipush 1
      // 1d: invokevirtual com/facebook/internal/WorkQueue$WorkNode.verify (Z)V
      // 20: iload 1
      // 21: bipush 1
      // 22: iadd
      // 23: istore 2
      // 24: aload 3
      // 25: invokevirtual com/facebook/internal/WorkQueue$WorkNode.getNext ()Lcom/facebook/internal/WorkQueue$WorkNode;
      // 28: astore 4
      // 2a: iload 2
      // 2b: istore 1
      // 2c: aload 4
      // 2e: astore 3
      // 2f: aload 4
      // 31: aload 0
      // 32: getfield com/facebook/internal/WorkQueue.runningJobs Lcom/facebook/internal/WorkQueue$WorkNode;
      // 35: if_acmpne 1b
      // 38: iload 2
      // 39: istore 1
      // 3a: getstatic com/facebook/internal/WorkQueue.$assertionsDisabled Z
      // 3d: ifne 58
      // 40: aload 0
      // 41: getfield com/facebook/internal/WorkQueue.runningCount I
      // 44: iload 1
      // 45: if_icmpeq 58
      // 48: new java/lang/AssertionError
      // 4b: astore 3
      // 4c: aload 3
      // 4d: invokespecial java/lang/AssertionError.<init> ()V
      // 50: aload 3
      // 51: athrow
      // 52: astore 3
      // 53: aload 5
      // 55: monitorexit
      // 56: aload 3
      // 57: athrow
      // 58: aload 5
      // 5a: monitorexit
      // 5b: return
      // try (9 -> 15): 49 null
      // try (17 -> 20): 49 null
      // try (24 -> 27): 49 null
      // try (31 -> 35): 49 null
      // try (37 -> 49): 49 null
      // try (50 -> 52): 49 null
      // try (54 -> 56): 49 null
   }

   public interface WorkItem {
      boolean cancel();

      boolean isRunning();

      void moveToFront();
   }

   private class WorkNode implements WorkQueue.WorkItem {
      static final boolean $assertionsDisabled;
      private final Runnable callback;
      private boolean isRunning;
      private WorkQueue.WorkNode next;
      private WorkQueue.WorkNode prev;
      final WorkQueue this$0;

      static {
         boolean var0;
         if (!WorkQueue.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         $assertionsDisabled = var0;
      }

      WorkNode(WorkQueue var1, Runnable var2) {
         this.this$0 = var1;
         this.callback = var2;
      }

      WorkQueue.WorkNode addToList(WorkQueue.WorkNode var1, boolean var2) {
         if (!$assertionsDisabled && this.next != null) {
            throw new AssertionError();
         }

         if (!$assertionsDisabled && this.prev != null) {
            throw new AssertionError();
         }

         if (var1 == null) {
            this.prev = this;
            this.next = this;
            var1 = this;
         } else {
            this.next = var1;
            this.prev = var1.prev;
            WorkQueue.WorkNode var3 = this.next;
            this.prev.next = this;
            var3.prev = this;
         }

         if (var2) {
            var1 = this;
         }

         return var1;
      }

      @Override
      public boolean cancel() {
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
         // 01: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 04: invokestatic com/facebook/internal/WorkQueue.access$100 (Lcom/facebook/internal/WorkQueue;)Ljava/lang/Object;
         // 07: astore 3
         // 08: aload 3
         // 09: monitorenter
         // 0a: aload 0
         // 0b: invokevirtual com/facebook/internal/WorkQueue$WorkNode.isRunning ()Z
         // 0e: ifne 2a
         // 11: aload 0
         // 12: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 15: aload 0
         // 16: aload 0
         // 17: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 1a: invokestatic com/facebook/internal/WorkQueue.access$200 (Lcom/facebook/internal/WorkQueue;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 1d: invokevirtual com/facebook/internal/WorkQueue$WorkNode.removeFromList (Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 20: invokestatic com/facebook/internal/WorkQueue.access$202 (Lcom/facebook/internal/WorkQueue;Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 23: pop
         // 24: bipush 1
         // 25: istore 1
         // 26: aload 3
         // 27: monitorexit
         // 28: iload 1
         // 29: ireturn
         // 2a: aload 3
         // 2b: monitorexit
         // 2c: bipush 0
         // 2d: istore 1
         // 2e: goto 28
         // 31: astore 2
         // 32: aload 3
         // 33: monitorexit
         // 34: aload 2
         // 35: athrow
         // try (6 -> 18): 29 null
         // try (20 -> 22): 29 null
         // try (24 -> 26): 29 null
         // try (30 -> 32): 29 null
      }

      Runnable getCallback() {
         return this.callback;
      }

      WorkQueue.WorkNode getNext() {
         return this.next;
      }

      @Override
      public boolean isRunning() {
         return this.isRunning;
      }

      @Override
      public void moveToFront() {
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
         // 01: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 04: invokestatic com/facebook/internal/WorkQueue.access$100 (Lcom/facebook/internal/WorkQueue;)Ljava/lang/Object;
         // 07: astore 1
         // 08: aload 1
         // 09: monitorenter
         // 0a: aload 0
         // 0b: invokevirtual com/facebook/internal/WorkQueue$WorkNode.isRunning ()Z
         // 0e: ifne 38
         // 11: aload 0
         // 12: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 15: aload 0
         // 16: aload 0
         // 17: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 1a: invokestatic com/facebook/internal/WorkQueue.access$200 (Lcom/facebook/internal/WorkQueue;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 1d: invokevirtual com/facebook/internal/WorkQueue$WorkNode.removeFromList (Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 20: invokestatic com/facebook/internal/WorkQueue.access$202 (Lcom/facebook/internal/WorkQueue;Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 23: pop
         // 24: aload 0
         // 25: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 28: aload 0
         // 29: aload 0
         // 2a: getfield com/facebook/internal/WorkQueue$WorkNode.this$0 Lcom/facebook/internal/WorkQueue;
         // 2d: invokestatic com/facebook/internal/WorkQueue.access$200 (Lcom/facebook/internal/WorkQueue;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 30: bipush 1
         // 31: invokevirtual com/facebook/internal/WorkQueue$WorkNode.addToList (Lcom/facebook/internal/WorkQueue$WorkNode;Z)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 34: invokestatic com/facebook/internal/WorkQueue.access$202 (Lcom/facebook/internal/WorkQueue;Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;
         // 37: pop
         // 38: aload 1
         // 39: monitorexit
         // 3a: return
         // 3b: astore 2
         // 3c: aload 1
         // 3d: monitorexit
         // 3e: aload 2
         // 3f: athrow
         // try (6 -> 28): 31 null
         // try (28 -> 30): 31 null
         // try (32 -> 34): 31 null
      }

      WorkQueue.WorkNode removeFromList(WorkQueue.WorkNode var1) {
         if (!$assertionsDisabled && this.next == null) {
            throw new AssertionError();
         }

         if (!$assertionsDisabled && this.prev == null) {
            throw new AssertionError();
         }

         WorkQueue.WorkNode var2 = var1;
         if (var1 == this) {
            if (this.next == this) {
               var2 = null;
            } else {
               var2 = this.next;
            }
         }

         this.next.prev = this.prev;
         this.prev.next = this.next;
         this.prev = null;
         this.next = null;
         return var2;
      }

      void setIsRunning(boolean var1) {
         this.isRunning = var1;
      }

      void verify(boolean var1) {
         if (!$assertionsDisabled && this.prev.next != this) {
            throw new AssertionError();
         }

         if (!$assertionsDisabled && this.next.prev != this) {
            throw new AssertionError();
         }

         if (!$assertionsDisabled && this.isRunning() != var1) {
            throw new AssertionError();
         }
      }
   }
}
