package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class SearchResultSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String description;
   @Key
   private String liveBroadcastContent;
   @Key
   private DateTime publishedAt;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public SearchResultSnippet clone() {
      return (SearchResultSnippet)super.clone();
   }

   public String getChannelId() {
      return this.channelId;
   }

   public String getChannelTitle() {
      return this.channelTitle;
   }

   public String getDescription() {
      return this.description;
   }

   public String getLiveBroadcastContent() {
      return this.liveBroadcastContent;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public String getTitle() {
      return this.title;
   }

   public SearchResultSnippet set(String var1, Object var2) {
      return (SearchResultSnippet)super.set(var1, var2);
   }

   public SearchResultSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public SearchResultSnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public SearchResultSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public SearchResultSnippet setLiveBroadcastContent(String var1) {
      this.liveBroadcastContent = var1;
      return this;
   }

   public SearchResultSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public SearchResultSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public SearchResultSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
