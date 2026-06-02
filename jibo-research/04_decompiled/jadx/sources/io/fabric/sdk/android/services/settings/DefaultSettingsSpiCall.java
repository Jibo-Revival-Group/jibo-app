package io.fabric.sdk.android.services.settings;

import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a9  */
    @Override // io.fabric.sdk.android.services.settings.SettingsSpiCall
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject mo15452a(io.fabric.sdk.android.services.settings.SettingsRequest r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.DefaultSettingsSpiCall.mo15452a(io.fabric.sdk.android.services.settings.SettingsRequest):org.json.JSONObject");
    }

    /* JADX INFO: renamed from: a */
    JSONObject m15451a(HttpRequest httpRequest) {
        int iM15376b = httpRequest.m15376b();
        Fabric.m15085h().mo15063a("Fabric", "Settings result was: " + iM15376b);
        if (m15453a(iM15376b)) {
            return m15448a(httpRequest.m15387e());
        }
        Fabric.m15085h().mo15072e("Fabric", "Failed to retrieve settings from " + m15144a());
        return null;
    }

    /* JADX INFO: renamed from: a */
    boolean m15453a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    /* JADX INFO: renamed from: a */
    private JSONObject m15448a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Fabric.m15085h().mo15064a("Fabric", "Failed to parse settings JSON from " + m15144a(), e);
            Fabric.m15085h().mo15063a("Fabric", "Settings response " + str);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private Map<String, String> m15450b(SettingsRequest settingsRequest) {
        HashMap map = new HashMap();
        map.put("build_version", settingsRequest.f14806j);
        map.put("display_version", settingsRequest.f14805i);
        map.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(settingsRequest.f14807k));
        if (settingsRequest.f14808l != null) {
            map.put("icon_hash", settingsRequest.f14808l);
        }
        String str = settingsRequest.f14804h;
        if (!CommonUtils.m15200c(str)) {
            map.put("instance", str);
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private HttpRequest m15447a(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        m15449a(httpRequest, "X-CRASHLYTICS-API-KEY", settingsRequest.f14797a);
        m15449a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m15449a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f14552a.mo5600a());
        m15449a(httpRequest, HttpHeaders.ACCEPT, "application/json");
        m15449a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f14798b);
        m15449a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f14799c);
        m15449a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f14800d);
        m15449a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", settingsRequest.f14801e);
        m15449a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.f14802f);
        m15449a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", settingsRequest.f14803g);
        return httpRequest;
    }

    /* JADX INFO: renamed from: a */
    private void m15449a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.m15366a(str, str2);
        }
    }
}
