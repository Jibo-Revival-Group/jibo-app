package com.google.maps.model;

import com.google.maps.internal.StringJoin;

/* JADX INFO: loaded from: classes.dex */
public enum LocationType implements StringJoin.UrlValue {
    ROOFTOP,
    RANGE_INTERPOLATED,
    GEOMETRIC_CENTER,
    APPROXIMATE,
    UNKNOWN;

    @Override // com.google.maps.internal.StringJoin.UrlValue
    public String toUrlValue() {
        if (this == UNKNOWN) {
            throw new UnsupportedOperationException("Shouldn't use LocationType.UNKNOWN in a request.");
        }
        return name();
    }
}
