package com.salesforce.android.service.common.fetchsave.internal.operations;

import com.salesforce.android.service.common.utilities.control.Async;

public interface Operation<T> {
   Operation<T> e();

   Async<T> f();
}
