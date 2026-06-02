package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class ChannelContentOwnerDetails extends GenericJson {
   @Key
   private String contentOwner;
   @Key
   private DateTime timeLinked;

   public ChannelContentOwnerDetails clone() {
      return (ChannelContentOwnerDetails)super.clone();
   }

   public String getContentOwner() {
      return this.contentOwner;
   }

   public DateTime getTimeLinked() {
      return this.timeLinked;
   }

   public ChannelContentOwnerDetails set(String var1, Object var2) {
      return (ChannelContentOwnerDetails)super.set(var1, var2);
   }

   public ChannelContentOwnerDetails setContentOwner(String var1) {
      this.contentOwner = var1;
      return this;
   }

   public ChannelContentOwnerDetails setTimeLinked(DateTime var1) {
      this.timeLinked = var1;
      return this;
   }
}
