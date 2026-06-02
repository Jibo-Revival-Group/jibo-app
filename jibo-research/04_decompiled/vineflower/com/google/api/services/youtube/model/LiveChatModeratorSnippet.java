package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatModeratorSnippet extends GenericJson {
   @Key
   private String liveChatId;
   @Key
   private ChannelProfileDetails moderatorDetails;

   public LiveChatModeratorSnippet clone() {
      return (LiveChatModeratorSnippet)super.clone();
   }

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public ChannelProfileDetails getModeratorDetails() {
      return this.moderatorDetails;
   }

   public LiveChatModeratorSnippet set(String var1, Object var2) {
      return (LiveChatModeratorSnippet)super.set(var1, var2);
   }

   public LiveChatModeratorSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public LiveChatModeratorSnippet setModeratorDetails(ChannelProfileDetails var1) {
      this.moderatorDetails = var1;
      return this;
   }
}
