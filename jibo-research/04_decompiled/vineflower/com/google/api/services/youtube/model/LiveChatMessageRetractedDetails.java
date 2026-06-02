package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatMessageRetractedDetails extends GenericJson {
   @Key
   private String retractedMessageId;

   public LiveChatMessageRetractedDetails clone() {
      return (LiveChatMessageRetractedDetails)super.clone();
   }

   public String getRetractedMessageId() {
      return this.retractedMessageId;
   }

   public LiveChatMessageRetractedDetails set(String var1, Object var2) {
      return (LiveChatMessageRetractedDetails)super.set(var1, var2);
   }

   public LiveChatMessageRetractedDetails setRetractedMessageId(String var1) {
      this.retractedMessageId = var1;
      return this;
   }
}
