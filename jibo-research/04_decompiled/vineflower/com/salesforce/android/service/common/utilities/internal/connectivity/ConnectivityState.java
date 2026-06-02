package com.salesforce.android.service.common.utilities.internal.connectivity;

public enum ConnectivityState {
   CONNECTED,
   DISCONNECTED,
   SWITCHING,
   UNKNOWN;

   private static final ConnectivityState[] $VALUES = new ConnectivityState[]{
      ConnectivityState.UNKNOWN, ConnectivityState.CONNECTED, ConnectivityState.SWITCHING, ConnectivityState.DISCONNECTED
   };
}
