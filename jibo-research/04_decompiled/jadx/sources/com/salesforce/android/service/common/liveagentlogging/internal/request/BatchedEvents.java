package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentSessionRequest;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.List;
import okhttp3.RequestBody;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class BatchedEvents implements LiveAgentSessionRequest {

    /* JADX INFO: renamed from: b */
    private final transient String f13638b;

    /* JADX INFO: renamed from: c */
    private final transient String f13639c;

    /* JADX INFO: renamed from: d */
    private final transient List<BaseEvent> f13640d;

    public BatchedEvents(String str, String str2, List<BaseEvent> list) {
        this.f13638b = str;
        this.f13639c = str2;
        this.f13640d = list;
    }

    /* JADX INFO: renamed from: a */
    public List<BaseEvent> m13922a() {
        return this.f13640d;
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest
    /* JADX INFO: renamed from: a */
    public String mo13861a(String str) {
        return String.format("https://%s/chat/rest/%s", Arguments.m14236a(str, "LiveAgent Pod must not be null"), "WebEvent/BatchedEvents");
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest
    /* JADX INFO: renamed from: a */
    public String mo13860a(Gson gson) {
        return gson.m9362b(this);
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest
    /* JADX INFO: renamed from: a */
    public HttpRequest mo13859a(String str, Gson gson, int i) {
        return HttpFactory.m13756b().mo13766a(mo13861a(str)).mo13767a(HttpHeaders.ACCEPT, "application/json; charset=utf-8").mo13767a("x-liveagent-api-version", "37").mo13767a("x-liveagent-session-key", this.f13638b).mo13767a("x-liveagent-affinity", this.f13639c).mo13767a("x-liveagent-sequence", Integer.toString(i)).mo13769a(RequestBody.m15785a(f13571a, mo13860a(gson))).mo13771c();
    }
}
