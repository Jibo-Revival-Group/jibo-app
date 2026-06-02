package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSpiCall {

    /* JADX INFO: renamed from: b */
    private static final Pattern f14551b = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* JADX INFO: renamed from: a */
    protected final Kit f14552a;

    /* JADX INFO: renamed from: c */
    private final String f14553c;

    /* JADX INFO: renamed from: d */
    private final HttpRequestFactory f14554d;

    /* JADX INFO: renamed from: e */
    private final HttpMethod f14555e;

    /* JADX INFO: renamed from: f */
    private final String f14556f;

    public AbstractSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (httpRequestFactory == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.f14552a = kit;
        this.f14556f = str;
        this.f14553c = m15142a(str2);
        this.f14554d = httpRequestFactory;
        this.f14555e = httpMethod;
    }

    /* JADX INFO: renamed from: a */
    protected String m15144a() {
        return this.f14553c;
    }

    /* JADX INFO: renamed from: b */
    protected HttpRequest m15145b() {
        return m15143a(Collections.emptyMap());
    }

    /* JADX INFO: renamed from: a */
    protected HttpRequest m15143a(Map<String, String> map) {
        return this.f14554d.mo15345a(this.f14555e, m15144a(), map).m15373a(false).m15363a(10000).m15366a("User-Agent", "Crashlytics Android SDK/" + this.f14552a.mo5600a()).m15366a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* JADX INFO: renamed from: a */
    private String m15142a(String str) {
        if (!CommonUtils.m15200c(this.f14556f)) {
            return f14551b.matcher(str).replaceFirst(this.f14556f);
        }
        return str;
    }
}
