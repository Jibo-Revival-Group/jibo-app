package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class VideoRating extends GenericJson {
   @Key
   private String rating;
   @Key
   private String videoId;

   public VideoRating clone() {
      return (VideoRating)super.clone();
   }

   public String getRating() {
      return this.rating;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public VideoRating set(String var1, Object var2) {
      return (VideoRating)super.set(var1, var2);
   }

   public VideoRating setRating(String var1) {
      this.rating = var1;
      return this;
   }

   public VideoRating setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }
}
