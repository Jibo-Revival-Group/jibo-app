package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

public final class Channel extends GenericJson {
   @Key
   private ChannelAuditDetails auditDetails;
   @Key
   private ChannelBrandingSettings brandingSettings;
   @Key
   private ChannelContentDetails contentDetails;
   @Key
   private ChannelContentOwnerDetails contentOwnerDetails;
   @Key
   private ChannelConversionPings conversionPings;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private InvideoPromotion invideoPromotion;
   @Key
   private String kind;
   @Key
   private Map<String, ChannelLocalization> localizations;
   @Key
   private ChannelSnippet snippet;
   @Key
   private ChannelStatistics statistics;
   @Key
   private ChannelStatus status;
   @Key
   private ChannelTopicDetails topicDetails;

   public Channel clone() {
      return (Channel)super.clone();
   }

   public ChannelAuditDetails getAuditDetails() {
      return this.auditDetails;
   }

   public ChannelBrandingSettings getBrandingSettings() {
      return this.brandingSettings;
   }

   public ChannelContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public ChannelContentOwnerDetails getContentOwnerDetails() {
      return this.contentOwnerDetails;
   }

   public ChannelConversionPings getConversionPings() {
      return this.conversionPings;
   }

   public String getEtag() {
      return this.etag;
   }

   public String getId() {
      return this.id;
   }

   public InvideoPromotion getInvideoPromotion() {
      return this.invideoPromotion;
   }

   public String getKind() {
      return this.kind;
   }

   public Map<String, ChannelLocalization> getLocalizations() {
      return this.localizations;
   }

   public ChannelSnippet getSnippet() {
      return this.snippet;
   }

   public ChannelStatistics getStatistics() {
      return this.statistics;
   }

   public ChannelStatus getStatus() {
      return this.status;
   }

   public ChannelTopicDetails getTopicDetails() {
      return this.topicDetails;
   }

   public Channel set(String var1, Object var2) {
      return (Channel)super.set(var1, var2);
   }

   public Channel setAuditDetails(ChannelAuditDetails var1) {
      this.auditDetails = var1;
      return this;
   }

   public Channel setBrandingSettings(ChannelBrandingSettings var1) {
      this.brandingSettings = var1;
      return this;
   }

   public Channel setContentDetails(ChannelContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public Channel setContentOwnerDetails(ChannelContentOwnerDetails var1) {
      this.contentOwnerDetails = var1;
      return this;
   }

   public Channel setConversionPings(ChannelConversionPings var1) {
      this.conversionPings = var1;
      return this;
   }

   public Channel setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Channel setId(String var1) {
      this.id = var1;
      return this;
   }

   public Channel setInvideoPromotion(InvideoPromotion var1) {
      this.invideoPromotion = var1;
      return this;
   }

   public Channel setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Channel setLocalizations(Map<String, ChannelLocalization> var1) {
      this.localizations = var1;
      return this;
   }

   public Channel setSnippet(ChannelSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Channel setStatistics(ChannelStatistics var1) {
      this.statistics = var1;
      return this;
   }

   public Channel setStatus(ChannelStatus var1) {
      this.status = var1;
      return this;
   }

   public Channel setTopicDetails(ChannelTopicDetails var1) {
      this.topicDetails = var1;
      return this;
   }
}
