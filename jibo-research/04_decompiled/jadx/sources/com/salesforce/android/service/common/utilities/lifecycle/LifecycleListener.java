package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import java.lang.Enum;

/* JADX INFO: loaded from: classes.dex */
public interface LifecycleListener<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
    /* JADX WARN: Incorrect types in method signature: (TM;)V */
    /* JADX INFO: renamed from: a */
    void mo13807a(Enum r1);

    /* JADX WARN: Incorrect types in method signature: (TS;TS;)V */
    /* JADX INFO: renamed from: a */
    void mo13808a(Enum r1, Enum r2);
}
