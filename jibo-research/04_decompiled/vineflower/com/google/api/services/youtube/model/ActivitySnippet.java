package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class ActivitySnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String description;
   @Key
   private String groupId;
   @Key
   private DateTime publishedAt;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;
   @Key
   private String type;

   public ActivitySnippet clone() {
      return (ActivitySnippet)super.clone();
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

   public String getGroupId() {
      return this.groupId;
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

   public String getType() {
      return this.type;
   }

   public ActivitySnippet set(String var1, Object var2) {
      return (ActivitySnippet)super.set(var1, var2);
   }

   public ActivitySnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public ActivitySnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public ActivitySnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public ActivitySnippet setGroupId(String var1) {
      this.groupId = var1;
      return this;
   }

   public ActivitySnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public ActivitySnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public ActivitySnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public ActivitySnippet setType(String var1) {
      this.type = var1;
      return this;
   }
}
