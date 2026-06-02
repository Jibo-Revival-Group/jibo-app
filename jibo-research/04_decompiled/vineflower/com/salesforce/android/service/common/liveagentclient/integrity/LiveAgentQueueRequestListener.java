package com.salesforce.android.service.common.liveagentclient.integrity;

import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public interface LiveAgentQueueRequestListener {
   <T> Async<T> a(LiveAgentRequest var1, Class<T> var2);
}
