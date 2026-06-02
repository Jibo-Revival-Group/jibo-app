package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

public final class VideoSnippet extends GenericJson {
   @Key
   private String categoryId;
   @Key
   private String channelId;
   @Key
   private String channelTitle;
   @Key
   private String defaultAudioLanguage;
   @Key
   private String defaultLanguage;
   @Key
   private String description;
   @Key
   private String liveBroadcastContent;
   @Key
   private VideoLocalization localized;
   @Key
   private DateTime publishedAt;
   @Key
   private List<String> tags;
   @Key
   private ThumbnailDetails thumbnails;
   @Key
   private String title;

   public VideoSnippet clone() {
      return (VideoSnippet)super.clone();
   }

   public String getCategoryId() {
      return this.categoryId;
   }

   public String getChannelId() {
      return this.channelId;
   }

   public String getChannelTitle() {
      return this.channelTitle;
   }

   public String getDefaultAudioLanguage() {
      return this.defaultAudioLanguage;
   }

   public String getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public String getDescription() {
      return this.description;
   }

   public String getLiveBroadcastContent() {
      return this.liveBroadcastContent;
   }

   public VideoLocalization getLocalized() {
      return this.localized;
   }

   public DateTime getPublishedAt() {
      return this.publishedAt;
   }

   public List<String> getTags() {
      return this.tags;
   }

   public ThumbnailDetails getThumbnails() {
      return this.thumbnails;
   }

   public String getTitle() {
      return this.title;
   }

   public VideoSnippet set(String var1, Object var2) {
      return (VideoSnippet)super.set(var1, var2);
   }

   public VideoSnippet setCategoryId(String var1) {
      this.categoryId = var1;
      return this;
   }

   public VideoSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public VideoSnippet setChannelTitle(String var1) {
      this.channelTitle = var1;
      return this;
   }

   public VideoSnippet setDefaultAudioLanguage(String var1) {
      this.defaultAudioLanguage = var1;
      return this;
   }

   public VideoSnippet setDefaultLanguage(String var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public VideoSnippet setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public VideoSnippet setLiveBroadcastContent(String var1) {
      this.liveBroadcastContent = var1;
      return this;
   }

   public VideoSnippet setLocalized(VideoLocalization var1) {
      this.localized = var1;
      return this;
   }

   public VideoSnippet setPublishedAt(DateTime var1) {
      this.publishedAt = var1;
      return this;
   }

   public VideoSnippet setTags(List<String> var1) {
      this.tags = var1;
      return this;
   }

   public VideoSnippet setThumbnails(ThumbnailDetails var1) {
      this.thumbnails = var1;
      return this;
   }

   public VideoSnippet setTitle(String var1) {
      this.title = var1;
      return this;
   }
}
