package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class SessionAnalyticsFilesSender extends AbstractSpiCall implements FilesSender {

    /* JADX INFO: renamed from: b */
    private final String f5069b;

    public SessionAnalyticsFilesSender(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
        this.f5069b = str3;
    }

    @Override // io.fabric.sdk.android.services.events.FilesSender
    /* JADX INFO: renamed from: a */
    public boolean mo5638a(List<File> list) throws Throwable {
        HttpRequest httpRequestM15366a = m15145b().m15366a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m15366a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f14552a.mo5600a()).m15366a("X-CRASHLYTICS-API-KEY", this.f5069b);
        int i = 0;
        for (File file : list) {
            httpRequestM15366a.m15369a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        Fabric.m15085h().mo15063a("Answers", "Sending " + list.size() + " analytics files to " + m15144a());
        int iM15376b = httpRequestM15366a.m15376b();
        Fabric.m15085h().mo15063a("Answers", "Response code for analytics file send is " + iM15376b);
        return ResponseParser.m15266a(iM15376b) == 0;
    }
}
