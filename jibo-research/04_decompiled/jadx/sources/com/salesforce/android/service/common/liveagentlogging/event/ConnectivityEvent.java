package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "connectivityEvents")
public class ConnectivityEvent extends BaseEvent {

    @SerializedName(m9428a = "radioType")
    private final String mRadioType;

    @SerializedName(m9428a = "technology")
    private final String mTechnology;

    public ConnectivityEvent(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.mTechnology = str3;
        this.mRadioType = str4;
    }
}
