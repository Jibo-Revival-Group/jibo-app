package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Base64;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class LiveBroadcastContentDetails extends GenericJson {
   @Key
   private String boundStreamId;
   @Key
   private DateTime boundStreamLastUpdateTimeMs;
   @Key
   private String closedCaptionsType;
   @Key
   private Boolean enableAutoStart;
   @Key
   private Boolean enableClosedCaptions;
   @Key
   private Boolean enableContentEncryption;
   @Key
   private Boolean enableDvr;
   @Key
   private Boolean enableEmbed;
   @Key
   private Boolean enableLowLatency;
   @Key
   private String latencyPreference;
   @Key
   private String mesh;
   @Key
   private MonitorStreamInfo monitorStream;
   @Key
   private String projection;
   @Key
   private Boolean recordFromStart;
   @Key
   private Boolean startWithSlate;

   public LiveBroadcastContentDetails clone() {
      return (LiveBroadcastContentDetails)super.clone();
   }

   public byte[] decodeMesh() {
      return Base64.decodeBase64(this.mesh);
   }

   public LiveBroadcastContentDetails encodeMesh(byte[] var1) {
      this.mesh = Base64.encodeBase64URLSafeString(var1);
      return this;
   }

   public String getBoundStreamId() {
      return this.boundStreamId;
   }

   public DateTime getBoundStreamLastUpdateTimeMs() {
      return this.boundStreamLastUpdateTimeMs;
   }

   public String getClosedCaptionsType() {
      return this.closedCaptionsType;
   }

   public Boolean getEnableAutoStart() {
      return this.enableAutoStart;
   }

   public Boolean getEnableClosedCaptions() {
      return this.enableClosedCaptions;
   }

   public Boolean getEnableContentEncryption() {
      return this.enableContentEncryption;
   }

   public Boolean getEnableDvr() {
      return this.enableDvr;
   }

   public Boolean getEnableEmbed() {
      return this.enableEmbed;
   }

   public Boolean getEnableLowLatency() {
      return this.enableLowLatency;
   }

   public String getLatencyPreference() {
      return this.latencyPreference;
   }

   public String getMesh() {
      return this.mesh;
   }

   public MonitorStreamInfo getMonitorStream() {
      return this.monitorStream;
   }

   public String getProjection() {
      return this.projection;
   }

   public Boolean getRecordFromStart() {
      return this.recordFromStart;
   }

   public Boolean getStartWithSlate() {
      return this.startWithSlate;
   }

   public LiveBroadcastContentDetails set(String var1, Object var2) {
      return (LiveBroadcastContentDetails)super.set(var1, var2);
   }

   public LiveBroadcastContentDetails setBoundStreamId(String var1) {
      this.boundStreamId = var1;
      return this;
   }

   public LiveBroadcastContentDetails setBoundStreamLastUpdateTimeMs(DateTime var1) {
      this.boundStreamLastUpdateTimeMs = var1;
      return this;
   }

   public LiveBroadcastContentDetails setClosedCaptionsType(String var1) {
      this.closedCaptionsType = var1;
      return this;
   }

   public LiveBroadcastContentDetails setEnableAutoStart(Boolean var1) {
      this.enableAutoStart = var1;
      return this;
   }

   public LiveBroadcastContentDetails setEnableClosedCaptions(Boolean var1) {
      this.enableClosedCaptions = var1;
      return this;
   }

   public LiveBroadcastContentDetails setEnableContentEncryption(Boolean var1) {
      this.enableContentEncryption = var1;
      return this;
   }

   public LiveBroadcastContentDetails setEnableDvr(Boolean var1) {
      this.enableDvr = var1;
      return this;
   }

   public LiveBroadcastContentDetails setEnableEmbed(Boolean var1) {
      this.enableEmbed = var1;
      return this;
   }

   public LiveBroadcastContentDetails setEnableLowLatency(Boolean var1) {
      this.enableLowLatency = var1;
      return this;
   }

   public LiveBroadcastContentDetails setLatencyPreference(String var1) {
      this.latencyPreference = var1;
      return this;
   }

   public LiveBroadcastContentDetails setMesh(String var1) {
      this.mesh = var1;
      return this;
   }

   public LiveBroadcastContentDetails setMonitorStream(MonitorStreamInfo var1) {
      this.monitorStream = var1;
      return this;
   }

   public LiveBroadcastContentDetails setProjection(String var1) {
      this.projection = var1;
      return this;
   }

   public LiveBroadcastContentDetails setRecordFromStart(Boolean var1) {
      this.recordFromStart = var1;
      return this;
   }

   public LiveBroadcastContentDetails setStartWithSlate(Boolean var1) {
      this.startWithSlate = var1;
      return this;
   }
}
