package com.salesforce.android.service.common.liveagentclient.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;

public enum LiveAgentState implements LifecycleState<LiveAgentMetric> {
   Connecting(LiveAgentMetric.ConnectionEstablished, LiveAgentMetric.SessionInfoReceived),
   Deleting(LiveAgentMetric.Deleted),
   Ended(),
   Initializing(LiveAgentMetric.Initiated),
   LongPolling(LiveAgentMetric.Ending);

   private static final LiveAgentState[] $VALUES = new LiveAgentState[]{
      LiveAgentState.Initializing, LiveAgentState.Connecting, LiveAgentState.LongPolling, LiveAgentState.Deleting, LiveAgentState.Ended
   };
   private final LiveAgentMetric[] mMetrics;

   LiveAgentState(LiveAgentMetric... var3) {
      this.mMetrics = var3;
   }

   public LiveAgentMetric[] getMetrics() {
      return this.mMetrics;
   }
}
