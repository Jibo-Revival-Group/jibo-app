package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveBroadcast extends GenericJson {
   @Key
   private LiveBroadcastContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private LiveBroadcastSnippet snippet;
   @Key
   private LiveBroadcastStatistics statistics;
   @Key
   private LiveBroadcastStatus status;

   public LiveBroadcast clone() {
      return (LiveBroadcast)super.clone();
   }

   public LiveBroadcastContentDetails getContentDetails() {
      return this.contentDetails;
   }

   public String getEtag() {
      return this.etag;
   }

   public String getId() {
      return this.id;
   }

   public String getKind() {
      return this.kind;
   }

   public LiveBroadcastSnippet getSnippet() {
      return this.snippet;
   }

   public LiveBroadcastStatistics getStatistics() {
      return this.statistics;
   }

   public LiveBroadcastStatus getStatus() {
      return this.status;
   }

   public LiveBroadcast set(String var1, Object var2) {
      return (LiveBroadcast)super.set(var1, var2);
   }

   public LiveBroadcast setContentDetails(LiveBroadcastContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public LiveBroadcast setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public LiveBroadcast setId(String var1) {
      this.id = var1;
      return this;
   }

   public LiveBroadcast setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public LiveBroadcast setSnippet(LiveBroadcastSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public LiveBroadcast setStatistics(LiveBroadcastStatistics var1) {
      this.statistics = var1;
      return this;
   }

   public LiveBroadcast setStatus(LiveBroadcastStatus var1) {
      this.status = var1;
      return this;
   }
}
