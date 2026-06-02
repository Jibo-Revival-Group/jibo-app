package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ActivityContentDetailsLike extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ActivityContentDetailsLike clone() {
      return (ActivityContentDetailsLike)super.clone();
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsLike set(String var1, Object var2) {
      return (ActivityContentDetailsLike)super.set(var1, var2);
   }

   public ActivityContentDetailsLike setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }
}
