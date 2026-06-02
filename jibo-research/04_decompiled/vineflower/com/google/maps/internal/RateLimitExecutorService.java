package com.google.maps.internal;

import com.google.common.util.concurrent.RateLimiter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RateLimitExecutorService implements Runnable, ExecutorService {
   private static final int DEFAULT_QUERIES_PER_SECOND = 10;
   private static final Logger LOG = LoggerFactory.a(RateLimitExecutorService.class.getName());
   private final ExecutorService delegate = new ThreadPoolExecutor(
      Runtime.getRuntime().availableProcessors(),
      Integer.MAX_VALUE,
      60L,
      TimeUnit.SECONDS,
      new SynchronousQueue<>(),
      threadFactory("Rate Limited Dispatcher", true)
   );
   private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
   private final RateLimiter rateLimiter = RateLimiter.a(10.0, 1L, TimeUnit.SECONDS);

   public RateLimitExecutorService() {
      this.setQueriesPerSecond(10);
      Thread var1 = new Thread(this);
      var1.setDaemon(true);
      var1.setName("RateLimitExecutorDelayThread");
      var1.start();
   }

   private static ThreadFactory threadFactory(String var0, boolean var1) {
      return new ThreadFactory(var0, var1) {
         final boolean val$daemon;
         final String val$name;

         {
            this.val$name = var1;
            this.val$daemon = var2;
         }

         @Override
         public Thread newThread(Runnable var1) {
            var1 = new Thread(var1, this.val$name);
            var1.setDaemon(this.val$daemon);
            return var1;
         }
      };
   }

   @Override
   public boolean awaitTermination(long var1, TimeUnit var3) throws InterruptedException {
      return this.delegate.awaitTermination(var1, var3);
   }

   @Override
   public void execute(Runnable var1) {
      this.queue.add(var1);
   }

   @Override
   public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> var1) throws InterruptedException {
      return this.delegate.invokeAll(var1);
   }

   @Override
   public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> var1, long var2, TimeUnit var4) throws InterruptedException {
      return this.delegate.invokeAll(var1, var2, var4);
   }

   @Override
   public <T> T invokeAny(Collection<? extends Callable<T>> var1) throws InterruptedException, ExecutionException {
      return this.delegate.invokeAny(var1);
   }

   @Override
   public <T> T invokeAny(Collection<? extends Callable<T>> var1, long var2, TimeUnit var4) throws InterruptedException, ExecutionException, TimeoutException {
      return this.delegate.invokeAny(var1, var2, var4);
   }

   @Override
   public boolean isShutdown() {
      return this.delegate.isShutdown();
   }

   @Override
   public boolean isTerminated() {
      return this.delegate.isTerminated();
   }

   @Override
   public void run() {
      while (true) {
         try {
            if (!this.delegate.isShutdown()) {
               this.rateLimiter.c();
               Runnable var1 = this.queue.take();
               this.delegate.execute(var1);
               continue;
            }
         } catch (InterruptedException var2) {
            LOG.a("Interrupted", var2);
         }

         return;
      }
   }

   public void setQueriesPerSecond(int var1) {
      this.rateLimiter.a((double)var1);
   }

   @Override
   public void shutdown() {
      this.delegate.shutdown();
   }

   @Override
   public List<Runnable> shutdownNow() {
      return this.delegate.shutdownNow();
   }

   @Override
   public Future<?> submit(Runnable var1) {
      return this.delegate.submit(var1);
   }

   @Override
   public <T> Future<T> submit(Runnable var1, T var2) {
      return this.delegate.submit(var1, (T)var2);
   }

   @Override
   public <T> Future<T> submit(Callable<T> var1) {
      return this.delegate.submit(var1);
   }
}
