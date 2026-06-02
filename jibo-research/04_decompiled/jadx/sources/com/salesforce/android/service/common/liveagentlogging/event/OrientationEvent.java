package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "orientationEvents")
public class OrientationEvent extends BaseEvent {

    @SerializedName(m9428a = "orientation")
    private final String mOrientation;

    public OrientationEvent(String str, String str2, Orientation orientation) {
        super(str, str2);
        if (orientation.m14213b()) {
            this.mOrientation = "LANDSCAPE_LEFT";
        } else if (orientation.m14212a()) {
            this.mOrientation = "PORTRAIT";
        } else {
            this.mOrientation = "UNDEFINED";
        }
    }
}
