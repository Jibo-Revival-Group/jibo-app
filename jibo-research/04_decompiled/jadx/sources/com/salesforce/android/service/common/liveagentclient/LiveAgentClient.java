package com.salesforce.android.service.common.liveagentclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpJob;
import com.salesforce.android.service.common.http.TlsSocketFactory;
import com.salesforce.android.service.common.liveagentclient.json.GsonFactory;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.TlsVersion;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentClient {

    /* JADX INFO: renamed from: b */
    private static final ServiceLogger f13477b = ServiceLogging.m14203a((Class<?>) LiveAgentClient.class);

    /* JADX INFO: renamed from: a */
    String f13478a;

    /* JADX INFO: renamed from: c */
    private final JobQueue f13479c;

    /* JADX INFO: renamed from: d */
    private final HttpClient f13480d;

    /* JADX INFO: renamed from: e */
    private final Gson f13481e;

    protected LiveAgentClient(Builder builder) {
        f13477b.mo14187a("Initializing LiveAgentClient for pod {}", builder.f13482a);
        this.f13478a = builder.f13482a;
        this.f13480d = builder.f13484c;
        this.f13479c = builder.f13483b;
        this.f13481e = builder.f13485d;
    }

    /* JADX INFO: renamed from: a */
    public void m13795a(String str) {
        f13477b.mo14187a("Updating LiveAgentClient pod: {} --> {}", this.f13478a, str);
        this.f13478a = str;
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m13791a(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        return m13794a(liveAgentRequest, cls, this.f13480d, 0);
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m13792a(LiveAgentRequest liveAgentRequest, Class<T> cls, int i) {
        return m13794a(liveAgentRequest, cls, this.f13480d, i);
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m13793a(LiveAgentRequest liveAgentRequest, Class<T> cls, long j) {
        return m13794a(liveAgentRequest, cls, this.f13480d.mo13746a().mo13753b(j, TimeUnit.MILLISECONDS).mo13747a(), 0);
    }

    /* JADX INFO: renamed from: a */
    <T> Async<T> m13794a(LiveAgentRequest liveAgentRequest, Class<T> cls, HttpClient httpClient, int i) {
        if (i > 0) {
            f13477b.mo14187a("Sending #{} {} to LiveAgent: URL[{}] - Body[{}]", Integer.valueOf(i), liveAgentRequest.getClass().getSimpleName(), liveAgentRequest.mo13861a(this.f13478a), liveAgentRequest.mo13860a(this.f13481e));
        } else {
            f13477b.mo14187a("Sending {} to LiveAgent: URL[{}] - Body[{}]", liveAgentRequest.getClass().getSimpleName(), liveAgentRequest.mo13861a(this.f13478a), liveAgentRequest.mo13860a(this.f13481e));
        }
        return this.f13479c.m14223a(HttpJob.m13757a(httpClient, liveAgentRequest.mo13859a(this.f13478a, this.f13481e, i), cls, this.f13481e));
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected String f13482a;

        /* JADX INFO: renamed from: b */
        protected JobQueue f13483b;

        /* JADX INFO: renamed from: c */
        protected HttpClient f13484c;

        /* JADX INFO: renamed from: d */
        protected Gson f13485d;

        /* JADX INFO: renamed from: e */
        private LiveAgentMessageRegistry f13486e;

        /* JADX INFO: renamed from: f */
        private boolean f13487f = false;

        /* JADX INFO: renamed from: g */
        private GsonBuilder f13488g;

        /* JADX INFO: renamed from: a */
        public Builder m13797a(String str) {
            this.f13482a = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13796a(GsonBuilder gsonBuilder) {
            this.f13488g = gsonBuilder;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public LiveAgentClient m13798a() throws NoSuchAlgorithmException, KeyManagementException {
            Arguments.m14238a(this.f13482a);
            if (this.f13483b == null) {
                this.f13483b = new JobQueue(Executors.newFixedThreadPool(2, PriorityThreadFactory.m14230a()));
            }
            if (this.f13484c == null) {
                this.f13484c = HttpFactory.m13755a().mo13749a(Arrays.asList(new ConnectionSpec.Builder(ConnectionSpec.f15029a).m15572a(TlsVersion.TLS_1_2).m15573a(), ConnectionSpec.f15031c)).mo13750a(new TlsSocketFactory(), TlsSocketFactory.m13782a()).mo13747a();
            }
            if (this.f13486e == null) {
                this.f13486e = new LiveAgentMessageRegistry();
            }
            if (this.f13488g == null) {
                this.f13488g = new GsonBuilder();
            }
            this.f13485d = GsonFactory.m13856a(this.f13488g, this.f13486e, this.f13487f);
            return new LiveAgentClient(this);
        }
    }
}
