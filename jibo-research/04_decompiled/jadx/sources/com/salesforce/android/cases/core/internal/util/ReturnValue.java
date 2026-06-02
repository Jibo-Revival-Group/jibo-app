package com.salesforce.android.cases.core.internal.util;

import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
public class ReturnValue<T> extends BasicAsync<T> implements ResultReceiver<T> {
    @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
    /* JADX INFO: renamed from: a */
    public BasicAsync<T> mo12614b(T t) {
        super.mo12614b(t);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
    /* JADX INFO: renamed from: a */
    public BasicAsync<T> mo12615b(Throwable th) {
        super.mo12615b(th);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
    /* JADX INFO: renamed from: a */
    public BasicAsync<T> mo12613b() {
        super.mo12613b();
        return this;
    }
}
