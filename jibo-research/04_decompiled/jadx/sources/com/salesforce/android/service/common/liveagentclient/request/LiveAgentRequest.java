package com.salesforce.android.service.common.liveagentclient.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpRequest;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public interface LiveAgentRequest {

    /* JADX INFO: renamed from: a */
    public static final MediaType f13571a = MediaType.m15695a("application/json; charset=utf-8");

    /* JADX INFO: renamed from: a */
    HttpRequest mo13859a(String str, Gson gson, int i);

    /* JADX INFO: renamed from: a */
    String mo13860a(Gson gson);

    /* JADX INFO: renamed from: a */
    String mo13861a(String str);
}
