package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.google.gson.Gson;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentSessionRequest;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.List;
import okhttp3.RequestBody;

public class BatchedEvents implements LiveAgentSessionRequest {
   private final transient String b;
   private final transient String c;
   private final transient List<BaseEvent> d;

   public BatchedEvents(String var1, String var2, List<BaseEvent> var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   @Override
   public HttpRequest a(String var1, Gson var2, int var3) {
      return HttpFactory.b()
         .a(this.a(var1))
         .a("Accept", "application/json; charset=utf-8")
         .a("x-liveagent-api-version", "37")
         .a("x-liveagent-session-key", this.b)
         .a("x-liveagent-affinity", this.c)
         .a("x-liveagent-sequence", Integer.toString(var3))
         .a(RequestBody.a(a, this.a(var2)))
         .c();
   }

   @Override
   public String a(Gson var1) {
      return var1.b(this);
   }

   @Override
   public String a(String var1) {
      return String.format("https://%s/chat/rest/%s", Arguments.a(var1, "LiveAgent Pod must not be null"), "WebEvent/BatchedEvents");
   }

   public List<BaseEvent> a() {
      return this.d;
   }
}
