package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.gson.JsonElement;
import java.util.Locale;

public class UnregisteredMessage extends LiveAgentMessage {
   private final String a;

   public UnregisteredMessage(String var1, JsonElement var2) {
      super("UNKNOWN", var2);
      this.a = var1;
   }

   @Override
   public String toString() {
      return String.format(Locale.getDefault(), "Unregistered Live Agent Message. Type[%s] - Content[%s]", this.a, this.a(JsonElement.class));
   }
}
