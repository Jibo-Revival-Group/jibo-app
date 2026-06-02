package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveChatUserBannedMessageDetails extends GenericJson {
   @JsonString
   @Key
   private BigInteger banDurationSeconds;
   @Key
   private String banType;
   @Key
   private ChannelProfileDetails bannedUserDetails;

   public LiveChatUserBannedMessageDetails clone() {
      return (LiveChatUserBannedMessageDetails)super.clone();
   }

   public BigInteger getBanDurationSeconds() {
      return this.banDurationSeconds;
   }

   public String getBanType() {
      return this.banType;
   }

   public ChannelProfileDetails getBannedUserDetails() {
      return this.bannedUserDetails;
   }

   public LiveChatUserBannedMessageDetails set(String var1, Object var2) {
      return (LiveChatUserBannedMessageDetails)super.set(var1, var2);
   }

   public LiveChatUserBannedMessageDetails setBanDurationSeconds(BigInteger var1) {
      this.banDurationSeconds = var1;
      return this;
   }

   public LiveChatUserBannedMessageDetails setBanType(String var1) {
      this.banType = var1;
      return this;
   }

   public LiveChatUserBannedMessageDetails setBannedUserDetails(ChannelProfileDetails var1) {
      this.bannedUserDetails = var1;
      return this;
   }
}
