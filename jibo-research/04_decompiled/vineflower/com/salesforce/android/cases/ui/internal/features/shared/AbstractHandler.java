package com.salesforce.android.cases.ui.internal.features.shared;

import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.utilities.control.Async;
import java.io.IOException;

public abstract class AbstractHandler<T> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {
   Async<T> c;
   T d;
   Throwable e;

   private void b(Throwable var1) {
      if (!(var1 instanceof IOException) && !(var1 instanceof OfflineException)) {
         this.a(var1);
      } else {
         this.c();
      }
   }

   protected abstract Async<T> a();

   @Override
   public void a(Async<?> var1) {
   }

   @Override
   public final void a(Async<?> var1, T var2) {
      this.d = (T)var2;
      this.a(this.d);
   }

   @Override
   public final void a(Async<?> var1, Throwable var2) {
      this.e = var2;
      this.b(this.e);
   }

   protected abstract void a(T var1);

   protected abstract void a(Throwable var1);

   protected abstract void b();

   protected abstract void c();

   public void d() {
      if (this.c != null) {
         if (this.c.e()) {
            this.b(this.e);
         } else if (this.c.d()) {
            this.a(this.d);
         } else {
            this.b();
         }
      } else {
         this.b();
         this.c = this.a();
         this.c.b(this);
      }
   }

   public void e() {
      if (this.c != null) {
         this.c.c(this);
      }

      this.e = null;
      this.d = null;
      this.c = null;
   }

   public boolean f() {
      boolean var1;
      if (this.c != null && this.c.d()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean g() {
      boolean var1;
      if (this.c != null && this.c.e()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean h() {
      boolean var1;
      if (this.c != null && this.c.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean i() {
      boolean var1;
      if (!this.h() && !this.g() && !this.f()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }
}
