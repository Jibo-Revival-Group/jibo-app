package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

public final class Playlist extends GenericJson {
   @Key
   private PlaylistContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private Map<String, PlaylistLocalization> localizations;
   @Key
   private PlaylistPlayer player;
   @Key
   private PlaylistSnippet snippet;
   @Key
   private PlaylistStatus status;

   public Playlist clone() {
      return (Playlist)super.clone();
   }

   public PlaylistContentDetails getContentDetails() {
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

   public Map<String, PlaylistLocalization> getLocalizations() {
      return this.localizations;
   }

   public PlaylistPlayer getPlayer() {
      return this.player;
   }

   public PlaylistSnippet getSnippet() {
      return this.snippet;
   }

   public PlaylistStatus getStatus() {
      return this.status;
   }

   public Playlist set(String var1, Object var2) {
      return (Playlist)super.set(var1, var2);
   }

   public Playlist setContentDetails(PlaylistContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public Playlist setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Playlist setId(String var1) {
      this.id = var1;
      return this;
   }

   public Playlist setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Playlist setLocalizations(Map<String, PlaylistLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public Playlist setPlayer(PlaylistPlayer var1) {
      this.player = var1;
      return this;
   }

   public Playlist setSnippet(PlaylistSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Playlist setStatus(PlaylistStatus var1) {
      this.status = var1;
      return this;
   }
}
