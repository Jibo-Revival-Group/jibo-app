package com.google.maps.model;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.maps.internal.StringJoin;

/* JADX INFO: loaded from: classes.dex */
public enum PriceLevel implements StringJoin.UrlValue {
    FREE(AppEventsConstants.EVENT_PARAM_VALUE_NO),
    INEXPENSIVE(AppEventsConstants.EVENT_PARAM_VALUE_YES),
    MODERATE("2"),
    EXPENSIVE("3"),
    VERY_EXPENSIVE("4"),
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);

    private final String priceLevel;

    PriceLevel(String str) {
        this.priceLevel = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.priceLevel;
    }

    @Override // com.google.maps.internal.StringJoin.UrlValue
    public String toUrlValue() {
        if (this == UNKNOWN) {
            throw new UnsupportedOperationException("Shouldn't use PriceLevel.UNKNOWN in a request.");
        }
        return this.priceLevel;
    }
}
