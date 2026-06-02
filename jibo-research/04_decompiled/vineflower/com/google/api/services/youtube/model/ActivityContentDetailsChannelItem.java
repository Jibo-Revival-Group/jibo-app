package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ActivityContentDetailsChannelItem extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ActivityContentDetailsChannelItem clone() {
      return (ActivityContentDetailsChannelItem)super.clone();
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsChannelItem set(String var1, Object var2) {
      return (ActivityContentDetailsChannelItem)super.set(var1, var2);
   }

   public ActivityContentDetailsChannelItem setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }
}
