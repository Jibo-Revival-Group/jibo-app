package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class SubscriptionSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String description;
   @Key
   private DateTime publishedAt;
   @Key
   private ResourceId resourceId;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public SubscriptionSnippet clone() {
      return (SubscriptionSnippet)super.clone();
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

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public ResourceId getResourceId() {
      return this.resourceId;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public String getTitle() {
      return this.title;
   }

   public SubscriptionSnippet set(String var1, Object var2) {
      return (SubscriptionSnippet)super.set(var1, var2);
   }

   public SubscriptionSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public SubscriptionSnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public SubscriptionSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public SubscriptionSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public SubscriptionSnippet setResourceId(ResourceId var1) {
      this.resourceId = var1;
      return this;
   }

   public SubscriptionSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public SubscriptionSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
