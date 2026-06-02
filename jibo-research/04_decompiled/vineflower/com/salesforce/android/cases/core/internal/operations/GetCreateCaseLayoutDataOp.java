package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.DbUtils;
import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.accounts.UserAccount;

class GetCreateCaseLayoutDataOp extends CaseFetchSaveOperation<CreateCaseQuickActionRequest, CaseLayoutData> {
   private ServiceLogger b = ServiceLogging.a(GetCreateCaseLayoutDataOp.class);
   private final UserAccount c;

   public GetCreateCaseLayoutDataOp(CreateCaseQuickActionRequest var1, LocalRepository var2, RemoteRepository var3, UserAccount var4) {
      super(var1, var2, var3);
      this.c = var4;
   }

   protected Async<CaseLayoutData> a(LocalRepository var1, CreateCaseQuickActionRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(LocalRepository var1, CreateCaseQuickActionRequest var2, CaseLayoutData var3) {
      Async var4;
      if (DbUtils.a(this.c)) {
         var4 = var1.a(var2, var3);
      } else {
         this.b.c("Unable to store Case Layout while unauthenticated.");
         var4 = BasicAsync.h();
      }

      return var4;
   }

   protected Async<CaseLayoutData> a(RemoteRepository var1, CreateCaseQuickActionRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Get Case Layout Data, Offline";
   }
}
