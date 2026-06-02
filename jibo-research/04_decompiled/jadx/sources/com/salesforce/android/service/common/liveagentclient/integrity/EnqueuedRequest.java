package com.salesforce.android.service.common.liveagentclient.integrity;

import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class EnqueuedRequest<T> {

    /* JADX INFO: renamed from: a */
    private final LiveAgentRequest f13547a;

    /* JADX INFO: renamed from: b */
    private final Class<T> f13548b;

    /* JADX INFO: renamed from: c */
    private final BasicAsync<T> f13549c;

    /* JADX INFO: renamed from: d */
    private int f13550d;

    public EnqueuedRequest(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        this(liveAgentRequest, cls, new BasicAsync(), 1);
    }

    EnqueuedRequest(LiveAgentRequest liveAgentRequest, Class<T> cls, BasicAsync<T> basicAsync, int i) {
        this.f13547a = liveAgentRequest;
        this.f13548b = cls;
        this.f13549c = basicAsync;
        this.f13550d = i;
    }

    /* JADX INFO: renamed from: a */
    public LiveAgentRequest m13839a() {
        return this.f13547a;
    }

    /* JADX INFO: renamed from: b */
    public Class<T> m13840b() {
        return this.f13548b;
    }

    /* JADX INFO: renamed from: c */
    public BasicAsync<T> m13841c() {
        return this.f13549c;
    }

    /* JADX INFO: renamed from: d */
    public void m13842d() {
        this.f13550d++;
    }

    /* JADX INFO: renamed from: e */
    public void m13843e() {
        this.f13549c.mo12615b((Throwable) new IOException("Unable to send " + this));
    }

    public String toString() {
        return String.format("%s on attempt #%s", this.f13547a.getClass().getSimpleName(), Integer.valueOf(this.f13550d));
    }

    static class Factory {
        Factory() {
        }

        /* JADX INFO: renamed from: a */
        <T> EnqueuedRequest<T> m13844a(LiveAgentRequest liveAgentRequest, Class<T> cls) {
            return new EnqueuedRequest<>(liveAgentRequest, cls);
        }
    }
}
