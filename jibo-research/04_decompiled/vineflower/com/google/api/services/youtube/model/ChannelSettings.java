package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class ChannelSettings extends GenericJson {
   @Key
   private String country;
   @Key
   private String defaultLanguage;
   @Key
   private String defaultTab;
   @Key
   private String description;
   @Key
   private String featuredChannelsTitle;
   @Key
   private List<String> featuredChannelsUrls;
   @Key
   private String keywords;
   @Key
   private Boolean moderateComments;
   @Key
   private String profileColor;
   @Key
   private Boolean showBrowseView;
   @Key
   private Boolean showRelatedChannels;
   @Key
   private String title;
   @Key
   private String trackingAnalyticsAccountId;
   @Key
   private String unsubscribedTrailer;

   public ChannelSettings clone() {
      return (ChannelSettings)super.clone();
   }

   public String getCountry() {
      return this.country;
   }

   public String getDefaultLanguage() {
      return this.defaultLanguage;
   }

   public String getDefaultTab() {
      return this.defaultTab;
   }

   public String getDescription() {
      return this.description;
   }

   public String getFeaturedChannelsTitle() {
      return this.featuredChannelsTitle;
   }

   public List<String> getFeaturedChannelsUrls() {
      return this.featuredChannelsUrls;
   }

   public String getKeywords() {
      return this.keywords;
   }

   public Boolean getModerateComments() {
      return this.moderateComments;
   }

   public String getProfileColor() {
      return this.profileColor;
   }

   public Boolean getShowBrowseView() {
      return this.showBrowseView;
   }

   public Boolean getShowRelatedChannels() {
      return this.showRelatedChannels;
   }

   public String getTitle() {
      return this.title;
   }

   public String getTrackingAnalyticsAccountId() {
      return this.trackingAnalyticsAccountId;
   }

   public String getUnsubscribedTrailer() {
      return this.unsubscribedTrailer;
   }

   public ChannelSettings set(String var1, Object var2) {
      return (ChannelSettings)super.set(var1, var2);
   }

   public ChannelSettings setCountry(String var1) {
      this.country = var1;
      return this;
   }

   public ChannelSettings setDefaultLanguage(String var1) {
      this.defaultLanguage = var1;
      return this;
   }

   public ChannelSettings setDefaultTab(String var1) {
      this.defaultTab = var1;
      return this;
   }

   public ChannelSettings setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public ChannelSettings setFeaturedChannelsTitle(String var1) {
      this.featuredChannelsTitle = var1;
      return this;
   }

   public ChannelSettings setFeaturedChannelsUrls(List<String> var1) {
      this.featuredChannelsUrls = var1;
      return this;
   }

   public ChannelSettings setKeywords(String var1) {
      this.keywords = var1;
      return this;
   }

   public ChannelSettings setModerateComments(Boolean var1) {
      this.moderateComments = var1;
      return this;
   }

   public ChannelSettings setProfileColor(String var1) {
      this.profileColor = var1;
      return this;
   }

   public ChannelSettings setShowBrowseView(Boolean var1) {
      this.showBrowseView = var1;
      return this;
   }

   public ChannelSettings setShowRelatedChannels(Boolean var1) {
      this.showRelatedChannels = var1;
      return this;
   }

   public ChannelSettings setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public ChannelSettings setTrackingAnalyticsAccountId(String var1) {
      this.trackingAnalyticsAccountId = var1;
      return this;
   }

   public ChannelSettings setUnsubscribedTrailer(String var1) {
      this.unsubscribedTrailer = var1;
      return this;
   }
}
