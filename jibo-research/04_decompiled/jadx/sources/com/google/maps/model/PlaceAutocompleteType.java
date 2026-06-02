package com.google.maps.model;

import com.google.maps.internal.StringJoin;

/* JADX INFO: loaded from: classes.dex */
public enum PlaceAutocompleteType implements StringJoin.UrlValue {
    GEOCODE("geocode"),
    ADDRESS("address"),
    ESTABLISHMENT("establishment"),
    REGIONS("(regions)"),
    CITIES("(cities)");

    private String placeType;

    PlaceAutocompleteType(String str) {
        this.placeType = str;
    }

    @Override // com.google.maps.internal.StringJoin.UrlValue
    public String toUrlValue() {
        return this.placeType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.placeType;
    }
}
