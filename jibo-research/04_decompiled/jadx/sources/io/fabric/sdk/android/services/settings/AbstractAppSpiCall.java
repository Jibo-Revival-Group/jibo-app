package io.fabric.sdk.android.services.settings;

import android.content.res.Resources;
import com.google.api.client.http.HttpMethods;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractAppSpiCall extends AbstractSpiCall {
    public AbstractAppSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo15426a(AppRequestData appRequestData) {
        HttpRequest httpRequestM15424b = m15424b(m15423a(m15145b(), appRequestData), appRequestData);
        Fabric.m15085h().mo15063a("Fabric", "Sending app info to " + m15144a());
        if (appRequestData.f14742j != null) {
            Fabric.m15085h().mo15063a("Fabric", "App icon hash is " + appRequestData.f14742j.f14764a);
            Fabric.m15085h().mo15063a("Fabric", "App icon size is " + appRequestData.f14742j.f14766c + "x" + appRequestData.f14742j.f14767d);
        }
        int iM15376b = httpRequestM15424b.m15376b();
        Fabric.m15085h().mo15063a("Fabric", (HttpMethods.POST.equals(httpRequestM15424b.m15400p()) ? "Create" : "Update") + " app request ID: " + httpRequestM15424b.m15378b("X-REQUEST-ID"));
        Fabric.m15085h().mo15063a("Fabric", "Result was " + iM15376b);
        return ResponseParser.m15266a(iM15376b) == 0;
    }

    /* JADX INFO: renamed from: a */
    private HttpRequest m15423a(HttpRequest httpRequest, AppRequestData appRequestData) {
        return httpRequest.m15366a("X-CRASHLYTICS-API-KEY", appRequestData.f14733a).m15366a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m15366a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f14552a.mo5600a());
    }

    /* JADX INFO: renamed from: b */
    private HttpRequest m15424b(HttpRequest httpRequest, AppRequestData appRequestData) {
        HttpRequest httpRequestM15386e = httpRequest.m15386e("app[identifier]", appRequestData.f14734b).m15386e("app[name]", appRequestData.f14738f).m15386e("app[display_version]", appRequestData.f14735c).m15386e("app[build_version]", appRequestData.f14736d).m15365a("app[source]", Integer.valueOf(appRequestData.f14739g)).m15386e("app[minimum_sdk_version]", appRequestData.f14740h).m15386e("app[built_sdk_version]", appRequestData.f14741i);
        if (!CommonUtils.m15200c(appRequestData.f14737e)) {
            httpRequestM15386e.m15386e("app[instance_identifier]", appRequestData.f14737e);
        }
        if (appRequestData.f14742j != null) {
            InputStream inputStreamOpenRawResource = null;
            try {
                inputStreamOpenRawResource = this.f14552a.m15121r().getResources().openRawResource(appRequestData.f14742j.f14765b);
                httpRequestM15386e.m15386e("app[icon][hash]", appRequestData.f14742j.f14764a).m15370a("app[icon][data]", "icon.png", "application/octet-stream", inputStreamOpenRawResource).m15365a("app[icon][width]", Integer.valueOf(appRequestData.f14742j.f14766c)).m15365a("app[icon][height]", Integer.valueOf(appRequestData.f14742j.f14767d));
            } catch (Resources.NotFoundException e) {
                Fabric.m15085h().mo15073e("Fabric", "Failed to find app icon with resource ID: " + appRequestData.f14742j.f14765b, e);
            } finally {
                CommonUtils.m15188a((Closeable) inputStreamOpenRawResource, "Failed to close app icon InputStream.");
            }
        }
        if (appRequestData.f14743k != null) {
            for (KitInfo kitInfo : appRequestData.f14743k) {
                httpRequestM15386e.m15386e(m15425a(kitInfo), kitInfo.m15127b());
                httpRequestM15386e.m15386e(m15427b(kitInfo), kitInfo.m15128c());
            }
        }
        return httpRequestM15386e;
    }

    /* JADX INFO: renamed from: a */
    String m15425a(KitInfo kitInfo) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", kitInfo.m15126a());
    }

    /* JADX INFO: renamed from: b */
    String m15427b(KitInfo kitInfo) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", kitInfo.m15126a());
    }
}
