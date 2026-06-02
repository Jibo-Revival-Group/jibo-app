package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {
   private static final int a = Runtime.getRuntime().availableProcessors();
   public static final Executor b = new ThreadPoolExecutor(AsyncTask.d, AsyncTask.e, 1L, TimeUnit.SECONDS, AsyncTask.g, AsyncTask.f);
   public static final Executor c = new AsyncTask.SerialExecutor();
   private static final int d = a + 1;
   private static final int e = a * 2 + 1;
   private static final ThreadFactory f = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);

      @Override
      public Thread newThread(Runnable var1) {
         return new Thread(var1, "AsyncTask #" + this.a.getAndIncrement());
      }
   };
   private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue<>(128);
   private static final AsyncTask.InternalHandler h = new AsyncTask.InternalHandler();
   private static volatile Executor i = c;
   private final AsyncTask.WorkerRunnable<Params, Result> j;
   private final FutureTask<Result> k;
   private volatile AsyncTask.Status l = AsyncTask.Status.PENDING;
   private final AtomicBoolean m = new AtomicBoolean();
   private final AtomicBoolean n = new AtomicBoolean();

   public AsyncTask() {
      this.j = new AsyncTask.WorkerRunnable<Params, Result>(this) {
         final AsyncTask a;

         {
            this.a = var1;
         }

         @Override
         public Result call() throws Exception {
            this.a.n.set(true);
            Process.setThreadPriority(10);
            return (Result)this.a.e(this.a.a(this.b));
         }
      };
      this.k = new FutureTask<Result>(this, this.j) {
         final AsyncTask a;

         {
            this.a = var1;
         }

         @Override
         protected void done() {
            try {
               this.a.d(this.get());
            } catch (InterruptedException var2) {
               Log.w("AsyncTask", var2);
            } catch (ExecutionException var3) {
               throw new RuntimeException("An error occured while executing doInBackground()", var3.getCause());
            } catch (CancellationException var4) {
               this.a.d(null);
            }
         }
      };
   }

   private void d(Result var1) {
      if (!this.n.get()) {
         this.e((Result)var1);
      }
   }

   private Result e(Result var1) {
      h.obtainMessage(1, new AsyncTask.AsyncTaskResult<>(this, var1)).sendToTarget();
      return (Result)var1;
   }

   private void f(Result var1) {
      if (this.e()) {
         this.b((Result)var1);
      } else {
         this.a((Result)var1);
      }

      this.l = AsyncTask.Status.FINISHED;
   }

   public final AsyncTask<Params, Progress, Result> a(Executor var1, Params... var2) {
      if (this.l != AsyncTask.Status.PENDING) {
         switch (<unrepresentable>.a[this.l.ordinal()]) {
            case 1:
               throw new IllegalStateException("Cannot execute task: the task is already running.");
            case 2:
               throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
         }
      }

      this.l = AsyncTask.Status.RUNNING;
      this.a();
      this.j.b = (Params[])var2;
      var1.execute(this.k);
      return this;
   }

   protected abstract Result a(Params... var1);

   protected void a() {
   }

   protected void a(Result var1) {
   }

   public final boolean a(boolean var1) {
      this.m.set(true);
      return this.k.cancel(var1);
   }

   protected void b(Result var1) {
      this.v_();
   }

   protected void b(Progress... var1) {
   }

   public final boolean e() {
      return this.m.get();
   }

   public final AsyncTask.Status u_() {
      return this.l;
   }

   protected void v_() {
   }

   private static class AsyncTaskResult<Data> {
      final AsyncTask a;
      final Data[] b;

      AsyncTaskResult(AsyncTask var1, Data... var2) {
         this.a = var1;
         this.b = (Data[])var2;
      }
   }

   private static class InternalHandler extends Handler {
      public InternalHandler() {
         super(Looper.getMainLooper());
      }

      public void handleMessage(Message var1) {
         AsyncTask.AsyncTaskResult var2 = (AsyncTask.AsyncTaskResult)var1.obj;
         switch (var1.what) {
            case 1:
               var2.a.f((Result)var2.b[0]);
               break;
            case 2:
               var2.a.b((Progress[])var2.b);
         }
      }
   }

   private static class SerialExecutor implements Executor {
      final LinkedList<Runnable> a = new LinkedList<>();
      Runnable b;

      private SerialExecutor() {
      }

      protected void a() {
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
         // 02: aload 0
         // 03: getfield io/fabric/sdk/android/services/concurrency/AsyncTask$SerialExecutor.a Ljava/util/LinkedList;
         // 06: invokevirtual java/util/LinkedList.poll ()Ljava/lang/Object;
         // 09: checkcast java/lang/Runnable
         // 0c: astore 1
         // 0d: aload 0
         // 0e: aload 1
         // 0f: putfield io/fabric/sdk/android/services/concurrency/AsyncTask$SerialExecutor.b Ljava/lang/Runnable;
         // 12: aload 1
         // 13: ifnull 22
         // 16: getstatic io/fabric/sdk/android/services/concurrency/AsyncTask.b Ljava/util/concurrent/Executor;
         // 19: aload 0
         // 1a: getfield io/fabric/sdk/android/services/concurrency/AsyncTask$SerialExecutor.b Ljava/lang/Runnable;
         // 1d: invokeinterface java/util/concurrent/Executor.execute (Ljava/lang/Runnable;)V 2
         // 22: aload 0
         // 23: monitorexit
         // 24: return
         // 25: astore 1
         // 26: aload 0
         // 27: monitorexit
         // 28: aload 1
         // 29: athrow
         // try (2 -> 10): 19 null
         // try (12 -> 16): 19 null
      }

      @Override
      public void execute(Runnable var1) {
         synchronized (this) {
            LinkedList var2 = this.a;
            Runnable var3 = new Runnable(this, var1) {
               final Runnable a;
               final AsyncTask.SerialExecutor b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  try {
                     this.a.run();
                  } finally {
                     this.b.a();
                  }
               }
            };
            var2.offer(var3);
            if (this.b == null) {
               this.a();
            }
         }
      }
   }

   public enum Status {
      FINISHED,
      PENDING,
      RUNNING;

      private static final AsyncTask.Status[] $VALUES = new AsyncTask.Status[]{AsyncTask.Status.PENDING, AsyncTask.Status.RUNNING, AsyncTask.Status.FINISHED};
   }

   private abstract static class WorkerRunnable<Params, Result> implements Callable<Result> {
      Params[] b;

      private WorkerRunnable() {
      }
   }
}
