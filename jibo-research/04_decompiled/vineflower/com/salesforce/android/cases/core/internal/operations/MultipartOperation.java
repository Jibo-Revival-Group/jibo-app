package com.salesforce.android.cases.core.internal.operations;

import android.support.v4.util.ArraySet;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.util.Collections;
import java.util.Set;

public abstract class MultipartOperation<T> implements MultipartOperationObserver, Operation<T> {
   private final BasicAsync<T> a;
   private final Set<Async> b = Collections.synchronizedSet(new ArraySet<>());
   private boolean c;

   MultipartOperation() {
      this.a = BasicAsync.g();
   }

   abstract void a();

   @Override
   public void a(Async<?> var1) {
      this.b.remove(var1);
      if (this.b.isEmpty() && this.c) {
         this.a.a();
      }
   }

   @Override
   public void a(Throwable var1) {
      this.a.a(var1);
      this.a.a();
      this.b.clear();
   }

   @Override
   public void b(Async<?> var1) {
      var1.c();
      this.a(var1);
   }

   abstract boolean b();

   @Override
   public void c(Async<?> var1) {
      this.b.add(var1);
   }

   abstract T d();

   @Override
   public final Operation<T> e() {
      this.a();
      this.c = true;
      if (this.b.isEmpty()) {
         this.a.a();
      }

      return this;
   }

   @Override
   public Async<T> f() {
      return this.a;
   }

   @Override
   public void g() {
      if (this.b() && this.d() != null) {
         this.a.a(this.d());
      }
   }
}
