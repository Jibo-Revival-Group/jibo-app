package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.os.Binder;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentLoggingServiceBinder extends Binder {

    /* JADX INFO: renamed from: a */
    private final LiveAgentLoggingSession f13642a;

    protected LiveAgentLoggingServiceBinder(Builder builder) {
        this.f13642a = builder.f13643a;
    }

    /* JADX INFO: renamed from: a */
    LiveAgentLoggingSession m13924a() {
        return this.f13642a;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected LiveAgentLoggingSession f13643a;

        /* JADX INFO: renamed from: a */
        Builder m13925a(LiveAgentLoggingSession liveAgentLoggingSession) {
            this.f13643a = liveAgentLoggingSession;
            return this;
        }

        /* JADX INFO: renamed from: a */
        LiveAgentLoggingServiceBinder m13926a() {
            Arguments.m14235a(this.f13643a);
            return new LiveAgentLoggingServiceBinder(this);
        }
    }
}
