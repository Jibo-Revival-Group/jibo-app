package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class VideoAgeGating extends GenericJson {
   @Key
   private Boolean alcoholContent;
   @Key
   private Boolean restricted;
   @Key
   private String videoGameRating;

   public VideoAgeGating clone() {
      return (VideoAgeGating)super.clone();
   }

   public Boolean getAlcoholContent() {
      return this.alcoholContent;
   }

   public Boolean getRestricted() {
      return this.restricted;
   }

   public String getVideoGameRating() {
      return this.videoGameRating;
   }

   public VideoAgeGating set(String var1, Object var2) {
      return (VideoAgeGating)super.set(var1, var2);
   }

   public VideoAgeGating setAlcoholContent(Boolean var1) {
      this.alcoholContent = var1;
      return this;
   }

   public VideoAgeGating setRestricted(Boolean var1) {
      this.restricted = var1;
      return this;
   }

   public VideoAgeGating setVideoGameRating(String var1) {
      this.videoGameRating = var1;
      return this;
   }
}
