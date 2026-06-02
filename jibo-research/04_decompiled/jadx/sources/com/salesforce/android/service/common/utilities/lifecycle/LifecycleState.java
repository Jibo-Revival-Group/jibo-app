package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import java.lang.Enum;

/* JADX INFO: loaded from: classes.dex */
public interface LifecycleState<M extends Enum<M> & LifecycleMetric> {
    /* JADX WARN: Incorrect return type in method signature: ()[TM; */
    Enum[] getMetrics();
}
