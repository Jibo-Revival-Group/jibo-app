package com.salesforce.android.service.common.utilities.lifecycle;

public interface LifecycleState<M extends Enum<M> & LifecycleMetric> {
   M[] getMetrics();
}
