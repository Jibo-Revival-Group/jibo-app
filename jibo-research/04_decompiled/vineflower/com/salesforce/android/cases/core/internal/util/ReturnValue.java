package com.salesforce.android.cases.core.internal.util;

import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;

public class ReturnValue<T> extends BasicAsync<T> implements ResultReceiver<T> {
   @Override
   public BasicAsync<T> a() {
      super.a();
      return this;
   }

   @Override
   public BasicAsync<T> a(T var1) {
      super.a((T)var1);
      return this;
   }

   @Override
   public BasicAsync<T> a(Throwable var1) {
      super.a(var1);
      return this;
   }
}
