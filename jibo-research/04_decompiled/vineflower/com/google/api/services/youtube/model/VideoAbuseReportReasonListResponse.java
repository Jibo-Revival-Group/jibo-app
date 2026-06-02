package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class VideoAbuseReportReasonListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<VideoAbuseReportReason> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   static {
      Data.nullOf(VideoAbuseReportReason.class);
   }

   public VideoAbuseReportReasonListResponse clone() {
      return (VideoAbuseReportReasonListResponse)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getEventId() {
      return this.eventId;
   }

   public List<VideoAbuseReportReason> getItems() {
      return this.items;
   }

   public String getKind() {
      return this.kind;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public VideoAbuseReportReasonListResponse set(String var1, Object var2) {
      return (VideoAbuseReportReasonListResponse)super.set(var1, var2);
   }

   public VideoAbuseReportReasonListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public VideoAbuseReportReasonListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public VideoAbuseReportReasonListResponse setItems(List<VideoAbuseReportReason> var1) {
      this.items = var1;
      return this;
   }

   public VideoAbuseReportReasonListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public VideoAbuseReportReasonListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }
}
