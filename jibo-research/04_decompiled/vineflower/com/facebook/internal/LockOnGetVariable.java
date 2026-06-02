package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T> {
   private CountDownLatch initLatch;
   private T value;

   public LockOnGetVariable(T var1) {
      this.value = (T)var1;
   }

   public LockOnGetVariable(Callable<T> var1) {
      this.initLatch = new CountDownLatch(1);
      FacebookSdk.getExecutor().execute(new FutureTask<>(new Callable<Void>(this, var1) {
         final LockOnGetVariable this$0;
         final Callable val$callable;

         {
            this.this$0 = var1;
            this.val$callable = var2;
         }

         public Void call() throws Exception {
            try {
               this.this$0.value = (T)this.val$callable.call();
            } finally {
               this.this$0.initLatch.countDown();
            }

            return null;
         }
      }));
   }

   private void waitOnInit() {
      if (this.initLatch != null) {
         try {
            this.initLatch.await();
         } catch (InterruptedException var2) {
         }
      }
   }

   public T getValue() {
      this.waitOnInit();
      return this.value;
   }
}
