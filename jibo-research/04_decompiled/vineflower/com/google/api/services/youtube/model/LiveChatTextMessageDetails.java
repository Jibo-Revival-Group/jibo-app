package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveChatTextMessageDetails extends GenericJson {
   @Key
   private String messageText;

   public LiveChatTextMessageDetails clone() {
      return (LiveChatTextMessageDetails)super.clone();
   }

   public String getMessageText() {
      return this.messageText;
   }

   public LiveChatTextMessageDetails set(String var1, Object var2) {
      return (LiveChatTextMessageDetails)super.set(var1, var2);
   }

   public LiveChatTextMessageDetails setMessageText(String var1) {
      this.messageText = var1;
      return this;
   }
}
