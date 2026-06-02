package com.salesforce.android.service.common.fetchsave.internal.operations;

import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.fetchsave.internal.http.HttpService;
import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

public abstract class FetchSaveOp<S extends FetchSaveRequest, T> implements Operation<T> {
   private final S a;
   private Async<Void> b;
   private T c;
   private boolean d;
   private final BasicAsync<T> e = BasicAsync.g();

   public FetchSaveOp(S var1) {
      this.a = (S)var1;
   }

   protected abstract OfflineException a();

   protected abstract Async<T> a(S var1);

   protected abstract Async<Void> a(S var1, T var2);

   void a(T var1) {
      this.e.a((T)var1);
   }

   void a(Throwable var1) {
      this.e.a(var1);
   }

   protected abstract Async<T> b(S var1);

   void b(T var1) {
      FetchSaveOp.SaveHandler var2 = new FetchSaveOp.SaveHandler(this);
      this.b = this.a(this.a, (T)var1).a(var2).a(var2);
   }

   void b(Throwable var1) {
      if (this.d) {
         this.i();
      } else {
         this.a(var1);
      }
   }

   protected abstract HttpService c();

   void c(T var1) {
      this.c = (T)var1;
      if (this.a.n() || !this.d) {
         this.a((T)var1);
      }
   }

   void c(Throwable var1) {
      if (this.c != null) {
         if (!this.a.n()) {
            this.a(this.c);
         }

         this.g();
      } else {
         this.a(var1);
      }
   }

   public FetchSaveOp<S, T> d() {
      this.d = this.c().c();
      if (this.a.m()) {
         this.h();
      } else {
         this.i();
      }

      return this;
   }

   void d(T var1) {
      this.a((T)var1);
      if (this.a.l()) {
         this.b((T)var1);
      }
   }

   void d(Throwable var1) {
      this.a(var1);
   }

   @Override
   public Async<T> f() {
      return this.e;
   }

   void g() {
      this.e.a();
   }

   void h() {
      this.a(this.a).b(new FetchSaveOp.DbHandler(this));
   }

   void i() {
      this.b(this.a).b(new FetchSaveOp.HttpHandler(this));
   }

   void j() {
      if (this.d) {
         this.i();
      } else if (this.c == null) {
         this.a(this.a());
      } else {
         this.g();
      }
   }

   void k() {
      if (this.b == null) {
         this.g();
      }
   }

   void l() {
      this.g();
   }

   class DbHandler implements Async.Handler<T> {
      final FetchSaveOp a;

      DbHandler(FetchSaveOp var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.j();
      }

      @Override
      public void a(Async<?> var1, T var2) {
         this.a.c(var2);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.b(var2);
      }
   }

   class HttpHandler implements Async.Handler<T> {
      final FetchSaveOp a;

      HttpHandler(FetchSaveOp var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.k();
      }

      @Override
      public void a(Async<?> var1, T var2) {
         this.a.d(var2);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.c(var2);
      }
   }

   class SaveHandler implements Async.CompletionHandler, Async.ErrorHandler {
      final FetchSaveOp a;

      SaveHandler(FetchSaveOp var1) {
         this.a = var1;
      }

      @Override
      public void a(Async<?> var1) {
         this.a.l();
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         this.a.d(var2);
      }
   }
}
