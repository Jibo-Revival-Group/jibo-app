package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public class GetCaseFeedOp extends CaseFetchSaveOperation<CaseFeedRequest, CaseFeed> {
   public GetCaseFeedOp(CaseFeedRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<CaseFeed> a(LocalRepository var1, CaseFeedRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(LocalRepository var1, CaseFeedRequest var2, CaseFeed var3) {
      return var1.a(var2, var3);
   }

   protected Async<CaseFeed> a(RemoteRepository var1, CaseFeedRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Get Case Feed, Offline";
   }
}
