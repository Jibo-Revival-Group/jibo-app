package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ActivityContentDetailsBulletin extends GenericJson {
   @Key
   private ResourceId resourceId;

   public ActivityContentDetailsBulletin clone() {
      return (ActivityContentDetailsBulletin)super.clone();
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ActivityContentDetailsBulletin set(String var1, Object var2) {
      return (ActivityContentDetailsBulletin)super.set(var1, var2);
   }

   public ActivityContentDetailsBulletin setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }
}
