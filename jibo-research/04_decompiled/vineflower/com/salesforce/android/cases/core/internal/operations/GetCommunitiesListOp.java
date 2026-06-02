package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.List;

public class GetCommunitiesListOp extends CaseFetchSaveOperation<CommunitiesListRequest, List<Community>> {
   public GetCommunitiesListOp(CommunitiesListRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<List<Community>> a(LocalRepository var1, CommunitiesListRequest var2) {
      return var1.c();
   }

   protected Async<Void> a(LocalRepository var1, CommunitiesListRequest var2, List<Community> var3) {
      return var1.a(var2, var3);
   }

   protected Async<List<Community>> a(RemoteRepository var1, CommunitiesListRequest var2) {
      return var1.a();
   }

   @Override
   protected String b() {
      return "Cannot Get Communities List, Offline";
   }
}
