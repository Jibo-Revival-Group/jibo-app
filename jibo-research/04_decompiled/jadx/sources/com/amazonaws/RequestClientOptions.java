package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class RequestClientOptions {
    private final Map<Marker, String> markers = new EnumMap(Marker.class);

    public enum Marker {
        USER_AGENT
    }

    public String getClientMarker(Marker marker) {
        return this.markers.get(marker);
    }
}
