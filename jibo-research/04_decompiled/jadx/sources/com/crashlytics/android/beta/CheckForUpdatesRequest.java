package com.crashlytics.android.beta;

import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
class CheckForUpdatesRequest extends AbstractSpiCall {

    /* JADX INFO: renamed from: b */
    private final CheckForUpdatesResponseTransform f5130b;

    /* JADX INFO: renamed from: a */
    static String m5702a(String str) {
        return "3:" + str;
    }

    public CheckForUpdatesRequest(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.GET);
        this.f5130b = checkForUpdatesResponseTransform;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00f5 -> B:27:0x008d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00f7 -> B:27:0x008d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.crashlytics.android.beta.CheckForUpdatesResponse m5704a(java.lang.String r8, java.lang.String r9, com.crashlytics.android.beta.BuildProperties r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.CheckForUpdatesRequest.m5704a(java.lang.String, java.lang.String, com.crashlytics.android.beta.BuildProperties):com.crashlytics.android.beta.CheckForUpdatesResponse");
    }

    /* JADX INFO: renamed from: a */
    private HttpRequest m5701a(HttpRequest httpRequest, String str, String str2) {
        return httpRequest.m15366a(HttpHeaders.ACCEPT, "application/json").m15366a("User-Agent", "Crashlytics Android SDK/" + this.f14552a.mo5600a()).m15366a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").m15366a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m15366a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f14552a.mo5600a()).m15366a("X-CRASHLYTICS-API-KEY", str).m15366a("X-CRASHLYTICS-BETA-TOKEN", m5702a(str2));
    }

    /* JADX INFO: renamed from: a */
    private Map<String, String> m5703a(BuildProperties buildProperties) {
        HashMap map = new HashMap();
        map.put("build_version", buildProperties.f5126a);
        map.put("display_version", buildProperties.f5127b);
        map.put("instance", buildProperties.f5128c);
        map.put(ShareConstants.FEED_SOURCE_PARAM, "3");
        return map;
    }
}
