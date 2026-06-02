package com.google.maps.model;

import com.google.maps.internal.PolylineEncoding;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EncodedPolyline {
    private final String points;

    public EncodedPolyline(String str) {
        this.points = str;
    }

    public EncodedPolyline(List<LatLng> list) {
        this.points = PolylineEncoding.encode(list);
    }

    public String getEncodedPath() {
        return this.points;
    }

    public List<LatLng> decodePath() {
        return PolylineEncoding.decode(this.points);
    }
}
