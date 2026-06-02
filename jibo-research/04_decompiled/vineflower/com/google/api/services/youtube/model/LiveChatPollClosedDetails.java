package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatPollClosedDetails extends GenericJson {
   @Key
   private String pollId;

   public LiveChatPollClosedDetails clone() {
      return (LiveChatPollClosedDetails)super.clone();
   }

   public String getPollId() {
      return this.pollId;
   }

   public LiveChatPollClosedDetails set(String var1, Object var2) {
      return (LiveChatPollClosedDetails)super.set(var1, var2);
   }

   public LiveChatPollClosedDetails setPollId(String var1) {
      this.pollId = var1;
      return this;
   }
}
