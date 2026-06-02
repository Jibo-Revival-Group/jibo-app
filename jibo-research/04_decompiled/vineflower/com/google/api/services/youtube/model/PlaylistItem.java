package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class PlaylistItem extends GenericJson {
   @Key
   private PlaylistItemContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private PlaylistItemSnippet snippet;
   @Key
   private PlaylistItemStatus status;

   public PlaylistItem clone() {
      return (PlaylistItem)super.clone();
   }

   public PlaylistItemContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public String getEtag() {
      return this.etag;
   }

   public String getId() {
      return this.id;
   }

   public String getKind() {
      return this.kind;
   }

   public PlaylistItemSnippet getSnippet() {
      return this.snippet;
   }

   public PlaylistItemStatus getStatus() {
      return this.status;
   }

   public PlaylistItem set(String var1, Object var2) {
      return (PlaylistItem)super.set(var1, var2);
   }

   public PlaylistItem setContentDetails(PlaylistItemContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public PlaylistItem setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public PlaylistItem setId(String var1) {
      this.id = var1;
      return this;
   }

   public PlaylistItem setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public PlaylistItem setSnippet(PlaylistItemSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public PlaylistItem setStatus(PlaylistItemStatus var1) {
      this.status = var1;
      return this;
   }
}
