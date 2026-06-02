package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoLiveStreamingDetails extends GenericJson {
   @Key
   private String activeLiveChatId;
   @Key
   private DateTime actualEndTime;
   @Key
   private DateTime actualStartTime;
   @JsonString
   @Key
   private BigInteger concurrentViewers;
   @Key
   private DateTime scheduledEndTime;
   @Key
   private DateTime scheduledStartTime;

   public VideoLiveStreamingDetails clone() {
      return (VideoLiveStreamingDetails)super.clone();
   }

   public String getActiveLiveChatId() {
      return this.activeLiveChatId;
   }

   public DateTime getActualEndTime() {
      return this.actualEndTime;
   }

   public DateTime getActualStartTime() {
      return this.actualStartTime;
   }

   public BigInteger getConcurrentViewers() {
      return this.concurrentViewers;
   }

   public DateTime getScheduledEndTime() {
      return this.scheduledEndTime;
   }

   public DateTime getScheduledStartTime() {
      return this.scheduledStartTime;
   }

   public VideoLiveStreamingDetails set(String var1, Object var2) {
      return (VideoLiveStreamingDetails)super.set(var1, var2);
   }

   public VideoLiveStreamingDetails setActiveLiveChatId(String var1) {
      this.activeLiveChatId = var1;
      return this;
   }

   public VideoLiveStreamingDetails setActualEndTime(DateTime var1) {
      this.actualEndTime = var1;
      return this;
   }

   public VideoLiveStreamingDetails setActualStartTime(DateTime var1) {
      this.actualStartTime = var1;
      return this;
   }

   public VideoLiveStreamingDetails setConcurrentViewers(BigInteger var1) {
      this.concurrentViewers = var1;
      return this;
   }

   public VideoLiveStreamingDetails setScheduledEndTime(DateTime var1) {
      this.scheduledEndTime = var1;
      return this;
   }

   public VideoLiveStreamingDetails setScheduledStartTime(DateTime var1) {
      this.scheduledStartTime = var1;
      return this;
   }
}
