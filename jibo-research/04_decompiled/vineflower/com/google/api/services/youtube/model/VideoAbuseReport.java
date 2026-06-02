package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class VideoAbuseReport extends GenericJson {
   @Key
   private String comments;
   @Key
   private String language;
   @Key
   private String reasonId;
   @Key
   private String secondaryReasonId;
   @Key
   private String videoId;

   public VideoAbuseReport clone() {
      return (VideoAbuseReport)super.clone();
   }

   public String getComments() {
      return this.comments;
   }

   public String getLanguage() {
      return this.language;
   }

   public String getReasonId() {
      return this.reasonId;
   }

   public String getSecondaryReasonId() {
      return this.secondaryReasonId;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public VideoAbuseReport set(String var1, Object var2) {
      return (VideoAbuseReport)super.set(var1, var2);
   }

   public VideoAbuseReport setComments(String var1) {
      this.comments = var1;
      return this;
   }

   public VideoAbuseReport setLanguage(String var1) {
      this.language = var1;
      return this;
   }

   public VideoAbuseReport setReasonId(String var1) {
      this.reasonId = var1;
      return this;
   }

   public VideoAbuseReport setSecondaryReasonId(String var1) {
      this.secondaryReasonId = var1;
      return this;
   }

   public VideoAbuseReport setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }
}
