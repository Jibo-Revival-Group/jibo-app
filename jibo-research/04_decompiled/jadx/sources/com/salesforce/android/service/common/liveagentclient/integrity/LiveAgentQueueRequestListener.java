package com.salesforce.android.service.common.liveagentclient.integrity;

import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public interface LiveAgentQueueRequestListener {
    /* JADX INFO: renamed from: a */
    <T> Async<T> mo13802a(LiveAgentRequest liveAgentRequest, Class<T> cls);
}
