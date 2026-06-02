package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PlaylistItemStatus extends GenericJson {
   @Key
   private String privacyStatus;

   public PlaylistItemStatus clone() {
      return (PlaylistItemStatus)super.clone();
   }

   public String getPrivacyStatus() {
      return this.privacyStatus;
   }

   public PlaylistItemStatus set(String var1, Object var2) {
      return (PlaylistItemStatus)super.set(var1, var2);
   }

   public PlaylistItemStatus setPrivacyStatus(String var1) {
      this.privacyStatus = var1;
      return this;
   }
}
