package com.salesforce.android.service.common.liveagentclient.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class DeleteSessionRequest implements LiveAgentSessionRequest {

    /* JADX INFO: renamed from: b */
    private final transient String f13569b;

    /* JADX INFO: renamed from: c */
    private final transient String f13570c;

    public DeleteSessionRequest(String str, String str2) {
        this.f13569b = str;
        this.f13570c = str2;
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest
    /* JADX INFO: renamed from: a */
    public String mo13861a(String str) {
        return String.format("https://%s/chat/rest/%s/%s", Arguments.m14236a(str, "LiveAgent Pod must not be null"), "System/SessionId", this.f13569b);
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest
    /* JADX INFO: renamed from: a */
    public String mo13860a(Gson gson) {
        return gson.m9362b(this);
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest
    /* JADX INFO: renamed from: a */
    public HttpRequest mo13859a(String str, Gson gson, int i) {
        return HttpFactory.m13756b().mo13766a(mo13861a(str)).mo13767a(HttpHeaders.ACCEPT, "application/json; charset=utf-8").mo13767a("x-liveagent-api-version", "37").mo13767a("x-liveagent-session-key", this.f13569b).mo13767a("x-liveagent-affinity", this.f13570c).mo13770b().mo13771c();
    }
}
