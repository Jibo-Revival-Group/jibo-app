package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LatLng implements StringJoin.UrlValue {
    public double lat;
    public double lng;

    public LatLng(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public LatLng() {
    }

    public String toString() {
        return toUrlValue();
    }

    @Override // com.google.maps.internal.StringJoin.UrlValue
    public String toUrlValue() {
        return String.format(Locale.ENGLISH, "%.8f,%.8f", Double.valueOf(this.lat), Double.valueOf(this.lng));
    }
}
