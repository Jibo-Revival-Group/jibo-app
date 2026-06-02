package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveStreamConfigurationIssue extends GenericJson {
   @Key
   private String description;
   @Key
   private String reason;
   @Key
   private String severity;
   @Key
   private String type;

   public LiveStreamConfigurationIssue clone() {
      return (LiveStreamConfigurationIssue)super.clone();
   }

   public String getDescription() {
      return this.description;
   }

   public String getReason() {
      return this.reason;
   }

   public String getSeverity() {
      return this.severity;
   }

   public String getType() {
      return this.type;
   }

   public LiveStreamConfigurationIssue set(String var1, Object var2) {
      return (LiveStreamConfigurationIssue)super.set(var1, var2);
   }

   public LiveStreamConfigurationIssue setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public LiveStreamConfigurationIssue setReason(String var1) {
      this.reason = var1;
      return this;
   }

   public LiveStreamConfigurationIssue setSeverity(String var1) {
      this.severity = var1;
      return this;
   }

   public LiveStreamConfigurationIssue setType(String var1) {
      this.type = var1;
      return this;
   }
}
