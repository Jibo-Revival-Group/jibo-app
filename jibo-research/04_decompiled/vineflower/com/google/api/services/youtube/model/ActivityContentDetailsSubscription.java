package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ActivityContentDetailsSubscription extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ActivityContentDetailsSubscription clone() {
      return (ActivityContentDetailsSubscription)super.clone();
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsSubscription set(String var1, Object var2) {
      return (ActivityContentDetailsSubscription)super.set(var1, var2);
   }

   public ActivityContentDetailsSubscription setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }
}
