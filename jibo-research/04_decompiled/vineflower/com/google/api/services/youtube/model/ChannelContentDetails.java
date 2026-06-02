package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChannelContentDetails extends GenericJson {
   @Key
   private ChannelContentDetails.RelatedPlaylists relatedPlaylists;

   public ChannelContentDetails clone() {
      return (ChannelContentDetails)super.clone();
   }

   public ChannelContentDetails.RelatedPlaylists getRelatedPlaylists() {
      return this.relatedPlaylists;
   }

   public ChannelContentDetails set(String var1, Object var2) {
      return (ChannelContentDetails)super.set(var1, var2);
   }

   public ChannelContentDetails setRelatedPlaylists(ChannelContentDetails.RelatedPlaylists var1) {
      this.relatedPlaylists = var1;
      return this;
   }

   public static final class RelatedPlaylists extends GenericJson {
      @Key
      private String favorites;
      @Key
      private String likes;
      @Key
      private String uploads;
      @Key
      private String watchHistory;
      @Key
      private String watchLater;

      public ChannelContentDetails.RelatedPlaylists clone() {
         return (ChannelContentDetails.RelatedPlaylists)super.clone();
      }

      public String getFavorites() {
         return this.favorites;
      }

      public String getLikes() {
         return this.likes;
      }

      public String getUploads() {
         return this.uploads;
      }

      public String getWatchHistory() {
         return this.watchHistory;
      }

      public String getWatchLater() {
         return this.watchLater;
      }

      public ChannelContentDetails.RelatedPlaylists set(String var1, Object var2) {
         return (ChannelContentDetails.RelatedPlaylists)super.set(var1, var2);
      }

      public ChannelContentDetails.RelatedPlaylists setFavorites(String var1) {
         this.favorites = var1;
         return this;
      }

      public ChannelContentDetails.RelatedPlaylists setLikes(String var1) {
         this.likes = var1;
         return this;
      }

      public ChannelContentDetails.RelatedPlaylists setUploads(String var1) {
         this.uploads = var1;
         return this;
      }

      public ChannelContentDetails.RelatedPlaylists setWatchHistory(String var1) {
         this.watchHistory = var1;
         return this;
      }

      public ChannelContentDetails.RelatedPlaylists setWatchLater(String var1) {
         this.watchLater = var1;
         return this;
      }
   }
}
