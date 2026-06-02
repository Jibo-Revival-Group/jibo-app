package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.service.common.utilities.control.Async;

public abstract class AbstractMultipartRequestHandler<T> implements Async.Handler<T> {
   final MultipartOperationObserver a;

   public AbstractMultipartRequestHandler(MultipartOperationObserver var1) {
      this.a = var1;
   }

   @Override
   public void a(Async<?> var1) {
      this.a.a(var1);
   }

   @Override
   public void a(Async<?> var1, Throwable var2) {
      this.a.a(var2);
   }
}
