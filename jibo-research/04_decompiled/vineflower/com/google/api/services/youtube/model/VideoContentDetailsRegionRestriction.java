package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class VideoContentDetailsRegionRestriction extends GenericJson {
   @Key
   private List<String> allowed;
   @Key
   private List<String> blocked;

   public VideoContentDetailsRegionRestriction clone() {
      return (VideoContentDetailsRegionRestriction)super.clone();
   }

   public List<String> getAllowed() {
      return this.allowed;
   }

   public List<String> getBlocked() {
      return this.blocked;
   }

   public VideoContentDetailsRegionRestriction set(String var1, Object var2) {
      return (VideoContentDetailsRegionRestriction)super.set(var1, var2);
   }

   public VideoContentDetailsRegionRestriction setAllowed(List<String> var1) {
      this.allowed = var1;
      return this;
   }

   public VideoContentDetailsRegionRestriction setBlocked(List<String> var1) {
      this.blocked = var1;
      return this;
   }
}
