package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PlaylistContentDetails extends GenericJson {
   @Key
   private Long itemCount;

   public PlaylistContentDetails clone() {
      return (PlaylistContentDetails)super.clone();
   }

   public Long getItemCount() {
      return this.itemCount;
   }

   public PlaylistContentDetails set(String var1, Object var2) {
      return (PlaylistContentDetails)super.set(var1, var2);
   }

   public PlaylistContentDetails setItemCount(Long var1) {
      this.itemCount = var1;
      return this;
   }
}
