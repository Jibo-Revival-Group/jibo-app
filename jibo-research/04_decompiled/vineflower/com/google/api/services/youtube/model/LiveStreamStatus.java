package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveStreamStatus extends GenericJson {
   @Key
   private LiveStreamHealthStatus healthStatus;
   @Key
   private String streamStatus;

   public LiveStreamStatus clone() {
      return (LiveStreamStatus)super.clone();
   }

   public LiveStreamHealthStatus getHealthStatus() {
      return this.healthStatus;
   }

   public String getStreamStatus() {
      return this.streamStatus;
   }

   public LiveStreamStatus set(String var1, Object var2) {
      return (LiveStreamStatus)super.set(var1, var2);
   }

   public LiveStreamStatus setHealthStatus(LiveStreamHealthStatus var1) {
      this.healthStatus = var1;
      return this;
   }

   public LiveStreamStatus setStreamStatus(String var1) {
      this.streamStatus = var1;
      return this;
   }
}
