package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public class GetListViewDescribeOp extends CaseFetchSaveOperation<ListViewDescribeRequest, ListViewDescribe> {
   public GetListViewDescribeOp(ListViewDescribeRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<ListViewDescribe> a(LocalRepository var1, ListViewDescribeRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(LocalRepository var1, ListViewDescribeRequest var2, ListViewDescribe var3) {
      return var1.a(var2, var3);
   }

   protected Async<ListViewDescribe> a(RemoteRepository var1, ListViewDescribeRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Get List View Description, Offline";
   }
}
