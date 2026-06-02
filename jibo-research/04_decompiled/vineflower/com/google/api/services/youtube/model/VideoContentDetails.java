package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class VideoContentDetails extends GenericJson {
   @Key
   private String caption;
   @Key
   private ContentRating contentRating;
   @Key
   private AccessPolicy countryRestriction;
   @Key
   private String definition;
   @Key
   private String dimension;
   @Key
   private String duration;
   @Key
   private Boolean hasCustomThumbnail;
   @Key
   private Boolean licensedContent;
   @Key
   private String projection;
   @Key
   private VideoContentDetailsRegionRestriction regionRestriction;

   public VideoContentDetails clone() {
      return (VideoContentDetails)super.clone();
   }

   public String getCaption() {
      return this.caption;
   }

   public ContentRating getContentRating() {
      return this.contentRating;
   }

   public AccessPolicy getCountryRestriction() {
      return this.countryRestriction;
   }

   public String getDefinition() {
      return this.definition;
   }

   public String getDimension() {
      return this.dimension;
   }

   public String getDuration() {
      return this.duration;
   }

   public Boolean getHasCustomThumbnail() {
      return this.hasCustomThumbnail;
   }

   public Boolean getLicensedContent() {
      return this.licensedContent;
   }

   public String getProjection() {
      return this.projection;
   }

   public VideoContentDetailsRegionRestriction getRegionRestriction() {
      return this.regionRestriction;
   }

   public VideoContentDetails set(String var1, Object var2) {
      return (VideoContentDetails)super.set(var1, var2);
   }

   public VideoContentDetails setCaption(String var1) {
      this.caption = var1;
      return this;
   }

   public VideoContentDetails setContentRating(ContentRating var1) {
      this.contentRating = var1;
      return this;
   }

   public VideoContentDetails setCountryRestriction(AccessPolicy var1) {
      this.countryRestriction = var1;
      return this;
   }

   public VideoContentDetails setDefinition(String var1) {
      this.definition = var1;
      return this;
   }

   public VideoContentDetails setDimension(String var1) {
      this.dimension = var1;
      return this;
   }

   public VideoContentDetails setDuration(String var1) {
      this.duration = var1;
      return this;
   }

   public VideoContentDetails setHasCustomThumbnail(Boolean var1) {
      this.hasCustomThumbnail = var1;
      return this;
   }

   public VideoContentDetails setLicensedContent(Boolean var1) {
      this.licensedContent = var1;
      return this;
   }

   public VideoContentDetails setProjection(String var1) {
      this.projection = var1;
      return this;
   }

   public VideoContentDetails setRegionRestriction(VideoContentDetailsRegionRestriction var1) {
      this.regionRestriction = var1;
      return this;
   }
}
