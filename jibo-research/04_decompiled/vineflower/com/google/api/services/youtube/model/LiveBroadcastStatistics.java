package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveBroadcastStatistics extends GenericJson {
   @JsonString
   @Key
   private BigInteger concurrentViewers;
   @JsonString
   @Key
   private BigInteger totalChatCount;

   public LiveBroadcastStatistics clone() {
      return (LiveBroadcastStatistics)super.clone();
   }

   public BigInteger getConcurrentViewers() {
      return this.concurrentViewers;
   }

   public BigInteger getTotalChatCount() {
      return this.totalChatCount;
   }

   public LiveBroadcastStatistics set(String var1, Object var2) {
      return (LiveBroadcastStatistics)super.set(var1, var2);
   }

   public LiveBroadcastStatistics setConcurrentViewers(BigInteger var1) {
      this.concurrentViewers = var1;
      return this;
   }

   public LiveBroadcastStatistics setTotalChatCount(BigInteger var1) {
      this.totalChatCount = var1;
      return this;
   }
}
