package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;

public final class RequestClientOptions {
   private final Map<RequestClientOptions.Marker, String> markers = new EnumMap<>(RequestClientOptions.Marker.class);

   public String getClientMarker(RequestClientOptions.Marker var1) {
      return this.markers.get(var1);
   }

   public enum Marker {
      USER_AGENT;

      private static final RequestClientOptions.Marker[] $VALUES = new RequestClientOptions.Marker[]{RequestClientOptions.Marker.USER_AGENT};
   }
}
