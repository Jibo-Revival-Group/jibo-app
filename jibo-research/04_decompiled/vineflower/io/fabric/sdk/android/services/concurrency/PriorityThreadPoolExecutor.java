package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
   private static final int a = Runtime.getRuntime().availableProcessors();
   private static final int b = a + 1;
   private static final int c = a * 2 + 1;

   <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor(
      int var1, int var2, long var3, TimeUnit var5, DependencyPriorityBlockingQueue<T> var6, ThreadFactory var7
   ) {
      super(var1, var2, var3, var5, var6, var7);
      this.prestartAllCoreThreads();
   }

   public static PriorityThreadPoolExecutor a() {
      return a(b, c);
   }

   public static <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor a(int var0, int var1) {
      return new PriorityThreadPoolExecutor(
         var0, var1, 1L, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue<>(), new PriorityThreadPoolExecutor.PriorityThreadFactory(10)
      );
   }

   @Override
   protected void afterExecute(Runnable var1, Throwable var2) {
      Task var3 = (Task)var1;
      var3.b(true);
      var3.a(var2);
      this.b().d();
      super.afterExecute(var1, var2);
   }

   public DependencyPriorityBlockingQueue b() {
      return (DependencyPriorityBlockingQueue)super.getQueue();
   }

   @TargetApi(9)
   @Override
   public void execute(Runnable var1) {
      if (PriorityTask.a(var1)) {
         super.execute(var1);
      } else {
         super.execute(this.newTaskFor(var1, null));
      }
   }

   @Override
   protected <T> RunnableFuture<T> newTaskFor(Runnable var1, T var2) {
      return new PriorityFutureTask<>(var1, (T)var2);
   }

   @Override
   protected <T> RunnableFuture<T> newTaskFor(Callable<T> var1) {
      return new PriorityFutureTask<>(var1);
   }

   protected static final class PriorityThreadFactory implements ThreadFactory {
      private final int a;

      public PriorityThreadFactory(int var1) {
         this.a = var1;
      }

      @Override
      public Thread newThread(Runnable var1) {
         var1 = new Thread(var1);
         var1.setPriority(this.a);
         var1.setName("Queue");
         return var1;
      }
   }
}
