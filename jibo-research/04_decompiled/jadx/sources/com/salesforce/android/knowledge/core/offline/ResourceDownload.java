package com.salesforce.android.knowledge.core.offline;

import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpResponse;
import com.salesforce.android.service.common.http.HttpResponseBody;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.io.IOException;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
class ResourceDownload {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13032a = ServiceLogging.m14203a((Class<?>) ResourceDownload.class);

    /* JADX INFO: renamed from: b */
    private final String f13033b;

    /* JADX INFO: renamed from: c */
    private final HttpClient f13034c;

    ResourceDownload(String str, HttpClient httpClient) {
        this.f13033b = str;
        this.f13034c = httpClient;
    }

    /* JADX INFO: renamed from: a */
    boolean m13301a(OfflineResourceCache offlineResourceCache) throws IOException {
        HttpUrl httpUrlM15645e = HttpUrl.m15645e(this.f13033b);
        if (httpUrlM15645e == null) {
            throw new IOException("Invalid url");
        }
        f13032a.mo14187a("Starting download of resource at {}", this.f13033b);
        HttpResponse httpResponseMo13744a = this.f13034c.mo13745a(HttpFactory.m13756b().mo13768a(httpUrlM15645e).mo13771c()).mo13744a();
        HttpResponseBody httpResponseBodyMo13774c = httpResponseMo13744a.mo13774c();
        boolean zMo13773b = httpResponseMo13744a.mo13773b();
        if (zMo13773b) {
            zMo13773b = offlineResourceCache.m13291a(this.f13033b, httpResponseBodyMo13774c.mo13775a());
        } else {
            f13032a.mo14193d("Error downloading {}. Code {}", this.f13033b, Integer.valueOf(httpResponseMo13744a.mo13772a()));
        }
        httpResponseBodyMo13774c.close();
        return zMo13773b;
    }

    static class Factory {

        /* JADX INFO: renamed from: a */
        private final HttpClient f13035a;

        Factory(HttpClient httpClient) {
            this.f13035a = httpClient;
        }

        /* JADX INFO: renamed from: a */
        ResourceDownload m13302a(String str) {
            return new ResourceDownload(str, this.f13035a);
        }
    }
}
