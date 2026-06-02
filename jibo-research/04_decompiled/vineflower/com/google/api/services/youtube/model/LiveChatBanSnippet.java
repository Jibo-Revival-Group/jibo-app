package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveChatBanSnippet extends GenericJson {
   @JsonString
   @Key
   private BigInteger banDurationSeconds;
   @Key
   private ChannelProfileDetails bannedUserDetails;
   @Key
   private String liveChatId;
   @Key
   private String type;

   public LiveChatBanSnippet clone() {
      return (LiveChatBanSnippet)super.clone();
   }

   public BigInteger getBanDurationSeconds() {
      return this.banDurationSeconds;
   }

   public ChannelProfileDetails getBannedUserDetails() {
      return this.bannedUserDetails;
   }

   public String getLiveChatId() {
      return this.liveChatId;
   }

   public String getType() {
      return this.type;
   }

   public LiveChatBanSnippet set(String var1, Object var2) {
      return (LiveChatBanSnippet)super.set(var1, var2);
   }

   public LiveChatBanSnippet setBanDurationSeconds(BigInteger var1) {
      this.banDurationSeconds = var1;
      return this;
   }

   public LiveChatBanSnippet setBannedUserDetails(ChannelProfileDetails var1) {
      this.bannedUserDetails = var1;
      return this;
   }

   public LiveChatBanSnippet setLiveChatId(String var1) {
      this.liveChatId = var1;
      return this;
   }

   public LiveChatBanSnippet setType(String var1) {
      this.type = var1;
      return this;
   }
}
