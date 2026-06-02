package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChannelProfileDetails extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelUrl;
   @Key
   private String displayName;
   @Key
   private String profileImageUrl;

   public ChannelProfileDetails clone() {
      return (ChannelProfileDetails)super.clone();
   }

   public String getChannelId() {
      return this.channelId;
   }

   public String getChannelUrl() {
      return this.channelUrl;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public String getProfileImageUrl() {
      return this.profileImageUrl;
   }

   public ChannelProfileDetails set(String var1, Object var2) {
      return (ChannelProfileDetails)super.set(var1, var2);
   }

   public ChannelProfileDetails setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public ChannelProfileDetails setChannelUrl(String var1) {
      this.channelUrl = var1;
      return this;
   }

   public ChannelProfileDetails setDisplayName(String var1) {
      this.displayName = var1;
      return this;
   }

   public ChannelProfileDetails setProfileImageUrl(String var1) {
      this.profileImageUrl = var1;
      return this;
   }
}
