package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }

    @Override // com.crashlytics.android.core.CreateReportSpiCall
    /* JADX INFO: renamed from: a */
    public boolean mo5897a(CreateReportRequest createReportRequest) throws Throwable {
        HttpRequest httpRequestM5899a = m5899a(m5898a(m15145b(), createReportRequest), createReportRequest.f5251b);
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Sending report to: " + m15144a());
        int iM15376b = httpRequestM5899a.m15376b();
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Create report request ID: " + httpRequestM5899a.m15378b("X-REQUEST-ID"));
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Result was: " + iM15376b);
        return ResponseParser.m15266a(iM15376b) == 0;
    }

    /* JADX INFO: renamed from: a */
    private HttpRequest m5898a(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        HttpRequest httpRequestM15366a = httpRequest.m15366a("X-CRASHLYTICS-API-KEY", createReportRequest.f5250a).m15366a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m15366a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f14552a.mo5600a());
        Iterator<Map.Entry<String, String>> it = createReportRequest.f5251b.mo5918e().entrySet().iterator();
        while (true) {
            HttpRequest httpRequest2 = httpRequestM15366a;
            if (it.hasNext()) {
                httpRequestM15366a = httpRequest2.m15372a(it.next());
            } else {
                return httpRequest2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private HttpRequest m5899a(HttpRequest httpRequest, Report report) throws Throwable {
        httpRequest.m15386e("report[identifier]", report.mo5915b());
        if (report.mo5917d().length == 1) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Adding single file " + report.mo5914a() + " to report " + report.mo5915b());
            return httpRequest.m15369a("report[file]", report.mo5914a(), "application/octet-stream", report.mo5916c());
        }
        int i = 0;
        for (File file : report.mo5917d()) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Adding file " + file.getName() + " to report " + report.mo5915b());
            httpRequest.m15369a("report[file" + i + "]", file.getName(), "application/octet-stream", file);
            i++;
        }
        return httpRequest;
    }
}
