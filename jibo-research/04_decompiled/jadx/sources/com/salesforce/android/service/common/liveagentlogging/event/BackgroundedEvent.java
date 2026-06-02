package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "backgroundedEvents")
public class BackgroundedEvent extends BaseEvent {

    @SerializedName(m9428a = "backgrounded")
    private final boolean mBackgrounded;

    public BackgroundedEvent(String str, String str2, boolean z) {
        super(str, str2);
        this.mBackgrounded = z;
    }
}
