package com.salesforce.android.service.common.liveagentclient.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpRequest;
import okhttp3.MediaType;

public interface LiveAgentRequest {
   MediaType a = MediaType.a("application/json; charset=utf-8");

   HttpRequest a(String var1, Gson var2, int var3);

   String a(Gson var1);

   String a(String var1);
}
