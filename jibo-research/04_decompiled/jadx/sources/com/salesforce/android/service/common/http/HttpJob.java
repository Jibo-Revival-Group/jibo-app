package com.salesforce.android.service.common.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class HttpJob<T> implements Job<T> {

    /* JADX INFO: renamed from: e */
    private static final ServiceLogger f13457e = ServiceLogging.m14203a((Class<?>) HttpJob.class);

    /* JADX INFO: renamed from: a */
    final HttpClient f13458a;

    /* JADX INFO: renamed from: b */
    final HttpRequest f13459b;

    /* JADX INFO: renamed from: c */
    final Class<T> f13460c;

    /* JADX INFO: renamed from: d */
    final Gson f13461d;

    /* JADX INFO: renamed from: a */
    public static <T> HttpJob<T> m13757a(HttpClient httpClient, HttpRequest httpRequest, Class<T> cls, Gson gson) {
        return new Builder().m13759a(httpClient).m13760a(httpRequest).m13761a(cls).m13758a(gson).m13762a();
    }

    protected HttpJob(Builder<T> builder) {
        this.f13458a = builder.f13462a;
        this.f13459b = builder.f13463b;
        this.f13460c = builder.f13464c;
        this.f13461d = builder.f13465d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.salesforce.android.service.common.utilities.threading.Job
    /* JADX INFO: renamed from: a */
    public void mo12210a(ResultReceiver<T> resultReceiver) {
        f13457e.mo14187a("Submitting http request to {}", this.f13459b.mo13763a());
        HttpResponse httpResponse = null;
        try {
            try {
                HttpResponse httpResponseMo13744a = this.f13458a.mo13745a(this.f13459b).mo13744a();
                if (httpResponseMo13744a.mo13773b()) {
                    resultReceiver.mo12614b(this.f13461d.m9353a(httpResponseMo13744a.mo13774c().mo13776b(), (Class) this.f13460c));
                    resultReceiver.mo12613b();
                } else {
                    f13457e.mo14193d("Unsuccessful HTTP request: {}", httpResponseMo13744a.toString());
                    resultReceiver.mo12615b((Throwable) new ResponseException("Unsuccessful HTTP request: " + httpResponseMo13744a.toString(), httpResponseMo13744a.mo13772a(), httpResponseMo13744a.mo13774c().mo13777c()));
                }
                if (httpResponseMo13744a != null) {
                    try {
                        httpResponseMo13744a.close();
                    } catch (IOException e) {
                        f13457e.mo14193d("Unable to close HTTP response stream.\n{}", e);
                    }
                }
            } catch (Exception e2) {
                f13457e.mo14193d("Encountered Exception during HTTP request {}\nResponse: {}", e2, null);
                resultReceiver.mo12615b((Throwable) e2);
                if (0 != 0) {
                    try {
                        httpResponse.close();
                    } catch (IOException e3) {
                        f13457e.mo14193d("Unable to close HTTP response stream.\n{}", e3);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpResponse.close();
                } catch (IOException e4) {
                    f13457e.mo14193d("Unable to close HTTP response stream.\n{}", e4);
                }
            }
            throw th;
        }
    }

    public static class Builder<T> {

        /* JADX INFO: renamed from: a */
        protected HttpClient f13462a;

        /* JADX INFO: renamed from: b */
        protected HttpRequest f13463b;

        /* JADX INFO: renamed from: c */
        protected Class<T> f13464c;

        /* JADX INFO: renamed from: d */
        protected Gson f13465d;

        /* JADX INFO: renamed from: a */
        public Builder<T> m13759a(HttpClient httpClient) {
            this.f13462a = httpClient;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder<T> m13760a(HttpRequest httpRequest) {
            this.f13463b = httpRequest;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder<T> m13761a(Class<T> cls) {
            this.f13464c = cls;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder<T> m13758a(Gson gson) {
            this.f13465d = gson;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public HttpJob<T> m13762a() {
            Arguments.m14235a(this.f13462a);
            Arguments.m14235a(this.f13463b);
            Arguments.m14235a(this.f13464c);
            if (this.f13465d == null) {
                this.f13465d = new GsonBuilder().m9376a();
            }
            return new HttpJob<>(this);
        }
    }
}
