package com.salesforce.android.service.common.liveagentclient.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;

public enum LiveAgentMetric implements LifecycleMetric {
   ConnectionEstablished(30000),
   Deleted,
   Ending,
   Initiated,
   SessionInfoReceived;

   private static final LiveAgentMetric[] $VALUES = new LiveAgentMetric[]{
      LiveAgentMetric.Initiated, LiveAgentMetric.SessionInfoReceived, LiveAgentMetric.ConnectionEstablished, LiveAgentMetric.Ending, LiveAgentMetric.Deleted
   };
   private int mTimeoutMs;

   LiveAgentMetric() {
   }

   LiveAgentMetric(int var3) {
      this.mTimeoutMs = var3;
   }

   @Override
   public Integer getTimeoutMs() {
      return this.mTimeoutMs;
   }
}
