package android.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultTaskExecutor extends TaskExecutor {
   private final Object a = new Object();
   private ExecutorService b = Executors.newFixedThreadPool(2);
   private volatile Handler c;

   @Override
   public void a(Runnable var1) {
      this.b.execute(var1);
   }

   @Override
   public void b(Runnable param1) {
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
      // 01: getfield android/arch/core/executor/DefaultTaskExecutor.c Landroid/os/Handler;
      // 04: ifnonnull 27
      // 07: aload 0
      // 08: getfield android/arch/core/executor/DefaultTaskExecutor.a Ljava/lang/Object;
      // 0b: astore 2
      // 0c: aload 2
      // 0d: monitorenter
      // 0e: aload 0
      // 0f: getfield android/arch/core/executor/DefaultTaskExecutor.c Landroid/os/Handler;
      // 12: ifnonnull 25
      // 15: new android/os/Handler
      // 18: astore 3
      // 19: aload 3
      // 1a: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 1d: invokespecial android/os/Handler.<init> (Landroid/os/Looper;)V
      // 20: aload 0
      // 21: aload 3
      // 22: putfield android/arch/core/executor/DefaultTaskExecutor.c Landroid/os/Handler;
      // 25: aload 2
      // 26: monitorexit
      // 27: aload 0
      // 28: getfield android/arch/core/executor/DefaultTaskExecutor.c Landroid/os/Handler;
      // 2b: aload 1
      // 2c: invokevirtual android/os/Handler.post (Ljava/lang/Runnable;)Z
      // 2f: pop
      // 30: return
      // 31: astore 1
      // 32: aload 2
      // 33: monitorexit
      // 34: aload 1
      // 35: athrow
      // try (8 -> 19): 27 null
      // try (19 -> 21): 27 null
      // try (28 -> 30): 27 null
   }

   @Override
   public boolean b() {
      boolean var1;
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
