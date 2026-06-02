package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public class GetDefaultValuesOp extends CaseFetchSaveOperation<DefaultValuesRequest, DefaultValues> {
   public GetDefaultValuesOp(DefaultValuesRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<DefaultValues> a(LocalRepository var1, DefaultValuesRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(LocalRepository var1, DefaultValuesRequest var2, DefaultValues var3) {
      return var1.a(var2, var3);
   }

   protected Async<DefaultValues> a(RemoteRepository var1, DefaultValuesRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Get Default Values, Offline";
   }
}
