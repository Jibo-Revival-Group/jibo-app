package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class VideoMonetizationDetails extends GenericJson {
   @Key
   private AccessPolicy access;

   public VideoMonetizationDetails clone() {
      return (VideoMonetizationDetails)super.clone();
   }

   public AccessPolicy getAccess() {
      return this.access;
   }

   public VideoMonetizationDetails set(String var1, Object var2) {
      return (VideoMonetizationDetails)super.set(var1, var2);
   }

   public VideoMonetizationDetails setAccess(AccessPolicy var1) {
      this.access = var1;
      return this;
   }
}
