package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class LiveChatPollOpenedDetails extends GenericJson {
   @Key
   private String id;
   @Key
   private List<LiveChatPollItem> items;
   @Key
   private String prompt;

   static {
      Data.nullOf(LiveChatPollItem.class);
   }

   public LiveChatPollOpenedDetails clone() {
      return (LiveChatPollOpenedDetails)super.clone();
   }

   public String getId() {
      return this.id;
   }

   public List<LiveChatPollItem> getItems() {
      return this.items;
   }

   public String getPrompt() {
      return this.prompt;
   }

   public LiveChatPollOpenedDetails set(String var1, Object var2) {
      return (LiveChatPollOpenedDetails)super.set(var1, var2);
   }

   public LiveChatPollOpenedDetails setId(String var1) {
      this.id = var1;
      return this;
   }

   public LiveChatPollOpenedDetails setItems(List<LiveChatPollItem> var1) {
      this.items = var1;
      return this;
   }

   public LiveChatPollOpenedDetails setPrompt(String var1) {
      this.prompt = var1;
      return this;
   }
}
