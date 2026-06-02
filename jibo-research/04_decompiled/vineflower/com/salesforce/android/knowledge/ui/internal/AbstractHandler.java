package com.salesforce.android.knowledge.ui.internal;

import com.salesforce.android.service.common.utilities.control.Async;

public abstract class AbstractHandler<T> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {
   private Async<T> a;

   public void a() {
      this.a = this.c();
      this.a.b(this);
   }

   public void b() {
      if (this.a != null) {
         this.a.c(this);
      }
   }

   protected abstract Async<T> c();

   public boolean d() {
      boolean var1;
      if (this.a != null && this.a.d()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean e() {
      boolean var1;
      if (this.a != null && this.a.e()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean f() {
      boolean var1;
      if (this.a != null && this.a.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
