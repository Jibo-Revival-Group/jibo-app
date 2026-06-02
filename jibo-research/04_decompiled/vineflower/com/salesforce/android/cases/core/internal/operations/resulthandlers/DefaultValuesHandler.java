package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.service.common.utilities.control.Async;

public class DefaultValuesHandler extends AbstractMultipartRequestHandler<DefaultValues> {
   private final CompleteCaseFeedModel b;

   public DefaultValuesHandler(MultipartOperationObserver var1, CompleteCaseFeedModel var2) {
      super(var1);
      this.b = var2;
   }

   public void a(Async<?> var1, DefaultValues var2) {
      this.b.a(var2);
      this.a.g();
   }
}
