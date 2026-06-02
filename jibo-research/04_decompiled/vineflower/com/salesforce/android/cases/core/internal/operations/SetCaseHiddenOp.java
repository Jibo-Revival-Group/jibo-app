package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public class SetCaseHiddenOp extends SaveOp<SetCaseHiddenRequest, Void> {
   public SetCaseHiddenOp(SetCaseHiddenRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<Void> a(LocalRepository var1, SetCaseHiddenRequest var2) {
      return var1.a(var2.c(), var2.d());
   }
}
