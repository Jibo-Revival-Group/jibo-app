package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class VideoStatus extends GenericJson {
   @Key
   private Boolean embeddable;
   @Key
   private String failureReason;
   @Key
   private String license;
   @Key
   private String privacyStatus;
   @Key
   private Boolean publicStatsViewable;
   @Key
   private DateTime publishAt;
   @Key
   private String rejectionReason;
   @Key
   private String uploadStatus;

   public VideoStatus clone() {
      return (VideoStatus)super.clone();
   }

   public Boolean getEmbeddable() {
      return this.embeddable;
   }

   public String getFailureReason() {
      return this.failureReason;
   }

   public String getLicense() {
      return this.license;
   }

   public String getPrivacyStatus() {
      return this.privacyStatus;
   }

   public Boolean getPublicStatsViewable() {
      return this.publicStatsViewable;
   }

   public DateTime getPublishAt() {
      return this.publishAt;
   }

   public String getRejectionReason() {
      return this.rejectionReason;
   }

   public String getUploadStatus() {
      return this.uploadStatus;
   }

   public VideoStatus set(String var1, Object var2) {
      return (VideoStatus)super.set(var1, var2);
   }

   public VideoStatus setEmbeddable(Boolean var1) {
      this.embeddable = var1;
      return this;
   }

   public VideoStatus setFailureReason(String var1) {
      this.failureReason = var1;
      return this;
   }

   public VideoStatus setLicense(String var1) {
      this.license = var1;
      return this;
   }

   public VideoStatus setPrivacyStatus(String var1) {
      this.privacyStatus = var1;
      return this;
   }

   public VideoStatus setPublicStatsViewable(Boolean var1) {
      this.publicStatsViewable = var1;
      return this;
   }

   public VideoStatus setPublishAt(DateTime var1) {
      this.publishAt = var1;
      return this;
   }

   public VideoStatus setRejectionReason(String var1) {
      this.rejectionReason = var1;
      return this;
   }

   public VideoStatus setUploadStatus(String var1) {
      this.uploadStatus = var1;
      return this;
   }
}
