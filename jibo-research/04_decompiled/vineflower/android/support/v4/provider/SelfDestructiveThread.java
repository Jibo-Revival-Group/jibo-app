package android.support.v4.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Handler.Callback;
import java.util.concurrent.Callable;

public class SelfDestructiveThread {
   private final Object a = new Object();
   private HandlerThread b;
   private Handler c;
   private int d;
   private Callback e = new Callback(this) {
      final SelfDestructiveThread a;

      {
         this.a = var1;
      }

      public boolean handleMessage(Message var1) {
         switch (var1.what) {
            case 0:
               this.a.a();
               break;
            case 1:
               this.a.b((Runnable)var1.obj);
         }

         return true;
      }
   };
   private final int f;
   private final int g;
   private final String h;

   public SelfDestructiveThread(String var1, int var2, int var3) {
      this.h = var1;
      this.g = var2;
      this.f = var3;
      this.d = 0;
   }

   private void a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/v4/provider/SelfDestructiveThread.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 0b: bipush 1
      // 0c: invokevirtual android/os/Handler.hasMessages (I)Z
      // 0f: ifeq 15
      // 12: aload 2
      // 13: monitorexit
      // 14: return
      // 15: aload 0
      // 16: getfield android/support/v4/provider/SelfDestructiveThread.b Landroid/os/HandlerThread;
      // 19: invokevirtual android/os/HandlerThread.quit ()Z
      // 1c: pop
      // 1d: aload 0
      // 1e: aconst_null
      // 1f: putfield android/support/v4/provider/SelfDestructiveThread.b Landroid/os/HandlerThread;
      // 22: aload 0
      // 23: aconst_null
      // 24: putfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 27: aload 2
      // 28: monitorexit
      // 29: goto 14
      // 2c: astore 1
      // 2d: aload 2
      // 2e: monitorexit
      // 2f: aload 1
      // 30: athrow
      // try (5 -> 12): 26 null
      // try (13 -> 25): 26 null
      // try (27 -> 29): 26 null
   }

   private void a(Runnable param1) {
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
      // 01: getfield android/support/v4/provider/SelfDestructiveThread.a Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield android/support/v4/provider/SelfDestructiveThread.b Landroid/os/HandlerThread;
      // 0b: ifnonnull 4c
      // 0e: new android/os/HandlerThread
      // 11: astore 3
      // 12: aload 3
      // 13: aload 0
      // 14: getfield android/support/v4/provider/SelfDestructiveThread.h Ljava/lang/String;
      // 17: aload 0
      // 18: getfield android/support/v4/provider/SelfDestructiveThread.g I
      // 1b: invokespecial android/os/HandlerThread.<init> (Ljava/lang/String;I)V
      // 1e: aload 0
      // 1f: aload 3
      // 20: putfield android/support/v4/provider/SelfDestructiveThread.b Landroid/os/HandlerThread;
      // 23: aload 0
      // 24: getfield android/support/v4/provider/SelfDestructiveThread.b Landroid/os/HandlerThread;
      // 27: invokevirtual android/os/HandlerThread.start ()V
      // 2a: new android/os/Handler
      // 2d: astore 3
      // 2e: aload 3
      // 2f: aload 0
      // 30: getfield android/support/v4/provider/SelfDestructiveThread.b Landroid/os/HandlerThread;
      // 33: invokevirtual android/os/HandlerThread.getLooper ()Landroid/os/Looper;
      // 36: aload 0
      // 37: getfield android/support/v4/provider/SelfDestructiveThread.e Landroid/os/Handler$Callback;
      // 3a: invokespecial android/os/Handler.<init> (Landroid/os/Looper;Landroid/os/Handler$Callback;)V
      // 3d: aload 0
      // 3e: aload 3
      // 3f: putfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 42: aload 0
      // 43: aload 0
      // 44: getfield android/support/v4/provider/SelfDestructiveThread.d I
      // 47: bipush 1
      // 48: iadd
      // 49: putfield android/support/v4/provider/SelfDestructiveThread.d I
      // 4c: aload 0
      // 4d: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 50: bipush 0
      // 51: invokevirtual android/os/Handler.removeMessages (I)V
      // 54: aload 0
      // 55: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 58: aload 0
      // 59: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 5c: bipush 1
      // 5d: aload 1
      // 5e: invokevirtual android/os/Handler.obtainMessage (ILjava/lang/Object;)Landroid/os/Message;
      // 61: invokevirtual android/os/Handler.sendMessage (Landroid/os/Message;)Z
      // 64: pop
      // 65: aload 2
      // 66: monitorexit
      // 67: return
      // 68: astore 1
      // 69: aload 2
      // 6a: monitorexit
      // 6b: aload 1
      // 6c: athrow
      // try (5 -> 40): 56 null
      // try (40 -> 55): 56 null
      // try (57 -> 59): 56 null
   }

   private void b(Runnable param1) {
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
      // 00: aload 1
      // 01: invokeinterface java/lang/Runnable.run ()V 1
      // 06: aload 0
      // 07: getfield android/support/v4/provider/SelfDestructiveThread.a Ljava/lang/Object;
      // 0a: astore 2
      // 0b: aload 2
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 11: bipush 0
      // 12: invokevirtual android/os/Handler.removeMessages (I)V
      // 15: aload 0
      // 16: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 19: aload 0
      // 1a: getfield android/support/v4/provider/SelfDestructiveThread.c Landroid/os/Handler;
      // 1d: bipush 0
      // 1e: invokevirtual android/os/Handler.obtainMessage (I)Landroid/os/Message;
      // 21: aload 0
      // 22: getfield android/support/v4/provider/SelfDestructiveThread.f I
      // 25: i2l
      // 26: invokevirtual android/os/Handler.sendMessageDelayed (Landroid/os/Message;J)Z
      // 29: pop
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: return
      // 2d: astore 1
      // 2e: aload 2
      // 2f: monitorexit
      // 30: aload 1
      // 31: athrow
      // try (7 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   public <T> T a(Callable<T> param1, int param2) throws InterruptedException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: new java/util/concurrent/locks/ReentrantLock
      // 03: dup
      // 04: invokespecial java/util/concurrent/locks/ReentrantLock.<init> ()V
      // 07: astore 7
      // 09: aload 7
      // 0b: invokevirtual java/util/concurrent/locks/ReentrantLock.newCondition ()Ljava/util/concurrent/locks/Condition;
      // 0e: astore 8
      // 10: new java/util/concurrent/atomic/AtomicReference
      // 13: dup
      // 14: invokespecial java/util/concurrent/atomic/AtomicReference.<init> ()V
      // 17: astore 9
      // 19: new java/util/concurrent/atomic/AtomicBoolean
      // 1c: dup
      // 1d: bipush 1
      // 1e: invokespecial java/util/concurrent/atomic/AtomicBoolean.<init> (Z)V
      // 21: astore 10
      // 23: aload 0
      // 24: new android/support/v4/provider/SelfDestructiveThread$3
      // 27: dup
      // 28: aload 0
      // 29: aload 9
      // 2b: aload 1
      // 2c: aload 7
      // 2e: aload 10
      // 30: aload 8
      // 32: invokespecial android/support/v4/provider/SelfDestructiveThread$3.<init> (Landroid/support/v4/provider/SelfDestructiveThread;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Callable;Ljava/util/concurrent/locks/ReentrantLock;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/locks/Condition;)V
      // 35: invokespecial android/support/v4/provider/SelfDestructiveThread.a (Ljava/lang/Runnable;)V
      // 38: aload 7
      // 3a: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 3d: aload 10
      // 3f: invokevirtual java/util/concurrent/atomic/AtomicBoolean.get ()Z
      // 42: ifne 52
      // 45: aload 9
      // 47: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 4a: astore 1
      // 4b: aload 7
      // 4d: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 50: aload 1
      // 51: areturn
      // 52: getstatic java/util/concurrent/TimeUnit.MILLISECONDS Ljava/util/concurrent/TimeUnit;
      // 55: iload 2
      // 56: i2l
      // 57: invokevirtual java/util/concurrent/TimeUnit.toNanos (J)J
      // 5a: lstore 3
      // 5b: aload 8
      // 5d: lload 3
      // 5e: invokeinterface java/util/concurrent/locks/Condition.awaitNanos (J)J 3
      // 63: lstore 5
      // 65: aload 10
      // 67: invokevirtual java/util/concurrent/atomic/AtomicBoolean.get ()Z
      // 6a: ifne 7b
      // 6d: aload 9
      // 6f: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 72: astore 1
      // 73: aload 7
      // 75: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 78: goto 50
      // 7b: lload 5
      // 7d: lstore 3
      // 7e: lload 5
      // 80: lconst_0
      // 81: lcmp
      // 82: ifgt 5b
      // 85: new java/lang/InterruptedException
      // 88: astore 1
      // 89: aload 1
      // 8a: ldc "timeout"
      // 8c: invokespecial java/lang/InterruptedException.<init> (Ljava/lang/String;)V
      // 8f: aload 1
      // 90: athrow
      // 91: astore 1
      // 92: aload 7
      // 94: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 97: aload 1
      // 98: athrow
      // 99: astore 1
      // 9a: lload 3
      // 9b: lstore 5
      // 9d: goto 65
      // try (29 -> 35): 70 null
      // try (39 -> 44): 70 null
      // try (44 -> 48): 75 java/lang/InterruptedException
      // try (44 -> 48): 70 null
      // try (48 -> 54): 70 null
      // try (63 -> 70): 70 null
   }

   public <T> void a(Callable<T> var1, SelfDestructiveThread.ReplyCallback<T> var2) {
      this.a(new Runnable(this, var1, new Handler(), var2) {
         final Callable a;
         final Handler b;
         final SelfDestructiveThread.ReplyCallback c;
         final SelfDestructiveThread d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3;
            this.c = var4;
         }

         @Override
         public void run() {
            Object var1x;
            try {
               var1x = this.a.call();
            } catch (Exception var2x) {
               var1x = null;
            }

            this.b.post(new Runnable(this, var1x) {
               final Object a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  this.b.c.a(this.a);
               }
            });
         }
      });
   }

   public interface ReplyCallback<T> {
      void a(T var1);
   }
}
