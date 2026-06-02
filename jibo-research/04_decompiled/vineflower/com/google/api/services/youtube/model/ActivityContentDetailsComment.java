package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ActivityContentDetailsComment extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ActivityContentDetailsComment clone() {
      return (ActivityContentDetailsComment)super.clone();
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsComment set(String var1, Object var2) {
      return (ActivityContentDetailsComment)super.set(var1, var2);
   }

   public ActivityContentDetailsComment setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }
}
