package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.service.common.utilities.control.Async;

class CreateCaseRecordOp extends CaseFetchSaveOperation<CreateCaseRecordRequest, CreateCaseRecordResult> {
   public CreateCaseRecordOp(CreateCaseRecordRequest var1, RemoteRepository var2) {
      super(var1, null, var2);
   }

   protected Async<CreateCaseRecordResult> a(RemoteRepository var1, CreateCaseRecordRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Create Case, Offline";
   }
}
