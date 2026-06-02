package com.salesforce.android.service.common.liveagentclient.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class CreateSessionRequest implements LiveAgentRequest {
   @Override
   public HttpRequest a(String var1, Gson var2, int var3) {
      return HttpFactory.b()
         .a(this.a(var1))
         .a("Accept", "application/json; charset=utf-8")
         .a("x-liveagent-api-version", "37")
         .a("x-liveagent-affinity", "null")
         .a()
         .c();
   }

   @Override
   public String a(Gson var1) {
      return var1.b(this);
   }

   @Override
   public String a(String var1) {
      return String.format("https://%s/chat/rest/%s", Arguments.a(var1, "LiveAgent Pod must not be null"), "System/SessionId");
   }
}
