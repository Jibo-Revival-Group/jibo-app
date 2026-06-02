package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.service.common.utilities.control.Async;

public class GetCaseDetailHandler extends AbstractMultipartRequestHandler<CaseDetailRecord> {
   private final CompleteCaseFeedModel b;

   public GetCaseDetailHandler(MultipartOperationObserver var1, CompleteCaseFeedModel var2) {
      super(var1);
      this.b = var2;
   }

   public void a(Async<?> var1, CaseDetailRecord var2) {
      this.b.a(var2);
      this.a.g();
   }
}
