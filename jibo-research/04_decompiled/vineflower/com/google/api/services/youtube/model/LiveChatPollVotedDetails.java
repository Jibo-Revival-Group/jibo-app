package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatPollVotedDetails extends GenericJson {
   @Key
   private String itemId;
   @Key
   private String pollId;

   public LiveChatPollVotedDetails clone() {
      return (LiveChatPollVotedDetails)super.clone();
   }

   public String getItemId() {
      return this.itemId;
   }

   public String getPollId() {
      return this.pollId;
   }

   public LiveChatPollVotedDetails set(String var1, Object var2) {
      return (LiveChatPollVotedDetails)super.set(var1, var2);
   }

   public LiveChatPollVotedDetails setItemId(String var1) {
      this.itemId = var1;
      return this;
   }

   public LiveChatPollVotedDetails setPollId(String var1) {
      this.pollId = var1;
      return this;
   }
}
