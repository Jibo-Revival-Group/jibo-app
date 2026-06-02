package com.salesforce.android.service.common.liveagentclient.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class DeleteSessionRequest implements LiveAgentSessionRequest {
   private final transient String b;
   private final transient String c;

   public DeleteSessionRequest(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   @Override
   public HttpRequest a(String var1, Gson var2, int var3) {
      return HttpFactory.b()
         .a(this.a(var1))
         .a("Accept", "application/json; charset=utf-8")
         .a("x-liveagent-api-version", "37")
         .a("x-liveagent-session-key", this.b)
         .a("x-liveagent-affinity", this.c)
         .b()
         .c();
   }

   @Override
   public String a(Gson var1) {
      return var1.b(this);
   }

   @Override
   public String a(String var1) {
      return String.format("https://%s/chat/rest/%s/%s", Arguments.a(var1, "LiveAgent Pod must not be null"), "System/SessionId", this.b);
   }
}
