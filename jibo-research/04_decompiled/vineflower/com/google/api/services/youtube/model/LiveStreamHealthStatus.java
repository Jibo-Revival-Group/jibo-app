package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

public final class LiveStreamHealthStatus extends GenericJson {
   @Key
   private List<LiveStreamConfigurationIssue> configurationIssues;
   @JsonString
   @Key
   private BigInteger lastUpdateTimeSeconds;
   @Key
   private String status;

   static {
      Data.nullOf(LiveStreamConfigurationIssue.class);
   }

   public LiveStreamHealthStatus clone() {
      return (LiveStreamHealthStatus)super.clone();
   }

   public List<LiveStreamConfigurationIssue> getConfigurationIssues() {
      return this.configurationIssues;
   }

   public BigInteger getLastUpdateTimeSeconds() {
      return this.lastUpdateTimeSeconds;
   }

   public String getStatus() {
      return this.status;
   }

   public LiveStreamHealthStatus set(String var1, Object var2) {
      return (LiveStreamHealthStatus)super.set(var1, var2);
   }

   public LiveStreamHealthStatus setConfigurationIssues(List<LiveStreamConfigurationIssue> var1) {
      this.configurationIssues = var1;
      return this;
   }

   public LiveStreamHealthStatus setLastUpdateTimeSeconds(BigInteger var1) {
      this.lastUpdateTimeSeconds = var1;
      return this;
   }

   public LiveStreamHealthStatus setStatus(String var1) {
      this.status = var1;
      return this;
   }
}
