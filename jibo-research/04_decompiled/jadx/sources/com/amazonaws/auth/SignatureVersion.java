package com.amazonaws.auth;

import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes.dex */
public enum SignatureVersion {
    V1(AppEventsConstants.EVENT_PARAM_VALUE_YES),
    V2("2");

    private String value;

    SignatureVersion(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
