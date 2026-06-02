package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.requests.SaveRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

abstract class SaveOp<S extends SaveRequest, T> implements Operation<T> {
   private final S a;
   private final LocalRepository b;
   private final RemoteRepository c;
   private final BasicAsync<T> d = BasicAsync.g();

   public SaveOp(S var1, LocalRepository var2, RemoteRepository var3) {
      this.a = (S)var1;
      this.b = var2;
      this.c = var3;
   }

   public SaveOp<S, T> a() {
      if (this.a.a()) {
         this.a(this.b, this.a).b(new SaveOp.LocalRepositoryHandler(this));
      } else if (this.a.b()) {
         this.a(this.c, this.a).b(new SaveOp.RemoteRepositoryHandler(this));
      }

      return this;
   }

   protected Async<T> a(LocalRepository var1, S var2) {
      return BasicAsync.h();
   }

   protected Async<T> a(RemoteRepository var1, S var2) {
      return BasicAsync.h();
   }

   @Override
   public Async<T> f() {
      return this.d;
   }

   private class LocalRepositoryHandler implements Async.Handler<T> {
      final SaveOp a;

      private LocalRepositoryHandler(SaveOp var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         if (this.a.a.b()) {
            this.a.a(this.a.c, this.a.a).b(this.a.new RemoteRepositoryHandler(this.a));
         } else {
            this.a.d.a();
         }
      }

      @Override
      public void a(Async<?> var1, T var2) {
         this.a.d.a((T)var2);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.d.a(var2);
      }
   }

   private class RemoteRepositoryHandler implements Async.Handler<T> {
      final SaveOp a;

      private RemoteRepositoryHandler(SaveOp var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.d.a();
      }

      @Override
      public void a(Async<?> var1, T var2) {
         this.a.d.a((T)var2);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.d.a(var2);
      }
   }
}
