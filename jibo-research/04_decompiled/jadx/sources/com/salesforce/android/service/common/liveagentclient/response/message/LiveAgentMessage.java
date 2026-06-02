package com.salesforce.android.service.common.liveagentclient.response.message;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentMessage {

    /* JADX INFO: renamed from: a */
    private final String f13576a;

    /* JADX INFO: renamed from: b */
    private final Object f13577b;

    public LiveAgentMessage(String str, Object obj) {
        this.f13577b = obj;
        this.f13576a = str;
    }

    /* JADX INFO: renamed from: a */
    public String m13875a() {
        return this.f13576a;
    }

    /* JADX INFO: renamed from: a */
    public <T> T m13874a(Class<T> cls) {
        return cls.cast(this.f13577b);
    }
}
