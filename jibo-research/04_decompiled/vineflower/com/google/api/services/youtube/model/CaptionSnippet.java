package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class CaptionSnippet extends GenericJson {
   @Key
   private String audioTrackType;
   @Key
   private String failureReason;
   @Key
   private Boolean isAutoSynced;
   @Key
   private Boolean isCC;
   @Key
   private Boolean isDraft;
   @Key
   private Boolean isEasyReader;
   @Key
   private Boolean isLarge;
   @Key
   private String language;
   @Key
   private DateTime lastUpdated;
   @Key
   private String name;
   @Key
   private String status;
   @Key
   private String trackKind;
   @Key
   private String videoId;

   public CaptionSnippet clone() {
      return (CaptionSnippet)super.clone();
   }

   public String getAudioTrackType() {
      return this.audioTrackType;
   }

   public String getFailureReason() {
      return this.failureReason;
   }

   public Boolean getIsAutoSynced() {
      return this.isAutoSynced;
   }

   public Boolean getIsCC() {
      return this.isCC;
   }

   public Boolean getIsDraft() {
      return this.isDraft;
   }

   public Boolean getIsEasyReader() {
      return this.isEasyReader;
   }

   public Boolean getIsLarge() {
      return this.isLarge;
   }

   public String getLanguage() {
      return this.language;
   }

   public DateTime getLastUpdated() {
      return this.lastUpdated;
   }

   public String getName() {
      return this.name;
   }

   public String getStatus() {
      return this.status;
   }

   public String getTrackKind() {
      return this.trackKind;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public CaptionSnippet set(String var1, Object var2) {
      return (CaptionSnippet)super.set(var1, var2);
   }

   public CaptionSnippet setAudioTrackType(String var1) {
      this.audioTrackType = var1;
      return this;
   }

   public CaptionSnippet setFailureReason(String var1) {
      this.failureReason = var1;
      return this;
   }

   public CaptionSnippet setIsAutoSynced(Boolean var1) {
      this.isAutoSynced = var1;
      return this;
   }

   public CaptionSnippet setIsCC(Boolean var1) {
      this.isCC = var1;
      return this;
   }

   public CaptionSnippet setIsDraft(Boolean var1) {
      this.isDraft = var1;
      return this;
   }

   public CaptionSnippet setIsEasyReader(Boolean var1) {
      this.isEasyReader = var1;
      return this;
   }

   public CaptionSnippet setIsLarge(Boolean var1) {
      this.isLarge = var1;
      return this;
   }

   public CaptionSnippet setLanguage(String var1) {
      this.language = var1;
      return this;
   }

   public CaptionSnippet setLastUpdated(DateTime var1) {
      this.lastUpdated = var1;
      return this;
   }

   public CaptionSnippet setName(String var1) {
      this.name = var1;
      return this;
   }

   public CaptionSnippet setStatus(String var1) {
      this.status = var1;
      return this;
   }

   public CaptionSnippet setTrackKind(String var1) {
      this.trackKind = var1;
      return this;
   }

   public CaptionSnippet setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }
}
