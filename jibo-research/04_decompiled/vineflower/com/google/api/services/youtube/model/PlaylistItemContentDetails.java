package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class PlaylistItemContentDetails extends GenericJson {
   @Key
   private String endAt;
   @Key
   private String note;
   @Key
   private String startAt;
   @Key
   private String videoId;
   @Key
   private DateTime videoPublishedAt;

   public PlaylistItemContentDetails clone() {
      return (PlaylistItemContentDetails)super.clone();
   }

   public String getEndAt() {
      return this.endAt;
   }

   public String getNote() {
      return this.note;
   }

   public String getStartAt() {
      return this.startAt;
   }

   public String getVideoId() {
      return this.videoId;
   }

   public DateTime getVideoPublishedAt() {
      return this.videoPublishedAt;
   }

   public PlaylistItemContentDetails set(String var1, Object var2) {
      return (PlaylistItemContentDetails)super.set(var1, var2);
   }

   public PlaylistItemContentDetails setEndAt(String var1) {
      this.endAt = var1;
      return this;
   }

   public PlaylistItemContentDetails setNote(String var1) {
      this.note = var1;
      return this;
   }

   public PlaylistItemContentDetails setStartAt(String var1) {
      this.startAt = var1;
      return this;
   }

   public PlaylistItemContentDetails setVideoId(String var1) {
      this.videoId = var1;
      return this;
   }

   public PlaylistItemContentDetails setVideoPublishedAt(DateTime var1) {
      this.videoPublishedAt = var1;
      return this;
   }
}
