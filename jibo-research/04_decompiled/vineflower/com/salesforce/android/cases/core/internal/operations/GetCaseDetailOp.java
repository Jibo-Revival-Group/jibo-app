package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public class GetCaseDetailOp extends CaseFetchSaveOperation<CaseDetailRequest, CaseDetailRecord> {
   public GetCaseDetailOp(CaseDetailRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<CaseDetailRecord> a(LocalRepository var1, CaseDetailRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(LocalRepository var1, CaseDetailRequest var2, CaseDetailRecord var3) {
      return var1.a(var2, var3);
   }

   protected Async<CaseDetailRecord> a(RemoteRepository var1, CaseDetailRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Get Case Detail, Offline";
   }
}
