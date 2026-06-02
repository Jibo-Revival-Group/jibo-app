package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.fetchsave.internal.http.HttpService;
import com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp;
import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

abstract class CaseFetchSaveOperation<S extends FetchSaveRequest, T> extends FetchSaveOp<S, T> {
   final LocalRepository a;
   private final RemoteRepository b;
   private final ServiceLogger c = ServiceLogging.a(CaseFetchSaveOperation.class);

   public CaseFetchSaveOperation(S var1, LocalRepository var2, RemoteRepository var3) {
      super((S)var1);
      this.a = var2;
      this.b = var3;
   }

   @Override
   protected OfflineException a() {
      return new OfflineException(this.b());
   }

   protected Async<T> a(LocalRepository var1, S var2) {
      return BasicAsync.h();
   }

   protected Async<Void> a(LocalRepository var1, S var2, T var3) {
      return BasicAsync.h();
   }

   protected abstract Async<T> a(RemoteRepository var1, S var2);

   @Override
   protected Async<T> a(S var1) {
      if (this.a == null) {
         throw new IllegalStateException("Operations that support caching must provide a LocalRepository.");
      } else {
         return this.a(this.a, (S)var1);
      }
   }

   @Override
   protected Async<Void> a(S var1, T var2) {
      if (this.a == null) {
         throw new IllegalStateException("Operations that support caching must provide a LocalRepository.");
      } else {
         return this.a(this.a, (S)var1, (T)var2);
      }
   }

   @Override
   protected Async<T> b(S var1) {
      return this.a(this.b, (S)var1);
   }

   protected abstract String b();

   @Override
   protected HttpService c() {
      return this.b;
   }
}
