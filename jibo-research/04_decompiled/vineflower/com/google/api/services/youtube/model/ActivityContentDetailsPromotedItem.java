package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class ActivityContentDetailsPromotedItem extends GenericJson {
   @Key
   private String adTag;
   @Key
   private String clickTrackingUrl;
   @Key
   private String creativeViewUrl;
   @Key
   private String ctaType;
   @Key
   private String customCtaButtonText;
   @Key
   private String descriptionText;
   @Key
   private String destinationUrl;
   @Key
   private List<String> forecastingUrl;
   @Key
   private List<String> impressionUrl;
   @Key
   private String videoId;

   public ActivityContentDetailsPromotedItem clone() {
      return (ActivityContentDetailsPromotedItem)super.clone();
   }

   public String getAdTag() {
      return this.adTag;
   }

   public String getClickTrackingUrl() {
      return this.clickTrackingUrl;
   }

   public String getCreativeViewUrl() {
      return this.creativeViewUrl;
   }

   public String getCtaType() {
      return this.ctaType;
   }

   public String getCustomCtaButtonText() {
      return this.customCtaButtonText;
   }

   public String getDescriptionText() {
      return this.descriptionText;
   }

   public String getDestinationUrl() {
      return this.destinationUrl;
   }

   public List<String> getForecastingUrl() {
      return this.forecastingUrl;
   }

   public List<String> getImpressionUrl() {
      return this.impressionUrl;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public ActivityContentDetailsPromotedItem set(String var1, Object var2) {
      return (ActivityContentDetailsPromotedItem)super.set(var1, var2);
   }

   public ActivityContentDetailsPromotedItem setAdTag(String var1) {
      this.adTag = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setClickTrackingUrl(String var1) {
      this.clickTrackingUrl = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setCreativeViewUrl(String var1) {
      this.creativeViewUrl = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setCtaType(String var1) {
      this.ctaType = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setCustomCtaButtonText(String var1) {
      this.customCtaButtonText = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setDescriptionText(String var1) {
      this.descriptionText = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setDestinationUrl(String var1) {
      this.destinationUrl = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setForecastingUrl(List<String> var1) {
      this.forecastingUrl = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setImpressionUrl(List<String> var1) {
      this.impressionUrl = var1;
      return this;
   }

   public ActivityContentDetailsPromotedItem setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }
}
