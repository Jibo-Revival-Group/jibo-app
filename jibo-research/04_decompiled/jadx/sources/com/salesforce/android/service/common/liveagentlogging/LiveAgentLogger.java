package com.salesforce.android.service.common.liveagentlogging;

import android.content.Context;
import com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceConnection;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentLogger {

    /* JADX INFO: renamed from: a */
    private final LiveAgentLoggingServiceConnection f13579a;

    /* JADX INFO: renamed from: b */
    private final LiveAgentLoggingConfiguration f13580b;

    protected LiveAgentLogger(Builder builder) {
        this.f13580b = builder.f13581a;
        this.f13579a = builder.f13582b.m13930a();
    }

    /* JADX INFO: renamed from: a */
    public Async<LiveAgentLoggingSession> m13879a(Context context) {
        return this.f13579a.m13928a(context, this.f13579a.m13927a(context, this.f13580b));
    }

    /* JADX INFO: renamed from: a */
    public void m13880a() {
        this.f13579a.m13929a();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected LiveAgentLoggingConfiguration f13581a;

        /* JADX INFO: renamed from: b */
        protected LiveAgentLoggingServiceConnection.Builder f13582b;

        /* JADX INFO: renamed from: a */
        public Builder m13881a(LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
            this.f13581a = liveAgentLoggingConfiguration;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public LiveAgentLogger m13882a() {
            Arguments.m14235a(this.f13581a);
            if (this.f13582b == null) {
                this.f13582b = new LiveAgentLoggingServiceConnection.Builder();
            }
            return new LiveAgentLogger(this);
        }
    }
}
