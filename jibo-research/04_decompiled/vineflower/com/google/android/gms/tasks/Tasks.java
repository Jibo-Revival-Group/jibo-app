package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
   public static <TResult> Task<TResult> a(Exception var0) {
      zzn var1 = new zzn();
      var1.a(var0);
      return var1;
   }

   public static <TResult> Task<TResult> a(TResult var0) {
      zzn var1 = new zzn();
      var1.a(var0);
      return var1;
   }

   public static <TResult> Task<TResult> a(Executor var0, Callable<TResult> var1) {
      zzbq.a(var0, "Executor must not be null");
      zzbq.a(var1, "Callback must not be null");
      zzn var2 = new zzn();
      var0.execute(new zzo(var2, var1));
      return var2;
   }

   public static <TResult> TResult a(Task<TResult> var0) throws ExecutionException, InterruptedException {
      zzbq.c("Must not be called on the main application thread");
      zzbq.a(var0, "Task must not be null");
      Object var2;
      if (var0.a()) {
         var2 = b(var0);
      } else {
         Tasks.zza var1 = new Tasks.zza(null);
         a(var0, var1);
         var1.a();
         var2 = b(var0);
      }

      return (TResult)var2;
   }

   public static <TResult> TResult a(Task<TResult> var0, long var1, TimeUnit var3) throws ExecutionException, InterruptedException, TimeoutException {
      zzbq.c("Must not be called on the main application thread");
      zzbq.a(var0, "Task must not be null");
      zzbq.a(var3, "TimeUnit must not be null");
      Object var5;
      if (var0.a()) {
         var5 = b(var0);
      } else {
         Tasks.zza var4 = new Tasks.zza(null);
         a(var0, var4);
         if (!var4.a(var1, var3)) {
            throw new TimeoutException("Timed out waiting for Task");
         }

         var5 = b(var0);
      }

      return (TResult)var5;
   }

   private static void a(Task<?> var0, Tasks.zzb var1) {
      var0.a(TaskExecutors.b, var1);
      var0.a(TaskExecutors.b, var1);
   }

   private static <TResult> TResult b(Task<TResult> var0) throws ExecutionException {
      if (var0.b()) {
         return (TResult)var0.c();
      } else {
         throw new ExecutionException(var0.d());
      }
   }

   static final class zza implements Tasks.zzb {
      private final CountDownLatch a = new CountDownLatch(1);

      private zza() {
      }

      public final void a() throws InterruptedException {
         this.a.await();
      }

      @Override
      public final void a(Exception var1) {
         this.a.countDown();
      }

      @Override
      public final void a(Object var1) {
         this.a.countDown();
      }

      public final boolean a(long var1, TimeUnit var3) throws InterruptedException {
         return this.a.await(var1, var3);
      }
   }

   interface zzb extends OnFailureListener, OnSuccessListener<Object> {
   }
}
