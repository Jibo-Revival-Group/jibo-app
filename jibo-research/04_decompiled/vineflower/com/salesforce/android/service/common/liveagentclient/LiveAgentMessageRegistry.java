package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.response.message.AsyncResult;
import com.salesforce.android.service.common.liveagentclient.response.message.SwitchServerMessage;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.HashMap;
import java.util.Map;

public class LiveAgentMessageRegistry {
   private static final ServiceLogger a = ServiceLogging.a(LiveAgentMessageRegistry.class);
   private Map<String, Class> b = new HashMap<>();

   public LiveAgentMessageRegistry() {
      this.a("AsyncResult", AsyncResult.class);
      this.a("SwitchServer", SwitchServerMessage.class);
   }

   public LiveAgentMessageRegistry a(String var1, Class var2) {
      this.b.put(var1, var2);
      a.a("Registered LiveAgentMessage content type {} as class {}", var1, var2.getSimpleName());
      return this;
   }

   public Class a(String var1) {
      return this.b.get(var1);
   }
}
