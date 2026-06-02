package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "batteryEvents")
public class BatteryEvent extends BaseEvent {

    @SerializedName(m9428a = "level")
    private final int mLevel;

    public BatteryEvent(String str, String str2, int i) {
        super(str, str2);
        int i2 = i < 0 ? 0 : i;
        this.mLevel = i2 <= 100 ? i2 : 100;
    }
}
