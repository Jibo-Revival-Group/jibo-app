package com.salesforce.android.service.common.utilities.lifecycle;

public interface LifecycleListener<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
   void a(M var1);

   void a(S var1, S var2);
}
