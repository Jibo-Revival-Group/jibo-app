package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import java.util.concurrent.Executor;

public class JobQueue {
   private final Executor a;
   private final JobQueue.HandlerFactory b;

   public JobQueue(Executor var1) {
      this(var1, new JobQueue.HandlerFactory());
   }

   JobQueue(Executor var1, JobQueue.HandlerFactory var2) {
      this.a = var1;
      this.b = var2;
   }

   public <T> Async<T> a(Job<T> var1) {
      Looper var2 = Looper.myLooper();
      if (var2 == null) {
         throw new IllegalStateException("Cannot add jobs on a thread without a looper");
      } else {
         return this.a(var1, var2);
      }
   }

   public <T> Async<T> a(Job<T> var1, Handler var2) {
      JobQueue.JobAsync var4 = new JobQueue.JobAsync(var2);
      JobQueue.JobRunner var3 = new JobQueue.JobRunner<>(var1, var4);
      this.a.execute(var3);
      return var4;
   }

   public <T> Async<T> a(Job<T> var1, Looper var2) {
      return this.a(var1, this.b.a(var2));
   }

   public static class HandlerFactory {
      public Handler a(Looper var1) {
         return new Handler(var1);
      }
   }

   static class JobAsync<T> extends BasicAsync<T> {
      final android.os.Handler a;

      JobAsync(android.os.Handler var1) {
         this.a = var1;
      }

      @Override
      public BasicAsync<T> a() {
         if (this.a.getLooper().equals(Looper.myLooper())) {
            super.a();
         } else {
            this.a.post(new Runnable(this) {
               final JobQueue.JobAsync a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a();
               }
            });
         }

         return this;
      }

      @Override
      public BasicAsync<T> a(T var1) {
         if (this.a.getLooper().equals(Looper.myLooper())) {
            super.a((T)var1);
         } else {
            this.a.post(new Runnable(this, var1) {
               final Object a;
               final JobQueue.JobAsync b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  this.b.a(this.a);
               }
            });
         }

         return this;
      }

      @Override
      public BasicAsync<T> a(Throwable var1) {
         if (this.a.getLooper().equals(Looper.myLooper())) {
            super.a(var1);
         } else {
            this.a.post(new Runnable(this, var1) {
               final Throwable a;
               final JobQueue.JobAsync b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  this.b.a(this.a);
               }
            });
         }

         return this;
      }
   }

   static class JobRunner<T> implements Runnable {
      final Job<T> a;
      final ResultReceiver<T> b;

      JobRunner(Job<T> var1, ResultReceiver<T> var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void run() {
         try {
            this.a.a(this.b);
         } catch (Throwable var2) {
            this.b.b(var2);
         }
      }
   }
}
