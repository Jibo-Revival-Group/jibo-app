package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.response.message.AsyncResult;
import com.salesforce.android.service.common.liveagentclient.response.message.SwitchServerMessage;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentMessageRegistry {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13489a = ServiceLogging.m14203a((Class<?>) LiveAgentMessageRegistry.class);

    /* JADX INFO: renamed from: b */
    private Map<String, Class> f13490b = new HashMap();

    public LiveAgentMessageRegistry() {
        m13799a("AsyncResult", AsyncResult.class);
        m13799a("SwitchServer", SwitchServerMessage.class);
    }

    /* JADX INFO: renamed from: a */
    public LiveAgentMessageRegistry m13799a(String str, Class cls) {
        this.f13490b.put(str, cls);
        f13489a.mo14187a("Registered LiveAgentMessage content type {} as class {}", str, cls.getSimpleName());
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Class m13800a(String str) {
        return this.f13490b.get(str);
    }
}
