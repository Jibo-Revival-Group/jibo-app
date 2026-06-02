package com.salesforce.android.service.common.liveagentclient.response.message;

public class LiveAgentMessage {
   private final String a;
   private final Object b;

   public LiveAgentMessage(String var1, Object var2) {
      this.b = var2;
      this.a = var1;
   }

   public <T> T a(Class<T> var1) {
      return (T)var1.cast(this.b);
   }

   public String a() {
      return this.a;
   }
}
